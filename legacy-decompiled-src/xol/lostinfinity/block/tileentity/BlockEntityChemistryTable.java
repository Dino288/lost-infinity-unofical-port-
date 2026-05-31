/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.player.Player
 *  net.minecraft.inventory.IInventory
 *  net.minecraft.inventory.ItemStackHelper
 *  net.minecraft.item.ItemStack
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
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.util.ITickable;
import net.minecraft.core.NonNullList;
import net.minecraft.sounds.SoundSource;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.recipes.ChemistryRecipes;

public class BlockEntityChemistryTable
extends BlockEntity
implements IInventory,
ITickable {
    private NonNullList<ItemStack> inventory = NonNullList.func_191197_a((int)4, (Object)ItemStack.field_190927_a);
    private int mix0;
    private int mix1;
    private int mix2;
    private int mix3;
    private int mix4;
    private int mix5;
    private int mix6;
    private int mix7;
    private int mix8;
    private int currentMixLevel;

    public void func_73660_a() {
        ItemStack result;
        if (!this.field_145850_b.field_72995_K && (result = ChemistryRecipes.getResult(this.func_70301_a(this.mix0), this.func_70301_a(this.mix1), this.func_70301_a(this.mix2), this.func_70301_a(this.mix3), this.func_70301_a(this.mix4), this.func_70301_a(this.mix5), this.func_70301_a(this.mix6), this.func_70301_a(this.mix7), this.func_70301_a(this.mix8))) != null && this.currentMixLevel == 9 && this.func_70301_a(3).func_190926_b()) {
            this.func_70298_a(this.mix0, 1);
            this.func_70298_a(this.mix1, 1);
            this.func_70298_a(this.mix2, 1);
            this.func_70299_a(3, result);
            this.mix0 = 0;
            this.mix1 = 0;
            this.mix2 = 0;
            this.mix3 = 0;
            this.mix4 = 0;
            this.mix5 = 0;
            this.mix6 = 0;
            this.mix7 = 0;
            this.mix8 = 0;
            this.currentMixLevel = 0;
            this.field_145850_b.func_184133_a(null, this.func_174877_v(), SoundInit.CHEMICAL_MIXING, SoundSource.BLOCKS, 1.5f, 0.7f + this.field_145850_b.field_73012_v.nextFloat() * 0.6f);
        }
    }

    public int func_174887_a_(int id) {
        switch (id) {
            case 0: {
                return this.mix0;
            }
            case 1: {
                return this.mix1;
            }
            case 2: {
                return this.mix2;
            }
            case 3: {
                return this.mix3;
            }
            case 4: {
                return this.mix4;
            }
            case 5: {
                return this.mix5;
            }
            case 6: {
                return this.mix6;
            }
            case 7: {
                return this.mix7;
            }
            case 8: {
                return this.mix8;
            }
            case 9: {
                return this.currentMixLevel;
            }
        }
        return 0;
    }

    public void func_174885_b(int id, int value) {
        switch (id) {
            case 0: {
                this.mix0 = value;
                break;
            }
            case 1: {
                this.mix1 = value;
                break;
            }
            case 2: {
                this.mix2 = value;
                break;
            }
            case 3: {
                this.mix3 = value;
                break;
            }
            case 4: {
                this.mix4 = value;
                break;
            }
            case 5: {
                this.mix5 = value;
                break;
            }
            case 6: {
                this.mix6 = value;
                break;
            }
            case 7: {
                this.mix7 = value;
                break;
            }
            case 8: {
                this.mix8 = value;
                break;
            }
            case 9: {
                this.currentMixLevel = value;
            }
        }
    }

    public int func_174890_g() {
        return 10;
    }

    public int func_70302_i_() {
        return this.inventory.size();
    }

    public boolean func_191420_l() {
        return this.inventory.isEmpty();
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
        return true;
    }

    public void func_174889_b(Player player) {
    }

    public void func_174886_c(Player player) {
    }

    public boolean func_94041_b(int index, ItemStack stack) {
        return true;
    }

    public void func_174888_l() {
    }

    public String func_70005_c_() {
        return "tile.chemistry_table";
    }

    public boolean func_145818_k_() {
        return false;
    }
}

