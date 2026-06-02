package xol.lostinfinity.network;

import java.util.Optional;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.simple.SimpleChannel;
import xol.lostinfinity.LostInfinity;

public final class LostNetwork {
    private static final String PROTOCOL_VERSION = "1";
    public static final SimpleChannel CHANNEL = NetworkRegistry.newSimpleChannel(
            new ResourceLocation(LostInfinity.MODID, "main"),
            () -> PROTOCOL_VERSION,
            PROTOCOL_VERSION::equals,
            PROTOCOL_VERSION::equals);
    private static int packetId;

    private LostNetwork() {
    }

    public static void register() {
        CHANNEL.registerMessage(nextId(), LostItemModePacket.class, LostItemModePacket::encode, LostItemModePacket::decode,
                LostItemModePacket::handle, Optional.of(NetworkDirection.PLAY_TO_SERVER));
        CHANNEL.registerMessage(nextId(), LostMachineUpdatePacket.class, LostMachineUpdatePacket::encode, LostMachineUpdatePacket::decode,
                LostMachineUpdatePacket::handle, Optional.of(NetworkDirection.PLAY_TO_SERVER));
        CHANNEL.registerMessage(nextId(), LostClientParticlePacket.class, LostClientParticlePacket::encode, LostClientParticlePacket::decode,
                LostClientParticlePacket::handle, Optional.of(NetworkDirection.PLAY_TO_CLIENT));
        CHANNEL.registerMessage(nextId(), LostClientSoundPacket.class, LostClientSoundPacket::encode, LostClientSoundPacket::decode,
                LostClientSoundPacket::handle, Optional.of(NetworkDirection.PLAY_TO_CLIENT));
        CHANNEL.registerMessage(nextId(), LostAnimationPacket.class, LostAnimationPacket::encode, LostAnimationPacket::decode,
                LostAnimationPacket::handle, Optional.of(NetworkDirection.PLAY_TO_CLIENT));
        CHANNEL.registerMessage(nextId(), LostInputPacket.class, LostInputPacket::encode, LostInputPacket::decode,
                LostInputPacket::handle, Optional.of(NetworkDirection.PLAY_TO_SERVER));
        CHANNEL.registerMessage(nextId(), LostSetBonusPacket.class, LostSetBonusPacket::encode, LostSetBonusPacket::decode,
                LostSetBonusPacket::handle, Optional.of(NetworkDirection.PLAY_TO_SERVER));
    }

    public static void sendToServer(Object packet) {
        CHANNEL.sendToServer(packet);
    }

    public static void sendToPlayer(ServerPlayer player, Object packet) {
        CHANNEL.send(PacketDistributor.PLAYER.with(() -> player), packet);
    }

    public static void sendTracking(Entity entity, Object packet) {
        CHANNEL.send(PacketDistributor.TRACKING_ENTITY.with(() -> entity), packet);
    }

    public static void sendNear(ServerPlayer player, double x, double y, double z, double radius, Object packet) {
        CHANNEL.send(PacketDistributor.NEAR.with(() -> new PacketDistributor.TargetPoint(x, y, z, radius, player.level().dimension())), packet);
    }

    private static int nextId() {
        return packetId++;
    }
}
