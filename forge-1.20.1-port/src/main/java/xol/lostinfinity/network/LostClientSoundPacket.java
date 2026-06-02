package xol.lostinfinity.network;

import java.util.function.Supplier;
import net.minecraft.client.Minecraft;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.network.NetworkEvent;
import xol.lostinfinity.LostInfinity;

public record LostClientSoundPacket(String sound, double x, double y, double z, SoundSource source, float volume, float pitch) {
    public static void encode(LostClientSoundPacket packet, FriendlyByteBuf buf) {
        buf.writeUtf(packet.sound);
        buf.writeDouble(packet.x);
        buf.writeDouble(packet.y);
        buf.writeDouble(packet.z);
        buf.writeEnum(packet.source);
        buf.writeFloat(packet.volume);
        buf.writeFloat(packet.pitch);
    }

    public static LostClientSoundPacket decode(FriendlyByteBuf buf) {
        return new LostClientSoundPacket(buf.readUtf(), buf.readDouble(), buf.readDouble(), buf.readDouble(), buf.readEnum(SoundSource.class), buf.readFloat(), buf.readFloat());
    }

    public static void handle(LostClientSoundPacket packet, Supplier<NetworkEvent.Context> contextSupplier) {
        NetworkEvent.Context context = contextSupplier.get();
        context.enqueueWork(() -> DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> play(packet)));
        context.setPacketHandled(true);
    }

    private static void play(LostClientSoundPacket packet) {
        var level = Minecraft.getInstance().level;
        if (level == null) {
            return;
        }
        SoundEvent sound = SoundEvent.createVariableRangeEvent(new ResourceLocation(LostInfinity.MODID, packet.sound));
        level.playLocalSound(packet.x, packet.y, packet.z, sound, packet.source, packet.volume, packet.pitch, false);
    }
}
