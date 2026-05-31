package xol.lostinfinity.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import xol.lostinfinity.LostInfinity;

public final class ModCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, LostInfinity.MODID);

    public static final RegistryObject<CreativeModeTab> LOST_INFINITY = CREATIVE_MODE_TABS.register("lost_infinity", () -> CreativeModeTab.builder()
            .withTabsBefore(CreativeModeTabs.SPAWN_EGGS)
            .title(Component.translatable("itemGroup.lostinfinity.lost_infinity"))
            .icon(() -> ModItems.ALL_ITEMS.get(0).get().getDefaultInstance())
            .displayItems((parameters, output) -> ModItems.ALL_ITEMS.forEach(item -> output.accept(item.get())))
            .build());

    private ModCreativeTabs() {
    }
}
