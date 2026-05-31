/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.util.math.AABB
 *  net.minecraft.util.math.Mth
 *  net.minecraft.util.math.Rotations
 *  net.minecraft.util.math.Vec3
 *  org.lwjgl.util.vector.Quaternion
 */
package xol.lostinfinity.util.math;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.AABB;
import net.minecraft.util.Mth;
import net.minecraft.util.math.Rotations;
import net.minecraft.world.phys.Vec3;
import org.lwjgl.util.vector.Quaternion;

public class LMath {
    public static final float DEG2RAD = (float)Math.PI / 180;
    public static final float RAD2DEG = 57.29578f;
    public static final float PI = (float)Math.PI;

    public static float fastSqrt(float value) {
        return (float)(1.0 / Mth.func_181161_i((double)value));
    }

    public static double fastSqrt(double value) {
        return 1.0 / Mth.func_181161_i((double)value);
    }

    public static Vec3 getCenter(AABB boundingBox) {
        return new Vec3(boundingBox.field_72340_a + (boundingBox.field_72336_d - boundingBox.field_72340_a) * 0.5, boundingBox.field_72338_b + (boundingBox.field_72337_e - boundingBox.field_72338_b) * 0.5, boundingBox.field_72339_c + (boundingBox.field_72334_f - boundingBox.field_72339_c) * 0.5);
    }

    public static double getDistanceSquaredToAABB(Vec3 start, AABB boundingBox) {
        Vec3 delta = start.func_178788_d(LMath.getCenter(boundingBox));
        double sizeX = boundingBox.field_72336_d - boundingBox.field_72340_a;
        double sizeY = boundingBox.field_72337_e - boundingBox.field_72338_b;
        double sizeZ = boundingBox.field_72334_f - boundingBox.field_72339_c;
        Vec3 q = new Vec3(Math.max(Math.abs(delta.field_72450_a) - sizeX / 2.0, 0.0), Math.max(Math.abs(delta.field_72448_b) - sizeY / 2.0, 0.0), Math.max(Math.abs(delta.field_72449_c) - sizeZ / 2.0, 0.0));
        return q.func_189985_c();
    }

    public static boolean isAABBWithinDistance(Vec3 start, AABB boundingBox, double maxDistance) {
        return LMath.getDistanceSquaredToAABB(start, boundingBox) < maxDistance * maxDistance;
    }

    public static boolean isAABBWithinDistance(Vec3 start, Vec3 direction, AABB boundingBox, double maxDistance) {
        double tzMax;
        double tzMin;
        double tyMax;
        double tyMin;
        double tMax;
        double tMin;
        double startX = start.field_72450_a;
        double startY = start.field_72448_b;
        double startZ = start.field_72449_c;
        Vec3 dir = LMath.fastNormalize(direction);
        double dirX = dir.field_72450_a;
        double dirY = dir.field_72448_b;
        double dirZ = dir.field_72449_c;
        double divX = 1.0 / dirX;
        double divY = 1.0 / dirY;
        double divZ = 1.0 / dirZ;
        if (dirX >= 0.0) {
            tMin = (boundingBox.field_72340_a - startX) * divX;
            tMax = (boundingBox.field_72336_d - startX) * divX;
        } else {
            tMin = (boundingBox.field_72336_d - startX) * divX;
            tMax = (boundingBox.field_72340_a - startX) * divX;
        }
        if (dirY >= 0.0) {
            tyMin = (boundingBox.field_72338_b - startY) * divY;
            tyMax = (boundingBox.field_72337_e - startY) * divY;
        } else {
            tyMin = (boundingBox.field_72337_e - startY) * divY;
            tyMax = (boundingBox.field_72338_b - startY) * divY;
        }
        if (tMin > tyMax || tMax < tyMin) {
            return false;
        }
        if (tyMin > tMin) {
            tMin = tyMin;
        }
        if (tyMax < tMax) {
            tMax = tyMax;
        }
        if (dirZ >= 0.0) {
            tzMin = (boundingBox.field_72339_c - startZ) * divZ;
            tzMax = (boundingBox.field_72334_f - startZ) * divZ;
        } else {
            tzMin = (boundingBox.field_72334_f - startZ) * divZ;
            tzMax = (boundingBox.field_72339_c - startZ) * divZ;
        }
        if (tMin > tzMax || tMax < tzMin) {
            return false;
        }
        if (tzMin > tMin) {
            tMin = tzMin;
        }
        if (tzMax < tMax) {
            tMax = tzMax;
        }
        if (tMax < 0.0) {
            return false;
        }
        return !(tMin > maxDistance);
    }

