/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.state.BlockState
 *  net.minecraft.client.renderer.ItemMeshDefinition
 *  net.minecraft.client.renderer.block.model.ModelResourceLocation
 *  net.minecraft.client.renderer.block.statemap.IStateMapper
 *  net.minecraft.client.renderer.block.statemap.StateMapperBase
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.ResourceLocation
 *  net.minecraftforge.client.model.ModelLoader
 *  net.minecraftforge.fluids.Fluid
 *  net.minecraftforge.fluids.FluidRegistry
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package xol.lostinfinity.init;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.IStateMapper;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xol.lostinfinity.block.basic.BlockBasicFluid;
import xol.lostinfinity.fluid.FluidLiquid;
import xol.lostinfinity.init.BlockInit;

public class FluidInit {
    public static final List<Fluid> FLUIDS = new ArrayList<Fluid>();
    public static Fluid concentratedAcid = FluidInit.registerLiquid("concentrated_acid");

    public static void registerFluids(Side side) {
        FLUIDS.forEach(it -> {
            FluidRegistry.registerFluid((Fluid)it);
            FluidRegistry.addBucketForFluid((Fluid)it);
        });
        if (side.isClient()) {
            BlockInit.BLOCKS.stream().filter(it -> it instanceof BlockBasicFluid).forEach(it -> FluidInit.registerCustomFluid((BlockBasicFluid)((Object)it)));
        }
    }

    private static Fluid registerLiquid(String regName) {
        return new FluidLiquid(regName, new ResourceLocation("lostinfinity", "blocks/" + regName + "_still"), new ResourceLocation("lostinfinity", "blocks/" + regName + "_flow"));
    }

    @SideOnly(value=Side.CLIENT)
    public static <T extends BlockBasicFluid> void registerCustomFluid(final T t) {
        ModelLoader.setCustomMeshDefinition((Item)Item.func_150898_a(t), (ItemMeshDefinition)new ItemMeshDefinition(){

            public ModelResourceLocation func_178113_a(ItemStack stack) {
                return new ModelResourceLocation(t.getRegistryName(), "fluid");
            }
        });
        ModelLoader.setCustomStateMapper(t, (IStateMapper)new StateMapperBase(){

            protected ModelResourceLocation func_178132_a(BlockState state) {
                return new ModelResourceLocation(t.getRegistryName(), "fluid");
            }
        });
    }
}

