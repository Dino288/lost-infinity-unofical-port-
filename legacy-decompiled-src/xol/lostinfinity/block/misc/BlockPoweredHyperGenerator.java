/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.state.BlockState
 *  net.minecraft.entity.Entity
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.world.World
 */
package xol.lostinfinity.block.misc;

import java.util.Random;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import xol.lostinfinity.block.basic.BlockBasic;
import xol.lostinfinity.init.BlockInit;
import xol.lostinfinity.mob.entity.misc.EntityTornIndividual;

public class BlockPoweredHyperGenerator
extends BlockBasic {
    public BlockPoweredHyperGenerator(String name) {
        super(name);
        this.func_149715_a(1.0f);
        this.func_149675_a(true);
    }

    public void func_180650_b(Level worldIn, BlockPos pos, BlockState state, Random rand) {
        if (!worldIn.field_72995_K) {
            worldIn.func_175656_a(pos, BlockInit.hyperGeneratorUnpowered.func_176223_P());
            EntityTornIndividual torn = new EntityTornIndividual(worldIn);
            torn.func_70107_b(pos.func_177958_n(), pos.func_177956_o() + 1, pos.func_177952_p());
            worldIn.func_72838_d((Entity)torn);
        }
    }
}

