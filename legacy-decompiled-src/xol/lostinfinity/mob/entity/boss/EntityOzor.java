/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.entity.player.Player
 *  net.minecraft.network.datasync.DataParameter
 *  net.minecraft.network.datasync.DataSerializer
 *  net.minecraft.network.datasync.DataSerializers
 *  net.minecraft.network.datasync.EntityDataManager
 *  net.minecraft.potion.PotionEffect
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.EnumParticleTypes
 *  net.minecraft.util.SoundSource
 *  net.minecraft.util.SoundEvent
 *  net.minecraft.util.math.AABB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Vec3
 *  net.minecraft.util.text.Component
 *  net.minecraft.util.text.Component
 *  net.minecraft.world.World
 *  net.minecraft.world.ServerLevel
 */
package xol.lostinfinity.mob.entity.boss;

import java.util.ArrayList;
import java.util.Iterator;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializer;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.sounds.SoundSource;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.phys.AABB;
import net.minecraft.core.BlockPos;
import net.minecraft.world.phys.Vec3;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.Level;
import net.minecraft.server.level.ServerLevel;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.init.PotionInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.mob.entity.base.EntityMultipleLives;
import xol.lostinfinity.mob.entity.boss.EntityOzorDecoy;
import xol.lostinfinity.projectile.entity.EntityLaserBlast;
import xol.lostinfinity.stone.EntityInfinityStone;
import xol.lostinfinity.util.data.IMaxAttack;

