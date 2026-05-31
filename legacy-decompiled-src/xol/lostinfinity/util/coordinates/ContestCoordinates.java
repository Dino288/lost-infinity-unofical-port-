/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.math.AABB
 *  net.minecraft.util.math.BlockPos
 */
package xol.lostinfinity.util.coordinates;

import java.util.ArrayList;
import net.minecraft.world.phys.AABB;
import net.minecraft.core.BlockPos;
import xol.lostinfinity.dimension.data.ChunkPairing;

public class ContestCoordinates {
    public static ChunkPairing grandHallGenLoc() {
        return new ChunkPairing(0, 0);
    }

    public static ChunkPairing gamesLobbyGenLoc() {
        return new ChunkPairing(-5, 0);
    }

    public static ChunkPairing marketGenLoc() {
        return new ChunkPairing(5, 0);
    }

    public static BlockPos grandEntryPos() {
        return new BlockPos(-14.0, 32.0, 14.5);
    }

    public static BlockPos gamesLobbyPos() {
        return new BlockPos(-93.0, 34.0, 0.0);
    }

    public static BlockPos lobbyHologramPos() {
        return new BlockPos(-80, 40, 0);
    }

    public static BlockPos blackMarketPos() {
        return new BlockPos(92.0, 33.5, 8.0);
    }

    public static BlockPos archeologistPos() {
        return new BlockPos(92.0, 33.5, 39.0);
    }

    public static BlockPos chemistPos() {
        return new BlockPos(111.0, 33.5, 8.0);
    }

    public static ChunkPairing holodeckGenLoc() {
        return new ChunkPairing(5, 5);
    }

    public static AABB holodeckArenaAABB() {
        return new AABB(new BlockPos(106, 24, 63), new BlockPos(148, 37, 104));
    }

    public static AABB holodeckLobbyAABB() {
        return new AABB(new BlockPos(88, 34, 81), new BlockPos(101, 39, 89));
    }

    public static AABB holodeckControllerAABB() {
        return new AABB(new BlockPos(124, 40, 82), new BlockPos(130, 48, 86));
    }

    public static BlockPos holodeckControllerPos() {
        return new BlockPos(127.5, 42.0, 84.5);
    }

    public static BlockPos holodeckLobbyPos() {
        return new BlockPos(94.0, 35.2, 98.0);
    }

    public static BlockPos holodeckTelportPos() {
        return new BlockPos(151, 35, 125);
    }

    public static ChunkPairing huntersGenLoc() {
        return new ChunkPairing(5, 10);
    }

    public static AABB huntersArenaAABB() {
        return new AABB(new BlockPos(80, 20, 160), new BlockPos(142, 42, 222));
    }

    public static AABB huntersLobbyAABB() {
        return new AABB(new BlockPos(68, 30, 180), new BlockPos(77, 36, 190));
    }

    public static BlockPos huntersArenaCenterPos() {
        AABB arena = ContestCoordinates.huntersArenaAABB();
        return new BlockPos((arena.field_72340_a + arena.field_72336_d) / 2.0, arena.field_72338_b + 5.0, (arena.field_72339_c + arena.field_72334_f) / 2.0);
    }

    public static BlockPos huntersControllerPos() {
        return new BlockPos(112.5, 29.5, 192.5);
    }

    public static BlockPos huntersLobbyPos() {
        return new BlockPos(70, 32, 165);
    }

    public static ChunkPairing redlightGenLoc() {
        return new ChunkPairing(5, -5);
    }

    public static BlockPos redlightLobbyPos() {
        return new BlockPos(65.0, 37.0, -53.5);
    }

    public static BlockPos redlightControllerPos() {
        return new BlockPos(112.5, 32.0, -73.0);
    }

    public static AABB redlightArenaAABB() {
        return new AABB(new BlockPos(86, 10, -73), new BlockPos(138, 41, -22));
    }

    public static AABB redlightLobbyAABB() {
        return new AABB(new BlockPos(71, 37, -50), new BlockPos(77, 41, -39));
    }

    public static ChunkPairing bombersGenLoc() {
        return new ChunkPairing(5, -10);
    }

