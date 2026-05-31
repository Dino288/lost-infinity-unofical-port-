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

import java.util.List;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.AABB;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.mob.entity.contest.controller.EntityControllerBase;
import xol.lostinfinity.mob.entity.contest.misc.EntityTreadmillObstacle;
import xol.lostinfinity.mob.entity.contest.misc.EntityTreadmillObstacleJumpable;
import xol.lostinfinity.util.coordinates.ContestCoordinates;

public class EntityControllerTreadmill
extends EntityControllerBase {
    private static final int treadHeight = 45;

    public EntityControllerTreadmill(Level worldIn) {
        super(worldIn);
        this.func_70105_a(5.0f, 12.0f);
    }

    @Override
    protected AABB getArenaAABB() {
        return ContestCoordinates.treadmillArenaAABB();
    }

    @Override
    protected BlockPos getSnapPos() {
        return ContestCoordinates.treadmillControllerPos();
    }

    @Override
    public void func_70636_d() {
        super.func_70636_d();
        if (!this.field_70170_p.field_72995_K) {
            AABB treadmillBB = ContestCoordinates.treadmillGridAABB();
            int maxX = (int)treadmillBB.field_72336_d;
            int minZ = (int)treadmillBB.field_72339_c + 1;
            int maxZ = (int)treadmillBB.field_72334_f - 1;
            int y = 46;
            int count = 0;
            if (this.field_70173_aa % 40 == 0) {
                for (int i = minZ; i <= maxZ; ++i) {
                    EntityTreadmillObstacle obs;
                    BlockPos obsPos = new BlockPos(maxX, y, i);
                    if (count >= 6 || this.field_70146_Z.nextInt(3) != 0) continue;
                    ++count;
                    if (this.field_70146_Z.nextBoolean()) {
                        obs = new EntityTreadmillObstacle(this.field_70170_p);
                        obs.setVisual(this.field_70146_Z.nextInt(5) + 1);
                        obs.setSpeed(0.2f + this.field_70146_Z.nextFloat() * 0.1f);
                        obs.func_70634_a((double)obsPos.func_177958_n() - 0.5, obsPos.func_177956_o(), (double)obsPos.func_177952_p() + 0.5);
                        this.field_70170_p.func_72838_d((Entity)obs);
                        continue;
                    }
                    obs = new EntityTreadmillObstacleJumpable(this.field_70170_p);
                    obs.setVisual(this.field_70146_Z.nextInt(5) + 1);
                    obs.setSpeed(0.2f + this.field_70146_Z.nextFloat() * 0.1f);
                    obs.func_70634_a((double)obsPos.func_177958_n() - 0.5, obsPos.func_177956_o(), (double)obsPos.func_177952_p() + 0.5);
                    this.field_70170_p.func_72838_d((Entity)obs);
                }
            }
            List inObstacles = this.field_70170_p.func_72872_a(EntityTreadmillObstacle.class, treadmillBB);
            List arenaPlayers = this.field_70170_p.func_72872_a(Player.class, this.getArenaAABB());
            List inPlayers = this.field_70170_p.func_72872_a(Player.class, treadmillBB);
            for (Player player : arenaPlayers) {
                if (!inPlayers.contains(player)) {
                    this.removePlayer(player);
                    continue;
                }
                if (!player.field_71075_bZ.field_75100_b) continue;
                this.removePlayer(player);
            }
        }
    }

    @Override
    protected void rewardPlayer(Player player, int placement) {
        BlockPos teleTo = ContestCoordinates.treadmillLobbyPos();
        player.func_70634_a((double)teleTo.func_177958_n(), (double)teleTo.func_177956_o(), (double)teleTo.func_177952_p());
        int reward_count = 10 + 20 * placement + (placement == this.contenderCount - 1 ? this.contenderCount * 10 : 0);
        player.func_191521_c(new ItemStack(ItemInit.zirconiaMythic, reward_count));
    }
}

