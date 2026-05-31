/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.init.SoundEvents
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.InteractionResultHolder
 *  net.minecraft.util.InteractionHand
 *  net.minecraft.util.SoundSource
 *  net.minecraft.world.World
 */
package xol.lostinfinity.item.weapon;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.Level;
import xol.lostinfinity.init.TabsInit;
import xol.lostinfinity.item.basics.ItemBasic;
import xol.lostinfinity.projectile.entity.EntityInkBomb;

public class ItemInkBomb
extends ItemBasic {
    public ItemInkBomb(String regName) {
        super(regName, TabsInit.TAB_AUXWEP);
    }

    public InteractionResultHolder<ItemStack> func_77659_a(Level worldIn, Player playerIn, InteractionHand handIn) {
        ItemStack stack = playerIn.func_184586_b(handIn);
        if (!worldIn.field_72995_K) {
            EntityInkBomb shot = new EntityInkBomb(worldIn, (LivingEntity)playerIn);
            shot.setThrower((LivingEntity)playerIn);
            shot.func_184538_a((Entity)playerIn, playerIn.field_70125_A, playerIn.field_70177_z, 0.0f, 1.0f, 0.0f);
            worldIn.func_72838_d((Entity)shot);
            worldIn.func_184133_a(null, playerIn.func_180425_c(), SoundEvents.field_187578_au, SoundSource.PLAYERS, 0.7f, 0.7f + worldIn.field_73012_v.nextFloat() * 0.6f);
        }
        stack.func_190918_g(1);
        return super.func_77659_a(worldIn, playerIn, handIn);
    }
}

