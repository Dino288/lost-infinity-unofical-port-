/*
 * Decompiled with CFR 0.152.
 */
package xol.lostinfinity.dimension.data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import xol.lostinfinity.dimension.data.PowerColliderNode;

public class PowerColliderGrid {
    private ArrayList<ArrayList<PowerColliderNode>> paths = null;
    private PowerColliderNode[][] map = null;
    private int col = 0;
    private int row = 0;
    private int minLength = 0;
    private int numPaths = 0;

    public PowerColliderGrid(int col, int row, int minLength, int numPaths) {
        this.numPaths = numPaths;
        this.col = col;
        this.row = row;
        this.minLength = minLength;
        this.map = new PowerColliderNode[this.col][this.row];
        for (int i = 0; i < col; ++i) {
            for (int j = 0; j < row; ++j) {
                this.map[i][j] = new PowerColliderNode(i, j);
            }
        }
        for (int iterations = 0; !this.findPaths() && iterations < 10000; ++iterations) {
        }
    }

    public static void main(String[] args) {
        PowerColliderGrid grid = new PowerColliderGrid(10, 10, 10, 3);
    }

    public ArrayList<ArrayList<PowerColliderNode>> getPaths() {
        return this.paths;
    }

    private ArrayList<PowerColliderNode> getPath(int i) {
        return this.paths.get(i);
    }

    private boolean findPaths() {
        this.paths = new ArrayList();
        ArrayList<PowerColliderNode> visited = new ArrayList<PowerColliderNode>();
        Random rand = new Random();
        int endX = rand.nextInt(this.col);
        int endZ = rand.nextInt(this.row);
        PowerColliderNode endNode = this.getNodeAtLocation(endX, endZ);
        endNode.setEnd(true);
        visited.add(endNode);
        for (int i = 0; i < this.numPaths; ++i) {
            ArrayList<PowerColliderNode> path = new ArrayList<PowerColliderNode>();
            if (endNode == null) {
                return false;
            }
            path.add(endNode);
            int tries = 0;
            while (tries < 100) {
                ++tries;
                ArrayList<PowerColliderNode> neighbours1 = this.getNeighbours((PowerColliderNode)path.get(path.size() - 1));
                Collections.shuffle(neighbours1);
                for (PowerColliderNode neighbour : neighbours1) {
                    if (neighbour == null) continue;
                    int count = 0;
                    for (PowerColliderNode subNeighbour : this.getNeighbours(neighbour)) {
                        if (path.contains(subNeighbour)) {
                            ++count;
                        }
                        for (ArrayList<PowerColliderNode> otherPath : this.paths) {
                            if (!otherPath.contains(subNeighbour) || path.contains(subNeighbour)) continue;
                            ++count;
                        }
                    }
                    boolean intersect = false;
                    for (ArrayList<PowerColliderNode> otherPath : this.paths) {
                        if (!otherPath.contains(neighbour)) continue;
                        intersect = true;
                    }
                    if (count > 1 || path.contains(neighbour) || intersect) continue;
                    visited.add(neighbour);
                    path.add(neighbour);
                    break;
                }
                if (path.size() <= this.minLength || rand.nextInt(20) != 0) continue;
                this.paths.add(path);
                break;
            }
            if (tries != 100) continue;
            return false;
        }
        return true;
    }

    private ArrayList<PowerColliderNode> getNeighbours(PowerColliderNode node) {
        ArrayList<PowerColliderNode> neighbours = new ArrayList<PowerColliderNode>();
        neighbours.add(this.getNodeAtLocation(node.getX() + 1, node.getZ()));
        neighbours.add(this.getNodeAtLocation(node.getX() - 1, node.getZ()));
        neighbours.add(this.getNodeAtLocation(node.getX(), node.getZ() + 1));
        neighbours.add(this.getNodeAtLocation(node.getX(), node.getZ() - 1));
        return neighbours;
    }

    public PowerColliderNode getNodeAtLocation(int x, int z) {
        if (this.map != null && x >= 0 && x < this.map.length && z >= 0 && z < this.map[x].length) {
            return this.map[x][z];
        }
        return null;
    }
}

