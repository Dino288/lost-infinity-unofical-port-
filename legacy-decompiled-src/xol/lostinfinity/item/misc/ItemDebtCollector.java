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
 *  net.minecraft.potion.PotionEffect
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
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.PotionInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.init.TabsInit;
import xol.lostinfinity.item.basics.ItemCooldown;
import xol.lostinfinity.item.classify.IHotbarDeath;
import xol.lostinfinity.projectile.entity.EntityDebtCollectorEffect;

public class ItemDebtCollector
extends ItemCooldown
implements IHotbarDeath {
    public ItemDebtCollector(String regName) {
        super(regName);
        this.func_77637_a(TabsInit.TAB_INFINITYWEP);
    }

    @Override
    protected int getCooldown() {
        return 15000;
    }

    @SideOnly(value=Side.CLIENT)
    public void func_77624_a(ItemStack stack, @Nullable Level worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add((Object)((Object)TextFmt.Light_Purple) + "A very magical scythe.");
        tooltip.add((Object)((Object)TextFmt.Gold) + "When taking lethal damage, if there is a close enemy make them pay your debt instead.");
        tooltip.add((Object)((Object)TextFmt.Red) + "Paying a debt deals 200% life as true damage.");
        tooltip.add((Object)((Object)TextFmt.Red) + "Paying a debt takes 5 lives off creatures with multiple lives.");
        tooltip.add(TextFmt.getFormatting(TextFmt.Italic, TextFmt.Green) + "When a debt is paid, you heal to full health.");
        tooltip.add(TextFmt.getFormatting(TextFmt.Italic, TextFmt.Gold) + "Gain 3 seconds of immunity while a debt is paid.");
    }

    @Override
    public boolean playedKilled(ItemStack stack, Player player, Entity attacker, float damageDealt) {
        Level world = player.field_70170_p;
        if (!this.showDurabilityBar(stack)) {
            stack.func_77978_p().func_74772_a("lastUse", System.currentTimeMillis());
            LivingEntity collected = null;
            for (LivingEntity nearCreature : world.func_72872_a(LivingEntity.class, player.func_174813_aQ().func_72314_b(15.0, 5.0, 15.0))) {
                if (collected != null && (!(player.func_70032_d((Entity)nearCreature) < player.func_70032_d(collected)) || collected.func_110124_au() == player.func_110124_au()) || nearCreature.func_110124_au().equals(player.func_110124_au())) continue;
                collected = nearCreature;
            }
            if (collected != null) {
                if (!world.field_72995_K) {
                    EntityDebtCollectorEffect effect = new EntityDebtCollectorEffect(world);
                    effect.setCreator(player);
                    effect.setTargetPos(collected.func_174791_d());
                    effect.setTargetVec(collected.func_70040_Z());
                    effect.setTarget(collected);
                    effect.func_70107_b(collected.field_70165_t, collected.field_70163_u + (double)collected.field_70131_O + 0.6, collected.field_70161_v);
                    world.func_72838_d((Entity)effect);
                    world.func_184133_a(null, collected.func_180425_c(), SoundInit.EXECUTE_EFFECT_2, SoundSource.PLAYERS, 1.0f, 0.9f + 0.2f * world.field_73012_v.nextFloat());
                    player.func_70691_i(player.func_110138_aP());
                    player.func_70690_d(new PotionEffect(PotionInit.IRONHEART, 120));
                }
                return false;
            }
            return true;
        }
        return true;
    }
}

