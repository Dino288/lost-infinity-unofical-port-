/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.util.math.HitResult
 *  net.minecraft.world.World
 */
package xol.lostinfinity.projectile.entity;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.level.Level;
import xol.lostinfinity.init.ParticleInit;
import xol.lostinfinity.projectile.entity.EntityBaseThrowable;
import xol.lostinfinity.util.data.IMaxAttack;

public class EntityGravityWarper
extends EntityBaseThrowable {
    public EntityGravityWarper(Level par1World) {
        super(par1World);
    }

    public EntityGravityWarper(Level par1World, LivingEntity par2Mob) {
        super(par1World, par2Mob);
    }

    public EntityGravityWarper(Level par1World, double par2, double par4, double par6) {
        super(par1World, par2, par4, par6);
    }

    @Override
    protected void func_70184_a(HitResult result) {
        if (!this.field_70170_p.field_72995_K) {
            this.func_70106_y();
        }
    }

    protected float func_70185_h() {
        return 0.0f;
    }

    @Override
    public void func_70071_h_() {
        block3: {
            block2: {
                super.func_70071_h_();
                if (!this.field_70170_p.field_72995_K) break block2;
                for (int i = 0; i < 3; ++i) {
                    this.field_70170_p.func_175682_a(ParticleInit.GRAVITY_RING, true, this.field_70165_t + this.getROD(1), this.field_70163_u + this.getROD(1), this.field_70161_v + this.getROD(1), 0.0, 0.0, 0.0, new int[0]);
                }
                break block3;
            }
            if (this.func_85052_h() == null) break block3;
            for (LivingEntity entity : this.field_70170_p.func_72872_a(LivingEntity.class, this.func_174813_aQ().func_72314_b(15.0, 15.0, 15.0))) {
                if (entity.func_110124_au().equals(this.func_85052_h().func_110124_au())) continue;
                entity.func_70024_g(Math.signum(this.field_70165_t - entity.field_70165_t) * 0.5, Math.signum(this.field_70163_u - entity.field_70163_u) * 0.6, Math.signum(this.field_70161_v - entity.field_70161_v) * 0.5);
                entity.field_70133_I = true;
                if (this.field_70173_aa % 5 != 0 || !(this.func_70032_d((Entity)entity) < 3.0f)) continue;
                IMaxAttack.dealMaxHealth((Entity)this.func_85052_h(), entity, 6);
            }
        }
    }
}

