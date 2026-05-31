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
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.mob.entity.misc.EntityDroid;
import xol.lostinfinity.projectile.entity.EntityBaseThrowable;

public class EntityDroidBall
extends EntityBaseThrowable {
    private int spawnNum = 1;
    private boolean make_aggro = true;
    private int grade = 0;

    public EntityDroidBall(Level par1World) {
        super(par1World);
    }

    public EntityDroidBall(Level par1World, LivingEntity par2Mob) {
        super(par1World, par2Mob);
    }

    public EntityDroidBall(Level par1World, LivingEntity par2Mob, int extra) {
        this(par1World, par2Mob);
        this.spawnNum = extra;
    }

    public void setAttacking(boolean aggro) {
        this.make_aggro = aggro;
    }

    public void setGrade(int g) {
        this.grade = g;
    }

    @Override
    protected void func_70184_a(HitResult result) {
        if (!this.field_70170_p.field_72995_K) {
            for (int dr = 0; dr < this.spawnNum; ++dr) {
                EntityDroid droid = new EntityDroid(this.field_70170_p);
                if (this.func_85052_h() != null && this.func_85052_h() instanceof Player) {
                    droid.func_193101_c((Player)this.func_85052_h());
                }
                if (dr == 0) {
                    droid.func_70107_b(this.field_70165_t, this.field_70163_u + 0.2, this.field_70161_v);
                } else {
                    droid.func_70107_b(this.field_70165_t - 0.5 + this.field_70146_Z.nextDouble(), this.field_70163_u + 0.2, this.field_70161_v - 0.5 + this.field_70146_Z.nextDouble());
                }
                droid.setAggressive(this.make_aggro);
                droid.setGrade(this.grade);
                this.field_70170_p.func_72838_d((Entity)droid);
            }
            this.func_70106_y();
        }
        this.func_184185_a(SoundInit.DROID_SUMMON, 1.0f, 1.0f);
    }

    protected float func_70185_h() {
        return 0.05f;
    }
}

