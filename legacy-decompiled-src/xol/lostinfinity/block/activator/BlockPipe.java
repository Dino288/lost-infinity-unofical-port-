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
 *  net.minecraft.util.math.AABB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.world.World
 */
package xol.lostinfinity.block.activator;

import java.util.Iterator;
import net.minecraft.block.material.Material;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.entity.player.Player;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.phys.AABB;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import xol.lostinfinity.block.basic.BlockBasicRotational;
import xol.lostinfinity.init.TabsInit;
import xol.lostinfinity.mob.entity.misc.EntityPipeGameMerchant;

public class BlockPipe
extends BlockBasicRotational {
    public BlockPipe(String name) {
        this(name, 60.0f, Material.field_151576_e);
    }

    public BlockPipe(String name, float hardness, Material material) {
        this(name, hardness, material, TabsInit.TAB_BLOCKS);
    }

    public BlockPipe(String name, float hardness, Material material, CreativeModeTab tab) {
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
        block0: {
            AABB checkBox;
            Iterator iterator;
            if (worldIn.field_72995_K || hand != playerIn.func_184600_cs() || !(iterator = worldIn.func_72872_a(EntityPipeGameMerchant.class, checkBox = new AABB(pos.func_177982_a(-40, -40, -40), pos.func_177982_a(40, 40, 40))).iterator()).hasNext()) break block0;
            EntityPipeGameMerchant merch = (EntityPipeGameMerchant)((Object)iterator.next());
            merch.rotate(pos);
        }
        return super.func_180639_a(worldIn, pos, state, playerIn, hand, facing, hitX, hitY, hitZ);
    }

    public BlockState getStateWithFacing(Direction facing) {
        return this.func_176223_P().func_177226_a((Property)field_185512_D, (Comparable)facing);
    }
}

