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
 *  net.minecraft.util.text.Component
 *  net.minecraft.util.text.Component
 *  net.minecraft.world.World
 */
package xol.lostinfinity.block.activator;

import java.util.ArrayList;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundSource;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.Level;
import xol.lostinfinity.block.basic.BlockBasic;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.BlockInit;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.util.coordinates.GalaxyCoordinates;

public class BlockCellCharger
extends BlockBasic {
    public BlockCellCharger(String name) {
        super(name);
    }

    public boolean func_180639_a(Level worldIn, BlockPos pos, BlockState state, Player playerIn, InteractionHand hand, Direction facing, float hitX, float hitY, float hitZ) {
        ItemStack stack = playerIn.func_184586_b(hand);
        if (stack.func_77973_b() == ItemInit.unpoweredCell) {
            ArrayList<BlockPos> corePositions = GalaxyCoordinates.getCorePositions();
            boolean foundAll = true;
            for (BlockPos corePos : corePositions) {
                if (worldIn.func_180495_p(corePos) == BlockInit.blightedCore.func_176203_a(1)) continue;
                foundAll = false;
                break;
            }
            if (foundAll) {
                if (!worldIn.field_72995_K) {
                    for (BlockPos corePos : corePositions) {
                        worldIn.func_175656_a(corePos, BlockInit.blightedCore.func_176203_a(0));
                    }
                    playerIn.func_191521_c(new ItemStack(ItemInit.eternoCell));
                    worldIn.func_184133_a(null, pos, SoundInit.ELECTRIC_WOOSH, SoundSource.MASTER, 1.0f, 1.0f);
                }
                stack.func_190918_g(1);
            } else if (!worldIn.field_72995_K) {
                playerIn.func_145747_a((Component)new Component((Object)((Object)TextFmt.Red) + "The power cores are not all powered."));
            }
        }
        return true;
    }
}

