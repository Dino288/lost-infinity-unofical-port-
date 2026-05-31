/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.particle.Particle
 *  net.minecraft.client.renderer.BufferBuilder
 *  net.minecraft.entity.Entity
 *  net.minecraft.util.math.Mth
 *  net.minecraft.world.World
 */
package xol.lostinfinity.client.fx;

import net.minecraft.client.particle.Particle;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;
import net.minecraft.world.level.Level;

public abstract class LostParticle
extends Particle {
    protected float growSpeed;
    protected float rotateSpeed;
    protected float scale;
    protected float prevScale;

    public LostParticle(Level worldIn, double xCoordIn, double yCoordIn, double zCoordIn, double xSpeedIn, double ySpeedIn, double zSpeedIn) {
        super(worldIn, xCoordIn, yCoordIn, zCoordIn, xSpeedIn, ySpeedIn, zSpeedIn);
    }

    public void func_189213_a() {
        this.updatePos();
        this.updateScale();
        this.updateAngle();
    }

    protected void updatePos() {
        this.field_187123_c = this.field_187126_f;
        this.field_187124_d = this.field_187127_g;
        this.field_187125_e = this.field_187128_h;
    }

    protected void updateScale() {
        this.prevScale = this.scale;
        this.scale += this.growSpeed;
    }

    protected void updateAngle() {
        this.field_190015_G = this.field_190014_F;
        this.field_190014_F += this.rotateSpeed;
    }

    public void func_180434_a(BufferBuilder buffer, Entity entityIn, float partialTicks, float rotationX, float rotationZ, float rotationYZ, float rotationXY, float rotationXZ) {
        this.field_70544_f = (float)Mth.func_151238_b((double)this.prevScale, (double)this.scale, (double)partialTicks);
        super.func_180434_a(buffer, entityIn, partialTicks, rotationX, rotationZ, rotationYZ, rotationXY, rotationXZ);
    }
}

