/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.block.material.Material
 *  net.minecraft.block.state.BlockState
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.init.Blocks
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.world.World
 *  net.minecraftforge.event.entity.player.FillBucketEvent
 *  net.minecraftforge.fluids.Fluid
 *  net.minecraftforge.fluids.FluidRegistry
 *  net.minecraftforge.fluids.FluidStack
 *  net.minecraftforge.fluids.FluidUtil
 *  net.minecraftforge.fml.common.eventhandler.Event$Result
 */
package xol.lostinfinity.block.misc;

import net.minecraft.world.level.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.player.FillBucketEvent;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidUtil;
import net.minecraftforge.fml.common.eventhandler.Event;
import xol.lostinfinity.block.basic.BlockBasicFluid;
import xol.lostinfinity.init.BlockInit;
import xol.lostinfinity.init.DimensionInit;
import xol.lostinfinity.util.damagesource.LostDamageSources;
import xol.lostinfinity.util.data.IMaxAttack;

public class BlockConcentratedAcid
extends BlockBasicFluid
implements IMaxAttack {
    public BlockConcentratedAcid(String name, Fluid fluid, Material material) {
        super(name, fluid, material);
        BlockInit.BLOCKS.add((Block)this);
    }

    public void func_180634_a(Level worldIn, BlockPos pos, BlockState state, Entity entityIn) {
        boolean isImmuneToAcid = false;
        if (!isImmuneToAcid && entityIn instanceof LivingEntity) {
            LivingEntity e = (LivingEntity)entityIn;
            if (entityIn instanceof Player && ((Player)entityIn).func_184812_l_()) {
                return;
            }
            e.func_70097_a(LostDamageSources.CONCENTRATED_ACID.source, e.func_110138_aP() / 3.0f);
        }
    }

    @Override
    public void handleFill(FillBucketEvent event, BlockState bs) {
        boolean result = false;
        if (((Object)((Object)((BlockBasicFluid)bs.func_177230_c()))).equals(this)) {
            if (!event.getWorld().func_180494_b(event.getTarget().func_178782_a()).equals(DimensionInit.biomeCelestialArena)) {
                event.getWorld().func_175656_a(event.getTarget().func_178782_a(), Blocks.field_150350_a.func_176223_P());
            }
            event.setFilledBucket(FluidUtil.getFilledBucket((FluidStack)FluidRegistry.getFluidStack((String)this.fluidName, (int)1000)));
            event.setResult(Event.Result.ALLOW);
            result = true;
        }
        event.setResult(result ? Event.Result.ALLOW : Event.Result.DENY);
    }
}

