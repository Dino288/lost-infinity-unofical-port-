/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.state.BlockState
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.item.ItemEntity
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.SoundSource
 *  net.minecraft.util.math.AABB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Vec3i
 *  net.minecraft.world.World
 */
package xol.lostinfinity.block.misc;

import java.util.ArrayList;
import java.util.Random;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.phys.AABB;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Vec3i;
import net.minecraft.world.level.Level;
import xol.lostinfinity.block.basic.BlockBasic;
import xol.lostinfinity.init.BlockInit;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.init.SoundInit;

public class BlockPoweredHyperMelder
extends BlockBasic {
    public BlockPoweredHyperMelder(String name) {
        super(name);
        this.func_149715_a(1.0f);
        this.func_149675_a(true);
    }

    public void func_180650_b(Level worldIn, BlockPos pos, BlockState state, Random rand) {
        ArrayList<BlockPos> rememberPos = new ArrayList<BlockPos>();
        if (!worldIn.field_72995_K) {
            int generators = 0;
            for (int addX = -9; addX < 9; ++addX) {
                for (int addZ = -9; addZ < 9; ++addZ) {
                    BlockPos testPos = new BlockPos((Vec3i)pos.func_177982_a(addX, -1, addZ));
                    if (worldIn.func_180495_p(testPos).func_177230_c() != BlockInit.hyperGeneratorPowered) continue;
                    ++generators;
                    rememberPos.add(testPos);
                }
            }
            if (generators < 8) {
                worldIn.func_175656_a(pos, BlockInit.hyperMelderUnpowered.func_176223_P());
            } else {
                AABB aabb = new AABB(pos.func_177982_a(-2, 0, -2), pos.func_177982_a(2, 3, 2));
                boolean recycler = false;
                boolean powerBank = false;
                ItemEntity reyclerEntity = null;
                ItemEntity bankEntity = null;
                for (ItemEntity itemEntity : worldIn.func_72872_a(ItemEntity.class, aabb)) {
                    Item testItem = itemEntity.func_92059_d().func_77973_b();
                    if (testItem == ItemInit.clovinitePowerBank && !powerBank) {
                        if (itemEntity.func_92059_d().func_190916_E() < 10) continue;
                        bankEntity = itemEntity;
                        powerBank = true;
                        continue;
                    }
                    if (testItem != ItemInit.electronRecycler || recycler || itemEntity.func_92059_d().func_190916_E() < 20) continue;
                    reyclerEntity = itemEntity;
                    recycler = true;
                }
                if (recycler && powerBank) {
                    ItemEntity hubItem = new ItemEntity(worldIn, (double)pos.func_177958_n(), (double)(pos.func_177956_o() + 2), (double)pos.func_177952_p(), new ItemStack(ItemInit.clovinitePowerHub));
                    hubItem.field_70159_w = 0.0;
                    hubItem.field_70181_x = 0.0;
                    hubItem.field_70179_y = 0.0;
                    worldIn.func_72838_d((Entity)hubItem);
                    worldIn.func_184133_a(null, pos.func_177984_a(), SoundInit.SPECIAL_CRAFT, SoundSource.BLOCKS, 2.0f, 1.0f);
                    bankEntity.func_92059_d().func_190918_g(10);
                    reyclerEntity.func_92059_d().func_190918_g(20);
                    for (BlockPos rep : rememberPos) {
                        worldIn.func_175656_a(rep, BlockInit.hyperGeneratorUnpowered.func_176223_P());
                    }
                }
            }
        }
    }
}

