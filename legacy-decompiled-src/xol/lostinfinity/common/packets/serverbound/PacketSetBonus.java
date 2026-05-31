/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.buffer.ByteBuf
 *  net.minecraft.entity.player.ServerPlayer
 *  net.minecraft.item.ItemStack
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.util.SoundSource
 *  net.minecraft.util.text.Component
 *  net.minecraft.util.text.Component
 *  net.minecraftforge.fml.common.network.simpleimpl.IMessage
 *  net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler
 *  net.minecraftforge.fml.common.network.simpleimpl.MessageContext
 */
package xol.lostinfinity.common.packets.serverbound;

import io.netty.buffer.ByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundSource;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Component;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.SoundInit;

public class PacketSetBonus
implements IMessage {
    public void toBytes(ByteBuf buf) {
    }

    public void fromBytes(ByteBuf buf) {
    }

    public static class SetBonusPacketHandler
    implements IMessageHandler<PacketSetBonus, IMessage> {
        public IMessage onMessage(PacketSetBonus message, MessageContext ctx) {
            ServerPlayer player = ctx.getServerHandler().field_147369_b;
            ItemStack helmet = (ItemStack)player.field_71071_by.field_70460_b.get(3);
            player.func_71121_q().func_152344_a(() -> {
                CompoundTag tag;
                if (helmet.func_77978_p() == null) {
                    helmet.func_77982_d(new CompoundTag());
                }
                if ((tag = helmet.func_77978_p()).func_74764_b("setBonus")) {
                    tag.func_74757_a("setBonus", !tag.func_74767_n("setBonus"));
                } else {
                    tag.func_74757_a("setBonus", false);
                }
                boolean enabled = tag.func_74767_n("setBonus");
                player.func_145747_a((Component)new Component(enabled ? (Object)((Object)TextFmt.Green) + "Set Effect enabled" : (Object)((Object)TextFmt.Red) + "Set Effect disabled"));
                player.field_70170_p.func_184133_a(null, player.func_180425_c(), enabled ? SoundInit.ARMOR_ACTIVATE : SoundInit.ARMOR_DEACTIVATE, SoundSource.MASTER, 1.0f, 1.0f);
            });
            return null;
        }
    }
}

