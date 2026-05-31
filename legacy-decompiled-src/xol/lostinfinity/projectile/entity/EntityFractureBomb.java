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
import xol.lostinfinity.projectile.entity.EntityGenericBomb;
import xol.lostinfinity.util.data.IMaxAttack;

public class EntityFractureBomb
extends EntityBaseThrowable {
    public EntityFractureBomb(Level par1World) {
        super(par1World);
    }

    public EntityFractureBomb(Level par1World, LivingEntity par2Mob) {
        super(par1World, par2Mob);
    }

    public EntityFractureBomb(Level par1World, double par2, double par4, double par6) {
        super(par1World, par2, par4, par6);
    }

    @Override
    protected void func_70184_a(HitResult result) {
        if (!this.field_70170_p.field_72995_K) {
            if (this.func_85052_h() != null) {
                if (result.field_72308_g == null) {
                    double x0 = this.field_70165_t;
                    double y0 = this.field_70163_u + 0.5;
                    double z0 = this.field_70161_v;
                    double radius = 5.0;
                    float angle = 0.0f;
                    while ((double)angle <= Math.PI * 2) {
                        EntityGenericBomb shot = new EntityGenericBomb(this.field_70170_p);
                        shot.func_70107_b(x0, y0, z0);
                        double velocity_x = (double)0.06f * radius * Math.cos(angle);
                        double velocity_z = (double)0.06f * radius * Math.sin(angle);
                        shot.setThrower(this.func_85052_h());
                        shot.calculateVelocity(velocity_x, 0.8f, velocity_z);
                        this.field_70170_p.func_72838_d((Entity)shot);
                        angle = (float)((double)angle + 0.39269908169872414);
                    }
                    this.func_184185_a(SoundInit.GENERIC_WEAPON_6, 1.0f, 1.0f);
                } else if (result.field_72308_g instanceof LivingEntity) {
                    IMaxAttack.dealMaxHealth((Entity)this.func_85052_h(), (LivingEntity)result.field_72308_g, 4);
                }
            }
            this.func_70106_y();
        }
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void func_70071_h_() {
        super.func_70071_h_();
        if (this.field_70170_p.field_72995_K) {
            for (int k = 0; k < 2; ++k) {
                this.field_70170_p.func_175688_a(ParticleInit.CRESCENT_MOON, this.field_70165_t + (this.field_70146_Z.nextDouble() - 0.5) * (double)this.field_70130_N, this.field_70163_u + this.field_70146_Z.nextDouble() * (double)this.field_70131_O - 0.25, this.field_70161_v + (this.field_70146_Z.nextDouble() - 0.5) * (double)this.field_70130_N, (this.field_70146_Z.nextDouble() - 0.5) * 2.0, -this.field_70146_Z.nextDouble(), (this.field_70146_Z.nextDouble() - 0.5) * 2.0, new int[0]);
            }
        }
    }

    protected float func_70185_h() {
        return 0.05f;
    }
}

