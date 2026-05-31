/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityAgeable
 *  net.minecraft.entity.PathfinderMob
 *  net.minecraft.entity.Mob
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.IEntityOwnable
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.entity.ai.EntityAIAttackMelee
 *  net.minecraft.entity.ai.EntityAIBase
 *  net.minecraft.entity.ai.EntityAIHurtByTarget
 *  net.minecraft.entity.ai.EntityAILeapAtTarget
 *  net.minecraft.entity.ai.EntityAILookIdle
 *  net.minecraft.entity.ai.EntityAIOwnerHurtByTarget
 *  net.minecraft.entity.ai.EntityAIOwnerHurtTarget
 *  net.minecraft.entity.ai.EntityAISwimming
 *  net.minecraft.entity.ai.EntityAIWanderAvoidWater
 *  net.minecraft.entity.ai.EntityAIWatchClosest
 *  net.minecraft.entity.passive.EntityTameable
 *  net.minecraft.entity.player.Player
 *  net.minecraft.init.SoundEvents
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.SoundEvent
 *  net.minecraft.world.EnumDifficulty
 *  net.minecraft.world.World
 */
package xol.lostinfinity.mob.entity.misc;

import net.minecraft.world.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.entity.IEntityOwnable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILeapAtTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIOwnerHurtByTarget;
import net.minecraft.entity.ai.EntityAIOwnerHurtTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWanderAvoidWater;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.world.entity.player.Player;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.Difficulty;
import net.minecraft.world.level.Level;
import xol.lostinfinity.init.ParticleInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.mob.entity.minion.EntityMinion;
import xol.lostinfinity.util.data.CustomParticleConfig;
import xol.lostinfinity.util.data.IMaxAttack;
import xol.lostinfinity.util.fx.IParticleSpawner;

