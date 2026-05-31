/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.LazyLoadBase
 */
package xol.lostinfinity.util.load;

import java.util.Objects;
import java.util.function.Supplier;
import net.minecraft.util.LazyLoadBase;

public class CustomLazyLoad<T>
extends LazyLoadBase<T> {
    private Supplier<T> func;

    public CustomLazyLoad(Supplier<T> func) {
        this.func = func;
        Objects.requireNonNull(func);
    }

    protected T func_179280_b() {
        return this.func.get();
    }
}

