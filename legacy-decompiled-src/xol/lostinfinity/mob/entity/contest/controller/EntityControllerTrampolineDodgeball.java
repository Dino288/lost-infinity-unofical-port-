/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.state.BlockState
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.item.ItemEntity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.item.ItemStack
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.util.math.AABB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.world.World
 */
package xol.lostinfinity.mob.entity.contest.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.phys.AABB;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.BlockInit;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.mob.entity.contest.controller.EntityControllerBase;
import xol.lostinfinity.util.coordinates.ContestCoordinates;

public class EntityControllerTrampolineDodgeball
extends EntityControllerBase {
    private HashMap<UUID, Integer> playerScores = new HashMap();
    private ArrayList<UUID> playersInRound = new ArrayList();
    private ArrayList<BlockPos> spawnPositions = new ArrayList();
    private static final int maxScore = 3;

    public void setSpawnPositions(List<BlockPos> spawnPositions) {
        this.spawnPositions.clear();
        this.spawnPositions.addAll(spawnPositions);
    }

    public void initGame() {
        this.playersInRound.clear();
        this.playerScores.clear();
        for (UUID pl_id : this.getPlayerList()) {
            this.playerScores.put(pl_id, 0);
            this.playersInRound.add(pl_id);
        }
    }

    public void eliminatePlayerFromRound(Player player) {
        UUID pl_id = player.func_110124_au();
        this.playersInRound.remove(pl_id);
        this.soundContenders(SoundInit.GAME_BUZZER, 1.0f, 1.0f);
        BlockPos teleTo = ContestCoordinates.dodgeballWaitingRoomPos();
        player.func_70634_a((double)teleTo.func_177958_n(), (double)teleTo.func_177956_o(), (double)teleTo.func_177952_p());
        if (this.playersInRound.size() == 1) {
            this.roundUp(this.playersInRound.get(0));
        }
    }

    private void roundUp(UUID uuid) {
        this.playersInRound.clear();
        this.playersInRound.addAll(this.getPlayerList());
        int oldScore = this.playerScores.get(uuid);
        this.playerScores.replace(uuid, oldScore + 1);
        if (oldScore >= 2) {
            ArrayList<UUID> removeList = new ArrayList<UUID>();
            int iterations = this.getPlayerList().size();
            for (int i = 0; i < iterations; ++i) {
                int minScore = 99;
                UUID minPlayer = null;
                for (UUID pl_id : this.getPlayerList()) {
                    int score;
                    if (removeList.contains(pl_id) || !this.playerScores.containsKey(pl_id) || (score = this.playerScores.get(pl_id).intValue()) >= minScore) continue;
                    minScore = score;
                    minPlayer = pl_id;
                }
                if (minPlayer == null) continue;
                removeList.add(minPlayer);
            }
            for (UUID pl_id : removeList) {
                this.removePlayerByUUID(pl_id);
            }
            this.func_70106_y();
        } else {
            this.messageContenders(TextFmt.Green, "SCOREBOARD");
            int i = 0;
            for (UUID pl_id : this.getPlayerList()) {
                if (!this.playerScores.containsKey(pl_id)) continue;
                Player playerEntity = this.field_70170_p.func_152378_a(pl_id);
                if (playerEntity != null) {
                    this.messageContenders(TextFmt.Green, String.format("%s: %d", playerEntity.func_70005_c_(), this.playerScores.get(pl_id)));
                }
                BlockPos teleTo = this.spawnPositions.get(i);
                ++i;
                playerEntity.func_70634_a((double)teleTo.func_177958_n(), (double)teleTo.func_177956_o(), (double)teleTo.func_177952_p());
            }
            this.soundContenders(SoundInit.MINIGAME_POWERUP, 1.0f, 1.0f);
            this.messageContenders(TextFmt.Green, "Next round, begin!");
        }
    }

    @Override
    protected void playerStatusCheck() {
    }

    public EntityControllerTrampolineDodgeball(Level worldIn) {
        super(worldIn);
        this.func_70105_a(5.0f, 12.0f);
    }

    @Override
    public AABB getArenaAABB() {
        return ContestCoordinates.dodgeballArenaAABB();
    }

    @Override
    public void func_70636_d() {
        super.func_70636_d();
        if (!this.field_70170_p.field_72995_K) {
            Player lastPlayer;
            if (this.field_70173_aa > 2 && this.contenderCount < 2) {
                this.func_70106_y();
            }
            List inAABB = this.field_70170_p.func_72872_a(Player.class, this.getArenaAABB());
            if (this.field_70173_aa % 500 == 0) {
                int numSpecial = this.field_70170_p.field_73012_v.nextInt(3) + 1;
                int xMin = (int)this.getArenaAABB().field_72340_a + 5;
                int xMax = (int)this.getArenaAABB().field_72336_d - 5;
                int y = (int)this.getArenaAABB().field_72338_b + 6;
                int zMin = (int)this.getArenaAABB().field_72339_c + 5;
                int zMax = (int)this.getArenaAABB().field_72334_f - 5;
                for (int i = 0; i < numSpecial; ++i) {
                    ItemStack stack;
                    int x = this.field_70170_p.field_73012_v.nextInt(xMax - xMin + 1) + xMin;
                    int z = this.field_70170_p.field_73012_v.nextInt(zMax - zMin + 1) + zMin;
                    if (this.field_70170_p.field_73012_v.nextBoolean()) {
                        stack = new ItemStack(ItemInit.championDodgeball, 1);
                        if (!stack.func_77942_o()) {
                            stack.func_77982_d(new CompoundTag());
                        }
                        stack.func_77978_p().func_74768_a("balltype_data", 1);
                    } else {
                        stack = new ItemStack(ItemInit.championDodgeball, 1);
                        if (!stack.func_77942_o()) {
                            stack.func_77982_d(new CompoundTag());
                        }
                        stack.func_77978_p().func_74768_a("balltype_data", 2);
                    }
                    ItemEntity item = new ItemEntity(this.field_70170_p, (double)x, (double)y, (double)z, stack);
                    item.field_70159_w = 0.0;
                    item.field_70181_x = 0.0;
                    item.field_70179_y = 0.0;
                    this.field_70170_p.func_72838_d((Entity)item);
                }
                this.soundContenders(SoundInit.GAME_DING, 1.0f, 1.0f);
                this.messageContenders(TextFmt.Green, "Some special dodgeballs have been added to the arena!");
            }
            for (Player near_pl : inAABB) {
                BlockPos playerPos;
                BlockState state;
                near_pl.field_70143_R = -1.0f;
                if (near_pl.field_71075_bZ.field_75100_b) {
                    this.eliminatePlayerFromRound(near_pl);
                    this.removePlayer(near_pl);
                    this.messageContenders(TextFmt.Dark_Red, String.format("%s was removed for trying to fly away", near_pl.func_70005_c_()));
                }
                if ((state = this.field_70170_p.func_180495_p(playerPos = near_pl.func_180425_c().func_177977_b())).equals(BlockInit.parkourPlatform.func_176203_a(0))) {
                    near_pl.func_70024_g(0.0, 0.6, 0.0);
                    near_pl.field_70133_I = true;
                    continue;
                }
                if (!state.equals(BlockInit.championLauncher.func_176223_P())) continue;
                int xDiff = 208 - playerPos.func_177958_n();
                int zDiff = -49 - playerPos.func_177952_p();
                if (zDiff > 10) {
                    near_pl.func_70024_g(0.0, 0.5, 2.0);
                } else if (zDiff < -10) {
                    near_pl.func_70024_g(0.0, 0.5, -2.0);
                } else if (xDiff > 10) {
                    near_pl.func_70024_g(2.0, 0.5, 0.0);
                } else if (xDiff < -10) {
                    near_pl.func_70024_g(-2.0, 0.5, 0.0);
                }
                near_pl.field_70133_I = true;
            }
            if (this.getPlayerList().size() == 1 && (lastPlayer = this.field_70170_p.func_152378_a(this.getPlayerList().get(0))) != null) {
                this.rewardPlayer(lastPlayer, this.contenderCount);
                this.func_70106_y();
            }
        }
    }

    @Override
    protected BlockPos getSnapPos() {
        return ContestCoordinates.dodgeballControllerPos();
    }

    @Override
    protected void rewardPlayer(Player player, int placement) {
        for (int i = 0; i < player.field_71071_by.func_70302_i_(); ++i) {
            if (player.field_71071_by.func_70301_a(i).func_77973_b() != ItemInit.championDodgeball) continue;
            player.field_71071_by.func_70299_a(i, ItemStack.field_190927_a);
        }
        BlockPos teleTo = ContestCoordinates.dodgeballLobbyPos();
        player.func_70634_a((double)teleTo.func_177958_n(), (double)teleTo.func_177956_o(), (double)teleTo.func_177952_p());
        int reward_count = Math.min(10 + 20 * placement + (placement == this.contenderCount - 1 ? this.contenderCount * 10 : 0), 50);
        player.func_191521_c(new ItemStack(ItemInit.zirconiaAubergine, reward_count));
    }
}

