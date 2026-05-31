/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.state.BlockState
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Vec3i
 *  net.minecraft.world.World
 */
package xol.lostinfinity.block.misc;

import java.util.Random;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Vec3i;
import net.minecraft.world.level.Level;
import xol.lostinfinity.block.basic.BlockBasic;
import xol.lostinfinity.init.BlockInit;

public class BlockUnpoweredHyperMelder
extends BlockBasic {
    public BlockUnpoweredHyperMelder(String name) {
        super(name);
        this.func_149715_a(1.0f);
        this.func_149675_a(true);
    }

    public void func_180650_b(Level worldIn, BlockPos pos, BlockState state, Random rand) {
        if (!worldIn.field_72995_K) {
            int generators = 0;
            for (int addX = -9; addX < 9; ++addX) {
                for (int addZ = -9; addZ < 9; ++addZ) {
                    BlockPos testPos = new BlockPos((Vec3i)pos.func_177982_a(addX, -1, addZ));
                    if (worldIn.func_180495_p(testPos).func_177230_c() != BlockInit.hyperGeneratorPowered) continue;
                    ++generators;
                }
            }
            if (generators >= 8) {
                worldIn.func_175656_a(pos, BlockInit.hyperMelderPowered.func_176223_P());
            }
        }
    }
}

