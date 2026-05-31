/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.HashBasedTable
 *  com.google.common.collect.Table
 *  net.minecraft.item.ItemStack
 */
package xol.lostinfinity.util.compatibility.jei.rainfallgenerator;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import java.util.Map;
import net.minecraft.world.item.ItemStack;
import xol.lostinfinity.init.ItemInit;

public class RainfallGeneratorRecipeJEI {
    private static final RainfallGeneratorRecipeJEI INSTANCE = new RainfallGeneratorRecipeJEI();
    private final Table<ItemStack, ItemStack, ItemStack> rainfallGeneratorList = HashBasedTable.create();

    public RainfallGeneratorRecipeJEI() {
        this.addRainfallGeneratorRecipe(new ItemStack(ItemInit.bagOfMagicCrystals), ItemStack.field_190927_a, ItemStack.field_190927_a);
    }

    public static RainfallGeneratorRecipeJEI getInstance() {
        return INSTANCE;
    }

    public void addRainfallGeneratorRecipe(ItemStack input1, ItemStack input2, ItemStack result) {
        if (this.getRainfallGeneratorResult(input1, input2) != ItemStack.field_190927_a) {
            return;
        }
        this.rainfallGeneratorList.put((Object)input1, (Object)input2, (Object)result);
    }

    public ItemStack getRainfallGeneratorResult(ItemStack input1, ItemStack input2) {
        for (Map.Entry entry : this.rainfallGeneratorList.columnMap().entrySet()) {
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

    public Table<ItemStack, ItemStack, ItemStack> getRainfallGeneratorList() {
        return this.rainfallGeneratorList;
    }
}

