/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.block.BlockLiquid
 *  net.minecraft.block.BlockSlab
 *  net.minecraft.block.BlockStairs
 *  net.minecraft.block.material.Material
 *  net.minecraft.block.state.BlockState
 *  net.minecraft.init.Blocks
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.world.World
 *  net.minecraft.world.ServerLevel
 *  net.minecraft.world.chunk.Chunk
 *  net.minecraftforge.event.world.ChunkEvent$Load
 *  net.minecraftforge.fluids.BlockFluidBase
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 */
package xol.lostinfinity.common.events;

import java.util.Random;
import net.minecraft.world.level.block.Block;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.material.Material;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.chunk.Chunk;
import net.minecraftforge.event.world.ChunkEvent;
import net.minecraftforge.fluids.BlockFluidBase;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import xol.lostinfinity.block.basic.BlockBasicCrop;
import xol.lostinfinity.block.basic.ISpecialMurkMeta;
import xol.lostinfinity.init.BlockInit;
import xol.lostinfinity.init.DimensionInit;

public class EventsMurk {
    private Random rand = new Random();

    @SubscribeEvent
    public void ChunkLoad(ChunkEvent.Load event) {
        Level world = event.getWorld();
        if (world != null && !world.field_72995_K && world.field_73011_w.func_186058_p() == DimensionInit.infiniteMurk) {
            Chunk chunk = event.getChunk();
            ServerLevel overworld = world.func_73046_m().func_71218_a(0);
            Chunk overChunk = overworld.func_72964_e(chunk.field_76635_g, chunk.field_76647_h);
            for (int x = 0; x < 16; ++x) {
                for (int z = 0; z < 16; ++z) {
                    for (int y = 0; y < 256; ++y) {
                        BlockState state = overChunk.func_186032_a(x, y, z);
                        BlockState placeState = EventsMurk.getBlockToPlace(state, y);
                        chunk.func_177436_a(new BlockPos(x, y, z), placeState);
                    }
                }
            }
            chunk.func_177427_f(true);
        }
    }

    public static BlockState getBlockToPlace(BlockState state, int height) {
        Block block = state.func_177230_c();
        String regName = block.getRegistryName().toString();
        Material material = state.func_185904_a();
        Random rand = new Random();
        if (!block.func_149686_d(state)) {
            BlockBasicCrop flower;
            if (block instanceof BlockStairs) {
                if (material == Material.field_151575_d) {
                    return BlockInit.murkplankStairs.func_176203_a(block.func_176201_c(state));
                }
                return BlockInit.murkbrickStairs.func_176203_a(block.func_176201_c(state));
            }
            if (block instanceof BlockSlab) {
                if (material == Material.field_151575_d) {
                    return BlockInit.murkplankHalf.func_176203_a(block.func_176201_c(state));
                }
                return BlockInit.murkbrickHalf.func_176203_a(block.func_176201_c(state));
            }
            if (regName.contains("glass") && material == Material.field_151592_s) {
                return BlockInit.murkglass.func_176223_P();
            }
            if (block instanceof BlockFluidBase || block instanceof BlockLiquid) {
                return state;
            }
            if (block == BlockInit.moonFlower && (flower = (BlockBasicCrop)block).func_185526_g() == flower.getCropAge(state)) {
                return BlockInit.voidFlower.func_176223_P();
            }
            return Blocks.field_150350_a.func_176223_P();
        }
        if (block instanceof ISpecialMurkMeta) {
            int meta = ((ISpecialMurkMeta)block).getMurkMeta(state);
            return block.func_176203_a(meta);
        }
        if (regName.contains("leaves") && material == Material.field_151584_j) {
            return BlockInit.leavesMurk.func_176223_P();
        }
        if (regName.contains("log") && material == Material.field_151575_d) {
            return BlockInit.logsMurk.func_176223_P();
        }
        if (regName.toString().contains("planks") && material == Material.field_151575_d) {
            return BlockInit.murkplanks.func_176223_P();
        }
        if (regName.contains("ice") && material == Material.field_151588_w) {
            return BlockInit.murkice.func_176223_P();
        }
        if (material == Material.field_151577_b) {
            return BlockInit.murksoil.func_176223_P();
        }
        if (material == Material.field_151578_c) {
            return BlockInit.murkdirt.func_176223_P();
        }
        if (regName.contains("brick")) {
            return BlockInit.murkbricks.func_176223_P();
        }
        if (regName.contains("obsidian")) {
            return BlockInit.igneousMurkstone.func_176223_P();
        }
        if (regName.contains("bedrock")) {
            if (height < 15 && rand.nextInt(20) == 0) {
                return BlockInit.multiversiteMurk.func_176223_P();
            }
            return BlockInit.murkcore.func_176223_P();
        }
        if (height < 25 && rand.nextInt(100) == 0) {
            return BlockInit.darksteelOre.func_176223_P();
        }
        if (height < 65 && rand.nextInt(150) == 0) {
            return BlockInit.atomiteOre.func_176203_a(0);
        }
        return BlockInit.murkstone.func_176223_P();
    }
}

