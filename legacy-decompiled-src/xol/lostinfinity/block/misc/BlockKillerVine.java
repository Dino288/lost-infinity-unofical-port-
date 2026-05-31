/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.IBlockEntityProvider
 *  net.minecraft.block.state.BlockState
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.item.ItemStack
 *  net.minecraft.tileentity.BlockEntity
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.world.World
 */
package xol.lostinfinity.block.misc;

import net.minecraft.block.IBlockEntityProvider;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import xol.lostinfinity.block.basic.BlockBasicCrop;
import xol.lostinfinity.block.tileentity.BlockEntityKillerVine;

public class BlockKillerVine
extends BlockBasicCrop
implements IBlockEntityProvider {
    public BlockKillerVine(String name) {
        super(name);
    }

    public BlockEntity func_149915_a(Level worldIn, int meta) {
        return null;
    }

    public BlockEntity createBlockEntity(Level world, BlockState state) {
        return new BlockEntityKillerVine();
    }

    public boolean func_149716_u() {
        return true;
    }

    public void func_180633_a(Level worldIn, BlockPos pos, BlockState state, LivingEntity placer, ItemStack stack) {
        BlockEntity tileentity;
        if (!worldIn.field_72995_K && this.field_149758_A && (tileentity = worldIn.func_175625_s(pos)) instanceof BlockEntityKillerVine) {
            BlockEntityKillerVine vineentity = (BlockEntityKillerVine)tileentity;
            if (placer instanceof Player) {
                vineentity.setPlacer((Player)placer);
            }
        }
        super.func_180633_a(worldIn, pos, state, placer, stack);
    }
}

