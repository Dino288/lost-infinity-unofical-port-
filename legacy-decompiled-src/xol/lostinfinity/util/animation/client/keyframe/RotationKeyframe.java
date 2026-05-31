/*
 * Decompiled with CFR 0.152.
 */
package xol.lostinfinity.util.animation.client.keyframe;

import xol.lostinfinity.util.animation.client.keyframe.AbstractKeyframe;
import xol.lostinfinity.util.animation.client.keyframe.KeyframeType;
import xol.lostinfinity.util.math.EulerAngle;

public class RotationKeyframe
extends AbstractKeyframe<EulerAngle> {
    public RotationKeyframe(EulerAngle value) {
        super(value);
    }

    public RotationKeyframe(EulerAngle value, KeyframeType type) {
        super(value, type);
    }
}

