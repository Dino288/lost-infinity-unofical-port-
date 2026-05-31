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

public interface IHeldTick {
    default public void heldTick(Player player, InteractionHand hand, ItemStack stack) {
    }

    default public void startHolding(Player player, InteractionHand hand, ItemStack stack) {
    }

    default public void stopHolding(Player player, InteractionHand hand, ItemStack stack) {
    }
}

