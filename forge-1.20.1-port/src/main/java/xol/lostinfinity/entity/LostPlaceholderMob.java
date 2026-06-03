package xol.lostinfinity.entity;

import java.util.Locale;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.PathfinderMob;
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
import xol.lostinfinity.registry.ModEffects;

public class LostPlaceholderMob extends PathfinderMob {
    private static final String FUSE_TAG = "LostFuse";
    private static final String SUMMONED_MINION_TAG = "SummonedMinion";
    private int specialCooldown;
    private int supportCooldown;
    private int ambushCooldown;
    private int fuseTicks = -1;
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
    }

    @Override
    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putInt(FUSE_TAG, this.fuseTicks);
        tag.putBoolean(SUMMONED_MINION_TAG, this.summonedMinion);
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
        this.level().playSound(null, this.blockPosition(), SoundEvents.GHAST_SHOOT, SoundSource.HOSTILE, 0.55F, projectilePitch());
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
        this.level().playSound(null, minion.blockPosition(), SoundEvents.EVOKER_CAST_SPELL, SoundSource.HOSTILE, 0.7F, 1.2F);
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
                || id.contains("statue") || id.contains("deco") || id.contains("supply");
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

    private boolean isStoneEntity() {
        String id = mobId();
        return id.contains("rock") || id.contains("stone") || id.contains("crystal") || id.contains("crusher");
    }

    private boolean isBossEntity() {
        String id = mobId();
        return id.contains("boss") || id.contains("cthulhu") || id.contains("doomsday") || id.contains("andromeda")
                || id.contains("mushmerra") || id.contains("thundyron") || id.contains("cryonus");
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
}
