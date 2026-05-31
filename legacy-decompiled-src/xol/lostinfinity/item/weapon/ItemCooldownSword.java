/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.item.Item
 *  net.minecraft.item.Item$ToolMaterial
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.SwordItem
 *  net.minecraft.nbt.CompoundTag
 */
package xol.lostinfinity.item.weapon;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.nbt.CompoundTag;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.item.classify.ICooldown;

public class ItemCooldownSword
extends SwordItem
implements ICooldown {
    public ItemCooldownSword(String regName) {
        super(Item.ToolMaterial.DIAMOND);
        this.setRegistryName(regName);
        this.func_77655_b(regName);
        ItemInit.ITEMS.add((Item)this);
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

