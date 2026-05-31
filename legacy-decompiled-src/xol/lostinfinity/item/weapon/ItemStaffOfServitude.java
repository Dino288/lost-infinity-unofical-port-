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
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.world.World
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
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
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.init.TabsInit;
import xol.lostinfinity.item.basics.ItemCooldown;
import xol.lostinfinity.item.classify.ICustomRaytrace;
import xol.lostinfinity.projectile.entity.EntityPortalEffect;
import xol.lostinfinity.util.data.CustomHitResult;

public class ItemStaffOfServitude
extends ItemCooldown
implements ICustomRaytrace {
    public ItemStaffOfServitude(String regName) {
        super(regName);
        this.func_77637_a(TabsInit.TAB_AUXWEP);
    }

    public InteractionResultHolder<ItemStack> func_77659_a(Level worldIn, Player playerIn, InteractionHand handIn) {
        if (!this.showDurabilityBar(playerIn.func_184586_b(handIn))) {
            CustomHitResult trace_result;
            ItemStack stack = playerIn.func_184586_b(handIn);
            if (!worldIn.field_72995_K && (trace_result = this.forwardTrace(worldIn, (Entity)playerIn, 10)) != null) {
                BlockPos resultPos = trace_result.getResultPos();
                EntityPortalEffect portal = new EntityPortalEffect(worldIn);
                portal.func_70107_b(resultPos.func_177958_n(), resultPos.func_177956_o(), resultPos.func_177952_p());
                portal.setCreator(playerIn);
                worldIn.func_72838_d((Entity)portal);
                worldIn.func_184133_a(null, resultPos, SoundInit.PORTAL_OPEN, SoundSource.PLAYERS, 1.0f, 1.0f);
            }
            worldIn.func_184133_a(null, playerIn.func_180425_c(), SoundInit.PORTAL_OPEN, SoundSource.PLAYERS, 1.0f, 1.0f);
            playerIn.func_184586_b(handIn).func_77978_p().func_74772_a("lastUse", System.currentTimeMillis());
        }
        return super.func_77659_a(worldIn, playerIn, handIn);
    }

    @Override
    protected int getCooldown() {
        return 1000;
    }

    @SideOnly(value=Side.CLIENT)
    public void func_77624_a(ItemStack stack, @Nullable Level worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add((Object)((Object)TextFmt.Aqua) + "Can be used to open portals.");
        tooltip.add((Object)((Object)TextFmt.Gold) + "Tentaclons serve you forever, dealing 100% max health damage.");
    }
}

