/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.block.state.BlockState
 *  net.minecraft.client.util.ITooltipFlag
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.InteractionResultHolder
 *  net.minecraft.util.InteractionHand
 *  net.minecraft.util.SoundSource
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Vec3
 *  net.minecraft.world.World
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package xol.lostinfinity.item.weapon;

import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundSource;
import net.minecraft.core.BlockPos;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xol.lostinfinity.block.basic.BlockBasicCrop;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.BlockInit;
import xol.lostinfinity.init.ParticleInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.init.TabsInit;
import xol.lostinfinity.item.basics.ItemCooldown;
import xol.lostinfinity.item.classify.ICustomHoldPose;
import xol.lostinfinity.item.classify.ICustomRaytrace;
import xol.lostinfinity.mob.entity.misc.EntityPickleMan;
import xol.lostinfinity.util.data.CustomParticleConfig;
import xol.lostinfinity.util.data.CustomHitResult;
import xol.lostinfinity.util.data.IMaxAttack;
import xol.lostinfinity.util.fx.IParticleSpawner;

public class ItemVeggiEnigmatic
extends ItemCooldown
implements IMaxAttack,
ICustomRaytrace,
ICustomHoldPose {
    public ItemVeggiEnigmatic(String regName) {
        super(regName);
        this.func_77637_a(TabsInit.TAB_AUXWEP);
    }

    public InteractionResultHolder<ItemStack> func_77659_a(Level worldIn, Player playerIn, InteractionHand handIn) {
        ItemStack stack = playerIn.func_184586_b(handIn);
        if (!this.showDurabilityBar(stack)) {
            if (!worldIn.field_72995_K) {
                BlockBasicCrop pickleplant;
                Vec3 tracePos;
                BlockState grabbedState;
                CustomHitResult trace_result = this.immaterialTrace(worldIn, (LivingEntity)playerIn, 15);
                if (trace_result != null && (grabbedState = worldIn.func_180495_p(new BlockPos(tracePos = trace_result.getGrabbedVector()))).func_177230_c() == BlockInit.spacePickle && (pickleplant = (BlockBasicCrop)grabbedState.func_177230_c()).getCropAge(grabbedState) == 7) {
                    EntityPickleMan pickleman = new EntityPickleMan(worldIn);
                    pickleman.func_70107_b(tracePos.field_72450_a, tracePos.field_72448_b + 0.5, tracePos.field_72449_c);
                    pickleman.func_193101_c(playerIn);
                    worldIn.func_72838_d((Entity)pickleman);
                    worldIn.func_175698_g(new BlockPos(tracePos));
                    CustomParticleConfig config1 = new CustomParticleConfig();
                    config1.createInstance().setParticle(ParticleInit.NATURE_MAGIC).setSpread(4.0, 1.0, 4.0).setCount(10).setIgnoreRange(true);
                    IParticleSpawner.spawnParticle(worldIn, config1, tracePos.field_72450_a, tracePos.field_72448_b + 0.5, tracePos.field_72449_c);
                }
                worldIn.func_184133_a(null, playerIn.func_180425_c(), SoundInit.LASER_WEAPON_3, SoundSource.PLAYERS, 0.7f, 0.7f + worldIn.field_73012_v.nextFloat() * 0.6f);
            }
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
        tooltip.add((Object)((Object)TextFmt.Light_Purple) + "Shocks a target that you are looking at.");
        tooltip.add((Object)((Object)TextFmt.Gold) + "Increases level of shock is target is already shocked.");
        tooltip.add((Object)((Object)TextFmt.Gold) + "Deals 10% Max Health Damage per stack of shock.");
    }
}

