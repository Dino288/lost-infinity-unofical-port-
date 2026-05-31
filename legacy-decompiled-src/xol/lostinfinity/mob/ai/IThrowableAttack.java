/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.projectile.EntityThrowable
 *  net.minecraft.util.math.Mth
 *  net.minecraft.world.World
 */
package xol.lostinfinity.mob.ai;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.Mth;
import net.minecraft.world.level.Level;

@FunctionalInterface
public interface IThrowableAttack {
    public EntityThrowable createThowable(Level var1, LivingEntity var2, double var3, double var5, double var7);

    default public float getVelocity() {
        return 1.6f;
    }

    default public float getInaccuracy(Level world) {
        return 3 - world.func_175659_aa().func_151525_a();
    }

    default public Entity createFireball(LivingEntity parent, Entity target) {
        EntityThrowable fireball = this.createThowable(parent.field_70170_p, parent, parent.field_70165_t, parent.field_70163_u, parent.field_70161_v);
        double d0 = target.field_70163_u + (double)target.func_70047_e() - (double)1.1f;
        double d1 = target.field_70165_t - parent.field_70165_t;
        double d2 = d0 - fireball.field_70163_u;
        double d3 = target.field_70161_v - parent.field_70161_v;
        float f = Mth.func_76133_a((double)(d1 * d1 + d3 * d3)) * 0.2f;
        fireball.func_70186_c(d1, d2 + (double)f, d3, this.getVelocity(), this.getInaccuracy(parent.field_70170_p));
        return fireball;
    }
}

