/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.client.util.ITooltipFlag
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.item.Item
 *  net.minecraft.item.Item$ToolMaterial
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.SwordItem
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
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.init.TabsInit;
import xol.lostinfinity.util.data.IMaxAttack;

public class ItemDominator
extends SwordItem
implements IMaxAttack {
    public ItemDominator(String regName) {
        super(Item.ToolMaterial.WOOD);
        this.func_77637_a(TabsInit.TAB_AUXWEP);
        this.setRegistryName(regName);
        this.func_77655_b(regName);
        ItemInit.ITEMS.add((Item)this);
    }

    public boolean func_77644_a(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        float damageMulti = 3.0f + 3.0f * (1.0f - target.func_110143_aJ() / target.func_110138_aP());
        if (attacker.func_110143_aJ() == attacker.func_110138_aP()) {
            float amount = target.func_110138_aP() / 4.0f * damageMulti;
            IMaxAttack.dealTrueDamage((Entity)attacker, target, amount);
        } else {
            IMaxAttack.dealMaxHealth((Entity)attacker, target, 4, damageMulti);
        }
        return true;
    }

    @SideOnly(value=Side.CLIENT)
    public void func_77624_a(ItemStack stack, @Nullable Level worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add((Object)((Object)TextFmt.Gold) + "Deals 75% max health damage per hit.");
        tooltip.add((Object)((Object)TextFmt.Red) + "Deals up 150% max health damage depending on your target's missing health.");
        tooltip.add((Object)((Object)TextFmt.Italic) + "(Lower health deals more damage)");
        tooltip.add((Object)((Object)TextFmt.Green) + "Deals true damage while you are on full life.");
    }
}

