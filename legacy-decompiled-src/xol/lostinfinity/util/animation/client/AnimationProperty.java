/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.math.Vec3
 */
package xol.lostinfinity.util.animation.client;

import java.util.function.Supplier;
import net.minecraft.world.phys.Vec3;
import xol.lostinfinity.util.animation.client.blueprint.Animation;
import xol.lostinfinity.util.animation.client.blueprint.LoopMode;
import xol.lostinfinity.util.animation.client.blueprint.Timeline;
import xol.lostinfinity.util.math.EulerAngle;

public class AnimationProperty {
    public final Supplier<Animation> animationSupplier;
    public Animation animation;
    public LoopMode loopMode = LoopMode.NONE;
    public boolean isOverride;
    public float time;
    public float speedModifier;
    public boolean stopped;

    public AnimationProperty(Supplier<Animation> animation) {
        this.animationSupplier = animation;
    }

    public void refresh() {
        this.animation = this.animationSupplier.get();
        this.loopMode = this.animation.loopMode;
        this.isOverride = this.animation.isOverride;
    }

    public void update(float partialTick) {
        if (this.stopped) {
            return;
        }
        this.time += partialTick * this.speedModifier;
        if (this.time > this.animation.duration) {
            switch (this.loopMode) {
                case NONE: {
                    this.stop();
                    break;
                }
                case LOOP: {
                    this.time %= this.animation.duration;
                    break;
                }
                case HOLD: {
                    this.time = this.animation.duration;
                }
            }
        }
    }

    public Vec3 getPosition(String bone) {
        Timeline timeline = this.animation.timelines.get(bone);
        if (timeline == null) {
            return null;
        }
        return timeline.position.interpolate(this.time);
    }

    public EulerAngle getRotation(String bone) {
        Timeline timeline = this.animation.timelines.get(bone);
        if (timeline == null) {
            return null;
        }
        return timeline.rotation.interpolate(this.time);
    }

    public Vec3 getScale(String bone) {
        Timeline timeline = this.animation.timelines.get(bone);
        if (timeline == null) {
            return null;
        }
        return timeline.scale.interpolate(this.time);
    }

    public void stop() {
        this.stopped = true;
    }
}

