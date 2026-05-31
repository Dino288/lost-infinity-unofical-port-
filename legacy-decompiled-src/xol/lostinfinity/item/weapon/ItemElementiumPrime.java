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
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.init.TabsInit;
import xol.lostinfinity.item.basics.ItemCooldown;
import xol.lostinfinity.item.classify.ICustomHoldPose;
import xol.lostinfinity.projectile.entity.EntityElementiumPrime;

public class ItemElementiumPrime
extends ItemCooldown
implements ICustomHoldPose {
    public ItemElementiumPrime(String regName) {
        super(regName);
        this.func_77637_a(TabsInit.TAB_INFINITYWEP);
    }

    public InteractionResultHolder<ItemStack> func_77659_a(Level worldIn, Player playerIn, InteractionHand handIn) {
        if (!this.showDurabilityBar(playerIn.func_184586_b(handIn))) {
            if (!worldIn.field_72995_K) {
                for (int shot = 0; shot < 8; ++shot) {
                    EntityElementiumPrime water = new EntityElementiumPrime(worldIn, (LivingEntity)playerIn);
                    water.setThrower((LivingEntity)playerIn);
                    water.func_184538_a((Entity)playerIn, playerIn.field_70125_A, playerIn.field_70177_z, 0.0f, 2.0f, 8.0f);
                    worldIn.func_72838_d((Entity)water);
                }
                worldIn.func_184133_a(null, playerIn.func_180425_c(), SoundInit.CROSSBOW, SoundSource.MASTER, 1.0f, 1.0f);
            }
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
        tooltip.add((Object)((Object)TextFmt.Gold) + "Shoots a bunch of arrows that combine ALL prior Elementium Elements.");
        tooltip.add((Object)((Object)TextFmt.Italic) + "Combines Air, Water, Earth, Fire, Shadow, Blight & Plague");
    }
}

