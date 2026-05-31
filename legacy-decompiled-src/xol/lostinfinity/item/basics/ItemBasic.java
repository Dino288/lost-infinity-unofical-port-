/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.creativetab.CreativeModeTab
 *  net.minecraft.item.Item
 */
package xol.lostinfinity.item.basics;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import xol.lostinfinity.init.ItemInit;

public class ItemBasic
extends Item {
    public ItemBasic(String regName, CreativeModeTab tab) {
        this.setRegistryName(regName);
        this.func_77655_b(regName);
        this.func_77637_a(tab);
        ItemInit.ITEMS.add(this);
    }
}

