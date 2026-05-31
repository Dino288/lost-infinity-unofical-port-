/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.player.Player
 *  net.minecraft.entity.player.Inventory
 *  net.minecraft.inventory.ClickType
 *  net.minecraft.inventory.Container
 *  net.minecraft.inventory.IContainerListener
 *  net.minecraft.inventory.IInventory
 *  net.minecraft.inventory.Slot
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package xol.lostinfinity.gui.containers;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.inventory.ClickType;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IContainerListener;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xol.lostinfinity.block.tileentity.BlockEntityShipmentFiller;
import xol.lostinfinity.item.misc.ItemShipmentBox;

public class ContainerShipmentFiller
extends Container {
    private static final int PLAYER_INVENTORY_ROW_COUNT = 3;
    private static final int PLAYER_INVENTORY_COLUMN_COUNT = 9;
    private final Inventory player;
    private final BlockEntityShipmentFiller tileEntity;
    private final Slot inputSlot;
    private final Slot boxSlot;
    private final Slot itemSlot0;
    private final Slot itemSlot1;
    private final Slot itemSlot2;
    private final Slot itemSlot3;
    private final Slot itemSlot4;
    private final Slot itemSlot5;
    private final Slot itemSlot6;
    private final Slot itemSlot7;
    private final Slot itemSlot8;
    private final Slot itemSlot9;
    private final Slot itemSlot10;
    private final Slot itemSlot11;
    private final Slot itemSlot12;
    private final Slot itemSlot13;
    private final Slot itemSlot14;
    private final Slot itemSlot15;
    private final Slot itemSlot16;
    private final Slot itemSlot17;
    private final Slot itemSlot18;
    private final Slot itemSlot19;
    private final Slot itemSlot20;
    private final Slot itemSlot21;
    private final Slot itemSlot22;
    private final Slot itemSlot23;
    private final Slot itemSlot24;
    private final Slot itemSlot25;
    private final Slot itemSlot26;
    private final Slot itemSlot27;

    public ContainerShipmentFiller(Inventory invPlayer, BlockEntityShipmentFiller tileEntity) {
        this.player = invPlayer;
        this.tileEntity = tileEntity;
        this.inputSlot = new Slot((IInventory)tileEntity, 0, 8, 6);
        this.boxSlot = new Slot((IInventory)tileEntity, 1, 8, 63);
        this.itemSlot0 = new Slot((IInventory)tileEntity, 2, 38, 6);
        this.itemSlot1 = new Slot((IInventory)tileEntity, 3, 57, 6);
        this.itemSlot2 = new Slot((IInventory)tileEntity, 4, 76, 6);
        this.itemSlot3 = new Slot((IInventory)tileEntity, 5, 95, 6);
        this.itemSlot4 = new Slot((IInventory)tileEntity, 6, 114, 6);
        this.itemSlot5 = new Slot((IInventory)tileEntity, 7, 133, 6);
        this.itemSlot6 = new Slot((IInventory)tileEntity, 8, 152, 6);
        this.itemSlot7 = new Slot((IInventory)tileEntity, 9, 38, 25);
        this.itemSlot8 = new Slot((IInventory)tileEntity, 10, 57, 25);
        this.itemSlot9 = new Slot((IInventory)tileEntity, 11, 76, 25);
        this.itemSlot10 = new Slot((IInventory)tileEntity, 12, 95, 25);
        this.itemSlot11 = new Slot((IInventory)tileEntity, 13, 114, 25);
        this.itemSlot12 = new Slot((IInventory)tileEntity, 14, 133, 25);
        this.itemSlot13 = new Slot((IInventory)tileEntity, 15, 152, 25);
        this.itemSlot14 = new Slot((IInventory)tileEntity, 16, 38, 44);
        this.itemSlot15 = new Slot((IInventory)tileEntity, 17, 57, 44);
        this.itemSlot16 = new Slot((IInventory)tileEntity, 18, 76, 44);
        this.itemSlot17 = new Slot((IInventory)tileEntity, 19, 95, 44);
        this.itemSlot18 = new Slot((IInventory)tileEntity, 20, 114, 44);
        this.itemSlot19 = new Slot((IInventory)tileEntity, 21, 133, 44);
        this.itemSlot20 = new Slot((IInventory)tileEntity, 22, 152, 44);
        this.itemSlot21 = new Slot((IInventory)tileEntity, 23, 38, 63);
        this.itemSlot22 = new Slot((IInventory)tileEntity, 24, 57, 63);
        this.itemSlot23 = new Slot((IInventory)tileEntity, 25, 76, 63);
        this.itemSlot24 = new Slot((IInventory)tileEntity, 26, 95, 63);
        this.itemSlot25 = new Slot((IInventory)tileEntity, 27, 114, 63);
        this.itemSlot26 = new Slot((IInventory)tileEntity, 28, 133, 63);
        this.itemSlot27 = new Slot((IInventory)tileEntity, 29, 152, 63);
        this.func_75146_a(this.inputSlot);
        this.func_75146_a(this.boxSlot);
        this.func_75146_a(this.itemSlot0);
        this.func_75146_a(this.itemSlot1);
        this.func_75146_a(this.itemSlot2);
        this.func_75146_a(this.itemSlot3);
        this.func_75146_a(this.itemSlot4);
        this.func_75146_a(this.itemSlot5);
        this.func_75146_a(this.itemSlot6);
        this.func_75146_a(this.itemSlot7);
        this.func_75146_a(this.itemSlot8);
        this.func_75146_a(this.itemSlot9);
        this.func_75146_a(this.itemSlot10);
        this.func_75146_a(this.itemSlot11);
        this.func_75146_a(this.itemSlot12);
        this.func_75146_a(this.itemSlot13);
        this.func_75146_a(this.itemSlot14);
        this.func_75146_a(this.itemSlot15);
        this.func_75146_a(this.itemSlot16);
        this.func_75146_a(this.itemSlot17);
        this.func_75146_a(this.itemSlot18);
        this.func_75146_a(this.itemSlot19);
        this.func_75146_a(this.itemSlot20);
        this.func_75146_a(this.itemSlot21);
        this.func_75146_a(this.itemSlot22);
        this.func_75146_a(this.itemSlot23);
        this.func_75146_a(this.itemSlot24);
        this.func_75146_a(this.itemSlot25);
        this.func_75146_a(this.itemSlot26);
        this.func_75146_a(this.itemSlot27);
        for (int playerSlotIndexY = 0; playerSlotIndexY < 3; ++playerSlotIndexY) {
            for (int playerSlotIndexX = 0; playerSlotIndexX < 9; ++playerSlotIndexX) {
                this.func_75146_a(new Slot((IInventory)this.player, playerSlotIndexX + playerSlotIndexY * 9 + 9, 8 + playerSlotIndexX * 18, 84 + playerSlotIndexY * 18));
            }
        }
        for (int hotbarSlotIndex = 0; hotbarSlotIndex < 9; ++hotbarSlotIndex) {
            this.func_75146_a(new Slot((IInventory)this.player, hotbarSlotIndex, 8 + hotbarSlotIndex * 18, 142));
        }
    }

    public ItemStack func_184996_a(int slotId, int dragType, ClickType clickTypeIn, Player player) {
        ItemStack heldStack = player.field_71071_by.func_70445_o();
        if (slotId == 0) {
            if (this.boxSlot.func_75211_c().func_190926_b()) {
                return ItemStack.field_190927_a;
            }
            if (this.boxSlot.func_75211_c().func_77973_b() instanceof ItemShipmentBox) {
                Item boxItem = this.boxSlot.func_75211_c().func_77973_b();
                ItemStack boxStack = this.boxSlot.func_75211_c();
                if (!(boxItem instanceof ItemShipmentBox)) {
                    return ItemStack.field_190927_a;
                }
                if (!boxStack.func_77942_o()) {
                    boxStack.func_77982_d(new CompoundTag());
                }
                int boxWeight = boxStack.func_77978_p().func_74762_e("weight");
                if (ItemShipmentBox.getNewWeight(heldStack.func_77973_b(), boxWeight) > 100) {
                    return ItemStack.field_190927_a;
                }
                if (this.tileEntity.func_94041_b(0, heldStack)) {
                    return super.func_184996_a(slotId, dragType, clickTypeIn, player);
                }
                return ItemStack.field_190927_a;
            }
            if (this.boxSlot.func_75211_c().func_77973_b() instanceof ItemShipmentBox && this.tileEntity.func_94041_b(0, heldStack)) {
                return super.func_184996_a(slotId, dragType, clickTypeIn, player);
            }
            return ItemStack.field_190927_a;
        }
        if (slotId == 1) {
            if (this.tileEntity.func_94041_b(1, heldStack) && this.boxSlot.func_75211_c().func_190926_b()) {
                return super.func_184996_a(slotId, dragType, clickTypeIn, player);
            }
            if (heldStack.func_190926_b()) {
                return super.func_184996_a(slotId, dragType, clickTypeIn, player);
            }
            return ItemStack.field_190927_a;
        }
        if (slotId >= 2 && slotId <= 29) {
            if (((Slot)this.field_75151_b.get(slotId)).func_75211_c().func_190926_b() || !heldStack.func_190926_b()) {
                return ItemStack.field_190927_a;
            }
            return super.func_184996_a(slotId, dragType, clickTypeIn, player);
        }
        return super.func_184996_a(slotId, dragType, clickTypeIn, player);
    }

    public boolean func_75145_c(Player playerIn) {
        return this.tileEntity.func_70300_a(playerIn);
    }

    public void func_75132_a(IContainerListener listener) {
        super.func_75132_a(listener);
        listener.func_175173_a((Container)this, (IInventory)this.tileEntity);
    }

    @SideOnly(value=Side.CLIENT)
    public void func_75137_b(int id, int data) {
        this.tileEntity.func_174885_b(id, data);
    }

    public ItemStack func_82846_b(Player playerIn, int index) {
        return ItemStack.field_190927_a;
    }
}

