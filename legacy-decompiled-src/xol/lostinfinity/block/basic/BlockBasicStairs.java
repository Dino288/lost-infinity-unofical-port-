/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.block.BlockStairs
 *  net.minecraft.block.state.BlockState
 *  net.minecraft.item.Item
 *  net.minecraft.item.BlockItem
 */
package xol.lostinfinity.block.basic;

import net.minecraft.world.level.block.Block;
import net.minecraft.block.BlockStairs;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;
import xol.lostinfinity.init.BlockInit;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.init.TabsInit;

public class BlockBasicStairs
extends BlockStairs {
    public BlockBasicStairs(String name, float hardness, BlockState modelState) {
        super(modelState);
        this.func_149663_c(name);
        this.setRegistryName(name);
        this.func_149711_c(hardness);
        this.func_149647_a(TabsInit.TAB_BLOCKS);
        this.field_149783_u = true;
        BlockInit.BLOCKS.add((Block)this);
        ItemInit.ITEMS.add((Item)new BlockItem((Block)this).setRegistryName(this.getRegistryName()));
    }
}

