/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.entity.player.Player
 *  net.minecraft.item.Item
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.world.World
 */
package xol.lostinfinity.block.harvest;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import xol.lostinfinity.block.basic.BlockBasic;
import xol.lostinfinity.block.basic.ISpecialHarvest;
import xol.lostinfinity.init.BlockInit;
import xol.lostinfinity.init.ItemInit;

public class BlockSeparatedMatter
extends BlockBasic
implements ISpecialHarvest {
    public BlockSeparatedMatter(String name) {
        super(name);
        this.func_149711_c(2.0f);
    }

    @Override
    public Item getHarvestResult(Level world, BlockPos pos) {
        return Item.func_150898_a((Block)BlockInit.separatedMatter);
    }

    @Override
    public Item getToolNeeded() {
        return ItemInit.forgeFirePickaxe;
    }

    @Override
    public void worldHarvestEffect(Level world, BlockPos pos, Player harvester) {
        if (!world.field_72995_K) {
            world.func_175698_g(pos);
        }
    }

    @Override
    public void failedHarvest(Level world, BlockPos pos, Player harvester) {
    }

    @Override
    public boolean isHarvestable(Level world, BlockPos pos, Player harvester) {
        return true;
    }
}

