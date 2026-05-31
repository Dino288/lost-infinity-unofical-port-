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

import java.util.UUID;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.AABB;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.Level;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.dimension.data.ChunkPairing;
import xol.lostinfinity.dimension.data.TileMap;
import xol.lostinfinity.dimension.util.WorldGenStructure;
import xol.lostinfinity.mob.entity.contest.controller.EntityControllerHolodeck;
import xol.lostinfinity.mob.entity.contest.operator.EntityOperatorBase;
import xol.lostinfinity.util.coordinates.ContestCoordinates;

public class EntityOperatorHolodeck
extends EntityOperatorBase {
    public EntityOperatorHolodeck(Level worldIn) {
        super(worldIn);
    }

    @Override
    protected void incrementStyle() {
        ++this.style;
        if (this.style == 5) {
            this.style = 0;
        }
    }

    @Override
    protected void startGame() {
        EntityControllerHolodeck gamehologram = new EntityControllerHolodeck(this.field_70170_p);
        BlockPos holopos = ContestCoordinates.holodeckControllerPos();
        gamehologram.func_70107_b(holopos.func_177958_n(), holopos.func_177956_o(), holopos.func_177952_p());
        gamehologram.setPlayerCount(this.contenders.size());
        gamehologram.setMyHolodeck(new TileMap(7, 7, -1, -1, this.style));
        gamehologram.setArenaStyle(this.style);
        for (UUID pl_id : this.contenders) {
            Player pl = this.field_70170_p.func_152378_a(pl_id);
            if (pl == null) continue;
            gamehologram.addPlayerToList(pl);
            pl.field_71071_by.func_70436_m();
            int pl_xoff = this.field_70146_Z.nextInt(7);
            int pl_zoff = this.field_70146_Z.nextInt(7);
            int pl_ypos = this.getYfromXZStyle(pl_xoff, pl_zoff, this.style);
            double arena_xstart = ContestCoordinates.holodeckArenaAABB().field_72340_a + 3.0;
            double arena_zstart = ContestCoordinates.holodeckArenaAABB().field_72339_c + 3.0;
            pl.func_70634_a(arena_xstart + (double)(pl_xoff * 6), (double)pl_ypos + 1.0, arena_zstart + (double)(pl_zoff * 6));
            pl.func_145747_a((Component)new Component((Object)((Object)TextFmt.Aqua) + "Grandmaster: Last one standing wins."));
        }
        this.field_70170_p.func_72838_d((Entity)gamehologram);
        this.contenders.clear();
    }

    @Override
    protected AABB getArenaAABB() {
        return ContestCoordinates.holodeckControllerAABB();
    }

    @Override
    protected AABB getLobbyAABB() {
        return ContestCoordinates.holodeckLobbyAABB();
    }

    @Override
    protected void generateArena() {
        ChunkPairing chunk = ContestCoordinates.holodeckGenLoc();
        int chunkX = chunk.chunkX();
        int chunkZ = chunk.chunkZ();
        int holoX = 27 + chunkX * 16;
        int holoZ = -16 + chunkZ * 16;
        for (int xp = 0; xp < 41; ++xp) {
            for (int zp = 0; zp < 41; ++zp) {
                for (int yp = 0; yp < 7; ++yp) {
                    this.field_70170_p.func_175698_g(new BlockPos(holoX + xp, 28 + yp, holoZ + zp));
                }
            }
        }
        for (int xline = 0; xline < 7; ++xline) {
            for (int zline = 0; zline < 7; ++zline) {
                int ypos = this.getYfromXZStyle(xline, zline, this.style);
                new WorldGenStructure("contest/holodeckpiece").func_180709_b(this.field_70170_p, this.field_70170_p.field_73012_v, new BlockPos(holoX + 6 * xline, ypos, holoZ + 6 * zline));
            }
        }
    }

    private int getYfromXZStyle(int xline, int zline, int style) {
        int yheight = 28;
        switch (style) {
            case 0: {
                break;
            }
            case 1: {
                if (xline % 2 != 1 && zline % 2 != 1) break;
                ++yheight;
                break;
            }
            case 2: {
                int xdiff = Math.abs(3 - xline);
                int zdiff = Math.abs(3 - zline);
                if (xdiff > zdiff) {
                    yheight = 28 + xdiff;
                    break;
                }
                yheight = 28 + zdiff;
                break;
            }
            case 3: {
                int xdiff = Math.abs(3 - xline);
                int zdiff = Math.abs(3 - zline);
                if (xdiff > zdiff) {
                    yheight = 31 - xdiff;
                    break;
                }
                yheight = 31 - zdiff;
                break;
            }
            case 4: {
                yheight += xline;
            }
        }
        return yheight;
    }
}

