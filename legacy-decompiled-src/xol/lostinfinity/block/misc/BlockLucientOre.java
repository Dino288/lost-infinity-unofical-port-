/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.properties.Property
 *  net.minecraft.block.state.BlockState
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.world.World
 */
package xol.lostinfinity.block.misc;

import java.util.Random;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import xol.lostinfinity.block.basic.BlockBasicBoolState;

public class BlockLucientOre
extends BlockBasicBoolState {
    public BlockLucientOre(String name) {
        super(name);
        this.func_149675_a(true);
        this.func_180632_j(this.field_176227_L.func_177621_b().func_177226_a((Property)ACTIVE, (Comparable)Boolean.valueOf(true)));
    }

    public void func_180650_b(Level worldIn, BlockPos pos, BlockState state, Random rand) {
        int meta;
        if (!worldIn.field_72995_K && (meta = this.func_176201_c(state)) == 0) {
            worldIn.func_175656_a(pos, this.func_176203_a(1));
        }
    }
}

