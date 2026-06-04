package xol.lostinfinity.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import xol.lostinfinity.LostInfinity;
import xol.lostinfinity.dimension.LostDimensionTeleporter;
import xol.lostinfinity.effect.LostFx;
import xol.lostinfinity.progression.LostProgression;

public class LostDimensionPortalBlock extends Block {
    private final String targetDimension;

    public LostDimensionPortalBlock(BlockBehaviour.Properties properties, String targetDimension) {
        super(properties);
        this.targetDimension = targetDimension;
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if (!level.isClientSide() && player instanceof ServerPlayer serverPlayer) {
            if (!canUsePortal(serverPlayer)) {
                serverPlayer.displayClientMessage(Component.translatable("message.lostinfinity.portal.locked"), true);
                LostFx.play(level, pos, "weapon_error", SoundSource.BLOCKS, 0.5F, 0.8F);
                LostFx.burst(level, pos, "dark_magic", 8, 0.35D, 0.02D);
                return InteractionResult.SUCCESS;
            }
            LostFx.play(level, pos, "portal_open", SoundSource.BLOCKS, 0.9F, 1.0F);
            LostFx.burst(level, pos, portalParticle(), 28, 0.75D, 0.05D);
            LostDimensionTeleporter.teleport(serverPlayer, targetDimension);
        }
        return InteractionResult.sidedSuccess(level.isClientSide());
    }

    private String portalParticle() {
        return switch (targetDimension) {
            case "shadowsea" -> "murky_mist";
            case "infinitemurk" -> "murk";
            case "cartographerrealmtop", "cartographerrealmmid", "cartographerrealmbot" -> "space_magic";
            case "nonexistence", "celestialvoid" -> "portal_beam";
            default -> "warp";
        };
    }

    private boolean canUsePortal(ServerPlayer player) {
        if (LostProgression.canUseDimension(player, targetDimension)) {
            return true;
        }
        return switch (targetDimension) {
            case "shadowsea" -> hasItemLike(player, "magic_conch", "igneous_pearl", "igneous_pearl_ore");
            case "infinitemurk" -> hasItemLike(player, "murky_mirror");
            case "cartographerrealmtop", "cartographerrealmmid", "cartographerrealmbot" ->
                    hasItemLike(player, "solar_globe", "solar_globe_middle", "solar_globe_bottom", "synchronizer", "advanced_synchronizer");
            case "nonexistence", "celestialvoid" ->
                    hasItemLike(player, "galaxybeacon", "geodimensional_tunnel", "dimensional_capacitor", "dimensionalizer_blueprint");
            default -> true;
        };
    }

    private static boolean hasItemLike(ServerPlayer player, String... itemNames) {
        for (ItemStack stack : player.getInventory().items) {
            if (matchesItem(stack, itemNames)) {
                return true;
            }
        }
        for (ItemStack stack : player.getInventory().armor) {
            if (matchesItem(stack, itemNames)) {
                return true;
            }
        }
        return matchesItem(player.getOffhandItem(), itemNames);
    }

    private static boolean matchesItem(ItemStack stack, String... itemNames) {
        if (stack.isEmpty()) {
            return false;
        }
        ResourceLocation location = BuiltInRegistries.ITEM.getKey(stack.getItem());
        if (!LostInfinity.MODID.equals(location.getNamespace())) {
            return false;
        }
        for (String itemName : itemNames) {
            if (itemName.equals(location.getPath())) {
                return true;
            }
        }
        return false;
    }
}
