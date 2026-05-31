/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.state.BlockState
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.world.World
 *  net.minecraft.world.biome.Biome$BiomeProperties
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package xol.lostinfinity.dimension.shadowsea;

import java.util.Random;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xol.lostinfinity.dimension.shadowsea.CoralGenerator;
import xol.lostinfinity.dimension.util.CustomBiome;
import xol.lostinfinity.dimension.util.IDamageRestricted;
import xol.lostinfinity.dimension.util.WorldGenStructure;
import xol.lostinfinity.init.BlockInit;

public class BiomeMoltenSea
extends CustomBiome
implements IDamageRestricted {
    private static Biome.BiomeProperties properties = new Biome.BiomeProperties("moltensea").func_185396_a();
    private CoralGenerator coralGen = new CoralGenerator();

    public BiomeMoltenSea() {
        super(properties, "moltensea");
        this.field_76752_A = BlockInit.heatsand.func_176223_P();
        this.field_76753_B = BlockInit.moltenSeastone.func_176223_P();
        this.terrainBlock = BlockInit.igneousSeastone.func_176223_P();
    }

    @SideOnly(value=Side.CLIENT)
    public int func_76731_a(float par1) {
        return 9902613;
    }

    public void func_180624_a(Level worldIn, Random rand, BlockPos pos) {
        int z;
        int x;
        this.generatePlants(worldIn, rand, pos);
        this.coralGen.setWorld(worldIn, this.field_76752_A);
        int currentX = pos.func_177958_n();
        int currentZ = pos.func_177952_p();
        int runs = 1 + rand.nextInt(3);
        for (int k = 0; k < runs; ++k) {
            x = currentX + rand.nextInt(8) + 8;
            z = currentZ + rand.nextInt(8) + 8;
            int y = worldIn.func_189649_b(x, z);
            BlockPos treePos = new BlockPos(x, y, z);
            this.coralGen.genVolcanicCoral(treePos);
        }
        if (rand.nextInt(120) == 75) {
            int x2 = currentX + rand.nextInt(8) + 8;
            int z2 = currentZ + rand.nextInt(8) + 8;
            int y = worldIn.func_189649_b(x2, z2);
            BlockPos genPos = new BlockPos(x2, y, z2);
            this.generatePearlHouse(worldIn, rand, genPos);
        }
        for (int i = 0; i < 25; ++i) {
            x = currentX + rand.nextInt(8) + 8;
            z = currentZ + rand.nextInt(8) + 8;
            int y = 30 + rand.nextInt(60);
            BlockPos pearlPos = new BlockPos(x, y, z);
            if (worldIn.func_180495_p(pearlPos) != this.terrainBlock) continue;
            worldIn.func_175656_a(pearlPos, BlockInit.igneousPearlOre.func_176223_P());
        }
    }

    public int getWaterColorMultiplier() {
        return 9902613;
    }

    @Override
    public String allowedTypes() {
        return "Aquatic";
    }

    private void generatePlants(Level world, Random rand, BlockPos pos) {
        int runs = 10 + rand.nextInt(15);
        int currentX = pos.func_177958_n();
        int currentZ = pos.func_177952_p();
        for (int k = 0; k < runs; ++k) {
            int z;
            int y;
            int x = currentX + rand.nextInt(8) + 8;
            BlockPos genPos = new BlockPos(x, y = world.func_189649_b(x, z = currentZ + rand.nextInt(8) + 8), z);
            if (world.func_175623_d(genPos.func_177977_b())) continue;
            int weightedPick = rand.nextInt(50);
            if (weightedPick < 5) {
                this.generateEmberkelp(world, rand, genPos);
                continue;
            }
            if (weightedPick < 10) {
                this.generateSmokeweed(world, rand, genPos);
                continue;
            }
            if (weightedPick < 15) {
                this.generateHeatweed(world, rand, genPos);
                continue;
            }
            world.func_175656_a(genPos, BlockInit.moltrock.func_176223_P());
        }
    }

    private void generateEmberkelp(Level world, Random rand, BlockPos pos) {
        int height = 15 + rand.nextInt(20);
        for (int i = 0; i <= height; ++i) {
            world.func_175656_a(pos.func_177982_a(0, i, 0), (float)i < (float)height * 0.75f ? BlockInit.emberkelp.func_176223_P() : BlockInit.emberkelp.func_176203_a(1));
        }
    }

    private void generateSmokeweed(Level world, Random rand, BlockPos pos) {
        int height = 7 + rand.nextInt(12);
        for (int i = 0; i <= height; ++i) {
            world.func_175656_a(pos.func_177982_a(0, i, 0), i != height ? BlockInit.smokeweed.func_176203_a(0) : BlockInit.smokeweed.func_176203_a(1));
        }
    }

    private void generateHeatweed(Level world, Random rand, BlockPos pos) {
        int height = 3 + rand.nextInt(5);
        for (int i = 0; i <= height; ++i) {
            world.func_175656_a(pos.func_177982_a(0, i, 0), i != height ? BlockInit.heatweed.func_176203_a(0) : BlockInit.heatweed.func_176203_a(1));
        }
    }

    private void generatePearlHouse(Level world, Random rand, BlockPos pos) {
        BlockState belowState = world.func_180495_p(pos.func_177977_b());
        if (belowState == this.field_76752_A || belowState == this.terrainBlock) {
            BlockPos curPos = pos;
            boolean shiftLast = true;
            int height = 35 + rand.nextInt(30);
            for (int i = 0; i <= height; ++i) {
                if (i == height) {
                    new WorldGenStructure("sea/pearl_house").func_180709_b(world, rand, curPos.func_177982_a(-(2 + rand.nextInt(3)), 0, -(2 + rand.nextInt(3))));
                    continue;
                }
                for (int xPos = -1; xPos <= 1; ++xPos) {
                    for (int zPos = -1; zPos <= 1; ++zPos) {
                        world.func_175656_a(curPos.func_177982_a(xPos, 0, zPos), BlockInit.igneousSeastone.func_176223_P());
                    }
                }
                if (!shiftLast) {
                    curPos = curPos.func_177982_a(-1 + rand.nextInt(3), 1, -1 + rand.nextInt(3));
                    shiftLast = true;
                    continue;
                }
                curPos = curPos.func_177982_a(0, 1, 0);
                shiftLast = false;
            }
        }
    }
}

