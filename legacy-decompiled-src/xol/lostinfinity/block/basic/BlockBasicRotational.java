/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.block.BlockHorizontal
 *  net.minecraft.block.SoundType
 *  net.minecraft.block.material.Material
 *  net.minecraft.block.properties.Property
 *  net.minecraft.block.state.StateDefinition
 *  net.minecraft.block.state.BlockState
 *  net.minecraft.creativetab.CreativeModeTab
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.item.Item
 *  net.minecraft.item.BlockItem
 *  net.minecraft.util.Direction
 *  net.minecraft.util.Mirror
 *  net.minecraft.util.Rotation
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.world.World
 */
package xol.lostinfinity.block.basic;

import net.minecraft.world.level.block.Block;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;
import net.minecraft.core.Direction;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import xol.lostinfinity.init.BlockInit;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.init.TabsInit;

public class BlockBasicRotational
extends BlockHorizontal {
    public BlockBasicRotational(String name) {
        this(name, 60.0f, Material.field_151576_e);
    }

    public BlockBasicRotational(String name, float hardness, Material material) {
        this(name, hardness, material, TabsInit.TAB_BLOCKS);
    }

    public BlockBasicRotational(String name, float hardness, Material material, CreativeModeTab tab) {
        super(material);
        this.func_149663_c(name);
        this.setRegistryName(name);
        this.func_149711_c(hardness);
        this.func_149752_b(60.0f);
        this.func_149647_a(tab);
        this.func_149672_a(SoundType.field_185851_d);
        BlockInit.BLOCKS.add((Block)this);
        ItemInit.ITEMS.add((Item)new BlockItem((Block)this).setRegistryName(this.getRegistryName()));
    }

    protected StateDefinition func_180661_e() {
        return new StateDefinition((Block)this, new Property[]{field_185512_D});
    }

    public BlockState func_185499_a(BlockState state, Rotation rot) {
        return state.func_177226_a((Property)field_185512_D, (Comparable)rot.func_185831_a((Direction)state.func_177229_b((Property)field_185512_D)));
    }

    public BlockState func_185471_a(BlockState state, Mirror mirrorIn) {
        return state.func_185907_a(mirrorIn.func_185800_a((Direction)state.func_177229_b((Property)field_185512_D)));
    }

    public BlockState func_180642_a(Level worldIn, BlockPos pos, Direction facing, float hitX, float hitY, float hitZ, int meta, LivingEntity placer) {
        return this.func_176223_P().func_177226_a((Property)field_185512_D, (Comparable)placer.func_174811_aO().func_176734_d());
    }

    public int func_176201_c(BlockState state) {
        int i = 0;
        return i |= ((Direction)state.func_177229_b((Property)field_185512_D)).func_176736_b();
    }

    public BlockState func_176203_a(int meta) {
        return this.func_176223_P().func_177226_a((Property)field_185512_D, (Comparable)Direction.func_176731_b((int)meta));
    }
}

