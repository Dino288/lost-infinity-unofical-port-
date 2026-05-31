/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.state.BlockState
 *  net.minecraft.entity.player.Player
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.Direction
 *  net.minecraft.util.InteractionHand
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.text.Component
 *  net.minecraft.util.text.Component
 *  net.minecraft.world.World
 */
package xol.lostinfinity.block.activator;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.Level;
import xol.lostinfinity.block.basic.BlockBasic;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.ItemInit;

public class BlockPuzzleKey
extends BlockBasic {
    public BlockPuzzleKey(String name) {
        super(name);
    }

    public boolean func_180639_a(Level worldIn, BlockPos pos, BlockState state, Player playerIn, InteractionHand hand, Direction facing, float hitX, float hitY, float hitZ) {
        ItemStack heldstack = playerIn.func_184586_b(hand);
        if (heldstack.func_77973_b() == ItemInit.puzzleKey) {
            if (!worldIn.field_72995_K) {
                playerIn.func_191521_c(new ItemStack(ItemInit.beaconKey));
                playerIn.func_70634_a(0.0, 33.0, 0.0);
                playerIn.func_145747_a((Component)new Component((Object)((Object)TextFmt.Dark_Aqua) + "The Echo: Activate the beacon if you wish to play " + playerIn.func_70005_c_()));
            }
            heldstack.func_190918_g(1);
        }
        return true;
    }
}

