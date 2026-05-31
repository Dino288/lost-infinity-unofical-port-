/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.client.util.ITooltipFlag
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.InteractionResultHolder
 *  net.minecraft.util.InteractionHand
 *  net.minecraft.util.text.Component
 *  net.minecraft.util.text.Component
 *  net.minecraft.world.World
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package xol.lostinfinity.item.activate;

import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.DimensionInit;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.init.TabsInit;
import xol.lostinfinity.mob.entity.murk.EntityDoomsday;

public class ItemDarkIncantation
extends Item {
    public ItemDarkIncantation(String regName) {
        this.setRegistryName(regName);
        this.func_77655_b(regName);
        this.func_77637_a(TabsInit.TAB_GALAXY);
        this.func_77625_d(1);
        ItemInit.ITEMS.add(this);
    }

    public InteractionResultHolder<ItemStack> func_77659_a(Level worldIn, Player playerIn, InteractionHand handIn) {
        if (!worldIn.field_72995_K && worldIn.field_73011_w.func_186058_p() == DimensionInit.infiniteMurk) {
            EntityDoomsday doomsday = new EntityDoomsday(worldIn);
            doomsday.func_70107_b(playerIn.field_70165_t, playerIn.field_70163_u + 3.0, playerIn.field_70161_v);
            worldIn.func_72838_d((Entity)doomsday);
            playerIn.func_145747_a((Component)new Component((Object)((Object)TextFmt.Dark_Aqua) + "Doomsday: Thank you for freeing me " + playerIn.func_70005_c_() + ", but now you must die."));
        }
        return super.func_77659_a(worldIn, playerIn, handIn);
    }

    @SideOnly(value=Side.CLIENT)
    public void func_77624_a(ItemStack stack, @Nullable Level worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add((Object)((Object)TextFmt.Gold) + "When used in the Infinite Murk, calls upon Doomsday.");
        tooltip.add(TextFmt.getFormatting(TextFmt.Light_Purple, TextFmt.Italic) + "A dark incantation, of forbidden magic.");
    }
}

