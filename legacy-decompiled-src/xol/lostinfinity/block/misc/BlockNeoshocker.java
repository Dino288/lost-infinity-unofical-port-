/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.block.properties.Property
 *  net.minecraft.block.properties.IntegerProperty
 *  net.minecraft.block.state.StateDefinition
 *  net.minecraft.block.state.BlockState
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.util.Direction
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.world.World
 */
package xol.lostinfinity.block.misc;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import xol.lostinfinity.block.basic.BlockBasic;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.util.damagesource.DeathMessage;

public class BlockNeoshocker
extends BlockBasic {
    public static final IntegerProperty AMOUNT = IntegerProperty.func_177719_a((String)"amount", (int)0, (int)2);

    public BlockNeoshocker(String name) {
        super(name);
    }

    public BlockState func_180642_a(Level worldIn, BlockPos pos, Direction facing, float hitX, float hitY, float hitZ, int meta, LivingEntity placer) {
        return this.func_176223_P().func_177226_a((Property)AMOUNT, (Comparable)Integer.valueOf(0));
    }

    public BlockState func_176203_a(int meta) {
        return this.func_176223_P().func_177226_a((Property)AMOUNT, (Comparable)Integer.valueOf(meta));
    }

    public int func_176201_c(BlockState state) {
        return (Integer)state.func_177229_b((Property)AMOUNT);
    }

    protected StateDefinition func_180661_e() {
        return new StateDefinition((Block)this, new Property[]{AMOUNT});
    }

    public BlockState getStateWithAmount(int amount) {
        return this.func_176223_P().func_177226_a((Property)AMOUNT, (Comparable)Integer.valueOf(amount));
    }

    public void func_176199_a(Level worldIn, BlockPos pos, Entity entityIn) {
        super.func_176199_a(worldIn, pos, entityIn);
        if (!worldIn.field_72995_K && entityIn instanceof Player) {
            Player player = (Player)entityIn;
            int shockValue = this.func_176201_c(worldIn.func_180495_p(pos));
            if (shockValue == 2 && !player.func_184812_l_() && player.field_70173_aa % 3 == 0 && player.func_110143_aJ() > 0.0f) {
                player.func_70606_j(player.func_110143_aJ() - player.func_110138_aP() / 4.0f);
                if (player.func_110143_aJ() <= 0.0f) {
                    DeathMessage.broadcastDeathMessage(player.func_184102_h(), (Object)((Object)TextFmt.Red) + player.func_70005_c_() + " was electrocuted.");
                }
            }
        }
    }
}

