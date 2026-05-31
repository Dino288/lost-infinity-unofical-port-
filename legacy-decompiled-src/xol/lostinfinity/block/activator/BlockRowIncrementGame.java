/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.block.state.BlockState
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.Direction
 *  net.minecraft.util.InteractionHand
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Vec3i
 *  net.minecraft.world.World
 */
package xol.lostinfinity.block.activator;

import java.util.ArrayList;
import java.util.Random;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Vec3i;
import net.minecraft.world.level.Level;
import xol.lostinfinity.block.activator.BlockRowIncrementButton;
import xol.lostinfinity.block.basic.BlockBasic;
import xol.lostinfinity.dimension.util.DimensionActivator;
import xol.lostinfinity.init.BlockInit;
import xol.lostinfinity.init.DimensionInit;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.item.activate.ItemComplexLostMap;

public class BlockRowIncrementGame
extends BlockBasic {
    public BlockRowIncrementGame(String name) {
        super(name);
    }

    private boolean validInput(ItemStack stack) {
        return stack.func_77973_b().equals(ItemInit.acidbloodSolution) && stack.func_190916_E() >= 10;
    }

    private boolean validMap(ItemStack stack) {
        return stack.func_77973_b() instanceof ItemComplexLostMap && stack.func_77942_o() && stack.func_77978_p().func_74762_e("MapProgress") == 2;
    }

    public boolean func_180639_a(Level worldIn, BlockPos pos, BlockState state, Player playerIn, InteractionHand hand, Direction facing, float hitX, float hitY, float hitZ) {
        if (!playerIn.func_70093_af()) {
            if (this.validInput(playerIn.func_184586_b(hand))) {
                if (!worldIn.field_72995_K) {
                    this.reset(worldIn, pos, state, playerIn, hand, facing, hitX, hitY, hitZ);
                }
                playerIn.func_184586_b(hand).func_190918_g(10);
            } else if (this.validMap(playerIn.func_184586_b(hand)) && !worldIn.field_72995_K) {
                BlockPos ref = pos.func_177982_a(0, 0, 0);
                Vec3i dir = BlockRowIncrementGame.findTileDir(worldIn, ref);
                int xDir = dir.func_177958_n();
                int zDir = dir.func_177952_p();
                int count = 0;
                BlockPos temp = ref = ref.func_177971_a(dir);
                while (worldIn.func_180495_p(temp).func_177230_c().equals(BlockInit.rowIncrementTile)) {
                    temp = ref.func_177982_a(xDir * ++count, 0, 0);
                }
                int dimension = count;
                boolean flag = true;
                block1: for (int i = 0; i < dimension; ++i) {
                    for (int j = 0; j < dimension; ++j) {
                        BlockPos tile = ref.func_177982_a(xDir * i, 0, zDir * j);
                        if (worldIn.func_180495_p(tile).equals(BlockInit.rowIncrementTile.func_176203_a(4))) continue;
                        flag = false;
                        continue block1;
                    }
                }
                if (flag) {
                    playerIn.func_184586_b(hand).func_190918_g(1);
                    playerIn.func_184611_a(hand, new ItemStack(ItemInit.mazeToken, 1));
                    DimensionActivator.transferEntityWithCoords((Entity)playerIn, DimensionInit.celestialVoid, 1465.0, 65.0, 431.0);
                    this.reset(worldIn, pos, state, playerIn, hand, facing, hitX, hitY, hitZ);
                }
            }
        }
        return true;
    }

    private void reset(Level worldIn, BlockPos pos, BlockState state, Player playerIn, InteractionHand hand, Direction facing, float hitX, float hitY, float hitZ) {
        BlockPos ref = pos.func_177982_a(0, 0, 0);
        Vec3i dir = BlockRowIncrementGame.findTileDir(worldIn, ref);
        int xDir = dir.func_177958_n();
        int zDir = dir.func_177952_p();
        int maxIterations = 200;
        ref = ref.func_177971_a(dir);
        int count = 0;
        BlockPos temp = ref;
        while (worldIn.func_180495_p(temp).func_177230_c().equals(BlockInit.rowIncrementTile)) {
            temp = ref.func_177982_a(xDir * ++count, 0, 0);
        }
        int dimension = count;
        for (int i = 0; i < dimension; ++i) {
            for (int j = 0; j < dimension; ++j) {
                BlockPos tile = ref.func_177982_a(xDir * i, 0, zDir * j);
                if (!worldIn.func_180495_p(tile).func_177230_c().equals(BlockInit.rowIncrementTile)) continue;
                worldIn.func_175656_a(tile, BlockInit.rowIncrementTile.func_176203_a(0));
            }
        }
        ref = pos.func_177982_a(0, 0, 0);
        Random rand = new Random();
        int iterations = rand.nextInt(maxIterations + 1);
        for (int k = 0; k < iterations; ++k) {
            Block button;
            for (int i = 1; i <= dimension; ++i) {
                if (!rand.nextBoolean() || !((button = worldIn.func_180495_p(ref.func_177982_a(xDir * i, 0, 0)).func_177230_c()) instanceof BlockRowIncrementButton)) continue;
                ((BlockRowIncrementButton)button).func_180639_a(worldIn, ref.func_177982_a(xDir * i, 0, 0), state, playerIn, hand, facing, hitX, hitY, hitZ);
            }
            for (int j = 1; j <= dimension; ++j) {
                if (!rand.nextBoolean() || !((button = worldIn.func_180495_p(ref.func_177982_a(0, 0, zDir * j)).func_177230_c()) instanceof BlockRowIncrementButton)) continue;
                ((BlockRowIncrementButton)button).func_180639_a(worldIn, ref.func_177982_a(0, 0, zDir * j), state, playerIn, hand, facing, hitX, hitY, hitZ);
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
            if (!worldIn.func_180495_p(pos.func_177971_a(dir)).func_177230_c().equals(BlockInit.rowIncrementTile)) continue;
            return dir;
        }
        return null;
    }
}

