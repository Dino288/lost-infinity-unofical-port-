/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.util.math.HitResult
 *  net.minecraft.world.World
 */
package xol.lostinfinity.projectile.entity;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.level.Level;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.mob.entity.misc.EntityDroid;
import xol.lostinfinity.projectile.entity.EntityBaseThrowable;

public class EntityDroidZapper
extends EntityBaseThrowable {
    private boolean make_aggro = true;

    public EntityDroidZapper(Level par1World) {
        super(par1World);
    }

    public EntityDroidZapper(Level par1World, LivingEntity par2Mob) {
        super(par1World, par2Mob);
    }

    public void setAttacking(boolean aggro) {
        this.make_aggro = aggro;
    }

    @Override
    protected void func_70184_a(HitResult result) {
        if (!this.field_70170_p.field_72995_K) {
            for (EntityDroid droid : this.field_70170_p.func_72872_a(EntityDroid.class, this.func_174813_aQ().func_72314_b(30.0, 30.0, 30.0))) {
                droid.func_70634_a(this.field_70165_t - 1.0 + this.field_70146_Z.nextDouble() * 2.0, this.field_70163_u + 0.5, this.field_70161_v - 1.0 + this.field_70146_Z.nextDouble() * 2.0);
                droid.setAggressive(this.make_aggro);
            }
            this.func_70106_y();
        }
        this.func_184185_a(SoundInit.LARGE_TELEPORT, 1.0f, 1.0f);
    }

    protected float func_70185_h() {
        return 0.05f;
    }
}

