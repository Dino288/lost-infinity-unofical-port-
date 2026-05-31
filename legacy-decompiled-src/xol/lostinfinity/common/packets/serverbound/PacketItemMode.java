/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.buffer.ByteBuf
 *  net.minecraft.entity.player.Player
 *  net.minecraft.entity.player.ServerPlayer
 *  net.minecraft.item.ItemStack
 *  net.minecraftforge.fml.common.network.simpleimpl.IMessage
 *  net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler
 *  net.minecraftforge.fml.common.network.simpleimpl.MessageContext
 */
package xol.lostinfinity.common.packets.serverbound;

import io.netty.buffer.ByteBuf;
import net.minecraft.world.entity.player.Player;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import xol.lostinfinity.item.classify.IModeSelect;

public class PacketItemMode
implements IMessage {
    public void toBytes(ByteBuf buf) {
    }

    public void fromBytes(ByteBuf buf) {
    }

    public static class ItemModePacketHandler
    implements IMessageHandler<PacketItemMode, IMessage> {
        public IMessage onMessage(PacketItemMode message, MessageContext ctx) {
            ServerPlayer player = ctx.getServerHandler().field_147369_b;
            ItemStack stack = player.func_184614_ca();
            player.func_71121_q().func_152344_a(() -> {
                if (stack.func_77973_b() instanceof IModeSelect) {
                    IModeSelect mode_item = (IModeSelect)stack.func_77973_b();
                    mode_item.modeUpdate(stack, (Player)player);
                }
            });
            return null;
        }
    }
}

