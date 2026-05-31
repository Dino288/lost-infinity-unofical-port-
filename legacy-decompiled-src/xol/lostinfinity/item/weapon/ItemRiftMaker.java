/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.client.util.ITooltipFlag
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.SoundSource
 *  net.minecraft.world.World
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package xol.lostinfinity.item.weapon;

import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.init.TabsInit;
import xol.lostinfinity.item.basics.ItemCooldown;
import xol.lostinfinity.item.classify.IMaxNullable;
import xol.lostinfinity.util.data.IMaxAttack;

public class ItemRiftMaker
extends ItemCooldown
implements IMaxNullable,
IMaxAttack {
    public ItemRiftMaker(String regName) {
        super(regName);
        this.func_77637_a(TabsInit.TAB_AUXWEP);
    }

    @Override
    protected int getCooldown() {
        return 3000;
    }

    @Override
    public float nullableReaction(Player player, boolean isMainHand, float originalDamage, float newDamage, ItemStack stack) {
        if (!this.showDurabilityBar(stack)) {
            player.field_70170_p.func_184133_a(null, player.func_180425_c(), SoundInit.SHIELD_BLOCK, SoundSource.PLAYERS, 1.0f, 0.8f + player.field_70170_p.field_73012_v.nextFloat() * 0.4f);
            stack.func_77978_p().func_74772_a("lastUse", System.currentTimeMillis());
            return 0.0f;
        }
        for (LivingEntity near_creature : player.field_70170_p.func_72872_a(LivingEntity.class, player.func_174813_aQ().func_72314_b(10.0, 7.0, 10.0))) {
            if (near_creature.func_110124_au().equals(player.func_110124_au())) continue;
            IMaxAttack.dealMaxHealth((Entity)player, near_creature, 10);
            player.func_70691_i(near_creature.func_110138_aP() * 0.1f);
        }
        return newDamage;
    }

    @SideOnly(value=Side.CLIENT)
    public void func_77624_a(ItemStack stack, @Nullable Level worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add((Object)((Object)TextFmt.Light_Purple) + "When held, blocks the next max health damage hit.");
        tooltip.add((Object)((Object)TextFmt.Gold) + "Upon blocking, this goes on a short cooldown.");
        tooltip.add((Object)((Object)TextFmt.Red) + "While on cooldown, taking a hit causes you to lifesteal 10% max health from everything nearby.");
    }
}

