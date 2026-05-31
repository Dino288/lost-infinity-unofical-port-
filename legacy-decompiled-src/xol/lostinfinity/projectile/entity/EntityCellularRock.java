/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.HitResult
 *  net.minecraft.world.World
 */
package xol.lostinfinity.projectile.entity;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.level.Level;
import xol.lostinfinity.init.BlockInit;
import xol.lostinfinity.projectile.entity.EntityBaseThrowable;
import xol.lostinfinity.util.data.IMaxAttack;

public class EntityCellularRock
extends EntityBaseThrowable {
    public EntityCellularRock(Level par1World) {
        super(par1World);
        this.func_70105_a(0.75f, 0.75f);
    }

    public EntityCellularRock(Level par1World, LivingEntity par2Mob) {
        super(par1World, par2Mob);
        this.func_70105_a(0.75f, 0.75f);
    }

    public EntityCellularRock(Level par1World, double par2, double par4, double par6) {
        super(par1World, par2, par4, par6);
        this.func_70105_a(0.75f, 0.75f);
    }

    @Override
    protected void func_70184_a(HitResult result) {
        if (!this.field_70170_p.field_72995_K) {
            if (result.field_72308_g == null) {
                BlockPos prev;
                BlockPos resultPos = result.func_178782_a();
                if (this.field_70170_p.func_180495_p(resultPos).func_177230_c() != BlockInit.cellularOre && this.field_70170_p.func_175623_d(prev = this.func_180425_c())) {
                    this.field_70170_p.func_175656_a(prev, BlockInit.cellularOre.func_176223_P());
                }
            } else if (result.field_72308_g instanceof LivingEntity) {
                LivingEntity target = (LivingEntity)result.field_72308_g;
                IMaxAttack.dealMaxHealth((Entity)this, target, 1);
            }
            this.func_70106_y();
        }
    }

    protected float func_70185_h() {
        return 0.0f;
    }
}

