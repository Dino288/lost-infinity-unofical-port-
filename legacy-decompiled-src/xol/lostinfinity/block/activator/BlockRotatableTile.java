/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.block.material.Material
 *  net.minecraft.block.properties.Property
 *  net.minecraft.block.state.BlockState
 *  net.minecraft.creativetab.CreativeModeTab
 *  net.minecraft.entity.player.Player
 *  net.minecraft.util.Direction
 *  net.minecraft.util.InteractionHand
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Vec3i
 *  net.minecraft.world.World
 */
package xol.lostinfinity.block.activator;

import java.util.ArrayList;
import net.minecraft.world.level.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.entity.player.Player;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Vec3i;
import net.minecraft.world.level.Level;
import xol.lostinfinity.block.basic.BlockBasicRotational;
import xol.lostinfinity.init.TabsInit;

public class BlockRotatableTile
extends BlockBasicRotational {
    public BlockRotatableTile(String name) {
        this(name, 60.0f, Material.field_151576_e);
    }

    public BlockRotatableTile(String name, float hardness, Material material) {
        this(name, hardness, material, TabsInit.TAB_BLOCKS);
    }

    public BlockRotatableTile(String name, float hardness, Material material, CreativeModeTab tab) {
        super(name, hardness, material, tab);
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

    public boolean func_180639_a(Level worldIn, BlockPos pos, BlockState state, Player playerIn, InteractionHand hand, Direction facing, float hitX, float hitY, float hitZ) {
        if (!worldIn.field_72995_K) {
            worldIn.func_175656_a(pos, this.getStateNextRotation(state));
            ArrayList<Vec3i> neighbours = new ArrayList<Vec3i>();
            neighbours.add(new Vec3i(1, 0, 0));
            neighbours.add(new Vec3i(-1, 0, 0));
            neighbours.add(new Vec3i(0, 0, 1));
            neighbours.add(new Vec3i(0, 0, -1));
            for (Vec3i neighbour : neighbours) {
                BlockState neighbourState = worldIn.func_180495_p(pos.func_177971_a(neighbour));
                Block block = neighbourState.func_177230_c();
                if (!(block instanceof BlockRotatableTile)) continue;
                worldIn.func_175656_a(pos.func_177971_a(neighbour), this.getStateNextRotation(neighbourState));
            }
        }
        return true;
    }

    public BlockState getStateWithFacing(Direction facing) {
        return this.func_176223_P().func_177226_a((Property)field_185512_D, (Comparable)facing);
    }
}

