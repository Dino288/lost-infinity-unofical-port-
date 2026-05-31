/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.item.ItemStack
 */
package xol.lostinfinity.util.compatibility.jei.chemistrynegametric;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import net.minecraft.world.item.ItemStack;
import xol.lostinfinity.init.ItemInit;

public class ChemistryNegametricRecipeJEI {
    private static final ChemistryNegametricRecipeJEI INSTANCE = new ChemistryNegametricRecipeJEI();
    private final Map<List<ItemStack>, ItemStack> chemistryTableList = new HashMap<List<ItemStack>, ItemStack>();

    public ChemistryNegametricRecipeJEI() {
        ItemStack chromeAlum = new ItemStack(ItemInit.chromeAlumVial);
        chromeAlum.func_190920_e(2);
        ItemStack gigachargeSolutions = new ItemStack(ItemInit.gigachargeSolutions);
        gigachargeSolutions.func_190920_e(4);
        ItemStack negativeMagnecronite = new ItemStack(ItemInit.negativeMagnecronite);
        negativeMagnecronite.func_190920_e(3);
        ArrayList<ItemStack> negametricInput = new ArrayList<ItemStack>(Arrays.asList(chromeAlum, gigachargeSolutions, negativeMagnecronite));
        this.addChemistryTableRecipe(negametricInput, new ItemStack(ItemInit.negametricIsotope));
    }

    public static ChemistryNegametricRecipeJEI getInstance() {
        return INSTANCE;
    }

    public void addChemistryTableRecipe(List<ItemStack> inputs, ItemStack result) {
        if (this.getChemistryTableResult(inputs) != ItemStack.field_190927_a) {
            return;
        }
        this.chemistryTableList.put(inputs, result);
    }

    public ItemStack getChemistryTableResult(List<ItemStack> inputs) {
        for (Map.Entry<List<ItemStack>, ItemStack> entry : this.chemistryTableList.entrySet()) {
            if (!Objects.equals(inputs, entry.getKey())) continue;
            return entry.getValue();
        }
        return ItemStack.field_190927_a;
    }

    public Map<List<ItemStack>, ItemStack> getChemistryTableList() {
        return this.chemistryTableList;
    }
}