    public static float degreeDifference(float a, float b) {
        return Mth.func_76142_g((float)(b - a));
    }

    public static Quaternion fromRotations(Rotations rotations) {
        return LMath.fromEulerRadian(rotations.func_179415_b() * ((float)Math.PI / 180), rotations.func_179416_c() * ((float)Math.PI / 180), rotations.func_179413_d() * ((float)Math.PI / 180));
    }

    public static Quaternion fromEulerDegree(float x, float y, float z) {
        return LMath.fromEulerRadian(x * ((float)Math.PI / 180), y * ((float)Math.PI / 180), z * ((float)Math.PI / 180));
    }

    public static Quaternion fromEulerRadian(float rX, float rY, float rZ) {
        float sX = Mth.func_76126_a((float)(0.5f * -rX));
        float cX = Mth.func_76134_b((float)(0.5f * -rX));
        float sY = Mth.func_76126_a((float)(0.5f * rY));
        float cY = Mth.func_76134_b((float)(0.5f * rY));
        float sZ = Mth.func_76126_a((float)(0.5f * rZ));
        float cZ = Mth.func_76134_b((float)(0.5f * rZ));
        return new Quaternion(sX * cY * cZ + cX * sY * sZ, cX * sY * cZ - sX * cY * sZ, sX * sY * cZ + cX * cY * sZ, cX * cY * cZ - sX * sY * sZ);
    }

    public static Rotations toEulerAngle(Quaternion quaternion) {
        double z;
        double x;
        double x2 = quaternion.x + quaternion.x;
        double y2 = quaternion.y + quaternion.y;
        double z2 = quaternion.z + quaternion.z;
        double xx = (double)quaternion.x * x2;
        double xy = (double)quaternion.x * y2;
        double xz = (double)quaternion.x * z2;
        double yy = (double)quaternion.y * y2;
        double yz = (double)quaternion.y * z2;
        double zz = (double)quaternion.z * z2;
        double wx = (double)quaternion.w * x2;
        double wy = (double)quaternion.w * y2;
        double wz = (double)quaternion.w * z2;
        double m11 = 1.0 - (yy + zz);
        double m12 = xy + wz;
        double m21 = xy - wz;
        double m22 = 1.0 - (xx + zz);
        double m31 = xz + wy;
        double m32 = yz - wx;
        double m33 = 1.0 - (xx + yy);
        double y = Math.asin(-Mth.func_151237_a((double)m31, (double)-1.0, (double)1.0));
        if (Math.abs(m31) < 0.9999999) {
            x = Mth.func_181159_b((double)m32, (double)m33);
            z = Mth.func_181159_b((double)m21, (double)m11);
        } else {
            x = 0.0;
            z = Mth.func_181159_b((double)(-m12), (double)m22);
        }
        return new Rotations((float)x * 57.29578f, (float)y * 57.29578f, (float)z * 57.29578f);
    }

    public static Quaternion globalRotate(Quaternion origin, Quaternion delta) {
        return Quaternion.mul((Quaternion)origin, (Quaternion)delta, null);
    }

    public static Quaternion localRotate(Quaternion origin, Quaternion delta) {
        return Quaternion.mul((Quaternion)delta, (Quaternion)origin, null);
    }

    public static Rotations toPitchYaw(Vec3 dir) {
        double hMagnitude = LMath.fastSqrt(dir.field_72450_a * dir.field_72450_a + dir.field_72449_c * dir.field_72449_c);
        float pitch = (float)Mth.func_181159_b((double)(-dir.field_72448_b), (double)hMagnitude) * 57.29578f;
        float yaw = (float)Mth.func_181159_b((double)(-dir.field_72450_a), (double)dir.field_72449_c) * 57.29578f;
        return new Rotations(pitch, yaw, 0.0f);
    }

