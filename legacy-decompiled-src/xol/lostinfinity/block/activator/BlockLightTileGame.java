/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.state.BlockState
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.item.ItemEntity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.Direction
 *  net.minecraft.util.InteractionHand
 *  net.minecraft.util.SoundSource
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Mth
 *  net.minecraft.util.math.Vec3i
 *  net.minecraft.util.text.Component
 *  net.minecraft.util.text.Component
 *  net.minecraft.world.World
 */
package xol.lostinfinity.block.activator;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundSource;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.core.Vec3i;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.Level;
import xol.lostinfinity.block.activator.BlockLightTile;
import xol.lostinfinity.block.basic.BlockBasic;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.dimension.data.LightTileMap;
import xol.lostinfinity.init.BlockInit;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.init.SoundInit;

public class BlockLightTileGame
extends BlockBasic {
    public BlockLightTileGame(String name) {
        super(name);
    }

    public boolean func_180639_a(Level worldIn, BlockPos pos, BlockState state, Player playerIn, InteractionHand hand, Direction facing, float hitX, float hitY, float hitZ) {
        boolean isCrafter = false;
        if (worldIn.func_180495_p(pos).func_177230_c() == BlockInit.highPoweredCharger) {
            isCrafter = true;
        }
        if (!playerIn.func_70093_af()) {
            int c;
            int col = 9;
            int row = 9;
            int checkoffset = isCrafter ? 2 : 1;
            boolean downX = true;
            boolean downZ = true;
            for (int i = 0; i < 4; ++i) {
                int checkX = -checkoffset + i % 2 * checkoffset * 2;
                int checkZ = -checkoffset + Mth.func_76141_d((float)(i / 2)) * checkoffset * 2;
                BlockPos checkPos = new BlockPos((Vec3i)pos.func_177982_a(checkX, 0, checkZ));
                if (!(worldIn.func_180495_p(checkPos).func_177230_c() instanceof BlockLightTile)) continue;
                if (checkX > 0) {
                    downX = false;
                }
                if (checkZ <= 0) break;
                downZ = false;
                break;
            }
            BlockPos gridStart = pos.func_177982_a(downX ? -8 - checkoffset : checkoffset, 0, downZ ? -8 - checkoffset : checkoffset);
            if (!isCrafter) {
                if (!worldIn.field_72995_K) {
                    LightTileMap lightTileMap = new LightTileMap(col, row, 10);
                    for (c = 0; c < col; ++c) {
                        for (int r = 0; r < row; ++r) {
                            if (lightTileMap.getNodeAtLocation(c, r).isLit()) {
                                worldIn.func_175656_a(gridStart.func_177982_a(c, 0, r), BlockInit.lightTileLit.func_176223_P());
                                continue;
                            }
                            worldIn.func_175656_a(gridStart.func_177982_a(c, 0, r), BlockInit.lightTileDark.func_176223_P());
                        }
                    }
                }
            } else if (playerIn.func_184586_b(hand).func_77973_b().equals(ItemInit.superchargedCell)) {
                boolean allLit = true;
                block3: for (c = 0; c < col; ++c) {
                    for (int r = 0; r < row; ++r) {
                        if (worldIn.func_180495_p(gridStart.func_177982_a(c, 0, r)).func_177230_c() != BlockInit.lightTileDark) continue;
                        allLit = false;
                        break block3;
                    }
                }
                if (allLit) {
                    if (!worldIn.field_72995_K) {
                        ItemEntity cellItem = new ItemEntity(worldIn, (double)pos.func_177958_n(), (double)(pos.func_177956_o() + 2), (double)pos.func_177952_p(), new ItemStack(ItemInit.overchargedCell));
                        cellItem.field_70159_w = 0.0;
                        cellItem.field_70181_x = 0.0;
                        cellItem.field_70179_y = 0.0;
                        worldIn.func_72838_d((Entity)cellItem);
                        worldIn.func_184133_a(null, pos.func_177984_a(), SoundInit.SPECIAL_CRAFT, SoundSource.BLOCKS, 2.0f, 1.0f);
                        for (int c2 = 0; c2 < col; ++c2) {
                            for (int r = 0; r < row; ++r) {
                                worldIn.func_175656_a(gridStart.func_177982_a(c2, 0, r), BlockInit.lightTileDark.func_176223_P());
                            }
                        }
                    }
                    playerIn.func_184586_b(hand).func_190918_g(1);
                } else if (!worldIn.field_72995_K) {
                    playerIn.func_145747_a((Component)new Component((Object)((Object)TextFmt.Red) + "Light tiles not all lit or missing."));
                }
            }
        }
        return true;
    }
}

