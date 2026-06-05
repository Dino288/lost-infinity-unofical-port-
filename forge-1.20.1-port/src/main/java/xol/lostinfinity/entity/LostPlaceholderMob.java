package xol.lostinfinity.entity;

import java.util.Locale;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.Guardian;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import xol.lostinfinity.effect.LostFx;
import xol.lostinfinity.LostInfinity;
import xol.lostinfinity.registry.ModEffects;
import xol.lostinfinity.registry.ModEntities;

public class LostPlaceholderMob extends PathfinderMob {
    private static final String FUSE_TAG = "LostFuse";
    private static final String SUMMONED_MINION_TAG = "SummonedMinion";
    private static final String BOSS_PHASE_TAG = "LostBossPhase";
    private int specialCooldown;
    private int supportCooldown;
    private int ambushCooldown;
    private int fuseTicks = -1;
    private int bossPhase = 1;
    private boolean summonedMinion;

    public LostPlaceholderMob(EntityType<? extends PathfinderMob> type, Level level) {
        super(type, level);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        if (!isPassiveEntity()) {
            this.goalSelector.addGoal(2, new MeleeAttackGoal(this, isHeavyEntity() ? 0.8D : 1.05D, false));
        }
        this.goalSelector.addGoal(7, new RandomStrollGoal(this, isFlyingEntity() ? 1.0D : 0.8D));
        this.goalSelector.addGoal(8, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
        if (!isPassiveEntity()) {
            this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
            this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
        }
    }

    @Override
    public void aiStep() {
        super.aiStep();
        if (isFlyingEntity()) {
            this.setNoGravity(true);
            if (this.getTarget() == null && this.tickCount % 45 == 0) {
                this.setDeltaMovement(this.getDeltaMovement().add(randomDrift()));
            }
        } else if (isBurrowEntity()) {
            this.setNoGravity(false);
        }
        if (isStationaryEntity()) {
            this.setDeltaMovement(Vec3.ZERO);
        }
        if (!this.level().isClientSide()) {
            tickSpecialBehavior();
        }
    }

    @Override
    public boolean doHurtTarget(Entity target) {
        boolean hurt = super.doHurtTarget(target);
        if (target instanceof LivingEntity living) {
            applyThemedHit(living);
        }
        if (isExplosiveEntity()) {
            primeFuse();
        }
        return hurt;
    }

    @Override
    public boolean hurt(DamageSource source, float amount) {
        boolean hurt = super.hurt(source, amount);
        if (hurt && !this.level().isClientSide()) {
            if (isSplitterEntity() && this.getHealth() > 0.0F && this.getHealth() < this.getMaxHealth() * 0.5F && this.tickCount % 20 == 0) {
                splitMinions();
            }
            if (isPackEntity() && source.getEntity() instanceof LivingEntity attacker) {
                callPack(attacker);
            }
        }
        return hurt;
    }

    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        this.fuseTicks = tag.getInt(FUSE_TAG);
        this.summonedMinion = tag.getBoolean(SUMMONED_MINION_TAG);
        this.bossPhase = Math.max(1, tag.getInt(BOSS_PHASE_TAG));
    }

