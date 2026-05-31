/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.util.EnumParticleTypes
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.HitResult
 *  net.minecraft.world.World
 *  net.minecraft.world.ServerLevel
 */
package xol.lostinfinity.projectile.entity;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.level.Level;
import net.minecraft.server.level.ServerLevel;
import xol.lostinfinity.init.ParticleInit;
import xol.lostinfinity.projectile.entity.EntityBaseThrowable;
import xol.lostinfinity.util.data.IMaxAttack;

public class EntityComet
extends EntityBaseThrowable {
    private int count = 0;
    private BlockPos starting;

    public EntityComet(Level par1World) {
        super(par1World);
        this.func_70105_a(1.0f, 1.0f);
    }

    public EntityComet(Level par1World, LivingEntity par2Mob) {
        super(par1World, par2Mob);
        this.func_70105_a(1.0f, 1.0f);
    }

    public EntityComet(Level par1World, double par2, double par4, double par6) {
        super(par1World, par2, par4, par6);
        this.func_70105_a(1.0f, 1.0f);
    }

    @Override
    public void setThrower(LivingEntity throwset) {
        this.field_70192_c = throwset;
    }

    public void setCount(int newc) {
        this.count = newc;
    }

    public void setStartLoc(double sx, double sy, double sz) {
        this.starting = new BlockPos(sx, sy, sz);
    }

    @Override
    protected void func_70184_a(HitResult result) {
        if (!this.field_70170_p.field_72995_K) {
            for (LivingEntity target : this.field_70170_p.func_72872_a(LivingEntity.class, this.func_174813_aQ().func_72314_b(4.0, 4.0, 4.0))) {
                int multi = 2;
                if (target instanceof Player) {
                    multi = 3;
                }
                IMaxAttack.dealMaxHealth((Entity)this, target, 4, multi);
            }
            this.field_70170_p.func_72876_a((Entity)this, this.field_70165_t, this.field_70163_u, this.field_70161_v, 4.0f, false);
            this.func_70106_y();
        }
    }

    protected float func_70185_h() {
        if (this.func_189652_ae()) {
            return 0.0f;
        }
        return 0.0366f;
    }

    @Override
    public void func_70071_h_() {
        super.func_70071_h_();
        if (this.field_70170_p.field_72995_K) {
            this.field_70170_p.func_175688_a(ParticleInit.COMET_BLUE, this.field_70165_t + (this.field_70146_Z.nextDouble() - 0.5) * (double)this.field_70130_N, this.field_70163_u + this.field_70146_Z.nextDouble() * (double)this.field_70131_O - 0.25, this.field_70161_v + (this.field_70146_Z.nextDouble() - 0.5) * (double)this.field_70130_N, (this.field_70146_Z.nextDouble() - 0.5) * 2.0, -this.field_70146_Z.nextDouble(), (this.field_70146_Z.nextDouble() - 0.5) * 2.0, new int[0]);
            this.field_70170_p.func_175688_a(ParticleInit.COMET_WHITE, this.field_70165_t + (this.field_70146_Z.nextDouble() - 0.5) * (double)this.field_70130_N, this.field_70163_u + this.field_70146_Z.nextDouble() * (double)this.field_70131_O - 0.25, this.field_70161_v + (this.field_70146_Z.nextDouble() - 0.5) * (double)this.field_70130_N, (this.field_70146_Z.nextDouble() - 0.5) * 2.0, -this.field_70146_Z.nextDouble(), (this.field_70146_Z.nextDouble() - 0.5) * 2.0, new int[0]);
        } else if (this.field_70173_aa == 10 && this.count < 19 && this.starting != null) {
            EntityComet star = new EntityComet(this.field_70170_p);
            star.func_70107_b(this.starting.func_177958_n(), this.starting.func_177956_o(), this.starting.func_177952_p());
            star.setStartLoc(this.starting.func_177958_n(), this.starting.func_177956_o(), this.starting.func_177952_p());
            star.setCount(this.count + 1);
            star.func_70186_c((this.field_70146_Z.nextDouble() - 0.5) * (double)0.1f, -0.1, (this.field_70146_Z.nextDouble() - 0.5) * (double)0.1f, 0.4f, 0.0f);
            star.setThrower(this.func_85052_h());
            this.field_70170_p.func_72838_d((Entity)star);
            ((ServerLevel)this.field_70170_p).func_175739_a(EnumParticleTypes.LAVA, star.field_70165_t, star.field_70163_u, star.field_70161_v, 2, this.field_70146_Z.nextDouble() * 3.0, 0.3, this.field_70146_Z.nextDouble() * 3.0, (double)0.15f, new int[0]);
        }
    }
}

