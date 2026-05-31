/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.buffer.ByteBuf
 *  net.minecraft.client.Minecraft
 *  net.minecraft.entity.Entity
 *  net.minecraft.network.FriendlyByteBuf
 *  net.minecraftforge.fml.common.network.simpleimpl.IMessage
 *  net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler
 *  net.minecraftforge.fml.common.network.simpleimpl.MessageContext
 */
package xol.lostinfinity.common.packets.clientbound;

import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import xol.lostinfinity.mob.entity.classify.ILostMultiPart;
import xol.lostinfinity.mob.entity.classify.IRelay;

public class PacketSyncParts
implements IMessage {
    private int parentId;
    private int partId;
    private double posX;
    private double posY;
    private double posZ;
    private float yaw;
    private float pitch;

    public PacketSyncParts() {
    }

    public PacketSyncParts(IRelay<?> part) {
        this.parentId = part.getRelay().func_145782_y();
        this.partId = part.getId();
        this.posX = part.getX();
        this.posY = part.getY();
        this.posZ = part.getZ();
        this.yaw = part.getYaw();
        this.pitch = part.getPitch();
    }

    public void fromBytes(ByteBuf b) {
        FriendlyByteBuf buf = new FriendlyByteBuf(b);
        this.parentId = buf.func_150792_a();
        this.partId = buf.func_150792_a();
        this.posX = buf.readDouble();
        this.posY = buf.readDouble();
        this.posZ = buf.readDouble();
        this.yaw = buf.readFloat();
        this.pitch = buf.readFloat();
    }

    public void toBytes(ByteBuf b) {
        FriendlyByteBuf buf = new FriendlyByteBuf(b);
        buf.func_150787_b(this.parentId);
        buf.func_150787_b(this.partId);
        buf.writeDouble(this.posX);
        buf.writeDouble(this.posY);
        buf.writeDouble(this.posZ);
        buf.writeFloat(this.yaw);
        buf.writeFloat(this.pitch);
    }

    public static class SyncPartsPacketHandler
    implements IMessageHandler<PacketSyncParts, IMessage> {
        public IMessage onMessage(PacketSyncParts message, MessageContext ctx) {
            Entity part;
            Entity[] parts;
            Entity main = Minecraft.func_71410_x().field_71441_e.func_73045_a(message.parentId);
            if (main instanceof ILostMultiPart && (parts = main.func_70021_al()) != null && message.partId < parts.length && (part = parts[message.partId]) instanceof IRelay) {
                ((IRelay)part).setPos(message.posX, message.posY, message.posZ, message.yaw, message.pitch);
            }
            return null;
        }
    }
}

