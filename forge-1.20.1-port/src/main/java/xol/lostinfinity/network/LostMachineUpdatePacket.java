package xol.lostinfinity.network;

import java.util.function.Supplier;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkEvent;
import xol.lostinfinity.blockentity.LostMachineBlockEntity;

public record LostMachineUpdatePacket(BlockPos pos, int index, int value) {
    public static void encode(LostMachineUpdatePacket packet, FriendlyByteBuf buf) {
        buf.writeBlockPos(packet.pos);
        buf.writeVarInt(packet.index);
        buf.writeVarInt(packet.value);
    }

    public static LostMachineUpdatePacket decode(FriendlyByteBuf buf) {
        return new LostMachineUpdatePacket(buf.readBlockPos(), buf.readVarInt(), buf.readVarInt());
    }

    public static void handle(LostMachineUpdatePacket packet, Supplier<NetworkEvent.Context> contextSupplier) {
        NetworkEvent.Context context = contextSupplier.get();
        context.enqueueWork(() -> {
            ServerPlayer player = context.getSender();
            if (player == null || player.distanceToSqr(packet.pos.getX() + 0.5D, packet.pos.getY() + 0.5D, packet.pos.getZ() + 0.5D) > 64.0D) {
                return;
            }
            if (player.level().getBlockEntity(packet.pos) instanceof LostMachineBlockEntity machine) {
                machine.applyNetworkUpdate(packet.index, packet.value);
            }
        });
        context.setPacketHandled(true);
    }
}
