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
import xol.lostinfinity.block.tileentity.BlockEntityCthulhuSpawner;
import xol.lostinfinity.block.tileentity.BlockEntityRainfallGenerator;

public class ContainerCthulhuSpawner
extends Container {
    private final BlockEntityCthulhuSpawner tileentity;
    private int burnTime;
    private int currentBurnTime;

    public ContainerCthulhuSpawner(Inventory player, BlockEntityCthulhuSpawner tileEntityRainfallGenerator) {
        this.tileentity = tileEntityRainfallGenerator;
        this.func_75146_a(new Slot(tileEntityRainfallGenerator, 0, 80, 28){

            public boolean func_75214_a(ItemStack stack) {
                return BlockEntityCthulhuSpawner.isItemFuel(stack);
            }

            public int func_178170_b(ItemStack stack) {
                return 64;
            }

            public int func_75219_a() {
                return 64;
            }
        });
        for (int y = 0; y < 3; ++y) {
            for (int x = 0; x < 9; ++x) {
                this.func_75146_a(new Slot((IInventory)player, x + y * 9 + 9, 8 + x * 18, 84 + y * 18));
            }
        }
        for (int x = 0; x < 9; ++x) {
            this.func_75146_a(new Slot((IInventory)player, x, 8 + x * 18, 142));
        }
    }

    public void func_75132_a(IContainerListener listener) {
        super.func_75132_a(listener);
        listener.func_175173_a((Container)this, (IInventory)this.tileentity);
    }

    public void func_75142_b() {
        super.func_75142_b();
        for (int i = 0; i < this.field_75149_d.size(); ++i) {
            IContainerListener icontainerlistener = (IContainerListener)this.field_75149_d.get(i);
            if (this.burnTime != this.tileentity.func_174887_a_(0)) {
                icontainerlistener.func_71112_a((Container)this, 0, this.tileentity.func_174887_a_(0));
            }
            if (this.currentBurnTime == this.tileentity.func_174887_a_(1)) continue;
            icontainerlistener.func_71112_a((Container)this, 1, this.tileentity.func_174887_a_(1));
        }
        this.burnTime = this.tileentity.func_174887_a_(0);
        this.currentBurnTime = this.tileentity.func_174887_a_(1);
    }

    @SideOnly(value=Side.CLIENT)
    public void func_75137_b(int id, int data) {
        this.tileentity.func_174885_b(id, data);
    }

    public boolean func_75145_c(Player playerIn) {
        return this.tileentity.func_70300_a(playerIn);
    }

    public ItemStack func_82846_b(Player playerIn, int index) {
        ItemStack itemstack = ItemStack.field_190927_a;
        Slot slot = (Slot)this.field_75151_b.get(index);
        if (slot != null && slot.func_75216_d()) {
            ItemStack itemstack1 = slot.func_75211_c();
            itemstack = itemstack1.func_77946_l();
            if (index == 2) {
                if (!this.func_75135_a(itemstack1, 1, 37, true)) {
                    return ItemStack.field_190927_a;
                }
                slot.func_75220_a(itemstack1, itemstack);
            } else if (index != 1 && index != 0 ? (BlockEntityRainfallGenerator.isItemFuel(itemstack1) ? !this.func_75135_a(itemstack1, 0, 1, false) : (index >= 3 && index < 30 ? !this.func_75135_a(itemstack1, 28, 37, false) : index >= 30 && index < 39 && !this.func_75135_a(itemstack1, 1, 28, false))) : !this.func_75135_a(itemstack1, 1, 37, false)) {
                return ItemStack.field_190927_a;
            }
            if (itemstack1.func_190926_b()) {
                slot.func_75215_d(ItemStack.field_190927_a);
            } else {
                slot.func_75218_e();
            }
            if (itemstack1.func_190916_E() == itemstack.func_190916_E()) {
                return ItemStack.field_190927_a;
            }
            slot.func_190901_a(playerIn, itemstack1);
        }
        return itemstack;
    }
}