    @Override
    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putInt(FUSE_TAG, this.fuseTicks);
        tag.putBoolean(SUMMONED_MINION_TAG, this.summonedMinion);
        tag.putInt(BOSS_PHASE_TAG, this.bossPhase);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 32.0D)
                .add(Attributes.ATTACK_DAMAGE, 5.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.23D)
                .add(Attributes.FOLLOW_RANGE, 24.0D)
                .add(Attributes.KNOCKBACK_RESISTANCE, 0.2D)
                .add(Attributes.FLYING_SPEED, 0.18D);
    }

    @Override
    protected ResourceLocation getDefaultLootTable() {
        return ResourceLocation.fromNamespaceAndPath(LostInfinity.MODID, recoveredLootId(mobId()));
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return LostMobSounds.ambient(mobId());
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return LostMobSounds.hurt(mobId(), source);
    }

    @Override
    protected SoundEvent getDeathSound() {
        return LostMobSounds.death(mobId());
    }

    private void tickSpecialBehavior() {
        if (this.specialCooldown > 0) {
            this.specialCooldown--;
        }
        if (this.supportCooldown > 0) {
            this.supportCooldown--;
        }
        if (this.ambushCooldown > 0) {
            this.ambushCooldown--;
        }
        LivingEntity target = this.getTarget();
        if (target != null && target.isAlive()) {
            if (isStationaryEntity()) {
                this.getNavigation().stop();
                this.setDeltaMovement(Vec3.ZERO);
            }
            if (isFlyingEntity()) {
                Vec3 delta = target.getEyePosition().subtract(this.position());
                if (delta.lengthSqr() > 1.0D) {
                    this.setDeltaMovement(this.getDeltaMovement().scale(0.86D).add(delta.normalize().scale(0.075D)));
                }
            }
            if (isBurrowEntity() && this.ambushCooldown <= 0 && this.distanceToSqr(target) > 16.0D && this.distanceToSqr(target) < 196.0D) {
                ambush(target);
                this.ambushCooldown = 120;
            }
            if (isRangedEntity() && this.specialCooldown <= 0 && this.distanceToSqr(target) < 28.0D * 28.0D) {
                shootAt(target);
                this.specialCooldown = rangedCooldown();
            }
            if (isPackEntity() && this.supportCooldown <= 0) {
                callPack(target);
                this.supportCooldown = 100;
            }
            if (isExplosiveEntity() && this.distanceToSqr(target) < 4.0D * 4.0D) {
                primeFuse();
            }
            if (isTrapEntity() && this.distanceToSqr(target) < 9.0D) {
                springTrap(target);
            }
            if (isDecoyEntity() && this.supportCooldown <= 0) {
                confuseTarget(target);
                this.supportCooldown = 140;
            }
            if (isEvasiveEntity() && this.ambushCooldown <= 0 && this.distanceToSqr(target) < 36.0D) {
                evadeTarget(target);
                this.ambushCooldown = 90;
            }
            if (isWebbingEntity() && this.specialCooldown <= 0 && this.distanceToSqr(target) < 144.0D) {
                webTarget(target);
                this.specialCooldown = 100;
            }
            if (isAquaticEntity() && this.specialCooldown <= 0 && this.distanceToSqr(target) < 100.0D) {
                reefCurrent(target);
                this.specialCooldown = 80;
            }
            if (isLeaperEntity() && this.onGround() && this.ambushCooldown <= 0 && this.distanceToSqr(target) > 9.0D && this.distanceToSqr(target) < 144.0D) {
                leapAt(target);
                this.ambushCooldown = 70;
            }
            if (isBossEntity() && this.getHealth() < this.getMaxHealth() * 0.5F && this.supportCooldown <= 0) {
                enrage(target);
                this.supportCooldown = 160;
            }
            if (isRecoveredBossEntity()) {
                tickRecoveredBossBehavior(target);
            }
        }
        if ((isHealerEntity() || isSummonerEntity()) && this.supportCooldown <= 0) {
            if (isHealerEntity()) {
                healAllies();
            }
            if (!this.summonedMinion && isSummonerEntity() && target != null && target.isAlive()) {
                summonMinion(target);
            }
            this.supportCooldown = isSummonerEntity() ? 180 : 120;
        }
        if (isCollectorEntity() && this.tickCount % 40 == 0) {
            collectNearbyItems();
        }
        if (isMountEntity() && target != null && target.isAlive() && this.tickCount % 35 == 0) {
            mountedCharge(target);
        }
        if (this.fuseTicks >= 0) {
            this.fuseTicks++;
            if (this.fuseTicks % 8 == 0) {
                LostFx.burst(this.level(), this.blockPosition(), isStormEntity() ? "electric_explosion_blue" : "plasma", 8, 0.35D, 0.03D);
                this.level().playSound(null, this.blockPosition(), SoundEvents.CREEPER_PRIMED, SoundSource.HOSTILE, 0.35F, 1.4F);
            }
            if (this.fuseTicks >= 30) {
                explode();
            }
        }
        if (isTotemEntity() && this.tickCount % 80 == 0) {
            for (LivingEntity living : this.level().getEntitiesOfClass(LivingEntity.class, this.getBoundingBox().inflate(6.0D), e -> e != this)) {
                if (living instanceof Player) {
                    living.addEffect(new MobEffectInstance(ModEffects.NULLIFIED.get(), 80, 0));
                } else if (living.getType().builtInRegistryHolder().key().location().getNamespace().equals("lostinfinity")) {
                    living.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 100, 0, true, false));
                }
            }
            LostFx.burst(this.level(), this.blockPosition(), "gravity_ring", 12, 0.7D, 0.02D);
        }
    }

    private void shootAt(LivingEntity target) {
        LostCombatProjectile projectile = new LostCombatProjectile(this.level(), this, projectileDamage());
        projectile.setPos(this.getX(), this.getEyeY() - 0.15D, this.getZ());
        Vec3 delta = target.getEyePosition().subtract(projectile.position());
        projectile.shoot(delta.x, delta.y, delta.z, projectileVelocity(), 0.2F);
        this.level().addFreshEntity(projectile);
        this.level().playSound(null, this.blockPosition(), LostMobSounds.ability(mobId()), SoundSource.HOSTILE, 0.65F, projectilePitch());
    }

    private void healAllies() {
        boolean didHeal = false;
        for (LivingEntity living : this.level().getEntitiesOfClass(LivingEntity.class, this.getBoundingBox().inflate(7.0D))) {
            if (living == this || !living.getType().builtInRegistryHolder().key().location().getNamespace().equals("lostinfinity")) {
                continue;
            }
            if (living.getHealth() < living.getMaxHealth()) {
                living.heal(isBossEntity() ? 8.0F : 4.0F);
                living.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 80, 0, true, false));
                didHeal = true;
            }
        }
        if (didHeal) {
            LostFx.burst(this.level(), this.blockPosition(), "murky_mist", 18, 1.0D, 0.03D);
            this.level().playSound(null, this.blockPosition(), SoundEvents.BEACON_POWER_SELECT, SoundSource.HOSTILE, 0.7F, 1.35F);
        }
    }

    private void summonMinion(LivingEntity target) {
        LostPlaceholderMob minion = (LostPlaceholderMob) this.getType().create(this.level());
        if (minion == null) {
            return;
        }
        Vec3 around = target.position().add((this.random.nextDouble() - 0.5D) * 5.0D, 0.0D, (this.random.nextDouble() - 0.5D) * 5.0D);
        minion.moveTo(around.x, around.y, around.z, this.random.nextFloat() * 360.0F, 0.0F);
        minion.summonedMinion = true;
        minion.setHealth(Math.max(4.0F, minion.getMaxHealth() * 0.35F));
        minion.setTarget(target);
        this.level().addFreshEntity(minion);
        LostFx.burst(this.level(), minion.blockPosition(), "ancient_spell", 16, 0.6D, 0.04D);
        this.level().playSound(null, minion.blockPosition(), LostMobSounds.ability(mobId()), SoundSource.HOSTILE, 0.7F, 1.2F);
    }

    private void tickRecoveredBossBehavior(LivingEntity target) {
        int phase = bossPhaseForHealth();
        if (phase != this.bossPhase) {
            this.bossPhase = phase;
            this.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 90, 1, true, false));
            this.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 140, phase - 1, true, false));
            LostFx.burst(this.level(), this.blockPosition(), bossPhaseParticle(), 36, 1.6D, 0.07D);
            this.level().playSound(null, this.blockPosition(), SoundEvents.WITHER_SPAWN, SoundSource.HOSTILE, 0.7F, 0.75F + phase * 0.1F);
        }
        switch (mobId()) {
            case "cthulhu" -> tickCthulhuBoss(target, phase);
            case "andromeda" -> tickAndromedaBoss(target, phase);
            case "mushmerra" -> tickMushmerraBoss(target, phase);
            case "thundyron" -> tickThunderBoss(target, phase);
            case "cryonus" -> tickCryonusBoss(target, phase);
            case "ozor" -> tickOzorBoss(target, phase);
            case "elara" -> tickElaraBoss(target, phase);
            case "arash" -> tickArashBoss(target, phase);
            case "urogo" -> tickUrogoBoss(target, phase);
            case "velo" -> tickVeloBoss(target, phase);
            default -> {
            }
        }
    }

    private void tickCthulhuBoss(LivingEntity target, int phase) {
        if (this.tickCount % Math.max(28, 60 - phase * 10) == 0) {
            shootAt(target);
        }
        if (this.tickCount % Math.max(75, 130 - phase * 20) == 0) {
            gravityPulse(target, 8.0D + phase, 3.0F + phase, "blackhole_ring");
        }
        if (this.tickCount % Math.max(95, 160 - phase * 20) == 0) {
            spawnBossMinion(ModEntities.CTHULHU_TENTACLE.get(), target, 0.45F, 6);
            if (phase >= 2) {
                spawnBossMinion(ModEntities.CTHULHU_TURRET.get(), target, 0.35F, 3);
            }
            if (phase >= 3) {
                spawnBossMinion(ModEntities.CTHULHU_HEALING_ORB.get(), target, 0.3F, 2);
            }
        }
    }

    private void tickAndromedaBoss(LivingEntity target, int phase) {
        if (this.tickCount % Math.max(24, 50 - phase * 8) == 0) {
            shootAt(target);
        }
        if (this.tickCount % Math.max(65, 115 - phase * 15) == 0) {
            gravityPulse(target, 7.0D + phase, 2.0F + phase, "gravity_ring");
            target.addEffect(new MobEffectInstance(ModEffects.DIMENSIONAL_TEAR.get(), 120, phase - 1));
        }
        if (this.tickCount % Math.max(80, 150 - phase * 20) == 0) {
            evadeTarget(target);
        }
    }

    private void tickMushmerraBoss(LivingEntity target, int phase) {
        if (this.tickCount % Math.max(50, 90 - phase * 12) == 0) {
            sporePulse(target, 5.0D + phase);
        }
        if (this.tickCount % Math.max(95, 155 - phase * 20) == 0) {
            spawnBossMinion(phase >= 2 ? ModEntities.MUSHMERRA_CLONE.get() : ModEntities.SHROOMITE.get(), target, phase >= 2 ? 0.35F : 0.55F, phase >= 3 ? 6 : 4);
        }
        if (phase >= 2 && this.tickCount % 120 == 0 && this.getHealth() < this.getMaxHealth()) {
            this.heal(4.0F + phase);
            LostFx.burst(this.level(), this.blockPosition(), "poison_rings", 20, 1.0D, 0.04D);
        }
    }

    private void tickThunderBoss(LivingEntity target, int phase) {
        if (this.tickCount % Math.max(30, 65 - phase * 10) == 0) {
            shootAt(target);
            target.addEffect(new MobEffectInstance(ModEffects.NULLIFIED.get(), 100, phase - 1));
        }
        if (this.tickCount % Math.max(70, 125 - phase * 15) == 0) {
            stormPulse(target, phase, "electric_explosion_blue");
        }
    }

    private void tickCryonusBoss(LivingEntity target, int phase) {
        if (this.tickCount % Math.max(34, 70 - phase * 10) == 0) {
            shootAt(target);
            target.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 130, phase));
        }
        if (this.tickCount % Math.max(80, 135 - phase * 15) == 0) {
            stormPulse(target, phase, "snowflake");
        }
    }

    private void tickOzorBoss(LivingEntity target, int phase) {
        if (this.tickCount % Math.max(38, 75 - phase * 10) == 0) {
            confuseTarget(target);
        }
        if (this.tickCount % Math.max(90, 150 - phase * 18) == 0) {
            spawnBossMinion(ModEntities.OZORDECOY.get(), target, 0.45F, phase >= 3 ? 5 : 3);
            if (phase >= 2) {
                evadeTarget(target);
            }
        }
    }

    private void tickElaraBoss(LivingEntity target, int phase) {
        if (this.tickCount % 60 == 0) {
            shootAt(target);
        }
        if (this.tickCount % 100 == 0) {
            pushNearbyPlayers(7.0D, 1.39D, 0.65D, "portal_beam");
        }
        if (this.tickCount % 150 == 0) {
            Vec3 charge = target.position().subtract(this.position()).normalize().scale(0.65D);
            this.setDeltaMovement(charge.x, 1.0D, charge.z);
            LostFx.burst(this.level(), this.blockPosition(), "supersonic_blue", 20, 0.8D, 0.04D);
            this.level().playSound(null, this.blockPosition(), SoundEvents.TRIDENT_RIPTIDE_3, SoundSource.HOSTILE, 0.8F, 1.2F);
        }
        if (this.tickCount % 120 == 0) {
            rainProjectilesOver(target, 8 + this.random.nextInt(4), "space_magic");
        }
        if (phase >= 2 && this.tickCount % 400 == 0) {
            spawnGuardians(target, 4 + this.random.nextInt(2));
        }
    }

    private void tickArashBoss(LivingEntity target, int phase) {
        if (this.tickCount % 120 == 0) {
            this.teleportTo(target.getX(), target.getY(), target.getZ());
            target.hurt(this.damageSources().mobAttack(this), Math.max(4.0F, target.getMaxHealth() / 4.0F));
            pushNearbyPlayers(4.0D, 0.59D, 0.35D, "sweep_attack");
            this.level().playSound(null, this.blockPosition(), SoundEvents.PLAYER_ATTACK_SWEEP, SoundSource.HOSTILE, 0.9F, 0.8F);
        }
        if ((this.tickCount + 80) % 100 == 0) {
            int crystalCount = 1 + (phase >= 2 ? 1 : 0) + (phase >= 3 ? 1 : 0);
            for (int i = 0; i < crystalCount; i++) {
                spawnBossMinion(ModEntities.DEVIANTCRYSTAL.get(), target, phase >= 3 ? 0.75F : 0.55F, 6);
            }
        }
    }

    private void tickUrogoBoss(LivingEntity target, int phase) {
        int interval = phase >= 2 ? 50 : 120;
        if (this.tickCount % interval != 0) {
            return;
        }
        switch (this.random.nextInt(3)) {
            case 0 -> {
                this.teleportTo(target.getX(), target.getY(), target.getZ());
                target.hurt(this.damageSources().mobAttack(this), Math.max(5.0F, target.getMaxHealth() / 7.0F));
            }
            case 1 -> {
                target.teleportTo(this.getX(), this.getY(), this.getZ());
                target.hurt(this.damageSources().mobAttack(this), Math.max(5.0F, target.getMaxHealth() / 8.0F));
            }
            default -> {
                this.teleportTo(25.5D, 62.2D, -92.0D);
                target.teleportTo(25.5D, 62.2D, -88.0D);
                target.addEffect(new MobEffectInstance(ModEffects.TETHERED.get(), 120, 0));
            }
        }
        target.push(this.getDeltaMovement().x * 7.5D, 0.4D, this.getDeltaMovement().z * 7.0D);
        LostFx.burst(this.level(), target.blockPosition(), "bad_magic", 22, 0.8D, 0.05D);
        this.level().playSound(null, target.blockPosition(), SoundEvents.ENDERMAN_TELEPORT, SoundSource.HOSTILE, 0.8F, 0.65F);
    }

    private void tickVeloBoss(LivingEntity target, int phase) {
        if (this.tickCount % 30 == 0) {
            for (int i = -1; i <= 1; i++) {
                shootSpreadAt(target, i * 0.45D, 6.0F + phase);
            }
            this.level().playSound(null, this.blockPosition(), SoundEvents.EVOKER_CAST_SPELL, SoundSource.HOSTILE, 1.0F, 1.0F);
        }
        int roomForm = (phase - 1) % 3;
        if (roomForm == 2 && this.tickCount % 80 == 0) {
            radialProjectiles(12, 0.35D, "ancient_spell");
        } else if (roomForm == 1 && this.tickCount % 60 < 30 && this.tickCount % 2 == 0) {
            radialProjectiles(1, 0.25D, "space_magic");
        } else if (roomForm == 0 && this.tickCount % 90 <= 30 && this.tickCount % 10 == 0) {
            radialProjectiles(10, 0.2D + 0.08D * ((this.tickCount % 90) / 10), "portal_beam");
        }
    }

    private void spawnBossMinion(EntityType<? extends LostPlaceholderMob> type, LivingEntity target, float healthScale, int maxNearby) {
        String family = minionFamily(type);
        long nearby = this.level().getEntitiesOfClass(LostPlaceholderMob.class, this.getBoundingBox().inflate(24.0D),
                mob -> mob != this && mob.summonedMinion && mob.mobId().startsWith(family)).size();
        if (nearby >= maxNearby) {
            return;
        }
        LostPlaceholderMob minion = type.create(this.level());
        if (minion == null) {
            return;
        }
        Vec3 offset = new Vec3((this.random.nextDouble() - 0.5D) * 8.0D, 0.0D, (this.random.nextDouble() - 0.5D) * 8.0D);
        if (offset.lengthSqr() < 1.0D) {
            offset = new Vec3(2.0D, 0.0D, 0.0D);
        }
        Vec3 spawn = this.position().add(offset);
        minion.moveTo(spawn.x, this.getY(), spawn.z, this.random.nextFloat() * 360.0F, 0.0F);
        minion.summonedMinion = true;
        minion.bossPhase = this.bossPhase;
        minion.setHealth(Math.max(4.0F, minion.getMaxHealth() * healthScale));
        minion.setTarget(target);
        this.level().addFreshEntity(minion);
        LostFx.burst(this.level(), minion.blockPosition(), minion.mobId().contains("cthulhu") ? "shadow_blast" : "ancient_spell", 18, 0.7D, 0.04D);
        this.level().playSound(null, minion.blockPosition(), LostMobSounds.ability(mobId()), SoundSource.HOSTILE, 0.65F, 1.15F);
    }

    private void gravityPulse(LivingEntity target, double radius, float damage, String particle) {
        for (LivingEntity living : this.level().getEntitiesOfClass(LivingEntity.class, this.getBoundingBox().inflate(radius),
                e -> e != this && e.isAlive() && !isLostInfinityMob(e))) {
            Vec3 pull = this.position().add(0.0D, this.getBbHeight() * 0.5D, 0.0D).subtract(living.position());
            if (pull.lengthSqr() > 0.01D) {
                living.push(pull.normalize().x * 0.65D, 0.25D, pull.normalize().z * 0.65D);
            }
            living.addEffect(new MobEffectInstance(ModEffects.NULLIFIED.get(), 90, 0));
            if (living == target || living.distanceToSqr(this) < 16.0D) {
                living.hurt(this.damageSources().mobAttack(this), damage);
            }
        }
        LostFx.burst(this.level(), this.blockPosition(), particle, 34, radius * 0.16D, 0.07D);
        this.level().playSound(null, this.blockPosition(), SoundEvents.BEACON_DEACTIVATE, SoundSource.HOSTILE, 0.75F, 0.7F);
    }

    private void sporePulse(LivingEntity target, double radius) {
        for (LivingEntity living : this.level().getEntitiesOfClass(LivingEntity.class, this.getBoundingBox().inflate(radius),
                e -> e != this && e.isAlive() && !isLostInfinityMob(e))) {
            living.addEffect(new MobEffectInstance(MobEffects.POISON, 120, bossPhase - 1));
            living.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 120, 0));
            if (living == target) {
                living.hurt(this.damageSources().mobAttack(this), 2.0F + bossPhase);
            }
        }
        LostFx.burst(this.level(), this.blockPosition(), "plague", 30, radius * 0.14D, 0.05D);
        this.level().playSound(null, this.blockPosition(), SoundEvents.FUNGUS_PLACE, SoundSource.HOSTILE, 0.8F, 0.85F);
    }

    private void stormPulse(LivingEntity target, int phase, String particle) {
        for (LivingEntity living : this.level().getEntitiesOfClass(LivingEntity.class, this.getBoundingBox().inflate(6.0D + phase),
                e -> e != this && e.isAlive() && !isLostInfinityMob(e))) {
            living.hurt(this.damageSources().mobAttack(this), 3.0F + phase);
            if ("snowflake".equals(particle)) {
                living.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 140, phase));
                living.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 100, 0));
            } else {
                living.addEffect(new MobEffectInstance(ModEffects.NULLIFIED.get(), 100, phase - 1));
                living.push(0.0D, 0.45D, 0.0D);
            }
        }
        LostFx.burst(this.level(), target.blockPosition(), particle, 28, 1.0D, 0.07D);
        this.level().playSound(null, target.blockPosition(), SoundEvents.LIGHTNING_BOLT_THUNDER, SoundSource.HOSTILE, 0.7F, "snowflake".equals(particle) ? 1.4F : 1.0F);
    }

    private void pushNearbyPlayers(double radius, double strength, double yBoost, String particle) {
        for (Player player : this.level().getEntitiesOfClass(Player.class, this.getBoundingBox().inflate(radius), Player::isAlive)) {
            Vec3 away = player.position().subtract(this.position());
            if (away.lengthSqr() < 0.01D) {
                away = randomDrift();
            }
            Vec3 push = away.normalize().scale(strength);
            player.push(push.x, yBoost, push.z);
        }
        LostFx.burst(this.level(), this.blockPosition(), particle, 22, radius * 0.12D, 0.05D);
    }

    private void spawnGuardians(LivingEntity target, int count) {
        for (int i = 0; i < count; i++) {
            Guardian guardian = EntityType.GUARDIAN.create(this.level());
            if (guardian == null) {
                continue;
            }
            guardian.moveTo(this.getX() - 4.0D + this.random.nextDouble() * 8.0D, this.getY() + 2.0D,
                    this.getZ() - 4.0D + this.random.nextDouble() * 8.0D, this.random.nextFloat() * 360.0F, 0.0F);
            guardian.setTarget(target);
            this.level().addFreshEntity(guardian);
        }
        LostFx.burst(this.level(), this.blockPosition(), "murk", 30, 1.2D, 0.04D);
        this.level().playSound(null, this.blockPosition(), SoundEvents.GUARDIAN_AMBIENT, SoundSource.HOSTILE, 0.9F, 0.85F);
    }

    private void rainProjectilesOver(LivingEntity target, int count, String particle) {
        for (int i = 0; i < count; i++) {
            LostCombatProjectile projectile = new LostCombatProjectile(this.level(), this, 6.0F + this.bossPhase);
            projectile.setPos(target.getX() - 4.0D + this.random.nextDouble() * 8.0D, target.getY() + 12.0D + this.random.nextDouble() * 8.0D,
                    target.getZ() - 4.0D + this.random.nextDouble() * 8.0D);
            projectile.shoot(0.0D, -0.35D, 0.0D, 0.75F, 0.1F);
            this.level().addFreshEntity(projectile);
        }
        LostFx.burst(this.level(), target.blockPosition(), particle, 18, 0.9D, 0.04D);
        this.level().playSound(null, target.blockPosition(), SoundEvents.ILLUSIONER_CAST_SPELL, SoundSource.HOSTILE, 0.8F, 1.15F);
    }

    private void shootSpreadAt(LivingEntity target, double spread, float damage) {
        LostCombatProjectile projectile = new LostCombatProjectile(this.level(), this, damage);
        projectile.setPos(this.getX(), this.getEyeY() - 0.15D, this.getZ());
        Vec3 delta = target.getEyePosition().subtract(projectile.position()).add(spread, 0.0D, -spread);
        projectile.shoot(delta.x, delta.y + delta.horizontalDistance() * 0.2D, delta.z, 1.55F, 0.0F);
        this.level().addFreshEntity(projectile);
    }

    private void radialProjectiles(int count, double yLift, String particle) {
        for (int i = 0; i < count; i++) {
            double angle = (Math.PI * 2.0D * i) / Math.max(1, count);
            LostCombatProjectile projectile = new LostCombatProjectile(this.level(), this, 5.0F + this.bossPhase);
            projectile.setPos(this.getX(), this.getEyeY(), this.getZ());
            projectile.shoot(Math.cos(angle), yLift, Math.sin(angle), 1.25F, 0.0F);
            this.level().addFreshEntity(projectile);
        }
        LostFx.burst(this.level(), this.blockPosition(), particle, Math.max(12, count * 2), 0.9D, 0.04D);
    }

    private void splitMinions() {
        for (int i = 0; i < 2; i++) {
            LostPlaceholderMob minion = (LostPlaceholderMob) this.getType().create(this.level());
            if (minion == null) {
                continue;
            }
            minion.moveTo(this.getX() + (this.random.nextDouble() - 0.5D) * 1.6D, this.getY(), this.getZ() + (this.random.nextDouble() - 0.5D) * 1.6D,
                    this.random.nextFloat() * 360.0F, 0.0F);
            minion.summonedMinion = true;
            minion.setHealth(Math.max(3.0F, minion.getMaxHealth() * 0.25F));
            minion.setTarget(this.getTarget());
            this.level().addFreshEntity(minion);
        }
        LostFx.burst(this.level(), this.blockPosition(), "gloop_splash", 24, 0.9D, 0.05D);
        this.level().playSound(null, this.blockPosition(), SoundEvents.SLIME_BLOCK_BREAK, SoundSource.HOSTILE, 0.8F, 0.8F);
    }

    private void callPack(LivingEntity target) {
        for (LostPlaceholderMob ally : this.level().getEntitiesOfClass(LostPlaceholderMob.class, this.getBoundingBox().inflate(12.0D))) {
            if (ally != this && ally.getTarget() == null && ally.mobFamily().equals(this.mobFamily())) {
                ally.setTarget(target);
            }
        }
        LostFx.burst(this.level(), this.blockPosition(), "supersonic_blue", 8, 0.45D, 0.02D);
    }

    private void ambush(LivingEntity target) {
        Vec3 away = this.position().subtract(target.position()).normalize().scale(2.2D);
        this.teleportTo(target.getX() + away.x, target.getY(), target.getZ() + away.z);
        this.setDeltaMovement(target.position().subtract(this.position()).normalize().scale(0.55D).add(0.0D, 0.35D, 0.0D));
        LostFx.burst(this.level(), this.blockPosition(), isStoneEntity() ? "small_spark" : "murky_mist", 18, 0.8D, 0.04D);
        this.level().playSound(null, this.blockPosition(), SoundEvents.GRAVEL_BREAK, SoundSource.HOSTILE, 0.8F, 0.8F);
    }

    private void springTrap(LivingEntity target) {
        if (this.specialCooldown > 0) {
            return;
        }
        this.specialCooldown = 80;
        target.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 120, isBossEntity() ? 3 : 2));
        target.addEffect(new MobEffectInstance(ModEffects.NULLIFIED.get(), 80, 0));
        Vec3 pull = this.position().subtract(target.position()).normalize().scale(0.85D);
        target.push(pull.x, 0.15D, pull.z);
        LostFx.burst(this.level(), this.blockPosition(), mobId().contains("tentacle") ? "shadow_blast" : "gravity_ring", 20, 0.7D, 0.04D);
        this.level().playSound(null, this.blockPosition(), SoundEvents.CHAIN_PLACE, SoundSource.HOSTILE, 0.8F, 0.85F);
    }

    private void confuseTarget(LivingEntity target) {
        target.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 160, 0));
        target.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 60, 0));
        LostFx.burst(this.level(), target.blockPosition(), "space_magic", 16, 0.55D, 0.03D);
        this.level().playSound(null, this.blockPosition(), LostMobSounds.ability(mobId()), SoundSource.HOSTILE, 0.7F, 1.15F);
    }

    private void evadeTarget(LivingEntity target) {
        Vec3 away = this.position().subtract(target.position()).normalize();
        if (away.lengthSqr() == 0.0D) {
            away = randomDrift().normalize();
        }
        this.teleportTo(this.getX() + away.x * 4.0D, this.getY() + 0.2D, this.getZ() + away.z * 4.0D);
        this.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 80, 0, true, false));
        LostFx.burst(this.level(), this.blockPosition(), "spectral", 18, 0.7D, 0.04D);
        this.level().playSound(null, this.blockPosition(), SoundEvents.ENDERMAN_TELEPORT, SoundSource.HOSTILE, 0.65F, 1.4F);
    }

    private void webTarget(LivingEntity target) {
        target.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 160, 2));
        target.addEffect(new MobEffectInstance(ModEffects.TETHERED.get(), 120, 0));
        Vec3 pull = this.position().subtract(target.position()).normalize().scale(0.45D);
        target.push(pull.x, 0.1D, pull.z);
        LostFx.burst(this.level(), target.blockPosition(), "murky_mist", 16, 0.55D, 0.02D);
        this.level().playSound(null, target.blockPosition(), SoundEvents.WOOL_PLACE, SoundSource.HOSTILE, 0.8F, 0.9F);
    }

    private void reefCurrent(LivingEntity target) {
        Vec3 swirl = new Vec3(target.getZ() - this.getZ(), 0.15D, this.getX() - target.getX()).normalize().scale(0.45D);
        target.push(swirl.x, swirl.y, swirl.z);
        target.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 100, 0));
        LostFx.burst(this.level(), target.blockPosition(), "murk", 18, 0.7D, 0.04D);
        this.level().playSound(null, target.blockPosition(), SoundEvents.BUBBLE_COLUMN_WHIRLPOOL_INSIDE, SoundSource.HOSTILE, 0.7F, 1.1F);
    }

    private void leapAt(LivingEntity target) {
        Vec3 delta = target.position().subtract(this.position()).normalize();
        this.setDeltaMovement(delta.x * 0.75D, 0.55D, delta.z * 0.75D);
        LostFx.burst(this.level(), this.blockPosition(), isStoneEntity() ? "small_spark" : "supersonic_blue", 10, 0.45D, 0.02D);
        this.level().playSound(null, this.blockPosition(), SoundEvents.RAVAGER_STEP, SoundSource.HOSTILE, 0.7F, 1.25F);
    }

    private void enrage(LivingEntity target) {
        this.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 180, 1, true, false));
        this.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 180, 0, true, false));
        if (this.random.nextBoolean()) {
            shootAt(target);
        }
        LostFx.burst(this.level(), this.blockPosition(), isStormEntity() ? "electric_explosion_blue" : "bad_magic", 24, 1.1D, 0.05D);
        this.level().playSound(null, this.blockPosition(), SoundEvents.WITHER_AMBIENT, SoundSource.HOSTILE, 0.8F, 0.8F);
    }

    private void collectNearbyItems() {
        for (ItemEntity item : this.level().getEntitiesOfClass(ItemEntity.class, this.getBoundingBox().inflate(5.0D))) {
            Vec3 pull = this.position().add(0.0D, this.getBbHeight() * 0.5D, 0.0D).subtract(item.position());
            if (pull.lengthSqr() > 0.04D) {
                item.setDeltaMovement(item.getDeltaMovement().scale(0.6D).add(pull.normalize().scale(0.18D)));
            } else if (mobId().contains("pearl") || mobId().contains("collector")) {
                this.heal(1.0F);
                item.discard();
                LostFx.burst(this.level(), this.blockPosition(), "portal_beam", 8, 0.3D, 0.02D);
            }
        }
    }

    private void mountedCharge(LivingEntity target) {
        Vec3 delta = target.position().subtract(this.position());
        if (delta.lengthSqr() > 4.0D && delta.lengthSqr() < 144.0D) {
            this.setDeltaMovement(delta.normalize().scale(0.95D).add(0.0D, 0.18D, 0.0D));
            this.level().playSound(null, this.blockPosition(), SoundEvents.HORSE_GALLOP, SoundSource.HOSTILE, 0.7F, 1.05F);
        }
    }

    private void applyThemedHit(LivingEntity living) {
        String id = mobId();
        if (id.contains("acid") || id.contains("vile") || id.contains("poison") || id.contains("venom") || id.contains("blight")) {
            living.addEffect(new MobEffectInstance(MobEffects.POISON, 120, id.contains("blight") ? 1 : 0));
        }
        if (id.contains("fyre") || id.contains("fire") || id.contains("flame") || id.contains("sun") || id.contains("explosect")) {
            living.setSecondsOnFire(5);
        }
        if (id.contains("cryo") || id.contains("ice") || id.contains("gloop") || id.contains("sticky") || id.contains("web")) {
            living.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 120, 1));
        }
        if (id.contains("hypno") || id.contains("screach") || id.contains("scream") || id.contains("whisper") || id.contains("terror")) {
            living.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 120, 0));
        }
        if (id.contains("shadow") || id.contains("doom") || id.contains("cthulhu") || id.contains("void") || id.contains("wither")) {
            living.addEffect(new MobEffectInstance(MobEffects.WITHER, 100, 0));
            living.addEffect(new MobEffectInstance(ModEffects.NULLIFIED.get(), 100, 0));
        }
        if (id.contains("grav") || id.contains("rift") || id.contains("black_hole")) {
            living.push(0.0D, 0.55D, 0.0D);
        }
        if (id.contains("leech") || id.contains("vamp") || id.contains("blood")) {
            living.addEffect(new MobEffectInstance(ModEffects.BLOOD_TOXIN.get(), 120, 0));
            this.heal(1.5F);
        }
        if (id.contains("phase") || id.contains("spectre") || id.contains("ghost")) {
            living.addEffect(new MobEffectInstance(ModEffects.PHASED.get(), 120, 0));
        }
    }

    private void primeFuse() {
        if (this.fuseTicks < 0) {
            this.fuseTicks = 0;
        }
    }

    private void explode() {
        float radius = mobId().contains("nuclear") || mobId().contains("doomsday") ? 5.0F : isStormEntity() ? 3.0F : 2.5F;
        LostFx.burst(this.level(), this.blockPosition(), isStormEntity() ? "electric_explosion_blue" : "plasma_explosion", 32, radius * 0.35D, 0.08D);
        this.level().explode(this, this.getX(), this.getY(), this.getZ(), radius, Level.ExplosionInteraction.MOB);
        this.discard();
    }

    private Vec3 randomDrift() {
        return new Vec3((this.random.nextDouble() - 0.5D) * 0.18D, (this.random.nextDouble() - 0.35D) * 0.12D,
                (this.random.nextDouble() - 0.5D) * 0.18D);
    }

    private boolean isPassiveEntity() {
        String id = mobId();
        return id.contains("merchant") || id.contains("trader") || id.contains("operator") || id.contains("controller")
                || id.contains("contrader") || id.contains("hologram") || id.contains("market") || id.contains("puzzlemaster")
                || id.contains("statue") || id.contains("deco") || id.contains("supply") || id.contains("obstacle")
                || id.contains("screen") || id.contains("arenaevent");
    }

    private boolean isFlyingEntity() {
        String id = mobId();
        return id.contains("fly") || id.contains("flapper") || id.contains("flutter") || id.contains("wisp") || id.contains("phantom")
                || id.contains("spectre") || id.contains("ghost") || id.contains("orbiter") || id.contains("drone")
                || id.contains("sky") || id.contains("scorpwing") || id.contains("terrorfly") || id.contains("cthulhu_cloud");
    }

    private boolean isRangedEntity() {
        String id = mobId();
        return id.contains("wizard") || id.contains("caster") || id.contains("sentry") || id.contains("spite") || id.contains("spik")
                || id.contains("crystal") || id.contains("cannon") || id.contains("mortar") || id.contains("screach")
                || id.contains("scream") || id.contains("beam") || id.contains("turret") || id.contains("cthulhu")
                || id.contains("zenon") || id.contains("thundyron") || id.contains("cryonus") || id.contains("ozor");
    }

    private boolean isExplosiveEntity() {
        String id = mobId();
        return id.contains("bomb") || id.contains("explosion") || id.contains("explosive") || id.contains("tnt")
                || id.contains("nuclear") || id.contains("doomsday") || id.contains("rocket_strapped");
    }

    private boolean isTotemEntity() {
        String id = mobId();
        return id.contains("totem") || id.contains("pylon") || id.contains("idol") || id.contains("restorationcrystal")
                || id.contains("atlascrystal") || id.contains("sentrycrystal");
    }

    private boolean isHealerEntity() {
        String id = mobId();
        return id.contains("restoration") || id.contains("healing") || id.contains("idol") || id.contains("pylon")
                || id.contains("beacon") || id.contains("life") || id.contains("aura");
    }

    private boolean isSummonerEntity() {
        String id = mobId();
        return id.contains("cthulhu") || id.contains("mushmerra") || id.contains("weaver") || id.contains("puppermaster")
                || id.contains("staff") || id.contains("totemsplitter") || id.contains("tentaclelantern");
    }

    private boolean isSplitterEntity() {
        String id = mobId();
        return id.contains("gloop") || id.contains("slime") || id.contains("cluster") || id.contains("mushmerra_clone")
                || id.contains("glob") || id.contains("minimite");
    }

    private boolean isPackEntity() {
        String id = mobId();
        return id.contains("hound") || id.contains("dog") || id.contains("wolf") || id.contains("hunter") || id.contains("gnawer")
                || id.contains("snapper") || id.contains("chomper") || id.contains("grubber") || id.contains("terror");
    }

    private boolean isBurrowEntity() {
        String id = mobId();
        return id.contains("worm") || id.contains("slug") || id.contains("lurcher") || id.contains("crawker") || id.contains("rock")
                || id.contains("tentaclon") || id.contains("tetherbug");
    }

    private boolean isTrapEntity() {
        String id = mobId();
        return id.contains("trap") || id.contains("tether") || id.contains("clinger") || id.contains("grappler")
                || id.contains("hanger") || id.contains("brand") || id.contains("mark_of");
    }

    private boolean isStationaryEntity() {
        String id = mobId();
        return id.contains("obstacle") || id.contains("totem") || id.contains("pylon") || id.contains("crystal")
                || id.contains("cannon") || id.contains("turret") || id.contains("statue") || id.contains("rift")
                || id.contains("trap");
    }

    private boolean isDecoyEntity() {
        String id = mobId();
        return id.contains("decoy") || id.contains("ghostcopy") || id.contains("shimmer") || id.contains("phaser")
                || id.contains("illusion") || id.contains("mirror");
    }

    private boolean isEvasiveEntity() {
        String id = mobId();
        return id.contains("phase") || id.contains("spectre") || id.contains("ghost") || id.contains("shimmer")
                || id.contains("mirror") || id.contains("wisp") || id.contains("phantom");
    }

    private boolean isWebbingEntity() {
        String id = mobId();
        return id.contains("web") || id.contains("weaver") || id.contains("spider") || id.contains("clinger")
                || id.contains("tether") || id.contains("hanger") || id.contains("tentacle");
    }

    private boolean isAquaticEntity() {
        String id = mobId();
        return id.contains("crab") || id.contains("fish") || id.contains("shark") || id.contains("eel")
                || id.contains("octo") || id.contains("leviathan") || id.contains("sea") || id.contains("reef")
                || id.contains("bubble") || id.contains("water");
    }

    private boolean isLeaperEntity() {
        String id = mobId();
        return id.contains("hopper") || id.contains("jumper") || id.contains("chomper") || id.contains("snapper")
                || id.contains("rib") || id.contains("ravager") || id.contains("spider") || id.contains("crab");
    }

    private boolean isCollectorEntity() {
        String id = mobId();
        return id.contains("collector") || id.contains("merchant") || id.contains("market") || id.contains("contrader")
                || id.contains("pearlcollector");
    }

    private boolean isMountEntity() {
        String id = mobId();
        return id.contains("mount") || id.contains("horse") || id.contains("ravager") || id.contains("rib") || id.contains("crusher")
                || id.contains("ribrex");
    }

    private boolean isStoneEntity() {
        String id = mobId();
        return id.contains("rock") || id.contains("stone") || id.contains("crystal") || id.contains("crusher");
    }

    private boolean isBossEntity() {
        String id = mobId();
        return id.contains("boss") || id.contains("cthulhu") || id.contains("doomsday") || id.contains("andromeda")
                || id.contains("mushmerra") || id.contains("thundyron") || id.contains("cryonus");
    }

    private boolean isRecoveredBossEntity() {
        String id = mobId();
        return "cthulhu".equals(id) || "andromeda".equals(id) || "mushmerra".equals(id)
                || "thundyron".equals(id) || "cryonus".equals(id) || "ozor".equals(id)
                || "elara".equals(id) || "arash".equals(id) || "urogo".equals(id) || "velo".equals(id);
    }

    private int bossPhaseForHealth() {
        float healthRatio = this.getHealth() / Math.max(1.0F, this.getMaxHealth());
        if (healthRatio <= 0.3F) {
            return 3;
        }
        if (healthRatio <= 0.6F) {
            return 2;
        }
        return 1;
    }

    private String bossPhaseParticle() {
        String id = mobId();
        if ("cthulhu".equals(id)) return "blackhole_ring";
        if ("andromeda".equals(id)) return "gravity_ring";
        if ("mushmerra".equals(id)) return "plague";
        if ("thundyron".equals(id)) return "electric_explosion_blue";
        if ("cryonus".equals(id)) return "snowflake";
        if ("ozor".equals(id)) return "space_magic";
        if ("elara".equals(id)) return "portal_beam";
        if ("arash".equals(id) || "urogo".equals(id)) return "bad_magic";
        if ("velo".equals(id)) return "ancient_spell";
        return "bad_magic";
    }

    private String minionFamily(EntityType<? extends LostPlaceholderMob> type) {
        return type.builtInRegistryHolder().key().location().getPath().toLowerCase(Locale.ROOT).split("_")[0];
    }

    private static boolean isLostInfinityMob(LivingEntity entity) {
        return entity.getType().builtInRegistryHolder().key().location().getNamespace().equals(LostInfinity.MODID);
    }

    private boolean isHeavyEntity() {
        String id = mobId();
        return id.contains("giant") || id.contains("boss") || id.contains("cthulhu") || id.contains("crusher")
                || id.contains("ravager") || id.contains("doomsday") || id.contains("golem");
    }

    private boolean isStormEntity() {
        String id = mobId();
        return id.contains("storm") || id.contains("thunder") || id.contains("ion") || id.contains("tesla");
    }

    private float projectileDamage() {
        String id = mobId();
        if (id.contains("cthulhu") || id.contains("boss") || id.contains("doomsday")) return 10.0F;
        if (id.contains("cannon") || id.contains("mortar") || id.contains("turret")) return 8.0F;
        if (id.contains("wizard") || id.contains("cryonus") || id.contains("thundyron")) return 6.0F;
        return 5.0F;
    }

    private float projectileVelocity() {
        String id = mobId();
        if (id.contains("laser") || id.contains("beam") || id.contains("sentry")) return 1.45F;
        if (id.contains("mortar") || id.contains("cannon")) return 0.9F;
        return 1.1F;
    }

    private float projectilePitch() {
        String id = mobId();
        if (id.contains("scream") || id.contains("screach")) return 1.7F;
        if (id.contains("cthulhu") || id.contains("doom")) return 0.75F;
        return 1.1F;
    }

    private int rangedCooldown() {
        String id = mobId();
        if (id.contains("turret") || id.contains("sentry")) return 35;
        if (id.contains("cannon") || id.contains("mortar")) return 70;
        return 55;
    }

    private String mobFamily() {
        String id = mobId();
        if (id.contains("_")) {
            return id.substring(0, id.indexOf('_'));
        }
        for (String suffix : new String[] { "hunter", "dog", "wolf", "slug", "worm", "gloop", "glob", "terror" }) {
            if (id.contains(suffix)) {
                return suffix;
            }
        }
        return id.replace("giant", "").replace("super", "").replace("mutant", "");
    }

    private String mobId() {
        return this.getType().builtInRegistryHolder().key().location().getPath().toLowerCase(Locale.ROOT);
    }

    protected String recoveredLootId(String id) {
        return switch (id) {
            case "sea_serpent" -> "seaserpent";
            case "deviant_wolf" -> "deviantwolf";
            case "deviant_husk" -> "devianthusk";
            case "deviant_wither" -> "deviantwither";
            case "titanpiglin" -> "titanpigman";
            case "mushmerra_clone" -> "mushmerra";
            case "giant_rockslug" -> "rockslug";
            case "x_screacher" -> "screacher";
            case "galaxybeast" -> "galaxybeast_blue";
            case "galaxysorcerer" -> "galaxysorcerer_blue";
            case "galaxygladiator" -> "galaxygladiator_blue";
            case "tentacletrap" -> "tentaclon";
            default -> id;
        };
    }
}
