/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.block.state.BlockState
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.item.ItemEntity
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
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.AABB;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import xol.lostinfinity.block.misc.BlockInkable;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.mob.entity.contest.controller.EntityControllerBase;
import xol.lostinfinity.util.coordinates.ContestCoordinates;

public class EntityControllerInkBattle
extends EntityControllerBase {
    private int time = 0;
    private static final int duration = 5000;
    private List<BlockPos> spawnPositions = new ArrayList<BlockPos>();
    private HashMap<UUID, Integer> inks = new HashMap();

    public void initInkBattle(List<BlockPos> spawnPositions) {
        this.spawnPositions.clear();
        this.spawnPositions.addAll(spawnPositions);
        this.time = 0;
        AABB arena = this.getArenaAABB();
        for (BlockPos arenaPos : BlockPos.func_191532_a((int)((int)arena.field_72340_a), (int)((int)arena.field_72338_b), (int)((int)arena.field_72339_c), (int)((int)arena.field_72336_d), (int)((int)arena.field_72337_e), (int)((int)arena.field_72334_f))) {
            BlockState state;
            Block block;
            if (this.field_70170_p.func_175623_d(arenaPos) || !((block = (state = this.field_70170_p.func_180495_p(arenaPos)).func_177230_c()) instanceof BlockInkable)) continue;
            this.field_70170_p.func_175656_a(arenaPos, block.func_176203_a(0));
        }
    }

    public void inkBlock(UUID id, BlockPos pos) {
        if (this.inks != null && this.inks.containsKey(id)) {
            int ink = this.inks.get(id);
            BlockState state = this.field_70170_p.func_180495_p(pos);
            Block block = state.func_177230_c();
            if (block instanceof BlockInkable) {
                this.field_70170_p.func_175656_a(pos, block.func_176203_a(ink));
            }
        }
    }

    public EntityControllerInkBattle(Level worldIn) {
        super(worldIn);
        this.func_70105_a(5.0f, 12.0f);
    }

    @Override
    public AABB getArenaAABB() {
        return ContestCoordinates.inkBattleArenaAABB();
    }

    @Override
    public void func_70636_d() {
        super.func_70636_d();
        if (!this.field_70170_p.field_72995_K) {
            if (this.field_70173_aa > 2 && this.inks == null) {
                this.func_70106_y();
            }
            AABB arena = this.getArenaAABB();
            if (this.field_70173_aa % 400 == 0) {
                for (BlockPos pos : this.getPowerupPostions()) {
                    ItemEntity item;
                    if (this.field_70146_Z.nextInt(4) != 0) continue;
                    if (this.field_70146_Z.nextBoolean()) {
                        item = new ItemEntity(this.field_70170_p, (double)pos.func_177958_n(), (double)(pos.func_177956_o() + 2), (double)pos.func_177952_p(), new ItemStack(ItemInit.inkBomb));
                        item.field_70159_w = 0.0;
                        item.field_70181_x = 0.0;
                        item.field_70179_y = 0.0;
                        this.field_70170_p.func_72838_d((Entity)item);
                        continue;
                    }
                    item = new ItemEntity(this.field_70170_p, (double)pos.func_177958_n(), (double)(pos.func_177956_o() + 2), (double)pos.func_177952_p(), new ItemStack(ItemInit.inkShotgun));
                    item.field_70159_w = 0.0;
                    item.field_70181_x = 0.0;
                    item.field_70179_y = 0.0;
                    this.field_70170_p.func_72838_d((Entity)item);
                }
                this.messageContenders(TextFmt.Green, "Powerful Items Have Spawned Around The Arena!");
            }
            ++this.time;
            if (this.time >= 5000) {
                int numToRemove = this.getPlayerList().size() - 1;
                HashMap<UUID, Integer> playerScores = new HashMap<UUID, Integer>();
                ArrayList<BlockPos> inkables = new ArrayList<BlockPos>();
                for (BlockPos arenaPos : BlockPos.func_191532_a((int)((int)arena.field_72340_a), (int)((int)arena.field_72338_b), (int)((int)arena.field_72339_c), (int)((int)arena.field_72336_d), (int)((int)arena.field_72337_e), (int)((int)arena.field_72334_f))) {
                    BlockState state;
                    Block block;
                    if (this.field_70170_p.func_175623_d(arenaPos) || !((block = (state = this.field_70170_p.func_180495_p(arenaPos)).func_177230_c()) instanceof BlockInkable)) continue;
                    inkables.add(arenaPos);
                }
                for (UUID pl_id : this.getPlayerList()) {
                    int score = 0;
                    if (this.inks != null && this.inks.containsKey(pl_id)) {
                        int ink = this.inks.get(pl_id);
                        for (BlockPos inkable : inkables) {
                            BlockState state = this.field_70170_p.func_180495_p(inkable);
                            Block block = state.func_177230_c();
                            int meta = block.func_176201_c(state);
                            if (meta != ink) continue;
                            ++score;
                        }
                    }
                    playerScores.put(pl_id, score);
                }
                for (int i = 0; i < numToRemove; ++i) {
                    int min = 1000;
                    UUID remove = null;
                    for (UUID pl_id : this.getPlayerList()) {
                        if ((Integer)playerScores.get(pl_id) >= min) continue;
                        min = (Integer)playerScores.get(pl_id);
                        remove = pl_id;
                    }
                    if (remove == null) continue;
                    this.removePlayerByUUID(remove);
                }
            }
        }
    }

    private ArrayList<BlockPos> getPowerupPostions() {
        return ContestCoordinates.inkBattlePowerUpPositions();
    }

    public void inkPlayer(Player target) {
        if (this.spawnPositions != null && !this.spawnPositions.isEmpty()) {
            int randSpawn = this.field_70146_Z.nextInt(this.spawnPositions.size());
            BlockPos spawn = this.spawnPositions.get(randSpawn);
            target.func_70634_a((double)spawn.func_177958_n(), (double)spawn.func_177956_o(), (double)spawn.func_177952_p());
        }
    }

    @Override
    protected BlockPos getSnapPos() {
        return ContestCoordinates.inkBattleControllerPos();
    }

    @Override
    protected void rewardPlayer(Player player, int placement) {
        BlockPos teleTo = ContestCoordinates.inkBattleLobbyPos();
        player.func_70634_a((double)teleTo.func_177958_n(), (double)teleTo.func_177956_o(), (double)teleTo.func_177952_p());
        for (int i = 0; i < player.field_71071_by.func_70302_i_(); ++i) {
            if (player.field_71071_by.func_70301_a(i).func_77973_b() != ItemInit.inkGun && player.field_71071_by.func_70301_a(i).func_77973_b() != ItemInit.inkShotgun && player.field_71071_by.func_70301_a(i).func_77973_b() != ItemInit.inkBomb) continue;
            player.field_71071_by.func_70299_a(i, ItemStack.field_190927_a);
        }
        int reward_count = Math.min(10 + 20 * placement + (placement == this.contenderCount - 1 ? this.contenderCount * 10 : 0), 50);
        player.func_191521_c(new ItemStack(ItemInit.zirconiaIvory, reward_count));
    }

    public void setInk(UUID pl_id, int i) {
        if (this.inks != null) {
            this.inks.put(pl_id, i);
        }
    }
}

