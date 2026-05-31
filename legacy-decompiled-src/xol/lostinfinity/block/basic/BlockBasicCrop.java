/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.block.BlockCrops
 *  net.minecraft.block.properties.Property
 *  net.minecraft.block.state.BlockState
 *  net.minecraft.item.Item
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.world.World
 */
package xol.lostinfinity.block.basic;

import net.minecraft.world.level.block.Block;
import net.minecraft.block.BlockCrops;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.item.Item;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import xol.lostinfinity.init.BlockInit;
import xol.lostinfinity.init.TabsInit;

public class BlockBasicCrop
extends BlockCrops {
    private Item seed = null;
    private Item crop = null;
    private Block soilBlock = null;

    public BlockBasicCrop(String name) {
        this.func_149663_c(name);
        this.setRegistryName(name);
        this.func_149647_a(TabsInit.TAB_BLOCKS);
        BlockInit.BLOCKS.add((Block)this);
    }

    public void setSeedCropSoil(Item seedIn, Item cropIn, Block block) {
        this.seed = seedIn;
        this.crop = cropIn;
        this.soilBlock = block;
    }

    protected Item func_149866_i() {
        return this.seed;
    }

    protected Item func_149865_P() {
        return this.crop;
    }

    public boolean func_180671_f(Level worldIn, BlockPos pos, BlockState state) {
        return worldIn.func_180495_p(pos.func_177977_b()).func_177230_c() == this.soilBlock;
    }

    public int getCropAge(BlockState state) {
        return (Integer)state.func_177229_b((Property)this.func_185524_e());
    }
}

