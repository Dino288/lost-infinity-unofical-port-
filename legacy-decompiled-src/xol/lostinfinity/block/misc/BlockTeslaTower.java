/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.block.IBlockEntityProvider
 *  net.minecraft.tileentity.BlockEntity
 *  net.minecraft.world.World
 */
package xol.lostinfinity.block.misc;

import javax.annotation.Nullable;
import net.minecraft.block.IBlockEntityProvider;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.Level;
import xol.lostinfinity.block.basic.BlockBasicNoDrop;
import xol.lostinfinity.block.tileentity.BlockEntityTeslaTower;

public class BlockTeslaTower
extends BlockBasicNoDrop
implements IBlockEntityProvider {
    public BlockTeslaTower(String name) {
        super(name);
    }

    @Nullable
    public BlockEntity func_149915_a(Level worldIn, int meta) {
        return new BlockEntityTeslaTower();
    }
}

