/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.item.ItemStack
 */
package xol.lostinfinity.item.classify;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

public interface IHotbarDeath {
    public boolean playedKilled(ItemStack var1, Player var2, Entity var3, float var4);
}