public class EntityOzor
extends EntityMultipleLives
implements IMaxAttack {
    private static final DataParameter<Integer> ILLUSION_PHASE = EntityDataManager.func_187226_a(EntityOzor.class, (DataSerializer)DataSerializers.field_187192_b);
    private BlockPos hoverTo = null;
    private int fireMode = 0;
    private int nextFormTimer = 200;
    private int illusionCooldown = 300;
    private float ozorAlpha = 1.0f;

    public EntityOzor(Level worldIn) {
        super(worldIn);
        this.func_70105_a(7.5f, 7.5f);
    }

    @Override
    protected void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af.func_187214_a(ILLUSION_PHASE, (Object)0);
    }

    public int getIllusionPhase() {
        return (Integer)this.field_70180_af.func_187225_a(ILLUSION_PHASE);
    }

    public void setIllusionPhase(int f) {
        this.field_70180_af.func_187227_b(ILLUSION_PHASE, (Object)f);
    }

    public void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(1.0);
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.32);
        this.func_110148_a(SharedMonsterAttributes.field_111266_c).func_111128_a(1.0);
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(15000.0);
    }

    public boolean func_70652_k(Entity entity) {
        super.func_70652_k(entity);
        if (this.func_70638_az() != null) {
            IMaxAttack.dealMaxHealth((Entity)this, this.func_70638_az(), 2);
            return true;
        }
        return false;
    }

    public float getAlpha() {
        return this.ozorAlpha;
    }

    private AABB getArenaAABB() {
        return new AABB(new BlockPos(-3.0, 60.0, -149.0), new BlockPos(52.0, 85.0, -36.0));
    }

    private void fireLaser(int attackType) {
        if (!this.field_70170_p.field_72995_K) {
            Player near_pl;
            boolean fired = false;
            Iterator iterator = this.field_70170_p.func_72872_a(Player.class, this.getArenaAABB()).iterator();
            if (iterator.hasNext() && !(near_pl = (Player)iterator.next()).func_184812_l_()) {
                fired = true;
                Vec3 vec3d = this.func_70676_i(1.0f);
                double makeX = (this.func_174813_aQ().field_72340_a + this.func_174813_aQ().field_72336_d) / 2.0;
                double makeY = this.field_70163_u + (double)(this.field_70131_O / 2.0f) + 0.5;
                double makeZ = (this.func_174813_aQ().field_72339_c + this.func_174813_aQ().field_72334_f) / 2.0;
                double d2 = near_pl.field_70165_t - makeX;
                double d3 = near_pl.func_174813_aQ().field_72338_b + (double)(near_pl.field_70131_O / 2.0f) - makeY;
                double d4 = near_pl.field_70161_v - makeZ;
                EntityLaserBlast shot = new EntityLaserBlast(this.field_70170_p, (LivingEntity)this);
                float speed = 2.0f;
                if (attackType == 1) {
                    speed = 3.0f;
                } else if (attackType == 2) {
                    speed = 2.5f;
                }
                shot.func_70186_c(d2, d3, d4, speed, attackType == 2 ? 8.0f : 0.0f);
                shot.setForm(attackType);
                shot.setThrower((LivingEntity)this);
                this.field_70170_p.func_72838_d((Entity)shot);
                ((ServerLevel)this.field_70170_p).func_175739_a(EnumParticleTypes.LAVA, shot.field_70165_t, shot.field_70163_u, shot.field_70161_v, 2, this.field_70146_Z.nextDouble() * 3.0, 0.3, this.field_70146_Z.nextDouble() * 3.0, (double)0.15f, new int[0]);
            }
            if (fired) {
                SoundEvent wepSound = SoundInit.LASER_WEAPON_5;
                if (attackType == 1) {
                    wepSound = SoundInit.LASER_WEAPON_4;
                } else if (attackType == 2) {
                    wepSound = SoundInit.LASER_WEAPON_3;
                }
                this.soundPlayers(wepSound, attackType == 2 ? 0.25f : 0.75f);
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public void func_70636_d() {
        super.func_70636_d();
        this.field_70143_R = -1.0f;
        if (!this.field_70170_p.field_72995_K) {
            int phase = this.getIllusionPhase();
            if (phase == 0) {
                if (this.hoverTo != null) {
                    if (this.func_70011_f(this.hoverTo.func_177958_n(), this.hoverTo.func_177956_o(), this.hoverTo.func_177952_p()) > 1.0 && this.field_70159_w > (double)-0.7f && this.field_70159_w < (double)0.7f && this.field_70179_y > (double)-0.7f && this.field_70179_y < (double)0.7f) {
                        this.func_70024_g(((double)this.hoverTo.func_177958_n() - this.field_70165_t) * 0.03, ((double)this.hoverTo.func_177956_o() - this.field_70163_u) * 0.02, ((double)this.hoverTo.func_177952_p() - this.field_70161_v) * 0.03);
                        this.field_70133_I = true;
                    }
                } else {
                    this.findNewMove();
                }
                if (this.field_70173_aa % 70 == 0) {
                    this.findNewMove();
                }
                --this.nextFormTimer;
                switch (this.fireMode) {
                    case 0: {
                        if (this.field_70173_aa % 30 == 0) {
                            this.fireLaser(0);
                        }
                        if (this.nextFormTimer == 0) {
                            this.fireMode = 1;
                            this.nextFormTimer = 300;
                            break;
                        }
                        if (this.nextFormTimer != 20) break;
                        this.messagePlayers((Object)((Object)TextFmt.Red) + "Ozor: High Powdered Lasers!");
                        this.soundPlayers(SoundInit.OZOR_MESSAGE, 1.0f);
                        break;
                    }
                    case 1: {
                        if (this.field_70173_aa % 50 == 0) {
                            this.fireLaser(1);
                        }
                        if (this.nextFormTimer == 0) {
                            this.fireMode = 2;
                            this.nextFormTimer = 120;
                            break;
                        }
                        if (this.nextFormTimer != 20) break;
                        this.messagePlayers((Object)((Object)TextFmt.Red) + "Ozor: Rapid Fire!");
                        this.soundPlayers(SoundInit.OZOR_MESSAGE, 1.0f);
                        break;
                    }
                    case 2: {
                        if (this.field_70173_aa % 2 == 0) {
                            this.fireLaser(2);
                        }
                        if (this.nextFormTimer == 0) {
                            this.fireMode = 0;
                            this.nextFormTimer = 200;
                            break;
                        }
                        if (this.nextFormTimer != 20) break;
                        this.messagePlayers((Object)((Object)TextFmt.Red) + "Ozor: Standard Fire!");
                        this.soundPlayers(SoundInit.OZOR_MESSAGE, 1.0f);
                        break;
                    }
                }
                --this.illusionCooldown;
                if (this.illusionCooldown != 0) return;
                this.setIllusionPhase(1);
                this.illusionCooldown = 100;
                this.messagePlayers((Object)((Object)TextFmt.Aqua) + "Ozor: Embrace Illusion...");
                this.soundPlayers(SoundInit.OZOR_VANISH, 1.5f);
                this.field_70714_bg.field_75782_a.clear();
                this.field_70715_bh.field_75782_a.clear();
                return;
            }
            if (phase == 1) {
                --this.illusionCooldown;
                if (this.illusionCooldown == 0) {
                    this.setIllusionPhase(2);
                    this.performIllusion();
                }
                this.func_70690_d(new PotionEffect(PotionInit.PROTECTED, 10));
                return;
            }
            if (phase != 2) return;
            return;
        }
        int phase = this.getIllusionPhase();
        if (phase == 0) {
            this.ozorAlpha = 1.0f;
            return;
        }
        if (phase == 1) {
            if (!(this.ozorAlpha > 0.0f)) return;
            this.ozorAlpha -= 0.025f;
            return;
        }
        this.ozorAlpha += 0.025f;
    }

    private void findNewMove() {
        AABB aabb = this.getArenaAABB();
        int length = (int)Math.round(aabb.field_72336_d - aabb.field_72340_a) - 6;
        int width = (int)Math.round(aabb.field_72334_f - aabb.field_72339_c) - 6;
        this.hoverTo = new BlockPos(aabb.field_72340_a + 3.0 + (double)this.field_70146_Z.nextInt(length), aabb.field_72338_b + (double)this.field_70146_Z.nextInt(EntityOzor.getMaxFly()), aabb.field_72339_c + 3.0 + (double)this.field_70146_Z.nextInt(width));
    }

    private static int getMaxFly() {
        return 10;
    }

    private void clearDecoys() {
        for (EntityOzorDecoy decoy : this.field_70170_p.func_72872_a(EntityOzorDecoy.class, this.getArenaAABB())) {
            decoy.setFading(true);
        }
    }

    private void performIllusion() {
        this.func_184589_d(PotionInit.PROTECTED);
        ArrayList<BlockPos> locations = new ArrayList<BlockPos>();
        AABB aabb = this.getArenaAABB();
        int length = (int)Math.round(aabb.field_72336_d - aabb.field_72340_a) - 16;
        int width = (int)Math.round(aabb.field_72334_f - aabb.field_72339_c) - 16;
        for (int i = 0; i < 12; ++i) {
            locations.add(new BlockPos(aabb.field_72340_a + 8.0 + (double)this.field_70146_Z.nextInt(length), aabb.field_72338_b + 2.0, aabb.field_72339_c + 8.0 + (double)this.field_70146_Z.nextInt(width)));
        }
        BlockPos first = (BlockPos)locations.get(0);
        this.func_70634_a(first.func_177958_n(), first.func_177956_o(), first.func_177952_p());
        for (int i = 1; i < 12; ++i) {
            BlockPos current = (BlockPos)locations.get(i);
            EntityOzorDecoy decoy = new EntityOzorDecoy(this.field_70170_p);
            decoy.func_70107_b(current.func_177958_n(), current.func_177956_o(), current.func_177952_p());
            this.field_70170_p.func_72838_d((Entity)decoy);
        }
        this.soundPlayers(SoundInit.OZOR_REAPPEAR, 1.0f);
    }

    protected SoundEvent func_184615_bR() {
        return SoundInit.GENERIC_STYLE3_DEATH;
    }

    protected SoundEvent func_184601_bQ(DamageSource damageSourceIn) {
        return SoundInit.GENERIC_STYLE3_HURT;
    }

    protected SoundEvent func_184639_G() {
        return null;
    }

    @Override
    protected int numberOfLives() {
        return 150;
    }

    @Override
    protected void updateLifeAction() {
        int lifePercent = Math.round(100 * (this.numberOfLives() - this.getLivesCount()) / this.numberOfLives());
        this.messagePlayers((Object)((Object)TextFmt.Gold) + "Ozor is at " + lifePercent + "% health.");
        if (this.getIllusionPhase() == 2) {
            this.setIllusionPhase(0);
            this.clearDecoys();
            this.func_184651_r();
            this.illusionCooldown = 500;
        }
    }

    protected void messagePlayers(String message) {
        for (Player contender : this.field_70170_p.func_72872_a(Player.class, this.getArenaAABB())) {
            contender.func_145747_a((Component)new Component(message));
        }
    }

    protected void soundPlayers(SoundEvent sound, float vol) {
        for (Player contender : this.field_70170_p.func_72872_a(Player.class, this.getArenaAABB())) {
            this.field_70170_p.func_184133_a(null, contender.func_180425_c(), sound, SoundSource.MASTER, vol, 0.9f + this.field_70146_Z.nextFloat() * 0.2f);
        }
    }

    @Override
    public void trueDeathAction() {
        if (!this.field_70170_p.field_72995_K) {
            EntityInfinityStone stone = new EntityInfinityStone(this.field_70170_p);
            stone.setStoneNum((byte)11);
            stone.func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
            this.field_70170_p.func_72838_d((Entity)stone);
            this.func_145779_a(ItemInit.arenaCard, 1);
        }
    }

    protected boolean func_70692_ba() {
        return false;
    }

    @Override
    public boolean func_70814_o() {
        return true;
    }

    public int func_70641_bl() {
        return 1;
    }
}

