/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.item.ItemStack
 */
package xol.lostinfinity.recipes;

import java.util.ArrayList;
import net.minecraft.world.item.ItemStack;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.recipes.Recipe;

public class FossilCombinerRecipes {
    private static ArrayList<Recipe> recipes = new ArrayList();

    private static void init() {
        Recipe testRec = new Recipe(ItemInit.remainsPelicanEel, ItemStack.field_190927_a, ItemStack.field_190927_a, ItemStack.field_190927_a, ItemStack.field_190927_a, ItemStack.field_190927_a, new ItemStack(ItemInit.fossilRibbedTail), new ItemStack(ItemInit.fossilSmallRibs), new ItemStack(ItemInit.fossilSmallRibs), new ItemStack(ItemInit.fossilSmallRibs), new ItemStack(ItemInit.fossilEelTopjaw), new ItemStack(ItemInit.fossilRibbedTail), ItemStack.field_190927_a, ItemStack.field_190927_a, ItemStack.field_190927_a, new ItemStack(ItemInit.fossilEelBotjaw));
        recipes.add(testRec);
    }

    public static ItemStack getResult(ItemStack ... inputs) {
        if (recipes.isEmpty()) {
            FossilCombinerRecipes.init();
        }
        for (int i = 0; i < recipes.size(); ++i) {
            Recipe recipe = recipes.get(i);
            ArrayList<ItemStack> foundInputs = new ArrayList<ItemStack>();
            ArrayList<ItemStack> neededInputs = new ArrayList<ItemStack>();
            if (recipe.values.length != 15) continue;
            for (int j = 0; j < 15; ++j) {
                neededInputs.add(recipe.values[j]);
            }
            for (int k = 0; k < 15; ++k) {
                ItemStack stack = (ItemStack)neededInputs.get(k);
                if (!stack.func_77969_a(inputs[k]) && (!inputs[k].func_190926_b() || !stack.func_190926_b())) continue;
                foundInputs.add(stack);
            }
            if (!foundInputs.containsAll(neededInputs)) continue;
            return new ItemStack(recipe.result);
        }
        return null;
    }
}

