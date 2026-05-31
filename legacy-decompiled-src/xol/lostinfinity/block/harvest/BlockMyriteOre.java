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
import xol.lostinfinity.block.basic.BlockBasicLight;
import xol.lostinfinity.block.basic.ISpecialHarvest;
import xol.lostinfinity.init.BlockInit;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.util.data.IMaxAttack;

public class BlockMyriteOre
extends BlockBasicLight
implements ISpecialHarvest,
IMaxAttack {
    public BlockMyriteOre(String name) {
        super(name);
        this.func_149711_c(2.0f);
        this.func_149675_a(true);
    }

    @Override
    public void failedHarvest(Level world, BlockPos pos, Player harvester) {
    }

    @Override
    public Item getHarvestResult(Level world, BlockPos pos) {
        return ItemInit.myrite;
    }

    @Override
    public Item getToolNeeded() {
        return ItemInit.crystalPickaxe;
    }

    public void func_180650_b(Level worldIn, BlockPos pos, BlockState state, Random rand) {
        if (!worldIn.field_72995_K) {
            worldIn.func_175656_a(pos, BlockInit.myriteOreDark.func_176223_P());
        }
    }

    @Override
    public void worldHarvestEffect(Level world, BlockPos pos, Player harvester) {
        if (!world.field_72995_K) {
            world.func_175656_a(pos, BlockInit.myriteOreDark.func_176223_P());
        }
    }

    @Override
    public boolean isHarvestable(Level world, BlockPos pos, Player harvester) {
        return true;
    }
}

