/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.item.ItemEntity
 *  net.minecraft.entity.monster.EntityHusk
 *  net.minecraft.entity.monster.EntitySkeleton
 *  net.minecraft.entity.player.Player
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.math.AABB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.world.World
 */
package xol.lostinfinity.mob.entity.contest.controller;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.entity.monster.EntityHusk;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.AABB;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.dimension.data.ChunkPairing;
import xol.lostinfinity.dimension.data.TileMap;
import xol.lostinfinity.dimension.data.TileNode;
import xol.lostinfinity.dimension.util.WorldGenStructure;
import xol.lostinfinity.init.DimensionInit;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.mob.entity.contest.controller.EntityControllerBase;
import xol.lostinfinity.util.coordinates.ContestCoordinates;

public class EntityControllerHolodeck
extends EntityControllerBase {
    private TileMap my_holodeck = null;
    private List<TileNode> removed_tiles = new ArrayList<TileNode>();
    private int style = 0;
    private int stageTimer = 100;

    public EntityControllerHolodeck(Level worldIn) {
        super(worldIn);
        this.func_70105_a(5.0f, 12.0f);
    }

    public void setMyHolodeck(TileMap holo) {
        this.my_holodeck = holo;
    }

    public void setArenaStyle(int styleIn) {
        this.style = styleIn;
    }

    @Override
    protected AABB getArenaAABB() {
        return ContestCoordinates.holodeckArenaAABB();
    }

    @Override
    protected BlockPos getSnapPos() {
        return ContestCoordinates.holodeckControllerPos();
    }

    @Override
    public void func_70636_d() {
        super.func_70636_d();
        if (!this.field_70170_p.field_72995_K) {
            if (this.my_holodeck == null) {
                this.func_70106_y();
            } else if (this.field_70170_p.field_73011_w.func_186058_p() == DimensionInit.grandmasterOutpost) {
                if (this.stageTimer == 0) {
                    this.upStage();
                } else {
                    --this.stageTimer;
                }
            }
        }
    }

    private void upStage() {
        ++this.stage;
        int typeOfStage = this.stage % 3;
        switch (typeOfStage) {
            case 0: {
                TileNode dropNode = this.my_holodeck.randomLivingNode();
                BlockPos spawnPos = this.nodeToBlockPos(dropNode).func_177963_a(2.5, 1.0, 2.5);
                if (this.field_70146_Z.nextBoolean()) {
                    EntitySkeleton summon;
                    if (this.field_70146_Z.nextBoolean()) {
                        summon = new EntitySkeleton(this.field_70170_p);
                        this.messageContenders(TextFmt.Italic, "Nothing like a skeleton to make things spookier!");
                    } else {
                        summon = new EntityHusk(this.field_70170_p);
                        this.messageContenders(TextFmt.Italic, "Don't hug the husk contenders!");
                    }
                    summon.func_70107_b((double)spawnPos.func_177958_n(), (double)(spawnPos.func_177956_o() + 1), (double)spawnPos.func_177952_p());
                    this.field_70170_p.func_72838_d((Entity)summon);
                    break;
                }
                if (this.field_70146_Z.nextBoolean()) {
                    ItemEntity saber = new ItemEntity(this.field_70170_p, (double)spawnPos.func_177958_n(), (double)spawnPos.func_177956_o(), (double)spawnPos.func_177952_p(), new ItemStack(ItemInit.holoSaber));
                    this.field_70170_p.func_72838_d((Entity)saber);
                    this.messageContenders(TextFmt.Aqua, "I've dropped a holo saber into the arena. Who will get it?");
                    break;
                }
                ItemEntity pulse = new ItemEntity(this.field_70170_p, (double)spawnPos.func_177958_n(), (double)spawnPos.func_177956_o(), (double)spawnPos.func_177952_p(), new ItemStack(ItemInit.powerPulse));
                this.field_70170_p.func_72838_d((Entity)pulse);
                this.messageContenders(TextFmt.Blue, "A power pulse has been placed in the arena.");
                break;
            }
            case 1: {
                int remainingTiles = this.my_holodeck.remainingTiles();
                int removeTiles = remainingTiles > 10 ? 4 : (remainingTiles > 5 ? 2 : 1);
                this.removed_tiles = this.my_holodeck.removeTiles(Math.min(remainingTiles - 1, removeTiles));
                for (TileNode node : this.removed_tiles) {
                    this.highlightTile(node);
                }
                this.messageContenders(TextFmt.Gold, this.randomRemoveTileMsg());
                this.func_184185_a(SoundInit.SPIRE_TARGET, 1.0f, 1.0f);
                break;
            }
            case 2: {
                for (TileNode node : this.removed_tiles) {
                    this.removeTile(node);
                }
                this.removed_tiles.clear();
                this.func_184185_a(SoundInit.SPIRE_DIFFICULTY, 1.0f, 1.0f);
            }
        }
        this.stageTimer = 120;
    }

    private BlockPos nodeToBlockPos(TileNode tile) {
        ChunkPairing chunk = ContestCoordinates.holodeckGenLoc();
        int chunkX = chunk.chunkX();
        int chunkZ = chunk.chunkZ();
        int holoX = 27 + chunkX * 16;
        int holoZ = -16 + chunkZ * 16;
        int posX = tile.getX();
        int posY = tile.getY();
        int posZ = tile.getZ();
        return new BlockPos(holoX + 6 * posX, posY, holoZ + 6 * posZ);
    }

    private void highlightTile(TileNode tile) {
        new WorldGenStructure("contest/holodeckplatformh").func_180709_b(this.field_70170_p, this.field_70170_p.field_73012_v, this.nodeToBlockPos(tile));
    }

    private void removeTile(TileNode tile) {
        BlockPos start = this.nodeToBlockPos(tile);
        for (int xp = 0; xp < 5; ++xp) {
            for (int zp = 0; zp < 5; ++zp) {
                this.field_70170_p.func_175698_g(start.func_177982_a(xp, 0, zp));
            }
        }
    }

    private String randomRemoveTileMsg() {
        switch (this.field_70146_Z.nextInt(5)) {
            case 0: {
                return "Some more tiles are getting ready to disappear!";
            }
            case 1: {
                return "Some tiles are ready to vanish beneath your feet.";
            }
            case 2: {
                return "Time to remove part of the arena!";
            }
            case 3: {
                return "Who's ready to fall into the void?";
            }
            case 4: {
                return "I've marked more tiles for removal contenders!";
            }
        }
        return "Some more tiles are getting ready to disappear!";
    }

    @Override
    protected void rewardPlayer(Player player, int placement) {
        if (player.field_70165_t > 100.0) {
            BlockPos teleTo = ContestCoordinates.holodeckLobbyPos();
            player.func_70634_a((double)teleTo.func_177958_n(), (double)teleTo.func_177956_o(), (double)teleTo.func_177952_p());
        }
        int reward_count = Math.min(1 + placement * Math.floorDiv(this.stage, 4) + (placement == this.contenderCount - 1 ? this.contenderCount * 2 : 0), 50);
        player.func_191521_c(new ItemStack(ItemInit.zirconiaCerulean, reward_count));
    }
}

