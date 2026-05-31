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
import xol.lostinfinity.util.data.CustomDamageResult;

public interface IMaxNullable {
    public float nullableReaction(Player var1, boolean var2, float var3, float var4, ItemStack var5);

    default public float trueNullableReaction(Player player, boolean isMainHand, float originalDamage, float newDamage, ItemStack stack, CustomDamageResult result) {
        return newDamage;
    }
}

