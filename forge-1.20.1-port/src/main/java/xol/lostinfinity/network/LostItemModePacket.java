package xol.lostinfinity.network;

import java.util.function.Supplier;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.network.NetworkEvent;
import xol.lostinfinity.item.LostItemBehavior;

public record LostItemModePacket(InteractionHand hand) {
    public static void encode(LostItemModePacket packet, FriendlyByteBuf buf) {
        buf.writeEnum(packet.hand);
    }

    public static LostItemModePacket decode(FriendlyByteBuf buf) {
        return new LostItemModePacket(buf.readEnum(InteractionHand.class));
    }

    public static void handle(LostItemModePacket packet, Supplier<NetworkEvent.Context> contextSupplier) {
        NetworkEvent.Context context = contextSupplier.get();
        context.enqueueWork(() -> {
            ServerPlayer player = context.getSender();
            if (player == null) {
                return;
            }
            ItemStack stack = player.getItemInHand(packet.hand);
            if (!stack.isEmpty()) {
                String id = stack.getItem().builtInRegistryHolder().key().location().getPath();
                LostItemBehavior.cycleModeFromNetwork(id, stack, player.level(), player);
            }
        });
        context.setPacketHandled(true);
    }
}
