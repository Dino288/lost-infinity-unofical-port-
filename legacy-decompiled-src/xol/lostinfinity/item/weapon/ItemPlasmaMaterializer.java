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
 *  net.minecraft.util.EnumInteractionResultHolder
 *  net.minecraft.util.InteractionHand
 *  net.minecraft.util.SoundSource
 *  net.minecraft.util.math.BlockPos
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
import net.minecraft.util.EnumInteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundSource;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.init.TabsInit;
import xol.lostinfinity.item.basics.ItemChanneling;
import xol.lostinfinity.mob.entity.misc.EntityPlasmaExplosion;
import xol.lostinfinity.util.data.CustomHitResult;
import xol.lostinfinity.util.data.IMaxAttack;
import xol.lostinfinity.util.data.RayTraceBuilder;
import xol.lostinfinity.util.fx.IParticleSpawner;

public class ItemPlasmaMaterializer
extends ItemChanneling
implements IMaxAttack {
    public ItemPlasmaMaterializer(String regName) {
        super(regName);
        this.func_77637_a(TabsInit.TAB_INFINITYWEP);
    }

    private InteractionResultHolder<ItemStack> onItemRightClick0(Level worldIn, Player playerIn, InteractionHand handIn) {
        ItemStack stack = playerIn.func_184586_b(handIn);
        if (!this.showDurabilityBar(stack) && !stack.func_77951_h()) {
            CustomHitResult trace_result;
            if (!worldIn.field_72995_K && (trace_result = RayTraceBuilder.entity(EntityPlasmaExplosion.class, 45).entityFilter(null).trace((Entity)playerIn, true)) != null) {
                if (trace_result.getResultEntity() != null) {
                    EntityPlasmaExplosion explosEntity = (EntityPlasmaExplosion)trace_result.getResultEntity();
                    if (!playerIn.func_70093_af()) {
                        explosEntity.upExplScale();
                        worldIn.func_184133_a(null, playerIn.func_180425_c(), SoundInit.GENERIC_WEAPON_2, SoundSource.MASTER, 2.0f, 1.0f + worldIn.field_73012_v.nextFloat() * 0.2f);
                    } else {
                        explosEntity.setBoom();
                    }
                } else {
                    BlockPos result_pos = trace_result.getResultPos();
                    EntityPlasmaExplosion charging_entity = new EntityPlasmaExplosion(worldIn);
                    charging_entity.setCreator(playerIn.func_110124_au());
                    charging_entity.func_70107_b(result_pos.func_177958_n(), result_pos.func_177956_o() + 1, result_pos.func_177952_p());
                    worldIn.func_72838_d((Entity)charging_entity);
                    IParticleSpawner.spawnParticle(worldIn, 2, 0, (double)result_pos.func_177958_n(), (double)(result_pos.func_177956_o() + 1), (double)result_pos.func_177952_p());
                    worldIn.func_184133_a(null, playerIn.func_180425_c(), SoundInit.GENERIC_WEAPON_1, SoundSource.MASTER, 2.0f, 1.0f);
                }
            }
            playerIn.func_184586_b(handIn).func_77978_p().func_74772_a("lastUse", System.currentTimeMillis());
        }
        return super.func_77659_a(worldIn, playerIn, handIn);
    }

    @Override
    public InteractionResultHolder<ItemStack> chargeStart(Level worldIn, Player player, InteractionHand handIn, ItemStack stack) {
        if (this.showDurabilityBar(stack) || worldIn.field_72995_K) {
            return new InteractionResultHolder(EnumInteractionResultHolder.FAIL, (Object)stack);
        }
        CustomHitResult trace = RayTraceBuilder.block(45).trace((Entity)player, true);
        if (trace == null) {
            return new InteractionResultHolder(EnumInteractionResultHolder.FAIL, (Object)stack);
        }
        BlockPos resultPos = trace.getResultPos();
        EntityPlasmaExplosion chargeEntity = new EntityPlasmaExplosion(worldIn);
        chargeEntity.setCreator(player.func_110124_au());
        chargeEntity.func_70107_b(resultPos.func_177958_n(), resultPos.func_177956_o() + 1, resultPos.func_177952_p());
        worldIn.func_72838_d((Entity)chargeEntity);
        IParticleSpawner.spawnParticle(worldIn, 2, 0, (double)resultPos.func_177958_n(), (double)(resultPos.func_177956_o() + 1), (double)resultPos.func_177952_p());
        worldIn.func_184133_a(null, player.func_180425_c(), SoundInit.GENERIC_WEAPON_1, SoundSource.MASTER, 2.0f, 1.0f);
        return new InteractionResultHolder(EnumInteractionResultHolder.SUCCESS, (Object)stack);
    }

    @Override
    public void chargeTick(Level worldIn, Player player, InteractionHand hand, ItemStack stack, int chargeTime) {
        if (chargeTime == 0 || chargeTime % 10 != 0 || this.showDurabilityBar(stack) || worldIn.field_72995_K) {
            return;
        }
        CustomHitResult trace = RayTraceBuilder.entity(EntityPlasmaExplosion.class, 45).entityFilter(null).trace((Entity)player, true);
        if (trace == null || trace.getResultEntity() == null) {
            return;
        }
        EntityPlasmaExplosion explodeEntity = (EntityPlasmaExplosion)trace.getResultEntity();
        if (explodeEntity.getExplScale() < explodeEntity.maxExpSize()) {
            worldIn.func_184133_a(null, player.func_180425_c(), SoundInit.GENERIC_WEAPON_2, SoundSource.MASTER, 2.0f, 1.0f + worldIn.field_73012_v.nextFloat() * 0.2f);
        }
        explodeEntity.upExplScale();
    }

    @Override
    public void chargeStop(ItemStack stack, Level worldIn, LivingEntity entityLiving, int chargeTime) {
        if (this.showDurabilityBar(stack) || worldIn.field_72995_K) {
            return;
        }
        CustomHitResult trace = RayTraceBuilder.entity(EntityPlasmaExplosion.class, 45).entityFilter(null).trace((Entity)entityLiving, true);
        if (trace == null || trace.getResultEntity() == null) {
            return;
        }
        EntityPlasmaExplosion explodeEntity = (EntityPlasmaExplosion)trace.getResultEntity();
        explodeEntity.setBoom();
        this.startCooldown(stack);
    }

    @Override
    protected int getCooldown() {
        return 100;
    }

    @SideOnly(value=Side.CLIENT)
    public void func_77624_a(ItemStack stack, @Nullable Level worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add((Object)((Object)TextFmt.Light_Purple) + "Places a plasma charge.");
        tooltip.add((Object)((Object)TextFmt.Green) + "If looking at an existing plasma charge, power it up.");
        tooltip.add((Object)((Object)TextFmt.Red) + "Plasma Charges can be charged to increase in size in damage before exploding.");
        tooltip.add((Object)((Object)TextFmt.Gold) + "Shift Click: Detonate Early");
    }
}

