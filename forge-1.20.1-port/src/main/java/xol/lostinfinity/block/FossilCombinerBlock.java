package xol.lostinfinity.block;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import xol.lostinfinity.effect.LostFx;
import xol.lostinfinity.registry.ModItems;

import java.util.ArrayList;
import java.util.List;

public class FossilCombinerBlock extends Block {
    public FossilCombinerBlock(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if (level.isClientSide) {
            return InteractionResult.SUCCESS;
        }
        List<ItemEntity> fossils = level.getEntitiesOfClass(ItemEntity.class, new AABB(pos).inflate(3.5D, 1.5D, 3.5D),
                entity -> !entity.getItem().isEmpty());
        List<ItemEntity> ribbedTails = matching(fossils, ModItems.ITEM_FOSSIL_RIBBED_TAIL.get());
        List<ItemEntity> smallRibs = matching(fossils, ModItems.ITEM_FOSSIL_SMALL_RIBS.get());
        List<ItemEntity> topJaws = matching(fossils, ModItems.ITEM_FOSSIL_EEL_TOPJAW.get());
        List<ItemEntity> botJaws = matching(fossils, ModItems.ITEM_FOSSIL_EEL_BOTJAW.get());
        if (count(ribbedTails) < 2 || count(smallRibs) < 3 || count(topJaws) < 1 || count(botJaws) < 1) {
            LostFx.play(level, pos, "weapon_error", SoundSource.BLOCKS, 0.45F, 0.8F);
            LostFx.burst(level, pos, "bone_fragments", 10, 0.45D, 0.03D);
            return InteractionResult.SUCCESS;
        }
        consume(ribbedTails, 2);
        consume(smallRibs, 3);
        consume(topJaws, 1);
        consume(botJaws, 1);
        ItemEntity output = new ItemEntity(level, pos.getX() + 0.5D, pos.getY() + 1.15D, pos.getZ() + 0.5D,
                new ItemStack(ModItems.ITEM_REMAINS_PELICAN_EEL.get()));
        output.setDeltaMovement(0.0D, 0.08D, 0.0D);
        level.addFreshEntity(output);
        LostFx.play(level, pos, "special_craft", SoundSource.BLOCKS, 0.9F, 0.9F);
        LostFx.burst(level, pos, "bone_fragments", 28, 0.95D, 0.05D);
        return InteractionResult.SUCCESS;
    }

    private static List<ItemEntity> matching(List<ItemEntity> entities, Item item) {
        List<ItemEntity> matched = new ArrayList<>();
        for (ItemEntity entity : entities) {
            if (entity.getItem().is(item)) {
                matched.add(entity);
            }
        }
        return matched;
    }

    private static int count(List<ItemEntity> entities) {
        int count = 0;
        for (ItemEntity entity : entities) {
            count += entity.getItem().getCount();
        }
        return count;
    }

    private static void consume(List<ItemEntity> entities, int amount) {
        int remaining = amount;
        for (ItemEntity entity : entities) {
            int used = Math.min(remaining, entity.getItem().getCount());
            entity.getItem().shrink(used);
            remaining -= used;
            if (remaining <= 0) {
                return;
            }
        }
    }
}
