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
 *  net.minecraft.util.SoundSource
 *  net.minecraft.util.math.Mth
 *  net.minecraft.util.text.Component
 *  net.minecraft.util.text.Component
 *  net.minecraft.world.World
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package xol.lostinfinity.item.weapon;

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
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.init.TabsInit;
import xol.lostinfinity.item.classify.ICustomRaytrace;
import xol.lostinfinity.item.classify.IHotbarDeath;
import xol.lostinfinity.item.weapon.ItemCooldownSword;
import xol.lostinfinity.mob.entity.misc.EntityPickleMan;
import xol.lostinfinity.util.data.CustomHitResult;
import xol.lostinfinity.util.data.IMaxAttack;

public class ItemPickleSabre
extends ItemCooldownSword
implements IMaxAttack,
IHotbarDeath,
ICustomRaytrace {
    public ItemPickleSabre(String regName) {
        super(regName);
        this.func_77637_a(TabsInit.TAB_AUXWEP);
    }

    public InteractionResultHolder<ItemStack> func_77659_a(Level worldIn, Player playerIn, InteractionHand handIn) {
        int pstacks;
        ItemStack stack = playerIn.func_184586_b(handIn);
        if (!stack.func_77942_o()) {
            stack.func_77982_d(new CompoundTag());
        }
        if (!worldIn.field_72995_K && (pstacks = stack.func_77978_p().func_74762_e("PickleStacks")) > 0) {
            CustomHitResult trace_result = this.entityTrace(worldIn, (LivingEntity)playerIn, 45, EntityPickleMan.class);
            if (trace_result != null && trace_result.getResultEntity() != null) {
                EntityPickleMan hitPickle = (EntityPickleMan)trace_result.getResultEntity();
                hitPickle.addTrueDamageToAttacks(0.025f * (float)pstacks);
                hitPickle.setMyScale(1.0f + 0.2f * (float)pstacks);
                hitPickle.addExtraLives(pstacks);
            }
            worldIn.func_184133_a(null, playerIn.func_180425_c(), SoundInit.GENERIC_WEAPON_1, SoundSource.PLAYERS, 0.7f, 0.7f + worldIn.field_73012_v.nextFloat() * 0.6f);
        }
        playerIn.func_184586_b(handIn).func_77978_p().func_74772_a("lastUse", System.currentTimeMillis());
        return super.func_77659_a(worldIn, playerIn, handIn);
    }

    public boolean func_77644_a(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        IMaxAttack.dealMaxHealth((Entity)attacker, target, 1, 2.0f);
        return true;
    }

    @Override
    protected int getCooldown() {
        return 20000;
    }

    @SideOnly(value=Side.CLIENT)
    public void func_77624_a(ItemStack stack, @Nullable Level worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add((Object)((Object)TextFmt.Gold) + "Deals 200% max health damage per hit.");
        tooltip.add((Object)((Object)TextFmt.Red) + "When taking max health damage that would kill you, block it and:");
        tooltip.add(TextFmt.getFormatting(TextFmt.Italic, TextFmt.Green) + "Heal to full.");
        tooltip.add(TextFmt.getFormatting(TextFmt.Italic, TextFmt.Gold) + "Store the stacks of pickle power in your sword.");
        tooltip.add((Object)((Object)TextFmt.Underline) + "Gain a stack for each 5% of your max life blocked.");
        tooltip.add((Object)((Object)TextFmt.Green) + "You can consume stacks by buffing a Pickle Man:");
        tooltip.add((Object)((Object)TextFmt.Bold) + "Per Stack:" + (Object)((Object)TextFmt.Reset) + (Object)((Object)TextFmt.Aqua) + " Adds 2.5% Health As True Damage on hit.");
        tooltip.add((Object)((Object)TextFmt.Bold) + "Per Stack:" + (Object)((Object)TextFmt.Reset) + (Object)((Object)TextFmt.Aqua) + " Gain an extra life.");
        tooltip.add((Object)((Object)TextFmt.Bold) + "Per Stack:" + (Object)((Object)TextFmt.Reset) + (Object)((Object)TextFmt.Aqua) + " Increase in size.");
    }

    @Override
    public boolean playedKilled(ItemStack stack, Player player, Entity attacker, float damageDealt) {
        Level world = player.field_70170_p;
        if (!this.showDurabilityBar(stack)) {
            stack.func_77978_p().func_74772_a("lastUse", System.currentTimeMillis());
            if (!world.field_72995_K) {
                player.func_70691_i(player.func_110138_aP());
                world.func_184133_a(null, player.func_180425_c(), SoundInit.MAGIC_WEAPON_14, SoundSource.MASTER, 1.0f, 1.0f);
                float cappedDamage = Math.min(damageDealt, player.func_110138_aP());
                int stacksToAdd = Mth.func_76141_d((float)(cappedDamage / (player.func_110138_aP() / 20.0f)));
                stack.func_77978_p().func_74768_a("PickleStacks", Math.min(stack.func_77978_p().func_74762_e("PickleStacks") + stacksToAdd, 20));
                player.func_145747_a((Component)new Component((Object)((Object)TextFmt.Green) + "You have " + stack.func_77978_p().func_74762_e("PickleStacks") + " stacks."));
            }
            return false;
        }
        return true;
    }
}

