/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.IBlockEntityProvider
 *  net.minecraft.block.state.BlockState
 *  net.minecraft.tileentity.BlockEntity
 *  net.minecraft.world.World
 */
package xol.lostinfinity.block.misc;

import net.minecraft.block.IBlockEntityProvider;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.Level;
import xol.lostinfinity.block.basic.BlockBasicBoolState;
import xol.lostinfinity.block.tileentity.BlockEntityPortalNexus;

public class BlockPortalNexus
extends BlockBasicBoolState
implements IBlockEntityProvider {
    public BlockPortalNexus(String name) {
        super(name);
    }

    public BlockEntity createBlockEntity(Level world, BlockState state) {
        return new BlockEntityPortalNexus();
    }

    public boolean hasBlockEntity(BlockState state) {
        return true;
    }

    public BlockEntity func_149915_a(Level worldIn, int meta) {
        return null;
    }
}

