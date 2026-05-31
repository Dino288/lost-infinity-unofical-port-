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
import xol.lostinfinity.block.basic.BlockBasic;
import xol.lostinfinity.block.basic.ISpecialHarvest;
import xol.lostinfinity.init.ItemInit;

public class BlockCelestialLogsBlue
extends BlockBasic
implements ISpecialHarvest {
    public BlockCelestialLogsBlue(String name) {
        super(name, Material.field_151575_d);
    }

    @Override
    public void failedHarvest(Level world, BlockPos pos, Player harvester) {
    }

    @Override
    public Item getHarvestResult(Level world, BlockPos pos) {
        return ItemInit.positiveMagnecronite;
    }

    @Override
    public Item getToolNeeded() {
        return ItemInit.forgefireAxe;
    }

    @Override
    public void worldHarvestEffect(Level world, BlockPos pos, Player harvester) {
    }

    @Override
    public boolean isHarvestable(Level world, BlockPos pos, Player harvester) {
        return true;
    }
}

