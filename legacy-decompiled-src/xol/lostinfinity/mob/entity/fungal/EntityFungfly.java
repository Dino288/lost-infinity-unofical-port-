/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.IMobData
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.network.datasync.DataParameter
 *  net.minecraft.network.datasync.DataSerializer
 *  net.minecraft.network.datasync.DataSerializers
 *  net.minecraft.network.datasync.EntityDataManager
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.ResourceLocation
 *  net.minecraft.util.SoundEvent
 *  net.minecraft.world.DifficultyInstance
 *  net.minecraft.world.World
 */
package xol.lostinfinity.mob.entity.fungal;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.entity.IMobData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializer;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.level.Level;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.mob.ai.EntityAIFloatAttack;
import xol.lostinfinity.mob.entity.base.EntityFloatingBase;
import xol.lostinfinity.util.data.IMaxAttack;
import xol.lostinfinity.util.load.LootTableRegistry;

public class EntityFungfly
extends EntityFloatingBase
implements IMaxAttack {
    private static final DataParameter<Integer> VISUAL_STYLE = EntityDataManager.func_187226_a(EntityFungfly.class, (DataSerializer)DataSerializers.field_187192_b);

    public EntityFungfly(Level worldIn) {
        super(worldIn);
        this.func_70105_a(0.5f, 0.5f);
    }

    @Override
    protected void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af.func_187214_a(VISUAL_STYLE, (Object)-1);
    }

    public boolean func_70652_k(Entity entity) {
        super.func_70652_k(entity);
        if (this.func_70638_az() != null) {
            IMaxAttack.dealMaxHealth((Entity)this, this.func_70638_az(), 1);
            return true;
        }
        return false;
    }

    public IMobData func_180482_a(DifficultyInstance difficulty, IMobData livingdata) {
        this.setVisual(this.field_70146_Z.nextInt(5));
        return super.func_180482_a(difficulty, livingdata);
    }

    public int getVisual() {
        return (Integer)this.field_70180_af.func_187225_a(VISUAL_STYLE);
    }

    public void setVisual(int v) {
        this.field_70180_af.func_187227_b(VISUAL_STYLE, (Object)v);
    }

    @Override
    public void func_70636_d() {
        super.func_70636_d();
        if (!this.field_70170_p.field_72995_K && this.func_70638_az() != null) {
            LivingEntity target = this.func_70638_az();
            this.func_70605_aq().func_75642_a(target.field_70165_t, target.field_70163_u, target.field_70161_v, 1.0);
        }
    }

    @Override
    public void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(4000.0);
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(1.0);
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.25);
        this.func_110148_a(SharedMonsterAttributes.field_111266_c).func_111128_a(1.0);
    }

    protected SoundEvent func_184615_bR() {
        return SoundInit.TERROR_FLY_DEATH;
    }

    protected SoundEvent func_184601_bQ(DamageSource damageSourceIn) {
        return SoundInit.TERROR_FLY_HURT;
    }

    protected SoundEvent func_184639_G() {
        return SoundInit.TERROR_FLY_AMBIENT;
    }

    @Override
    protected int numberOfLives() {
        return 7;
    }

    protected ResourceLocation func_184647_J() {
        return LootTableRegistry.ENTITIES_TERRORFLY;
    }

    @Override
    protected EntityAIFloatAttack createShootAI() {
        return null;
    }
}

