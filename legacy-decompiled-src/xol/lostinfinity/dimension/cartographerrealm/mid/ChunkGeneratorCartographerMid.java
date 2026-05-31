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
package xol.lostinfinity.dimension.cartographerrealm.mid;

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

public class ChunkGeneratorCartographerMid
implements IChunkGenerator,
ICartographerRealm {
    private final Random rand;
    private final Level world;
    private Biome[] biomesForGeneration;

    public ChunkGeneratorCartographerMid(Level world, long seed) {
        this.world = world;
        this.rand = new Random(seed);
    }

    public void func_185931_b(int chunkX, int chunkZ) {
        this.rand.setSeed(this.world.func_72905_C());
        long k = this.rand.nextLong() / 2L * 2L + 1L;
        long l = this.rand.nextLong() / 2L * 2L + 1L;
        this.rand.setSeed((long)chunkX * k + (long)chunkZ * l ^ this.world.func_72905_C());
        this.doGeneration(this.world, this.rand, chunkX, chunkZ);
    }

    @Override
    public String teleRoom() {
        return "labyrinth/lowerlabcross3";
    }

    @Override
    public String gateRoom() {
        return "labyrinth/lowerlabcross3";
    }

    @Override
    public String[] stairsRoom() {
        String[] stairs = new String[]{"labyrinth/lowerlabelevatortop", "labyrinth/lowerlabelevatorbase"};
        return stairs;
    }

    @Override
    public String[] twoLevelRoom() {
        String[] room = new String[2];
        if (this.rand.nextBoolean()) {
            int game_pick = this.rand.nextInt(2);
            room[0] = "labyrinth/lowerlabtimelinetop";
            room[1] = "labyrinth/lowerlabtimelinebase" + ++game_pick;
        } else {
            room[0] = "labyrinth/labitemchalltop";
            room[1] = "labyrinth/labitemchallbot";
        }
        return room;
    }

    @Override
    public String connectorRoom() {
        int con_pick = this.rand.nextInt(16);
        return "labyrinth/lowerlabcon" + ++con_pick;
    }

    @Override
    public String crossRoom() {
        int cross_pick = this.rand.nextInt(6);
        return "labyrinth/lowerlabcross" + ++cross_pick;
    }

    @Override
    public String gameRoom() {
        int cross_pick = this.rand.nextInt(12);
        return "labyrinth/lowerlabspeccross" + ++cross_pick;
    }

    @Override
    public String portalRoom() {
        return "labyrinth/lowerlabportal";
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

