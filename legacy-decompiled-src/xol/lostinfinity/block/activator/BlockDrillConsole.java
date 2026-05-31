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
import xol.lostinfinity.block.tileentity.BlockEntityDrillConsole;
import xol.lostinfinity.init.ItemInit;

public class BlockDrillConsole
extends BlockBasic
implements IBlockEntityProvider {
    public BlockDrillConsole(String name) {
        super(name);
    }

    public BlockEntity func_149915_a(Level worldIn, int meta) {
        return null;
    }

    public BlockEntity createBlockEntity(Level world, BlockState state) {
        return new BlockEntityDrillConsole();
    }

    public boolean func_149716_u() {
        return true;
    }

    public boolean func_180639_a(Level worldIn, BlockPos pos, BlockState state, Player playerIn, InteractionHand hand, Direction facing, float hitX, float hitY, float hitZ) {
        BlockEntity te;
        ItemStack stack = playerIn.func_184586_b(hand);
        if (stack.func_77973_b() == ItemInit.externalCloviniteBattery && (te = worldIn.func_175625_s(pos)) != null && te instanceof BlockEntityDrillConsole) {
            ((BlockEntityDrillConsole)te).activateDrill(playerIn);
            stack.func_190918_g(1);
        }
        return true;
    }
}

