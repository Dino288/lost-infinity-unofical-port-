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
 *  net.minecraft.item.Item$ToolMaterial
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.SwordItem
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.util.SoundSource
 *  net.minecraft.util.math.Mth
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
import net.minecraft.world.item.SwordItem;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.init.ParticleInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.init.TabsInit;
import xol.lostinfinity.item.classify.IModeSelect;
import xol.lostinfinity.item.classify.ISwitchModels;
import xol.lostinfinity.util.data.CustomParticleConfig;
import xol.lostinfinity.util.data.IMaxAttack;
import xol.lostinfinity.util.fx.IParticleSpawner;

public class ItemBladeOfTheForbidden
extends SwordItem
implements IMaxAttack,
ISwitchModels,
IModeSelect {
    public ItemBladeOfTheForbidden(String regName) {
        super(Item.ToolMaterial.WOOD);
        this.func_77637_a(TabsInit.TAB_INFINITYWEP);
        this.setRegistryName(regName);
        this.func_77655_b(regName);
        ItemInit.ITEMS.add((Item)this);
        this.setModelSwitch("swordtype", (Item)this, 2);
    }

    public boolean func_77644_a(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (!stack.func_77942_o()) {
            stack.func_77982_d(new CompoundTag());
        }
        Level world = attacker.field_70170_p;
        int attack_style = stack.func_77978_p().func_74762_e("swordtype_data");
        if (attack_style == 0) {
            float lowestHP = attacker.func_110143_aJ();
            for (LivingEntity near_pl : world.func_72872_a(LivingEntity.class, attacker.func_174813_aQ().func_72314_b(25.0, 15.0, 25.0))) {
                if (near_pl.field_70128_L || !(near_pl.func_110143_aJ() < lowestHP)) continue;
                lowestHP = near_pl.func_110143_aJ();
            }
            for (LivingEntity near_pl : world.func_72872_a(LivingEntity.class, attacker.func_174813_aQ().func_72314_b(25.0, 15.0, 25.0))) {
                if (near_pl.func_110124_au().equals(attacker.func_110124_au())) continue;
                near_pl.func_70606_j(lowestHP);
                CustomParticleConfig config1 = new CustomParticleConfig();
                config1.createInstance().setParticle(ParticleInit.QUANTUM_MARK).setSpread(2.0, 1.0, 2.0).setCount(10).setIgnoreRange(true);
                IParticleSpawner.spawnParticle(world, config1, near_pl.field_70165_t, near_pl.field_70163_u + (double)(near_pl.field_70131_O / 2.0f), near_pl.field_70161_v);
            }
            if (!world.field_72995_K) {
                world.func_184133_a(null, attacker.func_180425_c(), SoundInit.GENERIC_POP, SoundSource.PLAYERS, 0.7f, 0.7f + attacker.field_70170_p.field_73012_v.nextFloat() * 0.6f);
            }
        } else {
            for (LivingEntity near_pl : world.func_72872_a(LivingEntity.class, attacker.func_174813_aQ().func_72314_b(25.0, 15.0, 25.0))) {
                if (near_pl.func_110124_au().equals(attacker.func_110124_au())) continue;
                int healthLossMulti = Mth.func_76141_d((float)(100.0f - 100.0f * (near_pl.func_110143_aJ() / near_pl.func_110138_aP()) / 5.0f));
                IMaxAttack.dealMaxHealth((Entity)attacker, near_pl, 10, healthLossMulti);
            }
            if (!world.field_72995_K) {
                world.func_184133_a(null, attacker.func_180425_c(), SoundInit.GENERIC_WEAPON_7, SoundSource.PLAYERS, 0.7f, 0.7f + attacker.field_70170_p.field_73012_v.nextFloat() * 0.6f);
            }
        }
        return true;
    }

    @SideOnly(value=Side.CLIENT)
    public void func_77624_a(ItemStack stack, @Nullable Level worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add((Object)((Object)TextFmt.Light_Purple) + "Purple Side: Sets All Nearby Creatures to the Health of the LOWEST Nearby Creatures");
        tooltip.add((Object)((Object)TextFmt.Red) + "Red Side: Deals Max Health Damage Based on Missing Health To ALL Nearby Creatures");
        tooltip.add((Object)((Object)TextFmt.Red) + "Red Side: Max 200% Health Damage");
    }

    @Override
    public void modeUpdate(ItemStack stack, Player player) {
        if (!stack.func_77942_o()) {
            stack.func_77982_d(new CompoundTag());
        }
        player.field_70170_p.func_184133_a(null, player.func_180425_c(), SoundEvents.field_187750_dc, SoundSource.MASTER, 2.0f, 1.0f);
        int attack_style = stack.func_77978_p().func_74762_e("swordtype_data");
        if (attack_style == 0) {
            stack.func_77978_p().func_74768_a("swordtype_data", 1);
        } else {
            stack.func_77978_p().func_74768_a("swordtype_data", 0);
        }
    }
}

