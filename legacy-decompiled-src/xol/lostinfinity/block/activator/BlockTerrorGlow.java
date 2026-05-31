/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.state.BlockState
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.Direction
 *  net.minecraft.util.InteractionHand
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.world.World
 */
package xol.lostinfinity.block.activator;

import java.util.ArrayList;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import xol.lostinfinity.block.basic.BlockBasicBoolState;
import xol.lostinfinity.init.BlockInit;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.mob.entity.boss.EntityDuskerQueen;

public class BlockTerrorGlow
extends BlockBasicBoolState {
    public BlockTerrorGlow(String name) {
        super(name);
    }

    private static boolean validInput(ItemStack stack) {
        return stack.func_77973_b().equals(ItemInit.quickflameSolution);
    }

    public boolean func_180639_a(Level worldIn, BlockPos pos, BlockState state, Player playerIn, InteractionHand hand, Direction facing, float hitX, float hitY, float hitZ) {
        if (!playerIn.func_70093_af()) {
            if (BlockTerrorGlow.validInput(playerIn.func_184586_b(hand)) && !worldIn.field_72995_K && state == BlockInit.terrorGlow.func_176203_a(0)) {
                worldIn.func_175656_a(pos, BlockInit.terrorGlow.func_176203_a(1));
                ArrayList<BlockPos> lit = new ArrayList<BlockPos>();
                lit.add(pos);
                int radius = 20;
                int count = 0;
                for (int i = -radius; i <= radius; ++i) {
                    for (int j = -2; j <= 2; ++j) {
                        for (int k = -radius; k <= radius; ++k) {
                            BlockPos check = pos.func_177982_a(i, j, k);
                            if (worldIn.func_180495_p(check) != BlockInit.terrorGlow.func_176203_a(1)) continue;
                            ++count;
                            lit.add(check);
                        }
                    }
                }
                if (count >= 8) {
                    for (BlockPos litPos : lit) {
                        worldIn.func_175656_a(litPos, BlockInit.terrorGlow.func_176203_a(0));
                    }
                    EntityDuskerQueen queen = new EntityDuskerQueen(worldIn);
                    queen.func_70107_b(173.0, 35.0, -86.0);
                    worldIn.func_72838_d((Entity)queen);
                }
            }
            playerIn.func_184586_b(hand).func_190918_g(1);
        }
        return true;
    }
}

