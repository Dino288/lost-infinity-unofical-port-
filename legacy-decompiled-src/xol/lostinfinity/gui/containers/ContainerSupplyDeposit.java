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

import java.util.List;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.inventory.ClickType;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import xol.lostinfinity.item.misc.ItemShipmentBox;
import xol.lostinfinity.mob.entity.misc.EntitySupplyTrader;

public class ContainerSupplyDeposit
extends Container {
    private static final int PLAYER_INVENTORY_ROW_COUNT = 3;
    private static final int PLAYER_INVENTORY_COLUMN_COUNT = 9;
    private final Inventory invPlayer;
    private final EntitySupplyTrader trader;
    private final InventoryBasic inventory;
    private final Slot inputSlot;

    public ContainerSupplyDeposit(Inventory invPlayer) {
        this.invPlayer = invPlayer;
        this.trader = (EntitySupplyTrader)((Object)invPlayer.field_70458_d.field_70170_p.func_72872_a(EntitySupplyTrader.class, invPlayer.field_70458_d.func_174813_aQ().func_186662_g(10.0)).get(0));
        this.inventory = new InventoryBasic("Deposit Box", false, 1){

            public void func_70296_d() {
                super.func_70296_d();
                ContainerSupplyDeposit.this.func_75130_a((IInventory)this);
            }
        };
        this.inputSlot = new Slot((IInventory)this.inventory, 0, 80, 35);
        this.func_75146_a(this.inputSlot);
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
        ItemStack heldStack = player.field_71071_by.func_70445_o();
        if (slotId == 0) {
            if (heldStack.func_190926_b()) {
                return super.func_184996_a(slotId, dragType, clickTypeIn, player);
            }
            if (!(heldStack.func_77973_b() instanceof ItemShipmentBox)) {
                return ItemStack.field_190927_a;
            }
            return super.func_184996_a(slotId, dragType, clickTypeIn, player);
        }
        return super.func_184996_a(slotId, dragType, clickTypeIn, player);
    }

    public void func_75130_a(IInventory inventoryIn) {
        ItemStack stack;
        super.func_75130_a(inventoryIn);
        if (inventoryIn == this.inventory && (stack = this.inventory.func_70301_a(0)).func_77973_b() instanceof ItemShipmentBox && !this.trader.field_70170_p.field_72995_K) {
            int[] itemIDs = stack.func_77978_p().func_74759_k("itemids");
            int item1Count = this.trader.getItem1Count();
            int item2Count = this.trader.getItem2Count();
            int item3Count = this.trader.getItem3Count();
            int item4Count = this.trader.getItem4Count();
            block6: for (int i = 0; i < itemIDs.length; ++i) {
                switch (itemIDs[i]) {
                    case 1: {
                        ++item1Count;
                        continue block6;
                    }
                    case 2: {
                        ++item2Count;
                        continue block6;
                    }
                    case 3: {
                        ++item3Count;
                        continue block6;
                    }
                    case 4: {
                        ++item4Count;
                    }
                }
            }
            this.trader.setItem1Count(item1Count);
            this.trader.setItem2Count(item2Count);
            this.trader.setItem3Count(item3Count);
            this.trader.setItem4Count(item4Count);
            stack.func_190918_g(1);
            this.trader.updateInventoryToClient(this.invPlayer.field_70458_d);
            List nearPlayers = this.trader.field_70170_p.func_72872_a(Player.class, this.trader.func_174813_aQ().func_186662_g(20.0));
            nearPlayers.forEach(this.trader::updateInventoryToClient);
        }
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

