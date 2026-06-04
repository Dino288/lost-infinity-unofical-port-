package xol.lostinfinity.progression;

import java.util.Locale;
import net.minecraft.ChatFormatting;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import xol.lostinfinity.LostInfinity;

@Mod.EventBusSubscriber(modid = LostInfinity.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public final class LostProgression {
    private static final String ROOT = "lostinfinity_progression";
    public static final String MURK_UNLOCKED = "murk_unlocked";
    public static final String SHADOW_SEA_UNLOCKED = "shadowsea_unlocked";
    public static final String NONEXISTENCE_UNLOCKED = "nonexistence_unlocked";
    public static final String CARTOGRAPHER_UNLOCKED = "cartographer_unlocked";
    public static final String GRANDMASTER_UNLOCKED = "grandmaster_unlocked";
    public static final String CELESTIAL_VOID_UNLOCKED = "celestialvoid_unlocked";
    public static final String MURK_ENTERED = "murk_entered";
    public static final String SHADOW_SEA_ENTERED = "shadowsea_entered";
    public static final String NONEXISTENCE_ENTERED = "nonexistence_entered";
    public static final String CARTOGRAPHER_ENTERED = "cartographer_entered";
    public static final String GRANDMASTER_ENTERED = "grandmaster_entered";
    public static final String CELESTIAL_VOID_ENTERED = "celestialvoid_entered";
    public static final String GALAXY_TRIAL_CLEARED = "galaxy_trial_cleared";
    public static final String SHADOW_SEA_TRIAL_CLEARED = "shadowsea_trial_cleared";
    public static final String CARTOGRAPHER_TRIAL_CLEARED = "cartographer_trial_cleared";
    public static final String DEVIANT_TRIAL_CLEARED = "deviant_trial_cleared";

    private LostProgression() {
    }

    public static boolean has(Player player, String flag) {
        return data(player).getBoolean(flag);
    }

    public static boolean award(ServerPlayer player, String flag, Component message) {
        CompoundTag data = data(player);
        if (data.getBoolean(flag)) {
            return false;
        }
        data.putBoolean(flag, true);
        if (message != null) {
            player.displayClientMessage(message.copy().withStyle(ChatFormatting.GOLD), false);
        }
        player.level().playSound(null, player.blockPosition(), SoundEvents.PLAYER_LEVELUP, SoundSource.PLAYERS, 0.65F, 1.35F);
        return true;
    }

    public static boolean canUseDimension(ServerPlayer player, String dimension) {
        return switch (dimension) {
            case "infinitemurk" -> has(player, MURK_UNLOCKED);
            case "shadowsea" -> has(player, SHADOW_SEA_UNLOCKED);
            case "nonexistence" -> has(player, NONEXISTENCE_UNLOCKED);
            case "cartographerrealmtop", "cartographerrealmmid", "cartographerrealmbot" -> has(player, CARTOGRAPHER_UNLOCKED);
            case "grandmasteroutpost" -> has(player, GRANDMASTER_UNLOCKED);
            case "celestialvoid" -> has(player, CELESTIAL_VOID_UNLOCKED);
            default -> true;
        };
    }

    public static void recoverUnlockFromItem(ServerPlayer player, ItemStack stack) {
        ResourceLocation id = BuiltInRegistries.ITEM.getKey(stack.getItem());
        if (!LostInfinity.MODID.equals(id.getNamespace())) {
            return;
        }
        String item = id.getPath();
        switch (item) {
            case "murky_mirror" -> award(player, MURK_UNLOCKED, Component.literal("The mirror remembers the Infinite Murk."));
            case "magic_conch" -> award(player, SHADOW_SEA_UNLOCKED, Component.literal("The conch opens the Shadow Sea route."));
            case "galaxybeacon" -> award(player, NONEXISTENCE_UNLOCKED, Component.literal("The galaxy beacon locks onto Nonexistence."));
            case "solar_globe", "solar_globe_middle", "solar_globe_bottom" -> award(player, CARTOGRAPHER_UNLOCKED, Component.literal("The solar globe restores the Cartographer route."));
            case "atlas_beacon" -> award(player, GRANDMASTER_UNLOCKED, Component.literal("The atlas beacon anchors the Grandmaster Outpost."));
            case "beacon_key" -> award(player, CELESTIAL_VOID_UNLOCKED, Component.literal("The beacon key unlocks the Celestial Void."));
            case "synchronizer", "advanced_synchronizer", "geodimensional_tunnel", "dimensional_capacitor", "dimensionalizer_blueprint" ->
                    recoverDimensionalCrafting(player, item);
            default -> {
            }
        }
    }

    public static String status(ServerPlayer player) {
        return "Lost Infinity progression:"
                + "\nInfinite Murk: " + yes(MURK_UNLOCKED, MURK_ENTERED, player)
                + "\nShadow Sea: " + yes(SHADOW_SEA_UNLOCKED, SHADOW_SEA_ENTERED, player) + trial(SHADOW_SEA_TRIAL_CLEARED, player)
                + "\nNonexistence: " + yes(NONEXISTENCE_UNLOCKED, NONEXISTENCE_ENTERED, player) + trial(GALAXY_TRIAL_CLEARED, player)
                + "\nCartographer Realm: " + yes(CARTOGRAPHER_UNLOCKED, CARTOGRAPHER_ENTERED, player) + trial(CARTOGRAPHER_TRIAL_CLEARED, player)
                + "\nGrandmaster Outpost: " + yes(GRANDMASTER_UNLOCKED, GRANDMASTER_ENTERED, player) + trial(DEVIANT_TRIAL_CLEARED, player)
                + "\nCelestial Void: " + yes(CELESTIAL_VOID_UNLOCKED, CELESTIAL_VOID_ENTERED, player);
    }

    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if (event.phase != TickEvent.Phase.END || !(event.player instanceof ServerPlayer player) || player.tickCount % 80 != 0) {
            return;
        }
        for (ItemStack stack : player.getInventory().items) {
            if (!stack.isEmpty()) {
                recoverUnlockFromItem(player, stack);
            }
        }
        recoverEnteredDimension(player);
    }

    @SubscribeEvent
    public static void onLivingDeath(LivingDeathEvent event) {
        if (!(event.getSource().getEntity() instanceof ServerPlayer player)) {
            return;
        }
        ResourceLocation id = event.getEntity().getType().builtInRegistryHolder().key().location();
        if (!LostInfinity.MODID.equals(id.getNamespace())) {
            return;
        }
        String path = id.getPath().toLowerCase(Locale.ROOT);
        if (path.contains("galaxy") || path.contains("nonexistence")) {
            award(player, GALAXY_TRIAL_CLEARED, Component.literal("Galaxy trial recovered."));
        } else if (path.contains("shadow") || path.contains("sea") || path.contains("coral")) {
            award(player, SHADOW_SEA_TRIAL_CLEARED, Component.literal("Shadow Sea trial recovered."));
        } else if (path.contains("cartographer") || path.contains("hologram") || path.contains("contest")) {
            award(player, CARTOGRAPHER_TRIAL_CLEARED, Component.literal("Cartographer contest recovered."));
        } else if (path.contains("deviant") || path.contains("grandmaster")) {
            award(player, DEVIANT_TRIAL_CLEARED, Component.literal("Deviant trial recovered."));
        }
    }

    private static void recoverDimensionalCrafting(ServerPlayer player, String item) {
        award(player, CARTOGRAPHER_UNLOCKED, Component.literal("A synchronizer restores part of the dimensional route."));
        if (item.contains("dimensional") || item.equals("geodimensional_tunnel")) {
            award(player, NONEXISTENCE_UNLOCKED, Component.literal("Dimensional machinery restores the Nonexistence route."));
        }
    }

    private static void recoverEnteredDimension(ServerPlayer player) {
        ResourceLocation dimension = player.level().dimension().location();
        if (!LostInfinity.MODID.equals(dimension.getNamespace())) {
            return;
        }
        switch (dimension.getPath()) {
            case "infinitemurk" -> award(player, MURK_ENTERED, Component.literal("Infinite Murk route recorded."));
            case "shadowsea" -> award(player, SHADOW_SEA_ENTERED, Component.literal("Shadow Sea route recorded."));
            case "nonexistence" -> award(player, NONEXISTENCE_ENTERED, Component.literal("Nonexistence route recorded."));
            case "cartographerrealmtop", "cartographerrealmmid", "cartographerrealmbot" ->
                    award(player, CARTOGRAPHER_ENTERED, Component.literal("Cartographer Realm route recorded."));
            case "grandmasteroutpost" -> award(player, GRANDMASTER_ENTERED, Component.literal("Grandmaster Outpost route recorded."));
            case "celestialvoid" -> award(player, CELESTIAL_VOID_ENTERED, Component.literal("Celestial Void route recorded."));
            default -> {
            }
        }
    }

    private static CompoundTag data(Player player) {
        CompoundTag persistent = player.getPersistentData();
        if (!persistent.contains(ROOT)) {
            persistent.put(ROOT, new CompoundTag());
        }
        return persistent.getCompound(ROOT);
    }

    private static String yes(String unlock, String entered, ServerPlayer player) {
        return (has(player, unlock) ? "unlocked" : "locked") + ", " + (has(player, entered) ? "visited" : "unvisited");
    }

    private static String trial(String flag, ServerPlayer player) {
        return has(player, flag) ? ", trial cleared" : ", trial pending";
    }
}
