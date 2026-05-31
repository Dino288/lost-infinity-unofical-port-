package xol.lostinfinity.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import xol.lostinfinity.dimension.LostDimensionTeleporter;
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
        if (!LostDimensionTeleporter.teleport(player, id)) {
            source.sendFailure(Component.literal("Dimension is not loaded: " + LostInfinity.MODID + ":" + id));
            return 0;
        }
        source.sendSuccess(() -> Component.literal("Teleported to " + LostInfinity.MODID + ":" + id), true);
        return 1;
    }
}
