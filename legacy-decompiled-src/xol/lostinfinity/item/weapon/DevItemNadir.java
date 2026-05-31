/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.base.Predicate
 *  javax.annotation.Nullable
 *  net.minecraft.client.util.ITooltipFlag
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.item.EnumRarity
 *  net.minecraft.item.ItemStack
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.util.InteractionResultHolder
 *  net.minecraft.util.InteractionHand
 *  net.minecraft.util.EnumParticleTypes
 *  net.minecraft.util.math.Vec3
 *  net.minecraft.world.World
 *  net.minecraftforge.common.IRarity
 */
package xol.lostinfinity.item.weapon;

import com.google.common.base.Predicate;
import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.item.EnumRarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.IRarity;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.ParticleInit;
import xol.lostinfinity.item.basics.ItemCooldown;
import xol.lostinfinity.item.classify.ICustomRaytrace;
import xol.lostinfinity.item.classify.IModeSelect;
import xol.lostinfinity.mob.entity.base.EntityImmaterial;
import xol.lostinfinity.mob.entity.base.EntityMultipleLives;
import xol.lostinfinity.util.data.CustomParticleConfig;
import xol.lostinfinity.util.data.CustomHitResult;
import xol.lostinfinity.util.data.IMaxAttack;
import xol.lostinfinity.util.data.RayTraceBuilder;
import xol.lostinfinity.util.fx.IParticleSpawner;

public class DevItemNadir
extends ItemCooldown
implements IMaxAttack,
IModeSelect,
ICustomRaytrace {
    public DevItemNadir(String regName) {
        super(regName);
    }

    public InteractionResultHolder<ItemStack> func_77659_a(Level worldIn, Player playerIn, InteractionHand handIn) {
        ItemStack stack = playerIn.func_184586_b(handIn);
        if (!this.showDurabilityBar(stack)) {
            CustomHitResult trace_result;
            if (!worldIn.field_72995_K && (trace_result = RayTraceBuilder.fx(LivingEntity.class, 75, EnumParticleTypes.SMOKE_NORMAL).entityFilter((Predicate<Entity>)((Predicate)input -> !(input instanceof EntityImmaterial) && !input.field_70128_L)).trace((Entity)playerIn, true)) != null && trace_result.getResultEntity() != null) {
                LivingEntity target = (LivingEntity)trace_result.getResultEntity();
                if (target instanceof EntityMultipleLives) {
                    EntityMultipleLives ml = (EntityMultipleLives)target;
                    switch (this.getMode(stack)) {
                        case INSTANT: {
                            ml.takeawayNumLives(ml.remainingLives() + 1);
                            break;
                        }
                        case ONE_LIFE: {
                            ml.takeawayNumLives(100);
                        }
                    }
                } else {
                    target.func_70606_j(0.0f);
                }
                double size = target.func_174813_aQ().func_72320_b();
                Vec3 loc = new Vec3(target.field_70165_t, target.field_70163_u + (double)(target.field_70131_O / 2.0f), target.field_70161_v);
                CustomParticleConfig config = new CustomParticleConfig();
                config.setCount(10);
                config.createInstance().setParticle(ParticleInit.PRISMATIC_EXPLOSION_TYPE1).setSpread(size / 2.0, size / 2.0, size / 2.0).setIgnoreRange(true);
                config.createInstance().setParticle(ParticleInit.PRISMATIC_EXPLOSION_TYPE2).setSpread(size / 2.0, size / 2.0, size / 2.0).setIgnoreRange(true);
                config.createInstance().setParticle(ParticleInit.PRISMATIC_EXPLOSION_TYPE3).setSpread(size / 2.0, size / 2.0, size / 2.0).setIgnoreRange(true);
                IParticleSpawner.spawnParticle(worldIn, config, loc);
            }
            playerIn.func_184586_b(handIn).func_77978_p().func_74772_a("lastUse", System.currentTimeMillis());
        }
        return super.func_77659_a(worldIn, playerIn, handIn);
    }

    @Override
    protected int getCooldown() {
        return 50;
    }

    @Override
    public void modeUpdate(ItemStack stack, Player player) {
        this.cycleMode(stack);
    }

    public void func_77624_a(ItemStack stack, @Nullable Level worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add(TextFmt.getFormatting(TextFmt.Dark_Red, TextFmt.Bold) + "Developer Item");
    }

    private void cycleMode(ItemStack stack) {
        if (!stack.func_77942_o()) {
            stack.func_77982_d(new CompoundTag());
        }
        stack.func_77978_p().func_74768_a("blade_mode", (stack.func_77978_p().func_74762_e("blade_mode") + 1) % BladeMode.values().length);
    }

    private BladeMode getMode(ItemStack stack) {
        if (!stack.func_77942_o()) {
            stack.func_77982_d(new CompoundTag());
            return BladeMode.INSTANT;
        }
        return BladeMode.values()[stack.func_77978_p().func_74762_e("blade_mode")];
    }

    public String getHighlightTip(ItemStack item, String displayName) {
        switch (this.getMode(item)) {
            case INSTANT: {
                return displayName + " - Instant Kill";
            }
            case ONE_LIFE: {
                return displayName + " - Remove Life";
            }
        }
        return displayName;
    }

    public IRarity getForgeRarity(ItemStack stack) {
        return EnumRarity.EPIC;
    }

    public static enum BladeMode {
        INSTANT,
        ONE_LIFE;

    }
}

