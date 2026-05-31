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
 *  net.minecraft.potion.Potion
 *  net.minecraft.potion.PotionEffect
 *  net.minecraft.util.InteractionResultHolder
 *  net.minecraft.util.InteractionHand
 *  net.minecraft.util.SoundSource
 *  net.minecraft.world.World
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package xol.lostinfinity.item.weapon;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.Nullable;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.ParticleInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.init.TabsInit;
import xol.lostinfinity.item.classify.ICustomRaytrace;
import xol.lostinfinity.item.weapon.ItemCooldownSword;
import xol.lostinfinity.util.PotionBasic;
import xol.lostinfinity.util.data.CustomDamageResult;
import xol.lostinfinity.util.data.CustomParticleConfig;
import xol.lostinfinity.util.data.CustomHitResult;
import xol.lostinfinity.util.data.IMaxAttack;
import xol.lostinfinity.util.fx.IParticleSpawner;

public class ItemEverlastingWarlord
extends ItemCooldownSword
implements IMaxAttack,
ICustomRaytrace {
    public ItemEverlastingWarlord(String regName) {
        super(regName);
        this.func_77637_a(TabsInit.TAB_INFINITYWEP);
    }

    public boolean func_77644_a(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        CustomDamageResult dr = IMaxAttack.dealTrueDamage((Entity)attacker, target, target.func_110138_aP() * 0.5f);
        float damageDealt = dr.getDamageDealt();
        if (dr.wasTargetKilled()) {
            this.killReward(attacker);
        } else {
            attacker.func_70691_i(damageDealt);
        }
        attacker.field_70170_p.func_184133_a(null, attacker.func_180425_c(), SoundInit.SWING_HIT, SoundSource.PLAYERS, 1.5f, 0.6f + attacker.field_70170_p.field_73012_v.nextFloat() * 0.4f);
        return true;
    }

    public InteractionResultHolder<ItemStack> func_77659_a(Level worldIn, Player playerIn, InteractionHand handIn) {
        ItemStack stack;
        if (handIn == InteractionHand.MAIN_HAND && !this.showDurabilityBar(stack = playerIn.func_184586_b(handIn))) {
            CustomHitResult trace_result;
            if (!worldIn.field_72995_K && (trace_result = this.entityTrace(worldIn, (LivingEntity)playerIn, 30, LivingEntity.class)) != null && trace_result.getResultEntity() != null) {
                LivingEntity tracedEntity = (LivingEntity)trace_result.getResultEntity();
                playerIn.func_70634_a(tracedEntity.field_70165_t, tracedEntity.field_70163_u, tracedEntity.field_70161_v);
                IMaxAttack.dealTrueDamage((Entity)playerIn, tracedEntity, tracedEntity.func_110138_aP() * 0.5f);
                worldIn.func_184133_a(null, tracedEntity.func_180425_c(), SoundInit.RAPID_TELEPORT, SoundSource.PLAYERS, 1.5f, 0.8f + worldIn.field_73012_v.nextFloat() * 0.4f);
                if (tracedEntity.func_110143_aJ() <= 0.0f) {
                    this.killReward((LivingEntity)playerIn);
                }
                CustomParticleConfig config1 = new CustomParticleConfig();
                config1.createInstance().setParticle(ParticleInit.CLAW_MARKS).setSpread(4.0, 1.0, 4.0).setCount(8).setIgnoreRange(true);
                IParticleSpawner.spawnParticle(worldIn, config1, tracedEntity.field_70165_t, tracedEntity.field_70163_u + (double)(tracedEntity.field_70131_O / 2.0f), tracedEntity.field_70161_v);
            }
            playerIn.func_184586_b(handIn).func_77978_p().func_74772_a("lastUse", System.currentTimeMillis());
        }
        return super.func_77659_a(worldIn, playerIn, handIn);
    }

    @Override
    protected int getCooldown() {
        return 2000;
    }

    private void killReward(LivingEntity player) {
        ArrayList<PotionEffect> potionsToAdd = new ArrayList<PotionEffect>();
        List potionList = player.func_70651_bq().stream().map(PotionEffect::func_188419_a).collect(Collectors.toList());
        for (Potion potion : potionList) {
            if (potion instanceof PotionBasic) {
                PotionBasic lost_potion = (PotionBasic)potion;
                PotionEffect scaledEffect = this.scalePotionEffect(player.func_70660_b(potion), lost_potion.negativeLostEffect());
                if (scaledEffect == null) continue;
                potionsToAdd.add(scaledEffect);
                continue;
            }
            PotionEffect scaledEffect = this.scalePotionEffect(player.func_70660_b(potion), potion.func_76398_f());
            if (scaledEffect == null) continue;
            potionsToAdd.add(scaledEffect);
        }
        player.func_70674_bp();
        for (PotionEffect pe : potionsToAdd) {
            player.func_70690_d(pe);
        }
        player.func_70691_i(player.func_110138_aP());
    }

    private PotionEffect scalePotionEffect(PotionEffect effect, boolean bad) {
        if (!bad) {
            return effect;
        }
        int level = effect.func_76458_c() - 1;
        int duration = effect.func_76459_b();
        if (level >= 0) {
            return new PotionEffect(effect.func_188419_a(), duration, level);
        }
        return null;
    }

    @SideOnly(value=Side.CLIENT)
    public void func_77624_a(ItemStack stack, @Nullable Level worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add((Object)((Object)TextFmt.Light_Purple) + "Deals 50% Health True Damage");
        tooltip.add((Object)((Object)TextFmt.Green) + "Lifesteals for 100% of (melee) Damage Dealt");
        tooltip.add((Object)((Object)TextFmt.Italic) + "Right Click to dash to a target, dealing an instant ranged hit.");
        tooltip.add((Object)((Object)TextFmt.Gold) + "Killing a target heals you to full and reduces the level of negative effects.");
    }
}

