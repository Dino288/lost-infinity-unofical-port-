package xol.lostinfinity.item;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.Level;

public class LostShovelItem extends ShovelItem {
    private final String itemName;

    public LostShovelItem(String itemName, Tier tier, float attackDamageModifier, float attackSpeedModifier, Properties properties) {
        super(tier, attackDamageModifier, attackSpeedModifier, properties);
        this.itemName = itemName;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);
        if (!level.isClientSide()) {
            if (LostItemBehavior.useModeEnergyItem(itemName, stack, level, player, hand)) {
                return InteractionResultHolder.success(stack);
            }
            player.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 160, 0, true, false));
            player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 120, 0, true, false));
            player.getCooldowns().addCooldown(this, 140);
        }
        return InteractionResultHolder.sidedSuccess(stack, level.isClientSide());
    }
}
