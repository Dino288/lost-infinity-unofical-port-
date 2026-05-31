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
package xol.lostinfinity.item.weapon;

import java.util.ArrayList;
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
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.init.TabsInit;
import xol.lostinfinity.item.classify.ICustomRaytrace;
import xol.lostinfinity.item.weapon.ItemCooldownSword;
import xol.lostinfinity.util.PotionBasic;
import xol.lostinfinity.util.data.CustomHitResult;
import xol.lostinfinity.util.data.IMaxAttack;

public class ItemPhantomBlade
extends ItemCooldownSword
implements IMaxAttack,
ICustomRaytrace {
    public ItemPhantomBlade(String regName) {
        super(regName);
        this.func_77637_a(TabsInit.TAB_INFINITYWEP);
    }

    public boolean func_77644_a(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        IMaxAttack.dealMaxHealth((Entity)attacker, target, 4, 3.0f);
        return true;
    }

    @Override
    protected int getCooldown() {
        return 500;
    }

    public InteractionResultHolder<ItemStack> func_77659_a(Level worldIn, Player playerIn, InteractionHand handIn) {
        ItemStack stack = playerIn.func_184586_b(handIn);
        if (!this.showDurabilityBar(stack)) {
            CustomHitResult trace_result;
            if (!worldIn.field_72995_K && (trace_result = this.complexTrace(worldIn, (LivingEntity)playerIn, 25, null, 0, 0, false, LivingEntity.class, 1, 0.3f)) != null && trace_result.getResultEntity() != null) {
                LivingEntity tracedEntity = (LivingEntity)trace_result.getResultEntity();
                playerIn.func_70634_a(tracedEntity.field_70165_t, tracedEntity.field_70163_u, tracedEntity.field_70161_v);
                worldIn.func_184133_a(null, tracedEntity.func_180425_c(), SoundInit.ITEM_GHOSTHUNTER, SoundSource.MASTER, 2.0f, 1.0f);
                ArrayList<PotionEffect> effectsToAdd = new ArrayList<PotionEffect>();
                for (PotionEffect effect : playerIn.func_70651_bq()) {
                    PotionBasic basicPot;
                    Potion effPot = effect.func_188419_a();
                    if (effPot.func_76398_f()) {
                        effectsToAdd.add(effect);
                        continue;
                    }
                    if (!(effPot instanceof PotionBasic) || !(basicPot = (PotionBasic)effPot).negativeLostEffect()) continue;
                    effectsToAdd.add(effect);
                }
                if (effectsToAdd.size() > 0 && IMaxAttack.dealMaxHealth((Entity)playerIn, tracedEntity, 10, effectsToAdd.size()).didSuccessfulHit()) {
                    for (PotionEffect effect : effectsToAdd) {
                        tracedEntity.func_70690_d(effect);
                    }
                }
                playerIn.func_70674_bp();
            }
            playerIn.func_184586_b(handIn).func_77978_p().func_74772_a("lastUse", System.currentTimeMillis());
        }
        return super.func_77659_a(worldIn, playerIn, handIn);
    }

    @SideOnly(value=Side.CLIENT)
    public void func_77624_a(ItemStack stack, @Nullable Level worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add((Object)((Object)TextFmt.Gold) + "Deals 75% Max Health Damage");
        tooltip.add((Object)((Object)TextFmt.Dark_Purple) + "Right click to teleport up to 20 blocks to an entity through walls.");
        tooltip.add((Object)((Object)TextFmt.Aqua) + "Teleporting to an entity transfers ALL negative potion effects to them.");
        tooltip.add((Object)((Object)TextFmt.Dark_Purple) + "Teleporting deals 10% Max Health Damage per effect transferred.");
    }
}

