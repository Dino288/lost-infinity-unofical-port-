package xol.lostinfinity.network;

import java.util.function.Supplier;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraftforge.network.NetworkEvent;
import xol.lostinfinity.effect.LostFx;

public record LostSetBonusPacket(boolean enabled) {
    public static void encode(LostSetBonusPacket packet, FriendlyByteBuf buf) {
        buf.writeBoolean(packet.enabled);
    }

    public static LostSetBonusPacket decode(FriendlyByteBuf buf) {
        return new LostSetBonusPacket(buf.readBoolean());
    }

    public static void handle(LostSetBonusPacket packet, Supplier<NetworkEvent.Context> contextSupplier) {
        NetworkEvent.Context context = contextSupplier.get();
        context.enqueueWork(() -> {
            ServerPlayer player = context.getSender();
            if (player != null) {
                player.getPersistentData().putBoolean("LostSetBonusEnabled", packet.enabled);
                LostFx.play(player.level(), player.blockPosition(), packet.enabled ? "armor_activate" : "armor_deactivate", SoundSource.PLAYERS, 0.75F, 1.0F);
            }
        });
        context.setPacketHandled(true);
    }
}
