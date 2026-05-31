/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.player.Player
 *  net.minecraft.item.ItemStack
 */
package xol.lostinfinity.item.classify;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

public interface IMaxReducible {
    public float reduceMaxDamage(Player var1, boolean var2, float var3, float var4, ItemStack var5);

    default public float trueReduceMaxDamage(Player player, boolean isMainHand, float damage, float reductionMultiplier, ItemStack stack) {
        return damage;
    }
}

