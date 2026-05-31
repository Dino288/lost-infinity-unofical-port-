/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.init.SoundEvents
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.util.EnumParticleTypes
 *  net.minecraft.world.World
 *  net.minecraft.world.ServerLevel
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package xol.lostinfinity.projectile.entity;

import java.util.UUID;
import javax.annotation.Nullable;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.level.Level;
import net.minecraft.server.level.ServerLevel;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xol.lostinfinity.util.data.IMaxAttack;

public class EntityDeviantEvokerFangs
extends Entity
implements IMaxAttack {
    private int warmupDelayTicks;
    private boolean sentSpikeEvent;
    private int lifeTicks = 22;
    private boolean clientSideAttackStarted;
    private LivingEntity caster;
    private UUID casterUuid;

    public EntityDeviantEvokerFangs(Level worldIn) {
        super(worldIn);
        this.func_70105_a(0.5f, 0.8f);
    }

    public EntityDeviantEvokerFangs(Level worldIn, double x, double y, double z, float yaw, int warmupTicks, LivingEntity casterIn) {
        this(worldIn);
        this.warmupDelayTicks = warmupTicks;
        this.setCaster(casterIn);
        this.field_70177_z = yaw * 57.295776f;
        this.func_70107_b(x, y, z);
    }

    protected void func_70088_a() {
    }

    public void setCaster(@Nullable LivingEntity caster) {
        this.caster = caster;
        this.casterUuid = caster == null ? null : caster.func_110124_au();
    }

    @Nullable
    public LivingEntity getCaster() {
        Entity entity;
        if (this.caster == null && this.casterUuid != null && this.field_70170_p instanceof ServerLevel && (entity = ((ServerLevel)this.field_70170_p).func_175733_a(this.casterUuid)) instanceof LivingEntity) {
            this.caster = (LivingEntity)entity;
        }
        return this.caster;
    }

    protected void func_70037_a(CompoundTag compound) {
        this.warmupDelayTicks = compound.func_74762_e("Warmup");
        this.casterUuid = compound.func_186857_a("OwnerUUID");
    }

    protected void func_70014_b(CompoundTag compound) {
        compound.func_74768_a("Warmup", this.warmupDelayTicks);
        if (this.casterUuid != null) {
            compound.func_186854_a("OwnerUUID", this.casterUuid);
        }
    }

    public void func_70071_h_() {
        super.func_70071_h_();
        if (this.field_70170_p.field_72995_K) {
            if (this.clientSideAttackStarted) {
                --this.lifeTicks;
                if (this.lifeTicks == 14) {
                    for (int i = 0; i < 12; ++i) {
                        double d0 = this.field_70165_t + (this.field_70146_Z.nextDouble() * 2.0 - 1.0) * (double)this.field_70130_N * 0.5;
                        double d1 = this.field_70163_u + 0.05 + this.field_70146_Z.nextDouble() * 1.0;
                        double d2 = this.field_70161_v + (this.field_70146_Z.nextDouble() * 2.0 - 1.0) * (double)this.field_70130_N * 0.5;
                        double d3 = (this.field_70146_Z.nextDouble() * 2.0 - 1.0) * 0.3;
                        double d4 = 0.3 + this.field_70146_Z.nextDouble() * 0.3;
                        double d5 = (this.field_70146_Z.nextDouble() * 2.0 - 1.0) * 0.3;
                        this.field_70170_p.func_175688_a(EnumParticleTypes.CRIT, d0, d1 + 1.0, d2, d3, d4, d5, new int[0]);
                    }
                }
            }
        } else if (--this.warmupDelayTicks < 0) {
            if (this.warmupDelayTicks == -8) {
                for (LivingEntity entitylivingbase : this.field_70170_p.func_72872_a(LivingEntity.class, this.func_174813_aQ().func_72314_b(0.2, 0.0, 0.2))) {
                    this.damage(entitylivingbase);
                }
            }
            if (!this.sentSpikeEvent) {
                this.field_70170_p.func_72960_a((Entity)this, (byte)4);
                this.sentSpikeEvent = true;
            }
            if (--this.lifeTicks < 0) {
                this.func_70106_y();
            }
        }
    }

    private void damage(LivingEntity target) {
        LivingEntity entitylivingbase = this.getCaster();
        if (target.func_70089_S() && !target.func_190530_aW() && target != entitylivingbase) {
            if (entitylivingbase == null) {
                IMaxAttack.dealMaxHealth(this, target, 1);
            } else {
                if (entitylivingbase.func_184191_r((Entity)target)) {
                    return;
                }
                IMaxAttack.dealMaxHealth((Entity)entitylivingbase, target, 1);
            }
        }
    }

    @SideOnly(value=Side.CLIENT)
    public void func_70103_a(byte id) {
        super.func_70103_a(id);
        if (id == 4) {
            this.clientSideAttackStarted = true;
            if (!this.func_174814_R()) {
                this.field_70170_p.func_184134_a(this.field_70165_t, this.field_70163_u, this.field_70161_v, SoundEvents.field_191242_bl, this.func_184176_by(), 1.0f, this.field_70146_Z.nextFloat() * 0.2f + 0.85f, false);
            }
        }
    }

    @SideOnly(value=Side.CLIENT)
    public float getAnimationProgress(float partialTicks) {
        if (!this.clientSideAttackStarted) {
            return 0.0f;
        }
        int i = this.lifeTicks - 2;
        return i <= 0 ? 1.0f : 1.0f - ((float)i - partialTicks) / 20.0f;
    }
}

