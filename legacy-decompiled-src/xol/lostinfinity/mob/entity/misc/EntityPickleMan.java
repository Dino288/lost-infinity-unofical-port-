/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityAgeable
 *  net.minecraft.entity.PathfinderMob
 *  net.minecraft.entity.Mob
 *  net.minecraft.entity.LivingEntity
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
 *  net.minecraft.network.datasync.DataParameter
 *  net.minecraft.network.datasync.DataSerializer
 *  net.minecraft.network.datasync.DataSerializers
 *  net.minecraft.network.datasync.EntityDataManager
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.EnumParticleTypes
 *  net.minecraft.util.SoundSource
 *  net.minecraft.util.SoundEvent
 *  net.minecraft.world.EnumDifficulty
 *  net.minecraft.world.World
 *  net.minecraft.world.ServerLevel
 */
package xol.lostinfinity.mob.entity.misc;

import net.minecraft.world.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
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
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializer;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.sounds.SoundSource;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.Difficulty;
import net.minecraft.world.level.Level;
import net.minecraft.server.level.ServerLevel;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.mob.entity.base.EntityMultiLivesTameable;
import xol.lostinfinity.util.data.IMaxAttack;

public class EntityPickleMan
extends EntityMultiLivesTameable
implements IMaxAttack {
    private static final DataParameter<Float> SCALE = EntityDataManager.func_187226_a(EntityPickleMan.class, (DataSerializer)DataSerializers.field_187193_c);
    private int myLives = 5;
    private float currentStepScale = 1.0f;
    private float addedTrueDamage = 0.0f;

    public EntityPickleMan(Level worldIn) {
        super(worldIn);
        this.func_70105_a(1.2f, 2.5f);
    }

    @Override
    protected void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af.func_187214_a(SCALE, (Object)Float.valueOf(1.0f));
    }

    public float getMyScale() {
        return ((Float)this.field_70180_af.func_187225_a(SCALE)).floatValue();
    }

    public void setMyScale(float f) {
        if (f > this.getMyScale()) {
            this.field_70180_af.func_187227_b(SCALE, (Object)Float.valueOf(f));
        }
    }

    public float getMyStepScale() {
        return this.currentStepScale;
    }

    public void addExtraLives(int lifeSet) {
        this.myLives += lifeSet;
    }

    public void addTrueDamageToAttacks(float damage) {
        this.addedTrueDamage += damage;
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
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.45);
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(2500.0);
    }

    public boolean func_70652_k(Entity entity) {
        super.func_70652_k(entity);
        if (this.func_70638_az() != null) {
            if (this.addedTrueDamage > 0.0f) {
                IMaxAttack.dealTrueDamage((Entity)this, this.func_70638_az(), this.func_70638_az().func_110138_aP() * this.addedTrueDamage);
            }
            if (this.func_70638_az().func_110143_aJ() > 0.0f && this.func_70638_az() != null) {
                IMaxAttack.dealMaxHealth((Entity)this, this.func_70638_az(), 2);
            }
            ((ServerLevel)this.field_70170_p).func_175739_a(EnumParticleTypes.SWEEP_ATTACK, this.field_70165_t, this.field_70163_u + 1.5, this.field_70161_v, 2, -0.5 + this.field_70146_Z.nextDouble(), 0.3 * (-0.5 + this.field_70146_Z.nextDouble()), -0.5 + this.field_70146_Z.nextDouble(), (double)0.15f, new int[0]);
            this.field_70170_p.func_184133_a(null, this.func_180425_c(), SoundInit.GENERIC_WHACK, SoundSource.HOSTILE, 1.0f, 0.7f + 0.6f * this.field_70146_Z.nextFloat());
        }
        return false;
    }

    public void func_70636_d() {
        super.func_70636_d();
        this.field_70143_R = -1.0f;
        if (this.field_70173_aa > 20 && this.currentStepScale < this.getMyScale()) {
            this.currentStepScale += 0.1f;
            this.func_70105_a(1.2f * this.currentStepScale, 2.5f * this.currentStepScale);
        }
        if (!this.field_70170_p.field_72995_K) {
            if (this.field_70170_p.func_175659_aa() == EnumDifficulty.PEACEFUL) {
                this.func_70106_y();
            }
            if (this.field_70173_aa % 30 == 0) {
                float lowest = 100000.0f;
                for (LivingEntity li : this.field_70170_p.func_72872_a(LivingEntity.class, this.func_174813_aQ().func_72314_b(12.0, 12.0, 12.0))) {
                    float newdist;
                    if (li.func_110124_au().equals(this.func_184753_b()) || li instanceof EntityPickleMan || !((newdist = this.func_70032_d((Entity)li)) < lowest)) continue;
                    this.func_70624_b(li);
                    lowest = newdist;
                }
            }
        }
    }

    protected SoundEvent func_184615_bR() {
        return SoundEvents.field_187943_hq;
    }

    protected SoundEvent func_184601_bQ(DamageSource damageSourceIn) {
        return SoundEvents.field_187944_hr;
    }

    protected SoundEvent func_184639_G() {
        return null;
    }

    protected boolean func_70692_ba() {
        return this.func_70902_q() == null;
    }

    @Override
    public boolean func_70601_bi() {
        return this.field_70170_p.func_175659_aa() != EnumDifficulty.PEACEFUL;
    }

    @Override
    public EntityAgeable func_90011_a(EntityAgeable ageable) {
        return null;
    }

    @Override
    protected int numberOfLives() {
        return this.myLives;
    }
}

