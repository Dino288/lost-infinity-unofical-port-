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
import java.util.HashMap;
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
import xol.lostinfinity.mob.entity.contest.controller.EntityControllerBattleSnakes;
import xol.lostinfinity.mob.entity.contest.operator.EntityOperatorBase;
import xol.lostinfinity.util.coordinates.ContestCoordinates;

public class EntityOperatorBattleSnakes
extends EntityOperatorBase {
    private List<BlockPos> spawnPositions = new ArrayList<BlockPos>();

    public EntityOperatorBattleSnakes(Level worldIn) {
        super(worldIn);
    }

    @Override
    protected void startGame() {
        for (EntityControllerBattleSnakes entity : this.field_70170_p.func_72872_a(EntityControllerBattleSnakes.class, this.getArenaAABB())) {
            entity.func_70106_y();
        }
        EntityControllerBattleSnakes gamehologram = new EntityControllerBattleSnakes(this.field_70170_p);
        BlockPos pos = ContestCoordinates.battleSnakesControllerPos();
        gamehologram.func_70107_b(pos.func_177958_n(), pos.func_177956_o(), pos.func_177952_p());
        gamehologram.setPlayerCount(this.contenders.size());
        HashMap<UUID, BlockPos> controllerMap = new HashMap<UUID, BlockPos>();
        ArrayList<BlockPos> controlPositions = ContestCoordinates.battleSnakeControlPositions();
        int curSpawn = 0;
        ArrayList<UUID> toRemove = new ArrayList<UUID>();
        for (UUID pl_id : this.contenders) {
            if (this.contenders.indexOf(pl_id) <= 4) continue;
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
            controllerMap.put(pl_id, controlPositions.get(curSpawn));
            BlockPos spawnPos = this.spawnPositions.get(curSpawn);
            pl.func_70634_a((double)spawnPos.func_177958_n(), (double)spawnPos.func_177956_o(), (double)spawnPos.func_177952_p());
            pl.func_145747_a((Component)new Component((Object)((Object)TextFmt.Aqua) + "Grandmaster: Alright contenders, guide your snakes to victory!"));
            ++curSpawn;
        }
        this.field_70170_p.func_72838_d((Entity)gamehologram);
        gamehologram.setupSnakes();
        gamehologram.setControllerMap(controllerMap);
        this.spawnPositions.clear();
        this.contenders.clear();
    }

    @Override
    protected void arenaClear() {
        BlockPos arenaPos = ContestCoordinates.battleSnakesArenaPos();
        int row = (int)Math.abs(this.getBoardAABB().field_72334_f - this.getBoardAABB().field_72339_c);
        int col = (int)Math.abs(this.getBoardAABB().field_72336_d - this.getBoardAABB().field_72340_a);
        for (int i = 0; i <= col; ++i) {
            for (int j = 0; j <= row; ++j) {
                this.field_70170_p.func_175698_g(arenaPos.func_177982_a(i, 2, j));
            }
        }
    }

    @Override
    protected AABB getArenaAABB() {
        return ContestCoordinates.battleSnakesArenaAABB();
    }

    @Override
    protected AABB getLobbyAABB() {
        return ContestCoordinates.battleSnakesLobbyAABB();
    }

    protected AABB getBoardAABB() {
        return ContestCoordinates.battleSnakesBoardAABB();
    }

    @Override
    protected void generateArena() {
        BlockPos arenaPos = ContestCoordinates.battleSnakesArenaPos();
        this.spawnPositions.clear();
        int row = (int)Math.abs(this.getBoardAABB().field_72334_f - this.getBoardAABB().field_72339_c);
        int col = (int)Math.abs(this.getBoardAABB().field_72336_d - this.getBoardAABB().field_72340_a);
        for (int i = 0; i <= col; ++i) {
            for (int j = 0; j <= row; ++j) {
            }
        }
        this.spawnPositions = ContestCoordinates.battleSnakeSpawnPositions();
    }
}

