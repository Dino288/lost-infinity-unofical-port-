/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 */
package xol.lostinfinity.recipes;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class Recipe {
    public ItemStack[] values;
    public Item result;

    public Recipe(Item result, ItemStack ... values) {
        this.result = result;
        this.values = values;
    }

    public boolean recipeMatches(ItemStack ... values) {
        boolean result = true;
        int index = 0;
        for (ItemStack stack : values) {
            if (!(stack.func_190926_b() && this.values[index].func_190926_b() || stack.func_77973_b().equals(this.values[index].func_77973_b()) && stack.func_190916_E() >= this.values[index].func_190916_E())) {
                result = false;
            }
            ++index;
            if (!result) break;
        }
        return result;
    }
}

