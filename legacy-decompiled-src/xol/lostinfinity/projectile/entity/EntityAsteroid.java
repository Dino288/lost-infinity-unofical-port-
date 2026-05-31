/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.util.math.HitResult
 *  net.minecraft.util.math.Vec3
 *  net.minecraft.world.World
 */
package xol.lostinfinity.projectile.entity;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.Level;
import xol.lostinfinity.init.ParticleInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.mob.entity.base.EntityMultipleLives;
import xol.lostinfinity.projectile.entity.EntityBaseThrowable;
import xol.lostinfinity.projectile.entity.EntityMeteor;
import xol.lostinfinity.util.data.CustomDamageResult;
import xol.lostinfinity.util.data.CustomParticleConfig;
import xol.lostinfinity.util.data.IMaxAttack;
import xol.lostinfinity.util.fx.IParticleSpawner;

public class EntityAsteroid
extends EntityBaseThrowable {
    public EntityAsteroid(Level par1World) {
        super(par1World);
        this.func_70105_a(6.0f, 6.0f);
    }

    public EntityAsteroid(Level par1World, LivingEntity par2Mob) {
        super(par1World, par2Mob);
        this.func_70105_a(6.0f, 6.0f);
    }

    public EntityAsteroid(Level par1World, double par2, double par4, double par6) {
        super(par1World, par2, par4, par6);
        this.func_70105_a(6.0f, 6.0f);
    }

    @Override
    public void func_70071_h_() {
        block3: {
            block2: {
                super.func_70071_h_();
                if (this.field_70170_p.field_72995_K) break block2;
                if (this.field_70173_aa % 12 != 0) break block3;
                for (int i = 0; i < 2; ++i) {
                    double randYaw = this.field_70146_Z.nextDouble() * Math.PI / 2.0 - 0.7853981633974483;
                    double randPitch = this.field_70146_Z.nextDouble() * Math.PI / 2.0 - 0.7853981633974483;
                    Vec3 dir = new Vec3(this.field_70159_w, this.field_70181_x, this.field_70179_y).func_72432_b().func_178789_a((float)randPitch).func_178785_b((float)randYaw);
                    if (this.field_70192_c == null) continue;
                    EntityMeteor meteor = new EntityMeteor(this.field_70170_p, this.field_70192_c);
                    meteor.setThrower(this.field_70192_c);
                    meteor.func_70107_b(this.field_70165_t + dir.field_72450_a * 1.3 + this.field_70146_Z.nextDouble() * 2.0 - 1.0, this.field_70163_u + this.field_70146_Z.nextDouble() * 2.0 - 1.0, this.field_70161_v + dir.field_72449_c * 1.3 + this.field_70146_Z.nextDouble() * 2.0 - 1.0);
                    meteor.func_70186_c(dir.field_72450_a, dir.field_72448_b, dir.field_72449_c, 2.8f, 1.0f);
                    this.field_70170_p.func_72838_d((Entity)meteor);
                }
                break block3;
            }
            for (int i = 0; i < 3; ++i) {
                this.field_70170_p.func_175688_a(this.field_70146_Z.nextBoolean() ? ParticleInit.EXPLOSION_RED : ParticleInit.EXPLOSION_ORANGE, this.field_70165_t + (this.field_70146_Z.nextDouble() - 0.5) * (double)this.field_70130_N, this.field_70163_u + this.field_70146_Z.nextDouble() * (double)this.field_70131_O - 0.25, this.field_70161_v + (this.field_70146_Z.nextDouble() - 0.5) * (double)this.field_70130_N, (this.field_70146_Z.nextDouble() - 0.5) * 2.0, -this.field_70146_Z.nextDouble(), (this.field_70146_Z.nextDouble() - 0.5) * 2.0, new int[0]);
                this.field_70170_p.func_175688_a(ParticleInit.FLAME_LARGE, this.field_70165_t + (this.field_70146_Z.nextDouble() - 0.5) * (double)this.field_70130_N, this.field_70163_u + this.field_70146_Z.nextDouble() * (double)this.field_70131_O - 0.25, this.field_70161_v + (this.field_70146_Z.nextDouble() - 0.5) * (double)this.field_70130_N, (this.field_70146_Z.nextDouble() - 0.5) * 2.0, -this.field_70146_Z.nextDouble(), (this.field_70146_Z.nextDouble() - 0.5) * 2.0, new int[0]);
            }
        }
    }

    @Override
    protected void func_70184_a(HitResult result) {
        if (!this.field_70170_p.field_72995_K) {
            if (this.func_85052_h() != null) {
                for (LivingEntity target : this.field_70170_p.func_72872_a(LivingEntity.class, this.func_174813_aQ().func_186662_g(20.0))) {
                    CustomDamageResult dr;
                    if (target.func_110124_au().equals(this.field_70192_c.func_110124_au()) || (dr = this.func_70032_d((Entity)target) < 6.0f ? IMaxAttack.dealTrueDamage((Entity)this, target, target.func_110138_aP() * 1.25f) : IMaxAttack.dealTrueDamage((Entity)this, target, target.func_110138_aP() * 0.75f)).wasTargetKilled() || !(target instanceof EntityMultipleLives)) continue;
                    EntityMultipleLives multi = (EntityMultipleLives)target;
                    ((EntityMultipleLives)target).takeawayNumLives(8);
                }
                this.func_184185_a(SoundInit.ASTEROID_IMPACT, 2.0f, 0.5f + 0.7f * this.field_70146_Z.nextFloat());
                CustomParticleConfig config1 = new CustomParticleConfig();
                config1.setCount(15);
                config1.createInstance().setParticle(ParticleInit.EXPLOSION_RED).setSpread(25.0, 4.0, 25.0).setIgnoreRange(true);
                config1.createInstance().setParticle(ParticleInit.EXPLOSION_ORANGE).setSpread(25.0, 4.0, 25.0).setIgnoreRange(true);
                IParticleSpawner.spawnParticle(this.field_70170_p, config1, this.field_70165_t, this.field_70163_u, this.field_70161_v);
            }
            this.func_70106_y();
        }
    }

    protected float func_70185_h() {
        return 0.0f;
    }
}

