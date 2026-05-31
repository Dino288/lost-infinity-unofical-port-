/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.Mob
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.entity.ai.EntityAIBase
 *  net.minecraft.entity.ai.EntityAIWatchClosest
 *  net.minecraft.entity.player.Player
 *  net.minecraft.entity.projectile.EntityArrow
 *  net.minecraft.entity.projectile.EntityFireball
 *  net.minecraft.entity.projectile.EntityThrowable
 *  net.minecraft.init.SoundEvents
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.EnumParticleTypes
 *  net.minecraft.util.ResourceLocation
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

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.world.entity.player.Player;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntityFireball;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.resources.ResourceLocation;
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
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.mob.entity.base.EntityMultipleLives;
import xol.lostinfinity.mob.entity.boss.EntityWitherSkullling;
import xol.lostinfinity.projectile.entity.EntityWitherBomb;
import xol.lostinfinity.util.data.IMaxAttack;
import xol.lostinfinity.util.load.LootTableRegistry;

public class EntityDeviantWither
extends EntityMultipleLives
implements IMaxAttack {
    private BlockPos move_towards = null;

    public EntityDeviantWither(Level worldIn) {
        super(worldIn);
        this.func_70105_a(5.0f, 7.5f);
        this.func_189654_d(true);
    }

    @Override
    protected void func_184651_r() {
        this.field_70714_bg.func_75776_a(8, (EntityAIBase)new EntityAIWatchClosest((Mob)this, Player.class, 8.0f));
    }

    public void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(15000.0);
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(3.0);
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.3);
        this.func_110148_a(SharedMonsterAttributes.field_111266_c).func_111128_a(1.0);
    }

    public void func_70636_d() {
        super.func_70636_d();
        this.field_70143_R = -1.0f;
        if (this.move_towards != null && this.func_70011_f(this.move_towards.func_177958_n(), this.move_towards.func_177956_o(), this.move_towards.func_177952_p()) > 1.0 && this.field_70159_w > (double)-0.7f && this.field_70159_w < (double)0.7f && this.field_70179_y > (double)-0.7f && this.field_70179_y < (double)0.7f) {
            this.func_70024_g(((double)this.move_towards.func_177958_n() - this.field_70165_t) * 0.03, ((double)this.move_towards.func_177956_o() - this.field_70163_u) * 0.02, ((double)this.move_towards.func_177952_p() - this.field_70161_v) * 0.03);
            this.field_70133_I = true;
        }
        this.field_70177_z += 2.0f;
        if (!this.field_70170_p.field_72995_K) {
            int remainder;
            if (this.field_70173_aa % 3 == 0) {
                this.scanArenaProjectiles();
            }
            if ((remainder = this.field_70173_aa % this.getTickOffset()) % 50 == 0) {
                this.findNewMove();
            }
            if (remainder == 30) {
                this.releaseWitherlings();
            }
            if (remainder >= 75 && remainder <= 100) {
                if (remainder % 5 == 0) {
                    this.fireAttack(2.0f);
                }
            } else if (remainder == 50) {
                this.func_184185_a(SoundInit.DEVIANT_WITHER_ROAR, 1.0f, 0.7f + 0.6f * this.field_70146_Z.nextFloat());
                this.messagePlayers(TextFmt.getFormatting(TextFmt.Italic, TextFmt.Red) + "ROAAAAAAR", SoundInit.DEVIANT_WITHER_ROAR);
            } else if (remainder % 40 == 0) {
                this.fireAttack(1.0f);
            }
        }
    }

    private void scanArenaProjectiles() {
        for (Entity proj : this.field_70170_p.func_72872_a(Entity.class, this.getArenaAABB())) {
            if (!(proj instanceof EntityThrowable) && !(proj instanceof EntityArrow) && !(proj instanceof EntityFireball) || proj instanceof EntityWitherBomb) continue;
            this.field_70170_p.func_72876_a(null, proj.field_70165_t, proj.field_70163_u, proj.field_70161_v, 2.0f, false);
            for (Player target : this.field_70170_p.func_72872_a(Player.class, this.func_174813_aQ().func_72314_b(10.0, 10.0, 10.0))) {
                IMaxAttack.dealMaxHealth((Entity)this, (LivingEntity)target, 4);
            }
            proj.func_70106_y();
            ((ServerLevel)this.field_70170_p).func_175739_a(EnumParticleTypes.SWEEP_ATTACK, proj.field_70165_t, proj.field_70163_u, proj.field_70161_v, 2, (-0.5 + this.field_70146_Z.nextDouble()) * 3.0, 0.3, (-0.5 + this.field_70146_Z.nextDouble()) * 3.0, (double)0.15f, new int[0]);
        }
    }

    private void findNewMove() {
        AABB aabb = this.getArenaAABB();
        int length = (int)Math.round(aabb.field_72336_d - aabb.field_72340_a) - 6;
        int width = (int)Math.round(aabb.field_72334_f - aabb.field_72339_c) - 6;
        this.move_towards = new BlockPos(aabb.field_72340_a + 3.0 + (double)this.field_70146_Z.nextInt(length), aabb.field_72338_b + (double)this.field_70146_Z.nextInt(EntityDeviantWither.getMaxFly()), aabb.field_72339_c + 3.0 + (double)this.field_70146_Z.nextInt(width));
    }

    private void releaseWitherlings() {
        int skullnum = 0;
        for (EntityWitherSkullling skulling : this.field_70170_p.func_72872_a(EntityWitherSkullling.class, this.getArenaAABB())) {
            ++skullnum;
        }
        if (skullnum < 8) {
            int count = 1 + this.field_70146_Z.nextInt(2);
            for (int i = 0; i < count; ++i) {
                EntityWitherSkullling skull = new EntityWitherSkullling(this.field_70170_p);
                skull.func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
                this.field_70170_p.func_72838_d((Entity)skull);
            }
        }
    }

    private void fireAttack(float velo) {
        boolean did_shot = false;
        for (Player near_pl : this.field_70170_p.func_72872_a(Player.class, this.getArenaAABB())) {
            if (near_pl.func_184812_l_() || this.field_70170_p.field_72995_K) continue;
            Vec3 vec3d = this.func_70676_i(1.0f);
            double makeX = (this.func_174813_aQ().field_72340_a + this.func_174813_aQ().field_72336_d) / 2.0;
            double makeY = this.field_70163_u + (double)(this.field_70131_O / 2.0f) + 0.5;
            double makeZ = (this.func_174813_aQ().field_72339_c + this.func_174813_aQ().field_72334_f) / 2.0;
            double d2 = near_pl.field_70165_t - makeX;
            double d3 = near_pl.func_174813_aQ().field_72338_b + (double)(near_pl.field_70131_O / 2.0f) - makeY;
            double d4 = near_pl.field_70161_v - makeZ;
            EntityWitherBomb shot = new EntityWitherBomb(this.field_70170_p);
            shot.field_70165_t = makeX;
            shot.field_70163_u = makeY;
            shot.field_70161_v = makeZ;
            shot.func_70186_c(d2, d3, d4, velo, 0.0f);
            shot.setThrower((LivingEntity)this);
            this.field_70170_p.func_72838_d((Entity)shot);
            did_shot = true;
        }
        if (did_shot) {
            this.func_184185_a(SoundEvents.field_187606_E, 2.0f, 0.5f + this.field_70146_Z.nextFloat());
        }
    }

    private AABB getArenaAABB() {
        return new AABB(new BlockPos(958.0, 60.0, 877.0), new BlockPos(1012.0, 82.0, 924.0));
    }

    @Override
    protected void updateLifeAction() {
        int lifePercent = Math.round(100 * (this.numberOfLives() - this.getLivesCount()) / this.numberOfLives());
        this.messagePlayers((Object)((Object)TextFmt.Gold) + "The Deviant Wither is at " + lifePercent + "% health.", null);
    }

    private static int getMaxFly() {
        return 15;
    }

    @Override
    protected int numberOfLives() {
        return 40;
    }

    private int getTickOffset() {
        if (this.getLivesCount() < 15) {
            return 300;
        }
        if (this.getLivesCount() < 30) {
            return 200;
        }
        return 100;
    }

    protected void messagePlayers(String message, SoundEvent sound) {
        for (Player contender : this.field_70170_p.func_72872_a(Player.class, this.getArenaAABB())) {
            contender.func_145747_a((Component)new Component(message));
            if (sound == null) continue;
            this.field_70170_p.func_184133_a(null, contender.func_180425_c(), sound, SoundSource.MASTER, 1.5f, 1.0f);
        }
    }

    protected SoundEvent func_184615_bR() {
        return SoundEvents.field_187849_gA;
    }

    protected SoundEvent func_184601_bQ(DamageSource damageSourceIn) {
        return SoundEvents.field_187851_gB;
    }

    protected SoundEvent func_184639_G() {
        return null;
    }

    protected ResourceLocation func_184647_J() {
        return this.onFinalLife() ? LootTableRegistry.ENTITIES_DEVIANT_WITHER : null;
    }
}

