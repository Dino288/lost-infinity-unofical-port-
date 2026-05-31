/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.block.state.BlockState
 *  net.minecraft.entity.player.Player
 *  net.minecraft.init.SoundEvents
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
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
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundSource;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import xol.lostinfinity.block.basic.BlockBasic;
import xol.lostinfinity.init.BlockInit;
import xol.lostinfinity.init.ItemInit;

public class BlockNeocraft
extends BlockBasic {
    public BlockNeocraft(String name) {
        super(name);
        this.func_149715_a(1.0f);
    }

    public boolean func_180639_a(Level worldIn, BlockPos pos, BlockState state, Player playerIn, InteractionHand hand, Direction facing, float hitX, float hitY, float hitZ) {
        ItemStack held = playerIn.func_184586_b(hand);
        Block makeBlock = this.blockFromItem(held.func_77973_b());
        if (makeBlock != null && makeBlock != worldIn.func_180495_p(pos).func_177230_c()) {
            if (!worldIn.field_72995_K) {
                worldIn.func_175656_a(pos, makeBlock.func_176223_P());
                worldIn.func_184133_a(null, pos, SoundEvents.field_187620_cL, SoundSource.MASTER, 1.0f, 1.0f);
            }
            held.func_190918_g(1);
        }
        return true;
    }

    private Block blockFromItem(Item item) {
        if (item == ItemInit.cureSampleBlue) {
            return BlockInit.neocraftBlue;
        }
        if (item == ItemInit.cureSampleGreen) {
            return BlockInit.neocraftGreen;
        }
        if (item == ItemInit.cureSampleYellow) {
            return BlockInit.neocraftYellow;
        }
        if (item == ItemInit.cureSampleOrange) {
            return BlockInit.neocraftOrange;
        }
        if (item == ItemInit.cureSamplePink) {
            return BlockInit.neocraftPink;
        }
        return null;
    }
}

