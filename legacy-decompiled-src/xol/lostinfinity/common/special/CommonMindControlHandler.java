/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.player.Player
 *  net.minecraft.entity.player.ServerPlayer
 *  net.minecraft.util.EnumInteractionResultHolder
 *  net.minecraftforge.event.entity.player.PlayerInteractEvent
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 *  net.minecraftforge.fml.common.gameevent.PlayerEvent$PlayerLoggedOutEvent
 */
package xol.lostinfinity.common.special;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import net.minecraft.world.entity.player.Player;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.EnumInteractionResultHolder;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;
import xol.lostinfinity.common.lostinfinity;
import xol.lostinfinity.common.packets.clientbound.PacketSetControlled;

public class CommonMindControlHandler {
    public static CommonMindControlHandler INSTANCE;
    private final Map<UUID, Player> puppeteers = new ConcurrentHashMap<UUID, Player>();
    private final Map<UUID, Player> controlled = new ConcurrentHashMap<UUID, Player>();

    public CommonMindControlHandler() {
        INSTANCE = this;
    }

    @SubscribeEvent
    public void onClientDisconnect(PlayerEvent.PlayerLoggedOutEvent event) {
        CommonMindControlHandler.onDisconnect(event.player);
    }

    @SubscribeEvent
    public void onRightClick(PlayerInteractEvent event) {
        if (this.controlled.containsKey(event.getPlayer().func_110124_au())) {
            event.setCancellationResult(EnumInteractionResultHolder.PASS);
            if (event.isCancelable()) {
                event.setCanceled(true);
            }
        }
    }

    public static void registerPair(Player puppeteer, Player target) {
        CommonMindControlHandler.INSTANCE.puppeteers.put(puppeteer.func_110124_au(), target);
        CommonMindControlHandler.INSTANCE.controlled.put(target.func_110124_au(), puppeteer);
    }

    public static void unregisterPair(Player puppeteer, Player target) {
        CommonMindControlHandler.INSTANCE.puppeteers.remove(puppeteer.func_110124_au());
        CommonMindControlHandler.INSTANCE.controlled.remove(target.func_110124_au());
    }

    public static void onDisconnect(Player disconnected) {
        Player player = CommonMindControlHandler.removeControllerOfPlayer(disconnected.func_110124_au());
        if (player != null) {
            lostinfinity.instance.packetHandler.sendToPlayer((ServerPlayer)player, new PacketSetControlled());
        }
        if ((player = CommonMindControlHandler.removeTargetOfPlayer(disconnected.func_110124_au())) != null) {
            lostinfinity.instance.packetHandler.sendToPlayer((ServerPlayer)player, new PacketSetControlled());
        }
    }

    public static Player getTargetOfPlayer(Player player) {
        return CommonMindControlHandler.getTargetOfPlayer(player.func_110124_au());
    }

    public static Player getTargetOfPlayer(UUID uuid) {
        return CommonMindControlHandler.INSTANCE.puppeteers.get(uuid);
    }

    public static Player removeTargetOfPlayer(Player player) {
        return CommonMindControlHandler.removeTargetOfPlayer(player.func_110124_au());
    }

    public static Player removeTargetOfPlayer(UUID uuid) {
        return CommonMindControlHandler.INSTANCE.puppeteers.remove(uuid);
    }

    public static Player getControllerOfPlayer(Player player) {
        return CommonMindControlHandler.getControllerOfPlayer(player.func_110124_au());
    }

    public static Player getControllerOfPlayer(UUID uuid) {
        return CommonMindControlHandler.INSTANCE.controlled.get(uuid);
    }

    public static Player removeControllerOfPlayer(Player player) {
        return CommonMindControlHandler.removeControllerOfPlayer(player.func_110124_au());
    }

    public static Player removeControllerOfPlayer(UUID uuid) {
        return CommonMindControlHandler.INSTANCE.controlled.remove(uuid);
    }

    public static enum State {
        NONE,
        CONTROLLED,
        CONTROLLING;

    }
}

