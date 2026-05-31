/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Mob
 *  net.minecraft.entity.ai.EntityAIBase
 *  net.minecraft.entity.ai.EntityAIWatchClosest2
 *  net.minecraft.entity.player.Player
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.world.World
 */
package xol.lostinfinity.mob.entity.contest;

import net.minecraft.world.entity.Mob;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAIWatchClosest2;
import net.minecraft.world.entity.player.Player;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import xol.lostinfinity.init.DimensionInit;
import xol.lostinfinity.mob.entity.base.EntityImmaterial;
import xol.lostinfinity.util.coordinates.ContestCoordinates;

public class EntityContestHologram
extends EntityImmaterial {
    public EntityContestHologram(Level worldIn) {
        super(worldIn);
        this.func_184224_h(true);
    }

    protected void func_184651_r() {
        this.field_70714_bg.func_75776_a(9, (EntityAIBase)new EntityAIWatchClosest2((Mob)this, Player.class, 3.0f, 1.0f));
    }

    @Override
    public void func_70636_d() {
        super.func_70636_d();
        if (!this.field_70170_p.field_72995_K && this.field_70173_aa % 5 == 0 && this.field_70170_p.field_73011_w.func_186058_p() == DimensionInit.grandmasterOutpost) {
            BlockPos teleTo = ContestCoordinates.lobbyHologramPos();
            this.func_70634_a(teleTo.func_177958_n(), teleTo.func_177956_o(), teleTo.func_177952_p());
        }
    }
}

