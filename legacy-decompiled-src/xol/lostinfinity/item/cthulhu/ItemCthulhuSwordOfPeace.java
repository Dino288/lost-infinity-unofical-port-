/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.InteractionHand
 *  net.minecraft.util.SoundSource
 *  net.minecraft.world.World
 */
package xol.lostinfinity.item.cthulhu;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.Level;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.item.cthulhu.AbstractCthulhuSword;
import xol.lostinfinity.mob.entity.cthulhu.EntityCthulhu;

public class ItemCthulhuSwordOfPeace
extends AbstractCthulhuSword {
    public ItemCthulhuSwordOfPeace(String regName) {
        super(regName);
    }

    public boolean onEntitySwing(LivingEntity entityLiving, ItemStack stack) {
        if (entityLiving instanceof Player) {
            Player player = (Player)entityLiving;
            ItemCthulhuSwordOfPeace.checkHittingBarrier(player);
        }
        return super.onEntitySwing(entityLiving, stack);
    }

    private static void checkHittingBarrier(Player entityPlayer) {
        Level world = entityPlayer.field_70170_p;
        if (!entityPlayer.func_184586_b(InteractionHand.MAIN_HAND).func_77973_b().equals(ItemInit.cthulhuSwordPeace)) {
            return;
        }
        if (world.field_72995_K && ItemCthulhuSwordOfPeace.isHittingBarrier(entityPlayer)) {
            world.func_184133_a(null, entityPlayer.func_180425_c(), SoundInit.FORCEFIELD_HIT, SoundSource.PLAYERS, 1.0f, 0.8f + entityPlayer.field_70170_p.field_73012_v.nextFloat() * 0.4f);
            entityPlayer.field_70170_p.field_72996_f.stream().filter(entity -> entity instanceof EntityCthulhu).map(entity -> (EntityCthulhu)entity).findFirst().ifPresent(cthulhu -> ItemCthulhuSwordOfPeace.sendCthulhuPacket(3, 20, cthulhu.func_145782_y()));
        }
    }
}

