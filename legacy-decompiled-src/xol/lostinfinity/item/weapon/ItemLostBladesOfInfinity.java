/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.client.util.ITooltipFlag
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.entity.projectile.EntityArrow
 *  net.minecraft.entity.projectile.EntityThrowable
 *  net.minecraft.item.ItemStack
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.util.InteractionResultHolder
 *  net.minecraft.util.InteractionHand
 *  net.minecraft.world.World
 */
package xol.lostinfinity.item.weapon;

import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.world.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.level.Level;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.TabsInit;
import xol.lostinfinity.item.basics.ItemCooldown;
import xol.lostinfinity.item.classify.IHotbarHit;
import xol.lostinfinity.item.classify.IModeSelect;
import xol.lostinfinity.item.classify.ISummon;
import xol.lostinfinity.mob.entity.minion.EntityLostBlade;
import xol.lostinfinity.mob.entity.minion.EntityMinion;
import xol.lostinfinity.util.data.CustomDamageResult;

public class ItemLostBladesOfInfinity
extends ItemCooldown
implements IModeSelect,
IHotbarHit,
ISummon {
    public ItemLostBladesOfInfinity(String regName) {
        super(regName);
        this.func_77637_a(TabsInit.TAB_AUXWEP);
    }

    public InteractionResultHolder<ItemStack> func_77659_a(Level world, Player player, InteractionHand hand) {
        ItemStack stack = player.func_184586_b(hand);
        if (!this.showDurabilityBar(stack)) {
            if (!world.field_72995_K) {
                this.despawnPrevious(player);
                for (int i = 0; i < 6; ++i) {
                    EntityLostBlade lostBlade = new EntityLostBlade(world);
                    lostBlade.setOwner(player);
                    lostBlade.setHand(hand);
                    lostBlade.setLastSlot(player.field_71071_by.field_70461_c);
                    lostBlade.setPose(i);
                    lostBlade.setTrackedItemStack(stack);
                    world.func_72838_d((Entity)lostBlade);
                }
            }
            this.startCooldown(stack);
        }
        return super.func_77659_a(world, player, hand);
    }

    @Override
    public void hitReaction(Player player, Entity attacker, CustomDamageResult result, ItemStack stack) {
        if (this.getMode(stack) != BladeMode.REACTIVE) {
            return;
        }
        if (attacker instanceof EntityThrowable) {
            attacker = ((EntityThrowable)attacker).func_85052_h();
        }
        if (attacker instanceof EntityArrow) {
            attacker = ((EntityArrow)attacker).field_70250_c;
        }
        if (!(attacker instanceof LivingEntity)) {
            return;
        }
        LivingEntity livingBase = (LivingEntity)attacker;
        for (EntityMinion minion : this.getCurrentMinion(player)) {
            if (!(minion instanceof EntityLostBlade)) continue;
            ((EntityLostBlade)minion).setTarget(livingBase);
        }
    }

    @Override
    public void modeUpdate(ItemStack stack, Player player) {
        this.cycleMode(stack);
    }

    private void cycleMode(ItemStack stack) {
        if (!stack.func_77942_o()) {
            stack.func_77982_d(new CompoundTag());
        }
        stack.func_77978_p().func_74768_a("blade_mode", (stack.func_77978_p().func_74762_e("blade_mode") + 1) % BladeMode.values().length);
    }

    private BladeMode getMode(ItemStack stack) {
        if (!stack.func_77942_o()) {
            stack.func_77982_d(new CompoundTag());
            return BladeMode.STANDBY;
        }
        return BladeMode.values()[stack.func_77978_p().func_74762_e("blade_mode")];
    }

    public String getHighlightTip(ItemStack item, String displayName) {
        switch (this.getMode(item)) {
            case STANDBY: {
                return displayName + " - Standby";
            }
            case REACTIVE: {
                return displayName + " - Reactive";
            }
            case TARGET: {
                return displayName + " - Targeted";
            }
            case GENOCIDE: {
                return displayName + " - Genocide";
            }
        }
        return displayName;
    }

    public void func_77624_a(ItemStack stack, @Nullable Level worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add((Object)((Object)TextFmt.Gold) + "Summons the Blades of Infinity to fight alongside you.");
        tooltip.add((Object)((Object)TextFmt.Red) + "Each blade deals 20% Max Health Damage every 0.4 seconds.");
        switch (this.getMode(stack)) {
            case STANDBY: {
                tooltip.add("");
                tooltip.add((Object)((Object)TextFmt.Light_Purple) + "Current Mode: Standby");
                tooltip.add((Object)((Object)TextFmt.White) + "Your blades would not attack anything.");
                break;
            }
            case REACTIVE: {
                tooltip.add("");
                tooltip.add((Object)((Object)TextFmt.Light_Purple) + "Current Mode: Reactive");
                tooltip.add((Object)((Object)TextFmt.Green) + "Your blades would attack anything that damaged you.");
                break;
            }
            case TARGET: {
                tooltip.add("");
                tooltip.add((Object)((Object)TextFmt.Light_Purple) + "Current Mode: Targeted");
                tooltip.add((Object)((Object)TextFmt.Aqua) + "Your blades would attack your target.");
                break;
            }
            case GENOCIDE: {
                tooltip.add("");
                tooltip.add((Object)((Object)TextFmt.Light_Purple) + "Current Mode: Genocide");
                tooltip.add((Object)((Object)TextFmt.Red) + "Your blades would search and destroy anything within 24 blocks.");
            }
        }
        tooltip.add((Object)((Object)TextFmt.Aqua) + "Aquatic");
    }

    public static enum BladeMode {
        STANDBY,
        REACTIVE,
        TARGET,
        GENOCIDE;

    }
}

