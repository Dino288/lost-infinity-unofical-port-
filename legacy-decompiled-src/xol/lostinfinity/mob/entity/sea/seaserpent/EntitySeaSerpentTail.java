/*
 * Decompiled with CFR 0.152.
 */
package xol.lostinfinity.mob.entity.sea.seaserpent;

import xol.lostinfinity.mob.entity.sea.seaserpent.EntitySeaSerpentController;
import xol.lostinfinity.mob.entity.sea.seaserpent.EntitySeaSerpentSegment;

public class EntitySeaSerpentTail
extends EntitySeaSerpentSegment {
    public EntitySeaSerpentTail(EntitySeaSerpentController parent, EntitySeaSerpentSegment parentSegment) {
        super(parent, parentSegment, 1.375f, 1.0f);
        this.dSocketOffset = 0.9375f;
        this.dOriginDistance = 0.9375f;
    }
}

