package xol.lostinfinity.item;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.Level;

public class LostAxeItem extends AxeItem {
    private final String itemName;

    public LostAxeItem(String itemName, Tier tier, float attackDamageModifier, float attackSpeedModifier, Properties properties) {
        super(tier, attackDamageModifier, attackSpeedModifier, properties);
        this.itemName = itemName;
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (itemName.contains("forgefire") || itemName.contains("thermo")) {
            target.setSecondsOnFire(8);
        }
        if (itemName.contains("saw")) {
            target.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 100, 0));
        }
        return super.hurtEnemy(stack, target, attacker);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);
        if (!level.isClientSide()) {
            if (itemName.contains("forgefire") || itemName.contains("thermo")) {
                player.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 240, 0, true, false));
            } else {
                player.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 160, 0, true, false));
            }
            player.getCooldowns().addCooldown(this, 140);
        }
        return InteractionResultHolder.sidedSuccess(stack, level.isClientSide());
    }
}
