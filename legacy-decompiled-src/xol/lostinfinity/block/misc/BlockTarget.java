/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.properties.Property
 *  net.minecraft.block.state.BlockState
 *  net.minecraft.entity.player.Player
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.world.World
 */
package xol.lostinfinity.block.misc;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.entity.player.Player;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import xol.lostinfinity.block.basic.BlockBasicBoolState;
import xol.lostinfinity.block.basic.ITargetable;
import xol.lostinfinity.mob.entity.contest.controller.EntityControllerTargets;
import xol.lostinfinity.util.coordinates.ContestCoordinates;

public class BlockTarget
extends BlockBasicBoolState
implements ITargetable {
    public BlockTarget(String name) {
        super(name);
        this.func_149715_a(1.0f);
    }

    @Override
    public void targetedResult(Level worldIn, Player playerIn, BlockPos pos) {
        for (EntityControllerTargets controller : worldIn.func_72872_a(EntityControllerTargets.class, ContestCoordinates.targetsArenaAABB())) {
            controller.scoreTarget(pos);
        }
    }

    public BlockState getActiveState() {
        return this.func_176223_P().func_177226_a((Property)ACTIVE, (Comparable)Boolean.valueOf(true));
    }

    public BlockState getInactiveState() {
        return this.func_176223_P().func_177226_a((Property)ACTIVE, (Comparable)Boolean.valueOf(false));
    }
}

