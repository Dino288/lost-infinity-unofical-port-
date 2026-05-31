/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.client.model.ModelBiped
 *  net.minecraft.client.util.ITooltipFlag
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.init.SoundEvents
 *  net.minecraft.inventory.EntityEquipmentSlot
 *  net.minecraft.item.ArmorItem$ArmorMaterial
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.SoundEvent
 *  net.minecraft.world.World
 *  net.minecraftforge.common.util.EnumHelper
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package xol.lostinfinity.item.armor;

import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.ArmorInit;
import xol.lostinfinity.item.armor.ItemLostArmor;
import xol.lostinfinity.item.armor.model.ModelArmorVampyreon;
import xol.lostinfinity.util.data.IMaxAttack;

public class ItemVampyreonArmor
extends ItemLostArmor {
    private static final ArmorItem.ArmorMaterial vampyreanMaterial = EnumHelper.addArmorMaterial((String)"vampyreonArmor", (String)"lostinfinity:vampyreon_armor", (int)-1, (int[])new int[]{12, 24, 32, 12}, (int)20, (SoundEvent)SoundEvents.field_187716_o, (float)3.0f);

    public ItemVampyreonArmor(String regName, EntityEquipmentSlot slot) {
        super(vampyreanMaterial, regName, slot);
    }

    @Override
    protected void handleSpecialArmorBonus(Player player) {
        Level world = player.field_70170_p;
        if (!world.field_72995_K && player.field_70173_aa % 10 == 0) {
            int leeched = 0;
            List entities = player.field_70170_p.func_72872_a(Player.class, player.func_174813_aQ().func_72314_b(4.0, 4.0, 4.0));
            for (Player e : entities) {
                if (e.equals((Object)player)) continue;
                ++leeched;
                IMaxAttack.dealMaxHealth((Entity)player, (LivingEntity)e, 20);
            }
            if (leeched > 0) {
                player.func_70691_i(Math.min((float)leeched * (player.func_110138_aP() / 50.0f), player.func_110138_aP() / 10.0f));
            }
        }
    }

    @Override
    public ArmorInit.ArmorSet getArmorSet() {
        return ArmorInit.vampyreonSet;
    }

    @Override
    public boolean isPrimeSet() {
        return false;
    }

    public String getArmorTexture(ItemStack itemstack, Entity entity, EntityEquipmentSlot slot, String layer) {
        return "lostinfinity:textures/armor/vampyreon_armor.png";
    }

    @SideOnly(value=Side.CLIENT)
    @Nullable
    public ModelBiped getArmorModel(LivingEntity entityLiving, ItemStack itemStack, EntityEquipmentSlot armorSlot, ModelBiped _default) {
        if (!itemStack.func_190926_b() && itemStack.func_77973_b() instanceof ItemVampyreonArmor) {
            ModelArmorVampyreon vamp = new ModelArmorVampyreon();
            vamp.field_78116_c.field_78806_j = armorSlot == EntityEquipmentSlot.HEAD;
            vamp.field_78115_e.field_78806_j = armorSlot == EntityEquipmentSlot.CHEST;
            vamp.field_178724_i.field_78806_j = armorSlot == EntityEquipmentSlot.CHEST;
            vamp.field_178723_h.field_78806_j = armorSlot == EntityEquipmentSlot.CHEST;
            vamp.field_178722_k.field_78806_j = armorSlot == EntityEquipmentSlot.LEGS;
            vamp.field_178721_j.field_78806_j = armorSlot == EntityEquipmentSlot.LEGS;
            vamp.field_178720_f.field_78807_k = true;
            vamp.field_78091_s = _default.field_78091_s;
            vamp.field_78117_n = _default.field_78117_n;
            vamp.field_78093_q = _default.field_78093_q;
            vamp.field_187075_l = _default.field_187075_l;
            vamp.field_187076_m = _default.field_187076_m;
            return vamp;
        }
        return null;
    }

    @SideOnly(value=Side.CLIENT)
    public void func_77624_a(ItemStack stack, @Nullable Level worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add((Object)((Object)TextFmt.Gold) + "Immune to normal hits.");
        tooltip.add((Object)((Object)TextFmt.Green) + "2% Max HP Damage Reduction Per Piece");
        tooltip.add((Object)((Object)TextFmt.Bold) + "Set Bonuses:");
        tooltip.add((Object)((Object)TextFmt.Green) + "+7% Max HP Damage Reduction");
        tooltip.add((Object)((Object)TextFmt.Red) + "Steal max life constantly from nearby players.");
    }
}

