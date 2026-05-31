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
import xol.lostinfinity.init.BlockInit;

public class BiomeShadowSea
extends CustomBiome
implements IDamageRestricted {
    private static Biome.BiomeProperties properties = new Biome.BiomeProperties("shadowsea").func_185396_a();
    private CoralGenerator coralGen = new CoralGenerator();

    public BiomeShadowSea() {
        super(properties, "shadowsea");
        this.field_76752_A = BlockInit.seasand.func_176223_P();
        this.field_76753_B = BlockInit.sandySeastone.func_176223_P();
        this.terrainBlock = BlockInit.seastone.func_176223_P();
    }

    @SideOnly(value=Side.CLIENT)
    public int func_76731_a(float par1) {
        return 3149998;
    }

    public void func_180624_a(Level worldIn, Random rand, BlockPos pos) {
        int y;
        int z;
        int x;
        this.generatePlants(worldIn, rand, pos);
        this.coralGen.setWorld(worldIn, this.field_76752_A);
        int currentX = pos.func_177958_n();
        int currentZ = pos.func_177952_p();
        int runs = 1 + rand.nextInt(4);
        for (int k = 0; k < runs; ++k) {
            int x2 = currentX + rand.nextInt(8) + 8;
            int z2 = currentZ + rand.nextInt(8) + 8;
            int y2 = worldIn.func_189649_b(x2, z2);
            BlockPos treePos = new BlockPos(x2, y2, z2);
            this.coralGen.genRandomCoral(treePos);
        }
        if (rand.nextInt(25) == 5) {
            x = currentX + rand.nextInt(8) + 8;
            z = currentZ + rand.nextInt(8) + 8;
            y = worldIn.func_189649_b(x, z);
            BlockPos genPos = new BlockPos(x, y, z);
            this.generateClaySpire(worldIn, rand, genPos);
        }
        if (rand.nextInt(280) == 45) {
            x = currentX + rand.nextInt(8) + 8;
            z = currentZ + rand.nextInt(8) + 8;
            y = worldIn.func_189649_b(x, z);
            BlockPos treePos = new BlockPos(x, y, z);
            this.coralGen.genRandomExtras(treePos);
        }
    }

    public int getWaterColorMultiplier() {
        return 3139384;
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
                this.generateKelp(world, rand, genPos);
                continue;
            }
            if (weightedPick < 10) {
                this.generateWiggleWeed(world, rand, genPos);
                continue;
            }
            if (weightedPick < 25) {
                world.func_175656_a(genPos, BlockInit.seabush.func_176223_P());
                continue;
            }
            world.func_175656_a(genPos, BlockInit.searock.func_176223_P());
        }
    }

    private void generateKelp(Level world, Random rand, BlockPos pos) {
        int height = 15 + rand.nextInt(20);
        for (int i = 0; i <= height; ++i) {
            world.func_175656_a(pos.func_177982_a(0, i, 0), (float)i < (float)height * 0.75f ? BlockInit.kelp.func_176223_P() : BlockInit.denseKelp.func_176223_P());
        }
    }

    private void generateWiggleWeed(Level world, Random rand, BlockPos pos) {
        int height = 7 + rand.nextInt(12);
        for (int i = 0; i <= height; ++i) {
            world.func_175656_a(pos.func_177982_a(0, i, 0), i != height ? BlockInit.wiggleweed.func_176203_a(0) : BlockInit.wiggleweed.func_176203_a(1));
        }
    }

    private void generateClaySpire(Level world, Random rand, BlockPos pos) {
        BlockState belowState = world.func_180495_p(pos.func_177977_b());
        if (belowState == this.field_76752_A || belowState == this.terrainBlock) {
            BlockPos curPos = pos;
            boolean shiftLast = true;
            int height = 15 + rand.nextInt(34);
            for (int i = 0; i < height; ++i) {
                for (int xPos = -1; xPos <= 1; ++xPos) {
                    for (int zPos = -1; zPos <= 1; ++zPos) {
                        if (i == height - 1 && xPos == 0 && zPos == 0) continue;
                        world.func_175656_a(curPos.func_177982_a(xPos, 0, zPos), rand.nextBoolean() ? BlockInit.seastone.func_176223_P() : BlockInit.seaClay.func_176223_P());
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

