/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.state.BlockState
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.item.ItemEntity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.Direction
 *  net.minecraft.util.InteractionHand
 *  net.minecraft.util.SoundSource
 *  net.minecraft.util.math.AABB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.text.Component
 *  net.minecraft.util.text.Component
 *  net.minecraft.world.World
 */
package xol.lostinfinity.block.activator;

import java.util.ArrayList;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.phys.AABB;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.Level;
import xol.lostinfinity.block.basic.BlockBasic;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.BlockInit;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.init.SoundInit;

public class BlockBlightEyeBattery
extends BlockBasic {
    public BlockBlightEyeBattery(String name) {
        super(name);
    }

    public boolean func_180639_a(Level worldIn, BlockPos pos, BlockState state, Player playerIn, InteractionHand hand, Direction facing, float hitX, float hitY, float hitZ) {
        if (!playerIn.func_70093_af() && !worldIn.field_72995_K) {
            ArrayList<BlockPos> eyes = new ArrayList<BlockPos>();
            int eyeCount = 0;
            for (int i = -6; i <= 6; ++i) {
                for (int j = -6; j < 6; ++j) {
                    if (!worldIn.func_180495_p(pos.func_177982_a(i, 0, j)).func_177230_c().equals(BlockInit.blightEye)) continue;
                    ++eyeCount;
                    eyes.add(pos.func_177982_a(i, 0, j));
                }
            }
            if (eyeCount >= 6) {
                ArrayList<BlockPos> mouthBlocks = new ArrayList<BlockPos>();
                for (int i = -6; i <= 6; ++i) {
                    for (int j = -6; j < 6; ++j) {
                        if (!worldIn.func_180495_p(pos.func_177982_a(i, 0, j)).func_177230_c().equals(BlockInit.blightMouth)) continue;
                        mouthBlocks.add(pos.func_177982_a(i, 0, j));
                    }
                }
                boolean stack1 = false;
                boolean stack2 = false;
                boolean stack3 = false;
                boolean stack4 = false;
                ItemEntity stack1Entity = null;
                ItemEntity stack2Entity = null;
                ItemEntity stack3Entity = null;
                ItemEntity stack4Entity = null;
                for (BlockPos mouthPos : mouthBlocks) {
                    AABB aabb = new AABB(mouthPos.func_177984_a());
                    for (ItemEntity itemEntity : worldIn.func_72872_a(ItemEntity.class, aabb)) {
                        Item testItem = itemEntity.func_92059_d().func_77973_b();
                        if (testItem == ItemInit.basicStorageChip && !stack1) {
                            if (itemEntity.func_92059_d().func_190916_E() < 3) continue;
                            stack1Entity = itemEntity;
                            stack1 = true;
                            continue;
                        }
                        if (testItem == ItemInit.organicPlate && !stack2) {
                            if (itemEntity.func_92059_d().func_190916_E() < 10) continue;
                            stack2Entity = itemEntity;
                            stack2 = true;
                            continue;
                        }
                        if (testItem == ItemInit.gloominessenceCubes && !stack3) {
                            if (itemEntity.func_92059_d().func_190916_E() < 20) continue;
                            stack3Entity = itemEntity;
                            stack3 = true;
                            continue;
                        }
                        if (testItem != ItemInit.organicWire || stack4 || itemEntity.func_92059_d().func_190916_E() < 5) continue;
                        stack4Entity = itemEntity;
                        stack4 = true;
                    }
                }
                if (stack1 && stack2 && stack3 && stack4) {
                    ItemEntity resultItem = new ItemEntity(worldIn, (double)((BlockPos)mouthBlocks.get(0)).func_177958_n(), (double)(((BlockPos)mouthBlocks.get(0)).func_177956_o() + 2), (double)((BlockPos)mouthBlocks.get(0)).func_177952_p(), new ItemStack(ItemInit.darkworldDataChip));
                    resultItem.field_70159_w = 0.0;
                    resultItem.field_70181_x = 1.0;
                    resultItem.field_70179_y = 0.0;
                    resultItem.field_70133_I = true;
                    worldIn.func_72838_d((Entity)resultItem);
                    worldIn.func_184133_a(null, pos.func_177984_a(), SoundInit.CRUNCHING, SoundSource.BLOCKS, 2.0f, 1.0f);
                    stack1Entity.func_92059_d().func_190918_g(stack1Entity.func_92059_d().func_190916_E());
                    stack2Entity.func_92059_d().func_190918_g(stack2Entity.func_92059_d().func_190916_E());
                    stack3Entity.func_92059_d().func_190918_g(stack3Entity.func_92059_d().func_190916_E());
                    stack4Entity.func_92059_d().func_190918_g(stack4Entity.func_92059_d().func_190916_E());
                    for (BlockPos eye : eyes) {
                        worldIn.func_175656_a(eye, BlockInit.blightEyeEmpty.func_176223_P());
                    }
                    playerIn.func_145747_a((Component)new Component((Object)((Object)TextFmt.Light_Purple) + "Feed the darkness, and it will feed you in return..."));
                }
            }
        }
        return true;
    }
}

