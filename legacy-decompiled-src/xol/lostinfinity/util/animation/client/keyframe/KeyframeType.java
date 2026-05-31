/*
 * Decompiled with CFR 0.152.
 */
package xol.lostinfinity.util.animation.client.keyframe;

public enum KeyframeType {
    LINEAR,
    SMOOTH,
    STEP;


    public static KeyframeType parse(String val) {
        if ("catmullrom".equals(val)) {
            return SMOOTH;
        }
        if ("step".equals(val)) {
            return STEP;
        }
        return LINEAR;
    }
}

