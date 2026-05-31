/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.util.math.HitResult
 *  net.minecraft.util.math.HitResult$Type
 *  net.minecraft.world.World
 */
package xol.lostinfinity.projectile.entity;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.level.Level;
import xol.lostinfinity.projectile.entity.EntityBaseThrowable;
import xol.lostinfinity.util.data.IMaxAttack;

public class EntityDeviantEvokerBomb
extends EntityBaseThrowable {
    private boolean landed = false;
    private int timer = 0;

    public EntityDeviantEvokerBomb(Level par1World) {
        super(par1World);
    }

    public EntityDeviantEvokerBomb(Level par1World, LivingEntity par2Mob) {
        super(par1World, par2Mob);
    }

    public EntityDeviantEvokerBomb(Level par1World, double par2, double par4, double par6) {
        super(par1World, par2, par4, par6);
    }

    protected void func_70088_a() {
        super.func_70088_a();
    }

    @Override
    protected void func_70184_a(HitResult result) {
        if (!this.field_70170_p.field_72995_K && result.field_72313_a == HitResult.Type.BLOCK) {
            this.field_70159_w = 0.0;
            this.field_70181_x = 0.0;
            this.field_70179_y = 0.0;
            this.field_70133_I = true;
            this.landed = true;
            this.func_189654_d(true);
        }
    }

    public void func_70030_z() {
        super.func_70030_z();
        if (!this.field_70170_p.field_72995_K && this.landed) {
            if (this.timer < 40) {
                ++this.timer;
            } else {
                this.explode();
            }
        }
    }

    private void explode() {
        LivingEntity attacker = this.func_85052_h();
        this.field_70170_p.func_72876_a(null, this.field_70165_t, this.field_70163_u, this.field_70161_v, 4.0f, false);
        for (LivingEntity target : this.field_70170_p.func_72872_a(LivingEntity.class, this.func_174813_aQ().func_72314_b(4.0, 4.0, 4.0))) {
            if (attacker.func_110124_au().equals(target.func_110124_au())) continue;
            IMaxAttack.dealMaxHealth((Entity)this, target, 2);
        }
        this.func_70106_y();
    }

    protected float func_70185_h() {
        return 0.030000001f;
    }
}

