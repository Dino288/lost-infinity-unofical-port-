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
import xol.lostinfinity.block.basic.BlockBasic;
import xol.lostinfinity.init.BlockInit;

public class BlockEmberslagDeposit
extends BlockBasic {
    public BlockEmberslagDeposit(String name) {
        super(name);
        this.func_149675_a(true);
    }

    public void func_180650_b(Level worldIn, BlockPos pos, BlockState state, Random rand) {
        worldIn.func_175656_a(pos.func_177984_a(), BlockInit.emberslag.func_176223_P());
    }
}

