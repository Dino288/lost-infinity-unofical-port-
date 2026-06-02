package xol.lostinfinity.item;

import java.util.Locale;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import xol.lostinfinity.LostInfinity;

@Mod.EventBusSubscriber(modid = LostInfinity.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public final class LostArmorEffects {
    private LostArmorEffects() {
    }

    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if (event.phase != TickEvent.Phase.END || !(event.player instanceof ServerPlayer player)) {
            return;
        }
        String set = fullArmorSet(player);
        if (set.isEmpty() || player.tickCount % 40 != 0) {
            return;
        }

        boolean prime = set.contains("prime");
        if (set.contains("vampyreon")) {
            add(player, MobEffects.REGENERATION, prime ? 1 : 0);
            add(player, MobEffects.DAMAGE_BOOST, 0);
        } else if (set.contains("graviterium")) {
            add(player, MobEffects.SLOW_FALLING, 0);
            add(player, MobEffects.JUMP, prime ? 2 : 1);
        } else if (set.contains("plasmythic")) {
            add(player, MobEffects.FIRE_RESISTANCE, 0);
            add(player, MobEffects.MOVEMENT_SPEED, 0);
        } else if (set.contains("spectros")) {
            add(player, MobEffects.NIGHT_VISION, 0);
            add(player, MobEffects.INVISIBILITY, prime ? 0 : -1);
        } else if (set.contains("blightcyst")) {
            add(player, MobEffects.DAMAGE_RESISTANCE, prime ? 1 : 0);
            add(player, MobEffects.REGENERATION, 0);
        } else if (set.contains("bionic_veggitron")) {
            add(player, MobEffects.SATURATION, 0);
            add(player, MobEffects.REGENERATION, prime ? 1 : 0);
        } else if (set.contains("vitraliton")) {
            add(player, MobEffects.ABSORPTION, prime ? 1 : 0);
            add(player, MobEffects.DAMAGE_RESISTANCE, 0);
        } else if (set.contains("celestial")) {
            add(player, MobEffects.SLOW_FALLING, 0);
            add(player, MobEffects.NIGHT_VISION, 0);
        }
    }

    @SubscribeEvent
    public static void onLivingDamage(LivingDamageEvent event) {
        if (event.getSource().getEntity() instanceof Player attacker) {
            String attackSet = fullArmorSet(attacker);
            if (attackSet.contains("vampyreon")) {
                attacker.heal(event.getAmount() * (attackSet.contains("prime") ? 0.18F : 0.10F));
            }
            if (attackSet.contains("spectros")) {
                event.getEntity().addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 100, attackSet.contains("prime") ? 1 : 0));
            }
            if (attackSet.contains("blightcyst")) {
                event.getEntity().addEffect(new MobEffectInstance(MobEffects.POISON, 100, attackSet.contains("prime") ? 1 : 0));
            }
            if (attackSet.contains("bionic_veggitron")) {
                event.setAmount(event.getAmount() + (attackSet.contains("prime") ? 3.0F : 1.5F));
            }
        }

        if (event.getEntity() instanceof Player target) {
            String targetSet = fullArmorSet(target);
            LivingEntity attacker = event.getSource().getEntity() instanceof LivingEntity living ? living : null;
            if (attacker != null) {
                for (EquipmentSlot slot : new EquipmentSlot[] { EquipmentSlot.HEAD, EquipmentSlot.CHEST, EquipmentSlot.LEGS, EquipmentSlot.FEET }) {
                    ItemStack armor = target.getItemBySlot(slot);
                    String itemName = armorItemName(armor);
                    if (!itemName.isEmpty()) {
                        LostItemBehavior.onArmorHurt(itemName, armor, target, attacker);
                    }
                }
            }
            if (targetSet.contains("plasmythic") && attacker != null) {
                attacker.setSecondsOnFire(targetSet.contains("prime") ? 8 : 4);
            }
            if (targetSet.contains("graviterium")) {
                event.setAmount(event.getAmount() * (targetSet.contains("prime") ? 0.72F : 0.84F));
            }
            if (targetSet.contains("vitraliton")) {
                target.heal(targetSet.contains("prime") ? 1.5F : 0.75F);
            }
        }
    }

    private static void add(Player player, net.minecraft.world.effect.MobEffect effect, int amplifier) {
        if (amplifier >= 0) {
            player.addEffect(new MobEffectInstance(effect, 100, amplifier, true, false));
        }
    }

    private static String fullArmorSet(Player player) {
        String head = armorSetName(player.getItemBySlot(EquipmentSlot.HEAD));
        if (head.isEmpty()) {
            return "";
        }
        String chest = armorSetName(player.getItemBySlot(EquipmentSlot.CHEST));
        String legs = armorSetName(player.getItemBySlot(EquipmentSlot.LEGS));
        String feet = armorSetName(player.getItemBySlot(EquipmentSlot.FEET));
        return head.equals(chest) && head.equals(legs) && head.equals(feet) ? head : "";
    }

    private static String armorSetName(ItemStack stack) {
        if (stack.isEmpty()) {
            return "";
        }
        ResourceLocation id = stack.getItem().builtInRegistryHolder().key().location();
        if (!LostInfinity.MODID.equals(id.getNamespace())) {
            return "";
        }
        String path = id.getPath().toLowerCase(Locale.ROOT);
        for (String suffix : new String[] { "_helmet", "_headguard", "_mask", "_chestplate", "_leggings", "_boots" }) {
            if (path.endsWith(suffix)) {
                return path.substring(0, path.length() - suffix.length());
            }
        }
        if (path.endsWith("helmet")) {
            return path.substring(0, path.length() - "helmet".length());
        }
        if (path.endsWith("headguard")) {
            return path.substring(0, path.length() - "headguard".length());
        }
        if (path.endsWith("mask")) {
            return path.substring(0, path.length() - "mask".length());
        }
        return "";
    }

    private static String armorItemName(ItemStack stack) {
        if (stack.isEmpty()) {
            return "";
        }
        ResourceLocation id = stack.getItem().builtInRegistryHolder().key().location();
        return LostInfinity.MODID.equals(id.getNamespace()) ? id.getPath().toLowerCase(Locale.ROOT) : "";
    }
}
