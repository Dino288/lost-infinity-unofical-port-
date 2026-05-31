package xol.lostinfinity.item;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Snowball;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class LostRangedItem extends Item {
    private final float velocity;
    private final int cooldownTicks;

    public LostRangedItem(Properties properties, float velocity, int cooldownTicks) {
        super(properties);
        this.velocity = velocity;
        this.cooldownTicks = cooldownTicks;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);
        level.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.FIRECHARGE_USE, SoundSource.PLAYERS, 0.5F, 1.15F);

        if (!level.isClientSide()) {
            Snowball projectile = new Snowball(level, player);
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
