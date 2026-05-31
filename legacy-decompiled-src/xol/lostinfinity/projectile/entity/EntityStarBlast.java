/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.util.math.HitResult
 *  net.minecraft.world.World
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package xol.lostinfinity.projectile.entity;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xol.lostinfinity.init.ParticleInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.projectile.entity.EntityBaseThrowable;
import xol.lostinfinity.util.data.CustomParticleConfig;
import xol.lostinfinity.util.data.IMaxAttack;
import xol.lostinfinity.util.fx.IParticleSpawner;

public class EntityStarBlast
extends EntityBaseThrowable {
    public EntityStarBlast(Level par1World) {
        super(par1World);
        this.func_70105_a(0.75f, 0.75f);
    }

    public EntityStarBlast(Level par1World, LivingEntity par2Mob) {
        super(par1World, par2Mob);
        this.func_70105_a(0.75f, 0.75f);
    }

    @Override
    protected void func_70184_a(HitResult result) {
        if (!this.field_70170_p.field_72995_K) {
            if (this.func_85052_h() != null) {
                for (LivingEntity target : this.field_70170_p.func_72872_a(LivingEntity.class, this.func_174813_aQ().func_186662_g(14.0))) {
                    if (target.func_110124_au().equals(this.func_85052_h().func_110124_au())) continue;
                    IMaxAttack.dealMaxHealth((Entity)this, target, 4, 3.0f);
                }
                float angle = 0.0f;
                while ((double)angle <= Math.PI * 2) {
                    double velocity_x = 14.0 * Math.cos(angle);
                    double velocity_z = 14.0 * Math.sin(angle);
                    CustomParticleConfig config1 = new CustomParticleConfig();
                    config1.createInstance().setParticle(ParticleInit.FLAME_LARGE).setSpread(1.0, 0.0, 1.0).setSpeed(0.3, 0.0, 0.3).setVelSpread(1.0, 0.0, 1.0).setCount(9).setIgnoreRange(true);
                    IParticleSpawner.spawnParticle(this.field_70170_p, config1, this.field_70165_t + velocity_x / 2.0, this.field_70163_u, this.field_70161_v + velocity_z / 2.0);
                    angle = (float)((double)angle + 0.39269908169872414);
                }
                this.func_184185_a(SoundInit.GENERIC_WEAPON_10, 1.0f, 1.0f);
            }
            this.func_70106_y();
        }
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void func_70071_h_() {
        super.func_70071_h_();
        if (this.field_70170_p.field_72995_K) {
            for (int k = 0; k < 3; ++k) {
                this.field_70170_p.func_175688_a(ParticleInit.GOLD_STAR, this.field_70165_t + (this.field_70146_Z.nextDouble() - 0.5) * (double)this.field_70130_N, this.field_70163_u + this.field_70146_Z.nextDouble() * (double)this.field_70131_O - 0.25, this.field_70161_v + (this.field_70146_Z.nextDouble() - 0.5) * (double)this.field_70130_N, (this.field_70146_Z.nextDouble() - 0.5) * 2.0, -this.field_70146_Z.nextDouble(), (this.field_70146_Z.nextDouble() - 0.5) * 2.0, new int[0]);
            }
            if (this.field_70128_L) {
                // empty if block
            }
        }
    }

    protected float func_70185_h() {
        return 0.0f;
    }
}

