/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.block.state.BlockState
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.world.World
 *  net.minecraftforge.fluids.BlockFluidBase
 */
package xol.lostinfinity.block.basic;

import java.util.Random;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraftforge.fluids.BlockFluidBase;
import xol.lostinfinity.block.basic.BlockBasic;

public class BlockBasicMoistured
extends BlockBasic {
    private Block replacementBlock = null;
    private boolean requiresMoisture = false;
    private BlockFluidBase mositureLiquid = null;

    public BlockBasicMoistured(String name, boolean moisture) {
        super(name);
        this.func_149675_a(true);
        this.requiresMoisture = moisture;
    }

    public void setReplacementAndLiquid(Block replace, BlockFluidBase liquid) {
        this.replacementBlock = replace;
        this.mositureLiquid = liquid;
    }

    public void func_180650_b(Level worldIn, BlockPos pos, BlockState state, Random rand) {
        boolean hasMoisture = false;
        if (worldIn.func_180495_p(pos.func_177977_b()).func_177230_c() == this.mositureLiquid) {
            hasMoisture = true;
        } else {
            for (int x = -2; x <= 2; ++x) {
                for (int z = -2; z <= 2; ++z) {
                    if (worldIn.func_180495_p(pos.func_177982_a(x, 0, z)).func_177230_c() != this.mositureLiquid) continue;
                    hasMoisture = true;
                }
            }
        }
        if (hasMoisture && !this.requiresMoisture || !hasMoisture && this.requiresMoisture) {
            worldIn.func_175656_a(pos, this.replacementBlock.func_176223_P());
        }
    }
}

