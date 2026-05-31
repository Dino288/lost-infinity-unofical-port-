/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.EnumCreatureType
 *  net.minecraft.util.Rotation
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.world.World
 *  net.minecraft.world.biome.Biome
 *  net.minecraft.world.biome.Biome$SpawnListEntry
 *  net.minecraft.world.chunk.Chunk
 *  net.minecraft.world.chunk.ChunkPrimer
 *  net.minecraft.world.gen.IChunkGenerator
 */
package xol.lostinfinity.dimension.grandmasteroutpost;

import java.util.List;
import java.util.Random;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.util.Rotation;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.IChunkGenerator;
import xol.lostinfinity.dimension.data.ChunkPairing;
import xol.lostinfinity.dimension.util.WorldGenStructure;
import xol.lostinfinity.util.coordinates.ContestCoordinates;

public class ChunkGeneratorGrandmasterOutpost
implements IChunkGenerator {
    private final Random rand;
    private final Level world;
    private Biome[] biomesForGeneration;

    public ChunkGeneratorGrandmasterOutpost(Level world, long seed) {
        this.world = world;
        this.rand = new Random(seed);
    }

    public void func_185931_b(int chunkX, int chunkZ) {
        int posX = chunkX * 16;
        int posZ = chunkZ * 16;
        this.rand.setSeed(this.world.func_72905_C());
        long k = this.rand.nextLong() / 2L * 2L + 1L;
        long l = this.rand.nextLong() / 2L * 2L + 1L;
        this.rand.setSeed((long)chunkX * k + (long)chunkZ * l ^ this.world.func_72905_C());
        ChunkPairing chunk = new ChunkPairing(chunkX, chunkZ);
        if (chunk.sameChunkAs(ContestCoordinates.gamesLobbyGenLoc())) {
            this.generateContestGamesRoom(chunk);
        } else if (chunk.sameChunkAs(ContestCoordinates.grandHallGenLoc())) {
            this.generateContestGrandHall(chunk);
        } else if (chunk.sameChunkAs(ContestCoordinates.holodeckGenLoc())) {
            this.generateHolodeck(chunk);
        } else if (chunk.sameChunkAs(ContestCoordinates.marketGenLoc())) {
            this.generateBlackMarket(chunk);
        } else if (chunk.sameChunkAs(ContestCoordinates.huntersGenLoc())) {
            this.generateHunters(chunk);
        } else if (chunk.sameChunkAs(ContestCoordinates.redlightGenLoc())) {
            this.generateRedlight(chunk);
        } else if (chunk.sameChunkAs(ContestCoordinates.bombersGenLoc())) {
            this.generateBombers(chunk);
        } else if (chunk.sameChunkAs(ContestCoordinates.duelGenLoc())) {
            this.generateDuelArena(chunk);
        } else if (chunk.sameChunkAs(ContestCoordinates.lightbridgeGenLoc())) {
            this.generateLightBridge(chunk);
        } else if (chunk.sameChunkAs(ContestCoordinates.targetsGenLoc())) {
            this.generateTargets(chunk);
        } else if (chunk.sameChunkAs(ContestCoordinates.battleSnakesGenLoc())) {
            this.generateBattleSnakes(chunk);
        } else if (chunk.sameChunkAs(ContestCoordinates.laserTagGenLoc())) {
            this.generateLaserWarz(chunk);
        } else if (chunk.sameChunkAs(ContestCoordinates.parkourGenLoc())) {
            this.generateParkour(chunk);
        } else if (chunk.sameChunkAs(ContestCoordinates.dodgeballGenLoc())) {
            this.generateDodgeball(chunk);
        } else if (chunk.sameChunkAs(ContestCoordinates.inkBattleGenLoc())) {
            this.generateInkwars(chunk);
        } else if (chunk.sameChunkAs(ContestCoordinates.treadmillGenLoc())) {
            this.generateObstacleAlley(chunk);
        }
    }

    private void generateContestGrandHall(ChunkPairing chunkIn) {
        int chunkX = chunkIn.chunkX();
        int chunkZ = chunkIn.chunkZ();
        int posX = chunkX * 16;
        int posZ = chunkZ * 16;
        new WorldGenStructure("contest/contest_welcome_p1").func_180709_b(this.world, this.rand, new BlockPos(posX - 20, 30, posZ));
        new WorldGenStructure("contest/contest_welcome_p2").func_180709_b(this.world, this.rand, new BlockPos(posX + 12, 30, posZ));
    }

    private void generateContestGamesRoom(ChunkPairing chunkIn) {
        int chunkX = chunkIn.chunkX();
        int chunkZ = chunkIn.chunkZ();
        int posX = chunkX * 16;
        int posZ = chunkZ * 16;
        new WorldGenStructure("contest/contestofchampionsp1").func_180709_b(this.world, this.rand, new BlockPos(posX - 19, 30, posZ - 19));
        new WorldGenStructure("contest/contestofchampionsp2").func_180709_b(this.world, this.rand, new BlockPos(posX - 19, 30, posZ));
        new WorldGenStructure("contest/contestofchampionsp3").func_180709_b(this.world, this.rand, new BlockPos(posX, 30, posZ - 19));
        new WorldGenStructure("contest/contestofchampionsp4").func_180709_b(this.world, this.rand, new BlockPos(posX, 30, posZ));
    }

    private void generateParkour(ChunkPairing chunkIn) {
        int chunkX = chunkIn.chunkX();
        int chunkZ = chunkIn.chunkZ();
        int posX = chunkX * 16;
        int posZ = chunkZ * 16;
        new WorldGenStructure("contest/contest_parkourtrials_p1").func_180709_b(this.world, this.rand, new BlockPos(posX, 30, posZ));
        new WorldGenStructure("contest/contest_parkourtrials_p2").func_180709_b(this.world, this.rand, new BlockPos(posX + 32, 30, posZ));
    }

    private void generateObstacleAlley(ChunkPairing chunkIn) {
        int chunkX = chunkIn.chunkX();
        int chunkZ = chunkIn.chunkZ();
        int posX = chunkX * 16;
        int posZ = chunkZ * 16;
        new WorldGenStructure("contest/champion_obstaclealley_p1").func_180709_b(this.world, this.rand, new BlockPos(posX, 30, posZ));
        new WorldGenStructure("contest/champion_obstaclealley_p2").func_180709_b(this.world, this.rand, new BlockPos(posX + 32, 30, posZ));
    }

    private void generateDodgeball(ChunkPairing chunkIn) {
        int chunkX = chunkIn.chunkX();
        int chunkZ = chunkIn.chunkZ();
        int posX = chunkX * 16;
        int posZ = chunkZ * 16;
        new WorldGenStructure("contest/contest_dodgeball_p1").func_180709_b(this.world, this.rand, new BlockPos(posX, 30, posZ));
        new WorldGenStructure("contest/contest_dodgeball_p2").func_180709_b(this.world, this.rand, new BlockPos(posX + 32, 30, posZ));
        new WorldGenStructure("contest/contest_dodgeball_p3").func_180709_b(this.world, this.rand, new BlockPos(posX, 30, posZ + 32));
        new WorldGenStructure("contest/contest_dodgeball_p4").func_180709_b(this.world, this.rand, new BlockPos(posX + 32, 30, posZ + 32));
    }

    private void generateDuelArena(ChunkPairing chunkIn) {
        int chunkX = chunkIn.chunkX();
        int chunkZ = chunkIn.chunkZ();
        int posX = chunkX * 16;
        int posZ = chunkZ * 16;
        new WorldGenStructure("contest/contest_duelarena_p1").func_180709_b(this.world, this.rand, new BlockPos(posX, 30, posZ));
        new WorldGenStructure("contest/contest_duelarena_p2").func_180709_b(this.world, this.rand, new BlockPos(posX + 16, 30, posZ));
        new WorldGenStructure("contest/contest_duelarena_p3").func_180709_b(this.world, this.rand, new BlockPos(posX + 48, 30, posZ));
    }

    private void generateLaserWarz(ChunkPairing chunkIn) {
        int chunkX = chunkIn.chunkX();
        int chunkZ = chunkIn.chunkZ();
        int posX = chunkX * 16;
        int posZ = chunkZ * 16;
        new WorldGenStructure("contest/contest_laserwarz_p1").func_180709_b(this.world, this.rand, new BlockPos(posX, 30, posZ));
        new WorldGenStructure("contest/contest_laserwarz_p2").func_180709_b(this.world, this.rand, new BlockPos(posX, 30, posZ + 32));
        new WorldGenStructure("contest/contest_laserwarz_p3").func_180709_b(this.world, this.rand, new BlockPos(posX + 32, 30, posZ));
        new WorldGenStructure("contest/contest_laserwarz_p4").func_180709_b(this.world, this.rand, new BlockPos(posX + 32, 30, posZ + 32));
    }

    private void generateTargets(ChunkPairing chunkIn) {
        int chunkX = chunkIn.chunkX();
        int chunkZ = chunkIn.chunkZ();
        int posX = chunkX * 16;
        int posZ = chunkZ * 16;
        new WorldGenStructure("contest/contest_targets_p1").func_180709_b(this.world, this.rand, new BlockPos(posX, 30, posZ));
        new WorldGenStructure("contest/contest_targets_p2").func_180709_b(this.world, this.rand, new BlockPos(posX, 30, posZ + 10));
    }

    private void generateBattleSnakes(ChunkPairing chunkIn) {
        int chunkX = chunkIn.chunkX();
        int chunkZ = chunkIn.chunkZ();
        int posX = chunkX * 16;
        int posZ = chunkZ * 16;
        new WorldGenStructure("contest/contest_snakes_p1").func_180709_b(this.world, this.rand, new BlockPos(posX, 30, posZ));
        new WorldGenStructure("contest/contest_snakes_p2").func_180709_b(this.world, this.rand, new BlockPos(posX, 30, posZ + 32));
        new WorldGenStructure("contest/contest_snakes_p3").func_180709_b(this.world, this.rand, new BlockPos(posX + 32, 30, posZ));
        new WorldGenStructure("contest/contest_snakes_p4").func_180709_b(this.world, this.rand, new BlockPos(posX + 32, 30, posZ + 32));
    }

    private void generateLightBridge(ChunkPairing chunkIn) {
        int chunkX = chunkIn.chunkX();
        int chunkZ = chunkIn.chunkZ();
        int posX = chunkX * 16;
        int posZ = chunkZ * 16;
        new WorldGenStructure("contest/contest_lightbridge_p1").func_180709_b(this.world, this.rand, new BlockPos(posX, 30, posZ));
        new WorldGenStructure("contest/contest_lightbridge_p2").func_180709_b(this.world, this.rand, new BlockPos(posX + 32, 30, posZ));
    }

    private void generateBlackMarket(ChunkPairing chunkIn) {
        int chunkX = chunkIn.chunkX();
        int chunkZ = chunkIn.chunkZ();
        int posX = chunkX * 16;
        int posZ = chunkZ * 16;
        new WorldGenStructure("contest/contestblackmarket").func_180709_b(this.world, this.rand, new BlockPos(posX, 30, posZ));
        new WorldGenStructure("contest/contest_archeologist").func_180709_b(this.world, this.rand, new BlockPos(posX, 30, posZ + 32));
        new WorldGenStructure("contest/contest_chemist").func_180709_b(this.world, this.rand, new BlockPos(posX + 20, 30, posZ));
    }

    private void generateRedlight(ChunkPairing chunkIn) {
        int chunkX = chunkIn.chunkX();
        int chunkZ = chunkIn.chunkZ();
        int posX = chunkX * 16;
        int posZ = chunkZ * 16;
        new WorldGenStructure("contest/contest_redlight_basearena").func_180709_b(this.world, this.rand, new BlockPos(posX, 10, posZ));
        new WorldGenStructure("contest/contest_redlight_basearena").generateWithRotation(this.world, this.rand, new BlockPos(posX + 32, 10, posZ), Rotation.CLOCKWISE_90);
        new WorldGenStructure("contest/contest_redlight_basearena").generateWithRotation(this.world, this.rand, new BlockPos(posX + 32, 10, posZ + 32), Rotation.CLOCKWISE_180);
        new WorldGenStructure("contest/contest_redlight_basearena").generateWithRotation(this.world, this.rand, new BlockPos(posX, 10, posZ + 32), Rotation.COUNTERCLOCKWISE_90);
        new WorldGenStructure("contest/contest_redlight_toparena").func_180709_b(this.world, this.rand, new BlockPos(posX, 25, posZ));
        new WorldGenStructure("contest/contest_redlight_toparena").generateWithRotation(this.world, this.rand, new BlockPos(posX + 32, 25, posZ), Rotation.CLOCKWISE_90);
        new WorldGenStructure("contest/contest_redlight_toparena").generateWithRotation(this.world, this.rand, new BlockPos(posX + 32, 25, posZ + 32), Rotation.CLOCKWISE_180);
        new WorldGenStructure("contest/contest_redlight_toparena").generateWithRotation(this.world, this.rand, new BlockPos(posX, 25, posZ + 32), Rotation.COUNTERCLOCKWISE_90);
        new WorldGenStructure("contest/contest_redlight_viewdeck_1").func_180709_b(this.world, this.rand, new BlockPos(posX, 35, posZ));
        new WorldGenStructure("contest/contest_redlight_viewdeck_0").generateWithRotation(this.world, this.rand, new BlockPos(posX + 32, 35, posZ), Rotation.CLOCKWISE_90);
        new WorldGenStructure("contest/contest_redlight_viewdeck_0").generateWithRotation(this.world, this.rand, new BlockPos(posX + 32, 35, posZ + 32), Rotation.CLOCKWISE_180);
        new WorldGenStructure("contest/contest_redlight_viewdeck_0").generateWithRotation(this.world, this.rand, new BlockPos(posX, 35, posZ + 32), Rotation.COUNTERCLOCKWISE_90);
        new WorldGenStructure("contest/contest_redlight_lobby").func_180709_b(this.world, this.rand, new BlockPos(posX - 20, 34, posZ + 17));
        new WorldGenStructure(this.randomRedlightGame()).func_180709_b(this.world, this.rand, new BlockPos(posX, 24, posZ));
        new WorldGenStructure(this.randomRedlightGame()).generateWithRotation(this.world, this.rand, new BlockPos(posX + 32, 24, posZ), Rotation.CLOCKWISE_90);
        new WorldGenStructure(this.randomRedlightGame()).generateWithRotation(this.world, this.rand, new BlockPos(posX + 32, 24, posZ + 32), Rotation.CLOCKWISE_180);
        new WorldGenStructure(this.randomRedlightGame()).generateWithRotation(this.world, this.rand, new BlockPos(posX, 24, posZ + 32), Rotation.COUNTERCLOCKWISE_90);
    }

    private void generateHolodeck(ChunkPairing chunkIn) {
        int chunkX = chunkIn.chunkX();
        int chunkZ = chunkIn.chunkZ();
        int posX = chunkX * 16;
        int posZ = chunkZ * 16;
        new WorldGenStructure("contest/holodecklobbyp1").func_180709_b(this.world, this.rand, new BlockPos(posX, 30, posZ));
        new WorldGenStructure("contest/holodecklobbyp2").func_180709_b(this.world, this.rand, new BlockPos(posX + 8, 30, posZ + 32));
        new WorldGenStructure("contest/holodecklobbyp3").func_180709_b(this.world, this.rand, new BlockPos(posX + 32, 30, posZ + 28));
        new WorldGenStructure("contest/holodecklobbyp4").func_180709_b(this.world, this.rand, new BlockPos(posX + 64, 30, posZ + 28));
        int holoX = posX + 27;
        int holoZ = posZ - 16;
        for (int xline = 0; xline < 7; ++xline) {
            for (int zline = 0; zline < 7; ++zline) {
                new WorldGenStructure("holodeckpiece").func_180709_b(this.world, this.rand, new BlockPos(holoX + 6 * xline, 28, holoZ + 6 * zline));
            }
        }
    }

    private void generateHunters(ChunkPairing chunkIn) {
        int chunkX = chunkIn.chunkX();
        int chunkZ = chunkIn.chunkZ();
        int posX = chunkX * 16;
        int posZ = chunkZ * 16;
        new WorldGenStructure("contest/contest_hunters_lobby").func_180709_b(this.world, this.rand, new BlockPos(posX - 18, 30, posZ));
        new WorldGenStructure("contest/contest_hunters_viewdeck_1").func_180709_b(this.world, this.rand, new BlockPos(posX, 29, posZ));
        new WorldGenStructure("contest/contest_hunters_viewdeck_0").generateWithRotation(this.world, this.rand, new BlockPos(posX + 32, 29, posZ), Rotation.CLOCKWISE_90);
        new WorldGenStructure("contest/contest_hunters_viewdeck_0").generateWithRotation(this.world, this.rand, new BlockPos(posX + 32, 29, posZ + 32), Rotation.CLOCKWISE_180);
        new WorldGenStructure("contest/contest_hunters_viewdeck_0").generateWithRotation(this.world, this.rand, new BlockPos(posX, 29, posZ + 32), Rotation.COUNTERCLOCKWISE_90);
        new WorldGenStructure(this.randomHuntersGame()).func_180709_b(this.world, this.rand, new BlockPos(posX, 22, posZ));
        new WorldGenStructure(this.randomHuntersGame()).generateWithRotation(this.world, this.rand, new BlockPos(posX + 32, 22, posZ), Rotation.CLOCKWISE_90);
        new WorldGenStructure(this.randomHuntersGame()).generateWithRotation(this.world, this.rand, new BlockPos(posX + 32, 22, posZ + 32), Rotation.CLOCKWISE_180);
        new WorldGenStructure(this.randomHuntersGame()).generateWithRotation(this.world, this.rand, new BlockPos(posX, 22, posZ + 32), Rotation.COUNTERCLOCKWISE_90);
    }

    private void generateBombers(ChunkPairing chunkIn) {
        int chunkX = chunkIn.chunkX();
        int chunkZ = chunkIn.chunkZ();
        int posX = chunkX * 16;
        int posZ = chunkZ * 16;
        new WorldGenStructure("contest/contest_bombers1").func_180709_b(this.world, this.rand, new BlockPos(posX, 30, posZ));
        new WorldGenStructure("contest/contest_bombers2").func_180709_b(this.world, this.rand, new BlockPos(posX, 30, posZ + 32));
        new WorldGenStructure("contest/contest_bombers3").func_180709_b(this.world, this.rand, new BlockPos(posX + 32, 30, posZ));
        new WorldGenStructure("contest/contest_bombers4").func_180709_b(this.world, this.rand, new BlockPos(posX + 32, 30, posZ + 32));
    }

    private void generateInkwars(ChunkPairing chunkIn) {
        int chunkX = chunkIn.chunkX();
        int chunkZ = chunkIn.chunkZ();
        int posX = chunkX * 16;
        int posZ = chunkZ * 16;
        new WorldGenStructure("contest/contest_inkwars1").func_180709_b(this.world, this.rand, new BlockPos(posX, 30, posZ));
        new WorldGenStructure("contest/contest_inkwars2").func_180709_b(this.world, this.rand, new BlockPos(posX, 30, posZ + 32));
        new WorldGenStructure("contest/contest_inkwars3").func_180709_b(this.world, this.rand, new BlockPos(posX + 32, 30, posZ));
        new WorldGenStructure("contest/contest_inkwars4").func_180709_b(this.world, this.rand, new BlockPos(posX + 32, 30, posZ + 32));
    }

    private String randomHuntersGame() {
        int game_pick = this.rand.nextInt(7);
        return "contest/contest_hunters_game" + ++game_pick;
    }

    private String randomRedlightGame() {
        int game_pick = this.rand.nextInt(12);
        return "contest/contest_redlight_arena_" + ++game_pick;
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
}

