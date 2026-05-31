/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.state.BlockState
 *  net.minecraft.entity.player.Player
 *  net.minecraft.util.Direction
 *  net.minecraft.util.InteractionHand
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.world.World
 */
package xol.lostinfinity.block.activator;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.entity.player.Player;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import xol.lostinfinity.block.basic.BlockBasicBoolState;
import xol.lostinfinity.block.tileentity.BlockEntityAlignmentDialGame;
import xol.lostinfinity.init.BlockInit;

public class BlockAlignmentTile
extends BlockBasicBoolState {
    public BlockAlignmentTile(String name) {
        super(name);
    }

    public boolean func_180639_a(Level worldIn, BlockPos pos, BlockState state, Player playerIn, InteractionHand hand, Direction facing, float hitX, float hitY, float hitZ) {
        if (!worldIn.field_72995_K) {
            int radius = 15;
            for (int i = -radius; i <= radius; ++i) {
                for (int j = -radius; j <= radius; ++j) {
                    BlockPos check = pos.func_177982_a(i, 0, j);
                    if (!worldIn.func_180495_p(check).func_177230_c().equals(BlockInit.alignmentDialGame) || worldIn.func_175625_s(check) == null) continue;
                    BlockEntityAlignmentDialGame tileEntity = (BlockEntityAlignmentDialGame)worldIn.func_175625_s(check);
                    tileEntity.toggleRing(pos);
                }
            }
        }
        return true;
    }
}

