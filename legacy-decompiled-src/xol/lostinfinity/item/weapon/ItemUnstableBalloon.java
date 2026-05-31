/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.creativetab.CreativeModeTab
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.InteractionResultHolder
 *  net.minecraft.util.InteractionHand
 *  net.minecraft.world.World
 */
package xol.lostinfinity.item.weapon;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.level.Level;
import xol.lostinfinity.item.basics.ItemBasic;
import xol.lostinfinity.projectile.entity.EntityUnstableBalloon;

public class ItemUnstableBalloon
extends ItemBasic {
    public ItemUnstableBalloon(String regName, CreativeModeTab tab) {
        super(regName, tab);
    }

    public InteractionResultHolder<ItemStack> func_77659_a(Level worldIn, Player playerIn, InteractionHand handIn) {
        ItemStack stack = playerIn.func_184586_b(handIn);
        if (!worldIn.field_72995_K) {
            EntityUnstableBalloon shot = new EntityUnstableBalloon(worldIn);
            shot.func_70634_a(playerIn.field_70165_t, playerIn.field_70163_u + (double)playerIn.field_70131_O + 1.0, playerIn.field_70161_v);
            shot.setThrower((LivingEntity)playerIn);
            shot.func_70186_c(0.0, 1.0, 0.0, 1.0f, 0.5f);
            worldIn.func_72838_d((Entity)shot);
        }
        stack.func_190918_g(1);
        return super.func_77659_a(worldIn, playerIn, handIn);
    }
}

