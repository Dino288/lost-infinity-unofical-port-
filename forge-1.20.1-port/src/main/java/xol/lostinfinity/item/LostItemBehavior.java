package xol.lostinfinity.item;

import java.util.Locale;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import xol.lostinfinity.entity.LostCombatProjectile;
import xol.lostinfinity.registry.ModEffects;

public final class LostItemBehavior {
    private static final String MODE_TAG = "LostMode";
    private static final String ENERGY_TAG = "LostEnergy";
    private static final String AMMO_TAG = "LostAmmo";
    private static final String CHARGE_TAG = "LostCharge";

    private LostItemBehavior() {
    }

    public static boolean useModeEnergyItem(String itemName, ItemStack stack, Level level, Player player, InteractionHand hand) {
        String name = normalize(itemName);
        if (player.isShiftKeyDown() && modeCount(name) > 1) {
            cycleModeFromNetwork(name, stack, level, player);
            return true;
        }

        if (name.contains("battery") || name.contains("energy_cell") || name.contains("power_cell") || name.contains("tesla_core")) {
            recharge(stack, name.contains("tesla") ? 400 : 250, energyCapacity(name));
            player.displayClientMessage(Component.literal("Energy: " + energy(stack) + "/" + energyCapacity(name)), true);
            return true;
        }
        if (name.contains("ammo") || name.contains("shell") || name.contains("cartridge") || name.contains("magazine")) {
            addAmmo(stack, name.contains("shell") ? 8 : 24, ammoCapacity(name));
            player.displayClientMessage(Component.literal("Ammo: " + ammo(stack) + "/" + ammoCapacity(name)), true);
            return true;
        }
        if (name.contains("gauntlet") || name.contains("timekeeper") || name.contains("world_splitter") || name.contains("black_hole")
                || name.contains("selector") || name.contains("selection") || name.contains("ultimatum") || name.contains("resurgence")
                || name.contains("skyverge") || name.contains("reverberance") || name.contains("insanity") || name.contains("sonic")
                || name.contains("celestial") || name.contains("spectral") || name.contains("void") || name.contains("plague")
                || name.contains("blight") || name.contains("graviterium") || name.contains("plasmythic") || name.contains("vampyreon")) {
            if (!consumeEnergy(stack, costFor(name), player)) {
                return true;
            }
            castModePower(name, mode(stack), level, player, stack);
            damageHeld(stack, player, hand, 1);
            player.getCooldowns().addCooldown(stack.getItem(), cooldownFor(name));
            return true;
        }
        return false;
    }

    public static void cycleModeFromNetwork(String itemName, ItemStack stack, Level level, Player player) {
        String name = normalize(itemName);
        if (modeCount(name) <= 1) {
            return;
        }
        int nextMode = (mode(stack) + 1) % modeCount(name);
        stack.getOrCreateTag().putInt(MODE_TAG, nextMode);
        player.displayClientMessage(Component.literal("Mode: " + modeName(name, nextMode)), true);
        level.playSound(null, player.blockPosition(), SoundEvents.UI_BUTTON_CLICK.get(), SoundSource.PLAYERS, 0.5F, 1.2F);
    }

