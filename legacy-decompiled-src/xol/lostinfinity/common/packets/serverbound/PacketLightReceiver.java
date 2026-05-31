/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.buffer.ByteBuf
 *  net.minecraft.entity.player.ServerPlayer
 *  net.minecraft.tileentity.BlockEntity
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.world.World
 *  net.minecraftforge.fml.common.network.simpleimpl.IMessage
 *  net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler
 *  net.minecraftforge.fml.common.network.simpleimpl.MessageContext
 */
package xol.lostinfinity.common.packets.serverbound;

import io.netty.buffer.ByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import xol.lostinfinity.block.tileentity.BlockEntityLightEmitter;

public class PacketLightReceiver
implements IMessage {
    private boolean complete;
    private int x;
    private int y;
    private int z;
    private boolean active;

    public PacketLightReceiver() {
    }

    public PacketLightReceiver(boolean complete, int x, int y, int z) {
        this.complete = complete;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public void toBytes(ByteBuf buf) {
        buf.writeBoolean(this.complete);
        buf.writeInt(this.x);
        buf.writeInt(this.y);
        buf.writeInt(this.z);
    }

    public void fromBytes(ByteBuf buf) {
        this.complete = buf.readBoolean();
        this.x = buf.readInt();
        this.y = buf.readInt();
        this.z = buf.readInt();
    }

    public static class LightReceiverPacketHandler
    implements IMessageHandler<PacketLightReceiver, IMessage> {
        public IMessage onMessage(PacketLightReceiver message, MessageContext ctx) {
            ServerPlayer player = ctx.getServerHandler().field_147369_b;
            Level world = player.field_70170_p;
            player.func_71121_q().func_152344_a(() -> {
                int z;
                int y;
                int x = message.x;
                BlockEntity te = player.field_70170_p.func_175625_s(new BlockPos(x, y = message.y, z = message.z));
                if (te instanceof BlockEntityLightEmitter) {
                    ((BlockEntityLightEmitter)te).setComplete(message.complete);
                }
            });
            return null;
        }
    }
}

