package xol.lostinfinity.entity;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.network.NetworkHooks;
import xol.lostinfinity.registry.ModEffects;

public class LostPlaceholderProjectile extends Entity {
    private static final String AGE_TAG = "Age";
    private int age;

    public LostPlaceholderProjectile(EntityType<? extends LostPlaceholderProjectile> type, Level level) {
        super(type, level);
        this.noPhysics = false;
    }

    @Override
    protected void defineSynchedData() {
    }

    @Override
    protected void readAdditionalSaveData(CompoundTag tag) {
        this.age = tag.getInt(AGE_TAG);
    }

    @Override
    protected void addAdditionalSaveData(CompoundTag tag) {
        tag.putInt(AGE_TAG, this.age);
    }

    @Override
    public void tick() {
        super.tick();
        String id = projectileId();
        this.age++;
        int maxAge = id.contains("portal") || id.contains("rift") || id.contains("effect") ? 120 : 200;
        if (this.age > maxAge) {
            discard();
            return;
        }

        if (this.getDeltaMovement().lengthSqr() < 0.0001D) {
            this.setDeltaMovement(defaultVelocity(id));
        }
        if (shouldHome(id) && !this.level().isClientSide()) {
            homeTowardNearestTarget();
        }

        Vec3 start = this.position();
        Vec3 end = start.add(this.getDeltaMovement());
        HitResult hit = ProjectileUtil.getHitResultOnMoveVector(this, this::canHitEntity);
        if (hit.getType() != HitResult.Type.MISS) {
            end = hit.getLocation();
        }
        this.setPos(end.x, end.y, end.z);
        spawnTrail(id);

        if (hit.getType() == HitResult.Type.ENTITY) {
            onEntityImpact((EntityHitResult) hit, id);
        } else if (hit.getType() == HitResult.Type.BLOCK) {
            onBlockImpact((BlockHitResult) hit, id);
        }
    }

    @Override
    public boolean isPickable() {
        return true;
    }

    @Override
    public boolean hurt(net.minecraft.world.damagesource.DamageSource source, float amount) {
        if (!this.level().isClientSide()) {
            discard();
        }
        return true;
    }

    private boolean canHitEntity(Entity entity) {
        return entity.isAlive() && entity.isPickable() && entity != this.getVehicle();
    }

    private void onEntityImpact(EntityHitResult hit, String id) {
        if (this.level().isClientSide()) {
            return;
        }
        Entity target = hit.getEntity();
        float damage = damageFor(id);
        if (damage > 0.0F) {
            target.hurt(this.damageSources().magic(), damage);
        }
        if (target instanceof LivingEntity living) {
            applyEffects(living, id);
            if (id.contains("sucker") || id.contains("grip") || id.contains("chain") || id.contains("tether")) {
                Vec3 pull = this.position().subtract(living.position()).normalize().scale(0.8D);
                living.push(pull.x, 0.2D, pull.z);
            }
            if (id.contains("gravity") || id.contains("warp")) {
                living.push(0.0D, 0.9D, 0.0D);
            }
        }
        impactBurst(id);
        if (!isPiercing(id)) {
            discard();
        }
    }

    private void onBlockImpact(BlockHitResult hit, String id) {
        if (this.level().isClientSide()) {
            return;
        }
        impactBurst(id);
        if (id.contains("portal") || id.contains("rift") || id.contains("wormhole")) {
            this.level().playSound(null, hit.getBlockPos(), SoundEvents.ENDERMAN_TELEPORT, SoundSource.NEUTRAL, 1.0F, 0.7F);
        }
        discard();
    }

