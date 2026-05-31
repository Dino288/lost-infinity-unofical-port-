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
import xol.lostinfinity.mob.ai.IBasicAI;
import xol.lostinfinity.mob.entity.base.EntityMultipleLives;
import xol.lostinfinity.projectile.entity.EntityCrystalShard;
import xol.lostinfinity.util.data.IMaxAttack;
import xol.lostinfinity.util.load.LootTableRegistry;

public class EntitySpyker
extends EntityMultipleLives
implements IMaxAttack,
IBasicAI {
    private static final DataParameter<Boolean> ENLARGED = EntityDataManager.func_187226_a(EntitySpyker.class, (DataSerializer)DataSerializers.field_187198_h);
    private float ultrascale = 1.0f;

    public EntitySpyker(Level worldIn) {
        super(worldIn);
        this.func_70105_a(1.0f, 1.5f);
    }

    @Override
    protected void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af.func_187214_a(ENLARGED, (Object)false);
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
            IMaxAttack.dealMaxHealth((Entity)this, this.func_70638_az(), 4);
            return true;
        }
        return false;
    }

    public void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(1500.0);
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(1.0);
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.3);
        this.func_110148_a(SharedMonsterAttributes.field_111266_c).func_111128_a(1.0);
    }

    public void func_70636_d() {
        super.func_70636_d();
        if (this.isEnlarged() && this.ultrascale < 3.0f) {
            this.ultrascale += 0.02f;
            this.func_70105_a(1.0f * this.ultrascale, 1.5f * this.ultrascale);
        }
    }

    public void func_70645_a(DamageSource cause) {
        super.func_70645_a(cause);
        if (!this.field_70170_p.field_72995_K) {
            double x0 = this.field_70165_t;
            double y0 = (this.func_174813_aQ().field_72338_b + this.func_174813_aQ().field_72337_e) / 2.0;
            double z0 = this.field_70161_v;
            double radius = 5.0;
            int repeats = this.isEnlarged() ? 16 : 8;
            float angle = 0.0f;
            while ((double)angle <= Math.PI * 2) {
                EntityCrystalShard shot = new EntityCrystalShard(this.field_70170_p, (LivingEntity)this);
                shot.func_70107_b(x0, y0, z0);
                double velocity_x = radius * Math.cos(angle);
                double velocity_z = radius * Math.sin(angle);
                shot.setThrower((LivingEntity)this);
                shot.calculateVelocity(velocity_x, 0.5, velocity_z);
                shot.func_184538_a((Entity)this, shot.field_70125_A, shot.field_70177_z, 0.0f, 0.5f, 0.0f);
                this.field_70170_p.func_72838_d((Entity)shot);
                angle = (float)((double)angle + Math.PI / (double)repeats);
            }
        }
    }

    protected SoundEvent func_184615_bR() {
        return SoundInit.STARFORGE_SPYKER_DEATH;
    }

    protected SoundEvent func_184601_bQ(DamageSource damageSourceIn) {
        return SoundInit.STARFORGE_SPYKER_HURT;
    }

    protected SoundEvent func_184639_G() {
        return SoundInit.STARFORGE_SPYKER_AMBIENT;
    }

    protected ResourceLocation func_184647_J() {
        return this.isEnlarged() ? LootTableRegistry.ENTITIES_STARFORGE_BLUE_SPYKER : LootTableRegistry.ENTITIES_STARFORGE_SPYKER;
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
        return this.isEnlarged() ? 5 : 1;
    }

    @Override
    public boolean func_70601_bi() {
        return this.field_70170_p.func_175659_aa() != EnumDifficulty.PEACEFUL;
    }
}

