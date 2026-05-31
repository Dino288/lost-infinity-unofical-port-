/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.buffer.ByteBuf
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.ServerPlayer
 *  net.minecraft.world.World
 *  net.minecraftforge.fml.common.network.simpleimpl.IMessage
 *  net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler
 *  net.minecraftforge.fml.common.network.simpleimpl.MessageContext
 */
package xol.lostinfinity.common.packets.serverbound;

import io.netty.buffer.ByteBuf;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import xol.lostinfinity.mob.entity.cthulhu.EntityCthulhu;

public class PacketCthulhuBarrier
implements IMessage {
    private int flag;
    private int value;
    private int entityID;

    public PacketCthulhuBarrier() {
    }

    public PacketCthulhuBarrier(int flag, int value, int entityID) {
        this.flag = flag;
        this.value = value;
        this.entityID = entityID;
    }

    public void fromBytes(ByteBuf buf) {
        this.flag = buf.readInt();
        this.value = buf.readInt();
        this.entityID = buf.readInt();
    }

    public void toBytes(ByteBuf buf) {
        buf.writeInt(this.flag);
        buf.writeInt(this.value);
        buf.writeInt(this.entityID);
    }

    public static class CthulhuBarrierPacketHandler
    implements IMessageHandler<PacketCthulhuBarrier, IMessage> {
        public IMessage onMessage(PacketCthulhuBarrier message, MessageContext ctx) {
            ServerPlayer player = ctx.getServerHandler().field_147369_b;
            Level world = player.field_70170_p;
            player.func_71121_q().func_152344_a(() -> {
                Entity entity = world.func_73045_a(message.entityID);
                if (entity instanceof EntityCthulhu) {
                    EntityCthulhu cthulhu = (EntityCthulhu)entity;
                    switch (message.flag) {
                        case 1: {
                            cthulhu.setBarrierCd1(message.value);
                            break;
                        }
                        case 2: {
                            cthulhu.setBarrierCd2(message.value);
                            break;
                        }
                        case 3: {
                            cthulhu.setBarrierCd3(message.value);
                            break;
                        }
                        case 4: {
                            cthulhu.setBarrierCd4(message.value);
                            break;
                        }
                        case 5: {
                            cthulhu.setAllBarrierCd(message.value);
                        }
                    }
                }
            });
            return null;
        }
    }
}

