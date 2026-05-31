/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.material.Material
 *  net.minecraft.entity.player.Player
 *  net.minecraft.item.Item
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.world.World
 */
package xol.lostinfinity.block.harvest;

import net.minecraft.block.material.Material;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import xol.lostinfinity.block.basic.BlockBasicPillar;
import xol.lostinfinity.block.basic.ISpecialHarvest;
import xol.lostinfinity.init.BlockInit;
import xol.lostinfinity.init.ItemInit;

public class BlockSunderwoodSap
extends BlockBasicPillar
implements ISpecialHarvest {
    public BlockSunderwoodSap(String name) {
        super(name, Material.field_151575_d);
    }

    @Override
    public void failedHarvest(Level world, BlockPos pos, Player harvester) {
    }

    @Override
    public Item getHarvestResult(Level world, BlockPos pos) {
        return ItemInit.burningSap;
    }

    @Override
    public Item getToolNeeded() {
        return ItemInit.forgefireAxe;
    }

    @Override
    public void worldHarvestEffect(Level world, BlockPos pos, Player harvester) {
        if (!world.field_72995_K) {
            int meta = this.func_176201_c(world.func_180495_p(pos));
            world.func_175656_a(pos, BlockInit.sunderwoodSapEmpty.func_176203_a(meta));
        }
    }

    @Override
    public boolean isHarvestable(Level world, BlockPos pos, Player harvester) {
        return true;
    }
}

