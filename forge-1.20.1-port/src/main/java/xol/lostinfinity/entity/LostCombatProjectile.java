package xol.lostinfinity.entity;

import java.util.Locale;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.Snowball;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import xol.lostinfinity.effect.LostFx;
import xol.lostinfinity.registry.ModEffects;

public class LostCombatProjectile extends Snowball {
    private final float damage;

    public LostCombatProjectile(Level level, LivingEntity owner, float damage) {
        super(level, owner);
        this.damage = damage;
    }

    @Override
    public void tick() {
        super.tick();
        if (!level().isClientSide() && tickCount % 2 == 0) {
            LostFx.trail(level(), this, trailParticle(projectileId()), 2);
        }
    }

    @Override
    protected void onHitEntity(EntityHitResult result) {
        super.onHitEntity(result);
        if (!level().isClientSide()) {
            Entity target = result.getEntity();
            String id = projectileId();
            target.hurt(damageSources().thrown(this, getOwner()), damageFor(id));
            if (target instanceof LivingEntity living) {
                applyHitEffects(living, id);
                if (id.contains("black_hole") || id.contains("gravity") || id.contains("sucker") || id.contains("grip")) {
                    LivingEntity owner = getOwner() instanceof LivingEntity livingOwner ? livingOwner : null;
                    if (owner != null) {
                        var pull = owner.position().subtract(living.position()).normalize().scale(0.75D);
                        living.push(pull.x, 0.2D, pull.z);
                    }
                }
            }
            areaEffect(id);
            impactBurst(blockPosition(), id);
        }
    }

    @Override
    protected void onHitBlock(BlockHitResult result) {
        super.onHitBlock(result);
        if (!level().isClientSide()) {
            String id = projectileId();
            areaEffect(id);
            impactBurst(result.getBlockPos(), id);
        }
    }

