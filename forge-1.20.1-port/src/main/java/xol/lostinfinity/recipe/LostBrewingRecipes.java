package xol.lostinfinity.recipe;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.brewing.BrewingRecipe;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import xol.lostinfinity.registry.ModItems;

public final class LostBrewingRecipes {
    private LostBrewingRecipes() {
    }

    public static void registerAll() {
        add(ModItems.ITEM_EXPLOSIVE_SACK.get(), ModItems.ITEM_FIREBLOOD_SOLUTION.get());
        add(ModItems.ITEM_ACIDIC_TONGUE.get(), ModItems.ITEM_ACIDBLOOD_SOLUTION.get());
        add(ModItems.ITEM_DUSKER_EGGS.get(), ModItems.ITEM_POLYCHARGE_SOLUTION.get());
        add(ModItems.ITEM_SUPERMUTATED_FLESH.get(), ModItems.ITEM_UNSTABLE_SOLUTION.get());
        add(ModItems.ITEM_DEVIANT_FLESH.get(), ModItems.ITEM_CORRUPTED_SOLUTION.get());
        add(ModItems.ITEM_VOLATILE_BLOOD.get(), ModItems.ITEM_VOLATILITY_SOLUTION.get());
        add(ModItems.ITEM_NIGHTMARE_POWDER.get(), ModItems.ITEM_NIGHTMARE_SOLUTION.get());
        add(ModItems.ITEM_GLOWING_SAC.get(), ModItems.ITEM_GLOWBLOOD_SOLUTION.get());
        add(ModItems.ITEM_EMBER_SAC.get(), ModItems.ITEM_QUICKFLAME_SOLUTION.get());
        add(ModItems.ITEM_ATOMIC_CELL.get(), ModItems.ITEM_RAPID_GROWTH_SOLUTION.get());
        add(ModItems.ITEM_VILE_SAC.get(), ModItems.ITEM_BIOREACTIVE_SOLUTION.get());
    }

    private static void add(Item ingredient, Item output) {
        ItemStack waterBottle = PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.WATER);
        BrewingRecipeRegistry.addRecipe(new BrewingRecipe(Ingredient.of(waterBottle), Ingredient.of(ingredient), new ItemStack(output)));
    }
}
