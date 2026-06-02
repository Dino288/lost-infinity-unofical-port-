package xol.lostinfinity.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
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
import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.Vec3;
import xol.lostinfinity.registry.ModBlocks;
import xol.lostinfinity.registry.ModItems;

public class LostSeaMob extends LostPlaceholderMob {
    public enum Kind {
        LONGFIN,
        DOUBLERANG,
        RAYFISH,
        GLOWFISH,
        UNDERFIN,
        OCTOBRELLA,
        EELSHARK,
        RIBSHARK,
        CRABULON,
        SEA_SERPENT,
        LEVIATHAN
    }

    private static final String VISUAL_STYLE_TAG = "VisualStyle";
    private static final String FED_TAG = "Fed";
    private static final String FEED_TIMER_TAG = "FeedTimer";
    private static final String RECENT_FOOD_TAG = "RecentFood";
    private static final String TARGET_X_TAG = "TargetX";
    private static final String TARGET_Y_TAG = "TargetY";
    private static final String TARGET_Z_TAG = "TargetZ";
    private static final String HAS_TARGET_TAG = "HasTarget";

    private final Kind kind;
    private int visualStyle;
    private boolean fed;
    private int feedTimer;
    private int recentFood;
    private BlockPos targetPos;

    public LostSeaMob(EntityType<? extends PathfinderMob> type, Level level, Kind kind) {
        super(type, level);
        this.kind = kind;
        this.visualStyle = this.random.nextInt(4);
        this.xpReward = switch (kind) {
            case CRABULON, EELSHARK, SEA_SERPENT, LEVIATHAN -> 80;
            case RIBSHARK, OCTOBRELLA -> 30;
            default -> 8;
        };
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.0D, true));
        this.goalSelector.addGoal(6, new RandomStrollGoal(this, 0.8D));
        this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, 10.0F));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        if (isHostile()) {
            this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
        }
    }

    public static AttributeSupplier.Builder fishAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 20.0D)
                .add(Attributes.ATTACK_DAMAGE, 1.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.24D)
                .add(Attributes.FOLLOW_RANGE, 16.0D);
    }

    public static AttributeSupplier.Builder octoAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 120.0D)
                .add(Attributes.ATTACK_DAMAGE, 2.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.28D)
                .add(Attributes.FOLLOW_RANGE, 24.0D);
    }

    public static AttributeSupplier.Builder predatorAttributes(double health, double speed, double followRange) {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, health)
                .add(Attributes.ATTACK_DAMAGE, 3.0D)
                .add(Attributes.MOVEMENT_SPEED, speed)
                .add(Attributes.KNOCKBACK_RESISTANCE, 1.0D)
                .add(Attributes.FOLLOW_RANGE, followRange);
    }

    @Override
    public void aiStep() {
        super.aiStep();
        if (this.level().isClientSide()) {
            return;
        }

        this.fallDistance = 0.0F;
        if (isFish()) {
            tickFishFeeding();
        }

        LivingEntity target = this.getTarget();
        if (target != null && isHostile()) {
            swimToward(target.position().add(0.0D, target.getBbHeight() * 0.5D, 0.0D), speedForKind());
        } else if (this.tickCount % 80 == 0 || this.getDeltaMovement().lengthSqr() < 0.002D) {
            Vec3 roam = this.position().add(this.random.nextDouble() * 12.0D - 6.0D, this.random.nextDouble() * 6.0D - 3.0D,
                    this.random.nextDouble() * 12.0D - 6.0D);
            swimToward(roam, speedForKind() * 0.55D);
        }

        if (this.kind == Kind.EELSHARK && this.tickCount % 100 == 20) {
            shockNearbyPlayers();
        } else if (this.kind == Kind.CRABULON && target != null && this.tickCount % 60 == 0 && this.distanceToSqr(target) > 16.0D) {
            shootAt(target, 12.0F, 1.5F);
            this.level().playSound(null, this.blockPosition(), SoundEvents.TRIDENT_THROW, SoundSource.HOSTILE, 1.0F, 0.8F);
        }
    }

    private void tickFishFeeding() {
        if (this.fed) {
            this.feedTimer++;
            if (this.feedTimer >= 400) {
                this.spawnAtLocation(ModItems.ITEM_ORGANIC_SHADOW_MATTER.get(), 1);
                this.fed = false;
                this.targetPos = null;
                this.feedTimer = 0;
            }
            return;
        }

        this.recentFood--;
        if (this.targetPos != null && this.recentFood > 0) {
            swimToward(Vec3.atCenterOf(this.targetPos), 0.18D);
        }
        if (this.tickCount % 20 == 19 && this.recentFood > 0) {
            findAndEatFishChow();
        }
    }

    private void findAndEatFishChow() {
        int radius = 3;
        for (BlockPos pos : BlockPos.betweenClosed(this.blockPosition().offset(-radius, -radius, -radius),
                this.blockPosition().offset(radius, radius, radius))) {
            if (this.level().getBlockState(pos).is(ModBlocks.FISH_CHOW.get())) {
                this.level().removeBlock(pos, false);
                this.targetPos = null;
                this.fed = true;
                this.level().playSound(null, this.blockPosition(), SoundEvents.GENERIC_EAT, SoundSource.HOSTILE, 1.5F, 1.0F);
                return;
            }
        }
    }

    private void shockNearbyPlayers() {
        this.level().playSound(null, this.blockPosition(), SoundEvents.LIGHTNING_BOLT_THUNDER, SoundSource.HOSTILE, 1.75F,
                0.8F + this.random.nextFloat() * 0.4F);
        for (Player player : this.level().getEntitiesOfClass(Player.class, this.getBoundingBox().inflate(8.0D))) {
            player.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 300, 0));
            player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 120, 0));
        }
    }

    private void swimToward(Vec3 target, double speed) {
        Vec3 delta = target.subtract(this.position());
        if (delta.lengthSqr() > 0.01D) {
            this.setDeltaMovement(this.getDeltaMovement().scale(0.82D).add(delta.normalize().scale(speed)));
        }
    }

    private void shootAt(LivingEntity target, float damage, float velocity) {
        LostCombatProjectile projectile = new LostCombatProjectile(this.level(), this, damage);
        projectile.setPos(this.getX(), this.getY() + this.getBbHeight() * 0.5D, this.getZ());
        double dx = target.getX() - this.getX();
        double dy = target.getEyeY() - projectile.getY();
        double dz = target.getZ() - this.getZ();
        projectile.shoot(dx, dy, dz, velocity, 0.0F);
        this.level().addFreshEntity(projectile);
    }

    @Override
    public boolean doHurtTarget(Entity target) {
        boolean hurt = super.doHurtTarget(target);
        if (target instanceof LivingEntity living) {
            float percent = switch (this.kind) {
                case CRABULON -> 0.75F;
                case RIBSHARK -> 0.4F;
                case OCTOBRELLA -> 0.25F;
                case EELSHARK, SEA_SERPENT, LEVIATHAN -> 0.10F;
                default -> 0.0F;
            };
            if (percent > 0.0F) {
                hurt |= living.hurt(this.damageSources().mobAttack(this), Math.max(1.0F, living.getMaxHealth() * percent));
            }
        }
        return hurt;
    }

    @Override
    public InteractionResult mobInteract(Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);
        if (this.kind == Kind.OCTOBRELLA && stack.is(ModItems.ITEM_DEVIANTEGG.get())) {
            if (!this.level().isClientSide()) {
                giveUniquePearl(player, ModItems.ITEM_PEARL_TWILIGHT.get(), "A strange magical property in the pearl prevents you from collecting another.");
            }
            if (!player.getAbilities().instabuild) {
                stack.shrink(1);
            }
            return InteractionResult.sidedSuccess(this.level().isClientSide());
        }
        if (isFish() && stack.is(ModItems.BLOCK_ITEM_FISH_CHOW.get())) {
            this.targetPos = this.blockPosition();
            this.recentFood = 120;
            return InteractionResult.sidedSuccess(this.level().isClientSide());
        }
        return super.mobInteract(player, hand);
    }

    @Override
    protected void dropCustomDeathLoot(net.minecraft.world.damagesource.DamageSource source, int looting, boolean recentlyHit) {
        super.dropCustomDeathLoot(source, looting, recentlyHit);
        if (this.kind == Kind.GLOWFISH && !this.level().isClientSide()) {
            Player player = this.level().getNearestPlayer(this, 15.0D);
            if (player != null) {
                giveUniquePearl(player, ModItems.ITEM_PEARL_BIOLUMINESCENT.get(),
                        "A strange magical property in the pearl prevents you from collecting another.");
            }
        }
    }

    private void giveUniquePearl(Player player, net.minecraft.world.item.Item item, String duplicateMessage) {
        if (player.getInventory().contains(new ItemStack(item))) {
            player.displayClientMessage(Component.literal(duplicateMessage), true);
            return;
        }
        player.getInventory().add(new ItemStack(item));
    }

    @Override
    public boolean canDrownInFluidType(net.minecraftforge.fluids.FluidType type) {
        return false;
    }

    @Override
    public boolean causeFallDamage(float distance, float damageMultiplier, net.minecraft.world.damagesource.DamageSource source) {
        return false;
    }

    private boolean isFish() {
        return this.kind == Kind.LONGFIN || this.kind == Kind.DOUBLERANG || this.kind == Kind.RAYFISH || this.kind == Kind.GLOWFISH
                || this.kind == Kind.UNDERFIN;
    }

    private boolean isHostile() {
        return this.kind == Kind.OCTOBRELLA || this.kind == Kind.EELSHARK || this.kind == Kind.RIBSHARK || this.kind == Kind.CRABULON
                || this.kind == Kind.SEA_SERPENT || this.kind == Kind.LEVIATHAN;
    }

    private double speedForKind() {
        return switch (this.kind) {
            case RIBSHARK, EELSHARK -> 0.12D;
            case CRABULON, SEA_SERPENT, LEVIATHAN -> 0.10D;
            case OCTOBRELLA -> 0.09D;
            default -> 0.07D;
        };
    }

    public int getVisualStyle() {
        return this.visualStyle;
    }

    @Override
    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putInt(VISUAL_STYLE_TAG, this.visualStyle);
        tag.putBoolean(FED_TAG, this.fed);
        tag.putInt(FEED_TIMER_TAG, this.feedTimer);
        tag.putInt(RECENT_FOOD_TAG, this.recentFood);
        tag.putBoolean(HAS_TARGET_TAG, this.targetPos != null);
        if (this.targetPos != null) {
            tag.putInt(TARGET_X_TAG, this.targetPos.getX());
            tag.putInt(TARGET_Y_TAG, this.targetPos.getY());
            tag.putInt(TARGET_Z_TAG, this.targetPos.getZ());
        }
    }

    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        this.visualStyle = tag.getInt(VISUAL_STYLE_TAG);
        this.fed = tag.getBoolean(FED_TAG);
        this.feedTimer = tag.getInt(FEED_TIMER_TAG);
        this.recentFood = tag.getInt(RECENT_FOOD_TAG);
        if (tag.getBoolean(HAS_TARGET_TAG)) {
            this.targetPos = new BlockPos(tag.getInt(TARGET_X_TAG), tag.getInt(TARGET_Y_TAG), tag.getInt(TARGET_Z_TAG));
        }
    }
}
