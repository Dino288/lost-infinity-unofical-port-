/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.util.math.HitResult
 *  net.minecraft.util.math.HitResult$Type
 *  net.minecraft.world.World
 */
package xol.lostinfinity.projectile.entity;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.level.Level;
import xol.lostinfinity.init.ParticleInit;
import xol.lostinfinity.projectile.entity.EntityBaseThrowable;
import xol.lostinfinity.util.data.IMaxAttack;

public class EntityPiercingShot
extends EntityBaseThrowable {
    private List<LivingEntity> hitCreatures = new ArrayList<LivingEntity>();

    public EntityPiercingShot(Level par1World) {
        super(par1World);
    }

    public EntityPiercingShot(Level par1World, LivingEntity par2Mob) {
        super(par1World, par2Mob);
    }

    @Override
    protected void func_70184_a(HitResult result) {
        if (!this.field_70170_p.field_72995_K && result.field_72313_a == HitResult.Type.BLOCK) {
            System.out.println(this.hitCreatures.size());
            for (LivingEntity hit : this.hitCreatures) {
                if (hit == null) continue;
                IMaxAttack.dealMaxHealth((Entity)this, hit, 10, 6 + 3 * (this.hitCreatures.size() - 1));
            }
            this.func_70106_y();
        }
    }

    protected float func_70185_h() {
        return 0.02f;
    }

    @Override
    public void func_70071_h_() {
        super.func_70071_h_();
        if (this.field_70170_p.field_72995_K) {
            this.field_70170_p.func_175688_a(ParticleInit.LASER_FIZZLE, this.field_70165_t + (this.field_70146_Z.nextDouble() - 0.5) * (double)this.field_70130_N, this.field_70163_u + this.field_70146_Z.nextDouble() * (double)this.field_70131_O - 0.25, this.field_70161_v + (this.field_70146_Z.nextDouble() - 0.5) * (double)this.field_70130_N, (this.field_70146_Z.nextDouble() - 0.5) * 2.0, -this.field_70146_Z.nextDouble(), (this.field_70146_Z.nextDouble() - 0.5) * 2.0, new int[0]);
        } else {
            for (LivingEntity near_creature : this.field_70170_p.func_72872_a(LivingEntity.class, this.func_174813_aQ().func_186662_g(0.5))) {
                if (this.hitCreatures.contains(near_creature)) continue;
                this.hitCreatures.add(near_creature);
            }
        }
    }
}

