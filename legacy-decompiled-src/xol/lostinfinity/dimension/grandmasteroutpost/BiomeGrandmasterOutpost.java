/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.world.World
 *  net.minecraft.world.biome.Biome$BiomeProperties
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package xol.lostinfinity.dimension.grandmasteroutpost;

import java.awt.Color;
import java.util.Random;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xol.lostinfinity.dimension.util.DimensionNoBuild;

public class BiomeGrandmasterOutpost
extends DimensionNoBuild {
    private static Biome.BiomeProperties properties = new Biome.BiomeProperties("grandmasteroutpost").func_185396_a();

    public BiomeGrandmasterOutpost() {
        super(properties, "grandmasteroutpost");
    }

    @SideOnly(value=Side.CLIENT)
    public int func_76731_a(float par1) {
        return Color.BLACK.getRGB();
    }

    public void func_180624_a(Level worldIn, Random rand, BlockPos pos) {
    }
}

