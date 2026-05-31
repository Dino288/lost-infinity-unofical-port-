/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.buffer.ByteBuf
 *  net.minecraft.entity.player.Player
 *  net.minecraft.network.FriendlyByteBuf
 *  net.minecraft.util.math.Vec3
 *  net.minecraftforge.fml.common.network.simpleimpl.IMessage
 *  net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler
 *  net.minecraftforge.fml.common.network.simpleimpl.MessageContext
 */
package xol.lostinfinity.common.packets.clientbound;

import io.netty.buffer.ByteBuf;
import java.util.UUID;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import xol.lostinfinity.client.screen.HeadHunterVision;

public class PacketHeadHunterUpdate
implements IMessage {
    private UUID id;
    private float x;
    private float y;
    private float z;

    public PacketHeadHunterUpdate() {
    }

    public PacketHeadHunterUpdate(Player target) {
        this.id = target.func_110124_au();
        this.x = (float)target.field_70165_t;
        this.y = (float)target.field_70163_u;
        this.z = (float)target.field_70161_v;
    }

    public void fromBytes(ByteBuf b) {
        FriendlyByteBuf buf = new FriendlyByteBuf(b);
        this.id = buf.func_179253_g();
        this.x = buf.readFloat();
        this.y = buf.readFloat();
        this.z = buf.readFloat();
    }

    public void toBytes(ByteBuf b) {
        FriendlyByteBuf buf = new FriendlyByteBuf(b);
        buf.func_179252_a(this.id);
        buf.writeFloat(this.x);
        buf.writeFloat(this.y);
        buf.writeFloat(this.z);
    }

    public static class HeadHunterUpdatePacketHandler
    implements IMessageHandler<PacketHeadHunterUpdate, IMessage> {
        public IMessage onMessage(PacketHeadHunterUpdate message, MessageContext ctx) {
            HeadHunterVision.oorPlayer.put(message.id, new Vec3((double)message.x, (double)message.y, (double)message.z));
            return null;
        }
    }
}

