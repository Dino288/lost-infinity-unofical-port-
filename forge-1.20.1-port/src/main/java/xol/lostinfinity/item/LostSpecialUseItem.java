package xol.lostinfinity.item;

import java.util.List;
import java.util.Locale;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;
import xol.lostinfinity.entity.LostCombatProjectile;
import xol.lostinfinity.effect.LostFx;
import xol.lostinfinity.registry.ModEffects;

public class LostSpecialUseItem extends Item {
    private final String itemName;

    public LostSpecialUseItem(String itemName, Properties properties) {
        super(properties);
        this.itemName = itemName.toLowerCase(Locale.ROOT);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);
        if (level.isClientSide()) {
            return InteractionResultHolder.sidedSuccess(stack, true);
        }
        if (LostItemBehavior.useModeEnergyItem(itemName, stack, level, player, hand)) {
            return InteractionResultHolder.success(stack);
        }

        if (isCureItem()) {
            clearBadEffects(player);
            player.heal(itemName.contains("guardian") ? 8.0F : 4.0F);
            LostFx.play(level, player.blockPosition(), "bioenergize", SoundSource.PLAYERS, 0.7F, 1.15F);
            LostFx.burst(level, player.blockPosition(), "miasma", 16, 0.55D, 0.03D);
            consumeOrDamage(player, stack, hand, true);
            player.getCooldowns().addCooldown(this, 80);
            return InteractionResultHolder.success(stack);
        }
        if (isInjection()) {
            applyInjection(player);
            LostFx.play(level, player.blockPosition(), "syringe_use", SoundSource.PLAYERS, 0.75F, 1.0F);
            LostFx.burst(level, player.blockPosition(), "blood_drop", 10, 0.35D, 0.02D);
            consumeOrDamage(player, stack, hand, true);
            player.getCooldowns().addCooldown(this, 200);
            return InteractionResultHolder.success(stack);
        }
        if (itemName.contains("cloaking_device") || itemName.contains("ring_of_illusions")) {
            player.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 400, 0, true, false));
            player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 200, 0, true, false));
            LostFx.play(level, player.blockPosition(), "rapid_teleport", SoundSource.PLAYERS, 0.45F, 1.35F);
            LostFx.burst(level, player.blockPosition(), "spectral", 18, 0.65D, 0.03D);
            player.getCooldowns().addCooldown(this, 240);
            consumeOrDamage(player, stack, hand, false);
            return InteractionResultHolder.success(stack);
        }
        if (itemName.contains("rift_walker") || itemName.contains("starlit_globe")) {
            blink(level, player, itemName.contains("starlit") ? 48.0D : 24.0D);
            player.getCooldowns().addCooldown(this, 120);
            consumeOrDamage(player, stack, hand, false);
            return InteractionResultHolder.success(stack);
        }
        if (itemName.contains("hot_pod") || itemName.contains("extremely_hot_pod")) {
            fireBurst(level, player, itemName.contains("extremely") ? 7.0D : 4.5D);
            LostFx.play(level, player.blockPosition(), "magic_weapon_4", SoundSource.PLAYERS, 0.8F, 0.85F);
            consumeOrDamage(player, stack, hand, true);
            player.getCooldowns().addCooldown(this, 100);
            return InteractionResultHolder.success(stack);
        }
        if (itemName.contains("blight") || itemName.contains("bio") || itemName.contains("plague")) {
            effectBurst(level, player, MobEffects.POISON, itemName.contains("cure") ? MobEffects.REGENERATION : MobEffects.POISON);
            consumeOrDamage(player, stack, hand, itemName.contains("powder") || itemName.contains("flask"));
            player.getCooldowns().addCooldown(this, 120);
            return InteractionResultHolder.success(stack);
        }
        if (itemName.contains("power_pulse") || itemName.contains("pulse_charge") || itemName.contains("element_stone")) {
            effectBurst(level, player, MobEffects.MOVEMENT_SLOWDOWN, MobEffects.DAMAGE_BOOST);
            LostFx.play(level, player.blockPosition(), itemName.contains("pulse") ? "sound_gun" : "magic_weapon_5", SoundSource.PLAYERS, 0.65F, 1.1F);
            player.getCooldowns().addCooldown(this, 160);
            consumeOrDamage(player, stack, hand, false);
            return InteractionResultHolder.success(stack);
        }
        if (itemName.contains("mystery_box") || itemName.contains("box_of_life")) {
            dropReward(level, player, itemName.contains("life"));
            consumeOrDamage(player, stack, hand, true);
            player.getCooldowns().addCooldown(this, 40);
            return InteractionResultHolder.success(stack);
        }
        if (itemName.contains("analyzer") || itemName.contains("correlator") || itemName.contains("compass")) {
            analyze(level, player);
            LostFx.play(level, player.blockPosition(), "scanner", SoundSource.PLAYERS, 0.6F, 1.0F);
            LostFx.burst(level, player.blockPosition(), "small_spark", 8, 0.35D, 0.02D);
            player.getCooldowns().addCooldown(this, 40);
            return InteractionResultHolder.success(stack);
        }
        if (itemName.contains("sextant") || itemName.startsWith("map_") || itemName.endsWith("_map")
                || itemName.contains("monitor") || itemName.contains("hypercron")) {
            navigationPulse(level, player);
            consumeOrDamage(player, stack, hand, false);
            player.getCooldowns().addCooldown(this, 80);
            return InteractionResultHolder.success(stack);
        }
        if (itemName.contains("relocator") || itemName.contains("geolocation") || itemName.contains("geocoordinated")) {
            relocatePulse(level, player);
            consumeOrDamage(player, stack, hand, false);
            player.getCooldowns().addCooldown(this, 120);
            return InteractionResultHolder.success(stack);
        }
        if (itemName.contains("_token") || itemName.endsWith("card") || itemName.contains("_key")
                || itemName.contains("override_device")) {
            progressionPulse(level, player);
            consumeOrDamage(player, stack, hand, false);
            player.getCooldowns().addCooldown(this, 100);
            return InteractionResultHolder.success(stack);
        }
        if (itemName.contains("attractor") || itemName.contains("vacuum") || itemName.contains("magnet") || itemName.contains("tether")) {
            attract(level, player);
            consumeOrDamage(player, stack, hand, false);
            player.getCooldowns().addCooldown(this, 80);
            return InteractionResultHolder.success(stack);
        }
        if (itemName.contains("shield") || itemName.contains("forcefield") || itemName.contains("pylon_protector")
                || itemName.contains("beacon_of_light")) {
            defensivePulse(level, player);
            consumeOrDamage(player, stack, hand, false);
            player.getCooldowns().addCooldown(this, 180);
            return InteractionResultHolder.success(stack);
        }
        if (itemName.contains("summon") || itemName.contains("staff_of_servitude") || itemName.contains("tentacle_remote")
                || itemName.contains("luminousguardian") || itemName.contains("starsoldier") || itemName.contains("skycrabcontroller")) {
            summonHelper(level, player);
            consumeOrDamage(player, stack, hand, false);
            player.getCooldowns().addCooldown(this, 240);
            return InteractionResultHolder.success(stack);
        }
        if (itemName.contains("rain") || itemName.contains("storm") || itemName.contains("thunder") || itemName.contains("moonshaker")
                || itemName.contains("time_trigger")) {
            weatherOrTime(level, player);
            consumeOrDamage(player, stack, hand, false);
            player.getCooldowns().addCooldown(this, 300);
            return InteractionResultHolder.success(stack);
        }
        if (itemName.contains("reconstruction") || itemName.contains("repair") || itemName.contains("resurgence")
                || itemName.contains("rebirth") || itemName.contains("life_vessel")) {
            repairAndRestore(player);
            consumeOrDamage(player, stack, hand, itemName.contains("scroll"));
            player.getCooldowns().addCooldown(this, 180);
            return InteractionResultHolder.success(stack);
        }
        if (itemName.contains("augment_slide")) {
            augmentPulse(level, player);
            consumeOrDamage(player, stack, hand, false);
            player.getCooldowns().addCooldown(this, 140);
            return InteractionResultHolder.success(stack);
        }
        if (itemName.contains("storage_chip") || itemName.contains("data_chip") || itemName.contains("synchronizer")
                || itemName.contains("optical_disc") || itemName.endsWith("_disc")) {
            dataPulse(level, player);
            consumeOrDamage(player, stack, hand, false);
            player.getCooldowns().addCooldown(this, 90);
            return InteractionResultHolder.success(stack);
        }
        if (itemName.contains("battery") || itemName.contains("cell") || itemName.contains("capacitor")
                || itemName.contains("generator") || itemName.contains("crystal") || itemName.contains("orb")
                || itemName.contains("heart") || itemName.contains("seed") || itemName.contains("sap")
                || itemName.contains("container") || itemName.contains("totem") || itemName.contains("idol")
                || itemName.contains("relic") || itemName.contains("controller") || itemName.contains("constructor")
                || itemName.contains("remote")) {
            resourcePulse(level, player);
            consumeOrDamage(player, stack, hand, false);
            player.getCooldowns().addCooldown(this, 120);
            return InteractionResultHolder.success(stack);
        }
        if (itemName.contains("solution") || itemName.contains("powder") || itemName.contains("sample")
                || itemName.contains("vial") || itemName.contains("concoction") || itemName.contains("toxin")
                || itemName.contains("blood") || itemName.contains("ooze") || itemName.contains("gel")
                || itemName.contains("syrup") || itemName.contains("pouch") || itemName.contains("acid")
                || itemName.contains("tissue") || itemName.contains("fibre") || itemName.contains("monomer")
                || itemName.contains("dust")) {
            chemistryPulse(level, player);
            consumeOrDamage(player, stack, hand, itemName.contains("solution") || itemName.contains("vial")
                    || itemName.contains("concoction") || itemName.contains("powder") || itemName.contains("sample"));
            player.getCooldowns().addCooldown(this, 100);
            return InteractionResultHolder.success(stack);
        }
        if (itemName.contains("bomb") || itemName.contains("charge") || itemName.contains("quark") || itemName.contains("gluon")
                || itemName.contains("exothermite") || itemName.contains("emitter")) {
            shootUtilityProjectile(level, player, stack);
            consumeOrDamage(player, stack, hand, !stack.isDamageableItem());
            player.getCooldowns().addCooldown(this, itemName.contains("bomb") ? 35 : 18);
            return InteractionResultHolder.success(stack);
        }

        recoveredArtifactPulse(level, player);
        consumeOrDamage(player, stack, hand, false);
        player.getCooldowns().addCooldown(this, 100);
        return InteractionResultHolder.success(stack);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag flag) {
        tooltip.add(Component.literal("Recovered special item: first-pass 1.20.1 behavior restored.").withStyle(ChatFormatting.DARK_AQUA));
        LostItemBehavior.appendModeEnergyTooltip(itemName, stack, tooltip);
    }

    private boolean isCureItem() {
        return itemName.contains("cure") || itemName.contains("elixir") || itemName.contains("brew") || itemName.contains("drink");
    }

    private boolean isInjection() {
        return itemName.contains("injection") || itemName.contains("nitrous_bottle") || itemName.contains("energetic_heart");
    }

    private void applyInjection(Player player) {
        if (itemName.contains("rampage")) {
            player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 500, 2));
            player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 500, 1));
            player.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 180, 0));
        } else if (itemName.contains("super")) {
            player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 600, 1));
            player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 600, 1));
            player.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 600, 1));
        } else {
            player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 300, 1));
            player.addEffect(new MobEffectInstance(MobEffects.JUMP, 300, 1));
        }
    }

    private static void clearBadEffects(Player player) {
        player.removeEffect(MobEffects.POISON);
        player.removeEffect(MobEffects.WITHER);
        player.removeEffect(MobEffects.CONFUSION);
        player.removeEffect(MobEffects.WEAKNESS);
        player.removeEffect(MobEffects.MOVEMENT_SLOWDOWN);
        player.removeEffect(ModEffects.NULLIFIED.get());
    }

    private static void blink(Level level, Player player, double range) {
        Vec3 eye = player.getEyePosition();
        Vec3 look = player.getLookAngle();
        BlockHitResult hit = level.clip(new ClipContext(eye, eye.add(look.scale(range)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, player));
        Vec3 target = hit.getType() == HitResult.Type.BLOCK ? hit.getLocation().subtract(look.scale(1.5D)) : eye.add(look.scale(range));
        LostFx.burst(level, player.blockPosition(), "warp", 18, 0.55D, 0.04D);
        player.teleportTo(target.x, target.y, target.z);
        LostFx.burst(level, player.blockPosition(), "warp", 24, 0.65D, 0.04D);
        LostFx.play(level, player.blockPosition(), "rapid_teleport", SoundSource.PLAYERS, 0.75F, 1.25F);
    }

    private static void fireBurst(Level level, Player player, double radius) {
        LostFx.burst(level, player.blockPosition(), "plasma_explosion", 26, 0.9D, 0.06D);
        for (LivingEntity entity : level.getEntitiesOfClass(LivingEntity.class, player.getBoundingBox().inflate(radius), entity -> entity != player)) {
            entity.setSecondsOnFire((int) radius);
            entity.hurt(level.damageSources().playerAttack(player), (float) radius);
        }
    }

    private void effectBurst(Level level, Player player, MobEffect targetEffect, MobEffect selfEffect) {
        LostFx.play(level, player.blockPosition(), targetEffect == MobEffects.POISON ? "flask_explode" : "magic_weapon_10", SoundSource.PLAYERS, 0.55F, 1.25F);
        LostFx.burst(level, player.blockPosition(), targetEffect == MobEffects.POISON ? "plague" : "supersonic_blue", 24, 0.9D, 0.04D);
        for (LivingEntity entity : level.getEntitiesOfClass(LivingEntity.class, player.getBoundingBox().inflate(6.0D), entity -> entity != player)) {
            entity.addEffect(new MobEffectInstance(targetEffect, 220, itemName.contains("ultra") ? 2 : 0));
            if (targetEffect == MobEffects.POISON) {
                entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 160, 0));
            }
        }
        player.addEffect(new MobEffectInstance(selfEffect, 180, 0, true, false));
    }

    private static void dropReward(Level level, Player player, boolean strong) {
        ItemStack reward = new ItemStack(strong ? net.minecraft.world.item.Items.GOLDEN_APPLE : net.minecraft.world.item.Items.EMERALD);
        ItemEntity item = new ItemEntity(level, player.getX(), player.getY() + 0.5D, player.getZ(), reward);
        level.addFreshEntity(item);
        LostFx.play(level, player.blockPosition(), "special_craft", SoundSource.PLAYERS, 0.7F, 1.2F);
        LostFx.burst(level, player.blockPosition(), "golden_magic", 18, 0.5D, 0.03D);
    }

    private void analyze(Level level, Player player) {
        String dimension = level.dimension().location().toString();
        long day = level.getDayTime() / 24000L;
        player.displayClientMessage(Component.literal("Dimension: " + dimension + " | Day: " + day), false);
        if (level instanceof ServerLevel serverLevel) {
            player.displayClientMessage(Component.literal("Nearby entities: "
                    + serverLevel.getEntities(player, new AABB(player.blockPosition()).inflate(24.0D)).size()), false);
        }
    }

    private void attract(Level level, Player player) {
        boolean pushAway = itemName.contains("repuls") || itemName.contains("shockwave");
        double radius = itemName.contains("vacuum") ? 14.0D : 9.0D;
        for (Entity entity : level.getEntities(player, player.getBoundingBox().inflate(radius), entity -> entity.isAlive())) {
            Vec3 delta = player.position().subtract(entity.position());
            if (delta.lengthSqr() < 0.01D) {
                continue;
            }
            Vec3 motion = delta.normalize().scale(pushAway ? -0.75D : 0.65D);
            entity.push(motion.x, pushAway ? 0.25D : 0.1D, motion.z);
            if (entity instanceof ItemEntity itemEntity) {
                itemEntity.setPickUpDelay(0);
            }
        }
        LostFx.burst(level, player.blockPosition(), pushAway ? "electric_explosion_blue" : "gravity_ring", 24, 1.1D, 0.05D);
        LostFx.play(level, player.blockPosition(), pushAway ? "electric_bounce" : "magic_weapon_3", SoundSource.PLAYERS, 0.65F, 1.2F);
    }

    private void defensivePulse(Level level, Player player) {
        player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 260, itemName.contains("quantum") ? 2 : 1, true, false));
        player.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 260, 1, true, false));
        for (LivingEntity entity : level.getEntitiesOfClass(LivingEntity.class, player.getBoundingBox().inflate(5.0D), entity -> entity != player)) {
            entity.addEffect(new MobEffectInstance(ModEffects.NULLIFIED.get(), 100, 0));
            Vec3 push = entity.position().subtract(player.position()).normalize().scale(0.7D);
            entity.push(push.x, 0.25D, push.z);
        }
        LostFx.burst(level, player.blockPosition(), "portal_beam", 26, 0.9D, 0.04D);
        LostFx.play(level, player.blockPosition(), "shield_block", SoundSource.PLAYERS, 0.8F, 0.9F);
    }

    private void summonHelper(Level level, Player player) {
        EntityType<?> type = itemName.contains("skycrab") ? EntityType.PHANTOM
                : itemName.contains("tentacle") ? EntityType.SQUID
                : itemName.contains("guardian") ? EntityType.IRON_GOLEM
                : EntityType.WOLF;
        Entity entity = type.create(level);
        if (entity == null) {
            return;
        }
        Vec3 pos = player.position().add(player.getLookAngle().scale(2.0D));
        entity.moveTo(pos.x, pos.y, pos.z, player.getYRot(), 0.0F);
        if (entity instanceof LivingEntity living) {
            living.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 600, 0, true, false));
            living.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 600, 0, true, false));
        }
        level.addFreshEntity(entity);
        LostFx.burst(level, entity.blockPosition(), "ancient_spell", 24, 0.7D, 0.04D);
        LostFx.play(level, entity.blockPosition(), "magic_weapon_13", SoundSource.PLAYERS, 0.8F, 1.1F);
    }

    private void weatherOrTime(Level level, Player player) {
        if (level instanceof ServerLevel serverLevel) {
            if (itemName.contains("rain")) {
                serverLevel.setWeatherParameters(0, 6000, true, false);
            } else if (itemName.contains("storm") || itemName.contains("thunder")) {
                serverLevel.setWeatherParameters(0, 6000, true, true);
                for (LivingEntity entity : level.getEntitiesOfClass(LivingEntity.class, player.getBoundingBox().inflate(10.0D), entity -> entity != player)) {
                    entity.hurt(level.damageSources().lightningBolt(), 5.0F);
                    entity.addEffect(new MobEffectInstance(ModEffects.NULLIFIED.get(), 120, 0));
                }
            } else {
                serverLevel.setDayTime((serverLevel.getDayTime() + 12000L) % 24000L);
            }
        }
        LostFx.burst(level, player.blockPosition(), itemName.contains("storm") || itemName.contains("thunder") ? "electric_explosion_blue" : "space_magic",
                32, 1.3D, 0.05D);
        LostFx.play(level, player.blockPosition(), itemName.contains("rain") ? "rainfall_generator" : "magic_weapon_12", SoundSource.PLAYERS, 0.8F, 0.7F);
    }

    private void repairAndRestore(Player player) {
        int repaired = 0;
        for (ItemStack carried : player.getInventory().items) {
            if (carried.isDamageableItem() && carried.getDamageValue() > 0) {
                carried.setDamageValue(Math.max(0, carried.getDamageValue() - 80));
                repaired++;
                if (repaired >= 4) {
                    break;
                }
            }
        }
        player.heal(itemName.contains("life") || itemName.contains("rebirth") ? 10.0F : 4.0F);
        player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 160, 1, true, false));
        LostFx.play(player.level(), player.blockPosition(), "special_craft", SoundSource.PLAYERS, 0.55F, 1.4F);
        LostFx.burst(player.level(), player.blockPosition(), "murky_mist", 18, 0.65D, 0.04D);
    }

    private void augmentPulse(Level level, Player player) {
        if (itemName.contains("heal") || itemName.contains("regenerative")) {
            player.heal(5.0F);
            player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 160, 1, true, false));
        } else if (itemName.contains("dash") || itemName.contains("slide")) {
            Vec3 dash = player.getLookAngle().normalize().scale(1.8D);
            player.push(dash.x, 0.15D, dash.z);
            player.hurtMarked = true;
            player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 120, 1, true, false));
        } else if (itemName.contains("teleport")) {
            blink(level, player, 18.0D);
        } else if (itemName.contains("invisibility")) {
            player.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 240, 0, true, false));
        } else if (itemName.contains("gravity")) {
            attract(level, player);
            return;
        } else if (itemName.contains("forcefield")) {
            defensivePulse(level, player);
            return;
        } else if (itemName.contains("summon")) {
            summonHelper(level, player);
            return;
        } else {
            MobEffect effect = itemName.contains("blight") || itemName.contains("plague") ? MobEffects.POISON
                    : itemName.contains("emp") ? ModEffects.NULLIFIED.get()
                    : itemName.contains("nightmare") ? ModEffects.TERRIFIED.get()
                    : itemName.contains("destructive") || itemName.contains("shatter") || itemName.contains("slam")
                    ? MobEffects.MOVEMENT_SLOWDOWN : MobEffects.WEAKNESS;
            for (LivingEntity entity : level.getEntitiesOfClass(LivingEntity.class, player.getBoundingBox().inflate(5.5D), entity -> entity != player)) {
                entity.addEffect(new MobEffectInstance(effect, 140, itemName.contains("emp") || itemName.contains("plague") ? 1 : 0));
                if (itemName.contains("hurt") || itemName.contains("destructive") || itemName.contains("shatter")) {
                    entity.hurt(level.damageSources().playerAttack(player), 4.0F);
                }
            }
        }
        LostFx.play(level, player.blockPosition(), augmentSound(), SoundSource.PLAYERS, 0.6F, 1.25F);
        LostFx.burst(level, player.blockPosition(), augmentParticle(), 18, 0.65D, 0.03D);
    }

    private void dataPulse(Level level, Player player) {
        if (itemName.contains("anti_radar")) {
            player.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 180, 0, true, false));
        } else if (itemName.contains("fresh") || itemName.contains("storage")) {
            player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 160, 0, true, false));
        } else if (itemName.contains("warped") || itemName.contains("audio")) {
            for (LivingEntity entity : level.getEntitiesOfClass(LivingEntity.class, player.getBoundingBox().inflate(6.0D), entity -> entity != player)) {
                entity.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 140, 0));
                entity.addEffect(new MobEffectInstance(ModEffects.NULLIFIED.get(), 100, 0));
            }
        } else if (itemName.contains("aligned") || itemName.contains("synchronized") || itemName.contains("synchronizer")) {
            player.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 180, 0, true, false));
            player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 180, 0, true, false));
        } else {
            analyze(level, player);
        }
        LostFx.play(level, player.blockPosition(), "scanner", SoundSource.PLAYERS, 0.55F, 1.3F);
        LostFx.burst(level, player.blockPosition(), "small_spark", 16, 0.45D, 0.03D);
    }

    private void navigationPulse(Level level, Player player) {
        analyze(level, player);
        if (itemName.contains("hypercron") || itemName.contains("timeline")) {
            player.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 220, 1, true, false));
            player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 220, 0, true, false));
            if (level instanceof ServerLevel serverLevel && itemName.contains("hypercron")) {
                serverLevel.setDayTime((serverLevel.getDayTime() + 1000L) % 24000L);
            }
        } else if (itemName.startsWith("map_") || itemName.endsWith("_map")) {
            player.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 240, 0, true, false));
            player.addEffect(new MobEffectInstance(MobEffects.LUCK, 240, 0, true, false));
        } else {
            player.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 180, 0, true, false));
        }
        LostFx.play(level, player.blockPosition(), itemName.contains("hypercron") ? "magic_weapon_12" : "scanner", SoundSource.PLAYERS, 0.6F, 1.15F);
        LostFx.burst(level, player.blockPosition(), itemName.contains("hypercron") ? "space_magic" : "small_spark", 20, 0.55D, 0.03D);
    }

    private void relocatePulse(Level level, Player player) {
        blink(level, player, itemName.contains("mk3") || itemName.contains("geocoordinated") ? 36.0D : 20.0D);
        player.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 100, 0, true, false));
        LostFx.burst(level, player.blockPosition(), "warp", 22, 0.65D, 0.04D);
    }

    private void progressionPulse(Level level, Player player) {
        if (itemName.contains("power") || itemName.contains("override")) {
            for (LivingEntity entity : level.getEntitiesOfClass(LivingEntity.class, player.getBoundingBox().inflate(6.0D), entity -> entity != player)) {
                entity.addEffect(new MobEffectInstance(ModEffects.NULLIFIED.get(), 120, 1));
                entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 140, 0));
            }
            player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 160, 0, true, false));
        } else if (itemName.contains("maze") || itemName.contains("puzzle")) {
            player.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 240, 0, true, false));
            player.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 160, 0, true, false));
        } else if (itemName.contains("arena") || itemName.contains("token") || itemName.endsWith("card")) {
            player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 180, 0, true, false));
            player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 180, 0, true, false));
        } else {
            player.addEffect(new MobEffectInstance(MobEffects.LUCK, 180, 0, true, false));
        }
        LostFx.play(level, player.blockPosition(), progressionSound(), SoundSource.PLAYERS, 0.65F, 1.15F);
        LostFx.burst(level, player.blockPosition(), progressionParticle(), 20, 0.65D, 0.03D);
    }

    private void resourcePulse(Level level, Player player) {
        if (itemName.contains("battery") || itemName.contains("cell") || itemName.contains("capacitor")
                || itemName.contains("generator")) {
            player.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 180, 1, true, false));
            player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 160, 0, true, false));
            LostFx.play(level, player.blockPosition(), "charging_power", SoundSource.PLAYERS, 0.6F, 1.2F);
            LostFx.burst(level, player.blockPosition(), "electric_explosion_blue", 18, 0.55D, 0.03D);
            return;
        }
        if (itemName.contains("heart") || itemName.contains("vessel")) {
            player.heal(itemName.contains("giant") || itemName.contains("light") ? 8.0F : 4.0F);
            player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 160, 1, true, false));
            LostFx.play(level, player.blockPosition(), "bioenergize", SoundSource.PLAYERS, 0.65F, 1.15F);
            LostFx.burst(level, player.blockPosition(), "blood_drop", 14, 0.45D, 0.02D);
            return;
        }
        if (itemName.contains("seed") || itemName.contains("sap") || itemName.contains("flower")) {
            player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 140, 0, true, false));
            player.addEffect(new MobEffectInstance(MobEffects.SATURATION, 80, 0, true, false));
            LostFx.play(level, player.blockPosition(), "special_craft", SoundSource.PLAYERS, 0.55F, 1.35F);
            LostFx.burst(level, player.blockPosition(), "miasma", 18, 0.5D, 0.03D);
            return;
        }
        if (itemName.contains("totem") || itemName.contains("idol") || itemName.contains("relic")) {
            defensivePulse(level, player);
            player.addEffect(new MobEffectInstance(MobEffects.LUCK, 200, 0, true, false));
            return;
        }
        if (itemName.contains("controller") || itemName.contains("constructor") || itemName.contains("remote")) {
            summonHelper(level, player);
            return;
        }
        if (itemName.contains("plague") || itemName.contains("curse") || itemName.contains("dark")
                || itemName.contains("shadow") || itemName.contains("forbidden")) {
            effectBurst(level, player, MobEffects.WITHER, MobEffects.DAMAGE_BOOST);
            return;
        }
        if (itemName.contains("solar") || itemName.contains("ember") || itemName.contains("fire")
                || itemName.contains("burning")) {
            fireBurst(level, player, 4.0D);
            return;
        }
        if (itemName.contains("georedirection") || itemName.contains("orb")) {
            attract(level, player);
            return;
        }
        player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 160, 0, true, false));
        player.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 200, 0, true, false));
        LostFx.play(level, player.blockPosition(), "magic_weapon_5", SoundSource.PLAYERS, 0.55F, 1.25F);
        LostFx.burst(level, player.blockPosition(), "space_magic", 18, 0.5D, 0.03D);
    }

    private void chemistryPulse(Level level, Player player) {
        if (itemName.contains("cure") || itemName.contains("filter") || itemName.contains("syrup")) {
            clearBadEffects(player);
            player.heal(3.0F);
            player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 120, 0, true, false));
            LostFx.play(level, player.blockPosition(), "bioenergize", SoundSource.PLAYERS, 0.55F, 1.25F);
            LostFx.burst(level, player.blockPosition(), "miasma", 14, 0.45D, 0.03D);
            return;
        }
        if (itemName.contains("acid") || itemName.contains("toxin") || itemName.contains("poison")
                || itemName.contains("biocorruption")) {
            effectBurst(level, player, MobEffects.POISON, ModEffects.ACIDIC.get());
            return;
        }
        if (itemName.contains("plague") || itemName.contains("bio") || itemName.contains("corrupt")) {
            effectBurst(level, player, ModEffects.PLAGUE.get(), ModEffects.CONTAGIOUS.get());
            return;
        }
        if (itemName.contains("fire") || itemName.contains("flame") || itemName.contains("solar")
                || itemName.contains("quickflame")) {
            fireBurst(level, player, 4.5D);
            player.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 180, 0, true, false));
            return;
        }
        if (itemName.contains("growth") || itemName.contains("gel") || itemName.contains("syrup")) {
            player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 180, 1, true, false));
            player.addEffect(new MobEffectInstance(MobEffects.SATURATION, 100, 0, true, false));
            LostFx.burst(level, player.blockPosition(), "miasma", 18, 0.55D, 0.03D);
            LostFx.play(level, player.blockPosition(), "special_craft", SoundSource.PLAYERS, 0.55F, 1.35F);
            return;
        }
        if (itemName.contains("gravity") || itemName.contains("cyclone") || itemName.contains("ultralight")) {
            for (LivingEntity entity : level.getEntitiesOfClass(LivingEntity.class, player.getBoundingBox().inflate(6.0D), entity -> entity != player)) {
                entity.addEffect(new MobEffectInstance(ModEffects.GRAVITATIONAL.get(), 140, itemName.contains("ultralight") ? 0 : 1));
                entity.push(0.0D, itemName.contains("ultralight") ? 0.7D : 0.35D, 0.0D);
            }
            LostFx.burst(level, player.blockPosition(), "gravity_ring", 20, 0.8D, 0.04D);
            LostFx.play(level, player.blockPosition(), "magic_weapon_3", SoundSource.PLAYERS, 0.6F, 1.1F);
            return;
        }
        if (itemName.contains("nightmare") || itemName.contains("dark") || itemName.contains("mortality")) {
            for (LivingEntity entity : level.getEntitiesOfClass(LivingEntity.class, player.getBoundingBox().inflate(5.5D), entity -> entity != player)) {
                entity.addEffect(new MobEffectInstance(ModEffects.TERRIFIED.get(), 180, 0));
                entity.addEffect(new MobEffectInstance(MobEffects.WITHER, 100, 0));
            }
            LostFx.burst(level, player.blockPosition(), "dark_magic", 18, 0.65D, 0.03D);
            LostFx.play(level, player.blockPosition(), "magic_weapon_11", SoundSource.PLAYERS, 0.6F, 0.9F);
            return;
        }
        if (itemName.contains("volatile") || itemName.contains("unstable") || itemName.contains("explosive")) {
            fireBurst(level, player, 3.5D);
            LostFx.burst(level, player.blockPosition(), "plasma_explosion", 20, 0.7D, 0.05D);
            LostFx.play(level, player.blockPosition(), "deep_explosion", SoundSource.PLAYERS, 0.55F, 1.25F);
            return;
        }
        player.addEffect(new MobEffectInstance(ModEffects.POTION_AFFINITY.get(), 200, 0, true, false));
        player.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 160, 0, true, false));
        LostFx.burst(level, player.blockPosition(), "small_spark", 16, 0.45D, 0.03D);
        LostFx.play(level, player.blockPosition(), "chemical_mixing", SoundSource.PLAYERS, 0.55F, 1.2F);
    }

    private void recoveredArtifactPulse(Level level, Player player) {
        if (itemName.contains("dark") || itemName.contains("void") || itemName.contains("shadow") || itemName.contains("murk")) {
            player.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 240, 0, true, false));
            for (LivingEntity entity : level.getEntitiesOfClass(LivingEntity.class, player.getBoundingBox().inflate(5.0D), entity -> entity != player)) {
                entity.addEffect(new MobEffectInstance(ModEffects.NULLIFIED.get(), 120, 0));
                entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 120, 0));
            }
            LostFx.burst(level, player.blockPosition(), "shadow_blast", 18, 0.6D, 0.03D);
            LostFx.play(level, player.blockPosition(), "magic_weapon_11", SoundSource.PLAYERS, 0.55F, 1.0F);
            return;
        }
        if (itemName.contains("galaxy") || itemName.contains("star") || itemName.contains("astral") || itemName.contains("celestial")) {
            player.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 180, 0, true, false));
            player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 140, 0, true, false));
            LostFx.burst(level, player.blockPosition(), "space_magic", 22, 0.65D, 0.03D);
            LostFx.play(level, player.blockPosition(), "cosmic_explosion", SoundSource.PLAYERS, 0.45F, 1.45F);
            return;
        }
        if (itemName.contains("sea") || itemName.contains("coral") || itemName.contains("water") || itemName.contains("aqua")) {
            player.addEffect(new MobEffectInstance(MobEffects.WATER_BREATHING, 240, 0, true, false));
            player.addEffect(new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 160, 0, true, false));
            LostFx.burst(level, player.blockPosition(), "murk", 18, 0.55D, 0.03D);
            LostFx.play(level, player.blockPosition(), "water_drop", SoundSource.PLAYERS, 0.55F, 1.2F);
            return;
        }
        if (itemName.contains("lab") || itemName.contains("maze") || itemName.contains("puzzle")) {
            player.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 180, 0, true, false));
            player.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 220, 0, true, false));
            LostFx.burst(level, player.blockPosition(), "spectral", 18, 0.55D, 0.03D);
            LostFx.play(level, player.blockPosition(), "magic_weapon_5", SoundSource.PLAYERS, 0.6F, 1.15F);
            return;
        }
        player.addEffect(new MobEffectInstance(MobEffects.LUCK, 180, 0, true, false));
        player.addEffect(new MobEffectInstance(ModEffects.POTION_AFFINITY.get(), 180, 0, true, false));
        LostFx.burst(level, player.blockPosition(), "small_spark", 14, 0.45D, 0.03D);
        LostFx.play(level, player.blockPosition(), "magic_weapon_5", SoundSource.PLAYERS, 0.5F, 1.25F);
    }

    private String augmentSound() {
        if (itemName.contains("heal") || itemName.contains("regenerative")) return "bioenergize";
        if (itemName.contains("dash") || itemName.contains("slide")) return "sound_bounce";
        if (itemName.contains("teleport")) return "rapid_teleport";
        if (itemName.contains("invisibility") || itemName.contains("nightmare")) return "magic_weapon_11";
        if (itemName.contains("blight") || itemName.contains("plague")) return "flask_explode";
        if (itemName.contains("emp")) return "charging_power";
        if (itemName.contains("destructive") || itemName.contains("shatter") || itemName.contains("slam")) return "rock_tumble";
        return "special_craft";
    }

    private String augmentParticle() {
        if (itemName.contains("heal") || itemName.contains("regenerative")) return "blood_drop";
        if (itemName.contains("dash") || itemName.contains("slide")) return "supersonic_blue";
        if (itemName.contains("teleport")) return "warp";
        if (itemName.contains("invisibility") || itemName.contains("nightmare")) return "shadow_blast";
        if (itemName.contains("blight") || itemName.contains("plague")) return "plague";
        if (itemName.contains("emp")) return "electric_explosion_blue";
        if (itemName.contains("destructive") || itemName.contains("shatter") || itemName.contains("slam")) return "small_spark";
        return "ancient_spell";
    }

    private String progressionSound() {
        if (itemName.contains("power") || itemName.contains("override")) return "charging_power";
        if (itemName.contains("maze") || itemName.contains("puzzle")) return "magic_weapon_5";
        if (itemName.contains("arena") || itemName.contains("token") || itemName.endsWith("card")) return "armor_activate";
        return "nebulous_beacon";
    }

    private String progressionParticle() {
        if (itemName.contains("power") || itemName.contains("override")) return "electric_explosion_blue";
        if (itemName.contains("maze") || itemName.contains("puzzle")) return "spectral";
        if (itemName.contains("arena") || itemName.contains("token") || itemName.endsWith("card")) return "space_magic";
        return "portal_beam";
    }

    private void shootUtilityProjectile(Level level, Player player, ItemStack stack) {
        float damage = itemName.contains("bomb") || itemName.contains("exothermite") ? 9.0F : 5.0F;
        LostCombatProjectile projectile = new LostCombatProjectile(level, player, damage);
        ItemStack projectileStack = stack.copy();
        projectileStack.setCount(1);
        projectile.setItem(projectileStack);
        projectile.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, itemName.contains("bomb") ? 1.05F : 1.75F, 0.6F);
        level.addFreshEntity(projectile);
        LostFx.play(level, player.blockPosition(), utilityShotSound(), SoundSource.PLAYERS, 0.55F, itemName.contains("bomb") ? 0.85F : 1.05F);
        LostFx.burst(level, player.blockPosition(), itemName.contains("exothermite") ? "plasma" : "small_spark", 8, 0.25D, 0.02D);
    }

    private String utilityShotSound() {
        if (itemName.contains("bomb")) {
            return "bomb_tick";
        }
        if (itemName.contains("exothermite")) {
            return "missile_launch";
        }
        if (itemName.contains("quark") || itemName.contains("gluon")) {
            return "magic_weapon_20";
        }
        if (itemName.contains("emitter")) {
            return "sound_gun";
        }
        return "magic_weapon_1";
    }

    private static void consumeOrDamage(Player player, ItemStack stack, InteractionHand hand, boolean consume) {
        if (player.getAbilities().instabuild) {
            return;
        }
        if (consume) {
            stack.shrink(1);
        } else if (stack.isDamageableItem()) {
            stack.hurtAndBreak(1, player, owner -> owner.broadcastBreakEvent(hand));
        }
    }
}
