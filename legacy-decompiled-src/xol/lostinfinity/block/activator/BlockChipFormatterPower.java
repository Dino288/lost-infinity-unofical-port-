/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
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

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.entity.player.Player;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundSource;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import xol.lostinfinity.block.activator.BlockAlienSlide;
import xol.lostinfinity.block.basic.BlockBasic;
import xol.lostinfinity.dimension.data.SlideMap;
import xol.lostinfinity.dimension.data.SlideNode;
import xol.lostinfinity.util.coordinates.GalaxyCoordinates;

public class BlockChipFormatterPower
extends BlockBasic {
    public BlockChipFormatterPower(String name) {
        super(name);
        this.func_149715_a(1.0f);
    }

    public boolean func_180639_a(Level worldIn, BlockPos pos, BlockState state, Player playerIn, InteractionHand hand, Direction facing, float hitX, float hitY, float hitZ) {
        if (!worldIn.field_72995_K) {
            BlockPos tablePos = GalaxyCoordinates.ChipTable();
            SlideMap puzzle = new SlideMap(5, 5, 40, 17);
            for (int z = 0; z < 5; ++z) {
                for (int x = 0; x < 5; ++x) {
                    BlockPos addPos = tablePos.func_177982_a(x, 0, z);
                    SlideNode node = puzzle.getNodeAtLocation(z, x);
                    if (node.isEmpty()) {
                        worldIn.func_175656_a(addPos, BlockAlienSlide.getSlideByNum(17).func_176223_P());
                        continue;
                    }
                    worldIn.func_175656_a(addPos, BlockAlienSlide.getSlideByNum(node.getTileNum()).func_176223_P());
                }
            }
            worldIn.func_184133_a(null, pos, SoundEvents.field_187556_aj, SoundSource.MASTER, 1.0f, 1.0f);
        }
        return true;
    }
}

