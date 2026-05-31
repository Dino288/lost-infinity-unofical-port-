/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.state.BlockState
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.NonNullList
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.world.IBlockAccess
 *  net.minecraft.world.World
 */
package xol.lostinfinity.block.basic;

import java.util.Random;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.NonNullList;
import net.minecraft.core.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.level.Level;
import xol.lostinfinity.block.basic.BlockBasic;
import xol.lostinfinity.init.BlockInit;

public class BlockStarforgeOre
extends BlockBasic {
    public final boolean isDepletedType;
    private Item correspondingDrop;

    public BlockStarforgeOre(String name, boolean depleted) {
        super(name);
        this.isDepletedType = depleted;
        this.func_149675_a(depleted);
    }

    public BlockStarforgeOre(String name) {
        this(name, false);
    }

    public void func_180650_b(Level worldIn, BlockPos pos, BlockState state, Random rand) {
        worldIn.func_175656_a(pos, BlockInit.getRandomOre(worldIn).func_176223_P());
    }

    public void getDrops(NonNullList<ItemStack> drops, IBlockAccess world, BlockPos pos, BlockState state, int fortune) {
        drops.clear();
        drops.add((Object)new ItemStack(this.correspondingDrop));
    }

    public BlockStarforgeOre setCorrespondingItem(Item item) {
        this.correspondingDrop = item;
        return this;
    }
}

