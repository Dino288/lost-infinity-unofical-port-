/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.buffer.Unpooled
 *  io.netty.channel.ChannelDuplexHandler
 *  io.netty.channel.ChannelHandlerContext
 *  io.netty.channel.ChannelPromise
 *  net.minecraft.entity.Entity
 *  net.minecraft.network.NetHandlerPlayServer
 *  net.minecraft.network.FriendlyByteBuf
 *  net.minecraft.network.play.client.CPacketInput
 */
package xol.lostinfinity.common.packets;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelDuplexHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.NetHandlerPlayServer;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.play.client.CPacketInput;
import xol.lostinfinity.mob.entity.base.EntityMultipleLivesMount;

public class LostInfinityPacketListener
extends ChannelDuplexHandler {
    private final NetHandlerPlayServer connection;

    public LostInfinityPacketListener(NetHandlerPlayServer connection) {
        this.connection = connection;
    }

    public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
        super.write(ctx, msg, promise);
    }

    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        if (msg instanceof CPacketInput) {
            Entity mount;
            CPacketInput input = (CPacketInput)msg;
            FriendlyByteBuf buf = new FriendlyByteBuf(Unpooled.buffer());
            buf.writeFloat(input.func_149620_c());
            buf.writeFloat(input.func_192620_b());
            byte flags = 0;
            if (input.func_149618_e()) {
                flags = (byte)(flags | 1);
            }
            if (input.func_149617_f() && !((mount = this.connection.field_147369_b.func_184208_bv()) instanceof EntityMultipleLivesMount)) {
                flags = (byte)(flags | 2);
            }
            buf.writeByte((int)flags);
            input.func_148837_a(buf);
        }
        super.channelRead(ctx, msg);
    }
}

