package xol.lostinfinity.item;

import java.util.List;
import net.minecraft.ChatFormatting;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
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

public class LostDimensionItem extends Item {
    private static final String SOLAR_FLOOR_TAG = "lostinfinity_solar_floor";
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
                toggleDimension(serverPlayer, "infinitemurk");
                player.getCooldowns().addCooldown(this, 80);
            } else if ("galaxybeacon".equals(itemName)) {
                useGalaxyBeacon(serverPlayer);
                player.getCooldowns().addCooldown(this, 120);
            } else if ("magic_conch".equals(itemName)) {
                useMagicConch(serverPlayer);
                player.getCooldowns().addCooldown(this, 120);
            } else if ("solar_globe".equals(itemName)) {
                useSolarGlobe(serverPlayer, stack);
                player.getCooldowns().addCooldown(this, 80);
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
        }
    }

    private static void toggleDimension(ServerPlayer player, String targetDimension) {
        if (isInLostDimension(player, targetDimension)) {
            LostDimensionTeleporter.teleport(player, "overworld", player.getX(), player.getY(), player.getZ(), true);
        } else {
            LostDimensionTeleporter.teleport(player, targetDimension, player.getX(), player.getY(), player.getZ(), true);
        }
    }

    private static void useGalaxyBeacon(ServerPlayer player) {
        if (isInLostDimension(player, "nonexistence")) {
            LostDimensionTeleporter.teleport(player, "overworld", player.getX(), player.getY(), player.getZ(), true);
        } else {
            LostDimensionTeleporter.teleport(player, "nonexistence", 24.0D, 110.0D, 17.0D, false);
        }
    }

    private static void useMagicConch(ServerPlayer player) {
        if (isInLostDimension(player, "shadowsea")) {
            LostDimensionTeleporter.teleport(player, "overworld", player.getX(), player.getY(), player.getZ(), true);
        } else {
            double x = randomCoordinate(player.getRandom());
            double z = randomCoordinate(player.getRandom());
            LostDimensionTeleporter.teleport(player, "shadowsea", x, 160.0D, z, false);
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
            LostDimensionTeleporter.teleport(player, "overworld", player.getX(), player.getY(), player.getZ(), true);
            return;
        }

        int floor = getSolarFloor(stack);
        String dimension = floor == 1 ? "cartographerrealmmid" : floor == 2 ? "cartographerrealmbot" : "cartographerrealmtop";
        int roomX = player.getRandom().nextInt(1000) - 500;
        int roomZ = player.getRandom().nextInt(1000) - 500;
        double y = roomX == roomZ ? 16.0D : 25.0D;
        LostDimensionTeleporter.teleport(player, dimension, 15.0D + 160.0D * roomX, y, 15.0D + 160.0D * roomZ, false);
    }

    private static boolean isInLostDimension(ServerPlayer player, String dimension) {
        return LostInfinity.MODID.equals(player.level().dimension().location().getNamespace())
                && dimension.equals(player.level().dimension().location().getPath());
    }

    private static double randomCoordinate(net.minecraft.util.RandomSource random) {
        return (-0.5D + random.nextDouble()) * 10000.0D;
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
