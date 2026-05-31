/*
 * Decompiled with CFR 0.152.
 */
package xol.lostinfinity.util.animation.client.blueprint;

public enum LoopMode {
    NONE,
    LOOP,
    HOLD;


    public static LoopMode parse(String val) {
        if ("hold_on_last_frame".equals(val)) {
            return HOLD;
        }
        if ("true".equals(val)) {
            return LOOP;
        }
        return NONE;
    }
}

