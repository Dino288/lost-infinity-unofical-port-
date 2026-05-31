package xol.lostinfinity.dimension;

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
}
