/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.buffer.ByteBuf
 *  net.minecraft.entity.player.Player
 *  net.minecraft.entity.player.ServerPlayer
 *  net.minecraft.network.FriendlyByteBuf
 *  net.minecraftforge.fml.common.network.simpleimpl.IMessage
 *  net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler
 *  net.minecraftforge.fml.common.network.simpleimpl.MessageContext
 */
package xol.lostinfinity.common.packets;

import io.netty.buffer.ByteBuf;
import net.minecraft.world.entity.player.Player;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import xol.lostinfinity.client.special.ClientMindControlHandler;
import xol.lostinfinity.common.lostinfinity;
import xol.lostinfinity.common.special.CommonMindControlHandler;

public class PacketSendInput
implements IMessage {
    private float forward;
    private float side;
    private boolean jump;
    private boolean sneak;

    public PacketSendInput() {
    }

    public PacketSendInput(float forward, float side, boolean jump, boolean sneak) {
        this.forward = forward;
        this.side = side;
        this.jump = jump;
        this.sneak = sneak;
    }

    public void fromBytes(ByteBuf b) {
        FriendlyByteBuf buf = new FriendlyByteBuf(b);
        this.forward = buf.readFloat();
        this.side = buf.readFloat();
        this.jump = buf.readBoolean();
        this.sneak = buf.readBoolean();
    }

    public void toBytes(ByteBuf b) {
        FriendlyByteBuf buf = new FriendlyByteBuf(b);
        buf.writeFloat(this.forward);
        buf.writeFloat(this.side);
        buf.writeBoolean(this.jump);
        buf.writeBoolean(this.sneak);
    }

    public static class SendInputPacketHandler
    implements IMessageHandler<PacketSendInput, IMessage> {
        public IMessage onMessage(PacketSendInput message, MessageContext ctx) {
            switch (ctx.side) {
                case CLIENT: {
                    ClientMindControlHandler.INSTANCE.lastForward = message.forward;
                    ClientMindControlHandler.INSTANCE.lastStrafe = message.side;
                    ClientMindControlHandler.INSTANCE.lastJump = message.jump;
                    ClientMindControlHandler.INSTANCE.lastSneak = message.sneak;
                    break;
                }
                case SERVER: {
                    ServerPlayer player = ctx.getServerHandler().field_147369_b;
                    Player target = CommonMindControlHandler.getTargetOfPlayer((Player)player);
                    if (target == null) break;
                    lostinfinity.instance.packetHandler.sendToPlayer((ServerPlayer)target, message);
                    break;
                }
            }
            return null;
        }
    }
}