    public static BlockPos bombersArenaPos() {
        return new BlockPos(92.0, 34.0, -148.0);
    }

    public static BlockPos bombersLobbyPos() {
        return new BlockPos(88.0, 39.0, -152.5);
    }

    public static BlockPos bombersControllerPos() {
        return new BlockPos(112.5, 37.0, -128.5);
    }

    public static AABB bombersArenaAABB() {
        return new AABB(new BlockPos(91, 34, -149), new BlockPos(137, 36, -102));
    }

    public static AABB bombersLobbyAABB() {
        return new AABB(new BlockPos(85, 32, -138), new BlockPos(90, 36, -124));
    }

    public static AABB bombersControllerAABB() {
        return new AABB(new BlockPos(110, 35, -130), new BlockPos(114, 45, -126));
    }

    public static ChunkPairing duelGenLoc() {
        return new ChunkPairing(5, 15);
    }

    public static BlockPos duelLobbyPos() {
        return new BlockPos(85, 43, 255);
    }

    public static AABB duelArenaAABB() {
        return new AABB(new BlockPos(97, 31, 242), new BlockPos(160, 50, 280));
    }

    public static AABB duelLobbyAABB() {
        return new AABB(new BlockPos(81, 33, 245), new BlockPos(90, 38, 251));
    }

    public static ChunkPairing lightbridgeGenLoc() {
        return new ChunkPairing(5, -15);
    }

    public static BlockPos lightBridgeControllerPos() {
        return new BlockPos(116, 49, -223);
    }

    public static AABB lightBridgeArenaAABB() {
        return new AABB(new BlockPos(94, 37, -237), new BlockPos(140, 60, -219));
    }

    public static AABB lightBridgeLobbyAABB() {
        return new AABB(new BlockPos(83, 51, -235), new BlockPos(90, 54, -222));
    }

    public static BlockPos lightBridgeArenaPos() {
        return new BlockPos(97, 45, -237);
    }

    public static BlockPos lightBridgeLobbyPos() {
        return new BlockPos(137.0, 51.5, -213.0);
    }

    public static AABB lightBridgeBoardAABB() {
        return new AABB(new BlockPos(98, 45, -237), new BlockPos(137, 45, -220));
    }

    public static ChunkPairing targetsGenLoc() {
        return new ChunkPairing(5, 20);
    }

    public static BlockPos targetsLobbyPos() {
        return new BlockPos(84.0, 37.5, 326.0);
    }

    public static BlockPos targetsSpawnPos() {
        return new BlockPos(106, 34, 335);
    }

    public static BlockPos targetsControllerPos() {
        return new BlockPos(106, 39, 344);
    }

    public static BlockPos duelControllerPos() {
        return new BlockPos(123, 38, 270);
    }

    public static BlockPos duelFrame1Pos() {
        return new BlockPos(91, 44, 246);
    }

    public static BlockPos duelFrame2Pos() {
        return new BlockPos(93, 44, 246);
    }

    public static AABB targetsArenaAABB() {
        return new AABB(new BlockPos(70, 32, 320), new BlockPos(108, 42, 359));
    }

    public static AABB targetsLobbyAABB() {
        return new AABB(new BlockPos(103, 36, 323), new BlockPos(111, 40, 328));
    }

    public static ChunkPairing battleSnakesGenLoc() {
        return new ChunkPairing(10, 0);
    }

    public static BlockPos battleSnakesControllerPos() {
        return new BlockPos(192, 51, 31);
    }

    public static AABB battleSnakesArenaAABB() {
        return new AABB(new BlockPos(162, 40, 2), new BlockPos(221, 60, 62));
    }

    public static AABB battleSnakesLobbyAABB() {
        return new AABB(new BlockPos(162, 32, 2), new BlockPos(173, 37, 13));
    }

    public static BlockPos battleSnakesArenaPos() {
        return new BlockPos(163, 39, 4);
    }

    public static BlockPos battleSnakesLobbyPos() {
        return new BlockPos(190, 34, 27);
    }

    public static AABB battleSnakesBoardAABB() {
        return new AABB(new BlockPos(164, 39, 4), new BlockPos(220, 39, 59));
    }

