/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.BlockPos$MutableBlockPos
 *  net.minecraft.util.math.ChunkPos
 *  net.minecraft.world.World
 *  net.minecraft.world.biome.Biome
 *  net.minecraft.world.biome.BiomeDecorator
 */
package xol.lostinfinity.dimension.util;

import java.util.Random;
import net.minecraft.core.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.biome.BiomeDecorator;

public abstract class CustomBiomeDecorator
extends BiomeDecorator {
    public void func_180292_a(Level world, Random rand, Biome biome, BlockPos pos) {
        this.doOreGen(world, biome, rand, pos, new BlockPos.MutableBlockPos(), 0, 0, 0);
        this.doPlantGen(world, biome, rand, pos, new BlockPos.MutableBlockPos(), 0, 0, 0);
        this.doTreeGen(world, biome, rand, pos, new BlockPos.MutableBlockPos(), 0, 0, 0);
        this.doMiscGen(world, biome, rand, pos, new BlockPos.MutableBlockPos(), 0, 0, 0);
        ChunkPos cPos = new ChunkPos(pos);
    }

    protected void doOreGen(Level world, Biome biome, Random rand, BlockPos basePos, BlockPos.MutableBlockPos pos, int posX, int posY, int posZ) {
    }

    protected void doPlantGen(Level world, Biome biome, Random rand, BlockPos basePos, BlockPos.MutableBlockPos pos, int posX, int posY, int posZ) {
    }

    protected void doTreeGen(Level world, Biome biome, Random rand, BlockPos basePos, BlockPos.MutableBlockPos pos, int posX, int posY, int posZ) {
    }

    protected void doMiscGen(Level world, Biome biome, Random rand, BlockPos basePos, BlockPos.MutableBlockPos pos, int posX, int posY, int posZ) {
    }
}

