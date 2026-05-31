/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.entity.projectile.EntityArrow
 *  net.minecraft.entity.projectile.EntityFireball
 *  net.minecraft.entity.projectile.EntityThrowable
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.network.datasync.DataParameter
 *  net.minecraft.network.datasync.DataSerializer
 *  net.minecraft.network.datasync.DataSerializers
 *  net.minecraft.network.datasync.EntityDataManager
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.EnumParticleTypes
 *  net.minecraft.util.ResourceLocation
 *  net.minecraft.util.SoundEvent
 *  net.minecraft.world.World
 */
package xol.lostinfinity.mob.entity.starforge;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntityFireball;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializer;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.level.Level;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.mob.entity.base.EntityMultipleLives;
import xol.lostinfinity.projectile.entity.EntityUltraCrystalGel;
import xol.lostinfinity.util.data.IMaxAttack;
import xol.lostinfinity.util.load.LootTableRegistry;

public class EntityReflectal
extends EntityMultipleLives
implements IMaxAttack {
    private static final DataParameter<Boolean> DEFENDING = EntityDataManager.func_187226_a(EntityReflectal.class, (DataSerializer)DataSerializers.field_187198_h);
    private static final DataParameter<Boolean> ENLARGED = EntityDataManager.func_187226_a(EntityReflectal.class, (DataSerializer)DataSerializers.field_187198_h);
    private int target_tick = -1;
    private float ultrascale = 1.0f;

    public EntityReflectal(Level worldIn) {
        super(worldIn);
        this.func_70105_a(1.1f, 1.2f);
    }

    @Override
    protected void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af.func_187214_a(DEFENDING, (Object)false);
        this.field_70180_af.func_187214_a(ENLARGED, (Object)false);
    }

    public boolean getDefending() {
        return (Boolean)this.field_70180_af.func_187225_a(DEFENDING);
    }

    public void setDefending(boolean f) {
        this.field_70180_af.func_187227_b(DEFENDING, (Object)f);
    }

    public void setEnlarged(boolean f) {
        this.field_70180_af.func_187227_b(ENLARGED, (Object)f);
    }

    public boolean isEnlarged() {
        return (Boolean)this.field_70180_af.func_187225_a(ENLARGED);
    }

    public float getUltraScl() {
        return this.ultrascale;
    }

    @Override
    public void func_70014_b(CompoundTag tag) {
        super.func_70014_b(tag);
        tag.func_74757_a("EnlargedState", this.isEnlarged());
    }

    @Override
    public void func_70037_a(CompoundTag tag) {
        super.func_70037_a(tag);
        this.setEnlarged(tag.func_74767_n("EnlargedState"));
    }

    public void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(2500.0);
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(1.0);
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.22);
        this.func_110148_a(SharedMonsterAttributes.field_111266_c).func_111128_a(1.0);
    }

    public boolean func_70652_k(Entity entity) {
        super.func_70652_k(entity);
        if (this.func_70638_az() != null) {
            IMaxAttack.dealMaxHealth((Entity)this, this.func_70638_az(), 3);
            return true;
        }
        return false;
    }

    public void func_70636_d() {
        super.func_70636_d();
        if (this.isEnlarged() && this.ultrascale < 3.0f) {
            this.ultrascale += 0.02f;
            this.func_70105_a(1.1f * this.ultrascale, 1.2f * this.ultrascale);
        }
        boolean flag = false;
        for (Entity proj : this.field_70170_p.func_72872_a(Entity.class, this.func_174813_aQ().func_72314_b(7.0, 5.0, 7.0))) {
            if (!(proj instanceof EntityThrowable) && !(proj instanceof EntityArrow) && !(proj instanceof EntityFireball)) continue;
            if (!this.field_70170_p.field_72995_K && !(proj instanceof EntityUltraCrystalGel)) {
                proj.func_70106_y();
                flag = true;
                continue;
            }
            for (int i = 0; i < 3; ++i) {
                this.field_70170_p.func_175688_a(EnumParticleTypes.DRAGON_BREATH, proj.field_70165_t, proj.field_70163_u, proj.field_70161_v, this.field_70170_p.field_73012_v.nextDouble() - 0.5, -this.field_70170_p.field_73012_v.nextDouble(), this.field_70170_p.field_73012_v.nextDouble() - 0.5, new int[0]);
            }
        }
        if (!this.field_70170_p.field_72995_K) {
            if (flag) {
                this.func_184185_a(SoundInit.ITEM_AXIOMAVORUM, 1.0f, 1.0f);
                this.setDefending(true);
                this.target_tick = this.field_70173_aa + 25;
            } else if (this.field_70173_aa == this.target_tick) {
                this.setDefending(false);
            }
        }
    }

    protected SoundEvent func_184615_bR() {
        return SoundInit.STARFORGE_REFLECTAL_DEATH;
    }

    protected SoundEvent func_184601_bQ(DamageSource damageSourceIn) {
        return SoundInit.STARFORGE_REFLECTAL_HURT;
    }

    protected SoundEvent func_184639_G() {
        return SoundInit.STARFORGE_REFLECTAL_AMBIENT;
    }

    protected ResourceLocation func_184647_J() {
        return this.isEnlarged() ? LootTableRegistry.ENTITIES_STARFORGE_BLUE_REFLECTAL : LootTableRegistry.ENTITIES_STARFORGE_REFLECTAL;
    }

    @Override
    protected int numberOfLives() {
        return this.isEnlarged() ? 6 : 3;
    }

    @Override
    protected void updateLifeAction() {
        int size = this.isEnlarged() ? 15 : 5;
        for (LivingEntity near_pl : this.field_70170_p.func_72872_a(LivingEntity.class, this.func_174813_aQ().func_72314_b((double)size, (double)size, (double)size))) {
            IMaxAttack.dealMaxHealth((Entity)this, near_pl, 3, 2.0f);
        }
    }

    protected boolean func_70692_ba() {
        return false;
    }
}

