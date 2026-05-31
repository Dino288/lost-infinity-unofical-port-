/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.IBlockEntityProvider
 *  net.minecraft.block.state.BlockState
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.item.ItemEntity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.item.ItemStack
 *  net.minecraft.tileentity.BlockEntity
 *  net.minecraft.util.Direction
 *  net.minecraft.util.InteractionHand
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Vec3i
 *  net.minecraft.world.World
 */
package xol.lostinfinity.block.activator;

import java.util.ArrayList;
import net.minecraft.block.IBlockEntityProvider;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Vec3i;
import net.minecraft.world.level.Level;
import xol.lostinfinity.block.basic.BlockBasic;
import xol.lostinfinity.block.tileentity.BlockEntityPowerConduit;
import xol.lostinfinity.init.BlockInit;
import xol.lostinfinity.init.ItemInit;

public class BlockPowerConduit
extends BlockBasic
implements IBlockEntityProvider {
    private static final Vec3i offset = new Vec3i(0, -2, 0);

    public BlockPowerConduit(String name) {
        super(name);
    }

    private boolean validInput(ItemStack stack) {
        return stack.func_77973_b().equals(ItemInit.blankOpticalDisc);
    }

    public boolean func_180639_a(Level worldIn, BlockPos pos, BlockState state, Player playerIn, InteractionHand hand, Direction facing, float hitX, float hitY, float hitZ) {
        if (!playerIn.func_70093_af()) {
            if (this.validInput(playerIn.func_184586_b(hand))) {
                if (!worldIn.field_72995_K) {
                    this.reset(worldIn, pos, state, false);
                }
                playerIn.func_184586_b(hand).func_190918_g(1);
            } else if (!worldIn.field_72995_K) {
                BlockPos ref = pos.func_177971_a(offset);
                Vec3i dir = BlockPowerConduit.findTileDir(worldIn, ref);
                Vec3i upDir = new Vec3i(0, 0, 1);
                Vec3i leftDir = new Vec3i(1, 0, 0);
                if (dir.func_177958_n() < 0) {
                    if (dir.func_177952_p() < 0) {
                        upDir = new Vec3i(0, 0, -1);
                        leftDir = new Vec3i(-1, 0, 0);
                    } else {
                        upDir = new Vec3i(-1, 0, 0);
                        leftDir = new Vec3i(0, 0, 1);
                    }
                } else if (dir.func_177952_p() < 0) {
                    upDir = new Vec3i(1, 0, 0);
                    leftDir = new Vec3i(0, 0, -1);
                }
                ref = ref.func_177971_a(dir);
                int upCount = 0;
                BlockPos temp = ref;
                while (worldIn.func_180495_p(temp).func_177230_c().equals(BlockInit.powerNodule)) {
                    temp = ref.func_177982_a(upDir.func_177958_n() * ++upCount, 0, upDir.func_177952_p() * upCount);
                }
                int leftCount = 0;
                temp = ref;
                while (worldIn.func_180495_p(temp).func_177230_c().equals(BlockInit.powerNodule)) {
                    temp = ref.func_177982_a(leftDir.func_177958_n() * ++leftCount, 0, leftDir.func_177952_p() * leftCount);
                }
                boolean reachedEnd = false;
                BlockPos lastRow = ref.func_177982_a(upDir.func_177958_n() * (upCount - 1), 0, upDir.func_177952_p() * (upCount - 1));
                for (int i = 0; i < leftCount; ++i) {
                    BlockPos check = lastRow.func_177982_a(leftDir.func_177958_n() * i, 0, leftDir.func_177952_p() * i);
                    if (BlockInit.powerNodule.func_176201_c(worldIn.func_180495_p(check)) != 3) continue;
                    reachedEnd = true;
                    break;
                }
                if (reachedEnd) {
                    ItemEntity item = new ItemEntity(worldIn, (double)pos.func_177958_n(), (double)(pos.func_177956_o() + 2), (double)pos.func_177952_p(), new ItemStack(ItemInit.powerControlDisc, 1));
                    item.field_70159_w = 0.0;
                    item.field_70181_x = 0.0;
                    item.field_70179_y = 0.0;
                    worldIn.func_72838_d((Entity)item);
                    this.reset(worldIn, pos, state, true);
                }
            }
        }
        return true;
    }

    private void reset(Level worldIn, BlockPos pos, BlockState state, boolean end) {
        BlockEntity tileEntity;
        BlockPos ref = pos.func_177971_a(offset);
        Vec3i dir = BlockPowerConduit.findTileDir(worldIn, ref);
        Vec3i upDir = new Vec3i(0, 0, 1);
        Vec3i leftDir = new Vec3i(1, 0, 0);
        if (dir.func_177958_n() < 0) {
            if (dir.func_177952_p() < 0) {
                upDir = new Vec3i(0, 0, -1);
                leftDir = new Vec3i(-1, 0, 0);
            } else {
                upDir = new Vec3i(-1, 0, 0);
                leftDir = new Vec3i(0, 0, 1);
            }
        } else if (dir.func_177952_p() < 0) {
            upDir = new Vec3i(1, 0, 0);
            leftDir = new Vec3i(0, 0, -1);
        }
        ref = ref.func_177971_a(dir);
        int upCount = 11;
        int leftCount = 11;
        ArrayList<BlockPos> tiles = new ArrayList<BlockPos>();
        boolean foundAllTiles = true;
        for (int i = 0; i < upCount; ++i) {
            for (int j = 0; j < leftCount; ++j) {
                BlockPos tile = ref.func_177982_a(upDir.func_177958_n() * i + leftDir.func_177958_n() * j, 0, upDir.func_177952_p() * i + leftDir.func_177952_p() * j);
                worldIn.func_175656_a(tile, BlockInit.powerNodule.func_176203_a(0));
                tiles.add(tile);
            }
        }
        if (foundAllTiles && worldIn.func_180495_p(pos).func_177230_c() instanceof BlockPowerConduit && (tileEntity = worldIn.func_175625_s(pos)) != null && tileEntity instanceof BlockEntityPowerConduit) {
            BlockEntityPowerConduit TE = (BlockEntityPowerConduit)tileEntity;
            TE.setDirs(upDir, leftDir);
            TE.setTiles(tiles);
            TE.reset(upCount, leftCount);
            if (end) {
                TE.endGame();
            }
        }
    }

    private static Vec3i findTileDir(Level worldIn, BlockPos pos) {
        ArrayList<Vec3i> dirs = new ArrayList<Vec3i>();
        dirs.add(new Vec3i(1, 0, 1));
        dirs.add(new Vec3i(-1, 0, 1));
        dirs.add(new Vec3i(-1, 0, -1));
        dirs.add(new Vec3i(1, 0, -1));
        for (Vec3i dir : dirs) {
            if (!worldIn.func_180495_p(pos.func_177971_a(dir)).func_177230_c().equals(BlockInit.powerNodule)) continue;
            return dir;
        }
        return null;
    }

    public BlockEntity func_149915_a(Level worldIn, int meta) {
        return null;
    }

    public boolean func_149716_u() {
        return true;
    }

    public BlockEntity createBlockEntity(Level world, BlockState state) {
        return new BlockEntityPowerConduit();
    }
}

