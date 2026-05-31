/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.player.Player
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.math.AABB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.world.World
 */
package xol.lostinfinity.mob.entity.contest.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.AABB;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.mob.entity.contest.controller.EntityControllerBase;
import xol.lostinfinity.util.coordinates.ContestCoordinates;

public class EntityControllerLaserTag
extends EntityControllerBase {
    private HashMap<UUID, Integer> playerScores = null;
    private int time = 0;
    private static final int duration = 5000;
    private List<BlockPos> spawnPositions = new ArrayList<BlockPos>();

    public void initLaserTag(List<BlockPos> spawnPositions) {
        this.spawnPositions.clear();
        this.spawnPositions.addAll(spawnPositions);
        this.time = 0;
        this.playerScores = new HashMap();
        for (UUID pl_id : this.getPlayerList()) {
            this.playerScores.put(pl_id, 0);
        }
    }

    public void hitPlayer(Player attacker, Player target, int numHits) {
        UUID attacker_id = null;
        if (attacker != null) {
            attacker_id = attacker.func_110124_au();
        }
        int score = 0;
        if (this.playerScores == null) {
            return;
        }
        if (attacker_id != null && this.playerScores.containsKey(attacker_id)) {
            score = this.playerScores.get(attacker_id) + numHits;
            this.playerScores.replace(attacker_id, score);
            if (this.spawnPositions != null && !this.spawnPositions.isEmpty()) {
                int randSpawn = this.field_70146_Z.nextInt(this.spawnPositions.size());
                BlockPos spawn = this.spawnPositions.get(randSpawn);
                target.func_70634_a((double)spawn.func_177958_n(), (double)spawn.func_177956_o(), (double)spawn.func_177952_p());
            }
        }
        if (score != 0) {
            this.messageContenders(TextFmt.Red, String.format("%s SCORE: %d ", attacker.func_70005_c_(), score));
        }
    }

    public EntityControllerLaserTag(Level worldIn) {
        super(worldIn);
        this.func_70105_a(5.0f, 12.0f);
    }

    @Override
    public AABB getArenaAABB() {
        return ContestCoordinates.laserTagArenaAABB();
    }

    @Override
    public void func_70636_d() {
        super.func_70636_d();
        if (!this.field_70170_p.field_72995_K) {
            if (this.field_70173_aa > 2 && this.playerScores == null) {
                this.func_70106_y();
            }
            ++this.time;
            if (this.time >= 5000) {
                int numToRemove = this.getPlayerList().size() - 1;
                for (int i = 0; i < numToRemove; ++i) {
                    int min = 1000;
                    UUID remove = null;
                    for (UUID pl_id : this.getPlayerList()) {
                        if (this.playerScores.get(pl_id) >= min) continue;
                        min = this.playerScores.get(pl_id);
                        remove = pl_id;
                    }
                    if (remove == null) continue;
                    this.removePlayerByUUID(remove);
                }
            }
            List inAABB = this.field_70170_p.func_72872_a(Player.class, this.getArenaAABB());
            for (Player near_pl : inAABB) {
                if (!near_pl.field_71075_bZ.field_75100_b) continue;
                this.removePlayer(near_pl);
            }
        }
    }

    @Override
    protected BlockPos getSnapPos() {
        return ContestCoordinates.laserTagControllerPos();
    }

    @Override
    protected void rewardPlayer(Player player, int placement) {
        BlockPos teleTo = ContestCoordinates.laserTagLobbyPos();
        player.func_70634_a((double)teleTo.func_177958_n(), (double)teleTo.func_177956_o(), (double)teleTo.func_177952_p());
        for (int i = 0; i < player.field_71071_by.func_70302_i_(); ++i) {
            if (player.field_71071_by.func_70301_a(i).func_77973_b() != ItemInit.laserZapper) continue;
            player.field_71071_by.func_70299_a(i, ItemStack.field_190927_a);
        }
        int reward_count = Math.min(10 + 20 * placement + (placement == this.contenderCount - 1 ? this.contenderCount * 10 : 0), 50);
        player.func_191521_c(new ItemStack(ItemInit.zirconiaMidnight, reward_count));
    }
}

