/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.SoundEvent
 *  net.minecraft.util.math.Vec3
 *  net.minecraft.world.World
 */
package xol.lostinfinity.mob.entity.galaxy;

import java.util.Collections;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.Level;
import xol.lostinfinity.init.ParticleInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.mob.entity.base.EntityMultipleLivesMount;
import xol.lostinfinity.mob.entity.base.IConditionalDamage;
import xol.lostinfinity.projectile.entity.EntityGalaxyDragonFireball;
import xol.lostinfinity.util.data.CustomParticleConfig;
import xol.lostinfinity.util.data.CustomHitResult;
import xol.lostinfinity.util.data.IMaxAttack;
import xol.lostinfinity.util.data.RayTraceBuilder;
import xol.lostinfinity.util.fx.IParticleSpawner;

public class EntityGalaxyDragon
extends EntityMultipleLivesMount
implements IConditionalDamage {
    private static final Vec3 GROUND_OFFSET = new Vec3(0.0, 1.3, 1.0);
    private static final Vec3 AIR_OFFSET = new Vec3(0.0, 0.765, 1.0);
    private long nextFireballAttack;

    public EntityGalaxyDragon(Level worldIn) {
        super(worldIn);
        this.func_70105_a(2.0f, 1.53f);
        this.field_70138_W = 5.0f;
    }

    @Override
    protected void func_184651_r() {
    }

    public float func_70047_e() {
        return this.field_70131_O;
    }

    @Override
    protected int numberOfLives() {
        return 15;
    }

    public void fireBreathAttack(Player driver) {
        CustomHitResult result = RayTraceBuilder.entity(LivingEntity.class, 30).maxEntity(0).raySize(2.625f).custom((lastPos, currentPos, distance) -> {
            float spread = distance * distance / 180.0f + 0.25f;
            CustomParticleConfig config = new CustomParticleConfig();
            config.createInstance().setCount((int)distance / 3).setParticle(ParticleInit.DRAGON_FIRE).setSpread(spread, spread, spread).setIgnoreRange(true);
            IParticleSpawner.spawnParticle(this.field_70170_p, config, currentPos);
        }).trace(this.field_70170_p, (Entity)this, this.getHeadOffset(), driver.func_70040_Z());
        if (result == null) {
            return;
        }
        for (Entity entity : result.getResultEntities()) {
            if (entity == this || entity == driver) continue;
            LivingEntity livingBase = (LivingEntity)entity;
            IMaxAttack.dealTrueDamage((Entity)driver, livingBase, livingBase.func_110138_aP() * 0.05f, Collections.singletonList("Aquatic"));
        }
        this.func_184185_a(SoundInit.DRAGON_FIRE_BREATH, 0.7f, 0.8f + 0.4f * this.field_70146_Z.nextFloat());
    }

    public void fireballAttack(Player driver) {
        if (System.currentTimeMillis() < this.nextFireballAttack) {
            return;
        }
        Vec3 driverVec = driver.func_70040_Z();
        Vec3 location = this.getHeadOffset();
        EntityGalaxyDragonFireball fireball = new EntityGalaxyDragonFireball(this.field_70170_p, location.field_72450_a, location.field_72448_b, location.field_72449_c);
        fireball.setThrower((LivingEntity)this);
        fireball.setSecondaryThrower((LivingEntity)driver);
        driverVec = driverVec.func_186678_a(3.0);
        fireball.func_70024_g(driverVec.field_72450_a, driverVec.field_72448_b, driverVec.field_72449_c);
        this.field_70170_p.func_72838_d((Entity)fireball);
        this.func_184185_a(SoundInit.DRAGON_FIRE_BALL, 1.0f, 0.8f + 0.4f * this.field_70146_Z.nextFloat());
        this.nextFireballAttack = System.currentTimeMillis() + 500L;
    }

    public Vec3 getHeadOffset() {
        return this.func_174791_d().func_178787_e((this.isActuallyOnGround ? GROUND_OFFSET : AIR_OFFSET).func_178785_b(-this.field_70177_z * ((float)Math.PI / 180)));
    }

    protected float func_70599_aP() {
        return 0.3f;
    }

    @Override
    public double func_70042_X() {
        return super.func_70042_X() - 0.25;
    }

    protected SoundEvent func_184615_bR() {
        return SoundInit.DRAGON_DEATH;
    }

    protected SoundEvent func_184601_bQ(DamageSource damageSourceIn) {
        return SoundInit.DRAGON_HURT;
    }

    protected SoundEvent func_184639_G() {
        return SoundInit.DRAGON_AMBIENT;
    }

    @Override
    public boolean canBeDamaged(Entity attacker) {
        return attacker != this.owner;
    }
}

