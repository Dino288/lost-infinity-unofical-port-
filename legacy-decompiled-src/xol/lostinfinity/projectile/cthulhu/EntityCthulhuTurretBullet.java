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
package xol.lostinfinity.projectile.cthulhu;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.level.Level;
import xol.lostinfinity.mob.entity.cthulhu.ICthulhuMinion;
import xol.lostinfinity.projectile.entity.EntityBaseThrowable;
import xol.lostinfinity.util.data.IMaxAttack;

public class EntityCthulhuTurretBullet
extends EntityBaseThrowable {
    public EntityCthulhuTurretBullet(Level worldIn) {
        super(worldIn);
    }

    @Override
    protected void func_70184_a(HitResult result) {
        if (result.field_72313_a != HitResult.Type.ENTITY) {
            return;
        }
        if (result.field_72308_g == this.field_70192_c || result.field_72308_g == this.getSecondaryThrower()) {
            return;
        }
        if (result.field_72308_g instanceof LivingEntity && !(result.field_72308_g instanceof ICthulhuMinion)) {
            LivingEntity living = (LivingEntity)result.field_72308_g;
            IMaxAttack.dealTrueDamage((Entity)this.field_70192_c, living, living.func_110138_aP() * 0.25f);
            this.func_70106_y();
        }
    }

    @Override
    public void func_70071_h_() {
        if (!this.field_70170_p.field_72995_K && this.field_70173_aa > 100) {
            this.func_70106_y();
            return;
        }
        super.func_70071_h_();
    }

    protected float func_70185_h() {
        return 0.0f;
    }
}

