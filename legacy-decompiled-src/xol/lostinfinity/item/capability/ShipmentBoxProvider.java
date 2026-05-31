/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nonnull
 *  javax.annotation.Nullable
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.nbt.NBTBase
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.util.Direction
 *  net.minecraft.util.NonNullList
 *  net.minecraftforge.common.capabilities.Capability
 *  net.minecraftforge.common.capabilities.ICapabilityProvider
 *  net.minecraftforge.common.capabilities.ICapabilitySerializable
 *  net.minecraftforge.items.CapabilityItemHandler
 *  net.minecraftforge.items.ItemStackHandler
 */
package xol.lostinfinity.item.capability;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import xol.lostinfinity.item.misc.ItemShipmentBox;

public class ShipmentBoxProvider
implements ICapabilityProvider,
ICapabilitySerializable<NBTBase> {
    private ItemStackHandler handler = new ItemStackHandler(28);

    public boolean hasCapability(@Nonnull Capability<?> capability, @Nullable Direction facing) {
        return capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY;
    }

    @Nullable
    public <T> T getCapability(@Nonnull Capability<T> capability, @Nullable Direction facing) {
        if (capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
            return (T)this.handler;
        }
        return null;
    }

    public NBTBase serializeNBT() {
        return this.handler.serializeNBT();
    }

    public void deserializeNBT(NBTBase nbt) {
        this.handler.deserializeNBT((CompoundTag)nbt);
    }

    public static int getWeight(ItemStackHandler handler) {
        int weight = 0;
        if (handler == null) {
            return 0;
        }
        for (int i = 0; i < handler.getSlots(); ++i) {
            if (handler.getStackInSlot(i).func_190926_b()) continue;
            Item item = handler.getStackInSlot(i).func_77973_b();
            weight += ItemShipmentBox.getItemWeight(item);
        }
        return weight;
    }

    public static boolean transferItems(ItemStackHandler handler, NonNullList<ItemStack> invTo) {
        int i;
        if (handler == null || invTo == null) {
            return false;
        }
        for (i = 0; i < handler.getSlots(); ++i) {
            if (handler.getStackInSlot(i).func_190926_b()) continue;
            int nextSlot = -1;
            for (int j = 0; j < invTo.size(); ++j) {
                if (!((ItemStack)invTo.get(j)).func_190926_b()) continue;
                nextSlot = j;
                break;
            }
            if (nextSlot != -1) {
                invTo.set(nextSlot, (Object)handler.getStackInSlot(i));
                handler.setStackInSlot(i, ItemStack.field_190927_a);
                continue;
            }
            return false;
        }
        for (i = 0; i < handler.getSlots(); ++i) {
            if (handler.getStackInSlot(i).func_190926_b()) continue;
            return false;
        }
        ShipmentBoxProvider.mergeStacks(invTo);
        return true;
    }

    private static void mergeStacks(NonNullList<ItemStack> inventory) {
        for (int i = 0; i < inventory.size(); ++i) {
            if (inventory.get(i) == ItemStack.field_190927_a) continue;
            for (int j = 0; j < inventory.size(); ++j) {
                if (inventory.get(j) == ItemStack.field_190927_a || ((ItemStack)inventory.get(i)).func_77973_b() != ((ItemStack)inventory.get(j)).func_77973_b() || i == j) continue;
                ((ItemStack)inventory.get(i)).func_190917_f(((ItemStack)inventory.get(j)).func_190916_E());
                inventory.set(j, (Object)ItemStack.field_190927_a);
            }
        }
    }
}

