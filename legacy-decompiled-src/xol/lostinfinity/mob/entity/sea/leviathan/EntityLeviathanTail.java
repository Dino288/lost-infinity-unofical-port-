/*
 * Decompiled with CFR 0.152.
 */
package xol.lostinfinity.mob.entity.sea.leviathan;

import xol.lostinfinity.mob.entity.sea.leviathan.EntityLeviathanController;
import xol.lostinfinity.mob.entity.sea.leviathan.EntityLeviathanSegment;

public class EntityLeviathanTail
extends EntityLeviathanSegment {
    public EntityLeviathanTail(EntityLeviathanController parent, EntityLeviathanSegment parentSegment) {
        super(parent, parentSegment, 1.375f, 1.0f);
        this.dSocketOffset = 0.9375f;
        this.dOriginDistance = 0.9375f;
    }
}

