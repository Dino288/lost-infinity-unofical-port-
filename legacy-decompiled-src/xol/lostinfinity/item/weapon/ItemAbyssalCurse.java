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
 *  net.minecraft.potion.PotionEffect
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
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.init.PotionInit;
import xol.lostinfinity.init.TabsInit;
import xol.lostinfinity.util.data.IMaxAttack;

public class ItemAbyssalCurse
extends SwordItem
implements IMaxAttack {
    public ItemAbyssalCurse(String regName) {
        super(Item.ToolMaterial.WOOD);
        this.func_77637_a(TabsInit.TAB_AUXWEP);
        this.setRegistryName(regName);
        this.func_77655_b(regName);
        ItemInit.ITEMS.add((Item)this);
    }

    public boolean func_77644_a(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (IMaxAttack.dealMaxHealth((Entity)attacker, target, 1).didSuccessfulHit()) {
            if (target.func_70644_a(PotionInit.BLOOD_TOXIN)) {
                int level = target.func_70660_b(PotionInit.BLOOD_TOXIN).func_76458_c() + 1;
                target.func_70690_d(new PotionEffect(PotionInit.BLOOD_TOXIN, 200, Math.min(9, level)));
            } else {
                target.func_70690_d(new PotionEffect(PotionInit.BLOOD_TOXIN, 200));
            }
        }
        return true;
    }

    @SideOnly(value=Side.CLIENT)
    public void func_77624_a(ItemStack stack, @Nullable Level worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add((Object)((Object)TextFmt.Red) + "Deals 100% Max Health Damage");
        tooltip.add((Object)((Object)TextFmt.Dark_Green) + "Applies Blood Toxin.");
        tooltip.add((Object)((Object)TextFmt.Gold) + "If Blood Toxin is already applied, up the strength (max 10).");
    }
}

