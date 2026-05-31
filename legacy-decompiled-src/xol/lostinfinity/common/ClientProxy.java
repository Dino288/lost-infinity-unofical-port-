/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.audio.ISound
 *  net.minecraft.client.renderer.block.model.ModelResourceLocation
 *  net.minecraft.client.settings.KeyBinding
 *  net.minecraft.item.Item
 *  net.minecraft.util.SoundSource
 *  net.minecraft.util.SoundEvent
 *  net.minecraftforge.client.model.ModelLoader
 *  net.minecraftforge.common.MinecraftForge
 *  net.minecraftforge.fml.client.registry.ClientRegistry
 *  net.minecraftforge.fml.common.Loader
 *  net.minecraftforge.fml.common.event.FMLPostInitializationEvent
 *  net.minecraftforge.fml.common.event.FMLPreInitializationEvent
 *  net.minecraftforge.fml.common.eventhandler.EventBus
 */
package xol.lostinfinity.common;

import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.ISound;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.world.item.Item;
import net.minecraft.sounds.SoundSource;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.EventBus;
import xol.lostinfinity.client.ModelRegistry;
import xol.lostinfinity.client.audio.UniversalMovingSound;
import xol.lostinfinity.client.screen.CthulhuBossBar;
import xol.lostinfinity.client.screen.DistortionCover;
import xol.lostinfinity.client.screen.HeadHunterVision;
import xol.lostinfinity.client.screen.HealthValueGUI;
import xol.lostinfinity.client.special.ClientMindControlHandler;
import xol.lostinfinity.common.CommonProxy;
import xol.lostinfinity.init.ParticleInit;
import xol.lostinfinity.item.classify.IMovingSoundSource;
import xol.lostinfinity.util.compatibility.jer.JERCompatibility;

public class ClientProxy
extends CommonProxy {
    public static KeyBinding armorSetBonus = null;
    public static KeyBinding itemMode = null;
    public static KeyBinding dismount = null;

    @Override
    public void registerItemRenderer(Item item, int meta, String id) {
        ModelLoader.setCustomModelResourceLocation((Item)item, (int)meta, (ModelResourceLocation)new ModelResourceLocation(item.getRegistryName(), id));
    }

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        super.preInit(event);
        EventBus forgeBus = MinecraftForge.EVENT_BUS;
        forgeBus.register((Object)new ParticleInit());
        forgeBus.register((Object)new ModelRegistry());
    }

    @Override
    public void init() {
        super.init();
        this.registerKeybinds();
        if (Loader.isModLoaded((String)"jeresources")) {
            JERCompatibility.init();
        }
    }

    @Override
    public void postInit(FMLPostInitializationEvent event) {
        super.postInit(event);
        MinecraftForge.EVENT_BUS.register((Object)new HealthValueGUI());
        MinecraftForge.EVENT_BUS.register((Object)new CthulhuBossBar());
        MinecraftForge.EVENT_BUS.register((Object)new DistortionCover());
        MinecraftForge.EVENT_BUS.register((Object)new HeadHunterVision());
        MinecraftForge.EVENT_BUS.register((Object)new ClientMindControlHandler());
        ParticleInit.init();
    }

    @Override
    public void playMovingSound(SoundEvent soundIn, SoundSource categoryIn, IMovingSoundSource.Special special, float volume, float pitch) {
        Minecraft.func_71410_x().func_147118_V().func_147682_a((ISound)new UniversalMovingSound(soundIn, categoryIn, special, volume, pitch));
    }

    private void registerKeybinds() {
        armorSetBonus = new KeyBinding("key.lostinfinity.armor_set_bonus.desc", 47, "key.lostinfinity.category");
        ClientRegistry.registerKeyBinding((KeyBinding)armorSetBonus);
        itemMode = new KeyBinding("key.lostinfinity.item_mode.desc", 44, "key.lostinfinity.category");
        ClientRegistry.registerKeyBinding((KeyBinding)itemMode);
        dismount = new KeyBinding("key.lostinfinity.dismount.desc", 45, "key.lostinfinity.category");
        ClientRegistry.registerKeyBinding((KeyBinding)dismount);
    }
}

