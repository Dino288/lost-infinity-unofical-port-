package xol.lostinfinity.item;

import java.util.List;
import net.minecraft.ChatFormatting;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;
import xol.lostinfinity.LostInfinity;
import xol.lostinfinity.dimension.LostDimensionTeleporter;
import xol.lostinfinity.effect.LostFx;

public class LostDimensionItem extends Item {
    private static final String SOLAR_FLOOR_TAG = "lostinfinity_solar_floor";
    private static final String RETURN_DIMENSION_TAG = "lostinfinity_return_dimension";
    private static final String RETURN_X_TAG = "lostinfinity_return_x";
    private static final String RETURN_Y_TAG = "lostinfinity_return_y";
    private static final String RETURN_Z_TAG = "lostinfinity_return_z";
    private final String itemName;

    public LostDimensionItem(String itemName, Properties properties) {
        super(properties.stacksTo(1));
        this.itemName = itemName;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);
        if (!level.isClientSide() && player instanceof ServerPlayer serverPlayer) {
            if ("murky_mirror".equals(itemName)) {
                toggleDimension(serverPlayer, stack, "infinitemurk");
                player.getCooldowns().addCooldown(this, 80);
            } else if ("galaxybeacon".equals(itemName)) {
                useGalaxyBeacon(serverPlayer, stack);
                player.getCooldowns().addCooldown(this, 120);
            } else if ("magic_conch".equals(itemName)) {
                useMagicConch(serverPlayer, stack);
                player.getCooldowns().addCooldown(this, 120);
            } else if ("solar_globe".equals(itemName)) {
                useSolarGlobe(serverPlayer, stack);
                player.getCooldowns().addCooldown(this, 80);
            } else if ("atlas_beacon".equals(itemName)) {
                useAtlasBeacon(serverPlayer, stack);
                player.getCooldowns().addCooldown(this, 120);
            } else if ("beacon_key".equals(itemName)) {
                useBeaconKey(serverPlayer, stack);
                player.getCooldowns().addCooldown(this, 120);
            }
        }
        return InteractionResultHolder.sidedSuccess(stack, level.isClientSide());
    }

    @Override
    public boolean isFoil(ItemStack stack) {
        return "solar_globe".equals(itemName) || super.isFoil(stack);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag flag) {
        if ("murky_mirror".equals(itemName)) {
            tooltip.add(Component.literal("Gaze into the mirror to travel to the Infinite Murk.").withStyle(ChatFormatting.GOLD));
        } else if ("galaxybeacon".equals(itemName)) {
            tooltip.add(Component.literal("Teleports you to the Galaxy Dungeon in Nonexistence.").withStyle(ChatFormatting.GOLD));
        } else if ("magic_conch".equals(itemName)) {
            tooltip.add(Component.literal("Listen to the ocean and be taken away...").withStyle(ChatFormatting.AQUA));
        } else if ("solar_globe".equals(itemName)) {
            tooltip.add(Component.literal("Teleports you in and out of the Cartographer's Labyrinth.").withStyle(ChatFormatting.GOLD));
            tooltip.add(Component.literal("Sneak-use to select floor: " + solarFloorName(getSolarFloor(stack))).withStyle(ChatFormatting.AQUA));
        } else if ("atlas_beacon".equals(itemName)) {
            tooltip.add(Component.literal("Anchors a route to the Grandmaster Outpost.").withStyle(ChatFormatting.GOLD));
        } else if ("beacon_key".equals(itemName)) {
            tooltip.add(Component.literal("Unlocks the Celestial Void.").withStyle(ChatFormatting.GOLD));
        }
    }

    private static void toggleDimension(ServerPlayer player, ItemStack stack, String targetDimension) {
        if (isInLostDimension(player, targetDimension)) {
            teleportToReturnPosition(player, stack, "murk");
        } else {
            rememberReturnPosition(player, stack);
            teleport(player, targetDimension, 0.0D, 90.0D, 0.0D, true, "murk");
        }
    }

    private static void useGalaxyBeacon(ServerPlayer player, ItemStack stack) {
        if (isInLostDimension(player, "nonexistence")) {
            teleportToReturnPosition(player, stack, "portal_beam");
        } else {
            rememberReturnPosition(player, stack);
            teleport(player, "nonexistence", 24.0D, 110.0D, 17.0D, false, "portal_beam");
        }
    }

    private static void useMagicConch(ServerPlayer player, ItemStack stack) {
        if (isInLostDimension(player, "shadowsea")) {
            teleportToReturnPosition(player, stack, "murky_mist");
        } else {
            rememberReturnPosition(player, stack);
            teleport(player, "shadowsea", 0.0D, 96.0D, 0.0D, true, "murky_mist");
        }
    }

    private static void useSolarGlobe(ServerPlayer player, ItemStack stack) {
        if (player.isShiftKeyDown()) {
            int nextFloor = (getSolarFloor(stack) + 1) % 3;
            setSolarFloor(stack, nextFloor);
            player.displayClientMessage(Component.literal("Teleport set to " + solarFloorName(nextFloor) + "."), true);
            return;
        }
        if (LostInfinity.MODID.equals(player.level().dimension().location().getNamespace())
                && player.level().dimension().location().getPath().startsWith("cartographerrealm")) {
            teleportToReturnPosition(player, stack, "space_magic");
            return;
        }

        rememberReturnPosition(player, stack);
        int floor = getSolarFloor(stack);
        String dimension = floor == 1 ? "cartographerrealmmid" : floor == 2 ? "cartographerrealmbot" : "cartographerrealmtop";
        double y = floor == 2 ? 36.0D : floor == 1 ? 48.0D : 64.0D;
        teleport(player, dimension, 15.0D, y, 15.0D, false, "space_magic");
    }

    private static void useAtlasBeacon(ServerPlayer player, ItemStack stack) {
        if (isInLostDimension(player, "grandmasteroutpost")) {
            teleportToReturnPosition(player, stack, "portal_beam");
        } else {
            rememberReturnPosition(player, stack);
            teleport(player, "grandmasteroutpost", 0.0D, 76.0D, 0.0D, true, "portal_beam");
        }
    }

    private static void useBeaconKey(ServerPlayer player, ItemStack stack) {
        if (isInLostDimension(player, "celestialvoid")) {
            teleportToReturnPosition(player, stack, "space_magic");
        } else {
            rememberReturnPosition(player, stack);
            teleport(player, "celestialvoid", 0.0D, 128.0D, 0.0D, false, "space_magic");
        }
    }

    private static boolean isInLostDimension(ServerPlayer player, String dimension) {
        return LostInfinity.MODID.equals(player.level().dimension().location().getNamespace())
                && dimension.equals(player.level().dimension().location().getPath());
    }

    private static void rememberReturnPosition(ServerPlayer player, ItemStack stack) {
        CompoundTag tag = stack.getOrCreateTag();
        tag.putString(RETURN_DIMENSION_TAG, player.level().dimension().location().toString());
        tag.putDouble(RETURN_X_TAG, player.getX());
        tag.putDouble(RETURN_Y_TAG, player.getY());
        tag.putDouble(RETURN_Z_TAG, player.getZ());
    }

    private static void teleportToReturnPosition(ServerPlayer player, ItemStack stack, String particle) {
        CompoundTag tag = stack.getOrCreateTag();
        String dimension = tag.getString(RETURN_DIMENSION_TAG);
        if (dimension.isBlank() || !dimension.startsWith("minecraft:")) {
            teleport(player, "overworld", 0.0D, 80.0D, 0.0D, true, particle);
            return;
        }
        String target = "minecraft:overworld".equals(dimension) ? "overworld" : dimension;
        teleport(player, target, tag.getDouble(RETURN_X_TAG), tag.getDouble(RETURN_Y_TAG), tag.getDouble(RETURN_Z_TAG), true, particle);
    }

    private static void teleport(ServerPlayer player, String dimension, double x, double y, double z, boolean surface, String particle) {
        LostFx.play(player.level(), player.blockPosition(), "portal_open", SoundSource.PLAYERS, 0.8F, 1.0F);
        LostFx.burst(player.level(), player.blockPosition(), particle, 24, 0.7D, 0.05D);
        if (LostDimensionTeleporter.teleport(player, dimension, x, y, z, surface)) {
            LostFx.play(player.level(), player.blockPosition(), arrivalSound(particle), SoundSource.PLAYERS, 0.75F, 1.05F);
            LostFx.burst(player.level(), player.blockPosition(), particle, 32, 0.9D, 0.04D);
        }
    }

    private static String arrivalSound(String particle) {
        if ("portal_beam".equals(particle)) {
            return "nebulous_beacon";
        }
        if ("space_magic".equals(particle)) {
            return "big_warp";
        }
        return "portal_open";
    }

    private static int getSolarFloor(ItemStack stack) {
        CompoundTag tag = stack.getOrCreateTag();
        return Math.max(0, Math.min(2, tag.getInt(SOLAR_FLOOR_TAG)));
    }

    private static void setSolarFloor(ItemStack stack, int floor) {
        stack.getOrCreateTag().putInt(SOLAR_FLOOR_TAG, floor);
    }

    private static String solarFloorName(int floor) {
        return floor == 1 ? "middle (red)" : floor == 2 ? "bottom (purple)" : "top (blue)";
    }
}
