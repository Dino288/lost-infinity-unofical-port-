/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.IBlockEntityProvider
 *  net.minecraft.block.state.BlockState
 *  net.minecraft.entity.player.Player
 *  net.minecraft.tileentity.BlockEntity
 *  net.minecraft.util.Direction
 *  net.minecraft.util.InteractionHand
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.text.Component
 *  net.minecraft.util.text.Component
 *  net.minecraft.world.World
 */
package xol.lostinfinity.block.misc;

import net.minecraft.block.IBlockEntityProvider;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.Level;
import xol.lostinfinity.block.basic.BlockBasicGui;
import xol.lostinfinity.block.tileentity.BlockEntityGearbox;
import xol.lostinfinity.gui.GuiHandler;

public class BlockGearbox
extends BlockBasicGui
implements IBlockEntityProvider {
    public BlockGearbox(String name) {
        super(name, GuiHandler.RegisteredGuis.GEARBOX.getId());
    }

    public BlockEntity func_149915_a(Level worldIn, int meta) {
        return null;
    }

    public BlockEntity createBlockEntity(Level world, BlockState state) {
        return new BlockEntityGearbox();
    }

    public boolean func_149716_u() {
        return true;
    }

    @Override
    public boolean func_180639_a(Level worldIn, BlockPos pos, BlockState state, Player playerIn, InteractionHand hand, Direction facing, float hitX, float hitY, float hitZ) {
        BlockEntity te = worldIn.func_175625_s(pos);
        if (te != null && te instanceof BlockEntityGearbox && ((BlockEntityGearbox)te).getPowered()) {
            return super.func_180639_a(worldIn, pos, state, playerIn, hand, facing, hitX, hitY, hitZ);
        }
        if (!worldIn.field_72995_K) {
            playerIn.func_145747_a((Component)new Component("The gearbox must have a powered engine connected"));
        }
        return true;
    }
}

