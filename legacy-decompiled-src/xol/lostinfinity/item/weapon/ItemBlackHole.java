/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.client.util.ITooltipFlag
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.item.ItemStack
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.potion.PotionEffect
 *  net.minecraft.util.InteractionResultHolder
 *  net.minecraft.util.InteractionHand
 *  net.minecraft.util.SoundSource
 *  net.minecraft.util.text.Component
 *  net.minecraft.util.text.Component
 *  net.minecraft.world.World
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package xol.lostinfinity.item.weapon;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundSource;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.ParticleInit;
import xol.lostinfinity.init.PotionInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.init.TabsInit;
import xol.lostinfinity.item.basics.ItemCooldown;
import xol.lostinfinity.item.classify.IChargeItem;
import xol.lostinfinity.item.classify.IMaxNullable;
import xol.lostinfinity.item.classify.IModeSelect;
import xol.lostinfinity.item.classify.ISwitchModels;
import xol.lostinfinity.util.data.CustomParticleConfig;
import xol.lostinfinity.util.data.IMaxAttack;
import xol.lostinfinity.util.fx.IParticleSpawner;

public class ItemBlackHole
extends ItemCooldown
implements ISwitchModels,
IModeSelect,
IChargeItem,
IMaxAttack,
IMaxNullable {
    public ItemBlackHole(String regName) {
        super(regName);
        this.func_77637_a(TabsInit.TAB_INFINITYWEP);
        this.setModelSwitch("usetype", this, 2);
    }

    public InteractionResultHolder<ItemStack> func_77659_a(Level worldIn, Player playerIn, InteractionHand handIn) {
        if (!this.showDurabilityBar(playerIn.func_184586_b(handIn))) {
            ItemStack stack = playerIn.func_184586_b(handIn);
            int type = stack.func_77978_p().func_74762_e("usetype_data");
            if (!worldIn.field_72995_K) {
                if (type == 0) {
                    playerIn.func_70690_d(new PotionEffect(PotionInit.CHARGING, 300));
                } else {
                    playerIn.func_70690_d(new PotionEffect(PotionInit.CHARGING, 100));
                }
                playerIn.field_70170_p.func_184133_a(null, playerIn.func_180425_c(), SoundInit.MAGIC_WEAPON_10, SoundSource.PLAYERS, 1.5f, 1.0f);
            }
            int cdVal = type == 0 ? 25000 : 9000;
            stack.func_77978_p().func_74768_a("ComplexCooldown", cdVal);
            playerIn.func_184586_b(handIn).func_77978_p().func_74772_a("lastUse", System.currentTimeMillis());
        }
        return super.func_77659_a(worldIn, playerIn, handIn);
    }

    @Override
    protected boolean hasSimpleCooldown() {
        return false;
    }

    @Override
    public float nullableReaction(Player player, boolean isMainHand, float originalDamage, float newDamage, ItemStack stack) {
        float returnDamage = newDamage;
        if (player.func_70644_a(PotionInit.CHARGING)) {
            if (!stack.func_77942_o()) {
                stack.func_77982_d(new CompoundTag());
            }
            int mitigated_damage = Math.round(newDamage);
            returnDamage = 0.0f;
            int alreadyStored = stack.func_77978_p().func_74762_e("StoredDamage");
            stack.func_77978_p().func_74768_a("StoredDamage", alreadyStored + mitigated_damage);
        }
        return returnDamage;
    }

    @Override
    public void modeUpdate(ItemStack stack, Player player) {
        if (!stack.func_77942_o()) {
            stack.func_77982_d(new CompoundTag());
        }
        if (!this.showDurabilityBar(stack)) {
            int attack_style = stack.func_77978_p().func_74762_e("usetype_data");
            if (attack_style == 0) {
                stack.func_77978_p().func_74768_a("usetype_data", 1);
            } else {
                stack.func_77978_p().func_74768_a("usetype_data", 0);
            }
        }
    }

    @Override
    public void endChargeEffect(ItemStack stack, Player player) {
        int damageStored;
        if (!stack.func_77942_o()) {
            stack.func_77982_d(new CompoundTag());
        }
        if ((damageStored = stack.func_77978_p().func_74762_e("StoredDamage")) > 0) {
            int attack_style = stack.func_77978_p().func_74762_e("usetype_data");
            int damageDeal = attack_style == 0 ? Math.floorDiv(damageStored, 4) : damageStored;
            ArrayList<LivingEntity> near_creatures = new ArrayList<LivingEntity>();
            for (LivingEntity near_pl : player.field_70170_p.func_72872_a(LivingEntity.class, player.func_174813_aQ().func_72314_b(20.0, 8.0, 20.0))) {
                if (near_pl.func_110124_au().equals(player.func_110124_au())) continue;
                near_creatures.add(near_pl);
            }
            if (near_creatures.size() > 0) {
                int finalDeal = Math.floorDiv(damageDeal, near_creatures.size());
                for (LivingEntity near_pl : near_creatures) {
                    IMaxAttack.dealTrueDamage((Entity)player, near_pl, finalDeal);
                    CustomParticleConfig config1 = new CustomParticleConfig();
                    config1.createInstance().setParticle(ParticleInit.SPACE_MAGIC).setSpread(4.0, 1.0, 4.0).setCount(8).setIgnoreRange(true);
                    IParticleSpawner.spawnParticle(player.field_70170_p, config1, near_pl.field_70165_t, near_pl.field_70163_u + (double)(near_pl.field_70131_O / 2.0f), near_pl.field_70161_v);
                }
                player.func_145747_a((Component)new Component((Object)((Object)TextFmt.Gold) + "You dealt " + damageDeal + " split amongst " + near_creatures.size() + " creatures."));
            }
            CustomParticleConfig config1 = new CustomParticleConfig();
            config1.createInstance().setParticle(ParticleInit.POWER_FIELD).setIgnoreRange(true);
            IParticleSpawner.spawnParticle(player.field_70170_p, config1, player.field_70165_t, player.field_70163_u + (double)(player.field_70131_O / 2.0f), player.field_70161_v);
            player.field_70170_p.func_184133_a(null, player.func_180425_c(), SoundInit.ENERGY_PULSE, SoundSource.PLAYERS, 1.5f, 1.0f);
        }
        stack.func_77978_p().func_74768_a("StoredDamage", 0);
    }

    @SideOnly(value=Side.CLIENT)
    public void func_77624_a(ItemStack stack, @Nullable Level worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add((Object)((Object)TextFmt.Aqua) + "When held and activated, grants a charging buff.");
        tooltip.add((Object)((Object)TextFmt.Gold) + "While charging, take no max health damage and store damage prevented.");
        tooltip.add((Object)((Object)TextFmt.Gray) + "At the end of the charging duration, stored damage is dealt as true damage to all nearby creatures.");
        tooltip.add((Object)((Object)TextFmt.Italic) + "Damage dealt is split between the creatures.");
        tooltip.add((Object)((Object)TextFmt.Light_Purple) + "Purple: Long Duration, 25% Of Damage Stored");
        tooltip.add((Object)((Object)TextFmt.Red) + "Red: Short Duration, 100% Of Damage Stored");
    }
}

