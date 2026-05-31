/*
 * Decompiled with CFR 0.152.
 */
package xol.lostinfinity.dimension.data;

import java.util.ArrayList;
import java.util.List;
import xol.lostinfinity.dimension.data.TetrisMap;

public class TetrisNode {
    private int xpos;
    private int ypos;
    private boolean visited;

    public TetrisNode(int gridx, int gridy) {
        this.xpos = gridx;
        this.ypos = gridy;
        this.visited = false;
    }

    public void setVisited() {
        this.visited = true;
    }

    public boolean isVisited() {
        return this.visited;
    }

    public int getX() {
        return this.xpos;
    }

    public int getZ() {
        return this.ypos;
    }

    public List<TetrisNode> getNeighbours(TetrisMap map) {
        int x = this.getX();
        int z = this.getZ();
        ArrayList<TetrisNode> neighbours = new ArrayList<TetrisNode>();
        neighbours.add(map.getNodeAtLocation(x, z + 1));
        neighbours.add(map.getNodeAtLocation(x, z - 1));
        neighbours.add(map.getNodeAtLocation(x + 1, z));
        neighbours.add(map.getNodeAtLocation(x - 1, z));
        return neighbours;
    }
}

