package xol.lostinfinity.network;

import java.util.function.Supplier;
import net.minecraft.client.Minecraft;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.network.NetworkEvent;

public record LostAnimationPacket(int entityId, String animation, float speed, boolean overrideAnimation) {
    public static void encode(LostAnimationPacket packet, FriendlyByteBuf buf) {
        buf.writeVarInt(packet.entityId);
        buf.writeUtf(packet.animation);
        buf.writeFloat(packet.speed);
        buf.writeBoolean(packet.overrideAnimation);
    }

    public static LostAnimationPacket decode(FriendlyByteBuf buf) {
        return new LostAnimationPacket(buf.readVarInt(), buf.readUtf(), buf.readFloat(), buf.readBoolean());
    }

    public static void handle(LostAnimationPacket packet, Supplier<NetworkEvent.Context> contextSupplier) {
        NetworkEvent.Context context = contextSupplier.get();
        context.enqueueWork(() -> DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> apply(packet)));
        context.setPacketHandled(true);
    }

    private static void apply(LostAnimationPacket packet) {
        var level = Minecraft.getInstance().level;
        if (level == null || level.getEntity(packet.entityId) == null) {
            return;
        }
        // The renderer uses entity tick state today; this packet is the modern hook for exact legacy animations.
    }
}
