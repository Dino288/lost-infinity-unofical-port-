/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.potion.PotionEffect
 *  net.minecraft.util.EnumParticleTypes
 *  net.minecraft.util.SoundSource
 *  net.minecraft.util.math.HitResult
 *  net.minecraft.util.math.Vec3
 *  net.minecraft.world.World
 *  net.minecraft.world.ServerLevel
 */
package xol.lostinfinity.projectile.entity;

import java.util.ArrayList;
import java.util.Arrays;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.Level;
import net.minecraft.server.level.ServerLevel;
import xol.lostinfinity.init.ParticleInit;
import xol.lostinfinity.init.PotionInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.projectile.entity.EntityBaseThrowable;
import xol.lostinfinity.util.data.CustomParticleConfig;
import xol.lostinfinity.util.data.IMaxAttack;
import xol.lostinfinity.util.fx.IParticleSpawner;

public class EntityTitanRing
extends EntityBaseThrowable {
    private boolean rebound = false;
    private double speed = 0.1;
    private ArrayList<Entity> entitiesHit = null;
    private boolean returned = false;
    private boolean highVelo = false;
    private float alpha = 0.0f;

    public EntityTitanRing(Level par1World) {
        super(par1World);
        this.func_70105_a(1.25f, 0.75f);
    }

    public EntityTitanRing(Level par1World, LivingEntity par2Mob) {
        super(par1World, par2Mob);
        this.func_70105_a(1.25f, 0.75f);
    }

    public EntityTitanRing(Level par1World, double par2, double par4, double par6) {
        super(par1World, par2, par4, par6);
        this.func_70105_a(1.25f, 0.75f);
    }

    public void setHighVelo() {
        this.highVelo = true;
    }

    @Override
    protected void func_70184_a(HitResult result) {
        if (!this.field_70170_p.field_72995_K) {
            if (this.entitiesHit == null) {
                this.entitiesHit = new ArrayList();
            }
            if (result.field_72308_g != null && this.func_85052_h() != null) {
                LivingEntity thrower = this.func_85052_h();
                if (!result.field_72308_g.equals((Object)thrower) && result.field_72308_g instanceof LivingEntity && !this.entitiesHit.contains(result.field_72308_g)) {
                    LivingEntity hitEntity = (LivingEntity)result.field_72308_g;
                    int level = 0;
                    if (hitEntity.func_70644_a(PotionInit.SHOCKED)) {
                        level = hitEntity.func_70660_b(PotionInit.SHOCKED).func_76458_c();
                    }
                    if (IMaxAttack.dealTrueDamage((Entity)this, hitEntity, hitEntity.func_110138_aP() * (0.5f + 0.25f * (float)level) * (this.highVelo ? 0.7f : 1.0f), Arrays.asList("Darkborn", "Aquatic")).didSuccessfulHit()) {
                        hitEntity.func_70690_d(new PotionEffect(PotionInit.SHOCKED, 200, level + 1));
                    }
                    this.entitiesHit.add(result.field_72308_g);
                    CustomParticleConfig config1 = new CustomParticleConfig();
                    config1.setCount(3);
                    config1.createInstance().setParticle(ParticleInit.ELECTRIC_EXPLOSION_BLUE).setSpread(2.0, 1.0, 2.0).setIgnoreRange(true);
                    config1.createInstance().setParticle(ParticleInit.ELECTRIC_EXPLOSION_YELLOW).setSpread(2.0, 1.0, 2.0).setIgnoreRange(true);
                    IParticleSpawner.spawnParticle(this.field_70170_p, config1, hitEntity.field_70165_t, hitEntity.field_70163_u + (double)(hitEntity.field_70131_O / 2.0f), hitEntity.field_70161_v);
                    ((ServerLevel)this.field_70170_p).func_175739_a(EnumParticleTypes.SWEEP_ATTACK, this.field_70165_t, this.field_70163_u, this.field_70161_v, 5, -0.5 + this.field_70146_Z.nextDouble(), 0.3, -0.5 + this.field_70146_Z.nextDouble(), (double)0.15f, new int[0]);
                    this.field_70170_p.func_184133_a(null, hitEntity.func_180425_c(), SoundInit.MAGIC_WEAPON_14, SoundSource.PLAYERS, 0.2f, 0.8f + 0.4f * this.field_70146_Z.nextFloat());
                    this.field_70170_p.func_184133_a(null, hitEntity.func_180425_c(), SoundInit.GENERIC_SLICE, SoundSource.PLAYERS, 0.2f, 0.5f + 0.4f * this.field_70146_Z.nextFloat());
                } else if (result.field_72308_g.equals((Object)thrower) && thrower instanceof Player && !this.returned) {
                    Player player = (Player)thrower;
                    this.field_70170_p.func_184133_a(null, this.func_180425_c(), SoundInit.GENERIC_WEAPON_21, SoundSource.PLAYERS, 0.2f, 0.7f + this.field_70146_Z.nextFloat() * 0.6f);
                    this.returned = true;
                    this.func_70106_y();
                }
            }
            if (this.field_70192_c == null) {
                this.func_70106_y();
            }
            if (result.field_72308_g != null || this.field_70170_p.func_180495_p(result.func_178782_a()).func_185904_a().func_76230_c()) {
                this.rebound = true;
            }
        }
    }

    @Override
    public void func_70071_h_() {
        super.func_70071_h_();
        if (!this.field_70170_p.field_72995_K) {
            if (this.rebound) {
                LivingEntity thrower = this.func_85052_h();
                if (thrower != null) {
                    Vec3 dir = thrower.func_174791_d().func_178787_e(new Vec3(0.0, 0.2, 0.0)).func_178788_d(this.func_174791_d());
                    if (dir.func_72433_c() < 3.5 && thrower instanceof Player && !this.field_70128_L && !this.returned) {
                        this.field_70170_p.func_184133_a(null, this.func_180425_c(), SoundInit.GENERIC_WEAPON_21, SoundSource.PLAYERS, 0.6f, 0.7f + this.field_70146_Z.nextFloat() * 0.6f);
                        this.returned = true;
                        this.func_70106_y();
                    }
                    dir = dir.func_72432_b();
                    this.field_70159_w = dir.field_72450_a * this.speed;
                    this.field_70181_x = dir.field_72448_b * this.speed;
                    this.field_70179_y = dir.field_72449_c * this.speed;
                    if (this.speed < 1.5) {
                        this.speed += 0.1;
                    }
                    this.field_70133_I = true;
                }
            } else {
                this.field_70159_w *= 0.96;
                this.field_70181_x *= 0.96;
                this.field_70179_y *= 0.96;
                this.field_70133_I = true;
                if (this.field_70173_aa > 40) {
                    this.rebound = true;
                }
            }
        } else {
            if (this.alpha < 1.0f) {
                this.alpha += 0.1f;
            }
            this.field_70170_p.func_175688_a(this.field_70146_Z.nextBoolean() ? ParticleInit.SPECTRAL : ParticleInit.SMALL_SPARK, this.field_70165_t, this.field_70163_u, this.field_70161_v, 0.25 * (-0.5 + this.field_70146_Z.nextDouble()), 0.0, 0.25 * (-0.5 + this.field_70146_Z.nextDouble()), new int[0]);
        }
    }

    public float getAlpha() {
        return this.alpha;
    }

    protected float func_70185_h() {
        return 0.0f;
    }
}

