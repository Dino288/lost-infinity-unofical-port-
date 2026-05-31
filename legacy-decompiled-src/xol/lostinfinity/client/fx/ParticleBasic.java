/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.particle.IParticleFactory
 *  net.minecraft.client.particle.Particle
 *  net.minecraft.client.renderer.texture.TextureAtlasSprite
 *  net.minecraft.world.World
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package xol.lostinfinity.client.fx;

import net.minecraft.client.particle.IParticleFactory;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xol.lostinfinity.client.fx.LostParticle;

public class ParticleBasic
extends LostParticle {
    protected ParticleBasic(Level worldIn, double xPos, double yPos, double zPos, double xSpeed, double ySpeed, double zSpeed) {
        super(worldIn, xPos, yPos, zPos, xSpeed, ySpeed, zSpeed);
        this.field_70547_e = (int)(8.0 / (Math.random() * 0.8 + 0.2));
    }

    public ParticleBasic setTexture(TextureAtlasSprite sprite) {
        this.func_187117_a(sprite);
        return this;
    }

    public boolean func_187111_c() {
        return true;
    }

    @Override
    public void func_189213_a() {
        super.func_189213_a();
        if (this.field_70546_d++ >= this.field_70547_e) {
            this.func_187112_i();
        }
        this.func_187110_a(this.field_187129_i, this.field_187130_j, this.field_187131_k);
    }

    public int func_70537_b() {
        return 1;
    }

    @SideOnly(value=Side.CLIENT)
    public static class BaseParticleFactory
    implements IParticleFactory {
        public Particle func_178902_a(int particleID, Level worldIn, double xCoordIn, double yCoordIn, double zCoordIn, double xSpeedIn, double ySpeedIn, double zSpeedIn, int ... p_178902_15_) {
            ParticleBasic particle = new ParticleBasic(worldIn, xCoordIn, yCoordIn, zCoordIn, xSpeedIn, ySpeedIn, zSpeedIn);
            particle.func_187114_a(20);
            return particle;
        }
    }
}

