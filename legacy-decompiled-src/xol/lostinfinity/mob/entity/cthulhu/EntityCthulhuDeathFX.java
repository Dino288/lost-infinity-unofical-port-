/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.world.World
 */
package xol.lostinfinity.mob.entity.cthulhu;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import xol.lostinfinity.common.events.EventsClientRender;
import xol.lostinfinity.mob.entity.base.EntityImmaterial;

public class EntityCthulhuDeathFX
extends EntityImmaterial {
    public EntityCthulhuDeathFX(Level worldIn) {
        super(worldIn);
    }

    public void onAddedToWorld() {
        super.onAddedToWorld();
        if (this.field_70170_p.field_72995_K) {
            EventsClientRender.renderForce.put(this.func_145782_y(), (Entity)this);
        }
    }

    @Override
    public void func_70636_d() {
        super.func_70636_d();
        if (this.field_70173_aa > 340) {
            this.func_70106_y();
        }
    }
}

