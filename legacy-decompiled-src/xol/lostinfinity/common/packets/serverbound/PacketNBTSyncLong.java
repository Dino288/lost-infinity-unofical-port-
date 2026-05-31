/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.buffer.ByteBuf
 *  net.minecraft.item.ItemStack
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.network.FriendlyByteBuf
 *  net.minecraftforge.fml.common.network.simpleimpl.IMessage
 *  net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler
 *  net.minecraftforge.fml.common.network.simpleimpl.MessageContext
 */
package xol.lostinfinity.common.packets.serverbound;

import io.netty.buffer.ByteBuf;
import java.io.IOException;
import net.minecraft.world.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class PacketNBTSyncLong
implements IMessage {
    private String key;
    private long value;
    private ItemStack stack;

    public PacketNBTSyncLong() {
    }

    public PacketNBTSyncLong(String nbtKey, long nbtValue, ItemStack adjustedStack) {
        this.key = nbtKey;
        this.value = nbtValue;
        this.stack = adjustedStack;
    }

    public void toBytes(ByteBuf buf) {
        FriendlyByteBuf modifiedBuffer = new FriendlyByteBuf(buf);
        modifiedBuffer.func_180714_a(this.key);
        modifiedBuffer.func_150788_a(this.stack);
        buf.writeLong(this.value);
    }

    public void fromBytes(ByteBuf buf) {
        FriendlyByteBuf modifiedBuffer = new FriendlyByteBuf(buf);
        this.key = modifiedBuffer.func_150789_c(20);
        try {
            this.stack = modifiedBuffer.func_150791_c();
        }
        catch (IOException iOException) {
            // empty catch block
        }
        this.value = buf.readLong();
    }

    public static class PacketNBTSyncLongHandler
    implements IMessageHandler<PacketNBTSyncLong, IMessage> {
        public IMessage onMessage(PacketNBTSyncLong message, MessageContext ctx) {
            ItemStack stack = message.stack;
            if (!stack.func_77942_o()) {
                stack.func_77982_d(new CompoundTag());
            }
            stack.func_77978_p().func_74772_a(message.key, message.value);
            return null;
        }
    }
}

