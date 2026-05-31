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

public class EntityCelestialFire
extends EntityBaseThrowable {
    public EntityCelestialFire(Level par1World) {
        super(par1World);
        this.func_70105_a(0.75f, 0.75f);
    }

    public EntityCelestialFire(Level par1World, LivingEntity par2Mob) {
        super(par1World, par2Mob);
    }

    public EntityCelestialFire(Level par1World, double par2, double par4, double par6) {
        super(par1World, par2, par4, par6);
    }

    @Override
    protected void func_70184_a(HitResult result) {
        if (!this.field_70170_p.field_72995_K) {
            if (result.field_72308_g != null && this.func_85052_h() != null && result.field_72308_g != this.func_85052_h() && result.field_72308_g instanceof LivingEntity) {
                IMaxAttack.dealMaxHealth((Entity)this, (LivingEntity)result.field_72308_g, 2);
            }
            this.func_70106_y();
        } else if (this.field_70173_aa > 4) {
            this.field_70170_p.func_175688_a(EnumParticleTypes.LAVA, this.field_70165_t, this.field_70163_u, this.field_70161_v, (this.field_70170_p.field_73012_v.nextDouble() - 0.5) * 2.0, -this.field_70170_p.field_73012_v.nextDouble(), (this.field_70170_p.field_73012_v.nextDouble() - 0.5) * 2.0, new int[0]);
        }
    }

    protected float func_70185_h() {
        return 0.05f;
    }
}

