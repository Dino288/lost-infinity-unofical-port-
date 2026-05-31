/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.state.BlockState
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.util.math.AABB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.world.World
 */
package xol.lostinfinity.block.misc;

import java.util.Random;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.AABB;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import xol.lostinfinity.block.basic.BlockBasicNoCollide;
import xol.lostinfinity.init.BlockInit;

public class BlockEmptyHoneyGel
extends BlockBasicNoCollide {
    public BlockEmptyHoneyGel(String name) {
        super(name);
        this.func_149675_a(true);
    }

    public void func_180650_b(Level world, BlockPos pos, BlockState state, Random rand) {
        if (!world.field_72995_K) {
            boolean foundEntity = false;
            for (LivingEntity any : world.func_72872_a(LivingEntity.class, new AABB(pos))) {
                foundEntity = true;
            }
            if (!foundEntity) {
                world.func_175656_a(pos, BlockInit.honeyGel.func_176223_P());
            }
        }
    }
}

