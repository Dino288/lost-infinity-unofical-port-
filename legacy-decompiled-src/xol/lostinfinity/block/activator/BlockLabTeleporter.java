/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.material.Material
 *  net.minecraft.block.state.BlockState
 *  net.minecraft.entity.player.Player
 *  net.minecraft.util.Direction
 *  net.minecraft.util.InteractionHand
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.world.World
 */
package xol.lostinfinity.block.activator;

import net.minecraft.block.material.Material;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.entity.player.Player;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import xol.lostinfinity.block.basic.BlockBasic;

public class BlockLabTeleporter
extends BlockBasic {
    public BlockLabTeleporter(String name) {
        super(name, Material.field_151576_e);
    }

    public boolean func_180639_a(Level worldIn, BlockPos pos, BlockState state, Player playerIn, InteractionHand hand, Direction facing, float hitX, float hitY, float hitZ) {
        if (!playerIn.func_70093_af() && !worldIn.field_72995_K) {
            int roomRand_Z;
            int roomRand_X = worldIn.field_73012_v.nextInt(8);
            double yPlace = roomRand_X == (roomRand_Z = worldIn.field_73012_v.nextInt(8)) ? 35.0 : 26.0;
            playerIn.func_70634_a(1295.0 + (double)(160 * roomRand_X), yPlace, 1295.0 + (double)(160 * roomRand_Z));
        }
        return true;
    }
}

