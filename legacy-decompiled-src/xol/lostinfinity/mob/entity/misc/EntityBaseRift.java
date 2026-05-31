/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.world.World
 */
package xol.lostinfinity.mob.entity.misc;

import net.minecraft.world.level.Level;
import xol.lostinfinity.mob.entity.base.EntityImmaterial;
import xol.lostinfinity.util.data.IMaxAttack;

public class EntityBaseRift
extends EntityImmaterial
implements IMaxAttack {
    private float alpha = 0.0f;

    public EntityBaseRift(Level worldIn) {
        super(worldIn);
        this.func_70105_a(0.2f, 0.2f);
        this.func_184224_h(true);
        this.func_82142_c(true);
        this.func_189654_d(true);
    }

    public float getAlpha() {
        return this.alpha;
    }

    @Override
    public void func_70636_d() {
        super.func_70636_d();
        this.field_70159_w = 0.0;
        this.field_70181_x = 0.0;
        this.field_70179_y = 0.0;
        if (this.field_70170_p.field_72995_K && this.alpha < 0.85f) {
            this.alpha += 0.025f;
        }
    }

    protected double getROD(int multi) {
        return (-0.5 + this.field_70146_Z.nextDouble()) * (double)multi;
    }
}

