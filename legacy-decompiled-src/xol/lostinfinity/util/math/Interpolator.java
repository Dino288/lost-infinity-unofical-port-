/*
 * Decompiled with CFR 0.152.
 */
package xol.lostinfinity.util.math;

import xol.lostinfinity.util.math.ComplexInterpolator;

public class Interpolator<T>
extends ComplexInterpolator<T, T> {
    public Interpolator() {
        this.setParseFunc(value -> value);
    }
}

