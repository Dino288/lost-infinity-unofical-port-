/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.init.SoundEvents
 *  net.minecraft.network.datasync.DataParameter
 *  net.minecraft.network.datasync.DataSerializer
 *  net.minecraft.network.datasync.DataSerializers
 *  net.minecraft.network.datasync.EntityDataManager
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.ResourceLocation
 *  net.minecraft.util.SoundSource
 *  net.minecraft.util.SoundEvent
 *  net.minecraft.world.World
 */
package xol.lostinfinity.mob.entity.deviant;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializer;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundSource;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.level.Level;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.mob.entity.base.EntityDeviantMob;
import xol.lostinfinity.util.data.IMaxAttack;
import xol.lostinfinity.util.load.LootTableRegistry;

public class EntityDeviantWolf
extends EntityDeviantMob {
    private static final DataParameter<Boolean> SHIMMERS = EntityDataManager.func_187226_a(EntityDeviantWolf.class, (DataSerializer)DataSerializers.field_187198_h);
    private int shimmerCounter = 0;
    private int dashCooldown = -1;

    public EntityDeviantWolf(Level worldIn) {
        super(worldIn);
        this.func_70105_a(1.5f, 1.9f);
    }

    @Override
    protected void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af.func_187214_a(SHIMMERS, (Object)false);
    }

    public boolean isShimmering() {
        return (Boolean)this.field_70180_af.func_187225_a(SHIMMERS);
    }

    public void setShimmer(boolean sh) {
        this.field_70180_af.func_187227_b(SHIMMERS, (Object)sh);
    }

    protected SoundEvent func_184615_bR() {
        return SoundEvents.field_187859_gF;
    }

    protected SoundEvent func_184601_bQ(DamageSource damageSourceIn) {
        return SoundEvents.field_187863_gH;
    }

    protected SoundEvent func_184639_G() {
        return SoundEvents.field_187857_gE;
    }

    public void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(1.0);
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.5);
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(2000.0);
    }

    @Override
    protected ResourceLocation deviantDrop() {
        return LootTableRegistry.ENTITIES_DEVIANTWOLF;
    }

    @Override
    protected ResourceLocation superMutatedDrop() {
        return LootTableRegistry.ENTITIES_SUPERMUTANT_WOLF;
    }

    public boolean func_70652_k(Entity entity) {
        super.func_70652_k(entity);
        if (this.func_70638_az() != null) {
            IMaxAttack.dealTrueDamage((Entity)this, this.func_70638_az(), this.func_70638_az().func_110138_aP() * (0.5f + 0.25f * (float)this.getMutation()));
            return true;
        }
        return false;
    }

    public void func_70636_d() {
        super.func_70636_d();
        this.field_70143_R = -1.0f;
        if (!this.field_70170_p.field_72995_K) {
            LivingEntity pl;
            if (this.dashCooldown >= 0) {
                if (this.dashCooldown == 0 && this.func_70638_az() != null) {
                    pl = this.func_70638_az();
                    this.func_70024_g((pl.field_70165_t - this.field_70165_t) * 0.3, (pl.field_70163_u - this.field_70163_u) * 0.2, (pl.field_70161_v - this.field_70161_v) * 0.3);
                    this.field_70133_I = true;
                }
                --this.dashCooldown;
            }
            if (this.isShimmering()) {
                ++this.shimmerCounter;
                if (this.shimmerCounter == 30) {
                    this.setShimmer(false);
                }
            }
            if (this.field_70173_aa % (70 - 10 * this.getMutation()) == 0 && this.func_70638_az() != null) {
                pl = this.func_70638_az();
                this.func_70024_g((pl.field_70165_t - this.field_70165_t) * 0.05, 1.5, (pl.field_70161_v - this.field_70161_v) * 0.05);
                this.field_70133_I = true;
                this.setShimmer(true);
                this.dashCooldown = 5;
                this.shimmerCounter = 0;
                this.field_70170_p.func_184133_a(null, this.func_180425_c(), SoundInit.MAGIC_WEAPON_13, SoundSource.HOSTILE, 1.25f, 0.8f + this.field_70146_Z.nextFloat() * 0.4f);
            }
        }
    }
}

