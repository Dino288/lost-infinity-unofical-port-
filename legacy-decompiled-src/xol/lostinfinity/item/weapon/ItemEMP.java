/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.client.util.ITooltipFlag
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.item.ItemStack
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
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
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
import xol.lostinfinity.util.data.CustomParticleConfig;
import xol.lostinfinity.util.fx.IParticleSpawner;

public class ItemEMP
extends ItemCooldown {
    public ItemEMP(String regName) {
        super(regName);
        this.func_77637_a(TabsInit.TAB_AUXWEP);
    }

    public InteractionResultHolder<ItemStack> func_77659_a(Level worldIn, Player playerIn, InteractionHand handIn) {
        if (!this.showDurabilityBar(playerIn.func_184586_b(handIn))) {
            if (!worldIn.field_72995_K) {
                for (LivingEntity near_pl : worldIn.func_72872_a(LivingEntity.class, playerIn.func_174813_aQ().func_72314_b(25.0, 25.0, 25.0))) {
                    if (near_pl.func_110124_au().equals(playerIn.func_110124_au())) continue;
                    if (near_pl instanceof Player) {
                        near_pl.func_70690_d(new PotionEffect(PotionInit.NULLIFIED, 400, 0));
                        continue;
                    }
                    near_pl.func_70690_d(new PotionEffect(PotionInit.VULNERABILITY, 400, 0));
                }
                double radius = 3.0;
                float angle = 0.0f;
                while ((double)angle <= Math.PI * 2) {
                    double velocity_x = radius * Math.cos(angle);
                    double velocity_z = radius * Math.sin(angle);
                    CustomParticleConfig config1 = new CustomParticleConfig();
                    config1.createInstance().setParticle(ParticleInit.POWER_LOSS).setIgnoreRange(true);
                    IParticleSpawner.spawnParticle(worldIn, config1, playerIn.field_70165_t + velocity_x, playerIn.field_70163_u + 0.5, playerIn.field_70161_v + velocity_z);
                    angle = (float)((double)angle + 0.3141592653589793);
                }
                worldIn.func_184133_a(null, playerIn.func_180425_c(), SoundInit.MAGIC_WEAPON_11, SoundSource.PLAYERS, 1.0f, 1.0f);
            }
            playerIn.func_184586_b(handIn).func_77978_p().func_74772_a("lastUse", System.currentTimeMillis());
        }
        return super.func_77659_a(worldIn, playerIn, handIn);
    }

    @Override
    protected int getCooldown() {
        return 15000;
    }

    @SideOnly(value=Side.CLIENT)
    public void func_77624_a(ItemStack stack, @Nullable Level worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add((Object)((Object)TextFmt.Gold) + "Applies the nullified debuff to creatures in a large radius.");
        tooltip.add((Object)((Object)TextFmt.Green) + "Non-players receive vulnerability instead.");
    }
}

