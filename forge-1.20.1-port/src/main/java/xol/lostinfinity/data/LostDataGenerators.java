package xol.lostinfinity.data;

import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import xol.lostinfinity.LostInfinity;

@Mod.EventBusSubscriber(modid = LostInfinity.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public final class LostDataGenerators {
    private LostDataGenerators() {
    }

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        event.getGenerator().addProvider(event.includeServer(), new LostMachineRecipeProvider(event.getGenerator().getPackOutput()));
        event.getGenerator().addProvider(event.includeServer(), new LostBiomeTagDataProvider(event.getGenerator().getPackOutput()));
        event.getGenerator().addProvider(event.includeServer(), new LostBlockLootDataProvider(event.getGenerator().getPackOutput()));
    }
}
