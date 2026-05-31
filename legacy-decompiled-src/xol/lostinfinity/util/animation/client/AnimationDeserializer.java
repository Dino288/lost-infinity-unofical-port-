/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.JsonArray
 *  com.google.gson.JsonDeserializationContext
 *  com.google.gson.JsonDeserializer
 *  com.google.gson.JsonElement
 *  com.google.gson.JsonObject
 *  com.google.gson.JsonParseException
 *  net.minecraft.util.math.Vec3
 */
package xol.lostinfinity.util.animation.client;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.function.Function;
import net.minecraft.world.phys.Vec3;
import xol.lostinfinity.util.animation.client.blueprint.Animation;
import xol.lostinfinity.util.animation.client.blueprint.AnimationBlueprint;
import xol.lostinfinity.util.animation.client.blueprint.LoopMode;
import xol.lostinfinity.util.animation.client.blueprint.Timeline;
import xol.lostinfinity.util.animation.client.keyframe.KeyframeType;
import xol.lostinfinity.util.animation.client.keyframe.PositionKeyframe;
import xol.lostinfinity.util.animation.client.keyframe.RotationKeyframe;
import xol.lostinfinity.util.animation.client.keyframe.ScaleKeyframe;
import xol.lostinfinity.util.math.ComplexInterpolator;
import xol.lostinfinity.util.math.EulerAngle;

public class AnimationDeserializer
implements JsonDeserializer<AnimationBlueprint> {
    public AnimationBlueprint deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        AnimationBlueprint blueprint = new AnimationBlueprint();
        JsonObject root = json.getAsJsonObject();
        if (root.has("animations")) {
            JsonObject animations = root.getAsJsonObject("animations");
            for (Map.Entry entry : animations.entrySet()) {
                String id = (String)entry.getKey();
                JsonObject data = ((JsonElement)entry.getValue()).getAsJsonObject();
                LoopMode loopMode = data.has("loop") ? LoopMode.parse(data.get("loop").getAsString()) : LoopMode.NONE;
                boolean isOverride = data.has("override_previous_animation") && data.get("override_previous_animation").getAsBoolean();
                float duration = data.get("animation_length").getAsFloat() * 20.0f;
                Animation animation = new Animation(id, loopMode, isOverride, duration);
                if (data.has("bones")) {
                    JsonObject bones = data.getAsJsonObject("bones");
                    for (Map.Entry bone : bones.entrySet()) {
                        String boneId = (String)bone.getKey();
                        Timeline timeline = this.parseTimeline(((JsonElement)bone.getValue()).getAsJsonObject());
                        animation.timelines.put(boneId, timeline);
                    }
                }
                blueprint.addAnimation(id, animation);
            }
        }
        return blueprint;
    }

    private Timeline parseTimeline(JsonObject object) {
        Timeline timeline = new Timeline();
        if (object.has("position")) {
            this.insertKeyframes(object.get("position"), timeline.position, this::getPosition);
        }
        if (object.has("rotation")) {
            this.insertKeyframes(object.get("rotation"), timeline.rotation, this::getRotation);
        }
        if (object.has("scale")) {
            this.insertKeyframes(object.get("scale"), timeline.scale, this::getScale);
        }
        return timeline;
    }

    private <T> void insertKeyframes(JsonElement element, ComplexInterpolator<T, ?> timeline, Function<JsonElement, T> function) {
        if (element.isJsonArray()) {
            timeline.put(Float.valueOf(0.0f), function.apply(element));
        } else {
            JsonObject obj = element.getAsJsonObject();
            for (Map.Entry bone : obj.entrySet()) {
                float time = Float.parseFloat((String)bone.getKey()) * 20.0f;
                timeline.put(Float.valueOf(time), function.apply((JsonElement)bone.getValue()));
            }
        }
    }

    private PositionKeyframe getPosition(JsonElement element) {
        return this.getKeyframe(element, Vec3::new, PositionKeyframe::new);
    }

    private RotationKeyframe getRotation(JsonElement element) {
        return this.getKeyframe(element, EulerAngle::new, RotationKeyframe::new);
    }

    private ScaleKeyframe getScale(JsonElement element) {
        return this.getKeyframe(element, Vec3::new, ScaleKeyframe::new);
    }

    private <T, R> T getKeyframe(JsonElement element, Value<R> value, Keyframe<T, R> keyframe) {
        if (element.isJsonArray()) {
            JsonArray array = element.getAsJsonArray();
            R floats = value.get(array.get(0).getAsFloat(), array.get(1).getAsFloat(), array.get(2).getAsFloat());
            return keyframe.get(floats, KeyframeType.LINEAR);
        }
        JsonObject object = element.getAsJsonObject();
        JsonArray key = object.getAsJsonArray("post");
        KeyframeType type = this.getType(object);
        R floats = value.get(key.get(0).getAsFloat(), key.get(1).getAsFloat(), key.get(2).getAsFloat());
        return keyframe.get(floats, type);
    }

    private KeyframeType getType(JsonObject object) {
        return object.has("lerp_mode") ? KeyframeType.parse(object.get("lerp_mode").getAsString()) : KeyframeType.LINEAR;
    }

    @FunctionalInterface
    public static interface Keyframe<T, R> {
        public T get(R var1, KeyframeType var2);
    }

    @FunctionalInterface
    public static interface Value<T> {
        public T get(float var1, float var2, float var3);
    }
}

