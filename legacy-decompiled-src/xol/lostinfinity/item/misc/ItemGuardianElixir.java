/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.client.util.ITooltipFlag
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.init.SoundEvents
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
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.sounds.SoundEvents;
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
import xol.lostinfinity.init.TabsInit;
import xol.lostinfinity.item.basics.ItemCooldown;
import xol.lostinfinity.item.classify.IHotbarDeath;

public class ItemGuardianElixir
extends ItemCooldown
implements IHotbarDeath {
    public ItemGuardianElixir(String regName) {
        super(regName);
        this.func_77637_a(TabsInit.TAB_INFINITYWEP);
    }

    public InteractionResultHolder<ItemStack> func_77659_a(Level worldIn, Player playerIn, InteractionHand handIn) {
        if (!this.showDurabilityBar(playerIn.func_184586_b(handIn))) {
            if (!worldIn.field_72995_K) {
                worldIn.func_184133_a(null, playerIn.func_180425_c(), SoundEvents.field_187664_bz, SoundSource.MASTER, 1.0f, 1.0f);
            }
            playerIn.func_70690_d(new PotionEffect(PotionInit.IRONHEART, 300));
            playerIn.func_184586_b(handIn).func_77978_p().func_74772_a("lastUse", System.currentTimeMillis());
        }
        return super.func_77659_a(worldIn, playerIn, handIn);
    }

    @Override
    protected int getCooldown() {
        return 45000;
    }

    @SideOnly(value=Side.CLIENT)
    public void func_77624_a(ItemStack stack, @Nullable Level worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add((Object)((Object)TextFmt.Gold) + "When drunk, grants the Ironheart buff.");
        tooltip.add((Object)((Object)TextFmt.Aqua) + "When taking max health damage that would kill you, activate this elixir instead.");
        tooltip.add(TextFmt.getFormatting(TextFmt.Italic, TextFmt.Dark_Red) + "Ironheart grants immunity to max health damage.");
    }

    @Override
    public boolean playedKilled(ItemStack stack, Player player, Entity attacker, float damageDealt) {
        Level world = player.field_70170_p;
        if (!this.showDurabilityBar(stack)) {
            stack.func_77978_p().func_74772_a("lastUse", System.currentTimeMillis());
            if (!world.field_72995_K) {
                world.func_184133_a(null, player.func_180425_c(), SoundEvents.field_187664_bz, SoundSource.MASTER, 1.0f, 1.0f);
                player.func_70690_d(new PotionEffect(PotionInit.IRONHEART, 300));
            }
            return false;
        }
        return true;
    }
}

