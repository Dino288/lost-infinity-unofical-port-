/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.Mob
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.ai.EntityAIBase
 *  net.minecraft.util.math.Mth
 */
package xol.lostinfinity.mob.ai;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.util.Mth;

public class EntityAILookAround
extends EntityAIBase {
    private final Mob parentEntity;

    public EntityAILookAround(Mob ghast) {
        this.parentEntity = ghast;
        this.func_75248_a(2);
    }

    public boolean func_75250_a() {
        return true;
    }

    public void func_75246_d() {
        if (this.parentEntity.func_70638_az() == null) {
            this.parentEntity.field_70761_aq = this.parentEntity.field_70177_z = -((float)Mth.func_181159_b((double)this.parentEntity.field_70159_w, (double)this.parentEntity.field_70179_y)) * 57.295776f;
        } else {
            LivingEntity entitylivingbase = this.parentEntity.func_70638_az();
            double d0 = 64.0;
            if (entitylivingbase.func_70068_e((Entity)this.parentEntity) < 4096.0) {
                double d1 = entitylivingbase.field_70165_t - this.parentEntity.field_70165_t;
                double d2 = entitylivingbase.field_70161_v - this.parentEntity.field_70161_v;
                this.parentEntity.field_70761_aq = this.parentEntity.field_70177_z = -((float)Mth.func_181159_b((double)d1, (double)d2)) * 57.295776f;
            }
        }
    }
}

