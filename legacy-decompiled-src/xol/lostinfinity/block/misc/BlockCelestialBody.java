/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.SoundType
 *  net.minecraft.block.material.Material
 *  net.minecraft.block.state.BlockState
 *  net.minecraft.util.BlockRenderLayer
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package xol.lostinfinity.block.misc;

import net.minecraft.world.level.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.util.BlockRenderLayer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xol.lostinfinity.block.basic.BlockBasic;

public class BlockCelestialBody
extends BlockBasic {
    public BlockCelestialBody(String name) {
        super(name, Material.field_151592_s);
        this.func_149672_a(SoundType.field_185853_f);
        this.func_149715_a(1.0f);
    }

    @SideOnly(value=Side.CLIENT)
    public BlockRenderLayer func_180664_k() {
        return BlockRenderLayer.TRANSLUCENT;
    }

    public boolean func_149686_d(BlockState state) {
        return false;
    }

    public boolean func_149662_c(BlockState state) {
        return false;
    }
}

