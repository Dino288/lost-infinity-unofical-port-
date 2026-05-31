/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.client.util.ITooltipFlag
 *  net.minecraft.entity.player.Player
 *  net.minecraft.init.SoundEvents
 *  net.minecraft.item.ItemStack
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.potion.PotionEffect
 *  net.minecraft.util.InteractionResultHolder
 *  net.minecraft.util.InteractionHand
 *  net.minecraft.util.SoundSource
 *  net.minecraft.util.text.Component
 *  net.minecraft.util.text.Component
 *  net.minecraft.world.World
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package xol.lostinfinity.item.misc;

import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.world.entity.player.Player;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundSource;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.PotionInit;
import xol.lostinfinity.init.TabsInit;
import xol.lostinfinity.item.basics.ItemCooldown;
import xol.lostinfinity.item.classify.IModeSelect;

public class ItemBrewOfForbiddenArts
extends ItemCooldown
implements IModeSelect {
    public ItemBrewOfForbiddenArts(String regName) {
        super(regName);
        this.func_77637_a(TabsInit.TAB_AUXWEP);
    }

    public InteractionResultHolder<ItemStack> func_77659_a(Level worldIn, Player playerIn, InteractionHand handIn) {
        ItemStack stack = playerIn.func_184586_b(handIn);
        if (!this.showDurabilityBar(stack)) {
            if (playerIn.func_70644_a(PotionInit.PLANESPLIT)) {
                playerIn.func_184589_d(PotionInit.PLANESPLIT);
            } else {
                if (!worldIn.field_72995_K) {
                    int mode = stack.func_77978_p().func_74762_e("drink_mode");
                    playerIn.func_70690_d(new PotionEffect(PotionInit.PLANESPLIT, 72000, mode));
                    worldIn.func_184133_a(null, playerIn.func_180425_c(), SoundEvents.field_187664_bz, SoundSource.MASTER, 1.0f, 1.0f);
                }
                stack.func_77978_p().func_74772_a("lastUse", System.currentTimeMillis());
            }
        }
        return super.func_77659_a(worldIn, playerIn, handIn);
    }

    @Override
    protected int getCooldown() {
        return 5000;
    }

    @SideOnly(value=Side.CLIENT)
    public void func_77624_a(ItemStack stack, @Nullable Level worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add((Object)((Object)TextFmt.Gold) + "When drunk, grants you Plane-Split.");
        tooltip.add((Object)((Object)TextFmt.Red) + "Your health pool is limited while Plane-Split.");
        tooltip.add((Object)((Object)TextFmt.Aqua) + "Plane-Split grants a chance to dodge ANY damage.");
        tooltip.add((Object)((Object)TextFmt.Italic) + "Can select level of Plane-Split to grant.");
    }

    @Override
    public void modeUpdate(ItemStack stack, Player player) {
        int new_mode;
        if (!stack.func_77942_o()) {
            stack.func_77982_d(new CompoundTag());
            stack.func_77978_p().func_74768_a("drink_mode", 0);
        }
        if ((new_mode = stack.func_77978_p().func_74762_e("drink_mode") + 1) >= 9) {
            new_mode = 0;
        }
        stack.func_77978_p().func_74768_a("drink_mode", new_mode);
        player.func_145747_a((Component)new Component((Object)((Object)TextFmt.Italic) + "Life Cap: " + (90 - new_mode * 10) + "%, Dodge: " + (10 + new_mode * 10) + "%"));
        player.field_70170_p.func_184133_a(null, player.func_180425_c(), SoundEvents.field_187556_aj, SoundSource.MASTER, 1.0f, 1.0f);
    }
}

