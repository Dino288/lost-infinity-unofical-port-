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
            case 4 -> twistedTunnelsStructure(pieceType, random);
            case 5 -> overgrownPassagesStructure(pieceType, random);
            case 6 -> crystalCreviceStructure(pieceType, random);
            case 7 -> luminescentCavernStructure(pieceType, random);
            case 8 -> archluminescentCavernStructure(pieceType, random);
            case 9 -> blightedLuminescenceStructure(pieceType, random);
            case 12 -> manufacturingOutpostStructure(pieceType);
            case 13 -> fungalCavernStructure(pieceType, random);
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

    private static String twistedTunnelsStructure(String pieceType, Random random) {
        return switch (pieceType) {
            case "twistx" -> randomPiece("twistedtunnels", "twistedtunnel_xshaft", 4, random);
            case "twistz" -> randomPiece("twistedtunnels", "twistedtunnel_zshaft", 4, random);
            case "twistturn1" -> randomPiece("twistedtunnels", "twistedtunnel_turn_1_", 2, random);
            case "twistturn2" -> randomPiece("twistedtunnels", "twistedtunnel_turn_2_", 2, random);
            case "twisttxin" -> "twistedtunnels/twistedtunnel_tsect_xin";
            case "twisttxde" -> "twistedtunnels/twistedtunnel_tsect_xde";
            case "twisttzin" -> "twistedtunnels/twistedtunnel_tsect_zin";
            case "twisttzde" -> "twistedtunnels/twistedtunnel_tsect_zde";
            case "twistslug" -> randomPiece("twistedtunnels", "twisted_tunnel_rockslug", 4, random);
            case "compression" -> "twistedtunnels/twistedtunnel_compression";
            case "twistgen" -> "twistedtunnels/twistedtunnel_powergen";
            case "twistdk1" -> "twistedtunnels/twistedtunnel_dusker1";
            case "twistdk2" -> "twistedtunnels/twistedtunnel_dusker2";
            case "twistdk3" -> "twistedtunnels/twistedtunnel_dusker3";
            case "twistphot1" -> "twistedtunnels/twistedtunnel_phototenzyte1";
            case "twistphot2" -> "twistedtunnels/twistedtunnel_phototenzyte2";
            case "twistphot3" -> "twistedtunnels/twistedtunnel_phototenzyte3";
            case "twistphot4" -> "twistedtunnels/twistedtunnel_phototenzyte4";
            case "twistphot5" -> "twistedtunnels/twistedtunnel_phototenzyte5";
            case "twistphot6" -> "twistedtunnels/twistedtunnel_phototenzyte6";
            default -> "";
        };
    }

    private static String overgrownPassagesStructure(String pieceType, Random random) {
        return switch (pieceType) {
            case "ogentry" -> "overgrown/overgrown_entry";
            case "ogstairs" -> randomPiece("overgrown", "overgrown_stairs", 9, random);
            case "corcavern" -> randomPiece("overgrown", "corrosive_cavern_", 4, random);
            case "ogtsect" -> randomPiece("overgrown", "overgrown_tsect_", 3, random);
            case "ogturn" -> randomPiece("overgrown", "overgrown_turn_", 2, random);
            case "ogfyre" -> "overgrown/overgrown_giantfyreweed";
            case "corent" -> "overgrown/corrosive_cavern_entry";
            case "oggen" -> "overgrown/overgrown_powergen";
            case "ogaura1" -> "overgrown/overgrown_auradine1";
            case "ogaura2" -> "overgrown/overgrown_auradine2";
            case "ogaura3" -> "overgrown/overgrown_auradine3";
            case "ogaura4" -> "overgrown/overgrown_auradine4";
            default -> "";
        };
    }

    private static String crystalCreviceStructure(String pieceType, Random random) {
        return switch (pieceType) {
            case "crysent" -> "crystal/crystal_crevice_entry";
            case "fabricator" -> "crystal/crystal_crevice_fabricator";
            case "synch1" -> "crystal/crystal_crevice_synchro1";
            case "synch2" -> "crystal/crystal_crevice_synchro2";
            case "cryblight" -> "crystal/crystal_crevice_blight";
            case "crystal" -> randomPiece("crystal", "crystal_crevice_", 9, random);
            default -> "";
        };
    }

    private static String luminescentCavernStructure(String pieceType, Random random) {
        return switch (pieceType) {
            case "lumentry" -> "lumcavern/lumcavern_entry";
            case "lumessent" -> "lumcavern/lumcavern_ess_entry";
            case "lumboss" -> "lumcavern/lumcavern_boss_entry";
            case "augment" -> "lumcavern/lumcavern_boss";
            case "lumtree" -> "lumcavern/lumcavern_lumtree";
            case "lumgate" -> "lumcavern/lumcavern_archlum_gate";
            case "lumprism1" -> "lumcavern/lumcavern_prism1";
            case "lumprism2" -> "lumcavern/lumcavern_prism2";
            case "lumprism3" -> "lumcavern/lumcavern_prism3";
            case "lumportal" -> "lumcavern/lumcavern_portal";
            case "lumgen" -> "lumcavern/lumcavern_powergen";
            case "lumshaft" -> randomPiece("lumcavern", "lumcavern_tunnel", 36, random);
            case "lumturn" -> randomPiece("lumcavern", "lumcavern_turn", 12, random);
            case "lumtsect" -> randomPiece("lumcavern", "lumcavern_tsect", 16, random);
            case "lumess" -> randomPiece("lumcavern", "lumcavern_ess_seg", 12, random);
            case "lumups" -> randomPiece("lumcavern", "lumcavern_up_small", 10, random);
            case "lumupl" -> randomPiece("lumcavern", "lumcavern_up_big", 10, random);
            case "lumcabove" -> randomPiece("lumcavern", "lumcavern_tunnel", 36, random) + ",lumabove";
            case "lumcbelow" -> randomPiece("lumcavern", "lumcavern_tunnel", 36, random) + ",lumbelow";
            default -> "";
        };
    }

    private static String manufacturingOutpostStructure(String pieceType) {
        return switch (pieceType) {
            case "manent1" -> "twistedtunnels/twisted_manufact_entry1";
            case "manent2" -> "twistedtunnels/twisted_manufact_entry2";
            case "manent3" -> "twistedtunnels/twisted_manufact_entry3";
            case "manup1" -> "manufacturing/manufacturing_outpost_p1";
            case "manup2" -> "manufacturing/manufacturing_outpost_p2";
            case "manup3" -> "manufacturing/manufacturing_outpost_p3";
            case "manup4" -> "manufacturing/manufacturing_outpost_p4";
            case "serp1" -> "manufacturing/serpentine_cave1";
            case "serp2" -> "manufacturing/serpentine_cave2";
            case "serp3" -> "manufacturing/serpentine_cave3";
            case "serp4" -> "manufacturing/serpentine_cave4";
            case "serp5" -> "manufacturing/serpentine_cave5";
            case "serp6" -> "manufacturing/serpentine_cave6";
            case "exo1" -> "manufacturing/exothermite_cave1";
            case "exo2" -> "manufacturing/exothermite_cave2";
            case "sun1" -> "manufacturing/sunstone_mine1";
            case "sun2" -> "manufacturing/sunstone_mine2";
            default -> "";
        };
    }

    private static String fungalCavernStructure(String pieceType, Random random) {
        return switch (pieceType) {
            case "fungtun" -> randomPiece("fungal", "fungalcavern_tunnel", 6, random);
            case "fungat" -> randomPiece("fungal", "fungalcavern_tunnel", 72, random);
            case "funblock" -> "fungal/fungalcavern_blockage";
            case "fungrot1" -> "fungal/fungalcavern_turn_1";
            case "fungrot2" -> "fungal/fungalcavern_turn_2";
            case "fungrot3" -> "fungal/fungalcavern_turn_3";
            case "fungrot4" -> "fungal/fungalcavern_turn_4";
            case "fungluc1" -> "fungal/fungalcavern_lucient1";
            case "fungluc2" -> "fungal/fungalcavern_lucient2";
            case "fungluc3" -> "fungal/fungalcavern_lucient3";
            case "fungluc4" -> "fungal/fungalcavern_lucient4";
            case "fungluc5" -> "fungal/fungalcavern_lucient5";
            case "fungluc6" -> "fungal/fungalcavern_lucient6";
            default -> "";
        };
    }

    private static String archluminescentCavernStructure(String pieceType, Random random) {
        return switch (pieceType) {
            case "archgate" -> "lumcavern/lumcavern_archlum_top";
            case "archentry" -> "archcavern/archcavern_entry";
            case "archshaft" -> randomPiece("archcavern", "archcavern_tunnel", 24, random);
            case "archthin" -> randomPiece("archcavern", "archcavern_thintunnel", 18, random);
            case "archblock" -> randomPiece("archcavern", "archcavern_archblock", 4, random);
            case "archabs" -> randomPiece("archcavern", "archcavern_tunnel", 24, random) + ",archaboves";
            case "archbls" -> randomPiece("archcavern", "archcavern_tunnel", 24, random) + ",archbelows";
            case "archabt" -> randomPiece("archcavern", "archcavern_thintunnel", 18, random) + ",archabovet";
            case "archblt" -> randomPiece("archcavern", "archcavern_thintunnel", 18, random) + ",archbelowt";
            case "archwisp1" -> "archcavern/archcavern_wisp1";
            case "archwisp2" -> "archcavern/archcavern_wisp2";
            case "archwisp3" -> "archcavern/archcavern_wisp3";
            case "archwisp4" -> "archcavern/archcavern_wisp4";
            case "archbirth" -> "archcavern/archcavern_rebirth";
            case "archport" -> "archcavern/archcavern_portal";
            case "archpipe" -> "archcavern/archcavern_pipe";
            case "archinc1" -> "archcavern/archcavern_incandescite_lower1,archinc1";
            case "archinc2" -> "archcavern/archcavern_incandescite_lower2,archinc2";
            case "archinc3" -> "archcavern/archcavern_incandescite_lower3,archinc3";
            case "archinc4" -> "archcavern/archcavern_incandescite_lower4,archinc4";
            case "archinc5" -> "archcavern/archcavern_incandescite_lower5,archinc5";
            case "archinc6" -> "archcavern/archcavern_incandescite_lower6,archinc6";
            case "archinc7" -> "archcavern/archcavern_incandescite_lower7,archinc7";
            case "archinc8" -> "archcavern/archcavern_incandescite_lower8,archinc8";
            case "archinc9" -> "archcavern/archcavern_incandescite_lower9,archinc9";
            case "archsu" -> randomPiece("archcavern", "archcavern_smallup", 9, random) + ",archsu";
            case "archsr" -> randomPiece("archcavern", "archcavern_smallup", 9, random) + ",archsr";
            case "archsl" -> randomPiece("archcavern", "archcavern_smallup", 9, random) + ",archsl";
            case "archsd" -> randomPiece("archcavern", "archcavern_smallup", 9, random) + ",archsd";
            case "archlu" -> randomPiece("archcavern", "archcavern_largeup", 9, random) + ",archlu";
            case "archll" -> randomPiece("archcavern", "archcavern_largeup", 9, random) + ",archll";
            case "archld" -> randomPiece("archcavern", "archcavern_largeup", 9, random) + ",archld";
            case "archlr" -> randomPiece("archcavern", "archcavern_largeup", 9, random) + ",archlr";
            case "archmu" -> random.nextBoolean()
                    ? randomPiece("archcavern", "archcavern_smallup", 9, random) + ",archmlu"
                    : randomPiece("archcavern", "archcavern_largeup", 9, random) + ",archmsu";
            case "archml" -> random.nextBoolean()
                    ? randomPiece("archcavern", "archcavern_smallup", 9, random) + ",archmll"
                    : randomPiece("archcavern", "archcavern_largeup", 9, random) + ",archmsl";
            case "archmd" -> random.nextBoolean()
                    ? randomPiece("archcavern", "archcavern_smallup", 9, random) + ",archmld"
                    : randomPiece("archcavern", "archcavern_largeup", 9, random) + ",archmsd";
            case "archmr" -> random.nextBoolean()
                    ? randomPiece("archcavern", "archcavern_smallup", 9, random) + ",archmlr"
                    : randomPiece("archcavern", "archcavern_largeup", 9, random) + ",archmsr";
            default -> "";
        };
    }

    private static String blightedLuminescenceStructure(String pieceType, Random random) {
        return switch (pieceType) {
            case "bligentry" -> "blightcavern/blightcavern_entry";
            case "bligdark" -> "blightcavern/blightcavern_darktree";
            case "bligcrush" -> "blightcavern/blightcavern_crusher";
            case "bligshaft" -> randomPiece("blightcavern", "blightcavern_tunnel", 48, random);
            case "bligthin" -> randomPiece("blightcavern", "blightcavern_thintunnel", 36, random);
            case "bligblock" -> randomPiece("blightcavern", "blightcavern_blightblock", 4, random);
            case "bligabs" -> randomPiece("blightcavern", "blightcavern_tunnel", 48, random) + ",bligaboves";
            case "bligbls" -> randomPiece("blightcavern", "blightcavern_tunnel", 48, random) + ",bligbelows";
            case "bligabt" -> randomPiece("blightcavern", "blightcavern_thintunnel", 36, random) + ",bligabovet";
            case "bligblt" -> randomPiece("blightcavern", "blightcavern_thintunnel", 36, random) + ",bligbelowt";
            case "bligess" -> randomPiece("blightcavern", "blightcavern_ess_seg", 12, random);
            case "bligessent" -> "blightcavern/blightcavern_ess_entry";
            case "bligsap" -> "blightcavern/blightcavern_sap";
            case "bligport" -> "blightcavern/blightcavern_mouth";
            case "bligsec" -> "blightcavern/blightcavern_secu3";
            case "bligsu" -> randomPiece("blightcavern", "blightcavern_smallup", 18, random) + ",bligsu";
            case "bligsr" -> randomPiece("blightcavern", "blightcavern_smallup", 18, random) + ",bligsr";
            case "bligsl" -> randomPiece("blightcavern", "blightcavern_smallup", 18, random) + ",bligsl";
            case "bligsd" -> randomPiece("blightcavern", "blightcavern_smallup", 18, random) + ",bligsd";
            case "bliglu" -> randomPiece("blightcavern", "blightcavern_largeup", 18, random) + ",bliglu";
            case "bligll" -> randomPiece("blightcavern", "blightcavern_largeup", 18, random) + ",bligll";
            case "bligld" -> randomPiece("blightcavern", "blightcavern_largeup", 18, random) + ",bligld";
            case "bliglr" -> randomPiece("blightcavern", "blightcavern_largeup", 18, random) + ",bliglr";
            case "bligmu" -> random.nextBoolean()
                    ? randomPiece("blightcavern", "blightcavern_smallup", 18, random) + ",bligmlu"
                    : randomPiece("blightcavern", "blightcavern_largeup", 18, random) + ",bligmsu";
            case "bligml" -> random.nextBoolean()
                    ? randomPiece("blightcavern", "blightcavern_smallup", 18, random) + ",bligmll"
                    : randomPiece("blightcavern", "blightcavern_largeup", 18, random) + ",bligmsl";
            case "bligmd" -> random.nextBoolean()
                    ? randomPiece("blightcavern", "blightcavern_smallup", 18, random) + ",bligmld"
                    : randomPiece("blightcavern", "blightcavern_largeup", 18, random) + ",bligmsd";
            case "bligmr" -> random.nextBoolean()
                    ? randomPiece("blightcavern", "blightcavern_smallup", 18, random) + ",bligmlr"
                    : randomPiece("blightcavern", "blightcavern_largeup", 18, random) + ",bligmsr";
            case "bligpow1" -> "blightcavern/blightcavern_powercore_1";
            case "bligpow2" -> "blightcavern/blightcavern_powercore_2";
            case "bligpow3" -> "blightcavern/blightcavern_powercore_3";
            case "bligpow4" -> "blightcavern/blightcavern_powercore_4";
            case "bligpow5" -> "blightcavern/blightcavern_powercore_5";
            case "bligliblo" -> "blightcavern/blightcavern_lightblockage";
            case "bligboss" -> "blightcavern/blightcavern_bossgate";
            default -> "";
        };
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
            case "lumabove" -> new ExtraStructure(randomPiece("lumcavern", "lumcavern_tunnel", 36, random), 10, 1, 1, rotationFromInt(8, random));
            case "lumbelow" -> new ExtraStructure(randomPiece("lumcavern", "lumcavern_tunnel", 36, random), -10, 1, 1, rotationFromInt(8, random));
            case "galaxy1" -> new ExtraStructure("galaxy/galaxy_dungeon_upper1", 19, 1, 1, Rotation.NONE);
            case "galaxy2" -> new ExtraStructure("galaxy/galaxy_dungeon_upper2", 19, 1, 1, Rotation.NONE);
            case "galaxy3" -> new ExtraStructure("galaxy/galaxy_dungeon_upper3", 19, 1, 1, Rotation.NONE);
            case "galaxy4" -> new ExtraStructure("galaxy/galaxy_dungeon_upper4", 19, 1, 1, Rotation.NONE);
            case "hiveent" -> new ExtraStructure("starforge/sunder_hive_entry", -13, 1, 1, Rotation.NONE);
            case "hive1" -> new ExtraStructure("starforge/sunder_hive_top_1", 32, 1, 1, Rotation.NONE);
            case "hive2" -> new ExtraStructure("starforge/sunder_hive_top_2", 32, 1, 1, Rotation.NONE);
            case "hive3" -> new ExtraStructure("starforge/sunder_hive_top_3", 32, 1, 1, Rotation.NONE);
            case "hive4" -> new ExtraStructure("starforge/sunder_hive_top_4", 32, 1, 1, Rotation.NONE);
            case "archsu" -> new ExtraStructure(randomPiece("archcavern", "archcavern_smalldown", 9, random), 20, 1, 1, Rotation.CLOCKWISE_90);
            case "archsl" -> new ExtraStructure(randomPiece("archcavern", "archcavern_smalldown", 9, random), 20, 1, 1, Rotation.NONE);
            case "archsr" -> new ExtraStructure(randomPiece("archcavern", "archcavern_smalldown", 9, random), 20, 1, 1, Rotation.CLOCKWISE_180);
            case "archsd" -> new ExtraStructure(randomPiece("archcavern", "archcavern_smalldown", 9, random), 20, 1, 1, Rotation.COUNTERCLOCKWISE_90);
            case "archlu" -> new ExtraStructure(randomPiece("archcavern", "archcavern_largedown", 9, random), 30, 1, 1, Rotation.CLOCKWISE_90);
            case "archll" -> new ExtraStructure(randomPiece("archcavern", "archcavern_largedown", 9, random), 30, 1, 1, Rotation.NONE);
            case "archlr" -> new ExtraStructure(randomPiece("archcavern", "archcavern_largedown", 9, random), 30, 1, 1, Rotation.CLOCKWISE_180);
            case "archld" -> new ExtraStructure(randomPiece("archcavern", "archcavern_largedown", 9, random), 30, 1, 1, Rotation.COUNTERCLOCKWISE_90);
            case "archmsu" -> new ExtraStructure(randomPiece("archcavern", "archcavern_smalldown", 9, random), 30, 1, 1, Rotation.CLOCKWISE_90);
            case "archmsl" -> new ExtraStructure(randomPiece("archcavern", "archcavern_smalldown", 9, random), 30, 1, 1, Rotation.NONE);
            case "archmsr" -> new ExtraStructure(randomPiece("archcavern", "archcavern_smalldown", 9, random), 30, 1, 1, Rotation.CLOCKWISE_180);
            case "archmsd" -> new ExtraStructure(randomPiece("archcavern", "archcavern_smalldown", 9, random), 30, 1, 1, Rotation.COUNTERCLOCKWISE_90);
            case "archmlu" -> new ExtraStructure(randomPiece("archcavern", "archcavern_largedown", 9, random), 20, 1, 1, Rotation.CLOCKWISE_90);
            case "archmll" -> new ExtraStructure(randomPiece("archcavern", "archcavern_largedown", 9, random), 20, 1, 1, Rotation.NONE);
            case "archmlr" -> new ExtraStructure(randomPiece("archcavern", "archcavern_largedown", 9, random), 20, 1, 1, Rotation.CLOCKWISE_180);
            case "archmld" -> new ExtraStructure(randomPiece("archcavern", "archcavern_largedown", 9, random), 20, 1, 1, Rotation.COUNTERCLOCKWISE_90);
            case "archaboves" -> new ExtraStructure(randomPiece("archcavern", "archcavern_tunnel", 24, random), 20, 1, 1, Rotation.NONE);
            case "archbelows" -> new ExtraStructure(randomPiece("archcavern", "archcavern_tunnel", 24, random), -20, 1, 1, Rotation.NONE);
            case "archabovet" -> new ExtraStructure(randomPiece("archcavern", "archcavern_thintunnel", 18, random), 20, 1, 1, Rotation.NONE);
            case "archbelowt" -> new ExtraStructure(randomPiece("archcavern", "archcavern_thintunnel", 18, random), -20, 1, 1, Rotation.NONE);
            case "bligsu" -> new ExtraStructure(randomPiece("blightcavern", "blightcavern_smalldown", 18, random), 20, 1, 1, Rotation.CLOCKWISE_90);
            case "bligsl" -> new ExtraStructure(randomPiece("blightcavern", "blightcavern_smalldown", 18, random), 20, 1, 1, Rotation.NONE);
            case "bligsr" -> new ExtraStructure(randomPiece("blightcavern", "blightcavern_smalldown", 18, random), 20, 1, 1, Rotation.CLOCKWISE_180);
            case "bligsd" -> new ExtraStructure(randomPiece("blightcavern", "blightcavern_smalldown", 18, random), 20, 1, 1, Rotation.COUNTERCLOCKWISE_90);
            case "bliglu" -> new ExtraStructure(randomPiece("blightcavern", "blightcavern_largedown", 18, random), 30, 1, 1, Rotation.CLOCKWISE_90);
            case "bligll" -> new ExtraStructure(randomPiece("blightcavern", "blightcavern_largedown", 18, random), 30, 1, 1, Rotation.NONE);
            case "bliglr" -> new ExtraStructure(randomPiece("blightcavern", "blightcavern_largedown", 18, random), 30, 1, 1, Rotation.CLOCKWISE_180);
            case "bligld" -> new ExtraStructure(randomPiece("blightcavern", "blightcavern_largedown", 18, random), 30, 1, 1, Rotation.COUNTERCLOCKWISE_90);
            case "bligmsu" -> new ExtraStructure(randomPiece("blightcavern", "blightcavern_smalldown", 18, random), 30, 1, 1, Rotation.CLOCKWISE_90);
            case "bligmsl" -> new ExtraStructure(randomPiece("blightcavern", "blightcavern_smalldown", 18, random), 30, 1, 1, Rotation.NONE);
            case "bligmsr" -> new ExtraStructure(randomPiece("blightcavern", "blightcavern_smalldown", 18, random), 30, 1, 1, Rotation.CLOCKWISE_180);
            case "bligmsd" -> new ExtraStructure(randomPiece("blightcavern", "blightcavern_smalldown", 18, random), 30, 1, 1, Rotation.COUNTERCLOCKWISE_90);
            case "bligmlu" -> new ExtraStructure(randomPiece("blightcavern", "blightcavern_largedown", 18, random), 20, 1, 1, Rotation.CLOCKWISE_90);
            case "bligmll" -> new ExtraStructure(randomPiece("blightcavern", "blightcavern_largedown", 18, random), 20, 1, 1, Rotation.NONE);
            case "bligmlr" -> new ExtraStructure(randomPiece("blightcavern", "blightcavern_largedown", 18, random), 20, 1, 1, Rotation.CLOCKWISE_180);
            case "bligmld" -> new ExtraStructure(randomPiece("blightcavern", "blightcavern_largedown", 18, random), 20, 1, 1, Rotation.COUNTERCLOCKWISE_90);
            case "bligaboves" -> new ExtraStructure(randomPiece("blightcavern", "blightcavern_tunnel", 48, random), 20, 1, 1, Rotation.NONE);
            case "bligbelows" -> new ExtraStructure(randomPiece("blightcavern", "blightcavern_tunnel", 48, random), -20, 1, 1, Rotation.NONE);
            case "bligabovet" -> new ExtraStructure(randomPiece("blightcavern", "blightcavern_thintunnel", 36, random), 20, 1, 1, Rotation.NONE);
            case "bligbelowt" -> new ExtraStructure(randomPiece("blightcavern", "blightcavern_thintunnel", 36, random), -20, 1, 1, Rotation.NONE);
            case "archinc1" -> new ExtraStructure("archcavern/archcavern_incandescite_upper1", 30, 1, 1, Rotation.NONE);
            case "archinc2" -> new ExtraStructure("archcavern/archcavern_incandescite_upper2", 30, 1, 1, Rotation.NONE);
            case "archinc3" -> new ExtraStructure("archcavern/archcavern_incandescite_upper3", 30, 1, 1, Rotation.NONE);
            case "archinc4" -> new ExtraStructure("archcavern/archcavern_incandescite_upper4", 30, 1, 1, Rotation.NONE);
            case "archinc5" -> new ExtraStructure("archcavern/archcavern_incandescite_upper5", 30, 1, 1, Rotation.NONE);
            case "archinc6" -> new ExtraStructure("archcavern/archcavern_incandescite_upper6", 30, 1, 1, Rotation.NONE);
            case "archinc7" -> new ExtraStructure("archcavern/archcavern_incandescite_upper7", 30, 1, 1, Rotation.NONE);
            case "archinc8" -> new ExtraStructure("archcavern/archcavern_incandescite_upper8", 30, 1, 1, Rotation.NONE);
            case "archinc9" -> new ExtraStructure("archcavern/archcavern_incandescite_upper9", 30, 1, 1, Rotation.NONE);
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
