/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.util.math.AABB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.text.Component
 *  net.minecraft.util.text.Component
 *  net.minecraft.world.World
 */
package xol.lostinfinity.mob.entity.contest.operator;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.AABB;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.Level;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.mob.entity.contest.controller.EntityControllerTreadmill;
import xol.lostinfinity.mob.entity.contest.operator.EntityOperatorBase;
import xol.lostinfinity.util.coordinates.ContestCoordinates;

public class EntityOperatorTreadmill
extends EntityOperatorBase {
    private List<BlockPos> spawnPositions = new ArrayList<BlockPos>();

    public EntityOperatorTreadmill(Level worldIn) {
        super(worldIn);
    }

    @Override
    protected void startGame() {
        this.spawnPositions = ContestCoordinates.treadmillSpawnPositions();
        for (EntityControllerTreadmill entity : this.field_70170_p.func_72872_a(EntityControllerTreadmill.class, this.getArenaAABB())) {
            entity.func_70106_y();
        }
        EntityControllerTreadmill gamehologram = new EntityControllerTreadmill(this.field_70170_p);
        BlockPos pos = ContestCoordinates.treadmillControllerPos();
        gamehologram.func_70107_b(pos.func_177958_n(), pos.func_177956_o(), pos.func_177952_p());
        gamehologram.setPlayerCount(this.contenders.size());
        int curSpawn = 0;
        ArrayList<UUID> toRemove = new ArrayList<UUID>();
        for (UUID pl_id : this.contenders) {
            if (this.contenders.indexOf(pl_id) <= 6) continue;
            toRemove.add(pl_id);
        }
        for (UUID pl_id : toRemove) {
            this.contenders.remove(pl_id);
            this.field_70170_p.func_152378_a(pl_id).func_145747_a((Component)new Component((Object)((Object)TextFmt.Aqua) + "Too many players, please join the next game"));
        }
        for (UUID pl_id : this.contenders) {
            Player pl = this.field_70170_p.func_152378_a(pl_id);
            if (pl == null) continue;
            gamehologram.addPlayerToList(pl);
            pl.field_71071_by.func_70436_m();
            BlockPos spawnPos = this.spawnPositions.get(curSpawn);
            pl.func_70634_a((double)spawnPos.func_177958_n(), (double)spawnPos.func_177956_o(), (double)spawnPos.func_177952_p());
            pl.func_145747_a((Component)new Component((Object)((Object)TextFmt.Aqua) + "Grandmaster: Alright contenders, avoid the obstacles to survive!"));
            ++curSpawn;
        }
        this.field_70170_p.func_72838_d((Entity)gamehologram);
        this.spawnPositions.clear();
        this.contenders.clear();
    }

    @Override
    protected AABB getArenaAABB() {
        return ContestCoordinates.treadmillArenaAABB();
    }

    @Override
    protected AABB getLobbyAABB() {
        return ContestCoordinates.treadmillLobbyAABB();
    }
}

