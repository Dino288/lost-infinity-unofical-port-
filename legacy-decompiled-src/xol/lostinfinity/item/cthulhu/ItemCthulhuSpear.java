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
 *  net.minecraft.util.math.Mth
 *  net.minecraft.world.World
 */
package xol.lostinfinity.item.cthulhu;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.level.Level;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.init.TabsInit;
import xol.lostinfinity.item.basics.ItemChanneling;
import xol.lostinfinity.mob.entity.cthulhu.EntityCthulhuSpear;

public class ItemCthulhuSpear
extends ItemChanneling {
    public ItemCthulhuSpear(String regName) {
        super(regName);
        this.func_77637_a(TabsInit.TAB_AUXWEP);
    }

    @Override
    public InteractionResultHolder<ItemStack> chargeStart(Level worldIn, Player player, InteractionHand handIn, ItemStack stack) {
        if (!worldIn.field_72995_K) {
            EntityCthulhuSpear spear = new EntityCthulhuSpear(worldIn);
            spear.setOwner(player);
            spear.updatePosition();
            worldIn.func_72838_d((Entity)spear);
        }
        return super.chargeStart(worldIn, player, handIn, stack);
    }

    @Override
    public void chargeTick(Level worldIn, Player player, InteractionHand hand, ItemStack stack, int chargeTime) {
        if (chargeTime % 10 == 0) {
            worldIn.func_184133_a(null, player.func_180425_c(), SoundInit.MAGIC_WEAPON_15, SoundSource.PLAYERS, 1.0f, 0.4f + 0.15f * (float)Mth.func_76141_d((float)(chargeTime / 10)));
        }
    }
}

