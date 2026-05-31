/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.material.Material
 *  net.minecraft.block.state.BlockState
 *  net.minecraft.entity.player.Player
 *  net.minecraft.init.SoundEvents
 *  net.minecraft.util.Direction
 *  net.minecraft.util.InteractionHand
 *  net.minecraft.util.SoundSource
 *  net.minecraft.util.math.AABB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.world.World
 */
package xol.lostinfinity.block.activator;

import net.minecraft.block.material.Material;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.entity.player.Player;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.phys.AABB;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import xol.lostinfinity.block.basic.BlockBasic;
import xol.lostinfinity.init.DimensionInit;
import xol.lostinfinity.mob.entity.contest.controller.EntityControllerBase;
import xol.lostinfinity.util.coordinates.ContestCoordinates;

public class BlockDungeonSelector
extends BlockBasic {
    public BlockDungeonSelector(String name) {
        super(name, Material.field_151576_e);
        this.func_149715_a(1.0f);
    }

    public boolean func_180639_a(Level worldIn, BlockPos pos, BlockState state, Player playerIn, InteractionHand hand, Direction facing, float hitX, float hitY, float hitZ) {
        if (!worldIn.field_72995_K) {
            AABB aabb;
            if (worldIn.field_73011_w.func_186058_p() == DimensionInit.grandmasterOutpost && (aabb = this.gameByPos(pos)) != null) {
                for (EntityControllerBase search_cont : worldIn.func_72872_a(EntityControllerBase.class, aabb)) {
                    search_cont.registerTouch(playerIn);
                }
            }
            worldIn.func_184133_a(null, pos, SoundEvents.field_187620_cL, SoundSource.MASTER, 1.0f, 1.0f);
        }
        return true;
    }

    private AABB gameByPos(BlockPos pos) {
        AABB game = null;
        if (this.posInAABB(ContestCoordinates.huntersArenaAABB(), pos)) {
            game = ContestCoordinates.huntersArenaAABB();
        } else if (this.posInAABB(ContestCoordinates.redlightArenaAABB(), pos)) {
            game = ContestCoordinates.redlightArenaAABB();
        } else if (this.posInAABB(ContestCoordinates.lightBridgeArenaAABB(), pos)) {
            game = ContestCoordinates.lightBridgeArenaAABB();
        } else if (this.posInAABB(ContestCoordinates.parkourArenaAABB(), pos)) {
            game = ContestCoordinates.parkourArenaAABB();
        }
        return game;
    }

    private boolean posInAABB(AABB aabb, BlockPos pos) {
        return (double)pos.func_177958_n() >= aabb.field_72340_a && (double)pos.func_177958_n() <= aabb.field_72336_d && (double)pos.func_177956_o() >= aabb.field_72338_b && (double)pos.func_177956_o() <= aabb.field_72337_e && (double)pos.func_177952_p() >= aabb.field_72339_c && (double)pos.func_177952_p() <= aabb.field_72334_f;
    }
}

