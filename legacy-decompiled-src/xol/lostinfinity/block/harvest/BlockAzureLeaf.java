/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.state.BlockState
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.item.ItemEntity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.init.SoundEvents
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.Direction
 *  net.minecraft.util.InteractionHand
 *  net.minecraft.util.SoundSource
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.world.World
 */
package xol.lostinfinity.block.harvest;

import java.util.Random;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundSource;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import xol.lostinfinity.block.basic.BlockCappedPlant;
import xol.lostinfinity.init.ItemInit;

public class BlockAzureLeaf
extends BlockCappedPlant {
    public BlockAzureLeaf(String name) {
        super(name);
        this.func_149675_a(true);
    }

    public void func_180650_b(Level world, BlockPos pos, BlockState state, Random rand) {
        if (!world.field_72995_K && this.func_176201_c(state) == 0) {
            world.func_175656_a(pos, this.func_176203_a(1));
        }
    }

    @Override
    public boolean func_180639_a(Level worldIn, BlockPos pos, BlockState state, Player playerIn, InteractionHand hand, Direction facing, float hitX, float hitY, float hitZ) {
        ItemStack held = playerIn.func_184614_ca();
        if (held.func_77973_b() == ItemInit.heatResistantTongs && !worldIn.field_72995_K) {
            ItemEntity leaf = new ItemEntity(worldIn, (double)pos.func_177958_n(), (double)(pos.func_177956_o() + 2), (double)pos.func_177952_p(), new ItemStack(ItemInit.azureLeaf));
            leaf.field_70159_w = 0.0;
            leaf.field_70181_x = 0.0;
            leaf.field_70179_y = 0.0;
            worldIn.func_72838_d((Entity)leaf);
            worldIn.func_175656_a(pos, this.func_176203_a(0));
            worldIn.func_184133_a(null, pos.func_177984_a(), SoundEvents.field_187693_cj, SoundSource.BLOCKS, 2.0f, 1.0f);
        }
        return super.func_180639_a(worldIn, pos, state, playerIn, hand, facing, hitX, hitY, hitZ);
    }
}

