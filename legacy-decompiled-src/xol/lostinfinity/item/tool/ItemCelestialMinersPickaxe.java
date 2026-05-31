/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.client.util.ITooltipFlag
 *  net.minecraft.item.Item
 *  net.minecraft.item.Item$ToolMaterial
 *  net.minecraft.item.ItemPickaxe
 *  net.minecraft.item.ItemStack
 *  net.minecraft.world.World
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package xol.lostinfinity.item.tool;

import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.world.item.Item;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.init.TabsInit;

public class ItemCelestialMinersPickaxe
extends ItemPickaxe {
    public ItemCelestialMinersPickaxe(Item.ToolMaterial material, String regName) {
        super(material);
        this.func_77637_a(TabsInit.TAB_AUXWEP);
        this.setRegistryName(regName);
        this.func_77655_b(regName);
        ItemInit.ITEMS.add((Item)this);
    }

    @SideOnly(value=Side.CLIENT)
    public void func_77624_a(ItemStack stack, @Nullable Level worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add((Object)((Object)TextFmt.Light_Purple) + "Searches alternate timelines for celestial gems when mining ores.");
    }
}

