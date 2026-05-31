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
import xol.lostinfinity.init.BlockInit;
import xol.lostinfinity.mob.entity.contest.controller.EntityControllerRedlight;
import xol.lostinfinity.mob.entity.contest.operator.EntityOperatorBase;
import xol.lostinfinity.util.coordinates.ContestCoordinates;

public class EntityOperatorRedlight
extends EntityOperatorBase {
    public EntityOperatorRedlight(Level worldIn) {
        super(worldIn);
    }

    @Override
    protected void startGame() {
        EntityControllerRedlight gamehologram = new EntityControllerRedlight(this.field_70170_p);
        BlockPos holopos = ContestCoordinates.redlightControllerPos();
        gamehologram.func_70107_b(holopos.func_177958_n(), holopos.func_177956_o(), holopos.func_177952_p());
        gamehologram.setPlayerCount(this.contenders.size());
        gamehologram.setLights(BlockInit.championSignalGreen);
        gamehologram.darkenPillars();
        for (UUID pl_id : this.contenders) {
            Player pl = this.field_70170_p.func_152378_a(pl_id);
            if (pl == null) continue;
            gamehologram.addPlayerToList(pl);
            pl.field_71071_by.func_70436_m();
            ChunkPairing chunk = ContestCoordinates.redlightGenLoc();
            int chunkX = chunk.chunkX();
            int chunkZ = chunk.chunkZ();
            double spawnX = this.startingOffset() + 31.0 + (double)(chunkX * 16);
            double spawnZ = this.startingOffset() + 31.0 + (double)(chunkZ * 16);
            pl.func_70634_a(spawnX, 25.0, spawnZ);
            pl.func_145747_a((Component)new Component((Object)((Object)TextFmt.Aqua) + "Grandmaster: Okay contenders, don't let me catch you moving during a red light!"));
        }
        this.field_70170_p.func_72838_d((Entity)gamehologram);
        this.contenders.clear();
    }

    @Override
    protected AABB getArenaAABB() {
        return ContestCoordinates.redlightArenaAABB();
    }

    @Override
    protected AABB getLobbyAABB() {
        return ContestCoordinates.redlightLobbyAABB();
    }

    @Override
    protected void generateArena() {
        ChunkPairing chunk = ContestCoordinates.redlightGenLoc();
        int chunkX = chunk.chunkX();
        int chunkZ = chunk.chunkZ();
        int posX = chunkX * 16;
        int posZ = chunkZ * 16;
        new WorldGenStructure(this.randomRedlightGame()).func_180709_b(this.field_70170_p, this.field_70146_Z, new BlockPos(posX, 24, posZ));
        new WorldGenStructure(this.randomRedlightGame()).generateWithRotation(this.field_70170_p, this.field_70146_Z, new BlockPos(posX + 32, 24, posZ), Rotation.CLOCKWISE_90);
        new WorldGenStructure(this.randomRedlightGame()).generateWithRotation(this.field_70170_p, this.field_70146_Z, new BlockPos(posX + 32, 24, posZ + 32), Rotation.CLOCKWISE_180);
        new WorldGenStructure(this.randomRedlightGame()).generateWithRotation(this.field_70170_p, this.field_70146_Z, new BlockPos(posX, 24, posZ + 32), Rotation.COUNTERCLOCKWISE_90);
    }

    private double startingOffset() {
        return this.field_70146_Z.nextBoolean() ? -1 : 2;
    }

    private String randomRedlightGame() {
        int game_pick = this.field_70146_Z.nextInt(12);
        return "contest/contest_redlight_arena_" + ++game_pick;
    }
}

