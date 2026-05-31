/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.state.BlockState
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.world.biome.Biome
 *  net.minecraft.world.chunk.ChunkPrimer
 *  net.minecraft.world.gen.MapGenCaves
 */
package xol.lostinfinity.dimension.shadowsea;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.MapGenCaves;
import xol.lostinfinity.init.BlockInit;

public class CaveGeneratorShadowSea
extends MapGenCaves {
    protected boolean func_175793_a(BlockState targetBlock, BlockState replacementBlock) {
        return targetBlock.func_177230_c() == BlockInit.seastone;
    }

    protected void digBlock(ChunkPrimer data, int x, int y, int z, int chunkX, int chunkZ, boolean foundTop, BlockState state, BlockState up) {
        Biome biome = this.field_75039_c.func_180494_b(new BlockPos(x + chunkX * 16, 0, z + chunkZ * 16));
        BlockState top = biome.field_76752_A;
        BlockState filler = biome.field_76753_B;
        if (this.func_175793_a(state, up) || state.func_177230_c() == top.func_177230_c() || state.func_177230_c() == filler.func_177230_c()) {
            if (y < 10) {
                data.func_177855_a(x, y, z, BlockInit.murkcore.func_176223_P());
            } else {
                data.func_177855_a(x, y, z, field_186127_b);
                if (foundTop && data.func_177856_a(x, y - 1, z).func_177230_c() == filler.func_177230_c()) {
                    data.func_177855_a(x, y - 1, z, top.func_177230_c().func_176223_P());
                }
            }
        }
    }
}

