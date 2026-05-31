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
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.PotionInit;
import xol.lostinfinity.init.TabsInit;
import xol.lostinfinity.item.basics.ItemCooldown;
import xol.lostinfinity.item.classify.IModeSelect;
import xol.lostinfinity.item.classify.ISwitchModels;

public class ItemDrinkOfDuality
extends ItemCooldown
implements ISwitchModels,
IModeSelect {
    public ItemDrinkOfDuality(String regName) {
        super(regName);
        this.func_77637_a(TabsInit.TAB_INFINITYWEP);
        this.setModelSwitch("drink", this, 2);
    }

    public InteractionResultHolder<ItemStack> func_77659_a(Level worldIn, Player playerIn, InteractionHand handIn) {
        if (!this.showDurabilityBar(playerIn.func_184586_b(handIn))) {
            int drinkType;
            if (!worldIn.field_72995_K) {
                worldIn.func_184133_a(null, playerIn.func_180425_c(), SoundEvents.field_187664_bz, SoundSource.MASTER, 1.0f, 1.0f);
            }
            if ((drinkType = playerIn.func_184586_b(handIn).func_77978_p().func_74762_e("drink_data")) == 0) {
                playerIn.func_70690_d(new PotionEffect(PotionInit.ADRENALINE, 400, 2));
                playerIn.func_70690_d(new PotionEffect(PotionInit.LAST_BREATH, 400, 2));
            } else {
                playerIn.func_70690_d(new PotionEffect(PotionInit.ULTRAHEAVY, 400, 2));
                playerIn.func_70690_d(new PotionEffect(PotionInit.GRAVITATIONAL, 400, 2));
            }
            playerIn.func_184586_b(handIn).func_77978_p().func_74772_a("lastUse", System.currentTimeMillis());
        }
        return super.func_77659_a(worldIn, playerIn, handIn);
    }

    @Override
    protected int getCooldown() {
        return 50000;
    }

    @Override
    public void modeUpdate(ItemStack stack, Player player) {
        int attack_style;
        if (!stack.func_77942_o()) {
            stack.func_77982_d(new CompoundTag());
        }
        if ((attack_style = stack.func_77978_p().func_74762_e("drink_data")) == 0) {
            stack.func_77978_p().func_74768_a("drink_data", 1);
        } else {
            stack.func_77978_p().func_74768_a("drink_data", 0);
        }
    }

    @SideOnly(value=Side.CLIENT)
    public void func_77624_a(ItemStack stack, @Nullable Level worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add((Object)((Object)TextFmt.Gold) + "When drunk, grants one the following buffs depending on the potion drunk:");
        tooltip.add(TextFmt.getFormatting(TextFmt.Dark_Red) + "Adrenaline III");
        tooltip.add(TextFmt.getFormatting(TextFmt.Dark_Red) + "Last Breath III");
        tooltip.add(TextFmt.getFormatting(TextFmt.Dark_Aqua) + "Ultraheavy III");
        tooltip.add(TextFmt.getFormatting(TextFmt.Dark_Aqua) + "Gravitational III");
    }
}

