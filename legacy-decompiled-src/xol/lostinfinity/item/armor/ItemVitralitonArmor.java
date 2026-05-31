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
 *  net.minecraft.util.EnumParticleTypes
 *  net.minecraft.util.SoundEvent
 *  net.minecraft.world.World
 *  net.minecraft.world.ServerLevel
 *  net.minecraftforge.common.util.EnumHelper
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package xol.lostinfinity.item.armor;

import java.util.List;
import java.util.Random;
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
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.level.Level;
import net.minecraft.server.level.ServerLevel;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.ArmorInit;
import xol.lostinfinity.item.armor.ItemLostArmor;
import xol.lostinfinity.item.armor.model.ModelArmorVitraliton;

public class ItemVitralitonArmor
extends ItemLostArmor {
    private static final ArmorItem.ArmorMaterial VitralitonMaterial = EnumHelper.addArmorMaterial((String)"vitralitonArmor", (String)"lostinfinity:vitraliton_armor", (int)-1, (int[])new int[]{12, 24, 32, 12}, (int)20, (SoundEvent)SoundEvents.field_187716_o, (float)3.0f);

    public ItemVitralitonArmor(String regName, EntityEquipmentSlot slot) {
        super(VitralitonMaterial, regName, slot);
    }

    @Override
    protected void handleSpecialArmorBonus(Player player) {
        Level world = player.field_70170_p;
        if (!world.field_72995_K && player.field_70173_aa % 5 == 0) {
            float player_health = player.func_110143_aJ();
            float player_max = player.func_110138_aP();
            float percentage_health = player_health / player_max * 100.0f;
            int incremented_multiplier = (int)Math.round(Math.floor((100.0f - percentage_health) / 20.0f));
            float heal_amount = (float)incremented_multiplier * player.func_110138_aP() / 100.0f;
            player.func_70691_i(heal_amount);
            if (incremented_multiplier > 0) {
                ((ServerLevel)world).func_175739_a(EnumParticleTypes.HEART, player.field_70165_t, player.field_70163_u, player.field_70161_v, incremented_multiplier, this.randPosDouble(world.field_73012_v), 1.0, this.randPosDouble(world.field_73012_v), (double)0.15f, new int[0]);
            }
        }
    }

    private double randPosDouble(Random rand) {
        return -0.5 + rand.nextDouble();
    }

    @Override
    public boolean isPrimeSet() {
        return false;
    }

    @Override
    public ArmorInit.ArmorSet getArmorSet() {
        return ArmorInit.vitralitonSet;
    }

    public String getArmorTexture(ItemStack itemstack, Entity entity, EntityEquipmentSlot slot, String layer) {
        return "lostinfinity:textures/armor/vitraliton_armor.png";
    }

    @SideOnly(value=Side.CLIENT)
    @Nullable
    public ModelBiped getArmorModel(LivingEntity entityLiving, ItemStack itemStack, EntityEquipmentSlot armorSlot, ModelBiped _default) {
        if (!itemStack.func_190926_b() && itemStack.func_77973_b() instanceof ItemVitralitonArmor) {
            ModelArmorVitraliton vamp = new ModelArmorVitraliton();
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
        tooltip.add((Object)((Object)TextFmt.Gold) + "Immune to Normal Hits.");
        tooltip.add((Object)((Object)TextFmt.Green) + "2% Max HP Damage Reduction Per Piece");
        tooltip.add((Object)((Object)TextFmt.Bold) + "Set Bonuses:");
        tooltip.add((Object)((Object)TextFmt.Green) + "+7% Max HP Damage Reduction");
        tooltip.add((Object)((Object)TextFmt.Green) + "Increased % Health Regeneration Based on Missing Health");
    }
}

