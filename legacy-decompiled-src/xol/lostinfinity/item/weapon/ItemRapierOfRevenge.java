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
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.potion.PotionEffect
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
import net.minecraft.nbt.CompoundTag;
import net.minecraft.potion.PotionEffect;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.PotionInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.init.TabsInit;
import xol.lostinfinity.item.classify.IHotbarDeath;
import xol.lostinfinity.item.weapon.ItemCooldownSword;
import xol.lostinfinity.util.data.IMaxAttack;

public class ItemRapierOfRevenge
extends ItemCooldownSword
implements IMaxAttack,
IHotbarDeath {
    public ItemRapierOfRevenge(String regName) {
        super(regName);
        this.func_77637_a(TabsInit.TAB_AUXWEP);
    }

    public boolean func_77644_a(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (!this.isRevengeMode(attacker.func_184614_ca())) {
            IMaxAttack.dealMaxHealth((Entity)attacker, target, 5, 4.0f);
        } else {
            IMaxAttack.dealTrueDamage((Entity)attacker, target, target.func_110138_aP() * 0.8f);
        }
        return true;
    }

    public boolean isRevengeMode(ItemStack stack) {
        if (!stack.func_77942_o()) {
            stack.func_77982_d(new CompoundTag());
            stack.func_77978_p().func_74772_a("lastUse", 0L);
        }
        long lastUse = stack.func_77978_p().func_74763_f("lastUse");
        long maxDelay = this.getCooldown() / 3;
        return System.currentTimeMillis() - lastUse <= maxDelay;
    }

    @Override
    protected int getCooldown() {
        return 33000;
    }

    @SideOnly(value=Side.CLIENT)
    public void func_77624_a(ItemStack stack, @Nullable Level worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add((Object)((Object)TextFmt.Gold) + "Deals 80% max health damage per hit.");
        tooltip.add((Object)((Object)TextFmt.Aqua) + "When taking max health damage that would kill you:");
        tooltip.add(TextFmt.getFormatting(TextFmt.Italic, TextFmt.Green) + "Heal to full.");
        tooltip.add((Object)((Object)TextFmt.Green) + "Grant the Racing Heart buff.");
        tooltip.add((Object)((Object)TextFmt.Red) + "Deal true damage while the cooldown bar is below 33%.");
    }

    @Override
    public boolean playedKilled(ItemStack stack, Player player, Entity attacker, float damageDealt) {
        Level world = player.field_70170_p;
        if (!this.showDurabilityBar(stack)) {
            stack.func_77978_p().func_74772_a("lastUse", System.currentTimeMillis());
            if (!world.field_72995_K) {
                player.func_70691_i(player.func_110138_aP());
                world.func_184133_a(null, player.func_180425_c(), SoundInit.MAGIC_WEAPON_14, SoundSource.MASTER, 1.0f, 1.0f);
                player.func_70690_d(new PotionEffect(PotionInit.RACING_HEART, 400));
            }
            return false;
        }
        return true;
    }
}

