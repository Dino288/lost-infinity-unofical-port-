package xol.lostinfinity.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import xol.lostinfinity.dimension.LostDimensionTeleporter;
import xol.lostinfinity.LostInfinity;
import xol.lostinfinity.registry.ModBlocks;

@Mod.EventBusSubscriber(modid = LostInfinity.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public final class LostInfinityCommands {
    private static final String[] DIMENSIONS = {
            "infinitemurk",
            "celestialvoid",
            "cartographerrealmtop",
            "cartographerrealmmid",
            "cartographerrealmbot",
            "grandmasteroutpost",
            "nonexistence",
            "shadowsea"
    };

    private LostInfinityCommands() {
    }

    @SubscribeEvent
    public static void registerCommands(RegisterCommandsEvent event) {
        CommandDispatcher<CommandSourceStack> dispatcher = event.getDispatcher();
        var root = Commands.literal("lostinfinity")
                .requires(source -> source.hasPermission(2));
        var dimension = Commands.literal("dimension");
        for (String id : DIMENSIONS) {
            dimension.then(Commands.literal(id).executes(context -> teleportToDimension(context.getSource(), id)));
        }
        dispatcher.register(root
                .then(dimension)
                .then(clearRiftsCommand())
                .then(clearFracturesCommand())
                .then(setDeviantCommand())
                .then(chargeEssencePossessorCommand()));

        dispatcher.register(clearRiftsCommand());
        dispatcher.register(clearFracturesCommand());
        dispatcher.register(setDeviantCommand());
        dispatcher.register(chargeEssencePossessorCommand());
    }

    private static int teleportToDimension(CommandSourceStack source, String id) throws CommandSyntaxException {
        ServerPlayer player = source.getPlayerOrException();
        if (!LostDimensionTeleporter.teleport(player, id)) {
            source.sendFailure(Component.literal("Dimension is not loaded: " + LostInfinity.MODID + ":" + id));
            return 0;
        }
        source.sendSuccess(() -> Component.literal("Teleported to " + LostInfinity.MODID + ":" + id), true);
        return 1;
    }

    private static com.mojang.brigadier.builder.LiteralArgumentBuilder<CommandSourceStack> clearRiftsCommand() {
        return Commands.literal("clearrifts")
                .requires(source -> source.hasPermission(2))
                .then(Commands.argument("range", IntegerArgumentType.integer(1, 256))
                        .executes(context -> clearRifts(context.getSource(), IntegerArgumentType.getInteger(context, "range"))));
    }

    private static com.mojang.brigadier.builder.LiteralArgumentBuilder<CommandSourceStack> clearFracturesCommand() {
        return Commands.literal("clearfractures")
                .requires(source -> source.hasPermission(2))
                .then(Commands.argument("range", IntegerArgumentType.integer(1, 128))
                        .executes(context -> clearFractures(context.getSource(), IntegerArgumentType.getInteger(context, "range"))));
    }

    private static com.mojang.brigadier.builder.LiteralArgumentBuilder<CommandSourceStack> setDeviantCommand() {
        return Commands.literal("setdeviant")
                .requires(source -> source.hasPermission(2))
                .then(Commands.argument("name", StringArgumentType.word())
                        .executes(context -> setDeviant(context.getSource(), StringArgumentType.getString(context, "name"))));
    }

    private static com.mojang.brigadier.builder.LiteralArgumentBuilder<CommandSourceStack> chargeEssencePossessorCommand() {
        return Commands.literal("chargeep")
                .requires(source -> source.hasPermission(2))
                .executes(context -> chargeEssencePossessor(context.getSource()));
    }

    private static int clearRifts(CommandSourceStack source, int range) throws CommandSyntaxException {
        ServerPlayer player = source.getPlayerOrException();
        AABB area = player.getBoundingBox().inflate(range);
        int cleared = 0;
        for (Entity entity : player.level().getEntities(player, area, LostInfinityCommands::isRiftEntity)) {
            entity.discard();
            cleared++;
        }
        int finalCleared = cleared;
        source.sendSuccess(() -> Component.literal("Rifts cleared: " + finalCleared), true);
        return cleared;
    }

    private static boolean isRiftEntity(Entity entity) {
        ResourceLocation id = entity.getType().builtInRegistryHolder().key().location();
        if (!LostInfinity.MODID.equals(id.getNamespace())) {
            return false;
        }
        String path = id.getPath();
        return path.equals("rift") || path.equals("cthulhu_rift") || path.equals("unstablerift")
                || path.equals("wormholeportal") || path.endsWith("portaleffect") || path.contains("_rift");
    }

    private static int clearFractures(CommandSourceStack source, int range) throws CommandSyntaxException {
        ServerPlayer player = source.getPlayerOrException();
        Level level = player.level();
        BlockPos center = player.blockPosition();
        int cleared = 0;
        for (BlockPos pos : BlockPos.betweenClosed(center.offset(-range, -range, -range), center.offset(range, range, range))) {
            if (level.getBlockState(pos).is(ModBlocks.COSMIC_FRACTURE.get())) {
                level.removeBlock(pos, false);
                cleared++;
            }
        }
        int finalCleared = cleared;
        source.sendSuccess(() -> Component.literal("Fractures cleared: " + finalCleared), true);
        return cleared;
    }

    private static int setDeviant(CommandSourceStack source, String deviantName) throws CommandSyntaxException {
        ServerPlayer player = source.getPlayerOrException();
        ItemStack stack = player.getMainHandItem();
        ResourceLocation itemId = ForgeRegistries.ITEMS.getKey(stack.getItem());
        if (itemId == null || !LostInfinity.MODID.equals(itemId.getNamespace()) || !itemId.getPath().startsWith("branch_of_life")) {
            source.sendFailure(Component.literal("Not holding a compatible item."));
            return 0;
        }
        if (!stack.hasTag()) {
            source.sendFailure(Component.literal("No deviants saved."));
            return 0;
        }
        if (!stack.getOrCreateTag().contains(deviantName)) {
            source.sendFailure(Component.literal("That deviant is not saved."));
            return 0;
        }
        stack.getOrCreateTag().putString("currentdeviant", deviantName);
        player.level().playSound(null, player.blockPosition(), SoundEvents.PLAYER_LEVELUP, SoundSource.PLAYERS, 1.0F, 1.0F);
        source.sendSuccess(() -> Component.literal("Current deviant set to " + deviantName), true);
        return 1;
    }

    private static int chargeEssencePossessor(CommandSourceStack source) throws CommandSyntaxException {
        ServerPlayer player = source.getPlayerOrException();
        int charged = 0;
        if (chargeItem(player.getMainHandItem())) {
            charged++;
        }
        if (chargeItem(player.getOffhandItem())) {
            charged++;
        }
        int finalCharged = charged;
        source.sendSuccess(() -> Component.literal("Essence possessors charged: " + finalCharged), true);
        return charged;
    }

    private static boolean chargeItem(ItemStack stack) {
        if (stack.isEmpty()) {
            return false;
        }
        ResourceLocation itemId = ForgeRegistries.ITEMS.getKey(stack.getItem());
        if (itemId == null || !LostInfinity.MODID.equals(itemId.getNamespace()) || !itemId.getPath().equals("essence_possessor")) {
            return false;
        }
        stack.getOrCreateTag().putInt("essence", 10);
        return true;
    }
}
