/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.projectile.EntityThrowable
 *  net.minecraft.util.math.Mth
 *  net.minecraft.util.math.HitResult
 *  net.minecraft.world.World
 */
package xol.lostinfinity.projectile.entity;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.Mth;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.level.Level;
import xol.lostinfinity.util.data.IMaxAttack;

public class EntityBaseThrowable
extends EntityThrowable
implements IMaxAttack {
    private LivingEntity secondarThrower;

    public EntityBaseThrowable(Level worldIn) {
        super(worldIn);
    }

    public EntityBaseThrowable(Level worldIn, LivingEntity entityIn) {
        super(worldIn, entityIn);
    }

    public EntityBaseThrowable(Level worldIn, double x, double y, double z) {
        super(worldIn, x, y, z);
    }

    public EntityBaseThrowable(Level par1World, LivingEntity thrower, double par2, double par4, double par6, float speedMulti) {
        super(par1World, par2, par4, par6);
        this.func_70105_a(0.75f, 0.75f);
        this.setThrower(thrower);
        this.calculateTrajectory(thrower, par2, par4, par6, speedMulti);
    }

    public void setThrower(LivingEntity throwset) {
        this.field_70192_c = throwset;
    }

    public void setSecondaryThrower(LivingEntity entity) {
        this.secondarThrower = entity;
    }

    public LivingEntity getSecondaryThrower() {
        return this.secondarThrower;
    }

    protected void calculateTrajectory(LivingEntity shooter, double accelX, double accelY, double accelZ, float speedMulti) {
        this.func_70012_b(shooter.field_70165_t, shooter.field_70163_u, shooter.field_70161_v, shooter.field_70177_z, shooter.field_70125_A);
        this.func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
        this.field_70159_w = 0.0;
        this.field_70181_x = 0.0;
        this.field_70179_y = 0.0;
        double d0 = Mth.func_76133_a((double)((accelX += this.field_70146_Z.nextGaussian() * 0.4) * accelX + (accelY += this.field_70146_Z.nextGaussian() * 0.4) * accelY + (accelZ += this.field_70146_Z.nextGaussian() * 0.4) * accelZ));
        this.field_70159_w = (double)speedMulti * accelX / d0 * 0.1;
        this.field_70181_x = (double)speedMulti * accelY / d0 * 0.1;
        this.field_70179_y = (double)speedMulti * accelZ / d0 * 0.1;
        this.field_70133_I = true;
    }

    protected void func_70184_a(HitResult result) {
        this.func_70106_y();
    }

    public void func_70071_h_() {
        super.func_70071_h_();
        if (this.field_70173_aa == 300 && this.willDespawn()) {
            this.func_70106_y();
        }
    }

    protected boolean willDespawn() {
        return true;
    }

    public void calculateVelocity(double x, double y, double z) {
        this.field_70159_w = x;
        this.field_70181_x = y;
        this.field_70179_y = z;
        if (this.field_70127_C == 0.0f && this.field_70126_B == 0.0f) {
            float f = Mth.func_76133_a((double)(x * x + z * z));
            this.field_70177_z = (float)(Mth.func_181159_b((double)x, (double)z) * 57.29577951308232);
            this.field_70125_A = (float)(Mth.func_181159_b((double)y, (double)f) * 57.29577951308232);
            this.field_70126_B = this.field_70177_z;
            this.field_70127_C = this.field_70125_A;
        }
    }

    public void shootNoVel(Entity entityThrower, float rotationPitchIn, float rotationYawIn, float pitchOffset, float velocity, float inaccuracy) {
        float f = -Mth.func_76126_a((float)(rotationYawIn * ((float)Math.PI / 180))) * Mth.func_76134_b((float)(rotationPitchIn * ((float)Math.PI / 180)));
        float f1 = -Mth.func_76126_a((float)((rotationPitchIn + pitchOffset) * ((float)Math.PI / 180)));
        float f2 = Mth.func_76134_b((float)(rotationYawIn * ((float)Math.PI / 180))) * Mth.func_76134_b((float)(rotationPitchIn * ((float)Math.PI / 180)));
        this.func_70186_c(f, f1, f2, velocity, inaccuracy);
    }

    protected double getROD(int multi) {
        return (-0.5 + this.field_70146_Z.nextDouble()) * (double)multi;
    }
}

