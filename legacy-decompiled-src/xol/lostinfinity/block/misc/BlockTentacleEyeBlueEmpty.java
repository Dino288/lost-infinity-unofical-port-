/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.state.BlockState
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.world.World
 */
package xol.lostinfinity.block.misc;

import java.util.Random;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import xol.lostinfinity.block.basic.BlockBasicPillar;
import xol.lostinfinity.init.BlockInit;

public class BlockTentacleEyeBlueEmpty
extends BlockBasicPillar {
    public BlockTentacleEyeBlueEmpty(String name) {
        super(name);
        this.func_149675_a(true);
    }

    public void func_180650_b(Level world, BlockPos pos, BlockState state, Random rand) {
        if (!world.field_72995_K) {
            int meta = this.func_176201_c(world.func_180495_p(pos));
            world.func_175656_a(pos, BlockInit.blueTentacleEye.func_176203_a(meta));
        }
    }
}

