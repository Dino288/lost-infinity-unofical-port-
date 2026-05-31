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
 *  scala.util.Random
 */
package xol.lostinfinity.block.activator;

import java.util.ArrayList;
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
import scala.util.Random;
import xol.lostinfinity.block.activator.BlockRowSlideButton;
import xol.lostinfinity.block.activator.BlockRowSlideTile;
import xol.lostinfinity.block.basic.BlockBasic;
import xol.lostinfinity.init.BlockInit;
import xol.lostinfinity.init.ItemInit;

public class BlockRowSlideGame
extends BlockBasic {
    public BlockRowSlideGame(String name) {
        super(name);
    }

    private boolean validInput(ItemStack stack) {
        return stack.func_77973_b().equals(ItemInit.holotronDisc);
    }

    public boolean func_180639_a(Level worldIn, BlockPos pos, BlockState state, Player playerIn, InteractionHand hand, Direction facing, float hitX, float hitY, float hitZ) {
        if (!playerIn.func_70093_af()) {
            if (this.validInput(playerIn.func_184586_b(hand))) {
                if (!worldIn.field_72995_K && this.validInput(playerIn.func_184586_b(hand))) {
                    this.reset(worldIn, pos, state, playerIn, hand, facing, hitX, hitY, hitZ);
                }
                playerIn.func_184586_b(hand).func_190918_g(1);
            } else if (!worldIn.field_72995_K) {
                BlockPos ref = pos.func_177982_a(0, 0, 0);
                Vec3i dir = BlockRowSlideGame.findTileDir(worldIn, ref);
                int dirX = dir.func_177958_n();
                int dirZ = dir.func_177952_p();
                ref = ref.func_177971_a(dir);
                int count = 0;
                BlockPos temp = ref;
                while (worldIn.func_180495_p(temp).func_177230_c().equals(BlockInit.rowSlideTile)) {
                    temp = ref.func_177982_a(dirX * ++count, 0, 0);
                }
                int dimension = count;
                boolean flag = true;
                int meta1 = BlockInit.rowSlideTile.func_176201_c(worldIn.func_180495_p(ref));
                block1: for (int c = 1; c < dimension / 2; ++c) {
                    for (int r = 1; r < dimension / 2; ++r) {
                        if (BlockInit.rowSlideTile.func_176201_c(worldIn.func_180495_p(ref.func_177982_a(dirX * c, 0, dirZ * r))) == meta1) continue;
                        flag = false;
                        continue block1;
                    }
                }
                int meta2 = BlockInit.rowSlideTile.func_176201_c(worldIn.func_180495_p(ref.func_177982_a(dirX * (dimension / 2), 0, 0)));
                block3: for (int c = dimension / 2 + 1; c < dimension; ++c) {
                    for (int r = 1; r < dimension / 2; ++r) {
                        if (BlockInit.rowSlideTile.func_176201_c(worldIn.func_180495_p(ref.func_177982_a(dirX * c, 0, dirZ * r))) == meta2) continue;
                        flag = false;
                        continue block3;
                    }
                }
                int meta3 = BlockInit.rowSlideTile.func_176201_c(worldIn.func_180495_p(ref.func_177982_a(dirX * (dimension / 2), 0, dirZ * (dimension / 2))));
                block5: for (int c = dimension / 2 + 1; c < dimension; ++c) {
                    for (int r = dimension / 2 + 1; r < dimension; ++r) {
                        if (BlockInit.rowSlideTile.func_176201_c(worldIn.func_180495_p(ref.func_177982_a(dirX * c, 0, dirZ * r))) == meta3) continue;
                        flag = false;
                        continue block5;
                    }
                }
                int meta4 = BlockInit.rowSlideTile.func_176201_c(worldIn.func_180495_p(ref.func_177982_a(0, 0, dirZ * (dimension / 2))));
                block7: for (int c = 1; c < dimension / 2; ++c) {
                    for (int r = dimension / 2 + 1; r < dimension; ++r) {
                        if (BlockInit.rowSlideTile.func_176201_c(worldIn.func_180495_p(ref.func_177982_a(dirX * c, 0, dirZ * r))) == meta4) continue;
                        flag = false;
                        continue block7;
                    }
                }
                if (meta1 == meta2 || meta1 == meta3 || meta1 == meta4) {
                    flag = false;
                }
                if (flag) {
                    ItemEntity item = new ItemEntity(worldIn, (double)pos.func_177958_n(), (double)(pos.func_177956_o() + 2), (double)pos.func_177952_p(), new ItemStack(ItemInit.astralPlaneAnalyzer));
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
        Block block;
        int iterations;
        int r;
        int c;
        BlockPos ref = pos.func_177982_a(0, 0, 0);
        Vec3i dir = BlockRowSlideGame.findTileDir(worldIn, ref);
        int dirX = dir.func_177958_n();
        int dirZ = dir.func_177952_p();
        int maxRolls = 8;
        int count = 0;
        BlockPos temp = ref = ref.func_177971_a(dir);
        while (worldIn.func_180495_p(temp).func_177230_c().equals(BlockInit.rowSlideTile)) {
            temp = ref.func_177982_a(dirX * ++count, 0, 0);
        }
        int dimension = count;
        for (c = 0; c < dimension / 2; ++c) {
            for (r = 0; r < dimension / 2; ++r) {
                if (!(worldIn.func_180495_p(ref.func_177982_a(dirX * c, 0, dirZ * r)).func_177230_c() instanceof BlockRowSlideTile)) continue;
                worldIn.func_175656_a(ref.func_177982_a(dirX * c, 0, dirZ * r), BlockInit.rowSlideTile.func_176203_a(0));
            }
        }
        for (c = dimension / 2; c < dimension; ++c) {
            for (r = 0; r < dimension / 2; ++r) {
                if (!(worldIn.func_180495_p(ref.func_177982_a(dirX * c, 0, dirZ * r)).func_177230_c() instanceof BlockRowSlideTile)) continue;
                worldIn.func_175656_a(ref.func_177982_a(dirX * c, 0, dirZ * r), BlockInit.rowSlideTile.func_176203_a(1));
            }
        }
        for (c = 0; c < dimension / 2; ++c) {
            for (r = dimension / 2; r < dimension; ++r) {
                if (!(worldIn.func_180495_p(ref.func_177982_a(dirX * c, 0, dirZ * r)).func_177230_c() instanceof BlockRowSlideTile)) continue;
                worldIn.func_175656_a(ref.func_177982_a(dirX * c, 0, dirZ * r), BlockInit.rowSlideTile.func_176203_a(2));
            }
        }
        for (c = dimension / 2; c < dimension; ++c) {
            for (r = dimension / 2; r < dimension; ++r) {
                if (!(worldIn.func_180495_p(ref.func_177982_a(dirX * c, 0, dirZ * r)).func_177230_c() instanceof BlockRowSlideTile)) continue;
                worldIn.func_175656_a(ref.func_177982_a(dirX * c, 0, dirZ * r), BlockInit.rowSlideTile.func_176203_a(3));
            }
        }
        Random rand = new Random();
        for (int x = 1; x < dimension + 1; ++x) {
            iterations = rand.nextInt(maxRolls);
            if (iterations <= 0 || !((block = worldIn.func_180495_p(pos.func_177982_a(dirX * x, 0, 0)).func_177230_c()) instanceof BlockRowSlideButton)) continue;
            for (i = 0; i <= iterations; ++i) {
                ((BlockRowSlideButton)block).func_180639_a(worldIn, pos.func_177982_a(dirX * x, 0, 0), state, playerIn, hand, facing, hitX, hitY, hitZ);
            }
        }
        for (int z = 1; z < dimension + 1; ++z) {
            iterations = rand.nextInt(maxRolls);
            if (iterations <= 0 || !((block = worldIn.func_180495_p(pos.func_177982_a(0, 0, dirZ * z)).func_177230_c()) instanceof BlockRowSlideButton)) continue;
            for (i = 0; i <= iterations; ++i) {
                ((BlockRowSlideButton)block).func_180639_a(worldIn, pos.func_177982_a(0, 0, dirZ * z), state, playerIn, hand, facing, hitX, hitY, hitZ);
            }
        }
    }

    private static Vec3i findTileDir(Level worldIn, BlockPos pos) {
        ArrayList<Vec3i> dirs = new ArrayList<Vec3i>();
        dirs.add(new Vec3i(1, 0, 1));
        dirs.add(new Vec3i(-1, 0, 1));
        dirs.add(new Vec3i(1, 0, -1));
        dirs.add(new Vec3i(-1, 0, -1));
        for (Vec3i dir : dirs) {
            if (!(worldIn.func_180495_p(pos.func_177971_a(dir)).func_177230_c() instanceof BlockRowSlideTile)) continue;
            return dir;
        }
        return null;
    }
}

