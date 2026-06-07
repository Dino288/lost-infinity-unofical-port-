package xol.lostinfinity.item;

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
import xol.lostinfinity.effect.LostFx;

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
        LostFx.play(level, player.blockPosition(), rangedSound(), SoundSource.PLAYERS, 0.55F, rangedPitch());
        LostFx.burst(level, player.blockPosition(), rangedParticle(), 8, 0.25D, 0.02D);

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

    private String rangedSound() {
        if (itemName.contains("laser") || itemName.contains("beamer") || itemName.contains("rifle")) return "laser_weapon_10";
        if (itemName.contains("sound") || itemName.contains("sonic") || itemName.contains("echo")) return "sound_gun";
        if (itemName.contains("rocket") || itemName.contains("missile")) return "missile_launch";
        if (itemName.contains("bow")) return itemName.contains("space") || itemName.contains("galactic") ? "space_bow" : "generic_weapon_23";
        if (itemName.contains("zapper") || itemName.contains("tesla") || itemName.contains("shock")) return "electric_bounce";
        if (itemName.contains("magic") || itemName.contains("wand") || itemName.contains("spell")) return "magic_weapon_10";
        if (itemName.contains("plasma") || itemName.contains("cosmic") || itemName.contains("galaxy")) return "cosmic_explosion";
        return "magic_weapon_5";
    }

    private String rangedParticle() {
        if (itemName.contains("laser") || itemName.contains("beamer") || itemName.contains("rifle")) return "laser_fizzle";
        if (itemName.contains("sound") || itemName.contains("sonic") || itemName.contains("echo")) return "supersonic_blue";
        if (itemName.contains("rocket") || itemName.contains("missile")) return "plasma";
        if (itemName.contains("zapper") || itemName.contains("tesla") || itemName.contains("shock")) return "electric_explosion_blue";
        if (itemName.contains("magic") || itemName.contains("wand") || itemName.contains("spell")) return "ancient_spell";
        if (itemName.contains("plasma")) return "plasma";
        if (itemName.contains("cosmic") || itemName.contains("galaxy") || itemName.contains("space")) return "space_magic";
        return "small_spark";
    }

    private float rangedPitch() {
        if (itemName.contains("rocket") || itemName.contains("missile")) return 0.85F;
        if (itemName.contains("laser") || itemName.contains("zapper")) return 1.35F;
        if (itemName.contains("bow")) return 1.15F;
        return 1.05F;
    }
}
