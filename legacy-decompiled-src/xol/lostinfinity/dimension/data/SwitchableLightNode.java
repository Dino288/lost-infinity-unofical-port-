/*
 * Decompiled with CFR 0.152.
 */
package xol.lostinfinity.dimension.data;

public class SwitchableLightNode {
    private int x;
    private int y;
    private int z;
    private boolean lit;

    public SwitchableLightNode(int x, int y, int z, boolean lit) {
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
}

