/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.properties.Property
 *  net.minecraft.block.state.BlockState
 *  net.minecraft.entity.player.Player
 *  net.minecraft.util.Direction
 *  net.minecraft.util.InteractionHand
 *  net.minecraft.util.EnumParticleTypes
 *  net.minecraft.util.math.AABB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.world.World
 *  net.minecraft.world.ServerLevel
 */
package xol.lostinfinity.block.activator;

import java.util.Random;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.entity.player.Player;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.phys.AABB;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.server.level.ServerLevel;
import xol.lostinfinity.block.basic.BlockBasicBoolState;
import xol.lostinfinity.mob.entity.misc.EntityRhythmGameMerchant;

public class BlockRhythmButton
extends BlockBasicBoolState {
    public BlockRhythmButton(String name) {
        super(name);
        this.func_149715_a(1.0f);
    }

    public boolean func_180639_a(Level worldIn, BlockPos pos, BlockState state, Player playerIn, InteractionHand hand, Direction facing, float hitX, float hitY, float hitZ) {
        if (!worldIn.field_72995_K) {
            Random rand = new Random();
            AABB checkBox = new AABB(pos.func_177982_a(-10, -10, -10), pos.func_177982_a(10, 10, 10));
            for (EntityRhythmGameMerchant merch : worldIn.func_72872_a(EntityRhythmGameMerchant.class, checkBox)) {
                ((ServerLevel)worldIn).func_175739_a(EnumParticleTypes.PORTAL, merch.field_70165_t, merch.field_70163_u, merch.field_70161_v, 5, (-0.5 + rand.nextDouble()) * 3.0, 0.3, (-0.5 + rand.nextDouble()) * 3.0, (double)0.15f, new int[0]);
                merch.pressButton(pos);
            }
        }
        return true;
    }

    public BlockState getActiveState() {
        return this.func_176223_P().func_177226_a((Property)ACTIVE, (Comparable)Boolean.valueOf(true));
    }

    public BlockState getInactiveState() {
        return this.func_176223_P().func_177226_a((Property)ACTIVE, (Comparable)Boolean.valueOf(false));
    }
}

