/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.init.Items
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraftforge.common.brewing.BrewingRecipeRegistry
 *  net.minecraftforge.fml.common.registry.GameRegistry
 */
package xol.lostinfinity.recipes;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import xol.lostinfinity.init.ItemInit;

public class CustomBrewingRecipes {
    public static void init() {
        BrewingRecipeRegistry.addRecipe((ItemStack)new ItemStack((Item)Items.field_151068_bn), (ItemStack)new ItemStack(ItemInit.explosiveSack), (ItemStack)new ItemStack(ItemInit.firebloodSolution));
        BrewingRecipeRegistry.addRecipe((ItemStack)new ItemStack((Item)Items.field_151068_bn), (ItemStack)new ItemStack(ItemInit.acidicTongue), (ItemStack)new ItemStack(ItemInit.acidbloodSolution));
        BrewingRecipeRegistry.addRecipe((ItemStack)new ItemStack((Item)Items.field_151068_bn), (ItemStack)new ItemStack(ItemInit.duskerEggs), (ItemStack)new ItemStack(ItemInit.polychargeSolution));
        BrewingRecipeRegistry.addRecipe((ItemStack)new ItemStack((Item)Items.field_151068_bn), (ItemStack)new ItemStack(ItemInit.supermutatedFlesh), (ItemStack)new ItemStack(ItemInit.unstableSolution));
        BrewingRecipeRegistry.addRecipe((ItemStack)new ItemStack((Item)Items.field_151068_bn), (ItemStack)new ItemStack(ItemInit.deviantFlesh), (ItemStack)new ItemStack(ItemInit.corruptedSolution));
        BrewingRecipeRegistry.addRecipe((ItemStack)new ItemStack((Item)Items.field_151068_bn), (ItemStack)new ItemStack(ItemInit.volatileBlood), (ItemStack)new ItemStack(ItemInit.volatilitySolution));
        BrewingRecipeRegistry.addRecipe((ItemStack)new ItemStack((Item)Items.field_151068_bn), (ItemStack)new ItemStack(ItemInit.nightmarePowder), (ItemStack)new ItemStack(ItemInit.nightmareSolution));
        BrewingRecipeRegistry.addRecipe((ItemStack)new ItemStack((Item)Items.field_151068_bn), (ItemStack)new ItemStack(ItemInit.glowingSac), (ItemStack)new ItemStack(ItemInit.glowbloodSolution));
        BrewingRecipeRegistry.addRecipe((ItemStack)new ItemStack((Item)Items.field_151068_bn), (ItemStack)new ItemStack(ItemInit.emberSac), (ItemStack)new ItemStack(ItemInit.quickflameSolution));
        BrewingRecipeRegistry.addRecipe((ItemStack)new ItemStack((Item)Items.field_151068_bn), (ItemStack)new ItemStack(ItemInit.atomicCell), (ItemStack)new ItemStack(ItemInit.rapidGrowthSolution));
        BrewingRecipeRegistry.addRecipe((ItemStack)new ItemStack((Item)Items.field_151068_bn), (ItemStack)new ItemStack(ItemInit.vileSac), (ItemStack)new ItemStack(ItemInit.bioreactiveSolution));
        GameRegistry.addSmelting((Item)ItemInit.honeyJar, (ItemStack)new ItemStack(ItemInit.amber), (float)0.7f);
        GameRegistry.addSmelting((Item)ItemInit.impureExothermite, (ItemStack)new ItemStack(ItemInit.moltenExothermite), (float)0.7f);
        GameRegistry.addSmelting((Item)ItemInit.sunderLog, (ItemStack)new ItemStack(ItemInit.sunderAsh), (float)0.7f);
        GameRegistry.addSmelting((Item)ItemInit.murkyLog, (ItemStack)new ItemStack(ItemInit.murkyAsh), (float)0.7f);
    }
}

