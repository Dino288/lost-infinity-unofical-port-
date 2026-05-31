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
import xol.lostinfinity.block.tileentity.BlockEntityChemistryTable;

public class PacketChemistryTable
implements IMessage {
    private int field;
    private int value;
    private int x;
    private int y;
    private int z;

    public PacketChemistryTable() {
    }

    public PacketChemistryTable(BlockPos pos, int field, int value) {
        this.field = field;
        this.value = value;
        this.x = pos.func_177958_n();
        this.y = pos.func_177956_o();
        this.z = pos.func_177952_p();
    }

    public void fromBytes(ByteBuf buf) {
        this.x = buf.readInt();
        this.y = buf.readInt();
        this.z = buf.readInt();
        this.field = buf.readInt();
        this.value = buf.readInt();
    }

    public void toBytes(ByteBuf buf) {
        buf.writeInt(this.x);
        buf.writeInt(this.y);
        buf.writeInt(this.z);
        buf.writeInt(this.field);
        buf.writeInt(this.value);
    }

    public static class ChemistryTableGUIPacketHandler
    implements IMessageHandler<PacketChemistryTable, IMessage> {
        public IMessage onMessage(PacketChemistryTable message, MessageContext ctx) {
            ServerPlayer player = ctx.getServerHandler().field_147369_b;
            Level world = player.field_70170_p;
            player.func_71121_q().func_152344_a(() -> {
                BlockEntity tileEntity = world.func_175625_s(new BlockPos(message.x, message.y, message.z));
                if (tileEntity instanceof BlockEntityChemistryTable) {
                    ((BlockEntityChemistryTable)tileEntity).func_174885_b(message.field, message.value);
                    if (message.field != 9) {
                        ((BlockEntityChemistryTable)tileEntity).func_174885_b(9, ((BlockEntityChemistryTable)tileEntity).func_174887_a_(9) + 1);
                    }
                }
            });
            return null;
        }
    }
}

