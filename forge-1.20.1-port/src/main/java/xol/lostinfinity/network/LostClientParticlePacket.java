package xol.lostinfinity.network;

import java.util.function.Supplier;
import net.minecraft.client.Minecraft;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.network.NetworkEvent;
import xol.lostinfinity.effect.LostFx;

public record LostClientParticlePacket(String particle, double x, double y, double z, int count, double spread, double speed) {
    public static void encode(LostClientParticlePacket packet, FriendlyByteBuf buf) {
        buf.writeUtf(packet.particle);
        buf.writeDouble(packet.x);
        buf.writeDouble(packet.y);
        buf.writeDouble(packet.z);
        buf.writeVarInt(packet.count);
        buf.writeDouble(packet.spread);
        buf.writeDouble(packet.speed);
    }

    public static LostClientParticlePacket decode(FriendlyByteBuf buf) {
        return new LostClientParticlePacket(buf.readUtf(), buf.readDouble(), buf.readDouble(), buf.readDouble(), buf.readVarInt(), buf.readDouble(), buf.readDouble());
    }

    public static void handle(LostClientParticlePacket packet, Supplier<NetworkEvent.Context> contextSupplier) {
        NetworkEvent.Context context = contextSupplier.get();
        context.enqueueWork(() -> DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> spawn(packet)));
        context.setPacketHandled(true);
    }

    private static void spawn(LostClientParticlePacket packet) {
        var level = Minecraft.getInstance().level;
        if (level == null) {
            return;
        }
        for (int i = 0; i < packet.count; i++) {
            double dx = (level.random.nextDouble() - 0.5D) * packet.spread;
            double dy = (level.random.nextDouble() - 0.5D) * packet.spread;
            double dz = (level.random.nextDouble() - 0.5D) * packet.spread;
            level.addParticle(LostFx.particle(packet.particle), packet.x + dx, packet.y + dy, packet.z + dz, dx * packet.speed, dy * packet.speed, dz * packet.speed);
        }
    }
}
