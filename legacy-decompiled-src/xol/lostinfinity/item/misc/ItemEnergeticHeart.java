/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.client.util.ITooltipFlag
 *  net.minecraft.entity.player.Player
 *  net.minecraft.item.ItemStack
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
import net.minecraft.world.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.PotionInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.init.TabsInit;
import xol.lostinfinity.item.basics.ItemCooldown;
import xol.lostinfinity.item.classify.IHeldTick;

public class ItemEnergeticHeart
extends ItemCooldown
implements IHeldTick {
    public ItemEnergeticHeart(String regName) {
        super(regName);
        this.func_77637_a(TabsInit.TAB_INFINITYWEP);
    }

    public InteractionResultHolder<ItemStack> func_77659_a(Level worldIn, Player playerIn, InteractionHand handIn) {
        if (!this.showDurabilityBar(playerIn.func_184586_b(handIn))) {
            if (!worldIn.field_72995_K) {
                worldIn.func_184133_a(null, playerIn.func_180425_c(), SoundInit.MAGIC_WEAPON_20, SoundSource.MASTER, 1.5f, 1.0f);
            }
            playerIn.func_70690_d(new PotionEffect(PotionInit.UNLEASHING, 400, 3));
            playerIn.func_184586_b(handIn).func_77978_p().func_74772_a("lastUse", System.currentTimeMillis());
        }
        return super.func_77659_a(worldIn, playerIn, handIn);
    }

    @Override
    protected int getCooldown() {
        return 30000;
    }

    @SideOnly(value=Side.CLIENT)
    public void func_77624_a(ItemStack stack, @Nullable Level worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add((Object)((Object)TextFmt.Gold) + "When drunk, grants Unleashing IV.");
        tooltip.add(TextFmt.getFormatting(TextFmt.Italic, TextFmt.Yellow) + "Unleashing releases bursts of energy from your body.");
        tooltip.add((Object)((Object)TextFmt.Red) + "Bursts deal 33% Max Health. Deals True damage to targets below 33% health.");
    }

    @Override
    public void heldTick(Player player, InteractionHand hand, ItemStack stack) {
        if (!player.field_70170_p.field_72995_K && player.field_70173_aa % 60 == 0) {
            player.field_70170_p.func_184133_a(null, player.func_180425_c(), SoundInit.HEART_BEAT, SoundSource.PLAYERS, 1.5f, 1.0f);
        }
    }
}

