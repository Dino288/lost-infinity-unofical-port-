/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.entity.player.Player
 *  net.minecraft.entity.player.Inventory
 *  net.minecraft.init.Items
 *  net.minecraft.init.PotionTypes
 *  net.minecraft.inventory.Container
 *  net.minecraft.inventory.IInventory
 *  net.minecraft.inventory.InventoryBasic
 *  net.minecraft.inventory.Slot
 *  net.minecraft.item.ItemStack
 *  net.minecraft.potion.PotionEffect
 *  net.minecraft.potion.PotionType
 *  net.minecraft.potion.PotionUtils
 *  net.minecraft.world.World
 */
package xol.lostinfinity.gui.containers;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.Items;
import net.minecraft.init.PotionTypes;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.PotionType;
import net.minecraft.potion.PotionUtils;
import net.minecraft.world.level.Level;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.item.misc.ItemPortableBeacon;

public class ContainerPortableBeacon
extends Container {
    public final ItemStack beacon;
    private final Level world;
    private final IInventory inputSlots;

    @Nullable
    private ItemPortableBeacon getBeacon() {
        return this.beacon == null || !this.beacon.func_77973_b().equals(ItemInit.portableBeacon) ? null : (ItemPortableBeacon)this.beacon.func_77973_b();
    }

    public boolean isValidInput(ItemStack input) {
        boolean result = false;
        if (this.getBeacon() != null && input.func_77973_b().equals(Items.field_151068_bn)) {
            PotionType pot = PotionUtils.func_185191_c((ItemStack)input);
            List<PotionType> disallowedTypes = Arrays.asList(PotionTypes.field_185229_a, PotionTypes.field_185230_b, PotionTypes.field_185233_e, PotionTypes.field_185252_x, PotionTypes.field_185250_v, PotionTypes.field_185251_w, PotionTypes.field_185231_c, PotionTypes.field_185232_d);
            ItemPortableBeacon bc = this.getBeacon();
            Collection<PotionEffect> effects = bc.getPotionEffects(this.beacon);
            int limit = bc.getLimit(this.beacon);
            if (limit > effects.size() && !disallowedTypes.contains(pot)) {
                for (PotionEffect ef : pot.func_185170_a()) {
                    if (effects.contains(ef)) continue;
                    result = true;
                    break;
                }
            }
        }
        return result;
    }

    public ContainerPortableBeacon(Inventory player, Level worldIn, ItemStack beacon) {
        this.beacon = beacon;
        this.world = worldIn;
        this.inputSlots = new InventoryBasic("Portable Beacon", true, 2){

            public void func_70296_d() {
                super.func_70296_d();
                ContainerPortableBeacon.this.func_75130_a((IInventory)this);
            }
        };
        this.func_75146_a(new Slot(this.inputSlots, 0, 65, 37){

            public int func_178170_b(ItemStack stack) {
                return 1;
            }

            public boolean func_75214_a(ItemStack stack) {
                return ContainerPortableBeacon.this.isValidInput(stack);
            }

            public boolean func_82869_a(Player playerIn) {
                return this.func_75216_d();
            }
        });
        this.func_75146_a(new Slot(this.inputSlots, 1, 95, 37){

            public boolean func_75214_a(ItemStack stack) {
                return stack.func_77973_b().equals(Items.field_151117_aB) || stack.func_77973_b().equals(ItemInit.ultrapoweredCapacitor);
            }

            public int func_178170_b(ItemStack stack) {
                return 1;
            }

            public boolean func_82869_a(Player playerIn) {
                return this.func_75216_d() && (this.func_75211_c().func_77973_b().equals(Items.field_151133_ar) || this.func_75211_c().func_77973_b().equals(ItemInit.ultrapoweredCapacitor));
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
            this.updateBeaconGui();
        }
    }

    public void updateBeaconGui() {
        ItemPortableBeacon bc;
        ItemStack iteminput1 = this.inputSlots.func_70301_a(0).func_77946_l();
        ItemStack iteminput2 = this.inputSlots.func_70301_a(1).func_77946_l();
        if (!iteminput1.func_190926_b()) {
            bc = this.getBeacon();
            int limit = bc.getLimit(this.beacon);
            PotionType pot = PotionUtils.func_185191_c((ItemStack)iteminput1);
            pot.func_185170_a().stream().filter(e -> !bc.getPotionEffects(iteminput1).contains(e)).forEach(e -> {
                if (limit > bc.getPotionEffects(iteminput1).size()) {
                    bc.updatePotionEffects(iteminput1, this.beacon, (PotionEffect)e, false);
                    this.inputSlots.func_70299_a(0, ItemStack.field_190927_a);
                }
            });
        }
        if (iteminput2.func_77973_b().equals(Items.field_151117_aB)) {
            bc = this.getBeacon();
            if (bc != null) {
                bc.clearEffects(this.beacon);
                this.inputSlots.func_70299_a(1, new ItemStack(Items.field_151133_ar, 1));
            }
        } else if (iteminput2.func_77973_b().equals(ItemInit.ultrapoweredCapacitor) && (bc = this.getBeacon()) != null && bc.getLimit(this.beacon) == 5) {
            bc.setNewLimit(this.beacon, 10);
            this.inputSlots.func_70299_a(1, ItemStack.field_190927_a);
        }
    }

    public void func_75134_a(Player playerIn) {
        super.func_75134_a(playerIn);
        if (!this.world.field_72995_K) {
            this.func_193327_a(playerIn, this.world, this.inputSlots);
        }
    }

    public boolean func_75145_c(Player playerIn) {
        return true;
    }

    public ItemStack func_82846_b(Player playerIn, int index) {
        ItemStack itemstack = ItemStack.field_190927_a;
        Slot slot = (Slot)this.field_75151_b.get(index);
        if (slot != null && slot.func_75216_d()) {
            ItemStack itemstack1 = slot.func_75211_c();
            itemstack = itemstack1.func_77946_l();
            if (index == 1) {
                if (!this.func_75135_a(itemstack1, 2, 38, true)) {
                    return ItemStack.field_190927_a;
                }
                slot.func_75220_a(itemstack1, itemstack);
            } else if (index != 0 ? index >= 2 && index < 37 && !this.func_75135_a(itemstack1, 0, 1, false) : !this.func_75135_a(itemstack1, 2, 38, false)) {
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

