/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.client.model.ModelBiped
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.inventory.EntityEquipmentSlot
 *  net.minecraft.item.Item
 *  net.minecraft.item.ArmorItem
 *  net.minecraft.item.ArmorItem$ArmorMaterial
 *  net.minecraft.item.ItemStack
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package xol.lostinfinity.item.armor;

import javax.annotation.Nullable;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.init.TabsInit;
import xol.lostinfinity.item.armor.model.ModelArmorFiltrationMask;

public class ItemFiltrationMask
extends ArmorItem {
    public ItemFiltrationMask(ArmorItem.ArmorMaterial mat, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn, String regName) {
        super(mat, renderIndexIn, equipmentSlotIn);
        this.func_77637_a(TabsInit.TAB_AUXMATS);
        this.setRegistryName(regName);
        this.func_77655_b(regName);
        ItemInit.ITEMS.add((Item)this);
    }

    public String getArmorTexture(ItemStack itemstack, Entity entity, EntityEquipmentSlot slot, String layer) {
        return "lostinfinity:textures/armor/filtration_mask.png";
    }

    @SideOnly(value=Side.CLIENT)
    @Nullable
    public ModelBiped getArmorModel(LivingEntity entityLiving, ItemStack itemStack, EntityEquipmentSlot armorSlot, ModelBiped _default) {
        if (!itemStack.func_190926_b() && itemStack.func_77973_b() instanceof ArmorItem) {
            ModelArmorFiltrationMask guard = new ModelArmorFiltrationMask();
            guard.field_78116_c.field_78806_j = armorSlot == EntityEquipmentSlot.HEAD;
            guard.field_78091_s = _default.field_78091_s;
            guard.field_78117_n = _default.field_78117_n;
            guard.field_78093_q = _default.field_78093_q;
            guard.field_187075_l = _default.field_187075_l;
            guard.field_187076_m = _default.field_187076_m;
            return guard;
        }
        return null;
    }
}

