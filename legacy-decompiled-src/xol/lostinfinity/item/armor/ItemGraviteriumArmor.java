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
import xol.lostinfinity.item.armor.model.ModelArmorGraviterium;

public class ItemGraviteriumArmor
extends ItemLostArmor {
    private static final ArmorItem.ArmorMaterial graviteriumMaterial = EnumHelper.addArmorMaterial((String)"graviteriumArmor", (String)"lostinfinity:graviterium_armor", (int)-1, (int[])new int[]{12, 24, 32, 12}, (int)20, (SoundEvent)SoundEvents.field_187716_o, (float)3.0f);

    public ItemGraviteriumArmor(String regName, EntityEquipmentSlot slot) {
        super(graviteriumMaterial, regName, slot);
    }

    @Override
    protected void handleSpecialArmorBonus(Player player) {
        Level world = player.field_70170_p;
        if (!world.field_72995_K && player.field_70173_aa % 5 == 0 && player.func_110144_aD() != null) {
            LivingEntity entity = player.func_110144_aD();
            if (player.field_70173_aa - player.func_142013_aG() < 200 && entity.func_70032_d((Entity)player) > 7.0f && entity.func_70104_M()) {
                entity.func_70024_g(Math.signum(player.field_70165_t - entity.field_70165_t) * 0.5, Math.signum(player.field_70163_u - entity.field_70163_u) * 0.6, Math.signum(player.field_70161_v - entity.field_70161_v) * 0.5);
                entity.field_70133_I = true;
            }
        }
    }

    @Override
    public ArmorInit.ArmorSet getArmorSet() {
        return ArmorInit.graviteriumSet;
    }

    @Override
    public boolean isPrimeSet() {
        return false;
    }

    public String getArmorTexture(ItemStack itemstack, Entity entity, EntityEquipmentSlot slot, String layer) {
        return "lostinfinity:textures/armor/graviterium_armor.png";
    }

    @SideOnly(value=Side.CLIENT)
    @Nullable
    public ModelBiped getArmorModel(LivingEntity entityLiving, ItemStack itemStack, EntityEquipmentSlot armorSlot, ModelBiped _default) {
        if (!itemStack.func_190926_b() && itemStack.func_77973_b() instanceof ItemGraviteriumArmor) {
            ModelArmorGraviterium vamp = new ModelArmorGraviterium();
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
        tooltip.add((Object)((Object)TextFmt.Red) + "Enemies you attack with melee hits are marked for 10s.");
        tooltip.add((Object)((Object)TextFmt.Red) + "Marked enemies are pulled towards you if they get too far.");
    }
}

