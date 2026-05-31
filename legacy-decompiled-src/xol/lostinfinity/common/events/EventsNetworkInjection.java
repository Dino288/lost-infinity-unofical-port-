/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.channel.Channel
 *  io.netty.channel.ChannelHandler
 *  io.netty.channel.ChannelPipeline
 *  net.minecraft.entity.player.ServerPlayer
 *  net.minecraft.network.NetHandlerPlayServer
 *  net.minecraft.network.NetworkManager
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 *  net.minecraftforge.fml.common.gameevent.PlayerEvent$PlayerLoggedInEvent
 *  net.minecraftforge.fml.common.gameevent.PlayerEvent$PlayerLoggedOutEvent
 */
package xol.lostinfinity.common.events;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelPipeline;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.NetHandlerPlayServer;
import net.minecraft.network.NetworkManager;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;
import xol.lostinfinity.common.packets.LostInfinityPacketListener;

public class EventsNetworkInjection {
    public static final String LISTENER = "lost_infinity_packet_listener";

    @SubscribeEvent
    public void onClientDisconnect(PlayerEvent.PlayerLoggedOutEvent event) {
        if (event.player instanceof ServerPlayer) {
            NetHandlerPlayServer connection = ((ServerPlayer)event.player).field_71135_a;
            if (connection == null) {
                return;
            }
            Channel channel = connection.field_147371_a.channel();
            channel.eventLoop().submit(() -> {
                channel.pipeline().remove(LISTENER);
                return null;
            });
        }
    }

    @SubscribeEvent
    public void onClientConnect(PlayerEvent.PlayerLoggedInEvent event) {
        if (event.player instanceof ServerPlayer) {
            NetHandlerPlayServer connection = ((ServerPlayer)event.player).field_71135_a;
            ChannelPipeline pipeline = connection.field_147371_a.channel().pipeline();
            LostInfinityPacketListener listener = new LostInfinityPacketListener(connection);
            for (String name : pipeline.toMap().keySet()) {
                if (!(pipeline.get(name) instanceof NetworkManager)) continue;
                pipeline.addBefore(name, LISTENER, (ChannelHandler)listener);
                break;
            }
        }
    }
}

