/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.client.util.ITooltipFlag
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.init.SoundEvents
 *  net.minecraft.item.ItemStack
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.util.InteractionResultHolder
 *  net.minecraft.util.EnumInteractionResultHolder
 *  net.minecraft.util.InteractionHand
 *  net.minecraft.util.SoundSource
 *  net.minecraft.util.text.Component
 *  net.minecraft.util.text.Component
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
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.util.EnumInteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundSource;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.init.TabsInit;
import xol.lostinfinity.item.classify.ISwitchModels;
import xol.lostinfinity.item.weapon.droid.ItemDroidRelocatorMK2;
import xol.lostinfinity.projectile.entity.EntityDroidBall;
import xol.lostinfinity.projectile.entity.EntityDroidSucker;

public class ItemDroidConstructorMK3
extends ItemDroidRelocatorMK2
implements ISwitchModels {
    public ItemDroidConstructorMK3(String regName) {
        super(regName);
        this.func_77637_a(TabsInit.TAB_INFINITYWEP);
        this.setModelSwitch("primarytype", this, 2);
    }

    @Override
    public InteractionResultHolder<ItemStack> func_77659_a(Level worldIn, Player playerIn, InteractionHand handIn) {
        ItemStack stack = playerIn.func_184586_b(handIn);
        if (!stack.func_77942_o()) {
            stack.func_77982_d(new CompoundTag());
            stack.func_77978_p().func_74768_a("primarytype_data", 0);
            stack.func_77978_p().func_74768_a("Mode", 0);
        }
        if (playerIn.func_70093_af()) {
            int mode = stack.func_77978_p().func_74762_e("Mode");
            int primary = stack.func_77978_p().func_74762_e("primarytype_data");
            if (this.atMaxMode(primary, mode)) {
                int newPrimary = stack.func_77978_p().func_74762_e("primarytype_data") + 1;
                if (newPrimary == 2) {
                    newPrimary = 0;
                }
                stack.func_77978_p().func_74768_a("primarytype_data", newPrimary);
                stack.func_77978_p().func_74768_a("Mode", 0);
            } else {
                stack.func_77978_p().func_74768_a("Mode", mode + 1);
            }
            if (!worldIn.field_72995_K) {
                playerIn.func_145747_a((Component)new Component(this.getModeDescription(stack.func_77978_p().func_74762_e("primarytype_data"), stack.func_77978_p().func_74762_e("Mode"))));
                worldIn.func_184133_a(null, playerIn.func_180425_c(), SoundEvents.field_187556_aj, SoundSource.MASTER, 2.0f, 1.0f);
            }
        } else if (!this.showDurabilityBar(playerIn.func_184586_b(handIn))) {
            if (stack.func_77978_p().func_74762_e("primarytype_data") == 0) {
                if (!worldIn.field_72995_K) {
                    EntityDroidBall shot = new EntityDroidBall(worldIn, (LivingEntity)playerIn);
                    shot.setThrower((LivingEntity)playerIn);
                    shot.setGrade(2);
                    shot.func_184538_a((Entity)playerIn, playerIn.field_70125_A, playerIn.field_70177_z, 0.0f, 1.5f, 1.0f);
                    if (stack.func_77978_p().func_74762_e("Mode") == 1) {
                        shot.setAttacking(false);
                    }
                    worldIn.func_72838_d((Entity)shot);
                    worldIn.func_184133_a(null, playerIn.func_180425_c(), SoundInit.MAGIC_WEAPON_2, SoundSource.MASTER, 2.0f, 1.0f);
                }
            } else {
                int mode = stack.func_77978_p().func_74762_e("Mode");
                if (!worldIn.field_72995_K) {
                    if (mode == 0) {
                        EntityDroidSucker shot = new EntityDroidSucker(worldIn, (LivingEntity)playerIn);
                        shot.setThrower((LivingEntity)playerIn);
                        shot.func_184538_a((Entity)playerIn, playerIn.field_70125_A, playerIn.field_70177_z, 0.0f, 1.5f, 1.0f);
                        worldIn.func_72838_d((Entity)shot);
                    } else {
                        EntityDroidBall shot = new EntityDroidBall(worldIn, (LivingEntity)playerIn, stack.func_77978_p().func_74762_e("Stored"));
                        shot.setThrower((LivingEntity)playerIn);
                        shot.setGrade(2);
                        shot.func_184538_a((Entity)playerIn, playerIn.field_70125_A, playerIn.field_70177_z, 0.0f, 1.5f, 1.0f);
                        if (mode == 2) {
                            shot.setAttacking(false);
                        }
                        worldIn.func_72838_d((Entity)shot);
                        stack.func_77978_p().func_74768_a("Stored", 0);
                    }
                    worldIn.func_184133_a(null, playerIn.func_180425_c(), SoundInit.MAGIC_WEAPON_1, SoundSource.MASTER, 2.0f, 1.0f);
                }
            }
            playerIn.func_184586_b(handIn).func_77978_p().func_74772_a("lastUse", System.currentTimeMillis());
        }
        return new InteractionResultHolder(EnumInteractionResultHolder.PASS, (Object)playerIn.func_184586_b(handIn));
    }

    @Override
    protected int getCooldown() {
        return 300;
    }

    private boolean atMaxMode(int primary, int mode) {
        return mode == primary + 1;
    }

    private String getModeDescription(int primary, int mode) {
        String msg = "";
        msg = primary == 0 ? (mode == 0 ? (Object)((Object)TextFmt.Red) + "Constructing: Aggressive Droids" : (Object)((Object)TextFmt.Blue) + "Constructing: Reactive Droids") : (mode == 0 ? (Object)((Object)TextFmt.Gold) + "Relocator Enabled" : (mode == 1 ? (Object)((Object)TextFmt.Red) + "Deploying Stored Droids: Aggressive" : (Object)((Object)TextFmt.Blue) + "Deploying Stored Droids: Reactive"));
        return msg;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void func_77624_a(ItemStack stack, @Nullable Level worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add((Object)((Object)TextFmt.Gold) + "Summoned droids are extremely powerful.");
        tooltip.add((Object)((Object)TextFmt.Italic) + "Shift-Activate To Cycle Modes");
        if (stack.func_77942_o()) {
            tooltip.add((Object)((Object)TextFmt.Gray) + "Stored Droids: " + stack.func_77978_p().func_74762_e("Stored"));
        }
    }
}

