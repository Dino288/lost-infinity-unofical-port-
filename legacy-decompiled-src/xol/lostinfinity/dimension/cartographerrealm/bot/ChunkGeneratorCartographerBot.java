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
package xol.lostinfinity.dimension.cartographerrealm.bot;

import java.util.List;
import java.util.Random;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.IChunkGenerator;
import xol.lostinfinity.dimension.cartographerrealm.ICartographerRealm;
import xol.lostinfinity.dimension.util.WorldGenStructure;

public class ChunkGeneratorCartographerBot
implements IChunkGenerator,
ICartographerRealm {
    private final Random rand;
    private final Level world;
    private Biome[] biomesForGeneration;

    public ChunkGeneratorCartographerBot(Level world, long seed) {
        this.world = world;
        this.rand = new Random(seed);
    }

    public void func_185931_b(int chunkX, int chunkZ) {
        this.rand.setSeed(this.world.func_72905_C());
        long k = this.rand.nextLong() / 2L * 2L + 1L;
        long l = this.rand.nextLong() / 2L * 2L + 1L;
        this.rand.setSeed((long)chunkX * k + (long)chunkZ * l ^ this.world.func_72905_C());
        this.doGeneration(this.world, this.rand, chunkX, chunkZ);
        if (Math.abs(chunkX) <= 1 && Math.abs(chunkZ) <= 1) {
            int posZ;
            int posX;
            if (chunkX == -1 && chunkZ == -1) {
                posX = chunkX * 16;
                posZ = chunkZ * 16;
                new WorldGenStructure("labyrinth/labyrinth_puzzlemaster1").func_180709_b(this.world, this.rand, new BlockPos(posX + 8, 30, posZ + 8));
            }
            if (chunkX == 0 && chunkZ == -1) {
                posX = chunkX * 16;
                posZ = chunkZ * 16;
                new WorldGenStructure("labyrinth/labyrinth_puzzlemaster2").func_180709_b(this.world, this.rand, new BlockPos(posX + 8, 30, posZ + 8));
            }
            if (chunkX == -1 && chunkZ == 0) {
                posX = chunkX * 16;
                posZ = chunkZ * 16;
                new WorldGenStructure("labyrinth/labyrinth_puzzlemaster3").func_180709_b(this.world, this.rand, new BlockPos(posX + 8, 30, posZ + 8));
            }
            if (chunkX == 0 && chunkZ == 0) {
                posX = chunkX * 16;
                posZ = chunkZ * 16;
                new WorldGenStructure("labyrinth/labyrinth_puzzlemaster4").func_180709_b(this.world, this.rand, new BlockPos(posX + 8, 30, posZ + 8));
            }
        }
    }

    @Override
    public String teleRoom() {
        return "labyrinth/bottomlabcross1";
    }

    @Override
    public String gateRoom() {
        return "labyrinth/bottomlabcross1";
    }

    @Override
    public String[] stairsRoom() {
        String[] stairs = new String[]{"labyrinth/bottomlabelevatortop", "labyrinth/bottomlabelevatorbot"};
        return stairs;
    }

    @Override
    public String[] twoLevelRoom() {
        String[] stairs = new String[]{"labyrinth/bottomlabelevatortop", "labyrinth/bottomlabelevatorbot"};
        return stairs;
    }

    @Override
    public String connectorRoom() {
        int con_pick = this.rand.nextInt(16);
        return "labyrinth/bottomlabcon" + ++con_pick;
    }

    @Override
    public String crossRoom() {
        int cross_pick = this.rand.nextInt(5);
        return "labyrinth/bottomlabcross" + ++cross_pick;
    }

    @Override
    public String gameRoom() {
        int game_pick = this.rand.nextInt(11);
        return "labyrinth/bottomlabspeccross" + ++game_pick;
    }

    @Override
    public String portalRoom() {
        int con_pick = this.rand.nextInt(16);
        return "labyrinth/bottomlabcon" + ++con_pick;
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
        return null;
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
}

