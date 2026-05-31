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
import xol.lostinfinity.item.classify.IMaxNullable;
import xol.lostinfinity.item.classify.IMaxReducible;

public class ItemGigacron
extends Item
implements IMaxReducible,
IMaxNullable {
    public ItemGigacron(String regName) {
        this.func_77637_a(TabsInit.TAB_INFINITYWEP);
        this.setRegistryName(regName);
        this.func_77655_b(regName);
        ItemInit.ITEMS.add(this);
    }

    @Override
    public float reduceMaxDamage(Player player, boolean isMainHand, float damage, float reductionMultiplier, ItemStack stack) {
        float newMulti = reductionMultiplier;
        float reversePercentage = 1.0f - player.func_110143_aJ() / player.func_110138_aP();
        return newMulti -= 0.1f - 0.4f * reversePercentage;
    }

    @Override
    public float nullableReaction(Player player, boolean isMainHand, float originalDamage, float newDamage, ItemStack stack) {
        if (player.func_110143_aJ() <= player.func_110138_aP() / 3.0f) {
            return 0.0f;
        }
        return newDamage;
    }

    @SideOnly(value=Side.CLIENT)
    public void func_77624_a(ItemStack stack, @Nullable Level worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add((Object)((Object)TextFmt.Light_Purple) + "When held, reduces max health damage taken by 10%.");
        tooltip.add((Object)((Object)TextFmt.Gold) + "Reduce max health damage taken by up to 50% total, depending on missing health.");
        tooltip.add((Object)((Object)TextFmt.Aqua) + "Provides immunity to sonic attacks.");
    }
}

