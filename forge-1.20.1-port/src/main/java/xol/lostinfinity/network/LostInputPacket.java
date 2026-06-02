package xol.lostinfinity.network;

import java.util.function.Supplier;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkEvent;

public record LostInputPacket(float forward, float strafe, boolean jumping, boolean sneaking) {
    public static void encode(LostInputPacket packet, FriendlyByteBuf buf) {
        buf.writeFloat(packet.forward);
        buf.writeFloat(packet.strafe);
        buf.writeBoolean(packet.jumping);
        buf.writeBoolean(packet.sneaking);
    }

    public static LostInputPacket decode(FriendlyByteBuf buf) {
        return new LostInputPacket(buf.readFloat(), buf.readFloat(), buf.readBoolean(), buf.readBoolean());
    }

    public static void handle(LostInputPacket packet, Supplier<NetworkEvent.Context> contextSupplier) {
        NetworkEvent.Context context = contextSupplier.get();
        context.enqueueWork(() -> {
            ServerPlayer player = context.getSender();
            if (player != null) {
                player.getPersistentData().putFloat("LostInputForward", packet.forward);
                player.getPersistentData().putFloat("LostInputStrafe", packet.strafe);
                player.getPersistentData().putBoolean("LostInputJumping", packet.jumping);
                player.getPersistentData().putBoolean("LostInputSneaking", packet.sneaking);
            }
        });
        context.setPacketHandled(true);
    }
}
