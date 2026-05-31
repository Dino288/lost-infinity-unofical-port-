/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.item.Item
 */
package xol.lostinfinity.item.basics;

import net.minecraft.world.item.Item;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.init.TabsInit;

public class ItemArenaToken
extends Item {
    public ItemArenaToken(String regName) {
        this.setRegistryName(regName);
        this.func_77655_b(regName);
        this.func_77637_a(TabsInit.TAB_CELESTIALARENA);
        ItemInit.ITEMS.add(this);
    }
}

