/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.buffer.ByteBuf
 *  net.minecraft.network.FriendlyByteBuf
 *  net.minecraftforge.fml.common.network.simpleimpl.IMessage
 *  net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler
 *  net.minecraftforge.fml.common.network.simpleimpl.MessageContext
 */
package xol.lostinfinity.common.packets.clientbound;

import io.netty.buffer.ByteBuf;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import xol.lostinfinity.client.special.ClientMindControlHandler;
import xol.lostinfinity.common.special.CommonMindControlHandler;

public class PacketSetControlled
implements IMessage {
    private CommonMindControlHandler.State state;

    public PacketSetControlled() {
        this.state = CommonMindControlHandler.State.NONE;
    }

    public PacketSetControlled(CommonMindControlHandler.State state) {
        this.state = state;
    }

    public void fromBytes(ByteBuf b) {
        FriendlyByteBuf buf = new FriendlyByteBuf(b);
        this.state = (CommonMindControlHandler.State)buf.func_179257_a(CommonMindControlHandler.State.class);
    }

    public void toBytes(ByteBuf b) {
        FriendlyByteBuf buf = new FriendlyByteBuf(b);
        buf.func_179249_a((Enum)this.state);
    }

    public static class SetControlledPacketHandler
    implements IMessageHandler<PacketSetControlled, IMessage> {
        public IMessage onMessage(PacketSetControlled message, MessageContext ctx) {
            ClientMindControlHandler.INSTANCE.state = message.state;
            return null;
        }
    }
}

