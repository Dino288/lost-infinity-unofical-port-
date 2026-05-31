/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.util.math.AABB
 *  net.minecraft.util.math.HitResult
 *  net.minecraft.util.math.HitResult$Type
 *  net.minecraft.world.World
 */
package xol.lostinfinity.projectile.entity;

import java.util.List;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.level.Level;
import xol.lostinfinity.mob.entity.contest.controller.EntityControllerDuelArena;
import xol.lostinfinity.projectile.entity.EntityBaseThrowable;
import xol.lostinfinity.util.coordinates.ContestCoordinates;

public class EntityFountainPellet
extends EntityBaseThrowable {
    public EntityFountainPellet(Level par1World) {
        super(par1World);
        this.func_70105_a(0.75f, 0.75f);
    }

    public EntityFountainPellet(Level par1World, LivingEntity par2Mob) {
        super(par1World, par2Mob);
    }

    public EntityFountainPellet(Level par1World, double par2, double par4, double par6) {
        super(par1World, par2, par4, par6);
    }

    @Override
    protected void func_70184_a(HitResult result) {
        if (!this.field_70170_p.field_72995_K && result.field_72313_a == HitResult.Type.ENTITY) {
            AABB arena;
            List inAABB;
            if (result.field_72308_g instanceof Player && (inAABB = this.field_70170_p.func_72872_a(Player.class, arena = ContestCoordinates.duelArenaAABB())).contains((Player)result.field_72308_g)) {
                for (EntityControllerDuelArena controller : this.field_70170_p.func_72872_a(EntityControllerDuelArena.class, arena)) {
                    controller.hitPlayer((Player)result.field_72308_g, 1);
                }
            }
            this.func_70106_y();
        }
    }

    protected float func_70185_h() {
        return 0.2f;
    }
}

