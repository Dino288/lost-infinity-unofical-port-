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
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.ParticleInit;
import xol.lostinfinity.init.PotionInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.init.TabsInit;
import xol.lostinfinity.item.basics.ItemCooldown;
import xol.lostinfinity.item.classify.IHotbarDeath;
import xol.lostinfinity.util.data.CustomParticleConfig;
import xol.lostinfinity.util.fx.IParticleSpawner;

public class ItemReactionChamber
extends ItemCooldown
implements IHotbarDeath {
    public ItemReactionChamber(String regName) {
        super(regName);
        this.func_77637_a(TabsInit.TAB_INFINITYWEP);
    }

    public InteractionResultHolder<ItemStack> func_77659_a(Level worldIn, Player playerIn, InteractionHand handIn) {
        if (!this.showDurabilityBar(playerIn.func_184586_b(handIn))) {
            if (!worldIn.field_72995_K) {
                this.effect(worldIn, playerIn);
            }
            playerIn.func_184586_b(handIn).func_77978_p().func_74772_a("lastUse", System.currentTimeMillis());
        }
        return super.func_77659_a(worldIn, playerIn, handIn);
    }

    @Override
    protected int getCooldown() {
        return 45000;
    }

    @SideOnly(value=Side.CLIENT)
    public void func_77624_a(ItemStack stack, @Nullable Level worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add((Object)((Object)TextFmt.Aqua) + "When used or taking max health damage that would kill you, activate this instead.");
        tooltip.add((Object)((Object)TextFmt.Green) + "Grants you Racing Heart");
        tooltip.add(TextFmt.getFormatting(TextFmt.Italic, TextFmt.Dark_Red) + "Grants Nearby Enemies: Nullified");
        tooltip.add(TextFmt.getFormatting(TextFmt.Italic, TextFmt.Light_Purple) + "Grants Nearby Enemies: Blighted");
        tooltip.add(TextFmt.getFormatting(TextFmt.Italic, TextFmt.Gold) + "Grants Nearby Enemies: Vulnerability");
    }

    @Override
    public boolean playedKilled(ItemStack stack, Player player, Entity attacker, float damageDealt) {
        Level world = player.field_70170_p;
        if (!this.showDurabilityBar(stack)) {
            stack.func_77978_p().func_74772_a("lastUse", System.currentTimeMillis());
            if (!world.field_72995_K) {
                this.effect(world, player);
            }
            return false;
        }
        return true;
    }

    private void effect(Level world, Player player) {
        world.func_184133_a(null, player.func_180425_c(), SoundInit.SCANNER, SoundSource.MASTER, 1.0f, 1.0f);
        player.func_70690_d(new PotionEffect(PotionInit.RACING_HEART, 400));
        for (LivingEntity near_creature : player.field_70170_p.func_72872_a(LivingEntity.class, player.func_174813_aQ().func_186662_g(15.0))) {
            if (near_creature.func_110124_au().equals(player.func_110124_au())) continue;
            near_creature.func_70690_d(new PotionEffect(PotionInit.BLIGHTED, 200));
            near_creature.func_70690_d(new PotionEffect(PotionInit.VULNERABILITY, 200));
            near_creature.func_70690_d(new PotionEffect(PotionInit.NULLIFIED, 200));
        }
        CustomParticleConfig config1 = new CustomParticleConfig();
        config1.createInstance().setParticle(ParticleInit.FLAME_LARGE).setSpread(1.0, 0.0, 1.0).setSpeed(0.3, 0.0, 0.3).setVelSpread(1.0, 0.0, 1.0).setCount(21).setIgnoreRange(true);
        CustomParticleConfig config2 = new CustomParticleConfig();
        config2.createInstance().setParticle(ParticleInit.REPEL_FIELD).setSpread(1.0, 1.0, 1.0).setCount(3).setIgnoreRange(true);
        IParticleSpawner.spawnParticle(player.field_70170_p, config1, player.field_70165_t, player.field_70163_u + 1.0, player.field_70161_v);
        IParticleSpawner.spawnParticle(player.field_70170_p, config2, player.field_70165_t, player.field_70163_u + 1.0, player.field_70161_v);
    }
}

