/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.client.util.ITooltipFlag
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.init.SoundEvents
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.util.InteractionResultHolder
 *  net.minecraft.util.InteractionHand
 *  net.minecraft.util.SoundSource
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.text.Component
 *  net.minecraft.util.text.Component
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
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundSource;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.ParticleInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.init.TabsInit;
import xol.lostinfinity.item.classify.ICustomRaytrace;
import xol.lostinfinity.item.classify.IModeSelect;
import xol.lostinfinity.item.classify.ISwitchModels;
import xol.lostinfinity.item.weapon.ItemCooldownSword;
import xol.lostinfinity.util.data.CustomParticleConfig;
import xol.lostinfinity.util.data.CustomHitResult;
import xol.lostinfinity.util.data.IMaxAttack;
import xol.lostinfinity.util.fx.IParticleSpawner;

public class ItemBladeOfConqueror
extends ItemCooldownSword
implements IMaxAttack,
ISwitchModels,
IModeSelect,
ICustomRaytrace {
    public ItemBladeOfConqueror(String regName) {
        super(regName);
        this.func_77637_a(TabsInit.TAB_GALAXY);
        this.setModelSwitch("attack", (Item)this, 3);
    }

    @Override
    protected int getCooldown() {
        return 1500;
    }

    public InteractionResultHolder<ItemStack> func_77659_a(Level worldIn, Player playerIn, InteractionHand handIn) {
        if (!this.showDurabilityBar(playerIn.func_184586_b(handIn))) {
            if (!worldIn.field_72995_K) {
                if (!playerIn.func_70093_af()) {
                    CustomHitResult trace = this.forwardTrace(worldIn, (Entity)playerIn, 10);
                    BlockPos start_pos = playerIn.func_180425_c();
                    BlockPos result_pos = trace.getResultPos();
                    int divisor = 3;
                    if (playerIn.field_71075_bZ.field_75100_b) {
                        divisor = 6;
                    }
                    worldIn.func_184133_a(null, start_pos, SoundInit.DASH, SoundSource.MASTER, 1.0f, 1.0f);
                    worldIn.func_184133_a(null, result_pos, SoundInit.DASH, SoundSource.MASTER, 1.0f, 1.0f);
                    playerIn.func_70024_g((double)((start_pos.func_177958_n() - result_pos.func_177958_n()) / -divisor), 0.3, (double)((start_pos.func_177952_p() - result_pos.func_177952_p()) / -divisor));
                    playerIn.field_70133_I = true;
                } else {
                    CustomHitResult trace = this.forwardTrace(worldIn, (Entity)playerIn, 2);
                    BlockPos result_pos = trace.getResultPos();
                    for (LivingEntity near_pl : worldIn.func_72872_a(LivingEntity.class, playerIn.func_174813_aQ().func_72314_b(25.0, 3.0, 25.0))) {
                        if (near_pl.func_110124_au().equals(playerIn.func_110124_au())) continue;
                        near_pl.func_70634_a((double)result_pos.func_177958_n(), (double)result_pos.func_177956_o(), (double)result_pos.func_177952_p());
                    }
                    CustomParticleConfig config1 = new CustomParticleConfig();
                    config1.createInstance().setParticle(ParticleInit.WARP).setIgnoreRange(true);
                    IParticleSpawner.spawnParticle(worldIn, config1, (double)result_pos.func_177958_n(), (double)result_pos.func_177956_o() + 0.5, (double)result_pos.func_177952_p());
                }
            }
            playerIn.func_184586_b(handIn).func_77978_p().func_74772_a("lastUse", System.currentTimeMillis());
        }
        return super.func_77659_a(worldIn, playerIn, handIn);
    }

    public boolean func_77644_a(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (!stack.func_77942_o()) {
            stack.func_77982_d(new CompoundTag());
        }
        Level world = attacker.field_70170_p;
        int attack_style = stack.func_77978_p().func_74762_e("attack_data");
        if (attack_style == 0) {
            if (!world.field_72995_K) {
                if (!attacker.field_70170_p.func_175623_d(attacker.func_180425_c().func_177977_b())) {
                    for (LivingEntity near_pl : attacker.field_70170_p.func_72872_a(LivingEntity.class, target.func_174813_aQ().func_72314_b(12.0, 12.0, 12.0))) {
                        if (near_pl.func_110124_au().equals(attacker.func_110124_au())) continue;
                        IMaxAttack.dealTrueDamage((Entity)attacker, near_pl, near_pl.func_110138_aP() * 0.6f);
                    }
                    double radius = 6.0;
                    float angle = 0.0f;
                    while ((double)angle <= Math.PI * 2) {
                        double velocity_x = radius * Math.cos(angle);
                        double velocity_z = radius * Math.sin(angle);
                        CustomParticleConfig config1 = new CustomParticleConfig();
                        config1.createInstance().setParticle(ParticleInit.SLAM).setSpread(1.0, 1.0, 1.0).setCount(2).setIgnoreRange(true);
                        IParticleSpawner.spawnParticle(world, config1, attacker.field_70165_t + velocity_x, attacker.field_70163_u + 3.0, attacker.field_70161_v + velocity_z);
                        angle = (float)((double)angle + 0.3141592653589793);
                    }
                    world.func_184133_a(null, target.func_180425_c(), SoundInit.GROUND_SLAM, SoundSource.MASTER, 2.0f, 1.0f);
                } else {
                    IMaxAttack.dealTrueDamage((Entity)attacker, target, target.func_110138_aP() * 0.6f);
                }
            }
        } else if (attack_style == 1) {
            if (!world.field_72995_K) {
                attacker.func_70024_g(0.0, 4.0, 0.0);
                attacker.field_70133_I = true;
                for (LivingEntity near_pl : attacker.field_70170_p.func_72872_a(LivingEntity.class, target.func_174813_aQ().func_72314_b(12.0, 12.0, 12.0))) {
                    near_pl.func_70024_g(0.0, 4.0, 0.0);
                    near_pl.field_70133_I = true;
                }
            }
            stack.func_77978_p().func_74768_a("attack_data", 2);
        } else {
            stack.func_77978_p().func_74768_a("attack_data", 1);
            if (!world.field_72995_K) {
                for (LivingEntity near_pl : attacker.field_70170_p.func_72872_a(LivingEntity.class, target.func_174813_aQ().func_72314_b(12.0, 12.0, 12.0))) {
                    if (near_pl.func_110124_au().equals(attacker.func_110124_au()) || !(near_pl.field_70163_u >= 100.0)) continue;
                    IMaxAttack.dealTrueDamage((Entity)attacker, near_pl, near_pl.func_110138_aP() * 3.0f);
                }
            }
        }
        return true;
    }

    @SideOnly(value=Side.CLIENT)
    public void func_77624_a(ItemStack stack, @Nullable Level worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add((Object)((Object)TextFmt.Green) + "Deals 60% of target's health as True Damage.");
        tooltip.add((Object)((Object)TextFmt.Red) + "Uses AOE ground slam attack.");
        tooltip.add((Object)((Object)TextFmt.Aqua) + "Can toggle duality gravity combo instead, dealing 300% health as True Damage.");
        tooltip.add((Object)((Object)TextFmt.Gold) + "Special activatable abilities:");
        tooltip.add((Object)((Object)TextFmt.Gold) + "Right Click: Dash");
        tooltip.add((Object)((Object)TextFmt.Gold) + "Shift-Right Click: Warp nearby enemies in front of you.");
        tooltip.add((Object)((Object)TextFmt.Italic) + "True damage cannot be blocked or reflected.");
    }

    @Override
    public void modeUpdate(ItemStack stack, Player player) {
        if (!stack.func_77942_o()) {
            stack.func_77982_d(new CompoundTag());
        }
        player.field_70170_p.func_184133_a(null, player.func_180425_c(), SoundEvents.field_187750_dc, SoundSource.MASTER, 2.0f, 1.0f);
        int attack_style = stack.func_77978_p().func_74762_e("attack_data");
        if (attack_style == 0) {
            stack.func_77978_p().func_74768_a("attack_data", 1);
        } else {
            stack.func_77978_p().func_74768_a("attack_data", 0);
        }
        if (!player.field_70170_p.field_72995_K) {
            player.func_145747_a((Component)new Component((Object)((Object)TextFmt.Aqua) + "Gravity combo " + (attack_style == 0 ? "enabled" : "disabled")));
        }
    }
}

