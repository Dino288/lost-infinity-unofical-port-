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

public class ChemistryRecipes {
    public static ArrayList<Recipe> recipes = new ArrayList();

    public static ArrayList<Recipe> getRecipes() {
        return recipes;
    }

    private static void init() {
        Recipe radiochron = new Recipe(ItemInit.radiochronicIsotope, new ItemStack(ItemInit.radioactiveIsotopes), new ItemStack(ItemInit.polyamplificationSolution), new ItemStack(ItemInit.radioactiveIsotopes), new ItemStack(ItemInit.polyamplificationSolution), new ItemStack(ItemInit.solarumVial), new ItemStack(ItemInit.solarumVial), new ItemStack(ItemInit.solarumVial), new ItemStack(ItemInit.radioactiveIsotopes), new ItemStack(ItemInit.polyamplificationSolution));
        Recipe negamet = new Recipe(ItemInit.negametricIsotope, new ItemStack(ItemInit.chromeAlumVial), new ItemStack(ItemInit.gigachargeSolutions), new ItemStack(ItemInit.gigachargeSolutions), new ItemStack(ItemInit.negativeMagnecronite), new ItemStack(ItemInit.negativeMagnecronite), new ItemStack(ItemInit.gigachargeSolutions), new ItemStack(ItemInit.negativeMagnecronite), new ItemStack(ItemInit.gigachargeSolutions), new ItemStack(ItemInit.chromeAlumVial));
        recipes.add(radiochron);
        recipes.add(negamet);
    }

    public static ItemStack getResult(ItemStack ... inputs) {
        if (recipes.isEmpty()) {
            ChemistryRecipes.init();
        }
        for (Recipe recipe : recipes) {
            if (inputs.length != 9 || !recipe.values[0].func_77969_a(inputs[0]) || !recipe.values[1].func_77969_a(inputs[1]) || !recipe.values[2].func_77969_a(inputs[2]) || !recipe.values[3].func_77969_a(inputs[3]) || !recipe.values[4].func_77969_a(inputs[4]) || !recipe.values[5].func_77969_a(inputs[5]) || !recipe.values[6].func_77969_a(inputs[6]) || !recipe.values[7].func_77969_a(inputs[7]) || !recipe.values[8].func_77969_a(inputs[8])) continue;
            return new ItemStack(recipe.result);
        }
        return null;
    }
}

