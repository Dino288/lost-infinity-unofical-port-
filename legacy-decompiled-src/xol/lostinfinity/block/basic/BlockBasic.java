/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.block.SoundType
 *  net.minecraft.block.material.Material
 *  net.minecraft.creativetab.CreativeModeTab
 *  net.minecraft.item.Item
 *  net.minecraft.item.BlockItem
 */
package xol.lostinfinity.block.basic;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;
import xol.lostinfinity.init.BlockInit;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.init.TabsInit;

public class BlockBasic
extends Block {
    public BlockBasic(String name) {
        this(name, Material.field_151576_e);
    }

    public BlockBasic(String name, Material material) {
        this(name, material, TabsInit.TAB_BLOCKS);
    }

    public BlockBasic(String name, Material material, CreativeModeTab tab) {
        super(material);
        this.func_149663_c(name);
        this.setRegistryName(name);
        this.func_149711_c(60.0f);
        this.func_149752_b(60.0f);
        this.func_149647_a(tab);
        this.func_149672_a(SoundType.field_185851_d);
        BlockInit.BLOCKS.add(this);
        ItemInit.ITEMS.add((Item)new BlockItem((Block)this).setRegistryName(this.getRegistryName()));
    }
}

