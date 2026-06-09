package xol.lostinfinity.item;

import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import xol.lostinfinity.effect.LostFx;
import xol.lostinfinity.registry.ModBlocks;
import xol.lostinfinity.registry.ModItems;

import java.util.List;
import java.util.Locale;
import java.util.function.Supplier;

public class LostCatenationPouchItem extends Item {
    private final String itemName;

    public LostCatenationPouchItem(String itemName, Properties properties) {
        super(properties.stacksTo(16));
        this.itemName = itemName.toLowerCase(Locale.ROOT);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);
        if (level.isClientSide) {
            return InteractionResultHolder.sidedSuccess(stack, true);
        }
        CatenationRecipe recipe = recipe();
        if (recipe == null) {
            return InteractionResultHolder.pass(stack);
        }
        if (!isMurkLike(level)) {
            LostFx.play(level, player.blockPosition(), "weapon_error", SoundSource.PLAYERS, 0.45F, 0.75F);
            return InteractionResultHolder.success(stack);
        }
        List<ItemEntity> ingredients = findIngredients(level, player, recipe);
        if (ingredients.size() != 3) {
            LostFx.play(level, player.blockPosition(), "chemical_mixing", SoundSource.PLAYERS, 0.35F, 0.65F);
            LostFx.burst(level, player.blockPosition(), "acid", 8, 0.35D, 0.02D);
            return InteractionResultHolder.success(stack);
        }
        ingredients.forEach(entity -> entity.getItem().shrink(5));
        ItemEntity output = new ItemEntity(level, player.getX(), player.getY() + 1.2D, player.getZ(), new ItemStack(recipe.result().get()));
        output.setDeltaMovement(0.0D, 0.08D, 0.0D);
        level.addFreshEntity(output);
        stack.shrink(1);
        LostFx.play(level, player.blockPosition(), "special_craft", SoundSource.PLAYERS, 1.0F, 1.0F);
        LostFx.burst(level, player.blockPosition(), "acid", 36, 0.9D, 0.05D);
        player.getCooldowns().addCooldown(this, 40);
        return InteractionResultHolder.success(stack);
    }

    private CatenationRecipe recipe() {
        if (itemName.contains("colixium")) {
            return new CatenationRecipe(ModItems.ITEM_COLIXIUM,
                    List.of(ModItems.ITEM_DARKSTEEL_SHARDS, ModItems.ITEM_ELASTIC_TISSUE, ModItems.ITEM_SUPERMUTATED_CRYSTALS));
        }
        if (itemName.contains("phoroxium")) {
            return new CatenationRecipe(ModItems.ITEM_PHOROXIUM,
                    List.of(ModItems.ITEM_AURADINE, ModItems.BLOCK_ITEM_SPACE_PICKLE, ModItems.ITEM_SUPERMUTATED_PELT));
        }
        if (itemName.contains("laraxium")) {
            return new CatenationRecipe(ModItems.ITEM_LARAXIUM,
                    List.of(ModItems.ITEM_INCANDESCITE, ModItems.ITEM_GLOW_BULB, ModItems.ITEM_ORGANIC_FUSE));
        }
        return null;
    }

    private static List<ItemEntity> findIngredients(Level level, Player player, CatenationRecipe recipe) {
        boolean[] matched = new boolean[recipe.ingredients().size()];
        java.util.ArrayList<ItemEntity> entities = new java.util.ArrayList<>();
        AABB area = new AABB(player.blockPosition().offset(-4, -2, -4), player.blockPosition().offset(5, 3, 5));
        for (ItemEntity entity : level.getEntitiesOfClass(ItemEntity.class, area, entity -> !entity.getItem().isEmpty())) {
            if (!level.getBlockState(entity.blockPosition()).is(ModBlocks.CONCENTRATED_ACID.get())) {
                continue;
            }
            for (int index = 0; index < recipe.ingredients().size(); index++) {
                if (!matched[index] && entity.getItem().is(recipe.ingredients().get(index).get()) && entity.getItem().getCount() >= 5) {
                    matched[index] = true;
                    entities.add(entity);
                    break;
                }
            }
        }
        return entities;
    }

    private static boolean isMurkLike(Level level) {
        String path = level.dimension().location().getPath();
        return path.contains("murk") || path.contains("shadowsea");
    }

    private record CatenationRecipe(Supplier<Item> result, List<Supplier<Item>> ingredients) {
    }
}
