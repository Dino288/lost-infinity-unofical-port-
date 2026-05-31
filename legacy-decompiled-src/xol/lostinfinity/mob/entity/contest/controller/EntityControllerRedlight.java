/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.entity.player.Player
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.math.AABB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.world.World
 */
package xol.lostinfinity.mob.entity.contest.controller;

import java.util.HashMap;
import java.util.UUID;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.AABB;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.dimension.data.ChunkPairing;
import xol.lostinfinity.init.BlockInit;
import xol.lostinfinity.init.DimensionInit;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.mob.entity.contest.controller.EntityControllerBase;
import xol.lostinfinity.util.coordinates.ContestCoordinates;

public class EntityControllerRedlight
extends EntityControllerBase {
    private int stageTimer = 200;
    private int gracePeriod = 0;
    private HashMap<UUID, BlockPos> playerPositions = new HashMap();

    public EntityControllerRedlight(Level worldIn) {
        super(worldIn);
        this.func_70105_a(3.0f, 6.0f);
    }

    @Override
    public void func_70636_d() {
        super.func_70636_d();
        if (!this.field_70170_p.field_72995_K && this.field_70170_p.field_73011_w.func_186058_p() == DimensionInit.grandmasterOutpost) {
            if (this.stageTimer == 0) {
                this.upStage();
            } else {
                if (this.gracePeriod > 0) {
                    --this.gracePeriod;
                } else if (this.stage % 2 == 1 && this.field_70173_aa % 2 == 0) {
                    this.scanArenaForMoving();
                }
                --this.stageTimer;
            }
        }
    }

    private void upStage() {
        ++this.stage;
        if (this.stage % 2 == 0) {
            this.messageContendersWithSound(TextFmt.Green, "Green Light", SoundInit.GAME_DING);
            this.stageTimer = this.stage > 14 ? 60 + this.field_70146_Z.nextInt(60) : 100 + this.field_70146_Z.nextInt(100);
            this.playerPositions.clear();
            this.setLights(BlockInit.championSignalGreen);
            if (this.stage % 8 == 2) {
                this.newLights();
            }
        } else {
            this.messageContendersWithSound(TextFmt.Red, "RED LIGHT", SoundInit.GAME_BUZZER);
            this.cycleBlocks();
            this.setLights(BlockInit.championSignalRed);
            this.stageTimer = 140;
            this.gracePeriod = 15;
            if (this.stage > 1 && this.stage % 8 == 1) {
                this.handleCheckIn();
            }
        }
    }

    private void scanArenaForMoving() {
        for (Player contender : this.field_70170_p.func_72872_a(Player.class, this.getArenaAABB())) {
            UUID contender_id = contender.func_110124_au();
            BlockPos contender_pos = contender.func_180425_c();
            if (this.playerPositions.containsKey(contender_id) && !this.playerPositions.get(contender_id).equals((Object)contender_pos)) {
                this.removePlayerByUUID(contender_id);
            }
            this.playerPositions.put(contender_id, contender_pos);
        }
    }

    private void newLights() {
        this.touchInProgress = true;
        this.messageContenders(TextFmt.Gold, "You have 4 rounds to check in to a lit pillar.");
        int pick1 = this.field_70146_Z.nextInt(5);
        int pick2 = this.field_70146_Z.nextInt(5);
        while (pick1 == pick2) {
            pick2 = this.field_70146_Z.nextInt(5);
        }
        this.lightPillars(pick1, pick2);
    }

    private void handleCheckIn() {
        this.removeFailedCheckIn();
        this.darkenPillars();
    }

    public void setLights(Block block) {
        int col;
        int row;
        int distance;
        int width;
        ChunkPairing chunk = ContestCoordinates.redlightGenLoc();
        int chunkX = chunk.chunkX();
        int chunkZ = chunk.chunkZ();
        int blockX = 3 + chunkX * 16;
        int blockZ = 3 + chunkZ * 16;
        for (width = 0; width < 2; ++width) {
            for (distance = 0; distance < 2; ++distance) {
                for (row = 0; row < 4; ++row) {
                    for (col = 0; col < 4; ++col) {
                        this.field_70170_p.func_175656_a(new BlockPos(blockX + 28 * distance + 13 + row, 28 + col, blockZ + width * 57), block.func_176223_P());
                    }
                }
            }
        }
        for (width = 0; width < 2; ++width) {
            for (distance = 0; distance < 2; ++distance) {
                for (row = 0; row < 4; ++row) {
                    for (col = 0; col < 4; ++col) {
                        this.field_70170_p.func_175656_a(new BlockPos(blockX + width * 57, 28 + col, blockZ + 28 * distance + 13 + row), block.func_176223_P());
                    }
                }
            }
        }
    }

    private void cycleBlocks() {
        ChunkPairing chunk = ContestCoordinates.redlightGenLoc();
        int chunkX = chunk.chunkX();
        int chunkZ = chunk.chunkZ();
        int blockX = chunkX * 16;
        int blockZ = chunkZ * 16;
        for (int xAdd = 5; xAdd <= 59; ++xAdd) {
            for (int zAdd = 5; zAdd <= 59; ++zAdd) {
                BlockPos pos = new BlockPos(blockX + xAdd, 24, blockZ + zAdd);
                Block block = this.field_70170_p.func_180495_p(pos).func_177230_c();
                if (block.equals(BlockInit.championDoorClosed)) {
                    this.field_70170_p.func_175656_a(pos, BlockInit.championDoorAjar.func_176223_P());
                    continue;
                }
                if (block.equals(BlockInit.championDoorAjar)) {
                    this.field_70170_p.func_175656_a(pos, BlockInit.championDoorOpen.func_176223_P());
                    continue;
                }
                if (!block.equals(BlockInit.championDoorOpen)) continue;
                this.field_70170_p.func_175656_a(pos, BlockInit.championDoorClosed.func_176223_P());
            }
        }
    }

    private void setPillar(int pilnum, Block blockset) {
        ChunkPairing chunk = ContestCoordinates.redlightGenLoc();
        int chunkX = chunk.chunkX();
        int chunkZ = chunk.chunkZ();
        int blockX = 14 + chunkX * 16;
        int blockZ = 14 + chunkZ * 16;
        if (pilnum < 4) {
            blockX += 34 * (pilnum % 2);
            blockZ += 34 * Math.floorDiv(pilnum, 2);
        } else {
            blockX += 17;
            blockZ += 17;
        }
        for (int x = 0; x < 2; ++x) {
            for (int z = 0; z < 2; ++z) {
                this.field_70170_p.func_175656_a(new BlockPos(blockX + x, 26, blockZ + z), blockset.func_176223_P());
            }
        }
    }

    private void lightPillars(int pilnum1, int pilnum2) {
        this.setPillar(pilnum1, BlockInit.championDungeonSelector);
        this.setPillar(pilnum2, BlockInit.championDungeonSelector);
    }

    public void darkenPillars() {
        for (int i = 0; i < 5; ++i) {
            this.setPillar(i, BlockInit.championDungeonBox);
        }
    }

    @Override
    protected AABB getArenaAABB() {
        return ContestCoordinates.redlightArenaAABB();
    }

    @Override
    protected BlockPos getSnapPos() {
        return ContestCoordinates.redlightControllerPos();
    }

    @Override
    protected void rewardPlayer(Player player, int placement) {
        BlockPos teleTo = ContestCoordinates.redlightLobbyPos();
        player.func_70634_a((double)teleTo.func_177958_n(), (double)teleTo.func_177956_o(), (double)teleTo.func_177952_p());
        int reward_count = Math.min(1 + placement * Math.floorDiv(this.stage, 3) + (placement == this.contenderCount - 1 ? this.contenderCount * 2 : 0), 50);
        player.func_191521_c(new ItemStack(ItemInit.zirconiaMalachite, reward_count));
    }

    @Override
    protected void endGame() {
        this.setLights(BlockInit.championSignalGreen);
        this.darkenPillars();
    }
}

