/*
 * Decompiled with CFR 0.152.
 */
package xol.lostinfinity.dimension.data;

import java.util.ArrayList;
import java.util.List;
import xol.lostinfinity.dimension.data.BomberMap;

public class BomberNode {
    private int x;
    private int y;
    private int z;
    private String type;

    public BomberNode(int x, int y, int z, String type) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.type = type;
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

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<BomberNode> getNeighbours(BomberMap bomberMap) {
        int z;
        ArrayList<BomberNode> neighbours = new ArrayList<BomberNode>();
        int x = this.getX();
        if (bomberMap.getNodeAtLocation(x, (z = this.getZ()) + 1) != null) {
            neighbours.add(bomberMap.getNodeAtLocation(x, z + 1));
        }
        if (bomberMap.getNodeAtLocation(x, z - 1) != null) {
            neighbours.add(bomberMap.getNodeAtLocation(x, z - 1));
        }
        if (bomberMap.getNodeAtLocation(x + 1, z) != null) {
            neighbours.add(bomberMap.getNodeAtLocation(x + 1, z));
        }
        if (bomberMap.getNodeAtLocation(x - 1, z) != null) {
            neighbours.add(bomberMap.getNodeAtLocation(x - 1, z));
        }
        return neighbours;
    }
}

