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
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.init.ParticleInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.init.TabsInit;
import xol.lostinfinity.item.classify.IMaxNullable;
import xol.lostinfinity.item.classify.IMaxReducible;
import xol.lostinfinity.util.data.CustomParticleConfig;
import xol.lostinfinity.util.data.IMaxAttack;
import xol.lostinfinity.util.fx.IParticleSpawner;

public class ItemQuantumShield
extends Item
implements IMaxAttack,
IMaxReducible,
IMaxNullable {
    public ItemQuantumShield(String regName) {
        this.func_77637_a(TabsInit.TAB_AUXWEP);
        this.setRegistryName(regName);
        this.func_77655_b(regName);
        ItemInit.ITEMS.add(this);
    }

    @Override
    public float reduceMaxDamage(Player player, boolean isMainHand, float damage, float reductionMultiplier, ItemStack stack) {
        float newMulti = reductionMultiplier;
        newMulti = player.func_110143_aJ() > player.func_110138_aP() / 2.0f ? (newMulti -= 0.2f) : (newMulti -= 0.5f);
        return newMulti;
    }

    @Override
    public float nullableReaction(Player player, boolean isMainHand, float originalDamage, float newDamage, ItemStack stack) {
        float mitigated_damage = originalDamage - newDamage;
        Level world = player.field_70170_p;
        if (!world.field_72995_K) {
            world.func_184133_a(null, player.func_180425_c(), SoundInit.ITEM_AXIOMAVORUM, SoundSource.MASTER, 1.0f, 0.5f + world.field_73012_v.nextFloat());
            for (LivingEntity near_creature : player.field_70170_p.func_72872_a(LivingEntity.class, player.func_174813_aQ().func_72314_b(30.0, 30.0, 30.0))) {
                if (near_creature.func_110124_au().equals(player.func_110124_au())) continue;
                IMaxAttack.dealTrueDamage((Entity)player, near_creature, mitigated_damage);
                CustomParticleConfig config1 = new CustomParticleConfig();
                config1.createInstance().setParticle(ParticleInit.QUANTUM_MARK).setSpread(2.0, 1.0, 2.0).setCount(10).setIgnoreRange(true);
                IParticleSpawner.spawnParticle(world, config1, near_creature.field_70165_t, near_creature.field_70163_u + (double)(near_creature.field_70131_O / 2.0f), near_creature.field_70161_v);
            }
        }
        return newDamage;
    }

    @SideOnly(value=Side.CLIENT)
    public void func_77624_a(ItemStack stack, @Nullable Level worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add((Object)((Object)TextFmt.Light_Purple) + "When held, reduces max health damage taken by 20%.");
        tooltip.add((Object)((Object)TextFmt.Gold) + "When below 50% health, reduce max health damage by 50% instead.");
        tooltip.add((Object)((Object)TextFmt.Aqua) + "Mitigated damage is dealt to all creatures in a 30 block radius.");
    }
}

