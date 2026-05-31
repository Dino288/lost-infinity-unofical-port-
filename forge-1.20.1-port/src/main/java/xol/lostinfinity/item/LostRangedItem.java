package xol.lostinfinity.item;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import xol.lostinfinity.entity.LostCombatProjectile;

public class LostRangedItem extends Item {
    private final float velocity;
    private final int cooldownTicks;
    private final float damage;

    public LostRangedItem(Properties properties, float velocity, int cooldownTicks, float damage) {
        super(properties);
        this.velocity = velocity;
        this.cooldownTicks = cooldownTicks;
        this.damage = damage;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);
        level.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.FIRECHARGE_USE, SoundSource.PLAYERS, 0.5F, 1.15F);

        if (!level.isClientSide()) {
            LostCombatProjectile projectile = new LostCombatProjectile(level, player, damage);
            ItemStack projectileStack = stack.copy();
            projectileStack.setCount(1);
            projectile.setItem(projectileStack);
            projectile.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, velocity, 0.8F);
            level.addFreshEntity(projectile);

            if (!player.getAbilities().instabuild) {
                stack.hurtAndBreak(1, player, owner -> owner.broadcastBreakEvent(hand));
            }
        }

        player.getCooldowns().addCooldown(this, cooldownTicks);
        return InteractionResultHolder.sidedSuccess(stack, level.isClientSide());
    }
}
