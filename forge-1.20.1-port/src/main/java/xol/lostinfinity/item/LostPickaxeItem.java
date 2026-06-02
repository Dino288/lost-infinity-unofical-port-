package xol.lostinfinity.item;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class LostPickaxeItem extends PickaxeItem {
    private final String itemName;

    public LostPickaxeItem(String itemName, Tier tier, int attackDamageModifier, float attackSpeedModifier, Properties properties) {
        super(tier, attackDamageModifier, attackSpeedModifier, properties);
        this.itemName = itemName;
    }

    @Override
    public boolean mineBlock(ItemStack stack, Level level, BlockState state, BlockPos pos, LivingEntity miner) {
        if (!level.isClientSide() && miner instanceof Player player) {
            if (itemName.contains("celestial")) {
                player.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 120, 1, true, false));
                player.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 260, 0, true, false));
            } else if (itemName.contains("crystal")) {
                player.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 80, 0, true, false));
            } else if (itemName.contains("nightmare")) {
                player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 80, 0, true, false));
            }
        }
        return super.mineBlock(stack, level, state, pos, miner);
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        LostItemBehavior.onWeaponHit(itemName, stack, target, attacker);
        if (itemName.contains("forgefire")) {
            target.setSecondsOnFire(6);
        } else if (itemName.contains("nightmare")) {
            target.addEffect(new MobEffectInstance(MobEffects.DARKNESS, 120, 0));
            target.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 120, 0));
        }
        return super.hurtEnemy(stack, target, attacker);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);
        if (!level.isClientSide()) {
            if (LostItemBehavior.useModeEnergyItem(itemName, stack, level, player, hand)) {
                return InteractionResultHolder.success(stack);
            }
            if (itemName.contains("forgefire")) {
                player.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 240, 0, true, false));
                player.getCooldowns().addCooldown(this, 160);
            } else if (itemName.contains("nightmare")) {
                player.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 300, 0, true, false));
                player.getCooldowns().addCooldown(this, 160);
            } else {
                player.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 160, 0, true, false));
                player.getCooldowns().addCooldown(this, 120);
            }
        }
        return InteractionResultHolder.sidedSuccess(stack, level.isClientSide());
    }
}
