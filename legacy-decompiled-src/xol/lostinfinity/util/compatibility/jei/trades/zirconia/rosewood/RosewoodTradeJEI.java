/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.HashBasedTable
 *  com.google.common.collect.Table
 *  net.minecraft.item.ItemStack
 */
package xol.lostinfinity.util.compatibility.jei.trades.zirconia.rosewood;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import java.util.Map;
import net.minecraft.world.item.ItemStack;
import xol.lostinfinity.init.ItemInit;

public class RosewoodTradeJEI {
    private static final RosewoodTradeJEI INSTANCE = new RosewoodTradeJEI();
    private final Table<ItemStack, ItemStack, ItemStack> zirconiaTradeList = HashBasedTable.create();

    public RosewoodTradeJEI() {
        ItemStack mastercutDiamond5 = new ItemStack(ItemInit.masterCutDiamond);
        mastercutDiamond5.func_190920_e(5);
        this.addRosewoodTradeRecipe(mastercutDiamond5, ItemStack.field_190927_a, new ItemStack(ItemInit.eliteContenderPass));
        ItemStack mastercutDiamond10 = new ItemStack(ItemInit.masterCutDiamond);
        mastercutDiamond10.func_190920_e(10);
        ItemStack mysterybox4 = new ItemStack(ItemInit.mysteryBox);
        mysterybox4.func_190920_e(4);
        this.addRosewoodTradeRecipe(mastercutDiamond10, ItemStack.field_190927_a, mysterybox4);
        ItemStack zirconia20 = new ItemStack(ItemInit.zirconiaRosewood);
        zirconia20.func_190920_e(20);
        this.addRosewoodTradeRecipe(zirconia20, ItemStack.field_190927_a, new ItemStack(ItemInit.polyswitch));
        ItemStack zirconia50 = new ItemStack(ItemInit.zirconiaRosewood);
        zirconia50.func_190920_e(50);
        this.addRosewoodTradeRecipe(zirconia50, zirconia50, new ItemStack(ItemInit.sparkChamber));
    }

    public static RosewoodTradeJEI getInstance() {
        return INSTANCE;
    }

    public void addRosewoodTradeRecipe(ItemStack input1, ItemStack input2, ItemStack result) {
        if (this.getRosewoodTradeResult(input1, input2) != ItemStack.field_190927_a) {
            return;
        }
        this.zirconiaTradeList.put((Object)input1, (Object)input2, (Object)result);
    }

    public ItemStack getRosewoodTradeResult(ItemStack input1, ItemStack input2) {
        for (Map.Entry entry : this.zirconiaTradeList.columnMap().entrySet()) {
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

    public Table<ItemStack, ItemStack, ItemStack> getZirconiaTradeList() {
        return this.zirconiaTradeList;
    }
}

