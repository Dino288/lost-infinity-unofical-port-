/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.InteractionHand
 *  net.minecraft.util.math.AABB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.text.Component
 *  net.minecraft.util.text.Component
 *  net.minecraft.world.World
 */
package xol.lostinfinity.mob.entity.contest.operator;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.phys.AABB;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.Level;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.mob.entity.contest.controller.EntityControllerTargets;
import xol.lostinfinity.mob.entity.contest.operator.EntityOperatorBase;
import xol.lostinfinity.util.coordinates.ContestCoordinates;

public class EntityOperatorTargets
extends EntityOperatorBase {
    private List<BlockPos> spawnPositions = new ArrayList<BlockPos>();

    public EntityOperatorTargets(Level worldIn) {
        super(worldIn);
    }

    @Override
    public boolean func_184645_a(Player player, InteractionHand hand) {
        if (!this.field_70170_p.field_72995_K) {
            if (this.isGameInProgress() || this.gameStartCountdown >= 0) {
                player.func_145747_a((Component)new Component((Object)((Object)TextFmt.Red) + "A match is currently in progress."));
                return true;
            }
            if (this.timeSinceSwitch == 0) {
                Item held = player.func_184586_b(hand).func_77973_b();
                if (held.equals(ItemInit.eliteContenderPass)) {
                    this.gameStartCountdown = 1;
                    this.arenaClear();
                    this.generateArena();
                }
            } else {
                player.func_145747_a((Component)new Component((Object)((Object)TextFmt.Red) + "Operator: The arena was just changed. Be patient mortal."));
            }
        }
        return true;
    }

    @Override
    protected boolean canStartGame() {
        int pl_count = 0;
        block0: for (Player near_pl : this.field_70170_p.func_72872_a(Player.class, this.getLobbyAABB())) {
            for (int i = 0; i < near_pl.field_71071_by.func_70302_i_(); ++i) {
                if (!near_pl.field_71071_by.func_70301_a(i).func_77973_b().equals(ItemInit.eliteContenderPass)) continue;
                ++pl_count;
                this.contenders.add(near_pl.func_110124_au());
                near_pl.field_71071_by.func_70299_a(i, ItemStack.field_190927_a);
                continue block0;
            }
        }
        return pl_count == 1;
    }

    @Override
    protected void startGame() {
        this.spawnPositions.add(ContestCoordinates.targetsSpawnPos());
        EntityControllerTargets gamehologram = new EntityControllerTargets(this.field_70170_p);
        BlockPos pos = ContestCoordinates.targetsControllerPos();
        gamehologram.func_70107_b(pos.func_177958_n(), pos.func_177956_o(), pos.func_177952_p());
        gamehologram.setPlayerCount(1);
        int curSpawn = 0;
        for (UUID pl_id : this.contenders) {
            Player pl = this.field_70170_p.func_152378_a(pl_id);
            if (pl == null) continue;
            gamehologram.addPlayerToList(pl);
            pl.field_71071_by.func_70436_m();
            pl.func_191521_c(new ItemStack(ItemInit.spaceZapper, 1));
            BlockPos spawnPos = this.spawnPositions.get(curSpawn);
            pl.func_70634_a((double)spawnPos.func_177958_n(), (double)spawnPos.func_177956_o(), (double)spawnPos.func_177952_p());
            gamehologram.setTargetPositions(this.field_70170_p);
            ++curSpawn;
        }
        this.field_70170_p.func_72838_d((Entity)gamehologram);
        this.spawnPositions.clear();
        this.contenders.clear();
    }

    @Override
    protected AABB getArenaAABB() {
        return ContestCoordinates.targetsArenaAABB();
    }

    @Override
    protected AABB getLobbyAABB() {
        return ContestCoordinates.targetsLobbyAABB();
    }
}

