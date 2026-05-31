/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.util.math.HitResult
 *  net.minecraft.util.math.HitResult$Type
 *  net.minecraft.util.math.Vec3
 *  net.minecraft.world.World
 */
package xol.lostinfinity.projectile.cthulhu;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.Level;
import xol.lostinfinity.mob.entity.cthulhu.ICthulhuMinion;
import xol.lostinfinity.projectile.entity.EntityBaseThrowable;
import xol.lostinfinity.util.data.IMaxAttack;
import xol.lostinfinity.util.math.LMath;

public class EntityCthulhuMissile
extends EntityBaseThrowable {
    private LivingEntity target;

    public EntityCthulhuMissile(Level worldIn) {
        super(worldIn);
    }

    public void setTarget(LivingEntity target) {
        this.target = target;
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
        super.func_70071_h_();
        if (this.field_70170_p.field_72995_K) {
            return;
        }
        if (this.target == null || this.target.field_70128_L) {
            return;
        }
        Vec3 mot = LMath.fastNormalize(new Vec3(this.target.field_70165_t - this.field_70165_t, this.target.field_70163_u - this.field_70163_u, this.target.field_70161_v - this.field_70161_v)).func_186678_a(0.5);
        this.field_70159_w *= (double)0.9f;
        this.field_70181_x *= (double)0.9f;
        this.field_70179_y *= (double)0.9f;
        this.field_70159_w += mot.field_72450_a;
        this.field_70181_x += mot.field_72448_b;
        this.field_70179_y += mot.field_72449_c;
        this.field_70133_I = true;
    }

    protected float func_70185_h() {
        return 0.0f;
    }
}

