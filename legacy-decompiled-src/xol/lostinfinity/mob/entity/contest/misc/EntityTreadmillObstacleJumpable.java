/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.player.Player
 *  net.minecraft.world.World
 */
package xol.lostinfinity.mob.entity.contest.misc;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import xol.lostinfinity.mob.entity.contest.misc.EntityTreadmillObstacle;

public class EntityTreadmillObstacleJumpable
extends EntityTreadmillObstacle {
    public EntityTreadmillObstacleJumpable(Level worldIn) {
        super(worldIn);
        this.func_70105_a(0.1f, 1.0f);
    }

    @Override
    public void func_70100_b_(Player entityIn) {
        if (Math.abs(this.field_70163_u - entityIn.field_70163_u) < 0.001 && this.field_70165_t > entityIn.field_70165_t) {
            super.func_70100_b_(entityIn);
        }
    }
}

