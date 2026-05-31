/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.block.state.BlockState
 *  net.minecraft.entity.Mob
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.entity.player.Player
 *  net.minecraft.init.SoundEvents
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.InteractionHand
 *  net.minecraft.util.EnumParticleTypes
 *  net.minecraft.util.SoundEvent
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Vec3i
 *  net.minecraft.util.text.Component
 *  net.minecraft.util.text.Component
 *  net.minecraft.world.World
 *  net.minecraft.world.ServerLevel
 */
package xol.lostinfinity.mob.entity.misc;

import java.util.ArrayList;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.entity.Mob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Vec3i;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.Level;
import net.minecraft.server.level.ServerLevel;
import xol.lostinfinity.block.activator.BlockPipe;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.dimension.data.MazeMap;
import xol.lostinfinity.dimension.data.MazeNode;
import xol.lostinfinity.dimension.data.PipeNode;
import xol.lostinfinity.init.ItemInit;

public class EntityPipeGameMerchant
extends Mob {
    private boolean game = false;
    private boolean win = false;
    private BlockPos ref;
    private BlockPos startPos;
    private boolean lose = false;
    private int columns;
    private int rows;
    private Vec3i dir = new Vec3i(0, 0, 0);
    private PipeNode[][] pipeMap;
    private boolean sentWinMessage = false;

    public void setGridSize(int c, int r) {
        this.columns = c;
        this.rows = r;
    }

    public EntityPipeGameMerchant(Level worldIn) {
        super(worldIn);
    }

    protected void func_70088_a() {
        super.func_70088_a();
    }

    public void startGame() {
        for (Player near_pl : this.field_70170_p.func_72872_a(Player.class, this.func_174813_aQ().func_72314_b(15.0, 15.0, 15.0))) {
            near_pl.func_145747_a((Component)new Component(TextFmt.getFormatting(TextFmt.Bold, TextFmt.Green) + "Not often I get called to Nonexistence... Quickly connect the pipe to the top right to fill the vial."));
            this.game = false;
        }
        this.game = true;
    }

    public void genPipeGame(Level worldIn, BlockPos ref) {
        if (!worldIn.field_72995_K) {
            int col = this.columns;
            int row = this.rows;
            this.pipeMap = new PipeNode[col][row];
            MazeMap maze = new MazeMap(col, row);
            for (int c = 0; c < col; ++c) {
                for (int r = 0; r < row; ++r) {
                    PipeNode node = null;
                    String type = "cross";
                    int rot = 0;
                    boolean lit = false;
                    if (c == 0 && r == 0) {
                        rot = 0;
                        lit = true;
                    } else if (c == col - 1 && r == row - 1) {
                        rot = 0;
                    } else {
                        MazeNode mazeNode = maze.getNodeAtLocation(c, r);
                        node = (mazeNode.getType().equals("path") || mazeNode.getType().equals("trigger")) && mazeNode.isVisited() ? this.getPipeNodeFromMazeNode(mazeNode, maze, c, r) : new PipeNode(c, r);
                    }
                    if (node == null) {
                        node = new PipeNode(type, rot, c, r);
                    }
                    node.setLit(lit);
                    this.pipeMap[c][r] = node;
                }
            }
            this.setPipePositions(ref);
            this.updateLit();
        }
    }

    private PipeNode getPipeNodeFromMazeNode(MazeNode mazeNode, MazeMap maze, int c, int r) {
        boolean[] cross = new boolean[]{true, true, true, true};
        boolean[] elbow = new boolean[]{true, true, false, false};
        boolean[] t = new boolean[]{true, true, true, false};
        boolean[] l = new boolean[]{true, false, true, false};
        boolean[] connected = this.getConnectedMazeNeighbours(mazeNode, maze);
        if (EntityPipeGameMerchant.matchNeighbours(connected, cross)) {
            return new PipeNode("cross", 0, c, r);
        }
        if (EntityPipeGameMerchant.matchNeighbours(connected, elbow)) {
            return new PipeNode("elbow", 0, c, r);
        }
        if (EntityPipeGameMerchant.matchNeighbours(connected, t)) {
            return new PipeNode("t", 0, c, r);
        }
        if (EntityPipeGameMerchant.matchNeighbours(connected, l)) {
            return new PipeNode("l", 0, c, r);
        }
        for (int i = 1; i <= 3; ++i) {
            if (EntityPipeGameMerchant.matchNeighbours(connected = this.getRotatedMazeNeighbours(connected), cross)) {
                return new PipeNode("cross", 4 - i, c, r);
            }
            if (EntityPipeGameMerchant.matchNeighbours(connected, elbow)) {
                return new PipeNode("elbow", 4 - i, c, r);
            }
            if (EntityPipeGameMerchant.matchNeighbours(connected, t)) {
                return new PipeNode("t", 4 - i, c, r);
            }
            if (!EntityPipeGameMerchant.matchNeighbours(connected, l)) continue;
            return new PipeNode("l", 4 - i, c, r);
        }
        return new PipeNode("l", 0, c, r);
    }

    public static boolean matchNeighbours(boolean[] neighbours1, boolean[] neighbours2) {
        for (int i = 0; i < neighbours1.length; ++i) {
            if (neighbours1[i] == neighbours2[i]) continue;
            return false;
        }
        return true;
    }

    private boolean[] getConnectedMazeNeighbours(MazeNode mazeNode, MazeMap maze) {
        MazeNode node;
        int z;
        boolean[] connected = new boolean[]{false, false, false, false};
        int x = mazeNode.getX();
        if (maze.getNodeAtLocation(x, (z = mazeNode.getZ()) + 1) != null && ((node = maze.getNodeAtLocation(x, z + 1)).getType().equals("path") || node.getType().equals("trigger")) && node.isVisited()) {
            connected[0] = true;
        }
        if (maze.getNodeAtLocation(x + 1, z) != null && ((node = maze.getNodeAtLocation(x + 1, z)).getType().equals("path") || node.getType().equals("trigger")) && node.isVisited()) {
            connected[1] = true;
        }
        if (maze.getNodeAtLocation(x, z - 1) != null && ((node = maze.getNodeAtLocation(x, z - 1)).getType().equals("path") || node.getType().equals("trigger")) && node.isVisited()) {
            connected[2] = true;
        }
        if (maze.getNodeAtLocation(x - 1, z) != null && ((node = maze.getNodeAtLocation(x - 1, z)).getType().equals("path") || node.getType().equals("trigger")) && node.isVisited()) {
            connected[3] = true;
        }
        return connected;
    }

    private boolean[] getRotatedMazeNeighbours(boolean[] neighbours) {
        boolean[] newNeighbours = new boolean[]{false, false, false, false};
        if (neighbours[0]) {
            newNeighbours[1] = true;
        }
        if (neighbours[1]) {
            newNeighbours[2] = true;
        }
        if (neighbours[2]) {
            newNeighbours[3] = true;
        }
        if (neighbours[3]) {
            newNeighbours[0] = true;
        }
        return newNeighbours;
    }

    private void setBlock(PipeNode node) {
        BlockPos pos = node.getBlockPos();
        if (pos != null) {
            node.updateState();
            BlockState state = node.getState();
            this.field_70170_p.func_175656_a(pos, state);
        }
    }

    public BlockPos nearestPipe(BlockPos pos) {
        ArrayList<BlockPos> positions = new ArrayList<BlockPos>();
        positions.add(pos.func_177982_a(1, 0, 1));
        positions.add(pos.func_177982_a(1, 0, -1));
        positions.add(pos.func_177982_a(-1, 0, 1));
        positions.add(pos.func_177982_a(-1, 0, -1));
        positions.add(pos.func_177982_a(1, 0, 0));
        positions.add(pos.func_177982_a(-1, 0, 0));
        positions.add(pos.func_177982_a(0, 0, 1));
        positions.add(pos.func_177982_a(0, 0, -1));
        for (BlockPos position : positions) {
            Block block = this.field_70170_p.func_180495_p(position).func_177230_c();
            if (!(block instanceof BlockPipe)) continue;
            return position;
        }
        return null;
    }

    public void setPipePositions(BlockPos reference) {
        BlockPos pipe2;
        this.ref = reference;
        this.startPos = this.nearestPipe(this.ref);
        if (this.startPos != null && (pipe2 = this.nearestPipe(this.startPos)) != null) {
            if (pipe2.func_177958_n() == this.startPos.func_177958_n()) {
                boolean zdir = pipe2.func_177952_p() > this.startPos.func_177952_p();
                this.dir = new Vec3i(0, 0, zdir ? 1 : -1);
            } else {
                boolean xdir = pipe2.func_177958_n() > this.startPos.func_177958_n();
                this.dir = new Vec3i(xdir ? 1 : -1, 0, 0);
            }
        }
        for (int i = 0; i < this.columns; ++i) {
            for (int j = 0; j < this.rows; ++j) {
                BlockPos temp = this.startPos.func_177982_a(this.dir.func_177958_n() * i, j, this.dir.func_177952_p() * i);
                if (!(this.field_70170_p.func_180495_p(temp).func_177230_c() instanceof BlockPipe)) continue;
                PipeNode node = this.getNodeAtLocation(i, j);
                node.setBlockPos(temp);
                int numRot = this.field_70170_p.field_73012_v.nextInt(4);
                for (int rot = 0; rot < numRot; ++rot) {
                    node.rotate();
                }
                this.setBlock(node);
            }
        }
    }

    public void rotate(BlockPos pos) {
        if (this.startPos != null) {
            int gridX = Math.abs(pos.func_177958_n() - this.startPos.func_177958_n()) + Math.abs(pos.func_177952_p() - this.startPos.func_177952_p());
            int gridY = Math.abs(pos.func_177956_o() - this.startPos.func_177956_o());
            PipeNode node = this.getNodeAtLocation(gridX, gridY);
            node.rotate();
            this.setBlock(node);
            this.updateLit();
        }
    }

    private void updateLit() {
        for (int i = 0; i < this.columns; ++i) {
            for (int j = 0; j < this.rows; ++j) {
                PipeNode node = this.getNodeAtLocation(i, j);
                node.setLit(false);
                this.setBlock(node);
            }
        }
        PipeNode startNode = this.getNodeAtLocation(0, 0);
        startNode.propogateLit(this.pipeMap, new ArrayList<PipeNode>());
        for (int i = 0; i < this.columns; ++i) {
            for (int j = 0; j < this.rows; ++j) {
                PipeNode node = this.getNodeAtLocation(i, j);
                this.setBlock(node);
                if (!node.isLit() || i != this.columns - 1 || j != this.columns - 1) continue;
                this.win = true;
            }
        }
    }

    private PipeNode getNodeAtLocation(int c, int r) {
        if (this.pipeMap[c] != null && this.pipeMap[c][r] != null) {
            return this.pipeMap[c][r];
        }
        return null;
    }

    public boolean func_184645_a(Player player, InteractionHand hand) {
        if (!this.field_70170_p.field_72995_K && this.win) {
            this.func_145779_a(ItemInit.nanofluoricAcid, 1);
            this.win = false;
            this.deathEffect();
        }
        return true;
    }

    public void func_70636_d() {
        super.func_70636_d();
        if (!this.field_70170_p.field_72995_K) {
            if (this.field_70173_aa % 5 == 0 && this.startPos == null) {
                this.deathEffect();
            }
            if (this.field_70173_aa % 1400 == 0 && this.startPos != null && !this.win) {
                for (Player near_pl : this.field_70170_p.func_72872_a(Player.class, this.func_174813_aQ().func_72314_b(25.0, 35.0, 25.0))) {
                    near_pl.func_145747_a((Component)new Component(TextFmt.getFormatting(TextFmt.Bold, TextFmt.Red) + "Oh no! The liquid ran out before the pipes were connected."));
                    this.game = false;
                }
                this.deathEffect();
            }
            if (this.win && !this.sentWinMessage) {
                for (Player near_pl : this.field_70170_p.func_72872_a(Player.class, this.func_174813_aQ().func_72314_b(25.0, 32.0, 25.0))) {
                    near_pl.func_145747_a((Component)new Component(TextFmt.getFormatting(TextFmt.Bold, TextFmt.Green) + "The vial is full! Come get it."));
                }
                this.sentWinMessage = true;
            }
        }
    }

    private void deathEffect() {
        ((ServerLevel)this.field_70170_p).func_175739_a(EnumParticleTypes.PORTAL, this.field_70165_t, this.field_70163_u, this.field_70161_v, 12, (-0.5 + this.field_70146_Z.nextDouble()) * 3.0, 0.3, (-0.5 + this.field_70146_Z.nextDouble()) * 3.0, (double)0.15f, new int[0]);
        this.func_70106_y();
    }

    protected SoundEvent func_184639_G() {
        return SoundEvents.field_187910_gj;
    }

    protected SoundEvent func_184601_bQ(DamageSource damageSourceIn) {
        return SoundEvents.field_187912_gl;
    }

    protected SoundEvent func_184615_bR() {
        return SoundEvents.field_187911_gk;
    }

    public void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.2);
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(20.0);
    }
}

