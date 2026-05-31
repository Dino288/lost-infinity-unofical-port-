/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.client.util.ITooltipFlag
 *  net.minecraft.creativetab.CreativeModeTab
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.world.World
 */
package xol.lostinfinity.item.misc;

import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.Level;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.item.basics.ItemBasic;

public class ItemShipmentBox
extends ItemBasic {
    public ItemShipmentBox(String regName, CreativeModeTab tab) {
        super(regName, tab);
        this.func_77637_a(tab);
        this.func_77625_d(1);
    }

    public static int getNewWeight(Item item, int weightIn) {
        return weightIn += ItemShipmentBox.getItemWeight(item);
    }

    public static int getItemWeight(Item item) {
        if (item == ItemInit.azureLeaf) {
            return 3;
        }
        if (item == ItemInit.constrictingVines) {
            return 7;
        }
        if (item == ItemInit.lucientIngot) {
            return 15;
        }
        if (item == ItemInit.bumbleBlossom) {
            return 10;
        }
        return 0;
    }

    public static ItemStack[] getItemArray() {
        ItemStack[] items = new ItemStack[]{ItemStack.field_190927_a, new ItemStack(ItemInit.azureLeaf, 1), new ItemStack(ItemInit.constrictingVines, 1), new ItemStack(ItemInit.lucientIngot, 1), new ItemStack(ItemInit.bumbleBlossom, 1)};
        return items;
    }

    public void func_77624_a(ItemStack stack, @Nullable Level worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        if (!stack.func_77942_o()) {
            stack.func_77982_d(new CompoundTag());
        }
        int weight = stack.func_77978_p().func_74762_e("weight");
        tooltip.add("Box Weight: " + weight + " lbs");
    }
}

