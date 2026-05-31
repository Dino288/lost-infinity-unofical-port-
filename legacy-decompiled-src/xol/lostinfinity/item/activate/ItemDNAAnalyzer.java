/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.client.util.ITooltipFlag
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.Mob
 *  net.minecraft.entity.monster.EntityCreeper
 *  net.minecraft.entity.monster.EntityEnderman
 *  net.minecraft.entity.monster.EntitySkeleton
 *  net.minecraft.entity.passive.EntityChicken
 *  net.minecraft.entity.passive.EntityCow
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
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityCow;
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
import xol.lostinfinity.mob.entity.deviant.EntityLostDeviant;

public class ItemDNAAnalyzer
extends Item {
    public ItemDNAAnalyzer(String regName) {
        this.func_77637_a(TabsInit.TAB_AUXMATS);
        this.setRegistryName(regName);
        this.func_77655_b(regName);
        ItemInit.ITEMS.add(this);
    }

    public InteractionResultHolder<ItemStack> func_77659_a(Level worldIn, Player playerIn, InteractionHand handIn) {
        boolean found_creeper = false;
        boolean found_skeleton = false;
        boolean found_chicken = false;
        boolean found_cow = false;
        boolean found_enderman = false;
        for (Mob li : worldIn.func_72872_a(Mob.class, playerIn.func_174813_aQ().func_72314_b(12.0, 12.0, 12.0))) {
            if (li instanceof EntityCreeper) {
                found_creeper = true;
                continue;
            }
            if (li instanceof EntitySkeleton) {
                found_skeleton = true;
                continue;
            }
            if (li instanceof EntityCow) {
                found_cow = true;
                continue;
            }
            if (li instanceof EntityChicken) {
                found_chicken = true;
                continue;
            }
            if (!(li instanceof EntityEnderman)) continue;
            found_enderman = true;
        }
        if (found_creeper && found_skeleton && found_chicken && found_cow && found_enderman) {
            playerIn.func_184185_a(SoundInit.SCANNER, 1.0f, 1.0f);
            playerIn.func_184611_a(handIn, new ItemStack(ItemInit.variantAnalyzerFull, 1));
            if (!worldIn.field_72995_K) {
                for (Mob li : worldIn.func_72872_a(Mob.class, playerIn.func_174813_aQ().func_72314_b(12.0, 12.0, 12.0))) {
                    if (!(li instanceof EntityCreeper) && !(li instanceof EntitySkeleton) && !(li instanceof EntityCow) && !(li instanceof EntityChicken) && !(li instanceof EntityEnderman)) continue;
                    EntityLostDeviant dev = new EntityLostDeviant(worldIn);
                    dev.func_70107_b(li.field_70165_t, li.field_70163_u, li.field_70161_v);
                    worldIn.func_72838_d((Entity)dev);
                    li.func_70106_y();
                }
            }
        } else if (worldIn.field_72995_K) {
            playerIn.func_145747_a((Component)new Component((Object)((Object)TextFmt.Red) + "DETECTION: Creature missing!"));
        }
        return super.func_77659_a(worldIn, playerIn, handIn);
    }

    @SideOnly(value=Side.CLIENT)
    public void func_77624_a(ItemStack stack, @Nullable Level worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add((Object)((Object)TextFmt.Gold) + "Use near the following all at once to charge it:");
        tooltip.add((Object)((Object)TextFmt.Green) + "Creeper");
        tooltip.add((Object)((Object)TextFmt.Dark_Gray) + "Skeleton");
        tooltip.add((Object)((Object)TextFmt.White) + "Chicken");
        tooltip.add((Object)((Object)TextFmt.Gray) + "Cow");
        tooltip.add((Object)((Object)TextFmt.Light_Purple) + "Enderman");
    }
}

