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
import xol.lostinfinity.projectile.entity.EntityBaseThrowable;
import xol.lostinfinity.util.data.IMaxAttack;

public class EntityXSonicAttack
extends EntityBaseThrowable {
    public EntityXSonicAttack(Level worldIn) {
        super(worldIn);
        this.func_70105_a(1.0f, 1.0f);
    }

    public EntityXSonicAttack(Level worldIn, LivingEntity entityIn) {
        super(worldIn, entityIn);
        this.func_70105_a(1.0f, 1.0f);
    }

    public EntityXSonicAttack(Level worldIn, double x, double y, double z) {
        super(worldIn, x, y, z);
        this.func_70105_a(1.0f, 1.0f);
    }

    @Override
    protected void func_70184_a(HitResult result) {
        if (!this.field_70170_p.field_72995_K && result.field_72308_g != null && this.func_85052_h() != null && result.field_72308_g != this.func_85052_h() && result.field_72308_g != this.getSecondaryThrower() && result.field_72308_g instanceof LivingEntity) {
            IMaxAttack.dealTrueDamage((Entity)this, (LivingEntity)result.field_72308_g, ((LivingEntity)result.field_72308_g).func_110138_aP());
            this.func_70106_y();
        }
    }

    protected float func_70185_h() {
        return 0.0f;
    }
}

