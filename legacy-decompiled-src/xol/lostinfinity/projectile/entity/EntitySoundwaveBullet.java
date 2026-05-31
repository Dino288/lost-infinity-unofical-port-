/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.util.Direction
 *  net.minecraft.util.SoundSource
 *  net.minecraft.util.math.HitResult
 *  net.minecraft.util.math.Vec3
 *  net.minecraft.world.World
 */
package xol.lostinfinity.projectile.entity;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.Level;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.projectile.entity.EntityBaseThrowable;
import xol.lostinfinity.util.data.IMaxAttack;
import xol.lostinfinity.util.fx.IParticleSpawner;

public class EntitySoundwaveBullet
extends EntityBaseThrowable
implements IMaxAttack {
    private static final long HIT_COOLDOWN = 10L;
    private static final int MAX_BOUNCE_CHECK = 4;
    private boolean hasBouncedBefore = false;
    private final Map<Entity, Long> damageLog = new ConcurrentHashMap<Entity, Long>();

    public EntitySoundwaveBullet(Level worldIn) {
        super(worldIn);
        this.func_70105_a(0.5f, 0.5f);
    }

    public EntitySoundwaveBullet(Level worldIn, LivingEntity entityIn) {
        super(worldIn, entityIn);
        this.func_70105_a(0.5f, 0.5f);
    }

    @Override
    protected void func_70184_a(HitResult result) {
        if (this.field_70170_p.field_72995_K) {
            return;
        }
        switch (result.field_72313_a) {
            case ENTITY: {
                Entity entity = result.field_72308_g;
                if (entity instanceof LivingEntity && !entity.equals((Object)this.func_85052_h())) {
                    Long lastHitTime = this.damageLog.get(entity);
                    Long currentTime = System.currentTimeMillis();
                    if (lastHitTime == null || currentTime - lastHitTime >= 10L) {
                        if (this.hasBouncedBefore) {
                            IMaxAttack.dealTrueDamage((Entity)this, (LivingEntity)entity, ((LivingEntity)entity).func_110138_aP() * 0.33f);
                        } else {
                            IMaxAttack.dealMaxHealth((Entity)this, (LivingEntity)entity, 3);
                        }
                        this.damageLog.put(entity, currentTime);
                    }
                }
                this.checkBounce();
                break;
            }
            case BLOCK: {
                Direction facing = result.field_178784_b;
                for (int i = 0; i < 4; ++i) {
                    this.bounce(facing);
                    facing = this.raytraceFace();
                    if (facing == null) break;
                }
                this.hasBouncedBefore = true;
                IParticleSpawner.spawnParticle(this.field_70170_p, 62, 0, this.field_70165_t, this.field_70163_u, this.field_70161_v);
                this.field_70170_p.func_184133_a(null, this.func_180425_c(), SoundInit.SOUND_BOUNCE, SoundSource.NEUTRAL, 0.5f, 0.8f + this.field_70170_p.field_73012_v.nextFloat() * 0.4f);
                break;
            }
        }
    }

    @Override
    public void func_70071_h_() {
        this.field_70122_E = false;
        super.func_70071_h_();
        this.field_184539_c = null;
        if (this.field_70173_aa >= 140) {
            this.func_70106_y();
        }
    }

    protected float func_70185_h() {
        return 0.0f;
    }

    private void checkBounce() {
        Direction facing;
        boolean hasBounced = false;
        for (int i = 0; i < 4 && (facing = this.raytraceFace()) != null; ++i) {
            this.bounce(facing);
            hasBounced = true;
        }
        if (hasBounced) {
            this.hasBouncedBefore = true;
            IParticleSpawner.spawnParticle(this.field_70170_p, 62, 0, this.field_70165_t, this.field_70163_u, this.field_70161_v);
            this.field_70170_p.func_184133_a(null, this.func_180425_c(), SoundInit.SOUND_BOUNCE, SoundSource.NEUTRAL, 0.5f, 0.8f + this.field_70170_p.field_73012_v.nextFloat() * 0.4f);
        }
    }

    private void bounce(Direction facing) {
        switch (facing) {
            case DOWN: {
                this.field_70181_x = -Math.abs(this.field_70181_x);
                break;
            }
            case UP: {
                this.field_70181_x = Math.abs(this.field_70181_x);
                break;
            }
            case NORTH: {
                this.field_70179_y = -Math.abs(this.field_70179_y);
                break;
            }
            case SOUTH: {
                this.field_70179_y = Math.abs(this.field_70179_y);
                break;
            }
            case WEST: {
                this.field_70159_w = -Math.abs(this.field_70159_w);
                break;
            }
            case EAST: {
                this.field_70159_w = Math.abs(this.field_70159_w);
            }
        }
        this.field_70133_I = true;
    }

    private Direction raytraceFace() {
        Vec3 currPos = new Vec3(this.field_70165_t, this.field_70163_u, this.field_70161_v);
        Vec3 nextPos = new Vec3(this.field_70165_t + this.field_70159_w, this.field_70163_u + this.field_70181_x, this.field_70161_v + this.field_70179_y);
        HitResult raytraceresult = this.field_70170_p.func_72933_a(currPos, nextPos);
        return raytraceresult != null ? raytraceresult.field_178784_b : null;
    }
}

