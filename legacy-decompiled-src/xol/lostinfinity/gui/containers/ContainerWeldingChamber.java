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
 *  net.minecraft.item.ItemStack
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
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xol.lostinfinity.block.tileentity.BlockEntityWeldingChamber;

public class ContainerWeldingChamber
extends Container {
    private static final int PLAYER_INVENTORY_ROW_COUNT = 3;
    private static final int PLAYER_INVENTORY_COLUMN_COUNT = 9;
    private static final int INPUT_SLOT_INDEX = 0;
    private static final int OUTPUT_SLOT_INDEX = 1;
    private final Inventory invPlayer;
    private final BlockEntityWeldingChamber tileEntity;
    private final Slot inputSlot;
    private final Slot outputSlot;
    private int currentSmeltTime;
    private int heat;
    private int acetylene;

    public ContainerWeldingChamber(Inventory invPlayer, BlockEntityWeldingChamber tileEntity) {
        this.invPlayer = invPlayer;
        this.tileEntity = tileEntity;
        this.inputSlot = new Slot((IInventory)tileEntity, 0, 17, 27);
        this.outputSlot = new Slot((IInventory)tileEntity, 1, 143, 27);
        this.func_75146_a(this.inputSlot);
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
        ItemStack heldStack = player.field_71071_by.func_70445_o();
        ItemStack inputStack = this.inputSlot.func_75211_c();
        ItemStack outputStack = this.outputSlot.func_75211_c();
        switch (slotId) {
            case 0: {
                if (heldStack.func_190926_b()) {
                    return super.func_184996_a(slotId, dragType, clickTypeIn, player);
                }
                if (heldStack.func_77973_b().func_77658_a().equalsIgnoreCase("item.atomite_fragments")) break;
                return ItemStack.field_190927_a;
            }
            case 1: {
                if (heldStack.func_190926_b()) break;
                return ItemStack.field_190927_a;
            }
            default: {
                return super.func_184996_a(slotId, dragType, clickTypeIn, player);
            }
        }
        return super.func_184996_a(slotId, dragType, clickTypeIn, player);
    }

    public ItemStack func_82846_b(Player playerIn, int index) {
        Slot clickedSlot = (Slot)this.field_75151_b.get(index);
        Slot inputSlot = (Slot)this.field_75151_b.get(0);
        Slot outputSlot = (Slot)this.field_75151_b.get(1);
        if (clickedSlot != null && clickedSlot.func_75216_d()) {
            if (clickedSlot.equals(inputSlot) || clickedSlot.equals(outputSlot)) {
                if (!this.invPlayer.func_70441_a(clickedSlot.func_75211_c())) {
                    return ItemStack.field_190927_a;
                }
                clickedSlot.func_75215_d(ItemStack.field_190927_a);
                clickedSlot.func_75218_e();
            } else if (clickedSlot.field_75224_c.equals(this.invPlayer) && clickedSlot.func_75211_c().func_77973_b().func_77658_a().equalsIgnoreCase("item.atomite_fragments") && (inputSlot.func_75211_c().func_77973_b().func_77658_a().equalsIgnoreCase("item.atomite_fragments") || !inputSlot.func_75216_d())) {
                int inputCount;
                int clickedCount = clickedSlot.func_75211_c().func_190916_E();
                int totalCount = clickedCount + (inputCount = inputSlot.func_75211_c().func_190916_E());
                if (totalCount > inputSlot.func_75219_a()) {
                    inputSlot.func_75215_d(new ItemStack(clickedSlot.func_75211_c().func_77973_b(), inputSlot.func_75219_a()));
                    inputSlot.func_75218_e();
                    clickedSlot.func_75215_d(new ItemStack(clickedSlot.func_75211_c().func_77973_b(), totalCount - inputSlot.func_75219_a()));
                    clickedSlot.func_75218_e();
                    return ItemStack.field_190927_a;
                }
                inputSlot.func_75215_d(new ItemStack(clickedSlot.func_75211_c().func_77973_b(), totalCount));
                inputSlot.func_75218_e();
                clickedSlot.func_75215_d(ItemStack.field_190927_a);
                clickedSlot.func_75218_e();
                return ItemStack.field_190927_a;
            }
        }
        return ItemStack.field_190927_a;
    }

    public void func_75132_a(IContainerListener listener) {
        super.func_75132_a(listener);
        listener.func_175173_a((Container)this, (IInventory)this.tileEntity);
    }

    @SideOnly(value=Side.CLIENT)
    public void func_75137_b(int id, int data) {
        this.tileEntity.func_174885_b(id, data);
    }

    public boolean func_75145_c(Player playerIn) {
        return this.tileEntity.func_70300_a(playerIn);
    }

    public void func_75142_b() {
        super.func_75142_b();
        for (int i = 0; i < this.field_75149_d.size(); ++i) {
            IContainerListener listener = (IContainerListener)this.field_75149_d.get(i);
            if (this.currentSmeltTime != this.tileEntity.func_174887_a_(0)) {
                listener.func_71112_a((Container)this, 0, this.tileEntity.func_174887_a_(0));
            }
            if (this.heat != this.tileEntity.func_174887_a_(1)) {
                listener.func_71112_a((Container)this, 1, this.tileEntity.func_174887_a_(1));
            }
            if (this.acetylene == this.tileEntity.func_174887_a_(2)) continue;
            listener.func_71112_a((Container)this, 2, this.tileEntity.func_174887_a_(2));
        }
        this.currentSmeltTime = this.tileEntity.func_174887_a_(0);
        this.heat = this.tileEntity.func_174887_a_(1);
        this.acetylene = this.tileEntity.func_174887_a_(2);
    }
}

