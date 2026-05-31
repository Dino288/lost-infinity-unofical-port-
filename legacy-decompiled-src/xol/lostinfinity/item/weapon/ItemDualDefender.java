/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.client.util.ITooltipFlag
 *  net.minecraft.entity.player.Player
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.world.World
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package xol.lostinfinity.item.weapon;

import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.init.TabsInit;
import xol.lostinfinity.item.classify.IMaxReducible;

public class ItemDualDefender
extends Item
implements IMaxReducible {
    public ItemDualDefender(String regName) {
        this.func_77637_a(TabsInit.TAB_INFINITYWEP);
        this.setRegistryName(regName);
        this.func_77655_b(regName);
        ItemInit.ITEMS.add(this);
    }

    @Override
    public float reduceMaxDamage(Player player, boolean isMainHand, float damage, float reductionMultiplier, ItemStack stack) {
        float newMulti = reductionMultiplier;
        reductionMultiplier = player.func_110143_aJ() == player.func_110138_aP() ? (reductionMultiplier -= 0.5f) : (reductionMultiplier -= 0.1f);
        return newMulti;
    }

    @SideOnly(value=Side.CLIENT)
    public void func_77624_a(ItemStack stack, @Nullable Level worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add((Object)((Object)TextFmt.Italic) + "Grants effects while held in offhand.");
        tooltip.add((Object)((Object)TextFmt.Gold) + "While on full life:");
        tooltip.add((Object)((Object)TextFmt.Green) + "Take 50% Reduced Max Health Damage");
        tooltip.add((Object)((Object)TextFmt.Red) + "Reflect 25% of Max Health Damage");
        tooltip.add((Object)((Object)TextFmt.Gold) + "While not on full life:");
        tooltip.add((Object)((Object)TextFmt.Green) + "Take 10% Reduced Max Health Damage");
        tooltip.add((Object)((Object)TextFmt.Red) + "Reflect 125% of Max Health Damage");
    }
}