    public static Vec3 toLookVec(float pitch, float yaw) {
        float f = Mth.func_76134_b((float)(-yaw * ((float)Math.PI / 180) - (float)Math.PI));
        float f1 = Mth.func_76126_a((float)(-yaw * ((float)Math.PI / 180) - (float)Math.PI));
        float f2 = -Mth.func_76134_b((float)(-pitch * ((float)Math.PI / 180)));
        float f3 = Mth.func_76126_a((float)(-pitch * ((float)Math.PI / 180)));
        return new Vec3((double)(f1 * f2), (double)f3, (double)(f * f2));
    }

    public static byte rotToByte(float rot) {
        return (byte)(rot * 0.7111111f);
    }

    public static float byteToRot(byte rot) {
        return (float)rot * 1.40625f;
    }

    public static float degreeLerp(float start, float end, double ratio) {
        return (float)((double)start + (double)LMath.degreeDifference(start, end) * ratio);
    }

    public static Vec3 lerp(Vec3 start, Vec3 end, double ratio) {
        return new Vec3(Mth.func_151238_b((double)start.field_72450_a, (double)end.field_72450_a, (double)ratio), Mth.func_151238_b((double)start.field_72448_b, (double)end.field_72448_b, (double)ratio), Mth.func_151238_b((double)start.field_72449_c, (double)end.field_72449_c, (double)ratio));
    }

    public static Rotations lerp(Rotations a, Rotations b, double t) {
        return new Rotations(LMath.degreeLerp(a.func_179415_b(), b.func_179415_b(), t), LMath.degreeLerp(a.func_179416_c(), b.func_179416_c(), t), LMath.degreeLerp(a.func_179413_d(), b.func_179413_d(), t));
    }

    public static float lerp(float a, float b, double aT, double bT) {
        return (float)(aT * (double)a + bT * (double)b);
    }

    public static Quaternion lerp(Quaternion a, Quaternion b, double aT, double bT) {
        return new Quaternion(LMath.lerp(a.x, b.x, aT, bT), LMath.lerp(a.y, b.y, aT, bT), LMath.lerp(a.z, b.z, aT, bT), LMath.lerp(a.w, b.w, aT, bT)).normalise(null);
    }

    public static Quaternion onlerp(Quaternion a, Quaternion b, double t) {
        float ca = Quaternion.dot((Quaternion)a, (Quaternion)b);
        t = LMath.aprox(ca, (float)t);
        return LMath.lerp(a, b, 1.0 - t, ca > 0.0f ? t : -t);
    }

    public static Rotations slerp(Rotations a, Rotations b, double t) {
        return LMath.toEulerAngle(LMath.onlerp(LMath.fromRotations(a), LMath.fromRotations(b), t));
    }

    public static String toString(Rotations angle) {
        return String.format("[%s, %s, %s]", Float.valueOf(angle.func_179415_b()), Float.valueOf(angle.func_179416_c()), Float.valueOf(angle.func_179413_d()));
    }

    public static double fastLength(Vec3 vector) {
        double lSqr = vector.func_189985_c();
        return lSqr * Mth.func_181161_i((double)lSqr);
    }

    public static double fastLength(double x, double y, double z) {
        double lSqr = x * x + y * y + z * z;
        return lSqr * Mth.func_181161_i((double)lSqr);
    }

    public static Vec3 fastNormalize(Vec3 vector) {
        return vector.func_186678_a(Mth.func_181161_i((double)vector.func_189985_c()));
    }

    public static Vec3 getEntityMiddle(Entity entity) {
        return new Vec3(entity.field_70165_t, entity.field_70163_u + (double)(entity.field_70131_O / 2.0f), entity.field_70161_v);
    }

    public static double trig01(double value) {
        return (value + 1.0) * 0.5;
    }

    private static float aprox(float ca, float r) {
        float diff = Math.abs(ca);
        float a = 1.0904f + diff * (-3.2452f + diff * (3.55645f - diff * 1.43519f));
        float b = 0.848013f + diff * (-1.06021f + diff * 0.215638f);
        float k = a * (r - 0.5f) * (r - 0.5f) + b;
        return r + r * (r - 0.5f) * (r - 1.0f) * k;
    }
}

