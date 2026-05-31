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
import java.util.Iterator;
import java.util.Random;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.AABB;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import xol.lostinfinity.block.misc.BlockTarget;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.dimension.data.TargetNode;
import xol.lostinfinity.init.BlockInit;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.mob.entity.contest.controller.EntityControllerBase;
import xol.lostinfinity.util.coordinates.ContestCoordinates;

public class EntityControllerTargets
extends EntityControllerBase {
    private static int stageLength = 400;
    private int stageTimer = 0;
    private static int betweenRoundLength = 80;
    private int betweenTimer = betweenRoundLength;
    private ArrayList<BlockPos> targetPositions = null;
    private ArrayList<TargetNode> roundTargets = null;
    private ArrayList<TargetNode> activeTargets = null;
    private boolean game = false;
    private int score = 0;

    public EntityControllerTargets(Level worldIn) {
        super(worldIn);
        this.func_70105_a(5.0f, 12.0f);
        this.roundTargets = new ArrayList();
        this.targetPositions = new ArrayList();
        this.activeTargets = new ArrayList();
    }

    @Override
    protected AABB getArenaAABB() {
        return ContestCoordinates.targetsArenaAABB();
    }

    @Override
    protected BlockPos getSnapPos() {
        return ContestCoordinates.targetsControllerPos();
    }

    @Override
    public void func_70636_d() {
        super.func_70636_d();
        if (!this.field_70170_p.field_72995_K) {
            if (this.field_70173_aa % 3 == 0 && this.targetPositions == null) {
                this.func_70106_y();
            } else if (this.stage == 0 && !this.game && !this.targetPositions.isEmpty()) {
                this.setUpRoundTargets();
                this.game = true;
                this.score = 0;
            } else if (this.stageTimer == 0) {
                if (this.betweenTimer != 0 && this.stage != 4) {
                    --this.betweenTimer;
                    this.betweenStage();
                } else {
                    this.betweenTimer = betweenRoundLength;
                    this.upStage();
                }
                if (this.stage == 5 && this.game) {
                    this.endGame();
                } else {
                    this.setUpRoundTargets();
                }
            } else {
                --this.stageTimer;
                this.toggleTargets();
            }
        }
    }

    private void betweenStage() {
        if (this.betweenTimer == betweenRoundLength - 1) {
            this.resetTargets();
            this.messageContenders(TextFmt.Green, String.format("ROUND %d STARTING IN", this.stage + 1));
        } else if (this.betweenTimer % 20 == 0) {
            this.messageContenders(TextFmt.Green, String.format("%d", this.betweenTimer / 20));
        }
    }

    @Override
    protected void endGame() {
        Player playerEntity;
        this.game = false;
        for (BlockPos target : this.targetPositions) {
            this.field_70170_p.func_175656_a(target, ((BlockTarget)BlockInit.target).getInactiveState());
        }
        if (this.score > 90) {
            this.messageContenders(TextFmt.Green, "You have reached a high enough score!");
            playerEntity = null;
            BlockPos pos = this.func_180425_c();
            Iterator iterator = this.field_70170_p.func_72872_a(Player.class, this.getArenaAABB()).iterator();
            if (iterator.hasNext()) {
                Player player;
                playerEntity = player = (Player)iterator.next();
            }
            int placement = (this.score * 10 - 900) / 100 + 1;
            if (playerEntity != null) {
                this.rewardPlayer(playerEntity, placement);
            }
        } else {
            playerEntity = this.field_70170_p.func_152378_a(this.getPlayerList().get(0));
            this.rewardPlayer(playerEntity, 0);
            this.messageContenders(TextFmt.Green, "You have failed to reach a high enough score.");
        }
        this.func_70106_y();
    }

    public void scoreTarget(BlockPos pos) {
        if (this.stageTimer == 0) {
            return;
        }
        ArrayList<TargetNode> scored = new ArrayList<TargetNode>();
        int scoreToAdd = 0;
        for (TargetNode activeTarget : this.activeTargets) {
            int timeDiff;
            if (!activeTarget.getPos().equals((Object)pos) || (timeDiff = activeTarget.getTiming() - this.stageTimer) <= 0) continue;
            double ratio = (double)timeDiff / (double)activeTarget.getDuration();
            scoreToAdd = ratio < 0.4 ? 3 : (ratio < 0.7 ? 2 : 1);
            scored.add(activeTarget);
            this.soundContenders(SoundInit.MINIGAME_SCORE, 1.0f, 0.8f + this.field_70146_Z.nextFloat() * 0.4f);
            break;
        }
        this.field_70170_p.func_175656_a(pos, ((BlockTarget)BlockInit.target).getInactiveState());
        this.score += scoreToAdd;
        for (TargetNode scoredTarget : scored) {
            this.activeTargets.remove(scoredTarget);
            this.setGraceTimer(scoredTarget);
        }
        if (scoreToAdd > 0) {
            this.scoreMessage();
        }
    }

    private void setGraceTimer(TargetNode activeTarget) {
        ArrayList<TargetNode> toRemove = new ArrayList<TargetNode>();
        BlockPos pos = activeTarget.getPos();
        for (TargetNode node : this.activeTargets) {
            if (!node.getPos().equals((Object)pos) || node.equals(activeTarget)) continue;
            if (this.stageTimer - 30 > 0) {
                node.setTiming(this.stageTimer - 30);
            } else {
                this.roundTargets.remove(node);
            }
            toRemove.add(node);
        }
        for (TargetNode node : toRemove) {
            this.activeTargets.remove(node);
        }
    }

    @Override
    protected void playerStatusCheck() {
    }

    private void toggleTargets() {
        if (this.roundTargets != null && !this.roundTargets.isEmpty()) {
            for (TargetNode roundTarget : this.roundTargets) {
                if (this.stageTimer != roundTarget.getTiming()) continue;
                this.activeTargets.add(roundTarget);
                this.field_70170_p.func_175656_a(roundTarget.getPos(), ((BlockTarget)BlockInit.target).getActiveState());
            }
        }
        if (this.activeTargets != null && !this.activeTargets.isEmpty()) {
            ArrayList<TargetNode> inactive = new ArrayList<TargetNode>();
            for (TargetNode activeTarget : this.activeTargets) {
                if (this.stageTimer > activeTarget.getEndTime()) continue;
                inactive.add(activeTarget);
            }
            for (TargetNode inactiveTarget : inactive) {
                this.activeTargets.remove(inactiveTarget);
                this.field_70170_p.func_175656_a(inactiveTarget.getPos(), ((BlockTarget)BlockInit.target).getInactiveState());
            }
        }
    }

    private void scoreMessage() {
        this.messageContenders(TextFmt.Green, String.format("SCORE : %d", this.score));
    }

    private void upStage() {
        ++this.stage;
        this.stageTimer = stageLength;
        this.resetTargets();
    }

    private void resetTargets() {
        for (BlockPos pos : this.targetPositions) {
            this.field_70170_p.func_175656_a(pos, ((BlockTarget)BlockInit.target).getInactiveState());
        }
    }

    public void setTargetPositions(Level worldIn) {
        AABB arena = ContestCoordinates.targetsArenaAABB();
        for (int i = (int)arena.field_72340_a; i <= (int)arena.field_72336_d; ++i) {
            for (int j = (int)arena.field_72338_b; j <= (int)arena.field_72337_e; ++j) {
                for (int k = (int)arena.field_72339_c; k <= (int)arena.field_72334_f; ++k) {
                    BlockPos ref = new BlockPos(i, j, k);
                    if (!(this.field_70170_p.func_180495_p(ref).func_177230_c() instanceof BlockTarget)) continue;
                    this.targetPositions.add(ref);
                    this.field_70170_p.func_175656_a(ref, ((BlockTarget)BlockInit.target).getInactiveState());
                }
            }
        }
    }

    public void setUpRoundTargets() {
        if (this.targetPositions.isEmpty()) {
            return;
        }
        int roundTargets = 0;
        int minDuration = 0;
        int maxDuration = 0;
        switch (this.stage) {
            case 0: {
                roundTargets = 40;
                minDuration = 80;
                maxDuration = 100;
            }
            case 1: {
                roundTargets = 40;
                minDuration = 60;
                maxDuration = 80;
            }
            case 2: {
                roundTargets = 40;
                minDuration = 55;
                maxDuration = 70;
            }
            case 3: {
                roundTargets = 40;
                minDuration = 50;
                maxDuration = 65;
            }
            case 4: {
                roundTargets = 40;
                minDuration = 45;
                maxDuration = 55;
            }
        }
        Random rand = new Random();
        this.roundTargets.clear();
        for (int i = 0; i < roundTargets; ++i) {
            int randTarget = rand.nextInt(this.targetPositions.size());
            int randDuration = rand.nextInt(maxDuration - minDuration) + minDuration;
            int randTiming = rand.nextInt(stageLength - randDuration) + randDuration;
            TargetNode node = new TargetNode(this.targetPositions.get(randTarget), randTiming, randDuration);
            this.roundTargets.add(node);
        }
    }

    @Override
    protected void rewardPlayer(Player player, int placement) {
        for (int i = 0; i < player.field_71071_by.func_70302_i_(); ++i) {
            if (player.field_71071_by.func_70301_a(i).func_77973_b() != ItemInit.spaceZapper) continue;
            player.field_71071_by.func_70299_a(i, ItemStack.field_190927_a);
        }
        BlockPos teleTo = ContestCoordinates.targetsLobbyPos();
        player.func_70634_a((double)teleTo.func_177958_n(), (double)teleTo.func_177956_o(), (double)teleTo.func_177952_p());
        int reward_count = placement * 10;
        player.func_191521_c(new ItemStack(ItemInit.zirconiaRosewood, reward_count));
    }
}

