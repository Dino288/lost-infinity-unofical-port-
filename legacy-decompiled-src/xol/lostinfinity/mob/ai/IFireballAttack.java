/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nonnull
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.util.math.Vec3
 *  net.minecraft.world.World
 */
package xol.lostinfinity.mob.ai;

import javax.annotation.Nonnull;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.Level;

@FunctionalInterface
public interface IFireballAttack {
    @Nonnull
    public Entity createFireball(Level var1, LivingEntity var2, double var3, double var5, double var7, int var9);

    default public Entity createFireball(LivingEntity parent, Entity target) {
        Vec3 vec3d = parent.func_70676_i(1.0f);
        double d2 = target.field_70165_t - (parent.field_70165_t + vec3d.field_72450_a * 4.0);
        double d3 = target.func_174813_aQ().field_72338_b + (double)(target.field_70131_O / 2.0f) - (0.5 + parent.field_70163_u + (double)(parent.field_70131_O / 2.0f));
        double d4 = target.field_70161_v - (parent.field_70161_v + vec3d.field_72449_c * 4.0);
        Entity fireball = this.createFireball(parent.field_70170_p, parent, d2, d3, d4, parent.func_70681_au().nextInt(6));
        fireball.field_70165_t = parent.field_70165_t + vec3d.field_72450_a * 4.0;
        fireball.field_70163_u = parent.field_70163_u + (double)(parent.field_70131_O / 2.0f) + 0.5;
        fireball.field_70161_v = parent.field_70161_v + vec3d.field_72449_c * 4.0;
        return fireball;
    }
}

