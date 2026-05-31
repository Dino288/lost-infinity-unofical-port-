/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.player.Player
 *  net.minecraft.entity.player.PlayerCapabilities
 *  net.minecraft.inventory.EntityEquipmentSlot
 *  net.minecraft.item.ArmorItem
 *  net.minecraft.item.ArmorItem$ArmorMaterial
 *  net.minecraft.item.ItemStack
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.potion.Potion
 *  net.minecraft.potion.PotionEffect
 *  net.minecraft.world.World
 *  net.minecraftforge.fml.common.ObfuscationReflectionHelper
 */
package xol.lostinfinity.item.armor;

import java.lang.reflect.Field;
import java.util.List;
import java.util.stream.Collectors;
import net.minecraft.world.entity.player.Player;
import net.minecraft.entity.player.PlayerCapabilities;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import xol.lostinfinity.init.ArmorInit;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.init.PotionInit;
import xol.lostinfinity.init.TabsInit;
import xol.lostinfinity.util.ConfigurationHandler;
import xol.lostinfinity.util.data.IMaxAttack;
import xol.lostinfinity.util.player.PlayerManager;

public abstract class ItemLostArmor
extends ArmorItem
implements IMaxAttack {
    private static final Field FLY_SPEED = ObfuscationReflectionHelper.findField(PlayerCapabilities.class, (String)"field_75096_f");

    public ItemLostArmor(ArmorItem.ArmorMaterial material, String regName, EntityEquipmentSlot slot) {
        super(material, 0, slot);
        this.func_77637_a(TabsInit.TAB_ARMORS);
        this.setRegistryName(regName);
        this.func_77655_b(regName);
        ItemInit.ARMORS.add(this);
    }

    public abstract boolean isPrimeSet();

    public abstract ArmorInit.ArmorSet getArmorSet();

    public boolean isArmorActive(Player player, ItemStack itemStack) {
        if (player.func_70644_a(PotionInit.NULLIFIED)) {
            return false;
        }
        boolean hasSet = PlayerManager.isPlayerWearingFullSet(player, this.getArmorSet());
        if (hasSet && this.equals(this.getArmorSet().helmet)) {
            CompoundTag tag;
            if (itemStack.func_77978_p() == null) {
                itemStack.func_77982_d(new CompoundTag());
            }
            if (!(tag = itemStack.func_77978_p()).func_74764_b("setBonus") || tag.func_74767_n("setBonus")) {
                return true;
            }
        }
        return false;
    }

    public void onArmorTick(Level world, Player player, ItemStack itemStack) {
        boolean armorActive = this.isArmorActive(player, itemStack);
        if (armorActive) {
            this.handleSpecialArmorBonus(player);
        }
        if (!world.field_72995_K && !player.func_70644_a(PotionInit.NULLIFIED)) {
            player.func_70690_d(new PotionEffect(PotionInit.ARMORED, 10, 0, true, false));
        }
    }

    private static void setPlayerFlySpeed(Player player, float newSpeed) {
        try {
            FLY_SPEED.setFloat(player.field_71075_bZ, newSpeed);
        }
        catch (IllegalAccessException ignored) {
            throw new RuntimeException("Failed to modify player fly speed!");
        }
    }

    public static void handleStandardArmorBonus(Player player, boolean enable) {
        if (enable) {
            if (player.func_70644_a(PotionInit.ARMORED)) {
                if (ConfigurationHandler.armor_flight) {
                    ItemLostArmor.setPlayerFlySpeed(player, 0.2f);
                    player.field_71075_bZ.field_75101_c = true;
                }
                player.field_70138_W = 2.0f;
                player.func_71024_bL().func_75122_a(20, 20.0f);
                List potionList = player.func_70651_bq().stream().map(PotionEffect::func_188419_a).filter(Potion::func_76398_f).collect(Collectors.toList());
                for (Potion potion : potionList) {
                    player.func_184589_d(potion);
                }
            }
        } else if (player.func_70644_a(PotionInit.ARMORED)) {
            player.field_70138_W = 0.6f;
            if (ConfigurationHandler.armor_flight) {
                player.field_71075_bZ.field_75101_c = player.func_184812_l_();
                player.field_71075_bZ.field_75100_b = player.func_184812_l_();
                ItemLostArmor.setPlayerFlySpeed(player, 0.05f);
            }
        }
    }

    protected abstract void handleSpecialArmorBonus(Player var1);

    static {
        FLY_SPEED.setAccessible(true);
    }
}

