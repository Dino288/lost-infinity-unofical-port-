/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.entity.player.Player
 *  net.minecraft.entity.player.Inventory
 *  net.minecraft.inventory.Container
 *  net.minecraft.inventory.IInventory
 *  net.minecraft.inventory.InventoryBasic
 *  net.minecraft.inventory.InventoryCraftResult
 *  net.minecraft.inventory.Slot
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.world.World
 */
package xol.lostinfinity.gui.containers;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.inventory.InventoryCraftResult;
import net.minecraft.inventory.Slot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.item.tool.ItemForgefirePickaxe;
import xol.lostinfinity.util.Reference;

public class ContainerPickChargingTable
extends Container {
    private final Block pickChargingTable;
    private final BlockPos blockPos;
    private final Level world;
    private final IInventory outputSlot;
    private final IInventory inputSlots;
    public PickChargingStatus status = PickChargingStatus.AWAITING_INPUT;
    public int materialCost;

    public ContainerPickChargingTable(Inventory player, final Level worldIn, final BlockPos blockPosIn, Block pickChargingTable) {
        this.pickChargingTable = pickChargingTable;
        this.world = worldIn;
        this.blockPos = blockPosIn;
        this.outputSlot = new InventoryCraftResult();
        this.inputSlots = new InventoryBasic("Pickaxe Charging Table", true, 2){

            public void func_70296_d() {
                super.func_70296_d();
                ContainerPickChargingTable.this.func_75130_a((IInventory)this);
            }
        };
        this.func_75146_a(new Slot(this.inputSlots, 0, 27, 47){

            public boolean func_75214_a(ItemStack stack) {
                return stack.func_77973_b().equals(ItemInit.forgeFirePickaxe);
            }
        });
        this.func_75146_a(new Slot(this.inputSlots, 1, 76, 47){

            public boolean func_75214_a(ItemStack stack) {
                return Arrays.asList(ItemInit.getValidPickChargingCrystals()).contains(stack.func_77973_b());
            }

            public int func_75219_a() {
                return this.field_75224_c.func_70297_j_();
            }
        });
        this.func_75146_a(new Slot(this.outputSlot, 2, 134, 47){

            public boolean func_75214_a(ItemStack stack) {
                return false;
            }

            public boolean func_82869_a(Player playerIn) {
                return this.func_75216_d();
            }

            public ItemStack func_190901_a(Player thePlayer, ItemStack stack) {
                ContainerPickChargingTable.this.inputSlots.func_70299_a(0, ItemStack.field_190927_a);
                if (ContainerPickChargingTable.this.materialCost > 0) {
                    ItemStack itemstack = ContainerPickChargingTable.this.inputSlots.func_70301_a(1).func_77946_l();
                    if (!itemstack.func_190926_b() && itemstack.func_190916_E() >= ContainerPickChargingTable.this.materialCost) {
                        itemstack.func_190918_g(ContainerPickChargingTable.this.materialCost);
                        ContainerPickChargingTable.this.inputSlots.func_70299_a(1, itemstack);
                    } else {
                        ContainerPickChargingTable.this.inputSlots.func_70299_a(1, ItemStack.field_190927_a);
                    }
                } else {
                    ContainerPickChargingTable.this.inputSlots.func_70299_a(1, ItemStack.field_190927_a);
                }
                if (!worldIn.field_72995_K) {
                    worldIn.func_175718_b(1030, blockPosIn, 0);
                }
                ContainerPickChargingTable.this.inputSlots.func_70299_a(0, ItemStack.field_190927_a);
                return stack;
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

    public void func_75130_a(IInventory inventoryIn) {
        super.func_75130_a(inventoryIn);
        if (inventoryIn == this.inputSlots) {
            this.updateChargerOutput();
        }
    }

    public void updateChargerOutput() {
        ItemStack iteminput1 = this.inputSlots.func_70301_a(0).func_77946_l();
        ItemStack iteminput2 = this.inputSlots.func_70301_a(1).func_77946_l();
        if (iteminput1.func_190926_b() || iteminput2.func_190926_b()) {
            this.outputSlot.func_70299_a(0, ItemStack.field_190927_a);
            this.status = PickChargingStatus.AWAITING_INPUT;
            return;
        }
        Item[] crystals = ItemInit.getValidPickChargingCrystals();
        Optional<ChargeSource> src = Arrays.stream((Object[])crystals.clone()).map(it -> new ChargeSource((Item)it)).filter(it -> it.item.equals(iteminput2.func_77973_b())).findFirst();
        if (src.isPresent() && iteminput1.func_77973_b() instanceof ItemForgefirePickaxe && Arrays.asList(crystals).contains(iteminput2.func_77973_b())) {
            ChargeSource cs = src.get();
            if (!iteminput1.func_77942_o()) {
                iteminput1.func_77982_d(new CompoundTag());
            }
            this.materialCost = 0;
            int currentCharge = iteminput1.func_77978_p().func_74762_e(cs.key);
            int crystalAmt = iteminput2.func_190916_E();
            if (currentCharge < 250) {
                int charging = currentCharge;
                for (int x = this.materialCost; x < 10; ++x) {
                    ++this.materialCost;
                    if ((charging = Math.min(250, charging + 25)) == 250 || --crystalAmt == 0) break;
                }
                iteminput1.func_77978_p().func_74768_a(cs.key, charging);
                this.status = PickChargingStatus.VALID;
                this.outputSlot.func_70299_a(0, iteminput1);
                this.func_75142_b();
            } else {
                this.status = PickChargingStatus.ERR_FULLY_CHARGED;
                this.outputSlot.func_70299_a(0, ItemStack.field_190927_a);
                return;
            }
        }
    }

    public Optional<ChargeSource> getSource() {
        Optional<Object> module = Optional.ofNullable(null);
        ItemStack src = this.inputSlots.func_70301_a(1);
        if (!src.func_190926_b()) {
            module = Arrays.stream(ItemInit.getValidPickChargingCrystals()).filter(it -> it.equals(src.func_77973_b())).map(it -> new ChargeSource((Item)it)).findFirst();
        }
        return module;
    }

    public void func_75134_a(Player playerIn) {
        super.func_75134_a(playerIn);
        if (!this.world.field_72995_K) {
            this.func_193327_a(playerIn, this.world, this.inputSlots);
        }
    }

    public boolean func_75145_c(Player playerIn) {
        if (!this.world.func_180495_p(this.blockPos).func_177230_c().equals(this.pickChargingTable)) {
            return false;
        }
        return playerIn.func_70092_e((double)this.blockPos.func_177958_n() + 0.5, (double)this.blockPos.func_177956_o() + 0.5, (double)this.blockPos.func_177952_p() + 0.5) <= 64.0;
    }

    public ItemStack func_82846_b(Player playerIn, int index) {
        ItemStack itemstack = ItemStack.field_190927_a;
        Slot slot = (Slot)this.field_75151_b.get(index);
        if (slot != null && slot.func_75216_d()) {
            ItemStack itemstack1 = slot.func_75211_c();
            itemstack = itemstack1.func_77946_l();
            if (index == 2) {
                if (!this.func_75135_a(itemstack1, 3, 39, true)) {
                    return ItemStack.field_190927_a;
                }
                slot.func_75220_a(itemstack1, itemstack);
            } else if (index != 0 && index != 1 ? index >= 3 && index < 39 && !this.func_75135_a(itemstack1, 0, 2, false) : !this.func_75135_a(itemstack1, 3, 39, false)) {
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

    public class ChargeSource {
        final int chargeAmount = 25;
        final int chargeMax = 250;
        final String key;
        final Item item;

        public ChargeSource(Item item) {
            List<String> list = Arrays.asList(item.getRegistryName().func_110623_a().split("_"));
            this.key = list.get(list.size() - 1);
            this.item = item;
        }
    }

    public static enum PickChargingStatus {
        AWAITING_INPUT("Awaiting valid charging configuration..."),
        VALID("Valid charging configuration detected, proceed."),
        ERR_FULLY_CHARGED("The pickaxe is already at full charge of the provided source.");

        final String descriptor;

        private PickChargingStatus(String descriptor) {
            this.descriptor = descriptor;
        }

        public int getColor() {
            switch (this) {
                case AWAITING_INPUT: {
                    return Reference.getDecimalColorFromRGB(250, 250, 100);
                }
                case ERR_FULLY_CHARGED: {
                    return Reference.getDecimalColorFromRGB(200, 50, 50);
                }
                case VALID: {
                    return Reference.getDecimalColorFromRGB(100, 220, 100);
                }
            }
            return Reference.getDecimalColorFromRGB(255, 0, 0);
        }
    }
}

