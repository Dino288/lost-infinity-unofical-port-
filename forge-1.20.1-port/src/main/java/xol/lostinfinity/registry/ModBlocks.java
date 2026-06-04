package xol.lostinfinity.registry;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.GlassBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import xol.lostinfinity.LostInfinity;
import xol.lostinfinity.block.LostDimensionPortalBlock;
import xol.lostinfinity.block.LostMachineBlock;

public final class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, LostInfinity.MODID);
    public static final List<RegistryObject<Block>> ALL_BLOCKS = new ArrayList<>();

    private ModBlocks() {
    }

    private static RegistryObject<Block> registerBlock(String name, Supplier<Block> supplier) {
        RegistryObject<Block> block = BLOCKS.register(name, supplier);
        ALL_BLOCKS.add(block);
        return block;
    }

    private static Block defaultBlock(String name) {
        BlockBehaviour.Properties properties = propertiesFor(name);
        String targetDimension = targetDimensionFor(name);
        if (targetDimension != null) {
            return new LostDimensionPortalBlock(properties.noOcclusion().lightLevel(state -> 11), targetDimension);
        }
        if (isMachineBlock(name)) {
            return new LostMachineBlock(properties, name);
        }
        if (name.contains("slab")) {
            return new SlabBlock(properties);
        }
        if (name.contains("stairs")) {
            return new StairBlock(baseStateFor(name), properties);
        }
        if (name.contains("glass") || name.contains("barrier")) {
            return new GlassBlock(properties);
        }
        return new Block(properties);
    }

    private static BlockBehaviour.Properties propertiesFor(String name) {
        BlockBehaviour.Properties properties = BlockBehaviour.Properties.of().mapColor(MapColor.STONE).strength(2.0F, 6.0F).sound(SoundType.STONE);
        if (name.contains("glass") || name.contains("barrier")) {
            properties = properties.strength(0.3F, 1.5F).sound(SoundType.GLASS).noOcclusion();
        }
        if (name.contains("leaf") || name.contains("leaves") || name.contains("vine") || name.contains("weed")
                || name.contains("grass") || name.contains("flower") || name.contains("bloom") || name.contains("bulb")
                || name.contains("stem") || name.contains("root") || name.contains("coral")) {
            properties = properties.strength(0.4F, 0.4F).sound(SoundType.GRASS).noOcclusion();
        }
        if (name.contains("vine") || name.contains("weed") || name.contains("flower") || name.contains("bloom")
                || name.contains("bulb") || name.contains("stem") || name.contains("root") || name.contains("web")
                || name.contains("tentacle") || name.contains("sap") || name.contains("gel")) {
            properties = properties.noCollission().noOcclusion();
        }
        if (name.contains("web")) {
            properties = properties.strength(4.0F).sound(SoundType.WOOL);
        }
        if (name.contains("sand") || name.contains("mud") || name.contains("clay") || name.contains("slime")
                || name.contains("gel") || name.contains("goo")) {
            properties = properties.strength(0.6F, 0.6F).sound(SoundType.GRAVEL);
        }
        if (name.contains("lamp") || name.contains("light") || name.contains("lantern") || name.contains("glow")
                || name.contains("lumi") || name.endsWith("_lit") || name.endsWith("_on")) {
            properties = properties.lightLevel(state -> 15);
        }
        if (name.contains("spawner") || name.contains("summoner")) {
            properties = properties.strength(5.0F, 30.0F).sound(SoundType.METAL).lightLevel(state -> 7);
        }
        if (name.contains("metal") || name.contains("steel") || name.contains("machine") || name.contains("battery")
                || name.contains("forge") || name.contains("console")) {
            properties = properties.strength(4.0F, 9.0F).sound(SoundType.METAL);
        }
        if (name.contains("ore")) {
            properties = properties.strength(3.0F, 6.0F).requiresCorrectToolForDrops();
        }
        if (requiresCorrectTool(name)) {
            properties = properties.requiresCorrectToolForDrops();
        }
        return properties;
    }

    private static boolean requiresCorrectTool(String name) {
        if (name.contains("leaf") || name.contains("leaves") || name.contains("vine") || name.contains("weed")
                || name.contains("grass") || name.contains("flower") || name.contains("bloom") || name.contains("bulb")
                || name.contains("stem") || name.contains("root") || name.contains("coral")
                || name.contains("glass") || name.contains("barrier")) {
            return false;
        }
        return name.contains("ore") || name.contains("stone") || name.contains("rock") || name.contains("brick")
                || name.contains("metal") || name.contains("steel") || name.contains("machine") || name.contains("battery")
                || name.contains("forge") || name.contains("console") || name.contains("engine") || name.contains("gearbox")
                || name.contains("generator") || name.contains("infuser") || name.contains("beacon") || name.contains("collider")
                || name.contains("calibrator") || name.contains("chemistry") || name.contains("welding") || name.contains("fusion")
                || name.contains("polymer") || name.contains("grinder") || name.contains("drill") || name.contains("pillar")
                || name.contains("tile") || name.contains("slab") || name.contains("stairs") || name.contains("obsidian")
                || name.contains("seastone") || name.contains("astrorock");
    }

    private static String targetDimensionFor(String name) {
        if (name.equals("dimensionalizer") || name.equals("portal_nexus") || name.equals("portal_node")) {
            return "nonexistence";
        }
        if (name.equals("galaxy_portal_molten")) {
            return "moltensea";
        }
        if (name.contains("shadow") || name.contains("sea")) {
            return name.contains("portal") || name.contains("teleporter") ? "shadowsea" : null;
        }
        if (name.contains("celestial")) {
            return name.contains("portal") || name.contains("teleporter") ? "celestialvoid" : null;
        }
        if (name.contains("labyrinth_portal_green")) {
            return "cartographerrealmmid";
        }
        if (name.contains("labyrinth_portal_red")) {
            return "cartographerrealmbot";
        }
        if (name.contains("timeline_stabilizer_portal")) {
            return "cartographerrealmtop";
        }
        if (name.contains("starforge_teleporter")) {
            return "grandmasteroutpost";
        }
        if (name.contains("murk") && (name.contains("portal") || name.contains("teleporter"))) {
            return "infinitemurk";
        }
        if (name.contains("galaxy_portal") || name.contains("trialgate")) {
            return "nonexistence";
        }
        return null;
    }

    private static net.minecraft.world.level.block.state.BlockState baseStateFor(String name) {
        if (name.contains("metal") || name.contains("steel") || name.contains("forge")) {
            return Blocks.IRON_BLOCK.defaultBlockState();
        }
        if (name.contains("glass")) {
            return Blocks.GLASS.defaultBlockState();
        }
        if (name.contains("wood") || name.contains("plank")) {
            return Blocks.OAK_PLANKS.defaultBlockState();
        }
        if (name.contains("brick")) {
            return Blocks.STONE_BRICKS.defaultBlockState();
        }
        if (name.contains("sand")) {
            return Blocks.SANDSTONE.defaultBlockState();
        }
        return Blocks.STONE.defaultBlockState();
    }

    private static boolean isMachineBlock(String name) {
        return switch (name) {
            case "alignment_dial_game", "ancient_symbol_interpreter", "chemistry_table", "chroma_game",
                    "circuit_calibrator", "combustion_engine", "compressiontable", "cthulhu_spawner",
                    "drill_console", "eternal_beacon", "fusion_table", "gearbox", "grinder",
                    "killer_vine", "light_emitter", "melodic_sequencer", "navigation_device",
                    "nebulous_beacon", "nicronium_infuser", "polymerization_device", "power_collider",
                    "rainfall_generator", "sap_evaporator", "shipment_filler", "shockwave_generator",
                    "tesla_tower", "void_vacuum", "welding_chamber" -> true;
            default -> false;
        };
    }

    public static final RegistryObject<Block> ACID_LANTERN = registerBlock("acid_lantern", () -> defaultBlock("acid_lantern"));
    public static final RegistryObject<Block> ACID_POCKET = registerBlock("acid_pocket", () -> defaultBlock("acid_pocket"));
    public static final RegistryObject<Block> ACIDBULBS = registerBlock("acidbulbs", () -> defaultBlock("acidbulbs"));
    public static final RegistryObject<Block> ACIDBULBS_STEM = registerBlock("acidbulbs_stem", () -> defaultBlock("acidbulbs_stem"));
    public static final RegistryObject<Block> ACIDIC_CONCOCTION_GEL = registerBlock("acidic_concoction_gel", () -> defaultBlock("acidic_concoction_gel"));
    public static final RegistryObject<Block> ACIDICGEL = registerBlock("acidicgel", () -> defaultBlock("acidicgel"));
    public static final RegistryObject<Block> ALIGNMENT_DIAL_GAME = registerBlock("alignment_dial_game", () -> defaultBlock("alignment_dial_game"));
    public static final RegistryObject<Block> ALIGNMENT_TILE = registerBlock("alignment_tile", () -> defaultBlock("alignment_tile"));
    public static final RegistryObject<Block> ANCIENT_SYMBOL = registerBlock("ancient_symbol", () -> defaultBlock("ancient_symbol"));
    public static final RegistryObject<Block> ANCIENT_SYMBOL_INTERPRETER = registerBlock("ancient_symbol_interpreter", () -> defaultBlock("ancient_symbol_interpreter"));
    public static final RegistryObject<Block> ARCHBLOOM = registerBlock("archbloom", () -> defaultBlock("archbloom"));
    public static final RegistryObject<Block> ARCHBLOOM_STEM = registerBlock("archbloom_stem", () -> defaultBlock("archbloom_stem"));
    public static final RegistryObject<Block> ARCHGRASS = registerBlock("archgrass", () -> defaultBlock("archgrass"));
    public static final RegistryObject<Block> ARCHLUMGRASS = registerBlock("archlumgrass", () -> defaultBlock("archlumgrass"));
    public static final RegistryObject<Block> ARCHLUMILIGHT = registerBlock("archlumilight", () -> defaultBlock("archlumilight"));
    public static final RegistryObject<Block> ARCHLUMIO_GATE = registerBlock("archlumio_gate", () -> defaultBlock("archlumio_gate"));
    public static final RegistryObject<Block> ARCHLUMIO_GATE_PASS = registerBlock("archlumio_gate_pass", () -> defaultBlock("archlumio_gate_pass"));
    public static final RegistryObject<Block> ARCHLUMIO_ROCK = registerBlock("archlumio_rock", () -> defaultBlock("archlumio_rock"));
    public static final RegistryObject<Block> ARCHVINE = registerBlock("archvine", () -> defaultBlock("archvine"));
    public static final RegistryObject<Block> ARCHVINE_ROOT = registerBlock("archvine_root", () -> defaultBlock("archvine_root"));
    public static final RegistryObject<Block> ARENA_ANI_SLABS_BLUE = registerBlock("arena_ani_slabs_blue", () -> defaultBlock("arena_ani_slabs_blue"));
    public static final RegistryObject<Block> ARENA_ANI_SLABS_SEA = registerBlock("arena_ani_slabs_sea", () -> defaultBlock("arena_ani_slabs_sea"));
    public static final RegistryObject<Block> ARENA_BARRIER = registerBlock("arena_barrier", () -> defaultBlock("arena_barrier"));
    public static final RegistryObject<Block> ARENA_BRICK_BLACK = registerBlock("arena_brick_black", () -> defaultBlock("arena_brick_black"));
    public static final RegistryObject<Block> ARENA_BRICK_BLACK_STAIRS = registerBlock("arena_brick_black_stairs", () -> defaultBlock("arena_brick_black_stairs"));
    public static final RegistryObject<Block> ARENA_BRICK_BLUE = registerBlock("arena_brick_blue", () -> defaultBlock("arena_brick_blue"));
    public static final RegistryObject<Block> ARENA_BRICK_BLUE_STAIRS = registerBlock("arena_brick_blue_stairs", () -> defaultBlock("arena_brick_blue_stairs"));
    public static final RegistryObject<Block> ARENA_BRICK_RED = registerBlock("arena_brick_red", () -> defaultBlock("arena_brick_red"));
    public static final RegistryObject<Block> ARENA_BRICK_RED_STAIRS = registerBlock("arena_brick_red_stairs", () -> defaultBlock("arena_brick_red_stairs"));
    public static final RegistryObject<Block> ARENA_BRICK_YELLOW = registerBlock("arena_brick_yellow", () -> defaultBlock("arena_brick_yellow"));
    public static final RegistryObject<Block> ARENA_BRICK_YELLOW_STAIRS = registerBlock("arena_brick_yellow_stairs", () -> defaultBlock("arena_brick_yellow_stairs"));
    public static final RegistryObject<Block> ARENA_GLASS_BLUE = registerBlock("arena_glass_blue", () -> defaultBlock("arena_glass_blue"));
    public static final RegistryObject<Block> ARENA_GLASS_ORANGE = registerBlock("arena_glass_orange", () -> defaultBlock("arena_glass_orange"));
    public static final RegistryObject<Block> ARENA_GLASS_SEA = registerBlock("arena_glass_sea", () -> defaultBlock("arena_glass_sea"));
    public static final RegistryObject<Block> ARENA_GLASS_YELLOW = registerBlock("arena_glass_yellow", () -> defaultBlock("arena_glass_yellow"));
    public static final RegistryObject<Block> ARENA_LAMP_BLUE = registerBlock("arena_lamp_blue", () -> defaultBlock("arena_lamp_blue"));
    public static final RegistryObject<Block> ARENA_LAMP_DARK = registerBlock("arena_lamp_dark", () -> defaultBlock("arena_lamp_dark"));
    public static final RegistryObject<Block> ARENA_LAMP_RED = registerBlock("arena_lamp_red", () -> defaultBlock("arena_lamp_red"));
    public static final RegistryObject<Block> ARENA_LAMP_SEA = registerBlock("arena_lamp_sea", () -> defaultBlock("arena_lamp_sea"));
    public static final RegistryObject<Block> ARENA_LAMPRAZOR_BLUE = registerBlock("arena_lamprazor_blue", () -> defaultBlock("arena_lamprazor_blue"));
    public static final RegistryObject<Block> ARENA_LAMPRAZOR_RED = registerBlock("arena_lamprazor_red", () -> defaultBlock("arena_lamprazor_red"));
    public static final RegistryObject<Block> ARENA_LAMPRAZOR_YELLOW = registerBlock("arena_lamprazor_yellow", () -> defaultBlock("arena_lamprazor_yellow"));
    public static final RegistryObject<Block> ARENA_PILLAR_BLUE = registerBlock("arena_pillar_blue", () -> defaultBlock("arena_pillar_blue"));
    public static final RegistryObject<Block> ARENA_PILLAR_SEA = registerBlock("arena_pillar_sea", () -> defaultBlock("arena_pillar_sea"));
    public static final RegistryObject<Block> ARENA_PILLAR_YELLOW = registerBlock("arena_pillar_yellow", () -> defaultBlock("arena_pillar_yellow"));
    public static final RegistryObject<Block> ARENA_SLABS_BLUE = registerBlock("arena_slabs_blue", () -> defaultBlock("arena_slabs_blue"));
    public static final RegistryObject<Block> ARENA_SLABS_SEA = registerBlock("arena_slabs_sea", () -> defaultBlock("arena_slabs_sea"));
    public static final RegistryObject<Block> ARENA_STEEL_BLACK = registerBlock("arena_steel_black", () -> defaultBlock("arena_steel_black"));
    public static final RegistryObject<Block> ARENA_STEEL_BLUE = registerBlock("arena_steel_blue", () -> defaultBlock("arena_steel_blue"));
    public static final RegistryObject<Block> ARENA_SUMMONER = registerBlock("arena_summoner", () -> defaultBlock("arena_summoner"));
    public static final RegistryObject<Block> ASTRALLIUM_ORE = registerBlock("astrallium_ore", () -> defaultBlock("astrallium_ore"));
    public static final RegistryObject<Block> ASTROBARRIER_BLUE = registerBlock("astrobarrier_blue", () -> defaultBlock("astrobarrier_blue"));
    public static final RegistryObject<Block> ASTROBARRIER_GREEN = registerBlock("astrobarrier_green", () -> defaultBlock("astrobarrier_green"));
    public static final RegistryObject<Block> ASTROBARRIER_PURPLE = registerBlock("astrobarrier_purple", () -> defaultBlock("astrobarrier_purple"));
    public static final RegistryObject<Block> ASTROBARRIER_YELLOW = registerBlock("astrobarrier_yellow", () -> defaultBlock("astrobarrier_yellow"));
    public static final RegistryObject<Block> ASTROMOLT = registerBlock("astromolt", () -> defaultBlock("astromolt"));
    public static final RegistryObject<Block> ASTROMOLT_BUBBLE = registerBlock("astromolt_bubble", () -> defaultBlock("astromolt_bubble"));
    public static final RegistryObject<Block> ASTROMUD = registerBlock("astromud", () -> defaultBlock("astromud"));
    public static final RegistryObject<Block> ASTROROCK = registerBlock("astrorock", () -> defaultBlock("astrorock"));
    public static final RegistryObject<Block> ASTROROCK_BLUE = registerBlock("astrorock_blue", () -> defaultBlock("astrorock_blue"));
    public static final RegistryObject<Block> ASTROROCK_CRYSTAL_BLUE = registerBlock("astrorock_crystal_blue", () -> defaultBlock("astrorock_crystal_blue"));
    public static final RegistryObject<Block> ASTROROCK_CRYSTAL_PINK = registerBlock("astrorock_crystal_pink", () -> defaultBlock("astrorock_crystal_pink"));
    public static final RegistryObject<Block> ASTROROCK_GLASS = registerBlock("astrorock_glass", () -> defaultBlock("astrorock_glass"));
    public static final RegistryObject<Block> ASTROROCK_GREEN = registerBlock("astrorock_green", () -> defaultBlock("astrorock_green"));
    public static final RegistryObject<Block> ASTROROCK_HARDENED = registerBlock("astrorock_hardened", () -> defaultBlock("astrorock_hardened"));
    public static final RegistryObject<Block> ASTROROCK_LAMP_BLUE = registerBlock("astrorock_lamp_blue", () -> defaultBlock("astrorock_lamp_blue"));
    public static final RegistryObject<Block> ASTROROCK_LAMP_GREEN = registerBlock("astrorock_lamp_green", () -> defaultBlock("astrorock_lamp_green"));
    public static final RegistryObject<Block> ASTROROCK_LAMP_PURPLE = registerBlock("astrorock_lamp_purple", () -> defaultBlock("astrorock_lamp_purple"));
    public static final RegistryObject<Block> ASTROROCK_LAMP_YELLOW = registerBlock("astrorock_lamp_yellow", () -> defaultBlock("astrorock_lamp_yellow"));
    public static final RegistryObject<Block> ASTROROCK_PURPLE = registerBlock("astrorock_purple", () -> defaultBlock("astrorock_purple"));
    public static final RegistryObject<Block> ASTROROCK_STAIRS = registerBlock("astrorock_stairs", () -> defaultBlock("astrorock_stairs"));
    public static final RegistryObject<Block> ASTROROCK_YELLOW = registerBlock("astrorock_yellow", () -> defaultBlock("astrorock_yellow"));
    public static final RegistryObject<Block> ASTROSTEEL = registerBlock("astrosteel", () -> defaultBlock("astrosteel"));
    public static final RegistryObject<Block> ATOMITE_ORE = registerBlock("atomite_ore", () -> defaultBlock("atomite_ore"));
    public static final RegistryObject<Block> AUGMENTICON_CREATOR = registerBlock("augmenticon_creator", () -> defaultBlock("augmenticon_creator"));
    public static final RegistryObject<Block> AUGMENTOR = registerBlock("augmentor", () -> defaultBlock("augmentor"));
    public static final RegistryObject<Block> AURADINE_ORE = registerBlock("auradine_ore", () -> defaultBlock("auradine_ore"));
    public static final RegistryObject<Block> AZURE_ROOT = registerBlock("azure_root", () -> defaultBlock("azure_root"));
    public static final RegistryObject<Block> BATTLE_SNAKE = registerBlock("battle_snake", () -> defaultBlock("battle_snake"));
    public static final RegistryObject<Block> BATTLE_SNAKE_HEAD = registerBlock("battle_snake_head", () -> defaultBlock("battle_snake_head"));
    public static final RegistryObject<Block> BATTLE_SNAKE_POWERUP = registerBlock("battle_snake_powerup", () -> defaultBlock("battle_snake_powerup"));
    public static final RegistryObject<Block> BEE_HIVE = registerBlock("bee_hive", () -> defaultBlock("bee_hive"));
    public static final RegistryObject<Block> BLAZING_DAHILA_STEM = registerBlock("blazing_dahila_stem", () -> defaultBlock("blazing_dahila_stem"));
    public static final RegistryObject<Block> BLAZING_DAHILA_TOP = registerBlock("blazing_dahila_top", () -> defaultBlock("blazing_dahila_top"));
    public static final RegistryObject<Block> BLIGHT_EYE = registerBlock("blight_eye", () -> defaultBlock("blight_eye"));
    public static final RegistryObject<Block> BLIGHT_EYE_EMPTY = registerBlock("blight_eye_empty", () -> defaultBlock("blight_eye_empty"));
    public static final RegistryObject<Block> BLIGHT_IDOL_SUMMONER = registerBlock("blight_idol_summoner", () -> defaultBlock("blight_idol_summoner"));
    public static final RegistryObject<Block> BLIGHT_MOUTH = registerBlock("blight_mouth", () -> defaultBlock("blight_mouth"));
    public static final RegistryObject<Block> BLIGHTBLOOM = registerBlock("blightbloom", () -> defaultBlock("blightbloom"));
    public static final RegistryObject<Block> BLIGHTBLOOM_STEM = registerBlock("blightbloom_stem", () -> defaultBlock("blightbloom_stem"));
    public static final RegistryObject<Block> BLIGHTCUBES = registerBlock("blightcubes", () -> defaultBlock("blightcubes"));
    public static final RegistryObject<Block> BLIGHTED_CORE = registerBlock("blighted_core", () -> defaultBlock("blighted_core"));
    public static final RegistryObject<Block> BLIGHTGRASS = registerBlock("blightgrass", () -> defaultBlock("blightgrass"));
    public static final RegistryObject<Block> BLIGHTLUMGRASS = registerBlock("blightlumgrass", () -> defaultBlock("blightlumgrass"));
    public static final RegistryObject<Block> BLIGHTLUMIO_ROCK = registerBlock("blightlumio_rock", () -> defaultBlock("blightlumio_rock"));
    public static final RegistryObject<Block> BLIGHTSTOCKS = registerBlock("blightstocks", () -> defaultBlock("blightstocks"));
    public static final RegistryObject<Block> BLIGHTSTOCKS_TOP = registerBlock("blightstocks_top", () -> defaultBlock("blightstocks_top"));
    public static final RegistryObject<Block> BLIGHTVINE = registerBlock("blightvine", () -> defaultBlock("blightvine"));
    public static final RegistryObject<Block> BLIGHTVINE_ROOT = registerBlock("blightvine_root", () -> defaultBlock("blightvine_root"));
    public static final RegistryObject<Block> BLISTERBULB = registerBlock("blisterbulb", () -> defaultBlock("blisterbulb"));
    public static final RegistryObject<Block> BLOCK_TRACK = registerBlock("block_track", () -> defaultBlock("block_track"));
    public static final RegistryObject<Block> BLOCK_TRACK_USED = registerBlock("block_track_used", () -> defaultBlock("block_track_used"));
    public static final RegistryObject<Block> BLOCK_TRACK_WIN = registerBlock("block_track_win", () -> defaultBlock("block_track_win"));
    public static final RegistryObject<Block> BLOCK_TRIGGER_BLAZE = registerBlock("block_trigger_blaze", () -> defaultBlock("block_trigger_blaze"));
    public static final RegistryObject<Block> BLOCK_TRIGGER_CREEPER = registerBlock("block_trigger_creeper", () -> defaultBlock("block_trigger_creeper"));
    public static final RegistryObject<Block> BLOCK_TRIGGER_DIMTRADER = registerBlock("block_trigger_dimtrader", () -> defaultBlock("block_trigger_dimtrader"));
    public static final RegistryObject<Block> BLOCK_TRIGGER_ENDERMAN = registerBlock("block_trigger_enderman", () -> defaultBlock("block_trigger_enderman"));
    public static final RegistryObject<Block> BLOCK_TRIGGER_INGOT = registerBlock("block_trigger_ingot", () -> defaultBlock("block_trigger_ingot"));
    public static final RegistryObject<Block> BLOCK_TRIGGER_MYSTERY = registerBlock("block_trigger_mystery", () -> defaultBlock("block_trigger_mystery"));
    public static final RegistryObject<Block> BLOCK_TRIGGER_PIGLIN = registerBlock("block_trigger_piglin", () -> defaultBlock("block_trigger_piglin"));
    public static final RegistryObject<Block> BLOCK_TRIGGER_SKELETON = registerBlock("block_trigger_skeleton", () -> defaultBlock("block_trigger_skeleton"));
    public static final RegistryObject<Block> BLOCK_TRIGGER_SPIDER = registerBlock("block_trigger_spider", () -> defaultBlock("block_trigger_spider"));
    public static final RegistryObject<Block> BLOCK_TRIGGER_STRAY = registerBlock("block_trigger_stray", () -> defaultBlock("block_trigger_stray"));
    public static final RegistryObject<Block> BOMBER_WALL_FLOOR = registerBlock("bomber_wall_floor", () -> defaultBlock("bomber_wall_floor"));
    public static final RegistryObject<Block> BOMBER_WALL_HARD = registerBlock("bomber_wall_hard", () -> defaultBlock("bomber_wall_hard"));
    public static final RegistryObject<Block> BOMBER_WALL_SOFT = registerBlock("bomber_wall_soft", () -> defaultBlock("bomber_wall_soft"));
    public static final RegistryObject<Block> BOMBERS_POWERUP_CLOSED = registerBlock("bombers_powerup_closed", () -> defaultBlock("bombers_powerup_closed"));
    public static final RegistryObject<Block> BOMBERS_POWERUP_COOLDOWN = registerBlock("bombers_powerup_cooldown", () -> defaultBlock("bombers_powerup_cooldown"));
    public static final RegistryObject<Block> BOMBERS_POWERUP_SHIELD = registerBlock("bombers_powerup_shield", () -> defaultBlock("bombers_powerup_shield"));
    public static final RegistryObject<Block> BOMBERS_POWERUP_SIZE = registerBlock("bombers_powerup_size", () -> defaultBlock("bombers_powerup_size"));
    public static final RegistryObject<Block> BOMBERS_POWERUP_SPEED = registerBlock("bombers_powerup_speed", () -> defaultBlock("bombers_powerup_speed"));
    public static final RegistryObject<Block> BOSS_GATE = registerBlock("boss_gate", () -> defaultBlock("boss_gate"));
    public static final RegistryObject<Block> BUMBLEFRUIT = registerBlock("bumblefruit", () -> defaultBlock("bumblefruit"));
    public static final RegistryObject<Block> CATATONITE_ORE = registerBlock("catatonite_ore", () -> defaultBlock("catatonite_ore"));
    public static final RegistryObject<Block> CAVECRYSTAL_BLUE = registerBlock("cavecrystal_blue", () -> defaultBlock("cavecrystal_blue"));
    public static final RegistryObject<Block> CAVECRYSTAL_PINK = registerBlock("cavecrystal_pink", () -> defaultBlock("cavecrystal_pink"));
    public static final RegistryObject<Block> CAVECRYSTAL_RED = registerBlock("cavecrystal_red", () -> defaultBlock("cavecrystal_red"));
    public static final RegistryObject<Block> CAVEVINE = registerBlock("cavevine", () -> defaultBlock("cavevine"));
    public static final RegistryObject<Block> CELESTIAL_ARMOR_NAVY = registerBlock("celestial_armor_navy", () -> defaultBlock("celestial_armor_navy"));
    public static final RegistryObject<Block> CELESTIAL_ARMOR_PINK = registerBlock("celestial_armor_pink", () -> defaultBlock("celestial_armor_pink"));
    public static final RegistryObject<Block> CELESTIAL_ARMOR_PURPLE = registerBlock("celestial_armor_purple", () -> defaultBlock("celestial_armor_purple"));
    public static final RegistryObject<Block> CELESTIAL_ARMOR_TEAL = registerBlock("celestial_armor_teal", () -> defaultBlock("celestial_armor_teal"));
    public static final RegistryObject<Block> CELESTIAL_BARRIER = registerBlock("celestial_barrier", () -> defaultBlock("celestial_barrier"));
    public static final RegistryObject<Block> CELESTIAL_BODY_BLUE = registerBlock("celestial_body_blue", () -> defaultBlock("celestial_body_blue"));
    public static final RegistryObject<Block> CELESTIAL_BODY_RED = registerBlock("celestial_body_red", () -> defaultBlock("celestial_body_red"));
    public static final RegistryObject<Block> CELESTIAL_BODY_VIOLET = registerBlock("celestial_body_violet", () -> defaultBlock("celestial_body_violet"));
    public static final RegistryObject<Block> CELESTIAL_BODY_YELLOW = registerBlock("celestial_body_yellow", () -> defaultBlock("celestial_body_yellow"));
    public static final RegistryObject<Block> CELESTIAL_CORE_BLUE = registerBlock("celestial_core_blue", () -> defaultBlock("celestial_core_blue"));
    public static final RegistryObject<Block> CELESTIAL_CORE_GREEN = registerBlock("celestial_core_green", () -> defaultBlock("celestial_core_green"));
    public static final RegistryObject<Block> CELESTIAL_CORE_ORANGE = registerBlock("celestial_core_orange", () -> defaultBlock("celestial_core_orange"));
    public static final RegistryObject<Block> CELESTIAL_CORE_YELLOW = registerBlock("celestial_core_yellow", () -> defaultBlock("celestial_core_yellow"));
    public static final RegistryObject<Block> CELESTIAL_EYE_BLUE = registerBlock("celestial_eye_blue", () -> defaultBlock("celestial_eye_blue"));
    public static final RegistryObject<Block> CELESTIAL_EYE_LIME = registerBlock("celestial_eye_lime", () -> defaultBlock("celestial_eye_lime"));
    public static final RegistryObject<Block> CELESTIAL_EYE_PINK = registerBlock("celestial_eye_pink", () -> defaultBlock("celestial_eye_pink"));
    public static final RegistryObject<Block> CELESTIAL_EYE_YELLOW = registerBlock("celestial_eye_yellow", () -> defaultBlock("celestial_eye_yellow"));
    public static final RegistryObject<Block> CELESTIAL_OUTER_BLUE = registerBlock("celestial_outer_blue", () -> defaultBlock("celestial_outer_blue"));
    public static final RegistryObject<Block> CELESTIAL_OUTER_MAROON = registerBlock("celestial_outer_maroon", () -> defaultBlock("celestial_outer_maroon"));
    public static final RegistryObject<Block> CELESTIAL_OUTER_NAVY = registerBlock("celestial_outer_navy", () -> defaultBlock("celestial_outer_navy"));
    public static final RegistryObject<Block> CELESTIAL_OUTER_PURPLE = registerBlock("celestial_outer_purple", () -> defaultBlock("celestial_outer_purple"));
    public static final RegistryObject<Block> CELESTIAL_TRIM_NAVY = registerBlock("celestial_trim_navy", () -> defaultBlock("celestial_trim_navy"));
    public static final RegistryObject<Block> CELESTIAL_TRIM_PINK = registerBlock("celestial_trim_pink", () -> defaultBlock("celestial_trim_pink"));
    public static final RegistryObject<Block> CELESTIAL_TRIM_PURPLE = registerBlock("celestial_trim_purple", () -> defaultBlock("celestial_trim_purple"));
    public static final RegistryObject<Block> CELESTIAL_TRIM_TEAL = registerBlock("celestial_trim_teal", () -> defaultBlock("celestial_trim_teal"));
    public static final RegistryObject<Block> CELL_CHARGER = registerBlock("cell_charger", () -> defaultBlock("cell_charger"));
    public static final RegistryObject<Block> CELL_CONTAINER_3 = registerBlock("cell_container_3", () -> defaultBlock("cell_container_3"));
    public static final RegistryObject<Block> CELL_CONTAINER_5 = registerBlock("cell_container_5", () -> defaultBlock("cell_container_5"));
    public static final RegistryObject<Block> CELL_CONTAINER_7 = registerBlock("cell_container_7", () -> defaultBlock("cell_container_7"));
    public static final RegistryObject<Block> CELL_CONTAINER_9 = registerBlock("cell_container_9", () -> defaultBlock("cell_container_9"));
    public static final RegistryObject<Block> CELL_GAME = registerBlock("cell_game", () -> defaultBlock("cell_game"));
    public static final RegistryObject<Block> CELLULAR_ORE = registerBlock("cellular_ore", () -> defaultBlock("cellular_ore"));
    public static final RegistryObject<Block> CHAMPION_BAY = registerBlock("champion_bay", () -> defaultBlock("champion_bay"));
    public static final RegistryObject<Block> CHAMPION_BAY_LIGHT = registerBlock("champion_bay_light", () -> defaultBlock("champion_bay_light"));
    public static final RegistryObject<Block> CHAMPION_CARPET_BATTLESNAKES = registerBlock("champion_carpet_battlesnakes", () -> defaultBlock("champion_carpet_battlesnakes"));
    public static final RegistryObject<Block> CHAMPION_CARPET_BATTLESNAKES_CUT = registerBlock("champion_carpet_battlesnakes_cut", () -> defaultBlock("champion_carpet_battlesnakes_cut"));
    public static final RegistryObject<Block> CHAMPION_CARPET_BOMBERS = registerBlock("champion_carpet_bombers", () -> defaultBlock("champion_carpet_bombers"));
    public static final RegistryObject<Block> CHAMPION_CARPET_BOMBERS_CUT = registerBlock("champion_carpet_bombers_cut", () -> defaultBlock("champion_carpet_bombers_cut"));
    public static final RegistryObject<Block> CHAMPION_CARPET_CUT = registerBlock("champion_carpet_cut", () -> defaultBlock("champion_carpet_cut"));
    public static final RegistryObject<Block> CHAMPION_CARPET_DODGEBALL = registerBlock("champion_carpet_dodgeball", () -> defaultBlock("champion_carpet_dodgeball"));
    public static final RegistryObject<Block> CHAMPION_CARPET_DODGEBALL_CUT = registerBlock("champion_carpet_dodgeball_cut", () -> defaultBlock("champion_carpet_dodgeball_cut"));
    public static final RegistryObject<Block> CHAMPION_CARPET_DUEL = registerBlock("champion_carpet_duel", () -> defaultBlock("champion_carpet_duel"));
    public static final RegistryObject<Block> CHAMPION_CARPET_DUEL_CUT = registerBlock("champion_carpet_duel_cut", () -> defaultBlock("champion_carpet_duel_cut"));
    public static final RegistryObject<Block> CHAMPION_CARPET_HOLODECK = registerBlock("champion_carpet_holodeck", () -> defaultBlock("champion_carpet_holodeck"));
    public static final RegistryObject<Block> CHAMPION_CARPET_HOLODECK_CUT = registerBlock("champion_carpet_holodeck_cut", () -> defaultBlock("champion_carpet_holodeck_cut"));
    public static final RegistryObject<Block> CHAMPION_CARPET_HUNTERS = registerBlock("champion_carpet_hunters", () -> defaultBlock("champion_carpet_hunters"));
    public static final RegistryObject<Block> CHAMPION_CARPET_HUNTERS_CUT = registerBlock("champion_carpet_hunters_cut", () -> defaultBlock("champion_carpet_hunters_cut"));
    public static final RegistryObject<Block> CHAMPION_CARPET_INKWARS = registerBlock("champion_carpet_inkwars", () -> defaultBlock("champion_carpet_inkwars"));
    public static final RegistryObject<Block> CHAMPION_CARPET_INKWARS_CUT = registerBlock("champion_carpet_inkwars_cut", () -> defaultBlock("champion_carpet_inkwars_cut"));
    public static final RegistryObject<Block> CHAMPION_CARPET_LASERWARZ = registerBlock("champion_carpet_laserwarz", () -> defaultBlock("champion_carpet_laserwarz"));
    public static final RegistryObject<Block> CHAMPION_CARPET_LASERWARZ_CUT = registerBlock("champion_carpet_laserwarz_cut", () -> defaultBlock("champion_carpet_laserwarz_cut"));
    public static final RegistryObject<Block> CHAMPION_CARPET_LIGHTBRIDGE = registerBlock("champion_carpet_lightbridge", () -> defaultBlock("champion_carpet_lightbridge"));
    public static final RegistryObject<Block> CHAMPION_CARPET_LIGHTBRIDGE_CUT = registerBlock("champion_carpet_lightbridge_cut", () -> defaultBlock("champion_carpet_lightbridge_cut"));
    public static final RegistryObject<Block> CHAMPION_CARPET_OBSTACLEALLEY = registerBlock("champion_carpet_obstaclealley", () -> defaultBlock("champion_carpet_obstaclealley"));
    public static final RegistryObject<Block> CHAMPION_CARPET_OBSTACLEALLEY_CUT = registerBlock("champion_carpet_obstaclealley_cut", () -> defaultBlock("champion_carpet_obstaclealley_cut"));
    public static final RegistryObject<Block> CHAMPION_CARPET_PARKOUR = registerBlock("champion_carpet_parkour", () -> defaultBlock("champion_carpet_parkour"));
    public static final RegistryObject<Block> CHAMPION_CARPET_PARKOUR_CUT = registerBlock("champion_carpet_parkour_cut", () -> defaultBlock("champion_carpet_parkour_cut"));
    public static final RegistryObject<Block> CHAMPION_CARPET_REDLIGHT = registerBlock("champion_carpet_redlight", () -> defaultBlock("champion_carpet_redlight"));
    public static final RegistryObject<Block> CHAMPION_CARPET_REDLIGHT_CUT = registerBlock("champion_carpet_redlight_cut", () -> defaultBlock("champion_carpet_redlight_cut"));
    public static final RegistryObject<Block> CHAMPION_CARPET_TARGETS = registerBlock("champion_carpet_targets", () -> defaultBlock("champion_carpet_targets"));
    public static final RegistryObject<Block> CHAMPION_CARPET_TARGETS_CUT = registerBlock("champion_carpet_targets_cut", () -> defaultBlock("champion_carpet_targets_cut"));
    public static final RegistryObject<Block> CHAMPION_CARPET_WAITINGZONE = registerBlock("champion_carpet_waitingzone", () -> defaultBlock("champion_carpet_waitingzone"));
    public static final RegistryObject<Block> CHAMPION_DOOR_AJAR = registerBlock("champion_door_ajar", () -> defaultBlock("champion_door_ajar"));
    public static final RegistryObject<Block> CHAMPION_DOOR_CLOSED = registerBlock("champion_door_closed", () -> defaultBlock("champion_door_closed"));
    public static final RegistryObject<Block> CHAMPION_DOOR_OPEN = registerBlock("champion_door_open", () -> defaultBlock("champion_door_open"));
    public static final RegistryObject<Block> CHAMPION_DUNGEON_BOX = registerBlock("champion_dungeon_box", () -> defaultBlock("champion_dungeon_box"));
    public static final RegistryObject<Block> CHAMPION_DUNGEON_BRICK = registerBlock("champion_dungeon_brick", () -> defaultBlock("champion_dungeon_brick"));
    public static final RegistryObject<Block> CHAMPION_DUNGEON_PLATING = registerBlock("champion_dungeon_plating", () -> defaultBlock("champion_dungeon_plating"));
    public static final RegistryObject<Block> CHAMPION_DUNGEON_SELECTOR = registerBlock("champion_dungeon_selector", () -> defaultBlock("champion_dungeon_selector"));
    public static final RegistryObject<Block> CHAMPION_DUNGEON_WINDOW = registerBlock("champion_dungeon_window", () -> defaultBlock("champion_dungeon_window"));
    public static final RegistryObject<Block> CHAMPION_ELIMINATOR = registerBlock("champion_eliminator", () -> defaultBlock("champion_eliminator"));
    public static final RegistryObject<Block> CHAMPION_FOUNTAIN_TRAP = registerBlock("champion_fountain_trap", () -> defaultBlock("champion_fountain_trap"));
    public static final RegistryObject<Block> CHAMPION_GATE = registerBlock("champion_gate", () -> defaultBlock("champion_gate"));
    public static final RegistryObject<Block> CHAMPION_GLASS = registerBlock("champion_glass", () -> defaultBlock("champion_glass"));
    public static final RegistryObject<Block> CHAMPION_GLASS_DARK = registerBlock("champion_glass_dark", () -> defaultBlock("champion_glass_dark"));
    public static final RegistryObject<Block> CHAMPION_GLOWING_TILE = registerBlock("champion_glowing_tile", () -> defaultBlock("champion_glowing_tile"));
    public static final RegistryObject<Block> CHAMPION_HEAT_TRAP = registerBlock("champion_heat_trap", () -> defaultBlock("champion_heat_trap"));
    public static final RegistryObject<Block> CHAMPION_LAUNCHER = registerBlock("champion_launcher", () -> defaultBlock("champion_launcher"));
    public static final RegistryObject<Block> CHAMPION_LIGHT = registerBlock("champion_light", () -> defaultBlock("champion_light"));
    public static final RegistryObject<Block> CHAMPION_LOGO_CORE = registerBlock("champion_logo_core", () -> defaultBlock("champion_logo_core"));
    public static final RegistryObject<Block> CHAMPION_LOGO_GOLD = registerBlock("champion_logo_gold", () -> defaultBlock("champion_logo_gold"));
    public static final RegistryObject<Block> CHAMPION_LOGO_PURPLE = registerBlock("champion_logo_purple", () -> defaultBlock("champion_logo_purple"));
    public static final RegistryObject<Block> CHAMPION_PLATFORM = registerBlock("champion_platform", () -> defaultBlock("champion_platform"));
    public static final RegistryObject<Block> CHAMPION_PLATFORM_HIGHLIGHTED = registerBlock("champion_platform_highlighted", () -> defaultBlock("champion_platform_highlighted"));
    public static final RegistryObject<Block> CHAMPION_REINFORCEMENT = registerBlock("champion_reinforcement", () -> defaultBlock("champion_reinforcement"));
    public static final RegistryObject<Block> CHAMPION_SIGNAL_GREEN = registerBlock("champion_signal_green", () -> defaultBlock("champion_signal_green"));
    public static final RegistryObject<Block> CHAMPION_SIGNAL_RED = registerBlock("champion_signal_red", () -> defaultBlock("champion_signal_red"));
    public static final RegistryObject<Block> CHAMPION_STEEL = registerBlock("champion_steel", () -> defaultBlock("champion_steel"));
    public static final RegistryObject<Block> CHAMPION_STEEL_BEAM = registerBlock("champion_steel_beam", () -> defaultBlock("champion_steel_beam"));
    public static final RegistryObject<Block> CHAMPION_STEEL_FLOOR = registerBlock("champion_steel_floor", () -> defaultBlock("champion_steel_floor"));
    public static final RegistryObject<Block> CHAMPION_STEEL_STAIRS = registerBlock("champion_steel_stairs", () -> defaultBlock("champion_steel_stairs"));
    public static final RegistryObject<Block> CHAMPION_STEEL_WIRING = registerBlock("champion_steel_wiring", () -> defaultBlock("champion_steel_wiring"));
    public static final RegistryObject<Block> CHAMPION_STROBE_SYNC1 = registerBlock("champion_strobe_sync1", () -> defaultBlock("champion_strobe_sync1"));
    public static final RegistryObject<Block> CHAMPION_STROBE_SYNC2 = registerBlock("champion_strobe_sync2", () -> defaultBlock("champion_strobe_sync2"));
    public static final RegistryObject<Block> CHAMPION_STROBE_SYNC3 = registerBlock("champion_strobe_sync3", () -> defaultBlock("champion_strobe_sync3"));
    public static final RegistryObject<Block> CHAMPION_STROBE_SYNC4 = registerBlock("champion_strobe_sync4", () -> defaultBlock("champion_strobe_sync4"));
    public static final RegistryObject<Block> CHAMPION_STROBE_SYNC5 = registerBlock("champion_strobe_sync5", () -> defaultBlock("champion_strobe_sync5"));
    public static final RegistryObject<Block> CHAMPION_TEMPEREDGLASS = registerBlock("champion_temperedglass", () -> defaultBlock("champion_temperedglass"));
    public static final RegistryObject<Block> CHAMPION_TEMPEREDGLASS_HIGHLIGHTED = registerBlock("champion_temperedglass_highlighted", () -> defaultBlock("champion_temperedglass_highlighted"));
    public static final RegistryObject<Block> CHAMPION_WALL = registerBlock("champion_wall", () -> defaultBlock("champion_wall"));
    public static final RegistryObject<Block> CHEMISTRY_TABLE = registerBlock("chemistry_table", () -> defaultBlock("chemistry_table"));
    public static final RegistryObject<Block> CHIP_FORMATTER = registerBlock("chip_formatter", () -> defaultBlock("chip_formatter"));
    public static final RegistryObject<Block> CHIP_FORMATTER_POWER = registerBlock("chip_formatter_power", () -> defaultBlock("chip_formatter_power"));
    public static final RegistryObject<Block> CHROMA_GAME = registerBlock("chroma_game", () -> defaultBlock("chroma_game"));
    public static final RegistryObject<Block> CHROMA_TILE = registerBlock("chroma_tile", () -> defaultBlock("chroma_tile"));
    public static final RegistryObject<Block> CIRCUIT_CALIBRATOR = registerBlock("circuit_calibrator", () -> defaultBlock("circuit_calibrator"));
    public static final RegistryObject<Block> CIRCUIT_MONITOR = registerBlock("circuit_monitor", () -> defaultBlock("circuit_monitor"));
    public static final RegistryObject<Block> CLOVINITE_ORE = registerBlock("clovinite_ore", () -> defaultBlock("clovinite_ore"));
    public static final RegistryObject<Block> COMBUSTION_ENGINE = registerBlock("combustion_engine", () -> defaultBlock("combustion_engine"));
    public static final RegistryObject<Block> COMPRESSIONTABLE = registerBlock("compressiontable", () -> defaultBlock("compressiontable"));
    public static final RegistryObject<Block> CONCENTRATED_ACID = registerBlock("concentrated_acid", () -> defaultBlock("concentrated_acid"));
    public static final RegistryObject<Block> CONNECT_BLOCK = registerBlock("connect_block", () -> defaultBlock("connect_block"));
    public static final RegistryObject<Block> CONNECT_BLOCK_RED = registerBlock("connect_block_red", () -> defaultBlock("connect_block_red"));
    public static final RegistryObject<Block> CONNECT_BLOCK_YELLOW = registerBlock("connect_block_yellow", () -> defaultBlock("connect_block_yellow"));
    public static final RegistryObject<Block> CONNECT_BUTTON = registerBlock("connect_button", () -> defaultBlock("connect_button"));
    public static final RegistryObject<Block> CONNECT_GAME = registerBlock("connect_game", () -> defaultBlock("connect_game"));
    public static final RegistryObject<Block> CONTAINMENT_GATE = registerBlock("containment_gate", () -> defaultBlock("containment_gate"));
    public static final RegistryObject<Block> COSMIC_FRACTURE = registerBlock("cosmic_fracture", () -> defaultBlock("cosmic_fracture"));
    public static final RegistryObject<Block> CRUSHER_BUTTON = registerBlock("crusher_button", () -> defaultBlock("crusher_button"));
    public static final RegistryObject<Block> CRYSTAL_DEPOSIT = registerBlock("crystal_deposit", () -> defaultBlock("crystal_deposit"));
    public static final RegistryObject<Block> CRYSTAL_LILY = registerBlock("crystal_lily", () -> defaultBlock("crystal_lily"));
    public static final RegistryObject<Block> CRYSTALBLOSSOMS = registerBlock("crystalblossoms", () -> defaultBlock("crystalblossoms"));
    public static final RegistryObject<Block> CRYSTALBLOSSOMS_STEM = registerBlock("crystalblossoms_stem", () -> defaultBlock("crystalblossoms_stem"));
    public static final RegistryObject<Block> CRYSTALLIZED_SOIL = registerBlock("crystallized_soil", () -> defaultBlock("crystallized_soil"));
    public static final RegistryObject<Block> CRYSTALLIZED_SOIL_POWERED = registerBlock("crystallized_soil_powered", () -> defaultBlock("crystallized_soil_powered"));
    public static final RegistryObject<Block> CRYSTALLIZED_SOIL_UNPOWERED = registerBlock("crystallized_soil_unpowered", () -> defaultBlock("crystallized_soil_unpowered"));
    public static final RegistryObject<Block> CRYSTONIUM_ORE = registerBlock("crystonium_ore", () -> defaultBlock("crystonium_ore"));
    public static final RegistryObject<Block> CTHULHU_SPAWNER = registerBlock("cthulhu_spawner", () -> defaultBlock("cthulhu_spawner"));
    public static final RegistryObject<Block> DARK_ROUGH_CORAL = registerBlock("dark_rough_coral", () -> defaultBlock("dark_rough_coral"));
    public static final RegistryObject<Block> DARKSTEEL_ORE = registerBlock("darksteel_ore", () -> defaultBlock("darksteel_ore"));
    public static final RegistryObject<Block> DARKVINE = registerBlock("darkvine", () -> defaultBlock("darkvine"));
    public static final RegistryObject<Block> DARKWORLD_CONVERTER = registerBlock("darkworld_converter", () -> defaultBlock("darkworld_converter"));
    public static final RegistryObject<Block> DECONSTRUCTOR = registerBlock("deconstructor", () -> defaultBlock("deconstructor"));
    public static final RegistryObject<Block> DENSE_KELP = registerBlock("dense_kelp", () -> defaultBlock("dense_kelp"));
    public static final RegistryObject<Block> DEPLETED_ORE = registerBlock("depleted_ore", () -> defaultBlock("depleted_ore"));
    public static final RegistryObject<Block> DEPTH_MODULE = registerBlock("depth_module", () -> defaultBlock("depth_module"));
    public static final RegistryObject<Block> DETHERIUM_ORE = registerBlock("detherium_ore", () -> defaultBlock("detherium_ore"));
    public static final RegistryObject<Block> DEVIANT_WEEDS = registerBlock("deviant_weeds", () -> defaultBlock("deviant_weeds"));
    public static final RegistryObject<Block> DEVIATION_FIELD = registerBlock("deviation_field", () -> defaultBlock("deviation_field"));
    public static final RegistryObject<Block> DIMENSIONALIZER = registerBlock("dimensionalizer", () -> defaultBlock("dimensionalizer"));
    public static final RegistryObject<Block> DOOMGLOW = registerBlock("doomglow", () -> defaultBlock("doomglow"));
    public static final RegistryObject<Block> DRILL_BEAM = registerBlock("drill_beam", () -> defaultBlock("drill_beam"));
    public static final RegistryObject<Block> DRILL_CONSOLE = registerBlock("drill_console", () -> defaultBlock("drill_console"));
    public static final RegistryObject<Block> DRILL_CONTROL = registerBlock("drill_control", () -> defaultBlock("drill_control"));
    public static final RegistryObject<Block> DRILL_HEAD = registerBlock("drill_head", () -> defaultBlock("drill_head"));
    public static final RegistryObject<Block> DRILL_SHAFT = registerBlock("drill_shaft", () -> defaultBlock("drill_shaft"));
    public static final RegistryObject<Block> EFFICIENCY_MODULE = registerBlock("efficiency_module", () -> defaultBlock("efficiency_module"));
    public static final RegistryObject<Block> EMBERGRASS = registerBlock("embergrass", () -> defaultBlock("embergrass"));
    public static final RegistryObject<Block> EMBERIUM_ORE = registerBlock("emberium_ore", () -> defaultBlock("emberium_ore"));
    public static final RegistryObject<Block> EMBERKELP = registerBlock("emberkelp", () -> defaultBlock("emberkelp"));
    public static final RegistryObject<Block> EMBERLEAF = registerBlock("emberleaf", () -> defaultBlock("emberleaf"));
    public static final RegistryObject<Block> EMBERSLAG = registerBlock("emberslag", () -> defaultBlock("emberslag"));
    public static final RegistryObject<Block> EMBERSLAG_DEPOSIT = registerBlock("emberslag_deposit", () -> defaultBlock("emberslag_deposit"));
    public static final RegistryObject<Block> EMPTY_HIVENITE = registerBlock("empty_hivenite", () -> defaultBlock("empty_hivenite"));
    public static final RegistryObject<Block> ENGHOULED_ASTROROCK = registerBlock("enghouled_astrorock", () -> defaultBlock("enghouled_astrorock"));
    public static final RegistryObject<Block> EQUIVINE = registerBlock("equivine", () -> defaultBlock("equivine"));
    public static final RegistryObject<Block> ETERNAL_BEACON = registerBlock("eternal_beacon", () -> defaultBlock("eternal_beacon"));
    public static final RegistryObject<Block> ETHERSTOCK = registerBlock("etherstock", () -> defaultBlock("etherstock"));
    public static final RegistryObject<Block> EXOTHERMITE_ORE = registerBlock("exothermite_ore", () -> defaultBlock("exothermite_ore"));
    public static final RegistryObject<Block> FABRIC_REFORMULATOR = registerBlock("fabric_reformulator", () -> defaultBlock("fabric_reformulator"));
    public static final RegistryObject<Block> FABRICATION_BATTERY = registerBlock("fabrication_battery", () -> defaultBlock("fabrication_battery"));
    public static final RegistryObject<Block> FABRICATION_TABLE = registerBlock("fabrication_table", () -> defaultBlock("fabrication_table"));
    public static final RegistryObject<Block> FACTORY_CHAIN = registerBlock("factory_chain", () -> defaultBlock("factory_chain"));
    public static final RegistryObject<Block> FACTORY_CRATE = registerBlock("factory_crate", () -> defaultBlock("factory_crate"));
    public static final RegistryObject<Block> FACTORY_FLOOR = registerBlock("factory_floor", () -> defaultBlock("factory_floor"));
    public static final RegistryObject<Block> FACTORY_LANTERN = registerBlock("factory_lantern", () -> defaultBlock("factory_lantern"));
    public static final RegistryObject<Block> FACTORY_PLATFORM_DOUBLE = registerBlock("factory_platform_double", () -> defaultBlock("factory_platform_double"));
    public static final RegistryObject<Block> FACTORY_PLATFORM_HALF = registerBlock("factory_platform_half", () -> defaultBlock("factory_platform_half"));
    public static final RegistryObject<Block> FACTORY_SCAFFOLD = registerBlock("factory_scaffold", () -> defaultBlock("factory_scaffold"));
    public static final RegistryObject<Block> FALL_BRIDGE = registerBlock("fall_bridge", () -> defaultBlock("fall_bridge"));
    public static final RegistryObject<Block> FIRELILLY = registerBlock("firelilly", () -> defaultBlock("firelilly"));
    public static final RegistryObject<Block> FISH_CHOW = registerBlock("fish_chow", () -> defaultBlock("fish_chow"));
    public static final RegistryObject<Block> FORGE_STALACTITE = registerBlock("forge_stalactite", () -> defaultBlock("forge_stalactite"));
    public static final RegistryObject<Block> FORGEBLOOM = registerBlock("forgebloom", () -> defaultBlock("forgebloom"));
    public static final RegistryObject<Block> FORGEFIRE_LANTERN = registerBlock("forgefire_lantern", () -> defaultBlock("forgefire_lantern"));
    public static final RegistryObject<Block> FORGEROCK = registerBlock("forgerock", () -> defaultBlock("forgerock"));
    public static final RegistryObject<Block> FORGESHROOM_BLUE = registerBlock("forgeshroom_blue", () -> defaultBlock("forgeshroom_blue"));
    public static final RegistryObject<Block> FORGESHROOM_GREEN = registerBlock("forgeshroom_green", () -> defaultBlock("forgeshroom_green"));
    public static final RegistryObject<Block> FORGESHROOM_PURPLE = registerBlock("forgeshroom_purple", () -> defaultBlock("forgeshroom_purple"));
    public static final RegistryObject<Block> FORGESHROOM_RED = registerBlock("forgeshroom_red", () -> defaultBlock("forgeshroom_red"));
    public static final RegistryObject<Block> FORGESHROOM_STEM = registerBlock("forgeshroom_stem", () -> defaultBlock("forgeshroom_stem"));
    public static final RegistryObject<Block> FORGESHROOM_YELLOW = registerBlock("forgeshroom_yellow", () -> defaultBlock("forgeshroom_yellow"));
    public static final RegistryObject<Block> FOSSIL_COMBINER = registerBlock("fossil_combiner", () -> defaultBlock("fossil_combiner"));
    public static final RegistryObject<Block> FOSSIL_TRACK = registerBlock("fossil_track", () -> defaultBlock("fossil_track"));
    public static final RegistryObject<Block> FUNGAL_ASTROMUD = registerBlock("fungal_astromud", () -> defaultBlock("fungal_astromud"));
    public static final RegistryObject<Block> FUNGAL_ASTROMUD_BLUE = registerBlock("fungal_astromud_blue", () -> defaultBlock("fungal_astromud_blue"));
    public static final RegistryObject<Block> FUNGAL_ASTROMUD_TEAL = registerBlock("fungal_astromud_teal", () -> defaultBlock("fungal_astromud_teal"));
    public static final RegistryObject<Block> FUNGAL_ASTROROCK = registerBlock("fungal_astrorock", () -> defaultBlock("fungal_astrorock"));
    public static final RegistryObject<Block> FUNGAL_BLOCKAGE = registerBlock("fungal_blockage", () -> defaultBlock("fungal_blockage"));
    public static final RegistryObject<Block> FUSION_TABLE = registerBlock("fusion_table", () -> defaultBlock("fusion_table"));
    public static final RegistryObject<Block> GALACTIC_CHALLENGE = registerBlock("galactic_challenge", () -> defaultBlock("galactic_challenge"));
    public static final RegistryObject<Block> GALAXY_GATE = registerBlock("galaxy_gate", () -> defaultBlock("galaxy_gate"));
    public static final RegistryObject<Block> GALAXY_PORTAL_ARC = registerBlock("galaxy_portal_arc", () -> defaultBlock("galaxy_portal_arc"));
    public static final RegistryObject<Block> GALAXY_PORTAL_BLIGHT = registerBlock("galaxy_portal_blight", () -> defaultBlock("galaxy_portal_blight"));
    public static final RegistryObject<Block> GALAXY_PORTAL_HOME = registerBlock("galaxy_portal_home", () -> defaultBlock("galaxy_portal_home"));
    public static final RegistryObject<Block> GALAXY_PORTAL_LUMIN = registerBlock("galaxy_portal_lumin", () -> defaultBlock("galaxy_portal_lumin"));
    public static final RegistryObject<Block> GALAXY_PORTAL_MANU = registerBlock("galaxy_portal_manu", () -> defaultBlock("galaxy_portal_manu"));
    public static final RegistryObject<Block> GALAXY_PORTAL_MOLTEN = registerBlock("galaxy_portal_molten", () -> defaultBlock("galaxy_portal_molten"));
    public static final RegistryObject<Block> GALAXY_SPORE_BLUE = registerBlock("galaxy_spore_blue", () -> defaultBlock("galaxy_spore_blue"));
    public static final RegistryObject<Block> GALAXY_SPORE_GREEN = registerBlock("galaxy_spore_green", () -> defaultBlock("galaxy_spore_green"));
    public static final RegistryObject<Block> GALAXY_SPORE_PINK = registerBlock("galaxy_spore_pink", () -> defaultBlock("galaxy_spore_pink"));
    public static final RegistryObject<Block> GALAXY_SPORE_YELLOW = registerBlock("galaxy_spore_yellow", () -> defaultBlock("galaxy_spore_yellow"));
    public static final RegistryObject<Block> GALAXY_VINE_BLUE = registerBlock("galaxy_vine_blue", () -> defaultBlock("galaxy_vine_blue"));
    public static final RegistryObject<Block> GALAXY_VINE_GREEN = registerBlock("galaxy_vine_green", () -> defaultBlock("galaxy_vine_green"));
    public static final RegistryObject<Block> GALAXY_VINE_PINK = registerBlock("galaxy_vine_pink", () -> defaultBlock("galaxy_vine_pink"));
    public static final RegistryObject<Block> GALAXY_VINE_YELLOW = registerBlock("galaxy_vine_yellow", () -> defaultBlock("galaxy_vine_yellow"));
    public static final RegistryObject<Block> GALDUNGEONREWARD1 = registerBlock("galdungeonreward1", () -> defaultBlock("galdungeonreward1"));
    public static final RegistryObject<Block> GALDUNGEONREWARD2 = registerBlock("galdungeonreward2", () -> defaultBlock("galdungeonreward2"));
    public static final RegistryObject<Block> GALDUNGEONREWARD3 = registerBlock("galdungeonreward3", () -> defaultBlock("galdungeonreward3"));
    public static final RegistryObject<Block> GALDUNGEONREWARD4 = registerBlock("galdungeonreward4", () -> defaultBlock("galdungeonreward4"));
    public static final RegistryObject<Block> GALDUNGEONTARGET = registerBlock("galdungeontarget", () -> defaultBlock("galdungeontarget"));
    public static final RegistryObject<Block> GEARBOX = registerBlock("gearbox", () -> defaultBlock("gearbox"));
    public static final RegistryObject<Block> GLOGLOBES = registerBlock("gloglobes", () -> defaultBlock("gloglobes"));
    public static final RegistryObject<Block> GLOOMINESSENCE_ORE = registerBlock("gloominessence_ore", () -> defaultBlock("gloominessence_ore"));
    public static final RegistryObject<Block> GLOOMINESSENCE_ORE_EMPTY = registerBlock("gloominessence_ore_empty", () -> defaultBlock("gloominessence_ore_empty"));
    public static final RegistryObject<Block> GLOWING_IGNEOUS_MURKSTONE = registerBlock("glowing_igneous_murkstone", () -> defaultBlock("glowing_igneous_murkstone"));
    public static final RegistryObject<Block> GLOWINGWEEDS = registerBlock("glowingweeds", () -> defaultBlock("glowingweeds"));
    public static final RegistryObject<Block> GLOWVINE = registerBlock("glowvine", () -> defaultBlock("glowvine"));
    public static final RegistryObject<Block> GRINDER = registerBlock("grinder", () -> defaultBlock("grinder"));
    public static final RegistryObject<Block> GUIDE_BLOCK = registerBlock("guide_block", () -> defaultBlock("guide_block"));
    public static final RegistryObject<Block> GUIDE_BUTTON = registerBlock("guide_button", () -> defaultBlock("guide_button"));
    public static final RegistryObject<Block> GUIDE_START = registerBlock("guide_start", () -> defaultBlock("guide_start"));
    public static final RegistryObject<Block> HEATSAND = registerBlock("heatsand", () -> defaultBlock("heatsand"));
    public static final RegistryObject<Block> HEATWEED = registerBlock("heatweed", () -> defaultBlock("heatweed"));
    public static final RegistryObject<Block> HEXTORIUM_ORE = registerBlock("hextorium_ore", () -> defaultBlock("hextorium_ore"));
    public static final RegistryObject<Block> HIGH_POWERED_CHARGER = registerBlock("high_powered_charger", () -> defaultBlock("high_powered_charger"));
    public static final RegistryObject<Block> HIVENITE_EMPTY = registerBlock("hivenite_empty", () -> defaultBlock("hivenite_empty"));
    public static final RegistryObject<Block> HIVENITE_ORE = registerBlock("hivenite_ore", () -> defaultBlock("hivenite_ore"));
    public static final RegistryObject<Block> HONEY_GEL = registerBlock("honey_gel", () -> defaultBlock("honey_gel"));
    public static final RegistryObject<Block> HONEY_GEL_EMPTY = registerBlock("honey_gel_empty", () -> defaultBlock("honey_gel_empty"));
    public static final RegistryObject<Block> HYPER_GENERATOR_POWERED = registerBlock("hyper_generator_powered", () -> defaultBlock("hyper_generator_powered"));
    public static final RegistryObject<Block> HYPER_GENERATOR_UNPOWERED = registerBlock("hyper_generator_unpowered", () -> defaultBlock("hyper_generator_unpowered"));
    public static final RegistryObject<Block> HYPER_MELDER_POWERED = registerBlock("hyper_melder_powered", () -> defaultBlock("hyper_melder_powered"));
    public static final RegistryObject<Block> HYPER_MELDER_UNPOWERED = registerBlock("hyper_melder_unpowered", () -> defaultBlock("hyper_melder_unpowered"));
    public static final RegistryObject<Block> IGNEOUS_MURKSTONE = registerBlock("igneous_murkstone", () -> defaultBlock("igneous_murkstone"));
    public static final RegistryObject<Block> IGNEOUS_PEARL_ORE = registerBlock("igneous_pearl_ore", () -> defaultBlock("igneous_pearl_ore"));
    public static final RegistryObject<Block> IGNEOUS_SEASTONE = registerBlock("igneous_seastone", () -> defaultBlock("igneous_seastone"));
    public static final RegistryObject<Block> INCADIUM_ORE = registerBlock("incadium_ore", () -> defaultBlock("incadium_ore"));
    public static final RegistryObject<Block> INCANDESCITE_ORE = registerBlock("incandescite_ore", () -> defaultBlock("incandescite_ore"));
    public static final RegistryObject<Block> INKABLE_FLOOR = registerBlock("inkable_floor", () -> defaultBlock("inkable_floor"));
    public static final RegistryObject<Block> ION_BOMB = registerBlock("ion_bomb", () -> defaultBlock("ion_bomb"));
    public static final RegistryObject<Block> IONITE_ORE = registerBlock("ionite_ore", () -> defaultBlock("ionite_ore"));
    public static final RegistryObject<Block> ITEM_CHALLENGE_BLANK = registerBlock("item_challenge_blank", () -> defaultBlock("item_challenge_blank"));
    public static final RegistryObject<Block> ITEM_CHALLENGE_BONE = registerBlock("item_challenge_bone", () -> defaultBlock("item_challenge_bone"));
    public static final RegistryObject<Block> ITEM_CHALLENGE_BRANCH = registerBlock("item_challenge_branch", () -> defaultBlock("item_challenge_branch"));
    public static final RegistryObject<Block> ITEM_CHALLENGE_BULB = registerBlock("item_challenge_bulb", () -> defaultBlock("item_challenge_bulb"));
    public static final RegistryObject<Block> ITEM_CHALLENGE_COLLECTOR = registerBlock("item_challenge_collector", () -> defaultBlock("item_challenge_collector"));
    public static final RegistryObject<Block> ITEM_CHALLENGE_CRATE = registerBlock("item_challenge_crate", () -> defaultBlock("item_challenge_crate"));
    public static final RegistryObject<Block> ITEM_CHALLENGE_DUSKER = registerBlock("item_challenge_dusker", () -> defaultBlock("item_challenge_dusker"));
    public static final RegistryObject<Block> ITEM_CHALLENGE_EXPLOSAC = registerBlock("item_challenge_explosac", () -> defaultBlock("item_challenge_explosac"));
    public static final RegistryObject<Block> ITEM_CHALLENGE_EYE = registerBlock("item_challenge_eye", () -> defaultBlock("item_challenge_eye"));
    public static final RegistryObject<Block> ITEM_CHALLENGE_FANGS = registerBlock("item_challenge_fangs", () -> defaultBlock("item_challenge_fangs"));
    public static final RegistryObject<Block> ITEM_CHALLENGE_FEATHER = registerBlock("item_challenge_feather", () -> defaultBlock("item_challenge_feather"));
    public static final RegistryObject<Block> ITEM_CHALLENGE_FUSE = registerBlock("item_challenge_fuse", () -> defaultBlock("item_challenge_fuse"));
    public static final RegistryObject<Block> ITEM_CHALLENGE_GLOOP = registerBlock("item_challenge_gloop", () -> defaultBlock("item_challenge_gloop"));
    public static final RegistryObject<Block> ITEM_CHALLENGE_HEAVYCRYS = registerBlock("item_challenge_heavycrys", () -> defaultBlock("item_challenge_heavycrys"));
    public static final RegistryObject<Block> ITEM_CHALLENGE_MAGSTONE = registerBlock("item_challenge_magstone", () -> defaultBlock("item_challenge_magstone"));
    public static final RegistryObject<Block> ITEM_CHALLENGE_NIGHTMARE = registerBlock("item_challenge_nightmare", () -> defaultBlock("item_challenge_nightmare"));
    public static final RegistryObject<Block> ITEM_CHALLENGE_POLAR = registerBlock("item_challenge_polar", () -> defaultBlock("item_challenge_polar"));
    public static final RegistryObject<Block> ITEM_CHALLENGE_REFLECTIVE = registerBlock("item_challenge_reflective", () -> defaultBlock("item_challenge_reflective"));
    public static final RegistryObject<Block> ITEM_CHALLENGE_SHADHIDE = registerBlock("item_challenge_shadhide", () -> defaultBlock("item_challenge_shadhide"));
    public static final RegistryObject<Block> ITEM_CHALLENGE_SLIME = registerBlock("item_challenge_slime", () -> defaultBlock("item_challenge_slime"));
    public static final RegistryObject<Block> ITEM_CHALLENGE_SPINE = registerBlock("item_challenge_spine", () -> defaultBlock("item_challenge_spine"));
    public static final RegistryObject<Block> ITEM_CHALLENGE_STICKY = registerBlock("item_challenge_sticky", () -> defaultBlock("item_challenge_sticky"));
    public static final RegistryObject<Block> ITEM_CHALLENGE_TONGUE = registerBlock("item_challenge_tongue", () -> defaultBlock("item_challenge_tongue"));
    public static final RegistryObject<Block> ITEM_RIPPER = registerBlock("item_ripper", () -> defaultBlock("item_ripper"));
    public static final RegistryObject<Block> KELP = registerBlock("kelp", () -> defaultBlock("kelp"));
    public static final RegistryObject<Block> KILLER_VINE = registerBlock("killer_vine", () -> defaultBlock("killer_vine"));
    public static final RegistryObject<Block> KYLAXIUM_ORE = registerBlock("kylaxium_ore", () -> defaultBlock("kylaxium_ore"));
    public static final RegistryObject<Block> LAB_GAME_BLUE = registerBlock("lab_game_blue", () -> defaultBlock("lab_game_blue"));
    public static final RegistryObject<Block> LAB_GAME_PURPLE = registerBlock("lab_game_purple", () -> defaultBlock("lab_game_purple"));
    public static final RegistryObject<Block> LAB_GAME_STARTER_ORANGE = registerBlock("lab_game_starter_orange", () -> defaultBlock("lab_game_starter_orange"));
    public static final RegistryObject<Block> LAB_GAME_YELLOW = registerBlock("lab_game_yellow", () -> defaultBlock("lab_game_yellow"));
    public static final RegistryObject<Block> LAB_GATE = registerBlock("lab_gate", () -> defaultBlock("lab_gate"));
    public static final RegistryObject<Block> LAB_RELOCATOR = registerBlock("lab_relocator", () -> defaultBlock("lab_relocator"));
    public static final RegistryObject<Block> LABYRINTH_CHARGER_CORE = registerBlock("labyrinth_charger_core", () -> defaultBlock("labyrinth_charger_core"));
    public static final RegistryObject<Block> LABYRINTH_CHARGER_LIT = registerBlock("labyrinth_charger_lit", () -> defaultBlock("labyrinth_charger_lit"));
    public static final RegistryObject<Block> LABYRINTH_CHARGER_UNPOWERED = registerBlock("labyrinth_charger_unpowered", () -> defaultBlock("labyrinth_charger_unpowered"));
    public static final RegistryObject<Block> LABYRINTH_ETERNAL_CORE = registerBlock("labyrinth_eternal_core", () -> defaultBlock("labyrinth_eternal_core"));
    public static final RegistryObject<Block> LABYRINTH_FLOOR = registerBlock("labyrinth_floor", () -> defaultBlock("labyrinth_floor"));
    public static final RegistryObject<Block> LABYRINTH_FLOOR_PURPLE = registerBlock("labyrinth_floor_purple", () -> defaultBlock("labyrinth_floor_purple"));
    public static final RegistryObject<Block> LABYRINTH_FLOOR_RED = registerBlock("labyrinth_floor_red", () -> defaultBlock("labyrinth_floor_red"));
    public static final RegistryObject<Block> LABYRINTH_GEOLOCATOR_BLUE = registerBlock("labyrinth_geolocator_blue", () -> defaultBlock("labyrinth_geolocator_blue"));
    public static final RegistryObject<Block> LABYRINTH_GEOLOCATOR_CORE = registerBlock("labyrinth_geolocator_core", () -> defaultBlock("labyrinth_geolocator_core"));
    public static final RegistryObject<Block> LABYRINTH_GEOLOCATOR_GREEN = registerBlock("labyrinth_geolocator_green", () -> defaultBlock("labyrinth_geolocator_green"));
    public static final RegistryObject<Block> LABYRINTH_GEOLOCATOR_RED = registerBlock("labyrinth_geolocator_red", () -> defaultBlock("labyrinth_geolocator_red"));
    public static final RegistryObject<Block> LABYRINTH_GEOLOCATOR_YELLOW = registerBlock("labyrinth_geolocator_yellow", () -> defaultBlock("labyrinth_geolocator_yellow"));
    public static final RegistryObject<Block> LABYRINTH_GLASS_BLUE = registerBlock("labyrinth_glass_blue", () -> defaultBlock("labyrinth_glass_blue"));
    public static final RegistryObject<Block> LABYRINTH_GLASS_GREEN = registerBlock("labyrinth_glass_green", () -> defaultBlock("labyrinth_glass_green"));
    public static final RegistryObject<Block> LABYRINTH_GLASS_RED = registerBlock("labyrinth_glass_red", () -> defaultBlock("labyrinth_glass_red"));
    public static final RegistryObject<Block> LABYRINTH_LAMP = registerBlock("labyrinth_lamp", () -> defaultBlock("labyrinth_lamp"));
    public static final RegistryObject<Block> LABYRINTH_LAMP_BLUE = registerBlock("labyrinth_lamp_blue", () -> defaultBlock("labyrinth_lamp_blue"));
    public static final RegistryObject<Block> LABYRINTH_LAMP_GREEN = registerBlock("labyrinth_lamp_green", () -> defaultBlock("labyrinth_lamp_green"));
    public static final RegistryObject<Block> LABYRINTH_METAL_BLACK = registerBlock("labyrinth_metal_black", () -> defaultBlock("labyrinth_metal_black"));
    public static final RegistryObject<Block> LABYRINTH_METAL_BLUE = registerBlock("labyrinth_metal_blue", () -> defaultBlock("labyrinth_metal_blue"));
    public static final RegistryObject<Block> LABYRINTH_METAL_PURPLE = registerBlock("labyrinth_metal_purple", () -> defaultBlock("labyrinth_metal_purple"));
    public static final RegistryObject<Block> LABYRINTH_METAL_RED = registerBlock("labyrinth_metal_red", () -> defaultBlock("labyrinth_metal_red"));
    public static final RegistryObject<Block> LABYRINTH_PORTAL_GREEN = registerBlock("labyrinth_portal_green", () -> defaultBlock("labyrinth_portal_green"));
    public static final RegistryObject<Block> LABYRINTH_PORTAL_RED = registerBlock("labyrinth_portal_red", () -> defaultBlock("labyrinth_portal_red"));
    public static final RegistryObject<Block> LAUNCH_COORDINATOR_BLUE_1 = registerBlock("launch_coordinator_blue_1", () -> defaultBlock("launch_coordinator_blue_1"));
    public static final RegistryObject<Block> LAUNCH_COORDINATOR_BLUE_3 = registerBlock("launch_coordinator_blue_3", () -> defaultBlock("launch_coordinator_blue_3"));
    public static final RegistryObject<Block> LAUNCH_COORDINATOR_BLUE_4 = registerBlock("launch_coordinator_blue_4", () -> defaultBlock("launch_coordinator_blue_4"));
    public static final RegistryObject<Block> LAUNCH_COORDINATOR_BLUE_5 = registerBlock("launch_coordinator_blue_5", () -> defaultBlock("launch_coordinator_blue_5"));
    public static final RegistryObject<Block> LAUNCH_COORDINATOR_EMPTY = registerBlock("launch_coordinator_empty", () -> defaultBlock("launch_coordinator_empty"));
    public static final RegistryObject<Block> LAUNCH_COORDINATOR_GREEN_1 = registerBlock("launch_coordinator_green_1", () -> defaultBlock("launch_coordinator_green_1"));
    public static final RegistryObject<Block> LAUNCH_COORDINATOR_GREEN_3 = registerBlock("launch_coordinator_green_3", () -> defaultBlock("launch_coordinator_green_3"));
    public static final RegistryObject<Block> LAUNCH_COORDINATOR_GREEN_4 = registerBlock("launch_coordinator_green_4", () -> defaultBlock("launch_coordinator_green_4"));
    public static final RegistryObject<Block> LAUNCH_COORDINATOR_GREEN_5 = registerBlock("launch_coordinator_green_5", () -> defaultBlock("launch_coordinator_green_5"));
    public static final RegistryObject<Block> LAUNCH_COORDINATOR_PURPLE_1 = registerBlock("launch_coordinator_purple_1", () -> defaultBlock("launch_coordinator_purple_1"));
    public static final RegistryObject<Block> LAUNCH_COORDINATOR_PURPLE_3 = registerBlock("launch_coordinator_purple_3", () -> defaultBlock("launch_coordinator_purple_3"));
    public static final RegistryObject<Block> LAUNCH_COORDINATOR_PURPLE_4 = registerBlock("launch_coordinator_purple_4", () -> defaultBlock("launch_coordinator_purple_4"));
    public static final RegistryObject<Block> LAUNCH_COORDINATOR_PURPLE_5 = registerBlock("launch_coordinator_purple_5", () -> defaultBlock("launch_coordinator_purple_5"));
    public static final RegistryObject<Block> LAUNCH_COORDINATOR_RED_1 = registerBlock("launch_coordinator_red_1", () -> defaultBlock("launch_coordinator_red_1"));
    public static final RegistryObject<Block> LAUNCH_COORDINATOR_RED_3 = registerBlock("launch_coordinator_red_3", () -> defaultBlock("launch_coordinator_red_3"));
    public static final RegistryObject<Block> LAUNCH_COORDINATOR_RED_4 = registerBlock("launch_coordinator_red_4", () -> defaultBlock("launch_coordinator_red_4"));
    public static final RegistryObject<Block> LAUNCH_COORDINATOR_RED_5 = registerBlock("launch_coordinator_red_5", () -> defaultBlock("launch_coordinator_red_5"));
    public static final RegistryObject<Block> LAUNCH_CORE = registerBlock("launch_core", () -> defaultBlock("launch_core"));
    public static final RegistryObject<Block> LAUNCH_PAD = registerBlock("launch_pad", () -> defaultBlock("launch_pad"));
    public static final RegistryObject<Block> LAUNCH_PAD_UNPOWERED = registerBlock("launch_pad_unpowered", () -> defaultBlock("launch_pad_unpowered"));
    public static final RegistryObject<Block> LEAVES_ARCHLUM = registerBlock("leaves_archlum", () -> defaultBlock("leaves_archlum"));
    public static final RegistryObject<Block> LEAVES_BLIGHT = registerBlock("leaves_blight", () -> defaultBlock("leaves_blight"));
    public static final RegistryObject<Block> LEAVES_CELESTIAL_BLUE = registerBlock("leaves_celestial_blue", () -> defaultBlock("leaves_celestial_blue"));
    public static final RegistryObject<Block> LEAVES_CELESTIAL_PURPLE = registerBlock("leaves_celestial_purple", () -> defaultBlock("leaves_celestial_purple"));
    public static final RegistryObject<Block> LEAVES_CELESTIAL_RED = registerBlock("leaves_celestial_red", () -> defaultBlock("leaves_celestial_red"));
    public static final RegistryObject<Block> LEAVES_CELESTIAL_SEA = registerBlock("leaves_celestial_sea", () -> defaultBlock("leaves_celestial_sea"));
    public static final RegistryObject<Block> LEAVES_DARKBORN = registerBlock("leaves_darkborn", () -> defaultBlock("leaves_darkborn"));
    public static final RegistryObject<Block> LEAVES_LUMIO = registerBlock("leaves_lumio", () -> defaultBlock("leaves_lumio"));
    public static final RegistryObject<Block> LEAVES_METALLOID = registerBlock("leaves_metalloid", () -> defaultBlock("leaves_metalloid"));
    public static final RegistryObject<Block> LEAVES_MURK = registerBlock("leaves_murk", () -> defaultBlock("leaves_murk"));
    public static final RegistryObject<Block> LEAVES_NITRO = registerBlock("leaves_nitro", () -> defaultBlock("leaves_nitro"));
    public static final RegistryObject<Block> LEAVES_RADIANT = registerBlock("leaves_radiant", () -> defaultBlock("leaves_radiant"));
    public static final RegistryObject<Block> LEAVES_REBIRTH = registerBlock("leaves_rebirth", () -> defaultBlock("leaves_rebirth"));
    public static final RegistryObject<Block> LEAVES_SNARL = registerBlock("leaves_snarl", () -> defaultBlock("leaves_snarl"));
    public static final RegistryObject<Block> LIGHT_BRIDGE = registerBlock("light_bridge", () -> defaultBlock("light_bridge"));
    public static final RegistryObject<Block> LIGHT_EMITTER = registerBlock("light_emitter", () -> defaultBlock("light_emitter"));
    public static final RegistryObject<Block> LIGHT_RECEIVER = registerBlock("light_receiver", () -> defaultBlock("light_receiver"));
    public static final RegistryObject<Block> LIGHT_REFLECTOR = registerBlock("light_reflector", () -> defaultBlock("light_reflector"));
    public static final RegistryObject<Block> LIGHT_SMOOTH_CORAL = registerBlock("light_smooth_coral", () -> defaultBlock("light_smooth_coral"));
    public static final RegistryObject<Block> LIGHT_SWITCH_GAME = registerBlock("light_switch_game", () -> defaultBlock("light_switch_game"));
    public static final RegistryObject<Block> LIGHT_SWITCH_OFF = registerBlock("light_switch_off", () -> defaultBlock("light_switch_off"));
    public static final RegistryObject<Block> LIGHT_SWITCH_ON = registerBlock("light_switch_on", () -> defaultBlock("light_switch_on"));
    public static final RegistryObject<Block> LIGHT_TILE_DARK = registerBlock("light_tile_dark", () -> defaultBlock("light_tile_dark"));
    public static final RegistryObject<Block> LIGHT_TILE_LIT = registerBlock("light_tile_lit", () -> defaultBlock("light_tile_lit"));
    public static final RegistryObject<Block> LIGHT_TILE_RANDOMIZER = registerBlock("light_tile_randomizer", () -> defaultBlock("light_tile_randomizer"));
    public static final RegistryObject<Block> LOGS_ARCHBLIGHTED = registerBlock("logs_archblighted", () -> defaultBlock("logs_archblighted"));
    public static final RegistryObject<Block> LOGS_ARCHLUM = registerBlock("logs_archlum", () -> defaultBlock("logs_archlum"));
    public static final RegistryObject<Block> LOGS_ARCHLUM_WRAPPED = registerBlock("logs_archlum_wrapped", () -> defaultBlock("logs_archlum_wrapped"));
    public static final RegistryObject<Block> LOGS_CELESTIAL = registerBlock("logs_celestial", () -> defaultBlock("logs_celestial"));
    public static final RegistryObject<Block> LOGS_CELESTIAL_PURPLE = registerBlock("logs_celestial_purple", () -> defaultBlock("logs_celestial_purple"));
    public static final RegistryObject<Block> LOGS_CELESTIAL_RED = registerBlock("logs_celestial_red", () -> defaultBlock("logs_celestial_red"));
    public static final RegistryObject<Block> LOGS_METALLOID = registerBlock("logs_metalloid", () -> defaultBlock("logs_metalloid"));
    public static final RegistryObject<Block> LOGS_MURK = registerBlock("logs_murk", () -> defaultBlock("logs_murk"));
    public static final RegistryObject<Block> LOGS_NITRO = registerBlock("logs_nitro", () -> defaultBlock("logs_nitro"));
    public static final RegistryObject<Block> LUCIENT_ORE = registerBlock("lucient_ore", () -> defaultBlock("lucient_ore"));
    public static final RegistryObject<Block> LUMCUBES = registerBlock("lumcubes", () -> defaultBlock("lumcubes"));
    public static final RegistryObject<Block> LUMGLOW = registerBlock("lumglow", () -> defaultBlock("lumglow"));
    public static final RegistryObject<Block> LUMGRASS = registerBlock("lumgrass", () -> defaultBlock("lumgrass"));
    public static final RegistryObject<Block> LUMILIGHT = registerBlock("lumilight", () -> defaultBlock("lumilight"));
    public static final RegistryObject<Block> LUMIO_IDOL_SUMMONER = registerBlock("lumio_idol_summoner", () -> defaultBlock("lumio_idol_summoner"));
    public static final RegistryObject<Block> LUMIO_ORE = registerBlock("lumio_ore", () -> defaultBlock("lumio_ore"));
    public static final RegistryObject<Block> LUMIO_ORE_EMPTY = registerBlock("lumio_ore_empty", () -> defaultBlock("lumio_ore_empty"));
    public static final RegistryObject<Block> LUMIO_ROCK = registerBlock("lumio_rock", () -> defaultBlock("lumio_rock"));
    public static final RegistryObject<Block> MAIN_POWER_TERMINAL = registerBlock("main_power_terminal", () -> defaultBlock("main_power_terminal"));
    public static final RegistryObject<Block> MELODIC_SEQUENCER = registerBlock("melodic_sequencer", () -> defaultBlock("melodic_sequencer"));
    public static final RegistryObject<Block> MELODY_BUTTON = registerBlock("melody_button", () -> defaultBlock("melody_button"));
    public static final RegistryObject<Block> META_MATERIALIZER = registerBlock("meta_materializer", () -> defaultBlock("meta_materializer"));
    public static final RegistryObject<Block> MICRO_ROCKET = registerBlock("micro_rocket", () -> defaultBlock("micro_rocket"));
    public static final RegistryObject<Block> MODULATION_BATTERY = registerBlock("modulation_battery", () -> defaultBlock("modulation_battery"));
    public static final RegistryObject<Block> MODULATOR = registerBlock("modulator", () -> defaultBlock("modulator"));
    public static final RegistryObject<Block> MODULE_CREATOR = registerBlock("module_creator", () -> defaultBlock("module_creator"));
    public static final RegistryObject<Block> MOLDED_SEA_CLAY = registerBlock("molded_sea_clay", () -> defaultBlock("molded_sea_clay"));
    public static final RegistryObject<Block> MOLTEN_SEASTONE = registerBlock("molten_seastone", () -> defaultBlock("molten_seastone"));
    public static final RegistryObject<Block> MOLTROCK = registerBlock("moltrock", () -> defaultBlock("moltrock"));
    public static final RegistryObject<Block> MONOMER_CUBE = registerBlock("monomer_cube", () -> defaultBlock("monomer_cube"));
    public static final RegistryObject<Block> MONOMER_DEPOSIT = registerBlock("monomer_deposit", () -> defaultBlock("monomer_deposit"));
    public static final RegistryObject<Block> MOON_FLOWER = registerBlock("moon_flower", () -> defaultBlock("moon_flower"));
    public static final RegistryObject<Block> MOSSY_ASTROROCK = registerBlock("mossy_astrorock", () -> defaultBlock("mossy_astrorock"));
    public static final RegistryObject<Block> MULTIVERSITE_MURK = registerBlock("multiversite_murk", () -> defaultBlock("multiversite_murk"));
    public static final RegistryObject<Block> MULTIVERSITE_OVERWORLD = registerBlock("multiversite_overworld", () -> defaultBlock("multiversite_overworld"));
    public static final RegistryObject<Block> MURKBRICK_HALF = registerBlock("murkbrick_half", () -> defaultBlock("murkbrick_half"));
    public static final RegistryObject<Block> MURKBRICK_STAIRS = registerBlock("murkbrick_stairs", () -> defaultBlock("murkbrick_stairs"));
    public static final RegistryObject<Block> MURKBRICKS = registerBlock("murkbricks", () -> defaultBlock("murkbricks"));
    public static final RegistryObject<Block> MURKCORE = registerBlock("murkcore", () -> defaultBlock("murkcore"));
    public static final RegistryObject<Block> MURKDIRT = registerBlock("murkdirt", () -> defaultBlock("murkdirt"));
    public static final RegistryObject<Block> MURKGLASS = registerBlock("murkglass", () -> defaultBlock("murkglass"));
    public static final RegistryObject<Block> MURKICE = registerBlock("murkice", () -> defaultBlock("murkice"));
    public static final RegistryObject<Block> MURKPLANK_HALF = registerBlock("murkplank_half", () -> defaultBlock("murkplank_half"));
    public static final RegistryObject<Block> MURKPLANK_STAIRS = registerBlock("murkplank_stairs", () -> defaultBlock("murkplank_stairs"));
    public static final RegistryObject<Block> MURKPLANKS = registerBlock("murkplanks", () -> defaultBlock("murkplanks"));
    public static final RegistryObject<Block> MURKSOIL = registerBlock("murksoil", () -> defaultBlock("murksoil"));
    public static final RegistryObject<Block> MURKSTONE = registerBlock("murkstone", () -> defaultBlock("murkstone"));
    public static final RegistryObject<Block> MUSHWEED = registerBlock("mushweed", () -> defaultBlock("mushweed"));
    public static final RegistryObject<Block> MUTANT_BLOOM = registerBlock("mutant_bloom", () -> defaultBlock("mutant_bloom"));
    public static final RegistryObject<Block> MYRITE_ORE = registerBlock("myrite_ore", () -> defaultBlock("myrite_ore"));
    public static final RegistryObject<Block> MYRITE_ORE_DARK = registerBlock("myrite_ore_dark", () -> defaultBlock("myrite_ore_dark"));
    public static final RegistryObject<Block> NAVIGATION_DEVICE = registerBlock("navigation_device", () -> defaultBlock("navigation_device"));
    public static final RegistryObject<Block> NAVIGATION_NODULE = registerBlock("navigation_nodule", () -> defaultBlock("navigation_nodule"));
    public static final RegistryObject<Block> NEBULOUS_BEACON = registerBlock("nebulous_beacon", () -> defaultBlock("nebulous_beacon"));
    public static final RegistryObject<Block> NEO_LASERFIELD_1 = registerBlock("neo_laserfield_1", () -> defaultBlock("neo_laserfield_1"));
    public static final RegistryObject<Block> NEO_LASERFIELD_2 = registerBlock("neo_laserfield_2", () -> defaultBlock("neo_laserfield_2"));
    public static final RegistryObject<Block> NEO_LASERFIELD_3 = registerBlock("neo_laserfield_3", () -> defaultBlock("neo_laserfield_3"));
    public static final RegistryObject<Block> NEO_LASERFIELD_4 = registerBlock("neo_laserfield_4", () -> defaultBlock("neo_laserfield_4"));
    public static final RegistryObject<Block> NEO_LASERFIELD_5 = registerBlock("neo_laserfield_5", () -> defaultBlock("neo_laserfield_5"));
    public static final RegistryObject<Block> NEOCRAFT_BLUE = registerBlock("neocraft_blue", () -> defaultBlock("neocraft_blue"));
    public static final RegistryObject<Block> NEOCRAFT_GOAL_BLUE = registerBlock("neocraft_goal_blue", () -> defaultBlock("neocraft_goal_blue"));
    public static final RegistryObject<Block> NEOCRAFT_GOAL_EMPTY = registerBlock("neocraft_goal_empty", () -> defaultBlock("neocraft_goal_empty"));
    public static final RegistryObject<Block> NEOCRAFT_GOAL_GREEN = registerBlock("neocraft_goal_green", () -> defaultBlock("neocraft_goal_green"));
    public static final RegistryObject<Block> NEOCRAFT_GOAL_ORANGE = registerBlock("neocraft_goal_orange", () -> defaultBlock("neocraft_goal_orange"));
    public static final RegistryObject<Block> NEOCRAFT_GOAL_PINK = registerBlock("neocraft_goal_pink", () -> defaultBlock("neocraft_goal_pink"));
    public static final RegistryObject<Block> NEOCRAFT_GOAL_YELLOW = registerBlock("neocraft_goal_yellow", () -> defaultBlock("neocraft_goal_yellow"));
    public static final RegistryObject<Block> NEOCRAFT_GREEN = registerBlock("neocraft_green", () -> defaultBlock("neocraft_green"));
    public static final RegistryObject<Block> NEOCRAFT_ORANGE = registerBlock("neocraft_orange", () -> defaultBlock("neocraft_orange"));
    public static final RegistryObject<Block> NEOCRAFT_PINK = registerBlock("neocraft_pink", () -> defaultBlock("neocraft_pink"));
    public static final RegistryObject<Block> NEOCRAFT_UNPOWERED = registerBlock("neocraft_unpowered", () -> defaultBlock("neocraft_unpowered"));
    public static final RegistryObject<Block> NEOCRAFT_YELLOW = registerBlock("neocraft_yellow", () -> defaultBlock("neocraft_yellow"));
    public static final RegistryObject<Block> NEOCRAFTING_STATION = registerBlock("neocrafting_station", () -> defaultBlock("neocrafting_station"));
    public static final RegistryObject<Block> NEON_BRICKS_AQUA = registerBlock("neon_bricks_aqua", () -> defaultBlock("neon_bricks_aqua"));
    public static final RegistryObject<Block> NEON_BRICKS_BLUE = registerBlock("neon_bricks_blue", () -> defaultBlock("neon_bricks_blue"));
    public static final RegistryObject<Block> NEON_BRICKS_GREEN = registerBlock("neon_bricks_green", () -> defaultBlock("neon_bricks_green"));
    public static final RegistryObject<Block> NEON_BRICKS_ORANGE = registerBlock("neon_bricks_orange", () -> defaultBlock("neon_bricks_orange"));
    public static final RegistryObject<Block> NEON_BRICKS_PINK = registerBlock("neon_bricks_pink", () -> defaultBlock("neon_bricks_pink"));
    public static final RegistryObject<Block> NEON_BRICKS_PURPLE = registerBlock("neon_bricks_purple", () -> defaultBlock("neon_bricks_purple"));
    public static final RegistryObject<Block> NEON_BRICKS_RED = registerBlock("neon_bricks_red", () -> defaultBlock("neon_bricks_red"));
    public static final RegistryObject<Block> NEON_BRICKS_YELLOW = registerBlock("neon_bricks_yellow", () -> defaultBlock("neon_bricks_yellow"));
    public static final RegistryObject<Block> NEOSHOCKER = registerBlock("neoshocker", () -> defaultBlock("neoshocker"));
    public static final RegistryObject<Block> NEOSTEEL = registerBlock("neosteel", () -> defaultBlock("neosteel"));
    public static final RegistryObject<Block> NEOSTEEL_BEAM = registerBlock("neosteel_beam", () -> defaultBlock("neosteel_beam"));
    public static final RegistryObject<Block> NEOSTEEL_BLACK = registerBlock("neosteel_black", () -> defaultBlock("neosteel_black"));
    public static final RegistryObject<Block> NEOSTEEL_POWER_BEAM = registerBlock("neosteel_power_beam", () -> defaultBlock("neosteel_power_beam"));
    public static final RegistryObject<Block> NEOSTEEL_STAIRS = registerBlock("neosteel_stairs", () -> defaultBlock("neosteel_stairs"));
    public static final RegistryObject<Block> NICRONIUM_INFUSER = registerBlock("nicronium_infuser", () -> defaultBlock("nicronium_infuser"));
    public static final RegistryObject<Block> NIGHTVINES = registerBlock("nightvines", () -> defaultBlock("nightvines"));
    public static final RegistryObject<Block> NIGHTVINES_FLOWER = registerBlock("nightvines_flower", () -> defaultBlock("nightvines_flower"));
    public static final RegistryObject<Block> NOXERIUM_ORE = registerBlock("noxerium_ore", () -> defaultBlock("noxerium_ore"));
    public static final RegistryObject<Block> NUCLEAR_BOMB = registerBlock("nuclear_bomb", () -> defaultBlock("nuclear_bomb"));
    public static final RegistryObject<Block> OLYSIUM_ORE = registerBlock("olysium_ore", () -> defaultBlock("olysium_ore"));
    public static final RegistryObject<Block> OMNI_POWER_BLOCK = registerBlock("omni_power_block", () -> defaultBlock("omni_power_block"));
    public static final RegistryObject<Block> PARKOUR_PLATFORM = registerBlock("parkour_platform", () -> defaultBlock("parkour_platform"));
    public static final RegistryObject<Block> PARKOUR_PLATFORM_SLIPPERY = registerBlock("parkour_platform_slippery", () -> defaultBlock("parkour_platform_slippery"));
    public static final RegistryObject<Block> PATTERNED_SMOOTH_CORAL = registerBlock("patterned_smooth_coral", () -> defaultBlock("patterned_smooth_coral"));
    public static final RegistryObject<Block> PHOTOTENZYTE_ORE = registerBlock("phototenzyte_ore", () -> defaultBlock("phototenzyte_ore"));
    public static final RegistryObject<Block> PHYTROSIUM_ORE = registerBlock("phytrosium_ore", () -> defaultBlock("phytrosium_ore"));
    public static final RegistryObject<Block> PICKCHARGINGTABLE = registerBlock("pickchargingtable", () -> defaultBlock("pickchargingtable"));
    public static final RegistryObject<Block> PIPE_CROSS = registerBlock("pipe_cross", () -> defaultBlock("pipe_cross"));
    public static final RegistryObject<Block> PIPE_CROSS_LIT = registerBlock("pipe_cross_lit", () -> defaultBlock("pipe_cross_lit"));
    public static final RegistryObject<Block> PIPE_ELBOW = registerBlock("pipe_elbow", () -> defaultBlock("pipe_elbow"));
    public static final RegistryObject<Block> PIPE_ELBOW_LIT = registerBlock("pipe_elbow_lit", () -> defaultBlock("pipe_elbow_lit"));
    public static final RegistryObject<Block> PIPE_GAME = registerBlock("pipe_game", () -> defaultBlock("pipe_game"));
    public static final RegistryObject<Block> PIPE_L = registerBlock("pipe_l", () -> defaultBlock("pipe_l"));
    public static final RegistryObject<Block> PIPE_L_LIT = registerBlock("pipe_l_lit", () -> defaultBlock("pipe_l_lit"));
    public static final RegistryObject<Block> PIPE_NONE = registerBlock("pipe_none", () -> defaultBlock("pipe_none"));
    public static final RegistryObject<Block> PIPE_T = registerBlock("pipe_t", () -> defaultBlock("pipe_t"));
    public static final RegistryObject<Block> PIPE_T_LIT = registerBlock("pipe_t_lit", () -> defaultBlock("pipe_t_lit"));
    public static final RegistryObject<Block> PLASTERGLASS = registerBlock("plasterglass", () -> defaultBlock("plasterglass"));
    public static final RegistryObject<Block> POLYMERIZATION_DEVICE = registerBlock("polymerization_device", () -> defaultBlock("polymerization_device"));
    public static final RegistryObject<Block> PORTAL_NEXUS = registerBlock("portal_nexus", () -> defaultBlock("portal_nexus"));
    public static final RegistryObject<Block> PORTAL_NODE = registerBlock("portal_node", () -> defaultBlock("portal_node"));
    public static final RegistryObject<Block> POWER_BLOCK_BLUE = registerBlock("power_block_blue", () -> defaultBlock("power_block_blue"));
    public static final RegistryObject<Block> POWER_BLOCK_GREEN = registerBlock("power_block_green", () -> defaultBlock("power_block_green"));
    public static final RegistryObject<Block> POWER_BLOCK_PURPLE = registerBlock("power_block_purple", () -> defaultBlock("power_block_purple"));
    public static final RegistryObject<Block> POWER_BLOCK_YELLOW = registerBlock("power_block_yellow", () -> defaultBlock("power_block_yellow"));
    public static final RegistryObject<Block> POWER_COLLIDER = registerBlock("power_collider", () -> defaultBlock("power_collider"));
    public static final RegistryObject<Block> POWER_COLLIDER_TRACK = registerBlock("power_collider_track", () -> defaultBlock("power_collider_track"));
    public static final RegistryObject<Block> POWER_CONDUIT = registerBlock("power_conduit", () -> defaultBlock("power_conduit"));
    public static final RegistryObject<Block> POWER_CONNECTOR = registerBlock("power_connector", () -> defaultBlock("power_connector"));
    public static final RegistryObject<Block> POWER_GENERATOR = registerBlock("power_generator", () -> defaultBlock("power_generator"));
    public static final RegistryObject<Block> POWER_KEY_BLOCK = registerBlock("power_key_block", () -> defaultBlock("power_key_block"));
    public static final RegistryObject<Block> POWER_MODULE = registerBlock("power_module", () -> defaultBlock("power_module"));
    public static final RegistryObject<Block> POWER_NODULE = registerBlock("power_nodule", () -> defaultBlock("power_nodule"));
    public static final RegistryObject<Block> PRESENT = registerBlock("present", () -> defaultBlock("present"));
    public static final RegistryObject<Block> PRISMOSIS_ORE = registerBlock("prismosis_ore", () -> defaultBlock("prismosis_ore"));
    public static final RegistryObject<Block> PUFF_SPORE = registerBlock("puff_spore", () -> defaultBlock("puff_spore"));
    public static final RegistryObject<Block> PUZZLE_ARENA_FLOOR = registerBlock("puzzle_arena_floor", () -> defaultBlock("puzzle_arena_floor"));
    public static final RegistryObject<Block> PUZZLE_KEY_BLOCK = registerBlock("puzzle_key_block", () -> defaultBlock("puzzle_key_block"));
    public static final RegistryObject<Block> PUZZLE_LAVA = registerBlock("puzzle_lava", () -> defaultBlock("puzzle_lava"));
    public static final RegistryObject<Block> PUZZLE_MASTER_TURRET = registerBlock("puzzle_master_turret", () -> defaultBlock("puzzle_master_turret"));
    public static final RegistryObject<Block> PYREVINES = registerBlock("pyrevines", () -> defaultBlock("pyrevines"));
    public static final RegistryObject<Block> RADION_ORE = registerBlock("radion_ore", () -> defaultBlock("radion_ore"));
    public static final RegistryObject<Block> RADION_PILLAR = registerBlock("radion_pillar", () -> defaultBlock("radion_pillar"));
    public static final RegistryObject<Block> RAINFALL_GENERATOR = registerBlock("rainfall_generator", () -> defaultBlock("rainfall_generator"));
    public static final RegistryObject<Block> RANGE_MODULE = registerBlock("range_module", () -> defaultBlock("range_module"));
    public static final RegistryObject<Block> RHYTHM_BUTTON = registerBlock("rhythm_button", () -> defaultBlock("rhythm_button"));
    public static final RegistryObject<Block> RHYTHM_GAME = registerBlock("rhythm_game", () -> defaultBlock("rhythm_game"));
    public static final RegistryObject<Block> RHYTHM_TILE = registerBlock("rhythm_tile", () -> defaultBlock("rhythm_tile"));
    public static final RegistryObject<Block> RIFT_ENTANGLED_TILE = registerBlock("rift_entangled_tile", () -> defaultBlock("rift_entangled_tile"));
    public static final RegistryObject<Block> RING_GAME = registerBlock("ring_game", () -> defaultBlock("ring_game"));
    public static final RegistryObject<Block> RING_SLIDE_BUTTON = registerBlock("ring_slide_button", () -> defaultBlock("ring_slide_button"));
    public static final RegistryObject<Block> RING_TILE = registerBlock("ring_tile", () -> defaultBlock("ring_tile"));
    public static final RegistryObject<Block> ROCKWEEDS = registerBlock("rockweeds", () -> defaultBlock("rockweeds"));
    public static final RegistryObject<Block> ROTATABLE_TILE = registerBlock("rotatable_tile", () -> defaultBlock("rotatable_tile"));
    public static final RegistryObject<Block> ROTATABLE_TILE_GAME = registerBlock("rotatable_tile_game", () -> defaultBlock("rotatable_tile_game"));
    public static final RegistryObject<Block> ROUGH_CORAL = registerBlock("rough_coral", () -> defaultBlock("rough_coral"));
    public static final RegistryObject<Block> ROW_INCREMENT_BUTTON = registerBlock("row_increment_button", () -> defaultBlock("row_increment_button"));
    public static final RegistryObject<Block> ROW_INCREMENT_GAME = registerBlock("row_increment_game", () -> defaultBlock("row_increment_game"));
    public static final RegistryObject<Block> ROW_INCREMENT_TILE = registerBlock("row_increment_tile", () -> defaultBlock("row_increment_tile"));
    public static final RegistryObject<Block> ROW_SLIDE_BUTTON = registerBlock("row_slide_button", () -> defaultBlock("row_slide_button"));
    public static final RegistryObject<Block> ROW_SLIDE_GAME = registerBlock("row_slide_game", () -> defaultBlock("row_slide_game"));
    public static final RegistryObject<Block> ROW_SLIDE_TILE = registerBlock("row_slide_tile", () -> defaultBlock("row_slide_tile"));
    public static final RegistryObject<Block> ROW_TOGGLE_BUTTON = registerBlock("row_toggle_button", () -> defaultBlock("row_toggle_button"));
    public static final RegistryObject<Block> ROW_TOGGLE_GAME = registerBlock("row_toggle_game", () -> defaultBlock("row_toggle_game"));
    public static final RegistryObject<Block> ROW_TOGGLE_TILE = registerBlock("row_toggle_tile", () -> defaultBlock("row_toggle_tile"));
    public static final RegistryObject<Block> SANDY_SEASTONE = registerBlock("sandy_seastone", () -> defaultBlock("sandy_seastone"));
    public static final RegistryObject<Block> SAP_EVAPORATOR = registerBlock("sap_evaporator", () -> defaultBlock("sap_evaporator"));
    public static final RegistryObject<Block> SCREEN_ARCHEOLOGIST = registerBlock("screen_archeologist", () -> defaultBlock("screen_archeologist"));
    public static final RegistryObject<Block> SCREEN_BATTLESNAKES = registerBlock("screen_battlesnakes", () -> defaultBlock("screen_battlesnakes"));
    public static final RegistryObject<Block> SCREEN_BLACKMARKET = registerBlock("screen_blackmarket", () -> defaultBlock("screen_blackmarket"));
    public static final RegistryObject<Block> SCREEN_BOMBERS = registerBlock("screen_bombers", () -> defaultBlock("screen_bombers"));
    public static final RegistryObject<Block> SCREEN_CHEMIST = registerBlock("screen_chemist", () -> defaultBlock("screen_chemist"));
    public static final RegistryObject<Block> SCREEN_DODGEBALL = registerBlock("screen_dodgeball", () -> defaultBlock("screen_dodgeball"));
    public static final RegistryObject<Block> SCREEN_DUEL = registerBlock("screen_duel", () -> defaultBlock("screen_duel"));
    public static final RegistryObject<Block> SCREEN_HOLODECK = registerBlock("screen_holodeck", () -> defaultBlock("screen_holodeck"));
    public static final RegistryObject<Block> SCREEN_HUNTERKILLER = registerBlock("screen_hunterkiller", () -> defaultBlock("screen_hunterkiller"));
    public static final RegistryObject<Block> SCREEN_INKWARS = registerBlock("screen_inkwars", () -> defaultBlock("screen_inkwars"));
    public static final RegistryObject<Block> SCREEN_LASERWARZ = registerBlock("screen_laserwarz", () -> defaultBlock("screen_laserwarz"));
    public static final RegistryObject<Block> SCREEN_LIGHTBRIDGE = registerBlock("screen_lightbridge", () -> defaultBlock("screen_lightbridge"));
    public static final RegistryObject<Block> SCREEN_LOBBYCHANGER = registerBlock("screen_lobbychanger", () -> defaultBlock("screen_lobbychanger"));
    public static final RegistryObject<Block> SCREEN_OBSTACLEALLEY = registerBlock("screen_obstaclealley", () -> defaultBlock("screen_obstaclealley"));
    public static final RegistryObject<Block> SCREEN_PARKOUR = registerBlock("screen_parkour", () -> defaultBlock("screen_parkour"));
    public static final RegistryObject<Block> SCREEN_REDLIGHT = registerBlock("screen_redlight", () -> defaultBlock("screen_redlight"));
    public static final RegistryObject<Block> SCREEN_TARGETS = registerBlock("screen_targets", () -> defaultBlock("screen_targets"));
    public static final RegistryObject<Block> SEA_CLAY = registerBlock("sea_clay", () -> defaultBlock("sea_clay"));
    public static final RegistryObject<Block> SEABUSH = registerBlock("seabush", () -> defaultBlock("seabush"));
    public static final RegistryObject<Block> SEAROCK = registerBlock("searock", () -> defaultBlock("searock"));
    public static final RegistryObject<Block> SEASAND = registerBlock("seasand", () -> defaultBlock("seasand"));
    public static final RegistryObject<Block> SEASTONE = registerBlock("seastone", () -> defaultBlock("seastone"));
    public static final RegistryObject<Block> SECURITY_GATE_1 = registerBlock("security_gate_1", () -> defaultBlock("security_gate_1"));
    public static final RegistryObject<Block> SECURITY_GATE_2 = registerBlock("security_gate_2", () -> defaultBlock("security_gate_2"));
    public static final RegistryObject<Block> SECURITY_GATE_3 = registerBlock("security_gate_3", () -> defaultBlock("security_gate_3"));
    public static final RegistryObject<Block> SECURITY_GATE_4 = registerBlock("security_gate_4", () -> defaultBlock("security_gate_4"));
    public static final RegistryObject<Block> SECURITY_GATE_5 = registerBlock("security_gate_5", () -> defaultBlock("security_gate_5"));
    public static final RegistryObject<Block> SECURITY_GATE_6 = registerBlock("security_gate_6", () -> defaultBlock("security_gate_6"));
    public static final RegistryObject<Block> SELECTION_PREVIEW = registerBlock("selection_preview", () -> defaultBlock("selection_preview"));
    public static final RegistryObject<Block> SEPARATED_MATTER = registerBlock("separated_matter", () -> defaultBlock("separated_matter"));
    public static final RegistryObject<Block> SERPENTINE_ORE = registerBlock("serpentine_ore", () -> defaultBlock("serpentine_ore"));
    public static final RegistryObject<Block> SHIPMENT_FILLER = registerBlock("shipment_filler", () -> defaultBlock("shipment_filler"));
    public static final RegistryObject<Block> SHIVERGLOW = registerBlock("shiverglow", () -> defaultBlock("shiverglow"));
    public static final RegistryObject<Block> SHOCKWAVE_GENERATOR = registerBlock("shockwave_generator", () -> defaultBlock("shockwave_generator"));
    public static final RegistryObject<Block> SKY_STRIKER = registerBlock("sky_striker", () -> defaultBlock("sky_striker"));
    public static final RegistryObject<Block> SKYLOOM = registerBlock("skyloom", () -> defaultBlock("skyloom"));
    public static final RegistryObject<Block> SLAGDEPOSIT = registerBlock("slagdeposit", () -> defaultBlock("slagdeposit"));
    public static final RegistryObject<Block> SLIDE_PUZZLE_ALIEN_0 = registerBlock("slide_puzzle_alien_0", () -> defaultBlock("slide_puzzle_alien_0"));
    public static final RegistryObject<Block> SLIDE_PUZZLE_ALIEN_1 = registerBlock("slide_puzzle_alien_1", () -> defaultBlock("slide_puzzle_alien_1"));
    public static final RegistryObject<Block> SLIDE_PUZZLE_ALIEN_10 = registerBlock("slide_puzzle_alien_10", () -> defaultBlock("slide_puzzle_alien_10"));
    public static final RegistryObject<Block> SLIDE_PUZZLE_ALIEN_11 = registerBlock("slide_puzzle_alien_11", () -> defaultBlock("slide_puzzle_alien_11"));
    public static final RegistryObject<Block> SLIDE_PUZZLE_ALIEN_12 = registerBlock("slide_puzzle_alien_12", () -> defaultBlock("slide_puzzle_alien_12"));
    public static final RegistryObject<Block> SLIDE_PUZZLE_ALIEN_13 = registerBlock("slide_puzzle_alien_13", () -> defaultBlock("slide_puzzle_alien_13"));
    public static final RegistryObject<Block> SLIDE_PUZZLE_ALIEN_14 = registerBlock("slide_puzzle_alien_14", () -> defaultBlock("slide_puzzle_alien_14"));
    public static final RegistryObject<Block> SLIDE_PUZZLE_ALIEN_15 = registerBlock("slide_puzzle_alien_15", () -> defaultBlock("slide_puzzle_alien_15"));
    public static final RegistryObject<Block> SLIDE_PUZZLE_ALIEN_16 = registerBlock("slide_puzzle_alien_16", () -> defaultBlock("slide_puzzle_alien_16"));
    public static final RegistryObject<Block> SLIDE_PUZZLE_ALIEN_17 = registerBlock("slide_puzzle_alien_17", () -> defaultBlock("slide_puzzle_alien_17"));
    public static final RegistryObject<Block> SLIDE_PUZZLE_ALIEN_18 = registerBlock("slide_puzzle_alien_18", () -> defaultBlock("slide_puzzle_alien_18"));
    public static final RegistryObject<Block> SLIDE_PUZZLE_ALIEN_19 = registerBlock("slide_puzzle_alien_19", () -> defaultBlock("slide_puzzle_alien_19"));
    public static final RegistryObject<Block> SLIDE_PUZZLE_ALIEN_2 = registerBlock("slide_puzzle_alien_2", () -> defaultBlock("slide_puzzle_alien_2"));
    public static final RegistryObject<Block> SLIDE_PUZZLE_ALIEN_20 = registerBlock("slide_puzzle_alien_20", () -> defaultBlock("slide_puzzle_alien_20"));
    public static final RegistryObject<Block> SLIDE_PUZZLE_ALIEN_21 = registerBlock("slide_puzzle_alien_21", () -> defaultBlock("slide_puzzle_alien_21"));
    public static final RegistryObject<Block> SLIDE_PUZZLE_ALIEN_22 = registerBlock("slide_puzzle_alien_22", () -> defaultBlock("slide_puzzle_alien_22"));
    public static final RegistryObject<Block> SLIDE_PUZZLE_ALIEN_23 = registerBlock("slide_puzzle_alien_23", () -> defaultBlock("slide_puzzle_alien_23"));
    public static final RegistryObject<Block> SLIDE_PUZZLE_ALIEN_24 = registerBlock("slide_puzzle_alien_24", () -> defaultBlock("slide_puzzle_alien_24"));
    public static final RegistryObject<Block> SLIDE_PUZZLE_ALIEN_3 = registerBlock("slide_puzzle_alien_3", () -> defaultBlock("slide_puzzle_alien_3"));
    public static final RegistryObject<Block> SLIDE_PUZZLE_ALIEN_4 = registerBlock("slide_puzzle_alien_4", () -> defaultBlock("slide_puzzle_alien_4"));
    public static final RegistryObject<Block> SLIDE_PUZZLE_ALIEN_5 = registerBlock("slide_puzzle_alien_5", () -> defaultBlock("slide_puzzle_alien_5"));
    public static final RegistryObject<Block> SLIDE_PUZZLE_ALIEN_6 = registerBlock("slide_puzzle_alien_6", () -> defaultBlock("slide_puzzle_alien_6"));
    public static final RegistryObject<Block> SLIDE_PUZZLE_ALIEN_7 = registerBlock("slide_puzzle_alien_7", () -> defaultBlock("slide_puzzle_alien_7"));
    public static final RegistryObject<Block> SLIDE_PUZZLE_ALIEN_8 = registerBlock("slide_puzzle_alien_8", () -> defaultBlock("slide_puzzle_alien_8"));
    public static final RegistryObject<Block> SLIDE_PUZZLE_ALIEN_9 = registerBlock("slide_puzzle_alien_9", () -> defaultBlock("slide_puzzle_alien_9"));
    public static final RegistryObject<Block> SMOKEWEED = registerBlock("smokeweed", () -> defaultBlock("smokeweed"));
    public static final RegistryObject<Block> SMOOTH_CORAL = registerBlock("smooth_coral", () -> defaultBlock("smooth_coral"));
    public static final RegistryObject<Block> SNAKE_GUIDE_LEFT = registerBlock("snake_guide_left", () -> defaultBlock("snake_guide_left"));
    public static final RegistryObject<Block> SNAKE_GUIDE_RIGHT = registerBlock("snake_guide_right", () -> defaultBlock("snake_guide_right"));
    public static final RegistryObject<Block> SNARLVINE = registerBlock("snarlvine", () -> defaultBlock("snarlvine"));
    public static final RegistryObject<Block> SPACE_PICKLE = registerBlock("space_pickle", () -> defaultBlock("space_pickle"));
    public static final RegistryObject<Block> SPAWNER_ACIDBACK = registerBlock("spawner_acidback", () -> defaultBlock("spawner_acidback"));
    public static final RegistryObject<Block> SPAWNER_BLISTERWEED = registerBlock("spawner_blisterweed", () -> defaultBlock("spawner_blisterweed"));
    public static final RegistryObject<Block> SPAWNER_CHOMPER = registerBlock("spawner_chomper", () -> defaultBlock("spawner_chomper"));
    public static final RegistryObject<Block> SPAWNER_CLINGER = registerBlock("spawner_clinger", () -> defaultBlock("spawner_clinger"));
    public static final RegistryObject<Block> SPAWNER_CLUSTERWEED = registerBlock("spawner_clusterweed", () -> defaultBlock("spawner_clusterweed"));
    public static final RegistryObject<Block> SPAWNER_CLYSTER = registerBlock("spawner_clyster", () -> defaultBlock("spawner_clyster"));
    public static final RegistryObject<Block> SPAWNER_CRAWKER = registerBlock("spawner_crawker", () -> defaultBlock("spawner_crawker"));
    public static final RegistryObject<Block> SPAWNER_CRUSHER = registerBlock("spawner_crusher", () -> defaultBlock("spawner_crusher"));
    public static final RegistryObject<Block> SPAWNER_CYCLOS = registerBlock("spawner_cyclos", () -> defaultBlock("spawner_cyclos"));
    public static final RegistryObject<Block> SPAWNER_DOOMDOG = registerBlock("spawner_doomdog", () -> defaultBlock("spawner_doomdog"));
    public static final RegistryObject<Block> SPAWNER_DOUBLEJAW = registerBlock("spawner_doublejaw", () -> defaultBlock("spawner_doublejaw"));
    public static final RegistryObject<Block> SPAWNER_DRIPPLER = registerBlock("spawner_drippler", () -> defaultBlock("spawner_drippler"));
    public static final RegistryObject<Block> SPAWNER_DUSKER = registerBlock("spawner_dusker", () -> defaultBlock("spawner_dusker"));
    public static final RegistryObject<Block> SPAWNER_EXPLOSECT = registerBlock("spawner_explosect", () -> defaultBlock("spawner_explosect"));
    public static final RegistryObject<Block> SPAWNER_EYE_SLUG = registerBlock("spawner_eye_slug", () -> defaultBlock("spawner_eye_slug"));
    public static final RegistryObject<Block> SPAWNER_FLAPPER = registerBlock("spawner_flapper", () -> defaultBlock("spawner_flapper"));
    public static final RegistryObject<Block> SPAWNER_FLASHFLY = registerBlock("spawner_flashfly", () -> defaultBlock("spawner_flashfly"));
    public static final RegistryObject<Block> SPAWNER_FLURKY = registerBlock("spawner_flurky", () -> defaultBlock("spawner_flurky"));
    public static final RegistryObject<Block> SPAWNER_FLUTTERBEE = registerBlock("spawner_flutterbee", () -> defaultBlock("spawner_flutterbee"));
    public static final RegistryObject<Block> SPAWNER_FLUTTERFYRE = registerBlock("spawner_flutterfyre", () -> defaultBlock("spawner_flutterfyre"));
    public static final RegistryObject<Block> SPAWNER_FUNGFLY = registerBlock("spawner_fungfly", () -> defaultBlock("spawner_fungfly"));
    public static final RegistryObject<Block> SPAWNER_FYREWEED = registerBlock("spawner_fyreweed", () -> defaultBlock("spawner_fyreweed"));
    public static final RegistryObject<Block> SPAWNER_GALAXY_BEAST = registerBlock("spawner_galaxy_beast", () -> defaultBlock("spawner_galaxy_beast"));
    public static final RegistryObject<Block> SPAWNER_GALAXY_GLADIATOR = registerBlock("spawner_galaxy_gladiator", () -> defaultBlock("spawner_galaxy_gladiator"));
    public static final RegistryObject<Block> SPAWNER_GALAXY_GULPER = registerBlock("spawner_galaxy_gulper", () -> defaultBlock("spawner_galaxy_gulper"));
    public static final RegistryObject<Block> SPAWNER_GALAXY_SORCERER = registerBlock("spawner_galaxy_sorcerer", () -> defaultBlock("spawner_galaxy_sorcerer"));
    public static final RegistryObject<Block> SPAWNER_GIANT_ROCKSLUG = registerBlock("spawner_giant_rockslug", () -> defaultBlock("spawner_giant_rockslug"));
    public static final RegistryObject<Block> SPAWNER_GIANTFLAPPER = registerBlock("spawner_giantflapper", () -> defaultBlock("spawner_giantflapper"));
    public static final RegistryObject<Block> SPAWNER_GIANTFYREWEED = registerBlock("spawner_giantfyreweed", () -> defaultBlock("spawner_giantfyreweed"));
    public static final RegistryObject<Block> SPAWNER_GLANGLER = registerBlock("spawner_glangler", () -> defaultBlock("spawner_glangler"));
    public static final RegistryObject<Block> SPAWNER_GLOBOON = registerBlock("spawner_globoon", () -> defaultBlock("spawner_globoon"));
    public static final RegistryObject<Block> SPAWNER_GLOBRO = registerBlock("spawner_globro", () -> defaultBlock("spawner_globro"));
    public static final RegistryObject<Block> SPAWNER_GLOCHIPPER = registerBlock("spawner_glochipper", () -> defaultBlock("spawner_glochipper"));
    public static final RegistryObject<Block> SPAWNER_GLOMITE = registerBlock("spawner_glomite", () -> defaultBlock("spawner_glomite"));
    public static final RegistryObject<Block> SPAWNER_GLOOPMOTHER = registerBlock("spawner_gloopmother", () -> defaultBlock("spawner_gloopmother"));
    public static final RegistryObject<Block> SPAWNER_GNAWER = registerBlock("spawner_gnawer", () -> defaultBlock("spawner_gnawer"));
    public static final RegistryObject<Block> SPAWNER_GORGER = registerBlock("spawner_gorger", () -> defaultBlock("spawner_gorger"));
    public static final RegistryObject<Block> SPAWNER_GRAPPLER = registerBlock("spawner_grappler", () -> defaultBlock("spawner_grappler"));
    public static final RegistryObject<Block> SPAWNER_GRAVHEAD = registerBlock("spawner_gravhead", () -> defaultBlock("spawner_gravhead"));
    public static final RegistryObject<Block> SPAWNER_GRUBBER = registerBlock("spawner_grubber", () -> defaultBlock("spawner_grubber"));
    public static final RegistryObject<Block> SPAWNER_HANGER = registerBlock("spawner_hanger", () -> defaultBlock("spawner_hanger"));
    public static final RegistryObject<Block> SPAWNER_HURLER = registerBlock("spawner_hurler", () -> defaultBlock("spawner_hurler"));
    public static final RegistryObject<Block> SPAWNER_HYPNOSAUR = registerBlock("spawner_hypnosaur", () -> defaultBlock("spawner_hypnosaur"));
    public static final RegistryObject<Block> SPAWNER_LAB_WARRIOR = registerBlock("spawner_lab_warrior", () -> defaultBlock("spawner_lab_warrior"));
    public static final RegistryObject<Block> SPAWNER_LAB_WIZARD = registerBlock("spawner_lab_wizard", () -> defaultBlock("spawner_lab_wizard"));
    public static final RegistryObject<Block> SPAWNER_LEER = registerBlock("spawner_leer", () -> defaultBlock("spawner_leer"));
    public static final RegistryObject<Block> SPAWNER_LURCHER = registerBlock("spawner_lurcher", () -> defaultBlock("spawner_lurcher"));
    public static final RegistryObject<Block> SPAWNER_MINIMITE = registerBlock("spawner_minimite", () -> defaultBlock("spawner_minimite"));
    public static final RegistryObject<Block> SPAWNER_MUSHMERRA = registerBlock("spawner_mushmerra", () -> defaultBlock("spawner_mushmerra"));
    public static final RegistryObject<Block> SPAWNER_NAT = registerBlock("spawner_nat", () -> defaultBlock("spawner_nat"));
    public static final RegistryObject<Block> SPAWNER_NIGHTSHYRE = registerBlock("spawner_nightshyre", () -> defaultBlock("spawner_nightshyre"));
    public static final RegistryObject<Block> SPAWNER_ORBITER = registerBlock("spawner_orbiter", () -> defaultBlock("spawner_orbiter"));
    public static final RegistryObject<Block> SPAWNER_PHASER = registerBlock("spawner_phaser", () -> defaultBlock("spawner_phaser"));
    public static final RegistryObject<Block> SPAWNER_RAVAGER = registerBlock("spawner_ravager", () -> defaultBlock("spawner_ravager"));
    public static final RegistryObject<Block> SPAWNER_REFLECTAL = registerBlock("spawner_reflectal", () -> defaultBlock("spawner_reflectal"));
    public static final RegistryObject<Block> SPAWNER_RIBREX = registerBlock("spawner_ribrex", () -> defaultBlock("spawner_ribrex"));
    public static final RegistryObject<Block> SPAWNER_ROCKPEST = registerBlock("spawner_rockpest", () -> defaultBlock("spawner_rockpest"));
    public static final RegistryObject<Block> SPAWNER_ROCKSLUG = registerBlock("spawner_rockslug", () -> defaultBlock("spawner_rockslug"));
    public static final RegistryObject<Block> SPAWNER_ROCKWORM = registerBlock("spawner_rockworm", () -> defaultBlock("spawner_rockworm"));
    public static final RegistryObject<Block> SPAWNER_SCREACHER = registerBlock("spawner_screacher", () -> defaultBlock("spawner_screacher"));
    public static final RegistryObject<Block> SPAWNER_SENTRY = registerBlock("spawner_sentry", () -> defaultBlock("spawner_sentry"));
    public static final RegistryObject<Block> SPAWNER_SHIMMER = registerBlock("spawner_shimmer", () -> defaultBlock("spawner_shimmer"));
    public static final RegistryObject<Block> SPAWNER_SHROOMITE = registerBlock("spawner_shroomite", () -> defaultBlock("spawner_shroomite"));
    public static final RegistryObject<Block> SPAWNER_SIGHTWALKER = registerBlock("spawner_sightwalker", () -> defaultBlock("spawner_sightwalker"));
    public static final RegistryObject<Block> SPAWNER_SNAPPER = registerBlock("spawner_snapper", () -> defaultBlock("spawner_snapper"));
    public static final RegistryObject<Block> SPAWNER_SPINOVERN = registerBlock("spawner_spinovern", () -> defaultBlock("spawner_spinovern"));
    public static final RegistryObject<Block> SPAWNER_SPYKER = registerBlock("spawner_spyker", () -> defaultBlock("spawner_spyker"));
    public static final RegistryObject<Block> SPAWNER_STICKLER = registerBlock("spawner_stickler", () -> defaultBlock("spawner_stickler"));
    public static final RegistryObject<Block> SPAWNER_TENTACLON = registerBlock("spawner_tentaclon", () -> defaultBlock("spawner_tentaclon"));
    public static final RegistryObject<Block> SPAWNER_TERRORFLY = registerBlock("spawner_terrorfly", () -> defaultBlock("spawner_terrorfly"));
    public static final RegistryObject<Block> SPAWNER_TETHERBUG = registerBlock("spawner_tetherbug", () -> defaultBlock("spawner_tetherbug"));
    public static final RegistryObject<Block> SPAWNER_TITANOPOD = registerBlock("spawner_titanopod", () -> defaultBlock("spawner_titanopod"));
    public static final RegistryObject<Block> SPAWNER_VECTOSECT = registerBlock("spawner_vectosect", () -> defaultBlock("spawner_vectosect"));
    public static final RegistryObject<Block> SPAWNER_VILEBULB = registerBlock("spawner_vilebulb", () -> defaultBlock("spawner_vilebulb"));
    public static final RegistryObject<Block> SPAWNER_WEAVER = registerBlock("spawner_weaver", () -> defaultBlock("spawner_weaver"));
    public static final RegistryObject<Block> SPAWNER_WISP = registerBlock("spawner_wisp", () -> defaultBlock("spawner_wisp"));
    public static final RegistryObject<Block> STARBLOCK = registerBlock("starblock", () -> defaultBlock("starblock"));
    public static final RegistryObject<Block> STARFORGE_DECLOGGER = registerBlock("starforge_declogger", () -> defaultBlock("starforge_declogger"));
    public static final RegistryObject<Block> STARFORGE_MINERALINPUT = registerBlock("starforge_mineralinput", () -> defaultBlock("starforge_mineralinput"));
    public static final RegistryObject<Block> STARFORGE_TELEPORTER = registerBlock("starforge_teleporter", () -> defaultBlock("starforge_teleporter"));
    public static final RegistryObject<Block> STRANGELASH = registerBlock("strangelash", () -> defaultBlock("strangelash"));
    public static final RegistryObject<Block> STRANGLEWEED = registerBlock("strangleweed", () -> defaultBlock("strangleweed"));
    public static final RegistryObject<Block> STRIPED_STEEL_YELLOW = registerBlock("striped_steel_yellow", () -> defaultBlock("striped_steel_yellow"));
    public static final RegistryObject<Block> SUNDERLEAVES = registerBlock("sunderleaves", () -> defaultBlock("sunderleaves"));
    public static final RegistryObject<Block> SUNDERWOOD = registerBlock("sunderwood", () -> defaultBlock("sunderwood"));
    public static final RegistryObject<Block> SUNDERWOOD_PLANKS = registerBlock("sunderwood_planks", () -> defaultBlock("sunderwood_planks"));
    public static final RegistryObject<Block> SUNDERWOOD_SAP = registerBlock("sunderwood_sap", () -> defaultBlock("sunderwood_sap"));
    public static final RegistryObject<Block> SUNDERWOOD_SAP_EMPTY = registerBlock("sunderwood_sap_empty", () -> defaultBlock("sunderwood_sap_empty"));
    public static final RegistryObject<Block> SUNSTONE_ORE = registerBlock("sunstone_ore", () -> defaultBlock("sunstone_ore"));
    public static final RegistryObject<Block> SUPER_ROUGH_CORAL = registerBlock("super_rough_coral", () -> defaultBlock("super_rough_coral"));
    public static final RegistryObject<Block> SWITCHABLE_LIGHT_OFF = registerBlock("switchable_light_off", () -> defaultBlock("switchable_light_off"));
    public static final RegistryObject<Block> SWITCHABLE_LIGHT_ON = registerBlock("switchable_light_on", () -> defaultBlock("switchable_light_on"));
    public static final RegistryObject<Block> SYNCHRONITE_ORE = registerBlock("synchronite_ore", () -> defaultBlock("synchronite_ore"));
    public static final RegistryObject<Block> SYNCHRONITE_SIGNAL = registerBlock("synchronite_signal", () -> defaultBlock("synchronite_signal"));
    public static final RegistryObject<Block> TARGET = registerBlock("target", () -> defaultBlock("target"));
    public static final RegistryObject<Block> TENTACLE_BLUE = registerBlock("tentacle_blue", () -> defaultBlock("tentacle_blue"));
    public static final RegistryObject<Block> TENTACLE_BLUE_EYE = registerBlock("tentacle_blue_eye", () -> defaultBlock("tentacle_blue_eye"));
    public static final RegistryObject<Block> TENTACLE_EYE_EMPTY_BLUE = registerBlock("tentacle_eye_empty_blue", () -> defaultBlock("tentacle_eye_empty_blue"));
    public static final RegistryObject<Block> TENTACLE_EYE_EMPTY_PINK = registerBlock("tentacle_eye_empty_pink", () -> defaultBlock("tentacle_eye_empty_pink"));
    public static final RegistryObject<Block> TENTACLE_EYE_EMPTY_PURPLE = registerBlock("tentacle_eye_empty_purple", () -> defaultBlock("tentacle_eye_empty_purple"));
    public static final RegistryObject<Block> TENTACLE_PINK = registerBlock("tentacle_pink", () -> defaultBlock("tentacle_pink"));
    public static final RegistryObject<Block> TENTACLE_PINK_EYE = registerBlock("tentacle_pink_eye", () -> defaultBlock("tentacle_pink_eye"));
    public static final RegistryObject<Block> TENTACLE_PURPLE = registerBlock("tentacle_purple", () -> defaultBlock("tentacle_purple"));
    public static final RegistryObject<Block> TENTACLE_PURPLE_EYE = registerBlock("tentacle_purple_eye", () -> defaultBlock("tentacle_purple_eye"));
    public static final RegistryObject<Block> TENTACLE_SYNTHESIZER = registerBlock("tentacle_synthesizer", () -> defaultBlock("tentacle_synthesizer"));
    public static final RegistryObject<Block> TERROR_GLOW = registerBlock("terror_glow", () -> defaultBlock("terror_glow"));
    public static final RegistryObject<Block> TESLA_TOWER = registerBlock("tesla_tower", () -> defaultBlock("tesla_tower"));
    public static final RegistryObject<Block> TETHER_CREATOR = registerBlock("tether_creator", () -> defaultBlock("tether_creator"));
    public static final RegistryObject<Block> TIMELINE_STABILIZER_ARROW = registerBlock("timeline_stabilizer_arrow", () -> defaultBlock("timeline_stabilizer_arrow"));
    public static final RegistryObject<Block> TIMELINE_STABILIZER_CAPSULE = registerBlock("timeline_stabilizer_capsule", () -> defaultBlock("timeline_stabilizer_capsule"));
    public static final RegistryObject<Block> TIMELINE_STABILIZER_CONSOLE = registerBlock("timeline_stabilizer_console", () -> defaultBlock("timeline_stabilizer_console"));
    public static final RegistryObject<Block> TIMELINE_STABILIZER_GOAL = registerBlock("timeline_stabilizer_goal", () -> defaultBlock("timeline_stabilizer_goal"));
    public static final RegistryObject<Block> TIMELINE_STABILIZER_PORTAL = registerBlock("timeline_stabilizer_portal", () -> defaultBlock("timeline_stabilizer_portal"));
    public static final RegistryObject<Block> TRACK_WALL = registerBlock("track_wall", () -> defaultBlock("track_wall"));
    public static final RegistryObject<Block> TREADMILL_TRACK = registerBlock("treadmill_track", () -> defaultBlock("treadmill_track"));
    public static final RegistryObject<Block> TRIALGATE = registerBlock("trialgate", () -> defaultBlock("trialgate"));
    public static final RegistryObject<Block> UNPOWERED_FABRICATION_BATTERY = registerBlock("unpowered_fabrication_battery", () -> defaultBlock("unpowered_fabrication_battery"));
    public static final RegistryObject<Block> UNPOWERED_MODULATION_BATTERY = registerBlock("unpowered_modulation_battery", () -> defaultBlock("unpowered_modulation_battery"));
    public static final RegistryObject<Block> VELLORIUM_ORE = registerBlock("vellorium_ore", () -> defaultBlock("vellorium_ore"));
    public static final RegistryObject<Block> VIRAL_GROWTH = registerBlock("viral_growth", () -> defaultBlock("viral_growth"));
    public static final RegistryObject<Block> VOID_FLOWER = registerBlock("void_flower", () -> defaultBlock("void_flower"));
    public static final RegistryObject<Block> VOID_VACUUM = registerBlock("void_vacuum", () -> defaultBlock("void_vacuum"));
    public static final RegistryObject<Block> WATCHERWEEDS = registerBlock("watcherweeds", () -> defaultBlock("watcherweeds"));
    public static final RegistryObject<Block> WATCHERWEEDS_TOP = registerBlock("watcherweeds_top", () -> defaultBlock("watcherweeds_top"));
    public static final RegistryObject<Block> WEAVER_WEB = registerBlock("weaver_web", () -> defaultBlock("weaver_web"));
    public static final RegistryObject<Block> WELDING_CHAMBER = registerBlock("welding_chamber", () -> defaultBlock("welding_chamber"));
    public static final RegistryObject<Block> WHACK_BLOCK_LIT = registerBlock("whack_block_lit", () -> defaultBlock("whack_block_lit"));
    public static final RegistryObject<Block> WHACK_BLOCK_UNPOWERED = registerBlock("whack_block_unpowered", () -> defaultBlock("whack_block_unpowered"));
    public static final RegistryObject<Block> WHACK_GAME = registerBlock("whack_game", () -> defaultBlock("whack_game"));
    public static final RegistryObject<Block> WIGGLEWEED = registerBlock("wiggleweed", () -> defaultBlock("wiggleweed"));
    public static final RegistryObject<Block> WITHERGRASS = registerBlock("withergrass", () -> defaultBlock("withergrass"));
    public static final RegistryObject<Block> XEROVIUM_ORE = registerBlock("xerovium_ore", () -> defaultBlock("xerovium_ore"));
}

