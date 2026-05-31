/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.client.util.ITooltipFlag
 *  net.minecraft.entity.player.Player
 *  net.minecraft.init.SoundEvents
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.util.InteractionResultHolder
 *  net.minecraft.util.InteractionHand
 *  net.minecraft.util.SoundSource
 *  net.minecraft.world.World
 *  net.minecraft.world.biome.Biome
 *  net.minecraftforge.common.BiomeDictionary
 *  net.minecraftforge.common.BiomeDictionary$Type
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package xol.lostinfinity.item.activate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.world.entity.player.Player;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.init.TabsInit;

public class ItemElementStone
extends Item {
    public ItemElementStone(String regName) {
        this.setRegistryName(regName);
        this.func_77655_b(regName);
        this.func_77637_a(TabsInit.TAB_AUXMATS);
        this.func_77625_d(1);
        ItemInit.ITEMS.add(this);
    }

    private void populateRequirements(ItemStack stack) {
        ArrayList<BiomeDictionary.Type> types_to_pick = new ArrayList<BiomeDictionary.Type>();
        types_to_pick.add(BiomeDictionary.Type.COLD);
        types_to_pick.add(BiomeDictionary.Type.HOT);
        types_to_pick.add(BiomeDictionary.Type.MUSHROOM);
        types_to_pick.add(BiomeDictionary.Type.MESA);
        types_to_pick.add(BiomeDictionary.Type.MAGICAL);
        types_to_pick.add(BiomeDictionary.Type.SPOOKY);
        types_to_pick.add(BiomeDictionary.Type.SWAMP);
        types_to_pick.add(BiomeDictionary.Type.SPOOKY);
        types_to_pick.add(BiomeDictionary.Type.DENSE);
        types_to_pick.add(BiomeDictionary.Type.SPARSE);
        types_to_pick.add(BiomeDictionary.Type.MOUNTAIN);
        types_to_pick.add(BiomeDictionary.Type.NETHER);
        types_to_pick.add(BiomeDictionary.Type.END);
        types_to_pick.add(BiomeDictionary.Type.FOREST);
        types_to_pick.add(BiomeDictionary.Type.CONIFEROUS);
        types_to_pick.add(BiomeDictionary.Type.SNOWY);
        types_to_pick.add(BiomeDictionary.Type.OCEAN);
        Collections.shuffle(types_to_pick);
        for (int i = 0; i < 5; ++i) {
            stack.func_77978_p().func_74778_a("BiomeName" + i, ((BiomeDictionary.Type)types_to_pick.get(i)).getName());
            stack.func_77978_p().func_74757_a("BiomeComplete" + i, false);
        }
    }

    public InteractionResultHolder<ItemStack> func_77659_a(Level worldIn, Player playerIn, InteractionHand handIn) {
        ItemStack stack = playerIn.func_184586_b(handIn);
        if (!stack.func_77942_o()) {
            stack.func_77982_d(new CompoundTag());
        }
        if (stack.func_77978_p().func_74764_b("BiomeName1")) {
            Biome current_biome = playerIn.field_70170_p.func_180494_b(playerIn.func_180425_c());
            for (BiomeDictionary.Type bt : BiomeDictionary.getTypes((Biome)current_biome)) {
                for (int i = 0; i < 5; ++i) {
                    if (!stack.func_77978_p().func_74779_i("BiomeName" + i).equals(bt.getName())) continue;
                    stack.func_77978_p().func_74757_a("BiomeComplete" + i, true);
                    worldIn.func_184133_a(null, playerIn.func_180425_c(), SoundEvents.field_187556_aj, SoundSource.MASTER, 1.0f, 1.0f);
                }
            }
            int count = 0;
            for (int check = 0; check < 5; ++check) {
                if (!stack.func_77978_p().func_74767_n("BiomeComplete" + check)) continue;
                ++count;
            }
            if (count == 5) {
                worldIn.func_184133_a(null, playerIn.func_180425_c(), SoundEvents.field_187626_cN, SoundSource.MASTER, 1.0f, 1.0f);
                playerIn.func_184611_a(handIn, new ItemStack(ItemInit.elementStone));
            }
        } else {
            this.populateRequirements(stack);
            worldIn.func_184133_a(null, playerIn.func_180425_c(), SoundEvents.field_187766_dk, SoundSource.MASTER, 1.0f, 1.0f);
        }
        return super.func_77659_a(worldIn, playerIn, handIn);
    }

    private String biomeName(ItemStack stack, int slot) {
        return stack.func_77978_p().func_74779_i("BiomeName" + slot);
    }

    private boolean hasBiome(ItemStack stack, int slot) {
        return stack.func_77978_p().func_74767_n("BiomeComplete" + slot);
    }

    @SideOnly(value=Side.CLIENT)
    public void func_77624_a(ItemStack stack, @Nullable Level worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add((Object)((Object)TextFmt.Gold) + "Needs to be taken to the following biome types:");
        boolean flag = false;
        if (stack.func_77942_o() && stack.func_77978_p().func_74764_b("BiomeName1")) {
            tooltip.add((Object)((Object)(this.hasBiome(stack, 0) ? TextFmt.Green : TextFmt.Red)) + "1:" + this.biomeName(stack, 0));
            tooltip.add((Object)((Object)(this.hasBiome(stack, 1) ? TextFmt.Green : TextFmt.Red)) + "2:" + this.biomeName(stack, 1));
            tooltip.add((Object)((Object)(this.hasBiome(stack, 2) ? TextFmt.Green : TextFmt.Red)) + "3:" + this.biomeName(stack, 2));
            tooltip.add((Object)((Object)(this.hasBiome(stack, 3) ? TextFmt.Green : TextFmt.Red)) + "4:" + this.biomeName(stack, 3));
            tooltip.add((Object)((Object)(this.hasBiome(stack, 4) ? TextFmt.Green : TextFmt.Red)) + "5:" + this.biomeName(stack, 4));
            flag = true;
        }
        if (!flag) {
            tooltip.add((Object)((Object)TextFmt.Light_Purple) + "*Activate the stone to find out the locations*");
        }
    }
}

