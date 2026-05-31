/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.HashBasedTable
 *  com.google.common.collect.Table
 *  net.minecraft.item.ItemStack
 */
package xol.lostinfinity.util.compatibility.jei.fusiontable;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import java.util.Map;
import net.minecraft.world.item.ItemStack;
import xol.lostinfinity.init.ItemInit;

public class FusionTableRecipeJEI {
    private static final FusionTableRecipeJEI INSTANCE = new FusionTableRecipeJEI();
    private final Table<ItemStack, ItemStack, ItemStack> FusionTableList = HashBasedTable.create();

    public FusionTableRecipeJEI() {
        this.addFusionTableRecipe(new ItemStack(ItemInit.ioniteBar), new ItemStack(ItemInit.inverseMagnecronite), new ItemStack(ItemInit.polyionite));
        this.addFusionTableRecipe(new ItemStack(ItemInit.inverseMagnecronite), new ItemStack(ItemInit.ioniteBar), new ItemStack(ItemInit.polyionite));
    }

    public static FusionTableRecipeJEI getInstance() {
        return INSTANCE;
    }

    public void addFusionTableRecipe(ItemStack input1, ItemStack input2, ItemStack result) {
        if (this.getFusionTableResult(input1, input2) != ItemStack.field_190927_a) {
            return;
        }
        this.FusionTableList.put((Object)input1, (Object)input2, (Object)result);
    }

    public ItemStack getFusionTableResult(ItemStack input1, ItemStack input2) {
        for (Map.Entry entry : this.FusionTableList.columnMap().entrySet()) {
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

    public Table<ItemStack, ItemStack, ItemStack> getFusionTableList() {
        return this.FusionTableList;
    }
}

