package xol.lostinfinity.dimension;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Random;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.chunk.ChunkStatus;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.minecraftforge.event.level.ChunkEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import xol.lostinfinity.LostInfinity;

@Mod.EventBusSubscriber(modid = LostInfinity.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public final class LostOriginalStructureGeneration {
    private static final Grid STARFORGE_DUNGEON = Grid.load("data/lostinfinity/structures/predefined/starforge_dungeon.csv");

    private LostOriginalStructureGeneration() {
    }

    @SubscribeEvent
    public static void onChunkLoad(ChunkEvent.Load event) {
        if (!event.isNewChunk() || !(event.getLevel() instanceof ServerLevel level)) {
            return;
        }
        ChunkAccess chunk = event.getChunk();
        if (!chunk.getStatus().isOrAfter(ChunkStatus.FULL)) {
            return;
        }

        String dimension = level.dimension().location().getPath();
        int chunkX = chunk.getPos().x;
        int chunkZ = chunk.getPos().z;
        if ("cartographerrealmtop".equals(dimension)) {
            generateCartographer(level, chunkX, chunkZ, Floor.TOP);
        } else if ("cartographerrealmmid".equals(dimension)) {
            generateCartographer(level, chunkX, chunkZ, Floor.MID);
        } else if ("cartographerrealmbot".equals(dimension)) {
            generateCartographer(level, chunkX, chunkZ, Floor.BOT);
            generatePuzzleMasterOrigin(level, chunkX, chunkZ);
        } else if ("nonexistence".equals(dimension)) {
            generateNonexistenceGalaxy(level, chunkX, chunkZ);
        }
    }

    private static void generateNonexistenceGalaxy(ServerLevel level, int chunkX, int chunkZ) {
        GridNode node = STARFORGE_DUNGEON.getNodeAtLocation(chunkX, chunkZ, -14, 52);
        if (node == null) {
            return;
        }
        Random random = seededRandom(level, chunkX, chunkZ);
        String structure = nonexistenceStructure(node.pieceType(), random);
        if (structure.isEmpty()) {
            return;
        }

        int posX = chunkX * 16 + 8;
        int posZ = chunkZ * 16 + 8;
        String[] parts = structure.split(",");
        placeTemplate(level, parts[0], new BlockPos(posX, 80 + node.heightOffset(), posZ), node.rotation(random), random);
        if (parts.length > 1) {
            ExtraStructure extra = extraStructure(parts[1], random);
            if (extra != null) {
                placeTemplate(level, extra.name(), new BlockPos(posX + random.nextInt(extra.xOffsetCap()), 80 + node.heightOffset() + extra.yOffset(), posZ + random.nextInt(extra.zOffsetCap())), extra.rotation(), random);
            }
        }
    }

    private static void generateCartographer(ServerLevel level, int chunkX, int chunkZ, Floor floor) {
        Random random = seededRandom(level, chunkX, chunkZ);
        String topName;
        String bottomName;
        int xOffset = Math.abs(chunkX % 10);
        int zOffset = Math.abs(chunkZ % 10);
        if (xOffset == 0 && zOffset == 0) {
            if (chunkX == chunkZ) {
                bottomName = gateRoom(floor);
                topName = teleRoom(floor);
            } else {
                bottomName = teleRoom(floor);
                topName = gateRoom(floor);
            }
        } else {
            int stylePick = random.nextInt(20);
            if (stylePick == 0) {
                topName = crossRoom(floor, random);
                bottomName = portalRoom(floor, random);
            } else if (stylePick == 2) {
                topName = crossRoom(floor, random);
                bottomName = gameRoom(floor, random);
            } else if (stylePick == 3) {
                topName = gameRoom(floor, random);
                bottomName = crossRoom(floor, random);
            } else if (stylePick == 4 || stylePick == 5) {
                topName = crossRoom(floor, random);
                bottomName = crossRoom(floor, random);
            } else if (stylePick == 6 || stylePick == 7) {
                String[] stairs = stairsRoom(floor, random);
                topName = stairs[0];
                bottomName = stairs[1];
            } else if (stylePick == 8) {
                String[] room = twoLevelRoom(floor, random);
                topName = room[0];
                bottomName = room[1];
            } else {
                topName = connectorRoom(floor, random);
                bottomName = connectorRoom(floor, random);
            }
        }

        int posX = chunkX * 16 + 8;
        int posZ = chunkZ * 16 + 8;
        placeTemplate(level, topName, new BlockPos(posX, 20, posZ), randomRotation(random), random);
        placeTemplate(level, bottomName, new BlockPos(posX, 11, posZ), randomRotation(random), random);
    }

    private static void generatePuzzleMasterOrigin(ServerLevel level, int chunkX, int chunkZ) {
        if (Math.abs(chunkX) > 1 || Math.abs(chunkZ) > 1) {
            return;
        }
        String structure = null;
        if (chunkX == -1 && chunkZ == -1) {
            structure = "labyrinth/labyrinth_puzzlemaster1";
        } else if (chunkX == 0 && chunkZ == -1) {
            structure = "labyrinth/labyrinth_puzzlemaster2";
        } else if (chunkX == -1 && chunkZ == 0) {
            structure = "labyrinth/labyrinth_puzzlemaster3";
        } else if (chunkX == 0 && chunkZ == 0) {
            structure = "labyrinth/labyrinth_puzzlemaster4";
        }
        if (structure != null) {
            placeTemplate(level, structure, new BlockPos(chunkX * 16 + 8, 30, chunkZ * 16 + 8), Rotation.NONE, seededRandom(level, chunkX, chunkZ));
        }
    }

    private static void placeTemplate(ServerLevel level, String name, BlockPos pos, Rotation rotation, Random random) {
        ResourceLocation location = new ResourceLocation(LostInfinity.MODID, name);
        StructureTemplate template = level.getStructureManager().getOrCreate(location);
        StructurePlaceSettings settings = new StructurePlaceSettings()
                .setRotation(rotation)
                .setRandom(RandomSource.create(random.nextLong()))
                .setIgnoreEntities(false)
                .setFinalizeEntities(true);
        BlockPos adjusted = adjustedForRotation(pos, rotation, template);
        template.placeInWorld(level, adjusted, adjusted, settings, RandomSource.create(random.nextLong()), 2);
    }

    private static BlockPos adjustedForRotation(BlockPos position, Rotation rotation, StructureTemplate template) {
        var size = template.getSize();
        return switch (rotation) {
            case CLOCKWISE_90 -> position.offset(size.getZ() - 1, 0, 0);
            case CLOCKWISE_180 -> position.offset(size.getX() - 1, 0, size.getZ() - 1);
            case COUNTERCLOCKWISE_90 -> position.offset(0, 0, size.getX() - 1);
            default -> position;
        };
    }

    private static Random seededRandom(ServerLevel level, int chunkX, int chunkZ) {
        Random random = new Random(level.getSeed());
        long k = random.nextLong() / 2L * 2L + 1L;
        long l = random.nextLong() / 2L * 2L + 1L;
        random.setSeed((long) chunkX * k + (long) chunkZ * l ^ level.getSeed());
        return random;
    }

    private static Rotation randomRotation(Random random) {
        return switch (random.nextInt(4)) {
            case 1 -> Rotation.CLOCKWISE_90;
            case 2 -> Rotation.COUNTERCLOCKWISE_90;
            case 3 -> Rotation.CLOCKWISE_180;
            default -> Rotation.NONE;
        };
    }

    private static Rotation rotationFromInt(int rotation, Random random) {
        return switch (rotation) {
            case 1 -> Rotation.CLOCKWISE_90;
            case -1 -> Rotation.COUNTERCLOCKWISE_90;
            case 2 -> Rotation.CLOCKWISE_180;
            case 7 -> random.nextBoolean() ? Rotation.CLOCKWISE_90 : Rotation.COUNTERCLOCKWISE_90;
            case 8 -> random.nextBoolean() ? Rotation.NONE : Rotation.CLOCKWISE_180;
            case 9 -> rotationFromInt(random.nextInt(4) - 1, random);
            default -> Rotation.NONE;
        };
    }

    private static String nonexistenceStructure(String name, Random random) {
        int areaNumIdx = getAreaNumIdx(name);
        int areaNum = areaNumIdx == 0 ? -1 : Integer.parseInt(name.substring(0, areaNumIdx));
        String pieceType = name.substring(areaNumIdx);
        return switch (areaNum) {
            case 0 -> mineShaftsStructure(pieceType, random);
            case 1 -> mineShaftPoisStructure(pieceType);
            case 2 -> starforgeMinesStructure(pieceType, random);
            case 3 -> galaxyDungeonStructure(pieceType);
            default -> "";
        };
    }

    private static int getAreaNumIdx(String name) {
        int i = 0;
        while (i < name.length() && Character.isDigit(name.charAt(i))) {
            i++;
        }
        return i;
    }

    private static String mineShaftsStructure(String pieceType, Random random) {
        return switch (pieceType) {
            case "tsect" -> randomPiece("forgemines", "forgeminestsect", 2, random);
            case "end" -> randomPiece("forgemines", "forgeminesend", 3, random);
            case "turn" -> randomPiece("forgemines", "forgeminesturn", 3, random);
            case "shaft" -> randomPiece("forgemines", "forgeminesshaft", 8, random);
            case "stairs" -> randomPiece("forgemines", "forge_mines_stairs", 6, random);
            case "secur1" -> "starforge/forgeclearance1";
            case "secur3" -> "starforge/forgeclearance3";
            case "forgegen" -> "starforge/forgemines_powergen";
            case "forgeterm" -> "starforge/forgemines_powerterminal";
            case "rworm" -> randomPiece("forgemines", "forgemines_rockworm", 2, random);
            default -> "";
        };
    }

    private static String mineShaftPoisStructure(String pieceType) {
        return switch (pieceType) {
            case "starforge" -> "starforge/starforge_forge";
            case "entry" -> "forgemines/forgemines_entry";
            case "dark" -> "twistedtunnels/twistedtunnel_entrytop,twistedtunnel_entrybot";
            case "sunderbr" -> "starforge/sundertree2";
            case "sundertr" -> "starforge/sundertree4";
            case "sunderbl" -> "starforge/sundertree1";
            case "sundertl" -> "starforge/sundertree3,hiveent";
            case "hive1" -> "starforge/sunder_hive_bottom_1,hive1";
            case "hive2" -> "starforge/sunder_hive_bottom_2,hive2";
            case "hive3" -> "starforge/sunder_hive_bottom_3,hive3";
            case "hive4" -> "starforge/sunder_hive_bottom_4,hive4";
            case "clovm1" -> "starforge/clovinite_mine1";
            case "clovm2" -> "starforge/clovinite_mine2";
            case "clovm3" -> "starforge/clovinite_mine3";
            case "clovm4" -> "starforge/clovinite_mine4";
            case "cata1" -> "starforge/catatonite_mine1";
            case "cata2" -> "starforge/catatonite_mine2";
            case "cata3" -> "starforge/catatonite_mine3";
            case "cata4" -> "starforge/catatonite_mine4";
            default -> "";
        };
    }

    private static String starforgeMinesStructure(String pieceType, Random random) {
        return switch (pieceType) {
            case "minescr" -> "forgemines/forge_mines_corner";
            case "minesgw" -> "forgemines/forge_mines_door";
            case "minesgwo" -> "forgemines/forge_mines_dooropen";
            case "minegen" -> "forgemines/forge_mines_powergen";
            case "mines" -> randomPiece("forgemines", "forge_mines", 16, random) + ",orepillar";
            case "minesed" -> randomPiece("forgemines", "forge_mines_wall", 10, random);
            case "mycave1" -> "forgemines/forgemines_myrite_cave1";
            case "mycave2" -> "forgemines/forgemines_myrite_cave2";
            case "mycave3" -> "forgemines/forgemines_myrite_cave3";
            case "mycave4" -> "forgemines/forgemines_myrite_cave4";
            case "mypass" -> "forgemines/forgemines_myrite_passage";
            case "mywall" -> "forgemines/forgemines_myrite_wall";
            case "myentry" -> "forgemines/forgemines_myrite_entry";
            default -> "";
        };
    }

    private static String randomPiece(String folder, String prefix, int count, Random random) {
        return folder + "/" + prefix + (random.nextInt(count) + 1);
    }

    private static String galaxyDungeonStructure(String pieceType) {
        return switch (pieceType) {
            case "galaxy1" -> "galaxy/galaxy_dungeon_lower1,galaxy1";
            case "galaxy2" -> "galaxy/galaxy_dungeon_lower2,galaxy2";
            case "galaxy3" -> "galaxy/galaxy_dungeon_lower3,galaxy3";
            case "galaxy4" -> "galaxy/galaxy_dungeon_lower4,galaxy4";
            case "galblue" -> "galaxy/galaxy_basic_blue";
            case "galgreen" -> "galaxy/galaxy_basic_green";
            case "galyellow" -> "galaxy/galaxy_basic_yellow";
            case "galpink" -> "galaxy/galaxy_basic_pink";
            case "galsword" -> "galaxy/galaxy_elite_sword";
            case "galbomb" -> "galaxy/galaxy_elite_bomb";
            case "galknife" -> "galaxy/galaxy_elite_knife";
            case "gallight1" -> "galaxy/galaxy_lightmaze1";
            case "gallight2" -> "galaxy/galaxy_lightmaze2";
            case "gallight3" -> "galaxy/galaxy_lightmaze3";
            case "gallight4" -> "galaxy/galaxy_lightmaze4";
            case "galterror1" -> "galaxy/galaxy_shockarena1";
            case "galterror2" -> "galaxy/galaxy_shockarena2";
            case "galterror3" -> "galaxy/galaxy_shockarena3";
            case "galterror4" -> "galaxy/galaxy_shockarena4";
            default -> "";
        };
    }

    private static ExtraStructure extraStructure(String name, Random random) {
        return switch (name) {
            case "orepillar" -> new ExtraStructure(randomPiece("forgemines", "forgemines_orepillar", 10, random), 0, 5, 5, rotationFromInt(9, random));
            case "twistedtunnel_entrybot" -> new ExtraStructure("twistedtunnels/twistedtunnel_entrybot", -32, 1, 1, Rotation.COUNTERCLOCKWISE_90);
            case "galaxy1" -> new ExtraStructure("galaxy/galaxy_dungeon_upper1", 19, 1, 1, Rotation.NONE);
            case "galaxy2" -> new ExtraStructure("galaxy/galaxy_dungeon_upper2", 19, 1, 1, Rotation.NONE);
            case "galaxy3" -> new ExtraStructure("galaxy/galaxy_dungeon_upper3", 19, 1, 1, Rotation.NONE);
            case "galaxy4" -> new ExtraStructure("galaxy/galaxy_dungeon_upper4", 19, 1, 1, Rotation.NONE);
            case "hiveent" -> new ExtraStructure("starforge/sunder_hive_entry", -13, 1, 1, Rotation.NONE);
            case "hive1" -> new ExtraStructure("starforge/sunder_hive_top_1", 32, 1, 1, Rotation.NONE);
            case "hive2" -> new ExtraStructure("starforge/sunder_hive_top_2", 32, 1, 1, Rotation.NONE);
            case "hive3" -> new ExtraStructure("starforge/sunder_hive_top_3", 32, 1, 1, Rotation.NONE);
            case "hive4" -> new ExtraStructure("starforge/sunder_hive_top_4", 32, 1, 1, Rotation.NONE);
            default -> null;
        };
    }

    private static String teleRoom(Floor floor) {
        return switch (floor) {
            case TOP -> "labyrinth/labteleroom";
            case MID -> "labyrinth/lowerlabcross3";
            case BOT -> "labyrinth/bottomlabcross1";
        };
    }

    private static String gateRoom(Floor floor) {
        return switch (floor) {
            case TOP -> "labyrinth/labgateroom";
            case MID -> "labyrinth/lowerlabcross3";
            case BOT -> "labyrinth/bottomlabcross1";
        };
    }

    private static String[] stairsRoom(Floor floor, Random random) {
        return switch (floor) {
            case TOP -> {
                int style = random.nextInt(2) + 1;
                yield new String[] { "labyrinth/labelevatortop" + style, "labyrinth/labelevatorbase" + style };
            }
            case MID -> new String[] { "labyrinth/lowerlabelevatortop", "labyrinth/lowerlabelevatorbase" };
            case BOT -> new String[] { "labyrinth/bottomlabelevatortop", "labyrinth/bottomlabelevatorbot" };
        };
    }

    private static String[] twoLevelRoom(Floor floor, Random random) {
        return switch (floor) {
            case TOP -> new String[] { "labyrinth/labaspectroom", "labyrinth/labgameroom" + (random.nextInt(3) + 1) };
            case MID -> random.nextBoolean()
                    ? new String[] { "labyrinth/lowerlabtimelinetop", "labyrinth/lowerlabtimelinebase" + (random.nextInt(2) + 1) }
                    : new String[] { "labyrinth/labitemchalltop", "labyrinth/labitemchallbot" };
            case BOT -> new String[] { "labyrinth/bottomlabelevatortop", "labyrinth/bottomlabelevatorbot" };
        };
    }

    private static String connectorRoom(Floor floor, Random random) {
        return switch (floor) {
            case TOP -> "labyrinth/labconnector" + (random.nextInt(16) + 1);
            case MID -> "labyrinth/lowerlabcon" + (random.nextInt(16) + 1);
            case BOT -> "labyrinth/bottomlabcon" + (random.nextInt(16) + 1);
        };
    }

    private static String crossRoom(Floor floor, Random random) {
        return switch (floor) {
            case TOP -> "labyrinth/labcross" + (random.nextInt(8) + 1);
            case MID -> "labyrinth/lowerlabcross" + (random.nextInt(6) + 1);
            case BOT -> "labyrinth/bottomlabcross" + (random.nextInt(5) + 1);
        };
    }

    private static String gameRoom(Floor floor, Random random) {
        return switch (floor) {
            case TOP -> "labyrinth/labspeccross" + (random.nextInt(13) + 1);
            case MID -> "labyrinth/lowerlabspeccross" + (random.nextInt(12) + 1);
            case BOT -> "labyrinth/bottomlabspeccross" + (random.nextInt(11) + 1);
        };
    }

    private static String portalRoom(Floor floor, Random random) {
        return switch (floor) {
            case TOP -> "labyrinth/labportal";
            case MID -> "labyrinth/lowerlabportal";
            case BOT -> "labyrinth/bottomlabcon" + (random.nextInt(16) + 1);
        };
    }

    private enum Floor {
        TOP,
        MID,
        BOT
    }

    private record ExtraStructure(String name, int yOffset, int xOffsetCap, int zOffsetCap, Rotation rotation) {
    }

    private record GridNode(String pieceType, int rotation, int heightOffset) {
        private Rotation rotation(Random random) {
            return rotationFromInt(rotation, random);
        }
    }

    private record Grid(GridNode[][] nodes, int rows, int columns) {
        private static Grid load(String path) {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                    LostOriginalStructureGeneration.class.getClassLoader().getResourceAsStream(path), StandardCharsets.UTF_8))) {
                var lines = reader.lines().toList();
                int rows = lines.size();
                int columns = rows == 0 ? 0 : lines.get(0).split(",", -1).length;
                GridNode[][] nodes = new GridNode[rows][columns];
                for (int row = 0; row < rows; row++) {
                    String[] values = lines.get(row).split(",", -1);
                    for (int column = 0; column < values.length; column++) {
                        if (values[column].isEmpty()) {
                            continue;
                        }
                        String[] data = values[column].split(":");
                        int yOffset = data.length > 2 ? Integer.parseInt(data[2]) : 0;
                        nodes[row][column] = new GridNode(data[0], Integer.parseInt(data[1]), yOffset);
                    }
                }
                return new Grid(nodes, rows, columns);
            } catch (IOException | NullPointerException ex) {
                LostInfinity.LOGGER.warn("Unable to load Lost Infinity structure grid {}", path, ex);
                return new Grid(new GridNode[0][0], 0, 0);
            }
        }

        private GridNode getNodeAtLocation(int x, int z, int offsetX, int offsetZ) {
            int row = rows - 1 - x + offsetX;
            int column = z + offsetZ;
            if (row < 0 || column < 0 || row >= rows || column >= columns) {
                return null;
            }
            return nodes[row][column];
        }
    }
}
