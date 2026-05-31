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

import java.util.ArrayList;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.level.Level;
import xol.lostinfinity.projectile.entity.EntityBaseThrowable;
import xol.lostinfinity.util.data.IMaxAttack;

public class EntityZenonShot
extends EntityBaseThrowable
implements IMaxAttack {
    private static final float mult = 0.96f;
    private ArrayList<LivingEntity> entitiesHit = null;

    public EntityZenonShot(Level par1World) {
        super(par1World);
        this.func_189654_d(true);
    }

    public EntityZenonShot(Level par1World, LivingEntity par2Mob) {
        super(par1World, par2Mob);
        this.func_189654_d(true);
    }

    @Override
    protected void func_70184_a(HitResult result) {
        if (!this.field_70170_p.field_72995_K) {
            if (this.entitiesHit == null) {
                this.entitiesHit = new ArrayList();
            }
            if (result.field_72308_g != null && result.field_72308_g instanceof LivingEntity && this.field_70192_c != null) {
                LivingEntity target = (LivingEntity)result.field_72308_g;
                if (target.func_110124_au().equals(this.field_70192_c.func_110124_au())) {
                    this.func_70106_y();
                } else if (!this.entitiesHit.contains(target)) {
                    IMaxAttack.dealMaxHealth((Entity)this.field_70192_c, target, 3, 2.0f);
                    this.entitiesHit.add(target);
                }
            }
        }
    }

    public void clearHits() {
        if (this.entitiesHit != null) {
            this.entitiesHit.clear();
        }
    }

    protected float func_70185_h() {
        return 0.0f;
    }

    @Override
    public void func_70071_h_() {
        super.func_70071_h_();
        if (!this.field_70170_p.field_72995_K) {
            this.field_70159_w *= (double)0.96f;
            this.field_70181_x *= (double)0.96f;
            this.field_70179_y *= (double)0.96f;
            this.field_70133_I = true;
            if (this.field_70173_aa > 400) {
                this.func_70106_y();
            }
        }
    }
}

