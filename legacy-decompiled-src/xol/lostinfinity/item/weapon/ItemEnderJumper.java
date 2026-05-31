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
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundSource;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.ParticleInit;
import xol.lostinfinity.init.PotionInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.init.TabsInit;
import xol.lostinfinity.item.basics.ItemCooldown;
import xol.lostinfinity.item.classify.ICustomRaytrace;
import xol.lostinfinity.util.data.CustomDamageResult;
import xol.lostinfinity.util.data.CustomParticleConfig;
import xol.lostinfinity.util.data.CustomHitResult;
import xol.lostinfinity.util.data.IMaxAttack;
import xol.lostinfinity.util.fx.IParticleSpawner;

public class ItemEnderJumper
extends ItemCooldown
implements ICustomRaytrace,
IMaxAttack {
    public ItemEnderJumper(String regName) {
        super(regName);
        this.func_77637_a(TabsInit.TAB_AUXWEP);
    }

    public InteractionResultHolder<ItemStack> func_77659_a(Level worldIn, Player playerIn, InteractionHand handIn) {
        if (!this.showDurabilityBar(playerIn.func_184586_b(handIn))) {
            CustomHitResult trace_result;
            ItemStack stack = playerIn.func_184586_b(handIn);
            if (!worldIn.field_72995_K && (trace_result = this.simpleBlockTrace(worldIn, (LivingEntity)playerIn, 60)) != null) {
                BlockPos resultPos = trace_result.getResultPos();
                playerIn.func_70634_a((double)resultPos.func_177958_n(), (double)resultPos.func_177956_o(), (double)resultPos.func_177952_p());
                CustomParticleConfig config1 = new CustomParticleConfig();
                config1.createInstance().setParticle(ParticleInit.WARP).setIgnoreRange(true);
                IParticleSpawner.spawnParticle(worldIn, config1, (double)resultPos.func_177958_n(), (double)resultPos.func_177956_o() + 0.5, (double)resultPos.func_177952_p());
                worldIn.func_184133_a(null, resultPos, SoundInit.BIG_WARP, SoundSource.PLAYERS, 1.5f, 0.5f + worldIn.field_73012_v.nextFloat());
                for (LivingEntity near_pl : worldIn.func_72872_a(LivingEntity.class, playerIn.func_174813_aQ().func_72314_b(6.0, 6.0, 6.0))) {
                    CustomDamageResult result;
                    boolean wasKilled;
                    if (near_pl.func_110124_au().equals(playerIn.func_110124_au()) || (wasKilled = (result = IMaxAttack.dealMaxHealth((Entity)playerIn, near_pl, 4, 3.0f)).wasTargetKilled()) || !result.didSuccessfulHit()) continue;
                    near_pl.func_70690_d(new PotionEffect(PotionInit.VULNERABILITY, 200, 1));
                }
            }
            playerIn.func_184586_b(handIn).func_77978_p().func_74772_a("lastUse", System.currentTimeMillis());
        }
        return super.func_77659_a(worldIn, playerIn, handIn);
    }

    @Override
    protected int getCooldown() {
        return 1000;
    }

    @SideOnly(value=Side.CLIENT)
    public void func_77624_a(ItemStack stack, @Nullable Level worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add((Object)((Object)TextFmt.Aqua) + "Can be used to quickly warp to locations.");
        tooltip.add((Object)((Object)TextFmt.Gold) + "Warping deals 75% max health damage to nearby enemies upon arrival.");
        tooltip.add((Object)((Object)TextFmt.Italic) + "Warping also curses enemies with vulnerability II.");
    }
}

