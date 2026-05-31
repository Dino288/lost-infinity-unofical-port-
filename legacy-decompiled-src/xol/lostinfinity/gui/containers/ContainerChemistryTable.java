/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.player.Player
 *  net.minecraft.entity.player.Inventory
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
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IContainerListener;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xol.lostinfinity.block.tileentity.BlockEntityChemistryTable;

public class ContainerChemistryTable
extends Container {
    private static final int PLAYER_INVENTORY_ROW_COUNT = 3;
    private static final int PLAYER_INVENTORY_COLUMN_COUNT = 9;
    private final Inventory invPlayer;
    private final BlockEntityChemistryTable tileEntity;
    private final Slot inputSlot0;
    private final Slot inputSlot1;
    private final Slot inputSlot2;
    private final Slot outputSlot;
    private int mix0;
    private int mix1;
    private int mix2;
    private int mix3;
    private int mix4;
    private int mix5;
    private int mix6;
    private int mix7;
    private int mix8;
    private int currentMixLevel = 0;

    public ContainerChemistryTable(Inventory invPlayer, BlockEntityChemistryTable tileEntity) {
        this.invPlayer = invPlayer;
        this.tileEntity = tileEntity;
        this.inputSlot0 = new Slot((IInventory)tileEntity, 0, 18, 12);
        this.inputSlot1 = new Slot((IInventory)tileEntity, 1, 18, 34);
        this.inputSlot2 = new Slot((IInventory)tileEntity, 2, 18, 56);
        this.outputSlot = new Slot((IInventory)tileEntity, 3, 142, 35);
        this.func_75146_a(this.inputSlot0);
        this.func_75146_a(this.inputSlot1);
        this.func_75146_a(this.inputSlot2);
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

    public ItemStack func_82846_b(Player playerIn, int index) {
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
        return true;
    }

    public void func_75142_b() {
        super.func_75142_b();
        for (int i = 0; i < this.field_75149_d.size(); ++i) {
            IContainerListener listener = (IContainerListener)this.field_75149_d.get(i);
            if (this.mix0 != this.tileEntity.func_174887_a_(0)) {
                listener.func_71112_a((Container)this, 0, this.tileEntity.func_174887_a_(0));
            }
            if (this.mix1 != this.tileEntity.func_174887_a_(1)) {
                listener.func_71112_a((Container)this, 1, this.tileEntity.func_174887_a_(1));
            }
            if (this.mix2 != this.tileEntity.func_174887_a_(2)) {
                listener.func_71112_a((Container)this, 2, this.tileEntity.func_174887_a_(2));
            }
            if (this.mix3 != this.tileEntity.func_174887_a_(3)) {
                listener.func_71112_a((Container)this, 3, this.tileEntity.func_174887_a_(3));
            }
            if (this.mix4 != this.tileEntity.func_174887_a_(4)) {
                listener.func_71112_a((Container)this, 4, this.tileEntity.func_174887_a_(4));
            }
            if (this.mix5 != this.tileEntity.func_174887_a_(5)) {
                listener.func_71112_a((Container)this, 5, this.tileEntity.func_174887_a_(5));
            }
            if (this.mix6 != this.tileEntity.func_174887_a_(6)) {
                listener.func_71112_a((Container)this, 6, this.tileEntity.func_174887_a_(6));
            }
            if (this.mix7 != this.tileEntity.func_174887_a_(7)) {
                listener.func_71112_a((Container)this, 7, this.tileEntity.func_174887_a_(7));
            }
            if (this.mix8 != this.tileEntity.func_174887_a_(8)) {
                listener.func_71112_a((Container)this, 8, this.tileEntity.func_174887_a_(8));
            }
            if (this.currentMixLevel == this.tileEntity.func_174887_a_(9)) continue;
            listener.func_71112_a((Container)this, 9, this.tileEntity.func_174887_a_(9));
        }
        this.mix0 = this.tileEntity.func_174887_a_(0);
        this.mix1 = this.tileEntity.func_174887_a_(1);
        this.mix2 = this.tileEntity.func_174887_a_(2);
        this.mix3 = this.tileEntity.func_174887_a_(3);
        this.mix4 = this.tileEntity.func_174887_a_(4);
        this.mix5 = this.tileEntity.func_174887_a_(5);
        this.mix6 = this.tileEntity.func_174887_a_(6);
        this.mix7 = this.tileEntity.func_174887_a_(7);
        this.mix8 = this.tileEntity.func_174887_a_(8);
        this.currentMixLevel = this.tileEntity.func_174887_a_(9);
    }
}