    private void applyHitEffects(LivingEntity living, String id) {
        if (id.contains("poison") || id.contains("venom") || id.contains("plague") || id.contains("blight") || id.contains("acid")) {
            living.addEffect(new MobEffectInstance(MobEffects.POISON, 140, id.contains("plague") ? 1 : 0));
        }
        if (id.contains("wither") || id.contains("void") || id.contains("shadow") || id.contains("dark")) {
            living.addEffect(new MobEffectInstance(MobEffects.WITHER, 120, 0));
        }
        if (id.contains("fire") || id.contains("flame") || id.contains("plasma") || id.contains("meteor") || id.contains("exothermite")) {
            living.setSecondsOnFire(id.contains("exothermite") ? 8 : 5);
        }
        if (id.contains("ice") || id.contains("cryo") || id.contains("stun") || id.contains("web") || id.contains("ink")
                || id.contains("bubble") || id.contains("whirlpool") || id.contains("fountain") || id.contains("water")) {
            living.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 120, id.contains("stun") ? 2 : 1));
        }
        if (id.contains("sonic") || id.contains("sound") || id.contains("echo")) {
            living.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 120, 0));
        }
        if (id.contains("tesla") || id.contains("zapper") || id.contains("shock") || id.contains("laser") || id.contains("selection")) {
            living.addEffect(new MobEffectInstance(ModEffects.NULLIFIED.get(), 100, 0));
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
        if (id.contains("magic") || id.contains("spell") || id.contains("wand")) {
            living.addEffect(new MobEffectInstance(ModEffects.POTION_AFFINITY.get(), 120, 0));
        }
        if (id.contains("forbidden") || id.contains("ultimate") || id.contains("doom")) {
            living.addEffect(new MobEffectInstance(ModEffects.DIMENSIONAL_TEAR.get(), 120, 0));
            living.addEffect(new MobEffectInstance(ModEffects.TERRIFIED.get(), 100, 0));
        }
    }

    private void areaEffect(String id) {
        double radius = areaRadius(id);
        if (radius <= 0.0D) {
            return;
        }
        var center = position();
        for (LivingEntity living : level().getEntitiesOfClass(LivingEntity.class, getBoundingBox().inflate(radius))) {
            if (!living.isAlive() || living == getOwner()) {
                continue;
            }
            applyHitEffects(living, id);
            if (id.contains("black_hole") || id.contains("gravity") || id.contains("wormhole") || id.contains("rift")) {
                var pull = center.subtract(living.position());
                if (pull.lengthSqr() > 0.001D) {
                    var motion = pull.normalize().scale(0.75D);
                    living.push(motion.x, 0.18D, motion.z);
                }
                living.addEffect(new MobEffectInstance(ModEffects.DIMENSIONAL_TEAR.get(), 100, 0));
            }
            if (id.contains("sonic") || id.contains("soundwave") || id.contains("pulse") || id.contains("echo")) {
                var away = living.position().subtract(center);
                if (away.lengthSqr() > 0.001D) {
                    var motion = away.normalize().scale(0.85D);
                    living.push(motion.x, 0.28D, motion.z);
                }
                living.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 120, 0));
            }
            if (id.contains("web") || id.contains("chain") || id.contains("tether") || id.contains("vine")) {
                living.addEffect(new MobEffectInstance(ModEffects.TETHERED.get(), 140, 0));
                living.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 120, 2));
            }
            if (id.contains("cryo") || id.contains("ice") || id.contains("frost")) {
                living.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 140, 2));
                living.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 120, 0));
            }
        }
        if (id.contains("black_hole") || id.contains("gravity") || id.contains("wormhole") || id.contains("rift")) {
            LostFx.burst(level(), blockPosition(), id.contains("black_hole") ? "blackhole_ring" : "wormhole_portal", 28, radius * 0.22D, 0.03D);
            LostFx.play(level(), blockPosition(), "rift_create", SoundSource.PLAYERS, 0.9F, 0.75F);
        } else if (id.contains("sonic") || id.contains("soundwave") || id.contains("pulse") || id.contains("echo")) {
            LostFx.burst(level(), blockPosition(), "supersonic_blue", 24, radius * 0.22D, 0.06D);
            LostFx.play(level(), blockPosition(), "sound_bounce", SoundSource.PLAYERS, 0.8F, 0.9F);
        } else if (id.contains("web") || id.contains("chain") || id.contains("tether") || id.contains("vine")) {
            LostFx.burst(level(), blockPosition(), id.contains("chain") ? "barul_chain" : "web_magic", 22, radius * 0.18D, 0.02D);
            LostFx.play(level(), blockPosition(), id.contains("chain") ? "darkbind" : "tetherbug_attack", SoundSource.PLAYERS, 0.75F, 1.0F);
        }
    }

    private double areaRadius(String id) {
        if (id.contains("black_hole") || id.contains("gravity") || id.contains("wormhole")) return 5.0D;
        if (id.contains("rift")) return 4.0D;
        if (id.contains("sonic") || id.contains("soundwave") || id.contains("pulse") || id.contains("echo")) return 4.0D;
        if (id.contains("web") || id.contains("chain") || id.contains("tether") || id.contains("vine")) return 3.5D;
        if (id.contains("cryo") || id.contains("ice") || id.contains("frost")) return 3.0D;
        if (id.contains("poison") || id.contains("venom") || id.contains("plague") || id.contains("blight")) return 3.0D;
        if (id.contains("murk") || id.contains("gloom") || id.contains("ink")) return 3.0D;
        return 0.0D;
    }

    private void impactBurst(BlockPos pos, String id) {
        if (isExplosive(id)) {
            float radius = id.contains("micro") ? 1.3F : id.contains("meteor") || id.contains("mortar") || id.contains("cannon") ? 3.0F : 2.0F;
            LostFx.burst(level(), pos, burstParticle(id), 30, radius * 0.35D, 0.08D);
            level().explode(this, getX(), getY(), getZ(), radius, Level.ExplosionInteraction.MOB);
            LostFx.play(level(), pos, explosionSound(id), SoundSource.PLAYERS, 1.0F, 0.9F);
            return;
        }
        LostFx.burst(level(), pos, burstParticle(id), id.contains("laser") ? 10 : 18, 0.45D, 0.04D);
        LostFx.play(level(), pos, impactSound(id), SoundSource.PLAYERS, 0.65F, 1.1F);
    }

    private float damageFor(String id) {
        float adjusted = damage;
        if (id.contains("laser") || id.contains("sniper") || id.contains("selection")) adjusted += 3.0F;
        if (id.contains("rocket") || id.contains("launcher") || id.contains("cannon") || id.contains("mortar")) adjusted += 4.0F;
        if (id.contains("ultimate") || id.contains("world_splitter") || id.contains("black_hole")) adjusted += 5.0F;
        if (id.contains("crystal") || id.contains("shard") || id.contains("knife")) adjusted += 2.0F;
        if (id.contains("forbidden") || id.contains("doom")) adjusted += 4.0F;
        return adjusted;
    }

    private boolean isExplosive(String id) {
        return id.contains("bomb") || id.contains("rocket") || id.contains("launcher") || id.contains("cannon")
                || id.contains("mortar") || id.contains("meteor") || id.contains("exothermite");
    }

    private String burstParticle(String id) {
        if (id.contains("acid")) return "acid";
        if (id.contains("cryo") || id.contains("ice") || id.contains("frost")) return "ice_blast";
        if (id.contains("web") || id.contains("chain") || id.contains("tether") || id.contains("vine")) return id.contains("chain") ? "barul_chain" : "web_magic";
        if (id.contains("venom") || id.contains("poison")) return "venom";
        if (id.contains("plague") || id.contains("blight")) return "plague";
        if (id.contains("water") || id.contains("whirlpool") || id.contains("fountain") || id.contains("bubble")) return "murk";
        if (id.contains("murk") || id.contains("eidolon") || id.contains("gloom") || id.contains("ink")) return "murky_mist";
        if (id.contains("puzzle") || id.contains("maze") || id.contains("labyrinth") || id.contains("recursor")) return "spectral";
        if (id.contains("solar") || id.contains("sunstone") || id.contains("celestial")) return "space_magic";
        if (id.contains("blood") || id.contains("vamp") || id.contains("leech")) return "blood_drop";
        if (id.contains("crystal") || id.contains("shard") || id.contains("fracture") || id.contains("gel")) return "small_spark";
        if (id.contains("magic") || id.contains("spell") || id.contains("wand") || id.contains("ancient")) return "ancient_spell";
        if (id.contains("bio") || id.contains("toxic") || id.contains("miasma")) return "miasma";
        if (id.contains("sky") || id.contains("air") || id.contains("wind")) return "supersonic_blue";
        if (id.contains("earth") || id.contains("rock") || id.contains("stone")) return "small_spark";
        if (id.contains("forbidden") || id.contains("ultimate") || id.contains("doom")) return "bad_magic";
        if (id.contains("laser")) return "laser_fizzle";
        if (id.contains("tesla") || id.contains("shock") || id.contains("zapper")) return "electric_explosion_blue";
        if (id.contains("black_hole") || id.contains("gravity")) return "blackhole_ring";
        if (id.contains("galaxy") || id.contains("cosmic") || id.contains("meteor")) return "cosmic_explosion_type1";
        if (id.contains("shadow") || id.contains("void") || id.contains("dark")) return "shadow_blast";
        if (id.contains("sonic") || id.contains("sound") || id.contains("echo")) return "supersonic_blue";
        if (id.contains("fire") || id.contains("plasma") || id.contains("exothermite")) return "plasma";
        return fallbackParticle(id);
    }

    private String trailParticle(String id) {
        if (id.contains("fire") || id.contains("flame") || id.contains("plasma") || id.contains("meteor") || id.contains("exothermite")) return "plasma";
        if (id.contains("cryo") || id.contains("ice") || id.contains("frost")) return "cryo_beam";
        if (id.contains("acid")) return "acid";
        if (id.contains("venom") || id.contains("poison") || id.contains("bubble")) return "venom";
        if (id.contains("plague") || id.contains("blight")) return "plague";
        if (id.contains("laser") || id.contains("beam")) return "laser_fizzle";
        if (id.contains("web") || id.contains("chain") || id.contains("tether") || id.contains("vine")) return id.contains("chain") ? "barul_chain" : "web_magic";
        if (id.contains("rift") || id.contains("wormhole") || id.contains("portal") || id.contains("warp")) return id.contains("wormhole") ? "wormhole_portal" : "warp";
        if (id.contains("water") || id.contains("whirlpool") || id.contains("fountain") || id.contains("bubble")) return "murk";
        if (id.contains("murk") || id.contains("eidolon") || id.contains("gloom") || id.contains("ink")) return "murky_mist";
        if (id.contains("tesla") || id.contains("shock") || id.contains("zapper") || id.contains("arc")) return "tesla_ring_blue";
        if (id.contains("sonic") || id.contains("sound") || id.contains("echo")) return "supersonic_blue";
        if (id.contains("solar") || id.contains("sunstone") || id.contains("celestial")) return "space_magic";
        if (id.contains("blood") || id.contains("vamp") || id.contains("leech")) return "blood_drop";
        if (id.contains("forbidden") || id.contains("ultimate") || id.contains("doom")) return "bad_magic";
        if (id.contains("dark") || id.contains("shadow") || id.contains("void")) return "shadow_blast";
        if (id.contains("gravity")) return "gravity_ring";
        if (id.contains("black_hole")) return "blackhole_portal";
        return burstParticle(id);
    }

    private String impactSound(String id) {
        if (id.contains("laser") || id.contains("beam")) return "laser_weapon_10";
        if (id.contains("sound") || id.contains("sonic") || id.contains("echo")) return "sound_bounce";
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
        ItemStack stack = getItem();
        if (!stack.isEmpty()) {
            return stack.getItem().builtInRegistryHolder().key().location().getPath().toLowerCase(Locale.ROOT);
        }
        return getType().builtInRegistryHolder().key().location().getPath().toLowerCase(Locale.ROOT);
    }
}
