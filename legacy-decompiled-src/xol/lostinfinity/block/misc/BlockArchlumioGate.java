/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.block.Block
 *  net.minecraft.block.state.BlockState
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.util.SoundSource
 *  net.minecraft.util.math.AABB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.world.IBlockAccess
 *  net.minecraft.world.World
 */
package xol.lostinfinity.block.misc;

import java.util.ArrayList;
import javax.annotation.Nullable;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.phys.AABB;
import net.minecraft.core.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.level.Level;
import xol.lostinfinity.block.basic.BlockBasicGlass;
import xol.lostinfinity.init.BlockInit;
import xol.lostinfinity.init.SoundInit;

public class BlockArchlumioGate
extends BlockBasicGlass {
    public BlockArchlumioGate(String name) {
        super(name);
        this.func_149715_a(1.0f);
    }

    @Nullable
    public AABB func_180646_a(BlockState blockState, IBlockAccess worldIn, BlockPos pos) {
        return field_185506_k;
    }

    public void func_180634_a(Level worldIn, BlockPos pos, BlockState state, Entity entityIn) {
        LivingEntity killed;
        if (!worldIn.field_72995_K && entityIn instanceof LivingEntity && (killed = (LivingEntity)entityIn).func_110143_aJ() > 0.0f) {
            killed.func_70606_j(0.0f);
            worldIn.func_184133_a(null, pos, SoundInit.SCANNER, SoundSource.MASTER, 1.0f, 1.0f);
        }
    }

    public void propogatePass(Level worldIn, BlockPos pos, ArrayList<BlockPos> visited) {
        if (visited == null) {
            visited = new ArrayList();
        }
        if (!visited.contains(pos)) {
            visited.add(pos);
            worldIn.func_175656_a(pos, BlockInit.archlumioGatePass.func_176223_P());
            for (int i = -1; i <= 1; ++i) {
                for (int j = -1; j <= 1; ++j) {
                    for (int k = -1; k <= 1; ++k) {
                        BlockPos check;
                        Block block;
                        if (i == 0 && j == 0 && k == 0 || !(block = worldIn.func_180495_p(check = pos.func_177982_a(i, j, k)).func_177230_c()).equals(BlockInit.archlumioGate)) continue;
                        ((BlockArchlumioGate)block).propogatePass(worldIn, check, visited);
                    }
                }
            }
        }
    }
}

