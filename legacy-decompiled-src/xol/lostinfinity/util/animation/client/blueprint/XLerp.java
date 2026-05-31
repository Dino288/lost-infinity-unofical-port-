/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.math.Mth
 *  net.minecraft.util.math.Vec3
 */
package xol.lostinfinity.util.animation.client.blueprint;

import net.minecraft.util.Mth;
import net.minecraft.world.phys.Vec3;
import xol.lostinfinity.util.math.EulerAngle;

public class XLerp {
    public static float lerp(float a, float b, double aT, double bT) {
        return (float)(aT * (double)a + bT * (double)b);
    }

    public static double lerp(double a, double b, double aT, double bT) {
        return aT * a + bT * b;
    }

    public static Vec3 lerp(Vec3 start, Vec3 end, double ratio) {
        return new Vec3(Mth.func_151238_b((double)start.field_72450_a, (double)end.field_72450_a, (double)ratio), Mth.func_151238_b((double)start.field_72448_b, (double)end.field_72448_b, (double)ratio), Mth.func_151238_b((double)start.field_72449_c, (double)end.field_72449_c, (double)ratio));
    }

    public static Vec3 lerp(Vec3 a, Vec3 b, double aT, double bT) {
        return new Vec3(XLerp.lerp(a.field_72450_a, b.field_72450_a, aT, bT), XLerp.lerp(a.field_72448_b, b.field_72448_b, aT, bT), XLerp.lerp(a.field_72449_c, b.field_72449_c, aT, bT));
    }

    public static Vec3 smoothLerp(Vec3 a, Vec3 b, Vec3 c, Vec3 d, double t) {
        double t0 = 0.0;
        double t1 = 1.0;
        double t2 = 2.0;
        double t3 = 3.0;
        t = (t2 - t1) * t + t1;
        Vec3 a1 = XLerp.lerp(a, b, (t1 - t) / (t1 - t0), (t - t0) / (t1 - t0));
        Vec3 a2 = XLerp.lerp(b, c, (t2 - t) / (t2 - t1), (t - t1) / (t2 - t1));
        Vec3 a3 = XLerp.lerp(c, d, (t3 - t) / (t3 - t2), (t - t2) / (t3 - t2));
        Vec3 b1 = XLerp.lerp(a1, a2, (t2 - t) / (t2 - t0), (t - t0) / (t2 - t0));
        Vec3 b2 = XLerp.lerp(a2, a3, (t3 - t) / (t3 - t1), (t - t1) / (t3 - t1));
        return XLerp.lerp(b1, b2, (t2 - t) / (t2 - t1), (t - t1) / (t2 - t1));
    }

    public static EulerAngle lerp(EulerAngle start, EulerAngle end, double ratio) {
        return new EulerAngle((float)Mth.func_151238_b((double)start.getX(), (double)end.getX(), (double)ratio), (float)Mth.func_151238_b((double)start.getY(), (double)end.getY(), (double)ratio), (float)Mth.func_151238_b((double)start.getZ(), (double)end.getZ(), (double)ratio));
    }

    public static EulerAngle lerp(EulerAngle a, EulerAngle b, double aT, double bT) {
        return new EulerAngle(XLerp.lerp(a.getX(), b.getX(), aT, bT), XLerp.lerp(a.getY(), b.getY(), aT, bT), XLerp.lerp(a.getZ(), b.getZ(), aT, bT));
    }

    public static EulerAngle smoothLerp(EulerAngle a, EulerAngle b, EulerAngle c, EulerAngle d, double t) {
        double t0 = 0.0;
        double t1 = 1.0;
        double t2 = 2.0;
        double t3 = 3.0;
        t = (t2 - t1) * t + t1;
        EulerAngle a1 = XLerp.lerp(a, b, (t1 - t) / (t1 - t0), (t - t0) / (t1 - t0));
        EulerAngle a2 = XLerp.lerp(b, c, (t2 - t) / (t2 - t1), (t - t1) / (t2 - t1));
        EulerAngle a3 = XLerp.lerp(c, d, (t3 - t) / (t3 - t2), (t - t2) / (t3 - t2));
        EulerAngle b1 = XLerp.lerp(a1, a2, (t2 - t) / (t2 - t0), (t - t0) / (t2 - t0));
        EulerAngle b2 = XLerp.lerp(a2, a3, (t3 - t) / (t3 - t1), (t - t1) / (t3 - t1));
        return XLerp.lerp(b1, b2, (t2 - t) / (t2 - t1), (t - t1) / (t2 - t1));
    }
}

