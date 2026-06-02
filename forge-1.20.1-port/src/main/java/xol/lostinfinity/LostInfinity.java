package xol.lostinfinity;

import com.mojang.logging.LogUtils;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import xol.lostinfinity.registry.ModBlocks;
import xol.lostinfinity.registry.ModBlockEntities;
import xol.lostinfinity.registry.ModCreativeTabs;
import xol.lostinfinity.registry.ModEffects;
import xol.lostinfinity.registry.ModEntities;
import xol.lostinfinity.registry.ModItems;
import xol.lostinfinity.registry.ModMenus;
import xol.lostinfinity.registry.ModSpawnEggs;

@Mod(LostInfinity.MODID)
public final class LostInfinity {
    public static final String MODID = "lostinfinity";
    public static final Logger LOGGER = LogUtils.getLogger();

    public LostInfinity(FMLJavaModLoadingContext context) {
        IEventBus modEventBus = context.getModEventBus();
        ModBlocks.BLOCKS.register(modEventBus);
        ModBlockEntities.BLOCK_ENTITY_TYPES.register(modEventBus);
        ModEffects.MOB_EFFECTS.register(modEventBus);
        ModEntities.ENTITY_TYPES.register(modEventBus);
        ModSpawnEggs.touch();
        ModItems.ITEMS.register(modEventBus);
        ModMenus.MENUS.register(modEventBus);
        ModCreativeTabs.CREATIVE_MODE_TABS.register(modEventBus);
        LOGGER.info("Lost Infinity 1.20.1 port bootstrap registered {} blocks, {} items, and {} entity types.",
                ModBlocks.ALL_BLOCKS.size(), ModItems.ALL_ITEMS.size(), ModEntities.ALL_ENTITIES.size());
    }
}
