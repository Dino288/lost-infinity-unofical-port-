/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.util.math.HitResult
 *  net.minecraft.util.math.HitResult$Type
 *  net.minecraft.world.World
 */
package xol.lostinfinity.projectile.entity;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.level.Level;
import xol.lostinfinity.projectile.entity.EntityBaseThrowable;

public class EntityBallOfContainedGluons
extends EntityBaseThrowable {
    public EntityBallOfContainedGluons(Level par1World) {
        super(par1World);
    }

    public EntityBallOfContainedGluons(Level par1World, LivingEntity par2Mob) {
        super(par1World, par2Mob);
    }

    public EntityBallOfContainedGluons(Level par1World, double par2, double par4, double par6) {
        super(par1World, par2, par4, par6);
    }

    protected float func_70185_h() {
        return 0.05f;
    }

    @Override
    protected void func_70184_a(HitResult result) {
        if (!this.field_70170_p.field_72995_K && result.field_72313_a == HitResult.Type.BLOCK) {
            this.func_70106_y();
        }
    }
}

