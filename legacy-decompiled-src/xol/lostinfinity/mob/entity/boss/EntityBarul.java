/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.entity.player.Player
 *  net.minecraft.entity.player.ServerPlayer
 *  net.minecraft.entity.projectile.EntityArrow
 *  net.minecraft.entity.projectile.EntityFireball
 *  net.minecraft.entity.projectile.EntityThrowable
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.server.SPacketEntityVelocity
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

import java.util.Iterator;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntityFireball;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.SPacketEntityVelocity;
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
import xol.lostinfinity.projectile.entity.EntityBarulChain;
import xol.lostinfinity.stone.EntityInfinityStone;
import xol.lostinfinity.util.data.CustomDamageResult;
import xol.lostinfinity.util.data.IMaxAttack;

public class EntityBarul
extends EntityMultipleLives
implements IMaxAttack {
    private boolean amAttackingNext = false;
    private BlockPos goalPos = null;
    private EntityBarulChain chain = null;
    private boolean hasPulled = false;
    private boolean hasMessaged = false;

    public EntityBarul(Level worldIn) {
        super(worldIn);
        this.func_70105_a(3.5f, 8.0f);
    }

    public void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(5.0);
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.5);
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(5000.0);
        this.func_110148_a(SharedMonsterAttributes.field_111265_b).func_111128_a(30.0);
    }

    public boolean func_70652_k(Entity entity) {
        super.func_70652_k(entity);
        if (this.func_70638_az() != null) {
            if (this.field_70170_p.field_73012_v.nextInt(5) == 0 && !this.field_70170_p.field_72995_K) {
                IMaxAttack.dealMaxHealth((Entity)this, this.func_70638_az(), 3);
                entity.func_70024_g(0.0, 2.0, 0.0);
                entity.field_70133_I = true;
                this.messagePlayers("Barul: UPPERCUT!");
            } else {
                boolean stillAlive;
                CustomDamageResult result = IMaxAttack.dealMaxHealth((Entity)this, this.func_70638_az(), 3);
                boolean bl = stillAlive = !result.wasTargetKilled();
                if (stillAlive && result.didSuccessfulHit()) {
                    int debuff = this.field_70146_Z.nextInt(5);
                    switch (debuff) {
                        case 0: {
                            this.func_70638_az().func_70690_d(new PotionEffect(PotionInit.VULNERABILITY, 100));
                            break;
                        }
                        case 1: {
                            this.func_70638_az().func_70690_d(new PotionEffect(PotionInit.BLIGHTED, 100));
                            break;
                        }
                        case 2: {
                            this.func_70638_az().func_70690_d(new PotionEffect(PotionInit.INTANGIBLE, 100));
                            break;
                        }
                        case 3: {
                            this.func_70638_az().func_70690_d(new PotionEffect(PotionInit.NULLIFIED, 100));
                            break;
                        }
                        case 4: {
                            this.func_70638_az().func_70690_d(new PotionEffect(PotionInit.ULTRAHEAVY, 100));
                        }
                    }
                }
                return true;
            }
        }
        return false;
    }

    private AABB getArenaAABB() {
        return new AABB(new BlockPos(-3.0, 60.0, -149.0), new BlockPos(52.0, 85.0, -36.0));
    }

    public void func_70636_d() {
        super.func_70636_d();
        this.field_70143_R = -1.0f;
        if (!this.field_70170_p.field_72995_K) {
            Player target;
            for (Entity proj : this.field_70170_p.func_72872_a(Entity.class, this.func_174813_aQ().func_72314_b(10.0, 10.0, 10.0))) {
                if (!(proj instanceof EntityThrowable) && !(proj instanceof EntityArrow) && !(proj instanceof EntityFireball)) continue;
                proj.func_70106_y();
                proj.func_184185_a(SoundInit.ITEM_AXIOMAVORUM, 1.0f, 0.5f + this.field_70146_Z.nextFloat());
                ((ServerLevel)this.field_70170_p).func_175739_a(EnumParticleTypes.SWEEP_ATTACK, proj.field_70165_t, proj.field_70163_u, proj.field_70161_v, 2, (-0.5 + this.field_70146_Z.nextDouble()) * 3.0, 0.3, (-0.5 + this.field_70146_Z.nextDouble()) * 3.0, (double)0.15f, new int[0]);
            }
            if (this.chain != null && !this.hasPulled && this.chain.getGrowth() >= 1.0f) {
                if (!this.hasMessaged) {
                    this.messagePlayers("Barul: GET OVER HERE!");
                    this.hasMessaged = true;
                }
                if ((target = this.chain.getTarget()) != null && this.chain.getStopPos() == null) {
                    double dist = target.func_174791_d().func_72438_d(this.chain.func_174791_d());
                    if (dist < 4.0) {
                        this.hasPulled = true;
                        this.hasMessaged = false;
                        this.chain.func_70106_y();
                        this.chain = null;
                        IMaxAttack.dealMaxHealth((Entity)this, (LivingEntity)target, 3);
                        return;
                    }
                    Vec3 pullDir = this.chain.func_174791_d().func_178788_d(target.func_174791_d());
                    pullDir = pullDir.func_72432_b();
                    if (dist < 10.0) {
                        target.func_70024_g(pullDir.field_72450_a / 10.0, pullDir.field_72448_b / 10.0 + (double)0.01f, pullDir.field_72449_c / 10.0);
                    } else {
                        target.func_70024_g(pullDir.field_72450_a / 3.0, pullDir.field_72448_b / 3.0 + (double)0.1f, pullDir.field_72449_c / 3.0);
                    }
                    ((ServerPlayer)target).field_71135_a.func_147359_a((Packet)new SPacketEntityVelocity((Entity)target));
                }
            }
            if (this.field_70173_aa % 150 == 70) {
                this.hasPulled = false;
                if (this.chain != null) {
                    this.chain.func_70106_y();
                    this.chain = null;
                }
                target = null;
                Iterator iterator = this.field_70170_p.func_72872_a(Player.class, this.getArenaAABB()).iterator();
                if (iterator.hasNext()) {
                    Player near_pl;
                    target = near_pl = (Player)iterator.next();
                }
                if (target != null) {
                    this.chain = new EntityBarulChain(this.field_70170_p);
                    this.chain.setTarget(target);
                    this.chain.setOwner(this);
                    this.chain.func_70107_b(this.field_70165_t, this.field_70163_u + (double)(this.field_70131_O / 2.0f), this.field_70161_v);
                    this.field_70170_p.func_72838_d((Entity)this.chain);
                }
            }
        }
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
        return 200;
    }

    @Override
    protected void updateLifeAction() {
        int lifePercent = Math.round(100 * (this.numberOfLives() - this.getLivesCount()) / this.numberOfLives());
        this.messagePlayers((Object)((Object)TextFmt.Gold) + "Barul is at " + lifePercent + "% health.");
    }

    @Override
    public void trueDeathAction() {
        if (!this.field_70170_p.field_72995_K) {
            if (this.chain != null) {
                this.chain.func_70106_y();
                this.chain = null;
            }
            EntityInfinityStone stone = new EntityInfinityStone(this.field_70170_p);
            stone.setStoneNum((byte)14);
            stone.func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
            this.field_70170_p.func_72838_d((Entity)stone);
            this.func_145779_a(ItemInit.arenaCard, 1);
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

    protected boolean func_70692_ba() {
        return false;
    }
}

