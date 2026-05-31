/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.PathfinderMob
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.ai.EntityAITarget
 */
package xol.lostinfinity.mob.ai;

import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.entity.ai.EntityAITarget;
import xol.lostinfinity.mob.entity.base.EntityFloatingTameable;

public class EntityFlyingOwnerAttack
extends EntityAITarget {
    EntityFloatingTameable tameable;
    LivingEntity attacker;
    private int timestamp;

    public EntityFlyingOwnerAttack(EntityFloatingTameable theEntityTameableIn) {
        super((PathfinderMob)theEntityTameableIn, false);
        this.tameable = theEntityTameableIn;
        this.func_75248_a(1);
    }

    public boolean func_75250_a() {
        if (!this.tameable.isTamed()) {
            return false;
        }
        LivingEntity entitylivingbase = this.tameable.getOwner();
        if (entitylivingbase == null) {
            return false;
        }
        this.attacker = entitylivingbase.func_110144_aD();
        int i = entitylivingbase.func_142013_aG();
        return i != this.timestamp && this.func_75296_a(this.attacker, false) && this.tameable.shouldAttackEntity(this.attacker, entitylivingbase);
    }

    public void func_75249_e() {
        this.field_75299_d.func_70624_b(this.attacker);
        LivingEntity entitylivingbase = this.tameable.getOwner();
        if (entitylivingbase != null) {
            this.timestamp = entitylivingbase.func_142013_aG();
        }
        super.func_75249_e();
    }
}

