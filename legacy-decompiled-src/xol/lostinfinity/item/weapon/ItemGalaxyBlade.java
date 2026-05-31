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

public class ItemGalaxyBlade
extends SwordItem
implements IMaxAttack {
    private String wep = "";

    public ItemGalaxyBlade(String regName) {
        super(Item.ToolMaterial.WOOD);
        this.func_77637_a(TabsInit.TAB_GALAXY);
        this.setRegistryName(regName);
        this.func_77655_b(regName);
        this.wep = regName;
        ItemInit.ITEMS.add((Item)this);
    }

    public boolean func_77644_a(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        switch (this.wep) {
            case "moonglow_blade": {
                if (!(attacker.func_110143_aJ() >= 4.0f * (attacker.func_110138_aP() / 5.0f))) break;
                IMaxAttack.dealMaxHealth((Entity)attacker, target, 3);
                break;
            }
            case "novacron_blade": {
                if (!(target.func_110143_aJ() <= target.func_110138_aP() / 2.0f)) break;
                IMaxAttack.dealMaxHealth((Entity)attacker, target, 4);
                break;
            }
            case "aurorus_blade": {
                if (!(target.func_110143_aJ() >= target.func_110138_aP() / 2.0f)) break;
                IMaxAttack.dealMaxHealth((Entity)attacker, target, 4);
                break;
            }
            case "starfire_blade": {
                if (!(attacker.func_110143_aJ() <= attacker.func_110138_aP() / 5.0f)) break;
                IMaxAttack.dealMaxHealth((Entity)attacker, target, 3);
            }
        }
        return true;
    }

    @SideOnly(value=Side.CLIENT)
    public void func_77624_a(ItemStack stack, @Nullable Level worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        switch (this.wep) {
            case "moonglow_blade": {
                tooltip.add((Object)((Object)TextFmt.Gold) + "While Above 80% Life:");
                tooltip.add((Object)((Object)TextFmt.Aqua) + "Deal 33% Max Health Damage");
                break;
            }
            case "novacron_blade": {
                tooltip.add((Object)((Object)TextFmt.Gold) + "To Targets Below 50% Health:");
                tooltip.add((Object)((Object)TextFmt.Light_Purple) + "Deal 25% Max Health Damage");
                break;
            }
            case "aurorus_blade": {
                tooltip.add((Object)((Object)TextFmt.Gold) + "To Targets Above 50% Health:");
                tooltip.add((Object)((Object)TextFmt.Green) + "Deal 25% Max Health Damage");
                break;
            }
            case "starfire_blade": {
                tooltip.add((Object)((Object)TextFmt.Gold) + "While Below 20% Life:");
                tooltip.add((Object)((Object)TextFmt.Yellow) + "Deal 33% Max Health Damage");
            }
        }
    }
}

