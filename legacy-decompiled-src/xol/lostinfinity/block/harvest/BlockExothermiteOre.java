/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.state.BlockState
 *  net.minecraft.entity.player.Player
 *  net.minecraft.item.Item
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.world.World
 */
package xol.lostinfinity.block.harvest;

import java.util.Random;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import xol.lostinfinity.block.basic.BlockBasicBoolState;
import xol.lostinfinity.block.basic.ISpecialHarvest;
import xol.lostinfinity.init.BlockInit;
import xol.lostinfinity.init.ItemInit;

public class BlockExothermiteOre
extends BlockBasicBoolState
implements ISpecialHarvest {
    public BlockExothermiteOre(String name) {
        super(name);
        this.func_149675_a(true);
    }

    @Override
    public void failedHarvest(Level world, BlockPos pos, Player harvester) {
    }

    @Override
    public Item getHarvestResult(Level world, BlockPos pos) {
        return ItemInit.impureExothermite;
    }

    @Override
    public Item getToolNeeded() {
        return ItemInit.forgeFirePickaxe;
    }

    @Override
    public void worldHarvestEffect(Level world, BlockPos pos, Player harvester) {
        world.func_175656_a(pos, this.func_176203_a(0));
    }

    @Override
    public boolean isHarvestable(Level world, BlockPos pos, Player harvester) {
        return this.func_176201_c(world.func_180495_p(pos)) == 1;
    }

    public void func_180650_b(Level world, BlockPos pos, BlockState state, Random rand) {
        if (!world.field_72995_K) {
            if (this.func_176201_c(state) == 1) {
                if (world.func_180495_p(pos.func_177984_a()).func_177230_c() != BlockInit.concentratedAcid) {
                    world.func_175656_a(pos, this.func_176203_a(0));
                }
            } else if (world.func_180495_p(pos.func_177984_a()).func_177230_c() == BlockInit.concentratedAcid) {
                world.func_175656_a(pos, this.func_176203_a(1));
            }
        }
    }
}

