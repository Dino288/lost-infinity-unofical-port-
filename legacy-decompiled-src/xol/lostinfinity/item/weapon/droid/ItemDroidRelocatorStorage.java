/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.client.util.ITooltipFlag
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.item.ItemStack
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.util.InteractionResultHolder
 *  net.minecraft.util.InteractionHand
 *  net.minecraft.world.World
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package xol.lostinfinity.item.weapon.droid;

import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.init.TabsInit;
import xol.lostinfinity.item.basics.ItemCooldown;
import xol.lostinfinity.projectile.entity.EntityDroidBall;
import xol.lostinfinity.projectile.entity.EntityDroidSucker;

public class ItemDroidRelocatorStorage
extends ItemCooldown {
    public ItemDroidRelocatorStorage(String regName) {
        super(regName);
        this.func_77637_a(TabsInit.TAB_AUXWEP);
    }

    public InteractionResultHolder<ItemStack> func_77659_a(Level worldIn, Player playerIn, InteractionHand handIn) {
        if (!this.showDurabilityBar(playerIn.func_184586_b(handIn))) {
            ItemStack stack = playerIn.func_184586_b(handIn);
            if (!stack.func_77942_o()) {
                stack.func_77982_d(new CompoundTag());
                stack.func_77978_p().func_74768_a("Mode", 0);
                stack.func_77978_p().func_74768_a("Stored", 0);
            }
            if (stack.func_77978_p().func_74762_e("Mode") == 0) {
                if (!worldIn.field_72995_K) {
                    EntityDroidSucker shot = new EntityDroidSucker(worldIn, (LivingEntity)playerIn);
                    shot.setThrower((LivingEntity)playerIn);
                    shot.func_184538_a((Entity)playerIn, playerIn.field_70125_A, playerIn.field_70177_z, 0.0f, 1.5f, 1.0f);
                    worldIn.func_72838_d((Entity)shot);
                }
                stack.func_77978_p().func_74768_a("Mode", 1);
            } else {
                if (!worldIn.field_72995_K) {
                    EntityDroidBall shot = new EntityDroidBall(worldIn, (LivingEntity)playerIn, stack.func_77978_p().func_74762_e("Stored"));
                    shot.setThrower((LivingEntity)playerIn);
                    shot.setGrade(this.getSummonGrade());
                    shot.func_184538_a((Entity)playerIn, playerIn.field_70125_A, playerIn.field_70177_z, 0.0f, 1.5f, 1.0f);
                    if (playerIn.func_70093_af()) {
                        shot.setAttacking(false);
                    }
                    worldIn.func_72838_d((Entity)shot);
                }
                stack.func_77978_p().func_74768_a("Stored", 0);
                stack.func_77978_p().func_74768_a("Mode", 0);
            }
            playerIn.func_184185_a(SoundInit.MAGIC_WEAPON_1, 1.0f, 1.0f);
            playerIn.func_184586_b(handIn).func_77978_p().func_74772_a("lastUse", System.currentTimeMillis());
        }
        return super.func_77659_a(worldIn, playerIn, handIn);
    }

    protected int getSummonGrade() {
        return 0;
    }

    @Override
    protected int getCooldown() {
        return 3000;
    }

    @SideOnly(value=Side.CLIENT)
    public void func_77624_a(ItemStack stack, @Nullable Level worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add((Object)((Object)TextFmt.Red) + "Shoots a projectile that stores all nearby droids.");
        tooltip.add((Object)((Object)TextFmt.Gray) + "Can then shoot a projectile to deploy all stored droids.");
        if (stack.func_77942_o()) {
            if (stack.func_77978_p().func_74762_e("Mode") == 1) {
                tooltip.add((Object)((Object)TextFmt.Red) + "Stored: " + stack.func_77978_p().func_74762_e("Stored"));
            } else {
                tooltip.add((Object)((Object)TextFmt.Red) + "Ready to fire storage projectile!");
            }
        }
        tooltip.add((Object)((Object)TextFmt.Gray) + "Normal Fire: Relocated Droids are Aggressive");
        tooltip.add((Object)((Object)TextFmt.Gray) + "Shift Fire: Relocated Droids are Reactive");
        tooltip.add((Object)((Object)TextFmt.Aqua) + "Can be upgraded.");
    }
}

