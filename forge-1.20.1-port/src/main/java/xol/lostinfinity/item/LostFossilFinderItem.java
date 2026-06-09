package xol.lostinfinity.item;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.levelgen.Heightmap;
import xol.lostinfinity.effect.LostFx;
import xol.lostinfinity.registry.ModBlocks;
import xol.lostinfinity.registry.ModItems;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class LostFossilFinderItem extends Item {
    private static final String TRACK_LENGTH = "LostFossilTrackLength";
    private static final String FINAL_X = "LostFossilFinalX";
    private static final String FINAL_Y = "LostFossilFinalY";
    private static final String FINAL_Z = "LostFossilFinalZ";

    public LostFossilFinderItem(Properties properties) {
        super(properties.durability(128));
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);
        if (level.isClientSide) {
            return InteractionResultHolder.sidedSuccess(stack, true);
        }
        if (!isFossilDimension(level)) {
            player.displayClientMessage(Component.literal("The finder is silent here."), true);
            LostFx.play(level, player.blockPosition(), "weapon_error", SoundSource.PLAYERS, 0.45F, 0.8F);
            return InteractionResultHolder.success(stack);
        }

        CompoundTag tag = stack.getOrCreateTag();
        if (!tag.contains(TRACK_LENGTH)) {
            createTrack(level, player, tag);
        } else if (!tag.contains(FINAL_X)) {
            revealTrack(level, player, tag);
        } else {
            searchFinal(level, player, tag);
        }
        if (!player.getAbilities().instabuild) {
            stack.hurtAndBreak(1, player, broken -> broken.broadcastBreakEvent(hand));
        }
        player.getCooldowns().addCooldown(this, 30);
        return InteractionResultHolder.success(stack);
    }

    private static void createTrack(Level level, Player player, CompoundTag tag) {
        List<BlockPos> track = buildTrack(level, player.blockPosition());
        for (int i = 0; i < track.size(); i++) {
            BlockPos pos = track.get(i);
            tag.putInt("LostFossilTrack" + i + "X", pos.getX());
            tag.putInt("LostFossilTrack" + i + "Y", pos.getY());
            tag.putInt("LostFossilTrack" + i + "Z", pos.getZ());
        }
        tag.putInt(TRACK_LENGTH, track.size());
        if (!track.isEmpty()) {
            level.setBlockAndUpdate(track.get(0), ModBlocks.FOSSIL_TRACK.get().defaultBlockState());
        }
        player.displayClientMessage(Component.literal("Discovered fossil evidence, follow the trail!"), true);
        LostFx.play(level, player.blockPosition(), "scanner", SoundSource.PLAYERS, 0.8F, 0.85F);
        LostFx.burst(level, player.blockPosition(), "bone_fragments", 12, 0.55D, 0.03D);
    }

    private static void revealTrack(Level level, Player player, CompoundTag tag) {
        List<BlockPos> track = readTrack(tag);
        if (track.isEmpty()) {
            tag.remove(TRACK_LENGTH);
            return;
        }
        int nearest = nearestTrackIndex(player.blockPosition(), track);
        int lastRevealed = lastRevealedIndex(level, track);
        if (nearest < 0 || nearest > lastRevealed + 5) {
            player.displayClientMessage(Component.literal("Follow the revealed fossil track first."), true);
            return;
        }
        int bound = Math.min(track.size(), Math.max(lastRevealed + 2, nearest + 3));
        for (int i = 0; i < bound; i++) {
            level.setBlockAndUpdate(track.get(i), ModBlocks.FOSSIL_TRACK.get().defaultBlockState());
        }
        LostFx.play(level, player.blockPosition(), "water_drop", SoundSource.PLAYERS, 0.8F, 0.75F);
        if (bound >= track.size()) {
            BlockPos end = track.get(track.size() - 1);
            BlockPos finalPos = findFinalFossilSpot(level, end);
            tag.putInt(FINAL_X, finalPos.getX());
            tag.putInt(FINAL_Y, finalPos.getY());
            tag.putInt(FINAL_Z, finalPos.getZ());
            player.displayClientMessage(Component.literal("You reached the end of the trail. Search the area for the fossil."), true);
        }
    }

    private static void searchFinal(Level level, Player player, CompoundTag tag) {
        BlockPos finalPos = new BlockPos(tag.getInt(FINAL_X), tag.getInt(FINAL_Y), tag.getInt(FINAL_Z));
        int distance = manhattan(player.blockPosition(), finalPos);
        if (distance < 4) {
            clearTrack(level, tag);
            ItemStack reward = new ItemStack(randomFossil(level));
            ItemEntity fossil = new ItemEntity(level, player.getX(), player.getY() + 0.4D, player.getZ(), reward);
            fossil.setDeltaMovement(0.0D, 0.05D, 0.0D);
            level.addFreshEntity(fossil);
            clearFinderTag(tag);
            player.displayClientMessage(Component.literal("Fossil found!"), true);
            LostFx.play(level, player.blockPosition(), "special_craft", SoundSource.PLAYERS, 1.0F, 1.2F);
            LostFx.burst(level, player.blockPosition(), "bone_fragments", 24, 0.75D, 0.04D);
        } else if (distance < 8) {
            player.displayClientMessage(Component.literal("You are very close to the fossil!"), true);
        } else if (distance < 16) {
            player.displayClientMessage(Component.literal("You are close to the fossil!"), true);
        } else if (distance < 45) {
            player.displayClientMessage(Component.literal("The fossil is in this area, but not too close."), true);
        } else {
            player.displayClientMessage(Component.literal("Look around the end of the fossil track."), true);
        }
    }

    private static List<BlockPos> buildTrack(Level level, BlockPos start) {
        int targetX = start.getX() + 18 + level.random.nextInt(15);
        int targetZ = start.getZ() + 18 + level.random.nextInt(15);
        int currentX = start.getX();
        int currentZ = start.getZ();
        List<BlockPos> track = new ArrayList<>();
        track.add(surface(level, currentX, currentZ));
        while (currentX != targetX || currentZ != targetZ) {
            int xDiff = targetX - currentX;
            int zDiff = targetZ - currentZ;
            if (xDiff == 0 || zDiff != 0 && level.random.nextBoolean()) {
                currentZ += Integer.signum(zDiff);
            } else {
                currentX += Integer.signum(xDiff);
            }
            track.add(surface(level, currentX, currentZ));
        }
        return track;
    }

    private static List<BlockPos> readTrack(CompoundTag tag) {
        int length = tag.getInt(TRACK_LENGTH);
        List<BlockPos> track = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            track.add(new BlockPos(tag.getInt("LostFossilTrack" + i + "X"), tag.getInt("LostFossilTrack" + i + "Y"),
                    tag.getInt("LostFossilTrack" + i + "Z")));
        }
        return track;
    }

    private static int nearestTrackIndex(BlockPos playerPos, List<BlockPos> track) {
        int nearest = -1;
        int best = Integer.MAX_VALUE;
        for (int i = 0; i < track.size(); i++) {
            int distance = Math.abs(track.get(i).getX() - playerPos.getX()) + Math.abs(track.get(i).getZ() - playerPos.getZ());
            if (distance < best && distance <= 4) {
                best = distance;
                nearest = i;
            }
        }
        return nearest;
    }

    private static int lastRevealedIndex(Level level, List<BlockPos> track) {
        int last = 0;
        for (int i = 0; i < track.size(); i++) {
            if (level.getBlockState(track.get(i)).is(ModBlocks.FOSSIL_TRACK.get())) {
                last = i;
            }
        }
        return last;
    }

    private static void clearTrack(Level level, CompoundTag tag) {
        for (BlockPos pos : readTrack(tag)) {
            if (level.getBlockState(pos).is(ModBlocks.FOSSIL_TRACK.get())) {
                level.removeBlock(pos, false);
            }
        }
    }

    private static void clearFinderTag(CompoundTag tag) {
        Set<String> keys = Set.copyOf(tag.getAllKeys());
        keys.forEach(tag::remove);
    }

    private static BlockPos findFinalFossilSpot(Level level, BlockPos end) {
        for (int attempt = 0; attempt < 48; attempt++) {
            int x = end.getX() + level.random.nextInt(31) - 15;
            int z = end.getZ() + level.random.nextInt(31) - 15;
            BlockPos pos = surface(level, x, z);
            if (level.getBlockState(pos).isAir()) {
                return pos;
            }
        }
        return end;
    }

    private static BlockPos surface(Level level, int x, int z) {
        int y = level.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, x, z);
        return new BlockPos(x, y, z);
    }

    private static int manhattan(BlockPos a, BlockPos b) {
        return Math.abs(a.getX() - b.getX()) + Math.abs(a.getY() - b.getY()) + Math.abs(a.getZ() - b.getZ());
    }

    private static Item randomFossil(Level level) {
        return switch (level.random.nextInt(6)) {
            case 0 -> ModItems.ITEM_FOSSIL_EEL_BOTJAW.get();
            case 1, 5 -> ModItems.ITEM_FOSSIL_RIBBED_TAIL.get();
            case 2 -> ModItems.ITEM_FOSSIL_EEL_TOPJAW.get();
            default -> ModItems.ITEM_FOSSIL_SMALL_RIBS.get();
        };
    }

    private static boolean isFossilDimension(Level level) {
        String path = level.dimension().location().getPath();
        return path.contains("shadowsea") || path.contains("murk");
    }
}
