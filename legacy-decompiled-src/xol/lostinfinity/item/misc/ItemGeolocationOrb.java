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

public class ItemGeolocationOrb
extends ItemBasic
implements ItemSoulbound {
    public ItemGeolocationOrb(String regName) {
        super(regName, TabsInit.TAB_AUXMATS);
        this.func_77625_d(1);
    }

    private String typeToName(int type) {
        switch (type) {
            case 0: {
                return "Blue Triangle";
            }
            case 1: {
                return "Green Pentagon";
            }
            case 2: {
                return "Red Square";
            }
            case 3: {
                return "Yellow Circle";
            }
        }
        return "Data Error";
    }

    @SideOnly(value=Side.CLIENT)
    public void func_77624_a(ItemStack stack, @Nullable Level worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add(this.soulBoundMessage());
        tooltip.add((Object)((Object)TextFmt.Gold) + "Needs to be taken to 3 Geolocators in the Cartographer's Labyrinth");
        if (stack.func_77942_o()) {
            tooltip.add((Object)((Object)TextFmt.Green) + "Geolocators Remaining: " + stack.func_77978_p().func_74762_e("geocount"));
            tooltip.add((Object)((Object)TextFmt.Aqua) + "Next Geolocator Type: " + this.typeToName(stack.func_77978_p().func_74762_e("geolocator")));
        }
    }
}

