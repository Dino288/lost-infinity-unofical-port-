/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.util.math.HitResult
 *  net.minecraft.util.math.Vec3
 *  net.minecraft.world.World
 */
package xol.lostinfinity.projectile.entity;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.Level;
import xol.lostinfinity.projectile.entity.EntityBaseThrowable;
import xol.lostinfinity.util.data.IMaxAttack;

public class EntityHomingBlight
extends EntityBaseThrowable {
    private LivingEntity target = null;

    public EntityHomingBlight(Level par1World) {
        super(par1World);
        this.func_70105_a(0.75f, 0.75f);
    }

    public EntityHomingBlight(Level par1World, LivingEntity par2Mob) {
        super(par1World, par2Mob);
        this.func_70105_a(0.75f, 0.75f);
    }

    public EntityHomingBlight(Level par1World, double par2, double par4, double par6) {
        super(par1World, par2, par4, par6);
        this.func_70105_a(0.75f, 0.75f);
    }

    @Override
    protected void func_70184_a(HitResult result) {
        if (!this.field_70170_p.field_72995_K) {
            if (result.field_72308_g != null && this.func_85052_h() != null && !result.field_72308_g.equals((Object)this.func_85052_h()) && result.field_72308_g instanceof LivingEntity) {
                IMaxAttack.dealMaxHealth((Entity)this, (LivingEntity)result.field_72308_g, 1);
            }
            this.func_70106_y();
        }
    }

    @Override
    public void func_70071_h_() {
        super.func_70071_h_();
        if (!this.field_70170_p.field_72995_K && this.target != null) {
            Vec3 dir = this.target.func_174791_d().func_178788_d(this.func_174791_d());
            dir = dir.func_72432_b();
            this.field_70159_w = dir.field_72450_a * 0.01;
            this.field_70181_x = dir.field_72448_b * 0.01;
            this.field_70179_y = dir.field_72449_c * 0.01;
            this.field_70133_I = true;
        }
    }

    public void setTarget(LivingEntity target) {
        this.target = target;
    }

    protected float func_70185_h() {
        return 0.0f;
    }
}

