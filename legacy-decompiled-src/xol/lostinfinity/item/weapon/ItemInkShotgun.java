/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.player.Player
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
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.Level;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.init.TabsInit;
import xol.lostinfinity.item.basics.ItemCooldown;
import xol.lostinfinity.item.classify.ICustomHoldPose;
import xol.lostinfinity.projectile.entity.EntityInkShot;

public class ItemInkShotgun
extends ItemCooldown
implements ICustomHoldPose {
    public ItemInkShotgun(String regName) {
        super(regName);
        this.func_77637_a(TabsInit.TAB_AUXWEP);
    }

    public InteractionResultHolder<ItemStack> func_77659_a(Level worldIn, Player playerIn, InteractionHand handIn) {
        ItemStack stack = playerIn.func_184586_b(handIn);
        if (!this.showDurabilityBar(stack)) {
            if (!worldIn.field_72995_K) {
                for (int i = 0; i < 5; ++i) {
                    EntityInkShot shot = new EntityInkShot(worldIn, (LivingEntity)playerIn);
                    shot.setThrower((LivingEntity)playerIn);
                    shot.func_184538_a((Entity)playerIn, playerIn.field_70125_A, playerIn.field_70177_z, 0.0f, 1.0f, 15.0f);
                    worldIn.func_72838_d((Entity)shot);
                }
                worldIn.func_184133_a(null, playerIn.func_180425_c(), SoundInit.PAINT_GUN, SoundSource.PLAYERS, 1.0f, 0.5f + worldIn.field_73012_v.nextFloat() * 0.4f);
            }
            playerIn.func_184586_b(handIn).func_77978_p().func_74772_a("lastUse", System.currentTimeMillis());
        }
        return super.func_77659_a(worldIn, playerIn, handIn);
    }

    @Override
    protected int getCooldown() {
        return 1000;
    }
}

