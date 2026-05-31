/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.world.World
 */
package xol.lostinfinity.mob.entity.sea;

import net.minecraft.world.level.Level;
import xol.lostinfinity.mob.ai.EntityAIFloatAttack;
import xol.lostinfinity.mob.entity.base.EntityFloatingBase;

public class EntitySeaCreature
extends EntityFloatingBase {
    private int visualStyle = this.field_70146_Z.nextInt(4);

    public EntitySeaCreature(Level worldIn) {
        super(worldIn);
    }

    public int getVisualStyle() {
        return this.visualStyle;
    }

    @Override
    protected EntityAIFloatAttack createShootAI() {
        return null;
    }
}

