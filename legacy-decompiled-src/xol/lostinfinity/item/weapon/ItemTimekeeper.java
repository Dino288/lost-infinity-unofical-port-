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
 *  net.minecraft.util.EnumParticleTypes
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
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.PotionInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.init.TabsInit;
import xol.lostinfinity.item.basics.ItemCooldown;
import xol.lostinfinity.item.classify.ICustomHoldPose;
import xol.lostinfinity.item.classify.ICustomRaytrace;
import xol.lostinfinity.util.data.CustomHitResult;
import xol.lostinfinity.util.data.IMaxAttack;

public class ItemTimekeeper
extends ItemCooldown
implements IMaxAttack,
ICustomRaytrace,
ICustomHoldPose {
    public ItemTimekeeper(String regName) {
        super(regName);
        this.func_77637_a(TabsInit.TAB_AUXWEP);
    }

    public InteractionResultHolder<ItemStack> func_77659_a(Level worldIn, Player playerIn, InteractionHand handIn) {
        ItemStack stack = playerIn.func_184586_b(handIn);
        if (!this.showDurabilityBar(stack)) {
            if (!worldIn.field_72995_K) {
                CustomHitResult trace_result = this.standardFXTrace(worldIn, (LivingEntity)playerIn, 45, EnumParticleTypes.SMOKE_NORMAL, LivingEntity.class);
                if (trace_result != null && trace_result.getResultEntity() != null) {
                    LivingEntity hit_entity = (LivingEntity)trace_result.getResultEntity();
                    int level = 0;
                    if (hit_entity.func_70644_a(PotionInit.SPONTANEOUS_COMBUSTION)) {
                        level = hit_entity.func_70660_b(PotionInit.SPONTANEOUS_COMBUSTION).func_76458_c() + 1;
                    }
                    hit_entity.func_70690_d(new PotionEffect(PotionInit.SPONTANEOUS_COMBUSTION, 80, level));
                }
                worldIn.func_184133_a(null, playerIn.func_180425_c(), SoundInit.GENERIC_WEAPON_15, SoundSource.PLAYERS, 1.0f, 0.7f + worldIn.field_73012_v.nextFloat() * 0.6f);
                worldIn.func_184133_a(null, playerIn.func_180425_c(), SoundInit.GENERIC_WEAPON_17, SoundSource.PLAYERS, 1.0f, 1.0f);
            }
            playerIn.func_184586_b(handIn).func_77978_p().func_74772_a("lastUse", System.currentTimeMillis());
        }
        return super.func_77659_a(worldIn, playerIn, handIn);
    }

    @Override
    protected int getCooldown() {
        return 750;
    }

    @SideOnly(value=Side.CLIENT)
    public void func_77624_a(ItemStack stack, @Nullable Level worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add((Object)((Object)TextFmt.Red) + "Fires a round that explodes after some time.");
        tooltip.add((Object)((Object)TextFmt.Italic) + "(Applies Spontaneous Combustion)");
        tooltip.add((Object)((Object)TextFmt.Gold) + "Shooting a target with a round in them increases the damage of the round.");
    }
}

