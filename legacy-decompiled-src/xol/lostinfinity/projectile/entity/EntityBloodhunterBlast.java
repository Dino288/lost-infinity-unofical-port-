/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.util.EnumParticleTypes
 *  net.minecraft.util.math.AABB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.HitResult
 *  net.minecraft.world.World
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package xol.lostinfinity.projectile.entity;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.phys.AABB;
import net.minecraft.core.BlockPos;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xol.lostinfinity.init.DimensionInit;
import xol.lostinfinity.mob.entity.contest.controller.EntityControllerHunters;
import xol.lostinfinity.projectile.entity.EntityBaseThrowable;

public class EntityBloodhunterBlast
extends EntityBaseThrowable {
    public EntityBloodhunterBlast(Level par1World) {
        super(par1World);
    }

    public EntityBloodhunterBlast(Level par1World, LivingEntity par2Mob) {
        super(par1World, par2Mob);
        this.func_70105_a(1.0f, 1.0f);
    }

    @Override
    protected void func_70184_a(HitResult result) {
        if (!this.field_70170_p.field_72995_K) {
            if (result.field_72308_g != null && result.field_72308_g != this.func_85052_h() && result.field_72308_g instanceof Player && this.field_70170_p.field_73011_w.func_186058_p() == DimensionInit.grandmasterOutpost) {
                Player player = (Player)result.field_72308_g;
                for (EntityControllerHunters search_cont : this.field_70170_p.func_72872_a(EntityControllerHunters.class, this.getArenaAABB())) {
                    search_cont.removePlayer(player);
                }
            }
            this.func_70106_y();
        }
    }

    protected AABB getArenaAABB() {
        return new AABB(new BlockPos(0, 20, 160), new BlockPos(62, 42, 222));
    }

    protected float func_70185_h() {
        return 0.05f;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void func_70071_h_() {
        super.func_70071_h_();
        if (this.field_70170_p.field_72995_K) {
            this.field_70170_p.func_175688_a(EnumParticleTypes.SMOKE_NORMAL, this.field_70165_t + (this.field_70146_Z.nextDouble() - 0.5) * (double)this.field_70130_N, this.field_70163_u + this.field_70146_Z.nextDouble() * (double)this.field_70131_O - 0.25, this.field_70161_v + (this.field_70146_Z.nextDouble() - 0.5) * (double)this.field_70130_N, 0.0, 0.0, 0.0, new int[0]);
        }
    }
}

