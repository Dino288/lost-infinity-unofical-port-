/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.client.util.ITooltipFlag
 *  net.minecraft.entity.player.Player
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.InteractionResultHolder
 *  net.minecraft.util.InteractionHand
 *  net.minecraft.world.DimensionType
 *  net.minecraft.world.World
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package xol.lostinfinity.item.activate;

import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.DimensionType;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.dimension.util.WorldGenStructure;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.init.TabsInit;

public class ItemDimensionalizerBlueprint
extends Item {
    public ItemDimensionalizerBlueprint(String regName) {
        this.setRegistryName(regName);
        this.func_77655_b(regName);
        this.func_77637_a(TabsInit.TAB_AUXMATS);
        ItemInit.ITEMS.add(this);
    }

    public InteractionResultHolder<ItemStack> func_77659_a(Level worldIn, Player playerIn, InteractionHand handIn) {
        if (worldIn.field_73011_w.func_186058_p() == DimensionType.OVERWORLD) {
            if (!worldIn.field_72995_K) {
                new WorldGenStructure("celestialmaze/dimensionalizer_pad").func_180709_b(worldIn, worldIn.field_73012_v, playerIn.func_180425_c().func_177963_a(-4.5, -2.0, -4.5));
            }
            playerIn.func_184586_b(handIn).func_190918_g(1);
        }
        return super.func_77659_a(worldIn, playerIn, handIn);
    }

    @SideOnly(value=Side.CLIENT)
    public void func_77624_a(ItemStack stack, @Nullable Level worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add((Object)((Object)TextFmt.Gold) + "Places an 11x11 dimensionalizer pad beneath you.");
        tooltip.add(TextFmt.getFormatting(TextFmt.Italic, TextFmt.Dark_Aqua) + "Coordinators not included.");
    }
}

