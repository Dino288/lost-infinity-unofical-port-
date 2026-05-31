/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.math.Vec3
 */
package xol.lostinfinity.util.animation.client.keyframe;

import net.minecraft.world.phys.Vec3;
import xol.lostinfinity.util.animation.client.keyframe.AbstractKeyframe;
import xol.lostinfinity.util.animation.client.keyframe.KeyframeType;

public class ScaleKeyframe
extends AbstractKeyframe<Vec3> {
    public ScaleKeyframe(Vec3 value) {
        super(value);
    }

    public ScaleKeyframe(Vec3 value, KeyframeType type) {
        super(value, type);
    }
}

