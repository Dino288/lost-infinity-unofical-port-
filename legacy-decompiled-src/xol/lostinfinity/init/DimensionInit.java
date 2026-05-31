/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.world.DimensionType
 *  net.minecraft.world.biome.Biome
 *  net.minecraftforge.common.DimensionManager
 *  net.minecraftforge.event.RegistryEvent$Register
 *  net.minecraftforge.fml.common.Mod$EventBusSubscriber
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 *  net.minecraftforge.registries.IForgeRegistry
 *  net.minecraftforge.registries.IForgeRegistryEntry
 */
package xol.lostinfinity.init;

import net.minecraft.world.DimensionType;
import net.minecraft.world.level.biome.Biome;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;
import xol.lostinfinity.dimension.cartographerrealm.BiomeCartographerRealm;
import xol.lostinfinity.dimension.cartographerrealm.bot.WorldProviderCartographerBot;
import xol.lostinfinity.dimension.cartographerrealm.mid.WorldProviderCartographerMid;
import xol.lostinfinity.dimension.cartographerrealm.top.WorldProviderCartographerTop;
import xol.lostinfinity.dimension.celestialvoid.BiomeCelestialVoid;
import xol.lostinfinity.dimension.celestialvoid.WorldProviderCelestialVoid;
import xol.lostinfinity.dimension.grandmasteroutpost.BiomeGrandmasterOutpost;
import xol.lostinfinity.dimension.grandmasteroutpost.WorldProviderGrandmasterOutpost;
import xol.lostinfinity.dimension.murk.BiomeInfiniteMurk;
import xol.lostinfinity.dimension.murk.WorldProviderInfiniteMurk;
import xol.lostinfinity.dimension.nonexistence.BiomeNonexistence;
import xol.lostinfinity.dimension.nonexistence.WorldProviderNonexistence;
import xol.lostinfinity.dimension.shadowsea.BiomeMoltenSea;
import xol.lostinfinity.dimension.shadowsea.BiomeShadowSea;
import xol.lostinfinity.dimension.shadowsea.WorldProviderShadowSea;
import xol.lostinfinity.dimension.util.DimensionEffectRegistry;
import xol.lostinfinity.util.ConfigurationHandler;

@Mod.EventBusSubscriber
public class DimensionInit {
    public static DimensionType cartographerRealmTop;
    public static DimensionType cartographerRealmMid;
    public static DimensionType cartographerRealmBot;
    public static DimensionType celestialVoid;
    public static DimensionType grandmasterOutpost;
    public static DimensionType nonexistence;
    public static DimensionType infiniteMurk;
    public static DimensionType shadowSea;
    public static final Biome biomeCelestialArena;
    public static final Biome biomeGrandmasterOutpost;
    public static final Biome biomeNonexistence;
    public static final Biome biomeCartographerRealm;
    public static final Biome biomeInfiniteMurk;
    public static final Biome biomeShadowSea;
    public static final Biome biomeMoltenSea;

    @SubscribeEvent
    public static void registerBiomes(RegistryEvent.Register<Biome> event) {
        IForgeRegistry registry = event.getRegistry();
        registry.registerAll((IForgeRegistryEntry[])new Biome[]{biomeCelestialArena, biomeGrandmasterOutpost, biomeCartographerRealm, biomeNonexistence, biomeShadowSea, biomeMoltenSea, biomeInfiniteMurk});
    }

    public static void dimensionInit() {
        infiniteMurk = DimensionType.register((String)"lostinfinity:infinitemurk", (String)"_infinitemurk", (int)ConfigurationHandler.infinite_murk_id, WorldProviderInfiniteMurk.class, (boolean)false);
        DimensionManager.registerDimension((int)ConfigurationHandler.infinite_murk_id, (DimensionType)infiniteMurk);
        celestialVoid = DimensionType.register((String)"lostinfinity:celestialvoid", (String)"_celestialvoid", (int)ConfigurationHandler.celestial_void_id, WorldProviderCelestialVoid.class, (boolean)false);
        DimensionManager.registerDimension((int)ConfigurationHandler.celestial_void_id, (DimensionType)celestialVoid);
        cartographerRealmTop = DimensionType.register((String)"lostinfinity:cartographerrealmtop", (String)"_cartographerrealmtop", (int)ConfigurationHandler.cartographer_realm_top_id, WorldProviderCartographerTop.class, (boolean)false);
        DimensionManager.registerDimension((int)ConfigurationHandler.cartographer_realm_top_id, (DimensionType)cartographerRealmTop);
        cartographerRealmMid = DimensionType.register((String)"lostinfinity:cartographerrealmmid", (String)"_cartographerrealmmid", (int)ConfigurationHandler.cartographer_realm_mid_id, WorldProviderCartographerMid.class, (boolean)false);
        DimensionManager.registerDimension((int)ConfigurationHandler.cartographer_realm_mid_id, (DimensionType)cartographerRealmMid);
        cartographerRealmBot = DimensionType.register((String)"lostinfinity:cartographerrealmbot", (String)"_cartographerrealmbot", (int)ConfigurationHandler.cartographer_realm_bot_id, WorldProviderCartographerBot.class, (boolean)false);
        DimensionManager.registerDimension((int)ConfigurationHandler.cartographer_realm_bot_id, (DimensionType)cartographerRealmBot);
        grandmasterOutpost = DimensionType.register((String)"lostinfinity:grandmasteroutpost", (String)"_grandmasteroutpost", (int)ConfigurationHandler.grandmaster_outpost_id, WorldProviderGrandmasterOutpost.class, (boolean)false);
        DimensionManager.registerDimension((int)ConfigurationHandler.grandmaster_outpost_id, (DimensionType)grandmasterOutpost);
        nonexistence = DimensionType.register((String)"lostinfinity:nonexistence", (String)"_nonexistence", (int)ConfigurationHandler.nonexistence_id, WorldProviderNonexistence.class, (boolean)false);
        DimensionManager.registerDimension((int)ConfigurationHandler.nonexistence_id, (DimensionType)nonexistence);
        shadowSea = DimensionType.register((String)"lostinfinity:shadowsea", (String)"_shadowsea", (int)ConfigurationHandler.shadow_sea_id, WorldProviderShadowSea.class, (boolean)false);
        DimensionManager.registerDimension((int)ConfigurationHandler.shadow_sea_id, (DimensionType)shadowSea);
        DimensionEffectRegistry.registerDimensionEffects();
    }

    static {
        biomeCelestialArena = new BiomeCelestialVoid();
        biomeGrandmasterOutpost = new BiomeGrandmasterOutpost();
        biomeNonexistence = new BiomeNonexistence();
        biomeCartographerRealm = new BiomeCartographerRealm();
        biomeInfiniteMurk = new BiomeInfiniteMurk();
        biomeShadowSea = new BiomeShadowSea();
        biomeMoltenSea = new BiomeMoltenSea();
    }
}

