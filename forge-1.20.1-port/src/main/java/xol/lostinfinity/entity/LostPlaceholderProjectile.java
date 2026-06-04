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
import xol.lostinfinity.effect.LostFx;
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
            LostFx.play(this.level(), hit.getBlockPos(), "rift_create", SoundSource.NEUTRAL, 1.0F, 0.7F);
        }
        discard();
    }

    private void impactBurst(String id) {
        if (id.contains("bomb") || id.contains("explosive") || id.contains("meteor") || id.contains("comet") || id.contains("asteroid")
                || id.contains("rocket") || id.contains("tnt") || id.contains("doom") || id.contains("plasma")) {
            float radius = id.contains("meteor") || id.contains("asteroid") || id.contains("doom") ? 3.5F : id.contains("micro") ? 1.5F : 2.5F;
            LostFx.burst(this.level(), this.blockPosition(), burstParticle(id), 32, radius * 0.35D, 0.08D);
            LostFx.play(this.level(), this.blockPosition(), explosionSound(id), SoundSource.NEUTRAL, 1.1F, 0.85F + this.level().random.nextFloat() * 0.25F);
            this.level().explode(this, this.getX(), this.getY(), this.getZ(), radius, Level.ExplosionInteraction.MOB);
        } else {
            LostFx.burst(this.level(), this.blockPosition(), burstParticle(id), 18, 0.65D, 0.04D);
            LostFx.play(this.level(), this.blockPosition(), impactSound(id), SoundSource.NEUTRAL, 0.7F, 1.1F + this.level().random.nextFloat() * 0.25F);
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
        if (id.contains("cryo") || id.contains("ice") || id.contains("stun") || id.contains("ink") || id.contains("gel")
                || id.contains("bubble") || id.contains("whirlpool") || id.contains("fountain")) {
            living.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 120, id.contains("stun") ? 2 : 1));
        }
        if (id.contains("stun") || id.contains("sonic") || id.contains("soundwave") || id.contains("shock") || id.contains("tesla")
                || id.contains("zapper") || id.contains("lightning") || id.contains("arc")) {
            living.addEffect(new MobEffectInstance(ModEffects.NULLIFIED.get(), 100, 0));
            living.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 100, 0));
        }
        if (id.contains("leviathan") || id.contains("whirlpool") || id.contains("water") || id.contains("fountain")
                || id.contains("bubble") || id.contains("crabulon")) {
            living.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 100, 0));
        }
        if (id.contains("selector") || id.contains("selection") || id.contains("destabilizer") || id.contains("void")) {
            living.addEffect(new MobEffectInstance(ModEffects.NULLIFIED.get(), 160, 0));
        }
        if (id.contains("puzzle") || id.contains("maze") || id.contains("labyrinth") || id.contains("recursor")) {
            living.addEffect(new MobEffectInstance(ModEffects.NULLIFIED.get(), 120, 0));
            living.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 140, 0));
        }
        if (id.contains("solar") || id.contains("sunstone") || id.contains("celestial")) {
            living.setSecondsOnFire(6);
            living.addEffect(new MobEffectInstance(MobEffects.GLOWING, 120, 0));
        }
        if (id.contains("murk") || id.contains("eidolon") || id.contains("gloom") || id.contains("ink")) {
            living.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 90, 0));
        }
        if (id.contains("blood") || id.contains("vamp") || id.contains("leech")) {
            living.addEffect(new MobEffectInstance(ModEffects.BLOOD_TOXIN.get(), 140, 0));
        }
        if (id.contains("crystal") || id.contains("shard") || id.contains("fracture")) {
            living.addEffect(new MobEffectInstance(ModEffects.SHATTERED.get(), 120, 0));
        }
        if (id.contains("magic") || id.contains("spell") || id.contains("wizard") || id.contains("wand")) {
            living.addEffect(new MobEffectInstance(ModEffects.POTION_AFFINITY.get(), 120, 0));
        }
        if (id.contains("forbidden") || id.contains("ultimate") || id.contains("doom")) {
            living.addEffect(new MobEffectInstance(ModEffects.DIMENSIONAL_TEAR.get(), 120, 0));
            living.addEffect(new MobEffectInstance(ModEffects.TERRIFIED.get(), 100, 0));
        }
    }

    private float damageFor(String id) {
        float damage = 5.0F;
        if (id.contains("laser") || id.contains("beam")) damage += 3.0F;
        if (id.contains("knife") || id.contains("shard") || id.contains("spear") || id.contains("trident")) damage += 4.0F;
        if (id.contains("meteor") || id.contains("comet") || id.contains("asteroid") || id.contains("doom")) damage += 8.0F;
        if (id.contains("cthulhu") || id.contains("leviathan") || id.contains("galaxy") || id.contains("elementiumprime")) damage += 4.0F;
        if (id.contains("crystal") || id.contains("fracture")) damage += 2.0F;
        if (id.contains("forbidden") || id.contains("ultimate")) damage += 4.0F;
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
        if (this.level().isClientSide() || this.age % 2 != 0) {
            return;
        }
        LostFx.trail(this.level(), this, trailParticle(id), 2);
    }

    private String trailParticle(String id) {
        if (id.contains("fire") || id.contains("ember") || id.contains("meteor")) {
            return "plasma";
        }
        if (id.contains("poison") || id.contains("venom") || id.contains("bubble")) {
            return "venom";
        }
        if (id.contains("acid")) {
            return "acid";
        }
        if (id.contains("blight") || id.contains("plague")) {
            return "plague";
        }
        if (id.contains("laser") || id.contains("beam")) {
            return "laser_fizzle";
        }
        if (id.contains("galaxy") || id.contains("star") || id.contains("astral")) {
            return switch (Math.floorMod(this.tickCount, 4)) {
                case 0 -> "galaxy_blue";
                case 1 -> "galaxy_green";
                case 2 -> "galaxy_purple";
                default -> "galaxy_yellow";
            };
        }
        if (id.contains("portal") || id.contains("rift") || id.contains("wormhole") || id.contains("warp")) {
            return "warp";
        }
        if (id.contains("water") || id.contains("whirlpool") || id.contains("fountain") || id.contains("leviathan") || id.contains("crabulon")) {
            return "murk";
        }
        if (id.contains("shock") || id.contains("tesla") || id.contains("zapper") || id.contains("arc")) {
            return "zap";
        }
        if (id.contains("sound") || id.contains("sonic")) {
            return "supersonic_blue";
        }
        if (id.contains("murk") || id.contains("eidolon") || id.contains("gloom") || id.contains("ink")) {
            return "murky_mist";
        }
        if (id.contains("puzzle") || id.contains("maze") || id.contains("labyrinth") || id.contains("recursor")) {
            return "spectral";
        }
        if (id.contains("solar") || id.contains("sunstone") || id.contains("celestial")) {
            return "space_magic";
        }
        if (id.contains("blood") || id.contains("vamp") || id.contains("leech")) {
            return "blood_drop";
        }
        if (id.contains("crystal") || id.contains("shard") || id.contains("fracture") || id.contains("gel")) {
            return "small_spark";
        }
        if (id.contains("magic") || id.contains("spell") || id.contains("wizard") || id.contains("wand") || id.contains("ancient")) {
            return "ancient_spell";
        }
        if (id.contains("bio") || id.contains("toxic") || id.contains("miasma")) {
            return "miasma";
        }
        if (id.contains("sky") || id.contains("air") || id.contains("wind")) {
            return "supersonic_blue";
        }
        if (id.contains("earth") || id.contains("rock") || id.contains("stone")) {
            return "small_spark";
        }
        if (id.contains("forbidden") || id.contains("ultimate") || id.contains("doom")) {
            return "bad_magic";
        }
        if (id.contains("dark") || id.contains("shadow") || id.contains("void")) {
            return "shadow_blast";
        }
        if (id.contains("gravity")) {
            return "gravity_ring";
        }
        return fallbackParticle(id);
    }

    private String burstParticle(String id) {
        if (id.contains("plasma")) return "plasma_explosion";
        if (id.contains("murk") || id.contains("eidolon") || id.contains("ink") || id.contains("gloom")) return "murky_mist";
        if (id.contains("puzzle") || id.contains("maze") || id.contains("labyrinth") || id.contains("recursor")) return "spectral";
        if (id.contains("water") || id.contains("whirlpool") || id.contains("fountain") || id.contains("leviathan") || id.contains("crabulon")) return "murk";
        if (id.contains("solar") || id.contains("sunstone") || id.contains("celestial")) return "space_magic";
        if (id.contains("blood") || id.contains("vamp") || id.contains("leech")) return "blood_drop";
        if (id.contains("crystal") || id.contains("shard") || id.contains("fracture") || id.contains("gel")) return "small_spark";
        if (id.contains("magic") || id.contains("spell") || id.contains("wizard") || id.contains("wand") || id.contains("ancient")) return "ancient_spell";
        if (id.contains("bio") || id.contains("toxic") || id.contains("miasma")) return "miasma";
        if (id.contains("sky") || id.contains("air") || id.contains("wind")) return "supersonic_blue";
        if (id.contains("earth") || id.contains("rock") || id.contains("stone")) return "small_spark";
        if (id.contains("forbidden") || id.contains("ultimate") || id.contains("doom")) return "bad_magic";
        if (id.contains("cosmic") || id.contains("galaxy") || id.contains("star") || id.contains("meteor") || id.contains("asteroid")) return "cosmic_explosion_type1";
        if (id.contains("shock") || id.contains("tesla") || id.contains("arc")) return "electric_explosion_blue";
        if (id.contains("portal") || id.contains("rift") || id.contains("wormhole")) return "portal_beam";
        return trailParticle(id);
    }

    private String impactSound(String id) {
        if (id.contains("laser") || id.contains("beam")) return "laser_weapon_10";
        if (id.contains("sound") || id.contains("sonic")) return "sound_bounce";
        if (id.contains("shock") || id.contains("tesla") || id.contains("arc")) return "electric_bounce";
        if (id.contains("water") || id.contains("whirlpool") || id.contains("fountain") || id.contains("bubble")) return "water_drop";
        if (id.contains("murk") || id.contains("eidolon") || id.contains("gloom") || id.contains("ink")) return "goo_explode";
        if (id.contains("puzzle") || id.contains("maze") || id.contains("labyrinth") || id.contains("recursor")) return "generic_ui_5";
        if (id.contains("solar") || id.contains("sunstone") || id.contains("celestial")) return "magic_weapon_10";
        if (id.contains("portal") || id.contains("rift") || id.contains("wormhole")) return "rift_create";
        if (id.contains("acid") || id.contains("poison") || id.contains("venom") || id.contains("plague")) return "flask_explode";
        if (id.contains("blood") || id.contains("vamp") || id.contains("leech")) return "bioenergize";
        if (id.contains("crystal") || id.contains("shard") || id.contains("fracture") || id.contains("earth") || id.contains("rock") || id.contains("stone")) return "rock_tumble";
        if (id.contains("magic") || id.contains("spell") || id.contains("wizard") || id.contains("wand") || id.contains("ancient")) return "magic_weapon_11";
        if (id.contains("forbidden") || id.contains("ultimate") || id.contains("doom")) return "magic_weapon_5";
        if (id.contains("sky") || id.contains("air") || id.contains("wind")) return "sound_bounce";
        return "swing_hit";
    }

    private String explosionSound(String id) {
        if (id.contains("meteor") || id.contains("asteroid")) return "asteroid_impact";
        if (id.contains("missile") || id.contains("rocket")) return "missile_explosion";
        if (id.contains("cosmic") || id.contains("galaxy") || id.contains("plasma")) return "cosmic_explosion";
        return "deep_explosion";
    }

    private static String fallbackParticle(String id) {
        return switch (Math.floorMod(id.hashCode(), 8)) {
            case 0 -> "ancient_spell";
            case 1 -> "space_magic";
            case 2 -> "small_spark";
            case 3 -> "spectral";
            case 4 -> "miasma";
            case 5 -> "warp";
            case 6 -> "laser_fizzle";
            default -> "galaxy_purple";
        };
    }

    private String projectileId() {
        return this.getType().builtInRegistryHolder().key().location().getPath();
    }

    @Override
    public Packet<ClientGamePacketListener> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }
}
