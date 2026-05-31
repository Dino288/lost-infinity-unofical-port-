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
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
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
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.init.TabsInit;
import xol.lostinfinity.item.classify.ISwitchModels;
import xol.lostinfinity.projectile.entity.EntityAvenger;
import xol.lostinfinity.util.PotionBasic;
import xol.lostinfinity.util.data.CustomDamageResult;
import xol.lostinfinity.util.data.IMaxAttack;

public class ItemAvenger
extends SwordItem
implements ISwitchModels,
IMaxAttack {
    public ItemAvenger(String regName) {
        super(Item.ToolMaterial.DIAMOND);
        this.func_77637_a(TabsInit.TAB_INFINITYWEP);
        this.setRegistryName(regName);
        this.func_77655_b(regName);
        this.func_77625_d(1);
        this.setModelSwitch("empty", (Item)this, 2);
        ItemInit.ITEMS.add((Item)this);
    }

    public boolean func_77644_a(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        CustomDamageResult dr = IMaxAttack.dealTrueDamage((Entity)attacker, target, target.func_110138_aP() * 0.5f, Arrays.asList("Aquatic"));
        float damageDealt = dr.getDamageDealt();
        if (dr.wasTargetKilled()) {
            this.killReward(attacker);
        } else {
            attacker.func_70691_i(damageDealt);
        }
        attacker.field_70170_p.func_184133_a(null, attacker.func_180425_c(), SoundInit.SWING_HIT, SoundSource.PLAYERS, 1.5f, 0.6f + attacker.field_70170_p.field_73012_v.nextFloat() * 0.4f);
        return true;
    }

    public InteractionResultHolder<ItemStack> func_77659_a(Level worldIn, Player playerIn, InteractionHand handIn) {
        int mode;
        ItemStack stack = playerIn.func_184586_b(handIn);
        if (!stack.func_77942_o()) {
            stack.func_77982_d(new CompoundTag());
        }
        if ((mode = stack.func_77978_p().func_74762_e("empty_data")) == 0) {
            if (!worldIn.field_72995_K) {
                EntityAvenger shot = new EntityAvenger(worldIn, (LivingEntity)playerIn);
                shot.setThrower((LivingEntity)playerIn);
                shot.func_184538_a((Entity)playerIn, playerIn.field_70125_A, playerIn.field_70177_z, 0.0f, 2.0f, 0.0f);
                worldIn.func_72838_d((Entity)shot);
                worldIn.func_184133_a(null, playerIn.func_180425_c(), SoundEvents.field_187737_v, SoundSource.PLAYERS, 1.0f, 1.0f);
            }
            stack.func_77978_p().func_74768_a("empty_data", 1);
        }
        return super.func_77659_a(worldIn, playerIn, handIn);
    }

    private void killReward(LivingEntity player) {
        ArrayList<PotionEffect> potionsToAdd = new ArrayList<PotionEffect>();
        List potionList = player.func_70651_bq().stream().map(PotionEffect::func_188419_a).collect(Collectors.toList());
        for (Potion potion : potionList) {
            if (potion instanceof PotionBasic) {
                PotionBasic lost_potion = (PotionBasic)potion;
                PotionEffect scaledEffect = this.scalePotionEffect(player.func_70660_b(potion), lost_potion.negativeLostEffect());
                if (scaledEffect == null) continue;
                potionsToAdd.add(scaledEffect);
                continue;
            }
            PotionEffect scaledEffect = this.scalePotionEffect(player.func_70660_b(potion), potion.func_76398_f());
            if (scaledEffect == null) continue;
            potionsToAdd.add(scaledEffect);
        }
        player.func_70674_bp();
        for (PotionEffect pe : potionsToAdd) {
            player.func_70690_d(pe);
        }
        player.func_70691_i(player.func_110138_aP());
    }

    private PotionEffect scalePotionEffect(PotionEffect effect, boolean bad) {
        if (!bad) {
            return effect;
        }
        int level = effect.func_76458_c() - 1;
        int duration = effect.func_76459_b();
        if (level >= 0) {
            return new PotionEffect(effect.func_188419_a(), duration, level);
        }
        return null;
    }

    @SideOnly(value=Side.CLIENT)
    public void func_77624_a(ItemStack stack, @Nullable Level worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add((Object)((Object)TextFmt.Light_Purple) + "Deals 50% Health True Damage");
        tooltip.add((Object)((Object)TextFmt.Green) + "Lifesteals for 100% of Damage Dealt");
        tooltip.add((Object)((Object)TextFmt.Italic) + "Right Click to throw the hammer.");
        tooltip.add((Object)((Object)TextFmt.Gold) + "Killing a target heals you to full and reduces the level of negative effects.");
        tooltip.add((Object)((Object)TextFmt.Aqua) + "Aquatic");
    }
}

