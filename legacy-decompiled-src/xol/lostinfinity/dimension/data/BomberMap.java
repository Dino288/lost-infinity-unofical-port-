/*
 * Decompiled with CFR 0.152.
 */
package xol.lostinfinity.dimension.data;

import java.util.ArrayList;
import java.util.List;
import xol.lostinfinity.dimension.data.BomberNode;

public class BomberMap {
    private int col;
    private int row;
    private static int softWallRatio = 50;
    private BomberNode[][] bomberGrid;

    public static void main(String[] args) {
        int c = 31;
        int r = 31;
        BomberMap bombMap = new BomberMap(c, r, 10);
        bombMap.setSpawns(3);
        for (int i = 0; i < c; ++i) {
            block17: for (int j = 0; j < r; ++j) {
                String type;
                BomberNode node = bombMap.getNodeAtLocation(i, j);
                switch (type = node.getType()) {
                    case "hard": {
                        System.out.print("[]");
                        continue block17;
                    }
                    case "soft": {
                        System.out.print("{}");
                        continue block17;
                    }
                    case "spawn1": {
                        System.out.print("^!");
                        continue block17;
                    }
                    case "spawn2": {
                        System.out.print("^|");
                        continue block17;
                    }
                    case "spawn3": {
                        System.out.print("!^");
                        continue block17;
                    }
                    case "air": {
                        System.out.print("||");
                    }
                }
            }
            System.out.print("\r\n");
        }
    }

    public BomberMap(int columns, int rows, int numPowerups) {
        int y = 0;
        this.col = columns;
        this.row = rows;
        this.bomberGrid = new BomberNode[columns][rows];
        for (int i = 0; i < columns; ++i) {
            for (int j = 0; j < rows; ++j) {
                int randInt;
                BomberNode node = i % 3 == 2 && j % 3 == 2 ? new BomberNode(i, y, j, "hard") : ((randInt = (int)(Math.random() * 100.0)) < softWallRatio ? new BomberNode(i, y, j, "soft") : new BomberNode(i, y, j, "air"));
                this.bomberGrid[i][j] = node;
            }
        }
        int powerUpsLeft = numPowerups;
        while (powerUpsLeft > 0) {
            int randRow;
            int randCol = (int)(Math.random() * (double)columns);
            BomberNode node = this.getNodeAtLocation(randCol, randRow = (int)(Math.random() * (double)rows));
            if (!node.getType().equals("soft")) continue;
            node.setType("powerup");
            --powerUpsLeft;
        }
    }

    public void setSpawns(int numPlayers) {
        int c = this.col;
        int r = this.row;
        int n = numPlayers;
        int perimeter = 2 * c + 2 * r;
        int distPoint = perimeter / n;
        int startX = 0;
        int startZ = 0;
        BomberNode startNode = this.getNodeAtLocation(startX, startZ);
        startNode.setType("spawn1");
        List<BomberNode> spawns = this.findSpawnPointsFromPerimeterDist(startNode, distPoint, n);
        for (BomberNode spawn : spawns) {
            List<BomberNode> neighbours = spawn.getNeighbours(this);
            for (BomberNode neighbour : neighbours) {
                if (neighbour == null) continue;
                neighbour.setType("air");
            }
        }
    }

    public List<BomberNode> findSpawnPointsFromPerimeterDist(BomberNode startNode, int pointDist, int n) {
        ArrayList<BomberNode> spawnList = new ArrayList<BomberNode>();
        spawnList.add(startNode);
        String side = "";
        int c = this.col - 1;
        int r = this.row - 1;
        int x = startNode.getX();
        int z = startNode.getZ();
        for (int i = 1; i < n; ++i) {
            String type = "spawn" + Integer.toString(i + 1);
            System.out.println(type);
            int dist = pointDist;
            if (x == 0 && z >= 0) {
                side = "left";
            } else if (x > 0 && z == 0) {
                side = "bottom";
            } else if (x >= 0 && z == r) {
                side = "top";
            } else if (x == c && z >= 0) {
                side = "right";
            } else {
                System.out.println("bad things happened");
            }
            while (dist > 0) {
                switch (side) {
                    case "left": {
                        if (dist <= r - z) {
                            z += dist;
                            dist = 0;
                            break;
                        }
                        dist -= r - z;
                        z = r;
                        side = "top";
                        break;
                    }
                    case "top": {
                        if (dist <= c - x) {
                            x += dist;
                            dist = 0;
                            break;
                        }
                        dist -= c - x;
                        x = c;
                        side = "right";
                        break;
                    }
                    case "right": {
                        if (dist <= z) {
                            z -= dist;
                            dist = 0;
                            break;
                        }
                        dist -= z;
                        z = 0;
                        side = "bottom";
                        break;
                    }
                    case "bottom": {
                        if (dist <= x) {
                            x -= dist;
                            dist = 0;
                            break;
                        }
                        dist -= x;
                        x = 0;
                        side = "left";
                    }
                }
            }
            BomberNode spawn = this.getNodeAtLocation(x, z);
            spawn.setType(type);
            spawnList.add(spawn);
        }
        return spawnList;
    }

    public BomberNode getNodeAtLocation(int col, int row) {
        if (col < 0 || row < 0 || col >= this.col || row >= this.row) {
            return null;
        }
        return this.bomberGrid[col][row];
    }
}

