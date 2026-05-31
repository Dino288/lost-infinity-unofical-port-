/*
 * Decompiled with CFR 0.152.
 */
package xol.lostinfinity.util.animation.client.keyframe;

import xol.lostinfinity.util.animation.client.keyframe.KeyframeType;

public abstract class AbstractKeyframe<T> {
    private T value;
    private KeyframeType type;

    public KeyframeType getType() {
        return this.type;
    }

    public void setType(KeyframeType type) {
        this.type = type;
    }

    public T getValue() {
        return this.value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public AbstractKeyframe(T value) {
        this(value, KeyframeType.LINEAR);
    }

    public AbstractKeyframe(T value, KeyframeType type) {
        this.value = value;
        this.type = type;
    }
}

