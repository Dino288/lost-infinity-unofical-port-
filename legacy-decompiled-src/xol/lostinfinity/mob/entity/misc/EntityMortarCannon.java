/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.world.World
 */
package xol.lostinfinity.mob.entity.misc;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.mob.entity.misc.EntityBaseCannon;
import xol.lostinfinity.projectile.entity.EntityMortarShot;

public class EntityMortarCannon
extends EntityBaseCannon {
    public EntityMortarCannon(Level worldIn) {
        super(worldIn);
    }

    @Override
    public void func_70636_d() {
        super.func_70636_d();
        if (!this.field_70170_p.field_72995_K && this.field_70173_aa % 20 == 0) {
            EntityMortarShot shot = new EntityMortarShot(this.field_70170_p, (LivingEntity)this);
            shot.func_70107_b(this.field_70165_t, this.field_70163_u + (double)this.field_70131_O / 1.6, this.field_70161_v);
            shot.setSecondaryThrower((LivingEntity)this.getOwner());
            double x = Math.cos((double)this.getRotation() + 1.5707963267948966);
            double y = 0.6;
            double z = Math.sin((double)this.getRotation() + 1.5707963267948966);
            shot.func_70186_c(x, y, z, 1.5f, 0.0f);
            this.field_70170_p.func_72838_d((Entity)shot);
            this.func_184185_a(SoundInit.GENERIC_WEAPON_7, 1.0f, 0.8f + this.field_70146_Z.nextFloat() * 0.4f);
        }
    }
}

