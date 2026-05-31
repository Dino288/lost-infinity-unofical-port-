/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.block.state.BlockState
 *  net.minecraft.entity.player.Player
 *  net.minecraft.inventory.IInventory
 *  net.minecraft.inventory.ItemStackHelper
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.network.NetworkManager
 *  net.minecraft.network.play.server.SPacketUpdateBlockEntity
 *  net.minecraft.tileentity.BlockEntity
 *  net.minecraft.util.Direction
 *  net.minecraft.util.ITickable
 *  net.minecraft.util.NonNullList
 *  net.minecraft.util.math.AABB
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package xol.lostinfinity.block.tileentity;

import javax.annotation.Nullable;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.entity.player.Player;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.core.Direction;
import net.minecraft.util.ITickable;
import net.minecraft.core.NonNullList;
import net.minecraft.world.phys.AABB;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xol.lostinfinity.block.misc.BlockCthulhuSpawner;
import xol.lostinfinity.init.ItemInit;

public class BlockEntityCthulhuSpawner
extends BlockEntity
implements ITickable,
IInventory {
    public boolean spawned = false;
    private NonNullList<ItemStack> inventory = NonNullList.func_191197_a((int)1, (Object)ItemStack.field_190927_a);
    private Direction facing;
    private int burnTime;
    private int currentBurnTime;

    public void func_73660_a() {
        boolean burning = this.isBurning();
        boolean sync = false;
        if (this.isBurning()) {
            --this.burnTime;
        }
        if (!this.field_145850_b.field_72995_K) {
            if (this.canSpawn() && this.facing == Direction.NORTH) {
                this.spawned = BlockCthulhuSpawner.spawnCthulhu(this.field_145850_b, this.field_174879_c);
            }
            ItemStack fuel = (ItemStack)this.inventory.get(0);
            if ((this.isBurning() || !fuel.func_190926_b()) && !this.isBurning() && this.spawned) {
                this.currentBurnTime = this.burnTime = BlockEntityCthulhuSpawner.getItemBurnTime(fuel);
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
                if (this.spawned && !this.isBurning()) {
                    this.spawned = false;
                }
            }
        }
        if (sync) {
            this.func_70296_d();
            this.doBlockUpdate();
        }
    }

    public boolean isBurning() {
        return this.burnTime > 0;
    }

    public boolean canSpawn() {
        return !this.spawned && this.func_70301_a(0).func_190916_E() >= 2;
    }

    private static int getItemBurnTime(ItemStack fuel) {
        if (fuel.func_190926_b()) {
            return 0;
        }
        if (fuel.func_77973_b() == ItemInit.eternoCell) {
            return 300;
        }
        return 0;
    }

    public static boolean isItemFuel(ItemStack fuel) {
        return BlockEntityCthulhuSpawner.getItemBurnTime(fuel) > 0;
    }

    public int func_70302_i_() {
        return this.inventory.size();
    }

    public boolean func_191420_l() {
        return false;
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

    public int func_70297_j_() {
        return 64;
    }

    public boolean func_70300_a(Player player) {
        return this.field_145850_b.func_175625_s(this.field_174879_c) == this && player.func_70092_e((double)this.field_174879_c.func_177958_n() + 0.5, (double)this.field_174879_c.func_177956_o() + 0.5, (double)this.field_174879_c.func_177952_p() + 0.5) <= 64.0;
    }

    public void func_174889_b(Player player) {
    }

    public void func_174886_c(Player player) {
    }

    public boolean func_94041_b(int index, ItemStack stack) {
        if (index == 0) {
            return BlockEntityCthulhuSpawner.isItemFuel(stack);
        }
        return false;
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

    public String func_70005_c_() {
        return "tile.cthulhu_spawner";
    }

    public boolean func_145818_k_() {
        return false;
    }

    public Direction getFacing() {
        return BlockCthulhuSpawner.getFacing(this.field_145850_b, this.field_174879_c);
    }

    @SideOnly(value=Side.CLIENT)
    public AABB getRenderBoundingBox() {
        return INFINITE_EXTENT_AABB;
    }

    public void onLoad() {
        this.facing = this.getFacing();
    }

    public CompoundTag func_189515_b(CompoundTag compound) {
        super.func_189515_b(compound);
        compound.func_74768_a("BurnTime", (int)((short)this.burnTime));
        compound.func_74757_a("Spawned", this.spawned);
        ItemStackHelper.func_191282_a((CompoundTag)compound, this.inventory);
        return compound;
    }

    public void func_145839_a(CompoundTag compound) {
        super.func_145839_a(compound);
        this.inventory = NonNullList.func_191197_a((int)this.func_70302_i_(), (Object)ItemStack.field_190927_a);
        ItemStackHelper.func_191283_b((CompoundTag)compound, this.inventory);
        this.burnTime = compound.func_74762_e("BurnTime");
        this.currentBurnTime = BlockEntityCthulhuSpawner.getItemBurnTime((ItemStack)this.inventory.get(0));
        this.spawned = compound.func_74767_n("Spawned");
    }

    public CompoundTag func_189517_E_() {
        return this.func_189515_b(new CompoundTag());
    }

    @Nullable
    public SPacketUpdateBlockEntity func_189518_D_() {
        return new SPacketUpdateBlockEntity(this.field_174879_c, 0, this.func_189517_E_());
    }

    public void onDataPacket(NetworkManager net, SPacketUpdateBlockEntity pkt) {
        this.func_145839_a(pkt.func_148857_g());
    }

    public void doBlockUpdate() {
        BlockState blockState = this.field_145850_b.func_180495_p(this.func_174877_v());
        this.field_145850_b.func_184138_a(this.func_174877_v(), blockState, blockState, 3);
    }
}

