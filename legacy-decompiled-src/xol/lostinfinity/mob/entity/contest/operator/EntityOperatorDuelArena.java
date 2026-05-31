/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.item.ItemEntityFrame
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
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import net.minecraft.world.entity.Entity;
import net.minecraft.entity.item.ItemEntityFrame;
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
import xol.lostinfinity.mob.entity.contest.controller.EntityControllerDuelArena;
import xol.lostinfinity.mob.entity.contest.operator.EntityOperatorBase;
import xol.lostinfinity.util.coordinates.ContestCoordinates;

public class EntityOperatorDuelArena
extends EntityOperatorBase {
    private List<BlockPos> spawnPositions = new ArrayList<BlockPos>();

    public EntityOperatorDuelArena(Level worldIn) {
        super(worldIn);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public boolean func_184645_a(Player player, InteractionHand hand) {
        if (!this.field_70170_p.field_72995_K) {
            ItemEntityFrame frames;
            if (this.isGameInProgress() || this.gameStartCountdown >= 0) {
                player.func_145747_a((Component)new Component((Object)((Object)TextFmt.Red) + "A match is currently in progress."));
                return true;
            }
            Item held = player.func_184586_b(hand).func_77973_b();
            ItemStack stack = player.func_184586_b(hand);
            ItemStack temp1 = null;
            ItemStack temp2 = null;
            Iterator iterator = this.field_70170_p.func_72872_a(ItemEntityFrame.class, new AABB(ContestCoordinates.duelFrame1Pos())).iterator();
            if (iterator.hasNext()) {
                frames = (ItemEntityFrame)iterator.next();
                temp1 = frames.func_82335_i();
            }
            if ((iterator = this.field_70170_p.func_72872_a(ItemEntityFrame.class, new AABB(ContestCoordinates.duelFrame2Pos())).iterator()).hasNext()) {
                frames = (ItemEntityFrame)iterator.next();
                temp2 = frames.func_82335_i();
            }
            if (held.equals(ItemInit.contenderPass)) {
                if (temp1.func_190926_b() || temp2.func_190926_b()) return true;
                this.gameStartCountdown = 200;
                this.arenaClear();
            } else if (temp1.func_190926_b()) {
                iterator = this.field_70170_p.func_72872_a(ItemEntityFrame.class, new AABB(ContestCoordinates.duelFrame1Pos())).iterator();
                if (iterator.hasNext()) {
                    frames = (ItemEntityFrame)iterator.next();
                    frames.func_82334_a(stack.func_77946_l());
                    player.func_145747_a((Component)new Component((Object)((Object)TextFmt.Aqua) + "THANK YOU FOR YOU ITEM!"));
                }
            } else {
                if (!temp2.func_190926_b()) return true;
                iterator = this.field_70170_p.func_72872_a(ItemEntityFrame.class, new AABB(ContestCoordinates.duelFrame2Pos())).iterator();
                if (iterator.hasNext()) {
                    frames = (ItemEntityFrame)iterator.next();
                    frames.func_82334_a(stack.func_77946_l());
                    player.func_145747_a((Component)new Component((Object)((Object)TextFmt.Aqua) + "THANK YOU FOR YOU ITEM!"));
                }
            }
        }
        player.func_184586_b(hand).func_190918_g(1);
        return true;
    }

    @Override
    protected boolean canStartGame() {
        int pl_count = 0;
        block0: for (Player near_pl : this.field_70170_p.func_72872_a(Player.class, this.getLobbyAABB())) {
            for (int i = 0; i < near_pl.field_71071_by.func_70302_i_(); ++i) {
                if (!near_pl.field_71071_by.func_70301_a(i).func_77973_b().equals(ItemInit.contenderPass)) continue;
                ++pl_count;
                this.contenders.add(near_pl.func_110124_au());
                near_pl.field_71071_by.func_70299_a(i, ItemStack.field_190927_a);
                continue block0;
            }
        }
        return pl_count == 2;
    }

    @Override
    protected void startGame() {
        if (this.contenders.size() != 2) {
            return;
        }
        this.spawnPositions.add(new BlockPos(99, 33, 256));
        this.spawnPositions.add(new BlockPos(155, 33, 256));
        EntityControllerDuelArena gamehologram = new EntityControllerDuelArena(this.field_70170_p);
        BlockPos pos = ContestCoordinates.duelControllerPos();
        gamehologram.func_70107_b(pos.func_177958_n(), pos.func_177956_o(), pos.func_177952_p());
        gamehologram.setPlayerCount(this.contenders.size());
        int curSpawn = 0;
        for (UUID pl_id : this.contenders) {
            Player pl = this.field_70170_p.func_152378_a(pl_id);
            if (pl == null) continue;
            gamehologram.addPlayerToList(pl);
            pl.field_71071_by.func_70436_m();
            pl.func_191521_c(new ItemStack(ItemInit.duelingSwordDull, 1));
            BlockPos spawnPos = this.spawnPositions.get(curSpawn);
            pl.func_70634_a((double)spawnPos.func_177958_n(), (double)spawnPos.func_177956_o(), (double)spawnPos.func_177952_p());
            pl.func_145747_a((Component)new Component((Object)((Object)TextFmt.Aqua) + "Grandmaster: Alright contenders, last one standing wins!"));
            ++curSpawn;
        }
        gamehologram.initDuel();
        this.field_70170_p.func_72838_d((Entity)gamehologram);
        this.spawnPositions.clear();
        this.contenders.clear();
    }

    @Override
    protected AABB getArenaAABB() {
        return ContestCoordinates.duelArenaAABB();
    }

    @Override
    protected AABB getLobbyAABB() {
        return ContestCoordinates.duelLobbyAABB();
    }
}

