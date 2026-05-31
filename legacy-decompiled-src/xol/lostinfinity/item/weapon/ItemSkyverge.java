/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.client.util.ITooltipFlag
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.Mob
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.init.SoundEvents
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.InteractionResultHolder
 *  net.minecraft.util.InteractionHand
 *  net.minecraft.util.SoundSource
 *  net.minecraft.world.World
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package xol.lostinfinity.item.weapon;

import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.TabsInit;
import xol.lostinfinity.item.basics.ItemCooldown;
import xol.lostinfinity.util.data.IMaxAttack;

public class ItemSkyverge
extends ItemCooldown
implements IMaxAttack {
    public ItemSkyverge(String regName) {
        super(regName);
        this.func_77637_a(TabsInit.TAB_INFINITYWEP);
    }

    public InteractionResultHolder<ItemStack> func_77659_a(Level worldIn, Player playerIn, InteractionHand handIn) {
        ItemStack stack = playerIn.func_184586_b(handIn);
        if (!this.showDurabilityBar(stack) && !worldIn.field_72995_K) {
            worldIn.func_184133_a(null, playerIn.func_180425_c(), SoundEvents.field_191244_bn, SoundSource.MASTER, 2.0f, 1.0f);
            for (Player e : worldIn.func_72872_a(Player.class, playerIn.func_174813_aQ().func_72314_b(15.0, 15.0, 15.0))) {
                if (e.func_110124_au() == playerIn.func_110124_au()) continue;
                e.func_70024_g(Math.signum(playerIn.field_70165_t - e.field_70165_t) * 0.7, 0.5 + Math.signum(playerIn.field_70163_u - e.field_70163_u) * 0.5, Math.signum(playerIn.field_70161_v - e.field_70161_v) * 0.7);
                e.field_70133_I = true;
                IMaxAttack.dealMaxHealth((Entity)playerIn, (LivingEntity)e, 8);
            }
            for (Mob li : worldIn.func_72872_a(Mob.class, playerIn.func_174813_aQ().func_72314_b(30.0, 30.0, 30.0))) {
                if (li.func_110124_au() == playerIn.func_110124_au()) continue;
                li.func_70024_g(Math.signum(playerIn.field_70165_t - li.field_70165_t) * -2.5, 0.5, Math.signum(playerIn.field_70161_v - li.field_70161_v) * -2.5);
                li.field_70133_I = true;
            }
        }
        return super.func_77659_a(worldIn, playerIn, handIn);
    }

    @Override
    protected int getCooldown() {
        return 1000;
    }

    @SideOnly(value=Side.CLIENT)
    public void func_77624_a(ItemStack stack, @Nullable Level worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add((Object)((Object)TextFmt.Aqua) + "When activated, creates 2 gusts of wind:");
        tooltip.add((Object)((Object)TextFmt.Red) + "A gust that forces creatures away.");
        tooltip.add((Object)((Object)TextFmt.Blue) + "A gust that damages and carries nearby players towards you.");
    }
}

