/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.world.World
 */
package xol.lostinfinity.block.misc;

import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import xol.lostinfinity.block.basic.BlockBasic;

public class BlockTreadmillTrack
extends BlockBasic {
    public BlockTreadmillTrack(String name) {
        super(name);
    }

    public void func_176199_a(Level worldIn, BlockPos pos, Entity entityIn) {
        if (!worldIn.field_72995_K) {
            entityIn.field_70159_w -= (double)0.04f;
            entityIn.field_70133_I = true;
        }
    }
}

