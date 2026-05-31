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
package xol.lostinfinity.block.activator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import xol.lostinfinity.block.basic.BlockBasicBoolState;
import xol.lostinfinity.block.basic.ISpecialHarvest;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.init.SoundInit;

public class BlockRadionPillar
extends BlockBasicBoolState
implements ISpecialHarvest {
    private static final boolean DEBUG = false;
    private static final int PILLAR_MAX_HEIGHT = 10;

    public BlockRadionPillar(String name) {
        super(name);
        this.func_149675_a(true);
    }

    @Override
    public Item getHarvestResult(Level world, BlockPos pos) {
        return null;
    }

    @Override
    public Item getToolNeeded() {
        return null;
    }

    @Override
    public void worldHarvestEffect(Level world, BlockPos pos, Player harvester) {
    }

    @Override
    public void failedHarvest(Level world, BlockPos pos, Player harvester) {
    }

    @Override
    public boolean isHarvestable(Level world, BlockPos pos, Player harvester) {
        return false;
    }

    public void func_180650_b(Level worldIn, BlockPos pos, BlockState state, Random rand) {
        if (!worldIn.field_72995_K) {
            this.unlightPillarSegment(worldIn, pos);
        }
    }

    public void func_180649_a(Level worldIn, BlockPos pos, Player playerIn) {
        Iterable nearBlocks = BlockPos.func_177980_a((BlockPos)pos.func_177982_a(-10, -10, -10), (BlockPos)pos.func_177982_a(10, 10, 10));
        ArrayList<BlockRadionPillar> pillarBlocks = new ArrayList<BlockRadionPillar>();
        ArrayList<BlockPos> pillarBlockPositions = new ArrayList<BlockPos>();
        int pillarCharge = 0;
        for (BlockPos nearPos : nearBlocks) {
            if (!(worldIn.func_180495_p(nearPos).func_177230_c() instanceof BlockRadionPillar) || nearPos.func_177958_n() != pos.func_177958_n() || nearPos.func_177952_p() != pos.func_177952_p()) continue;
            pillarBlocks.add((BlockRadionPillar)worldIn.func_180495_p(nearPos).func_177230_c());
            pillarBlockPositions.add(nearPos);
            if (worldIn.func_180495_p(nearPos).func_177230_c().func_176201_c(worldIn.func_180495_p(nearPos)) != 1) continue;
            ++pillarCharge;
        }
        if (pillarCharge == pillarBlocks.size()) {
            if (!worldIn.field_72995_K) {
                for (int i = 0; i < pillarBlocks.size(); ++i) {
                    ((BlockRadionPillar)pillarBlocks.get(i)).unlightPillarSegment(worldIn, (BlockPos)pillarBlockPositions.get(i));
                }
                playerIn.func_145779_a(ItemInit.radionFragment, new Random().nextInt(4) + 3);
            }
            playerIn.func_184185_a(SoundInit.ENERGY_PULSE, 1.0f, 1.0f);
        }
    }

    public void lightUpPillarSegment(Level worldIn, BlockPos pos) {
        if (!worldIn.field_72995_K) {
            Iterable nearBlocks = BlockPos.func_177980_a((BlockPos)pos.func_177982_a(-10, -10, -10), (BlockPos)pos.func_177982_a(10, 10, 10));
            ArrayList<BlockRadionPillar> pillarBlocks = new ArrayList<BlockRadionPillar>();
            ArrayList<BlockPos> pillarBlockPositions = new ArrayList<BlockPos>();
            for (BlockPos nearPos : nearBlocks) {
                if (!(worldIn.func_180495_p(nearPos).func_177230_c() instanceof BlockRadionPillar)) continue;
                BlockRadionPillar pillarBlock = (BlockRadionPillar)worldIn.func_180495_p(nearPos).func_177230_c();
                if (nearPos.func_177958_n() != pos.func_177958_n() || nearPos.func_177952_p() != pos.func_177952_p()) continue;
                pillarBlocks.add(pillarBlock);
                pillarBlockPositions.add(nearPos);
            }
            for (int i = 0; i < pillarBlocks.size(); ++i) {
                BlockPos pillarBlockPos;
                BlockRadionPillar pillarBlock = (BlockRadionPillar)pillarBlocks.get(i);
                int meta = pillarBlock.func_176201_c(worldIn.func_180495_p(pillarBlockPos = (BlockPos)pillarBlockPositions.get(i)));
                if (meta != 0) continue;
                worldIn.func_175656_a(pillarBlockPos, pillarBlock.func_176203_a(1));
                break;
            }
        }
    }

    private void unlightPillarSegment(Level worldIn, BlockPos pos) {
        if (!worldIn.field_72995_K) {
            Iterable nearBlocks = BlockPos.func_177980_a((BlockPos)pos.func_177982_a(-10, -10, -10), (BlockPos)pos.func_177982_a(10, 10, 10));
            ArrayList<BlockRadionPillar> pillarBlocks = new ArrayList<BlockRadionPillar>();
            ArrayList<BlockPos> pillarBlockPositions = new ArrayList<BlockPos>();
            for (BlockPos nearPos : nearBlocks) {
                if (!(worldIn.func_180495_p(nearPos).func_177230_c() instanceof BlockRadionPillar)) continue;
                BlockRadionPillar pillarBlock = (BlockRadionPillar)worldIn.func_180495_p(nearPos).func_177230_c();
                if (nearPos.func_177958_n() != pos.func_177958_n() || nearPos.func_177952_p() != pos.func_177952_p()) continue;
                pillarBlocks.add(pillarBlock);
                pillarBlockPositions.add(nearPos);
            }
            Collections.reverse(pillarBlocks);
            Collections.reverse(pillarBlockPositions);
            for (int i = 0; i < pillarBlocks.size(); ++i) {
                BlockPos pillarBlockPos;
                BlockRadionPillar pillarBlock = (BlockRadionPillar)pillarBlocks.get(i);
                int meta = pillarBlock.func_176201_c(worldIn.func_180495_p(pillarBlockPos = (BlockPos)pillarBlockPositions.get(i)));
                if (meta != 1) continue;
                worldIn.func_175656_a(pillarBlockPos, pillarBlock.func_176203_a(0));
                break;
            }
        }
    }
}

