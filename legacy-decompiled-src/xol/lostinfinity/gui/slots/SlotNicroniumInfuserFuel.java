/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.inventory.IInventory
 *  net.minecraft.inventory.Slot
 *  net.minecraft.item.ItemStack
 */
package xol.lostinfinity.gui.slots;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import xol.lostinfinity.block.tileentity.BlockEntityNicroniumInfuser;

public class SlotNicroniumInfuserFuel
extends Slot {
    public SlotNicroniumInfuserFuel(IInventory inventoryIn, int index, int xPosition, int yPosition) {
        super(inventoryIn, index, xPosition, yPosition);
    }

    public boolean func_75214_a(ItemStack stack) {
        return BlockEntityNicroniumInfuser.isItemFuel(stack);
    }

    public int func_178170_b(ItemStack stack) {
        return super.func_178170_b(stack);
    }
}

