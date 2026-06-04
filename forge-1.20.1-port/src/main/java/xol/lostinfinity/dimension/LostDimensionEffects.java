package xol.lostinfinity.dimension;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.food.FoodData;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import xol.lostinfinity.LostInfinity;
import xol.lostinfinity.registry.ModEffects;

@Mod.EventBusSubscriber(modid = LostInfinity.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public final class LostDimensionEffects {
    private LostDimensionEffects() {
    }

    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if (event.phase != TickEvent.Phase.END || !(event.player instanceof ServerPlayer player) || player.isCreative() || player.isSpectator()) {
            return;
        }

        ResourceLocation dimension = player.level().dimension().location();
        if (!LostInfinity.MODID.equals(dimension.getNamespace())) {
            return;
        }

        switch (dimension.getPath()) {
            case "celestialvoid" -> tickCelestialVoid(player);
            case "nonexistence" -> tickNonexistence(player);
            case "cartographerrealmtop" -> tickCartographerRealmTop(player);
            case "cartographerrealmmid" -> tickCartographerRealm(player, false);
            case "cartographerrealmbot" -> tickCartographerRealm(player, true);
            case "grandmasteroutpost" -> tickGrandmasterOutpost(player);
            case "infinitemurk" -> tickInfiniteMurk(player);
            case "shadowsea" -> tickShadowSea(player);
            default -> {
            }
        }
    }

    private static void tickCelestialVoid(ServerPlayer player) {
        if (!hasNamedEquipment(player, "celestialheadguard") && !hasLostArmor(player)) {
            LostDimensionTeleporter.teleport(player, "nonexistence");
            player.displayClientMessage(Component.literal("Challengers must wear a Celestial Headguard."), false);
            return;
        }
        player.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 80, 0, true, false));
        player.addEffect(new MobEffectInstance(ModEffects.GRAVITATIONAL.get(), 80, 0, true, false));
        player.addEffect(new MobEffectInstance(ModEffects.OTHERWORLDLY.get(), 80, 0, true, false));
        if (player.getAbilities().flying && player.tickCount % 40 == 0) {
            player.hurt(player.damageSources().magic(), 1.0F);
            player.displayClientMessage(Component.literal("Flight damages your lungs due to the lack of atmosphere."), false);
        }
    }

    private static void tickNonexistence(ServerPlayer player) {
        if (hasNamedEquipment(player, "filtrationmask") || hasLostArmor(player)) {
            player.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 260, 0, true, false));
            player.addEffect(new MobEffectInstance(ModEffects.OTHERWORLDLY.get(), 120, 0, true, false));
            return;
        }
        player.addEffect(new MobEffectInstance(MobEffects.WITHER, 80, 1, true, false));
        player.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 120, 1, true, false));
        player.addEffect(new MobEffectInstance(ModEffects.DIMENSIONAL_TEAR.get(), 100, 0, true, false));
        if (player.tickCount % 80 == 0) {
            player.displayClientMessage(Component.literal("Toxic fumes quickly fill your airways."), false);
        }
    }

    private static void tickCartographerRealmTop(ServerPlayer player) {
        if (isHolding(player, "synchronizer") || isHolding(player, "advanced_synchronizer")) {
            player.addEffect(new MobEffectInstance(ModEffects.POTION_AFFINITY.get(), 80, 0, true, false));
            return;
        }
        if (player.tickCount % 120 == 0) {
            player.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 100, 0, true, false));
            player.displayClientMessage(Component.literal("The labyrinth map refuses to stay still. Hold a synchronizer to steady it."), false);
        }
    }

    private static void tickCartographerRealm(ServerPlayer player, boolean lowerRealm) {
        if (isHolding(player, "synchronizer") || isHolding(player, "advanced_synchronizer")) {
            player.addEffect(new MobEffectInstance(ModEffects.POTION_AFFINITY.get(), 80, lowerRealm ? 1 : 0, true, false));
            return;
        }
        int interval = lowerRealm ? 40 : 80;
        if (player.tickCount % interval == 0) {
            player.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 120, lowerRealm ? 1 : 0, true, false));
            player.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 120, lowerRealm ? 1 : 0, true, false));
            player.addEffect(new MobEffectInstance(ModEffects.DISTORTION.get(), 120, lowerRealm ? 1 : 0, true, false));
            player.displayClientMessage(Component.literal("A dimensional tear pulls at you. Hold a synchronizer to stabilize it."), false);
        }
    }

    private static void tickGrandmasterOutpost(ServerPlayer player) {
        if (player.tickCount % 20 == 0) {
            FoodData food = player.getFoodData();
            food.eat(20, 20.0F);
        }
        player.addEffect(new MobEffectInstance(ModEffects.PROTECTED.get(), 80, 0, true, false));
        player.addEffect(new MobEffectInstance(MobEffects.SATURATION, 40, 0, true, false));
    }

    private static void tickInfiniteMurk(ServerPlayer player) {
        player.addEffect(new MobEffectInstance(MobEffects.DARKNESS, 100, 0, true, false));
        player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 80, 0, true, false));
        player.addEffect(new MobEffectInstance(ModEffects.PHASED.get(), 80, 0, true, false));
        if (!hasLostArmor(player) && player.tickCount % 120 == 0) {
            player.hurt(player.damageSources().magic(), 1.0F);
            player.displayClientMessage(Component.literal("The murk drags at your reflection."), false);
        }
    }

    private static void tickShadowSea(ServerPlayer player) {
        player.addEffect(new MobEffectInstance(MobEffects.WATER_BREATHING, 120, 0, true, false));
        player.addEffect(new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 80, 0, true, false));
        player.addEffect(new MobEffectInstance(ModEffects.SUPERSONIC.get(), 80, 0, true, false));
        if (!hasNamedEquipment(player, "magic_conch") && !hasLostArmor(player) && player.tickCount % 140 == 0) {
            player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 100, 1, true, false));
            player.displayClientMessage(Component.literal("The reef currents fight against you."), false);
        }
    }

    private static boolean hasLostArmor(ServerPlayer player) {
        for (EquipmentSlot slot : new EquipmentSlot[] { EquipmentSlot.HEAD, EquipmentSlot.CHEST, EquipmentSlot.LEGS, EquipmentSlot.FEET }) {
            ResourceLocation id = itemId(player.getItemBySlot(slot));
            if (id != null && LostInfinity.MODID.equals(id.getNamespace()) && isArmorName(id.getPath())) {
                return true;
            }
        }
        return false;
    }

    private static boolean hasNamedEquipment(ServerPlayer player, String itemName) {
        for (EquipmentSlot slot : EquipmentSlot.values()) {
            ResourceLocation id = itemId(player.getItemBySlot(slot));
            if (id != null && LostInfinity.MODID.equals(id.getNamespace()) && id.getPath().equals(itemName)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isHolding(ServerPlayer player, String itemName) {
        return itemName.equals(path(player.getMainHandItem())) || itemName.equals(path(player.getOffhandItem()));
    }

    private static String path(ItemStack stack) {
        ResourceLocation id = itemId(stack);
        return id == null ? "" : id.getPath();
    }

    private static ResourceLocation itemId(ItemStack stack) {
        if (stack.isEmpty()) {
            return null;
        }
        return stack.getItem().builtInRegistryHolder().key().location();
    }

    private static boolean isArmorName(String name) {
        return name.endsWith("helmet") || name.endsWith("headguard") || name.endsWith("mask")
                || name.endsWith("chestplate") || name.endsWith("leggings") || name.endsWith("boots");
    }
}
