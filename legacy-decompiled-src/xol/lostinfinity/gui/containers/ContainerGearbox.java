/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.player.Player
 *  net.minecraft.entity.player.Inventory
 *  net.minecraft.inventory.Container
 *  net.minecraft.inventory.IInventory
 *  net.minecraft.inventory.Slot
 *  net.minecraft.item.ItemStack
 */
package xol.lostinfinity.gui.containers;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import xol.lostinfinity.block.tileentity.BlockEntityGearbox;

public class ContainerGearbox
extends Container {
    private final BlockEntityGearbox tileentity;

    public ContainerGearbox(Inventory player, BlockEntityGearbox tileentity) {
        this.tileentity = tileentity;
        for (int y = 0; y < 3; ++y) {
            for (int x = 0; x < 9; ++x) {
                this.func_75146_a(new Slot((IInventory)player, x + y * 9 + 9, 8 + x * 18, 84 + y * 18));
            }
        }
        for (int x = 0; x < 9; ++x) {
            this.func_75146_a(new Slot((IInventory)player, x, 8 + x * 18, 142));
        }
    }

    public boolean func_75145_c(Player playerIn) {
        return true;
    }

    public ItemStack func_82846_b(Player playerIn, int index) {
        return ItemStack.field_190927_a;
    }
}

