/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.client.util.ITooltipFlag
 *  net.minecraft.item.ItemStack
 *  net.minecraft.world.World
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package xol.lostinfinity.item.misc;

import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.TabsInit;
import xol.lostinfinity.item.basics.ItemBasic;
import xol.lostinfinity.item.classify.ItemSoulbound;

public class ItemPlayerEssence
extends ItemBasic
implements ItemSoulbound {
    public ItemPlayerEssence(String regName) {
        super(regName, TabsInit.TAB_AUXMATS);
        this.func_77625_d(1);
    }

    @SideOnly(value=Side.CLIENT)
    public void func_77624_a(ItemStack stack, @Nullable Level worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        if (stack.func_77942_o() && stack.func_77978_p().func_74764_b("EssenceID")) {
            tooltip.add((Object)((Object)TextFmt.Dark_Aqua) + "Bound To " + stack.func_77978_p().func_74779_i("EssenceName"));
        }
    }
}

