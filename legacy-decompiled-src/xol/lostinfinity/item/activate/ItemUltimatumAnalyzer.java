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
 *  net.minecraft.util.SoundSource
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
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.init.TabsInit;
import xol.lostinfinity.mob.entity.base.EntityDeviantMob;
import xol.lostinfinity.mob.entity.deviant.EntityDeviantCreeper;
import xol.lostinfinity.mob.entity.deviant.EntityDeviantLlama;
import xol.lostinfinity.mob.entity.deviant.EntityDeviantMagmacube;
import xol.lostinfinity.mob.entity.deviant.EntityDeviantPiglin;
import xol.lostinfinity.mob.entity.deviant.EntityDeviantSkeleton;
import xol.lostinfinity.mob.entity.deviant.EntityDeviantSlime;
import xol.lostinfinity.mob.entity.deviant.EntityDeviantSlimeStrider;
import xol.lostinfinity.mob.entity.deviant.EntityDeviantStray;
import xol.lostinfinity.mob.entity.deviant.EntityDeviantVex;
import xol.lostinfinity.mob.entity.deviant.EntityDeviantWitch;

public class ItemUltimatumAnalyzer
extends Item {
    public ItemUltimatumAnalyzer(String regName) {
        this.func_77637_a(TabsInit.TAB_AUXMATS);
        this.setRegistryName(regName);
        this.func_77655_b(regName);
        this.func_77625_d(1);
        ItemInit.ITEMS.add(this);
    }

    public InteractionResultHolder<ItemStack> func_77659_a(Level worldIn, Player playerIn, InteractionHand handIn) {
        boolean vex = false;
        boolean stray = false;
        boolean creeper = false;
        boolean witch = false;
        boolean cube = false;
        boolean strider = false;
        boolean slime = false;
        boolean piglin = false;
        boolean skeleton = false;
        boolean llama = false;
        for (EntityDeviantMob creature : worldIn.func_72872_a(EntityDeviantMob.class, playerIn.func_174813_aQ().func_72314_b(15.0, 15.0, 15.0))) {
            if (creature instanceof EntityDeviantVex) {
                if (creature.atMaxMutation()) {
                    vex = true;
                }
            } else if (creature instanceof EntityDeviantStray) {
                if (creature.atMaxMutation()) {
                    stray = true;
                }
            } else if (creature instanceof EntityDeviantCreeper) {
                if (creature.atMaxMutation()) {
                    creeper = true;
                }
            } else if (creature instanceof EntityDeviantWitch) {
                if (creature.atMaxMutation()) {
                    witch = true;
                }
            } else if (creature instanceof EntityDeviantMagmacube) {
                if (creature.atMaxMutation()) {
                    cube = true;
                }
            } else if (creature instanceof EntityDeviantSlimeStrider) {
                if (creature.atMaxMutation()) {
                    strider = true;
                }
            } else if (creature instanceof EntityDeviantSlime) {
                if (creature.atMaxMutation()) {
                    slime = true;
                }
            } else if (creature instanceof EntityDeviantPiglin) {
                if (creature.atMaxMutation()) {
                    piglin = true;
                }
            } else if (creature instanceof EntityDeviantSkeleton) {
                if (creature.atMaxMutation()) {
                    skeleton = true;
                }
            } else if (creature instanceof EntityDeviantLlama && creature.atMaxMutation()) {
                llama = true;
            }
            if (!vex || !stray || !creeper || !witch || !cube || !strider || !slime || !piglin || !skeleton || !llama) continue;
            worldIn.func_184133_a(null, playerIn.func_180425_c(), SoundInit.SCANNER, SoundSource.MASTER, 2.0f, 1.0f);
            playerIn.func_184611_a(handIn, new ItemStack(ItemInit.ultimatumAnalyzerFull, 1));
        }
        return super.func_77659_a(worldIn, playerIn, handIn);
    }

    @SideOnly(value=Side.CLIENT)
    public void func_77624_a(ItemStack stack, @Nullable Level worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add((Object)((Object)TextFmt.Gold) + "Use near the following all at once to charge this:");
        tooltip.add((Object)((Object)TextFmt.White) + "Fully Super-mutated Vex");
        tooltip.add((Object)((Object)TextFmt.Light_Purple) + "Fully Super-mutated Stray");
        tooltip.add((Object)((Object)TextFmt.White) + "Fully Super-mutated Creeper");
        tooltip.add((Object)((Object)TextFmt.Light_Purple) + "Fully Super-mutated Witch");
        tooltip.add((Object)((Object)TextFmt.White) + "Fully Super-mutated Magma Cube");
        tooltip.add((Object)((Object)TextFmt.Light_Purple) + "Fully Super-mutated Slime Strider");
        tooltip.add((Object)((Object)TextFmt.White) + "Fully Super-mutated Slime");
        tooltip.add((Object)((Object)TextFmt.Light_Purple) + "Fully Super-mutated Piglin");
        tooltip.add((Object)((Object)TextFmt.White) + "Fully Super-mutated Skeleton");
        tooltip.add((Object)((Object)TextFmt.Light_Purple) + "Fully Super-mutated Llama");
    }
}

