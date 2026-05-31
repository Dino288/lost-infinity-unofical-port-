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

import java.util.concurrent.ThreadLocalRandom;
import net.minecraft.world.entity.player.Player;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.util.ITickable;
import net.minecraft.core.NonNullList;
import net.minecraft.sounds.SoundSource;
import xol.lostinfinity.block.crafting.BlockWeldingChamber;
import xol.lostinfinity.gui.GuiHandler;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.init.SoundInit;

public class BlockEntityWeldingChamber
extends BlockEntity
implements IInventory,
ITickable {
    private NonNullList<ItemStack> inventory = NonNullList.func_191197_a((int)2, (Object)ItemStack.field_190927_a);
    private final int smeltTime = 300;
    private final int maxHeat = 6000;
    private int currentSmeltTime;
    private int heat = 3000;
    private int acetylene = 4;

    public void func_73660_a() {
        ItemStack input = (ItemStack)this.inventory.get(0);
        int inputCount = input.func_190916_E();
        if (input.func_77973_b().func_77658_a().equalsIgnoreCase("item.atomite_fragments") && inputCount >= 5 && ((ItemStack)this.inventory.get(1)).func_190916_E() <= 64) {
            BlockWeldingChamber.setState(true, this.field_145850_b, this.field_174879_c);
            this.currentSmeltTime = this.func_174887_a_(0) + 1;
            if (!this.calculateHeat(input, inputCount)) {
                return;
            }
            if (this.currentSmeltTime == 300) {
                this.fuseAtomite(input, inputCount);
            }
        } else {
            BlockWeldingChamber.setState(false, this.field_145850_b, this.field_174879_c);
            this.currentSmeltTime = 0;
            if (this.heat != 3000) {
                this.cool();
            }
        }
    }

    private boolean calculateHeat(ItemStack input, int inputCount) {
        int offset;
        int targetAcetyleneLevel = 0;
        int multiplier = 0;
        int n = offset = ThreadLocalRandom.current().nextInt(2) == 0 ? -(ThreadLocalRandom.current().nextInt(50) + 1) : ThreadLocalRandom.current().nextInt(50) + 1;
        if (this.heat >= this.maxHeat || this.heat <= 0) {
            this.failFuse(input, inputCount);
            return false;
        }
        if ((double)((float)this.currentSmeltTime / 300.0f) <= 0.2) {
            targetAcetyleneLevel = 1;
            multiplier = 20;
        } else if ((double)((float)this.currentSmeltTime / 300.0f) <= 0.4) {
            targetAcetyleneLevel = 4;
            multiplier = 30;
        } else if ((double)((float)this.currentSmeltTime / 300.0f) <= 0.6) {
            targetAcetyleneLevel = 2;
            multiplier = 30;
        } else if ((double)((float)this.currentSmeltTime / 300.0f) <= 0.8) {
            targetAcetyleneLevel = 6;
            multiplier = 25;
        } else if ((double)((float)this.currentSmeltTime / 300.0f) <= 1.0) {
            targetAcetyleneLevel = 2;
            multiplier = 25;
        }
        int diff = this.acetylene - targetAcetyleneLevel;
        this.heat += diff * multiplier + offset;
        return true;
    }

    private void failFuse(ItemStack input, int inputCount) {
        this.currentSmeltTime = 0;
        this.heat = 3000;
        this.field_145850_b.func_184133_a(null, this.field_174879_c, SoundInit.GENERIC_UI_4, SoundSource.BLOCKS, 1.0f, 1.0f);
        input.func_190920_e(inputCount - 5);
        this.func_70296_d();
    }

    private void cool() {
        if (this.heat == 2999) {
            ++this.heat;
        } else if (this.heat == 3001) {
            --this.heat;
        } else if (this.heat > 3000) {
            this.heat -= 4;
        } else if (this.heat < 3000) {
            this.heat += 4;
        }
    }

    private void fuseAtomite(ItemStack input, int inputCount) {
        ItemStack output;
        this.func_174885_b(0, 0);
        if (((ItemStack)this.inventory.get(1)).func_190926_b()) {
            output = new ItemStack(ItemInit.weldedAtomite, 1);
        } else {
            output = (ItemStack)this.inventory.get(1);
            output.func_190920_e(output.func_190916_E() + 1);
        }
        this.inventory.set(1, (Object)output);
        input.func_190920_e(inputCount - 5);
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

    public int func_174887_a_(int id) {
        switch (id) {
            case 0: {
                return this.currentSmeltTime;
            }
            case 1: {
                return this.heat;
            }
            case 2: {
                return this.acetylene;
            }
        }
        return 0;
    }

    public void func_174885_b(int id, int value) {
        switch (id) {
            case 0: {
                this.currentSmeltTime = value;
                break;
            }
            case 1: {
                this.heat = value;
                break;
            }
            case 2: {
                if (value < 0) {
                    value = 0;
                } else if (value > 7) {
                    value = 7;
                }
                this.acetylene = value;
            }
        }
    }

    public int func_174890_g() {
        return 3;
    }

    public void func_174888_l() {
        this.inventory.clear();
    }

    public String func_70005_c_() {
        return "tile.welding_chamber";
    }

    public boolean func_145818_k_() {
        return false;
    }

    public CompoundTag func_189515_b(CompoundTag compound) {
        super.func_189515_b(compound);
        compound.func_74768_a("currentSmeltTime", this.currentSmeltTime);
        compound.func_74768_a("heat", this.heat);
        compound.func_74768_a("acetylene", this.acetylene);
        ItemStackHelper.func_191282_a((CompoundTag)compound, this.inventory);
        return compound;
    }

    public void func_145839_a(CompoundTag compound) {
        super.func_145839_a(compound);
        this.inventory = NonNullList.func_191197_a((int)this.func_70302_i_(), (Object)ItemStack.field_190927_a);
        ItemStackHelper.func_191283_b((CompoundTag)compound, this.inventory);
        this.currentSmeltTime = compound.func_74762_e("currentSmeltTime");
        this.heat = compound.func_74762_e("heat");
        this.acetylene = compound.func_74762_e("acetylene");
    }

    public int getSmeltTime() {
        return this.smeltTime;
    }

    public int getMaxHeat() {
        return this.maxHeat;
    }

    public int getGuiID() {
        return GuiHandler.RegisteredGuis.WELDING_CHAMBER.getId();
    }
}

