/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.player.Player
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.text.Component
 *  net.minecraft.util.text.Component
 */
package xol.lostinfinity.item.classify;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Component;
import xol.lostinfinity.client.TextFmt;

public interface ItemSoulbound {
    default public String soulBoundMessage() {
        return (Object)((Object)TextFmt.Dark_Purple) + "This item is lifebound. It cannot be brought across dimensions and is lost on death.";
    }

    public static void removeSoulBound(Player play) {
        for (int i = 0; i < play.field_71071_by.func_70302_i_(); ++i) {
            if (!(play.field_71071_by.func_70301_a(i).func_77973_b() instanceof ItemSoulbound)) continue;
            play.field_71071_by.func_70299_a(i, ItemStack.field_190927_a);
            if (play.field_70170_p.field_72995_K) continue;
            play.func_145747_a((Component)new Component((Object)((Object)TextFmt.Red) + "You had a lifebound item removed from your inventory."));
        }
    }
}

