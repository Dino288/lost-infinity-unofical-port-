/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.HashBasedTable
 *  com.google.common.collect.Table
 *  net.minecraft.item.ItemStack
 */
package xol.lostinfinity.util.compatibility.jei.nicroniuminfuser;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import java.util.Map;
import net.minecraft.world.item.ItemStack;
import xol.lostinfinity.init.ItemInit;

public class NicroniumInfuserRecipeJEI {
    private static final NicroniumInfuserRecipeJEI INSTANCE = new NicroniumInfuserRecipeJEI();
    private final Table<ItemStack, ItemStack, ItemStack> nicroniumInfuserList = HashBasedTable.create();

    public NicroniumInfuserRecipeJEI() {
        this.addNicroniumInfuserRecipe(new ItemStack(ItemInit.powerfulPolarcronite), new ItemStack(ItemInit.nicronium), new ItemStack(ItemInit.infusedNicronium));
    }

    public static NicroniumInfuserRecipeJEI getInstance() {
        return INSTANCE;
    }

    public void addNicroniumInfuserRecipe(ItemStack input1, ItemStack input2, ItemStack result) {
        if (this.getNicroniumInfuserResult(input1, input2) != ItemStack.field_190927_a) {
            return;
        }
        this.nicroniumInfuserList.put((Object)input1, (Object)input2, (Object)result);
    }

    public ItemStack getNicroniumInfuserResult(ItemStack input1, ItemStack input2) {
        for (Map.Entry entry : this.nicroniumInfuserList.columnMap().entrySet()) {
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

    public Table<ItemStack, ItemStack, ItemStack> getNicroniumInfuserList() {
        return this.nicroniumInfuserList;
    }
}

