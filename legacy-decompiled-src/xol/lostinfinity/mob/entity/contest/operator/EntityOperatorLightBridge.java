/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.util.math.AABB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Vec3i
 *  net.minecraft.util.text.Component
 *  net.minecraft.util.text.Component
 *  net.minecraft.world.World
 */
package xol.lostinfinity.mob.entity.contest.operator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.AABB;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Vec3i;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.Level;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.mob.entity.contest.controller.EntityControllerLightBridge;
import xol.lostinfinity.mob.entity.contest.operator.EntityOperatorBase;
import xol.lostinfinity.util.coordinates.ContestCoordinates;

public class EntityOperatorLightBridge
extends EntityOperatorBase {
    private List<BlockPos> spawnPositions = new ArrayList<BlockPos>();
    private BlockPos ref = null;

    public EntityOperatorLightBridge(Level worldIn) {
        super(worldIn);
    }

    @Override
    protected void startGame() {
        EntityControllerLightBridge gamehologram = new EntityControllerLightBridge(this.field_70170_p);
        BlockPos pos = ContestCoordinates.lightBridgeControllerPos();
        gamehologram.func_70107_b(pos.func_177958_n(), pos.func_177956_o(), pos.func_177952_p());
        gamehologram.setPlayerCount(this.contenders.size());
        HashMap<UUID, BlockPos> respawnPositions = new HashMap<UUID, BlockPos>();
        int curSpawn = 0;
        for (UUID pl_id : this.contenders) {
            Player pl = this.field_70170_p.func_152378_a(pl_id);
            if (pl == null) continue;
            gamehologram.addPlayerToList(pl);
            pl.field_71071_by.func_70436_m();
            BlockPos spawnPos = this.spawnPositions.get(curSpawn);
            pl.func_70634_a((double)spawnPos.func_177958_n(), (double)spawnPos.func_177956_o(), (double)spawnPos.func_177952_p());
            respawnPositions.put(pl_id, new BlockPos((Vec3i)spawnPos));
            pl.func_145747_a((Component)new Component((Object)((Object)TextFmt.Aqua) + "Grandmaster: Alright contenders, lets see who can cross to the other side first!"));
            ++curSpawn;
        }
        int col = (int)Math.abs(this.getBoardAABB().field_72334_f - this.getBoardAABB().field_72339_c);
        int row = (int)Math.abs(this.getBoardAABB().field_72336_d - this.getBoardAABB().field_72340_a);
        gamehologram.setRespawns(respawnPositions);
        gamehologram.setBridgePositions(this.ref, col, row, this.field_70170_p);
        this.field_70170_p.func_72838_d((Entity)gamehologram);
        this.spawnPositions.clear();
        this.contenders.clear();
    }

    @Override
    protected AABB getArenaAABB() {
        return ContestCoordinates.lightBridgeArenaAABB();
    }

    @Override
    protected AABB getLobbyAABB() {
        return ContestCoordinates.lightBridgeLobbyAABB();
    }

    protected AABB getBoardAABB() {
        return ContestCoordinates.lightBridgeBoardAABB();
    }

    @Override
    protected void generateArena() {
        BlockPos arenaPos = ContestCoordinates.lightBridgeArenaPos();
        this.spawnPositions.clear();
        int col = (int)Math.abs(this.getBoardAABB().field_72334_f - this.getBoardAABB().field_72339_c);
        for (int i = 0; i < col; ++i) {
            this.spawnPositions.add(arenaPos.func_177982_a(0, 1, i));
        }
        Collections.shuffle(this.spawnPositions);
        this.ref = arenaPos.func_177982_a(1, 0, 0);
    }
}

