package xol.lostinfinity.item;

import java.util.List;
import java.util.Locale;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
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

        if (isCureItem()) {
            clearBadEffects(player);
            player.heal(itemName.contains("guardian") ? 8.0F : 4.0F);
            consumeOrDamage(player, stack, hand, true);
            player.getCooldowns().addCooldown(this, 80);
            return InteractionResultHolder.success(stack);
        }
        if (isInjection()) {
            applyInjection(player);
            consumeOrDamage(player, stack, hand, true);
            player.getCooldowns().addCooldown(this, 200);
            return InteractionResultHolder.success(stack);
        }
        if (itemName.contains("cloaking_device") || itemName.contains("ring_of_illusions")) {
            player.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 400, 0, true, false));
            player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 200, 0, true, false));
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
            player.getCooldowns().addCooldown(this, 40);
            return InteractionResultHolder.success(stack);
        }
        if (itemName.contains("bomb") || itemName.contains("charge") || itemName.contains("quark") || itemName.contains("gluon")
                || itemName.contains("exothermite") || itemName.contains("emitter")) {
            shootUtilityProjectile(level, player, stack);
            consumeOrDamage(player, stack, hand, !stack.isDamageableItem());
            player.getCooldowns().addCooldown(this, itemName.contains("bomb") ? 35 : 18);
            return InteractionResultHolder.success(stack);
        }

        player.displayClientMessage(Component.literal("This recovered item still needs its exact original mechanic ported."), true);
        player.getCooldowns().addCooldown(this, 20);
        return InteractionResultHolder.success(stack);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag flag) {
        tooltip.add(Component.literal("Recovered special item: first-pass 1.20.1 behavior restored.").withStyle(ChatFormatting.DARK_AQUA));
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
        player.teleportTo(target.x, target.y, target.z);
        level.playSound(null, player.blockPosition(), SoundEvents.ENDERMAN_TELEPORT, SoundSource.PLAYERS, 0.75F, 1.25F);
    }

    private static void fireBurst(Level level, Player player, double radius) {
        level.playSound(null, player.blockPosition(), SoundEvents.BLAZE_SHOOT, SoundSource.PLAYERS, 0.8F, 0.8F);
        for (LivingEntity entity : level.getEntitiesOfClass(LivingEntity.class, player.getBoundingBox().inflate(radius), entity -> entity != player)) {
            entity.setSecondsOnFire((int) radius);
            entity.hurt(level.damageSources().playerAttack(player), (float) radius);
        }
    }

    private void effectBurst(Level level, Player player, MobEffect targetEffect, MobEffect selfEffect) {
        level.playSound(null, player.blockPosition(), SoundEvents.BEACON_ACTIVATE, SoundSource.PLAYERS, 0.55F, 1.4F);
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
        level.playSound(null, player.blockPosition(), SoundEvents.PLAYER_LEVELUP, SoundSource.PLAYERS, 0.5F, 1.5F);
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

    private void shootUtilityProjectile(Level level, Player player, ItemStack stack) {
        float damage = itemName.contains("bomb") || itemName.contains("exothermite") ? 9.0F : 5.0F;
        LostCombatProjectile projectile = new LostCombatProjectile(level, player, damage);
        ItemStack projectileStack = stack.copy();
        projectileStack.setCount(1);
        projectile.setItem(projectileStack);
        projectile.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, itemName.contains("bomb") ? 1.05F : 1.75F, 0.6F);
        level.addFreshEntity(projectile);
        level.playSound(null, player.blockPosition(), SoundEvents.FIRECHARGE_USE, SoundSource.PLAYERS, 0.5F, 1.0F);
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
