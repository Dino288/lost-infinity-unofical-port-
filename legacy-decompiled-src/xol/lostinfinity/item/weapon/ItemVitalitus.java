/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.client.util.ITooltipFlag
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.player.Player
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
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
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

public class ItemVitalitus
extends SwordItem
implements IMaxAttack {
    public ItemVitalitus(String regName) {
        super(Item.ToolMaterial.WOOD);
        this.func_77637_a(TabsInit.TAB_DEVIANTWEP);
        this.setRegistryName(regName);
        this.func_77655_b(regName);
        ItemInit.ITEMS.add((Item)this);
    }

    public boolean func_77644_a(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (target instanceof Player && !attacker.field_70170_p.field_72995_K) {
            int target_percentage = Math.round(target.func_110143_aJ() / target.func_110138_aP() * 100.0f);
            int attacker_percentage = Math.round(attacker.func_110143_aJ() / attacker.func_110138_aP() * 100.0f);
            target.func_70606_j(target.func_110138_aP() * (float)attacker_percentage / 100.0f);
            attacker.func_70606_j(attacker.func_110138_aP() * (float)target_percentage / 100.0f);
            if (attacker.func_110143_aJ() < 0.0f && attacker instanceof Player) {
                ((Player)attacker).field_71071_by.func_70436_m();
            }
            if (target.func_110143_aJ() < 0.0f && target instanceof Player) {
                ((Player)target).field_71071_by.func_70436_m();
            }
        }
        return true;
    }

    @SideOnly(value=Side.CLIENT)
    public void func_77624_a(ItemStack stack, @Nullable Level worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add((Object)((Object)TextFmt.Light_Purple) + "On player hit:");
        tooltip.add((Object)((Object)TextFmt.Gold) + "Swaps your health percentage with the enemy.");
    }
}

