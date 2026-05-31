/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.buffer.ByteBuf
 *  net.minecraft.entity.player.ServerPlayer
 *  net.minecraftforge.fml.common.network.simpleimpl.IMessage
 *  net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler
 *  net.minecraftforge.fml.common.network.simpleimpl.MessageContext
 */
package xol.lostinfinity.common.packets.serverbound;

import io.netty.buffer.ByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class PacketDismount
implements IMessage {
    public void toBytes(ByteBuf buf) {
    }

    public void fromBytes(ByteBuf buf) {
    }

    public static class DismountPacketHandler
    implements IMessageHandler<PacketDismount, IMessage> {
        public IMessage onMessage(PacketDismount message, MessageContext ctx) {
            ServerPlayer player = ctx.getServerHandler().field_147369_b;
            player.func_71121_q().func_152344_a(() -> ((ServerPlayer)player).func_184210_p());
            return null;
        }
    }
}

