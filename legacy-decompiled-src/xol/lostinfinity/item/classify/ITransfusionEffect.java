/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.item.ItemStack
 *  net.minecraft.potion.Potion
 *  net.minecraft.util.InteractionHand
 */
package xol.lostinfinity.item.classify;

import java.util.List;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.world.InteractionHand;

public interface ITransfusionEffect {
    public void transfuse(Player var1, LivingEntity var2, InteractionHand var3, ItemStack var4, List<Potion> var5);
}

