/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.block.BlockSlab
 *  net.minecraft.block.BlockSlab$EnumBlockHalf
 *  net.minecraft.block.material.Material
 *  net.minecraft.block.properties.Property
 *  net.minecraft.block.properties.PropertyEnum
 *  net.minecraft.block.state.StateDefinition
 *  net.minecraft.block.state.BlockState
 *  net.minecraft.item.Item
 *  net.minecraft.item.BlockItem
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.IStringSerializable
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.world.World
 */
package xol.lostinfinity.block.basic;

import java.util.Random;
import net.minecraft.world.level.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.util.IStringSerializable;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import xol.lostinfinity.init.BlockInit;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.init.TabsInit;

public class BlockBasicSlab
extends BlockSlab {
    public static final PropertyEnum<Variant> VARIANT = PropertyEnum.func_177709_a((String)"variant", Variant.class);
    public BlockBasicSlab mySlab;

    public BlockBasicSlab(String name, Material Material2) {
        super(Material2);
        this.func_149663_c(name);
        this.setRegistryName(name);
        this.func_149711_c(60.0f);
        this.func_149752_b(60.0f);
        this.func_149647_a(TabsInit.TAB_BLOCKS);
        BlockState iblockstate = this.field_176227_L.func_177621_b();
        if (!this.func_176552_j()) {
            iblockstate = iblockstate.func_177226_a((Property)field_176554_a, (Comparable)BlockSlab.EnumBlockHalf.BOTTOM);
            ItemInit.ITEMS.add((Item)new BlockItem((Block)this).setRegistryName(this.getRegistryName()));
        }
        this.func_180632_j(iblockstate.func_177226_a(VARIANT, (Comparable)((Object)Variant.DEFAULT)));
        BlockInit.BLOCKS.add((Block)this);
    }

    public void setMySlab(BlockBasicSlab slab) {
        this.mySlab = slab;
    }

    public Item func_180660_a(BlockState state, Random rand, int fortune) {
        return Item.func_150898_a((Block)this.mySlab);
    }

    public ItemStack func_185473_a(Level worldIn, BlockPos pos, BlockState state) {
        return new ItemStack((Block)this.mySlab);
    }

    public BlockState func_176203_a(int meta) {
        BlockState iblockstate = this.func_176223_P().func_177226_a(VARIANT, (Comparable)((Object)Variant.DEFAULT));
        if (!this.func_176552_j()) {
            iblockstate = iblockstate.func_177226_a((Property)field_176554_a, (Comparable)((meta & 8) == 0 ? BlockSlab.EnumBlockHalf.BOTTOM : BlockSlab.EnumBlockHalf.TOP));
        }
        return iblockstate;
    }

    public int func_176201_c(BlockState state) {
        int i = 0;
        if (!this.func_176552_j() && state.func_177229_b((Property)field_176554_a) == BlockSlab.EnumBlockHalf.TOP) {
            i |= 8;
        }
        return i;
    }

    protected StateDefinition func_180661_e() {
        return this.func_176552_j() ? new StateDefinition((Block)this, new Property[]{VARIANT}) : new StateDefinition((Block)this, new Property[]{field_176554_a, VARIANT});
    }

    public String func_150002_b(int meta) {
        return super.func_149739_a();
    }

    public Property<?> func_176551_l() {
        return VARIANT;
    }

    public Comparable<?> func_185674_a(ItemStack stack) {
        return Variant.DEFAULT;
    }

    public boolean func_176552_j() {
        BlockState iblockstate = this.field_176227_L.func_177621_b();
        return this.func_176552_j();
    }

    public static enum Variant implements IStringSerializable
    {
        DEFAULT;


        public String func_176610_l() {
            return "default";
        }
    }

    public static class Half
    extends BlockBasicSlab {
        public Half(String name, Material material) {
            super(name, material);
        }

        @Override
        public boolean func_176552_j() {
            return false;
        }
    }

    public static class Double
    extends BlockBasicSlab {
        public Double(String name, Material material) {
            super(name, material);
        }

        @Override
        public boolean func_176552_j() {
            return true;
        }
    }
}

