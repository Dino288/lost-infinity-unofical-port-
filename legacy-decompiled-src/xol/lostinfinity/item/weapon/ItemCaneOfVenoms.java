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
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.util.InteractionResultHolder
 *  net.minecraft.util.InteractionHand
 *  net.minecraft.util.EnumParticleTypes
 *  net.minecraft.util.ResourceLocation
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
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.ParticleInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.init.TabsInit;
import xol.lostinfinity.item.classify.ICustomRaytrace;
import xol.lostinfinity.item.classify.IModeSelect;
import xol.lostinfinity.item.weapon.ItemCooldownSword;
import xol.lostinfinity.util.data.CustomParticleConfig;
import xol.lostinfinity.util.data.CustomHitResult;
import xol.lostinfinity.util.data.IMaxAttack;
import xol.lostinfinity.util.fx.IParticleSpawner;

public class ItemCaneOfVenoms
extends ItemCooldownSword
implements IMaxAttack,
ICustomRaytrace,
IModeSelect {
    private static final String MODE = "bane_mode";

    public ItemCaneOfVenoms(String regName) {
        super(regName);
        this.func_77637_a(TabsInit.TAB_AUXWEP);
        this.func_185043_a(new ResourceLocation("lostinfinity", MODE), (stack, worldIn, entityIn) -> this.isBaneMode(stack) ? 1.0f : 0.0f);
    }

    public boolean func_77644_a(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        int potion_count;
        if (this.isBaneMode(stack) && (potion_count = target.func_70651_bq().size()) > 0) {
            IMaxAttack.dealMaxHealth((Entity)attacker, target, 5, potion_count);
        }
        return true;
    }

    public String func_77667_c(ItemStack stack) {
        return this.isBaneMode(stack) ? "item.bane_of_venoms" : "item.cane_of_venoms";
    }

    public InteractionResultHolder<ItemStack> func_77659_a(Level worldIn, Player playerIn, InteractionHand handIn) {
        ItemStack stack = playerIn.func_184586_b(handIn);
        if (!this.showDurabilityBar(stack) && !this.isBaneMode(stack)) {
            CustomHitResult trace_result;
            if (!worldIn.field_72995_K && (trace_result = this.standardFXTrace(worldIn, (LivingEntity)playerIn, 45, EnumParticleTypes.SMOKE_NORMAL, LivingEntity.class)) != null && trace_result.getResultEntity() != null) {
                LivingEntity target = (LivingEntity)trace_result.getResultEntity();
                int potion_count = target.func_70651_bq().size();
                if (potion_count > 0) {
                    IMaxAttack.dealMaxHealth((Entity)playerIn, target, 10, potion_count);
                }
                CustomParticleConfig config1 = new CustomParticleConfig();
                config1.createInstance().setParticle(ParticleInit.VENOM).setSpread(4.0, 1.0, 4.0).setCount(10).setIgnoreRange(true);
                CustomParticleConfig config2 = new CustomParticleConfig();
                config2.createInstance().setParticle(ParticleInit.VENOM_RING).setSpread(1.0, 1.0, 1.0).setCount(5).setIgnoreRange(true);
                IParticleSpawner.spawnParticle(worldIn, config1, target.field_70165_t, target.field_70163_u + (double)(target.field_70131_O / 2.0f), target.field_70161_v);
                IParticleSpawner.spawnParticle(worldIn, config2, target.field_70165_t, target.field_70163_u + (double)(target.field_70131_O / 2.0f), target.field_70161_v);
            }
            worldIn.func_184133_a(null, playerIn.func_180425_c(), SoundInit.MAGIC_WEAPON_5, SoundSource.PLAYERS, 1.0f, 0.8f + worldIn.field_73012_v.nextFloat() * 0.4f);
            playerIn.func_184586_b(handIn).func_77978_p().func_74772_a("lastUse", System.currentTimeMillis());
        }
        return super.func_77659_a(worldIn, playerIn, handIn);
    }

    @Override
    protected int getCooldown() {
        return 100;
    }

    @SideOnly(value=Side.CLIENT)
    public void func_77624_a(ItemStack stack, @Nullable Level worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        if (this.isBaneMode(stack)) {
            tooltip.add((Object)((Object)TextFmt.Light_Purple) + "Per Potion Effect on Target:");
            tooltip.add((Object)((Object)TextFmt.Gold) + "Deals 20% Max Health Damage");
        } else {
            tooltip.add((Object)((Object)TextFmt.Gold) + "Fires a projectile that deals damage based on potion effects.");
            tooltip.add((Object)((Object)TextFmt.Light_Purple) + "Per Potion Effect on Target:");
            tooltip.add((Object)((Object)TextFmt.Gold) + "Deals 10% Max Health Damage");
        }
        tooltip.add((Object)((Object)TextFmt.Green) + "Shift Right-Click: Swap between Cane & Bane");
    }

    private void toggleBaneMode(ItemStack stack) {
        this.setBaneMode(stack, !this.isBaneMode(stack));
    }

    private void setBaneMode(ItemStack stack, boolean flag) {
        if (!stack.func_77942_o()) {
            stack.func_77982_d(new CompoundTag());
        }
        stack.func_77978_p().func_74757_a(MODE, flag);
    }

    private boolean isBaneMode(ItemStack stack) {
        if (!stack.func_77942_o()) {
            stack.func_77982_d(new CompoundTag());
            stack.func_77978_p().func_74757_a(MODE, false);
            return false;
        }
        return stack.func_77978_p().func_74767_n(MODE);
    }

    @Override
    public void modeUpdate(ItemStack stack, Player player) {
        this.toggleBaneMode(stack);
    }
}

