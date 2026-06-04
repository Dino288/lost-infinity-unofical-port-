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
            impactBurst(blockPosition(), id);
        }
    }

    @Override
    protected void onHitBlock(BlockHitResult result) {
        super.onHitBlock(result);
        if (!level().isClientSide()) {
            impactBurst(result.getBlockPos(), projectileId());
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

    private void impactBurst(BlockPos pos, String id) {
        if (isExplosive(id)) {
            float radius = id.contains("micro") ? 1.3F : id.contains("meteor") || id.contains("mortar") || id.contains("cannon") ? 3.0F : 2.0F;
            LostFx.burst(level(), pos, burstParticle(id), 30, radius * 0.35D, 0.08D);
            level().explode(this, getX(), getY(), getZ(), radius, Level.ExplosionInteraction.MOB);
            return;
        }
        LostFx.burst(level(), pos, burstParticle(id), id.contains("laser") ? 10 : 18, 0.45D, 0.04D);
        level().playSound(null, pos, id.contains("laser") ? SoundEvents.GUARDIAN_ATTACK : SoundEvents.FIRECHARGE_USE,
                SoundSource.PLAYERS, 0.45F, 1.15F);
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
        if (id.contains("galaxy") || id.contains("cosmic") || id.contains("meteor")) return "cosmic_explosion_type1";
        if (id.contains("shadow") || id.contains("void") || id.contains("dark")) return "shadow_blast";
        if (id.contains("sonic") || id.contains("sound") || id.contains("echo")) return "supersonic_blue";
        if (id.contains("fire") || id.contains("plasma") || id.contains("exothermite")) return "plasma";
        return fallbackParticle(id);
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