    public static ArrayList<BlockPos> battleSnakeSpawnPositions() {
        ArrayList<BlockPos> spawnPositions = new ArrayList<BlockPos>();
        spawnPositions.add(new BlockPos(163, 57, 32));
        spawnPositions.add(new BlockPos(191, 57, 3));
        spawnPositions.add(new BlockPos(220, 57, 32));
        spawnPositions.add(new BlockPos(192, 57, 60));
        return spawnPositions;
    }

    public static ArrayList<BlockPos> battleSnakeControlPositions() {
        ArrayList<BlockPos> controlPositions = new ArrayList<BlockPos>();
        controlPositions.add(new BlockPos(166, 55, 31));
        controlPositions.add(new BlockPos(192, 55, 6));
        controlPositions.add(new BlockPos(217, 55, 31));
        controlPositions.add(new BlockPos(192, 55, 57));
        return controlPositions;
    }

    public static ChunkPairing laserTagGenLoc() {
        return new ChunkPairing(10, 10);
    }

    public static BlockPos laserTagLobbyPos() {
        return new BlockPos(164.0, 42.5, 164.0);
    }

    public static AABB laserTagArenaAABB() {
        return new AABB(new BlockPos(163, 32, 163), new BlockPos(199, 40, 199));
    }

    public static AABB laserTagLobbyAABB() {
        return new AABB(new BlockPos(170, 41, 170), new BlockPos(177, 46, 177));
    }

    public static BlockPos laserTagControllerPos() {
        return new BlockPos(190, 42, 189);
    }

    public static ArrayList<BlockPos> laserTagSpawnPositions() {
        ArrayList<BlockPos> spawnPositions = new ArrayList<BlockPos>();
        spawnPositions.add(new BlockPos(99, 33, 256));
        spawnPositions.add(new BlockPos(122, 33, 244));
        spawnPositions.add(new BlockPos(155, 33, 256));
        spawnPositions.add(new BlockPos(126, 33, 267));
        return spawnPositions;
    }

    public static AABB laserTagControllerAABB() {
        return new AABB(new BlockPos(186, 38, 186), new BlockPos(193, 47, 193));
    }

    public static ChunkPairing parkourGenLoc() {
        return new ChunkPairing(11, 15);
    }

    public static BlockPos parkourSpawnPos() {
        return new BlockPos(187, 46, 254);
    }

    public static BlockPos parkourControllerPos() {
        return new BlockPos(201, 39, 243);
    }

    public static AABB parkourArenaAABB() {
        return new AABB(new BlockPos(186, 30, 243), new BlockPos(237, 58, 269));
    }

    public static AABB parkourLobbyAABB() {
        return new AABB(new BlockPos(177, 45, 247), new BlockPos(182, 49, 256));
    }

    public static BlockPos parkourLobbyPos() {
        return new BlockPos(181.0, 51.5, 267.0);
    }

    public static AABB parkourGridAABB() {
        return new AABB(new BlockPos(189, 39, 246), new BlockPos(233, 58, 265));
    }

    public static ChunkPairing dodgeballGenLoc() {
        return new ChunkPairing(11, -5);
    }

    public static BlockPos dodgeballControllerPos() {
        return new BlockPos(208, 42, -48);
    }

    public static BlockPos dodgeballLobbyPos() {
        return new BlockPos(180.0, 54.5, -75.0);
    }

    public static AABB dodgeballArenaAABB() {
        return new AABB(new BlockPos(183, 28, -73), new BlockPos(233, 62, -23));
    }

    public static AABB dodgeballLobbyAABB() {
        return new AABB(new BlockPos(177, 52, -28), new BlockPos(187, 61, -18));
    }

    public static BlockPos dodgeballWaitingRoomPos() {
        return new BlockPos(235, 55, -48);
    }

