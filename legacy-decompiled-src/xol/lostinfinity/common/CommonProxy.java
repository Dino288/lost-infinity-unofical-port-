/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.item.Item
 *  net.minecraft.util.SoundSource
 *  net.minecraft.util.SoundEvent
 *  net.minecraftforge.common.MinecraftForge
 *  net.minecraftforge.fml.common.Mod$EventBusSubscriber
 *  net.minecraftforge.fml.common.event.FMLPostInitializationEvent
 *  net.minecraftforge.fml.common.event.FMLPreInitializationEvent
 *  net.minecraftforge.fml.common.network.IGuiHandler
 *  net.minecraftforge.fml.common.network.NetworkRegistry
 */
package xol.lostinfinity.common;

import net.minecraft.world.item.Item;
import net.minecraft.sounds.SoundSource;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.IGuiHandler;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import xol.lostinfinity.common.lostinfinity;
import xol.lostinfinity.common.special.CommonMindControlHandler;
import xol.lostinfinity.common.special.CommonMinionHandler;
import xol.lostinfinity.gui.GuiHandler;
import xol.lostinfinity.init.SpawnInit;
import xol.lostinfinity.item.classify.IMovingSoundSource;

@Mod.EventBusSubscriber
public class CommonProxy {
    public void preInit(FMLPreInitializationEvent event) {
        NetworkRegistry.INSTANCE.registerGuiHandler((Object)lostinfinity.instance, (IGuiHandler)GuiHandler.getInstance());
    }

    public void init() {
    }

    public void postInit(FMLPostInitializationEvent event) {
        SpawnInit.init();
        CommonMinionHandler.init();
        MinecraftForge.EVENT_BUS.register((Object)new CommonMindControlHandler());
    }

    public void registerItemRenderer(Item item, int meta, String id) {
    }

    public void playMovingSound(SoundEvent soundIn, SoundSource categoryIn, IMovingSoundSource.Special special, float volume, float pitch) {
    }
}

