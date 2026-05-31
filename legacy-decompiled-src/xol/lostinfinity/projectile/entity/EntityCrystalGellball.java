/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.monster.EntityZombie
 *  net.minecraft.util.math.HitResult
 *  net.minecraft.world.World
 */
package xol.lostinfinity.projectile.entity;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.level.Level;
import xol.lostinfinity.mob.entity.misc.EntityMirrorZombie;
import xol.lostinfinity.projectile.entity.EntityBaseThrowable;

public class EntityCrystalGellball
extends EntityBaseThrowable {
    public EntityCrystalGellball(Level par1World) {
        super(par1World);
    }

    public EntityCrystalGellball(Level par1World, LivingEntity par2Mob) {
        super(par1World, par2Mob);
    }

    public EntityCrystalGellball(Level par1World, double par2, double par4, double par6) {
        super(par1World, par2, par4, par6);
    }

    @Override
    protected void func_70184_a(HitResult result) {
        if (!this.field_70170_p.field_72995_K) {
            if (result.field_72308_g != null && this.func_85052_h() != null && result.field_72308_g != this.func_85052_h() && result.field_72308_g instanceof EntityZombie) {
                result.field_72308_g.func_70106_y();
                result.field_72308_g.func_82142_c(true);
                EntityMirrorZombie mz = new EntityMirrorZombie(this.field_70170_p);
                mz.func_70107_b(this.field_70165_t, this.field_70163_u + 0.2, this.field_70161_v);
                this.field_70170_p.func_72838_d((Entity)mz);
            }
            this.func_70106_y();
        }
    }

    protected float func_70185_h() {
        return 0.05f;
    }
}

