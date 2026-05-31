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
import xol.lostinfinity.mob.entity.misc.EntityEidolonMist;
import xol.lostinfinity.util.data.IMaxAttack;

public class ItemEidolon
extends SwordItem
implements IMaxAttack {
    public ItemEidolon(String regName) {
        super(Item.ToolMaterial.DIAMOND);
        this.func_77637_a(TabsInit.TAB_AUXWEP);
        this.setRegistryName(regName);
        this.func_77655_b(regName);
        ItemInit.ITEMS.add((Item)this);
    }

    public boolean func_77644_a(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        Level world = attacker.field_70170_p;
        if (!world.field_72995_K) {
            IMaxAttack.dealMaxHealth((Entity)attacker, target, 2, 1.0f);
            EntityEidolonMist mist = new EntityEidolonMist(world, attacker);
            mist.func_70634_a(target.field_70165_t, target.field_70163_u + (double)(target.field_70131_O / 2.0f), target.field_70161_v);
            mist.addInitialTarget(target);
            mist.func_184538_a((Entity)attacker, attacker.field_70125_A, attacker.field_70177_z, 0.0f, 0.1f, 0.0f);
            world.func_72838_d((Entity)mist);
        }
        return true;
    }

    @SideOnly(value=Side.CLIENT)
    public void func_77624_a(ItemStack stack, @Nullable Level worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add((Object)((Object)TextFmt.Aqua) + "Melee hits create a mist.");
        tooltip.add((Object)((Object)TextFmt.Red) + "The Mist Deals 300% Health True Damage");
        tooltip.add((Object)((Object)TextFmt.Italic) + "The mist seeks out more targets beyond the first.");
        tooltip.add((Object)((Object)TextFmt.Gold) + "The Mist Unleashes Undead Phantoms");
        tooltip.add((Object)((Object)TextFmt.Dark_Aqua) + "Darkborn");
    }
}

