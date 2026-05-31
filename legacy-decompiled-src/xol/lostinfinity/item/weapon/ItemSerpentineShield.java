/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.client.util.ITooltipFlag
 *  net.minecraft.entity.player.Player
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.SoundSource
 *  net.minecraft.world.World
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package xol.lostinfinity.item.weapon;

import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.init.TabsInit;
import xol.lostinfinity.item.basics.ItemCooldown;
import xol.lostinfinity.item.classify.IMaxNullable;

public class ItemSerpentineShield
extends ItemCooldown
implements IMaxNullable {
    public ItemSerpentineShield(String regName) {
        super(regName);
        this.func_77637_a(TabsInit.TAB_AUXWEP);
    }

    @Override
    protected int getCooldown() {
        return 3000;
    }

    @Override
    public float nullableReaction(Player player, boolean isMainHand, float originalDamage, float newDamage, ItemStack stack) {
        if (!this.showDurabilityBar(stack)) {
            player.field_70170_p.func_184133_a(null, player.func_180425_c(), SoundInit.SHIELD_BLOCK, SoundSource.PLAYERS, 1.0f, 0.8f + player.field_70170_p.field_73012_v.nextFloat() * 0.4f);
            stack.func_77978_p().func_74772_a("lastUse", System.currentTimeMillis());
            return 0.0f;
        }
        return newDamage;
    }

    @SideOnly(value=Side.CLIENT)
    public void func_77624_a(ItemStack stack, @Nullable Level worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add((Object)((Object)TextFmt.Light_Purple) + "When held, blocks the next max health damage hit.");
        tooltip.add((Object)((Object)TextFmt.Gold) + "Upon blocking, this goes on a short cooldown.");
    }
}

