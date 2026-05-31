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
package xol.lostinfinity.util.compatibility.jei.compressiontable;

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
import xol.lostinfinity.util.compatibility.jei.compressiontable.CompressionTableRecipeJEI;

public class CompressionTableRecipeWrapper
implements IRecipeWrapper {
    private final ItemStack input;
    private final ItemStack output;

    public CompressionTableRecipeWrapper(ItemStack input, ItemStack output) {
        this.input = input;
        this.output = output;
    }

    public void getIngredients(IIngredients ingredients) {
        ingredients.setInput(VanillaTypes.ITEM, (Object)this.input);
        ingredients.setOutput(VanillaTypes.ITEM, (Object)this.output);
    }

    public static List<CompressionTableRecipeWrapper> getRecipes(IJeiHelpers helpers) {
        IStackHelper stackHelper = helpers.getStackHelper();
        CompressionTableRecipeJEI instance = CompressionTableRecipeJEI.getInstance();
        Map<ItemStack, ItemStack> recipes = instance.getCompressionTableList();
        ArrayList jeiRecipes = Lists.newArrayList();
        for (Map.Entry<ItemStack, ItemStack> entry : recipes.entrySet()) {
            ItemStack input = entry.getKey();
            ItemStack output = entry.getValue();
            CompressionTableRecipeWrapper recipe = new CompressionTableRecipeWrapper(input, output);
            jeiRecipes.add(recipe);
        }
        return jeiRecipes;
    }
}

