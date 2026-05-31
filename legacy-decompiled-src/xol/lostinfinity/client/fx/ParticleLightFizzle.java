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

public class ParticleLightFizzle
extends LostParticle {
    private static final Random RANDOM = new Random();

    protected ParticleLightFizzle(Level worldIn, double xCoordIn, double yCoordIn, double zCoordIn, double xSpeedIn, double ySpeed, double zSpeedIn) {
        super(worldIn, xCoordIn, yCoordIn, zCoordIn, 0.5 - RANDOM.nextDouble(), ySpeed, 0.5 - RANDOM.nextDouble());
        this.field_187130_j *= 0.0;
        this.field_187129_i *= (double)0.1f;
        this.field_187131_k *= (double)0.1f;
        this.scale = 4.5f + 2.0f * this.field_187136_p.nextFloat();
        this.field_82339_as = 0.0f;
        this.field_70547_e = (int)(14.0 / (Math.random() * 0.8 + 0.2));
        this.func_187117_a(ParticleInit.LIGHT_FIZZLE_SPRITE);
    }

    public ParticleLightFizzle setParticleGravity(double motionY) {
        this.field_187130_j = motionY;
        return this;
    }

    public boolean func_187111_c() {
        return true;
    }

    @Override
    public void func_189213_a() {
        super.func_189213_a();
        if (this.field_70546_d < 20) {
            if (this.field_82339_as < 1.0f) {
                this.field_82339_as += 0.2f;
            }
        } else if (this.field_82339_as > 0.0f) {
            this.field_82339_as -= 0.1f;
        } else {
            this.func_187112_i();
        }
        ++this.field_70546_d;
        this.func_187110_a(this.field_187129_i, this.field_187130_j, this.field_187131_k);
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
            return new ParticleLightFizzle(world, x, y, z, xSpeed, ySpeed, zSpeed);
        }
    }
}

