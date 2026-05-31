/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.EnumCreatureType
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.world.World
 *  net.minecraft.world.biome.Biome
 *  net.minecraft.world.biome.Biome$SpawnListEntry
 *  net.minecraft.world.chunk.Chunk
 *  net.minecraft.world.chunk.ChunkPrimer
 *  net.minecraft.world.gen.IChunkGenerator
 */
package xol.lostinfinity.dimension.celestialvoid;

import java.util.List;
import java.util.Random;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.IChunkGenerator;
import xol.lostinfinity.dimension.util.WorldGenStructure;

public class ChunkGeneratorCelestialVoid
implements IChunkGenerator {
    private final Random rand;
    private final Level world;
    private Biome[] biomesForGeneration;

    public ChunkGeneratorCelestialVoid(Level world, long seed) {
        this.world = world;
        this.rand = new Random(seed);
    }

    public Chunk func_185932_a(int x, int z) {
        this.rand.setSeed((long)x * 341873128712L + (long)z * 132897987541L);
        this.biomesForGeneration = this.world.func_72959_q().func_76933_b(this.biomesForGeneration, x * 16, z * 16, 16, 16);
        ChunkPrimer primer = new ChunkPrimer();
        Chunk chunk = new Chunk(this.world, primer, x, z);
        byte[] abyte = chunk.func_76605_m();
        for (int i = 0; i < abyte.length; ++i) {
            abyte[i] = (byte)Biome.func_185362_a((Biome)this.biomesForGeneration[i]);
        }
        chunk.func_76603_b();
        return chunk;
    }

    public List<Biome.SpawnListEntry> func_177458_a(EnumCreatureType creatureType, BlockPos pos) {
        Biome biome = this.world.func_72959_q().func_180631_a(pos);
        return biome != null ? biome.func_76747_a(creatureType) : null;
    }

    public boolean func_185933_a(Chunk chunkIn, int chunkX, int chunkZ) {
        return false;
    }

    public void func_180514_a(Chunk p_180514_1_, int x, int z) {
    }

    public boolean func_193414_a(Level worldIn, String structureName, BlockPos pos) {
        return false;
    }

    public BlockPos func_180513_a(Level worldIn, String structureName, BlockPos position, boolean findUnexplored) {
        return null;
    }

    public void func_185931_b(int chunkX, int chunkZ) {
        if (chunkX == 0 && chunkZ == 0) {
            this.generateGrandArena(chunkX, chunkZ);
        } else if (chunkX == 31 && chunkZ == 31) {
            this.generateTrialArena(chunkX, chunkZ);
        } else if (chunkX == 60 && chunkZ == 60) {
            this.generateDeviationArena(chunkX, chunkZ);
        } else if (chunkX == 60 && chunkZ == 60) {
            this.generateDeviationArena(chunkX, chunkZ);
        } else if (chunkX == 90 && chunkZ == 30) {
            this.generateCelestialMaze(chunkX, chunkZ);
        }
    }

    private void generateCelestialMaze(int chunkX, int chunkZ) {
        int posX = chunkX * 16;
        int posZ = chunkZ * 16;
        new WorldGenStructure("celestialmaze/celestialmazep1").func_180709_b(this.world, this.rand, new BlockPos(posX, 30, posZ));
        new WorldGenStructure("celestialmaze/celestialmazep2").func_180709_b(this.world, this.rand, new BlockPos(posX + 32, 30, posZ));
        new WorldGenStructure("celestialmaze/celestialmazep3").func_180709_b(this.world, this.rand, new BlockPos(posX, 62, posZ));
        new WorldGenStructure("celestialmaze/celestialmazep4").func_180709_b(this.world, this.rand, new BlockPos(posX + 32, 62, posZ));
        new WorldGenStructure("celestialmaze/celestialmazep5").func_180709_b(this.world, this.rand, new BlockPos(posX, 30, posZ + 32));
        new WorldGenStructure("celestialmaze/celestialmazep6").func_180709_b(this.world, this.rand, new BlockPos(posX + 32, 30, posZ + 32));
        new WorldGenStructure("celestialmaze/celestialmazep7").func_180709_b(this.world, this.rand, new BlockPos(posX, 62, posZ + 32));
        new WorldGenStructure("celestialmaze/celestialmazep8").func_180709_b(this.world, this.rand, new BlockPos(posX + 32, 62, posZ + 32));
        new WorldGenStructure("celestialmaze/celestialmazep9").func_180709_b(this.world, this.rand, new BlockPos(posX + 19, 94, posZ + 26));
        new WorldGenStructure("celestialmaze/celestialmazep10").func_180709_b(this.world, this.rand, new BlockPos(posX + 7, 63, posZ - 34));
        new WorldGenStructure("celestialmaze/celestialmazep11").func_180709_b(this.world, this.rand, new BlockPos(posX + 39, 63, posZ - 34));
        new WorldGenStructure("celestialmaze/celestialmazep12").func_180709_b(this.world, this.rand, new BlockPos(posX + 39, 63, posZ - 52));
        new WorldGenStructure("celestialmaze/celestialmazep13").func_180709_b(this.world, this.rand, new BlockPos(posX + 7, 63, posZ - 52));
    }

    private void generateTrialArena(int chunkX, int chunkZ) {
        int posX = chunkX * 16;
        int posZ = chunkZ * 16;
        new WorldGenStructure("trials/trial_arena_p1").func_180709_b(this.world, this.rand, new BlockPos(posX, 30, posZ));
        new WorldGenStructure("trials/trial_arena_p2").func_180709_b(this.world, this.rand, new BlockPos(posX + 32, 30, posZ));
        new WorldGenStructure("trials/trial_arena_p3").func_180709_b(this.world, this.rand, new BlockPos(posX, 62, posZ));
        new WorldGenStructure("trials/trial_arena_p4").func_180709_b(this.world, this.rand, new BlockPos(posX + 32, 62, posZ));
        new WorldGenStructure("trials/trial_arena_p5").func_180709_b(this.world, this.rand, new BlockPos(posX, 30, posZ + 32));
        new WorldGenStructure("trials/trial_arena_p6").func_180709_b(this.world, this.rand, new BlockPos(posX + 32, 30, posZ + 32));
        new WorldGenStructure("trials/trial_arena_p7").func_180709_b(this.world, this.rand, new BlockPos(posX, 62, posZ + 32));
        new WorldGenStructure("trials/trial_arena_p8").func_180709_b(this.world, this.rand, new BlockPos(posX + 32, 62, posZ + 32));
        new WorldGenStructure("trials/trial_arena_p9").func_180709_b(this.world, this.rand, new BlockPos(posX + 19, 94, posZ + 26));
        new WorldGenStructure("trials/trial_arena_p10").func_180709_b(this.world, this.rand, new BlockPos(posX + 19, 32, posZ - 25));
        new WorldGenStructure("trials/trial_arena_p11").func_180709_b(this.world, this.rand, new BlockPos(posX + 19, 57, posZ - 34));
        new WorldGenStructure("trials/trial_arena_p12").func_180709_b(this.world, this.rand, new BlockPos(posX - 3, 60, posZ - 66));
        new WorldGenStructure("trials/trial_arena_p13").func_180709_b(this.world, this.rand, new BlockPos(posX + 29, 60, posZ - 66));
        new WorldGenStructure("trials/trial_arena_p14").func_180709_b(this.world, this.rand, new BlockPos(posX - 3, 60, posZ - 90));
        new WorldGenStructure("trials/trial_arena_p15").func_180709_b(this.world, this.rand, new BlockPos(posX + 29, 60, posZ - 90));
    }

    private void generateDeviationArena(int chunkX, int chunkZ) {
        int posX = chunkX * 16;
        int posZ = chunkZ * 16;
        new WorldGenStructure("deviation/deviation_arena_p1").func_180709_b(this.world, this.rand, new BlockPos(posX, 30, posZ));
        new WorldGenStructure("deviation/deviation_arena_p2").func_180709_b(this.world, this.rand, new BlockPos(posX + 32, 30, posZ));
        new WorldGenStructure("deviation/deviation_arena_p3").func_180709_b(this.world, this.rand, new BlockPos(posX, 62, posZ));
        new WorldGenStructure("deviation/deviation_arena_p4").func_180709_b(this.world, this.rand, new BlockPos(posX + 32, 62, posZ));
        new WorldGenStructure("deviation/deviation_arena_p5").func_180709_b(this.world, this.rand, new BlockPos(posX, 30, posZ + 32));
        new WorldGenStructure("deviation/deviation_arena_p6").func_180709_b(this.world, this.rand, new BlockPos(posX + 32, 30, posZ + 32));
        new WorldGenStructure("deviation/deviation_arena_p7").func_180709_b(this.world, this.rand, new BlockPos(posX, 62, posZ + 32));
        new WorldGenStructure("deviation/deviation_arena_p8").func_180709_b(this.world, this.rand, new BlockPos(posX + 32, 62, posZ + 32));
        new WorldGenStructure("deviation/deviation_arena_p9").func_180709_b(this.world, this.rand, new BlockPos(posX + 19, 94, posZ + 26));
        new WorldGenStructure("deviation/deviation_arena_p10").func_180709_b(this.world, this.rand, new BlockPos(posX + 19, 32, posZ - 25));
        new WorldGenStructure("deviation/deviation_arena_p11").func_180709_b(this.world, this.rand, new BlockPos(posX + 19, 57, posZ - 34));
        new WorldGenStructure("deviation/deviation_arena_p12").func_180709_b(this.world, this.rand, new BlockPos(posX - 3, 60, posZ - 66));
        new WorldGenStructure("deviation/deviation_arena_p13").func_180709_b(this.world, this.rand, new BlockPos(posX + 29, 60, posZ - 66));
        new WorldGenStructure("deviation/deviation_arena_p14").func_180709_b(this.world, this.rand, new BlockPos(posX - 3, 60, posZ - 90));
        new WorldGenStructure("deviation/deviation_arena_p15").func_180709_b(this.world, this.rand, new BlockPos(posX + 29, 60, posZ - 90));
    }

    private void generateGrandArena(int chunkX, int chunkZ) {
        new WorldGenStructure("grandarena/celestialarenap1").func_180709_b(this.world, this.rand, new BlockPos(chunkX, 30, chunkZ));
        new WorldGenStructure("grandarena/celestialarenap2").func_180709_b(this.world, this.rand, new BlockPos(chunkX + 32, 30, chunkZ));
        new WorldGenStructure("grandarena/celestialarenap3").func_180709_b(this.world, this.rand, new BlockPos(chunkX, 62, chunkZ));
        new WorldGenStructure("grandarena/celestialarenap4").func_180709_b(this.world, this.rand, new BlockPos(chunkX + 32, 62, chunkZ));
        new WorldGenStructure("grandarena/celestialarenap5").func_180709_b(this.world, this.rand, new BlockPos(chunkX, 30, chunkZ + 32));
        new WorldGenStructure("grandarena/celestialarenap6").func_180709_b(this.world, this.rand, new BlockPos(chunkX + 32, 30, chunkZ + 32));
        new WorldGenStructure("grandarena/celestialarenap7").func_180709_b(this.world, this.rand, new BlockPos(chunkX, 62, chunkZ + 32));
        new WorldGenStructure("grandarena/celestialarenap8").func_180709_b(this.world, this.rand, new BlockPos(chunkX + 32, 62, chunkZ + 32));
        new WorldGenStructure("grandarena/celestialarenap9").func_180709_b(this.world, this.rand, new BlockPos(chunkX + 19, 94, chunkZ + 26));
        new WorldGenStructure("grandarena/celestialarenap10").func_180709_b(this.world, this.rand, new BlockPos(chunkX + 19, 32, chunkZ - 25));
        new WorldGenStructure("grandarena/celestialarenap11").func_180709_b(this.world, this.rand, new BlockPos(chunkX + 19, 57, chunkZ - 34));
        new WorldGenStructure("grandarena/celestialarenap12").func_180709_b(this.world, this.rand, new BlockPos(chunkX - 3, 60, chunkZ - 66));
        new WorldGenStructure("grandarena/celestialarenap13").func_180709_b(this.world, this.rand, new BlockPos(chunkX + 29, 60, chunkZ - 66));
        new WorldGenStructure("grandarena/celestialarenap14").func_180709_b(this.world, this.rand, new BlockPos(chunkX - 3, 60, chunkZ - 98));
        new WorldGenStructure("grandarena/celestialarenap15").func_180709_b(this.world, this.rand, new BlockPos(chunkX + 29, 60, chunkZ - 98));
        new WorldGenStructure("grandarena/celestialarenap16").func_180709_b(this.world, this.rand, new BlockPos(chunkX - 3, 60, chunkZ - 130));
        new WorldGenStructure("grandarena/celestialarenap17").func_180709_b(this.world, this.rand, new BlockPos(chunkX + 29, 60, chunkZ - 130));
        new WorldGenStructure("grandarena/celestialarenap18").func_180709_b(this.world, this.rand, new BlockPos(chunkX - 3, 60, chunkZ - 153));
        new WorldGenStructure("grandarena/celestialarenap19").func_180709_b(this.world, this.rand, new BlockPos(chunkX + 29, 60, chunkZ - 153));
        new WorldGenStructure("grandarena/arenaextraroom1").func_180709_b(this.world, this.rand, new BlockPos(chunkX, 60, chunkZ - 180));
        new WorldGenStructure("grandarena/arenaextraroom2").func_180709_b(this.world, this.rand, new BlockPos(chunkX + 20, 60, chunkZ - 180));
        new WorldGenStructure("grandarena/arenaextraroom3").func_180709_b(this.world, this.rand, new BlockPos(chunkX + 40, 60, chunkZ - 180));
    }
}