public class EntityTNTZombie
extends EntityTameable
implements IMaxAttack {
    private boolean exploded = false;
    private float damageMulti = 1.0f;

    public EntityTNTZombie(Level worldIn) {
        super(worldIn);
        this.func_70105_a(1.0f, 1.95f);
    }

    public void changeDamage(float multi) {
        this.damageMulti = multi;
    }

    protected void func_184651_r() {
        this.field_70714_bg.func_75776_a(1, (EntityAIBase)new EntityAISwimming((Mob)this));
        this.field_70714_bg.func_75776_a(3, (EntityAIBase)new EntityAILeapAtTarget((Mob)this, 0.4f));
        this.field_70714_bg.func_75776_a(4, (EntityAIBase)new EntityAIAttackMelee((PathfinderMob)this, 1.0, true));
        this.field_70714_bg.func_75776_a(7, (EntityAIBase)new EntityAIWanderAvoidWater((PathfinderMob)this, 1.0));
        this.field_70714_bg.func_75776_a(9, (EntityAIBase)new EntityAIWatchClosest((Mob)this, Player.class, 8.0f));
        this.field_70714_bg.func_75776_a(9, (EntityAIBase)new EntityAILookIdle((Mob)this));
        this.field_70715_bh.func_75776_a(1, (EntityAIBase)new EntityAIOwnerHurtByTarget((EntityTameable)this));
        this.field_70715_bh.func_75776_a(2, (EntityAIBase)new EntityAIOwnerHurtTarget((EntityTameable)this));
        this.field_70715_bh.func_75776_a(3, (EntityAIBase)new EntityAIHurtByTarget((PathfinderMob)this, true, new Class[0]));
    }

    public void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.35);
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(750.0);
    }

    public boolean func_70652_k(Entity entity) {
        super.func_70652_k(entity);
        if (this.func_70638_az() != null && this.field_70173_aa >= 60) {
            this.explode();
        } else {
            IMaxAttack.dealMaxHealth((Entity)this, this.func_70638_az(), 5);
        }
        return false;
    }

    private void explode() {
        if (this.func_70902_q() != null && !this.exploded) {
            this.exploded = true;
            for (LivingEntity target : this.field_70170_p.func_72872_a(LivingEntity.class, this.func_174813_aQ().func_72314_b(5.0, 5.0, 5.0))) {
                if (target.func_110124_au().equals(this.func_184753_b()) || target.func_110124_au().equals(this.func_110124_au()) || target instanceof IEntityOwnable && ((IEntityOwnable)target).func_184753_b() == this.func_70902_q().func_110124_au() || target instanceof EntityMinion && ((EntityMinion)target).getOwner() == this.func_70902_q()) continue;
                IMaxAttack.dealMaxHealth((Entity)this, target, 1, this.damageMulti);
            }
            CustomParticleConfig config1 = new CustomParticleConfig();
            config1.createInstance().setParticle(ParticleInit.EXPLOSION_RING).setSpread(2.0, 1.0, 2.0).setCount(3).setIgnoreRange(true);
            IParticleSpawner.spawnParticle(this.field_70170_p, config1, this.field_70165_t, this.field_70163_u, this.field_70161_v);
            this.func_184185_a(SoundInit.GENERIC_WEAPON_6, 1.0f, 0.8f + 0.4f * this.field_70146_Z.nextFloat());
            this.func_70106_y();
        }
    }

    public void func_70636_d() {
        super.func_70636_d();
        this.field_70143_R = -1.0f;
        this.removeOwnerTamedTargets();
        if (!this.field_70170_p.field_72995_K) {
            if (this.field_70170_p.func_175659_aa() == EnumDifficulty.PEACEFUL) {
                this.func_70106_y();
            }
            if (this.field_70173_aa == 300) {
                this.explode();
            }
            if (this.field_70173_aa % 30 == 0 && this.func_70902_q() != null) {
                float lowest = 100000.0f;
                for (LivingEntity li : this.field_70170_p.func_72872_a(LivingEntity.class, this.func_174813_aQ().func_72314_b(12.0, 12.0, 12.0))) {
                    float newdist;
                    if (li.func_110124_au().equals(this.func_184753_b()) || li instanceof EntityTNTZombie || li instanceof IEntityOwnable && ((IEntityOwnable)li).func_184753_b() == this.func_70902_q().func_110124_au() || li instanceof EntityMinion && ((EntityMinion)li).getOwner() == this.func_70902_q() || !((newdist = this.func_70032_d((Entity)li)) < lowest)) continue;
                    this.func_70624_b(li);
                    lowest = newdist;
                }
            }
        }
    }

    private void removeOwnerTamedTargets() {
        if (this.func_70902_q() == null) {
            return;
        }
        if (this.func_70638_az() == null) {
            return;
        }
        LivingEntity atkTarget = this.func_70638_az();
        if (atkTarget instanceof IEntityOwnable && ((IEntityOwnable)atkTarget).func_184753_b() == this.func_70902_q().func_110124_au()) {
            this.func_70624_b(null);
        }
        if (atkTarget instanceof EntityMinion && ((EntityMinion)atkTarget).getOwner() == this.func_70902_q()) {
            this.func_70624_b(null);
        }
        if (this.func_70643_av() == null) {
            return;
        }
        LivingEntity rvngTarget = this.func_70643_av();
        if (rvngTarget instanceof IEntityOwnable && ((IEntityOwnable)rvngTarget).func_184753_b() == this.func_70902_q().func_110124_au()) {
            this.func_70604_c(null);
        }
        if (rvngTarget instanceof EntityMinion && ((EntityMinion)rvngTarget).getOwner() == this.func_70902_q()) {
            this.func_70604_c(null);
        }
    }

    public void func_70645_a(DamageSource cause) {
        if (!this.field_70170_p.field_72995_K) {
            this.explode();
        }
    }

    protected SoundEvent func_184615_bR() {
        return SoundEvents.field_187930_hd;
    }

    protected SoundEvent func_184601_bQ(DamageSource damageSourceIn) {
        return SoundEvents.field_187934_hh;
    }

    protected SoundEvent func_184639_G() {
        return null;
    }

    protected boolean func_70692_ba() {
        return this.func_70902_q() == null;
    }

    public boolean func_70601_bi() {
        return this.field_70170_p.func_175659_aa() != EnumDifficulty.PEACEFUL;
    }

    public EntityAgeable func_90011_a(EntityAgeable ageable) {
        return null;
    }
}

