/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.InteractionResultHolder
 *  net.minecraft.util.InteractionHand
 *  net.minecraft.util.SoundSource
 *  net.minecraft.util.math.AABB
 *  net.minecraft.world.World
 */
package xol.lostinfinity.item.misc;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.Level;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.init.TabsInit;
import xol.lostinfinity.item.basics.ItemCooldown;
import xol.lostinfinity.mob.entity.misc.EntityPlasmaSlicer;

public class ItemPlasmaEmitter
extends ItemCooldown {
    public ItemPlasmaEmitter(String regName) {
        super(regName);
        this.func_77637_a(TabsInit.TAB_AUXWEP);
    }

    public InteractionResultHolder<ItemStack> func_77659_a(Level worldIn, Player playerIn, InteractionHand handIn) {
        ItemStack stack;
        if (!worldIn.field_72995_K) {
            for (EntityPlasmaSlicer slicer : worldIn.func_72872_a(EntityPlasmaSlicer.class, new AABB(playerIn.func_180425_c()).func_186662_g(3.0))) {
                if (!slicer.getEmitter().func_110124_au().equals(playerIn) && !slicer.getReceiver().func_110124_au().equals(playerIn)) continue;
                slicer.func_70106_y();
                break;
            }
        }
        if (!this.showDurabilityBar(stack = playerIn.func_184586_b(handIn))) {
            if (!worldIn.field_72995_K) {
                double radius = 15.0;
                for (Player player : worldIn.func_72872_a(Player.class, new AABB(playerIn.func_180425_c()).func_186662_g(radius))) {
                    if (player.func_110124_au().equals(playerIn.func_110124_au()) || player.func_184614_ca().func_77973_b() != ItemInit.plasmaReceiver) continue;
                    EntityPlasmaSlicer slicer = new EntityPlasmaSlicer(worldIn);
                    slicer.setEmitter(playerIn);
                    slicer.setReceiver(player);
                    slicer.setStableDist(playerIn.func_70032_d((Entity)player));
                    slicer.func_70634_a(playerIn.field_70165_t, playerIn.field_70163_u + (double)playerIn.field_70131_O / 2.0, playerIn.field_70161_v);
                    worldIn.func_72838_d((Entity)slicer);
                    worldIn.func_184133_a(null, playerIn.func_180425_c(), SoundInit.ELECTRIC_WOOSH, SoundSource.PLAYERS, 0.7f, 0.7f + worldIn.field_73012_v.nextFloat() * 0.6f);
                    break;
                }
            }
            playerIn.func_184586_b(handIn).func_77978_p().func_74772_a("lastUse", System.currentTimeMillis());
        }
        return super.func_77659_a(worldIn, playerIn, handIn);
    }

    @Override
    protected int getCooldown() {
        return 10000;
    }
}

