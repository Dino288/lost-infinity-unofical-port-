/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.passive.EntityTameable
 *  net.minecraft.util.EnumParticleTypes
 *  net.minecraft.util.SoundSource
 *  net.minecraft.util.SoundEvent
 *  net.minecraft.util.math.HitResult
 *  net.minecraft.util.math.Vec3
 *  net.minecraft.world.World
 */
package xol.lostinfinity.projectile.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.sounds.SoundSource;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.Level;
import xol.lostinfinity.init.ParticleInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.mob.entity.minion.EntityMinion;
import xol.lostinfinity.projectile.entity.EntityBaseThrowable;
import xol.lostinfinity.util.data.CustomParticleConfig;
import xol.lostinfinity.util.data.IMaxAttack;
import xol.lostinfinity.util.fx.IParticleSpawner;
import xol.lostinfinity.util.math.LMath;

public class EntityDeathShot
extends EntityBaseThrowable
implements IMaxAttack {
    private static final int MARK_RANGE = 15;
    private static final float GRAVITY = 0.01f;
    private static final SoundEvent DAMAGE_SOUND = SoundInit.MISSILE_EXPLOSION;
    private static final EnumParticleTypes MARK_PARTICLE = ParticleInit.RED_SKULL;
    private static final EnumParticleTypes DAMAGE_PARTICLE = ParticleInit.EXPLOSION;
    private List<LivingEntity> markedEntities = new ArrayList<LivingEntity>();

    public EntityDeathShot(Level par1World) {
        super(par1World);
        this.func_70105_a(0.75f, 0.75f);
    }

    public EntityDeathShot(Level worldIn, LivingEntity entityIn) {
        super(worldIn, entityIn);
        this.func_70105_a(0.75f, 0.75f);
        this.setThrower(entityIn);
        double spawnX = entityIn.field_70165_t;
        double spawnY = entityIn.field_70163_u + (double)entityIn.func_70047_e();
        double spawnZ = entityIn.field_70161_v;
        switch (entityIn.func_174811_aO()) {
            case NORTH: {
                spawnZ -= 1.0;
                break;
            }
            case SOUTH: {
                spawnZ += 1.0;
                break;
            }
            case EAST: {
                spawnX += 1.0;
                break;
            }
            case WEST: {
                spawnX -= 1.0;
            }
        }
        this.func_70634_a(spawnX, spawnY, spawnZ);
    }

    public EntityDeathShot(Level par1World, double par2, double par4, double par6) {
        super(par1World, par2, par4, par6);
        this.func_70105_a(0.75f, 0.75f);
    }

    @Override
    public void func_70071_h_() {
        super.func_70071_h_();
        if (this.field_70170_p.field_72995_K) {
            return;
        }
        if (this.field_70173_aa % 10 == 1 && this.func_85052_h() != null) {
            for (LivingEntity nearEntity : this.field_70170_p.func_72872_a(LivingEntity.class, this.func_174813_aQ().func_186662_g(15.0))) {
                EntityMinion minion;
                EntityTameable tameable;
                if (this.markedEntities.contains(nearEntity) || nearEntity.equals((Object)this.func_85052_h()) || nearEntity instanceof EntityTameable && (tameable = (EntityTameable)nearEntity).func_70909_n() && tameable.func_70902_q().equals((Object)this.func_85052_h()) || nearEntity instanceof EntityMinion && (minion = (EntityMinion)nearEntity).func_184753_b().equals(this.func_85052_h().func_110124_au())) continue;
                this.markedEntities.add(nearEntity);
            }
        }
        if (this.field_70173_aa % 10 == 1) {
            CustomParticleConfig config = new CustomParticleConfig();
            config.createInstance().setParticle(MARK_PARTICLE).setSpread(0.0, 0.0, 0.0).setCount(1).setIgnoreRange(true);
            for (LivingEntity markedEntity : this.markedEntities) {
                if (markedEntity.field_70128_L) continue;
                IParticleSpawner.spawnParticle(this.field_70170_p, config, markedEntity.field_70165_t, markedEntity.field_70163_u + (double)markedEntity.field_70131_O + (double)0.65f, markedEntity.field_70161_v);
            }
        }
    }

    @Override
    protected void func_70184_a(HitResult result) {
        if (result.field_72308_g != null && this.func_85052_h() != null && result.field_72308_g.equals((Object)this.func_85052_h())) {
            return;
        }
        if (this.field_70170_p.field_72995_K) {
            return;
        }
        CustomParticleConfig config = new CustomParticleConfig();
        config.createInstance().setParticle(ParticleInit.GENERIC_DOT_RED).setSpread(0.0, 0.0, 0.0).setCount(1).setSpeed(0.0, 0.0, 0.0).setIgnoreRange(true);
        Vec3 impactPos = this.func_174791_d();
        for (LivingEntity entity : this.markedEntities) {
            if (entity.field_70128_L) continue;
            IMaxAttack.dealTrueDamage((Entity)this, entity, entity.func_110138_aP() * 0.08f * (float)this.markedEntities.size(), Arrays.asList("Darkborn", "Aquatic"));
            IParticleSpawner.spawnParticle(this.field_70170_p, config, entity.field_70165_t, entity.field_70163_u + (double)(entity.field_70131_O / 2.0f), entity.field_70161_v);
            this.field_70170_p.func_184133_a(null, entity.func_180425_c(), DAMAGE_SOUND, SoundSource.PLAYERS, 1.5f, 0.6f + 0.4f * this.field_70146_Z.nextFloat());
            Vec3 beamDir = impactPos.func_178788_d(entity.func_174791_d().func_72441_c(0.0, (double)(entity.field_70131_O / 2.0f), 0.0));
            beamDir = LMath.fastNormalize(beamDir);
            double dist = entity.func_70011_f(this.field_70165_t, this.field_70163_u, this.field_70161_v);
            for (double i = 0.0; i < dist; i += 0.5) {
                IParticleSpawner.spawnParticle(this.field_70170_p, config, entity.field_70165_t + beamDir.field_72450_a * i, entity.field_70163_u + (double)(entity.field_70131_O / 2.0f) + beamDir.field_72448_b * i, entity.field_70161_v + beamDir.field_72449_c * i);
            }
        }
        this.func_70106_y();
    }

    protected float func_70185_h() {
        return 0.01f;
    }
}

