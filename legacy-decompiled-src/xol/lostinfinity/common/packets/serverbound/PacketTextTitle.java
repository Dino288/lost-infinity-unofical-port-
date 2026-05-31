/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.buffer.ByteBuf
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.server.SPacketTitle
 *  net.minecraft.network.play.server.SPacketTitle$Type
 *  net.minecraft.util.text.Component
 *  net.minecraft.util.text.Component
 *  net.minecraftforge.fml.common.network.simpleimpl.IMessage
 *  net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler
 *  net.minecraftforge.fml.common.network.simpleimpl.MessageContext
 */
package xol.lostinfinity.common.packets.serverbound;

import io.netty.buffer.ByteBuf;
import java.nio.charset.Charset;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.SPacketTitle;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Component;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class PacketTextTitle
implements IMessage {
    private boolean title;
    private boolean subtitle;
    private int fadeIn;
    private int fadeOut;
    private int timeUntilFade;
    private String message;

    public PacketTextTitle() {
    }

    public PacketTextTitle(boolean title, boolean subtitle, int timeUntilFade, int fadeIn, int fadeOut, String message) {
        this.title = title;
        this.subtitle = subtitle;
        this.fadeIn = fadeIn;
        this.fadeOut = fadeOut;
        this.timeUntilFade = timeUntilFade;
        this.message = message;
    }

    public void toBytes(ByteBuf buf) {
        buf.writeBoolean(this.title);
        buf.writeBoolean(this.subtitle);
        buf.writeInt(this.fadeIn);
        buf.writeInt(this.fadeOut);
        buf.writeInt(this.timeUntilFade);
        buf.writeInt(this.message.length());
        buf.writeCharSequence((CharSequence)this.message, Charset.defaultCharset());
    }

    public void fromBytes(ByteBuf buf) {
        this.title = buf.readBoolean();
        this.subtitle = buf.readBoolean();
        this.fadeIn = buf.readInt();
        this.fadeOut = buf.readInt();
        this.timeUntilFade = buf.readInt();
        int msgLength = buf.readInt();
        this.message = String.valueOf(buf.readCharSequence(msgLength, Charset.defaultCharset()));
    }

    public static class TitlePacketHandler
    implements IMessageHandler<PacketTextTitle, IMessage> {
        public IMessage onMessage(PacketTextTitle message, MessageContext ctx) {
            SPacketTitle.Type titleType = message.title ? SPacketTitle.Type.TITLE : (message.subtitle ? SPacketTitle.Type.SUBTITLE : SPacketTitle.Type.ACTIONBAR);
            ctx.getServerHandler().field_147369_b.field_71135_a.func_147359_a((Packet)new SPacketTitle(titleType, (Component)new Component(message.message), message.fadeIn, message.timeUntilFade, message.fadeOut));
            return null;
        }
    }
}

