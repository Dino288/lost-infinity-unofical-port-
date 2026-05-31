/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.HashBasedTable
 *  com.google.common.collect.Table
 *  net.minecraft.item.ItemStack
 */
package xol.lostinfinity.util.compatibility.jei.trades.zirconia.midnight;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import java.util.Map;
import net.minecraft.world.item.ItemStack;
import xol.lostinfinity.init.ItemInit;

public class MidnightTradeJEI {
    private static final MidnightTradeJEI INSTANCE = new MidnightTradeJEI();
    private final Table<ItemStack, ItemStack, ItemStack> zirconiaTradeList = HashBasedTable.create();

    public MidnightTradeJEI() {
        ItemStack celestialDiamond10 = new ItemStack(ItemInit.celestialDiamond);
        celestialDiamond10.func_190920_e(10);
        this.addMidnightTradeRecipe(celestialDiamond10, ItemStack.field_190927_a, new ItemStack(ItemInit.contenderPass));
        ItemStack celestialDiamond15 = new ItemStack(ItemInit.celestialDiamond);
        celestialDiamond15.func_190920_e(15);
        this.addMidnightTradeRecipe(celestialDiamond15, ItemStack.field_190927_a, new ItemStack(ItemInit.mysteryBox));
        ItemStack zirconia20 = new ItemStack(ItemInit.zirconiaMidnight);
        zirconia20.func_190920_e(20);
        this.addMidnightTradeRecipe(zirconia20, ItemStack.field_190927_a, new ItemStack(ItemInit.laserPointer));
        ItemStack zirconia50 = new ItemStack(ItemInit.zirconiaMidnight);
        zirconia50.func_190920_e(50);
        this.addMidnightTradeRecipe(zirconia50, zirconia50, new ItemStack(ItemInit.rgbIlluminator));
    }

    public static MidnightTradeJEI getInstance() {
        return INSTANCE;
    }

    public void addMidnightTradeRecipe(ItemStack input1, ItemStack input2, ItemStack result) {
        if (this.getMidnightTradeResult(input1, input2) != ItemStack.field_190927_a) {
            return;
        }
        this.zirconiaTradeList.put((Object)input1, (Object)input2, (Object)result);
    }

    public ItemStack getMidnightTradeResult(ItemStack input1, ItemStack input2) {
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

