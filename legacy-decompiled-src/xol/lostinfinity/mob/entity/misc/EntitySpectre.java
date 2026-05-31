/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.init.SoundEvents
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.network.datasync.DataParameter
 *  net.minecraft.network.datasync.DataSerializer
 *  net.minecraft.network.datasync.DataSerializers
 *  net.minecraft.network.datasync.EntityDataManager
 *  net.minecraft.potion.PotionEffect
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.EnumParticleTypes
 *  net.minecraft.util.SoundEvent
 *  net.minecraft.world.EnumDifficulty
 *  net.minecraft.world.World
 *  net.minecraft.world.ServerLevel
 */
package xol.lostinfinity.mob.entity.misc;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializer;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.Difficulty;
import net.minecraft.world.level.Level;
import net.minecraft.server.level.ServerLevel;
import xol.lostinfinity.init.PotionInit;
import xol.lostinfinity.mob.entity.base.EntityFloatingTameable;
import xol.lostinfinity.util.data.IMaxAttack;

public class EntitySpectre
extends EntityFloatingTameable
implements IMaxAttack {
    private static final DataParameter<Boolean> PRIME = EntityDataManager.func_187226_a(EntitySpectre.class, (DataSerializer)DataSerializers.field_187198_h);

    public EntitySpectre(Level worldIn) {
        super(worldIn);
        this.func_70105_a(1.2f, 1.75f);
        this.rawFlySpeed = 0.85f;
    }

    @Override
    public void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(750.0);
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.25);
        this.func_110148_a(SharedMonsterAttributes.field_111266_c).func_111128_a(1.0);
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(1.0);
    }

    @Override
    protected void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af.func_187214_a(PRIME, (Object)false);
    }

    public boolean isPrime() {
        return (Boolean)this.field_70180_af.func_187225_a(PRIME);
    }

    public void setPrime(boolean p) {
        this.rawFlySpeed = p ? 0.95f : 0.85f;
        this.field_70180_af.func_187227_b(PRIME, (Object)p);
    }

    @Override
    public void func_70014_b(CompoundTag tag) {
        super.func_70014_b(tag);
        tag.func_74757_a("SpectreQual", this.isPrime());
    }

    @Override
    public void func_70037_a(CompoundTag tag) {
        super.func_70037_a(tag);
        this.setPrime(tag.func_74767_n("SpectreQual"));
    }

    public boolean func_70652_k(Entity entity) {
        super.func_70652_k(entity);
        if (this.func_70638_az() != null) {
            if (this.isPrime()) {
                this.func_70638_az().func_70690_d(new PotionEffect(PotionInit.SHATTERED, 200, 0));
                this.func_70638_az().func_70690_d(new PotionEffect(PotionInit.BLIGHTED, 200, 0));
                this.func_70638_az().func_70690_d(new PotionEffect(PotionInit.VULNERABILITY, 200, 0));
                if (this.getOwner() != null) {
                    this.getOwner().func_70691_i(this.getOwner().func_110138_aP() * 0.15f);
                }
            }
            IMaxAttack.dealMaxHealth((Entity)this, this.func_70638_az(), this.isPrime() ? 2 : 4);
            ((ServerLevel)this.field_70170_p).func_175739_a(EnumParticleTypes.SWEEP_ATTACK, this.field_70165_t, this.field_70163_u + 1.0, this.field_70161_v, 2, -0.5 + this.field_70146_Z.nextDouble(), 0.3 * (-0.5 + this.field_70146_Z.nextDouble()), -0.5 + this.field_70146_Z.nextDouble(), (double)0.15f, new int[0]);
            return true;
        }
        return false;
    }

    @Override
    public void func_70636_d() {
        super.func_70636_d();
        this.field_70143_R = -1.0f;
        if (!this.field_70170_p.field_72995_K) {
            if (this.field_70170_p.func_175659_aa() == EnumDifficulty.PEACEFUL) {
                this.func_70106_y();
            }
            this.func_70606_j(this.func_110143_aJ() - 1.0f);
            if (this.func_70638_az() != null) {
                LivingEntity target = this.func_70638_az();
                this.func_70605_aq().func_75642_a(target.field_70165_t, target.field_70163_u, target.field_70161_v, 1.0);
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

    @Override
    protected int numberOfLives() {
        return this.isPrime() ? 4 : 1;
    }
}

