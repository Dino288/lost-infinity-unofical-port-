/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.HashBasedTable
 *  com.google.common.collect.Table
 *  net.minecraft.item.ItemStack
 */
package xol.lostinfinity.util.compatibility.jei.trades.archeologist;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import java.util.Map;
import net.minecraft.world.item.ItemStack;
import xol.lostinfinity.init.ItemInit;

public class ArcheologistTradeJEI {
    private static final ArcheologistTradeJEI INSTANCE = new ArcheologistTradeJEI();
    private final Table<ItemStack, ItemStack, ItemStack> archeologistTradeList = HashBasedTable.create();

    public ArcheologistTradeJEI() {
        ItemStack silverTokens = new ItemStack(ItemInit.silverToken);
        silverTokens.func_190920_e(16);
        this.addArcheologistTradeRecipe(new ItemStack(ItemInit.remainsPelicanEel), ItemStack.field_190927_a, silverTokens);
    }

    public static ArcheologistTradeJEI getInstance() {
        return INSTANCE;
    }

    public void addArcheologistTradeRecipe(ItemStack input1, ItemStack input2, ItemStack result) {
        if (this.getArcheologistTradeResult(input1, input2) != ItemStack.field_190927_a) {
            return;
        }
        this.archeologistTradeList.put((Object)input1, (Object)input2, (Object)result);
    }

    public ItemStack getArcheologistTradeResult(ItemStack input1, ItemStack input2) {
        for (Map.Entry entry : this.archeologistTradeList.columnMap().entrySet()) {
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

    public Table<ItemStack, ItemStack, ItemStack> getArcheologistTradeList() {
        return this.archeologistTradeList;
    }
}

