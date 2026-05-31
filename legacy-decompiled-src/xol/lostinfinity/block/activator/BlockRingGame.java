/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.block.state.BlockState
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.item.ItemEntity
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
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Vec3i;
import net.minecraft.world.level.Level;
import xol.lostinfinity.block.activator.BlockRingSlideButton;
import xol.lostinfinity.block.activator.BlockRingTile;
import xol.lostinfinity.block.activator.BlockRowSlideButton;
import xol.lostinfinity.block.basic.BlockBasic;
import xol.lostinfinity.init.BlockInit;
import xol.lostinfinity.init.ItemInit;

public class BlockRingGame
extends BlockBasic {
    public BlockRingGame(String name) {
        super(name);
    }

    private boolean validInput(ItemStack stack) {
        return stack.func_77973_b().equals(ItemInit.highToleranceWire);
    }

    public boolean func_180639_a(Level worldIn, BlockPos pos, BlockState state, Player playerIn, InteractionHand hand, Direction facing, float hitX, float hitY, float hitZ) {
        if (!playerIn.func_70093_af()) {
            if (this.validInput(playerIn.func_184586_b(hand))) {
                if (!worldIn.field_72995_K) {
                    this.reset(worldIn, pos, state, playerIn, hand, facing, hitX, hitY, hitZ);
                }
                playerIn.func_184586_b(hand).func_190918_g(1);
            } else if (!worldIn.field_72995_K) {
                BlockPos ref = pos.func_177982_a(0, -2, 0);
                Vec3i dir = BlockRingGame.findTileDir(worldIn, ref);
                int xDir = dir.func_177958_n();
                int zDir = dir.func_177952_p();
                int count = 0;
                BlockPos temp = ref = ref.func_177971_a(dir);
                while (worldIn.func_180495_p(temp).func_177230_c().equals(BlockInit.ringTile)) {
                    temp = ref.func_177982_a(xDir * ++count, 0, 0);
                }
                int dimension = count;
                boolean flag = true;
                block1: for (int i = 0; i < dimension; ++i) {
                    for (int j = 0; j < dimension; ++j) {
                        BlockPos tile = ref.func_177982_a(xDir * i, 0, zDir * j);
                        if (worldIn.func_180495_p(tile).equals(BlockInit.ringTile.func_176203_a(1))) continue;
                        flag = false;
                        continue block1;
                    }
                }
                if (flag) {
                    ItemEntity item = new ItemEntity(worldIn, (double)pos.func_177958_n(), (double)(pos.func_177956_o() + 2), (double)pos.func_177952_p(), new ItemStack(ItemInit.highSpeedWire, 1));
                    item.field_70159_w = 0.0;
                    item.field_70181_x = 0.0;
                    item.field_70179_y = 0.0;
                    worldIn.func_72838_d((Entity)item);
                    this.reset(worldIn, pos, state, playerIn, hand, facing, hitX, hitY, hitZ);
                }
            }
        }
        return true;
    }

    private void reset(Level worldIn, BlockPos pos, BlockState state, Player playerIn, InteractionHand hand, Direction facing, float hitX, float hitY, float hitZ) {
        int i;
        BlockPos ref = pos.func_177982_a(0, -2, 0);
        Vec3i dir = BlockRingGame.findTileDir(worldIn, ref);
        int xDir = dir.func_177958_n();
        int zDir = dir.func_177952_p();
        int iterations = 10;
        ref = ref.func_177971_a(dir);
        int count = 0;
        BlockPos temp = ref;
        while (worldIn.func_180495_p(temp).func_177230_c().equals(BlockInit.ringTile)) {
            temp = ref.func_177982_a(xDir * ++count, 0, 0);
        }
        int dimension = count;
        for (int i2 = 0; i2 < dimension; ++i2) {
            for (int j = 0; j < dimension; ++j) {
                BlockPos tile = ref.func_177982_a(xDir * i2, 0, zDir * j);
                if (!worldIn.func_180495_p(tile).func_177230_c().equals(BlockInit.ringTile)) continue;
                worldIn.func_175656_a(tile, BlockInit.ringTile.func_176203_a(1));
            }
        }
        Random rand = new Random();
        for (int k = 0; k < iterations; ++k) {
            int randz;
            int randx = rand.nextInt(dimension);
            BlockPos tile = ref.func_177982_a(xDir * randx, 0, zDir * (randz = rand.nextInt(dimension)));
            if (!worldIn.func_180495_p(tile).func_177230_c().equals(BlockInit.ringTile)) continue;
            ((BlockRingTile)worldIn.func_180495_p(tile).func_177230_c()).func_180639_a(worldIn, tile, state, playerIn, hand, facing, hitX, hitY, hitZ);
        }
        for (int x = 1; x < dimension + 1; ++x) {
            Block block;
            if (iterations <= 0 || !((block = worldIn.func_180495_p(pos.func_177982_a(xDir * x, 0, 0)).func_177230_c()) instanceof BlockRowSlideButton)) continue;
            for (i = 0; i <= iterations; ++i) {
                ((BlockRingSlideButton)block).func_180639_a(worldIn, pos.func_177982_a(xDir * x, 0, 0), state, playerIn, hand, facing, hitX, hitY, hitZ);
            }
        }
        for (int z = 1; z < dimension + 1; ++z) {
            Block block;
            if (iterations <= 0 || !((block = worldIn.func_180495_p(pos.func_177982_a(0, 0, zDir * z)).func_177230_c()) instanceof BlockRowSlideButton)) continue;
            for (i = 0; i <= iterations; ++i) {
                ((BlockRingSlideButton)block).func_180639_a(worldIn, pos.func_177982_a(0, 0, zDir * z), state, playerIn, hand, facing, hitX, hitY, hitZ);
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
            if (!worldIn.func_180495_p(pos.func_177971_a(dir)).func_177230_c().equals(BlockInit.ringTile)) continue;
            return dir;
        }
        return null;
    }
}

