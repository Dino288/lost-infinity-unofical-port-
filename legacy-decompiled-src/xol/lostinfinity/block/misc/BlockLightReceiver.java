/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.world.World
 */
package xol.lostinfinity.block.misc;

import java.util.ArrayList;
import net.minecraft.world.level.block.Block;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import xol.lostinfinity.block.basic.BlockBasic;
import xol.lostinfinity.init.BlockInit;

public class BlockLightReceiver
extends BlockBasic {
    public BlockLightReceiver(String name) {
        super(name);
    }

    public void openGate(Level worldIn, BlockPos pos) {
        for (int i = -1; i <= 1; ++i) {
            for (int j = -1; j <= 1; ++j) {
                for (int k = -1; k <= 1; ++k) {
                    BlockPos check;
                    Block block;
                    if (i == 0 && j == 0 && k == 0 || !(block = worldIn.func_180495_p(check = pos.func_177982_a(i, j, k)).func_177230_c()).equals(BlockInit.galaxyGate)) continue;
                    this.propogatePass(worldIn, check, null, 1);
                }
            }
        }
    }

    public void closeGate(Level worldIn, BlockPos pos) {
        for (int i = -1; i <= 1; ++i) {
            for (int j = -1; j <= 1; ++j) {
                for (int k = -1; k <= 1; ++k) {
                    BlockPos check;
                    Block block;
                    if (i == 0 && j == 0 && k == 0 || !(block = worldIn.func_180495_p(check = pos.func_177982_a(i, j, k)).func_177230_c()).equals(BlockInit.galaxyGate)) continue;
                    this.propogatePass(worldIn, check, null, 0);
                }
            }
        }
    }

    public void propogatePass(Level worldIn, BlockPos pos, ArrayList<BlockPos> visited, int meta) {
        if (visited == null) {
            visited = new ArrayList();
        }
        if (!visited.contains(pos)) {
            visited.add(pos);
            worldIn.func_175656_a(pos, BlockInit.galaxyGate.func_176203_a(meta));
            for (int i = -1; i <= 1; ++i) {
                for (int j = -1; j <= 1; ++j) {
                    for (int k = -1; k <= 1; ++k) {
                        BlockPos check;
                        Block block;
                        if (i == 0 && j == 0 && k == 0 || !(block = worldIn.func_180495_p(check = pos.func_177982_a(i, j, k)).func_177230_c()).equals(BlockInit.galaxyGate)) continue;
                        this.propogatePass(worldIn, check, visited, meta);
                    }
                }
            }
        }
    }
}

