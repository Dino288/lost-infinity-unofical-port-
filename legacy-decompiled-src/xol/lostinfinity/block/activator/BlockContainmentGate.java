/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.block.state.BlockState
 *  net.minecraft.entity.player.Player
 *  net.minecraft.item.Item
 *  net.minecraft.util.Direction
 *  net.minecraft.util.InteractionHand
 *  net.minecraft.util.SoundSource
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.text.Component
 *  net.minecraft.util.text.Component
 *  net.minecraft.world.World
 */
package xol.lostinfinity.block.activator;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundSource;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.Level;
import xol.lostinfinity.block.basic.BlockBasic;
import xol.lostinfinity.block.misc.BlockArchlumioGate;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.BlockInit;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.init.SoundInit;

public class BlockContainmentGate
extends BlockBasic {
    public BlockContainmentGate(String name) {
        super(name);
    }

    public boolean func_180639_a(Level worldIn, BlockPos pos, BlockState state, Player playerIn, InteractionHand hand, Direction facing, float hitX, float hitY, float hitZ) {
        Item heldItem;
        if (!worldIn.field_72995_K && (heldItem = playerIn.func_184614_ca().func_77973_b()).equals(ItemInit.powerOverrideDevice)) {
            worldIn.func_184133_a(null, pos, SoundInit.CONTAINMENT_PASS, SoundSource.MASTER, 1.0f, 1.0f);
            playerIn.func_145747_a((Component)new Component((Object)((Object)TextFmt.Light_Purple) + "It has been a long time since someone has entered these parts where I'm held. A very, very long time..."));
            for (int i = -1; i <= 1; ++i) {
                for (int j = -1; j <= 1; ++j) {
                    for (int k = -1; k <= 1; ++k) {
                        BlockPos check;
                        Block block;
                        if (i == 0 && j == 0 && k == 0 || !(block = worldIn.func_180495_p(check = pos.func_177982_a(i, j, k)).func_177230_c()).equals(BlockInit.archlumioGate)) continue;
                        ((BlockArchlumioGate)block).propogatePass(worldIn, check, null);
                    }
                }
            }
        }
        return true;
    }
}

