/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.material.Material
 *  net.minecraft.block.state.BlockState
 *  net.minecraft.init.Blocks
 *  net.minecraft.util.EnumBlockRenderType
 *  net.minecraftforge.event.entity.player.FillBucketEvent
 *  net.minecraftforge.fluids.BlockFluidClassic
 *  net.minecraftforge.fluids.Fluid
 *  net.minecraftforge.fml.common.eventhandler.Event$Result
 */
package xol.lostinfinity.block.basic;

import net.minecraft.block.material.Material;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraftforge.event.entity.player.FillBucketEvent;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fml.common.eventhandler.Event;

public class BlockBasicFluid
extends BlockFluidClassic {
    public BlockBasicFluid(String name, Fluid fluid, Material material) {
        super(fluid, material);
        this.func_149663_c(name);
        this.setRegistryName(name);
    }

    public EnumBlockRenderType func_149645_b(BlockState state) {
        return EnumBlockRenderType.MODEL;
    }

    public void handleFill(FillBucketEvent event, BlockState bs) {
        if (((Object)((Object)((BlockBasicFluid)bs.func_177230_c()))).equals((Object)this)) {
            event.getWorld().func_175656_a(event.getTarget().func_178782_a(), Blocks.field_150350_a.func_176223_P());
            event.setResult(Event.Result.ALLOW);
        } else {
            event.setResult(Event.Result.DENY);
        }
    }
}

