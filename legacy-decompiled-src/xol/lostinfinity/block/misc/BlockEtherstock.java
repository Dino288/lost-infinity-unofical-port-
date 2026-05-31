/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.state.BlockState
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.item.ItemEntity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.Direction
 *  net.minecraft.util.InteractionHand
 *  net.minecraft.util.SoundSource
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.world.World
 */
package xol.lostinfinity.block.misc;

import java.util.Random;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundSource;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import xol.lostinfinity.block.basic.BlockCappedPlant;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.init.SoundInit;

public class BlockEtherstock
extends BlockCappedPlant {
    public BlockEtherstock(String name) {
        super(name);
        this.func_149675_a(true);
    }

    @Override
    public boolean func_180639_a(Level worldIn, BlockPos pos, BlockState state, Player playerIn, InteractionHand hand, Direction facing, float hitX, float hitY, float hitZ) {
        ItemStack stack = playerIn.func_184586_b(hand);
        if (stack.func_77973_b() == ItemInit.magicBiopowder) {
            this.grow(worldIn, pos);
            if (!worldIn.field_72995_K) {
                worldIn.func_184133_a(null, pos, SoundInit.MAGIC_POWDER, SoundSource.MASTER, 1.0f, 1.0f);
            }
            stack.func_190918_g(1);
        } else if (!worldIn.field_72995_K && this.func_176201_c(worldIn.func_180495_p(pos)) == 1) {
            BlockPos down = pos;
            while (worldIn.func_180495_p(down).func_177230_c() instanceof BlockEtherstock) {
                worldIn.func_175698_g(down);
                down = down.func_177977_b();
            }
            ItemEntity ether = new ItemEntity(worldIn, (double)pos.func_177958_n(), (double)pos.func_177956_o(), (double)pos.func_177952_p(), new ItemStack(ItemInit.etherflower, 1));
            ether.field_70159_w = 0.0;
            ether.field_70181_x = 0.0;
            ether.field_70179_y = 0.0;
            worldIn.func_72838_d((Entity)ether);
        }
        return true;
    }

    private void grow(Level worldIn, BlockPos pos) {
        if (!worldIn.field_72995_K) {
            if (this.func_176201_c(worldIn.func_180495_p(pos)) == 1) {
                return;
            }
            if (worldIn.func_175623_d(pos.func_177984_a())) {
                int radius = 48;
                boolean tallest = true;
                for (BlockPos checkPos : BlockPos.func_177980_a((BlockPos)pos.func_177982_a(-radius, 0, -radius), (BlockPos)pos.func_177982_a(radius, 0, radius))) {
                    if (checkPos.equals((Object)pos) || worldIn.func_175623_d(checkPos)) continue;
                    tallest = false;
                    break;
                }
                if (tallest) {
                    worldIn.func_175656_a(pos, this.func_176203_a(1));
                } else {
                    worldIn.func_175656_a(pos.func_177984_a(), this.func_176203_a(0));
                }
            }
        }
    }

    public void func_180650_b(Level worldIn, BlockPos pos, BlockState state, Random rand) {
        this.grow(worldIn, pos);
    }
}

