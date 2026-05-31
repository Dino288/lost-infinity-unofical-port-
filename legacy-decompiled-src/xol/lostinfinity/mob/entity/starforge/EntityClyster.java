/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.network.datasync.DataParameter
 *  net.minecraft.network.datasync.DataSerializer
 *  net.minecraft.network.datasync.DataSerializers
 *  net.minecraft.network.datasync.EntityDataManager
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.ResourceLocation
 *  net.minecraft.util.SoundEvent
 *  net.minecraft.world.EnumDifficulty
 *  net.minecraft.world.World
 */
package xol.lostinfinity.mob.entity.starforge;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializer;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.Difficulty;
import net.minecraft.world.level.Level;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.mob.entity.base.EntityMultipleLives;
import xol.lostinfinity.util.data.IMaxAttack;
import xol.lostinfinity.util.load.LootTableRegistry;

public class EntityClyster
extends EntityMultipleLives
implements IMaxAttack {
    private static final DataParameter<Boolean> ATTACKING = EntityDataManager.func_187226_a(EntityClyster.class, (DataSerializer)DataSerializers.field_187198_h);
    private static final DataParameter<Boolean> ENLARGED = EntityDataManager.func_187226_a(EntityClyster.class, (DataSerializer)DataSerializers.field_187198_h);
    private float ultrascale = 1.0f;

    public EntityClyster(Level worldIn) {
        super(worldIn);
        this.func_70105_a(2.2f, 3.5f);
    }

    @Override
    protected void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af.func_187214_a(ATTACKING, (Object)false);
        this.field_70180_af.func_187214_a(ENLARGED, (Object)false);
    }

    public boolean getAngry() {
        return (Boolean)this.field_70180_af.func_187225_a(ATTACKING);
    }

    public void setAngry(boolean f) {
        this.field_70180_af.func_187227_b(ATTACKING, (Object)f);
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

    public boolean func_70652_k(Entity entity) {
        super.func_70652_k(entity);
        if (this.func_70638_az() != null) {
            IMaxAttack.dealMaxHealth((Entity)this, this.func_70638_az(), 3, 2.0f);
            return true;
        }
        return false;
    }

    public void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(2500.0);
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(1.0);
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.25);
        this.func_110148_a(SharedMonsterAttributes.field_111266_c).func_111128_a(1.0);
    }

    public void func_70636_d() {
        super.func_70636_d();
        if (this.isEnlarged() && this.ultrascale < 2.0f) {
            this.ultrascale += 0.02f;
            this.func_70105_a(2.2f * this.ultrascale, 3.5f * this.ultrascale);
        }
        if (!this.field_70170_p.field_72995_K) {
            this.setAngry(this.func_70638_az() != null);
        }
        if (this.func_70638_az() != null) {
            LivingEntity near_pl = this.func_70638_az();
            double moveSpeed = this.isEnlarged() ? 0.035 : 0.02;
            near_pl.func_70024_g(Math.signum(this.field_70165_t - near_pl.field_70165_t) * moveSpeed, 0.0, Math.signum(this.field_70161_v - near_pl.field_70161_v) * moveSpeed);
            near_pl.field_70133_I = true;
        }
    }

    protected SoundEvent func_184615_bR() {
        return SoundInit.STARFORGE_CLYSTER_DEATH;
    }

    protected SoundEvent func_184601_bQ(DamageSource damageSourceIn) {
        return SoundInit.STARFORGE_CLYSTER_HURT;
    }

    protected SoundEvent func_184639_G() {
        return SoundInit.STARFORGE_CLYSTER_AMBIENT;
    }

    protected ResourceLocation func_184647_J() {
        return this.isEnlarged() ? LootTableRegistry.ENTITIES_STARFORGE_BLUE_CLYSTER : LootTableRegistry.ENTITIES_STARFORGE_CLYSTER;
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

    @Override
    protected int numberOfLives() {
        return this.isEnlarged() ? 8 : 2;
    }

    @Override
    public boolean func_70601_bi() {
        return this.field_70170_p.func_175659_aa() != EnumDifficulty.PEACEFUL;
    }
}

