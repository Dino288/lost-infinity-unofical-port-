/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.math.Mth
 *  net.minecraft.world.World
 */
package xol.lostinfinity.mob.entity.cthulhu;

import net.minecraft.util.Mth;
import net.minecraft.world.level.Level;
import xol.lostinfinity.mob.entity.cthulhu.EntityCthulhuTentacle;
import xol.lostinfinity.util.animation.client.blueprint.LoopMode;

public class EntityCthulhuTentaclePersist
extends EntityCthulhuTentacle {
    public EntityCthulhuTentaclePersist(Level worldIn) {
        super(worldIn);
        this.setInverted(false);
        this.func_189654_d(false);
        this.setSize(9.25f);
    }

    @Override
    protected void livingUpdate() {
        if (!this.field_70170_p.field_72995_K && this.owner != null) {
            if (this.field_70173_aa % 600 == 580) {
                this.playAnimation("death", LoopMode.NONE, true, 0.5f);
            } else if (this.field_70173_aa % 600 == 0) {
                this.playAnimation("spawn", LoopMode.NONE, false, 0.5f);
                this.teleportRandom();
            }
        }
    }

    @Override
    protected void doDamageTint() {
        this.damageTint();
    }

    public void cast() {
        this.playAnimation("cast", 1.0f);
    }

    public void teleportRandom() {
        this.field_70759_as = this.field_70177_z = this.field_70170_p.field_73012_v.nextFloat() * 360.0f;
        double x = (double)this.field_70170_p.field_73012_v.nextFloat() - 0.5;
        double z = (double)this.field_70170_p.field_73012_v.nextFloat() - 0.5;
        double s = Mth.func_181161_i((double)(x * x + z * z)) * 64.0;
        x *= s;
        z *= s;
        double y = this.field_70170_p.func_189649_b((int)(x += this.owner.field_70165_t), (int)(z += this.owner.field_70161_v));
        this.func_70107_b(x, y, z);
    }
}

