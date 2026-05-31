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
import xol.lostinfinity.block.activator.BlockRingTile;
import xol.lostinfinity.block.basic.BlockBasic;

public class BlockRingSlideButton
extends BlockBasic {
    public BlockRingSlideButton(String name) {
        super(name);
    }

    public boolean func_180639_a(Level worldIn, BlockPos pos, BlockState state, Player playerIn, InteractionHand hand, Direction facing, float hitX, float hitY, float hitZ) {
        if (!playerIn.func_70093_af() && !worldIn.field_72995_K) {
            BlockPos ref = pos.func_177982_a(0, -1, 0);
            ArrayList<BlockPos> tiles = new ArrayList<BlockPos>();
            ArrayList<BlockState> states = new ArrayList<BlockState>();
            Vec3i dir = BlockRingSlideButton.findTileDir(worldIn, ref);
            if (dir != null) {
                BlockPos nextPos = ref.func_177971_a(dir);
                while (worldIn.func_180495_p(nextPos).func_177230_c() instanceof BlockRingTile) {
                    tiles.add(nextPos);
                    states.add(worldIn.func_180495_p(nextPos));
                    nextPos = nextPos.func_177971_a(dir);
                }
                ArrayList newStates = new ArrayList();
                for (int i = 1; i < states.size(); ++i) {
                    newStates.add(states.get(i));
                }
                newStates.add(states.get(0));
                for (BlockPos tile : tiles) {
                    worldIn.func_175656_a(tile, (BlockState)newStates.get(tiles.indexOf(tile)));
                }
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
            if (!(worldIn.func_180495_p(pos.func_177971_a(dir)).func_177230_c() instanceof BlockRingTile)) continue;
            return dir;
        }
        return null;
    }
}

