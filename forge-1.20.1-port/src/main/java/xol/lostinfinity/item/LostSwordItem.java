package xol.lostinfinity.item;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.Level;

public class LostSwordItem extends SwordItem {
    private final String itemName;

    public LostSwordItem(String itemName, Tier tier, int attackDamageModifier, float attackSpeedModifier, Properties properties) {
        super(tier, attackDamageModifier, attackSpeedModifier, properties);
        this.itemName = itemName;
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        LostItemBehavior.onWeaponHit(itemName, stack, target, attacker);
        if (itemName.contains("starfire") || itemName.contains("solar") || itemName.contains("fire")) {
            target.setSecondsOnFire(6);
        }
        if (itemName.contains("dead") || itemName.contains("nightmare") || itemName.contains("insanity")) {
            target.addEffect(new MobEffectInstance(MobEffects.WITHER, 100, 0));
        }
        if (itemName.contains("phantom") || itemName.contains("spectros")) {
            target.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 100, 1));
        }
        if (attacker instanceof Player player && (itemName.contains("vamp") || itemName.contains("dead"))) {
            player.heal(1.0F);
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
            if (itemName.contains("phantom") || itemName.contains("spectros")) {
                player.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 120, 0, true, false));
            } else if (itemName.contains("eternity") || itemName.contains("infinity") || itemName.contains("multiversal")) {
                player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 160, 1, true, false));
                player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 160, 0, true, false));
            } else {
                player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 120, 0, true, false));
            }
            player.getCooldowns().addCooldown(this, 180);
        }
        return InteractionResultHolder.sidedSuccess(stack, level.isClientSide());
    }
}
