package xol.lostinfinity.item;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import java.util.List;
import org.jetbrains.annotations.Nullable;

public class LostRangedItem extends Item {
    private final String itemName;
    private final float velocity;
    private final int cooldownTicks;
    private final float damage;

    public LostRangedItem(String itemName, Properties properties, float velocity, int cooldownTicks, float damage) {
        super(properties);
        this.itemName = itemName;
        this.velocity = velocity;
        this.cooldownTicks = cooldownTicks;
        this.damage = damage;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);
        level.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.FIRECHARGE_USE, SoundSource.PLAYERS, 0.5F, 1.15F);

        if (!level.isClientSide()) {
            if (!LostItemBehavior.fireRanged(itemName, stack, level, player, hand, velocity, damage)) {
                return InteractionResultHolder.fail(stack);
            }
        }

        player.getCooldowns().addCooldown(this, cooldownTicks);
        return InteractionResultHolder.sidedSuccess(stack, level.isClientSide());
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag flag) {
        LostItemBehavior.appendModeEnergyTooltip(itemName, stack, tooltip);
        super.appendHoverText(stack, level, tooltip, flag);
    }
}
