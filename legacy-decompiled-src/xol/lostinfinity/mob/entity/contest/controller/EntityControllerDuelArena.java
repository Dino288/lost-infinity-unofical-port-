/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.block.state.BlockState
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.item.ItemEntity
 *  net.minecraft.entity.item.ItemEntityFrame
 *  net.minecraft.entity.player.Player
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.math.AABB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.world.World
 */
package xol.lostinfinity.mob.entity.contest.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.entity.item.ItemEntityFrame;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.AABB;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.BlockInit;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.mob.entity.contest.controller.EntityControllerBase;
import xol.lostinfinity.projectile.entity.EntityFountainPellet;
import xol.lostinfinity.util.coordinates.ContestCoordinates;

public class EntityControllerDuelArena
extends EntityControllerBase {
    private ArrayList<BlockPos> heatTraps = null;
    private ArrayList<BlockPos> fountainTraps = null;
    private HashMap<UUID, Integer> playerHits = null;
    private static final int maxHits = 30;

    public void initDuel() {
        this.playerHits = new HashMap();
        this.heatTraps = new ArrayList();
        this.fountainTraps = new ArrayList();
        for (UUID pl_id : this.getPlayerList()) {
            this.playerHits.put(pl_id, 0);
        }
        AABB arena = this.getArenaAABB();
        for (int i = (int)arena.field_72340_a; i <= (int)arena.field_72336_d; ++i) {
            for (int k = (int)arena.field_72339_c; k <= (int)arena.field_72334_f; ++k) {
                BlockPos check = new BlockPos((double)i, arena.field_72338_b, (double)k);
                Block block = this.field_70170_p.func_180495_p(check).func_177230_c();
                if (block.equals(BlockInit.championHeatTrap)) {
                    this.heatTraps.add(check);
                    continue;
                }
                if (!block.equals(BlockInit.championFountainTrap)) continue;
                this.fountainTraps.add(check);
            }
        }
    }

    public void hitPlayer(Player player, int numHits) {
        UUID pl_id = player.func_110124_au();
        int hits = 0;
        if (this.playerHits == null) {
            return;
        }
        if (this.playerHits.containsKey(pl_id)) {
            hits = this.playerHits.get(pl_id) + numHits;
            if (hits > 30) {
                hits = 30;
            }
            this.playerHits.replace(pl_id, hits);
        }
        this.messageContenders(TextFmt.Red, String.format("%s is at %d hits", player.func_70005_c_(), hits));
    }

    public EntityControllerDuelArena(Level worldIn) {
        super(worldIn);
        this.func_70105_a(5.0f, 12.0f);
    }

    @Override
    public AABB getArenaAABB() {
        return ContestCoordinates.duelArenaAABB();
    }

    @Override
    public void func_70636_d() {
        super.func_70636_d();
        if (!this.field_70170_p.field_72995_K) {
            ItemEntity sword;
            BlockPos spawn;
            if (this.field_70173_aa == 1200) {
                this.messageContenders(TextFmt.Red, "A more powerful sword awaits at your spawn point!");
                spawn = new BlockPos(99, 33, 256);
                sword = new ItemEntity(this.field_70170_p, (double)spawn.func_177958_n(), (double)spawn.func_177956_o() + 0.4, (double)spawn.func_177952_p(), new ItemStack(ItemInit.duelingSwordSharp));
                sword.field_70159_w = 0.0;
                sword.field_70181_x = 0.0;
                sword.field_70179_y = 0.0;
                this.field_70170_p.func_72838_d((Entity)sword);
            }
            if (this.field_70173_aa == 2400) {
                this.messageContenders(TextFmt.Dark_Red, "THE MOST POWERFUL DUELING WEAPONS HAVE ARRIVED AT YOUR SPAWNS!");
                spawn = new BlockPos(155, 33, 256);
                sword = new ItemEntity(this.field_70170_p, (double)spawn.func_177958_n(), (double)spawn.func_177956_o() + 0.4, (double)spawn.func_177952_p(), new ItemStack(ItemInit.duelingSwordRazorEdged));
                sword.field_70159_w = 0.0;
                sword.field_70181_x = 0.0;
                sword.field_70179_y = 0.0;
                this.field_70170_p.func_72838_d((Entity)sword);
            }
            if (this.field_70173_aa > 2 && this.playerHits == null || this.contenderCount < 2) {
                this.func_70106_y();
            }
            List inAABB = this.field_70170_p.func_72872_a(Player.class, this.getArenaAABB());
            ArrayList<UUID> toRemove = new ArrayList<UUID>();
            for (UUID pl_id : this.getPlayerList()) {
                if (!this.playerHits.containsKey(pl_id) || this.playerHits.get(pl_id) < 30) continue;
                toRemove.add(pl_id);
            }
            this.removeMultiplePlayers(toRemove);
            for (Player near_pl : inAABB) {
                BlockPos playerPos;
                BlockState state;
                Block block;
                near_pl.field_70143_R = -1.0f;
                near_pl.func_70691_i(2.0f);
                if (near_pl.field_71075_bZ.field_75100_b) {
                    this.removePlayer(near_pl);
                }
                if ((block = (state = this.field_70170_p.func_180495_p(playerPos = near_pl.func_180425_c().func_177977_b())).func_177230_c()).equals(BlockInit.championLauncher)) {
                    if ((double)playerPos.func_177958_n() < (this.getArenaAABB().field_72336_d + this.getArenaAABB().field_72340_a) / 2.0) {
                        near_pl.func_70024_g(200.0, 1.0, 0.0);
                    } else {
                        near_pl.func_70024_g(-200.0, 1.0, 0.0);
                    }
                    near_pl.field_70133_I = true;
                    continue;
                }
                if (!block.equals(BlockInit.championHeatTrap) || this.field_70173_aa % 20 != 0 || !state.equals(BlockInit.championHeatTrap.func_176203_a(1))) continue;
                this.hitPlayer(near_pl, 2);
            }
            if (this.field_70173_aa % 200 >= 100 && this.field_70173_aa % 3 == 0) {
                for (BlockPos pos : this.fountainTraps) {
                    EntityFountainPellet shot = new EntityFountainPellet(this.field_70170_p);
                    shot.func_70107_b((double)pos.func_177958_n() + 0.5, pos.func_177956_o(), (double)pos.func_177952_p() + 0.5);
                    shot.func_70186_c(-0.15 + this.field_70170_p.field_73012_v.nextDouble() * 0.3, this.field_70170_p.field_73012_v.nextDouble() + 2.0, -0.15 + this.field_70170_p.field_73012_v.nextDouble() * 0.3, 1.5f, 2.0f);
                    this.field_70170_p.func_72838_d((Entity)shot);
                }
            }
            if (this.field_70173_aa % 200 < 100 && this.field_70173_aa % 20 == 0) {
                for (BlockPos pos : this.heatTraps) {
                    if (this.field_70170_p.field_73012_v.nextBoolean()) {
                        this.field_70170_p.func_175656_a(pos, BlockInit.championHeatTrap.func_176203_a(1));
                        continue;
                    }
                    this.field_70170_p.func_175656_a(pos, BlockInit.championHeatTrap.func_176203_a(0));
                }
            }
        }
    }

    @Override
    protected BlockPos getSnapPos() {
        return ContestCoordinates.duelControllerPos();
    }

    @Override
    protected void rewardPlayer(Player player, int placement) {
        block6: {
            ItemEntityFrame frames;
            int reward_count;
            this.playerHits = null;
            BlockPos teleTo = ContestCoordinates.duelLobbyPos();
            player.func_70634_a((double)teleTo.func_177958_n(), (double)teleTo.func_177956_o(), (double)teleTo.func_177952_p());
            for (int i = 0; i < player.field_71071_by.func_70302_i_(); ++i) {
                if (player.field_71071_by.func_70301_a(i).func_77973_b() != ItemInit.duelingSwordDull && player.field_71071_by.func_70301_a(i).func_77973_b() != ItemInit.duelingSwordSharp && player.field_71071_by.func_70301_a(i).func_77973_b() != ItemInit.duelingSwordRazorEdged) continue;
                player.field_71071_by.func_70299_a(i, ItemStack.field_190927_a);
            }
            int n = reward_count = placement == this.contenderCount - 1 ? 1 : 0;
            if (reward_count <= 0) break block6;
            ItemStack stack1 = null;
            ItemStack stack2 = null;
            Iterator iterator = this.field_70170_p.func_72872_a(ItemEntityFrame.class, new AABB(ContestCoordinates.duelFrame1Pos())).iterator();
            if (iterator.hasNext()) {
                frames = (ItemEntityFrame)iterator.next();
                stack1 = frames.func_82335_i();
            }
            if ((iterator = this.field_70170_p.func_72872_a(ItemEntityFrame.class, new AABB(ContestCoordinates.duelFrame2Pos())).iterator()).hasNext()) {
                frames = (ItemEntityFrame)iterator.next();
                stack2 = frames.func_82335_i();
            }
            if (stack1 != null && stack2 != null) {
                player.func_191521_c(stack1.func_77946_l());
                player.func_191521_c(stack2.func_77946_l());
                iterator = this.field_70170_p.func_72872_a(ItemEntityFrame.class, new AABB(ContestCoordinates.duelFrame1Pos())).iterator();
                if (iterator.hasNext()) {
                    frames = (ItemEntityFrame)iterator.next();
                    frames.func_82334_a(ItemStack.field_190927_a);
                }
                if ((iterator = this.field_70170_p.func_72872_a(ItemEntityFrame.class, new AABB(ContestCoordinates.duelFrame2Pos())).iterator()).hasNext()) {
                    frames = (ItemEntityFrame)iterator.next();
                    frames.func_82334_a(ItemStack.field_190927_a);
                }
            }
        }
    }
}

