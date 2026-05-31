/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.block.SoundType
 *  net.minecraft.block.material.Material
 *  net.minecraft.block.state.BlockFaceShape
 *  net.minecraft.block.state.BlockState
 *  net.minecraft.creativetab.CreativeModeTab
 *  net.minecraft.item.Item
 *  net.minecraft.item.BlockItem
 *  net.minecraft.util.BlockRenderLayer
 *  net.minecraft.util.Direction
 *  net.minecraft.util.math.AABB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Vec3i
 *  net.minecraft.world.IBlockAccess
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package xol.lostinfinity.block.misc;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.core.Direction;
import net.minecraft.world.phys.AABB;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Vec3i;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xol.lostinfinity.init.BlockInit;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.init.TabsInit;

public class BlockFossilTrack
extends Block {
    protected static final AABB CARPET_AABB = new AABB(0.0, 0.0, 0.0, 1.0, 0.0625, 1.0);

    public BlockFossilTrack(String name, float hardness, Material material) {
        this(name, hardness, material, TabsInit.TAB_BLOCKS);
    }

    public BlockFossilTrack(String name, float hardness, Material material, CreativeModeTab tab) {
        super(material);
        this.func_149663_c(name);
        this.setRegistryName(name);
        this.func_149647_a(tab);
        this.func_149722_s();
        this.func_149672_a(SoundType.field_185849_b);
        BlockInit.BLOCKS.add(this);
        ItemInit.ITEMS.add((Item)new BlockItem((Block)this).setRegistryName(this.getRegistryName()));
    }

    @SideOnly(value=Side.CLIENT)
    public BlockRenderLayer func_180664_k() {
        return BlockRenderLayer.TRANSLUCENT;
    }

    public AABB func_185496_a(BlockState state, IBlockAccess source, BlockPos pos) {
        return CARPET_AABB;
    }

    public boolean func_149662_c(BlockState state) {
        return false;
    }

    public boolean func_149686_d(BlockState state) {
        return false;
    }

    @SideOnly(value=Side.CLIENT)
    public boolean func_176225_a(BlockState blockState, IBlockAccess blockAccess, BlockPos pos, Direction side) {
        return side == Direction.UP;
    }

    private Vec3i rotVec(Vec3i vec, double angle) {
        int x = (int)Math.round((double)vec.func_177958_n() * Math.cos(angle) + (double)vec.func_177952_p() * Math.sin(angle));
        int z = (int)Math.round((double)(-vec.func_177958_n()) * Math.sin(angle) + (double)vec.func_177952_p() * Math.cos(angle));
        return new Vec3i(x, vec.func_177956_o(), z);
    }

    public BlockFaceShape func_193383_a(IBlockAccess worldIn, BlockState state, BlockPos pos, Direction face) {
        return face == Direction.DOWN ? BlockFaceShape.SOLID : BlockFaceShape.UNDEFINED;
    }
}

