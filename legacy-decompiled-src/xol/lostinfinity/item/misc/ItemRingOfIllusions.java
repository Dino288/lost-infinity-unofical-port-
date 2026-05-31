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
 *  net.minecraft.potion.PotionEffect
 *  net.minecraft.util.InteractionResultHolder
 *  net.minecraft.util.InteractionHand
 *  net.minecraft.util.SoundSource
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.world.DimensionType
 *  net.minecraft.world.World
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package xol.lostinfinity.item.misc;

import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundSource;
import net.minecraft.core.BlockPos;
import net.minecraft.world.DimensionType;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.dimension.util.DimensionActivator;
import xol.lostinfinity.init.ParticleInit;
import xol.lostinfinity.init.PotionInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.init.TabsInit;
import xol.lostinfinity.item.basics.ItemCooldown;
import xol.lostinfinity.item.classify.IHotbarDeath;
import xol.lostinfinity.util.data.CustomParticleConfig;
import xol.lostinfinity.util.data.IMaxAttack;
import xol.lostinfinity.util.fx.IParticleSpawner;

public class ItemRingOfIllusions
extends ItemCooldown
implements IHotbarDeath,
IMaxAttack {
    public ItemRingOfIllusions(String regName) {
        super(regName);
        this.func_77637_a(TabsInit.TAB_INFINITYWEP);
    }

    public InteractionResultHolder<ItemStack> func_77659_a(Level worldIn, Player playerIn, InteractionHand handIn) {
        ItemStack stack = playerIn.func_184586_b(handIn);
        if (!this.showDurabilityBar(stack) && stack.func_77978_p().func_74762_e("PreventedDim") == worldIn.field_73011_w.getDimension() && stack.func_77978_p().func_74767_n("PreventedLast")) {
            if (!worldIn.field_72995_K) {
                double posX = stack.func_77978_p().func_74769_h("PreventedX");
                double posY = stack.func_77978_p().func_74769_h("PreventedY");
                double posZ = stack.func_77978_p().func_74769_h("PreventedZ");
                playerIn.func_70634_a(posX, posY, posZ);
                CustomParticleConfig config1 = new CustomParticleConfig();
                config1.createInstance().setParticle(ParticleInit.WARP).setIgnoreRange(true);
                IParticleSpawner.spawnParticle(worldIn, config1, playerIn.field_70165_t, playerIn.field_70163_u + 1.0, playerIn.field_70161_v);
                float angle = 0.0f;
                while ((double)angle <= Math.PI * 2) {
                    double velocity_x = 12.0 * Math.cos(angle);
                    double velocity_z = 12.0 * Math.sin(angle);
                    CustomParticleConfig config2 = new CustomParticleConfig();
                    config2.createInstance().setParticle(ParticleInit.SHADOW_BLAST).setSpread(1.0, 1.0, 1.0).setIgnoreRange(true);
                    IParticleSpawner.spawnParticle(worldIn, config2, playerIn.field_70165_t + velocity_x / 2.0, playerIn.field_70163_u + 6.0, playerIn.field_70161_v + velocity_z / 2.0);
                    angle = (float)((double)angle + 0.39269908169872414);
                }
                worldIn.func_184133_a(null, playerIn.func_180425_c(), SoundInit.BIG_WARP, SoundSource.PLAYERS, 1.5f, 1.0f + worldIn.field_73012_v.nextFloat() * 0.5f);
                for (LivingEntity near_pl : worldIn.func_72872_a(LivingEntity.class, playerIn.func_174813_aQ().func_72314_b(15.0, 15.0, 15.0))) {
                    if (near_pl.func_110124_au().equals(playerIn.func_110124_au())) continue;
                    near_pl.func_70690_d(new PotionEffect(PotionInit.VULNERABILITY, 200, 1));
                }
            }
            stack.func_77978_p().func_74757_a("PreventedLast", false);
            stack.func_77978_p().func_74768_a("ComplexCooldown", 8000);
            playerIn.func_184586_b(handIn).func_77978_p().func_74772_a("lastUse", System.currentTimeMillis());
        }
        return super.func_77659_a(worldIn, playerIn, handIn);
    }

    @Override
    protected boolean hasSimpleCooldown() {
        return false;
    }

    @SideOnly(value=Side.CLIENT)
    public void func_77624_a(ItemStack stack, @Nullable Level worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add((Object)((Object)TextFmt.Italic) + "While this is in your hotbar:");
        tooltip.add((Object)((Object)TextFmt.Gold) + "When taking lethal max health damage, teleport home and heal.");
        tooltip.add((Object)((Object)TextFmt.Aqua) + "The damage you would have taken is reflected to the attacker as true damage.");
        tooltip.add(TextFmt.getFormatting(TextFmt.Italic, TextFmt.Dark_Red) + "Activate this item to teleport back, cursing everything nearby with vulnerability.");
    }

    @Override
    public boolean playedKilled(ItemStack stack, Player player, Entity attacker, float damageDealt) {
        Level world = player.field_70170_p;
        if (!this.showDurabilityBar(stack)) {
            stack.func_77978_p().func_74768_a("ComplexCooldown", 1000);
            stack.func_77978_p().func_74757_a("PreventedLast", true);
            stack.func_77978_p().func_74780_a("PreventedX", player.field_70165_t);
            stack.func_77978_p().func_74780_a("PreventedY", player.field_70163_u);
            stack.func_77978_p().func_74780_a("PreventedZ", player.field_70161_v);
            stack.func_77978_p().func_74768_a("PreventedDim", player.field_70170_p.field_73011_w.getDimension());
            stack.func_77978_p().func_74772_a("lastUse", System.currentTimeMillis());
            if (!world.field_72995_K) {
                player.func_70691_i(player.func_110138_aP());
                if (attacker instanceof LivingEntity) {
                    IMaxAttack.dealTrueDamage((Entity)player, (LivingEntity)attacker, damageDealt);
                }
                CustomParticleConfig config1 = new CustomParticleConfig();
                config1.createInstance().setParticle(ParticleInit.WARP).setIgnoreRange(true);
                IParticleSpawner.spawnParticle(player.field_70170_p, config1, player.field_70165_t, player.field_70163_u + 1.0, player.field_70161_v);
                player.field_70170_p.func_184133_a(null, player.func_180425_c(), SoundInit.BIG_WARP, SoundSource.PLAYERS, 1.5f, 0.5f + world.field_73012_v.nextFloat() * 0.5f);
                if (player.field_70170_p.field_73011_w.func_186058_p() == DimensionType.OVERWORLD) {
                    BlockPos bed = player.func_180470_cg();
                    if (bed == null) {
                        bed = world.func_175694_M();
                    }
                    player.func_70634_a((double)bed.func_177958_n(), (double)bed.func_177956_o() + 0.5, (double)bed.func_177952_p());
                } else {
                    DimensionActivator.transferEntity((Entity)player, DimensionType.OVERWORLD);
                }
            }
            return false;
        }
        return true;
    }
}

