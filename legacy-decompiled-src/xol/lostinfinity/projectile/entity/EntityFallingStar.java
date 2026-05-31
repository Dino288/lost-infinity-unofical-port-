/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.util.EnumParticleTypes
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.HitResult
 *  net.minecraft.world.World
 */
package xol.lostinfinity.projectile.entity;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.level.Level;
import xol.lostinfinity.projectile.entity.EntityBaseThrowable;
import xol.lostinfinity.util.data.IMaxAttack;

public class EntityFallingStar
extends EntityBaseThrowable {
    private int count = 0;
    private BlockPos starting;

    public EntityFallingStar(Level par1World) {
        super(par1World);
        this.func_70105_a(1.0f, 1.0f);
    }

    public EntityFallingStar(Level par1World, LivingEntity par2Mob) {
        super(par1World, par2Mob);
    }

    public EntityFallingStar(Level par1World, double par2, double par4, double par6) {
        super(par1World, par2, par4, par6);
    }

    public void setCount(int newc) {
        this.count = newc;
    }

    public void setStartLoc(double sx, double sy, double sz) {
        this.starting = new BlockPos(sx, sy, sz);
    }

    @Override
    protected void func_70184_a(HitResult result) {
        if (!this.field_70170_p.field_72995_K) {
            if (result.field_72308_g != null && result.field_72308_g instanceof LivingEntity) {
                IMaxAttack.dealMaxHealth((Entity)this, (LivingEntity)result.field_72308_g, 3);
            }
            this.func_70106_y();
        }
    }

    protected float func_70185_h() {
        return 0.010000001f;
    }

    @Override
    public void func_70071_h_() {
        super.func_70071_h_();
        if (this.field_70170_p.field_72995_K) {
            this.field_70170_p.func_175688_a(EnumParticleTypes.CRIT, this.field_70165_t + (this.field_70146_Z.nextDouble() - 0.5) * (double)this.field_70130_N, this.field_70163_u + this.field_70146_Z.nextDouble() * (double)this.field_70131_O - 0.25, this.field_70161_v + (this.field_70146_Z.nextDouble() - 0.5) * (double)this.field_70130_N, (this.field_70146_Z.nextDouble() - 0.5) * 2.0, -this.field_70146_Z.nextDouble(), (this.field_70146_Z.nextDouble() - 0.5) * 2.0, new int[0]);
        } else if (this.field_70173_aa == 2 && this.count < 49 && this.starting != null) {
            EntityFallingStar star = new EntityFallingStar(this.field_70170_p);
            star.func_70107_b(this.starting.func_177958_n(), this.starting.func_177956_o(), this.starting.func_177952_p());
            star.setStartLoc(this.starting.func_177958_n(), this.starting.func_177956_o(), this.starting.func_177952_p());
            star.setCount(this.count + 1);
            star.func_70186_c((this.field_70146_Z.nextDouble() - 0.5) * (double)0.1f, -0.1, (this.field_70146_Z.nextDouble() - 0.5) * (double)0.1f, 0.4f, 0.0f);
            star.setThrower(this.func_85052_h());
            this.field_70170_p.func_72838_d((Entity)star);
        }
    }
}

