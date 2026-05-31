/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.block.SoundType
 *  net.minecraft.block.material.Material
 *  net.minecraft.block.state.BlockState
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.monster.Monster
 *  net.minecraft.entity.player.Player
 *  net.minecraft.init.Blocks
 *  net.minecraft.item.Item
 *  net.minecraft.item.BlockItem
 *  net.minecraft.util.Direction
 *  net.minecraft.util.InteractionHand
 *  net.minecraft.util.math.AABB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.text.Component
 *  net.minecraft.util.text.Component
 *  net.minecraft.world.World
 */
package xol.lostinfinity.block.activator;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.phys.AABB;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.Level;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.BlockInit;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.init.TabsInit;
import xol.lostinfinity.mob.entity.galaxy.EntityGalaxySpire;
import xol.lostinfinity.util.coordinates.GalaxyCoordinates;

public class BlockGalaxyRewardSelector
extends Block {
    public BlockGalaxyRewardSelector(String name, float hardness) {
        this(name, hardness, 1.0f);
    }

    public BlockGalaxyRewardSelector(String name, float hardness, float lilev) {
        super(Material.field_151576_e);
        this.func_149663_c(name);
        this.setRegistryName(name);
        this.func_149711_c(hardness);
        this.func_149647_a(TabsInit.TAB_BLOCKS);
        this.func_149672_a(SoundType.field_185851_d);
        this.func_149715_a(lilev);
        BlockInit.BLOCKS.add(this);
        ItemInit.ITEMS.add((Item)new BlockItem((Block)this).setRegistryName(this.getRegistryName()));
    }

    public boolean func_180639_a(Level worldIn, BlockPos pos, BlockState state, Player playerIn, InteractionHand hand, Direction facing, float hitX, float hitY, float hitZ) {
        if (!worldIn.field_72995_K) {
            Block below = worldIn.func_180495_p(pos.func_177977_b()).func_177230_c();
            int game_style = -1;
            AABB arena_aabb = null;
            double spireHeight = 8.0;
            if (below.equals(BlockInit.astroRockBlue)) {
                game_style = 1;
                arena_aabb = GalaxyCoordinates.getBlueAABB();
            } else if (below.equals(BlockInit.astroRockGreen)) {
                game_style = 2;
                arena_aabb = GalaxyCoordinates.getGreenAABB();
            } else if (below.equals(BlockInit.astroRockPurple)) {
                game_style = 3;
                arena_aabb = GalaxyCoordinates.getPinkAABB();
            } else if (below.equals(BlockInit.astroRockYellow)) {
                game_style = 4;
                arena_aabb = GalaxyCoordinates.getYellowAABB();
            } else if (below.equals(BlockInit.astroRockLampBlue)) {
                game_style = 5;
                arena_aabb = GalaxyCoordinates.getSwordAABB();
                spireHeight = 15.0;
            } else if (below.equals(BlockInit.astroRockLampGreen)) {
                game_style = 6;
                arena_aabb = GalaxyCoordinates.getBombAABB();
                spireHeight = 15.0;
            } else if (below.equals(BlockInit.astroRockLampPurple)) {
                game_style = 7;
                arena_aabb = GalaxyCoordinates.getKnifeAABB();
                spireHeight = 15.0;
            }
            if (game_style > 0) {
                BlockPos spirePos = new BlockPos((arena_aabb.field_72336_d + arena_aabb.field_72340_a) / 2.0, arena_aabb.field_72338_b + spireHeight, (arena_aabb.field_72334_f + arena_aabb.field_72339_c) / 2.0);
                BlockPos gameStart = new BlockPos(arena_aabb.field_72340_a + 2.0, arena_aabb.field_72338_b + 6.0, arena_aabb.field_72339_c + 15.0);
                int playCount = 0;
                for (Player plays : worldIn.func_72872_a(Player.class, arena_aabb)) {
                    ++playCount;
                }
                if (playCount == 0) {
                    for (Monster leftover : worldIn.func_72872_a(Monster.class, arena_aabb)) {
                        leftover.func_70106_y();
                    }
                    this.replaceFloor(worldIn, arena_aabb, Blocks.field_150350_a, this.getMyBarrier(game_style), game_style >= 5 ? 64 : 32);
                    playerIn.func_70634_a((double)gameStart.func_177958_n(), (double)gameStart.func_177956_o(), (double)gameStart.func_177952_p());
                    EntityGalaxySpire spire = new EntityGalaxySpire(worldIn);
                    spire.func_70107_b(spirePos.func_177958_n(), spirePos.func_177956_o(), spirePos.func_177952_p());
                    spire.setItemDrop(this.lightToItem());
                    spire.setGameStyle(game_style);
                    if (game_style >= 5) {
                        spire.setElite();
                    }
                    worldIn.func_72838_d((Entity)spire);
                } else {
                    playerIn.func_145747_a((Component)new Component((Object)((Object)TextFmt.Dark_Red) + "The arena is currently in use."));
                }
            }
        }
        return true;
    }

    private void replaceFloor(Level world, AABB box, Block repblock, Block newblock, int size) {
        for (int blx = 0; blx < size; ++blx) {
            for (int blz = 0; blz < size; ++blz) {
                BlockPos pos = new BlockPos(box.field_72340_a + (double)blx, box.field_72338_b, box.field_72339_c + (double)blz);
                if (!world.func_180495_p(pos).func_177230_c().equals(repblock)) continue;
                world.func_175656_a(pos, newblock.func_176223_P());
            }
        }
    }

    private int lightToItem() {
        switch (this.field_149784_t) {
            case 12: {
                return 1;
            }
            case 9: {
                return 2;
            }
            case 6: {
                return 3;
            }
        }
        return 0;
    }

    private Block getMyBarrier(int style) {
        Block bl = BlockInit.astroBarrierBlue;
        switch (style) {
            case 2: {
                bl = BlockInit.astroBarrierGreen;
                break;
            }
            case 3: {
                bl = BlockInit.astroBarrierPurple;
                break;
            }
            case 4: {
                bl = BlockInit.astroBarrierYellow;
                break;
            }
            case 6: {
                bl = BlockInit.astroBarrierGreen;
                break;
            }
            case 7: {
                bl = BlockInit.astroBarrierPurple;
            }
        }
        return bl;
    }
}

