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
import xol.lostinfinity.init.ItemInit;

public class BlockPhototenzyteOre
extends BlockBasicBoolState
implements ISpecialHarvest {
    public BlockPhototenzyteOre(String name) {
        super(name);
        this.func_149675_a(true);
    }

    @Override
    public void failedHarvest(Level world, BlockPos pos, Player harvester) {
    }

    @Override
    public Item getHarvestResult(Level world, BlockPos pos) {
        return ItemInit.phototenzyte;
    }

    @Override
    public Item getToolNeeded() {
        return ItemInit.crystalPickaxe;
    }

    @Override
    public void worldHarvestEffect(Level world, BlockPos pos, Player harvester) {
    }

    @Override
    public boolean isHarvestable(Level world, BlockPos pos, Player harvester) {
        return this.func_176201_c(world.func_180495_p(pos)) == 1;
    }

    public void func_180650_b(Level world, BlockPos pos, BlockState state, Random rand) {
        if (!world.field_72995_K) {
            int range = 12;
            Iterable nearblocks = BlockPos.func_177980_a((BlockPos)pos.func_177982_a(-range, -range, -range), (BlockPos)pos.func_177982_a(range, range, range));
            for (BlockPos nearpos : nearblocks) {
                if (!(world.func_180495_p(nearpos).func_177230_c() instanceof BlockPhototenzyteOre) || !world.field_73012_v.nextBoolean()) continue;
                BlockState nearState = world.func_180495_p(nearpos);
                int meta = this.func_176201_c(nearState);
                if (meta == 0) {
                    world.func_175656_a(nearpos, this.func_176203_a(1));
                    continue;
                }
                world.func_175656_a(nearpos, this.func_176203_a(0));
            }
        }
    }
}

