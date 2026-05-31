/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.state.BlockState
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.util.Direction
 *  net.minecraft.util.InteractionHand
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.world.World
 */
package xol.lostinfinity.block.misc;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import xol.lostinfinity.block.basic.BlockBasicGlass;
import xol.lostinfinity.dimension.util.DimensionActivator;
import xol.lostinfinity.init.DimensionInit;

public class BlockLabPortal
extends BlockBasicGlass {
    private int portalLocation = 0;

    public BlockLabPortal(String name, int portal) {
        super(name);
        this.portalLocation = portal;
        this.func_149715_a(1.0f);
    }

    public boolean func_180639_a(Level worldIn, BlockPos pos, BlockState state, Player playerIn, InteractionHand hand, Direction facing, float hitX, float hitY, float hitZ) {
        if (!worldIn.field_72995_K) {
            int roomRand_Z;
            int bound = 1000;
            int roomRand_X = worldIn.field_73012_v.nextInt(bound) - bound / 2;
            double yPlace = roomRand_X == (roomRand_Z = worldIn.field_73012_v.nextInt(bound) - bound / 2) ? 16.0 : 25.0;
            if (this.portalLocation == 0) {
                DimensionActivator.transferEntityWithCoords((Entity)playerIn, DimensionInit.cartographerRealmMid, 15 + 160 * roomRand_X, yPlace, 15 + 160 * roomRand_Z);
            } else {
                DimensionActivator.transferEntityWithCoords((Entity)playerIn, DimensionInit.cartographerRealmBot, 15 + 160 * roomRand_X, yPlace, 15 + 160 * roomRand_Z);
            }
        }
        return true;
    }
}

