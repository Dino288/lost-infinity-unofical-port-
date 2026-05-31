/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.player.Player
 *  net.minecraft.inventory.IInventory
 *  net.minecraft.inventory.InventoryHelper
 *  net.minecraft.inventory.ItemStackHelper
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.tileentity.BlockEntity
 *  net.minecraft.util.ITickable
 *  net.minecraft.util.NonNullList
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.world.World
 */
package xol.lostinfinity.block.tileentity;

import net.minecraft.world.entity.player.Player;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.util.ITickable;
import net.minecraft.core.NonNullList;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import xol.lostinfinity.item.misc.ItemShipmentBox;
import xol.lostinfinity.mob.entity.misc.EntitySupplyTrader;

public class BlockEntityShipmentFiller
extends BlockEntity
implements IInventory,
ITickable {
    private NonNullList<ItemStack> inventory = NonNullList.func_191197_a((int)30, (Object)ItemStack.field_190927_a);

    public void func_73660_a() {
        for (int i = 2; i < this.inventory.size(); ++i) {
            if (((ItemStack)this.inventory.get(i)).func_190926_b()) continue;
            this.inventory.set(i, (Object)ItemStack.field_190927_a);
        }
        ItemStack inputStack = (ItemStack)this.inventory.get(0);
        ItemStack boxStack = (ItemStack)this.inventory.get(1);
        Item boxItem = boxStack.func_77973_b();
        if (!(boxItem instanceof ItemShipmentBox)) {
            return;
        }
        if (!this.field_145850_b.field_72995_K && !boxStack.func_77942_o()) {
            boxStack.func_77982_d(new CompoundTag());
        }
        if (!inputStack.func_190926_b()) {
            int[] curIDs = boxStack.func_77978_p().func_74759_k("itemids");
            int[] newIDs = new int[curIDs.length + 1];
            for (int j = 0; j < curIDs.length; ++j) {
                newIDs[j] = curIDs[j];
            }
            ItemStack[] shipmentItems = ItemShipmentBox.getItemArray();
            boolean found = false;
            for (int i = 0; i < shipmentItems.length; ++i) {
                if (!shipmentItems[i].func_77969_a(inputStack)) continue;
                newIDs[curIDs.length] = i;
                int oldWeight = boxStack.func_77978_p().func_74762_e("weight");
                boxStack.func_77978_p().func_74768_a("weight", ItemShipmentBox.getItemWeight(inputStack.func_77973_b()) + oldWeight);
                found = true;
                break;
            }
            if (found) {
                boxStack.func_77978_p().func_74783_a("itemids", newIDs);
            }
            this.func_70304_b(0);
        }
        int[] itemIds = boxStack.func_77978_p().func_74759_k("itemids");
        for (int i = 0; i < itemIds.length; ++i) {
            ItemStack stack = ItemShipmentBox.getItemArray()[itemIds[i]];
            if (stack.func_190926_b() || i + 2 >= this.inventory.size() || !((ItemStack)this.inventory.get(i + 2)).func_190926_b()) continue;
            this.inventory.set(i + 2, (Object)stack);
        }
    }

    public int func_174887_a_(int id) {
        return 0;
    }

    public void func_174885_b(int id, int value) {
    }

    public int func_174890_g() {
        return 0;
    }

    public void func_145839_a(CompoundTag compound) {
        super.func_145839_a(compound);
        ItemStackHelper.func_191283_b((CompoundTag)compound, this.inventory);
    }

    public CompoundTag func_189515_b(CompoundTag compound) {
        this.inventory.set(0, (Object)ItemStack.field_190927_a);
        for (int i = 2; i < this.inventory.size(); ++i) {
            this.inventory.set(i, (Object)ItemStack.field_190927_a);
        }
        ItemStackHelper.func_191282_a((CompoundTag)compound, this.inventory);
        return super.func_189515_b(compound);
    }

    public int func_70302_i_() {
        return this.inventory.size();
    }

    public boolean func_191420_l() {
        return this.inventory.isEmpty();
    }

    public ItemStack func_70301_a(int index) {
        return (ItemStack)this.inventory.get(index);
    }

    public ItemStack func_70298_a(int index, int count) {
        return ItemStackHelper.func_188382_a(this.inventory, (int)index, (int)count);
    }

    public ItemStack func_70304_b(int index) {
        return ItemStackHelper.func_188383_a(this.inventory, (int)index);
    }

    public void func_70299_a(int index, ItemStack stack) {
        this.inventory.set(index, (Object)stack);
        int limit = this.func_70297_j_();
        if (stack.func_190916_E() > limit) {
            stack.func_190920_e(limit);
        }
    }

    public int func_70297_j_() {
        return 1;
    }

    public boolean func_70300_a(Player player) {
        if (this.field_145850_b.func_175625_s(this.field_174879_c) != this) {
            return false;
        }
        return player.func_70092_e((double)this.field_174879_c.func_177958_n() + 0.5, (double)this.field_174879_c.func_177956_o() + 0.5, (double)this.field_174879_c.func_177952_p() + 0.5) <= 64.0;
    }

    public void func_174889_b(Player player) {
    }

    public void func_174886_c(Player player) {
    }

    public boolean func_94041_b(int index, ItemStack stack) {
        switch (index) {
            case 0: {
                if (!EntitySupplyTrader.SupplyTraderRecipe.isItemInRecipe(stack.func_77973_b())) break;
                return true;
            }
            case 1: {
                if (!(stack.func_77973_b() instanceof ItemShipmentBox)) break;
                return true;
            }
        }
        return false;
    }

    public void func_174888_l() {
    }

    public String func_70005_c_() {
        return "tile.shipment_filler";
    }

    public boolean func_145818_k_() {
        return false;
    }

    public void dropInventory() {
        this.inventory.set(0, (Object)ItemStack.field_190927_a);
        for (int i = 2; i < this.inventory.size(); ++i) {
            this.inventory.set(i, (Object)ItemStack.field_190927_a);
        }
        InventoryHelper.func_180175_a((World)this.field_145850_b, (BlockPos)this.field_174879_c, (IInventory)this);
    }
}

