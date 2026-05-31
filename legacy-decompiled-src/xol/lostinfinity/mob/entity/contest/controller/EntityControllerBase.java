/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.player.Player
 *  net.minecraft.util.SoundSource
 *  net.minecraft.util.SoundEvent
 *  net.minecraft.util.math.AABB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.text.Component
 *  net.minecraft.util.text.Component
 *  net.minecraft.world.World
 */
package xol.lostinfinity.mob.entity.contest.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import net.minecraft.world.entity.player.Player;
import net.minecraft.sounds.SoundSource;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.phys.AABB;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.Level;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.DimensionInit;
import xol.lostinfinity.mob.entity.base.EntityImmaterial;

public class EntityControllerBase
extends EntityImmaterial {
    protected int stage = 0;
    private List<UUID> player_list = new ArrayList<UUID>();
    protected int contenderCount = 0;
    protected List<UUID> touched_list = new ArrayList<UUID>();
    protected boolean touchInProgress = false;

    public EntityControllerBase(Level worldIn) {
        super(worldIn);
    }

    public void setPlayerCount(int count) {
        this.contenderCount = count;
    }

    public void addPlayerToList(Player player) {
        this.player_list.add(player.func_110124_au());
    }

    public List<UUID> getPlayerList() {
        return this.player_list;
    }

    public void removePlayer(Player player) {
        if (this.player_list.contains(player.func_110124_au())) {
            this.eliminatePlayer(player.func_110124_au());
            this.player_list.remove(player.func_110124_au());
            this.playerStatusCheck();
        }
    }

    public void removePlayerByUUID(UUID uuid) {
        if (this.player_list.contains(uuid)) {
            this.eliminatePlayer(uuid);
            this.player_list.remove(uuid);
            this.playerStatusCheck();
        }
    }

    public void removeMultiplePlayers(List<UUID> getting_removed) {
        for (UUID rem_id : getting_removed) {
            if (!this.player_list.contains(rem_id)) continue;
            this.eliminatePlayer(rem_id);
        }
        this.player_list.removeAll(getting_removed);
        this.playerStatusCheck();
    }

    protected void eliminatePlayer(UUID playerID) {
        Player player = this.field_70170_p.func_152378_a(playerID);
        if (player != null) {
            this.messageContenders(TextFmt.Green, player.func_70005_c_() + " Eliminated!");
            this.rewardPlayer(player, this.contenderCount - this.getPlayerList().size());
        }
    }

    protected void removeFailedCheckIn() {
        ArrayList<UUID> eliminated_players = new ArrayList<UUID>();
        for (UUID pl_id : this.getPlayerList()) {
            if (this.touched_list.contains(pl_id)) continue;
            eliminated_players.add(pl_id);
        }
        this.removeMultiplePlayers(eliminated_players);
        this.touchInProgress = false;
        this.touched_list.clear();
    }

    protected void playerStatusCheck() {
        boolean end_flag = false;
        ArrayList<UUID> accounted_for = new ArrayList<UUID>();
        for (Player near_pl : this.field_70170_p.func_72872_a(Player.class, this.getArenaAABB())) {
            accounted_for.add(near_pl.func_110124_au());
        }
        accounted_for.retainAll(this.player_list);
        ArrayList<UUID> not_detected = new ArrayList<UUID>();
        not_detected.addAll(this.player_list);
        not_detected.removeAll(accounted_for);
        if (!not_detected.isEmpty()) {
            this.removeMultiplePlayers(not_detected);
        }
        if (this.player_list.isEmpty()) {
            end_flag = true;
        }
        if (!end_flag && this.player_list.size() == 1) {
            Player winner = this.field_70170_p.func_152378_a(this.player_list.get(0));
            if (winner != null) {
                this.rewardPlayer(winner, this.contenderCount - 1);
            }
            end_flag = true;
        }
        if (end_flag) {
            this.func_70106_y();
            this.endGame();
        }
    }

    public void registerTouch(Player player) {
        UUID player_uuid;
        if (this.touchInProgress && !this.touched_list.contains(player_uuid = player.func_110124_au())) {
            this.touched_list.add(player_uuid);
            player.func_145747_a((Component)new Component((Object)((Object)TextFmt.Gold) + "You have checked in!"));
        }
    }

    @Override
    public boolean func_70104_M() {
        return false;
    }

    @Override
    public void func_70636_d() {
        super.func_70636_d();
        if (!this.field_70170_p.field_72995_K) {
            if (this.field_70170_p.field_73011_w.func_186058_p() == DimensionInit.grandmasterOutpost) {
                BlockPos snapPos = this.getSnapPos();
                if (this.field_70173_aa % 5 == 0) {
                    this.func_70634_a(snapPos.func_177958_n(), snapPos.func_177956_o(), snapPos.func_177952_p());
                }
            }
            if (this.player_list.isEmpty() && this.field_70173_aa > 5) {
                this.func_70106_y();
            } else if (this.field_70173_aa % 20 == 0) {
                this.playerStatusCheck();
            }
        }
    }

    protected AABB getArenaAABB() {
        return null;
    }

    protected BlockPos getSnapPos() {
        return null;
    }

    protected void messageContenders(TextFmt fmt, String message) {
        for (Player contender : this.field_70170_p.func_72872_a(Player.class, this.getArenaAABB())) {
            contender.func_145747_a((Component)new Component((Object)((Object)fmt) + "Grandmaster: " + message));
        }
    }

    protected void messageContendersWithSound(TextFmt fmt, String message, SoundEvent sound) {
        for (Player contender : this.field_70170_p.func_72872_a(Player.class, this.getArenaAABB())) {
            contender.func_145747_a((Component)new Component((Object)((Object)fmt) + "Grandmaster: " + message));
            contender.field_70170_p.func_184133_a(null, contender.func_180425_c(), sound, SoundSource.MASTER, 1.0f, 1.0f);
        }
    }

    protected void soundContenders(SoundEvent sound, float vol, float pitch) {
        for (Player contender : this.field_70170_p.func_72872_a(Player.class, this.getArenaAABB())) {
            contender.field_70170_p.func_184133_a(null, contender.func_180425_c(), sound, SoundSource.MASTER, vol, pitch);
        }
    }

    protected void rewardPlayer(Player player, int placement) {
    }

    protected void endGame() {
    }
}

