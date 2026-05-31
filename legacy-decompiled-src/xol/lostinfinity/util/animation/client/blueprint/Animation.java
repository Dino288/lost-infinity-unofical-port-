/*
 * Decompiled with CFR 0.152.
 */
package xol.lostinfinity.util.animation.client.blueprint;

import java.util.HashMap;
import java.util.Map;
import xol.lostinfinity.util.animation.client.blueprint.LoopMode;
import xol.lostinfinity.util.animation.client.blueprint.Timeline;

public class Animation {
    public final String id;
    public final LoopMode loopMode;
    public final boolean isOverride;
    public final float duration;
    public final Map<String, Timeline> timelines = new HashMap<String, Timeline>();

    public Animation(String id, LoopMode loopMode, boolean isOverride, float duration) {
        this.id = id;
        this.loopMode = loopMode;
        this.isOverride = isOverride;
        this.duration = duration;
    }
}

