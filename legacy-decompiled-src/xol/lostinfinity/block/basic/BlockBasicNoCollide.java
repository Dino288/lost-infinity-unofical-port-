/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.block.SoundType
 *  net.minecraft.block.material.Material
 *  net.minecraft.block.state.BlockState
 *  net.minecraft.util.BlockRenderLayer
 *  net.minecraft.util.math.AABB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.world.IBlockAccess
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package xol.lostinfinity.block.basic;

import javax.annotation.Nullable;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.world.phys.AABB;
import net.minecraft.core.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xol.lostinfinity.block.basic.BlockBasic;

public class BlockBasicNoCollide
extends BlockBasic {
    public BlockBasicNoCollide(String name) {
        super(name, Material.field_151592_s);
        this.func_149672_a(SoundType.field_185853_f);
    }

    public BlockBasicNoCollide(String name, Material material) {
        super(name, material);
    }

    @SideOnly(value=Side.CLIENT)
    public BlockRenderLayer func_180664_k() {
        return BlockRenderLayer.TRANSLUCENT;
    }

    public boolean func_149686_d(BlockState state) {
        return false;
    }

    public boolean func_149662_c(BlockState state) {
        return false;
    }

    @Nullable
    public AABB func_180646_a(BlockState blockState, IBlockAccess worldIn, BlockPos pos) {
        return field_185506_k;
    }
}

