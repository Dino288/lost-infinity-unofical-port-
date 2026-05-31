/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.Maps
 *  net.minecraft.util.math.Vec3
 */
package xol.lostinfinity.util.animation.client;

import com.google.common.collect.Maps;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import net.minecraft.world.phys.Vec3;
import xol.lostinfinity.util.animation.client.AnimationProperty;
import xol.lostinfinity.util.animation.client.blueprint.Animation;
import xol.lostinfinity.util.animation.client.blueprint.AnimationBlueprint;
import xol.lostinfinity.util.animation.model.IXolModel;
import xol.lostinfinity.util.animation.model.ModelRenderer;
import xol.lostinfinity.util.math.EulerAngle;

public class AnimationHandler {
    private final Map<String, AnimationProperty> animations = Maps.newConcurrentMap();
    private final Set<Runnable> queue = new HashSet<Runnable>();
    private AnimationBlueprint blueprint;

    public AnimationBlueprint getBlueprint() {
        return this.blueprint;
    }

    public void setBlueprint(AnimationBlueprint blueprint) {
        if (this.blueprint == blueprint) {
            return;
        }
        this.blueprint = blueprint;
        this.animations.values().forEach(AnimationProperty::refresh);
    }

    public Map<String, AnimationProperty> getAnimations() {
        return this.animations;
    }

    public void update(IXolModel model, float partialTick) {
        this.queue.forEach(Runnable::run);
        this.queue.clear();
        for (String id : this.animations.keySet()) {
            AnimationProperty property = this.animations.get(id);
            if (property == null || property.stopped || !this.blueprint.getAnimations().containsKey(id)) {
                this.animations.remove(id);
                continue;
            }
            property.update(partialTick);
        }
        for (String bone : model.getIndex().keySet()) {
            ModelRenderer renderer = model.getIndex().get(bone);
            renderer.reset();
            for (String id : this.blueprint.getAnimations().keySet()) {
                AnimationProperty property = this.animations.get(id);
                if (property == null) continue;
                Vec3 position = property.getPosition(bone);
                EulerAngle rotation = property.getRotation(bone);
                Vec3 scale = property.getScale(bone);
                if (position != null) {
                    if (property.isOverride) {
                        renderer.resetPosition();
                    }
                    renderer.field_82906_o = (float)((double)renderer.field_82906_o + position.field_72450_a * 0.0625);
                    renderer.field_82908_p = (float)((double)renderer.field_82908_p + -position.field_72448_b * 0.0625);
                    renderer.field_82907_q = (float)((double)renderer.field_82907_q + position.field_72449_c * 0.0625);
                }
                if (rotation != null) {
                    if (property.isOverride) {
                        renderer.resetRotation();
                    }
                    renderer.field_78795_f += rotation.getX() * ((float)Math.PI / 180);
                    renderer.field_78796_g += rotation.getY() * ((float)Math.PI / 180);
                    renderer.field_78808_h += rotation.getZ() * ((float)Math.PI / 180);
                }
                if (scale == null) continue;
                if (property.isOverride) {
                    renderer.resetScale();
                }
                renderer.scaleX = (float)((double)renderer.scaleX * scale.field_72450_a);
                renderer.scaleY = (float)((double)renderer.scaleY * scale.field_72448_b);
                renderer.scaleZ = (float)((double)renderer.scaleZ * scale.field_72449_c);
            }
        }
    }

    public void play(String id) {
        this.play(id, null);
    }

    public void play(String id, Consumer<AnimationProperty> consumer) {
        if (this.blueprint == null) {
            this.queue.add(() -> this.playInternal(id, consumer));
            return;
        }
        this.playInternal(id, consumer);
    }

    private void playInternal(String id, Consumer<AnimationProperty> consumer) {
        String animationId = id.toLowerCase(Locale.ROOT);
        Animation animation = this.blueprint.getAnimation(animationId);
        if (animation == null) {
            return;
        }
        AnimationProperty property = new AnimationProperty(() -> this.getBlueprint().getAnimation(animationId));
        property.refresh();
        property.speedModifier = 1.0f;
        if (consumer != null) {
            consumer.accept(property);
        }
        this.animations.put(animationId, property);
    }

    public void stop(String id) {
        AnimationProperty property = this.animations.get(id = id.toLowerCase(Locale.ROOT));
        if (property != null) {
            property.stop();
        }
    }
}

