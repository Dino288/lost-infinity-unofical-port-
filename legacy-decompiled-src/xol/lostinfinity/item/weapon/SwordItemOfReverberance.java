/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.client.util.ITooltipFlag
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.item.Item
 *  net.minecraft.item.Item$ToolMaterial
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.SwordItem
 *  net.minecraft.nbt.CompoundTag
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
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.init.TabsInit;
import xol.lostinfinity.item.classify.IMaxReducible;
import xol.lostinfinity.util.data.IMaxAttack;

public class SwordItemOfReverberance
extends SwordItem
implements IMaxAttack,
IMaxReducible {
    public SwordItemOfReverberance(String regName) {
        super(Item.ToolMaterial.DIAMOND);
        this.func_77637_a(TabsInit.TAB_AUXWEP);
        this.setRegistryName(regName);
        this.func_77655_b(regName);
        ItemInit.ITEMS.add((Item)this);
    }

    public boolean func_77644_a(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        int charge;
        if (!(attacker instanceof Player)) {
            return false;
        }
        Player player = (Player)attacker;
        if (!stack.func_77942_o()) {
            stack.func_77982_d(new CompoundTag());
            stack.func_77978_p().func_74768_a("sword_charge", 0);
        }
        if ((charge = stack.func_77978_p().func_74762_e("sword_charge")) >= 10) {
            int percent_multi = Math.floorDiv(charge, 10);
            int divBase = 10;
            if (!(target instanceof Player)) {
                divBase = 30;
            }
            IMaxAttack.dealMaxHealth((Entity)player, target, divBase, percent_multi);
            player.field_70170_p.func_184133_a(null, player.func_180425_c(), SoundInit.GALAXYFIRE, SoundSource.MASTER, 2.0f, 1.0f);
            stack.func_77978_p().func_74768_a("sword_charge", 0);
        }
        return false;
    }

    @Override
    public float reduceMaxDamage(Player player, boolean isMainHand, float damage, float reductionMultiplier, ItemStack stack) {
        float newMulti = reductionMultiplier;
        if (!stack.func_77942_o()) {
            stack.func_77982_d(new CompoundTag());
            stack.func_77978_p().func_74768_a("sword_charge", 0);
        }
        newMulti -= 0.1f;
        int chargeGained = Math.round(damage / player.func_110138_aP() * 100.0f);
        int newChargeTotal = stack.func_77978_p().func_74762_e("sword_charge") + chargeGained;
        if (newChargeTotal > 250) {
            newChargeTotal = 250;
        }
        stack.func_77978_p().func_74768_a("sword_charge", newChargeTotal);
        return newMulti;
    }

    @SideOnly(value=Side.CLIENT)
    public void func_77624_a(ItemStack stack, @Nullable Level worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add((Object)((Object)TextFmt.Light_Purple) + "When held, reduces max health damage taken by 10%.");
        tooltip.add((Object)((Object)TextFmt.Light_Purple) + "Gain 1 charge per 1% of life taken as damage.");
        boolean mark = false;
        if (stack.func_77942_o() && stack.func_77978_p().func_74764_b("sword_charge")) {
            mark = true;
        }
        if (mark) {
            int charges = stack.func_77978_p().func_74762_e("sword_charge");
            int percent_multi = Math.floorDiv(charges, 10);
            tooltip.add((Object)((Object)TextFmt.Gold) + "Charges: " + charges + "/250. This deals " + percent_multi * 10 + "% health damage.");
        }
        tooltip.add((Object)((Object)TextFmt.Dark_Gray) + "Damage is dealt in 10% increments. Deals 33% damage to non-players.");
        tooltip.add((Object)((Object)TextFmt.Green) + "Greatly reduces damage from sonic attacks and doubles current charge.");
    }
}

