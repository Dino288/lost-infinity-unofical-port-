/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.player.Player
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.InteractionHand
 */
package xol.lostinfinity.item.classify;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.InteractionHand;

public interface IMoveTick {
    public void moveTick(Player var1, InteractionHand var2, ItemStack var3);
}

