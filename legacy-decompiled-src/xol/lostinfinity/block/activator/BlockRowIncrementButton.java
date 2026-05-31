/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.state.BlockState
 *  net.minecraft.entity.player.Player
 *  net.minecraft.util.Direction
 *  net.minecraft.util.InteractionHand
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Vec3i
 *  net.minecraft.world.World
 */
package xol.lostinfinity.block.activator;

import java.util.ArrayList;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.entity.player.Player;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Vec3i;
import net.minecraft.world.level.Level;
import xol.lostinfinity.block.activator.BlockRowIncrementTile;
import xol.lostinfinity.block.basic.BlockBasic;
import xol.lostinfinity.init.BlockInit;

public class BlockRowIncrementButton
extends BlockBasic {
    public BlockRowIncrementButton(String name) {
        super(name);
        this.func_149715_a(1.0f);
    }

    public boolean func_180639_a(Level worldIn, BlockPos pos, BlockState state, Player playerIn, InteractionHand hand, Direction facing, float hitX, float hitY, float hitZ) {
        Vec3i dir;
        if (!playerIn.func_70093_af() && !worldIn.field_72995_K && (dir = BlockRowIncrementButton.findTileDir(worldIn, pos)) != null) {
            BlockPos nextPos = pos.func_177971_a(dir);
            while (worldIn.func_180495_p(nextPos).func_177230_c().equals(BlockInit.rowIncrementTile)) {
                int meta = ((BlockRowIncrementTile)BlockInit.rowIncrementTile).func_176201_c(worldIn.func_180495_p(nextPos));
                if (meta == 4) {
                    worldIn.func_175656_a(nextPos, BlockInit.rowIncrementTile.func_176203_a(0));
                } else {
                    worldIn.func_175656_a(nextPos, BlockInit.rowIncrementTile.func_176203_a(meta + 1));
                }
                nextPos = nextPos.func_177971_a(dir);
            }
        }
        return true;
    }

    private static Vec3i findTileDir(Level worldIn, BlockPos pos) {
        ArrayList<Vec3i> dirs = new ArrayList<Vec3i>();
        dirs.add(new Vec3i(1, 0, 0));
        dirs.add(new Vec3i(-1, 0, 0));
        dirs.add(new Vec3i(0, 0, 1));
        dirs.add(new Vec3i(0, 0, -1));
        for (Vec3i dir : dirs) {
            if (!worldIn.func_180495_p(pos.func_177971_a(dir)).func_177230_c().equals(BlockInit.rowIncrementTile)) continue;
            return dir;
        }
        return null;
    }
}

