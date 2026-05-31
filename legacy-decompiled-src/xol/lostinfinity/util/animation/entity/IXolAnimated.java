/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 */
package xol.lostinfinity.util.animation.entity;

import net.minecraft.world.entity.Entity;
import xol.lostinfinity.common.lostinfinity;
import xol.lostinfinity.util.animation.client.AnimationHandler;
import xol.lostinfinity.util.animation.client.blueprint.AnimationBlueprint;
import xol.lostinfinity.util.animation.client.blueprint.LoopMode;
import xol.lostinfinity.util.animation.packet.PacketAnimation;

public interface IXolAnimated {
    public AnimationHandler getAnimationHandler();

    default public void playAnimation(String id, float speed) {
        Entity entity = this.getEntity();
        if (entity.field_70170_p.field_72995_K) {
            this.getAnimationHandler().play(id, animationProperty -> {
                animationProperty.speedModifier = speed;
            });
        } else {
            lostinfinity.instance.packetHandler.sendToPlayerExcept(entity, new PacketAnimation(this, id, speed));
        }
    }

    default public void playAnimation(String id, LoopMode mode, boolean isOverride, float speed) {
        Entity entity = this.getEntity();
        if (entity.field_70170_p.field_72995_K) {
            this.getAnimationHandler().play(id, animationProperty -> {
                animationProperty.loopMode = mode;
                animationProperty.isOverride = isOverride;
                animationProperty.speedModifier = speed;
            });
        } else {
            lostinfinity.instance.packetHandler.sendToPlayerExcept(entity, new PacketAnimation(this, id, mode, isOverride, speed));
        }
    }

    default public void stopAnimation(String id) {
        Entity entity = this.getEntity();
        if (entity.field_70170_p.field_72995_K) {
            this.getAnimationHandler().stop(id);
        } else {
            lostinfinity.instance.packetHandler.sendToPlayerExcept(entity, new PacketAnimation(this, id));
        }
    }

    default public void setAnimationBlueprint(AnimationBlueprint animationBlueprint) {
        this.getAnimationHandler().setBlueprint(animationBlueprint);
    }

    default public Entity getEntity() {
        return (Entity)this;
    }
}

