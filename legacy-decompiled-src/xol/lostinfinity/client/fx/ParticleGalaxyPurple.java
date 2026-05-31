/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.client.particle.IParticleFactory
 *  net.minecraft.client.particle.Particle
 *  net.minecraft.world.World
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package xol.lostinfinity.client.fx;

import java.util.Random;
import javax.annotation.Nullable;
import net.minecraft.client.particle.IParticleFactory;
import net.minecraft.client.particle.Particle;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xol.lostinfinity.client.fx.LostParticle;
import xol.lostinfinity.init.ParticleInit;

public class ParticleGalaxyPurple
extends LostParticle {
    private static final Random RANDOM = new Random();

    protected ParticleGalaxyPurple(Level worldIn, double xCoordIn, double yCoordIn, double zCoordIn, double xSpeedIn, double ySpeed, double zSpeedIn) {
        super(worldIn, xCoordIn, yCoordIn, zCoordIn, 0.5 - RANDOM.nextDouble(), ySpeed, 0.5 - RANDOM.nextDouble());
        this.field_187130_j *= (double)0.2f;
        if (xSpeedIn == 0.0 && zSpeedIn == 0.0) {
            this.field_187129_i *= (double)0.1f;
            this.field_187131_k *= (double)0.1f;
        }
        this.scale = RANDOM.nextFloat();
        this.field_70547_e = (int)(14.0 / (Math.random() * 0.8 + 0.2));
        this.func_187117_a(ParticleInit.GALAXY_PURPLE_SPRITE);
    }

    public ParticleGalaxyPurple setParticleGravity(double motionY) {
        this.field_187130_j = motionY;
        return this;
    }

    public boolean func_187111_c() {
        return true;
    }

    @Override
    public void func_189213_a() {
        this.updatePos();
        this.updateAngle();
        if (this.field_70547_e - this.field_70546_d < 8) {
            if ((double)this.scale > 0.5) {
                this.prevScale = this.scale;
                this.scale = (float)((double)this.scale - 0.5);
            }
        } else if (this.scale < 3.0f) {
            this.prevScale = this.scale;
            this.scale = (float)((double)this.scale + 0.2);
        } else {
            this.prevScale = this.scale;
        }
        if (this.field_70546_d++ >= this.field_70547_e) {
            this.func_187112_i();
        }
        this.field_187130_j += 0.002;
        this.func_187110_a(this.field_187129_i, this.field_187130_j, this.field_187131_k);
        if (this.field_187127_g == this.field_187124_d) {
            this.field_187129_i *= 1.1;
            this.field_187131_k *= 1.1;
        }
        this.field_187129_i *= (double)0.96f;
        this.field_187130_j *= (double)0.96f;
        this.field_187131_k *= (double)0.96f;
        if (this.field_187132_l) {
            this.field_187129_i *= (double)0.7f;
            this.field_187131_k *= (double)0.7f;
        }
    }

    public int func_70537_b() {
        return 1;
    }

    @SideOnly(value=Side.CLIENT)
    public static class Factory
    implements IParticleFactory {
        @Nullable
        public Particle func_178902_a(int particleID, Level world, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed, int ... p_178902_15_) {
            return new ParticleGalaxyPurple(world, x, y, z, xSpeed, ySpeed, zSpeed);
        }
    }
}

