/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.item.ItemStack
 *  net.minecraft.nbt.CompoundTag
 */
package xol.lostinfinity.item.classify;

import net.minecraft.world.item.ItemStack;
import net.minecraft.nbt.CompoundTag;

public interface ICooldown {
    default public void startCooldown(ItemStack stack) {
        if (!stack.func_77942_o()) {
            stack.func_77982_d(new CompoundTag());
        }
        stack.func_77978_p().func_74772_a("lastUse", System.currentTimeMillis());
    }

    default public void setComplexCooldown(ItemStack stack, int cooldown) {
        if (!stack.func_77942_o()) {
            stack.func_77982_d(new CompoundTag());
        }
        stack.func_77978_p().func_74768_a("ComplexCooldown", cooldown);
    }
}

