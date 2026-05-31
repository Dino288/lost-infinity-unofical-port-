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
 *  net.minecraft.world.DimensionType
 *  net.minecraft.world.World
 */
package xol.lostinfinity.item.misc;

import java.util.Random;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.DimensionType;
import net.minecraft.world.level.Level;
import xol.lostinfinity.dimension.util.DimensionActivator;
import xol.lostinfinity.init.DimensionInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.init.TabsInit;
import xol.lostinfinity.item.basics.ItemBasic;
import xol.lostinfinity.item.classify.IDimensionSwitch;
import xol.lostinfinity.mob.entity.murk.EntityScreamer;

public class ItemScrollOfRedirection
extends ItemBasic
implements IDimensionSwitch {
    public ItemScrollOfRedirection(String regName) {
        super(regName, TabsInit.TAB_AUXMATS);
    }

    public InteractionResultHolder<ItemStack> func_77659_a(Level worldIn, Player playerIn, InteractionHand handIn) {
        if (!worldIn.field_72995_K && worldIn.field_73011_w.func_186058_p() == DimensionType.OVERWORLD) {
            DimensionActivator.transferEntityWithCoords((Entity)playerIn, DimensionInit.shadowSea, ItemScrollOfRedirection.randomCoordinate(playerIn.field_70170_p.field_73012_v), 160.0, ItemScrollOfRedirection.randomCoordinate(playerIn.field_70170_p.field_73012_v));
        }
        return super.func_77659_a(worldIn, playerIn, handIn);
    }

    private static double randomCoordinate(Random rand) {
        return (-0.5 + rand.nextDouble()) * 10000.0;
    }

    @Override
    public void onDimensionSwitch(Player player, ItemStack stack) {
        if (!player.field_70170_p.field_72995_K) {
            player.field_70170_p.func_184133_a(null, player.func_180425_c(), SoundInit.RAPID_TELEPORT, SoundSource.HOSTILE, 1.0f, 1.0f);
            player.func_70634_a(player.field_70165_t, (double)player.field_70170_p.func_189649_b((int)player.field_70165_t, (int)player.field_70161_v) + 0.5, player.field_70161_v);
            EntityScreamer screamer = new EntityScreamer(player.field_70170_p);
            screamer.func_70107_b(player.field_70165_t, player.field_70163_u + 15.0, player.field_70161_v);
            screamer.setInOcean(true);
            screamer.setLivesCount(50);
            player.field_70170_p.func_72838_d((Entity)screamer);
        }
        stack.func_190918_g(1);
    }
}

