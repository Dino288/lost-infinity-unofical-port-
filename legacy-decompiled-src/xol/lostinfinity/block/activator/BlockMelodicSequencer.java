/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.block.IBlockEntityProvider
 *  net.minecraft.block.state.BlockState
 *  net.minecraft.entity.player.Player
 *  net.minecraft.item.ItemStack
 *  net.minecraft.tileentity.BlockEntity
 *  net.minecraft.util.Direction
 *  net.minecraft.util.InteractionHand
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.text.Component
 *  net.minecraft.util.text.Component
 *  net.minecraft.world.World
 */
package xol.lostinfinity.block.activator;

import javax.annotation.Nullable;
import net.minecraft.block.IBlockEntityProvider;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.Level;
import xol.lostinfinity.block.basic.BlockBasic;
import xol.lostinfinity.block.tileentity.BlockEntityMelodicSequencer;
import xol.lostinfinity.init.ItemInit;

public class BlockMelodicSequencer
extends BlockBasic
implements IBlockEntityProvider {
    public BlockMelodicSequencer(String name) {
        super(name);
    }

    public boolean hasBlockEntity(BlockState state) {
        return true;
    }

    @Nullable
    public BlockEntity createBlockEntity(Level world, BlockState state) {
        return new BlockEntityMelodicSequencer();
    }

    public boolean func_180639_a(Level worldIn, BlockPos pos, BlockState state, Player playerIn, InteractionHand hand, Direction facing, float hitX, float hitY, float hitZ) {
        BlockEntity tileEntity = worldIn.func_175625_s(pos);
        ItemStack stack = playerIn.func_184586_b(hand);
        if (tileEntity != null && tileEntity instanceof BlockEntityMelodicSequencer && stack.func_77973_b() == ItemInit.blankOpticalDisc) {
            BlockEntityMelodicSequencer deviceEntity = (BlockEntityMelodicSequencer)tileEntity;
            if (!worldIn.field_72995_K) {
                playerIn.func_145747_a((Component)new Component("Repeat the sequences!"));
                deviceEntity.startGame();
            }
            stack.func_190918_g(1);
        }
        return true;
    }

    @Nullable
    public BlockEntity func_149915_a(Level worldIn, int meta) {
        return null;
    }
}

