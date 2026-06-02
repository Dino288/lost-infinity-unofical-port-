package xol.lostinfinity.registry;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.Heightmap;

public final class ModSpawnPlacements {
    private static boolean registered;

    private ModSpawnPlacements() {
    }

    public static void registerAll() {
        if (registered) {
            return;
        }
        registered = true;
        water(ModEntities.DOUBLERANG.get());
        water(ModEntities.LONGFIN.get());
        water(ModEntities.OCTOBRELLA.get());
        water(ModEntities.RAYFISH.get());
        water(ModEntities.GLOWFISH.get());
        water(ModEntities.UNDERFIN.get());
        water(ModEntities.EELSHARK.get());
        water(ModEntities.CRABULON.get());
        water(ModEntities.RIBSHARK.get());
        water(ModEntities.LEVIATHAN.get());
        water(ModEntities.SEA_SERPENT.get());

        ground(ModEntities.MIRRORZOMBIE.get());
        ground(ModEntities.SPECTRE.get());
        ground(ModEntities.MULTIVERSEGHOST.get());
        ground(ModEntities.RISINGPHANTOM.get());
        ground(ModEntities.DEVIANTZOMBIE.get());
        ground(ModEntities.DEVIANTENDERMAN.get());

        ground(ModEntities.GALAXYBEAST.get());
        ground(ModEntities.GALAXYGLADIATOR.get());
        ground(ModEntities.GALAXYSORCERER.get());
        ground(ModEntities.GALAXYGULPER.get());
        ground(ModEntities.GALAXYSPIRE.get());
        ground(ModEntities.GALAXY_DRAGON.get());

        ground(ModEntities.LABWARRIOR.get());
        ground(ModEntities.LABWIZARD.get());
        ground(ModEntities.GLOOP.get());
        ground(ModEntities.CLINGER.get());
        ground(ModEntities.CYCLOS.get());
        ground(ModEntities.SENTRYCRYSTAL.get());
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    private static void ground(EntityType<? extends Mob> type) {
        SpawnPlacements.register((EntityType) type, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                ModSpawnPlacements::canSpawnOnGround);
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    private static void water(EntityType<? extends Mob> type) {
        SpawnPlacements.register((EntityType) type, SpawnPlacements.Type.IN_WATER, Heightmap.Types.OCEAN_FLOOR,
                ModSpawnPlacements::canSpawnInWater);
    }

    private static boolean canSpawnOnGround(EntityType<? extends Mob> type, LevelAccessor level, MobSpawnType reason, BlockPos pos, net.minecraft.util.RandomSource random) {
        return level.getBlockState(pos.below()).isSolidRender(level, pos.below())
                && level.getBlockState(pos).isAir()
                && level.getBlockState(pos.above()).isAir();
    }

    private static boolean canSpawnInWater(EntityType<? extends Mob> type, LevelAccessor level, MobSpawnType reason, BlockPos pos, net.minecraft.util.RandomSource random) {
        return level.getBlockState(pos).is(Blocks.WATER)
                || level.getBlockState(pos).getFluidState().is(net.minecraft.tags.FluidTags.WATER);
    }
}
