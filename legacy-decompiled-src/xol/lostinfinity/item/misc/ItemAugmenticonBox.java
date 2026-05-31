/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.client.util.ITooltipFlag
 *  net.minecraft.item.ItemStack
 *  net.minecraft.nbt.NBTBase
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.nbt.NBTTagInt
 *  net.minecraft.nbt.NBTTagList
 *  net.minecraft.world.World
 */
package xol.lostinfinity.item.misc;

import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.world.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NBTTagInt;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.world.level.Level;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.TabsInit;
import xol.lostinfinity.item.basics.ItemBasic;
import xol.lostinfinity.item.misc.ItemAugmentSlide;

public class ItemAugmenticonBox
extends ItemBasic {
    public ItemAugmenticonBox() {
        super("augmenticon_box", TabsInit.TAB_AUXMATS);
        this.func_77625_d(1);
    }

    public static NBTTagList getAugmentList(ItemStack stack) {
        CompoundTag nbt;
        if (stack.func_77978_p() == null) {
            stack.func_77982_d(new CompoundTag());
        }
        if (!(nbt = stack.func_77978_p()).func_150297_b("slides", 9)) {
            nbt.func_74782_a("slides", (NBTBase)new NBTTagList());
        }
        return nbt.func_150295_c("slides", 3);
    }

    public void func_77624_a(ItemStack stack, @Nullable Level worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add((Object)((Object)TextFmt.Gold) + "Can have Augment Slides put inside while placed in an Augmentor.");
        tooltip.add((Object)((Object)TextFmt.Bold) + "Slides Entered: ");
        NBTTagList list = ItemAugmenticonBox.getAugmentList(stack);
        for (NBTBase tag : list) {
            NBTTagInt strTag = (NBTTagInt)tag;
            tooltip.add((Object)((Object)TextFmt.Italic) + ItemAugmentSlide.SlideType.values()[strTag.func_150287_d()].description);
        }
        tooltip.add((Object)((Object)TextFmt.Gold) + "Drops Added at Ability Count:");
        tooltip.add((Object)((Object)TextFmt.Gray) + "1: Glowing Seeds" + (Object)((Object)TextFmt.Reset) + (Object)((Object)TextFmt.Dark_Aqua) + ", 4: Ether Chamber" + (Object)((Object)TextFmt.Reset) + (Object)((Object)TextFmt.Aqua) + ", 8: Chemical Synchronizer" + (Object)((Object)TextFmt.Reset) + (Object)((Object)TextFmt.Dark_Purple) + ", 12: Astrometal Amalgamater" + (Object)((Object)TextFmt.Reset) + (Object)((Object)TextFmt.Light_Purple) + ", 16: Rapid Illuminator" + (Object)((Object)TextFmt.Reset) + (Object)((Object)TextFmt.Green) + ", 20: Metamorphosis Core");
    }
}

