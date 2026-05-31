/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.player.Player
 *  net.minecraft.item.Item
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.world.World
 */
package xol.lostinfinity.block.basic;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;

public interface ISpecialHarvest {
    public Item getHarvestResult(Level var1, BlockPos var2);

    public Item getToolNeeded();

    public void worldHarvestEffect(Level var1, BlockPos var2, Player var3);

    public void failedHarvest(Level var1, BlockPos var2, Player var3);

    public boolean isHarvestable(Level var1, BlockPos var2, Player var3);
}

