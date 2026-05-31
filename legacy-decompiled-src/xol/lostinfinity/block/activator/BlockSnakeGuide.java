/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.state.BlockState
 *  net.minecraft.entity.player.Player
 *  net.minecraft.util.Direction
 *  net.minecraft.util.InteractionHand
 *  net.minecraft.util.math.AABB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.world.World
 */
package xol.lostinfinity.block.activator;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.entity.player.Player;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.phys.AABB;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import xol.lostinfinity.block.basic.BlockBasicRotational;
import xol.lostinfinity.init.BlockInit;
import xol.lostinfinity.mob.entity.contest.controller.EntityControllerBattleSnakes;
import xol.lostinfinity.util.coordinates.ContestCoordinates;

public class BlockSnakeGuide
extends BlockBasicRotational {
    public BlockSnakeGuide(String name) {
        super(name);
        this.func_149715_a(1.0f);
    }

    public boolean func_180639_a(Level worldIn, BlockPos pos, BlockState state, Player playerIn, InteractionHand hand, Direction facing, float hitX, float hitY, float hitZ) {
        if (!worldIn.field_72995_K) {
            AABB arena = ContestCoordinates.battleSnakesArenaAABB();
            EntityControllerBattleSnakes controller = null;
            for (EntityControllerBattleSnakes entity : worldIn.func_72872_a(EntityControllerBattleSnakes.class, arena)) {
                if (entity.field_70128_L) continue;
                controller = entity;
                break;
            }
            if (controller != null) {
                if (state.func_177230_c().equals(BlockInit.snakeGuideLeft)) {
                    controller.turnSnake(pos, false);
                } else if (state.func_177230_c().equals(BlockInit.snakeGuideRight)) {
                    controller.turnSnake(pos, true);
                }
            }
        }
        return true;
    }
}

