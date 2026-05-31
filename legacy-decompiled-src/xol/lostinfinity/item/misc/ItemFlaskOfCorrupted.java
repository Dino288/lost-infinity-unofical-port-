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
 *  net.minecraft.potion.PotionEffect
 *  net.minecraft.util.SoundSource
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
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.init.ParticleInit;
import xol.lostinfinity.init.PotionInit;
import xol.lostinfinity.init.TabsInit;
import xol.lostinfinity.item.classify.IHotbarDeath;
import xol.lostinfinity.util.data.CustomParticleConfig;
import xol.lostinfinity.util.fx.IParticleSpawner;

public class ItemFlaskOfCorrupted
extends Item
implements IHotbarDeath {
    public ItemFlaskOfCorrupted(String regName) {
        this.func_77637_a(TabsInit.TAB_AUXWEP);
        this.setRegistryName(regName);
        this.func_77655_b(regName);
        ItemInit.ITEMS.add(this);
    }

    @SideOnly(value=Side.CLIENT)
    public void func_77624_a(ItemStack stack, @Nullable Level worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add((Object)((Object)TextFmt.Aqua) + "When taking max health damage that would kill you, activate this flask instead.");
        tooltip.add((Object)((Object)TextFmt.Italic) + "The flask does the following:");
        tooltip.add((Object)((Object)TextFmt.Green) + "Heal for 100% Maximum Life");
        tooltip.add((Object)((Object)TextFmt.Aqua) + "Grants Potion Affinity III");
        tooltip.add((Object)((Object)TextFmt.Light_Purple) + "Gives you Last Breath I and everything else nearby Blighted I.");
        tooltip.add((Object)((Object)TextFmt.Gold) + "If you already have Last Breath, increase the strength of both effects by 1.");
        tooltip.add((Object)((Object)TextFmt.Red) + "You die if you go beyond Last Breath V.");
    }

    @Override
    public boolean playedKilled(ItemStack stack, Player player, Entity attacker, float damageDealt) {
        Level world = player.field_70170_p;
        if (player.func_70644_a(PotionInit.LAST_BREATH)) {
            int level = player.func_70660_b(PotionInit.LAST_BREATH).func_76458_c();
            if (level >= 5) {
                return true;
            }
            if (!world.field_72995_K) {
                this.potionApplication(world, player, level + 1);
            }
        } else if (!world.field_72995_K) {
            this.potionApplication(world, player, 0);
        }
        player.func_70691_i(player.func_110138_aP());
        return false;
    }

    private void potionApplication(Level world, Player player, int amp) {
        player.func_70690_d(new PotionEffect(PotionInit.LAST_BREATH, 200, amp));
        player.func_70690_d(new PotionEffect(PotionInit.POTION_AFFINITY, 200, 2));
        for (LivingEntity near_creature : player.field_70170_p.func_72872_a(LivingEntity.class, player.func_174813_aQ().func_72314_b(20.0, 10.0, 20.0))) {
            if (near_creature.func_110124_au().equals(player.func_110124_au())) continue;
            player.func_70690_d(new PotionEffect(PotionInit.BLIGHTED, 200, amp));
        }
        if (!world.field_72995_K) {
            CustomParticleConfig config1 = new CustomParticleConfig();
            config1.createInstance().setParticle(ParticleInit.BLIGHT_SPELL_GREEN).setSpread(4.0, 1.0, 4.0).setCount(4).setIgnoreRange(true);
            IParticleSpawner.spawnParticle(world, config1, player.field_70165_t, player.field_70163_u + 1.0, player.field_70161_v);
            CustomParticleConfig config2 = new CustomParticleConfig();
            config2.createInstance().setParticle(ParticleInit.CORRUPTION_MAGIC).setSpread(4.0, 1.0, 4.0).setCount(10).setIgnoreRange(true);
            IParticleSpawner.spawnParticle(world, config2, player.field_70165_t, player.field_70163_u + 1.0, player.field_70161_v);
            world.func_184133_a(null, player.func_180425_c(), SoundEvents.field_187664_bz, SoundSource.MASTER, 1.0f, 1.0f);
        }
    }
}

