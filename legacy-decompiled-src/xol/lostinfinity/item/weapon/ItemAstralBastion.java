/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.client.util.ITooltipFlag
 *  net.minecraft.entity.player.Player
 *  net.minecraft.item.ItemStack
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.util.SoundSource
 *  net.minecraft.util.text.Component
 *  net.minecraft.util.text.Component
 *  net.minecraft.world.World
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package xol.lostinfinity.item.weapon;

import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundSource;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.init.TabsInit;
import xol.lostinfinity.item.basics.ItemBasic;
import xol.lostinfinity.item.classify.IHealReactive;
import xol.lostinfinity.item.classify.IMaxNullable;
import xol.lostinfinity.item.classify.IModeSelect;

public class ItemAstralBastion
extends ItemBasic
implements IMaxNullable,
IModeSelect,
IHealReactive {
    public ItemAstralBastion(String regName) {
        super(regName, TabsInit.TAB_AUXWEP);
    }

    @SideOnly(value=Side.CLIENT)
    public void func_77624_a(ItemStack stack, @Nullable Level worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add((Object)((Object)TextFmt.Green) + "Heals you receive are doubled.");
        tooltip.add((Object)((Object)TextFmt.Gold) + "Whenever you heal, store that amount (adding to any amount stored).");
        tooltip.add((Object)((Object)TextFmt.Underline) + "When you take max health damage, you block damage equal to your stored damage.");
    }

    @Override
    public float itemHealReaction(Player player, float healAmount, ItemStack stack) {
        if (!stack.func_77942_o()) {
            stack.func_77982_d(new CompoundTag());
            stack.func_77978_p().func_74768_a("shield_mode", 0);
            stack.func_77978_p().func_74776_a("stored_damage", 0.0f);
        }
        float storedDamage = stack.func_77978_p().func_74760_g("stored_damage");
        int shieldMode = stack.func_77978_p().func_74762_e("shield_mode");
        float newHeal = healAmount * 2.0f;
        if (newHeal >= player.func_110138_aP() * 0.05f) {
            if (storedDamage + newHeal <= player.func_110138_aP() * 10.0f) {
                stack.func_77978_p().func_74776_a("stored_damage", storedDamage + newHeal);
                if (shieldMode == 1) {
                    player.func_145747_a((Component)new Component((Object)((Object)TextFmt.Black) + String.format("%.2f Damage Stored", Float.valueOf(storedDamage + newHeal))));
                }
            } else {
                stack.func_77978_p().func_74776_a("stored_damage", player.func_110138_aP() * 10.0f);
            }
        }
        return newHeal;
    }

    @Override
    public void modeUpdate(ItemStack stack, Player player) {
        int shieldMode;
        if (!stack.func_77942_o()) {
            stack.func_77982_d(new CompoundTag());
            stack.func_77978_p().func_74768_a("shield_mode", 0);
            stack.func_77978_p().func_74776_a("stored_damage", 0.0f);
        }
        if ((shieldMode = stack.func_77978_p().func_74762_e("shield_mode")) == 0) {
            player.func_145747_a((Component)new Component((Object)((Object)TextFmt.Italic) + "Monitoring stored damage"));
            stack.func_77978_p().func_74768_a("shield_mode", 1);
        } else {
            player.func_145747_a((Component)new Component((Object)((Object)TextFmt.Italic) + "No longer monitoring stored damage"));
            stack.func_77978_p().func_74768_a("shield_mode", 0);
        }
    }

    @Override
    public float nullableReaction(Player player, boolean isMainHand, float originalDamage, float newDamage, ItemStack stack) {
        float storedDamage;
        if (!stack.func_77942_o()) {
            stack.func_77982_d(new CompoundTag());
            stack.func_77978_p().func_74768_a("shield_mode", 0);
            stack.func_77978_p().func_74776_a("stored_damage", 0.0f);
        }
        if ((storedDamage = stack.func_77978_p().func_74760_g("stored_damage")) > 0.0f && newDamage > 0.0f) {
            player.field_70170_p.func_184133_a(null, player.func_180425_c(), SoundInit.SHIELD_BLOCK, SoundSource.PLAYERS, 1.0f, 0.6f + player.field_70170_p.field_73012_v.nextFloat() * 0.4f);
        }
        if (storedDamage > player.func_110138_aP() * 10.0f) {
            storedDamage = player.func_110138_aP() * 10.0f;
        }
        float newStored = storedDamage;
        float finalDamage = newDamage;
        if (storedDamage > newDamage) {
            newStored -= newDamage;
            finalDamage = 0.0f;
        } else {
            finalDamage -= storedDamage;
            newStored = 0.0f;
        }
        stack.func_77978_p().func_74776_a("stored_damage", newStored);
        return finalDamage;
    }
}

