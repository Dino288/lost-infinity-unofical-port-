/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.state.BlockState
 *  net.minecraft.entity.player.Player
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.Direction
 *  net.minecraft.util.EnumParticleTypes
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.world.World
 */
package xol.lostinfinity.block.harvest;

import java.util.Random;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.Direction;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import xol.lostinfinity.block.activator.BlockRadionPillar;
import xol.lostinfinity.block.basic.BlockBasicBoolState;
import xol.lostinfinity.init.SoundInit;

public class BlockRadionOre
extends BlockBasicBoolState {
    private static final boolean DEBUG = true;

    public BlockRadionOre(String name) {
        super(name);
        this.func_149675_a(true);
        this.func_149711_c(3.0f);
        this.func_149752_b(5.0f);
    }

    public void func_180650_b(Level world, BlockPos pos, BlockState state, Random rand) {
        if (!world.field_72995_K) {
            int range = 3;
            Iterable nearblocks = BlockPos.func_177980_a((BlockPos)pos.func_177982_a(-range, -range, -range), (BlockPos)pos.func_177982_a(range, range, range));
            for (BlockPos nearpos : nearblocks) {
                if (!(world.func_180495_p(nearpos).func_177230_c() instanceof BlockRadionOre) || !world.field_73012_v.nextBoolean()) continue;
                BlockState nearState = world.func_180495_p(nearpos);
                int meta = this.func_176201_c(nearState);
                if (meta == 0) {
                    world.func_175656_a(nearpos, this.func_176203_a(1));
                    continue;
                }
                world.func_175656_a(nearpos, this.func_176203_a(0));
            }
        }
    }

    public Item func_180660_a(BlockState state, Random rand, int fortune) {
        return ItemStack.field_190927_a.func_77973_b();
    }

    public void func_176206_d(Level worldIn, BlockPos pos, BlockState state) {
        if (!worldIn.field_72995_K && !worldIn.func_184137_a((double)pos.func_177958_n(), (double)pos.func_177956_o(), (double)pos.func_177952_p(), 15.0, false).func_184812_l_()) {
            worldIn.func_175656_a(pos, this.func_176203_a(0));
            if (this.func_176201_c(state) == 1) {
                int range = 15;
                Iterable nearBlocks = BlockPos.func_177980_a((BlockPos)pos.func_177982_a(-range, -range, -range), (BlockPos)pos.func_177982_a(range, range, range));
                for (BlockPos nearPos : nearBlocks) {
                    if (!(worldIn.func_180495_p(nearPos).func_177230_c() instanceof BlockRadionPillar) || worldIn.func_180495_p(nearPos).func_177230_c().func_176201_c(worldIn.func_180495_p(nearPos)) != 0) continue;
                    System.out.println("RadionOre destroyed, charging RadionPillar at " + nearPos);
                    BlockRadionPillar pillarBlock = (BlockRadionPillar)worldIn.func_180495_p(nearPos).func_177230_c();
                    pillarBlock.lightUpPillarSegment(worldIn, nearPos);
                    break;
                }
            }
        }
        if (worldIn.field_72995_K && this.func_176201_c(state) == 1) {
            Player player = worldIn.func_184137_a((double)pos.func_177958_n(), (double)pos.func_177956_o(), (double)pos.func_177952_p(), 15.0, false);
            Direction facing = player.func_174811_aO();
            player.func_184185_a(SoundInit.ORE_LIGHT, 0.5f, 1.0f + (worldIn.field_73012_v.nextFloat() - worldIn.field_73012_v.nextFloat()) * 0.2f);
            double centerX = (double)pos.func_177958_n() + 0.5;
            double centerY = (double)pos.func_177956_o() + 0.5;
            double centerZ = (double)pos.func_177952_p() + 0.5;
            switch (facing) {
                case NORTH: {
                    for (int i = 0; i < 15; ++i) {
                        double offSetX = worldIn.field_73012_v.nextBoolean() ? worldIn.field_73012_v.nextDouble() % 0.8 : -(worldIn.field_73012_v.nextDouble() % 0.8);
                        double offsetY = worldIn.field_73012_v.nextBoolean() ? worldIn.field_73012_v.nextDouble() % 0.5 : -(worldIn.field_73012_v.nextDouble() % 0.5);
                        worldIn.func_175688_a(EnumParticleTypes.DRAGON_BREATH, centerX + offSetX, centerY + offsetY, centerZ + (double)worldIn.field_73012_v.nextFloat() % 0.8, 0.0, 0.0, 0.0, new int[0]);
                    }
                    break;
                }
                case SOUTH: {
                    for (int i = 0; i < 15; ++i) {
                        double offSetX = worldIn.field_73012_v.nextBoolean() ? worldIn.field_73012_v.nextDouble() % 0.8 : -(worldIn.field_73012_v.nextDouble() % 0.8);
                        double offsetY = worldIn.field_73012_v.nextBoolean() ? worldIn.field_73012_v.nextDouble() % 0.5 : -(worldIn.field_73012_v.nextDouble() % 0.5);
                        worldIn.func_175688_a(EnumParticleTypes.DRAGON_BREATH, centerX + offSetX, centerY + offsetY, centerZ - (double)worldIn.field_73012_v.nextFloat() % 0.8, 0.0, 0.0, 0.0, new int[0]);
                    }
                    break;
                }
                case EAST: {
                    for (int i = 0; i < 15; ++i) {
                        double offSetZ = worldIn.field_73012_v.nextBoolean() ? worldIn.field_73012_v.nextDouble() % 0.8 : -(worldIn.field_73012_v.nextDouble() % 0.8);
                        double offsetY = worldIn.field_73012_v.nextBoolean() ? worldIn.field_73012_v.nextDouble() % 0.5 : -(worldIn.field_73012_v.nextDouble() % 0.5);
                        worldIn.func_175688_a(EnumParticleTypes.DRAGON_BREATH, centerX - (double)worldIn.field_73012_v.nextFloat() % 0.8, centerY + offsetY, centerZ + offSetZ, 0.0, 0.0, 0.0, new int[0]);
                    }
                    break;
                }
                case WEST: {
                    for (int i = 0; i < 15; ++i) {
                        double offSetZ = worldIn.field_73012_v.nextBoolean() ? worldIn.field_73012_v.nextDouble() % 0.8 : -(worldIn.field_73012_v.nextDouble() % 0.8);
                        double offsetY = worldIn.field_73012_v.nextBoolean() ? worldIn.field_73012_v.nextDouble() % 0.5 : -(worldIn.field_73012_v.nextDouble() % 0.5);
                        worldIn.func_175688_a(EnumParticleTypes.DRAGON_BREATH, centerX + (double)worldIn.field_73012_v.nextFloat() % 0.8, centerY + offsetY, centerZ + offSetZ, 0.0, 0.0, 0.0, new int[0]);
                    }
                    break;
                }
            }
        }
    }
}

