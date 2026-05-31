/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.block.material.Material
 *  net.minecraft.block.state.BlockState
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.init.Blocks
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.world.World
 */
package xol.lostinfinity.block.misc;

import java.util.ArrayList;
import net.minecraft.world.level.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import xol.lostinfinity.block.basic.BlockBasic;
import xol.lostinfinity.init.BlockInit;

public class BlockPowerCrystal
extends BlockBasic {
    public BlockPowerCrystal(String name) {
        super(name, Material.field_151576_e);
    }

    public void func_180633_a(Level worldIn, BlockPos pos, BlockState state, LivingEntity placer, ItemStack stack) {
        if (!worldIn.field_72995_K && placer instanceof Player) {
            int place_case = this.powerCoordsCorrect(worldIn, state.func_177230_c(), pos);
            if (place_case == 0) {
                worldIn.func_175656_a(pos, Blocks.field_150350_a.func_176223_P());
                if (!((Player)placer).func_184812_l_()) {
                    placer.func_145779_a(state.func_177230_c().func_185473_a(worldIn, pos, state).func_77973_b(), 1);
                }
            } else if (place_case == 2) {
                worldIn.func_175698_g(pos);
                BlockPos teleport = this.telePos(state.func_177230_c());
                placer.func_70634_a((double)teleport.func_177958_n(), (double)teleport.func_177956_o(), (double)teleport.func_177952_p());
            }
        }
    }

    private BlockPos telePos(Block block) {
        if (block.equals(BlockInit.powerBlockBlue)) {
            return new BlockPos(767, 32, 357);
        }
        if (block.equals(BlockInit.powerBlockYellow)) {
            return new BlockPos(767, 32, 363);
        }
        if (block.equals(BlockInit.powerBlockPurple)) {
            return new BlockPos(784, 32, 363);
        }
        if (block.equals(BlockInit.powerBlockGreen)) {
            return new BlockPos(784, 32, 363);
        }
        return new BlockPos(784, 24, 355);
    }

    private int powerCoordsCorrect(Level world, Block block, BlockPos pos) {
        BlockPos below = pos.func_177977_b();
        if (world.func_180495_p(below).func_177230_c() == BlockInit.powerKeyBlock) {
            if (this.powerGateComplete(world, block, pos)) {
                return 2;
            }
            return 1;
        }
        return 0;
    }

    private boolean powerGateComplete(Level wl, Block blockcheck, BlockPos pos) {
        BlockPos testpos;
        ArrayList<BlockPos> memory = new ArrayList<BlockPos>();
        int otherRow = -2;
        if (wl.func_180495_p(pos.func_177984_a()).func_177230_c() == BlockInit.powerKeyBlock) {
            otherRow = 2;
        }
        int keycount = 0;
        int offset = 0;
        boolean keepGoing = true;
        while (keepGoing) {
            testpos = pos.func_177977_b().func_177982_a(0, 0, --offset);
            if (wl.func_180495_p(testpos).func_177230_c() == BlockInit.powerKeyBlock) {
                if (wl.func_180495_p(testpos.func_177984_a()).func_177230_c() == blockcheck) {
                    ++keycount;
                    memory.add(testpos.func_177984_a());
                    continue;
                }
                keepGoing = false;
                continue;
            }
            keepGoing = false;
        }
        keepGoing = true;
        offset = 0;
        while (keepGoing) {
            testpos = pos.func_177977_b().func_177982_a(0, 0, ++offset);
            if (wl.func_180495_p(testpos).func_177230_c() == BlockInit.powerKeyBlock) {
                if (wl.func_180495_p(testpos.func_177984_a()).func_177230_c() == blockcheck) {
                    ++keycount;
                    memory.add(testpos.func_177984_a());
                    continue;
                }
                keepGoing = false;
                continue;
            }
            keepGoing = false;
        }
        keepGoing = true;
        offset = 0;
        while (keepGoing) {
            testpos = pos.func_177977_b().func_177982_a(0, otherRow, ++offset);
            if (wl.func_180495_p(testpos).func_177230_c() == BlockInit.powerKeyBlock) {
                if (wl.func_180495_p(testpos.func_177984_a()).func_177230_c() == blockcheck) {
                    ++keycount;
                    memory.add(testpos.func_177984_a());
                    continue;
                }
                keepGoing = false;
                continue;
            }
            keepGoing = false;
        }
        keepGoing = true;
        offset = 0;
        while (keepGoing) {
            testpos = pos.func_177977_b().func_177982_a(0, otherRow, offset);
            if (wl.func_180495_p(testpos).func_177230_c() == BlockInit.powerKeyBlock) {
                if (wl.func_180495_p(testpos.func_177984_a()).func_177230_c() == blockcheck) {
                    ++keycount;
                    memory.add(testpos.func_177984_a());
                } else {
                    keepGoing = false;
                }
            } else {
                keepGoing = false;
            }
            --offset;
        }
        if (keycount >= 7) {
            for (BlockPos rem : memory) {
                wl.func_175698_g(rem);
            }
        }
        return keycount >= 7;
    }
}

