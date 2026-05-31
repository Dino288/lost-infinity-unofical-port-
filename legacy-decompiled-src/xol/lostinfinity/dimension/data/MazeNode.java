/*
 * Decompiled with CFR 0.152.
 */
package xol.lostinfinity.dimension.data;

import java.util.ArrayList;
import java.util.List;
import xol.lostinfinity.dimension.data.MazeMap;

public class MazeNode {
    private int xpos;
    private int ypos;
    private int zpos;
    private String type;
    private boolean end;
    private boolean visited;

    public MazeNode(String type, int gridx, int gridy, int gridz) {
        this.type = type;
        this.xpos = gridx;
        this.ypos = gridy;
        this.zpos = gridz;
        this.end = false;
        this.visited = false;
    }

    public boolean compare(MazeNode node) {
        int x1 = this.getX();
        int x2 = node.getX();
        int z1 = this.getZ();
        int z2 = node.getZ();
        return x1 == x2 && z1 == z2;
    }

    public void setEnd() {
        this.end = true;
    }

    public boolean isEnd() {
        return this.end;
    }

    public int getX() {
        return this.xpos;
    }

    public int getY() {
        return this.ypos;
    }

    public int getZ() {
        return this.zpos;
    }

    public void setX(int x) {
        this.xpos = x;
    }

    public void setY(int y) {
        this.ypos = y;
    }

    public void setZ(int z) {
        this.zpos = z;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public MazeNode connect(MazeNode neighbour, MazeMap map) {
        int x1 = this.getX();
        int z1 = this.getZ();
        int x2 = neighbour.getX();
        int z2 = neighbour.getZ();
        MazeNode node = null;
        block0 : switch (x1 - x2) {
            case -2: {
                node = map.getNodeAtLocation(x1 + 1, z1);
                break;
            }
            case 2: {
                node = map.getNodeAtLocation(x1 - 1, z1);
                break;
            }
            case 0: {
                switch (z1 - z2) {
                    case -2: {
                        node = map.getNodeAtLocation(x1, z1 + 1);
                        break block0;
                    }
                    case 2: {
                        node = map.getNodeAtLocation(x1, z1 - 1);
                    }
                }
            }
        }
        return node;
    }

    public List<MazeNode> getNeighbours(MazeMap mazeMap) {
        int z;
        ArrayList<MazeNode> neighbours = new ArrayList<MazeNode>();
        int x = this.getX();
        if (mazeMap.getNodeAtLocation(x, (z = this.getZ()) + 2) != null && !mazeMap.getNodeAtLocation(x, z + 2).isVisited()) {
            neighbours.add(mazeMap.getNodeAtLocation(x, z + 2));
        }
        if (mazeMap.getNodeAtLocation(x, z - 2) != null && !mazeMap.getNodeAtLocation(x, z - 2).isVisited()) {
            neighbours.add(mazeMap.getNodeAtLocation(x, z - 2));
        }
        if (mazeMap.getNodeAtLocation(x + 2, z) != null && !mazeMap.getNodeAtLocation(x + 2, z).isVisited()) {
            neighbours.add(mazeMap.getNodeAtLocation(x + 2, z));
        }
        if (mazeMap.getNodeAtLocation(x - 2, z) != null && !mazeMap.getNodeAtLocation(x - 2, z).isVisited()) {
            neighbours.add(mazeMap.getNodeAtLocation(x - 2, z));
        }
        return neighbours;
    }

    public boolean isVisited() {
        return this.visited;
    }

    public void setVisited() {
        this.visited = true;
    }
}

