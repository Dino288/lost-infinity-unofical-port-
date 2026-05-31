/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.Mob
 *  net.minecraft.entity.ai.EntityMoveHelper
 *  net.minecraft.entity.ai.EntityMoveHelper$Action
 *  net.minecraft.util.math.AABB
 *  net.minecraft.util.math.Mth
 */
package xol.lostinfinity.mob.ai;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.Mob;
import net.minecraft.entity.ai.EntityMoveHelper;
import net.minecraft.world.phys.AABB;
import net.minecraft.util.Mth;

public class FloatMoveHelper
extends EntityMoveHelper {
    private final Mob parentEntity;
    private int courseChangeCooldown;

    public FloatMoveHelper(Mob ghast) {
        super(ghast);
        this.parentEntity = ghast;
    }

    public void func_75641_c() {
        if (this.field_188491_h == EntityMoveHelper.Action.MOVE_TO) {
            double d0 = this.field_75646_b - this.parentEntity.field_70165_t;
            double d1 = this.field_75647_c - this.parentEntity.field_70163_u;
            double d2 = this.field_75644_d - this.parentEntity.field_70161_v;
            double d3 = d0 * d0 + d1 * d1 + d2 * d2;
            if (this.courseChangeCooldown-- <= 0) {
                this.courseChangeCooldown += this.parentEntity.func_70681_au().nextInt(5) + 2;
                if (this.isNotColliding(this.field_75646_b, this.field_75647_c, this.field_75644_d, d3 = (double)Mth.func_76133_a((double)d3))) {
                    this.parentEntity.field_70159_w += d0 / d3 * 0.1;
                    this.parentEntity.field_70181_x += d1 / d3 * 0.1;
                    this.parentEntity.field_70179_y += d2 / d3 * 0.1;
                } else {
                    this.field_188491_h = EntityMoveHelper.Action.WAIT;
                }
            }
        }
    }

    private boolean isNotColliding(double x, double y, double z, double p_179926_7_) {
        double d0 = (x - this.parentEntity.field_70165_t) / p_179926_7_;
        double d1 = (y - this.parentEntity.field_70163_u) / p_179926_7_;
        double d2 = (z - this.parentEntity.field_70161_v) / p_179926_7_;
        AABB axisalignedbb = this.parentEntity.func_174813_aQ();
        int i = 1;
        while ((double)i < p_179926_7_) {
            if (!this.parentEntity.field_70170_p.func_184144_a((Entity)this.parentEntity, axisalignedbb = axisalignedbb.func_72317_d(d0, d1, d2)).isEmpty()) {
                return false;
            }
            ++i;
        }
        return true;
    }
}

