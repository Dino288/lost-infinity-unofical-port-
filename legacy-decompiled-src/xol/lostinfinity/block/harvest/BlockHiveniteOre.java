/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.player.Player
 *  net.minecraft.item.Item
 *  net.minecraft.util.math.AABB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.world.World
 */
package xol.lostinfinity.block.harvest;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.phys.AABB;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import xol.lostinfinity.block.basic.BlockBasicLight;
import xol.lostinfinity.block.basic.ISpecialHarvest;
import xol.lostinfinity.init.BlockInit;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.mob.entity.starforge.EntityFlutterbee;

public class BlockHiveniteOre
extends BlockBasicLight
implements ISpecialHarvest {
    public BlockHiveniteOre(String name) {
        super(name);
        this.func_149711_c(2.0f);
    }

    @Override
    public void failedHarvest(Level world, BlockPos pos, Player harvester) {
    }

    @Override
    public Item getHarvestResult(Level world, BlockPos pos) {
        return ItemInit.hivenite;
    }

    @Override
    public Item getToolNeeded() {
        return ItemInit.crystalPickaxe;
    }

    @Override
    public void worldHarvestEffect(Level world, BlockPos pos, Player harvester) {
        if (!world.field_72995_K) {
            world.func_175656_a(pos, BlockInit.hiveniteEmpty.func_176223_P());
            for (EntityFlutterbee bee : world.func_72872_a(EntityFlutterbee.class, new AABB(pos.func_177982_a(-15, -15, -15), pos.func_177982_a(15, 15, 15)))) {
                bee.shootMiner(harvester.func_180425_c().func_177984_a());
            }
        }
    }

    @Override
    public boolean isHarvestable(Level world, BlockPos pos, Player harvester) {
        return true;
    }
}

