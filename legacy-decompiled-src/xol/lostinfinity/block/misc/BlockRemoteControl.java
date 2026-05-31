/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.state.BlockState
 *  net.minecraft.entity.player.Player
 *  net.minecraft.item.ItemStack
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.tileentity.BlockEntity
 *  net.minecraft.util.Direction
 *  net.minecraft.util.InteractionHand
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.text.Component
 *  net.minecraft.util.text.Component
 *  net.minecraft.world.World
 */
package xol.lostinfinity.block.misc;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.Level;
import xol.lostinfinity.block.basic.BlockBasic;
import xol.lostinfinity.block.tileentity.BlockEntityRemoteControl;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.item.basics.ItemRemoteControl;

public class BlockRemoteControl
extends BlockBasic {
    public BlockRemoteControl(String name) {
        super(name);
    }

    public BlockEntity createBlockEntity(Level world, BlockState state) {
        BlockEntityRemoteControl TE = new BlockEntityRemoteControl();
        return TE;
    }

    public boolean hasBlockEntity(BlockState state) {
        return true;
    }

    public boolean func_180639_a(Level worldIn, BlockPos pos, BlockState state, Player playerIn, InteractionHand hand, Direction facing, float hitX, float hitY, float hitZ) {
        ItemRemoteControl control;
        ItemStack held;
        if (!worldIn.field_72995_K && (held = playerIn.func_184586_b(hand)).func_77973_b() instanceof ItemRemoteControl && (control = (ItemRemoteControl)held.func_77973_b()).getControlBlock() == worldIn.func_180495_p(pos).func_177230_c()) {
            BlockEntity te;
            if (!held.func_77942_o()) {
                held.func_77982_d(new CompoundTag());
            }
            if ((te = worldIn.func_175625_s(pos)) == null || !(te instanceof BlockEntityRemoteControl)) {
                playerIn.func_145747_a((Component)new Component((Object)((Object)TextFmt.Red) + "Improper Tile Entity found here. Replace block."));
            } else {
                BlockEntityRemoteControl remTe = (BlockEntityRemoteControl)te;
                if (remTe.getPlacerID() == null) {
                    remTe.setPlacer(playerIn);
                }
                if (remTe.getPlacerID().equals(playerIn.func_110124_au())) {
                    held.func_77978_p().func_74780_a("BlockStoredX", (double)pos.func_177958_n());
                    held.func_77978_p().func_74780_a("BlockStoredY", (double)pos.func_177956_o());
                    held.func_77978_p().func_74780_a("BlockStoredZ", (double)pos.func_177952_p());
                    playerIn.func_145747_a((Component)new Component((Object)((Object)TextFmt.Gold) + "Remote bound to " + pos.func_177958_n() + "," + pos.func_177956_o() + "," + pos.func_177952_p()));
                }
            }
        }
        return true;
    }
}

