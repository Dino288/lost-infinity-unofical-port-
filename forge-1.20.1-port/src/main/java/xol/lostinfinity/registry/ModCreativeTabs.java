package xol.lostinfinity.registry;

import java.util.function.Predicate;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShieldItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import xol.lostinfinity.LostInfinity;

public final class ModCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, LostInfinity.MODID);

    public static final RegistryObject<CreativeModeTab> LOST_INFINITY = CREATIVE_MODE_TABS.register("lost_infinity", () -> CreativeModeTab.builder()
            .withTabsBefore(CreativeModeTabs.SPAWN_EGGS)
            .title(Component.translatable("itemGroup.lostinfinity.lost_infinity"))
            .icon(() -> ModItems.ALL_ITEMS.get(0).get().getDefaultInstance())
            .displayItems((parameters, output) -> {
                ModItems.ALL_ITEMS.forEach(item -> output.accept(item.get()));
                ModSpawnEggs.addToCreativeTab(output);
            })
            .build());

    public static final RegistryObject<CreativeModeTab> BLOCKS = CREATIVE_MODE_TABS.register("tab_blocks", () -> CreativeModeTab.builder()
            .withTabsBefore(CreativeModeTabs.SPAWN_EGGS)
            .title(Component.translatable("itemGroup.lostinfinity.tab_blocks"))
            .icon(() -> icon("murkstone", "rough_coral", "astrorock"))
            .displayItems((parameters, output) -> acceptMatching(output, item -> item instanceof BlockItem))
            .build());

    public static final RegistryObject<CreativeModeTab> ARMOR = CREATIVE_MODE_TABS.register("tab_armors", () -> CreativeModeTab.builder()
            .withTabsBefore(CreativeModeTabs.SPAWN_EGGS)
            .title(Component.translatable("itemGroup.lostinfinity.tab_armors"))
            .icon(() -> icon("vampyreon_chestplate", "celestialheadguard", "blightcyst_chestplate"))
            .displayItems((parameters, output) -> acceptMatching(output, item -> item instanceof ArmorItem))
            .build());

    public static final RegistryObject<CreativeModeTab> WEAPONS = CREATIVE_MODE_TABS.register("tab_infinity", () -> CreativeModeTab.builder()
            .withTabsBefore(CreativeModeTabs.SPAWN_EGGS)
            .title(Component.translatable("itemGroup.lostinfinity.tab_infinity"))
            .icon(() -> icon("world_splitter", "the_black_hole", "sword_of_selection"))
            .displayItems((parameters, output) -> acceptMatching(output, item -> isWeapon(path(item), item)))
            .build());

    public static final RegistryObject<CreativeModeTab> MAPS = CREATIVE_MODE_TABS.register("tab_maps", () -> CreativeModeTab.builder()
            .withTabsBefore(CreativeModeTabs.SPAWN_EGGS)
            .title(Component.translatable("itemGroup.lostinfinity.tab_maps"))
            .icon(() -> icon("mechanical_sextant", "map_ambition", "basic_sextant"))
            .displayItems((parameters, output) -> acceptMatching(output, item -> isMapOrProgression(path(item))))
            .build());

    public static final RegistryObject<CreativeModeTab> MATERIALS = CREATIVE_MODE_TABS.register("tab_mastercraft", () -> CreativeModeTab.builder()
            .withTabsBefore(CreativeModeTabs.SPAWN_EGGS)
            .title(Component.translatable("itemGroup.lostinfinity.tab_mastercraft"))
            .icon(() -> icon("multiversite", "sunstone", "darksteel_shards"))
            .displayItems((parameters, output) -> acceptMatching(output, item -> isMaterial(path(item), item)))
            .build());

    public static final RegistryObject<CreativeModeTab> SPAWN_EGGS = CREATIVE_MODE_TABS.register("tab_deviant", () -> CreativeModeTab.builder()
            .withTabsBefore(CreativeModeTabs.SPAWN_EGGS)
            .title(Component.translatable("itemGroup.lostinfinity.tab_deviant"))
            .icon(() -> icon("deviantbear_spawn_egg", "galaxybeast_spawn_egg", "dimensionalmerchant_spawn_egg"))
            .displayItems((parameters, output) -> ModSpawnEggs.addToCreativeTab(output))
            .build());

    private ModCreativeTabs() {
    }

    private static void acceptMatching(CreativeModeTab.Output output, Predicate<Item> predicate) {
        ModItems.ALL_ITEMS.stream()
                .map(RegistryObject::get)
                .filter(predicate)
                .forEach(output::accept);
    }

    private static ItemStack icon(String... paths) {
        for (String candidate : paths) {
            for (RegistryObject<Item> item : ModItems.ALL_ITEMS) {
                if (item.getId().getPath().equals(candidate)) {
                    return item.get().getDefaultInstance();
                }
            }
        }
        return ModItems.ALL_ITEMS.get(0).get().getDefaultInstance();
    }

    private static String path(Item item) {
        return item.builtInRegistryHolder().key().location().getPath();
    }

    private static boolean isWeapon(String path, Item item) {
        return item instanceof BowItem || item instanceof ShieldItem || path.contains("sword") || path.contains("blade")
                || path.contains("saber") || path.contains("sabre") || path.contains("claw") || path.contains("gun")
                || path.contains("rifle") || path.contains("cannon") || path.contains("zapper") || path.contains("wand")
                || path.contains("staff") || path.contains("launcher") || path.contains("blaster") || path.contains("trident")
                || path.contains("bomb");
    }

    private static boolean isMapOrProgression(String path) {
        return path.startsWith("map_") || path.endsWith("_map") || path.contains("sextant") || path.contains("monitor")
                || path.contains("hypercron") || path.contains("_token") || path.endsWith("card") || path.contains("_key")
                || path.contains("relocator") || path.contains("geolocation") || path.contains("geocoordinated");
    }

    private static boolean isMaterial(String path, Item item) {
        return !(item instanceof BlockItem) && !(item instanceof ArmorItem) && !isWeapon(path, item) && !isMapOrProgression(path);
    }
}
