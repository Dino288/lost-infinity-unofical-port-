/*
 * Decompiled with CFR 0.152.
 */
package xol.lostinfinity.dimension.data;

import java.util.ArrayList;
import java.util.List;
import xol.lostinfinity.dimension.data.SlideMap;

public class SlideNode {
    private int x;
    private int y;
    private int z;
    private int tileNum;
    private boolean empty;

    public SlideNode(int x, int y, int z, int tileNum) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.tileNum = tileNum;
        this.empty = false;
    }

    public void setTileNum(int num) {
        this.tileNum = num;
    }

    public int getTileNum() {
        return this.tileNum;
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

    public List<SlideNode> getNeighbours(SlideMap slideMap) {
        int z;
        ArrayList<SlideNode> neighbours = new ArrayList<SlideNode>();
        int x = this.getX();
        if (slideMap.getNodeAtLocation(x, (z = this.getZ()) + 1) != null) {
            neighbours.add(slideMap.getNodeAtLocation(x, z + 1));
        }
        if (slideMap.getNodeAtLocation(x, z - 1) != null) {
            neighbours.add(slideMap.getNodeAtLocation(x, z - 1));
        }
        if (slideMap.getNodeAtLocation(x + 1, z) != null) {
            neighbours.add(slideMap.getNodeAtLocation(x + 1, z));
        }
        if (slideMap.getNodeAtLocation(x - 1, z) != null) {
            neighbours.add(slideMap.getNodeAtLocation(x - 1, z));
        }
        return neighbours;
    }

    public void setEmpty(boolean empty) {
        this.empty = empty;
    }

    public boolean isEmpty() {
        return this.empty;
    }
}

