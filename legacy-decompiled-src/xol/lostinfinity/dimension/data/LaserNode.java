/*
 * Decompiled with CFR 0.152.
 */
package xol.lostinfinity.dimension.data;

public class LaserNode {
    private int x;
    private int z;
    private boolean visited = false;
    private boolean isStair = false;

    public LaserNode(int x, int z) {
        this.x = x;
        this.z = z;
        this.visited = false;
    }

    public boolean isStair() {
        return this.isStair;
    }

    public void setStair() {
        this.isStair = true;
    }

    public void setVisited() {
        this.visited = true;
    }

    public boolean visited() {
        return this.visited;
    }

    public int getX() {
        return this.x;
    }

    public int getZ() {
        return this.z;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setZ(int z) {
        this.z = z;
    }
}