    public static void onWeaponHit(String itemName, ItemStack stack, LivingEntity target, LivingEntity attacker) {
        String name = normalize(itemName);
        int mode = mode(stack);
        if (name.contains("selector") || name.contains("selection")) {
            target.addEffect(new MobEffectInstance(ModEffects.NULLIFIED.get(), 120, 0));
        }
        if (name.contains("time") || modeName(name, mode).equals("Stasis")) {
            target.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 120, 2));
        }
        if (name.contains("reverberance") || name.contains("sonic")) {
            target.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 120, 0));
            splashDamage(attacker, target, 3.5D, 3.0F);
        }
        if (name.contains("resurgence") && attacker instanceof Player player && player.getHealth() < player.getMaxHealth() * 0.5F) {
            player.heal(2.0F);
        }
        if (name.contains("ultimatum") || name.contains("world_splitter")) {
            target.hurt(attacker.damageSources().magic(), consumeEnergy(stack, 15, attacker instanceof Player p ? p : null) ? 7.0F : 2.0F);
        }
        if (name.contains("black_hole")) {
            target.push(0.0D, 0.45D, 0.0D);
        }
        if (name.contains("skyverge") || name.contains("graviterium")) {
            target.push(0.0D, 0.65D, 0.0D);
            target.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 60, 0));
        }
        if (name.contains("insanity") || name.contains("spectral")) {
            target.addEffect(new MobEffectInstance(ModEffects.TERRIFIED.get(), 120, 0));
            target.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 140, 0));
        }
        if (name.contains("blight") || name.contains("plague")) {
            target.addEffect(new MobEffectInstance(ModEffects.PLAGUE.get(), 140, name.contains("plague") ? 1 : 0));
            target.addEffect(new MobEffectInstance(ModEffects.BLIGHTED.get(), 120, 0));
        }
        if (name.contains("vampyreon") && attacker instanceof Player player) {
            player.heal(1.0F);
        }
        if (name.contains("plasmythic")) {
            target.setSecondsOnFire(5);
        }
    }

    public static void onArmorTick(String itemName, ItemStack stack, Level level, Player player) {
        String name = normalize(itemName);
        if (player.tickCount % 80 == 0 && energy(stack) < energyCapacity(name)) {
            recharge(stack, 1, energyCapacity(name));
        }
        if (name.contains("jet") || name.contains("sky") || name.contains("wing")) {
            player.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 60, 0, true, false));
        }
        if (name.contains("cthulhu") || name.contains("void") || name.contains("murk")) {
            player.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 220, 0, true, false));
        }
        if (name.contains("tesla") || name.contains("voltaic")) {
            player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 60, 0, true, false));
        }
        if (name.contains("celestial") || name.contains("spectral")) {
            player.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 80, 0, true, false));
            player.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 240, 0, true, false));
        }
        if (name.contains("sea") || name.contains("coral") || name.contains("aqua") || name.contains("serpent")) {
            player.addEffect(new MobEffectInstance(MobEffects.WATER_BREATHING, 120, 0, true, false));
            player.addEffect(new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 80, 0, true, false));
        }
        if (name.contains("plasmythic") || name.contains("molten") || name.contains("solar")) {
            player.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 100, 0, true, false));
        }
        if (name.contains("vampyreon") && player.getHealth() < player.getMaxHealth() * 0.55F) {
            player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 80, 0, true, false));
        }
        if (name.contains("runner") || name.contains("swift") || name.contains("nitrous")) {
            player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 80, 0, true, false));
        }
    }

    public static void onArmorHurt(String itemName, ItemStack stack, LivingEntity wearer, LivingEntity attacker) {
        String name = normalize(itemName);
        if (attacker == null) {
            return;
        }
        if (name.contains("thorn") || name.contains("spike") || name.contains("tesla") || name.contains("voltaic")) {
            attacker.hurt(wearer.damageSources().thorns(wearer), name.contains("tesla") || name.contains("voltaic") ? 4.0F : 2.0F);
            if (name.contains("tesla") || name.contains("voltaic")) {
                attacker.addEffect(new MobEffectInstance(ModEffects.NULLIFIED.get(), 80, 0));
            }
        }
        if (name.contains("blight") || name.contains("plague")) {
            attacker.addEffect(new MobEffectInstance(MobEffects.POISON, 100, 0));
        }
        if (name.contains("plasmythic") || name.contains("fire")) {
            attacker.setSecondsOnFire(4);
        }
        if (name.contains("void") || name.contains("murk") || name.contains("cthulhu") || name.contains("spectral")) {
            attacker.addEffect(new MobEffectInstance(ModEffects.NULLIFIED.get(), 100, 0));
            attacker.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 100, 0));
        }
        if (name.contains("ice") || name.contains("cryo") || name.contains("frost")) {
            attacker.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 120, 2));
        }
        if (name.contains("sonic") || name.contains("reverberance")) {
            attacker.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 120, 0));
            Vec3 away = attacker.position().subtract(wearer.position()).normalize().scale(0.8D);
            attacker.push(away.x, 0.25D, away.z);
        }
    }

    public static boolean fireRanged(String itemName, ItemStack stack, Level level, Player player, InteractionHand hand, float baseVelocity, float baseDamage) {
        String name = normalize(itemName);
        if (!consumeAmmoOrEnergy(stack, name, player)) {
            return false;
        }
        float damage = baseDamage + mode(stack) * 2.0F;
        float velocity = baseVelocity + (name.contains("sniper") ? 0.7F : 0.0F);
        LostCombatProjectile projectile = new LostCombatProjectile(level, player, damage);
        ItemStack projectileStack = stack.copy();
        projectileStack.setCount(1);
        projectile.setItem(projectileStack);
        projectile.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, velocity, name.contains("sniper") ? 0.1F : 0.7F);
        level.addFreshEntity(projectile);
        level.playSound(null, player.blockPosition(), name.contains("laser") || name.contains("zapper") ? SoundEvents.GUARDIAN_ATTACK : SoundEvents.FIRECHARGE_USE,
                SoundSource.PLAYERS, 0.55F, 1.05F + mode(stack) * 0.1F);
        damageHeld(stack, player, hand, 1);
        return true;
    }

    public static void appendModeEnergyTooltip(String itemName, ItemStack stack, java.util.List<Component> tooltip) {
        String name = normalize(itemName);
        if (modeCount(name) > 1) {
            tooltip.add(Component.literal("Mode: " + modeName(name, mode(stack))));
        }
        if (energyCapacity(name) > 0) {
            tooltip.add(Component.literal("Energy: " + energy(stack) + "/" + energyCapacity(name)));
        }
        if (ammoCapacity(name) > 0) {
            tooltip.add(Component.literal("Ammo: " + ammo(stack) + "/" + ammoCapacity(name)));
        }
    }

    private static void castModePower(String name, int mode, Level level, Player player, ItemStack stack) {
        String modeName = modeName(name, mode);
        if (modeName.equals("Blink")) {
            Vec3 target = player.position().add(player.getLookAngle().scale(18.0D));
            player.teleportTo(target.x, target.y, target.z);
            level.playSound(null, player.blockPosition(), SoundEvents.ENDERMAN_TELEPORT, SoundSource.PLAYERS, 0.8F, 1.0F);
        } else if (modeName.equals("Burst")) {
            splashDamage(player, player, 6.0D, 7.0F);
            level.playSound(null, player.blockPosition(), SoundEvents.GENERIC_EXPLODE, SoundSource.PLAYERS, 0.7F, 1.2F);
        } else if (modeName.equals("Summon")) {
            LightningBolt lightning = EntityType.LIGHTNING_BOLT.create(level);
            if (lightning != null) {
                lightning.moveTo(player.position());
                level.addFreshEntity(lightning);
            }
            level.explode(player, player.getX(), player.getY(), player.getZ(), 2.0F, Level.ExplosionInteraction.MOB);
        } else if (modeName.equals("Stasis")) {
            for (LivingEntity living : level.getEntitiesOfClass(LivingEntity.class, player.getBoundingBox().inflate(8.0D), e -> e != player)) {
                living.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 160, 3));
                living.addEffect(new MobEffectInstance(ModEffects.NULLIFIED.get(), 140, 0));
            }
        } else if (modeName.equals("Dash")) {
            Vec3 dash = player.getLookAngle().normalize().scale(2.4D);
            player.push(dash.x, Math.max(0.18D, dash.y * 0.35D), dash.z);
            player.hurtMarked = true;
            player.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 80, 0, true, false));
            level.playSound(null, player.blockPosition(), SoundEvents.ELYTRA_FLYING, SoundSource.PLAYERS, 0.45F, 1.35F);
        } else if (modeName.equals("Launch")) {
            player.push(0.0D, 1.15D, 0.0D);
            player.hurtMarked = true;
            player.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 140, 0, true, false));
            level.playSound(null, player.blockPosition(), SoundEvents.FIREWORK_ROCKET_LAUNCH, SoundSource.PLAYERS, 0.65F, 1.0F);
        } else if (modeName.equals("Gust")) {
            for (LivingEntity living : level.getEntitiesOfClass(LivingEntity.class, player.getBoundingBox().inflate(7.0D), e -> e != player)) {
                Vec3 away = living.position().subtract(player.position()).normalize().scale(1.1D);
                living.push(away.x, 0.45D, away.z);
                living.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 80, 0));
            }
            level.playSound(null, player.blockPosition(), SoundEvents.PHANTOM_FLAP, SoundSource.PLAYERS, 0.8F, 0.9F);
        } else if (modeName.equals("Echo") || modeName.equals("Silence")) {
            for (LivingEntity living : level.getEntitiesOfClass(LivingEntity.class, player.getBoundingBox().inflate(7.0D), e -> e != player)) {
                living.hurt(player.damageSources().magic(), modeName.equals("Silence") ? 4.0F : 2.0F);
                living.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 140, 0));
                living.addEffect(new MobEffectInstance(ModEffects.NULLIFIED.get(), 100, 0));
            }
            level.playSound(null, player.blockPosition(), SoundEvents.WARDEN_SONIC_BOOM, SoundSource.PLAYERS, 0.65F, 1.4F);
        } else if (modeName.equals("Panic") || modeName.equals("Terror")) {
            for (LivingEntity living : level.getEntitiesOfClass(LivingEntity.class, player.getBoundingBox().inflate(8.0D), e -> e != player)) {
                living.addEffect(new MobEffectInstance(ModEffects.TERRIFIED.get(), 180, modeName.equals("Terror") ? 1 : 0));
                living.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 140, 0));
            }
            level.playSound(null, player.blockPosition(), SoundEvents.SCULK_SHRIEKER_SHRIEK, SoundSource.PLAYERS, 0.75F, 1.1F);
        } else if (modeName.equals("Heal") || modeName.equals("Cleanse") || modeName.equals("Revitalize")) {
            player.heal(modeName.equals("Heal") ? 6.0F : 3.0F);
            if (!modeName.equals("Heal")) {
                player.removeEffect(MobEffects.POISON);
                player.removeEffect(MobEffects.WITHER);
                player.removeEffect(MobEffects.WEAKNESS);
                player.removeEffect(MobEffects.MOVEMENT_SLOWDOWN);
                player.removeEffect(MobEffects.CONFUSION);
            }
            if (modeName.equals("Revitalize")) {
                player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 180, 1, true, false));
                player.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 180, 1, true, false));
            }
            level.playSound(null, player.blockPosition(), SoundEvents.BEACON_POWER_SELECT, SoundSource.PLAYERS, 0.6F, 1.2F);
        } else if (modeName.equals("Judgement")) {
            Vec3 strike = player.position().add(player.getLookAngle().scale(8.0D));
            LightningBolt lightning = EntityType.LIGHTNING_BOLT.create(level);
            if (lightning != null) {
                lightning.moveTo(strike);
                level.addFreshEntity(lightning);
            }
            splashDamage(player, player, 8.0D, 9.0F);
        } else {
            player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 180, 1, true, false));
            player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 180, 0, true, false));
        }
    }

    private static void splashDamage(LivingEntity source, LivingEntity center, double radius, float damage) {
        for (LivingEntity living : center.level().getEntitiesOfClass(LivingEntity.class, center.getBoundingBox().inflate(radius), e -> e != source)) {
            living.hurt(source.damageSources().magic(), damage);
        }
    }

    private static boolean consumeAmmoOrEnergy(ItemStack stack, String name, Player player) {
        if (name.contains("gun") || name.contains("rifle") || name.contains("cannon") || name.contains("launcher")) {
            if (ammoCapacity(name) > 0 && ammo(stack) > 0) {
                stack.getOrCreateTag().putInt(AMMO_TAG, ammo(stack) - 1);
                return true;
            }
        }
        return consumeEnergy(stack, costFor(name), player);
    }

    private static boolean consumeEnergy(ItemStack stack, int cost, Player player) {
        if (cost <= 0) {
            return true;
        }
        int stored = energy(stack);
        if (stored <= 0) {
            stack.getOrCreateTag().putInt(ENERGY_TAG, Math.max(0, energyCapacity(normalize(stack.getItem().builtInRegistryHolder().key().location().getPath())) - cost));
            return true;
        }
        if (stored < cost) {
            if (player != null) {
                player.displayClientMessage(Component.literal("Not enough energy."), true);
            }
            return false;
        }
        stack.getOrCreateTag().putInt(ENERGY_TAG, stored - cost);
        return true;
    }

    private static void recharge(ItemStack stack, int amount, int cap) {
        if (cap > 0) {
            stack.getOrCreateTag().putInt(ENERGY_TAG, Math.min(cap, energy(stack) + amount));
        }
    }

    private static void addAmmo(ItemStack stack, int amount, int cap) {
        if (cap > 0) {
            stack.getOrCreateTag().putInt(AMMO_TAG, Math.min(cap, ammo(stack) + amount));
        }
    }

    private static void damageHeld(ItemStack stack, Player player, InteractionHand hand, int amount) {
        if (!player.getAbilities().instabuild && stack.isDamageableItem()) {
            stack.hurtAndBreak(amount, player, owner -> owner.broadcastBreakEvent(hand));
        }
    }

    private static int mode(ItemStack stack) {
        return stack.getOrCreateTag().getInt(MODE_TAG);
    }

    private static int energy(ItemStack stack) {
        return stack.getOrCreateTag().getInt(ENERGY_TAG);
    }

    private static int ammo(ItemStack stack) {
        return stack.getOrCreateTag().getInt(AMMO_TAG);
    }

    private static int modeCount(String name) {
        if (name.contains("skyverge") || name.contains("reverberance") || name.contains("sonic")
                || name.contains("insanity") || name.contains("resurgence") || name.contains("celestial")
                || name.contains("spectral") || name.contains("vampyreon")) {
            return 3;
        }
        if (name.contains("gauntlet") || name.contains("selector") || name.contains("selection") || name.contains("world_splitter")) {
            return 4;
        }
        if (name.contains("timekeeper") || name.contains("black_hole") || name.contains("ultimatum")) {
            return 3;
        }
        return 1;
    }

    private static String modeName(String name, int mode) {
        if (name.contains("black_hole")) {
            return new String[] { "Pull", "Burst", "Stasis" }[mode % 3];
        }
        if (name.contains("timekeeper")) {
            return new String[] { "Stasis", "Blink", "Burst" }[mode % 3];
        }
        if (name.contains("skyverge")) {
            return new String[] { "Dash", "Launch", "Gust" }[mode % 3];
        }
        if (name.contains("reverberance") || name.contains("sonic")) {
            return new String[] { "Echo", "Burst", "Silence" }[mode % 3];
        }
        if (name.contains("insanity") || name.contains("spectral")) {
            return new String[] { "Panic", "Blink", "Terror" }[mode % 3];
        }
        if (name.contains("resurgence") || name.contains("vampyreon")) {
            return new String[] { "Heal", "Cleanse", "Revitalize" }[mode % 3];
        }
        if (name.contains("celestial") || name.contains("ultimatum")) {
            return new String[] { "Strike", "Burst", "Judgement" }[mode % 3];
        }
        if (modeCount(name) == 4) {
            return new String[] { "Strike", "Blink", "Burst", "Summon" }[mode % 4];
        }
        return "Strike";
    }

    private static int energyCapacity(String name) {
        if (name.contains("gauntlet") || name.contains("world_splitter") || name.contains("black_hole")) return 1000;
        if (name.contains("skyverge") || name.contains("reverberance") || name.contains("insanity")
                || name.contains("celestial") || name.contains("spectral") || name.contains("vampyreon")) return 600;
        if (name.contains("tesla") || name.contains("voltaic") || name.contains("energy") || name.contains("battery")) return 500;
        if (name.contains("selector") || name.contains("selection") || name.contains("timekeeper") || name.contains("ultimatum")) return 300;
        return 0;
    }

    private static int ammoCapacity(String name) {
        if (name.contains("cannon") || name.contains("launcher")) return 24;
        if (name.contains("gun") || name.contains("rifle") || name.contains("sniper")) return 64;
        return 0;
    }

    private static int costFor(String name) {
        if (name.contains("world_splitter") || name.contains("black_hole")) return 75;
        if (name.contains("celestial") || name.contains("spectral") || name.contains("skyverge") || name.contains("reverberance")) return 50;
        if (name.contains("gauntlet") || name.contains("ultimatum")) return 45;
        if (name.contains("selector") || name.contains("selection") || name.contains("timekeeper")) return 25;
        if (name.contains("laser") || name.contains("zapper") || name.contains("tesla")) return 8;
        return 5;
    }

    private static int cooldownFor(String name) {
        if (name.contains("world_splitter") || name.contains("black_hole")) return 160;
        if (name.contains("celestial") || name.contains("spectral") || name.contains("reverberance") || name.contains("insanity")) return 120;
        if (name.contains("gauntlet") || name.contains("ultimatum")) return 100;
        return 60;
    }

    private static String normalize(String name) {
        return name.toLowerCase(Locale.ROOT);
    }
}
