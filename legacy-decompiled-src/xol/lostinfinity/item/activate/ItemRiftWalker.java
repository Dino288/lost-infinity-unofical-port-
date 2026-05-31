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
package xol.lostinfinity.item.activate;

import java.util.Arrays;
import java.util.List;
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
import xol.lostinfinity.init.PotionInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.init.TabsInit;
import xol.lostinfinity.item.basics.ItemCooldown;
import xol.lostinfinity.mob.entity.misc.EntityRift;
import xol.lostinfinity.util.data.CustomParticleConfig;
import xol.lostinfinity.util.data.IMaxAttack;
import xol.lostinfinity.util.fx.IParticleSpawner;

public class ItemRiftWalker
extends ItemCooldown
implements IMaxAttack {
    public ItemRiftWalker(String regName) {
        super(regName);
        this.func_77637_a(TabsInit.TAB_AUXWEP);
    }

    public InteractionResultHolder<ItemStack> func_77659_a(Level worldIn, Player playerIn, InteractionHand handIn) {
        ItemStack stack = playerIn.func_184586_b(handIn);
        if (playerIn.func_70644_a(PotionInit.SPECTRAL) && playerIn.func_70644_a(Potion.func_188412_a((int)14))) {
            playerIn.func_184596_c(PotionInit.SPECTRAL);
            playerIn.func_184596_c(Potion.func_188412_a((int)14));
            playerIn.func_184596_c(PotionInit.PROTECTED);
            ItemRiftWalker.endEffect(playerIn);
        } else if (!this.showDurabilityBar(stack) && !playerIn.func_70093_af()) {
            if (!worldIn.field_72995_K) {
                playerIn.func_70690_d(new PotionEffect(Potion.func_188412_a((int)14), 300, 0, false, false));
                playerIn.func_70690_d(new PotionEffect(PotionInit.SPECTRAL, 300, 0, false, false));
                playerIn.func_70690_d(new PotionEffect(PotionInit.PROTECTED, 300, 0, false, false));
                worldIn.func_184133_a(null, playerIn.func_180425_c(), SoundInit.GENERIC_VANISH, SoundSource.PLAYERS, 1.0f, 0.9f + 0.2f * worldIn.field_73012_v.nextFloat());
            }
            playerIn.func_184586_b(handIn).func_77978_p().func_74772_a("lastUse", System.currentTimeMillis());
        }
        return super.func_77659_a(worldIn, playerIn, handIn);
    }

    public static void endEffect(Player player) {
        if (!player.field_70170_p.field_72995_K) {
            player.func_82142_c(false);
            CustomParticleConfig config1 = new CustomParticleConfig();
            config1.createInstance().setParticle(ParticleInit.MURK).setSpread(5.0, 2.0, 5.0).setCount(20).setIgnoreRange(true);
            IParticleSpawner.spawnParticle(player.field_70170_p, config1, player.field_70165_t, player.field_70163_u, player.field_70161_v);
            player.field_70170_p.func_184133_a(null, player.func_180425_c(), SoundInit.RIFT_CREATE, SoundSource.PLAYERS, 1.5f, 1.0f);
            player.field_70170_p.func_184133_a(null, player.func_180425_c(), SoundInit.GENERIC_WEAPON_10, SoundSource.PLAYERS, 1.0f, 1.0f);
            for (LivingEntity target : player.field_70170_p.func_72872_a(LivingEntity.class, player.func_174813_aQ().func_186662_g(15.0))) {
                if (target.func_110124_au().equals(player.func_110124_au())) continue;
                IMaxAttack.dealTrueDamage((Entity)player, target, target.func_110138_aP() * 1.5f, Arrays.asList("Darkborn"));
            }
            EntityRift rift = new EntityRift(player.field_70170_p);
            rift.func_70107_b(player.field_70165_t, player.field_70163_u + 0.5, player.field_70161_v);
            player.field_70170_p.func_72838_d((Entity)rift);
        }
    }

    @Override
    protected int getCooldown() {
        return 8000;
    }

    @SideOnly(value=Side.CLIENT)
    public void func_77624_a(ItemStack stack, @Nullable Level worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add((Object)((Object)TextFmt.Light_Purple) + "Enter a spectral form, separated from your body, becoming immune and invisible.");
        tooltip.add((Object)((Object)TextFmt.Gold) + "After 15 seconds, your body snaps to your spectral form.");
        tooltip.add((Object)((Object)TextFmt.Red) + "Exiting spectral form creates dangerous rifts and deals damage.");
        tooltip.add((Object)((Object)TextFmt.Dark_Aqua) + "Darkborn");
    }
}

