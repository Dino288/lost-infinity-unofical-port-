/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.material.Material
 *  net.minecraft.block.properties.Property
 *  net.minecraft.block.state.BlockState
 *  net.minecraft.creativetab.CreativeModeTab
 *  net.minecraft.entity.player.Player
 *  net.minecraft.util.Direction
 *  net.minecraft.util.InteractionHand
 *  net.minecraft.util.SoundSource
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Vec3
 *  net.minecraft.world.World
 */
package xol.lostinfinity.block.activator;

import java.util.ArrayList;
import net.minecraft.block.material.Material;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.entity.player.Player;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundSource;
import net.minecraft.core.BlockPos;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.Level;
import xol.lostinfinity.block.basic.BlockBasicRotational;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.init.TabsInit;

public class BlockLightReflector
extends BlockBasicRotational {
    public BlockLightReflector(String name) {
        this(name, 60.0f, Material.field_151576_e);
        this.func_149715_a(0.7f);
    }

    public BlockLightReflector(String name, float hardness, Material material) {
        this(name, hardness, material, TabsInit.TAB_BLOCKS);
    }

    public BlockLightReflector(String name, float hardness, Material material, CreativeModeTab tab) {
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
            worldIn.func_184133_a(null, pos, SoundInit.GEAR_MACHINE, SoundSource.BLOCKS, 0.75f, 0.8f + 0.4f * worldIn.field_73012_v.nextFloat());
        }
        return true;
    }

    public BlockState getStateWithFacing(Direction facing) {
        return this.func_176223_P().func_177226_a((Property)field_185512_D, (Comparable)facing);
    }

    public ArrayList<Vec3> getBeamDirs(BlockState state) {
        Direction facing = (Direction)state.func_177229_b((Property)field_185512_D);
        ArrayList<Vec3> beamDirs = new ArrayList<Vec3>();
        switch (facing) {
            case NORTH: {
                beamDirs.add(new Vec3(0.0, 0.0, -1.0));
                beamDirs.add(new Vec3(1.0, 0.0, 0.0));
                break;
            }
            case EAST: {
                beamDirs.add(new Vec3(1.0, 0.0, 0.0));
                beamDirs.add(new Vec3(0.0, 0.0, 1.0));
                break;
            }
            case SOUTH: {
                beamDirs.add(new Vec3(0.0, 0.0, 1.0));
                beamDirs.add(new Vec3(-1.0, 0.0, 0.0));
                break;
            }
            case WEST: {
                beamDirs.add(new Vec3(-1.0, 0.0, 0.0));
                beamDirs.add(new Vec3(0.0, 0.0, -1.0));
                break;
            }
            default: {
                beamDirs.add(new Vec3(0.0, 0.0, -1.0));
                beamDirs.add(new Vec3(1.0, 0.0, 0.0));
            }
        }
        return beamDirs;
    }
}

