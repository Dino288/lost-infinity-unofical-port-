/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.projectile.EntityShulkerBullet
 *  net.minecraft.util.Direction$Axis
 *  net.minecraft.util.math.HitResult
 *  net.minecraft.world.World
 */
package xol.lostinfinity.projectile.entity;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.entity.projectile.EntityShulkerBullet;
import net.minecraft.core.Direction;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.level.Level;
import xol.lostinfinity.util.data.IMaxAttack;

public class EntityDeviantShulkerBullet
extends EntityShulkerBullet
implements IMaxAttack {
    public EntityDeviantShulkerBullet(Level worldIn) {
        super(worldIn);
    }

    public EntityDeviantShulkerBullet(Level worldIn, LivingEntity ownerIn, Entity targetIn) {
        super(worldIn, ownerIn, targetIn, Direction.Axis.X);
    }

    protected void func_184567_a(HitResult result) {
        if (!this.field_70170_p.field_72995_K) {
            if (result.field_72308_g != null && result.field_72308_g instanceof LivingEntity) {
                IMaxAttack.dealMaxHealth((Entity)this, (LivingEntity)result.field_72308_g, 3);
            }
            this.func_70106_y();
        }
    }
}

