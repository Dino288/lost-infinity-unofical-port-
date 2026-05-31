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
 *  net.minecraft.item.ItemStack
 *  net.minecraft.nbt.CompoundTag
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
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
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
import xol.lostinfinity.item.basics.ItemBasic;
import xol.lostinfinity.item.classify.ICustomHoldPose;
import xol.lostinfinity.item.classify.ICustomRaytrace;
import xol.lostinfinity.item.classify.ISwitchModels;
import xol.lostinfinity.util.data.CustomParticleConfig;
import xol.lostinfinity.util.data.CustomHitResult;
import xol.lostinfinity.util.fx.IParticleSpawner;

public class ItemAttractorBeam
extends ItemBasic
implements ICustomRaytrace,
ICustomHoldPose,
ISwitchModels {
    public ItemAttractorBeam(String regName) {
        super(regName, TabsInit.TAB_AUXWEP);
        this.setModelSwitch("beamtype", this, 2);
    }

    public InteractionResultHolder<ItemStack> func_77659_a(Level worldIn, Player playerIn, InteractionHand handIn) {
        CustomHitResult trace_result;
        ItemStack stack = playerIn.func_184586_b(handIn);
        if (!stack.func_77942_o()) {
            stack.func_77982_d(new CompoundTag());
            stack.func_77978_p().func_74768_a("beamtype_data", 0);
        }
        if (playerIn.func_70093_af()) {
            if (stack.func_77978_p().func_74762_e("beamtype_data") == 0) {
                stack.func_77978_p().func_74768_a("beamtype_data", 1);
            } else {
                stack.func_77978_p().func_74768_a("beamtype_data", 0);
            }
            worldIn.func_184133_a(null, playerIn.func_180425_c(), SoundEvents.field_187556_aj, SoundSource.MASTER, 1.0f, 1.0f);
        } else if (!worldIn.field_72995_K && (trace_result = this.complexTrace(worldIn, (LivingEntity)playerIn, 90, null, 3, 1, false, Entity.class, 1, 1.5f)) != null && trace_result.getResultEntity() != null) {
            double zvelo;
            boolean y_condition;
            Entity beamed_entity = trace_result.getResultEntity();
            boolean repelling = stack.func_77978_p().func_74762_e("beamtype_data") == 1;
            double x_attract = 0.2;
            double z_attract = 0.2;
            double yDiff = Math.signum(playerIn.field_70163_u - beamed_entity.field_70163_u);
            boolean bl = y_condition = yDiff > 0.0 && !repelling || yDiff < 0.0 && repelling;
            if (repelling) {
                x_attract *= -1.0;
                z_attract *= -1.0;
            }
            double xdifference = Math.signum(playerIn.field_70165_t - beamed_entity.field_70165_t);
            double zdifference = Math.signum(playerIn.field_70161_v - beamed_entity.field_70161_v);
            if (Math.abs(xdifference) < 2.0) {
                x_attract *= 0.5;
            }
            if (Math.abs(zdifference) < 2.0) {
                z_attract *= 0.5;
            }
            double xvelo = xdifference > 0.0 ? x_attract : -x_attract;
            double d = zvelo = zdifference > 0.0 ? z_attract : -z_attract;
            if (xvelo > 0.0 && beamed_entity.field_70159_w < 0.2 || xvelo < 0.0 && beamed_entity.field_70159_w > 0.2) {
                xvelo *= 4.0;
            }
            if (zvelo > 0.0 && beamed_entity.field_70179_y < 0.2 || zvelo < 0.0 && beamed_entity.field_70179_y > 0.2) {
                zvelo *= 4.0;
            }
            beamed_entity.func_70024_g(xvelo, y_condition ? 0.5 : 0.0, zvelo);
            beamed_entity.field_70133_I = true;
            CustomParticleConfig config1 = new CustomParticleConfig();
            config1.createInstance().setParticle(repelling ? ParticleInit.REPEL_FIELD : ParticleInit.ATTRACT_FIELD).setSpread(1.0, 1.0, 1.0).setCount(3).setIgnoreRange(true);
            IParticleSpawner.spawnParticle(worldIn, config1, beamed_entity.field_70165_t, beamed_entity.field_70163_u + (double)(beamed_entity.field_70131_O / 2.0f), beamed_entity.field_70161_v);
            worldIn.func_184133_a(null, playerIn.func_180425_c(), repelling ? SoundInit.ENTITY_PUSH : SoundInit.ENTITY_PULL, SoundSource.MASTER, 1.0f, 1.0f);
        }
        return super.func_77659_a(worldIn, playerIn, handIn);
    }

    @SideOnly(value=Side.CLIENT)
    public void func_77624_a(ItemStack stack, @Nullable Level worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add((Object)((Object)TextFmt.Aqua) + "Can be switched between a beam that pulls entities and pushes entities.");
    }
}

