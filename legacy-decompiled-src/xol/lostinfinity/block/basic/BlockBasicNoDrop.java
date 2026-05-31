/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.state.BlockState
 *  net.minecraft.init.Items
 *  net.minecraft.item.Item
 */
package xol.lostinfinity.block.basic;

import java.util.Random;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Item;
import xol.lostinfinity.block.basic.BlockBasic;

public class BlockBasicNoDrop
extends BlockBasic {
    public BlockBasicNoDrop(String name) {
        super(name);
    }

    public Item func_180660_a(BlockState state, Random rand, int fortune) {
        return Items.field_190931_a;
    }
}

