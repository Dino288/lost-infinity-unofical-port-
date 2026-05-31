/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.block.SoundType
 *  net.minecraft.block.material.Material
 *  net.minecraft.block.state.BlockState
 *  net.minecraft.entity.player.Player
 *  net.minecraft.init.SoundEvents
 *  net.minecraft.item.Item
 *  net.minecraft.item.BlockItem
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
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundSource;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import xol.lostinfinity.block.misc.BlockTrackTrigger;
import xol.lostinfinity.init.BlockInit;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.init.TabsInit;
import xol.lostinfinity.util.coordinates.CelestialCoordinates;

public class BlockGuideButton
extends Block {
    public BlockGuideButton(String name) {
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
        if (!worldIn.field_72995_K) {
            BlockPos baseReference = CelestialCoordinates.mazeReferencePos();
            BlockPos guidePos = null;
            worldIn.func_184133_a(null, pos, SoundEvents.field_187556_aj, SoundSource.MASTER, 1.0f, 1.0f);
            block6: for (int x = 0; x <= 29; ++x) {
                for (int z = 0; z <= 29; ++z) {
                    if (worldIn.func_180495_p(baseReference.func_177982_a(x, 1, z)).func_177230_c() != BlockInit.guideBlock) continue;
                    guidePos = baseReference.func_177982_a(x, 1, z);
                    break block6;
                }
            }
            if (guidePos != null) {
                int side = 0;
                side = worldIn.func_180495_p(pos.func_177977_b()).func_177230_c() == BlockInit.arenaBrickBlack ? 0 : (worldIn.func_180495_p(pos.func_177982_a(1, 0, 0)).func_177230_c() == BlockInit.arenaBrickBlack ? 1 : (worldIn.func_180495_p(pos.func_177984_a()).func_177230_c() == BlockInit.arenaBrickBlack ? 2 : 3));
                switch (side) {
                    case 0: {
                        int track = this.trackStyle(worldIn.func_180495_p(guidePos.func_177982_a(0, -1, 1)).func_177230_c());
                        if (!worldIn.func_175623_d(guidePos.func_177982_a(0, 0, 1)) || track <= 0) break;
                        if (track == 2) {
                            BlockTrackTrigger trigger = (BlockTrackTrigger)worldIn.func_180495_p(guidePos.func_177982_a(0, -1, 1)).func_177230_c();
                            trigger.trigger(worldIn, guidePos.func_177982_a(0, -1, 1));
                        }
                        if (track != 3) {
                            worldIn.func_175656_a(guidePos.func_177982_a(0, -1, 1), BlockInit.blockTrackUsed.func_176223_P());
                        }
                        worldIn.func_175656_a(guidePos.func_177982_a(0, 0, 1), BlockInit.guideBlock.func_176223_P());
                        worldIn.func_175698_g(guidePos);
                        worldIn.func_184133_a(null, pos, SoundInit.GEAR_MACHINE, SoundSource.MASTER, 0.75f, 1.0f);
                        break;
                    }
                    case 1: {
                        int track = this.trackStyle(worldIn.func_180495_p(guidePos.func_177982_a(-1, -1, 0)).func_177230_c());
                        if (!worldIn.func_175623_d(guidePos.func_177982_a(-1, 0, 0)) || track <= 0) break;
                        if (track == 2) {
                            BlockTrackTrigger trigger = (BlockTrackTrigger)worldIn.func_180495_p(guidePos.func_177982_a(-1, 0, 0)).func_177230_c();
                            trigger.trigger(worldIn, guidePos.func_177982_a(-1, 0, 0));
                        }
                        if (track != 3) {
                            worldIn.func_175656_a(guidePos.func_177982_a(-1, -1, 0), BlockInit.blockTrackUsed.func_176223_P());
                        }
                        worldIn.func_175656_a(guidePos.func_177982_a(-1, 0, 0), BlockInit.guideBlock.func_176223_P());
                        worldIn.func_175698_g(guidePos);
                        worldIn.func_184133_a(null, pos, SoundInit.GEAR_MACHINE, SoundSource.MASTER, 0.75f, 1.0f);
                        break;
                    }
                    case 2: {
                        int track = this.trackStyle(worldIn.func_180495_p(guidePos.func_177982_a(0, -1, -1)).func_177230_c());
                        if (!worldIn.func_175623_d(guidePos.func_177982_a(0, 0, -1)) || track <= 0) break;
                        if (track == 2) {
                            BlockTrackTrigger trigger = (BlockTrackTrigger)worldIn.func_180495_p(guidePos.func_177982_a(0, -1, -1)).func_177230_c();
                            trigger.trigger(worldIn, guidePos.func_177982_a(0, -1, -1));
                        }
                        if (track != 3) {
                            worldIn.func_175656_a(guidePos.func_177982_a(0, -1, -1), BlockInit.blockTrackUsed.func_176223_P());
                        }
                        worldIn.func_175656_a(guidePos.func_177982_a(0, 0, -1), BlockInit.guideBlock.func_176223_P());
                        worldIn.func_175698_g(guidePos);
                        worldIn.func_184133_a(null, pos, SoundInit.GEAR_MACHINE, SoundSource.MASTER, 0.75f, 1.0f);
                        break;
                    }
                    case 3: {
                        int track = this.trackStyle(worldIn.func_180495_p(guidePos.func_177982_a(1, -1, 0)).func_177230_c());
                        if (!worldIn.func_175623_d(guidePos.func_177982_a(1, 0, 0)) || track <= 0) break;
                        if (track == 2) {
                            BlockTrackTrigger trigger = (BlockTrackTrigger)worldIn.func_180495_p(guidePos.func_177982_a(1, -1, 0)).func_177230_c();
                            trigger.trigger(worldIn, guidePos.func_177982_a(1, -1, 0));
                        }
                        if (track != 3) {
                            worldIn.func_175656_a(guidePos.func_177982_a(1, -1, 0), BlockInit.blockTrackUsed.func_176223_P());
                        }
                        worldIn.func_175656_a(guidePos.func_177982_a(1, 0, 0), BlockInit.guideBlock.func_176223_P());
                        worldIn.func_175698_g(guidePos);
                        worldIn.func_184133_a(null, pos, SoundInit.GEAR_MACHINE, SoundSource.MASTER, 0.75f, 1.0f);
                    }
                }
            }
        }
        return true;
    }

    private int trackStyle(Block block) {
        if (block instanceof BlockTrackTrigger) {
            return 2;
        }
        if (block == BlockInit.blockTrack) {
            return 1;
        }
        if (block == BlockInit.blockTrackWin) {
            return 3;
        }
        return 0;
    }
}

