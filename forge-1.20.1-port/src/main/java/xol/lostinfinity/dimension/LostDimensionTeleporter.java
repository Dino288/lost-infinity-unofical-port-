package xol.lostinfinity.dimension;

import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.levelgen.Heightmap;
import xol.lostinfinity.LostInfinity;

public final class LostDimensionTeleporter {
    private LostDimensionTeleporter() {
    }

    public static boolean teleport(ServerPlayer player, String id) {
        MinecraftServer server = player.server;
        ResourceKey<Level> key = ResourceKey.create(Registries.DIMENSION, new ResourceLocation(LostInfinity.MODID, id));
        ServerLevel target = server.getLevel(key);
        if (target == null) {
            player.displayClientMessage(Component.literal("Dimension is not loaded: " + LostInfinity.MODID + ":" + id), false);
            return false;
        }

        BlockPos landing = landingPosition(target, player.getBlockX(), player.getBlockZ(), player.getY());
        player.teleportTo(target, landing.getX() + 0.5D, landing.getY(), landing.getZ() + 0.5D, player.getYRot(), player.getXRot());
        return true;
    }

    private static BlockPos landingPosition(ServerLevel target, int x, int z, double fallbackY) {
        int y = target.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, x, z) + 1;
        if (y <= target.getMinBuildHeight() + 1) {
            y = (int) Math.max(target.getMinBuildHeight() + 4.0D, Math.min(fallbackY, target.getMaxBuildHeight() - 4.0D));
        }
        return new BlockPos(x, y, z);
    }
}
