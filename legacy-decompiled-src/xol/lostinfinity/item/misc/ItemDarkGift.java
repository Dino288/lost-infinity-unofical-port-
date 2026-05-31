/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.item.ItemEntity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.item.ItemStack
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.potion.PotionEffect
 */
package xol.lostinfinity.item.misc;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.potion.PotionEffect;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.init.PotionInit;
import xol.lostinfinity.init.TabsInit;
import xol.lostinfinity.item.basics.ItemBasic;
import xol.lostinfinity.item.classify.IHotbarDeath;
import xol.lostinfinity.item.classify.IHotbarTick;

public class ItemDarkGift
extends ItemBasic
implements IHotbarTick,
IHotbarDeath {
    public ItemDarkGift(String regName) {
        super(regName, TabsInit.TAB_AUXMATS);
    }

    @Override
    public void hotbarTick(Player player, int itemSlot, ItemStack stack) {
        int progress;
        if (!stack.func_77942_o()) {
            stack.func_77982_d(new CompoundTag());
        }
        if ((progress = stack.func_77978_p().func_74762_e("progress")) == 0) {
            player.func_70690_d(new PotionEffect(PotionInit.VULNERABILITY, 1000));
        } else if (progress == 20) {
            player.func_70690_d(new PotionEffect(PotionInit.PLAGUE, 1000, 1));
        } else if (progress == 40) {
            player.func_70690_d(new PotionEffect(PotionInit.BLOOD_TOXIN, 1000, 1));
        } else if (progress == 60) {
            player.func_70690_d(new PotionEffect(PotionInit.SPONTANEOUS_COMBUSTION, 200, 1));
        } else if (progress == 80) {
            player.func_70690_d(new PotionEffect(PotionInit.DIMENSIONAL_TEAR, 1000));
        } else if (progress == 100) {
            player.func_70690_d(new PotionEffect(PotionInit.BLIGHTED, 1000));
        }
        stack.func_77978_p().func_74768_a("progress", progress + 1);
    }

    @Override
    public boolean playedKilled(ItemStack stack, Player player, Entity attacker, float damageDealt) {
        ItemStack lifeBox = new ItemStack(ItemInit.boxOfLife);
        lifeBox.func_77982_d(new CompoundTag());
        lifeBox.func_77978_p().func_74778_a("PlayerContained", player.func_70005_c_());
        ItemEntity box = new ItemEntity(player.field_70170_p, player.field_70165_t, player.field_70163_u + 1.0, player.field_70161_v, lifeBox);
        box.field_70159_w = 0.0;
        box.field_70181_x = 0.0;
        box.field_70179_y = 0.0;
        player.field_70170_p.func_72838_d((Entity)box);
        for (int i = 0; i < player.field_71071_by.func_70302_i_(); ++i) {
            if (!player.field_71071_by.func_70301_a(i).equals(stack)) continue;
            player.field_71071_by.func_70299_a(i, ItemStack.field_190927_a);
        }
        return false;
    }
}

