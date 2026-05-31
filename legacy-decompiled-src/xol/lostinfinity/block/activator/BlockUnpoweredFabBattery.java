/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.state.BlockState
 *  net.minecraft.entity.player.Player
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.Direction
 *  net.minecraft.util.InteractionHand
 *  net.minecraft.util.SoundSource
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.world.World
 */
package xol.lostinfinity.block.activator;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundSource;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import xol.lostinfinity.block.basic.BlockBasicLight;
import xol.lostinfinity.init.BlockInit;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.init.SoundInit;

public class BlockUnpoweredFabBattery
extends BlockBasicLight {
    public BlockUnpoweredFabBattery(String name) {
        super(name);
    }

    public boolean func_180639_a(Level worldIn, BlockPos pos, BlockState state, Player playerIn, InteractionHand hand, Direction facing, float hitX, float hitY, float hitZ) {
        ItemStack stack = playerIn.func_184586_b(hand);
        if (!stack.func_190926_b() && stack.func_77973_b().equals(ItemInit.fabricationPowerCore)) {
            if (!worldIn.field_72995_K) {
                worldIn.func_184133_a(null, pos, SoundInit.GENERIC_UI_3, SoundSource.MASTER, 1.0f, 1.0f);
                worldIn.func_175656_a(pos, BlockInit.fabricationBattery.func_176223_P());
            }
            stack.func_190918_g(1);
            return true;
        }
        return false;
    }
}

