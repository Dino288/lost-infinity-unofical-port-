/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.Lists
 *  com.google.common.collect.Table
 *  mezz.jei.api.IJeiHelpers
 *  mezz.jei.api.ingredients.IIngredients
 *  mezz.jei.api.ingredients.VanillaTypes
 *  mezz.jei.api.recipe.IRecipeWrapper
 *  mezz.jei.api.recipe.IStackHelper
 *  net.minecraft.item.ItemStack
 */
package xol.lostinfinity.util.compatibility.jei.trades.zirconia.mythic;

import com.google.common.collect.Lists;
import com.google.common.collect.Table;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import mezz.jei.api.IJeiHelpers;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.ingredients.VanillaTypes;
import mezz.jei.api.recipe.IRecipeWrapper;
import mezz.jei.api.recipe.IStackHelper;
import net.minecraft.world.item.ItemStack;
import xol.lostinfinity.util.compatibility.jei.trades.zirconia.mythic.MythicTradeJEI;

public class MythicTradeWrapper
implements IRecipeWrapper {
    private final List<ItemStack> inputs;
    private final ItemStack output;

    public MythicTradeWrapper(List<ItemStack> inputs, ItemStack output) {
        this.inputs = inputs;
        this.output = output;
    }

    public void getIngredients(IIngredients ingredients) {
        ingredients.setInputs(VanillaTypes.ITEM, this.inputs);
        ingredients.setOutput(VanillaTypes.ITEM, (Object)this.output);
    }

    public static List<MythicTradeWrapper> getRecipes(IJeiHelpers helpers) {
        IStackHelper stackHelper = helpers.getStackHelper();
        MythicTradeJEI instance = MythicTradeJEI.getInstance();
        Table<ItemStack, ItemStack, ItemStack> recipes = instance.getZirconiaTradeList();
        ArrayList jeiRecipes = Lists.newArrayList();
        for (Map.Entry entry : recipes.columnMap().entrySet()) {
            for (Map.Entry ent : ((Map)entry.getValue()).entrySet()) {
                ItemStack input1 = (ItemStack)entry.getKey();
                ItemStack input2 = (ItemStack)ent.getKey();
                ItemStack output = (ItemStack)ent.getValue();
                ArrayList inputs = Lists.newArrayList((Object[])new ItemStack[]{input1, input2});
                MythicTradeWrapper recipe = new MythicTradeWrapper(inputs, output);
                jeiRecipes.add(recipe);
            }
        }
        return jeiRecipes;
    }
}

