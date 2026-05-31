/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.material.Material
 *  net.minecraft.block.state.BlockState
 *  net.minecraft.entity.player.Player
 *  net.minecraft.init.Blocks
 *  net.minecraft.init.SoundEvents
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.Direction
 *  net.minecraft.util.InteractionHand
 *  net.minecraft.util.SoundSource
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Vec3i
 *  net.minecraft.util.text.Component
 *  net.minecraft.util.text.Component
 *  net.minecraft.world.World
 */
package xol.lostinfinity.block.activator;

import java.util.ArrayList;
import net.minecraft.block.material.Material;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundSource;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Vec3i;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.Level;
import xol.lostinfinity.block.basic.BlockBasic;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.BlockInit;
import xol.lostinfinity.init.ItemInit;

public class BlockStarforgeDeclogger
extends BlockBasic {
    public BlockStarforgeDeclogger(String name) {
        super(name, Material.field_151576_e);
    }

    public boolean func_180639_a(Level worldIn, BlockPos pos, BlockState state, Player playerIn, InteractionHand hand, Direction facing, float hitX, float hitY, float hitZ) {
        if (!playerIn.func_70093_af()) {
            int xpos = 13;
            boolean freeX = false;
            ArrayList<BlockPos> blocks = new ArrayList<BlockPos>();
            for (xpos = -6; xpos >= -9; --xpos) {
                BlockPos checkPos = new BlockPos((Vec3i)pos.func_177982_a(xpos, 9, -1));
                BlockState checkState = worldIn.func_180495_p(checkPos);
                if (!checkState.func_177230_c().equals(BlockInit.slagDeposit)) continue;
                blocks.add(checkPos);
            }
            if (!blocks.isEmpty()) {
                ItemStack resultFromHeld = playerIn.func_184586_b(hand);
                if (!resultFromHeld.func_190926_b() && resultFromHeld.func_77973_b().equals(ItemInit.carbonicAcid)) {
                    worldIn.func_184133_a(null, pos, SoundEvents.field_187633_N, SoundSource.MASTER, 2.0f, worldIn.field_73012_v.nextFloat() + 0.5f);
                    if (!worldIn.field_72995_K) {
                        for (BlockPos b : blocks) {
                            worldIn.func_175656_a(b, Blocks.field_150356_k.func_176223_P());
                        }
                    }
                    playerIn.func_184586_b(hand).func_190918_g(1);
                }
            } else if (!worldIn.field_72995_K) {
                playerIn.func_145747_a((Component)new Component((Object)((Object)TextFmt.Red) + "The forge is not clogged. There is no need to unclog it."));
            }
        }
        return true;
    }
}

