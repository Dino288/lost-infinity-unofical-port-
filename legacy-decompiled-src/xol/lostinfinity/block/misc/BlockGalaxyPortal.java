/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.state.BlockState
 *  net.minecraft.entity.player.Player
 *  net.minecraft.util.Direction
 *  net.minecraft.util.InteractionHand
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.world.World
 */
package xol.lostinfinity.block.misc;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.entity.player.Player;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import xol.lostinfinity.block.basic.BlockBasicGlass;
import xol.lostinfinity.init.DimensionInit;
import xol.lostinfinity.util.coordinates.GalaxyCoordinates;

public class BlockGalaxyPortal
extends BlockBasicGlass {
    private int portalLocation = 0;

    public BlockGalaxyPortal(String name, int portal) {
        super(name);
        this.portalLocation = portal;
        this.func_149715_a(1.0f);
    }

    public boolean func_180639_a(Level worldIn, BlockPos pos, BlockState state, Player playerIn, InteractionHand hand, Direction facing, float hitX, float hitY, float hitZ) {
        if (!worldIn.field_72995_K && worldIn.field_73011_w.func_186058_p() == DimensionInit.nonexistence) {
            BlockPos teleTo = GalaxyCoordinates.getGalaxyTeleporter(this.portalLocation);
            playerIn.func_70634_a((double)teleTo.func_177958_n(), (double)teleTo.func_177956_o(), (double)teleTo.func_177952_p());
        }
        return true;
    }
}

