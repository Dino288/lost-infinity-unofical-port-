/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.util.ITooltipFlag
 *  net.minecraft.item.ItemStack
 *  net.minecraft.world.World
 */
package xol.lostinfinity.item.misc;

import java.util.List;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.TabsInit;
import xol.lostinfinity.item.basics.ItemBasic;

public class ItemBoxOfLife
extends ItemBasic {
    public ItemBoxOfLife(String regName) {
        super(regName, TabsInit.TAB_AUXMATS);
    }

    public void func_77624_a(ItemStack stack, Level worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add((Object)((Object)TextFmt.Gold) + "A box containing the essence of someone's life.");
        if (stack.func_77942_o() && stack.func_77978_p().func_74764_b("PlayerContained")) {
            tooltip.add((Object)((Object)TextFmt.Italic) + "Contains the life of: " + stack.func_77978_p().func_74779_i("PlayerContained"));
        }
    }
}

