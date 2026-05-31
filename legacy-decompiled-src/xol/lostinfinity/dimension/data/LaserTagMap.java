/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.math.Vec3i
 */
package xol.lostinfinity.dimension.data;

import java.util.ArrayList;
import java.util.Random;
import net.minecraft.core.Vec3i;
import xol.lostinfinity.dimension.data.LaserNode;

public class LaserTagMap {
    private LaserNode[][] floor1 = null;
    private LaserNode[][] floor2 = null;
    private static final Random rand = new Random();
    private static final int iterations = 10000;
    private int columns = 0;
    private int rows = 0;
    private static ArrayList<Vec3i> dirs = null;

    public static void main(String[] args) {
        int j;
        int i;
        LaserTagMap map = new LaserTagMap(20, 20);
        LaserNode[][] floor1 = map.getFloor1();
        LaserNode[][] floor2 = map.getFloor2();
        for (i = 0; i < floor1.length; ++i) {
            for (j = 0; j < floor1[0].length; ++j) {
                if (floor1[i][j].isStair()) {
                    System.out.print("||");
                    continue;
                }
                if (floor1[i][j].visited()) {
                    System.out.print("[]");
                    continue;
                }
                System.out.print("{}");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
        for (i = 0; i < floor2.length; ++i) {
            for (j = 0; j < floor2[0].length; ++j) {
                if (floor2[i][j].isStair()) {
                    System.out.print("||");
                    continue;
                }
                if (floor2[i][j].visited()) {
                    System.out.print("[]");
                    continue;
                }
                System.out.print("{}");
            }
            System.out.println();
        }
    }

    public LaserTagMap(int columns, int rows) {
        dirs = new ArrayList();
        dirs.add(new Vec3i(1, 0, 0));
        dirs.add(new Vec3i(-1, 0, 0));
        dirs.add(new Vec3i(1, 0, 1));
        dirs.add(new Vec3i(1, 0, -1));
        dirs.add(new Vec3i(-1, 0, 1));
        dirs.add(new Vec3i(-1, 0, -1));
        dirs.add(new Vec3i(0, 0, 1));
        dirs.add(new Vec3i(0, 0, -1));
        this.columns = columns;
        this.rows = rows;
        this.floor1 = new LaserNode[columns][rows];
        this.floor2 = new LaserNode[columns][rows];
        for (int i = 0; i < columns; ++i) {
            for (int j = 0; j < rows; ++j) {
                this.floor1[i][j] = new LaserNode(i, j);
                this.floor2[i][j] = new LaserNode(i, j);
            }
        }
        this.generateFloor(true);
        this.generateFloor(false);
    }

    private void generateFloor(boolean firstFloor) {
        LaserNode[][] floor = null;
        floor = firstFloor ? this.getFloor1() : this.getFloor2();
        if (floor == null) {
            return;
        }
        for (int i = 0; i < 10000; ++i) {
            int nodeZ;
            int nodeX = rand.nextInt(this.columns);
            if (!this.isValidPlacement(nodeX, nodeZ = rand.nextInt(this.rows), firstFloor, true)) continue;
            int randDir = rand.nextInt(dirs.size());
            Vec3i dir = dirs.get(randDir);
            ArrayList<LaserNode> toVisit = this.traverse(nodeX, nodeZ, dir, firstFloor, true, null);
            for (LaserNode node : toVisit) {
                node.setVisited();
            }
        }
    }

    private ArrayList<LaserNode> traverse(int nodeX, int nodeZ, Vec3i dir, boolean firstFloor, boolean repeat, ArrayList<LaserNode> placed) {
        if (placed == null) {
            placed = new ArrayList();
        }
        ArrayList<LaserNode> toPlace = new ArrayList<LaserNode>();
        toPlace.add(this.getNodeAtLocation(nodeX, nodeZ, firstFloor));
        int length = rand.nextInt(4) + 2;
        for (int i = 1; i < length; ++i) {
            if (!this.isValidPlacement(nodeX + i * dir.func_177958_n(), nodeZ + i * dir.func_177952_p(), firstFloor, false) || placed.contains(this.getNodeAtLocation(nodeX + i * dir.func_177958_n(), nodeZ + i * dir.func_177952_p(), firstFloor))) {
                toPlace.clear();
                return toPlace;
            }
            toPlace.add(this.getNodeAtLocation(nodeX + i * dir.func_177958_n(), nodeZ + i * dir.func_177952_p(), firstFloor));
        }
        if (repeat) {
            placed.addAll(toPlace);
            int lastX = nodeX + (length - 1) * dir.func_177958_n();
            int lastZ = nodeZ + (length - 1) * dir.func_177952_p();
            int numSplits = rand.nextInt(3);
            ArrayList<Vec3i> chosenDirs = new ArrayList<Vec3i>();
            chosenDirs.add(dir);
            for (int i = 0; i <= numSplits; ++i) {
                int randDir = rand.nextInt(dirs.size());
                Vec3i newDir = dirs.get(randDir);
                while (chosenDirs.contains(newDir)) {
                    randDir = rand.nextInt(dirs.size());
                    newDir = dirs.get(randDir);
                }
                int startX = lastX + newDir.func_177958_n();
                int startZ = lastZ + newDir.func_177952_p();
                toPlace.addAll(this.traverse(startX, startZ, newDir, firstFloor, false, placed));
            }
        }
        return toPlace;
    }

    private boolean isValidPlacement(int nodeX, int nodeZ, boolean firstFloor, boolean canPlaceByWall) {
        if (nodeX >= this.columns - 4 && nodeZ >= this.rows - 4 || nodeX < 4 && nodeZ < 4) {
            return false;
        }
        boolean valid = true;
        if (this.getNodeAtLocation(nodeX, nodeZ, firstFloor) == null) {
            return false;
        }
        block0: for (int i = -1; i <= 1; ++i) {
            for (int j = -1; j <= 1; ++j) {
                LaserNode node = this.getNodeAtLocation(nodeX + i, nodeZ + j, firstFloor);
                if (canPlaceByWall) {
                    if (node == null || !node.visited()) continue;
                    valid = false;
                    break block0;
                }
                if (node != null && !node.visited()) continue;
                valid = false;
                break block0;
            }
        }
        return valid;
    }

    public LaserNode[][] getFloor1() {
        return this.floor1;
    }

    public LaserNode[][] getFloor2() {
        return this.floor2;
    }

    public LaserNode getNodeAtLocation(int x, int z, boolean firstFloor) {
        LaserNode[][] floor = null;
        floor = firstFloor ? this.getFloor1() : this.getFloor2();
        if (floor != null && x >= 0 && x < floor.length && z >= 0 && z < floor[x].length) {
            return floor[x][z];
        }
        return null;
    }
}

