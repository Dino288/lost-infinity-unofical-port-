/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.state.BlockState
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.item.ItemEntity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.Direction
 *  net.minecraft.util.InteractionHand
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.world.World
 */
package xol.lostinfinity.block.activator;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import xol.lostinfinity.block.basic.BlockBasic;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.item.activate.ItemEncryptedPowerBlueprints;

public class BlockMainPowerTerminal
extends BlockBasic {
    public BlockMainPowerTerminal(String name) {
        super(name);
    }

    public boolean func_180639_a(Level worldIn, BlockPos pos, BlockState state, Player playerIn, InteractionHand hand, Direction facing, float hitX, float hitY, float hitZ) {
        ItemEncryptedPowerBlueprints scroll;
        ItemStack held = playerIn.func_184586_b(hand);
        if (held.func_77973_b() == ItemInit.wiredRing) {
            if (!worldIn.field_72995_K) {
                held.func_190918_g(1);
                ItemEntity item = new ItemEntity(worldIn, (double)pos.func_177958_n(), (double)(pos.func_177956_o() + 2), (double)pos.func_177952_p(), new ItemStack(ItemInit.encryptedPowerBlueprints));
                item.field_70159_w = 0.0;
                item.field_70181_x = 0.0;
                item.field_70179_y = 0.0;
                worldIn.func_72838_d((Entity)item);
            }
        } else if (held.func_77973_b() == ItemInit.encryptedPowerBlueprints && !worldIn.field_72995_K && (scroll = (ItemEncryptedPowerBlueprints)held.func_77973_b()).getCompletion(held) == 3) {
            held.func_190918_g(1);
            ItemEntity item = new ItemEntity(worldIn, (double)pos.func_177958_n(), (double)(pos.func_177956_o() + 2), (double)pos.func_177952_p(), new ItemStack(ItemInit.electricalAccelerator));
            item.field_70159_w = 0.0;
            item.field_70181_x = 0.0;
            item.field_70179_y = 0.0;
            worldIn.func_72838_d((Entity)item);
        }
        return true;
    }
}

