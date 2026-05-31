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
 *  net.minecraft.util.EnumParticleTypes
 *  net.minecraft.util.SoundSource
 *  net.minecraft.world.World
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package xol.lostinfinity.item.weapon;

import java.util.List;
import java.util.UUID;
import javax.annotation.Nullable;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.init.TabsInit;
import xol.lostinfinity.item.basics.ItemCooldown;
import xol.lostinfinity.item.classify.ICustomHoldPose;
import xol.lostinfinity.item.classify.ICustomRaytrace;
import xol.lostinfinity.projectile.entity.EntityForbiddenBrand;
import xol.lostinfinity.util.data.CustomHitResult;
import xol.lostinfinity.util.data.IMaxAttack;

public class ItemBrandOfTheForbidden
extends ItemCooldown
implements IMaxAttack,
ICustomRaytrace,
ICustomHoldPose {
    public ItemBrandOfTheForbidden(String regName) {
        super(regName);
        this.func_77637_a(TabsInit.TAB_AUXWEP);
    }

    public InteractionResultHolder<ItemStack> func_77659_a(Level worldIn, Player playerIn, InteractionHand handIn) {
        ItemStack stack = playerIn.func_184586_b(handIn);
        if (!this.showDurabilityBar(stack)) {
            if (!worldIn.field_72995_K) {
                CustomHitResult trace_result = this.standardFXTrace(worldIn, (LivingEntity)playerIn, 45, EnumParticleTypes.TOTEM, LivingEntity.class);
                if (trace_result != null && trace_result.getResultEntity() != null) {
                    EntityForbiddenBrand existing;
                    UUID brandUUID = stack.func_77978_p().func_186857_a("brandID");
                    if (this.isExistingBrand(brandUUID) && (existing = (EntityForbiddenBrand)worldIn.func_73046_m().func_175576_a(brandUUID)) != null) {
                        existing.func_70106_y();
                    }
                    LivingEntity hit_entity = (LivingEntity)trace_result.getResultEntity();
                    EntityForbiddenBrand brand = new EntityForbiddenBrand(worldIn);
                    brand.func_70107_b(hit_entity.field_70165_t, hit_entity.field_70163_u, hit_entity.field_70161_v);
                    brand.setCreator(playerIn);
                    brand.setTarget(hit_entity);
                    worldIn.func_72838_d((Entity)brand);
                    stack.func_77978_p().func_186854_a("brandID", brand.func_110124_au());
                }
                worldIn.func_184133_a(null, playerIn.func_180425_c(), SoundInit.MAGIC_WEAPON_15, SoundSource.PLAYERS, 0.7f, 0.7f + worldIn.field_73012_v.nextFloat() * 0.6f);
            }
            playerIn.func_184586_b(handIn).func_77978_p().func_74772_a("lastUse", System.currentTimeMillis());
        }
        return super.func_77659_a(worldIn, playerIn, handIn);
    }

    private boolean isExistingBrand(UUID idToCheck) {
        return idToCheck != null && !idToCheck.equals(UUID.fromString("00000000-0000-0000-0000-000000000000"));
    }

    @Override
    protected int getCooldown() {
        return 1000;
    }

    @SideOnly(value=Side.CLIENT)
    public void func_77624_a(ItemStack stack, @Nullable Level worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add((Object)((Object)TextFmt.Light_Purple) + "Puts a forbidden brand on a target that you are looking at.");
        tooltip.add((Object)((Object)TextFmt.Gold) + "Forbidden Brand Deals Max Health Damage Rapidly");
        tooltip.add((Object)((Object)TextFmt.Red) + "Can only have one brand active at a time.");
    }
}

