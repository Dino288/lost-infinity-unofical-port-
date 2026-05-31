/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.client.util.ITooltipFlag
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.InteractionResultHolder
 *  net.minecraft.util.InteractionHand
 *  net.minecraft.util.SoundSource
 *  net.minecraft.world.World
 */
package xol.lostinfinity.item.weapon;

import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.Level;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.init.TabsInit;
import xol.lostinfinity.item.basics.ItemCooldown;
import xol.lostinfinity.item.classify.ICustomHoldPose;
import xol.lostinfinity.item.classify.ISummon;
import xol.lostinfinity.mob.entity.minion.EntityAbyssalCrabulon;

public class ItemAbyssalLantern
extends ItemCooldown
implements ICustomHoldPose,
ISummon {
    public ItemAbyssalLantern(String regName) {
        super(regName);
        this.func_77637_a(TabsInit.TAB_AUXWEP);
    }

    public InteractionResultHolder<ItemStack> func_77659_a(Level world, Player player, InteractionHand hand) {
        ItemStack stack = player.func_184586_b(hand);
        if (!this.showDurabilityBar(stack)) {
            if (!world.field_72995_K) {
                this.despawnPrevious(player);
                EntityAbyssalCrabulon tentacleLantern = new EntityAbyssalCrabulon(player.field_70170_p);
                tentacleLantern.setOwner(player);
                tentacleLantern.setHand(hand);
                tentacleLantern.setLastSlot(player.field_71071_by.field_70461_c);
                tentacleLantern.setTrackedItemStack(stack);
                tentacleLantern.func_70107_b(player.field_70165_t, player.field_70163_u, player.field_70161_v);
                world.func_72838_d((Entity)tentacleLantern);
                world.func_184133_a(null, player.func_180425_c(), SoundInit.CRABULON_AMBIENT, SoundSource.PLAYERS, 0.7f, 0.7f + world.field_73012_v.nextFloat() * 0.6f);
            }
            this.startCooldown(stack);
        }
        return super.func_77659_a(world, player, hand);
    }

    public void func_77624_a(ItemStack stack, @Nullable Level worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add((Object)((Object)TextFmt.Dark_Purple) + "Summons an Abyssal Crabulon to fight alongside you.");
    }
}

