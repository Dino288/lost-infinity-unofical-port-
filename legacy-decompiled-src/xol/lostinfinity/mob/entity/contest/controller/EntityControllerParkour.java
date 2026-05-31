/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.block.state.BlockState
 *  net.minecraft.entity.player.Player
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.math.AABB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.world.World
 */
package xol.lostinfinity.mob.entity.contest.controller;

import java.util.List;
import java.util.UUID;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.AABB;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.BlockInit;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.mob.entity.contest.controller.EntityControllerBase;
import xol.lostinfinity.mob.entity.contest.operator.EntityOperatorParkour;
import xol.lostinfinity.util.coordinates.ContestCoordinates;

public class EntityControllerParkour
extends EntityControllerBase {
    private int stage = 1;
    private static final int maxStage = 5;
    private int fails = 0;
    private boolean game = false;

    public EntityControllerParkour(Level worldIn) {
        super(worldIn);
        this.func_70105_a(5.0f, 12.0f);
    }

    @Override
    protected AABB getArenaAABB() {
        return ContestCoordinates.parkourArenaAABB();
    }

    @Override
    protected BlockPos getSnapPos() {
        return ContestCoordinates.parkourControllerPos();
    }

    @Override
    public void registerTouch(Player player) {
        if (!this.field_70170_p.field_72995_K && this.game) {
            if (this.stage < 5) {
                BlockPos spawn = ContestCoordinates.parkourSpawnPos();
                player.func_70634_a((double)spawn.func_177958_n(), (double)spawn.func_177956_o(), (double)spawn.func_177952_p());
                this.stageUp();
            } else {
                this.endGame();
            }
        }
    }

    private void stageUp() {
        ++this.stage;
        this.soundContenders(SoundInit.GENERIC_UI_1, 1.0f, 1.0f);
        this.messageContenders(TextFmt.Green, String.format("Stage %d begins!", this.stage));
        EntityOperatorParkour.genParkour(this.field_70170_p, this.stage);
    }

    @Override
    public void func_70636_d() {
        super.func_70636_d();
        this.field_70177_z = 90.0f;
        if (!this.field_70170_p.field_72995_K && this.game) {
            List inAABB = this.field_70170_p.func_72872_a(Player.class, ContestCoordinates.parkourArenaAABB());
            BlockPos spawn = ContestCoordinates.parkourSpawnPos();
            for (UUID playerID : this.getPlayerList()) {
                Player player = this.field_70170_p.func_152378_a(playerID);
                if (player == null || inAABB.contains(this.field_70170_p.func_152378_a(playerID))) continue;
                player.func_70634_a((double)spawn.func_177958_n(), (double)spawn.func_177956_o(), (double)spawn.func_177952_p());
                this.messageContenders(TextFmt.Green, "Stage failed! Try again.");
                ++this.fails;
            }
            for (Player near_pl : inAABB) {
                int meta;
                BlockPos playerPos;
                BlockState state;
                Block block;
                if (near_pl.field_71075_bZ.field_75100_b) {
                    this.messageContenders(TextFmt.Dark_Red, String.format("%s was removed for trying to fly away", near_pl.func_70005_c_()));
                    this.removePlayer(near_pl);
                }
                if (!(block = (state = this.field_70170_p.func_180495_p(playerPos = near_pl.func_180425_c().func_177977_b())).func_177230_c()).equals(BlockInit.parkourPlatform) || (meta = block.func_176201_c(state)) != 0) continue;
                near_pl.func_70024_g(0.0, 0.6, 0.0);
                near_pl.field_70133_I = true;
            }
            if (this.field_70173_aa % 40 == 10) {
                AABB parkourGrid = ContestCoordinates.parkourGridAABB();
                for (BlockPos pos : BlockPos.func_191532_a((int)((int)Math.round(parkourGrid.field_72340_a)), (int)((int)Math.round(parkourGrid.field_72338_b)), (int)((int)Math.round(parkourGrid.field_72339_c)), (int)((int)Math.round(parkourGrid.field_72336_d)), (int)((int)Math.round(parkourGrid.field_72337_e)), (int)((int)Math.round(parkourGrid.field_72334_f)))) {
                    if (this.field_70170_p.func_180495_p(pos).equals(BlockInit.parkourPlatform.func_176203_a(2))) {
                        this.field_70170_p.func_175656_a(pos, BlockInit.parkourPlatform.func_176203_a(1));
                        continue;
                    }
                    if (!this.field_70170_p.func_180495_p(pos).equals(BlockInit.parkourPlatform.func_176203_a(1))) continue;
                    this.field_70170_p.func_175656_a(pos, BlockInit.parkourPlatform.func_176203_a(2));
                }
            }
        }
    }

    @Override
    protected void endGame() {
        this.game = false;
        if (this.getPlayerList().size() == 1) {
            Player playerEntity = this.field_70170_p.func_152378_a(this.getPlayerList().get(0));
            this.messageContenders(TextFmt.Green, "Course completed!");
            this.rewardPlayer(playerEntity, 2);
        }
        this.func_70106_y();
    }

    @Override
    protected void playerStatusCheck() {
    }

    @Override
    protected void rewardPlayer(Player player, int placement) {
        BlockPos teleTo = ContestCoordinates.parkourLobbyPos();
        player.func_70634_a((double)teleTo.func_177958_n(), (double)teleTo.func_177956_o(), (double)teleTo.func_177952_p());
        int reward_count = placement != 2 ? 0 : Math.max(150 - this.fails, 30);
        player.func_191521_c(new ItemStack(ItemInit.zirconiaMusky, reward_count));
    }

    public void startGame() {
        this.game = true;
        this.fails = 0;
        this.stage = 1;
        this.soundContenders(SoundInit.GENERIC_UI_1, 1.0f, 1.0f);
        this.messageContenders(TextFmt.Green, "Stage 1 begins! Leap across to the other side to prove your agility!");
    }
}

