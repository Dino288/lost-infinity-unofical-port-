/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.entity.player.Player
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.util.InteractionResultHolder
 *  net.minecraft.util.InteractionHand
 *  net.minecraft.util.SoundSource
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.text.Component
 *  net.minecraft.util.text.Component
 *  net.minecraft.world.World
 */
package xol.lostinfinity.item.activate;

import java.util.ArrayList;
import java.util.Collections;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundSource;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.Level;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.BlockInit;
import xol.lostinfinity.init.DimensionInit;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.init.TabsInit;
import xol.lostinfinity.item.basics.ItemBasic;
import xol.lostinfinity.item.classify.ISwitchModels;

public class ItemMatterRecombiner
extends ItemBasic
implements ISwitchModels {
    public ItemMatterRecombiner(String regName) {
        super(regName, TabsInit.TAB_AUXMATS);
        this.func_77625_d(1);
        this.setModelSwitch("separation", this, 2);
    }

    public InteractionResultHolder<ItemStack> func_77659_a(Level worldIn, Player playerIn, InteractionHand handIn) {
        if (worldIn.field_73011_w.func_186058_p() == DimensionInit.infiniteMurk) {
            int type;
            ItemStack stack = playerIn.func_184586_b(handIn);
            if (!stack.func_77942_o()) {
                stack.func_77982_d(new CompoundTag());
            }
            if ((type = stack.func_77978_p().func_74762_e("separation_data")) == 0 && playerIn.func_180425_c().func_177956_o() > worldIn.func_189649_b(playerIn.func_180425_c().func_177958_n(), playerIn.func_180425_c().func_177952_p()) + 3) {
                return super.func_77659_a(worldIn, playerIn, handIn);
            }
            stack.func_77978_p().func_74768_a("separation_data", 1);
            if (!worldIn.field_72995_K) {
                if (type == 0) {
                    stack.func_77978_p().func_74772_a("SeparationTime", System.currentTimeMillis());
                    int numBlocks = worldIn.field_73012_v.nextInt(6) + 5;
                    stack.func_77978_p().func_74768_a("NumBlocks", numBlocks);
                    int blockCount = 0;
                    int radius = 70;
                    ArrayList<BlockPos> blocks = new ArrayList<BlockPos>();
                    for (int i = -radius; i <= radius; ++i) {
                        for (int j = -radius; j <= radius; ++j) {
                            int x = playerIn.func_180425_c().func_177958_n() + i;
                            int z = playerIn.func_180425_c().func_177952_p() + j;
                            int y = worldIn.func_189649_b(x, z);
                            blocks.add(new BlockPos(x, y, z));
                        }
                    }
                    Collections.shuffle(blocks);
                    for (BlockPos randPos : blocks) {
                        if (worldIn.func_175623_d(randPos)) {
                            worldIn.func_175656_a(randPos, BlockInit.separatedMatter.func_176223_P());
                            ++blockCount;
                        }
                        if (blockCount < numBlocks) continue;
                        break;
                    }
                    worldIn.func_184133_a(null, playerIn.func_180425_c(), SoundInit.FLASK_EXPLODE, SoundSource.PLAYERS, 1.5f, 1.0f);
                    playerIn.func_145747_a((Component)new Component((Object)((Object)TextFmt.Dark_Red) + String.format("Separation initiated. Quickly collect %d blocks of seperated matter in order to recombine it", numBlocks)));
                } else if (type == 1) {
                    long timeDiff = System.currentTimeMillis() - stack.func_77978_p().func_74763_f("SeparationTime");
                    int numBlocks = stack.func_77978_p().func_74762_e("NumBlocks");
                    boolean blocksFound = false;
                    if (timeDiff < 300000L) {
                        int count = 0;
                        for (int i = 0; i < playerIn.field_71071_by.func_70302_i_(); ++i) {
                            ItemStack invStack = playerIn.field_71071_by.func_70301_a(i);
                            if (!invStack.func_77973_b().equals(Item.func_150898_a((Block)BlockInit.separatedMatter))) continue;
                            int stackSize = invStack.func_190916_E();
                            if ((count += stackSize) > numBlocks) {
                                playerIn.field_71071_by.func_70299_a(i, new ItemStack(BlockInit.separatedMatter, stackSize - numBlocks));
                            } else if (count == numBlocks) {
                                playerIn.field_71071_by.func_70299_a(i, ItemStack.field_190927_a);
                            } else if (count < numBlocks) {
                                playerIn.field_71071_by.func_70299_a(i, ItemStack.field_190927_a);
                            }
                            if (count < numBlocks) continue;
                            blocksFound = true;
                            break;
                        }
                        if (blocksFound) {
                            stack.func_190918_g(1);
                            playerIn.func_191521_c(new ItemStack(ItemInit.reconfiguredMatter, 1));
                            playerIn.func_145747_a((Component)new Component((Object)((Object)TextFmt.Dark_Red) + "Matter successfully recombined"));
                            worldIn.func_184133_a(null, playerIn.func_180425_c(), SoundInit.GENERIC_WEAPON_22, SoundSource.PLAYERS, 1.5f, 1.0f);
                        } else {
                            playerIn.func_191521_c(new ItemStack(BlockInit.separatedMatter, count));
                            playerIn.func_145747_a((Component)new Component((Object)((Object)TextFmt.Dark_Red) + "Insufficient matter to recombine."));
                        }
                    }
                }
            }
        }
        return super.func_77659_a(worldIn, playerIn, handIn);
    }
}

