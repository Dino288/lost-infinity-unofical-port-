/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.math.Vec3
 */
package xol.lostinfinity.util.math;

import net.minecraft.world.phys.Vec3;
import xol.lostinfinity.util.math.LMath;

public class BezierCurve {
    public static Vec3 lerpNodes(Node start, Node end, double ratio) {
        Vec3 a1 = LMath.lerp(start.node, start.handleEnd, ratio);
        Vec3 a2 = LMath.lerp(start.handleEnd, end.handleStart, ratio);
        Vec3 a3 = LMath.lerp(end.handleStart, end.node, ratio);
        Vec3 b1 = LMath.lerp(a1, a2, ratio);
        Vec3 b2 = LMath.lerp(a2, a3, ratio);
        return LMath.lerp(b1, b2, ratio);
    }

    public static class Node {
        public final Vec3 node;
        public final Vec3 handleStart;
        public final Vec3 handleEnd;

        public Node(Vec3 node, Vec3 handleStart, Vec3 handleEnd) {
            this.node = node;
            this.handleStart = handleStart;
            this.handleEnd = handleEnd;
        }
    }
}

