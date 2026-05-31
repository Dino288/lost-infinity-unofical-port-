/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.state.BlockState
 *  net.minecraft.init.Blocks
 *  net.minecraft.world.biome.Biome
 *  net.minecraft.world.biome.Biome$BiomeProperties
 */
package xol.lostinfinity.dimension.util;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.biome.Biome;

public abstract class CustomBiome
extends Biome {
    public BlockState terrainBlock = Blocks.field_150357_h.func_176223_P();

    public CustomBiome(Biome.BiomeProperties properties, String name) {
        super(properties);
        this.setRegistryName("lostinfinity", name);
        this.field_76762_K.clear();
        this.field_76761_J.clear();
        this.field_82914_M.clear();
        this.field_76755_L.clear();
        this.flowers.clear();
        this.field_76760_I.field_76802_A = 0;
        this.field_76760_I.field_76803_B = 0;
    }
}

