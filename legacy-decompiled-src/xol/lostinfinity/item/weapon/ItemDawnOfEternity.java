/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.entity.PlayerSP
 *  net.minecraft.client.util.ITooltipFlag
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.item.Item
 *  net.minecraft.item.Item$ToolMaterial
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.SwordItem
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.util.InteractionHand
 *  net.minecraft.world.World
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package xol.lostinfinity.item.weapon;

import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.PlayerSP;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.init.TabsInit;
import xol.lostinfinity.item.classify.IMaxNullable;
import xol.lostinfinity.item.classify.IModeSelect;
import xol.lostinfinity.item.classify.ISwitchModels;
import xol.lostinfinity.item.weapon.ItemDuskOfEternity;
import xol.lostinfinity.util.data.CustomDamageResult;
import xol.lostinfinity.util.data.IMaxAttack;

public class ItemDawnOfEternity
extends SwordItem
implements IMaxAttack,
IMaxNullable,
ISwitchModels,
IModeSelect {
    private static final String MODE_DATA = "mode_data";
    private static final int ASC_MODE = 0;
    private static final float ASC_HIT_DAMAGE = 3.0f;
    private static final float ASC_AIR_DAMAGE = 1.5f;
    private static final int RES_MODE = 1;
    private static final float RES_HIT_DAMAGE = 0.5f;
    private static final float RES_OH_BLOCK_CHANCE = 0.5f;

    public ItemDawnOfEternity(String regName) {
        super(Item.ToolMaterial.DIAMOND);
        this.func_77637_a(TabsInit.TAB_AUXWEP);
        this.setRegistryName(regName);
        this.func_77655_b(regName);
        ItemInit.ITEMS.add((Item)this);
        this.setModelSwitch("mode", (Item)this, 2);
    }

    public boolean func_77644_a(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (!this.isPaired(attacker, InteractionHand.OFF_HAND)) {
            return true;
        }
        switch (this.getMode(stack)) {
            case 0: {
                if (target.field_70122_E) {
                    IMaxAttack.dealMaxHealth((Entity)attacker, target, 2, 3.0f);
                    break;
                }
                IMaxAttack.dealTrueDamage((Entity)attacker, target, target.func_110138_aP() * 1.5f);
                break;
            }
            case 1: {
                IMaxAttack.dealTrueDamage((Entity)attacker, target, target.func_110138_aP() * 0.5f);
                attacker.func_70691_i(attacker.func_110138_aP());
            }
        }
        ItemStack other = attacker.func_184592_cb();
        attacker.func_184611_a(InteractionHand.MAIN_HAND, other);
        attacker.func_184611_a(InteractionHand.OFF_HAND, stack);
        return true;
    }

    @Override
    public float nullableReaction(Player player, boolean isMainHand, float originalDamage, float newDamage, ItemStack stack) {
        if (player.field_70170_p.field_72995_K || isMainHand || !this.isPaired((LivingEntity)player, InteractionHand.MAIN_HAND)) {
            return newDamage;
        }
        if (this.getMode(stack) == 1 && player.field_70170_p.field_73012_v.nextFloat() > 0.5f) {
            player.func_70691_i(player.func_110138_aP());
            return 0.0f;
        }
        return newDamage;
    }

    @Override
    public float trueNullableReaction(Player player, boolean isMainHand, float originalDamage, float newDamage, ItemStack stack, CustomDamageResult result) {
        if (player.field_70170_p.field_72995_K || isMainHand || !this.isPaired((LivingEntity)player, InteractionHand.MAIN_HAND)) {
            return newDamage;
        }
        if (this.getMode(stack) == 0 && !result.getAttacker().field_70122_E && player.field_70170_p.field_73012_v.nextBoolean()) {
            result.setHitMissed();
            return 0.0f;
        }
        return newDamage;
    }

    @Override
    public void modeUpdate(ItemStack stack, Player player) {
        this.toggleMode(stack);
    }

    @SideOnly(value=Side.CLIENT)
    public void func_77624_a(ItemStack stack, @Nullable Level worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add("Twin sword of the " + (Object)((Object)TextFmt.Light_Purple) + "Dusk of Eternity" + (Object)((Object)TextFmt.Reset) + ".");
        PlayerSP player = Minecraft.func_71410_x().field_71439_g;
        if (player != null) {
            if (player.func_184586_b(InteractionHand.MAIN_HAND) == stack && this.isPaired((LivingEntity)player, InteractionHand.OFF_HAND) || player.func_184586_b(InteractionHand.OFF_HAND) == stack && this.isPaired((LivingEntity)player, InteractionHand.MAIN_HAND)) {
                tooltip.add(TextFmt.getFormatting(TextFmt.Dark_Purple, TextFmt.Bold) + "You can feel their power resonating!");
            } else {
                tooltip.add((Object)((Object)TextFmt.Dark_Gray) + "Without its twins, the sword feels strangely heavier...");
            }
        }
        switch (this.getMode(stack)) {
            case 0: {
                tooltip.add((Object)((Object)TextFmt.Aqua) + "Current mode: Ascentrum");
                tooltip.add((Object)((Object)TextFmt.Red) + "Main hand: If your target is airborne. deals true damage.");
                tooltip.add((Object)((Object)TextFmt.Red) + "Deals 150% Health Damage");
                tooltip.add((Object)((Object)TextFmt.Blue) + "Off hand: 50% chance dodging (infinity) damage dealt by airborne enemies.");
                break;
            }
            case 1: {
                tooltip.add((Object)((Object)TextFmt.Green) + "Current mode: Restorum");
                tooltip.add((Object)((Object)TextFmt.Red) + "Main hand: Restore all your health on hit.");
                tooltip.add((Object)((Object)TextFmt.Red) + "Deal 50% Health True Damage");
                tooltip.add((Object)((Object)TextFmt.Blue) + "Off hand: 50% chance to block max health damage, and restore all your health.");
            }
        }
    }

    private void toggleMode(ItemStack stack) {
        if (!stack.func_77942_o()) {
            stack.func_77982_d(new CompoundTag());
        }
        CompoundTag compound = stack.func_77978_p();
        compound.func_74768_a(MODE_DATA, (compound.func_74762_e(MODE_DATA) + 1) % 2);
    }

    private int getMode(ItemStack stack) {
        if (!stack.func_77942_o()) {
            stack.func_77982_d(new CompoundTag());
        }
        return stack.func_77978_p().func_74762_e(MODE_DATA);
    }

    private boolean isPaired(LivingEntity player, InteractionHand other) {
        return player.func_184586_b(other).func_77973_b() instanceof ItemDuskOfEternity;
    }
}

