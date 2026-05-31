/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.state.BlockState
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.init.Blocks
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
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.AABB;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.Level;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.dimension.data.LaserNode;
import xol.lostinfinity.dimension.data.LaserTagMap;
import xol.lostinfinity.init.BlockInit;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.mob.entity.contest.controller.EntityControllerLaserTag;
import xol.lostinfinity.mob.entity.contest.operator.EntityOperatorBase;
import xol.lostinfinity.util.coordinates.ContestCoordinates;

public class EntityOperatorLaserTag
extends EntityOperatorBase {
    private List<BlockPos> spawnPositions = new ArrayList<BlockPos>();

    public EntityOperatorLaserTag(Level worldIn) {
        super(worldIn);
    }

    @Override
    protected void startGame() {
        for (EntityControllerLaserTag entity : this.field_70170_p.func_72872_a(EntityControllerLaserTag.class, this.getArenaAABB())) {
            entity.func_70106_y();
        }
        EntityControllerLaserTag gamehologram = new EntityControllerLaserTag(this.field_70170_p);
        BlockPos pos = ContestCoordinates.laserTagControllerPos();
        gamehologram.func_70107_b(pos.func_177958_n(), pos.func_177956_o(), pos.func_177952_p());
        gamehologram.setPlayerCount(this.contenders.size());
        int curSpawn = 0;
        ArrayList<UUID> toRemove = new ArrayList<UUID>();
        for (UUID pl_id : this.contenders) {
            if (this.contenders.indexOf(pl_id) <= 10) continue;
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
            pl.func_191521_c(new ItemStack(ItemInit.laserZapper, 1));
            BlockPos spawnPos = this.spawnPositions.get(curSpawn);
            pl.func_70634_a((double)spawnPos.func_177958_n(), (double)spawnPos.func_177956_o(), (double)spawnPos.func_177952_p());
            pl.func_145747_a((Component)new Component((Object)((Object)TextFmt.Aqua) + "Grandmaster: Alright contenders, zap the other players to get the highest score!"));
            ++curSpawn;
        }
        this.field_70170_p.func_72838_d((Entity)gamehologram);
        gamehologram.initLaserTag(this.spawnPositions);
        this.spawnPositions.clear();
        this.contenders.clear();
    }

    @Override
    protected void generateArena() {
        BlockState wallState;
        int j;
        int i;
        BlockPos pos = new BlockPos(this.getArenaAABB().field_72340_a, this.getArenaAABB().field_72338_b + 1.0, this.getArenaAABB().field_72339_c);
        LaserTagMap map = new LaserTagMap(36, 36);
        LaserNode[][] floor1 = map.getFloor1();
        LaserNode[][] floor2 = map.getFloor2();
        for (i = 0; i < floor1.length; ++i) {
            for (j = 0; j < floor1[0].length; ++j) {
                if (i >= floor1.length - 4 && j >= floor1[0].length - 4 || i < 4 && j < 4) continue;
                this.field_70170_p.func_175698_g(pos.func_177982_a(i, 0, j));
                this.field_70170_p.func_175698_g(pos.func_177982_a(i, 1, j));
                this.field_70170_p.func_175698_g(pos.func_177982_a(i, 2, j));
                this.field_70170_p.func_175698_g(pos.func_177982_a(i, 3, j));
                this.field_70170_p.func_175656_a(pos.func_177982_a(i, 3, j), BlockInit.championDungeonPlating.func_176223_P());
                if (floor1[i][j].visited()) {
                    wallState = BlockInit.bomberWallHard.func_176223_P();
                    wallState = i < floor1.length / 2 ? (j < floor1[0].length / 2 ? BlockInit.neonBricksBlue.func_176223_P() : BlockInit.neonBricksYellow.func_176223_P()) : (j < floor1[0].length / 2 ? BlockInit.neonBricksRed.func_176223_P() : BlockInit.neonBricksGreen.func_176223_P());
                    this.field_70170_p.func_175656_a(pos.func_177982_a(i, 0, j), BlockInit.championWall.func_176223_P());
                    if (this.field_70170_p.field_73012_v.nextInt(10) == 0) {
                        this.field_70170_p.func_175656_a(pos.func_177982_a(i, 1, j), BlockInit.championGlassDark.func_176223_P());
                    } else {
                        this.field_70170_p.func_175656_a(pos.func_177982_a(i, 1, j), wallState);
                    }
                    this.field_70170_p.func_175656_a(pos.func_177982_a(i, 2, j), wallState);
                    continue;
                }
                this.spawnPositions.add(pos.func_177982_a(i, 1, j));
                if (this.field_70170_p.field_73012_v.nextInt(40) != 0) continue;
                this.field_70170_p.func_175656_a(pos.func_177982_a(i, 3, j), Blocks.field_150415_aT.func_176223_P());
            }
        }
        Collections.shuffle(this.spawnPositions);
        for (i = 0; i < floor2.length; ++i) {
            for (j = 0; j < floor2[0].length; ++j) {
                if (i >= floor2.length - 4 && j >= floor2[0].length - 4 || i < 4 && j < 4) continue;
                this.field_70170_p.func_175698_g(pos.func_177982_a(i, 4, j));
                this.field_70170_p.func_175698_g(pos.func_177982_a(i, 5, j));
                this.field_70170_p.func_175698_g(pos.func_177982_a(i, 6, j));
                if (!floor2[i][j].visited()) continue;
                wallState = BlockInit.championWall.func_176223_P();
                wallState = i < floor1.length / 2 ? (j < floor1[0].length / 2 ? BlockInit.neonBricksAqua.func_176223_P() : BlockInit.neonBricksOrange.func_176223_P()) : (j < floor1[0].length / 2 ? BlockInit.neonBricksPurple.func_176223_P() : BlockInit.neonBricksPink.func_176223_P());
                this.field_70170_p.func_175656_a(pos.func_177982_a(i, 4, j), BlockInit.championWall.func_176223_P());
                if (this.field_70170_p.field_73012_v.nextInt(15) == 0) {
                    this.field_70170_p.func_175656_a(pos.func_177982_a(i, 5, j), BlockInit.championGlassDark.func_176223_P());
                } else {
                    this.field_70170_p.func_175656_a(pos.func_177982_a(i, 5, j), wallState);
                }
                this.field_70170_p.func_175656_a(pos.func_177982_a(i, 6, j), wallState);
            }
        }
    }

    @Override
    protected AABB getArenaAABB() {
        return ContestCoordinates.laserTagArenaAABB();
    }

    @Override
    protected AABB getLobbyAABB() {
        return ContestCoordinates.laserTagLobbyAABB();
    }
}

