package xol.lostinfinity.block;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
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
import java.util.function.Supplier;

public class MetaMaterializerBlock extends Block {
    private static final List<MetaRecipe> RECIPES = List.of(
            new MetaRecipe(ModItems.ITEM_CLOVINITE_POWER_BANK, ModItems.ITEM_KYVORIUM_INGOT,
                    List.of(ModItems.ITEM_VELLORIUM_INGOT, ModItems.ITEM_KYLAXIUM_INGOT, ModItems.ITEM_XEROVIUM_INGOT),
                    List.of(ModItems.ITEM_ORGANIC_PLATE, ModItems.ITEM_CORRUPTED_ROOT, ModItems.ITEM_GIANT_TENTACLE)),
            new MetaRecipe(ModItems.ITEM_ADHESIVE_FIBRE, ModItems.ITEM_BIOSYNTHIUM_INGOT,
                    List.of(ModItems.ITEM_OLYSIUM_INGOT, ModItems.ITEM_DETHERIUM_INGOT, ModItems.ITEM_PHYTROSIUM_INGOT),
                    List.of(ModItems.ITEM_GLOOM_BULB, ModItems.ITEM_PICKLE, ModItems.ITEM_ANTHOCITE)),
            new MetaRecipe(ModItems.ITEM_EXTERNAL_CLOVINITE_BATTERY, ModItems.ITEM_MALICIUM_INGOT,
                    List.of(ModItems.ITEM_NOXERIUM_INGOT, ModItems.ITEM_INCADIUM_INGOT, ModItems.ITEM_EMBERIUM_INGOT),
                    List.of(ModItems.ITEM_GHOSTLY_HUSK, ModItems.ITEM_FLEXIBLE_HUSK, ModItems.ITEM_CORRUPTED_ROOT)),
            new MetaRecipe(ModItems.ITEM_ION_CELL, ModItems.ITEM_ETHERIUM_INGOT,
                    List.of(ModItems.ITEM_OLYSIUM_INGOT, ModItems.ITEM_XEROVIUM_INGOT, ModItems.ITEM_DETHERIUM_INGOT),
                    List.of(ModItems.ITEM_GHOSTLY_HUSK, ModItems.ITEM_PHOTOCHROMIC_HUSK, ModItems.ITEM_LUMINESCENT_STINGERS)),
            new MetaRecipe(ModItems.ITEM_POTENT_POLARCRONITE, ModItems.ITEM_POLARIUM_INGOT,
                    List.of(ModItems.ITEM_PHYTROSIUM_INGOT, ModItems.ITEM_XEROVIUM_INGOT, ModItems.ITEM_HEXTORIUM_INGOT),
                    List.of(ModItems.ITEM_VOLATILE_BLOOD, ModItems.ITEM_GLOWING_GLOBES, ModItems.ITEM_GLOWING_ORGAN))
    );

    public MetaMaterializerBlock(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        MetaRecipe recipe = recipeFor(player.getItemInHand(hand));
        if (recipe == null) {
            return InteractionResult.PASS;
        }
        if (level.isClientSide) {
            return InteractionResult.SUCCESS;
        }

        List<ItemEntity> ingots = matchedItems(level, oreBox(pos), recipe.ingots());
        List<ItemEntity> organics = matchedItems(level, organicsBox(pos), recipe.organics());
        List<LivingEntity> sacrifices = sacrifices(level, sacrificeBox(pos));
        if (ingots.size() < recipe.ingots().size() || organics.size() < recipe.organics().size() || sacrificeValue(sacrifices) < 3) {
            LostFx.play(level, pos, "weapon_error", SoundSource.BLOCKS, 0.55F, 0.8F);
            LostFx.burst(level, pos, "murky_mist", 12, 0.65D, 0.03D);
            return InteractionResult.SUCCESS;
        }

        int outputCount = materializeCount(ingots, organics);
        if (outputCount <= 0) {
            return InteractionResult.SUCCESS;
        }
        ingots.forEach(entity -> entity.getItem().shrink(outputCount));
        organics.forEach(entity -> entity.getItem().shrink(outputCount));
        sacrifices.forEach(entity -> entity.hurt(level.damageSources().magic(), Float.MAX_VALUE));
        for (int i = 0; i < 3; i++) {
            ItemEntity output = new ItemEntity(level, pos.getX() + 0.5D, pos.getY() + 1.15D, pos.getZ() + 0.5D,
                    new ItemStack(recipe.result().get(), outputCount));
            output.setDeltaMovement(0.0D, 0.08D, 0.0D);
            level.addFreshEntity(output);
        }
        LostFx.play(level, pos, "special_craft", SoundSource.BLOCKS, 1.0F, 0.75F);
        LostFx.burst(level, pos, "space_magic", 48, 1.4D, 0.08D);
        return InteractionResult.SUCCESS;
    }

    private static MetaRecipe recipeFor(ItemStack held) {
        if (held.isEmpty()) {
            return null;
        }
        for (MetaRecipe recipe : RECIPES) {
            if (held.is(recipe.trigger().get())) {
                return recipe;
            }
        }
        return null;
    }

    private static List<ItemEntity> matchedItems(Level level, AABB box, List<Supplier<Item>> needed) {
        List<ItemEntity> matched = new ArrayList<>();
        boolean[] used = new boolean[needed.size()];
        for (ItemEntity entity : level.getEntitiesOfClass(ItemEntity.class, box, entity -> !entity.getItem().isEmpty())) {
            for (int index = 0; index < needed.size(); index++) {
                if (!used[index] && entity.getItem().is(needed.get(index).get())) {
                    used[index] = true;
                    matched.add(entity);
                    break;
                }
            }
        }
        return matched;
    }

    private static List<LivingEntity> sacrifices(Level level, AABB box) {
        return level.getEntitiesOfClass(LivingEntity.class, box, entity -> entity.isAlive() && !entity.isSpectator());
    }

    private static int sacrificeValue(List<LivingEntity> sacrifices) {
        int value = 0;
        for (LivingEntity sacrifice : sacrifices) {
            value += sacrifice instanceof Player ? 3 : 1;
        }
        return value;
    }

    private static int materializeCount(List<ItemEntity> ingots, List<ItemEntity> organics) {
        int count = Integer.MAX_VALUE;
        for (ItemEntity entity : ingots) {
            count = Math.min(count, entity.getItem().getCount());
        }
        for (ItemEntity entity : organics) {
            count = Math.min(count, entity.getItem().getCount());
        }
        return count == Integer.MAX_VALUE ? 0 : count;
    }

    private static AABB oreBox(BlockPos pos) {
        return new AABB(pos.offset(-2, 0, -5), pos.offset(3, 2, -1));
    }

    private static AABB organicsBox(BlockPos pos) {
        return new AABB(pos.offset(-2, 0, -10), pos.offset(3, 2, -6));
    }

    private static AABB sacrificeBox(BlockPos pos) {
        return new AABB(pos.offset(-3, 0, -17), pos.offset(4, 3, -11));
    }

    private record MetaRecipe(Supplier<Item> trigger, Supplier<Item> result, List<Supplier<Item>> ingots,
                              List<Supplier<Item>> organics) {
    }
}
