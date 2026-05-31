/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.item.ItemStack
 */
package xol.lostinfinity.util.compatibility.jei.chemistryradiochronic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import net.minecraft.world.item.ItemStack;
import xol.lostinfinity.init.ItemInit;

public class ChemistryRadiochronicRecipeJEI {
    private static final ChemistryRadiochronicRecipeJEI INSTANCE = new ChemistryRadiochronicRecipeJEI();
    private final Map<List<ItemStack>, ItemStack> chemistryTableList = new HashMap<List<ItemStack>, ItemStack>();

    public ChemistryRadiochronicRecipeJEI() {
        ItemStack solarum = new ItemStack(ItemInit.solarumVial);
        solarum.func_190920_e(3);
        ItemStack polyamplificationSolution = new ItemStack(ItemInit.polyamplificationSolution);
        polyamplificationSolution.func_190920_e(3);
        ItemStack radioactiveIsotopes = new ItemStack(ItemInit.radioactiveIsotopes);
        radioactiveIsotopes.func_190920_e(3);
        ArrayList<ItemStack> radiochronicInputs = new ArrayList<ItemStack>(Arrays.asList(solarum, polyamplificationSolution, radioactiveIsotopes));
        this.addChemistryTableRecipe(radiochronicInputs, new ItemStack(ItemInit.radiochronicIsotope));
    }

    public static ChemistryRadiochronicRecipeJEI getInstance() {
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

