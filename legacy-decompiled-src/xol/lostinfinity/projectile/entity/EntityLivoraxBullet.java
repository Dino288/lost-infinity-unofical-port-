/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.projectile.EntityShulkerBullet
 *  net.minecraft.util.Direction$Axis
 *  net.minecraft.util.math.HitResult
 *  net.minecraft.world.World
 */
package xol.lostinfinity.projectile.entity;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.entity.projectile.EntityShulkerBullet;
import net.minecraft.core.Direction;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.level.Level;
import xol.lostinfinity.init.ParticleInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.mob.entity.deviant.prime.EntityLivorax;
import xol.lostinfinity.util.data.CustomParticleConfig;
import xol.lostinfinity.util.data.IMaxAttack;
import xol.lostinfinity.util.fx.IParticleSpawner;

public class EntityLivoraxBullet
extends EntityShulkerBullet
implements IMaxAttack {
    public EntityLivoraxBullet(Level worldIn) {
        super(worldIn);
    }

    public EntityLivoraxBullet(Level worldIn, LivingEntity ownerIn, Entity targetIn) {
        super(worldIn, ownerIn, targetIn, Direction.Axis.X);
    }

    protected void func_184567_a(HitResult result) {
        if (!this.field_70170_p.field_72995_K) {
            if (result.field_72308_g != null && result.field_72308_g instanceof LivingEntity) {
                IMaxAttack.dealMaxHealth((Entity)this, (LivingEntity)result.field_72308_g, 1);
            }
            this.func_70106_y();
        }
    }

    public void func_70071_h_() {
        super.func_70071_h_();
        this.field_70159_w *= (double)1.2f;
        this.field_70181_x *= (double)1.2f;
        this.field_70179_y *= (double)1.2f;
        this.field_70133_I = true;
        if (!this.field_70170_p.field_72995_K) {
            if (this.field_70173_aa >= 100 && !this.field_70128_L) {
                for (LivingEntity target : this.field_70170_p.func_72872_a(LivingEntity.class, this.func_174813_aQ().func_72314_b(2.0, 2.0, 2.0))) {
                    if (target instanceof EntityLivorax) continue;
                    IMaxAttack.dealMaxHealth((Entity)this, target, 1);
                }
                CustomParticleConfig config1 = new CustomParticleConfig();
                config1.createInstance().setParticle(ParticleInit.EXPLOSION_RING).setSpread(2.0, 1.0, 2.0).setCount(3).setIgnoreRange(true);
                IParticleSpawner.spawnParticle(this.field_70170_p, config1, this.field_70165_t, this.field_70163_u, this.field_70161_v);
                this.func_184185_a(SoundInit.GENERIC_WEAPON_6, 1.0f, 0.8f + 0.4f * this.field_70146_Z.nextFloat());
                this.func_70106_y();
            }
        } else {
            this.field_70170_p.func_175688_a(ParticleInit.COMET_BLUE, this.field_70165_t + (this.field_70146_Z.nextDouble() - 0.5) * (double)this.field_70130_N, this.field_70163_u + this.field_70146_Z.nextDouble() * (double)this.field_70131_O - 0.25, this.field_70161_v + (this.field_70146_Z.nextDouble() - 0.5) * (double)this.field_70130_N, (this.field_70146_Z.nextDouble() - 0.5) * 2.0, -this.field_70146_Z.nextDouble(), (this.field_70146_Z.nextDouble() - 0.5) * 2.0, new int[0]);
        }
    }
}

