/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.player.Player
 *  net.minecraft.item.ItemStack
 *  net.minecraft.potion.Potion
 *  net.minecraft.potion.PotionEffect
 *  net.minecraft.util.InteractionHand
 */
package xol.lostinfinity.item.classify;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.InteractionHand;

public interface IPotionReactive {
    default public void potionAddReaction(Player player, ItemStack stack, InteractionHand hand, PotionEffect newEffect, PotionEffect prevEffect) {
    }

    default public void potionRemoveReaction(Player player, ItemStack stack, InteractionHand hand, Potion potion, PotionEffect effect) {
    }
}

