/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.block.state.BlockState
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.util.Direction
 *  net.minecraft.util.InteractionHand
 *  net.minecraft.util.SoundSource
 *  net.minecraft.util.math.AABB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.text.Component
 *  net.minecraft.util.text.Component
 *  net.minecraft.world.IBlockAccess
 *  net.minecraft.world.World
 */
package xol.lostinfinity.block.activator;

import javax.annotation.Nullable;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.phys.AABB;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Component;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.level.Level;
import xol.lostinfinity.block.basic.BlockBasicGlass;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.SoundInit;

public class BlockBossGate
extends BlockBasicGlass {
    public BlockBossGate(String name) {
        super(name);
        this.func_149715_a(1.0f);
    }

    public boolean func_180639_a(Level worldIn, BlockPos pos, BlockState state, Player playerIn, InteractionHand hand, Direction facing, float hitX, float hitY, float hitZ) {
        if (!worldIn.field_72995_K) {
            playerIn.func_70606_j(0.5f);
            playerIn.func_145747_a((Component)new Component((Object)((Object)TextFmt.Dark_Purple) + "You'll never get through that gate " + playerIn.func_70005_c_() + ". You will have to open a portal to my prison."));
            worldIn.func_184133_a(null, pos, SoundInit.ELECTRIC_SHOCK, SoundSource.MASTER, 1.0f, 1.0f);
        }
        return true;
    }

    @Nullable
    public AABB func_180646_a(BlockState blockState, IBlockAccess worldIn, BlockPos pos) {
        return field_185506_k;
    }

    public void func_180634_a(Level worldIn, BlockPos pos, BlockState state, Entity entityIn) {
        if (!worldIn.field_72995_K && !entityIn.field_70128_L && entityIn instanceof LivingEntity) {
            worldIn.func_184133_a(null, pos, SoundInit.SCANNER, SoundSource.MASTER, 1.0f, 1.0f);
            LivingEntity living = (LivingEntity)entityIn;
            living.func_70606_j(0.0f);
        }
    }
}

