/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.util.math.HitResult
 *  net.minecraft.world.World
 */
package xol.lostinfinity.projectile.entity;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.level.Level;
import xol.lostinfinity.mob.entity.misc.EntityTNTZombie;
import xol.lostinfinity.projectile.entity.EntityBaseThrowable;

public class EntityTNTStrapper
extends EntityBaseThrowable {
    public EntityTNTStrapper(Level par1World) {
        super(par1World);
        this.func_70105_a(0.75f, 0.75f);
    }

    public EntityTNTStrapper(Level par1World, LivingEntity par2Mob) {
        super(par1World, par2Mob);
        this.func_70105_a(0.75f, 0.75f);
    }

    public EntityTNTStrapper(Level par1World, double par2, double par4, double par6) {
        super(par1World, par2, par4, par6);
        this.func_70105_a(0.75f, 0.75f);
    }

    @Override
    protected void func_70184_a(HitResult result) {
        if (!this.field_70170_p.field_72995_K) {
            if (this.func_85052_h() != null) {
                EntityTNTZombie zombie = new EntityTNTZombie(this.field_70170_p);
                zombie.func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
                zombie.func_193101_c((Player)this.func_85052_h());
                this.field_70170_p.func_72838_d((Entity)zombie);
            }
            this.func_70106_y();
        }
    }

    protected float func_70185_h() {
        return 0.05f;
    }
}

