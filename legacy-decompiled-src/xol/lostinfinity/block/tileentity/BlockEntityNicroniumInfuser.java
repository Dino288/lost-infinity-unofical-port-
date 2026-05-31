/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.player.Player
 *  net.minecraft.entity.player.ServerPlayer
 *  net.minecraft.inventory.IInventory
 *  net.minecraft.inventory.ItemStackHelper
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.potion.PotionEffect
 *  net.minecraft.tileentity.BlockEntity
 *  net.minecraft.util.ITickable
 *  net.minecraft.util.NonNullList
 *  net.minecraft.util.SoundSource
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Mth
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package xol.lostinfinity.block.tileentity;

import java.util.UUID;
import net.minecraft.world.entity.player.Player;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.util.ITickable;
import net.minecraft.core.NonNullList;
import net.minecraft.sounds.SoundSource;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xol.lostinfinity.block.crafting.BlockNicroniumInfuser;
import xol.lostinfinity.gui.GuiHandler;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.init.PotionInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.recipes.NicroniumInfuserRecipes;

public class BlockEntityNicroniumInfuser
extends BlockEntity
implements IInventory,
ITickable {
    private NonNullList<ItemStack> inventory = NonNullList.func_191197_a((int)3, (Object)ItemStack.field_190927_a);
    private int burnTime;
    private int currentBurnTime;
    private int cookTime;
    private int totalCookTime;
    private UUID placer = null;

    public String func_70005_c_() {
        return "tile.nicronium_infuser";
    }

    public boolean func_145818_k_() {
        return false;
    }

    public void func_73660_a() {
        boolean burning = this.isBurning();
        boolean sync = false;
        if (this.isBurning()) {
            --this.burnTime;
            if (!this.field_145850_b.field_72995_K && this.burnTime % 40 == 0) {
                this.field_145850_b.func_184133_a(null, this.func_174877_v(), SoundInit.INFUSER, SoundSource.BLOCKS, 1.5f, 0.5f + this.field_145850_b.field_73012_v.nextFloat());
            }
        }
        if (!this.field_145850_b.field_72995_K) {
            ItemStack input = (ItemStack)this.inventory.get(0);
            ItemStack fuel = (ItemStack)this.inventory.get(1);
            if (this.isBurning() || !fuel.func_190926_b() && !input.func_190926_b()) {
                if (!this.isBurning() && this.canSmelt()) {
                    this.currentBurnTime = this.burnTime = BlockEntityNicroniumInfuser.getItemBurnTime(fuel);
                    if (this.isBurning()) {
                        sync = true;
                        if (!fuel.func_190926_b()) {
                            Item item = fuel.func_77973_b();
                            fuel.func_190918_g(1);
                            if (fuel.func_190926_b()) {
                                ItemStack itemContainer = item.getContainerItem(fuel);
                                this.inventory.set(1, (Object)itemContainer);
                            }
                        }
                    }
                }
                if (this.isBurning() && this.canSmelt()) {
                    ++this.cookTime;
                    BlockPos pos = this.func_174877_v();
                    if (this.placer != null) {
                        for (ServerPlayer playerMP : this.field_145850_b.func_73046_m().func_184103_al().func_181057_v()) {
                            if (!playerMP.field_70170_p.equals(this.field_145850_b) || playerMP.func_110124_au().equals(this.placer) || !(playerMP.func_70011_f((double)this.func_174877_v().func_177958_n(), (double)this.func_174877_v().func_177956_o(), (double)this.func_174877_v().func_177952_p()) < 500.0)) continue;
                            playerMP.func_70690_d(new PotionEffect(PotionInit.INTANGIBLE, 200, 0));
                        }
                    }
                    if (this.cookTime >= this.totalCookTime) {
                        this.cookTime = 0;
                        this.totalCookTime = this.getCookTime((ItemStack)this.inventory.get(0));
                        this.smeltItem();
                        sync = true;
                    }
                } else {
                    this.cookTime = 0;
                }
            } else if (!this.isBurning() && this.cookTime > 0) {
                this.cookTime = Mth.func_76125_a((int)(this.cookTime - 2), (int)0, (int)this.totalCookTime);
            }
            if (burning != this.isBurning()) {
                sync = true;
                BlockNicroniumInfuser.setState(this.isBurning(), this.field_145850_b, this.field_174879_c);
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
            this.totalCookTime = this.getCookTime(stack);
            this.cookTime = 0;
            this.func_70296_d();
        }
    }

    private boolean canSmelt() {
        ItemStack input = (ItemStack)this.inventory.get(0);
        ItemStack fuel = (ItemStack)this.inventory.get(1);
        if (!input.func_190926_b() && !fuel.func_190926_b()) {
            ItemStack result = NicroniumInfuserRecipes.getResult(input);
            if (result == null || result.func_190926_b()) {
                return false;
            }
            ItemStack output = (ItemStack)this.inventory.get(2);
            if (output.func_190926_b()) {
                return true;
            }
            if (!output.func_77969_a(result)) {
                return false;
            }
            int count = output.func_190916_E() + result.func_190916_E();
            return count <= this.func_70297_j_() && count <= output.func_77976_d();
        }
        return false;
    }

    public void smeltItem() {
        if (this.canSmelt()) {
            ItemStack input = (ItemStack)this.inventory.get(0);
            ItemStack fuel = (ItemStack)this.inventory.get(1);
            ItemStack result = NicroniumInfuserRecipes.getResult(input);
            ItemStack output = (ItemStack)this.inventory.get(2);
            if (output.func_190926_b()) {
                this.inventory.set(2, (Object)result.func_77946_l());
            } else if (output.func_77973_b() == result.func_77973_b()) {
                output.func_190917_f(result.func_190916_E());
            }
            input.func_190918_g(1);
        }
    }

    private int getCookTime(ItemStack stack) {
        return 1500;
    }

    public CompoundTag func_189515_b(CompoundTag compound) {
        super.func_189515_b(compound);
        compound.func_74768_a("BurnTime", (int)((short)this.burnTime));
        compound.func_74768_a("CookTime", (int)((short)this.cookTime));
        compound.func_74768_a("TotalCookTime", (int)((short)this.totalCookTime));
        if (this.placer != null) {
            compound.func_186854_a("Placer", this.placer);
        }
        ItemStackHelper.func_191282_a((CompoundTag)compound, this.inventory);
        return compound;
    }

    public void func_145839_a(CompoundTag compound) {
        super.func_145839_a(compound);
        this.inventory = NonNullList.func_191197_a((int)this.func_70302_i_(), (Object)ItemStack.field_190927_a);
        ItemStackHelper.func_191283_b((CompoundTag)compound, this.inventory);
        this.burnTime = compound.func_74762_e("BurnTime");
        this.cookTime = compound.func_74762_e("CookTime");
        this.totalCookTime = compound.func_74762_e("TotalCookTime");
        this.placer = compound.func_186857_a("Placer");
        this.currentBurnTime = BlockEntityNicroniumInfuser.getItemBurnTime((ItemStack)this.inventory.get(1));
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
        if (fuel.func_77973_b() == ItemInit.powerfulPolarcronite) {
            return 1000;
        }
        return 0;
    }

    public static boolean isItemFuel(ItemStack fuel) {
        return BlockEntityNicroniumInfuser.getItemBurnTime(fuel) > 0;
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
        if (index >= 2) {
            return false;
        }
        if (index == 2) {
            return BlockEntityNicroniumInfuser.isItemFuel(stack);
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
            case 2: {
                return this.cookTime;
            }
            case 3: {
                return this.totalCookTime;
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
                break;
            }
            case 2: {
                this.cookTime = value;
                break;
            }
            case 3: {
                this.totalCookTime = value;
            }
        }
    }

    public int func_174890_g() {
        return 4;
    }

    public void func_174888_l() {
        this.inventory.clear();
    }

    public void setPlacer(Player placer) {
        this.placer = placer.func_110124_au();
    }
}

