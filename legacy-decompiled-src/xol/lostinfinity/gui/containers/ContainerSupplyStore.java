/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.player.Player
 *  net.minecraft.entity.player.Inventory
 *  net.minecraft.inventory.ClickType
 *  net.minecraft.inventory.Container
 *  net.minecraft.inventory.IInventory
 *  net.minecraft.inventory.InventoryBasic
 *  net.minecraft.inventory.Slot
 *  net.minecraft.item.ItemStack
 */
package xol.lostinfinity.gui.containers;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.inventory.ClickType;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import xol.lostinfinity.mob.entity.misc.EntitySupplyTrader;

public class ContainerSupplyStore
extends Container {
    private static final int PLAYER_INVENTORY_ROW_COUNT = 3;
    private static final int PLAYER_INVENTORY_COLUMN_COUNT = 9;
    private final Inventory invPlayer;
    private final EntitySupplyTrader trader;
    private final InventoryBasic inventory;
    private final Slot outputSlot;

    public ContainerSupplyStore(Inventory invPlayer) {
        this.invPlayer = invPlayer;
        this.trader = (EntitySupplyTrader)((Object)invPlayer.field_70458_d.field_70170_p.func_72872_a(EntitySupplyTrader.class, invPlayer.field_70458_d.func_174813_aQ().func_186662_g(10.0)).get(0));
        this.inventory = new InventoryBasic("Supply Store", false, 1);
        this.outputSlot = new Slot((IInventory)this.inventory, 0, 120, 33);
        this.func_75146_a(this.outputSlot);
        for (int playerSlotIndexY = 0; playerSlotIndexY < 3; ++playerSlotIndexY) {
            for (int playerSlotIndexX = 0; playerSlotIndexX < 9; ++playerSlotIndexX) {
                this.func_75146_a(new Slot((IInventory)this.invPlayer, playerSlotIndexX + playerSlotIndexY * 9 + 9, 8 + playerSlotIndexX * 18, 84 + playerSlotIndexY * 18));
            }
        }
        for (int hotbarSlotIndex = 0; hotbarSlotIndex < 9; ++hotbarSlotIndex) {
            this.func_75146_a(new Slot((IInventory)this.invPlayer, hotbarSlotIndex, 8 + hotbarSlotIndex * 18, 142));
        }
    }

    public ItemStack func_184996_a(int slotId, int dragType, ClickType clickTypeIn, Player player) {
        if (slotId == this.outputSlot.field_75222_d) {
            if (!this.outputSlot.func_75211_c().func_190926_b() && player.field_71071_by.func_70445_o().func_77973_b() != this.outputSlot.func_75211_c().func_77973_b()) {
                return ItemStack.field_190927_a;
            }
            if (this.outputSlot.func_75211_c().func_190926_b()) {
                return ItemStack.field_190927_a;
            }
        }
        return super.func_184996_a(slotId, dragType, clickTypeIn, player);
    }

    public ItemStack func_82846_b(Player playerIn, int index) {
        return ItemStack.field_190927_a;
    }

    public boolean func_75145_c(Player playerIn) {
        return true;
    }

    public EntitySupplyTrader getTrader() {
        return this.trader;
    }
}

