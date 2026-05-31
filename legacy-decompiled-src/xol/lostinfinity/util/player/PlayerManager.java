/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.player.Player
 *  net.minecraft.inventory.EntityEquipmentSlot
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 */
package xol.lostinfinity.util.player;

import java.util.List;
import net.minecraft.world.entity.player.Player;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import xol.lostinfinity.init.ArmorInit;
import xol.lostinfinity.item.armor.ItemLostArmor;

public class PlayerManager {
    public static boolean isPlayerWearingFullSet(Player player, ArmorInit.ArmorSet set) {
        List equipment = (List)player.func_184193_aE();
        if (((ItemStack)equipment.get(EntityEquipmentSlot.HEAD.func_188454_b())).func_77973_b() != set.helmet) {
            return false;
        }
        if (((ItemStack)equipment.get(EntityEquipmentSlot.CHEST.func_188454_b())).func_77973_b() != set.chestplate) {
            return false;
        }
        if (((ItemStack)equipment.get(EntityEquipmentSlot.LEGS.func_188454_b())).func_77973_b() != set.leggings) {
            return false;
        }
        return ((ItemStack)equipment.get(EntityEquipmentSlot.FEET.func_188454_b())).func_77973_b() == set.boots;
    }

    public static boolean isWearingAnySet(Player playerIn) {
        Item helmet_item = ((ItemStack)playerIn.field_71071_by.field_70460_b.get(3)).func_77973_b();
        if (!(helmet_item instanceof ItemLostArmor)) {
            return false;
        }
        ItemLostArmor helmet = (ItemLostArmor)helmet_item;
        ArmorInit.ArmorSet set = helmet.getArmorSet();
        return PlayerManager.isPlayerWearingFullSet(playerIn, set);
    }
}

