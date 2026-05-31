/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.block.state.BlockState
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.init.Blocks
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.math.AABB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Vec3i
 *  net.minecraft.world.World
 */
package xol.lostinfinity.block.misc;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.AABB;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Vec3i;
import net.minecraft.world.level.Level;
import xol.lostinfinity.block.basic.BlockBasic;
import xol.lostinfinity.mob.entity.misc.EntityStarfiend;

public class BlockStarblock
extends BlockBasic {
    public BlockStarblock(String name) {
        super(name);
    }

    public void func_180633_a(Level worldIn, BlockPos pos, BlockState state, LivingEntity placer, ItemStack stack) {
        List<BlockPos> validBlocks;
        if (!worldIn.field_72995_K && placer instanceof Player && !(validBlocks = this.isStructureComplete(worldIn, state.func_177230_c(), pos)).isEmpty()) {
            AABB aabb = this.getAxisFromList(validBlocks);
            for (double y = aabb.field_72337_e; y >= aabb.field_72338_b; y -= 1.0) {
                for (double x = aabb.field_72336_d; x >= aabb.field_72340_a; x -= 1.0) {
                    for (double z = aabb.field_72334_f; z >= aabb.field_72339_c; z -= 1.0) {
                        worldIn.func_175698_g(new BlockPos(x, y, z));
                    }
                }
            }
            EntityStarfiend starfiend = new EntityStarfiend(worldIn);
            starfiend.func_70107_b(pos.func_177958_n(), pos.func_177956_o(), pos.func_177952_p());
            worldIn.func_72838_d((Entity)starfiend);
        }
    }

    private AABB getAxisFromList(List<BlockPos> blocks) {
        int lowx = 0;
        int lowy = 0;
        int lowz = 0;
        for (int i = 0; i < blocks.size(); ++i) {
            BlockPos pos = blocks.get(i);
            if (i == 0) {
                lowx = pos.func_177958_n();
                lowy = pos.func_177956_o();
                lowz = pos.func_177952_p();
                continue;
            }
            if (pos.func_177958_n() < lowx) {
                lowx = pos.func_177958_n();
            }
            if (pos.func_177956_o() < lowy) {
                lowy = pos.func_177956_o();
            }
            if (pos.func_177952_p() >= lowz) continue;
            lowz = pos.func_177952_p();
        }
        return new AABB(new BlockPos(lowx, lowy, lowz), new BlockPos(lowx + 5, lowy + 4, lowz + 5));
    }

    private Block getBlockAt(BlockPos pos, Level world) {
        return world.func_180495_p(pos).func_177230_c();
    }

    private List<BlockPos> addBlocksToList(List<BlockPos> blocks, BlockPos basePos, int operationType) {
        blocks.add(basePos);
        if (operationType <= 1) {
            for (int i = 1; i <= 4; ++i) {
                blocks.add(new BlockPos((Vec3i)basePos).func_177982_a(operationType == 0 ? i : -i, -1, 0));
                if (i != 2) continue;
                for (int z = 2; z >= -2; --z) {
                    blocks.add(new BlockPos((Vec3i)basePos).func_177982_a(operationType == 0 ? i : -i, z == 2 || z == -2 ? 0 : -1, operationType == 0 ? z : -z));
                    if (z != 0) continue;
                    blocks.add(new BlockPos((Vec3i)basePos).func_177982_a(operationType == 0 ? i : -i, -2, operationType == 0 ? z : -z));
                    blocks.add(new BlockPos((Vec3i)basePos).func_177982_a(operationType == 0 ? i : -i, -3, operationType == 0 ? z : -z));
                }
            }
        } else {
            for (int i = 1; i <= 4; ++i) {
                blocks.add(new BlockPos((Vec3i)basePos).func_177982_a(0, -1, operationType == 2 ? i : -i));
                if (i != 2) continue;
                for (int z = 2; z >= -2; --z) {
                    blocks.add(new BlockPos((Vec3i)basePos).func_177982_a(operationType == 2 ? z : -z, z == 2 || z == -2 ? 0 : -1, operationType == 2 ? i : -i));
                    if (z != 0) continue;
                    blocks.add(new BlockPos((Vec3i)basePos).func_177982_a(operationType == 2 ? z : -z, -2, operationType == 2 ? i : -i));
                    blocks.add(new BlockPos((Vec3i)basePos).func_177982_a(operationType == 2 ? z : -z, -3, operationType == 2 ? i : -i));
                }
            }
        }
        return blocks;
    }

    private List<BlockPos> getValidBlocks(Level world, Block block, BlockPos basePos) {
        ArrayList<BlockPos> allValidBlocks = new ArrayList<BlockPos>();
        if (this.getBlockAt(new BlockPos((Vec3i)basePos).func_177982_a(4, 0, 0), world).equals(block)) {
            allValidBlocks.add(new BlockPos((Vec3i)basePos).func_177982_a(4, 0, 0));
            return this.addBlocksToList(allValidBlocks, basePos, 0);
        }
        if (this.getBlockAt(new BlockPos((Vec3i)basePos).func_177982_a(-4, 0, 0), world).equals(block)) {
            allValidBlocks.add(new BlockPos((Vec3i)basePos).func_177982_a(-4, 0, 0));
            return this.addBlocksToList(allValidBlocks, basePos, 1);
        }
        if (this.getBlockAt(new BlockPos((Vec3i)basePos).func_177982_a(0, 0, 4), world).equals(block)) {
            allValidBlocks.add(new BlockPos((Vec3i)basePos).func_177982_a(0, 0, 4));
            return this.addBlocksToList(allValidBlocks, basePos, 2);
        }
        if (this.getBlockAt(new BlockPos((Vec3i)basePos).func_177982_a(0, 0, -4), world).equals(block)) {
            allValidBlocks.add(new BlockPos((Vec3i)basePos).func_177982_a(0, 0, -4));
            return this.addBlocksToList(allValidBlocks, basePos, 3);
        }
        return allValidBlocks;
    }

    private List<BlockPos> isStructureComplete(Level world, Block block, BlockPos pos) {
        List<BlockPos> validBlocks = this.getValidBlocks(world, block, pos);
        if (!validBlocks.isEmpty()) {
            int starblock = 0;
            int redstone = 0;
            for (int i = 0; i < validBlocks.size(); ++i) {
                Block b = world.func_180495_p(validBlocks.get(i)).func_177230_c();
                if (b.equals(block)) {
                    ++starblock;
                    continue;
                }
                if (!b.equals(Blocks.field_189877_df)) continue;
                ++redstone;
            }
            if (starblock == 4 && redstone == 9) {
                return validBlocks;
            }
            validBlocks.clear();
        }
        return validBlocks;
    }
}

