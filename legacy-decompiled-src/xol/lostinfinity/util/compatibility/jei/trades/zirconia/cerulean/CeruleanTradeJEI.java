/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.HashBasedTable
 *  com.google.common.collect.Table
 *  net.minecraft.item.ItemStack
 */
package xol.lostinfinity.util.compatibility.jei.trades.zirconia.cerulean;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import java.util.Map;
import net.minecraft.world.item.ItemStack;
import xol.lostinfinity.init.ItemInit;

public class CeruleanTradeJEI {
    private static final CeruleanTradeJEI INSTANCE = new CeruleanTradeJEI();
    private final Table<ItemStack, ItemStack, ItemStack> ceruleanTradeList = HashBasedTable.create();

    public CeruleanTradeJEI() {
        ItemStack celestialDiamond10 = new ItemStack(ItemInit.celestialDiamond);
        celestialDiamond10.func_190920_e(10);
        this.addCeruleanTradeRecipe(celestialDiamond10, ItemStack.field_190927_a, new ItemStack(ItemInit.contenderPass));
        ItemStack celestialDiamond15 = new ItemStack(ItemInit.celestialDiamond);
        celestialDiamond15.func_190920_e(15);
        this.addCeruleanTradeRecipe(celestialDiamond15, ItemStack.field_190927_a, new ItemStack(ItemInit.mysteryBox));
        ItemStack zirconia20 = new ItemStack(ItemInit.zirconiaCerulean);
        zirconia20.func_190920_e(20);
        this.addCeruleanTradeRecipe(zirconia20, ItemStack.field_190927_a, new ItemStack(ItemInit.powerPlug));
        ItemStack zirconia50 = new ItemStack(ItemInit.zirconiaCerulean);
        zirconia50.func_190920_e(50);
        this.addCeruleanTradeRecipe(zirconia50, zirconia50, new ItemStack(ItemInit.ceruleanLens));
    }

    public static CeruleanTradeJEI getInstance() {
        return INSTANCE;
    }

    public void addCeruleanTradeRecipe(ItemStack input1, ItemStack input2, ItemStack result) {
        if (this.getCeruleanTradeResult(input1, input2) != ItemStack.field_190927_a) {
            return;
        }
        this.ceruleanTradeList.put((Object)input1, (Object)input2, (Object)result);
    }

    public ItemStack getCeruleanTradeResult(ItemStack input1, ItemStack input2) {
        for (Map.Entry entry : this.ceruleanTradeList.columnMap().entrySet()) {
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

    public Table<ItemStack, ItemStack, ItemStack> getCeruleanTradeList() {
        return this.ceruleanTradeList;
    }
}

