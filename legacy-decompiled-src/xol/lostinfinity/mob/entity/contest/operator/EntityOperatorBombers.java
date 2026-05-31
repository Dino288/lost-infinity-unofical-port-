/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.math.AABB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.text.Component
 *  net.minecraft.util.text.Component
 *  net.minecraft.world.World
 */
package xol.lostinfinity.mob.entity.contest.operator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.AABB;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.Level;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.dimension.data.BomberMap;
import xol.lostinfinity.dimension.data.BomberNode;
import xol.lostinfinity.init.BlockInit;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.mob.entity.contest.controller.EntityControllerBombers;
import xol.lostinfinity.mob.entity.contest.operator.EntityOperatorBase;
import xol.lostinfinity.util.coordinates.ContestCoordinates;

public class EntityOperatorBombers
extends EntityOperatorBase {
    private List<BlockPos> spawnPositions = new ArrayList<BlockPos>();
    private List<BlockPos> powerupPositions = new ArrayList<BlockPos>();

    public EntityOperatorBombers(Level worldIn) {
        super(worldIn);
    }

    @Override
    protected void startGame() {
        EntityControllerBombers gamehologram = new EntityControllerBombers(this.field_70170_p);
        BlockPos holopos = ContestCoordinates.bombersControllerPos();
        gamehologram.func_70107_b(holopos.func_177958_n(), holopos.func_177956_o(), holopos.func_177952_p());
        gamehologram.setPlayerCount(this.contenders.size());
        for (BlockPos pos : this.powerupPositions) {
            gamehologram.addPowerupLocation(pos);
        }
        int curSpawn = 0;
        for (UUID pl_id : this.contenders) {
            Player pl = this.field_70170_p.func_152378_a(pl_id);
            if (pl == null) continue;
            gamehologram.addPlayerToList(pl);
            pl.field_71071_by.func_70436_m();
            BlockPos spawnPos = this.spawnPositions.get(curSpawn);
            pl.func_70634_a((double)spawnPos.func_177958_n(), (double)spawnPos.func_177956_o(), (double)spawnPos.func_177952_p());
            pl.func_145747_a((Component)new Component((Object)((Object)TextFmt.Aqua) + "Grandmaster: Alright contenders, time to blow eachother up for our entertainment!"));
            pl.func_191521_c(new ItemStack(ItemInit.bomberGameDeployer));
            ++curSpawn;
        }
        this.field_70170_p.func_72838_d((Entity)gamehologram);
        this.spawnPositions.clear();
        this.powerupPositions.clear();
        this.contenders.clear();
    }

    @Override
    protected AABB getArenaAABB() {
        return ContestCoordinates.bombersArenaAABB();
    }

    @Override
    protected AABB getLobbyAABB() {
        return ContestCoordinates.bombersLobbyAABB();
    }

    @Override
    protected void generateArena() {
        BlockPos arenaPos = ContestCoordinates.bombersArenaPos();
        int col_max = 45;
        int row_max = 45;
        this.spawnPositions.clear();
        BomberMap game_map = new BomberMap(col_max, row_max, 20);
        game_map.setSpawns(10);
        for (int col = 0; col < col_max; ++col) {
            block13: for (int row = 0; row < row_max; ++row) {
                BomberNode node = game_map.getNodeAtLocation(col, row);
                String type = node.getType();
                if (type.contains("spawn")) {
                    this.field_70170_p.func_175698_g(arenaPos.func_177982_a(col, 0, row));
                    this.field_70170_p.func_175698_g(arenaPos.func_177982_a(col, 1, row));
                    this.spawnPositions.add(arenaPos.func_177982_a(col, 0, row));
                    continue;
                }
                switch (type) {
                    case "air": {
                        this.field_70170_p.func_175698_g(arenaPos.func_177982_a(col, 0, row));
                        this.field_70170_p.func_175698_g(arenaPos.func_177982_a(col, 1, row));
                        continue block13;
                    }
                    case "hard": {
                        this.field_70170_p.func_175656_a(arenaPos.func_177982_a(col, 0, row), BlockInit.bomberWallHard.func_176223_P());
                        this.field_70170_p.func_175656_a(arenaPos.func_177982_a(col, 1, row), BlockInit.bomberWallHard.func_176223_P());
                        continue block13;
                    }
                    case "soft": {
                        this.field_70170_p.func_175656_a(arenaPos.func_177982_a(col, 0, row), BlockInit.bomberWallSoft.func_176223_P());
                        this.field_70170_p.func_175656_a(arenaPos.func_177982_a(col, 1, row), BlockInit.bomberWallSoft.func_176223_P());
                        continue block13;
                    }
                    case "powerup": {
                        this.powerupPositions.add(arenaPos.func_177982_a(col, 1, row));
                        this.field_70170_p.func_175656_a(arenaPos.func_177982_a(col, 0, row), BlockInit.bomberWallHard.func_176223_P());
                        this.field_70170_p.func_175656_a(arenaPos.func_177982_a(col, 1, row), BlockInit.bombersPowerupClosed.func_176223_P());
                    }
                }
            }
        }
        Collections.shuffle(this.spawnPositions);
    }
}

