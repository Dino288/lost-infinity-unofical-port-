/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.state.BlockState
 *  net.minecraft.item.Item
 */
package xol.lostinfinity.block.misc;

import java.util.Random;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.item.Item;
import xol.lostinfinity.block.basic.BlockBasic;
import xol.lostinfinity.init.ItemInit;

public class BlockMultiversiteOverworld
extends BlockBasic {
    public BlockMultiversiteOverworld(String name) {
        super(name);
        this.func_149711_c(2.0f);
    }

    public Item func_180660_a(BlockState state, Random rand, int fortune) {
        return ItemInit.fracturedMultiversite;
    }

    public int quantityDropped(BlockState state, int fortune, Random random) {
        return 1;
    }
}

