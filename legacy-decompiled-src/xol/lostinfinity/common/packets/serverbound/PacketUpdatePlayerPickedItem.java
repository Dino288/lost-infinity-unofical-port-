/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.buffer.ByteBuf
 *  net.minecraft.entity.player.Player
 *  net.minecraft.entity.player.ServerPlayer
 *  net.minecraft.item.ItemStack
 *  net.minecraft.network.FriendlyByteBuf
 *  net.minecraftforge.fml.common.network.simpleimpl.IMessage
 *  net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler
 *  net.minecraftforge.fml.common.network.simpleimpl.MessageContext
 */
package xol.lostinfinity.common.packets.serverbound;

import io.netty.buffer.ByteBuf;
import java.io.IOException;
import net.minecraft.world.entity.player.Player;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class PacketUpdatePlayerPickedItem
implements IMessage {
    private int targetId;
    private ItemStack stack;

    public PacketUpdatePlayerPickedItem() {
    }

    public PacketUpdatePlayerPickedItem(int targetId, ItemStack stack) {
        this.targetId = targetId;
        this.stack = stack;
    }

    public void fromBytes(ByteBuf buf) {
        FriendlyByteBuf buffer = new FriendlyByteBuf(buf);
        this.targetId = buffer.func_150792_a();
        try {
            this.stack = buffer.func_150791_c();
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void toBytes(ByteBuf buf) {
        FriendlyByteBuf buffer = new FriendlyByteBuf(buf);
        buffer.func_150787_b(this.targetId);
        buffer.func_150788_a(this.stack);
    }

    public static class UpdatePlayerPickedItemPacketHandler
    implements IMessageHandler<PacketUpdatePlayerPickedItem, IMessage> {
        public IMessage onMessage(PacketUpdatePlayerPickedItem message, MessageContext ctx) {
            ServerPlayer serverPlayer = ctx.getServerHandler().field_147369_b;
            Player target = (Player)serverPlayer.field_70170_p.func_73045_a(message.targetId);
            target.field_71071_by.func_70437_b(message.stack);
            return null;
        }
    }
}

