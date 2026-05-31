/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.client.util.ITooltipFlag
 *  net.minecraft.entity.player.Player
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.InteractionHand
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
import net.minecraft.world.InteractionHand;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.init.TabsInit;
import xol.lostinfinity.item.classify.IHeldTick;
import xol.lostinfinity.util.player.HoldItemUtil;

public class ItemAxiomAvorum
extends Item
implements IHeldTick {
    public ItemAxiomAvorum(String regName) {
        this.func_77637_a(TabsInit.TAB_DEVIANTWEP);
        this.setRegistryName(regName);
        this.func_77655_b(regName);
        ItemInit.ITEMS.add(this);
    }

    @SideOnly(value=Side.CLIENT)
    public void func_77624_a(ItemStack stack, @Nullable Level worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add((Object)((Object)TextFmt.Gold) + "When held destroys incoming projectiles.");
    }

    @Override
    public void heldTick(Player player, InteractionHand hand, ItemStack stack) {
        HoldItemUtil.axiomProtection(player);
    }
}

