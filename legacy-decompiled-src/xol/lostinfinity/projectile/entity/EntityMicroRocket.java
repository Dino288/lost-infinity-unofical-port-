/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.util.SoundSource
 *  net.minecraft.util.math.AABB
 *  net.minecraft.util.math.HitResult
 *  net.minecraft.util.math.Vec3
 *  net.minecraft.world.World
 */
package xol.lostinfinity.projectile.entity;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.Level;
import xol.lostinfinity.init.ParticleInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.projectile.entity.EntityBaseThrowable;
import xol.lostinfinity.util.data.CustomParticleConfig;
import xol.lostinfinity.util.data.IMaxAttack;
import xol.lostinfinity.util.fx.IParticleSpawner;

public class EntityMicroRocket
extends EntityBaseThrowable {
    private static final double SPEED = 0.3;
    private static final int HOMING_RADIUS = 20;
    private int targetingHeight = 0;
    private LivingEntity target = null;

    public EntityMicroRocket(Level par1World) {
        super(par1World);
        this.func_70105_a(0.75f, 0.75f);
        this.field_70181_x = 0.5;
        this.field_70133_I = true;
    }

    public EntityMicroRocket(Level par1World, LivingEntity par2Mob) {
        super(par1World, par2Mob);
        this.func_70105_a(0.75f, 0.75f);
        this.field_70181_x = 0.5;
        this.field_70133_I = true;
    }

    public EntityMicroRocket(Level par1World, double par2, double par4, double par6) {
        super(par1World, par2, par4, par6);
        this.func_70105_a(0.75f, 0.75f);
        this.field_70181_x = 0.5;
        this.field_70133_I = true;
    }

    @Override
    protected void func_70184_a(HitResult result) {
        if (!this.field_70170_p.field_72995_K) {
            if (this.func_85052_h() != null) {
                for (LivingEntity target : this.field_70170_p.func_72872_a(LivingEntity.class, this.func_174813_aQ().func_186662_g(3.0))) {
                    if (target.func_110124_au().equals(this.func_85052_h().func_110124_au())) continue;
                    IMaxAttack.dealTrueDamage((Entity)this, target, target.func_110138_aP() / 3.0f);
                }
            }
            CustomParticleConfig config1 = new CustomParticleConfig();
            config1.createInstance().setParticle(ParticleInit.EXPLOSION_RING).setSpread(2.0, 1.0, 2.0).setCount(3).setIgnoreRange(true);
            IParticleSpawner.spawnParticle(this.field_70170_p, config1, this.field_70165_t, this.field_70163_u, this.field_70161_v);
            this.field_70170_p.func_184133_a(null, this.func_180425_c(), SoundInit.MISSILE_EXPLOSION, SoundSource.PLAYERS, 1.5f, 0.6f + 0.4f * this.field_70146_Z.nextFloat());
            this.func_70106_y();
        }
    }

    @Override
    public void func_70071_h_() {
        block5: {
            block4: {
                super.func_70071_h_();
                if (this.field_70170_p.field_72995_K) break block4;
                if (this.field_70173_aa <= 2) break block5;
                if (this.target == null || this.target.field_70128_L) {
                    LivingEntity closest = null;
                    double minDist = 9999.0;
                    for (LivingEntity entity : this.field_70170_p.func_72872_a(LivingEntity.class, new AABB(this.func_180425_c().func_177982_a(-20, -20, -20), this.func_180425_c().func_177982_a(20, 20, 20)))) {
                        if (this.func_85052_h() != null && this.func_85052_h().func_110124_au().equals(entity.func_110124_au())) continue;
                        double dist = this.func_70032_d((Entity)entity);
                        if (!(entity.field_70163_u >= (double)this.targetingHeight) || !(dist < minDist)) continue;
                        minDist = dist;
                        closest = entity;
                    }
                    this.target = closest;
                }
                if (this.target != null) {
                    Vec3 dir = this.target.func_174791_d().func_178787_e(new Vec3(0.0, (double)this.target.field_70131_O / 1.5, 0.0)).func_178788_d(this.func_174791_d());
                    dir = dir.func_72432_b();
                    Vec3 motionVec = new Vec3(this.field_70159_w, this.field_70181_x, this.field_70179_y);
                    motionVec = motionVec.func_72432_b();
                    Vec3 diff = dir.func_178788_d(motionVec);
                    this.field_70159_w += diff.field_72450_a * 0.3;
                    this.field_70181_x += diff.field_72448_b * 0.3;
                    this.field_70179_y += diff.field_72449_c * 0.3;
                    this.field_70133_I = true;
                }
                if (this.field_70173_aa <= 100) break block5;
                this.func_70106_y();
                break block5;
            }
            for (int i = 0; i < 3; ++i) {
                this.field_70170_p.func_175682_a(ParticleInit.FLAME_SMALL, true, this.field_70165_t, this.field_70163_u, this.field_70161_v, 0.0, 0.0, 0.0, new int[0]);
            }
        }
    }

    protected float func_70185_h() {
        return 0.0f;
    }

    public void setTargetingHeight(int targetingHeight) {
        this.targetingHeight = targetingHeight;
    }
}

