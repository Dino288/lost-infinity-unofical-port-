/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.block.state.BlockState
 *  net.minecraft.util.Direction
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.world.IBlockAccess
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package xol.lostinfinity.block.misc;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xol.lostinfinity.block.basic.BlockBasicNoCollide;

public class BlockFallBridge
extends BlockBasicNoCollide {
    public BlockFallBridge(String name) {
        super(name);
    }

    @SideOnly(value=Side.CLIENT)
    public boolean func_176225_a(BlockState blockState, IBlockAccess blockAccess, BlockPos pos, Direction side) {
        BlockState state = blockAccess.func_180495_p(pos.func_177972_a(side));
        Block block = state.func_177230_c();
        return block != this;
    }

    @Override
    public boolean func_149686_d(BlockState state) {
        return false;
    }

    @Override
    public boolean func_149662_c(BlockState state) {
        return false;
    }
}

