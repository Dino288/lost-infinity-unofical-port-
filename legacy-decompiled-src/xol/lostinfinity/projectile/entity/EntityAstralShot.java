/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.potion.PotionEffect
 *  net.minecraft.util.SoundSource
 *  net.minecraft.util.math.AABB
 *  net.minecraft.util.math.Mth
 *  net.minecraft.util.math.HitResult
 *  net.minecraft.util.math.Vec3
 *  net.minecraft.world.World
 */
package xol.lostinfinity.projectile.entity;

import java.util.Arrays;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.potion.PotionEffect;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.phys.AABB;
import net.minecraft.util.Mth;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.Level;
import xol.lostinfinity.init.ParticleInit;
import xol.lostinfinity.init.PotionInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.projectile.entity.EntityBaseThrowable;
import xol.lostinfinity.util.data.CustomParticleConfig;
import xol.lostinfinity.util.data.IMaxAttack;
import xol.lostinfinity.util.fx.IParticleSpawner;

public class EntityAstralShot
extends EntityBaseThrowable {
    private double speed = 0.1;
    private LivingEntity target = null;
    private static final int homingRadius = 20;

    public EntityAstralShot(Level par1World) {
        super(par1World);
        this.func_70105_a(0.75f, 0.75f);
    }

    public EntityAstralShot(Level par1World, LivingEntity par2Mob) {
        super(par1World, par2Mob);
        this.func_70105_a(0.75f, 0.75f);
    }

    public EntityAstralShot(Level par1World, double par2, double par4, double par6) {
        super(par1World, par2, par4, par6);
        this.func_70105_a(0.75f, 0.75f);
    }

    @Override
    protected void func_70184_a(HitResult result) {
        if (!this.field_70170_p.field_72995_K) {
            if (this.func_85052_h() != null) {
                for (LivingEntity target : this.field_70170_p.func_72872_a(LivingEntity.class, this.func_174813_aQ().func_186662_g(3.0))) {
                    if (target.func_110124_au().equals(this.func_85052_h().func_110124_au()) || !IMaxAttack.dealTrueDamage((Entity)this, target, target.func_110138_aP(), Arrays.asList("Darkborn")).didSuccessfulHit()) continue;
                    target.func_70690_d(new PotionEffect(PotionInit.DISTORTION, 300));
                }
            }
            CustomParticleConfig config = new CustomParticleConfig();
            config.setCount(5);
            config.createInstance().setParticle(ParticleInit.PRISMATIC_EXPLOSION_TYPE1).setSpread(1.0, 1.0, 1.0).setIgnoreRange(true);
            config.createInstance().setParticle(ParticleInit.PRISMATIC_EXPLOSION_TYPE2).setSpread(1.0, 1.0, 1.0).setIgnoreRange(true);
            config.createInstance().setParticle(ParticleInit.PRISMATIC_EXPLOSION_TYPE3).setSpread(1.0, 1.0, 1.0).setIgnoreRange(true);
            IParticleSpawner.spawnParticle(this.field_70170_p, config, this.field_70165_t, this.field_70163_u, this.field_70161_v);
            this.field_70170_p.func_184133_a(null, this.func_180425_c(), SoundInit.GENERIC_WEAPON_6, SoundSource.PLAYERS, 1.5f, 0.6f + 0.4f * this.field_70146_Z.nextFloat());
            this.func_70106_y();
        }
    }

    @Override
    public void func_70071_h_() {
        block17: {
            block16: {
                super.func_70071_h_();
                if (this.field_70170_p.field_72995_K) break block16;
                if (this.field_70173_aa <= 2) break block17;
                if (this.target == null || this.target.field_70128_L) {
                    LivingEntity closest = null;
                    double minDist = 9999.0;
                    for (LivingEntity entity : this.field_70170_p.func_72872_a(LivingEntity.class, new AABB(this.func_180425_c().func_177982_a(-20, -20, -20), this.func_180425_c().func_177982_a(20, 20, 20)))) {
                        double dist;
                        if (this.func_85052_h() != null && this.func_85052_h().func_110124_au().equals(entity.func_110124_au()) || !((dist = (double)this.func_70032_d((Entity)entity)) < minDist)) continue;
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
                    this.field_70159_w += diff.field_72450_a * this.speed;
                    this.field_70181_x += diff.field_72448_b * this.speed;
                    this.field_70179_y += diff.field_72449_c * this.speed;
                    this.field_70133_I = true;
                }
                if (this.field_70173_aa <= 100) break block17;
                this.func_70106_y();
                break block17;
            }
            block13: for (int i = 0; i < 3; ++i) {
                switch (Mth.func_76141_d((float)(this.field_70173_aa % 30 / 3))) {
                    case 0: {
                        this.field_70170_p.func_175682_a(ParticleInit.GENERIC_DOT_ACID, true, this.field_70165_t, this.field_70163_u, this.field_70161_v, 0.0, 0.0, 0.0, new int[0]);
                        continue block13;
                    }
                    case 1: {
                        this.field_70170_p.func_175682_a(ParticleInit.GENERIC_DOT_GREEN, true, this.field_70165_t, this.field_70163_u, this.field_70161_v, 0.0, 0.0, 0.0, new int[0]);
                        continue block13;
                    }
                    case 2: {
                        this.field_70170_p.func_175682_a(ParticleInit.GENERIC_DOT_AQUA, true, this.field_70165_t, this.field_70163_u, this.field_70161_v, 0.0, 0.0, 0.0, new int[0]);
                        continue block13;
                    }
                    case 3: {
                        this.field_70170_p.func_175682_a(ParticleInit.GENERIC_DOT_BLUE, true, this.field_70165_t, this.field_70163_u, this.field_70161_v, 0.0, 0.0, 0.0, new int[0]);
                        continue block13;
                    }
                    case 4: {
                        this.field_70170_p.func_175682_a(ParticleInit.GENERIC_DOT_PURPLE, true, this.field_70165_t, this.field_70163_u, this.field_70161_v, 0.0, 0.0, 0.0, new int[0]);
                        continue block13;
                    }
                    case 5: {
                        this.field_70170_p.func_175682_a(ParticleInit.GENERIC_DOT_PINK, true, this.field_70165_t, this.field_70163_u, this.field_70161_v, 0.0, 0.0, 0.0, new int[0]);
                        continue block13;
                    }
                    case 6: {
                        this.field_70170_p.func_175682_a(ParticleInit.GENERIC_DOT_RED, true, this.field_70165_t, this.field_70163_u, this.field_70161_v, 0.0, 0.0, 0.0, new int[0]);
                        continue block13;
                    }
                    case 7: {
                        this.field_70170_p.func_175682_a(ParticleInit.GENERIC_DOT_TANGERINE, true, this.field_70165_t, this.field_70163_u, this.field_70161_v, 0.0, 0.0, 0.0, new int[0]);
                        continue block13;
                    }
                    case 8: {
                        this.field_70170_p.func_175682_a(ParticleInit.GENERIC_DOT_ORANGE, true, this.field_70165_t, this.field_70163_u, this.field_70161_v, 0.0, 0.0, 0.0, new int[0]);
                        continue block13;
                    }
                    case 9: {
                        this.field_70170_p.func_175682_a(ParticleInit.GENERIC_DOT_YELLOW, true, this.field_70165_t, this.field_70163_u, this.field_70161_v, 0.0, 0.0, 0.0, new int[0]);
                    }
                }
            }
        }
    }

    protected float func_70185_h() {
        return 0.0f;
    }
}

