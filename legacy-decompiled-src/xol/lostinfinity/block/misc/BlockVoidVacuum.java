/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.block.IBlockEntityProvider
 *  net.minecraft.block.state.BlockState
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.item.ItemStack
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.tileentity.BlockEntity
 *  net.minecraft.util.Direction
 *  net.minecraft.util.InteractionHand
 *  net.minecraft.util.SoundSource
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.text.Component
 *  net.minecraft.util.text.Component
 *  net.minecraft.world.World
 */
package xol.lostinfinity.block.misc;

import java.util.UUID;
import net.minecraft.world.level.block.Block;
import net.minecraft.block.IBlockEntityProvider;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundSource;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.Level;
import xol.lostinfinity.block.basic.BlockBasic;
import xol.lostinfinity.block.tileentity.BlockEntityVoidVacuum;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.item.activate.ItemElasticThread;

public class BlockVoidVacuum
extends BlockBasic
implements IBlockEntityProvider {
    public BlockVoidVacuum(String name) {
        super(name);
    }

    public BlockEntity func_149915_a(Level worldIn, int meta) {
        return null;
    }

    public BlockEntity createBlockEntity(Level world, BlockState state) {
        return new BlockEntityVoidVacuum();
    }

    public boolean hasBlockEntity(BlockState state) {
        return true;
    }

    public boolean func_180639_a(Level worldIn, BlockPos pos, BlockState state, Player playerIn, InteractionHand hand, Direction facing, float hitX, float hitY, float hitZ) {
        if (!worldIn.field_72995_K) {
            ItemStack held = playerIn.func_184586_b(hand);
            if (!held.func_77942_o()) {
                held.func_77982_d(new CompoundTag());
            }
            if (held.func_77973_b() instanceof ItemElasticThread) {
                if (held.func_77978_p().func_186855_b("PlayerID")) {
                    LivingEntity target;
                    UUID pl_id = held.func_77978_p().func_186857_a("PlayerID");
                    if (pl_id != null && (target = (LivingEntity)worldIn.func_73046_m().func_175576_a(pl_id)) != null) {
                        Block result_block = state.func_177230_c();
                        BlockEntity tile_entity = worldIn.func_175625_s(pos);
                        if (result_block instanceof BlockVoidVacuum && tile_entity != null && tile_entity instanceof BlockEntityVoidVacuum) {
                            worldIn.func_184133_a(null, target.func_180425_c(), SoundInit.GENERIC_BOING, SoundSource.BLOCKS, 1.5f, 1.0f);
                            worldIn.func_184133_a(null, pos, SoundInit.GENERIC_BOING, SoundSource.BLOCKS, 1.5f, 1.0f);
                            BlockEntityVoidVacuum vacuum = (BlockEntityVoidVacuum)tile_entity;
                            vacuum.setTarget(target);
                            vacuum.setActive(true);
                            vacuum.resetPulled();
                            playerIn.func_184611_a(hand, ItemStack.field_190927_a);
                        }
                    }
                } else {
                    held.func_77978_p().func_74780_a("VacX", (double)pos.func_177958_n());
                    held.func_77978_p().func_74780_a("VacY", (double)pos.func_177956_o());
                    held.func_77978_p().func_74780_a("VacZ", (double)pos.func_177952_p());
                    playerIn.func_145747_a((Component)new Component((Object)((Object)TextFmt.Green) + "You have stuck one end of the thread to the vacuum."));
                }
            }
        }
        return true;
    }
}

