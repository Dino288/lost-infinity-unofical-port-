/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.player.Player
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.math.AABB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Vec3i
 *  net.minecraft.world.World
 */
package xol.lostinfinity.mob.entity.contest.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.AABB;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Vec3i;
import net.minecraft.world.level.Level;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.dimension.data.LightBridgeNode;
import xol.lostinfinity.init.BlockInit;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.mob.entity.contest.controller.EntityControllerBase;
import xol.lostinfinity.util.coordinates.ContestCoordinates;

public class EntityControllerLightBridge
extends EntityControllerBase {
    private Vec3i dirRight = new Vec3i(0, 0, 1);
    private Vec3i dirUp = new Vec3i(1, 0, 0);
    private LightBridgeNode[][] bridgeMap;
    private ArrayList<LightBridgeNode> previewBridge = new ArrayList();
    private boolean game = false;
    private BlockPos ref = new BlockPos(0, 0, 0);
    private HashMap<UUID, BlockPos> respawnPositions;

    public EntityControllerLightBridge(Level worldIn) {
        super(worldIn);
        this.func_70105_a(5.0f, 12.0f);
    }

    @Override
    public AABB getArenaAABB() {
        return ContestCoordinates.lightBridgeArenaAABB();
    }

    @Override
    public void func_70636_d() {
        super.func_70636_d();
        if (!this.field_70170_p.field_72995_K) {
            LightBridgeNode node;
            if (this.field_70173_aa % 40 == 20 && this.bridgeMap != null) {
                this.previewBridge.clear();
                Random rand = new Random();
                int randCol = rand.nextInt(this.bridgeMap.length - 8);
                int randRow = rand.nextInt(this.bridgeMap[randCol].length - 8);
                for (int c = 0; c < 8; ++c) {
                    for (int r = 0; r < 8; ++r) {
                        node = this.getNodeAtLocation(randCol + c, randRow + r);
                        if (!node.isLit()) continue;
                        this.previewBridge.add(node);
                        this.field_70170_p.func_175656_a(this.getBridgeNodePos(node), BlockInit.lightBridge.func_176203_a(1));
                    }
                }
            }
            if (this.field_70173_aa % 40 == 0) {
                this.previewBridge.clear();
            }
            if (this.bridgeMap != null) {
                for (int i = 0; i < this.bridgeMap.length; ++i) {
                    for (int j = 0; j < this.bridgeMap[0].length; ++j) {
                        if (this.previewBridge.contains(this.getNodeAtLocation(i, j))) continue;
                        this.field_70170_p.func_175656_a(this.getBridgeNodePos(this.getNodeAtLocation(i, j)), BlockInit.lightBridge.func_176203_a(0));
                    }
                }
            }
            List inAABB = this.field_70170_p.func_72872_a(Player.class, this.getArenaAABB());
            for (UUID playerID : this.getPlayerList()) {
                if (inAABB.contains(this.field_70170_p.func_152378_a(playerID))) continue;
                this.respawn(playerID);
            }
            for (Player near_pl : inAABB) {
                int y;
                int x;
                if (near_pl.field_71075_bZ.field_75100_b) {
                    this.removePlayer(near_pl);
                }
                if (!this.getPlayerList().contains(near_pl.func_110124_au()) || (node = this.getNodeAtLocation(x = this.getBridgeX(near_pl), y = this.getBridgeY(near_pl))) == null || !node.isLit()) continue;
                this.field_70170_p.func_175656_a(this.getBridgeNodePos(node), BlockInit.lightBridge.func_176203_a(1));
            }
        }
    }

    @Override
    public void registerTouch(Player player) {
        ArrayList<UUID> toRemove = new ArrayList<UUID>();
        for (UUID pl_id : this.getPlayerList()) {
            if (pl_id.equals(player.func_110124_au())) continue;
            toRemove.add(pl_id);
        }
        this.removeMultiplePlayers(toRemove);
    }

    private int getBridgeX(Player player) {
        return player.func_180425_c().func_177952_p() - this.ref.func_177952_p();
    }

    private int getBridgeY(Player player) {
        return player.func_180425_c().func_177958_n() - this.ref.func_177958_n();
    }

    @Override
    protected void playerStatusCheck() {
        boolean end_flag = false;
        if (this.getPlayerList().isEmpty()) {
            end_flag = true;
        }
        if (!end_flag && this.getPlayerList().size() == 1) {
            Player winner = this.field_70170_p.func_152378_a(this.getPlayerList().get(0));
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

    private void respawn(UUID pl_id) {
        if (this.respawnPositions.get(pl_id) != null) {
            BlockPos respawnPos = this.respawnPositions.get(pl_id);
            this.field_70170_p.func_152378_a(pl_id).func_70634_a((double)respawnPos.func_177958_n(), (double)respawnPos.func_177956_o(), (double)respawnPos.func_177952_p());
            this.messageContenders(TextFmt.Red, String.format("%s has fallen", this.field_70170_p.func_152378_a(pl_id).func_70005_c_()));
        }
    }

    @Override
    protected BlockPos getSnapPos() {
        return ContestCoordinates.lightBridgeControllerPos();
    }

    @Override
    protected void rewardPlayer(Player player, int placement) {
        BlockPos teleTo = ContestCoordinates.lightBridgeLobbyPos();
        player.func_70634_a((double)teleTo.func_177958_n(), (double)teleTo.func_177956_o(), (double)teleTo.func_177952_p());
        int reward_count = placement == this.contenderCount - 1 ? 20 * this.contenderCount : 0;
        player.func_191521_c(new ItemStack(ItemInit.zirconiaOyster, reward_count));
    }

    public void setBridgePositions(BlockPos ref, int columns, int rows, Level worldIn) {
        this.bridgeMap = new LightBridgeNode[columns][rows];
        this.ref = ref;
        for (int c = 0; c < columns; ++c) {
            for (int r = 0; r < rows; ++r) {
                BlockPos pos = ref.func_177982_a(this.dirRight.func_177958_n() * c + this.dirUp.func_177958_n() * r, 0, this.dirRight.func_177952_p() * c + this.dirUp.func_177952_p() * r);
                worldIn.func_175656_a(pos, BlockInit.lightBridge.func_176203_a(0));
                this.bridgeMap[c][r] = new LightBridgeNode(c, r, false);
            }
        }
        Random rand = new Random();
        int randCol = rand.nextInt(this.bridgeMap.length);
        ArrayList<LightBridgeNode> bridge = this.getNodeAtLocation(randCol, 0).getPathToNode(this.bridgeMap, null, rows - 1);
        while (bridge == null) {
            randCol = rand.nextInt(this.bridgeMap.length);
            bridge = this.getNodeAtLocation(randCol, 0).getPathToNode(this.bridgeMap, null, rows - 1);
        }
        if (bridge != null) {
            for (LightBridgeNode bridgeNode : bridge) {
                bridgeNode.setLit(true);
            }
        }
    }

    private BlockPos getBridgeNodePos(LightBridgeNode bridgeNode) {
        return this.ref.func_177982_a(this.dirRight.func_177958_n() * bridgeNode.getX() + this.dirUp.func_177958_n() * bridgeNode.getY(), 0, this.dirRight.func_177952_p() * bridgeNode.getX() + this.dirUp.func_177952_p() * bridgeNode.getY());
    }

    private LightBridgeNode getNodeAtLocation(int x, int y) {
        if (x >= 0 && x < this.bridgeMap.length && y >= 0 && y < this.bridgeMap[x].length) {
            return this.bridgeMap[x][y];
        }
        return null;
    }

    public void setRespawns(HashMap<UUID, BlockPos> respawnPositions) {
        this.respawnPositions = respawnPositions;
    }
}

