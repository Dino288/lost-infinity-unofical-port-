/*
 * Decompiled with CFR 0.152.
 */
package xol.lostinfinity.dimension.data;

public class LightSwitchNode {
    private int x;
    private int y;
    private int z;
    private boolean[] lights = null;
    private boolean switched = false;

    public LightSwitchNode(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public boolean isSwitched() {
        return this.switched;
    }

    public void toggle() {
        this.switched = !this.switched;
    }

    public boolean[] getLights() {
        return this.lights;
    }

    public void setLights(boolean[] lights) {
        this.lights = (boolean[])lights.clone();
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

