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

public class SapEvaporatorRecipes {
    private static ArrayList<Recipe> recipes = new ArrayList();

    private static void init() {
        ItemStack sap = new ItemStack(ItemInit.jarOfSap);
        Recipe sunderSyrup = new Recipe(ItemInit.jarOfSyrup, sap);
        recipes.add(sunderSyrup);
    }

    public static ItemStack getResult(ItemStack input) {
        if (recipes.isEmpty()) {
            SapEvaporatorRecipes.init();
        }
        for (int i = 0; i < recipes.size(); ++i) {
            Recipe recipe = recipes.get(i);
            if (!recipe.values[0].func_77969_a(input)) continue;
            return new ItemStack(recipe.result);
        }
        return null;
    }
}

