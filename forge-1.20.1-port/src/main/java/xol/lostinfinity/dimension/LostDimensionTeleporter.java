package xol.lostinfinity.dimension;

import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.levelgen.Heightmap;
import xol.lostinfinity.LostInfinity;

public final class LostDimensionTeleporter {
    private LostDimensionTeleporter() {
    }

    public static boolean teleport(ServerPlayer player, String id) {
        return teleport(player, id, player.getX(), player.getY(), player.getZ(), true);
    }

    public static boolean teleport(ServerPlayer player, String id, double x, double y, double z, boolean useSafeSurface) {
        MinecraftServer server = player.server;
        ResourceLocation targetId = "overworld".equals(id) ? new ResourceLocation("minecraft", "overworld") : new ResourceLocation(LostInfinity.MODID, id);
        ResourceKey<Level> key = ResourceKey.create(Registries.DIMENSION, targetId);
        ServerLevel target = server.getLevel(key);
        if (target == null) {
            player.displayClientMessage(Component.literal("Dimension is not loaded: " + targetId), false);
            return false;
        }

        x = safeCoordinate(x);
        z = safeCoordinate(z);
        y = Double.isFinite(y) ? y : 80.0D;
        if (useSafeSurface) {
            BlockPos landing = landingPosition(target, (int) Math.floor(x), (int) Math.floor(z), y);
            ensureSafeLanding(target, landing);
            player.teleportTo(target, landing.getX() + 0.5D, landing.getY(), landing.getZ() + 0.5D, player.getYRot(), player.getXRot());
        } else {
            double safeY = Math.max(target.getMinBuildHeight() + 4.0D, Math.min(y, target.getMaxBuildHeight() - 4.0D));
            BlockPos landing = new BlockPos((int) Math.floor(x), (int) Math.floor(safeY), (int) Math.floor(z));
            ensureSafeLanding(target, landing);
            player.teleportTo(target, landing.getX() + 0.5D, landing.getY(), landing.getZ() + 0.5D, player.getYRot(), player.getXRot());
        }
        return true;
    }

    private static BlockPos landingPosition(ServerLevel target, int x, int z, double fallbackY) {
        int y = target.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, x, z) + 1;
        if (y <= target.getMinBuildHeight() + 1) {
            y = (int) Math.max(target.getMinBuildHeight() + 4.0D, Math.min(fallbackY, target.getMaxBuildHeight() - 4.0D));
        }
        return new BlockPos(x, y, z);
    }

    private static double safeCoordinate(double coordinate) {
        if (!Double.isFinite(coordinate)) {
            return 0.0D;
        }
        return Math.max(-100000.0D, Math.min(100000.0D, coordinate));
    }

    private static void ensureSafeLanding(ServerLevel target, BlockPos landing) {
        BlockPos floor = landing.below();
        if (target.getBlockState(floor).isAir()) {
            for (int x = -1; x <= 1; x++) {
                for (int z = -1; z <= 1; z++) {
                    target.setBlockAndUpdate(floor.offset(x, 0, z), Blocks.COBBLESTONE.defaultBlockState());
                }
            }
        }
        target.setBlockAndUpdate(landing, Blocks.AIR.defaultBlockState());
        target.setBlockAndUpdate(landing.above(), Blocks.AIR.defaultBlockState());
    }
}
