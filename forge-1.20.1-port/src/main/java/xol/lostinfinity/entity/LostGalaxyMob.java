package xol.lostinfinity.entity;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import xol.lostinfinity.registry.ModItems;

public class LostGalaxyMob extends LostPlaceholderMob {
    public enum Kind {
        BEAST,
        SORCERER,
        GLADIATOR,
        SPIRE,
        GULPER,
        LASER_SPIRE,
        DRAGON
    }

    private static final String COLOR_TAG = "LostGalaxyColor";
    private static final String PINK_FEED_TAG = "PinkFeed";
    private static final String BLUE_FEED_TAG = "BlueFeed";
    private static final String PURPLE_FEED_TAG = "PurpleFeed";
    private static final String PINK_FEED_MAX_TAG = "PinkFeedMax";
    private static final String BLUE_FEED_MAX_TAG = "BlueFeedMax";
    private static final String PURPLE_FEED_MAX_TAG = "PurpleFeedMax";

    private final Kind kind;
    private int galaxyColor;
    private int pinkFeed;
    private int blueFeed;
    private int purpleFeed;
    private int pinkFeedMax;
    private int blueFeedMax;
    private int purpleFeedMax;
    private int laserFireOffset;

    public LostGalaxyMob(EntityType<? extends PathfinderMob> type, Level level, Kind kind) {
        super(type, level);
        this.kind = kind;
        this.xpReward = kind == Kind.SPIRE || kind == Kind.LASER_SPIRE ? 100 : 20;
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(8, new LookAtPlayerGoal(this, Player.class, 12.0F));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));

        if (this.kind != Kind.SPIRE && this.kind != Kind.LASER_SPIRE) {
            this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.0D, false));
            this.goalSelector.addGoal(7, new RandomStrollGoal(this, 0.8D));
        }
    }

    public static AttributeSupplier.Builder beastAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 1000.0D)
                .add(Attributes.ATTACK_DAMAGE, 1.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.4D)
                .add(Attributes.FOLLOW_RANGE, 32.0D);
    }

    public static AttributeSupplier.Builder sorcererAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 500.0D)
                .add(Attributes.ATTACK_DAMAGE, 1.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.22D)
                .add(Attributes.FOLLOW_RANGE, 32.0D);
    }

    public static AttributeSupplier.Builder gladiatorAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 700.0D)
                .add(Attributes.ATTACK_DAMAGE, 1.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.35D)
                .add(Attributes.FOLLOW_RANGE, 32.0D);
    }

    public static AttributeSupplier.Builder spireAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 10000.0D)
                .add(Attributes.ATTACK_DAMAGE, 0.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.0D)
                .add(Attributes.KNOCKBACK_RESISTANCE, 1.0D)
                .add(Attributes.FOLLOW_RANGE, 48.0D);
    }

    public static AttributeSupplier.Builder gulperAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 5500.0D)
                .add(Attributes.ATTACK_DAMAGE, 3.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.25D)
                .add(Attributes.KNOCKBACK_RESISTANCE, 1.0D)
                .add(Attributes.FOLLOW_RANGE, 32.0D);
    }

    public static AttributeSupplier.Builder laserSpireAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 10000.0D)
                .add(Attributes.ATTACK_DAMAGE, 0.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.0D)
                .add(Attributes.KNOCKBACK_RESISTANCE, 1.0D)
                .add(Attributes.FOLLOW_RANGE, 48.0D);
    }

    public static AttributeSupplier.Builder dragonAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 300.0D)
                .add(Attributes.ATTACK_DAMAGE, 6.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.3D)
                .add(Attributes.FOLLOW_RANGE, 48.0D);
    }

    @Override
    public void aiStep() {
        super.aiStep();
        if (this.level().isClientSide()) {
            return;
        }

        if (this.galaxyColor == 0) {
            this.galaxyColor = this.random.nextInt(4) + 1;
        }
        if (this.kind == Kind.GULPER && this.pinkFeedMax == 0) {
            resetGulperFeedNeeds();
        }
        if (this.kind == Kind.LASER_SPIRE && this.laserFireOffset == 0) {
            this.laserFireOffset = this.random.nextInt(6) * 5;
        }

        LivingEntity target = this.getTarget();
        if (this.kind == Kind.BEAST) {
            tickBeast(target);
        } else if (this.kind == Kind.SORCERER && target != null && this.tickCount % 20 == 0) {
            shootAt(target, 8.0F, 0.6F);
            this.level().playSound(null, this.blockPosition(), SoundEvents.EVOKER_CAST_SPELL, SoundSource.HOSTILE, 1.0F, 1.0F);
        } else if (this.kind == Kind.GLADIATOR && target != null && this.tickCount % 60 == 0) {
            this.teleportTo(target.getX(), target.getY(), target.getZ());
            dealPercentDamage(target, 0.05F);
            this.level().playSound(null, this.blockPosition(), SoundEvents.ENDERMAN_TELEPORT, SoundSource.HOSTILE, 1.0F, 1.0F);
        } else if (this.kind == Kind.SPIRE) {
            tickSpire(target);
        } else if (this.kind == Kind.GULPER) {
            tickGulper(target);
        } else if (this.kind == Kind.LASER_SPIRE) {
            tickLaserSpire(target);
        } else if (this.kind == Kind.DRAGON) {
            tickDragon(target);
        }
    }

    private void tickBeast(LivingEntity target) {
        this.fallDistance = 0.0F;
        if (this.tickCount % 20 < 10) {
            this.setDeltaMovement(this.getDeltaMovement().add(0.0D, 0.05D, 0.0D));
        }
        if (target != null) {
            Vec3 delta = target.position().subtract(this.position());
            if (target.getY() > this.getY()) {
                this.setDeltaMovement(this.getDeltaMovement().add(0.0D, 0.04D, 0.0D));
            }
            Vec3 flat = new Vec3(delta.x, 0.0D, delta.z);
            if (flat.lengthSqr() > 1.0D && this.getDeltaMovement().horizontalDistanceSqr() < 0.08D) {
                this.setDeltaMovement(this.getDeltaMovement().add(flat.normalize().scale(0.08D)));
            }
        }
    }

    private void tickSpire(LivingEntity target) {
        this.setDeltaMovement(Vec3.ZERO);
        this.fallDistance = 0.0F;
        if (this.getHealth() < this.getMaxHealth()) {
            this.setHealth(this.getMaxHealth());
        }
        if (target != null && this.distanceToSqr(target) <= 48.0D * 48.0D && this.tickCount % 40 == 0) {
            shootAt(target, 12.0F, 0.75F);
            this.level().playSound(null, this.blockPosition(), SoundEvents.BLAZE_SHOOT, SoundSource.HOSTILE, 1.0F, 0.7F);
        }
    }

    private void tickGulper(LivingEntity target) {
        if (this.pinkFeed >= this.pinkFeedMax && this.blueFeed >= this.blueFeedMax && this.purpleFeed >= this.purpleFeedMax) {
            this.spawnAtLocation(ModItems.ITEM_ACIDBLOOD_SOLUTION.get(), 1);
            resetGulperFeedNeeds();
        }
        if (target != null && this.tickCount % 360 > 200 && this.tickCount % 360 < 340) {
            this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.32D);
        } else {
            this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.25D);
        }
    }

    private void tickLaserSpire(LivingEntity target) {
        this.setDeltaMovement(Vec3.ZERO);
        this.fallDistance = 0.0F;
        if (this.getHealth() < this.getMaxHealth()) {
            this.setHealth(this.getMaxHealth());
        }
        if (target != null && this.distanceToSqr(target) > 9.0D && this.distanceToSqr(target) <= 48.0D * 48.0D
                && (this.tickCount + this.laserFireOffset) % 50 == 0) {
            shootAt(target, 14.0F, 1.0F);
            this.level().playSound(null, this.blockPosition(), SoundEvents.GUARDIAN_ATTACK, SoundSource.HOSTILE, 2.0F, 1.0F);
        }
    }

    private void tickDragon(LivingEntity target) {
        this.fallDistance = 0.0F;
        if (target == null) {
            return;
        }
        if (this.tickCount % 10 == 0 && this.distanceToSqr(target) <= 30.0D * 30.0D) {
            dealPercentDamage(target, 0.05F);
            this.level().playSound(null, this.blockPosition(), SoundEvents.ENDER_DRAGON_SHOOT, SoundSource.HOSTILE, 0.7F, 0.9F);
        }
        if (this.tickCount % 20 == 0 && this.distanceToSqr(target) <= 48.0D * 48.0D) {
            shootAt(target, 10.0F, 1.0F);
            this.level().playSound(null, this.blockPosition(), SoundEvents.GHAST_SHOOT, SoundSource.HOSTILE, 1.0F, 0.9F);
        }
    }

    private void shootAt(LivingEntity target, float damage, float velocity) {
        LostCombatProjectile projectile = new LostCombatProjectile(this.level(), this, damage);
        projectile.setPos(this.getX(), this.getEyeY() - 0.2D, this.getZ());
        double dx = target.getX() - this.getX();
        double dy = target.getEyeY() - projectile.getY();
        double dz = target.getZ() - this.getZ();
        double horizontal = Math.sqrt(dx * dx + dz * dz);
        projectile.shoot(dx, dy + horizontal * 0.2D, dz, velocity, 0.0F);
        this.level().addFreshEntity(projectile);
    }

    @Override
    public boolean doHurtTarget(Entity target) {
        boolean hurt = super.doHurtTarget(target);
        if (target instanceof LivingEntity living) {
            float percent = this.kind == Kind.GULPER ? gulperBitePercent() : this.kind == Kind.BEAST ? 0.05F : 0.08F;
            hurt |= dealPercentDamage(living, percent);
        }
        return hurt;
    }

    @Override
    public InteractionResult mobInteract(Player player, InteractionHand hand) {
        if (this.kind != Kind.GULPER) {
            return super.mobInteract(player, hand);
        }
        ItemStack stack = player.getItemInHand(hand);
        if (feedGulper(player, stack)) {
            if (!player.getAbilities().instabuild) {
                stack.shrink(1);
            }
            return InteractionResult.sidedSuccess(this.level().isClientSide());
        }
        return super.mobInteract(player, hand);
    }

    private boolean dealPercentDamage(LivingEntity target, float percent) {
        float damage = Math.max(1.0F, target.getMaxHealth() * percent);
        return target.hurt(this.damageSources().mobAttack(this), damage);
    }

    private boolean feedGulper(Player player, ItemStack stack) {
        if (stack.is(ModItems.ITEM_WATCHFUL_EYE_PINK.get())) {
            this.pinkFeed = feedOne(player, this.pinkFeed, this.pinkFeedMax);
            return true;
        }
        if (stack.is(ModItems.ITEM_WATCHFUL_EYE_BLUE.get())) {
            this.blueFeed = feedOne(player, this.blueFeed, this.blueFeedMax);
            return true;
        }
        if (stack.is(ModItems.ITEM_WATCHFUL_EYE_PURPLE.get())) {
            this.purpleFeed = feedOne(player, this.purpleFeed, this.purpleFeedMax);
            return true;
        }
        return false;
    }

    private int feedOne(Player player, int current, int max) {
        if (current < max) {
            player.displayClientMessage(Component.literal("Nom Nom Nom"), true);
            return current + 1;
        }
        player.displayClientMessage(Component.literal("Blleeecchhh"), true);
        return current;
    }

    private void resetGulperFeedNeeds() {
        this.pinkFeed = 0;
        this.blueFeed = 0;
        this.purpleFeed = 0;
        this.pinkFeedMax = this.random.nextInt(3) + 1;
        this.blueFeedMax = this.random.nextInt(3) + 1;
        this.purpleFeedMax = this.random.nextInt(3) + 1;
    }

    private float gulperBitePercent() {
        int degreeAge = this.tickCount % 360;
        return degreeAge > 200 && degreeAge < 340 ? 0.18F : 0.03F;
    }

    @Override
    public boolean isPushable() {
        return this.kind != Kind.SPIRE && this.kind != Kind.LASER_SPIRE && super.isPushable();
    }

    @Override
    public boolean causeFallDamage(float distance, float damageMultiplier, net.minecraft.world.damagesource.DamageSource source) {
        return this.kind != Kind.BEAST && this.kind != Kind.SPIRE && this.kind != Kind.LASER_SPIRE && this.kind != Kind.DRAGON
                && super.causeFallDamage(distance, damageMultiplier, source);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putInt(COLOR_TAG, this.galaxyColor);
        tag.putInt(PINK_FEED_TAG, this.pinkFeed);
        tag.putInt(BLUE_FEED_TAG, this.blueFeed);
        tag.putInt(PURPLE_FEED_TAG, this.purpleFeed);
        tag.putInt(PINK_FEED_MAX_TAG, this.pinkFeedMax);
        tag.putInt(BLUE_FEED_MAX_TAG, this.blueFeedMax);
        tag.putInt(PURPLE_FEED_MAX_TAG, this.purpleFeedMax);
        tag.putInt("LaserFireOffset", this.laserFireOffset);
    }

    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        this.galaxyColor = tag.getInt(COLOR_TAG);
        this.pinkFeed = tag.getInt(PINK_FEED_TAG);
        this.blueFeed = tag.getInt(BLUE_FEED_TAG);
        this.purpleFeed = tag.getInt(PURPLE_FEED_TAG);
        this.pinkFeedMax = tag.getInt(PINK_FEED_MAX_TAG);
        this.blueFeedMax = tag.getInt(BLUE_FEED_MAX_TAG);
        this.purpleFeedMax = tag.getInt(PURPLE_FEED_MAX_TAG);
        this.laserFireOffset = tag.getInt("LaserFireOffset");
    }

    public int getGalaxyColor() {
        return this.galaxyColor;
    }
}
