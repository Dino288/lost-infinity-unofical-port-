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
import xol.lostinfinity.mob.entity.boss.EntityPuzzleMaster;
import xol.lostinfinity.projectile.entity.EntityBaseThrowable;
import xol.lostinfinity.util.data.IMaxAttack;

public class EntityPuzzleMasterArrow
extends EntityBaseThrowable {
    public EntityPuzzleMasterArrow(Level par1World) {
        super(par1World);
    }

    public EntityPuzzleMasterArrow(Level par1World, LivingEntity par2Mob) {
        super(par1World, par2Mob);
    }

    @Override
    protected void func_70184_a(HitResult result) {
        if (!this.field_70170_p.field_72995_K) {
            if (result.field_72308_g != null && this.func_85052_h() != null && result.field_72308_g != this.func_85052_h() && result.field_72308_g instanceof LivingEntity && !(result.field_72308_g instanceof EntityPuzzleMaster)) {
                IMaxAttack.dealTrueDamage((Entity)this, (LivingEntity)result.field_72308_g, ((LivingEntity)result.field_72308_g).func_110138_aP() * 0.95f);
            }
            this.func_70106_y();
        }
    }

    protected float func_70185_h() {
        return 0.0f;
    }
}

