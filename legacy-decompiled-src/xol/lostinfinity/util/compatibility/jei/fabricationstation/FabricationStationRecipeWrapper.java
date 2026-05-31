/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.Lists
 *  mezz.jei.api.IJeiHelpers
 *  mezz.jei.api.ingredients.IIngredients
 *  mezz.jei.api.ingredients.VanillaTypes
 *  mezz.jei.api.recipe.IRecipeWrapper
 *  mezz.jei.api.recipe.IStackHelper
 *  net.minecraft.item.ItemStack
 */
package xol.lostinfinity.util.compatibility.jei.fabricationstation;

import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import mezz.jei.api.IJeiHelpers;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.ingredients.VanillaTypes;
import mezz.jei.api.recipe.IRecipeWrapper;
import mezz.jei.api.recipe.IStackHelper;
import net.minecraft.world.item.ItemStack;
import xol.lostinfinity.util.compatibility.jei.fabricationstation.FabricationStationRecipeJEI;

public class FabricationStationRecipeWrapper
implements IRecipeWrapper {
    private final List<ItemStack> inputs;
    private final ItemStack output;

    public FabricationStationRecipeWrapper(List<ItemStack> inputs, ItemStack output) {
        this.inputs = inputs;
        this.output = output;
    }

    public void getIngredients(IIngredients ingredients) {
        ingredients.setInputs(VanillaTypes.ITEM, this.inputs);
        ingredients.setOutput(VanillaTypes.ITEM, (Object)this.output);
    }

    public static List<FabricationStationRecipeWrapper> getRecipes(IJeiHelpers helpers) {
        IStackHelper stackHelper = helpers.getStackHelper();
        FabricationStationRecipeJEI instance = FabricationStationRecipeJEI.getInstance();
        Map<List<ItemStack>, ItemStack> recipes = instance.getFabricationStationList();
        ArrayList jeiRecipes = Lists.newArrayList();
        for (Map.Entry<List<ItemStack>, ItemStack> entry : recipes.entrySet()) {
            List<ItemStack> inputs = entry.getKey();
            ItemStack output = entry.getValue();
            FabricationStationRecipeWrapper recipe = new FabricationStationRecipeWrapper(inputs, output);
            jeiRecipes.add(recipe);
        }
        return jeiRecipes;
    }
}

