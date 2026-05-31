/*
 * Decompiled with CFR 0.152.
 */
package xol.lostinfinity.dimension.data;

public class ParkourNode {
    private int height = 0;
    private boolean visited = false;
    private int x = 0;
    private int z = 0;

    public ParkourNode(int x, int z) {
        this.x = x;
        this.z = z;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public boolean isVisited() {
        return this.visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public boolean isNeighbour(ParkourNode node) {
        if (this.getDistance(node) < 1.5) {
            return false;
        }
        if (this.height >= node.height) {
            return this.getDistance(node) <= 4.0;
        }
        if (this.height + 1 == node.height) {
            return this.getDistance(node) <= 3.0;
        }
        return false;
    }

    public double getDistance(ParkourNode node) {
        return Math.sqrt(Math.pow(this.x - node.x, 2.0) + Math.pow(this.z - node.z, 2.0));
    }

    public int getX() {
        return this.x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getZ() {
        return this.z;
    }

    public void setZ(int z) {
        this.z = z;
    }
}

