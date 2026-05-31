/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.IBlockEntityProvider
 *  net.minecraft.block.properties.Property
 *  net.minecraft.block.state.BlockState
 *  net.minecraft.entity.player.Player
 *  net.minecraft.tileentity.BlockEntity
 *  net.minecraft.util.Direction
 *  net.minecraft.util.InteractionHand
 *  net.minecraft.util.SoundSource
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Vec3
 *  net.minecraft.world.World
 */
package xol.lostinfinity.block.activator;

import net.minecraft.block.IBlockEntityProvider;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundSource;
import net.minecraft.core.BlockPos;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.Level;
import xol.lostinfinity.block.basic.BlockBasicRotational;
import xol.lostinfinity.block.tileentity.BlockEntityLightEmitter;
import xol.lostinfinity.init.SoundInit;

public class BlockLightEmitter
extends BlockBasicRotational
implements IBlockEntityProvider {
    public BlockLightEmitter(String name) {
        super(name);
        this.func_149715_a(1.0f);
    }

    public BlockState getStateNextRotation(BlockState state) {
        Direction facing = (Direction)state.func_177229_b((Property)field_185512_D);
        switch (facing) {
            case NORTH: {
                return this.func_176223_P().func_177226_a((Property)field_185512_D, (Comparable)Direction.EAST);
            }
            case EAST: {
                return this.func_176223_P().func_177226_a((Property)field_185512_D, (Comparable)Direction.SOUTH);
            }
            case SOUTH: {
                return this.func_176223_P().func_177226_a((Property)field_185512_D, (Comparable)Direction.WEST);
            }
            case WEST: {
                return this.func_176223_P().func_177226_a((Property)field_185512_D, (Comparable)Direction.NORTH);
            }
        }
        return state;
    }

    public BlockState getStateWithFacing(Direction facing) {
        return this.func_176223_P().func_177226_a((Property)field_185512_D, (Comparable)facing);
    }

    public Vec3 getBeamDir(BlockState state) {
        Direction facing = (Direction)state.func_177229_b((Property)field_185512_D);
        switch (facing) {
            case NORTH: {
                return new Vec3(0.0, 0.0, -1.0);
            }
            case EAST: {
                return new Vec3(1.0, 0.0, 0.0);
            }
            case SOUTH: {
                return new Vec3(0.0, 0.0, 1.0);
            }
            case WEST: {
                return new Vec3(-1.0, 0.0, 0.0);
            }
        }
        return new Vec3(0.0, 0.0, -1.0);
    }

    public boolean func_180639_a(Level worldIn, BlockPos pos, BlockState state, Player playerIn, InteractionHand hand, Direction facing, float hitX, float hitY, float hitZ) {
        if (!worldIn.field_72995_K) {
            worldIn.func_175656_a(pos, this.getStateNextRotation(state));
            worldIn.func_184133_a(null, pos, SoundInit.GEAR_MACHINE, SoundSource.BLOCKS, 0.75f, 0.8f + 0.4f * worldIn.field_73012_v.nextFloat());
        }
        return true;
    }

    public BlockEntity createBlockEntity(Level world, BlockState state) {
        return new BlockEntityLightEmitter();
    }

    public boolean hasBlockEntity(BlockState state) {
        return true;
    }

    private BlockEntityLightEmitter getTE(Level world, BlockPos pos) {
        return (BlockEntityLightEmitter)world.func_175625_s(pos);
    }

    public BlockEntity func_149915_a(Level worldIn, int meta) {
        return null;
    }
}

