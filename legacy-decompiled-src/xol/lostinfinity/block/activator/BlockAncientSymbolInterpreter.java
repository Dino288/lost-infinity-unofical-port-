/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.block.IBlockEntityProvider
 *  net.minecraft.block.state.BlockState
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.item.ItemEntity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.item.ItemStack
 *  net.minecraft.tileentity.BlockEntity
 *  net.minecraft.util.Direction
 *  net.minecraft.util.InteractionHand
 *  net.minecraft.util.SoundSource
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Vec3i
 *  net.minecraft.world.World
 */
package xol.lostinfinity.block.activator;

import java.util.ArrayList;
import net.minecraft.world.level.block.Block;
import net.minecraft.block.IBlockEntityProvider;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundSource;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Vec3i;
import net.minecraft.world.level.Level;
import xol.lostinfinity.block.activator.BlockAncientSymbol;
import xol.lostinfinity.block.basic.BlockBasic;
import xol.lostinfinity.block.tileentity.BlockEntityAncientSymbolInterpreter;
import xol.lostinfinity.init.BlockInit;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.init.SoundInit;

public class BlockAncientSymbolInterpreter
extends BlockBasic
implements IBlockEntityProvider {
    public BlockAncientSymbolInterpreter(String name) {
        super(name);
    }

    private boolean validInput(ItemStack stack) {
        return stack.func_77973_b().equals(ItemInit.magicalBook);
    }

    public boolean func_180639_a(Level worldIn, BlockPos pos, BlockState state, Player playerIn, InteractionHand hand, Direction facing, float hitX, float hitY, float hitZ) {
        if (!playerIn.func_70093_af()) {
            if (this.validInput(playerIn.func_184586_b(hand))) {
                if (!worldIn.field_72995_K) {
                    this.reset(worldIn, pos, state);
                }
                playerIn.func_184586_b(hand).func_190918_g(1);
            } else if (!worldIn.field_72995_K) {
                BlockPos ref = pos.func_177982_a(0, -3, 0);
                Vec3i dir = BlockAncientSymbolInterpreter.findTileDir(worldIn, ref);
                int xDir = dir.func_177958_n();
                int zDir = dir.func_177952_p();
                ref = ref.func_177971_a(dir);
                int count = 0;
                BlockPos temp = ref;
                while (worldIn.func_180495_p(temp).func_177230_c().equals(BlockInit.ancientSymbol)) {
                    temp = ref.func_177982_a(xDir * ++count, 0, 0);
                }
                int dimension = count + 1;
                boolean allFlipped = true;
                block1: for (int i = 0; i < dimension; ++i) {
                    for (int j = 0; j < dimension; ++j) {
                        int meta;
                        BlockPos tile = ref.func_177982_a(xDir * i, 0, zDir * j);
                        BlockState tileState = worldIn.func_180495_p(tile);
                        Block block = tileState.func_177230_c();
                        if (!(block instanceof BlockAncientSymbol) || (meta = ((BlockAncientSymbol)block).func_176201_c(tileState)) != 0) continue;
                        allFlipped = false;
                        break block1;
                    }
                }
                if (allFlipped) {
                    worldIn.func_184133_a(null, pos.func_177984_a(), SoundInit.CHIP_FORMAT, SoundSource.BLOCKS, 2.0f, 1.0f);
                    ItemEntity item = new ItemEntity(worldIn, (double)pos.func_177958_n(), (double)(pos.func_177956_o() + 2), (double)pos.func_177952_p(), new ItemStack(ItemInit.bookOfTranslation, 1));
                    item.field_70159_w = 0.0;
                    item.field_70181_x = 0.0;
                    item.field_70179_y = 0.0;
                    worldIn.func_72838_d((Entity)item);
                    this.reset(worldIn, pos, state);
                }
            }
        }
        return true;
    }

    private void reset(Level worldIn, BlockPos pos, BlockState state) {
        BlockEntity tileEntity;
        BlockPos ref = pos.func_177982_a(0, -3, 0);
        Vec3i dir = BlockAncientSymbolInterpreter.findTileDir(worldIn, ref);
        int xDir = dir.func_177958_n();
        int zDir = dir.func_177952_p();
        ref = ref.func_177971_a(dir);
        int count = 0;
        BlockPos temp = ref;
        while (worldIn.func_180495_p(temp).func_177230_c().equals(BlockInit.ancientSymbol)) {
            temp = ref.func_177982_a(xDir * ++count, 0, 0);
        }
        int dimension = count + 1;
        ArrayList<BlockPos> tiles = new ArrayList<BlockPos>();
        boolean foundAllTiles = true;
        for (int i = 0; i < dimension; ++i) {
            for (int j = 0; j < dimension; ++j) {
                BlockPos tile = ref.func_177982_a(xDir * i, 0, zDir * j);
                if (!worldIn.func_180495_p(tile).func_177230_c().equals(BlockInit.ancientSymbol)) continue;
                worldIn.func_175656_a(tile, BlockInit.ancientSymbol.func_176203_a(0));
                tiles.add(tile);
            }
        }
        if (foundAllTiles && worldIn.func_180495_p(pos).func_177230_c() instanceof BlockAncientSymbolInterpreter && (tileEntity = worldIn.func_175625_s(pos)) != null && tileEntity instanceof BlockEntityAncientSymbolInterpreter) {
            BlockEntityAncientSymbolInterpreter TE = (BlockEntityAncientSymbolInterpreter)tileEntity;
            TE.setDir(dir);
            TE.setTiles(tiles);
            TE.reset(dimension);
        }
    }

    private static Vec3i findTileDir(Level worldIn, BlockPos pos) {
        ArrayList<Vec3i> dirs = new ArrayList<Vec3i>();
        dirs.add(new Vec3i(1, 0, 1));
        dirs.add(new Vec3i(-1, 0, 1));
        dirs.add(new Vec3i(-1, 0, -1));
        dirs.add(new Vec3i(1, 0, -1));
        for (Vec3i dir : dirs) {
            if (!worldIn.func_180495_p(pos.func_177971_a(dir)).func_177230_c().equals(BlockInit.ancientSymbol)) continue;
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
        return new BlockEntityAncientSymbolInterpreter();
    }
}

