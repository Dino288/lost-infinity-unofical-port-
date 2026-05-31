/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.ResourceLocation
 *  net.minecraftforge.fluids.Fluid
 */
package xol.lostinfinity.fluid;

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.fluids.Fluid;
import xol.lostinfinity.init.FluidInit;

public class FluidLiquid
extends Fluid {
    public FluidLiquid(String fluidName, ResourceLocation still, ResourceLocation flowing) {
        super(fluidName, still, flowing);
        FluidInit.FLUIDS.add(this);
    }
}

