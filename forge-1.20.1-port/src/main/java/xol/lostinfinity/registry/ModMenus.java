package xol.lostinfinity.registry;

import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import xol.lostinfinity.LostInfinity;
import xol.lostinfinity.menu.LostMachineMenu;

public final class ModMenus {
    public static final DeferredRegister<MenuType<?>> MENUS =
            DeferredRegister.create(ForgeRegistries.MENU_TYPES, LostInfinity.MODID);

    public static final RegistryObject<MenuType<LostMachineMenu>> LOST_MACHINE_MENU =
            MENUS.register("lost_machine", () -> IForgeMenuType.create((containerId, inventory, data) ->
                    new LostMachineMenu(containerId, inventory)));

    private ModMenus() {
    }
}
