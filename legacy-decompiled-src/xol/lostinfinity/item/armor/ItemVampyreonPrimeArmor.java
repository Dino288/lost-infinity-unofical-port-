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
 *  net.minecraft.util.math.Mth
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
import net.minecraft.util.Mth;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.ArmorInit;
import xol.lostinfinity.init.ParticleInit;
import xol.lostinfinity.item.armor.ItemLostArmor;
import xol.lostinfinity.item.armor.model.ModelArmorVampyreon;
import xol.lostinfinity.mob.entity.base.EntityImmaterial;
import xol.lostinfinity.util.data.CustomParticleConfig;
import xol.lostinfinity.util.data.IMaxAttack;
import xol.lostinfinity.util.fx.IParticleSpawner;

public class ItemVampyreonPrimeArmor
extends ItemLostArmor {
    private static final ArmorItem.ArmorMaterial vampyreanMaterial = EnumHelper.addArmorMaterial((String)"vampyreonprimeArmor", (String)"lostinfinity:vampyreon_prime_armor", (int)-1, (int[])new int[]{12, 24, 32, 12}, (int)20, (SoundEvent)SoundEvents.field_187716_o, (float)3.0f);

    public ItemVampyreonPrimeArmor(String regName, EntityEquipmentSlot slot) {
        super(vampyreanMaterial, regName, slot);
    }

    @Override
    protected void handleSpecialArmorBonus(Player player) {
        Level world = player.field_70170_p;
        if (!world.field_72995_K && player.field_70173_aa % 10 == 0) {
            boolean belowHalf = player.func_110143_aJ() <= player.func_110138_aP() / 2.0f;
            int leeched = 0;
            List entities = player.field_70170_p.func_72872_a(LivingEntity.class, player.func_174813_aQ().func_72314_b(25.0, 15.0, 25.0));
            for (LivingEntity e : entities) {
                if (e.equals((Object)player) || e instanceof EntityImmaterial) continue;
                ++leeched;
                IMaxAttack.dealMaxHealth((Entity)player, e, belowHalf ? 4 : 8);
                if (!world.field_73012_v.nextBoolean()) continue;
                CustomParticleConfig config1 = new CustomParticleConfig();
                config1.createInstance().setParticle(ParticleInit.CLAW_MARKS).setSpread(2.0, 1.0, 2.0).setCount(2).setIgnoreRange(true);
                CustomParticleConfig config2 = new CustomParticleConfig();
                config2.createInstance().setParticle(ParticleInit.BLOOD_DROP).setSpread(2.0, 1.0, 2.0).setCount(2).setIgnoreRange(true);
                IParticleSpawner.spawnParticle(world, config1, e.field_70165_t, e.field_70163_u + (double)(e.field_70131_O / 2.0f), e.field_70161_v);
                IParticleSpawner.spawnParticle(world, config2, e.field_70165_t, e.field_70163_u + (double)(e.field_70131_O / 2.0f), e.field_70161_v);
            }
            if (leeched > 0) {
                player.func_70691_i(Math.min((float)leeched * (player.func_110138_aP() / (float)(belowHalf ? 20 : 50)), player.func_110138_aP() / (float)(belowHalf ? 2 : 4)));
            }
        }
    }

    @Override
    public ArmorInit.ArmorSet getArmorSet() {
        return ArmorInit.vampyreonPrimeSet;
    }

    @Override
    public boolean isPrimeSet() {
        return true;
    }

    public String getArmorTexture(ItemStack itemstack, Entity entity, EntityEquipmentSlot slot, String layer) {
        int sprite = Math.abs(4 - Mth.func_76141_d((float)(entity.field_70173_aa / 3)) % 8);
        return "lostinfinity:textures/armor/prime/vampyreon_prime_armor_" + sprite + ".png";
    }

    @SideOnly(value=Side.CLIENT)
    @Nullable
    public ModelBiped getArmorModel(LivingEntity entityLiving, ItemStack itemStack, EntityEquipmentSlot armorSlot, ModelBiped _default) {
        if (!itemStack.func_190926_b() && itemStack.func_77973_b() instanceof ItemVampyreonPrimeArmor) {
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
        tooltip.add((Object)((Object)TextFmt.Green) + "+22% Max HP Damage Reduction");
        tooltip.add((Object)((Object)TextFmt.Red) + "Steal max life constantly from creatures in a large radius.");
        tooltip.add((Object)((Object)TextFmt.Bold) + "Drain heavily increases while you are below 50% life.");
    }
}

