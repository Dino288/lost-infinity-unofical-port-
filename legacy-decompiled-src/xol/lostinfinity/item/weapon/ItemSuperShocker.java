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
import xol.lostinfinity.item.basics.ItemCooldown;
import xol.lostinfinity.item.classify.ICustomHoldPose;
import xol.lostinfinity.item.classify.ICustomRaytrace;
import xol.lostinfinity.item.classify.IModeSelect;
import xol.lostinfinity.item.classify.ISwitchModels;
import xol.lostinfinity.util.data.CustomParticleConfig;
import xol.lostinfinity.util.data.CustomHitResult;
import xol.lostinfinity.util.data.IMaxAttack;
import xol.lostinfinity.util.fx.IParticleSpawner;

public class ItemSuperShocker
extends ItemCooldown
implements IMaxAttack,
ICustomRaytrace,
ICustomHoldPose,
ISwitchModels,
IModeSelect {
    public ItemSuperShocker(String regName) {
        super(regName);
        this.func_77637_a(TabsInit.TAB_INFINITYWEP);
        this.setModelSwitch("zaptype", this, 2);
    }

    public InteractionResultHolder<ItemStack> func_77659_a(Level worldIn, Player playerIn, InteractionHand handIn) {
        ItemStack stack = playerIn.func_184586_b(handIn);
        if (!this.showDurabilityBar(stack)) {
            if (!worldIn.field_72995_K) {
                int attack_style = stack.func_77978_p().func_74762_e("zaptype_data");
                CustomHitResult trace_result = this.entityTrace(worldIn, (LivingEntity)playerIn, 45, LivingEntity.class);
                if (trace_result != null && trace_result.getResultEntity() != null) {
                    LivingEntity hit_entity = (LivingEntity)trace_result.getResultEntity();
                    int radius = this.shockCreature(playerIn, hit_entity, 5 + 5 * attack_style);
                    if (attack_style == 1) {
                        if (radius > 10) {
                            radius = 10;
                        }
                        for (LivingEntity near_pl : worldIn.func_72872_a(LivingEntity.class, playerIn.func_174813_aQ().func_186662_g((double)(3 + 2 * radius)))) {
                            if (near_pl.func_110124_au().equals(playerIn.func_110124_au()) || near_pl.func_110124_au().equals(hit_entity.func_110124_au())) continue;
                            this.shockCreature(playerIn, near_pl, 10);
                        }
                    }
                }
                worldIn.func_184133_a(null, playerIn.func_180425_c(), SoundInit.LASER_WEAPON_3, SoundSource.PLAYERS, 0.7f, 0.7f + worldIn.field_73012_v.nextFloat() * 0.6f);
            }
            playerIn.func_184586_b(handIn).func_77978_p().func_74772_a("lastUse", System.currentTimeMillis());
        }
        return super.func_77659_a(worldIn, playerIn, handIn);
    }

    private int shockCreature(Player attacker, LivingEntity entity, int denominator) {
        int level = 1;
        if (entity.func_70644_a(PotionInit.SHOCKED)) {
            level = entity.func_70660_b(PotionInit.SHOCKED).func_76458_c() + 1;
        }
        if (IMaxAttack.dealMaxHealth((Entity)attacker, entity, denominator, level).didSuccessfulHit()) {
            entity.func_70690_d(new PotionEffect(PotionInit.SHOCKED, 80, level));
        }
        CustomParticleConfig config1 = new CustomParticleConfig();
        config1.createInstance().setParticle(ParticleInit.ZAP).setSpread(3.0, 1.0, 3.0).setCount(5).setIgnoreRange(true);
        IParticleSpawner.spawnParticle(attacker.field_70170_p, config1, entity.field_70165_t, entity.field_70163_u + (double)(entity.field_70131_O / 2.0f), entity.field_70161_v);
        return level;
    }

    @Override
    protected int getCooldown() {
        return 100;
    }

    @SideOnly(value=Side.CLIENT)
    public void func_77624_a(ItemStack stack, @Nullable Level worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add((Object)((Object)TextFmt.Light_Purple) + "Shocks a target that you are looking at.");
        tooltip.add((Object)((Object)TextFmt.Gold) + "Increases level of shock if target is already shocked.");
        tooltip.add((Object)((Object)TextFmt.Underline) + "While AOE mode is enabled, spread shock in an area around target.");
        tooltip.add((Object)((Object)TextFmt.Italic) + "Radius of shock spread depends on target's number of shock stacks.");
        tooltip.add((Object)((Object)TextFmt.Gold) + "Deals (Single: 20%, AOE: 10%) Max Health Damage per stack of shock.");
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

