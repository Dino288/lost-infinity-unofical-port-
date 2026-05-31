/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.buffer.ByteBuf
 *  net.minecraft.client.Minecraft
 *  net.minecraft.item.ItemStack
 *  net.minecraft.network.FriendlyByteBuf
 *  net.minecraftforge.fml.common.network.simpleimpl.IMessage
 *  net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler
 *  net.minecraftforge.fml.common.network.simpleimpl.MessageContext
 */
package xol.lostinfinity.common.packets.clientbound;

import io.netty.buffer.ByteBuf;
import java.io.IOException;
import net.minecraft.client.Minecraft;
import net.minecraft.world.item.ItemStack;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import xol.lostinfinity.mob.entity.misc.EntitySupplyTrader;

public class PacketSupplyInventoryClient
implements IMessage {
    private int sourceId;
    private int slot;
    private ItemStack stack;

    public PacketSupplyInventoryClient() {
    }

    public PacketSupplyInventoryClient(int sourceId, int slot, ItemStack stack) {
        this.sourceId = sourceId;
        this.slot = slot;
        this.stack = stack;
    }

    public void fromBytes(ByteBuf b) {
        FriendlyByteBuf buf = new FriendlyByteBuf(b);
        this.sourceId = buf.func_150792_a();
        this.slot = buf.func_150792_a();
        try {
            this.stack = buf.func_150791_c();
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void toBytes(ByteBuf b) {
        FriendlyByteBuf buf = new FriendlyByteBuf(b);
        buf.func_150787_b(this.sourceId);
        buf.func_150787_b(this.slot);
        buf.func_150788_a(this.stack);
    }

    public static class SupplyInventoryClientPacketHandler
    implements IMessageHandler<PacketSupplyInventoryClient, IMessage> {
        public IMessage onMessage(PacketSupplyInventoryClient message, MessageContext ctx) {
            EntitySupplyTrader trader = (EntitySupplyTrader)Minecraft.func_71410_x().field_71441_e.func_73045_a(message.sourceId);
            trader.setInventorySlotContents(message.slot, message.stack);
            return null;
        }
    }
}

