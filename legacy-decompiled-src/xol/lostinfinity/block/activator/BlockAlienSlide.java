/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.block.state.BlockState
 *  net.minecraft.entity.player.Player
 *  net.minecraft.init.SoundEvents
 *  net.minecraft.util.Direction
 *  net.minecraft.util.InteractionHand
 *  net.minecraft.util.SoundSource
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.world.World
 */
package xol.lostinfinity.block.activator;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.entity.player.Player;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundSource;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import xol.lostinfinity.block.basic.BlockBasic;
import xol.lostinfinity.init.BlockInit;

public class BlockAlienSlide
extends BlockBasic {
    private int slideNum = 0;

    public BlockAlienSlide(String name) {
        super(name);
        this.slideNum = Integer.parseInt(name.replace("slide_puzzle_alien_", ""));
        this.func_149715_a(1.0f);
    }

    public boolean func_180639_a(Level worldIn, BlockPos pos, BlockState state, Player playerIn, InteractionHand hand, Direction facing, float hitX, float hitY, float hitZ) {
        if (!worldIn.field_72995_K) {
            if (this.slideNum != 17) {
                BlockPos[] adjBlocks;
                for (BlockPos side : adjBlocks = new BlockPos[]{pos.func_177978_c(), pos.func_177974_f(), pos.func_177968_d(), pos.func_177976_e()}) {
                    BlockAlienSlide nextBlock;
                    if (!(worldIn.func_180495_p(side).func_177230_c() instanceof BlockAlienSlide) || (nextBlock = (BlockAlienSlide)worldIn.func_180495_p(side).func_177230_c()).getBlockNum() != 17) continue;
                    worldIn.func_175656_a(side, this.func_176223_P());
                    worldIn.func_175656_a(pos, BlockInit.alienSlide17.func_176223_P());
                    break;
                }
            }
            worldIn.func_184133_a(null, pos, SoundEvents.field_187750_dc, SoundSource.MASTER, 1.0f, 1.0f);
        }
        return true;
    }

    public int getBlockNum() {
        return this.slideNum;
    }

    public static Block getSlideByNum(int num) {
        switch (num) {
            case 0: {
                return BlockInit.alienSlide0;
            }
            case 1: {
                return BlockInit.alienSlide1;
            }
            case 2: {
                return BlockInit.alienSlide2;
            }
            case 3: {
                return BlockInit.alienSlide3;
            }
            case 4: {
                return BlockInit.alienSlide4;
            }
            case 5: {
                return BlockInit.alienSlide5;
            }
            case 6: {
                return BlockInit.alienSlide6;
            }
            case 7: {
                return BlockInit.alienSlide7;
            }
            case 8: {
                return BlockInit.alienSlide8;
            }
            case 9: {
                return BlockInit.alienSlide9;
            }
            case 10: {
                return BlockInit.alienSlide10;
            }
            case 11: {
                return BlockInit.alienSlide11;
            }
            case 12: {
                return BlockInit.alienSlide12;
            }
            case 13: {
                return BlockInit.alienSlide13;
            }
            case 14: {
                return BlockInit.alienSlide14;
            }
            case 15: {
                return BlockInit.alienSlide15;
            }
            case 16: {
                return BlockInit.alienSlide16;
            }
            case 17: {
                return BlockInit.alienSlide17;
            }
            case 18: {
                return BlockInit.alienSlide18;
            }
            case 19: {
                return BlockInit.alienSlide19;
            }
            case 20: {
                return BlockInit.alienSlide20;
            }
            case 21: {
                return BlockInit.alienSlide21;
            }
            case 22: {
                return BlockInit.alienSlide22;
            }
            case 23: {
                return BlockInit.alienSlide23;
            }
            case 24: {
                return BlockInit.alienSlide24;
            }
        }
        return BlockInit.alienSlide17;
    }
}

