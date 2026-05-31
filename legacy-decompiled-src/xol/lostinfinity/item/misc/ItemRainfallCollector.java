/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.player.Player
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.nbt.CompoundTag
 */
package xol.lostinfinity.item.misc;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.init.TabsInit;
import xol.lostinfinity.item.classify.IHotbarTick;
import xol.lostinfinity.item.classify.ISwitchModels;

public class ItemRainfallCollector
extends Item
implements IHotbarTick,
ISwitchModels {
    public ItemRainfallCollector(String regName) {
        this.func_77637_a(TabsInit.TAB_AUXMATS);
        this.setRegistryName(regName);
        this.func_77655_b(regName);
        this.func_77625_d(1);
        ItemInit.ITEMS.add(this);
        this.setModelSwitch("collection", this, 2);
    }

    @Override
    public void hotbarTick(Player player, int itemSlot, ItemStack stack) {
        if (this.showDurabilityBar(stack)) {
            long progress = stack.func_77978_p().func_74763_f("Progress");
            if (!player.field_70170_p.field_72995_K && progress >= (long)ItemRainfallCollector.getMaxProgress()) {
                stack.func_190918_g(1);
                if (player != null) {
                    player.func_191521_c(new ItemStack(ItemInit.rainfallCollectorFull));
                }
            }
        }
    }

    public boolean showDurabilityBar(ItemStack stack) {
        long progress;
        if (!stack.func_77942_o()) {
            stack.func_77982_d(new CompoundTag());
            stack.func_77978_p().func_74772_a("Progress", 0L);
            stack.func_77978_p().func_74768_a("collection_data", 0);
        }
        return (progress = stack.func_77978_p().func_74763_f("Progress")) <= (long)ItemRainfallCollector.getMaxProgress();
    }

    protected static int getMaxProgress() {
        return 20;
    }

    public double getDurabilityForDisplay(ItemStack stack) {
        if (this.showDurabilityBar(stack)) {
            double progress = Math.min(stack.func_77978_p().func_74763_f("Progress"), (long)(ItemRainfallCollector.getMaxProgress() - 1));
            double fin = progress / (double)ItemRainfallCollector.getMaxProgress();
            if (fin < 0.1) {
                stack.func_77978_p().func_74768_a("collection_data", 0);
            } else if (fin < 0.3) {
                stack.func_77978_p().func_74768_a("collection_data", 1);
            } else if (fin < 0.6) {
                stack.func_77978_p().func_74768_a("collection_data", 2);
            } else if (fin < 0.8) {
                stack.func_77978_p().func_74768_a("collection_data", 3);
            } else {
                stack.func_77978_p().func_74768_a("collection_data", 4);
            }
            return 1.0 - Math.pow(fin, 1.0);
        }
        return 1.0;
    }
}

