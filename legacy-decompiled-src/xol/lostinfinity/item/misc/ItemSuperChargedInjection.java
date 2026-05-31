/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.client.util.ITooltipFlag
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.item.ItemStack
 *  net.minecraft.potion.PotionEffect
 *  net.minecraft.util.InteractionHand
 *  net.minecraft.util.SoundSource
 *  net.minecraft.world.World
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package xol.lostinfinity.item.misc;

import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.PotionInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.init.TabsInit;
import xol.lostinfinity.item.basics.ItemBasic;

public class ItemSuperChargedInjection
extends ItemBasic {
    public ItemSuperChargedInjection(String regName) {
        super(regName, TabsInit.TAB_AUXMATS);
    }

    public boolean func_111207_a(ItemStack stack, Player playerIn, LivingEntity target, InteractionHand hand) {
        if (target instanceof Player) {
            if (!playerIn.field_70170_p.field_72995_K) {
                playerIn.field_70170_p.func_184133_a(null, playerIn.func_180425_c(), SoundInit.SYRINGE_USE, SoundSource.MASTER, 1.5f, 1.0f);
            }
            target.func_70690_d(new PotionEffect(PotionInit.SUPERCHARGED, 72000, 9));
        }
        return super.func_111207_a(stack, playerIn, target, hand);
    }

    @SideOnly(value=Side.CLIENT)
    public void func_77624_a(ItemStack stack, @Nullable Level worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add((Object)((Object)TextFmt.Gold) + "Inject another player to grant them Super-Charged.");
        tooltip.add((Object)((Object)TextFmt.Light_Purple) + "Grants the player 10 lives, 50% dodge change, rapid healing, and a damage aura that deals 25% max health twice a second.");
    }
}

