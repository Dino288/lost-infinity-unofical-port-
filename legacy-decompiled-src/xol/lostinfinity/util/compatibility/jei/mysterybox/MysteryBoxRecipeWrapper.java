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
package xol.lostinfinity.util.compatibility.jei.mysterybox;

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
import xol.lostinfinity.util.compatibility.jei.mysterybox.MysteryBoxRecipeJEI;

public class MysteryBoxRecipeWrapper
implements IRecipeWrapper {
    private final ItemStack input;
    private final List<ItemStack> outputs;

    public MysteryBoxRecipeWrapper(ItemStack input, List<ItemStack> outputs) {
        this.input = input;
        this.outputs = outputs;
    }

    public void getIngredients(IIngredients ingredients) {
        for (ItemStack items : this.outputs) {
            items.func_190920_e(2 + (int)(Math.random() * 63.0));
        }
        ingredients.setInput(VanillaTypes.ITEM, (Object)this.input);
        ingredients.setOutputs(VanillaTypes.ITEM, this.outputs);
    }

    public static List<MysteryBoxRecipeWrapper> getRecipes(IJeiHelpers helpers) {
        IStackHelper stackHelper = helpers.getStackHelper();
        MysteryBoxRecipeJEI instance = MysteryBoxRecipeJEI.getInstance();
        Map<ItemStack, List<ItemStack>> recipes = instance.getMysteryBoxList();
        ArrayList jeiRecipes = Lists.newArrayList();
        for (Map.Entry<ItemStack, List<ItemStack>> entry : recipes.entrySet()) {
            ItemStack input = entry.getKey();
            List<ItemStack> outputs = entry.getValue();
            MysteryBoxRecipeWrapper recipe = new MysteryBoxRecipeWrapper(input, outputs);
            jeiRecipes.add(recipe);
        }
        return jeiRecipes;
    }
}

