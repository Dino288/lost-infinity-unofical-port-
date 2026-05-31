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
 *  net.minecraft.entity.player.ServerPlayer
 *  net.minecraft.init.SoundEvents
 *  net.minecraft.inventory.EntityEquipmentSlot
 *  net.minecraft.item.Item
 *  net.minecraft.item.ArmorItem$ArmorMaterial
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.EnumParticleTypes
 *  net.minecraft.util.SoundEvent
 *  net.minecraft.util.math.Mth
 *  net.minecraft.world.World
 *  net.minecraft.world.ServerLevel
 *  net.minecraftforge.common.util.EnumHelper
 *  net.minecraftforge.fml.common.network.simpleimpl.IMessage
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
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Mth;
import net.minecraft.world.level.Level;
import net.minecraft.server.level.ServerLevel;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.common.packets.LostInfinityPacketHandler;
import xol.lostinfinity.common.packets.serverbound.PacketNBTSyncLong;
import xol.lostinfinity.init.ArmorInit;
import xol.lostinfinity.item.armor.ItemLostArmor;
import xol.lostinfinity.item.armor.model.ModelArmorVitralitonPrime;
import xol.lostinfinity.item.classify.ICooldown;

public class ItemVitralitonPrimeArmor
extends ItemLostArmor {
    private static final ArmorItem.ArmorMaterial VitralitonMaterial = EnumHelper.addArmorMaterial((String)"vitralitonPrimeArmor", (String)"lostinfinity:vitraliton_prime_armor", (int)-1, (int[])new int[]{12, 24, 32, 12}, (int)20, (SoundEvent)SoundEvents.field_187716_o, (float)3.0f);

    public ItemVitralitonPrimeArmor(String regName, EntityEquipmentSlot slot) {
        super(VitralitonMaterial, regName, slot);
    }

    @Override
    protected void handleSpecialArmorBonus(Player player) {
        Level world = player.field_70170_p;
        if (!world.field_72995_K && player.field_70173_aa % 5 == 0) {
            float player_health = player.func_110143_aJ();
            float player_max = player.func_110138_aP();
            float percentage_health = player_health / player_max * 100.0f;
            int incremented_multiplier = (int)Math.round(Math.floor((100.0f - percentage_health) / 14.0f));
            float heal_amount = (float)incremented_multiplier * player.func_110138_aP() / 100.0f;
            player.func_70691_i(heal_amount);
            if (player_health != player.func_110143_aJ() && player.func_110143_aJ() < player.func_110138_aP() / 2.0f) {
                for (int i = 0; i <= 8; ++i) {
                    Item hotbarItem;
                    ItemStack invyStack = player.field_71071_by.func_70301_a(i);
                    if (!(invyStack.func_77973_b() instanceof ICooldown) || !(hotbarItem = invyStack.func_77973_b()).showDurabilityBar(invyStack)) continue;
                    long storedTime = invyStack.func_77978_p().func_74763_f("lastUse");
                    long currentTime = System.currentTimeMillis();
                    double barProgress = 1.0 - hotbarItem.getDurabilityForDisplay(invyStack);
                    long passedTime = currentTime - storedTime;
                    int originalCD = Mth.func_76128_c((double)((double)passedTime / barProgress));
                    int cooldownReduction = Mth.func_76128_c((double)((double)originalCD * 0.1));
                    long replaceLong = storedTime - (long)cooldownReduction;
                    invyStack.func_77978_p().func_74772_a("lastUse", replaceLong);
                    LostInfinityPacketHandler.INSTANCE.sendTo((IMessage)new PacketNBTSyncLong("lastUse", replaceLong, invyStack), (ServerPlayer)player);
                    break;
                }
            }
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
        return true;
    }

    @Override
    public ArmorInit.ArmorSet getArmorSet() {
        return ArmorInit.vitralitonPrimeSet;
    }

    public String getArmorTexture(ItemStack itemstack, Entity entity, EntityEquipmentSlot slot, String layer) {
        int sprite = Math.abs(4 - Mth.func_76141_d((float)(entity.field_70173_aa / 3)) % 8);
        return "lostinfinity:textures/armor/prime/vitraliton_prime_armor_" + sprite + ".png";
    }

    @SideOnly(value=Side.CLIENT)
    @Nullable
    public ModelBiped getArmorModel(LivingEntity entityLiving, ItemStack itemStack, EntityEquipmentSlot armorSlot, ModelBiped _default) {
        if (!itemStack.func_190926_b() && itemStack.func_77973_b() instanceof ItemVitralitonPrimeArmor) {
            ModelArmorVitralitonPrime vamp = new ModelArmorVitralitonPrime();
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
        tooltip.add("");
        tooltip.add((Object)((Object)TextFmt.Bold) + "Set Bonuses:");
        tooltip.add((Object)((Object)TextFmt.Green) + "+22% Max HP Damage Reduction");
        tooltip.add((Object)((Object)TextFmt.Green) + "Increased % Health Regeneration Based on Missing Health");
        tooltip.add((Object)((Object)TextFmt.Aqua) + "75% Chance To Dodge (Infinity) Damage While On Full Life");
        tooltip.add("");
        tooltip.add((Object)((Object)TextFmt.Italic) + "While restoring life while below half health:");
        tooltip.add((Object)((Object)TextFmt.Gold) + "Rapidly restore cooldowns (prioritizing left to right) of items in your hotbar.");
    }
}

