/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.HashBasedTable
 *  com.google.common.collect.Table
 *  net.minecraft.item.ItemStack
 */
package xol.lostinfinity.util.compatibility.jei.trades.chemist;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import java.util.Map;
import net.minecraft.world.item.ItemStack;
import xol.lostinfinity.init.ItemInit;

public class ChemistTradeJEI {
    private static final ChemistTradeJEI INSTANCE = new ChemistTradeJEI();
    private final Table<ItemStack, ItemStack, ItemStack> chemistTradeList = HashBasedTable.create();

    public ChemistTradeJEI() {
        ItemStack goldToken = new ItemStack(ItemInit.goldToken);
        ItemStack blueCompound = new ItemStack(ItemInit.cureSampleBlue);
        blueCompound.func_190920_e(16);
        this.addChemistTradeRecipe(goldToken, ItemStack.field_190927_a, blueCompound);
        ItemStack greenCompound = new ItemStack(ItemInit.cureSampleGreen);
        greenCompound.func_190920_e(16);
        this.addChemistTradeRecipe(goldToken, ItemStack.field_190927_a, greenCompound);
        ItemStack orangeCompound = new ItemStack(ItemInit.cureSampleOrange);
        orangeCompound.func_190920_e(16);
        this.addChemistTradeRecipe(goldToken, ItemStack.field_190927_a, orangeCompound);
        ItemStack pinkCompound = new ItemStack(ItemInit.cureSamplePink);
        pinkCompound.func_190920_e(16);
        this.addChemistTradeRecipe(goldToken, ItemStack.field_190927_a, pinkCompound);
        ItemStack yellowCompound = new ItemStack(ItemInit.cureSampleYellow);
        yellowCompound.func_190920_e(16);
        this.addChemistTradeRecipe(goldToken, ItemStack.field_190927_a, yellowCompound);
        ItemStack amazonToken = new ItemStack(ItemInit.amazoniteToken);
        amazonToken.func_190920_e(10);
        ItemStack magicBiopowder = new ItemStack(ItemInit.magicBiopowder);
        magicBiopowder.func_190920_e(16);
        this.addChemistTradeRecipe(amazonToken, ItemStack.field_190927_a, magicBiopowder);
        ItemStack corruptedRoot = new ItemStack(ItemInit.corruptedRoot);
        corruptedRoot.func_190920_e(60);
        this.addChemistTradeRecipe(corruptedRoot, new ItemStack(ItemInit.containerOfCollectionFull), new ItemStack(ItemInit.colixiumCatenationPouch));
        ItemStack ghostlyHusk = new ItemStack(ItemInit.ghostlyHusk);
        ghostlyHusk.func_190920_e(60);
        this.addChemistTradeRecipe(ghostlyHusk, new ItemStack(ItemInit.containerOfCollectionFull), new ItemStack(ItemInit.phoroxiumCatenationPouch));
        ItemStack luminecentCubes = new ItemStack(ItemInit.luminescentCubes);
        luminecentCubes.func_190920_e(60);
        this.addChemistTradeRecipe(luminecentCubes, new ItemStack(ItemInit.containerOfCollectionFull), new ItemStack(ItemInit.laraxiumCatenationPouch));
    }

    public static ChemistTradeJEI getInstance() {
        return INSTANCE;
    }

    public void addChemistTradeRecipe(ItemStack input1, ItemStack input2, ItemStack result) {
        if (this.getChemistTradeResult(input1, input2) != ItemStack.field_190927_a) {
            return;
        }
        this.chemistTradeList.put((Object)input1, (Object)input2, (Object)result);
    }

    public ItemStack getChemistTradeResult(ItemStack input1, ItemStack input2) {
        for (Map.Entry entry : this.chemistTradeList.columnMap().entrySet()) {
            if (!this.compareItemStacks(input1, (ItemStack)entry.getKey())) continue;
            for (Map.Entry ent : ((Map)entry.getValue()).entrySet()) {
                if (!this.compareItemStacks(input2, (ItemStack)ent.getKey())) continue;
                return (ItemStack)ent.getValue();
            }
        }
        return ItemStack.field_190927_a;
    }

    private boolean compareItemStacks(ItemStack stack1, ItemStack stack2) {
        return stack1.func_77973_b() == stack2.func_77973_b() && stack1.func_77960_j() == stack2.func_77960_j();
    }

    public Table<ItemStack, ItemStack, ItemStack> getChemistTradeList() {
        return this.chemistTradeList;
    }
}

