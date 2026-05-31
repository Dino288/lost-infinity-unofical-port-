/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.state.BlockState
 *  net.minecraft.entity.player.Player
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.Direction
 *  net.minecraft.util.InteractionHand
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.text.Component
 *  net.minecraft.util.text.Component
 *  net.minecraft.world.World
 */
package xol.lostinfinity.block.activator;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.Level;
import xol.lostinfinity.block.basic.BlockBasic;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.item.activate.ItemEncryptedPowerBlueprints;

public class BlockPowerGenerator
extends BlockBasic {
    public BlockPowerGenerator(String name) {
        super(name);
        this.func_149715_a(1.0f);
    }

    public boolean func_180639_a(Level worldIn, BlockPos pos, BlockState state, Player playerIn, InteractionHand hand, Direction facing, float hitX, float hitY, float hitZ) {
        ItemStack held;
        if (!worldIn.field_72995_K && (held = playerIn.func_184586_b(hand)).func_77973_b() == ItemInit.encryptedPowerBlueprints) {
            ItemEncryptedPowerBlueprints scroll = (ItemEncryptedPowerBlueprints)held.func_77973_b();
            if (scroll.getCompletion(held) < 3 && scroll.matchBlock(held, pos, worldIn)) {
                scroll.progress(held, playerIn);
            } else {
                playerIn.func_145747_a((Component)new Component((Object)((Object)TextFmt.Italic) + "You can not currently connect this generator, please consult the main blueprints."));
            }
        }
        return true;
    }
}

