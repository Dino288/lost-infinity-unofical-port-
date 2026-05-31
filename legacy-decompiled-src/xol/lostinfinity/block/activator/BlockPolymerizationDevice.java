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
import net.minecraft.world.level.Level;
import xol.lostinfinity.block.basic.BlockBasic;
import xol.lostinfinity.block.tileentity.BlockEntityPolymerizationDevice;
import xol.lostinfinity.init.ItemInit;

public class BlockPolymerizationDevice
extends BlockBasic
implements IBlockEntityProvider {
    public BlockPolymerizationDevice(String name) {
        super(name);
    }

    public boolean func_149716_u() {
        return true;
    }

    public BlockEntity createBlockEntity(Level world, BlockState state) {
        return new BlockEntityPolymerizationDevice();
    }

    public boolean func_180639_a(Level worldIn, BlockPos pos, BlockState state, Player playerIn, InteractionHand hand, Direction facing, float hitX, float hitY, float hitZ) {
        BlockEntity tileEntity = worldIn.func_175625_s(pos);
        if (tileEntity != null && tileEntity instanceof BlockEntityPolymerizationDevice) {
            BlockEntityPolymerizationDevice deviceEntity = (BlockEntityPolymerizationDevice)tileEntity;
            ItemStack stack = playerIn.func_184586_b(hand);
            if (stack.func_77973_b() == ItemInit.rainfallCollectorFull && !deviceEntity.isActivated()) {
                stack.func_190918_g(1);
            }
            if (!worldIn.field_72995_K) {
                deviceEntity.activate(playerIn, hand);
            }
        }
        return true;
    }

    public BlockEntity func_149915_a(Level worldIn, int meta) {
        return null;
    }
}

