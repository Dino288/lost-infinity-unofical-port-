/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.client.util.ITooltipFlag
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.Mob
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
import net.minecraft.world.entity.Mob;
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
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.init.TabsInit;
import xol.lostinfinity.mob.entity.deviant.EntityDeviantAmalgam;
import xol.lostinfinity.mob.entity.deviant.EntityDeviantCreeper;
import xol.lostinfinity.mob.entity.deviant.EntityDeviantEnderman;
import xol.lostinfinity.mob.entity.deviant.EntityDeviantShulker;
import xol.lostinfinity.mob.entity.deviant.EntityDeviantSkeleton;

public class ItemDeviationAnalyzer
extends Item {
    public ItemDeviationAnalyzer(String regName) {
        this.func_77637_a(TabsInit.TAB_AUXMATS);
        this.setRegistryName(regName);
        this.func_77655_b(regName);
        ItemInit.ITEMS.add(this);
    }

    public InteractionResultHolder<ItemStack> func_77659_a(Level worldIn, Player playerIn, InteractionHand handIn) {
        boolean found_creeper = false;
        boolean found_skeleton = false;
        boolean found_shulker = false;
        boolean found_enderman = false;
        for (Mob li : worldIn.func_72872_a(Mob.class, playerIn.func_174813_aQ().func_72314_b(12.0, 12.0, 12.0))) {
            if (li instanceof EntityDeviantCreeper) {
                found_creeper = true;
                continue;
            }
            if (li instanceof EntityDeviantSkeleton) {
                found_skeleton = true;
                continue;
            }
            if (li instanceof EntityDeviantShulker) {
                found_shulker = true;
                continue;
            }
            if (!(li instanceof EntityDeviantEnderman)) continue;
            found_enderman = true;
        }
        if (found_creeper && found_skeleton && found_shulker && found_enderman) {
            playerIn.func_184185_a(SoundInit.SCANNER, 1.0f, 1.0f);
            playerIn.func_184611_a(handIn, new ItemStack(ItemInit.deviationAnalyzerCharged, 1));
            if (!worldIn.field_72995_K) {
                for (Mob li : worldIn.func_72872_a(Mob.class, playerIn.func_174813_aQ().func_72314_b(12.0, 12.0, 12.0))) {
                    if (!(li instanceof EntityDeviantCreeper) && !(li instanceof EntityDeviantSkeleton) && !(li instanceof EntityDeviantShulker) && !(li instanceof EntityDeviantEnderman)) continue;
                    li.func_70106_y();
                }
                EntityDeviantAmalgam dev = new EntityDeviantAmalgam(worldIn);
                dev.func_70107_b(playerIn.field_70165_t, playerIn.field_70163_u + 2.0, playerIn.field_70161_v);
                worldIn.func_72838_d((Entity)dev);
            }
        } else if (worldIn.field_72995_K) {
            playerIn.func_145747_a((Component)new Component((Object)((Object)TextFmt.Red) + "DETECTION: Creature missing!"));
        }
        return super.func_77659_a(worldIn, playerIn, handIn);
    }

    @SideOnly(value=Side.CLIENT)
    public void func_77624_a(ItemStack stack, @Nullable Level worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add((Object)((Object)TextFmt.Gold) + "Use near the following all at once to charge it:");
        tooltip.add((Object)((Object)TextFmt.Green) + "Deviant Creeper");
        tooltip.add((Object)((Object)TextFmt.Dark_Gray) + "Deviant Skeleton");
        tooltip.add((Object)((Object)TextFmt.White) + "Deviant Shulker");
        tooltip.add((Object)((Object)TextFmt.Light_Purple) + "Deviant Enderman");
    }
}

