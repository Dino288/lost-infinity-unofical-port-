/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.util.Rotation
 *  net.minecraft.util.math.AABB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.text.Component
 *  net.minecraft.util.text.Component
 *  net.minecraft.world.World
 */
package xol.lostinfinity.mob.entity.contest.operator;

import java.util.UUID;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.util.Rotation;
import net.minecraft.world.phys.AABB;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.Level;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.dimension.data.ChunkPairing;
import xol.lostinfinity.dimension.util.WorldGenStructure;
import xol.lostinfinity.mob.entity.contest.EntityBloodhunter;
import xol.lostinfinity.mob.entity.contest.controller.EntityControllerHunters;
import xol.lostinfinity.mob.entity.contest.operator.EntityOperatorBase;
import xol.lostinfinity.util.coordinates.ContestCoordinates;

public class EntityOperatorHunters
extends EntityOperatorBase {
    public EntityOperatorHunters(Level worldIn) {
        super(worldIn);
    }

    @Override
    protected void arenaClear() {
        for (EntityBloodhunter hunter : this.field_70170_p.func_72872_a(EntityBloodhunter.class, this.getArenaAABB())) {
            hunter.func_70106_y();
        }
    }

    @Override
    protected void startGame() {
        EntityControllerHunters gamehologram = new EntityControllerHunters(this.field_70170_p);
        BlockPos holopos = ContestCoordinates.huntersControllerPos();
        gamehologram.func_70107_b(holopos.func_177958_n(), holopos.func_177956_o(), holopos.func_177952_p());
        gamehologram.setPlayerCount(this.contenders.size());
        for (UUID pl_id : this.contenders) {
            Player pl = this.field_70170_p.func_152378_a(pl_id);
            if (pl == null) continue;
            gamehologram.addPlayerToList(pl);
            pl.field_71071_by.func_70436_m();
            BlockPos spawnPos = ContestCoordinates.huntersArenaCenterPos();
            pl.func_70634_a((double)spawnPos.func_177958_n() + this.startingOffset(), (double)spawnPos.func_177956_o(), (double)spawnPos.func_177952_p() + this.startingOffset());
            pl.func_145747_a((Component)new Component((Object)((Object)TextFmt.Aqua) + "Grandmaster: Okay contenders, scurry quickly! A bloodhunter will be released in 10 seconds."));
        }
        this.field_70170_p.func_72838_d((Entity)gamehologram);
        this.contenders.clear();
    }

    @Override
    protected AABB getArenaAABB() {
        return ContestCoordinates.huntersArenaAABB();
    }

    @Override
    protected AABB getLobbyAABB() {
        return ContestCoordinates.huntersLobbyAABB();
    }

    @Override
    protected void generateArena() {
        ChunkPairing chunk = ContestCoordinates.huntersGenLoc();
        int chunkX = chunk.chunkX();
        int chunkZ = chunk.chunkZ();
        int posX = chunkX * 16;
        int posZ = chunkZ * 16;
        new WorldGenStructure(this.randomHuntersGame()).func_180709_b(this.field_70170_p, this.field_70146_Z, new BlockPos(posX, 22, posZ));
        new WorldGenStructure(this.randomHuntersGame()).generateWithRotation(this.field_70170_p, this.field_70146_Z, new BlockPos(posX + 32, 22, posZ), Rotation.CLOCKWISE_90);
        new WorldGenStructure(this.randomHuntersGame()).generateWithRotation(this.field_70170_p, this.field_70146_Z, new BlockPos(posX + 32, 22, posZ + 32), Rotation.CLOCKWISE_180);
        new WorldGenStructure(this.randomHuntersGame()).generateWithRotation(this.field_70170_p, this.field_70146_Z, new BlockPos(posX, 22, posZ + 32), Rotation.COUNTERCLOCKWISE_90);
    }

    private double startingOffset() {
        return 2.0 * (-0.5 + this.field_70146_Z.nextDouble());
    }

    private String randomHuntersGame() {
        int game_pick = this.field_70146_Z.nextInt(7);
        return "contest/contest_hunters_game" + ++game_pick;
    }
}

