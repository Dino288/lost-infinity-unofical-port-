/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.IEntityOwnable
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.init.SoundEvents
 *  net.minecraft.network.datasync.DataParameter
 *  net.minecraft.network.datasync.DataSerializer
 *  net.minecraft.network.datasync.DataSerializers
 *  net.minecraft.network.datasync.EntityDataManager
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.SoundEvent
 *  net.minecraft.world.World
 */
package xol.lostinfinity.mob.entity.deviant;

import java.util.UUID;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.entity.IEntityOwnable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializer;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.level.Level;
import xol.lostinfinity.mob.ai.EntityAIFloatAttack;
import xol.lostinfinity.mob.entity.base.EntityFloatingDeviant;
import xol.lostinfinity.mob.entity.deviant.EntityDeviantEvoker;
import xol.lostinfinity.util.data.IMaxAttack;

public class EntityDeviantEvokerVex
extends EntityFloatingDeviant
implements IMaxAttack,
IEntityOwnable {
    protected static final DataParameter<Boolean> TAMED = EntityDataManager.func_187226_a(EntityDeviantEvokerVex.class, (DataSerializer)DataSerializers.field_187198_h);
    protected static final DataParameter<Integer> OWNER_ID = EntityDataManager.func_187226_a(EntityDeviantEvokerVex.class, (DataSerializer)DataSerializers.field_187192_b);

    public EntityDeviantEvokerVex(Level worldIn) {
        super(worldIn);
        this.func_70105_a(1.0f, 1.3f);
    }

    @Override
    public void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(1.0);
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.5);
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(800.0);
    }

    public boolean func_70652_k(Entity entity) {
        super.func_70652_k(entity);
        if (this.func_70638_az() != null) {
            IMaxAttack.dealMaxHealth((Entity)this, this.func_70638_az(), 4);
            return true;
        }
        return false;
    }

    protected SoundEvent func_184615_bR() {
        return SoundEvents.field_191266_he;
    }

    protected SoundEvent func_184601_bQ(DamageSource damageSourceIn) {
        return SoundEvents.field_191267_hf;
    }

    protected SoundEvent func_184639_G() {
        return SoundEvents.field_191264_hc;
    }

    @Override
    public void func_70636_d() {
        super.func_70636_d();
        if (!this.field_70170_p.field_72995_K && this.func_70638_az() != null) {
            LivingEntity target = this.func_70638_az();
            if (target instanceof EntityDeviantEvoker) {
                this.func_70624_b(null);
            } else {
                this.func_70605_aq().func_75642_a(target.field_70165_t, target.field_70163_u, target.field_70161_v, 1.0);
            }
        }
    }

    @Override
    protected void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af.func_187214_a(TAMED, (Object)false);
        this.field_70180_af.func_187214_a(OWNER_ID, (Object)0);
    }

    public boolean isTamed() {
        return (Boolean)this.field_70180_af.func_187225_a(TAMED);
    }

    public void setTamed(boolean tamed) {
        this.field_70180_af.func_187227_b(TAMED, (Object)tamed);
    }

    public void setTamedBy(LivingEntity tamer) {
        this.setTamed(true);
        this.setOwnerId(tamer.func_145782_y());
    }

    public void setOwnerId(int id) {
        this.field_70180_af.func_187227_b(OWNER_ID, (Object)id);
    }

    public UUID func_184753_b() {
        Entity owner = this.field_70170_p.func_73045_a(((Integer)this.field_70180_af.func_187225_a(OWNER_ID)).intValue());
        if (owner != null) {
            return owner.func_110124_au();
        }
        return null;
    }

    public Entity func_70902_q() {
        return this.field_70170_p.func_73045_a(((Integer)this.field_70180_af.func_187225_a(OWNER_ID)).intValue());
    }

    @Override
    protected EntityAIFloatAttack createShootAI() {
        return null;
    }
}

