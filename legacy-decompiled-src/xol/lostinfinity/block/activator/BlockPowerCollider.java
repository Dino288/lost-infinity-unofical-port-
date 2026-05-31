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
import xol.lostinfinity.block.tileentity.BlockEntityPowerCollider;
import xol.lostinfinity.init.ItemInit;

public class BlockPowerCollider
extends BlockBasic
implements IBlockEntityProvider {
    public BlockPowerCollider(String name) {
        super(name);
    }

    private boolean validInput(ItemStack stack) {
        return stack.func_77973_b().equals(ItemInit.chargeCell);
    }

    public boolean func_180639_a(Level worldIn, BlockPos pos, BlockState state, Player playerIn, InteractionHand hand, Direction facing, float hitX, float hitY, float hitZ) {
        if (!playerIn.func_70093_af() && this.validInput(playerIn.func_184586_b(hand))) {
            if (!worldIn.field_72995_K) {
                this.reset(worldIn, pos, state);
            }
            playerIn.func_184586_b(hand).func_190918_g(1);
        }
        return true;
    }

    private void reset(Level worldIn, BlockPos pos, BlockState state) {
        BlockEntity tileEntity;
        if (worldIn.func_180495_p(pos).func_177230_c() instanceof BlockPowerCollider && (tileEntity = worldIn.func_175625_s(pos)) != null && tileEntity instanceof BlockEntityPowerCollider) {
            BlockEntityPowerCollider TE = (BlockEntityPowerCollider)tileEntity;
            TE.reset();
        }
    }

    public BlockEntity func_149915_a(Level worldIn, int meta) {
        return null;
    }

    public boolean func_149716_u() {
        return true;
    }

    public BlockEntity createBlockEntity(Level world, BlockState state) {
        return new BlockEntityPowerCollider();
    }
}

