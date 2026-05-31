/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.HitResult
 *  net.minecraft.util.math.HitResult$Type
 *  net.minecraft.world.World
 */
package xol.lostinfinity.projectile.entity;

import java.util.Iterator;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.core.BlockPos;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.level.Level;
import xol.lostinfinity.block.misc.BlockInkable;
import xol.lostinfinity.mob.entity.contest.controller.EntityControllerInkBattle;
import xol.lostinfinity.projectile.entity.EntityBaseThrowable;
import xol.lostinfinity.util.coordinates.ContestCoordinates;

public class EntityInkShot
extends EntityBaseThrowable {
    public EntityInkShot(Level par1World) {
        super(par1World);
        this.func_70105_a(0.75f, 0.75f);
    }

    public EntityInkShot(Level par1World, LivingEntity par2Mob) {
        super(par1World, par2Mob);
        this.func_70105_a(0.75f, 0.75f);
    }

    public EntityInkShot(Level par1World, double par2, double par4, double par6) {
        super(par1World, par2, par4, par6);
        this.func_70105_a(0.75f, 0.75f);
    }

    @Override
    protected void func_70184_a(HitResult result) {
        if (!this.field_70170_p.field_72995_K) {
            Iterator iterator;
            if (result.field_72313_a == HitResult.Type.BLOCK) {
                Iterator iterator2;
                BlockPos pos;
                if (this.field_70192_c != null && this.field_70170_p.func_180495_p(pos = result.func_178782_a()).func_177230_c() instanceof BlockInkable && (iterator2 = this.field_70170_p.func_72872_a(EntityControllerInkBattle.class, ContestCoordinates.inkBattleControllerAABB()).iterator()).hasNext()) {
                    EntityControllerInkBattle controller = (EntityControllerInkBattle)((Object)iterator2.next());
                    controller.inkBlock(this.field_70192_c.func_110124_au(), pos);
                }
            } else if (result.field_72308_g != null && result.field_72308_g instanceof Player && (iterator = this.field_70170_p.func_72872_a(EntityControllerInkBattle.class, ContestCoordinates.inkBattleControllerAABB()).iterator()).hasNext()) {
                EntityControllerInkBattle controller = (EntityControllerInkBattle)((Object)iterator.next());
                controller.inkPlayer((Player)result.field_72308_g);
            }
            this.func_70106_y();
        }
    }

    protected float func_70185_h() {
        return 0.08f;
    }
}

