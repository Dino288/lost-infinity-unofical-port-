/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.block.state.BlockState
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.util.SoundSource
 *  net.minecraft.util.math.AABB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.world.IBlockAccess
 *  net.minecraft.world.World
 */
package xol.lostinfinity.block.misc;

import javax.annotation.Nullable;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.phys.AABB;
import net.minecraft.core.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.level.Level;
import xol.lostinfinity.block.basic.BlockBasicGlass;
import xol.lostinfinity.init.PotionInit;
import xol.lostinfinity.init.SoundInit;

public class BlockLaserField
extends BlockBasicGlass {
    private int securityLevel = 0;

    public BlockLaserField(String name, int security) {
        super(name);
        this.securityLevel = security;
        this.func_149715_a(1.0f);
    }

    @Nullable
    public AABB func_180646_a(BlockState blockState, IBlockAccess worldIn, BlockPos pos) {
        return field_185506_k;
    }

    public void func_180634_a(Level worldIn, BlockPos pos, BlockState state, Entity entityIn) {
        if (!worldIn.field_72995_K) {
            LivingEntity killed;
            int security_clear;
            Player player;
            boolean kill = true;
            if (entityIn instanceof Player && (player = (Player)entityIn).func_70644_a(PotionInit.SECURITY_CLEARANCE) && (security_clear = player.func_70660_b(PotionInit.SECURITY_CLEARANCE).func_76458_c() + 1) >= this.securityLevel) {
                kill = false;
            }
            if (kill && entityIn instanceof LivingEntity && (killed = (LivingEntity)entityIn).func_110143_aJ() > 0.0f) {
                killed.func_70606_j(0.0f);
                worldIn.func_184133_a(null, pos, SoundInit.SCANNER, SoundSource.MASTER, 1.0f, 1.0f);
            }
        }
    }
}