    private void impactBurst(String id) {
        if (id.contains("bomb") || id.contains("explosive") || id.contains("meteor") || id.contains("comet") || id.contains("asteroid")
                || id.contains("rocket") || id.contains("tnt") || id.contains("doom") || id.contains("plasma")) {
            float radius = id.contains("meteor") || id.contains("asteroid") || id.contains("doom") ? 3.5F : id.contains("micro") ? 1.5F : 2.5F;
            this.level().explode(this, this.getX(), this.getY(), this.getZ(), radius, Level.ExplosionInteraction.MOB);
        } else {
            this.level().playSound(null, this.blockPosition(), SoundEvents.GENERIC_SPLASH, SoundSource.NEUTRAL, 0.7F, 1.3F);
        }
        if (id.contains("sonic") || id.contains("soundwave") || id.contains("pulse")) {
            for (LivingEntity living : this.level().getEntitiesOfClass(LivingEntity.class, this.getBoundingBox().inflate(3.5D))) {
                living.hurt(this.damageSources().magic(), 4.0F);
                living.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 100, 0));
            }
        }
    }

    private void applyEffects(LivingEntity living, String id) {
        if (id.contains("poison") || id.contains("venom") || id.contains("plague") || id.contains("blight") || id.contains("acid")) {
            living.addEffect(new MobEffectInstance(MobEffects.POISON, 120, id.contains("plague") ? 1 : 0));
        }
        if (id.contains("wither") || id.contains("death") || id.contains("doom") || id.contains("dark") || id.contains("shadow")) {
            living.addEffect(new MobEffectInstance(MobEffects.WITHER, 120, 0));
        }
        if (id.contains("fire") || id.contains("ember") || id.contains("meteor") || id.contains("comet") || id.contains("exothermite")) {
            living.setSecondsOnFire(5);
        }
        if (id.contains("cryo") || id.contains("ice") || id.contains("stun") || id.contains("ink") || id.contains("gel")) {
            living.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 120, id.contains("stun") ? 2 : 1));
        }
        if (id.contains("stun") || id.contains("sonic") || id.contains("soundwave") || id.contains("shock") || id.contains("tesla")
                || id.contains("zapper") || id.contains("lightning") || id.contains("arc")) {
            living.addEffect(new MobEffectInstance(ModEffects.NULLIFIED.get(), 100, 0));
            living.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 100, 0));
        }
        if (id.contains("leviathan") || id.contains("whirlpool") || id.contains("water") || id.contains("fountain")) {
            living.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 100, 0));
        }
        if (id.contains("selector") || id.contains("selection") || id.contains("destabilizer") || id.contains("void")) {
            living.addEffect(new MobEffectInstance(ModEffects.NULLIFIED.get(), 160, 0));
        }
    }

    private float damageFor(String id) {
        float damage = 5.0F;
        if (id.contains("laser") || id.contains("beam")) damage += 3.0F;
        if (id.contains("knife") || id.contains("shard") || id.contains("spear") || id.contains("trident")) damage += 4.0F;
        if (id.contains("meteor") || id.contains("comet") || id.contains("asteroid") || id.contains("doom")) damage += 8.0F;
        if (id.contains("cthulhu") || id.contains("leviathan") || id.contains("galaxy") || id.contains("elementiumprime")) damage += 4.0F;
        if (id.contains("effect") || id.contains("portal") || id.contains("rift")) damage = 0.0F;
        return damage;
    }

    private boolean isPiercing(String id) {
        return id.contains("laser") || id.contains("beam") || id.contains("chain") || id.contains("slicer") || id.contains("piercing");
    }

    private boolean shouldHome(String id) {
        return id.contains("homing") || id.contains("chaser") || id.contains("tracer") || id.contains("sucker") || id.contains("debtcollector");
    }

    private Vec3 defaultVelocity(String id) {
        double speed = id.contains("laser") || id.contains("beam") ? 0.65D : id.contains("meteor") || id.contains("raindrop") ? 0.25D : 0.35D;
        if (id.contains("raindrop") || id.contains("meteor") || id.contains("falling")) {
            return new Vec3(0.0D, -speed, 0.0D);
        }
        return new Vec3(0.0D, 0.0D, speed);
    }

    private void homeTowardNearestTarget() {
        AABB area = this.getBoundingBox().inflate(12.0D);
        LivingEntity best = null;
        double bestDistance = Double.MAX_VALUE;
        for (LivingEntity living : this.level().getEntitiesOfClass(LivingEntity.class, area)) {
            if (!living.isAlive()) {
                continue;
            }
            double distance = this.distanceToSqr(living);
            if (distance < bestDistance) {
                bestDistance = distance;
                best = living;
            }
        }
        if (best != null) {
            Vec3 current = this.getDeltaMovement();
            Vec3 desired = best.getEyePosition().subtract(this.position()).normalize().scale(Math.max(0.25D, current.length()));
            this.setDeltaMovement(current.scale(0.86D).add(desired.scale(0.14D)));
        }
    }

    private void spawnTrail(String id) {
        if (!this.level().isClientSide()) {
            return;
        }
        if (id.contains("fire") || id.contains("ember") || id.contains("meteor")) {
            this.level().addParticle(net.minecraft.core.particles.ParticleTypes.FLAME, this.getX(), this.getY(), this.getZ(), 0.0D, 0.0D, 0.0D);
        } else if (id.contains("poison") || id.contains("acid") || id.contains("blight") || id.contains("plague")) {
            this.level().addParticle(net.minecraft.core.particles.ParticleTypes.WITCH, this.getX(), this.getY(), this.getZ(), 0.0D, 0.0D, 0.0D);
        } else if (id.contains("laser") || id.contains("beam") || id.contains("galaxy") || id.contains("void")) {
            this.level().addParticle(net.minecraft.core.particles.ParticleTypes.END_ROD, this.getX(), this.getY(), this.getZ(), 0.0D, 0.0D, 0.0D);
        }
    }

    private String projectileId() {
        return this.getType().builtInRegistryHolder().key().location().getPath();
    }

    @Override
    public Packet<ClientGamePacketListener> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }
}
