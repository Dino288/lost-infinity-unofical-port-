package xol.lostinfinity.entity;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import xol.lostinfinity.registry.ModEffects;

public class LostDeviantMob extends LostPlaceholderMob {
    public enum Kind {
        DEVIANT,
        FLYING,
        CREEPER,
        ENDERMAN,
        SHULKER,
        CASTER,
        SPIDER,
        SLIME,
        BLAZE,
        GOLEM,
        PRIME,
        TITAN,
        TRIAL_OBSERVER
    }

    private final Kind kind;
    private final String id;

    public LostDeviantMob(EntityType<? extends PathfinderMob> type, Level level, Kind kind, String id) {
        super(type, level);
        this.kind = kind;
        this.id = id;
        this.xpReward = kind == Kind.TITAN || kind == Kind.TRIAL_OBSERVER ? 100 : kind == Kind.PRIME ? 50 : 10;
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(8, new LookAtPlayerGoal(this, Player.class, 16.0F));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));

        if (this.kind != Kind.SHULKER && this.kind != Kind.TRIAL_OBSERVER) {
            this.goalSelector.addGoal(2, new MeleeAttackGoal(this, this.kind == Kind.TITAN ? 1.15D : 1.0D, false));
            this.goalSelector.addGoal(7, new RandomStrollGoal(this, this.kind == Kind.TITAN ? 0.7D : 0.8D));
        }
    }

    public static AttributeSupplier.Builder deviantAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 80.0D)
                .add(Attributes.ATTACK_DAMAGE, 6.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.25D)
                .add(Attributes.FOLLOW_RANGE, 28.0D);
    }

    public static AttributeSupplier.Builder flyingAttributes() {
        return deviantAttributes()
                .add(Attributes.FLYING_SPEED, 0.32D);
    }

    public static AttributeSupplier.Builder primeAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 350.0D)
                .add(Attributes.ATTACK_DAMAGE, 12.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.3D)
                .add(Attributes.KNOCKBACK_RESISTANCE, 0.5D)
                .add(Attributes.FOLLOW_RANGE, 40.0D);
    }

    public static AttributeSupplier.Builder titanAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 1200.0D)
                .add(Attributes.ATTACK_DAMAGE, 20.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.22D)
                .add(Attributes.KNOCKBACK_RESISTANCE, 0.9D)
                .add(Attributes.FOLLOW_RANGE, 56.0D);
    }

    public static AttributeSupplier.Builder observerAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 1500.0D)
                .add(Attributes.ATTACK_DAMAGE, 10.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.0D)
                .add(Attributes.KNOCKBACK_RESISTANCE, 1.0D)
                .add(Attributes.FOLLOW_RANGE, 64.0D);
    }

    @Override
    public void aiStep() {
        super.aiStep();
        if (this.level().isClientSide()) {
            return;
        }

        LivingEntity target = this.getTarget();
        if (this.kind == Kind.FLYING || isFlyingName() || this.kind == Kind.PRIME && this.id.equals("livorax")) {
            tickFlying(target);
        }
        if (target == null) {
            return;
        }

        switch (this.kind) {
            case CREEPER -> tickCreeper(target);
            case ENDERMAN -> tickEnderman(target);
            case SHULKER -> tickTurret(target, 7.0F, 55, SoundEvents.SHULKER_SHOOT);
            case CASTER -> tickCaster(target);
            case SPIDER -> tickSpider(target);
            case SLIME -> tickSlime(target);
            case BLAZE -> tickBlaze(target);
            case GOLEM -> tickStomp(target, 7.0F, 70);
            case PRIME -> tickPrime(target);
            case TITAN -> tickTitan(target);
            case TRIAL_OBSERVER -> tickObserver(target);
            default -> tickNamedDeviant(target);
        }
    }

    @Override
    public boolean doHurtTarget(net.minecraft.world.entity.Entity target) {
        boolean hurt = super.doHurtTarget(target);
        if (hurt && target instanceof LivingEntity living) {
            applyHitEffects(living);
        }
        return hurt;
    }

    private void tickFlying(LivingEntity target) {
        this.fallDistance = 0.0F;
        if (this.tickCount % 20 < 10) {
            this.setDeltaMovement(this.getDeltaMovement().add(0.0D, 0.035D, 0.0D));
        }
        if (target != null) {
            Vec3 delta = target.position().subtract(this.position());
            if (delta.lengthSqr() > 4.0D) {
                this.setDeltaMovement(this.getDeltaMovement().add(delta.normalize().scale(0.055D)));
            }
            if (this.tickCount % (this.kind == Kind.TITAN ? 28 : 45) == 0) {
                shootAt(target, this.kind == Kind.TITAN ? 12.0F : 7.0F, 0.7F);
                this.level().playSound(null, this.blockPosition(), LostMobSounds.ability(this.id), SoundSource.HOSTILE, 1.0F, 1.1F);
            }
        }
    }

    private void tickCreeper(LivingEntity target) {
        int period = this.kind == Kind.TITAN ? 90 : 120;
        if (this.distanceToSqr(target) < (this.kind == Kind.TITAN ? 64.0D : 16.0D) && this.tickCount % period == 0) {
            this.level().explode(this, this.getX(), this.getY(), this.getZ(), this.kind == Kind.TITAN ? 6.0F : 3.0F, Level.ExplosionInteraction.MOB);
            if (this.kind != Kind.TITAN) {
                this.discard();
            }
        }
    }

    private void tickEnderman(LivingEntity target) {
        if ((this.distanceToSqr(target) > 100.0D || this.random.nextInt(120) == 0) && this.tickCount % 40 == 0) {
            this.teleportTo(target.getX() + this.random.nextInt(7) - 3, target.getY(), target.getZ() + this.random.nextInt(7) - 3);
            this.level().playSound(null, this.blockPosition(), SoundEvents.ENDERMAN_TELEPORT, SoundSource.HOSTILE, 1.0F, 1.0F);
        }
    }

    private void tickCaster(LivingEntity target) {
        if (this.tickCount % 50 == 0) {
            shootAt(target, 8.0F, 0.65F);
            target.addEffect(new MobEffectInstance(ModEffects.NULLIFIED.get(), 100, 0));
            target.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 120, 0));
            this.level().playSound(null, this.blockPosition(), LostMobSounds.ability(this.id), SoundSource.HOSTILE, 1.0F, 1.0F);
        }
    }

    private void tickSpider(LivingEntity target) {
        if (this.distanceToSqr(target) > 9.0D && this.distanceToSqr(target) < 100.0D && this.onGround() && this.tickCount % 45 == 0) {
            Vec3 delta = target.position().subtract(this.position()).normalize();
            this.setDeltaMovement(delta.x * 0.55D, 0.45D, delta.z * 0.55D);
        }
    }

    private void tickSlime(LivingEntity target) {
        if (this.onGround() && this.tickCount % 35 == 0) {
            Vec3 delta = target.position().subtract(this.position()).normalize();
            this.setDeltaMovement(delta.x * 0.35D, 0.55D, delta.z * 0.35D);
            this.level().playSound(null, this.blockPosition(), SoundEvents.SLIME_JUMP, SoundSource.HOSTILE, 1.0F, 0.8F);
        }
    }

    private void tickBlaze(LivingEntity target) {
        if (this.tickCount % 35 == 0) {
            shootAt(target, this.kind == Kind.TITAN ? 14.0F : 8.0F, 0.8F);
            this.level().playSound(null, this.blockPosition(), SoundEvents.BLAZE_SHOOT, SoundSource.HOSTILE, 1.0F, 1.0F);
        }
        if (this.distanceToSqr(target) < 16.0D) {
            target.setSecondsOnFire(this.kind == Kind.TITAN ? 8 : 4);
        }
    }

    private void tickPrime(LivingEntity target) {
        if (this.id.equals("azross") && this.tickCount % 45 == 0) {
            shootAt(target, 10.0F, 0.85F);
        } else if (this.id.equals("zenon") && this.tickCount % 55 == 0) {
            target.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 140, 1));
            target.addEffect(new MobEffectInstance(ModEffects.NULLIFIED.get(), 100, 0));
            shootAt(target, 9.0F, 0.75F);
        } else if (this.id.equals("kalikos")) {
            tickStomp(target, 9.0F, 55);
        }
    }

    private void tickTitan(LivingEntity target) {
        if (this.id.contains("blaze")) {
            tickBlaze(target);
        } else if (this.id.contains("creeper")) {
            tickCreeper(target);
        } else if (this.id.contains("enderman")) {
            tickEnderman(target);
        } else if (this.id.contains("shulker")) {
            tickTurret(target, 14.0F, 35, SoundEvents.SHULKER_SHOOT);
        } else if (this.id.contains("spider")) {
            tickSpider(target);
            tickStomp(target, 8.0F, 80);
        } else if (this.id.contains("vex")) {
            tickFlying(target);
        } else {
            tickStomp(target, 11.0F, 60);
        }
    }

    private void tickObserver(LivingEntity target) {
        this.setDeltaMovement(Vec3.ZERO);
        if (this.tickCount % 30 == 0) {
            tickTurret(target, 15.0F, 1, SoundEvents.GUARDIAN_ATTACK);
            target.addEffect(new MobEffectInstance(ModEffects.NULLIFIED.get(), 120, 1));
        }
    }

    private void tickNamedDeviant(LivingEntity target) {
        if (this.id.contains("guardian") || this.id.contains("squid")) {
            if (this.tickCount % 60 == 0) {
                target.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 120, 1));
                shootAt(target, 6.0F, 0.6F);
            }
        } else if (this.id.contains("snowman") && this.tickCount % 40 == 0) {
            target.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 100, 0));
            shootAt(target, 4.0F, 0.7F);
        }
    }

    private void tickTurret(LivingEntity target, float damage, int period, net.minecraft.sounds.SoundEvent sound) {
        if (period <= 1 || this.tickCount % period == 0) {
            shootAt(target, damage, 0.85F);
            this.level().playSound(null, this.blockPosition(), sound, SoundSource.HOSTILE, 1.0F, 1.0F);
        }
    }

    private void tickStomp(LivingEntity target, float damage, int period) {
        if (this.tickCount % period == 0 && this.distanceToSqr(target) < 81.0D) {
            target.hurt(this.damageSources().mobAttack(this), damage);
            Vec3 away = target.position().subtract(this.position()).normalize();
            target.push(away.x * 1.1D, 0.45D, away.z * 1.1D);
            this.level().playSound(null, this.blockPosition(), SoundEvents.GENERIC_EXPLODE, SoundSource.HOSTILE, 0.8F, 1.4F);
        }
    }

    private void shootAt(LivingEntity target, float damage, float velocity) {
        LostCombatProjectile projectile = new LostCombatProjectile(this.level(), this, damage);
        projectile.setPos(this.getX(), this.getEyeY() - 0.2D, this.getZ());
        Vec3 delta = target.getEyePosition().subtract(projectile.position());
        projectile.shoot(delta.x, delta.y, delta.z, velocity, 0.0F);
        this.level().addFreshEntity(projectile);
    }

    private void applyHitEffects(LivingEntity living) {
        if (this.kind == Kind.SPIDER || this.id.contains("spider")) {
            living.addEffect(new MobEffectInstance(MobEffects.POISON, 120, 0));
        }
        if (this.kind == Kind.BLAZE || this.id.contains("blaze") || this.id.contains("magmacube")) {
            living.setSecondsOnFire(this.kind == Kind.TITAN ? 8 : 4);
        }
        if (this.id.contains("wither")) {
            living.addEffect(new MobEffectInstance(MobEffects.WITHER, 120, 0));
        }
        if (this.kind == Kind.TITAN || this.kind == Kind.PRIME) {
            living.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 80, 0));
        }
    }

    private boolean isFlyingName() {
        return this.id.contains("ghast") || this.id.contains("vex") || this.id.contains("skyworm") || this.id.contains("bat");
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return LostMobSounds.ambient(this.id);
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return LostMobSounds.hurt(this.id, source);
    }

    @Override
    protected SoundEvent getDeathSound() {
        return LostMobSounds.death(this.id);
    }
}
