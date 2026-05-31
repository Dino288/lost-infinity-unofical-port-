/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.entity.player.Player
 *  net.minecraft.entity.player.Inventory
 *  net.minecraft.inventory.Container
 *  net.minecraft.inventory.IContainerListener
 *  net.minecraft.inventory.IInventory
 *  net.minecraft.inventory.Slot
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.world.World
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package xol.lostinfinity.gui.containers;

import java.util.Arrays;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IContainerListener;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.util.Reference;

public class ContainerCompressionTable
extends Container {
    private int progress;
    private final Block compTable;
    private final IInventory inv;
    private final BlockPos blockPos;
    private final Level world;
    public CompressionTableStatus status = CompressionTableStatus.AWAITING_INPUT;

    public ContainerCompressionTable(Inventory player, Level worldIn, BlockPos blockPosIn, Block compTable, IInventory inv) {
        this.compTable = compTable;
        this.blockPos = blockPosIn;
        this.world = worldIn;
        this.inv = inv;
        this.func_75146_a(new Slot(inv, 0, 39, 35){

            public boolean func_75214_a(ItemStack stack) {
                Item[] validItems = new Item[]{ItemInit.astralliumIngot, ItemInit.crystoniumIngot, ItemInit.detheriumIngot, ItemInit.emberiumIngot, ItemInit.incadiumIngot, ItemInit.hextoriumIngot, ItemInit.kylaxiumIngot, ItemInit.noxeriumIngot, ItemInit.olysiumIngot, ItemInit.velloriumIngot, ItemInit.xeroviumIngot, ItemInit.phytrosiumIngot, ItemInit.kyvoriumIngot, ItemInit.biosynthiumIngot, ItemInit.maliciumIngot, ItemInit.etheriumIngot, ItemInit.polariumIngot};
                return Arrays.stream(validItems).anyMatch(it -> stack.func_77973_b().equals(it));
            }
        });
        this.func_75146_a(new Slot(inv, 1, 116, 35){

            public boolean func_75214_a(ItemStack stack) {
                return false;
            }

            public boolean func_82869_a(Player playerIn) {
                return this.func_75216_d();
            }
        });
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 9; ++j) {
                this.func_75146_a(new Slot((IInventory)player, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }
        for (int k = 0; k < 9; ++k) {
            this.func_75146_a(new Slot((IInventory)player, k, 8 + k * 18, 142));
        }
    }

    public boolean func_75145_c(Player playerIn) {
        if (!this.world.func_180495_p(this.blockPos).func_177230_c().equals(this.compTable)) {
            return false;
        }
        return playerIn.func_70092_e((double)this.blockPos.func_177958_n() + 0.5, (double)this.blockPos.func_177956_o() + 0.5, (double)this.blockPos.func_177952_p() + 0.5) <= 64.0;
    }

    public void func_75132_a(IContainerListener listener) {
        super.func_75132_a(listener);
        listener.func_175173_a((Container)this, this.inv);
    }

    public void func_75142_b() {
        super.func_75142_b();
        for (int i = 0; i < this.field_75149_d.size(); ++i) {
            IContainerListener icontainerlistener = (IContainerListener)this.field_75149_d.get(i);
            if (this.progress == this.inv.func_174887_a_(0)) continue;
            icontainerlistener.func_71112_a((Container)this, 0, this.inv.func_174887_a_(0));
        }
        this.progress = this.inv.func_174887_a_(0);
    }

    @SideOnly(value=Side.CLIENT)
    public void func_75137_b(int id, int data) {
        this.inv.func_174885_b(id, data);
    }

    public ItemStack func_82846_b(Player playerIn, int index) {
        ItemStack itemstack = ItemStack.field_190927_a;
        Slot slot = (Slot)this.field_75151_b.get(index);
        if (slot != null && slot.func_75216_d()) {
            ItemStack itemstack1 = slot.func_75211_c();
            itemstack = itemstack1.func_77946_l();
            if (index == 2) {
                if (!this.func_75135_a(itemstack1, 3, 38, true)) {
                    return ItemStack.field_190927_a;
                }
                slot.func_75220_a(itemstack1, itemstack);
            } else if (index != 0 ? index >= 2 && index < 38 && !this.func_75135_a(itemstack1, 0, 1, false) : !this.func_75135_a(itemstack1, 2, 38, false)) {
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

    public static enum CompressionTableStatus {
        AWAITING_INPUT("Awaiting valid compression input..."),
        IN_PROGRESS("Compression in progress..."),
        COMPLETE("Compression has been completed."),
        VALID("Valid compression input detected, proceed.");

        final String descriptor;

        private CompressionTableStatus(String descriptor) {
            this.descriptor = descriptor;
        }

        public int getColor() {
            switch (this) {
                case AWAITING_INPUT: 
                case IN_PROGRESS: {
                    return Reference.getDecimalColorFromRGB(250, 250, 100);
                }
                case VALID: 
                case COMPLETE: {
                    return Reference.getDecimalColorFromRGB(100, 220, 100);
                }
            }
            return Reference.getDecimalColorFromRGB(255, 0, 0);
        }
    }
}

