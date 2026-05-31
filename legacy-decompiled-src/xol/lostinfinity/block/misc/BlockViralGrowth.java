/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.block.state.BlockState
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.util.math.AABB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.world.IBlockAccess
 *  net.minecraft.world.World
 */
package xol.lostinfinity.block.misc;

import javax.annotation.Nullable;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.AABB;
import net.minecraft.core.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.level.Level;
import xol.lostinfinity.block.basic.BlockBasicGlass;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.util.damagesource.DeathMessage;

public class BlockViralGrowth
extends BlockBasicGlass {
    public BlockViralGrowth(String name) {
        super(name);
        this.func_149715_a(1.0f);
    }

    @Nullable
    public AABB func_180646_a(BlockState blockState, IBlockAccess worldIn, BlockPos pos) {
        return field_185506_k;
    }

    public void func_180634_a(Level worldIn, BlockPos pos, BlockState state, Entity entityIn) {
        Player player;
        if (!worldIn.field_72995_K && entityIn instanceof Player && !(player = (Player)entityIn).func_184812_l_() && player.field_70173_aa % 5 == 0 && player.func_110143_aJ() > 0.0f) {
            player.func_70606_j(player.func_110143_aJ() - player.func_110138_aP() / 6.0f);
            if (player.func_110143_aJ() <= 0.0f) {
                DeathMessage.broadcastDeathMessage(player.func_184102_h(), (Object)((Object)TextFmt.Red) + player.func_70005_c_() + " died to a virus.");
            }
        }
    }
}

