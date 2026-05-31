/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.util.EnumParticleTypes
 *  net.minecraft.util.math.HitResult
 *  net.minecraft.world.World
 */
package xol.lostinfinity.projectile.entity;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.level.Level;
import xol.lostinfinity.projectile.entity.EntityBaseThrowable;
import xol.lostinfinity.util.data.IMaxAttack;

public class EntitySkyStrike
extends EntityBaseThrowable {
    private int multiplier = 1;
    private LivingEntity followTarget = null;

    public EntitySkyStrike(Level par1World) {
        super(par1World);
        this.func_70105_a(1.0f, 1.0f);
    }

    public EntitySkyStrike(Level par1World, double par2, double par4, double par6) {
        super(par1World, par2, par4, par6);
        this.func_70105_a(1.0f, 1.0f);
    }

    public void setDamageMultiplierAndTarget(int mult, LivingEntity target) {
        this.multiplier = mult;
        this.followTarget = target;
    }

    @Override
    protected void func_70184_a(HitResult result) {
        if (!this.field_70170_p.field_72995_K) {
            for (LivingEntity target : this.field_70170_p.func_72872_a(LivingEntity.class, this.func_174813_aQ().func_72314_b(4.0, 4.0, 4.0))) {
                IMaxAttack.dealMaxHealth((Entity)this, target, 5, this.multiplier);
            }
            this.field_70170_p.func_72876_a((Entity)this, this.field_70165_t, this.field_70163_u, this.field_70161_v, 4.0f, false);
            this.func_70106_y();
        }
    }

    protected float func_70185_h() {
        return 0.05f;
    }

    @Override
    public void func_70071_h_() {
        super.func_70071_h_();
        if (this.field_70170_p.field_72995_K) {
            for (int i = 0; i < 3; ++i) {
                this.field_70170_p.func_175688_a(EnumParticleTypes.SPELL_INSTANT, this.field_70165_t + (this.field_70146_Z.nextDouble() - 0.5) * (double)this.field_70130_N, this.field_70163_u + this.field_70146_Z.nextDouble() * (double)this.field_70131_O - 0.25, this.field_70161_v + (this.field_70146_Z.nextDouble() - 0.5) * (double)this.field_70130_N, 0.0, 0.0, 0.0, new int[0]);
            }
        } else if (this.followTarget != null) {
            if (this.followTarget.field_70165_t > this.field_70165_t) {
                this.field_70159_w = 1.0;
            } else if (this.followTarget.field_70165_t < this.field_70165_t) {
                this.field_70159_w = -1.0;
            }
            if (this.followTarget.field_70161_v > this.field_70161_v) {
                this.field_70179_y = 1.0;
            } else if (this.followTarget.field_70161_v < this.field_70161_v) {
                this.field_70179_y = -1.0;
            }
        }
    }
}

