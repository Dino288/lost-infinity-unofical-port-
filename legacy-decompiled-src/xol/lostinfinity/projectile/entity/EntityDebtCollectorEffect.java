/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.network.datasync.DataParameter
 *  net.minecraft.network.datasync.DataSerializer
 *  net.minecraft.network.datasync.DataSerializers
 *  net.minecraft.network.datasync.EntityDataManager
 *  net.minecraft.util.SoundSource
 *  net.minecraft.util.math.Vec3
 *  net.minecraft.world.World
 */
package xol.lostinfinity.projectile.entity;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializer;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.Level;
import xol.lostinfinity.init.ParticleInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.mob.entity.base.EntityMultipleLives;
import xol.lostinfinity.util.data.CustomParticleConfig;
import xol.lostinfinity.util.data.IMaxAttack;
import xol.lostinfinity.util.fx.IParticleSpawner;

public class EntityDebtCollectorEffect
extends Entity
implements IMaxAttack {
    private boolean playedExecuteSound = false;
    private boolean didKill = false;
    private static final DataParameter<Float> TARGET_X = EntityDataManager.func_187226_a(EntityDebtCollectorEffect.class, (DataSerializer)DataSerializers.field_187193_c);
    private static final DataParameter<Float> TARGET_Y = EntityDataManager.func_187226_a(EntityDebtCollectorEffect.class, (DataSerializer)DataSerializers.field_187193_c);
    private static final DataParameter<Float> TARGET_Z = EntityDataManager.func_187226_a(EntityDebtCollectorEffect.class, (DataSerializer)DataSerializers.field_187193_c);
    private static final DataParameter<Float> TARGET_LOOK_X = EntityDataManager.func_187226_a(EntityDebtCollectorEffect.class, (DataSerializer)DataSerializers.field_187193_c);
    private static final DataParameter<Float> TARGET_LOOK_Y = EntityDataManager.func_187226_a(EntityDebtCollectorEffect.class, (DataSerializer)DataSerializers.field_187193_c);
    private static final DataParameter<Float> TARGET_LOOK_Z = EntityDataManager.func_187226_a(EntityDebtCollectorEffect.class, (DataSerializer)DataSerializers.field_187193_c);
    private static final DataParameter<Float> TARGET_HEIGHT = EntityDataManager.func_187226_a(EntityDebtCollectorEffect.class, (DataSerializer)DataSerializers.field_187193_c);
    private Player creator = null;
    private LivingEntity target = null;
    private float rotation = 0.0f;
    private float alpha = 1.0f;
    private float rotationIncreaser = 0.025f;

    public EntityDebtCollectorEffect(Level worldIn) {
        super(worldIn);
    }

    public Vec3 getTargetPos() {
        double x = ((Float)this.field_70180_af.func_187225_a(TARGET_X)).floatValue();
        double y = ((Float)this.field_70180_af.func_187225_a(TARGET_Y)).floatValue();
        double z = ((Float)this.field_70180_af.func_187225_a(TARGET_Z)).floatValue();
        return new Vec3(x, y, z);
    }

    public Vec3 getTargetVec() {
        double x = ((Float)this.field_70180_af.func_187225_a(TARGET_LOOK_X)).floatValue();
        double y = ((Float)this.field_70180_af.func_187225_a(TARGET_LOOK_Y)).floatValue();
        double z = ((Float)this.field_70180_af.func_187225_a(TARGET_LOOK_Z)).floatValue();
        return new Vec3(x, y, z);
    }

    public void setTargetVec(Vec3 vec) {
        this.field_70180_af.func_187227_b(TARGET_LOOK_X, (Object)Float.valueOf((float)vec.field_72450_a));
        this.field_70180_af.func_187227_b(TARGET_LOOK_Y, (Object)Float.valueOf((float)vec.field_72448_b));
        this.field_70180_af.func_187227_b(TARGET_LOOK_Z, (Object)Float.valueOf((float)vec.field_72449_c));
    }

    public void setTargetPos(Vec3 vec) {
        this.field_70180_af.func_187227_b(TARGET_X, (Object)Float.valueOf((float)vec.field_72450_a));
        this.field_70180_af.func_187227_b(TARGET_Y, (Object)Float.valueOf((float)vec.field_72448_b));
        this.field_70180_af.func_187227_b(TARGET_Z, (Object)Float.valueOf((float)vec.field_72449_c));
    }

    public void setTargetHeight(double height) {
        this.field_70180_af.func_187227_b(TARGET_HEIGHT, (Object)Float.valueOf((float)height));
    }

    public double getTargetHeight() {
        return ((Float)this.field_70180_af.func_187225_a(TARGET_HEIGHT)).floatValue();
    }

    public void func_70071_h_() {
        super.func_70071_h_();
        if (!this.field_70170_p.field_72995_K) {
            if ((this.creator == null || this.target == null) && this.field_70173_aa > 2) {
                this.func_70106_y();
            } else {
                if (this.target != null) {
                    this.setTargetPos(this.target.func_174791_d());
                    this.setTargetVec(this.target.func_70040_Z());
                    this.setTargetHeight(this.target.field_70131_O);
                }
                if (this.field_70173_aa >= 45) {
                    if (!this.playedExecuteSound) {
                        this.field_70170_p.func_184133_a(null, this.func_180425_c(), SoundInit.EXECUTE_EFFECT_3, SoundSource.PLAYERS, 1.5f, 0.9f + 0.2f * this.field_70146_Z.nextFloat());
                        this.playedExecuteSound = true;
                    }
                    if (this.field_70173_aa >= 50 && !this.didKill) {
                        IMaxAttack.dealTrueDamage((Entity)this.creator, this.target, this.target.func_110138_aP() * 2.0f);
                        if (this.target instanceof EntityMultipleLives) {
                            ((EntityMultipleLives)this.target).takeawayNumLives(5);
                        }
                        this.didKill = true;
                        Vec3 vecPos = this.getTargetPos();
                        CustomParticleConfig config1 = new CustomParticleConfig();
                        config1.createInstance().setParticle(ParticleInit.PURPLE_SKULL).setSpread(4.0, 1.0, 4.0).setCount(12).setIgnoreRange(true);
                        IParticleSpawner.spawnParticle(this.field_70170_p, config1, vecPos.field_72450_a, vecPos.field_72448_b + this.getTargetHeight() / 2.0, vecPos.field_72449_c);
                    }
                }
            }
            if (this.field_70173_aa >= 140) {
                this.func_70106_y();
            }
        } else {
            this.rotation += this.rotationIncreaser;
            if (this.field_70173_aa > 30) {
                this.rotationIncreaser += 0.015f;
                if ((double)this.rotation >= Math.PI) {
                    this.alpha -= 0.07f;
                }
            }
        }
    }

    public void setTarget(LivingEntity target) {
        this.target = target;
    }

    public void setCreator(Player creator) {
        this.creator = creator;
    }

    protected void func_70037_a(CompoundTag compound) {
    }

    protected void func_70014_b(CompoundTag compound) {
    }

    protected void func_70088_a() {
        this.field_70180_af.func_187214_a(TARGET_X, (Object)Float.valueOf(0.0f));
        this.field_70180_af.func_187214_a(TARGET_Y, (Object)Float.valueOf(0.0f));
        this.field_70180_af.func_187214_a(TARGET_Z, (Object)Float.valueOf(0.0f));
        this.field_70180_af.func_187214_a(TARGET_LOOK_X, (Object)Float.valueOf(0.0f));
        this.field_70180_af.func_187214_a(TARGET_LOOK_Y, (Object)Float.valueOf(0.0f));
        this.field_70180_af.func_187214_a(TARGET_LOOK_Z, (Object)Float.valueOf(0.0f));
        this.field_70180_af.func_187214_a(TARGET_HEIGHT, (Object)Float.valueOf(0.0f));
    }

    public float getRotation() {
        return this.rotation;
    }

    public float getAlpha() {
        return this.alpha;
    }
}

