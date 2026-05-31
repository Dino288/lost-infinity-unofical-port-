/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.block.Block
 *  net.minecraft.block.state.BlockState
 *  net.minecraft.util.BlockRenderLayer
 *  net.minecraft.util.Direction
 *  net.minecraft.util.math.AABB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.world.IBlockAccess
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package xol.lostinfinity.block.misc;

import javax.annotation.Nullable;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.core.Direction;
import net.minecraft.world.phys.AABB;
import net.minecraft.core.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xol.lostinfinity.block.basic.BlockBasicBoolState;

public class BlockFungalBlockage
extends BlockBasicBoolState {
    public BlockFungalBlockage(String name) {
        super(name);
        this.func_149715_a(1.0f);
    }

    @SideOnly(value=Side.CLIENT)
    public BlockRenderLayer func_180664_k() {
        return BlockRenderLayer.TRANSLUCENT;
    }

    @SideOnly(value=Side.CLIENT)
    public boolean func_176225_a(BlockState blockState, IBlockAccess blockAccess, BlockPos pos, Direction side) {
        BlockState state = blockAccess.func_180495_p(pos.func_177972_a(side));
        Block block = state.func_177230_c();
        return block != this;
    }

    public boolean func_149686_d(BlockState state) {
        return false;
    }

    public boolean func_149662_c(BlockState state) {
        return false;
    }

    @Nullable
    public AABB func_180646_a(BlockState blockState, IBlockAccess worldIn, BlockPos pos) {
        if (blockState.equals(this.func_176203_a(1))) {
            return field_185506_k;
        }
        return super.func_180646_a(blockState, worldIn, pos);
    }
}

