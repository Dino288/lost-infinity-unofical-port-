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
 *  net.minecraftforge.common.MinecraftForge
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
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xol.lostinfinity.block.tileentity.BlockEntityNebulousBeacon;

public class ContainerNebulousBeacon
extends Container {
    private static final int PLAYER_INVENTORY_ROW_COUNT = 3;
    private static final int PLAYER_INVENTORY_COLUMN_COUNT = 9;
    private final Inventory invPlayer;
    private final BlockEntityNebulousBeacon tileEntity;
    private int lastHealth;
    private int lastDuration;

    public ContainerNebulousBeacon(Inventory invPlayer, BlockEntityNebulousBeacon tileEntity) {
        this.invPlayer = invPlayer;
        this.tileEntity = tileEntity;
        MinecraftForge.EVENT_BUS.register((Object)this);
        for (int playerSlotRow = 0; playerSlotRow < 3; ++playerSlotRow) {
            for (int playerSlotColumn = 0; playerSlotColumn < 9; ++playerSlotColumn) {
                this.func_75146_a(new Slot((IInventory)this.invPlayer, playerSlotColumn + playerSlotRow * 9 + 9, 8 + playerSlotColumn * 18, 84 + playerSlotRow * 18));
            }
        }
        for (int hotbarColumn = 0; hotbarColumn < 9; ++hotbarColumn) {
            this.func_75146_a(new Slot((IInventory)this.invPlayer, hotbarColumn, 8 + hotbarColumn * 18, 142));
        }
    }

    public boolean func_75145_c(Player playerIn) {
        return true;
    }

    public void func_75132_a(IContainerListener listener) {
        super.func_75132_a(listener);
        listener.func_175173_a((Container)this, (IInventory)this.tileEntity);
    }

    @SideOnly(value=Side.CLIENT)
    public void func_75137_b(int id, int data) {
        this.tileEntity.func_174885_b(id, data);
    }

    public void func_75142_b() {
        super.func_75142_b();
        for (int i = 0; i < this.field_75149_d.size(); ++i) {
            IContainerListener icontainerlistener = (IContainerListener)this.field_75149_d.get(i);
            if (this.lastHealth != this.tileEntity.func_174887_a_(0)) {
                icontainerlistener.func_71112_a((Container)this, 0, this.tileEntity.func_174887_a_(0));
            }
            if (this.lastDuration == this.tileEntity.func_174887_a_(1)) continue;
            icontainerlistener.func_71112_a((Container)this, 1, this.tileEntity.func_174887_a_(1));
        }
    }
}

