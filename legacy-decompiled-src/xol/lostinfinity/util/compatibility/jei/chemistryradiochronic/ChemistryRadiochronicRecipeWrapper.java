/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.Lists
 *  mezz.jei.api.IGuiHelper
 *  mezz.jei.api.IJeiHelpers
 *  mezz.jei.api.ingredients.IIngredients
 *  mezz.jei.api.ingredients.VanillaTypes
 *  mezz.jei.api.recipe.IRecipeWrapper
 *  mezz.jei.api.recipe.IStackHelper
 *  net.minecraft.item.ItemStack
 */
package xol.lostinfinity.util.compatibility.jei.chemistryradiochronic;

import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import mezz.jei.api.IGuiHelper;
import mezz.jei.api.IJeiHelpers;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.ingredients.VanillaTypes;
import mezz.jei.api.recipe.IRecipeWrapper;
import mezz.jei.api.recipe.IStackHelper;
import net.minecraft.world.item.ItemStack;
import xol.lostinfinity.util.compatibility.jei.chemistryradiochronic.ChemistryRadiochronicRecipeJEI;

public class ChemistryRadiochronicRecipeWrapper
implements IRecipeWrapper {
    private final List<ItemStack> inputs;
    private final ItemStack output;

    public ChemistryRadiochronicRecipeWrapper(List<ItemStack> inputs, ItemStack output, IGuiHelper helper) {
        this.inputs = inputs;
        this.output = output;
    }

    public void getIngredients(IIngredients ingredients) {
        ingredients.setInputs(VanillaTypes.ITEM, this.inputs);
        ingredients.setOutput(VanillaTypes.ITEM, (Object)this.output);
    }

    public static List<ChemistryRadiochronicRecipeWrapper> getRecipes(IJeiHelpers helpers) {
        IStackHelper stackHelper = helpers.getStackHelper();
        ChemistryRadiochronicRecipeJEI instance = ChemistryRadiochronicRecipeJEI.getInstance();
        Map<List<ItemStack>, ItemStack> recipes = instance.getChemistryTableList();
        ArrayList jeiRecipes = Lists.newArrayList();
        for (Map.Entry<List<ItemStack>, ItemStack> entry : recipes.entrySet()) {
            List<ItemStack> inputs = entry.getKey();
            ItemStack output = entry.getValue();
            ChemistryRadiochronicRecipeWrapper recipe = new ChemistryRadiochronicRecipeWrapper(inputs, output, helpers.getGuiHelper());
            jeiRecipes.add(recipe);
        }
        return jeiRecipes;
    }
}

