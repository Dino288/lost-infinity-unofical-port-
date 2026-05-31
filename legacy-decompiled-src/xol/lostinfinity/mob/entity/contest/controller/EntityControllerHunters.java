/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.math.AABB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.world.World
 */
package xol.lostinfinity.mob.entity.contest.controller;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.AABB;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.DimensionInit;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.mob.entity.contest.EntityBloodhunter;
import xol.lostinfinity.mob.entity.contest.controller.EntityControllerBase;
import xol.lostinfinity.util.coordinates.ContestCoordinates;

public class EntityControllerHunters
extends EntityControllerBase {
    private int stageTimer = 200;

    public EntityControllerHunters(Level worldIn) {
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
                if (this.stageTimer == 5 && this.touchInProgress) {
                    this.removeFailedCheckIn();
                }
                --this.stageTimer;
            }
        }
    }

    private void upStage() {
        ++this.stage;
        boolean summonStage = this.field_70146_Z.nextBoolean();
        if (this.stage == 1 || this.stage == 5) {
            summonStage = true;
            if (this.stage == 5) {
                for (EntityBloodhunter hunters : this.field_70170_p.func_72872_a(EntityBloodhunter.class, this.getArenaAABB())) {
                    hunters.setRanged();
                    this.messageContenders(TextFmt.Red, "Okay contenders, the hunters now attack with spells!");
                }
            }
        }
        if (summonStage) {
            EntityBloodhunter hunter = new EntityBloodhunter(this.field_70170_p);
            BlockPos spawnPos = ContestCoordinates.huntersArenaCenterPos().func_177984_a();
            hunter.func_70107_b(spawnPos.func_177958_n(), spawnPos.func_177956_o(), spawnPos.func_177952_p());
            if (this.stage >= 5) {
                hunter.setRanged();
            }
            this.field_70170_p.func_72838_d((Entity)hunter);
            this.stageTimer = 400;
            this.messageContenders(TextFmt.Gold, "A new hunter has been released!");
        } else {
            this.stageTimer = 300;
            this.touchInProgress = true;
            this.messageContenders(TextFmt.Dark_Aqua, "Time to come out of hiding! You have 15 seconds to touch a sensor block.");
        }
    }

    @Override
    protected AABB getArenaAABB() {
        return ContestCoordinates.huntersArenaAABB();
    }

    @Override
    protected BlockPos getSnapPos() {
        return ContestCoordinates.huntersControllerPos();
    }

    @Override
    protected void rewardPlayer(Player player, int placement) {
        BlockPos teleTo = ContestCoordinates.huntersLobbyPos();
        player.func_70634_a((double)teleTo.func_177958_n(), (double)teleTo.func_177956_o(), (double)teleTo.func_177952_p());
        int reward_count = Math.min(1 + placement * this.stage + (placement == this.contenderCount - 1 ? this.contenderCount * 2 : 0), 50);
        player.func_191521_c(new ItemStack(ItemInit.zirconiaCrimson, reward_count));
    }

    @Override
    protected void endGame() {
        for (EntityBloodhunter hunter : this.field_70170_p.func_72872_a(EntityBloodhunter.class, this.getArenaAABB())) {
            hunter.func_70106_y();
        }
    }
}

