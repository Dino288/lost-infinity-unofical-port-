/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.block.Block
 *  net.minecraft.block.state.BlockState
 *  net.minecraft.util.math.AABB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.world.IBlockAccess
 *  net.minecraft.world.World
 */
package xol.lostinfinity.block.misc;

import java.util.ArrayList;
import java.util.Random;
import javax.annotation.Nullable;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.core.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.level.Level;
import xol.lostinfinity.block.basic.BlockBasicGlass;
import xol.lostinfinity.init.BlockInit;

public class BlockArchlumioGatePass
extends BlockBasicGlass {
    public BlockArchlumioGatePass(String name) {
        super(name);
        this.func_149715_a(1.0f);
        this.func_149675_a(true);
    }

    @Nullable
    public AABB func_180646_a(BlockState blockState, IBlockAccess worldIn, BlockPos pos) {
        return field_185506_k;
    }

    public void func_180650_b(Level worldIn, BlockPos pos, BlockState state, Random rand) {
        this.closeGate(worldIn, pos, null);
        super.func_180650_b(worldIn, pos, state, rand);
    }

    public void closeGate(Level worldIn, BlockPos pos, ArrayList<BlockPos> visited) {
        if (visited == null) {
            visited = new ArrayList();
        }
        if (!visited.contains(pos)) {
            visited.add(pos);
            worldIn.func_175656_a(pos, BlockInit.archlumioGate.func_176223_P());
            for (int i = -1; i <= 1; ++i) {
                for (int j = -1; j <= 1; ++j) {
                    for (int k = -1; k <= 1; ++k) {
                        BlockPos check;
                        Block block;
                        if (i == 0 && j == 0 && k == 0 || !(block = worldIn.func_180495_p(check = pos.func_177982_a(i, j, k)).func_177230_c()).equals(BlockInit.archlumioGatePass)) continue;
                        ((BlockArchlumioGatePass)block).closeGate(worldIn, check, visited);
                    }
                }
            }
        }
    }
}

