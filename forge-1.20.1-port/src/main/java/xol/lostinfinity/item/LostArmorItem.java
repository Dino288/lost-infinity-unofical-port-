package xol.lostinfinity.item;

import java.util.List;
import java.util.Locale;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

public class LostArmorItem extends ArmorItem {
    private final String itemName;

    public LostArmorItem(String itemName, ArmorMaterial material, Type type, Properties properties) {
        super(material, type, properties);
        this.itemName = itemName.toLowerCase(Locale.ROOT);
    }

    @Override
    public void inventoryTick(ItemStack stack, Level level, Entity entity, int slot, boolean selected) {
        super.inventoryTick(stack, level, entity, slot, selected);
        if (!level.isClientSide() && entity instanceof Player player && player.getItemBySlot(getEquipmentSlot()) == stack) {
            LostItemBehavior.onArmorTick(itemName, stack, level, player);
        }
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);
        if (!level.isClientSide() && LostItemBehavior.useModeEnergyItem(itemName, stack, level, player, hand)) {
            return InteractionResultHolder.success(stack);
        }
        return super.use(level, player, hand);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag flag) {
        LostItemBehavior.appendModeEnergyTooltip(itemName, stack, tooltip);
        super.appendHoverText(stack, level, tooltip, flag);
    }
}