    public static ArrayList<BlockPos> dodgeballSpawnPositions() {
        ArrayList<BlockPos> spawnPositions = new ArrayList<BlockPos>();
        spawnPositions.add(new BlockPos(189, 35, -57));
        spawnPositions.add(new BlockPos(201, 35, -25));
        spawnPositions.add(new BlockPos(229, 35, -44));
        spawnPositions.add(new BlockPos(226, 35, -66));
        spawnPositions.add(new BlockPos(191, 35, -39));
        spawnPositions.add(new BlockPos(221, 35, -27));
        spawnPositions.add(new BlockPos(212, 35, -69));
        spawnPositions.add(new BlockPos(199, 35, -56));
        spawnPositions.add(new BlockPos(187, 25, -37));
        spawnPositions.add(new BlockPos(208, 37, -49));
        return spawnPositions;
    }

    public static ChunkPairing inkBattleGenLoc() {
        return new ChunkPairing(10, -10);
    }

    public static BlockPos inkBattleLobbyPos() {
        return new BlockPos(166.0, 39.5, -152.0);
    }

    public static AABB inkBattleArenaAABB() {
        return new AABB(new BlockPos(170, 31, -150), new BlockPos(218, 51, -102));
    }

    public static AABB inkBattleLobbyAABB() {
        return new AABB(new BlockPos(165, 31, -150), new BlockPos(170, 35, -125));
    }

    public static BlockPos inkBattleControllerPos() {
        return new BlockPos(195, 31, -126);
    }

    public static ArrayList<BlockPos> inkBattleSpawnPositions() {
        ArrayList<BlockPos> spawnPositions = new ArrayList<BlockPos>();
        spawnPositions.add(new BlockPos(181, 42, -139));
        spawnPositions.add(new BlockPos(181, 42, -113));
        spawnPositions.add(new BlockPos(198, 42, -113));
        spawnPositions.add(new BlockPos(208, 42, -113));
        spawnPositions.add(new BlockPos(208, 42, -130));
        spawnPositions.add(new BlockPos(208, 42, -140));
        return spawnPositions;
    }

    public static AABB inkBattleControllerAABB() {
        return new AABB(new BlockPos(170, 31, -150), new BlockPos(218, 51, -102));
    }

    public static ArrayList<BlockPos> inkBattlePowerUpPositions() {
        ArrayList<BlockPos> powerUpPositions = new ArrayList<BlockPos>();
        powerUpPositions.add(new BlockPos(203, 36, -135));
        powerUpPositions.add(new BlockPos(186, 36, -135));
        powerUpPositions.add(new BlockPos(178, 39, -126));
        powerUpPositions.add(new BlockPos(176, 35, -110));
        powerUpPositions.add(new BlockPos(194, 35, -134));
        powerUpPositions.add(new BlockPos(203, 36, -117));
        powerUpPositions.add(new BlockPos(186, 36, -118));
        return powerUpPositions;
    }

    public static ChunkPairing treadmillGenLoc() {
        return new ChunkPairing(15, 0);
    }

    public static BlockPos treadmillLobbyPos() {
        return new BlockPos(298.0, 51.5, 26.0);
    }

    public static AABB treadmillArenaAABB() {
        return new AABB(new BlockPos(262, 35, 1), new BlockPos(300, 53, 22));
    }

    public static AABB treadmillLobbyAABB() {
        return new AABB(new BlockPos(241, 49, 3), new BlockPos(252, 57, 20));
    }

    public static BlockPos treadmillControllerPos() {
        return new BlockPos(286, 25, 10);
    }

    public static ArrayList<BlockPos> treadmillSpawnPositions() {
        ArrayList<BlockPos> spawnPositions = new ArrayList<BlockPos>();
        spawnPositions.add(new BlockPos(266, 46, 6));
        spawnPositions.add(new BlockPos(266, 46, 8));
        spawnPositions.add(new BlockPos(266, 46, 10));
        spawnPositions.add(new BlockPos(266, 46, 12));
        spawnPositions.add(new BlockPos(266, 46, 14));
        spawnPositions.add(new BlockPos(266, 46, 16));
        return spawnPositions;
    }

    public static AABB treadmillControllerAABB() {
        return new AABB(new BlockPos(262, 35, 1), new BlockPos(300, 53, 22));
    }

    public static AABB treadmillGridAABB() {
        return new AABB(new BlockPos(263, 43, 3), new BlockPos(300, 50, 20));
    }
}

