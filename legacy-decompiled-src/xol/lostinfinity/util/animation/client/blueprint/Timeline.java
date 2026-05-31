/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.math.Vec3
 */
package xol.lostinfinity.util.animation.client.blueprint;

import net.minecraft.world.phys.Vec3;
import xol.lostinfinity.util.animation.client.blueprint.XLerp;
import xol.lostinfinity.util.animation.client.keyframe.AbstractKeyframe;
import xol.lostinfinity.util.animation.client.keyframe.KeyframeType;
import xol.lostinfinity.util.animation.client.keyframe.PositionKeyframe;
import xol.lostinfinity.util.animation.client.keyframe.RotationKeyframe;
import xol.lostinfinity.util.animation.client.keyframe.ScaleKeyframe;
import xol.lostinfinity.util.math.ComplexInterpolator;
import xol.lostinfinity.util.math.EulerAngle;

public class Timeline {
    public final ComplexInterpolator<PositionKeyframe, Vec3> position = new ComplexInterpolator<PositionKeyframe, Vec3>().setParseFunc(AbstractKeyframe::getValue);
    public final ComplexInterpolator<RotationKeyframe, EulerAngle> rotation = new ComplexInterpolator<RotationKeyframe, EulerAngle>().setParseFunc(AbstractKeyframe::getValue);
    public final ComplexInterpolator<ScaleKeyframe, Vec3> scale = new ComplexInterpolator<ScaleKeyframe, Vec3>().setParseFunc(AbstractKeyframe::getValue);

    public Timeline() {
        this.position.setInterpolateFunc((ctx, prev, next, ratio) -> {
            switch (Timeline.getType(prev, next)) {
                case LINEAR: {
                    return XLerp.lerp((Vec3)prev.getValue(), (Vec3)next.getValue(), (double)ratio);
                }
                case SMOOTH: {
                    PositionKeyframe pPrev = (PositionKeyframe)this.position.get(Float.valueOf(this.position.getLowerKey(ctx.prevKey)));
                    PositionKeyframe nNext = (PositionKeyframe)this.position.get(Float.valueOf(this.position.getHigherKey(ctx.nextKey)));
                    return XLerp.smoothLerp((Vec3)pPrev.getValue(), (Vec3)prev.getValue(), (Vec3)next.getValue(), (Vec3)nNext.getValue(), (double)ratio);
                }
                case STEP: {
                    return (Vec3)prev.getValue();
                }
            }
            return Vec3.field_186680_a;
        });
        this.rotation.setInterpolateFunc((ctx, prev, next, ratio) -> {
            switch (Timeline.getType(prev, next)) {
                case LINEAR: {
                    return XLerp.lerp((EulerAngle)prev.getValue(), (EulerAngle)next.getValue(), (double)ratio);
                }
                case SMOOTH: {
                    RotationKeyframe pPrev = (RotationKeyframe)this.rotation.get(Float.valueOf(this.rotation.getLowerKey(ctx.prevKey)));
                    RotationKeyframe nNext = (RotationKeyframe)this.rotation.get(Float.valueOf(this.rotation.getHigherKey(ctx.nextKey)));
                    return XLerp.smoothLerp((EulerAngle)pPrev.getValue(), (EulerAngle)prev.getValue(), (EulerAngle)next.getValue(), (EulerAngle)nNext.getValue(), (double)ratio);
                }
                case STEP: {
                    return (EulerAngle)prev.getValue();
                }
            }
            return new EulerAngle(0.0f, 0.0f, 0.0f);
        });
        this.scale.setInterpolateFunc((ctx, prev, next, ratio) -> {
            switch (Timeline.getType(prev, next)) {
                case LINEAR: {
                    return XLerp.lerp((Vec3)prev.getValue(), (Vec3)next.getValue(), (double)ratio);
                }
                case SMOOTH: {
                    ScaleKeyframe pPrev = (ScaleKeyframe)this.scale.get(Float.valueOf(this.scale.getLowerKey(ctx.prevKey)));
                    ScaleKeyframe nNext = (ScaleKeyframe)this.scale.get(Float.valueOf(this.scale.getHigherKey(ctx.nextKey)));
                    return XLerp.smoothLerp((Vec3)pPrev.getValue(), (Vec3)prev.getValue(), (Vec3)next.getValue(), (Vec3)nNext.getValue(), (double)ratio);
                }
                case STEP: {
                    return (Vec3)prev.getValue();
                }
            }
            return new Vec3(1.0, 1.0, 1.0);
        });
    }

    public static KeyframeType getType(AbstractKeyframe<?> last, AbstractKeyframe<?> next) {
        if (last.getType() == KeyframeType.STEP) {
            return KeyframeType.STEP;
        }
        if (last.getType() == KeyframeType.SMOOTH || next.getType() == KeyframeType.SMOOTH) {
            return KeyframeType.SMOOTH;
        }
        return KeyframeType.LINEAR;
    }
}

