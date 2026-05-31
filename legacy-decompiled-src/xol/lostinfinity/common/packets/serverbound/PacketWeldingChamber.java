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
import xol.lostinfinity.block.tileentity.BlockEntityWeldingChamber;

public class PacketWeldingChamber
implements IMessage {
    private int acetyleneAmount;
    private int x;
    private int y;
    private int z;

    public PacketWeldingChamber() {
    }

    public PacketWeldingChamber(BlockPos blockPos, int acetyleneAmount) {
        this.x = blockPos.func_177958_n();
        this.y = blockPos.func_177956_o();
        this.z = blockPos.func_177952_p();
        this.acetyleneAmount = acetyleneAmount;
    }

    public void fromBytes(ByteBuf buf) {
        this.x = buf.readInt();
        this.y = buf.readInt();
        this.z = buf.readInt();
        this.acetyleneAmount = buf.readInt();
    }

    public void toBytes(ByteBuf buf) {
        buf.writeInt(this.x);
        buf.writeInt(this.y);
        buf.writeInt(this.z);
        buf.writeInt(this.acetyleneAmount);
    }

    public static class WeldingChamberGUIPacketHandler
    implements IMessageHandler<PacketWeldingChamber, IMessage> {
        public IMessage onMessage(PacketWeldingChamber message, MessageContext ctx) {
            ServerPlayer player = ctx.getServerHandler().field_147369_b;
            Level world = player.field_70170_p;
            player.func_71121_q().func_152344_a(() -> {
                BlockEntity tileEntity = world.func_175625_s(new BlockPos(message.x, message.y, message.z));
                if (tileEntity instanceof BlockEntityWeldingChamber) {
                    ((BlockEntityWeldingChamber)tileEntity).func_174885_b(2, message.acetyleneAmount);
                }
            });
            return null;
        }
    }
}

