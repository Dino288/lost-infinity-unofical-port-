/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.nbt.CompoundTag
 */
package xol.lostinfinity.item.basics;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.item.classify.ICooldown;

public class ItemCooldown
extends Item
implements ICooldown {
    public ItemCooldown(String regName) {
        this.setRegistryName(regName);
        this.func_77655_b(regName);
        this.func_77625_d(1);
        ItemInit.ITEMS.add(this);
    }

    public boolean showDurabilityBar(ItemStack stack) {
        if (!stack.func_77942_o()) {
            stack.func_77982_d(new CompoundTag());
            stack.func_77978_p().func_74772_a("lastUse", 0L);
        }
        long lastUse = stack.func_77978_p().func_74763_f("lastUse");
        long maxDelay = this.hasSimpleCooldown() ? (long)this.getCooldown() : (long)stack.func_77978_p().func_74762_e("ComplexCooldown");
        return System.currentTimeMillis() - lastUse <= maxDelay;
    }

    protected int getCooldown() {
        return 5000;
    }

    protected boolean hasSimpleCooldown() {
        return true;
    }

    public double getDurabilityForDisplay(ItemStack stack) {
        if (this.showDurabilityBar(stack)) {
            double result = System.currentTimeMillis() - stack.func_77978_p().func_74763_f("lastUse");
            int denominator = this.hasSimpleCooldown() ? this.getCooldown() : stack.func_77978_p().func_74762_e("ComplexCooldown");
            double fin = result / (double)denominator;
            return 1.0 - Math.pow(fin, 1.0);
        }
        return 1.0;
    }
}

