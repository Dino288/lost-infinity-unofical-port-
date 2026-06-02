package xol.lostinfinity.effect;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.sounds.SoundSource;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import xol.lostinfinity.LostInfinity;
import xol.lostinfinity.registry.ModEffects;

@Mod.EventBusSubscriber(modid = LostInfinity.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public final class LostEffectEvents {
    private LostEffectEvents() {
    }

    @SubscribeEvent
    public static void onLivingTick(LivingEvent.LivingTickEvent event) {
        LivingEntity entity = event.getEntity();
        if (entity.level().isClientSide()) {
            return;
        }

        tickMovementEffects(entity);
        tickDamageEffects(entity);
        tickSpreadEffects(entity);
        tickUtilityEffects(entity);
    }

    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if (event.phase != TickEvent.Phase.END || event.player.level().isClientSide()) {
            return;
        }
        Player player = event.player;
        if (has(player, ModEffects.DIMENSIONAL_TEAR.get()) && player.tickCount % 30 == 0) {
            int level = Math.min(9, amplifier(player, ModEffects.DIMENSIONAL_TEAR.get()) + 1);
            player.removeEffect(ModEffects.DIMENSIONAL_TEAR.get());
            player.addEffect(new MobEffectInstance(ModEffects.DIMENSIONAL_TEAR.get(), 100, level, true, false));
            LostFx.trail(player.level(), player, "warp", 8);
            LostFx.play(player.level(), player.blockPosition(), "rift_create", SoundSource.PLAYERS, 0.45F, 0.8F + level * 0.05F);
        }
        if (has(player, ModEffects.SPECTRAL.get()) && player.tickCount % 10 == 0) {
            player.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 40, 0, true, false));
            LostFx.trail(player.level(), player, "spectral", 2);
        }
        if (has(player, ModEffects.TETHERED.get())) {
            player.setDeltaMovement(player.getDeltaMovement().multiply(0.45D, 0.55D, 0.45D));
        }
    }

    @SubscribeEvent
    public static void onLivingDamage(LivingDamageEvent event) {
        LivingEntity target = event.getEntity();
        LivingEntity attacker = event.getSource().getEntity() instanceof LivingEntity living ? living : null;
        float amount = event.getAmount();

        if (has(target, ModEffects.PROTECTED.get())) {
            amount *= 0.55F;
        }
        if (has(target, ModEffects.IRONHEART.get())) {
            amount = Math.min(amount, Math.max(4.0F, target.getMaxHealth() * 0.25F));
        }
        if (has(target, ModEffects.VULNERABILITY.get())) {
            amount *= 1.25F + amplifier(target, ModEffects.VULNERABILITY.get()) * 0.15F;
        }
        if (has(target, ModEffects.SHATTERED.get())) {
            amount *= 1.45F + amplifier(target, ModEffects.SHATTERED.get()) * 0.2F;
            target.removeEffect(ModEffects.SHATTERED.get());
        }
        if (has(target, ModEffects.OTHERWORLDLY.get()) && !isLostDamage(event.getSource())) {
            amount *= 0.35F;
        }
        if (has(target, ModEffects.POTION_AFFINITY.get())) {
            amount *= Math.max(0.35F, 1.0F - 0.08F * (amplifier(target, ModEffects.POTION_AFFINITY.get()) + 1));
        }
        if (has(target, ModEffects.PLANESPLIT.get())) {
            amount *= 1.0F + 0.18F * (amplifier(target, ModEffects.PLANESPLIT.get()) + 1);
        }
        if (has(target, ModEffects.SUPERCHARGED.get()) && target.getRandom().nextBoolean()) {
            amount *= 0.5F;
            burnSupercharge(target);
        }

        if (attacker != null) {
            if (has(attacker, ModEffects.ADRENALINE.get())) {
                amount *= 1.12F + 0.08F * (amplifier(attacker, ModEffects.ADRENALINE.get()) + 1);
            }
            if (has(attacker, ModEffects.RAMPAGING.get())) {
                amount *= 1.15F + 0.08F * (amplifier(attacker, ModEffects.RAMPAGING.get()) + 1);
            }
            if (has(attacker, ModEffects.BLIGHTED.get())) {
                target.addEffect(new MobEffectInstance(ModEffects.BLIGHTED.get(), 120, amplifier(attacker, ModEffects.BLIGHTED.get()), true, false));
            }
            if (has(attacker, ModEffects.ACIDIC.get())) {
                target.addEffect(new MobEffectInstance(MobEffects.POISON, 80, amplifier(attacker, ModEffects.ACIDIC.get()), true, false));
            }
            if (has(attacker, ModEffects.TRANSFUSION.get())) {
                attacker.heal(Math.min(6.0F, amount * (0.08F + 0.04F * (amplifier(attacker, ModEffects.TRANSFUSION.get()) + 1))));
            }
            if (has(attacker, ModEffects.FEARED.get()) && has(target, ModEffects.TERRIFIED.get()) && target.getRandom().nextBoolean()) {
                amount *= 1.75F;
            }
        }

        event.setAmount(amount);
    }

    @SubscribeEvent
    public static void onLivingDeath(LivingDeathEvent event) {
        LivingEntity attacker = event.getSource().getEntity() instanceof LivingEntity living ? living : null;
        if (attacker == null || attacker.level().isClientSide()) {
            return;
        }
        if (has(attacker, ModEffects.RAMPAGING.get())) {
            MobEffectInstance active = attacker.getEffect(ModEffects.RAMPAGING.get());
            int level = active == null ? 0 : Math.min(9, active.getAmplifier() + 1);
            int duration = active == null ? 160 : Math.min(1200, active.getDuration() + 100);
            attacker.addEffect(new MobEffectInstance(ModEffects.RAMPAGING.get(), duration, level, true, false));
        }
        if (has(attacker, ModEffects.SUPERCHARGED.get())) {
            attacker.addEffect(new MobEffectInstance(ModEffects.SUPERCHARGED.get(), 72000,
                    Math.min(9, amplifier(attacker, ModEffects.SUPERCHARGED.get()) + 1), true, false));
        }
    }

    @SubscribeEvent
    public static void onAttackEntity(AttackEntityEvent event) {
        if (!(event.getTarget() instanceof LivingEntity target)) {
            return;
        }
        Player player = event.getEntity();
        if (has(player, ModEffects.SUPERSONIC.get())) {
            target.knockback(1.2D + amplifier(player, ModEffects.SUPERSONIC.get()) * 0.35D, player.getX() - target.getX(), player.getZ() - target.getZ());
        }
        if (has(player, ModEffects.FRACTURE.get())) {
            target.addEffect(new MobEffectInstance(ModEffects.SHATTERED.get(), 120, amplifier(player, ModEffects.FRACTURE.get()), true, false));
        }
    }

    private static void tickMovementEffects(LivingEntity entity) {
        AttributeInstance speed = entity.getAttribute(Attributes.MOVEMENT_SPEED);
        if (speed == null) {
            return;
        }
        if (has(entity, ModEffects.NITROUS.get()) && entity.tickCount % 20 == 0) {
            entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 60, Math.min(4, amplifier(entity, ModEffects.NITROUS.get()) + 1), true, false));
        }
        if (has(entity, ModEffects.ADRENALINE.get()) && entity.tickCount % 20 == 0) {
            entity.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 60, Math.min(3, amplifier(entity, ModEffects.ADRENALINE.get())), true, false));
        }
        if (has(entity, ModEffects.GRAVITATIONAL.get())) {
            int level = amplifier(entity, ModEffects.GRAVITATIONAL.get());
            entity.setDeltaMovement(entity.getDeltaMovement().add(0.0D, 0.035D * (level + 1), 0.0D));
            entity.fallDistance = 0.0F;
        }
        if (has(entity, ModEffects.ULTRAHEAVY.get())) {
            entity.setDeltaMovement(entity.getDeltaMovement().multiply(0.72D, 0.55D, 0.72D));
        }
    }

    private static void tickDamageEffects(LivingEntity entity) {
        if (has(entity, ModEffects.PLAGUE.get()) && entity.tickCount % 40 == 0) {
            entity.hurt(entity.damageSources().magic(), 1.0F + amplifier(entity, ModEffects.PLAGUE.get()));
            LostFx.trail(entity.level(), entity, "plague", 6);
        }
        if (has(entity, ModEffects.BLOOD_TOXIN.get()) && entity.tickCount % 30 == 0) {
            entity.hurt(entity.damageSources().magic(), 1.0F + amplifier(entity, ModEffects.BLOOD_TOXIN.get()) * 0.5F);
            LostFx.trail(entity.level(), entity, "blood_drop", 4);
        }
        if (has(entity, ModEffects.LAST_BREATH.get()) && entity.tickCount % 10 == 0) {
            entity.hurt(entity.damageSources().magic(), 0.75F + amplifier(entity, ModEffects.LAST_BREATH.get()) * 0.75F);
            LostFx.trail(entity.level(), entity, "dark_magic", 2);
        }
        if (has(entity, ModEffects.SPONTANEOUS_COMBUSTION.get())) {
            entity.setSecondsOnFire(2 + amplifier(entity, ModEffects.SPONTANEOUS_COMBUSTION.get()));
            if (entity.tickCount % 20 == 0) {
                LostFx.burst(entity.level(), entity.blockPosition(), "plasma", 8, 0.35D, 0.04D);
                LostFx.play(entity.level(), entity.blockPosition(), "flask_explode", SoundSource.NEUTRAL, 0.35F, 1.2F);
            }
        }
        if (has(entity, ModEffects.BLIGHTED.get()) && entity.tickCount % 50 == 0) {
            entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 80, Math.min(2, amplifier(entity, ModEffects.BLIGHTED.get())), true, false));
            LostFx.trail(entity.level(), entity, "blight_spell_green", 4);
        }
    }

    private static void tickSpreadEffects(LivingEntity entity) {
        if (has(entity, ModEffects.CONTAGIOUS.get()) && has(entity, ModEffects.PLAGUE.get()) && entity.tickCount % 100 == 0) {
            int plagueLevel = Math.min(4, amplifier(entity, ModEffects.PLAGUE.get()) + 1);
            int duration = entity.getEffect(ModEffects.PLAGUE.get()).getDuration();
            entity.addEffect(new MobEffectInstance(ModEffects.PLAGUE.get(), duration, plagueLevel, true, false));
            for (LivingEntity nearby : entity.level().getEntitiesOfClass(LivingEntity.class, entity.getBoundingBox().inflate(4.0D))) {
                if (nearby != entity && !nearby.hasEffect(ModEffects.CONTAGIOUS.get())) {
                    nearby.addEffect(new MobEffectInstance(ModEffects.PLAGUE.get(), 160, Math.max(0, plagueLevel - 1), true, false));
                    nearby.addEffect(new MobEffectInstance(ModEffects.CONTAGIOUS.get(), 160, 0, true, false));
                }
            }
        }
        if (has(entity, ModEffects.MIASMA.get()) && entity.tickCount % 40 == 0) {
            int level = amplifier(entity, ModEffects.MIASMA.get());
            LostFx.burst(entity.level(), entity.blockPosition(), "miasma", 18, 1.5D + level, 0.03D);
            for (LivingEntity nearby : entity.level().getEntitiesOfClass(LivingEntity.class, entity.getBoundingBox().inflate(5.0D + level * 3.0D))) {
                if (nearby != entity) {
                    nearby.addEffect(new MobEffectInstance(ModEffects.PLAGUE.get(), 100, Math.max(0, level - 1), true, false));
                }
            }
        }
    }

    private static void tickUtilityEffects(LivingEntity entity) {
        if (has(entity, ModEffects.RACING_HEART.get()) && entity.tickCount % 20 == 0) {
            int duration = entity.getEffect(ModEffects.RACING_HEART.get()).getDuration();
            entity.addEffect(new MobEffectInstance(ModEffects.ADRENALINE.get(), Math.min(200, duration), 0, true, false));
        }
        if (has(entity, ModEffects.UNLEASHING.get()) && entity.tickCount % 40 == 0) {
            MobEffectInstance active = entity.getEffect(ModEffects.UNLEASHING.get());
            if (active != null && active.getDuration() > 45) {
                entity.addEffect(new MobEffectInstance(ModEffects.UNLEASHING.get(), active.getDuration(), Math.min(9, active.getAmplifier() + 1), true, false));
                LostFx.trail(entity.level(), entity, "space_magic", 4);
            }
        }
        if (has(entity, ModEffects.INTANGIBLE.get())) {
            ItemStack offhand = entity.getOffhandItem();
            if (!offhand.isEmpty() && entity.tickCount % 20 == 0) {
                offhand.hurtAndBreak(1, entity, living -> {
                });
            }
        }
        if (has(entity, ModEffects.TERRIFIED.get()) && entity instanceof Mob mob && entity.tickCount % 20 == 0) {
            for (LivingEntity nearby : entity.level().getEntitiesOfClass(LivingEntity.class, entity.getBoundingBox().inflate(6.0D))) {
                if (nearby.hasEffect(ModEffects.FEARED.get())) {
                    mob.setTarget(null);
                    break;
                }
            }
        }
    }

    private static boolean has(LivingEntity entity, MobEffect effect) {
        return entity.hasEffect(effect);
    }

    private static int amplifier(LivingEntity entity, MobEffect effect) {
        MobEffectInstance instance = entity.getEffect(effect);
        return instance == null ? 0 : instance.getAmplifier();
    }

    private static boolean isLostDamage(DamageSource source) {
        String id = source.getMsgId().toLowerCase();
        return id.contains("lost") || id.contains("darkborn") || id.contains("void");
    }

    private static void burnSupercharge(LivingEntity entity) {
        MobEffectInstance active = entity.getEffect(ModEffects.SUPERCHARGED.get());
        if (active == null) {
            return;
        }
        LostFx.burst(entity.level(), entity.blockPosition(), "electric_explosion_blue", 12, 0.45D, 0.05D);
        LostFx.play(entity.level(), entity.blockPosition(), "charging_power", SoundSource.NEUTRAL, 0.45F, 1.3F);
        int level = active.getAmplifier();
        entity.removeEffect(ModEffects.SUPERCHARGED.get());
        if (level > 0) {
            entity.addEffect(new MobEffectInstance(ModEffects.SUPERCHARGED.get(), active.getDuration(), level - 1, true, false));
        }
    }
}
