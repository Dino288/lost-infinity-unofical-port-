/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.client.util.ITooltipFlag
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.potion.PotionEffect
 *  net.minecraft.util.InteractionResultHolder
 *  net.minecraft.util.InteractionHand
 *  net.minecraft.util.SoundSource
 *  net.minecraft.world.World
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package xol.lostinfinity.item.weapon;

import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.ParticleInit;
import xol.lostinfinity.init.PotionInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.init.TabsInit;
import xol.lostinfinity.item.classify.ICustomHoldPose;
import xol.lostinfinity.item.classify.ICustomRaytrace;
import xol.lostinfinity.item.classify.IModeSelect;
import xol.lostinfinity.item.classify.ISwitchModels;
import xol.lostinfinity.item.weapon.ItemCooldownSword;
import xol.lostinfinity.util.data.CustomDamageResult;
import xol.lostinfinity.util.data.CustomParticleConfig;
import xol.lostinfinity.util.data.CustomHitResult;
import xol.lostinfinity.util.data.IMaxAttack;
import xol.lostinfinity.util.fx.IParticleSpawner;

public class ItemDarkZapper
extends ItemCooldownSword
implements IMaxAttack,
ICustomRaytrace,
ICustomHoldPose,
ISwitchModels,
IModeSelect {
    public ItemDarkZapper(String regName) {
        super(regName);
        this.func_77637_a(TabsInit.TAB_INFINITYWEP);
        this.setModelSwitch("zaptype", (Item)this, 2);
    }

    public InteractionResultHolder<ItemStack> func_77659_a(Level worldIn, Player playerIn, InteractionHand handIn) {
        ItemStack stack = playerIn.func_184586_b(handIn);
        int attack_style = stack.func_77978_p().func_74762_e("zaptype_data");
        if (attack_style == 0 && !this.showDurabilityBar(stack)) {
            if (!worldIn.field_72995_K) {
                CustomHitResult trace_result = this.entityTrace(worldIn, (LivingEntity)playerIn, 45, LivingEntity.class);
                if (trace_result != null && trace_result.getResultEntity() != null) {
                    CustomDamageResult result;
                    LivingEntity hit_entity = (LivingEntity)trace_result.getResultEntity();
                    int level = 1;
                    if (hit_entity.func_70644_a(PotionInit.SHOCKED)) {
                        level = hit_entity.func_70660_b(PotionInit.SHOCKED).func_76458_c() + 1;
                    }
                    if ((result = IMaxAttack.dealMaxHealth((Entity)playerIn, hit_entity, 10, level)).didSuccessfulHit()) {
                        hit_entity.func_70690_d(new PotionEffect(PotionInit.SHOCKED, 80, level));
                    }
                    if (!result.wasTargetKilled()) {
                        IMaxAttack.dealTrueDamage((Entity)playerIn, hit_entity, hit_entity.func_110138_aP() * (0.033f * (float)level));
                    }
                    CustomParticleConfig config1 = new CustomParticleConfig();
                    config1.createInstance().setParticle(ParticleInit.ZAP).setSpread(3.0, 1.0, 3.0).setCount(5).setIgnoreRange(true);
                    IParticleSpawner.spawnParticle(worldIn, config1, hit_entity.field_70165_t, hit_entity.field_70163_u + (double)(hit_entity.field_70131_O / 2.0f), hit_entity.field_70161_v);
                }
                worldIn.func_184133_a(null, playerIn.func_180425_c(), SoundInit.LASER_WEAPON_3, SoundSource.PLAYERS, 0.7f, 0.7f + worldIn.field_73012_v.nextFloat() * 0.6f);
            }
            playerIn.func_184586_b(handIn).func_77978_p().func_74772_a("lastUse", System.currentTimeMillis());
        }
        return super.func_77659_a(worldIn, playerIn, handIn);
    }

    public boolean func_77644_a(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        int attack_style = stack.func_77978_p().func_74762_e("zaptype_data");
        if (attack_style == 1 && target.func_70644_a(PotionInit.SHOCKED)) {
            int level = target.func_70660_b(PotionInit.SHOCKED).func_76458_c();
            for (LivingEntity near_pl : attacker.field_70170_p.func_72872_a(LivingEntity.class, target.func_174813_aQ().func_186662_g(8.0))) {
                if (near_pl.func_110124_au().equals(target.func_110124_au()) || near_pl.func_110124_au().equals(attacker.func_110124_au())) continue;
                near_pl.func_70690_d(new PotionEffect(PotionInit.SHOCKED, 100, level));
            }
        }
        return true;
    }

    @Override
    protected int getCooldown() {
        return 100;
    }

    @SideOnly(value=Side.CLIENT)
    public void func_77624_a(ItemStack stack, @Nullable Level worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add((Object)((Object)TextFmt.Light_Purple) + "Shocks a target that you are looking at.");
        tooltip.add((Object)((Object)TextFmt.Gold) + "Increases level of shock if target is already shocked.");
        tooltip.add((Object)((Object)TextFmt.Gold) + "Deals 10% Max Health Damage per stack of shock.");
        tooltip.add((Object)((Object)TextFmt.Gold) + "Deals 3% Health True Damage per stack of shock.");
        tooltip.add((Object)((Object)TextFmt.Aqua) + "Alternate melee form spreads stacks of shock to nearby enemies on hit.");
    }

    @Override
    public void modeUpdate(ItemStack stack, Player player) {
        int attack_style;
        if (!stack.func_77942_o()) {
            stack.func_77982_d(new CompoundTag());
        }
        if ((attack_style = stack.func_77978_p().func_74762_e("zaptype_data")) == 0) {
            stack.func_77978_p().func_74768_a("zaptype_data", 1);
        } else {
            stack.func_77978_p().func_74768_a("zaptype_data", 0);
        }
    }
}

