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
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.init.TabsInit;
import xol.lostinfinity.util.data.IMaxAttack;

public class ItemKingslayer
extends SwordItem
implements IMaxAttack {
    public ItemKingslayer(String regName) {
        super(Item.ToolMaterial.WOOD);
        this.func_77637_a(TabsInit.TAB_AUXWEP);
        this.setRegistryName(regName);
        this.func_77655_b(regName);
        ItemInit.ITEMS.add((Item)this);
    }

    public boolean func_77644_a(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        float attackerPercentage = attacker.func_110143_aJ() / attacker.func_110138_aP();
        if (target.func_110143_aJ() / target.func_110138_aP() < attackerPercentage) {
            IMaxAttack.dealTrueDamage((Entity)attacker, target, target.func_110138_aP() * 2.0f);
            target.field_70170_p.func_184133_a(null, target.func_180425_c(), SoundInit.GALAXYFIRE, SoundSource.MASTER, 1.0f, 1.0f);
        } else if (attackerPercentage > 0.5f) {
            IMaxAttack.dealTrueDamage((Entity)attacker, target, target.func_110138_aP() * 0.5f);
        } else {
            IMaxAttack.dealMaxHealth((Entity)attacker, target, 1, 2.0f);
        }
        return true;
    }

    @SideOnly(value=Side.CLIENT)
    public void func_77624_a(ItemStack stack, @Nullable Level worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add((Object)((Object)TextFmt.Gold) + "Deals 200% Health True Damage if you currently have a higher health % than your target.");
        tooltip.add((Object)((Object)TextFmt.Gold) + "Otherwise, if you are above 50% life deal 50% Health True Damage");
        tooltip.add((Object)((Object)TextFmt.Gold) + "Otherwise, deal 200% Max Health Damage");
    }
}

