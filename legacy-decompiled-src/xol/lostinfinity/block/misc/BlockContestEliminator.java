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
import xol.lostinfinity.block.basic.BlockBasicGlass;

public class BlockContestEliminator
extends BlockBasicGlass {
    public BlockContestEliminator(String name) {
        super(name);
    }

    public void func_176199_a(Level worldIn, BlockPos pos, Entity entityIn) {
        if (!worldIn.field_72995_K) {
            entityIn.func_70634_a(entityIn.field_70165_t, entityIn.field_70163_u + 20.0, entityIn.field_70161_v);
        }
    }
}

