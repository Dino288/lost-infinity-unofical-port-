/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.state.BlockState
 *  net.minecraft.entity.player.Player
 *  net.minecraft.init.SoundEvents
 *  net.minecraft.util.Direction
 *  net.minecraft.util.InteractionHand
 *  net.minecraft.util.SoundSource
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.world.World
 */
package xol.lostinfinity.block.activator;

import java.util.ArrayList;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.entity.player.Player;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundSource;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import xol.lostinfinity.block.basic.BlockBasicBoolState;
import xol.lostinfinity.init.BlockInit;

public class BlockRingTile
extends BlockBasicBoolState {
    public BlockRingTile(String name) {
        super(name);
        this.func_149715_a(1.0f);
    }

    public boolean func_180639_a(Level worldIn, BlockPos pos, BlockState state, Player playerIn, InteractionHand hand, Direction facing, float hitX, float hitY, float hitZ) {
        if (!worldIn.field_72995_K) {
            ArrayList<BlockPos> adjblocks = new ArrayList<BlockPos>();
            adjblocks.add(pos.func_177982_a(1, 0, 0));
            adjblocks.add(pos.func_177982_a(1, 0, 1));
            adjblocks.add(pos.func_177982_a(1, 0, -1));
            adjblocks.add(pos.func_177982_a(0, 0, 1));
            adjblocks.add(pos.func_177982_a(0, 0, -1));
            adjblocks.add(pos.func_177982_a(-1, 0, 1));
            adjblocks.add(pos.func_177982_a(-1, 0, 0));
            adjblocks.add(pos.func_177982_a(-1, 0, -1));
            for (BlockPos side : adjblocks) {
                if (worldIn.func_180495_p(side).equals(BlockInit.ringTile.func_176203_a(1))) {
                    worldIn.func_175656_a(side, BlockInit.ringTile.func_176203_a(0));
                    continue;
                }
                if (!worldIn.func_180495_p(side).equals(BlockInit.ringTile.func_176203_a(0))) continue;
                worldIn.func_175656_a(side, BlockInit.ringTile.func_176203_a(1));
            }
            worldIn.func_184133_a(null, pos, SoundEvents.field_187620_cL, SoundSource.MASTER, 1.0f, 1.0f);
        }
        return true;
    }
}

