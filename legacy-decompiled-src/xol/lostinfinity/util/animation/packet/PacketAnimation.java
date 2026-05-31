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
package xol.lostinfinity.util.animation.packet;

import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import xol.lostinfinity.util.animation.client.AnimationHandler;
import xol.lostinfinity.util.animation.client.blueprint.LoopMode;
import xol.lostinfinity.util.animation.entity.IXolAnimated;

public class PacketAnimation
implements IMessage {
    private int entityId;
    private String animation;
    private int add;
    private float speed;
    private LoopMode mode;
    private boolean isOverride;

    public PacketAnimation() {
    }

    public PacketAnimation(IXolAnimated animated, String animation) {
        this.entityId = animated.getEntity().func_145782_y();
        this.animation = animation;
        this.add = 0;
    }

    public PacketAnimation(IXolAnimated animated, String animation, float speed) {
        this.entityId = animated.getEntity().func_145782_y();
        this.animation = animation;
        this.add = 1;
        this.speed = speed;
    }

    public PacketAnimation(IXolAnimated animated, String animation, LoopMode mode, boolean isOverride, float speed) {
        this.entityId = ((Entity)animated).func_145782_y();
        this.animation = animation;
        this.add = 2;
        this.mode = mode;
        this.isOverride = isOverride;
        this.speed = speed;
    }

    public void fromBytes(ByteBuf b) {
        FriendlyByteBuf buf = new FriendlyByteBuf(b);
        this.entityId = buf.func_150792_a();
        this.animation = buf.func_150789_c(40);
        this.add = buf.func_150792_a();
        if (this.add > 0) {
            this.speed = buf.readFloat();
        }
        if (this.add == 2) {
            this.mode = (LoopMode)buf.func_179257_a(LoopMode.class);
            this.isOverride = buf.readBoolean();
        }
    }

    public void toBytes(ByteBuf b) {
        FriendlyByteBuf buf = new FriendlyByteBuf(b);
        buf.func_150787_b(this.entityId);
        buf.func_180714_a(this.animation);
        buf.func_150787_b(this.add);
        if (this.add > 0) {
            buf.writeFloat(this.speed);
        }
        if (this.add == 2) {
            buf.func_179249_a((Enum)this.mode);
            buf.writeBoolean(this.isOverride);
        }
    }

    public static class AnimationPacketHandler
    implements IMessageHandler<PacketAnimation, IMessage> {
        public IMessage onMessage(PacketAnimation message, MessageContext ctx) {
            Entity entity = Minecraft.func_71410_x().field_71441_e.func_73045_a(message.entityId);
            if (entity != null) {
                this.execute(entity, message);
            }
            return null;
        }

        private void execute(Entity entity, PacketAnimation message) {
            if (entity instanceof IXolAnimated) {
                AnimationHandler handler = ((IXolAnimated)entity).getAnimationHandler();
                switch (message.add) {
                    case 0: {
                        handler.stop(message.animation);
                        break;
                    }
                    case 1: {
                        handler.play(message.animation);
                        break;
                    }
                    case 2: {
                        handler.play(message.animation, animationProperty -> {
                            animationProperty.loopMode = message.mode;
                            animationProperty.isOverride = message.isOverride;
                            animationProperty.speedModifier = message.speed;
                        });
                    }
                }
            }
        }
    }
}

