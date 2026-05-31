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
 *  net.minecraft.util.math.Vec3i
 *  net.minecraft.util.text.Component
 *  net.minecraft.util.text.Component
 *  net.minecraft.world.World
 */
package xol.lostinfinity.mob.entity.contest.operator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.phys.AABB;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Vec3i;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.Level;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.dimension.data.ParkourNode;
import xol.lostinfinity.init.BlockInit;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.mob.entity.contest.controller.EntityControllerParkour;
import xol.lostinfinity.mob.entity.contest.operator.EntityOperatorBase;
import xol.lostinfinity.util.coordinates.ContestCoordinates;

public class EntityOperatorParkour
extends EntityOperatorBase {
    private List<BlockPos> spawnPositions = new ArrayList<BlockPos>();
    private static final int normalHeight = 6;
    private static final int minHeight = 3;
    private static final int maxHeight = 9;
    private static final int pillarStartHeight = 22;
    private static final int pillarHeight = 37;

    public EntityOperatorParkour(Level worldIn) {
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
        this.spawnPositions.add(ContestCoordinates.parkourSpawnPos());
        EntityControllerParkour gamehologram = new EntityControllerParkour(this.field_70170_p);
        BlockPos pos = ContestCoordinates.parkourControllerPos();
        gamehologram.func_70107_b(pos.func_177958_n(), pos.func_177956_o(), pos.func_177952_p());
        gamehologram.setPlayerCount(1);
        int curSpawn = 0;
        for (UUID pl_id : this.contenders) {
            Player pl = this.field_70170_p.func_152378_a(pl_id);
            if (pl == null) continue;
            gamehologram.addPlayerToList(pl);
            pl.field_71071_by.func_70436_m();
            BlockPos spawnPos = this.spawnPositions.get(curSpawn);
            pl.func_70634_a((double)spawnPos.func_177958_n(), (double)spawnPos.func_177956_o(), (double)spawnPos.func_177952_p());
            ++curSpawn;
        }
        this.field_70170_p.func_72838_d((Entity)gamehologram);
        gamehologram.startGame();
        this.spawnPositions.clear();
        this.contenders.clear();
    }

    @Override
    protected AABB getArenaAABB() {
        return ContestCoordinates.parkourArenaAABB();
    }

    @Override
    protected AABB getLobbyAABB() {
        return ContestCoordinates.parkourLobbyAABB();
    }

    @Override
    protected void generateArena() {
        if (!this.field_70170_p.field_72995_K) {
            EntityOperatorParkour.genParkour(this.field_70170_p, 1);
        }
    }

    public static void genParkour(Level world, int round) {
        int rows;
        int columns;
        AABB parkourGrid = ContestCoordinates.parkourGridAABB();
        Random rand = new Random();
        Vec3i upDir = new Vec3i(0, 0, 1);
        Vec3i leftDir = new Vec3i(1, 0, 0);
        int diffX = (int)Math.abs(Math.round(parkourGrid.field_72336_d) - Math.round(parkourGrid.field_72340_a)) + 1;
        int diffZ = (int)Math.abs(Math.round(parkourGrid.field_72334_f) - Math.round(parkourGrid.field_72339_c)) + 1;
        boolean swapColRow = false;
        if (swapColRow) {
            columns = diffZ;
            rows = diffX;
        } else {
            columns = diffX;
            rows = diffZ;
        }
        ArrayList<ParkourNode> nodes = new ArrayList<ParkourNode>();
        ParkourNode[][] grid = new ParkourNode[columns][rows];
        boolean found = false;
        for (int i = 0; i < columns; ++i) {
            for (int j = 0; j < rows; ++j) {
                ParkourNode node;
                grid[i][j] = node = new ParkourNode(i, j);
            }
        }
        ParkourNode end = EntityOperatorParkour.getNodeAtLocation(grid, columns - 1, rows / 2);
        ParkourNode start = EntityOperatorParkour.getNodeAtLocation(grid, 0, rows / 2);
        start.setVisited(true);
        start.setHeight(6);
        end.setHeight(6);
        if (end == null || start == null) {
            return;
        }
        while (!found) {
            nodes.clear();
            for (int i = 0; i < columns; ++i) {
                for (int j = 0; j < rows; ++j) {
                    ParkourNode node = EntityOperatorParkour.getNodeAtLocation(grid, i, j);
                    nodes.add(node);
                }
            }
            ArrayList<ParkourNode> path = EntityOperatorParkour.findPath(grid, start, end, new ArrayList<ParkourNode>());
            if (path == null) continue;
            found = true;
            for (ParkourNode pathNode : path) {
                pathNode.setVisited(true);
            }
        }
        boolean stop = false;
        for (Object pos : BlockPos.func_191532_a((int)((int)Math.round(parkourGrid.field_72340_a)), (int)((int)Math.round(parkourGrid.field_72338_b) - 20), (int)((int)Math.round(parkourGrid.field_72339_c)), (int)((int)Math.round(parkourGrid.field_72336_d)), (int)((int)Math.round(parkourGrid.field_72337_e)), (int)((int)Math.round(parkourGrid.field_72334_f)))) {
            if (!world.func_180495_p((BlockPos)pos).func_177230_c().equals(BlockInit.championGlowingTile) && !world.func_180495_p((BlockPos)pos).func_177230_c().equals(BlockInit.arenaBrickBlack) && !world.func_180495_p((BlockPos)pos).func_177230_c().equals(BlockInit.championDungeonSelector) && !world.func_180495_p((BlockPos)pos).func_177230_c().equals(BlockInit.parkourPlatform) && !world.func_180495_p((BlockPos)pos).func_177230_c().equals(BlockInit.parkourPlatformSlippery) && !world.func_180495_p((BlockPos)pos).equals(BlockInit.championWall.func_176223_P())) continue;
            world.func_175698_g((BlockPos)pos);
        }
        ArrayList<ParkourNode> visitedList = new ArrayList<ParkourNode>();
        for (ParkourNode node : nodes) {
            if (!node.isVisited()) continue;
            visitedList.add(node);
        }
        ArrayList<ParkourNode> pillarNodes = new ArrayList<ParkourNode>();
        ArrayList<ParkourNode> pillarsToPlace = new ArrayList<ParkourNode>();
        ArrayList<ParkourNode> adjacents = new ArrayList<ParkourNode>();
        boolean lastPlaced = false;
        for (int i = 4; i < columns - 3; ++i) {
            for (int j = 4; j < rows - 3; ++j) {
                double dist;
                pillarNodes.clear();
                adjacents.clear();
                pillarNodes.add(EntityOperatorParkour.getNodeAtLocation(grid, i, j));
                pillarNodes.add(EntityOperatorParkour.getNodeAtLocation(grid, i + 1, j));
                pillarNodes.add(EntityOperatorParkour.getNodeAtLocation(grid, i, j + 1));
                pillarNodes.add(EntityOperatorParkour.getNodeAtLocation(grid, i + 1, j + 1));
                boolean visited = false;
                for (ParkourNode pillarNode : pillarNodes) {
                    if (!pillarNode.isVisited()) continue;
                    visited = true;
                    break;
                }
                for (ParkourNode adjacent : EntityOperatorParkour.getAdjacents(grid, pillarNodes, visitedList, pillarsToPlace)) {
                    if (adjacents.contains(adjacent)) continue;
                    adjacents.add(adjacent);
                }
                if (visited || adjacents.size() != 2) continue;
                boolean canPut = true;
                ParkourNode adj1 = (ParkourNode)adjacents.get(0);
                ParkourNode adj2 = (ParkourNode)adjacents.get(1);
                if (adj1.getX() == adj2.getX() || adj1.getZ() == adj2.getZ()) {
                    canPut = false;
                }
                if ((dist = adj1.getDistance(adj2)) > 2.5) {
                    canPut = false;
                }
                if (!canPut) continue;
                if (lastPlaced) {
                    lastPlaced = false;
                    continue;
                }
                pillarsToPlace.addAll(pillarNodes);
                lastPlaced = true;
            }
        }
        for (ParkourNode pillar : pillarsToPlace) {
            int realX = leftDir.func_177958_n() * pillar.getX() + upDir.func_177958_n() * pillar.getZ() + (int)Math.round(parkourGrid.field_72340_a);
            int realZ = leftDir.func_177952_p() * pillar.getX() + upDir.func_177952_p() * pillar.getZ() + (int)Math.round(parkourGrid.field_72339_c);
            int startY = 22;
            for (int i = 0; i < 37; ++i) {
                world.func_175656_a(new BlockPos(realX, startY + i, realZ), BlockInit.championWall.func_176223_P());
            }
        }
        boolean last = false;
        for (ParkourNode node : visitedList) {
            int realX = leftDir.func_177958_n() * node.getX() + upDir.func_177958_n() * node.getZ() + (int)Math.round(parkourGrid.field_72340_a);
            int realZ = leftDir.func_177952_p() * node.getX() + upDir.func_177952_p() * node.getZ() + (int)Math.round(parkourGrid.field_72339_c);
            int realY = node.getHeight() + 40;
            if (node.equals(end)) {
                world.func_175656_a(new BlockPos(realX + upDir.func_177958_n() + 1, 46, realZ + upDir.func_177952_p()), BlockInit.championDungeonSelector.func_176223_P());
            }
            block0 : switch (round) {
                case 1: {
                    int randMeta = rand.nextInt(5);
                    world.func_175656_a(new BlockPos(realX, realY, realZ), BlockInit.championGlowingTile.func_176203_a(randMeta));
                    break;
                }
                case 2: {
                    if (rand.nextInt(3) == 0) {
                        world.func_175656_a(new BlockPos(realX, realY, realZ), BlockInit.parkourPlatformSlippery.func_176223_P());
                        break;
                    }
                    int randMeta = rand.nextInt(5);
                    world.func_175656_a(new BlockPos(realX, realY, realZ), BlockInit.championGlowingTile.func_176203_a(randMeta));
                    break;
                }
                case 3: {
                    if (rand.nextInt(3) == 0) {
                        world.func_175656_a(new BlockPos(realX, realY, realZ), BlockInit.parkourPlatform.func_176203_a(0));
                        break;
                    }
                    int randMeta = rand.nextInt(5);
                    world.func_175656_a(new BlockPos(realX, realY, realZ), BlockInit.championGlowingTile.func_176203_a(randMeta));
                    break;
                }
                case 4: {
                    if (rand.nextInt(3) == 0) {
                        if (last) {
                            world.func_175656_a(new BlockPos(realX, realY, realZ), BlockInit.parkourPlatform.func_176203_a(1));
                            last = false;
                            break;
                        }
                        world.func_175656_a(new BlockPos(realX, realY, realZ), BlockInit.parkourPlatform.func_176203_a(2));
                        last = true;
                        break;
                    }
                    int randMeta = rand.nextInt(5);
                    world.func_175656_a(new BlockPos(realX, realY, realZ), BlockInit.championGlowingTile.func_176203_a(randMeta));
                    break;
                }
                case 5: {
                    int randChoice = rand.nextInt(3);
                    switch (randChoice) {
                        case 0: {
                            world.func_175656_a(new BlockPos(realX, realY, realZ), BlockInit.parkourPlatformSlippery.func_176223_P());
                            break block0;
                        }
                        case 1: {
                            world.func_175656_a(new BlockPos(realX, realY, realZ), BlockInit.parkourPlatform.func_176203_a(0));
                            break block0;
                        }
                        case 2: {
                            if (last) {
                                world.func_175656_a(new BlockPos(realX, realY, realZ), BlockInit.parkourPlatform.func_176203_a(1));
                                last = false;
                                break block0;
                            }
                            world.func_175656_a(new BlockPos(realX, realY, realZ), BlockInit.parkourPlatform.func_176203_a(2));
                            last = true;
                        }
                    }
                }
            }
        }
    }

    public static ArrayList<ParkourNode> findPath(ParkourNode[][] grid, ParkourNode cur, ParkourNode end, ArrayList<ParkourNode> path) {
        Random rand = new Random();
        if (path == null) {
            path = new ArrayList();
        }
        if (path.contains(cur) || EntityOperatorParkour.hasAdjacents(grid, cur, path)) {
            return null;
        }
        if (cur.equals(end)) {
            end.setVisited(true);
            return path;
        }
        path.add(cur);
        int height = cur.getHeight();
        int roll = rand.nextInt(3);
        height = roll < 2 && cur.getHeight() < 9 ? ++height : (height -= rand.nextInt(cur.getHeight() - 3 + 1));
        int dist = 4;
        if (height > cur.getHeight()) {
            dist = 3;
        }
        ArrayList<Vec3i> dirs = EntityOperatorParkour.getDirs(dist);
        Collections.shuffle(dirs);
        for (Vec3i dir : dirs) {
            ArrayList<ParkourNode> nodePath;
            ParkourNode node = EntityOperatorParkour.getNodeAtLocation(grid, cur.getX() + dir.func_177958_n(), cur.getZ() + dir.func_177952_p());
            if (node == null || node.isVisited() || path.contains(node)) continue;
            node.setHeight(height);
            if (!cur.isNeighbour(node) || EntityOperatorParkour.hasAdjacents(grid, node, path) || (nodePath = EntityOperatorParkour.findPath(grid, node, end, path)) == null) continue;
            return nodePath;
        }
        return null;
    }

    public static boolean hasAdjacents(ParkourNode[][] grid, ParkourNode node, ArrayList<ParkourNode> path) {
        for (int i = -1; i <= 1; ++i) {
            for (int j = -1; j <= 1; ++j) {
                for (int k = -1; k <= 1; ++k) {
                    ParkourNode adjacent;
                    if (i == 0 && j == 0 || (adjacent = EntityOperatorParkour.getNodeAtLocation(grid, node.getX() + i, node.getZ() + j)) == null || !path.contains(adjacent)) continue;
                    return true;
                }
            }
        }
        return false;
    }

    public static ArrayList<ParkourNode> getAdjacents(ParkourNode[][] grid, ArrayList<ParkourNode> nodes, ArrayList<ParkourNode> path, ArrayList<ParkourNode> exclude) {
        ArrayList<ParkourNode> adjacents = new ArrayList<ParkourNode>();
        for (ParkourNode node : nodes) {
            for (int i = -1; i <= 1; ++i) {
                for (int j = -1; j <= 1; ++j) {
                    for (int k = -1; k <= 1; ++k) {
                        if (i == 0 && j == 0) continue;
                        ParkourNode adjacent = EntityOperatorParkour.getNodeAtLocation(grid, node.getX() + i, node.getZ() + j);
                        if (exclude.contains(adjacent)) {
                            adjacents.clear();
                            return adjacents;
                        }
                        if (adjacent == null || !path.contains(adjacent) || adjacents.contains(adjacent)) continue;
                        adjacents.add(adjacent);
                    }
                }
            }
        }
        return adjacents;
    }

    public static ArrayList<Vec3i> getDirs(int dist) {
        ArrayList<Vec3i> dirs = new ArrayList<Vec3i>();
        for (int i = 0; i <= dist; ++i) {
            for (int j = -dist; j <= dist; ++j) {
                double radius;
                if (i == 0 && j == 0 || i == 0 || (radius = Math.sqrt(i * i + j * j)) > (double)dist || radius < 1.0) continue;
                dirs.add(new Vec3i(i, 0, j));
            }
        }
        return dirs;
    }

    public static ParkourNode getNodeAtLocation(ParkourNode[][] grid, int x, int z) {
        if (grid != null && x >= 0 && x < grid.length && z >= 0 && z < grid[x].length) {
            return grid[x][z];
        }
        return null;
    }
}

