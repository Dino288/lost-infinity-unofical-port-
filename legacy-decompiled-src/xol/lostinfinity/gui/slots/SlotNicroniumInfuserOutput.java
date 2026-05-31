/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.player.Player
 *  net.minecraft.inventory.IInventory
 *  net.minecraft.inventory.Slot
 *  net.minecraft.item.ItemStack
 */
package xol.lostinfinity.gui.slots;

import net.minecraft.world.entity.player.Player;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.world.item.ItemStack;

public class SlotNicroniumInfuserOutput
extends Slot {
    private final Player player;
    private int removeCount;

    public SlotNicroniumInfuserOutput(Player player, IInventory inventoryIn, int index, int xPosition, int yPosition) {
        super(inventoryIn, index, xPosition, yPosition);
        this.player = player;
    }

    public boolean func_75214_a(ItemStack stack) {
        return false;
    }

    public ItemStack func_190901_a(Player player, ItemStack stack) {
        this.func_75208_c(stack);
        super.func_190901_a(player, stack);
        return stack;
    }

    public ItemStack func_75209_a(int amount) {
        if (this.func_75216_d()) {
            this.removeCount += Math.min(amount, this.func_75211_c().func_190916_E());
        }
        return super.func_75209_a(amount);
    }
}

