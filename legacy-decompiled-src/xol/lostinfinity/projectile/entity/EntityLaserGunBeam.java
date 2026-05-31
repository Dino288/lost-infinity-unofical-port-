/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.item.ItemStack
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.network.datasync.DataParameter
 *  net.minecraft.network.datasync.DataSerializer
 *  net.minecraft.network.datasync.DataSerializers
 *  net.minecraft.network.datasync.EntityDataManager
 *  net.minecraft.util.SoundSource
 *  net.minecraft.util.math.AABB
 *  net.minecraft.util.math.Mth
 *  net.minecraft.util.math.Vec3
 *  net.minecraft.world.World
 */
package xol.lostinfinity.projectile.entity;

import java.util.ArrayList;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializer;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.phys.AABB;
import net.minecraft.util.Mth;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.Level;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.init.ParticleInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.item.basics.ItemChanneling;
import xol.lostinfinity.mob.entity.base.EntityImmaterial;
import xol.lostinfinity.mob.entity.base.EntityMultipleLives;
import xol.lostinfinity.util.data.IMaxAttack;
import xol.lostinfinity.util.math.LMath;

public class EntityLaserGunBeam
extends Entity
implements IMaxAttack {
    private Player owner = null;
    private static final DataParameter<Float> TARGET_X = EntityDataManager.func_187226_a(EntityLaserGunBeam.class, (DataSerializer)DataSerializers.field_187193_c);
    private static final DataParameter<Float> TARGET_Y = EntityDataManager.func_187226_a(EntityLaserGunBeam.class, (DataSerializer)DataSerializers.field_187193_c);
    private static final DataParameter<Float> TARGET_Z = EntityDataManager.func_187226_a(EntityLaserGunBeam.class, (DataSerializer)DataSerializers.field_187193_c);
    private static final DataParameter<ItemStack> STACK = EntityDataManager.func_187226_a(EntityLaserGunBeam.class, (DataSerializer)DataSerializers.field_187196_f);
    private static final DataParameter<Boolean> CHARGING = EntityDataManager.func_187226_a(EntityLaserGunBeam.class, (DataSerializer)DataSerializers.field_187198_h);
    private static final int duration = 40;
    private final double dist = 90.0;
    public int counter;
    private boolean wasCharging = false;

    public EntityLaserGunBeam(Level worldIn) {
        super(worldIn);
    }

    public ItemStack getStack() {
        return (ItemStack)this.field_70180_af.func_187225_a(STACK);
    }

    public void setStack(ItemStack stack) {
        this.field_70180_af.func_187227_b(STACK, (Object)stack);
    }

    protected void func_70088_a() {
        this.field_70180_af.func_187214_a(TARGET_X, (Object)Float.valueOf(0.0f));
        this.field_70180_af.func_187214_a(TARGET_Y, (Object)Float.valueOf(0.0f));
        this.field_70180_af.func_187214_a(TARGET_Z, (Object)Float.valueOf(0.0f));
        this.field_70180_af.func_187214_a(STACK, (Object)ItemStack.field_190927_a);
        this.field_70180_af.func_187214_a(CHARGING, (Object)false);
    }

    public Vec3 getTargetPos() {
        double x = ((Float)this.field_70180_af.func_187225_a(TARGET_X)).floatValue();
        double y = ((Float)this.field_70180_af.func_187225_a(TARGET_Y)).floatValue();
        double z = ((Float)this.field_70180_af.func_187225_a(TARGET_Z)).floatValue();
        return new Vec3(x, y, z);
    }

    public void setTargetPos(Vec3 pos) {
        float xpos = (float)pos.field_72450_a;
        float ypos = (float)pos.field_72448_b;
        float zpos = (float)pos.field_72449_c;
        this.field_70180_af.func_187227_b(TARGET_X, (Object)Float.valueOf(xpos));
        this.field_70180_af.func_187227_b(TARGET_Y, (Object)Float.valueOf(ypos));
        this.field_70180_af.func_187227_b(TARGET_Z, (Object)Float.valueOf(zpos));
    }

    public Player getOwner() {
        return this.owner;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }

    public void func_70030_z() {
        super.func_70030_z();
        ItemStack stack = this.getStack();
        if (stack.func_77973_b() != ItemInit.laserGun) {
            return;
        }
        if (!this.field_70170_p.field_72995_K) {
            if (this.owner == null || this.owner.func_184614_ca().func_77973_b() != ItemInit.laserGun) {
                this.func_70106_y();
                return;
            }
            this.updatePosition();
            boolean charging = ItemChanneling.isChanneling((LivingEntity)this.owner, stack);
            this.setCharging(charging);
            if (charging) {
                if (this.counter < 34) {
                    ++this.counter;
                }
            } else {
                if (this.counter < 34) {
                    this.func_70106_y();
                    return;
                }
                ++this.counter;
                if (this.counter == 36) {
                    this.damageTarget();
                }
            }
            if (this.counter >= 40) {
                this.func_70106_y();
            }
        } else {
            boolean charging = (Boolean)this.field_70180_af.func_187225_a(CHARGING);
            if (charging) {
                if (this.counter < 34) {
                    ++this.counter;
                }
            } else {
                ++this.counter;
            }
            this.spawnParticles();
        }
    }

    private void damageTarget() {
        Vec3 dir = this.getTargetPos().func_178788_d(this.func_174791_d()).func_72432_b();
        ArrayList<LivingEntity> hitEntities = new ArrayList<LivingEntity>();
        for (double i = 0.0; i <= 90.0; i += 0.4) {
            Vec3 pos = this.func_174791_d().func_72441_c(dir.field_72450_a * i, dir.field_72448_b * i, dir.field_72449_c * i);
            double radius = 1.8;
            AABB checkBox = new AABB(pos.field_72450_a - radius, pos.field_72448_b - radius, pos.field_72449_c - radius, pos.field_72450_a + radius, pos.field_72448_b + radius, pos.field_72449_c + radius);
            for (LivingEntity entity : this.field_70170_p.func_72872_a(LivingEntity.class, checkBox)) {
                EntityMultipleLives multiLifer;
                int lives;
                if (entity instanceof EntityImmaterial || entity.func_110124_au().equals(this.owner.func_110124_au()) || hitEntities.contains(entity)) continue;
                if (!IMaxAttack.dealTrueDamage((Entity)this.owner, entity, entity.func_110138_aP() * 0.5f).wasTargetKilled() && entity instanceof EntityMultipleLives && (lives = (multiLifer = (EntityMultipleLives)entity).remainingLives()) >= 2) {
                    multiLifer.takeawayNumLives(Mth.func_76141_d((float)Math.min(lives / 2, 10)));
                }
                hitEntities.add(entity);
            }
        }
        this.field_70170_p.func_184133_a(null, this.owner.func_180425_c(), SoundInit.LASER_WEAPON_9, SoundSource.MASTER, 1.0f, 1.0f);
    }

    private void updatePosition() {
        if (this.owner == null) {
            return;
        }
        if (this.counter % 5 == 0 && this.counter < 36) {
            this.field_70170_p.func_184133_a(null, this.owner.func_180425_c(), SoundInit.LASER_WEAPON_8, SoundSource.MASTER, 1.0f, 0.7f + (float)this.counter / 10.0f);
        }
        Vec3 dir = this.owner.func_70040_Z();
        Vec3 offset = dir.func_178785_b(1.5707964f);
        this.func_70634_a(this.owner.field_70165_t - offset.field_72450_a / 2.0, this.owner.field_70163_u + (double)this.owner.field_70131_O / 1.8, this.owner.field_70161_v - offset.field_72449_c / 2.0);
        Vec3 targetPos = dir.func_186678_a(90.0).func_178787_e(this.owner.func_174791_d());
        this.setTargetPos(targetPos);
    }

    private void spawnParticles() {
        if (this.counter >= 40) {
            return;
        }
        Vec3 dir = LMath.fastNormalize(this.getTargetPos().func_178788_d(this.func_174791_d()));
        for (double i = 0.0; i <= 90.0; i += 1.0) {
            if (this.field_70146_Z.nextInt(4) != 0) continue;
            Vec3 pos = this.func_174791_d().func_178787_e(dir.func_186678_a(i));
            this.field_70170_p.func_175688_a(this.counter < 35 ? ParticleInit.FLAME_SMALL : ParticleInit.SPECTRAL, pos.field_72450_a, pos.field_72448_b + 0.4, pos.field_72449_c, (this.field_70146_Z.nextDouble() - 0.5) * 0.2, (this.field_70146_Z.nextDouble() - 0.5) * 0.2, (this.field_70146_Z.nextDouble() - 0.5) * 0.2, new int[0]);
        }
    }

    public double getDist() {
        return 90.0;
    }

    protected void func_70037_a(CompoundTag compound) {
    }

    protected void func_70014_b(CompoundTag compound) {
    }

    private void setCharging(boolean charging) {
        if (this.wasCharging == charging) {
            return;
        }
        this.wasCharging = charging;
        this.field_70180_af.func_187227_b(CHARGING, (Object)this.wasCharging);
    }
}

