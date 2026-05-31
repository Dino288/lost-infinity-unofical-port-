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
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.ParticleInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.init.TabsInit;
import xol.lostinfinity.item.classify.ICustomRaytrace;
import xol.lostinfinity.item.weapon.ItemCooldownSword;
import xol.lostinfinity.item.weapon.ItemHypercron;
import xol.lostinfinity.util.data.CustomParticleConfig;
import xol.lostinfinity.util.data.CustomHitResult;
import xol.lostinfinity.util.data.IMaxAttack;
import xol.lostinfinity.util.fx.IParticleSpawner;

public class ItemHyperKnuckle
extends ItemCooldownSword
implements IMaxAttack,
ICustomRaytrace {
    public ItemHyperKnuckle(String regName) {
        super(regName);
        this.func_77637_a(TabsInit.TAB_INFINITYWEP);
    }

    public boolean func_77644_a(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        float damageDealt = IMaxAttack.dealMaxHealth((Entity)attacker, target, 4, 3.0f).getDamageDealt();
        attacker.func_70691_i(damageDealt);
        return true;
    }

    public InteractionResultHolder<ItemStack> func_77659_a(Level worldIn, Player playerIn, InteractionHand handIn) {
        ItemStack stack;
        if (handIn == InteractionHand.MAIN_HAND && !this.showDurabilityBar(stack = playerIn.func_184586_b(handIn))) {
            if (!worldIn.field_72995_K) {
                LivingEntity tracedEntity;
                CustomHitResult trace_result;
                boolean hasOffhand;
                boolean bl = hasOffhand = playerIn.func_184592_cb().func_77973_b() instanceof ItemHyperKnuckle || playerIn.func_184592_cb().func_77973_b() instanceof ItemHypercron;
                if (hasOffhand && (trace_result = this.entityTrace(worldIn, (LivingEntity)playerIn, 10, LivingEntity.class)) != null && trace_result.getResultEntity() != null && (tracedEntity = (LivingEntity)trace_result.getResultEntity()).func_110143_aJ() < tracedEntity.func_110138_aP() / 3.0f) {
                    playerIn.func_70634_a(tracedEntity.field_70165_t, tracedEntity.field_70163_u, tracedEntity.field_70161_v);
                    playerIn.func_70691_i(playerIn.func_110138_aP());
                    IMaxAttack.dealTrueDamage((Entity)playerIn, tracedEntity, tracedEntity.func_110143_aJ() * 2.0f);
                    worldIn.func_184133_a(null, tracedEntity.func_180425_c(), SoundInit.EXECUTE_EFFECT, SoundSource.PLAYERS, 1.0f, 0.8f + worldIn.field_73012_v.nextFloat() * 0.4f);
                    CustomParticleConfig config1 = new CustomParticleConfig();
                    config1.createInstance().setParticle(ParticleInit.CLAW_MARKS).setSpread(4.0, 1.0, 4.0).setCount(8).setIgnoreRange(true);
                    IParticleSpawner.spawnParticle(worldIn, config1, tracedEntity.field_70165_t, tracedEntity.field_70163_u + (double)(tracedEntity.field_70131_O / 2.0f), tracedEntity.field_70161_v);
                }
            }
            playerIn.func_184586_b(handIn).func_77978_p().func_74772_a("lastUse", System.currentTimeMillis());
        }
        return super.func_77659_a(worldIn, playerIn, handIn);
    }

    @Override
    protected int getCooldown() {
        return 500;
    }

    @SideOnly(value=Side.CLIENT)
    public void func_77624_a(ItemStack stack, @Nullable Level worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add((Object)((Object)TextFmt.Light_Purple) + "Deals 75% Max Health Damage");
        tooltip.add((Object)((Object)TextFmt.Green) + "Lifesteals for 100% of Damage Dealt");
        tooltip.add((Object)((Object)TextFmt.Gold) + "If also wielding a Hyper Knuckle in the offhand:");
        tooltip.add((Object)((Object)TextFmt.Italic) + "Right Click to execute a nearby target below 33% health, dashing to them.");
        tooltip.add((Object)((Object)TextFmt.Italic) + "Executing a target heals you to full.");
    }
}

