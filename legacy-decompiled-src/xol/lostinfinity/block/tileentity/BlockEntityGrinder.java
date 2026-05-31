/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.player.Player
 *  net.minecraft.inventory.IInventory
 *  net.minecraft.inventory.ItemStackHelper
 *  net.minecraft.item.ItemStack
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.tileentity.BlockEntity
 *  net.minecraft.util.ITickable
 *  net.minecraft.util.NonNullList
 *  net.minecraft.util.SoundSource
 */
package xol.lostinfinity.block.tileentity;

import net.minecraft.world.entity.player.Player;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.util.ITickable;
import net.minecraft.core.NonNullList;
import net.minecraft.sounds.SoundSource;
import xol.lostinfinity.block.crafting.BlockGrinder;
import xol.lostinfinity.block.tileentity.IMachine;
import xol.lostinfinity.block.tileentity.BlockEntityGearbox;
import xol.lostinfinity.gui.GuiHandler;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.init.SoundInit;

public class BlockEntityGrinder
extends BlockEntity
implements IInventory,
ITickable,
IMachine {
    private NonNullList<ItemStack> inventory = NonNullList.func_191197_a((int)2, (Object)ItemStack.field_190927_a);
    private int failTimer = 0;

    public void func_73660_a() {
        ItemStack input = (ItemStack)this.inventory.get(0);
        int inputCount = input.func_190916_E();
        if (input.func_77973_b().func_77658_a().equalsIgnoreCase("item.sunstone") && inputCount >= 5 && ((ItemStack)this.inventory.get(1)).func_190916_E() <= 64 && this.getPowered()) {
            if (!this.field_145850_b.field_72995_K) {
                BlockGrinder.setState(true, this.field_145850_b, this.field_174879_c);
            }
        } else if (!this.field_145850_b.field_72995_K) {
            BlockGrinder.setState(false, this.field_145850_b, this.field_174879_c);
        }
    }

    @Override
    public boolean getPowered() {
        for (IMachine machine : this.getConnectedMachines(this, null)) {
            if (!(machine instanceof BlockEntityGearbox)) continue;
            return ((BlockEntityGearbox)machine).getActive();
        }
        return false;
    }

    public void failGrind() {
        if (this.failTimer > 0) {
            --this.failTimer;
            return;
        }
        this.failTimer = 30;
        ItemStack input = (ItemStack)this.inventory.get(0);
        int inputCount = input.func_190916_E();
        this.field_145850_b.func_184133_a(null, this.field_174879_c, SoundInit.GENERIC_UI_4, SoundSource.BLOCKS, 1.0f, 1.0f);
        input.func_190920_e(inputCount - 1);
        this.func_70296_d();
    }

    public void grind() {
        ItemStack output;
        ItemStack input = (ItemStack)this.inventory.get(0);
        int inputCount = input.func_190916_E();
        this.func_174885_b(0, 0);
        if (((ItemStack)this.inventory.get(1)).func_190926_b()) {
            output = new ItemStack(ItemInit.sunstoneDust, 1);
        } else {
            output = (ItemStack)this.inventory.get(1);
            output.func_190920_e(output.func_190916_E() + 1);
        }
        this.inventory.set(1, (Object)output);
        input.func_190920_e(inputCount - 1);
        this.field_145850_b.func_184133_a(null, this.field_174879_c, SoundInit.WELDING, SoundSource.BLOCKS, 1.0f, 3.0f);
        this.func_70296_d();
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
        this.inventory.set(index, (Object)stack);
        int limit = this.func_70297_j_();
        if (stack.func_190916_E() > limit) {
            stack.func_190920_e(limit);
        }
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
        return false;
    }

    public void func_174888_l() {
        this.inventory.clear();
    }

    public String func_70005_c_() {
        return "tile.grinder";
    }

    public boolean func_145818_k_() {
        return false;
    }

    public CompoundTag func_189515_b(CompoundTag compound) {
        super.func_189515_b(compound);
        ItemStackHelper.func_191282_a((CompoundTag)compound, this.inventory);
        return compound;
    }

    public void func_145839_a(CompoundTag compound) {
        super.func_145839_a(compound);
        this.inventory = NonNullList.func_191197_a((int)this.func_70302_i_(), (Object)ItemStack.field_190927_a);
        ItemStackHelper.func_191283_b((CompoundTag)compound, this.inventory);
    }

    public int getGuiID() {
        return GuiHandler.RegisteredGuis.GRINDER.getId();
    }

    public int func_174887_a_(int id) {
        return 0;
    }

    public void func_174885_b(int id, int value) {
    }

    public int func_174890_g() {
        return 0;
    }
}

