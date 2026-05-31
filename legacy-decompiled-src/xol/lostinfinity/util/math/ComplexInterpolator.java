/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package xol.lostinfinity.util.math;

import java.util.TreeMap;
import javax.annotation.Nullable;

public class ComplexInterpolator<T, R>
extends TreeMap<Float, T> {
    private Interpolation<T, R> interpolateFunc;
    private Parse<T, R> parseFunc;
    private R defaultValue = null;

    public ComplexInterpolator<T, R> setInterpolateFunc(Interpolation<T, R> interpolateFunc) {
        this.interpolateFunc = interpolateFunc;
        return this;
    }

    public ComplexInterpolator<T, R> setParseFunc(Parse<T, R> parseFunc) {
        this.parseFunc = parseFunc;
        return this;
    }

    public ComplexInterpolator<T, R> setDefaultValue(R value) {
        this.defaultValue = value;
        return this;
    }

    @Nullable
    public R interpolate(float key) {
        float lastKey;
        if (this.isEmpty()) {
            return this.defaultValue;
        }
        if (this.containsKey(Float.valueOf(key))) {
            return this.parseFunc.parse(this.get(Float.valueOf(key)));
        }
        float nextKey = this.getHigherKey(key);
        if (nextKey == (lastKey = this.getLowerKey(key))) {
            return this.parseFunc.parse(this.get(Float.valueOf(lastKey)));
        }
        float t = (key - lastKey) / (nextKey - lastKey);
        Object next = this.get(Float.valueOf(nextKey));
        Object prev = this.get(Float.valueOf(lastKey));
        return this.interpolateFunc.interpolate(new Context(lastKey, nextKey), prev, next, t);
    }

    public float getHigherKey(float time) {
        Float high = this.higherKey(Float.valueOf(time));
        if (high == null) {
            return ((Float)this.lastKey()).floatValue();
        }
        return high.floatValue();
    }

    public float getLowerKey(float time) {
        Float low = this.lowerKey(Float.valueOf(time));
        if (low == null) {
            return ((Float)this.firstKey()).floatValue();
        }
        return low.floatValue();
    }

    public static class Context {
        public final float prevKey;
        public final float nextKey;

        public Context(float prevKey, float nextKey) {
            this.prevKey = prevKey;
            this.nextKey = nextKey;
        }
    }

    @FunctionalInterface
    public static interface Parse<T, R> {
        public R parse(T var1);
    }

    @FunctionalInterface
    public static interface Interpolation<T, R> {
        public R interpolate(Context var1, T var2, T var3, float var4);
    }
}

