/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.inventory.IInventory
 *  net.minecraft.inventory.ItemStackHelper
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.tileentity.BlockEntity
 *  net.minecraft.util.ITickable
 *  net.minecraft.util.NonNullList
 *  net.minecraft.util.SoundSource
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package xol.lostinfinity.block.tileentity;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.util.ITickable;
import net.minecraft.core.NonNullList;
import net.minecraft.sounds.SoundSource;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xol.lostinfinity.block.activator.BlockRainfallGenerator;
import xol.lostinfinity.gui.GuiHandler;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.projectile.entity.EntityAcidRainDrop;
import xol.lostinfinity.projectile.entity.EntityBaseThrowable;
import xol.lostinfinity.projectile.entity.EntityRainDrop;

public class BlockEntityRainfallGenerator
extends BlockEntity
implements IInventory,
ITickable {
    private NonNullList<ItemStack> inventory = NonNullList.func_191197_a((int)1, (Object)ItemStack.field_190927_a);
    private int burnTime;
    private int currentBurnTime;

    public String func_70005_c_() {
        return "tile.rainfall_generator";
    }

    public boolean func_145818_k_() {
        return false;
    }

    private double getROD(int multi) {
        return (-0.5 + this.field_145850_b.field_73012_v.nextDouble()) * (double)multi;
    }

    public void func_73660_a() {
        boolean burning = this.isBurning();
        boolean sync = false;
        if (this.isBurning()) {
            --this.burnTime;
            if (!this.field_145850_b.field_72995_K) {
                EntityBaseThrowable shot;
                if (this.burnTime % 30 == 0) {
                    this.field_145850_b.func_184133_a(null, this.field_174879_c, SoundInit.RAINFALL_GENERATOR, SoundSource.BLOCKS, 1.25f, 0.8f + this.field_145850_b.field_73012_v.nextFloat() * 0.4f);
                }
                if (this.field_145850_b.field_73012_v.nextInt(5) < 2) {
                    shot = new EntityAcidRainDrop(this.field_145850_b, (double)this.func_174877_v().func_177958_n() + this.getROD(20), this.func_174877_v().func_177956_o() + 100, (double)this.func_174877_v().func_177952_p() + this.getROD(20));
                    shot.func_70186_c(0.0, -0.05, 0.0, 0.7f, 0.0f);
                    this.field_145850_b.func_72838_d((Entity)shot);
                } else {
                    shot = new EntityRainDrop(this.field_145850_b, (double)this.func_174877_v().func_177958_n() + this.getROD(20), this.func_174877_v().func_177956_o() + 100, (double)this.func_174877_v().func_177952_p() + this.getROD(20));
                    shot.func_70186_c(0.0, -0.05, 0.0, 0.7f, 0.0f);
                    this.field_145850_b.func_72838_d((Entity)shot);
                }
            }
        }
        if (!this.field_145850_b.field_72995_K) {
            ItemStack fuel = (ItemStack)this.inventory.get(0);
            if ((this.isBurning() || !fuel.func_190926_b()) && !this.isBurning() && this.canSmelt()) {
                this.currentBurnTime = this.burnTime = BlockEntityRainfallGenerator.getItemBurnTime(fuel);
                if (this.isBurning()) {
                    sync = true;
                    if (!fuel.func_190926_b()) {
                        Item item = fuel.func_77973_b();
                        fuel.func_190918_g(1);
                        if (fuel.func_190926_b()) {
                            ItemStack itemContainer = item.getContainerItem(fuel);
                            this.inventory.set(0, (Object)itemContainer);
                        }
                    }
                }
            }
            if (burning != this.isBurning()) {
                sync = true;
                BlockRainfallGenerator.setState(this.isBurning(), this.field_145850_b, this.field_174879_c);
            }
        }
        if (sync) {
            this.func_70296_d();
        }
    }

    public int func_70302_i_() {
        return this.inventory.size();
    }

    public boolean func_191420_l() {
        for (ItemStack stack : this.inventory) {
            if (stack.func_190926_b()) continue;
            return false;
        }
        return true;
    }

    public ItemStack func_70301_a(int index) {
        return (ItemStack)this.inventory.get(index);
    }

    public ItemStack func_70298_a(int index, int count) {
        return ItemStackHelper.func_188382_a(this.inventory, (int)index, (int)count);
    }

    public ItemStack func_70304_b(int index) {
        return ItemStackHelper.func_188383_a(this.inventory, (int)index);
    }

    public void func_70299_a(int index, ItemStack stack) {
        boolean same;
        ItemStack itemstack = (ItemStack)this.inventory.get(index);
        this.inventory.set(index, (Object)stack);
        int limit = this.func_70297_j_();
        if (stack.func_190916_E() > limit) {
            stack.func_190920_e(limit);
        }
        boolean bl = same = stack.func_190926_b() || !stack.func_77969_a(itemstack) || !ItemStack.func_77970_a((ItemStack)stack, (ItemStack)itemstack);
        if (index == 0 && same) {
            this.func_70296_d();
        }
    }

    private boolean canSmelt() {
        ItemStack fuel = (ItemStack)this.inventory.get(0);
        return !fuel.func_190926_b();
    }

    public CompoundTag func_189515_b(CompoundTag compound) {
        super.func_189515_b(compound);
        compound.func_74768_a("BurnTime", (int)((short)this.burnTime));
        ItemStackHelper.func_191282_a((CompoundTag)compound, this.inventory);
        return compound;
    }

    public void func_145839_a(CompoundTag compound) {
        super.func_145839_a(compound);
        this.inventory = NonNullList.func_191197_a((int)this.func_70302_i_(), (Object)ItemStack.field_190927_a);
        ItemStackHelper.func_191283_b((CompoundTag)compound, this.inventory);
        this.burnTime = compound.func_74762_e("BurnTime");
        this.currentBurnTime = BlockEntityRainfallGenerator.getItemBurnTime((ItemStack)this.inventory.get(0));
    }

    public boolean isBurning() {
        return this.burnTime > 0;
    }

    @SideOnly(value=Side.CLIENT)
    public static boolean isBurning(IInventory inventory) {
        return inventory.func_174887_a_(0) > 0;
    }

    private static int getItemBurnTime(ItemStack fuel) {
        if (fuel.func_190926_b()) {
            return 0;
        }
        if (fuel.func_77973_b() == ItemInit.bagOfMagicCrystals) {
            return 200;
        }
        return 0;
    }

    public static boolean isItemFuel(ItemStack fuel) {
        return BlockEntityRainfallGenerator.getItemBurnTime(fuel) > 0;
    }

    public int func_70297_j_() {
        return 64;
    }

    public boolean func_70300_a(Player player) {
        if (this.field_145850_b.func_175625_s(this.field_174879_c) != this) {
            return false;
        }
        return player.func_70092_e((double)this.field_174879_c.func_177958_n() + 0.5, (double)this.field_174879_c.func_177956_o() + 0.5, (double)this.field_174879_c.func_177952_p() + 0.5) <= 64.0;
    }

    public void func_174889_b(Player player) {
    }

    public void func_174886_c(Player player) {
    }

    public boolean func_94041_b(int index, ItemStack stack) {
        if (index >= 1) {
            return false;
        }
        if (index == 0) {
            return BlockEntityRainfallGenerator.isItemFuel(stack);
        }
        return true;
    }

    public int getGuiID() {
        return GuiHandler.RegisteredGuis.NICRONIUM_INFUSER.getId();
    }

    public int func_174887_a_(int id) {
        switch (id) {
            case 0: {
                return this.burnTime;
            }
            case 1: {
                return this.currentBurnTime;
            }
        }
        return 0;
    }

    public void func_174885_b(int id, int value) {
        switch (id) {
            case 0: {
                this.burnTime = value;
                break;
            }
            case 1: {
                this.currentBurnTime = value;
            }
        }
    }

    public int func_174890_g() {
        return 2;
    }

    public void func_174888_l() {
        this.inventory.clear();
    }
}

