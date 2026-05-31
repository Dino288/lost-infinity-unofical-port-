/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.command.ICommand
 *  net.minecraftforge.common.MinecraftForge
 *  net.minecraftforge.fluids.FluidRegistry
 *  net.minecraftforge.fml.common.Mod
 *  net.minecraftforge.fml.common.Mod$EventHandler
 *  net.minecraftforge.fml.common.Mod$Instance
 *  net.minecraftforge.fml.common.SidedProxy
 *  net.minecraftforge.fml.common.event.FMLInitializationEvent
 *  net.minecraftforge.fml.common.event.FMLPostInitializationEvent
 *  net.minecraftforge.fml.common.event.FMLPreInitializationEvent
 *  net.minecraftforge.fml.common.event.FMLServerStartingEvent
 *  org.apache.logging.log4j.LogManager
 *  org.apache.logging.log4j.Logger
 */
package xol.lostinfinity.common;

import net.minecraft.command.ICommand;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import xol.lostinfinity.common.CommonProxy;
import xol.lostinfinity.common.events.EventsClientRender;
import xol.lostinfinity.common.events.EventsCreatureAction;
import xol.lostinfinity.common.events.EventsDimensional;
import xol.lostinfinity.common.events.EventsMurk;
import xol.lostinfinity.common.events.EventsNetworkInjection;
import xol.lostinfinity.common.events.EventsPlayerAction;
import xol.lostinfinity.common.events.EventsPlayerInput;
import xol.lostinfinity.common.packets.LostInfinityPacketHandler;
import xol.lostinfinity.init.ArmorInit;
import xol.lostinfinity.init.BlockInit;
import xol.lostinfinity.init.DimensionInit;
import xol.lostinfinity.init.EntityInit;
import xol.lostinfinity.init.FluidInit;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.init.PotionInit;
import xol.lostinfinity.recipes.CustomBrewingRecipes;
import xol.lostinfinity.util.ConfigurationHandler;
import xol.lostinfinity.util.command.CommandChargeEP;
import xol.lostinfinity.util.command.CommandClearFractures;
import xol.lostinfinity.util.command.CommandClearRifts;
import xol.lostinfinity.util.command.CommandSetDeviant;

@Mod(modid="lostinfinity", name="Lost Infinity Stones", version="1.15.4", acceptedMinecraftVersions="[1.12.2]")
public class lostinfinity {
    @Mod.Instance
    public static lostinfinity instance;
    public LostInfinityPacketHandler packetHandler;
    @SidedProxy(clientSide="xol.lostinfinity.common.ClientProxy", serverSide="xol.lostinfinity.common.CommonProxy")
    public static CommonProxy proxy;
    public static final Logger LOGGER;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        ConfigurationHandler.init(event.getModConfigurationDirectory());
        FluidInit.registerFluids(event.getSide());
        DimensionInit.dimensionInit();
        EntityInit.tileEntityRegister();
        PotionInit.registerPotions();
        MinecraftForge.EVENT_BUS.register((Object)new ArmorInit());
        MinecraftForge.EVENT_BUS.register((Object)new EventsClientRender());
        MinecraftForge.EVENT_BUS.register((Object)new EventsPlayerInput());
        MinecraftForge.EVENT_BUS.register((Object)new EventsPlayerAction());
        MinecraftForge.EVENT_BUS.register((Object)new EventsCreatureAction());
        MinecraftForge.EVENT_BUS.register((Object)new EventsDimensional());
        MinecraftForge.EVENT_BUS.register((Object)new EventsMurk());
        MinecraftForge.EVENT_BUS.register((Object)new EventsNetworkInjection());
        proxy.preInit(event);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        this.packetHandler = new LostInfinityPacketHandler();
        CustomBrewingRecipes.init();
        BlockInit.objectPassing();
        ItemInit.objectPassing();
        proxy.init();
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit(event);
    }

    @Mod.EventHandler
    public void serverInit(FMLServerStartingEvent event) {
        event.registerServerCommand((ICommand)new CommandSetDeviant());
        event.registerServerCommand((ICommand)new CommandClearRifts());
        event.registerServerCommand((ICommand)new CommandClearFractures());
        event.registerServerCommand((ICommand)new CommandChargeEP());
    }

    static {
        LOGGER = LogManager.getLogger((String)"lostinfinity");
        FluidRegistry.enableUniversalBucket();
    }
}

