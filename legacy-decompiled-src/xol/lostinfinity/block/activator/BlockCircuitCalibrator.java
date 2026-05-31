/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
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
import xol.lostinfinity.block.tileentity.BlockEntityCircuitCalibrator;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.ItemInit;

public class BlockCircuitCalibrator
extends BlockBasic
implements IBlockEntityProvider {
    public BlockCircuitCalibrator(String name) {
        super(name);
    }

    public BlockEntity func_149915_a(Level worldIn, int meta) {
        return null;
    }

    public BlockEntity createBlockEntity(Level world, BlockState state) {
        return new BlockEntityCircuitCalibrator();
    }

    public boolean func_149716_u() {
        return true;
    }

    public boolean func_180639_a(Level worldIn, BlockPos pos, BlockState state, Player playerIn, InteractionHand hand, Direction facing, float hitX, float hitY, float hitZ) {
        BlockEntity tileEntity = worldIn.func_175625_s(pos);
        ItemStack stack = playerIn.func_184586_b(hand);
        if (tileEntity != null && tileEntity instanceof BlockEntityCircuitCalibrator && stack.func_77973_b() == ItemInit.timeTrigger) {
            BlockEntityCircuitCalibrator deviceEntity = (BlockEntityCircuitCalibrator)tileEntity;
            if (!worldIn.field_72995_K) {
                playerIn.func_145747_a((Component)new Component((Object)((Object)TextFmt.Green) + "React quickly to calibrate the circuit! Click the monitor when it is green!"));
                deviceEntity.startGame();
            }
            stack.func_190918_g(1);
        }
        return true;
    }
}

