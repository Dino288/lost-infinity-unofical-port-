/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.client.util.ITooltipFlag
 *  net.minecraft.creativetab.CreativeModeTab
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.InteractionResultHolder
 *  net.minecraft.util.InteractionHand
 *  net.minecraft.util.SoundSource
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.world.World
 */
package xol.lostinfinity.item.weapon;

import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundSource;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.item.basics.ItemCooldown;
import xol.lostinfinity.item.classify.ICustomRaytrace;
import xol.lostinfinity.projectile.entity.EntityWhirlpool;
import xol.lostinfinity.util.data.CustomHitResult;

public class ItemWhirlpool
extends ItemCooldown
implements ICustomRaytrace {
    private static final int RANGE = 5;

    public ItemWhirlpool(String regName, CreativeModeTab tab) {
        super(regName);
        this.func_77637_a(tab);
    }

    public InteractionResultHolder<ItemStack> func_77659_a(Level worldIn, Player playerIn, InteractionHand handIn) {
        if (!this.showDurabilityBar(playerIn.func_184586_b(handIn))) {
            CustomHitResult crtResult;
            if (!worldIn.field_72995_K && (crtResult = this.forwardTrace(worldIn, (Entity)playerIn, 5)) != null) {
                BlockPos resultPos = crtResult.getResultPos();
                EntityWhirlpool entityWhirlpool = new EntityWhirlpool(worldIn);
                entityWhirlpool.setOwner((Entity)playerIn);
                entityWhirlpool.func_70107_b(resultPos.func_177958_n(), (float)resultPos.func_177956_o() + 0.1f, resultPos.func_177952_p());
                worldIn.func_72838_d((Entity)entityWhirlpool);
                worldIn.func_184133_a(null, crtResult.getResultPos(), SoundInit.MAGIC_WEAPON_7, SoundSource.PLAYERS, 1.0f, 1.0f);
            }
            playerIn.func_184586_b(handIn).func_77978_p().func_74772_a("lastUse", System.currentTimeMillis());
        }
        return super.func_77659_a(worldIn, playerIn, handIn);
    }

    @Override
    protected int getCooldown() {
        return 2000;
    }

    public void func_77624_a(ItemStack stack, @Nullable Level worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add((Object)((Object)TextFmt.Gold) + "Right-Click to spawn a whirlpool at your targeted location.");
        tooltip.add((Object)((Object)TextFmt.Gold) + "The whirlpool will slowly grow and pull enemies towards it's center.");
        tooltip.add((Object)((Object)TextFmt.Gold) + "It deals massive damage to enemies that get too close.");
        tooltip.add((Object)((Object)TextFmt.Aqua) + "Aquatic");
    }
}

