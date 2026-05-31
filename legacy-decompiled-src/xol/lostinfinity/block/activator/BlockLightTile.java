/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.state.BlockState
 *  net.minecraft.entity.player.Player
 *  net.minecraft.init.SoundEvents
 *  net.minecraft.util.Direction
 *  net.minecraft.util.InteractionHand
 *  net.minecraft.util.SoundSource
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.world.World
 */
package xol.lostinfinity.block.activator;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.entity.player.Player;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundSource;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import xol.lostinfinity.block.basic.BlockBasic;
import xol.lostinfinity.init.BlockInit;

public class BlockLightTile
extends BlockBasic {
    public BlockLightTile(String name) {
        super(name);
        this.func_149715_a(1.0f);
    }

    public boolean func_180639_a(Level worldIn, BlockPos pos, BlockState state, Player playerIn, InteractionHand hand, Direction facing, float hitX, float hitY, float hitZ) {
        if (!worldIn.field_72995_K) {
            BlockPos[] adjblocks;
            if (state.func_177230_c().equals(BlockInit.lightTileLit)) {
                worldIn.func_175656_a(pos, BlockInit.lightTileDark.func_176223_P());
            } else {
                worldIn.func_175656_a(pos, BlockInit.lightTileLit.func_176223_P());
            }
            for (BlockPos side : adjblocks = new BlockPos[]{pos.func_177978_c(), pos.func_177974_f(), pos.func_177968_d(), pos.func_177976_e()}) {
                if (worldIn.func_180495_p(side).func_177230_c().equals(BlockInit.lightTileDark)) {
                    worldIn.func_175656_a(side, BlockInit.lightTileLit.func_176223_P());
                    continue;
                }
                if (!worldIn.func_180495_p(side).func_177230_c().equals(BlockInit.lightTileLit)) continue;
                worldIn.func_175656_a(side, BlockInit.lightTileDark.func_176223_P());
            }
            worldIn.func_184133_a(null, pos, SoundEvents.field_187620_cL, SoundSource.MASTER, 1.0f, 1.0f);
        }
        return true;
    }
}

