package xol.lostinfinity.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import xol.lostinfinity.LostInfinity;

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
        dispatcher.register(root.then(dimension));
    }

    private static int teleportToDimension(CommandSourceStack source, String id) throws CommandSyntaxException {
        ServerPlayer player = source.getPlayerOrException();
        ResourceKey<Level> key = ResourceKey.create(Registries.DIMENSION, new ResourceLocation(LostInfinity.MODID, id));
        ServerLevel target = source.getServer().getLevel(key);
        if (target == null) {
            source.sendFailure(Component.literal("Dimension is not loaded: " + LostInfinity.MODID + ":" + id));
            return 0;
        }
        double x = player.getX();
        double y = Math.max(target.getMinBuildHeight() + 4.0D, Math.min(player.getY(), target.getMaxBuildHeight() - 4.0D));
        double z = player.getZ();
        player.teleportTo(target, x, y, z, player.getYRot(), player.getXRot());
        source.sendSuccess(() -> Component.literal("Teleported to " + LostInfinity.MODID + ":" + id), true);
        return 1;
    }
}
