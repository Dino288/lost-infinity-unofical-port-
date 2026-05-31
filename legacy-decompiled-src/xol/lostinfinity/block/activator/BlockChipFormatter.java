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
import net.minecraft.world.level.Level;
import xol.lostinfinity.block.activator.BlockAlienSlide;
import xol.lostinfinity.block.basic.BlockBasic;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.util.coordinates.GalaxyCoordinates;

public class BlockChipFormatter
extends BlockBasic {
    public BlockChipFormatter(String name) {
        super(name);
        this.func_149715_a(1.0f);
    }

    public boolean func_180639_a(Level worldIn, BlockPos pos, BlockState state, Player playerIn, InteractionHand hand, Direction facing, float hitX, float hitY, float hitZ) {
        ItemStack held = playerIn.func_184586_b(hand);
        if (held.func_77973_b() == ItemInit.freshDataChip) {
            BlockPos tablePos = GalaxyCoordinates.ChipTable();
            int pieceId = 0;
            boolean allCorrect = true;
            for (int z = 0; z < 5; ++z) {
                for (int x = 0; x < 5; ++x) {
                    BlockPos addPos = tablePos.func_177982_a(x, 0, z);
                    if (worldIn.func_180495_p(addPos).func_177230_c() instanceof BlockAlienSlide) {
                        BlockAlienSlide slide = (BlockAlienSlide)worldIn.func_180495_p(addPos).func_177230_c();
                        if (slide.getBlockNum() != pieceId) {
                            allCorrect = false;
                        }
                    } else {
                        allCorrect = false;
                    }
                    ++pieceId;
                }
            }
            if (allCorrect) {
                held.func_190918_g(1);
                if (!worldIn.field_72995_K) {
                    ItemEntity cellItem = new ItemEntity(worldIn, (double)pos.func_177958_n(), (double)(pos.func_177956_o() + 2), (double)pos.func_177952_p(), new ItemStack(ItemInit.basicStorageChip));
                    cellItem.field_70159_w = 0.0;
                    cellItem.field_70181_x = 0.0;
                    cellItem.field_70179_y = 0.0;
                    worldIn.func_72838_d((Entity)cellItem);
                    worldIn.func_184133_a(null, pos.func_177984_a(), SoundInit.CHIP_FORMAT, SoundSource.BLOCKS, 2.0f, 1.0f);
                    for (int z = 0; z < 5; ++z) {
                        for (int x = 0; x < 5; ++x) {
                            BlockPos addPos = tablePos.func_177982_a(x, 0, z);
                            worldIn.func_175656_a(addPos, BlockAlienSlide.getSlideByNum(17).func_176223_P());
                        }
                    }
                }
            }
        }
        return true;
    }
}

