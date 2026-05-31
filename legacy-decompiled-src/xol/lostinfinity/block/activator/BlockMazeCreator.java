/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.block.SoundType
 *  net.minecraft.block.material.Material
 *  net.minecraft.block.state.BlockState
 *  net.minecraft.entity.player.Player
 *  net.minecraft.item.Item
 *  net.minecraft.item.BlockItem
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.Direction
 *  net.minecraft.util.InteractionHand
 *  net.minecraft.util.SoundSource
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.world.World
 */
package xol.lostinfinity.block.activator;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundSource;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import xol.lostinfinity.block.misc.BlockTrackTrigger;
import xol.lostinfinity.dimension.data.MazeMap;
import xol.lostinfinity.init.BlockInit;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.init.TabsInit;
import xol.lostinfinity.util.coordinates.CelestialCoordinates;

public class BlockMazeCreator
extends Block {
    public BlockMazeCreator(String name) {
        super(Material.field_151573_f);
        this.func_149663_c(name);
        this.setRegistryName(name);
        this.func_149711_c(3.0f);
        this.func_149647_a(TabsInit.TAB_BLOCKS);
        this.func_149672_a(SoundType.field_185851_d);
        this.func_149715_a(1.0f);
        BlockInit.BLOCKS.add(this);
        ItemInit.ITEMS.add((Item)new BlockItem((Block)this).setRegistryName(this.getRegistryName()));
    }

    public boolean func_180639_a(Level worldIn, BlockPos pos, BlockState state, Player playerIn, InteractionHand hand, Direction facing, float hitX, float hitY, float hitZ) {
        ItemStack held = playerIn.func_184586_b(hand);
        if (held.func_77973_b() == ItemInit.mazeToken) {
            if (!worldIn.field_72995_K) {
                BlockPos mazeReferencePos;
                int r;
                int c;
                BlockPos mazeStartPos = CelestialCoordinates.mazeReferencePos();
                int col = 29;
                int row = 29;
                MazeMap maze = new MazeMap(col, row);
                for (c = 0; c < col; ++c) {
                    for (r = 0; r < row; ++r) {
                        mazeReferencePos = mazeStartPos.func_177982_a(c, 0, r);
                        worldIn.func_175656_a(mazeReferencePos, BlockInit.blockTrack.func_176223_P());
                        worldIn.func_175698_g(mazeReferencePos.func_177984_a());
                    }
                }
                for (c = 0; c < col; ++c) {
                    for (r = 0; r < row; ++r) {
                        mazeReferencePos = mazeStartPos.func_177982_a(c, 0, r);
                        if (c == 0 && r == 0) {
                            worldIn.func_175656_a(mazeReferencePos.func_177984_a(), BlockInit.guideBlock.func_176223_P());
                            continue;
                        }
                        if (c == col - 1 && r == row - 1) {
                            worldIn.func_175656_a(mazeReferencePos, BlockInit.blockTrackWin.func_176223_P());
                            continue;
                        }
                        if (maze.getNodeAtLocation(c, r).getType().equals("path") && maze.getNodeAtLocation(c, r).isVisited()) {
                            worldIn.func_175656_a(mazeReferencePos, BlockInit.blockTrack.func_176223_P());
                            continue;
                        }
                        if (maze.getNodeAtLocation(c, r).getType().equals("trigger") && maze.getNodeAtLocation(c, r).isVisited()) {
                            worldIn.func_175656_a(mazeReferencePos, BlockTrackTrigger.randomTriggerBlock(worldIn.field_73012_v).func_176223_P());
                            continue;
                        }
                        worldIn.func_175656_a(mazeReferencePos.func_177984_a(), BlockInit.trackWall.func_176223_P());
                    }
                }
                worldIn.func_184133_a(null, pos, SoundInit.MAZE_BUILD, SoundSource.MASTER, 1.0f, 1.0f);
            }
            held.func_190918_g(1);
        }
        return true;
    }
}

