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
package xol.lostinfinity.mob.entity.minion.andromeda;

import java.util.Collections;
import java.util.List;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.Level;
import xol.lostinfinity.mob.entity.minion.andromeda.EntityAndromedaController;
import xol.lostinfinity.projectile.entity.EntityBaseThrowable;
import xol.lostinfinity.util.data.IMaxAttack;
import xol.lostinfinity.util.math.LMath;

public class EntityAndromedaChaser
extends EntityBaseThrowable {
    private static final List<String> DAMAGE_TYPE = Collections.singletonList("Aquatic");
    private LivingEntity target;

    public EntityAndromedaChaser(Level worldIn) {
        super(worldIn);
        this.func_70105_a(2.5f, 2.5f);
    }

    public void setTarget(LivingEntity target) {
        this.target = target;
    }

    @Override
    public void setThrower(LivingEntity throwset) {
        super.setThrower(throwset);
        this.field_184539_c = throwset;
    }

    @Override
    protected void func_70184_a(HitResult result) {
        if (this.field_70170_p.field_72995_K) {
            return;
        }
        if (result.field_72313_a == HitResult.Type.BLOCK || !(result.field_72308_g instanceof LivingEntity)) {
            return;
        }
        LivingEntity impact = (LivingEntity)result.field_72308_g;
        if (impact != this.target || impact == this.field_70192_c || impact == this.getSecondaryThrower()) {
            return;
        }
        if (this.field_70192_c instanceof EntityAndromedaController && !((EntityAndromedaController)this.field_70192_c).validateTarget((Entity)impact)) {
            return;
        }
        double dX = impact.field_70159_w;
        double dY = impact.field_70181_x;
        double dZ = impact.field_70179_y;
        IMaxAttack.dealTrueDamage((Entity)this.getSecondaryThrower(), impact, impact.func_110138_aP() * 1.25f, DAMAGE_TYPE);
        impact.field_70159_w = dX;
        impact.field_70181_x = dY;
        impact.field_70179_y = dZ;
        this.func_70106_y();
    }

    @Override
    public void func_70071_h_() {
        super.func_70071_h_();
        if (this.field_70173_aa > 140) {
            this.func_70106_y();
            return;
        }
        if (this.field_70170_p.field_72995_K) {
            return;
        }
        if (this.target == null) {
            this.func_70106_y();
            return;
        }
        if (this.target.field_70128_L) {
            return;
        }
        this.field_70159_w *= 0.95;
        this.field_70181_x *= 0.95;
        this.field_70179_y *= 0.95;
        Vec3 dir = LMath.fastNormalize(LMath.getEntityMiddle((Entity)this.target).func_178788_d(this.func_174791_d())).func_186678_a(0.2);
        this.func_70024_g(dir.field_72450_a, dir.field_72448_b, dir.field_72449_c);
    }

    protected float func_70185_h() {
        return 0.0f;
    }
}

