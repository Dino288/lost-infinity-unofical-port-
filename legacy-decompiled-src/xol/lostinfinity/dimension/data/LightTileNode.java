/*
 * Decompiled with CFR 0.152.
 */
package xol.lostinfinity.dimension.data;

import java.util.ArrayList;
import java.util.List;
import xol.lostinfinity.dimension.data.LightTileMap;

public class LightTileNode {
    private int x;
    private int y;
    private int z;
    private boolean lit;

    public LightTileNode(int x, int y, int z, boolean lit) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.lit = lit;
    }

    public boolean isLit() {
        return this.lit;
    }

    public void setLit(boolean lit) {
        this.lit = lit;
    }

    public void toggle() {
        this.lit = !this.lit;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public int getZ() {
        return this.z;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setZ(int z) {
        this.z = z;
    }

    public List<LightTileNode> getNeighbours(LightTileMap lightTileMap) {
        int z;
        ArrayList<LightTileNode> neighbours = new ArrayList<LightTileNode>();
        int x = this.getX();
        if (lightTileMap.getNodeAtLocation(x, (z = this.getZ()) + 1) != null) {
            neighbours.add(lightTileMap.getNodeAtLocation(x, z + 1));
        }
        if (lightTileMap.getNodeAtLocation(x, z - 1) != null) {
            neighbours.add(lightTileMap.getNodeAtLocation(x, z - 1));
        }
        if (lightTileMap.getNodeAtLocation(x + 1, z) != null) {
            neighbours.add(lightTileMap.getNodeAtLocation(x + 1, z));
        }
        if (lightTileMap.getNodeAtLocation(x - 1, z) != null) {
            neighbours.add(lightTileMap.getNodeAtLocation(x - 1, z));
        }
        return neighbours;
    }
}

