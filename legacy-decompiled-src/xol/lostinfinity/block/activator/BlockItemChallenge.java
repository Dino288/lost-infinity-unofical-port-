/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.block.SoundType
 *  net.minecraft.block.material.Material
 *  net.minecraft.block.state.BlockState
 *  net.minecraft.entity.player.Player
 *  net.minecraft.init.SoundEvents
 *  net.minecraft.item.Item
 *  net.minecraft.item.BlockItem
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.Direction
 *  net.minecraft.util.InteractionHand
 *  net.minecraft.util.SoundSource
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.world.World
 */
package xol.lostinfinity.block.activator;

import java.util.Random;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.entity.player.Player;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundSource;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import xol.lostinfinity.init.BlockInit;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.init.TabsInit;

public class BlockItemChallenge
extends Block {
    private int item_num = 0;

    public BlockItemChallenge(String name, int itemNum) {
        super(Material.field_151573_f);
        this.func_149663_c(name);
        this.setRegistryName(name);
        this.func_149711_c(3.0f);
        this.func_149647_a(TabsInit.TAB_BLOCKS);
        this.func_149672_a(SoundType.field_185851_d);
        this.func_149715_a(1.0f);
        this.item_num = itemNum;
        if (itemNum != 0) {
            BlockInit.ITEM_CHALLENGE_BLOCKS.add(this);
        }
        BlockInit.BLOCKS.add(this);
        ItemInit.ITEMS.add((Item)new BlockItem((Block)this).setRegistryName(this.getRegistryName()));
    }

    public boolean func_180639_a(Level worldIn, BlockPos pos, BlockState state, Player playerIn, InteractionHand hand, Direction facing, float hitX, float hitY, float hitZ) {
        ItemStack held;
        if (this.item_num != 0 && (held = playerIn.func_184614_ca()).func_77973_b() == this.getItemNeeded()) {
            boolean run = true;
            int up_check = 2;
            while (run) {
                BlockPos check = pos.func_177982_a(0, up_check, 0);
                if (worldIn.func_175623_d(check)) {
                    run = false;
                    held.func_190918_g(1);
                    if (!worldIn.field_72995_K) {
                        worldIn.func_175656_a(check, BlockInit.itemChallengeCrate.func_176223_P());
                        worldIn.func_184133_a(null, playerIn.func_180425_c(), SoundEvents.field_187620_cL, SoundSource.PLAYERS, 1.0f, 1.0f);
                    }
                } else if (worldIn.func_180495_p(check).func_177230_c() == BlockInit.labyrinthLamp) {
                    run = false;
                }
                ++up_check;
            }
        }
        return true;
    }

    private Item getItemNeeded() {
        switch (this.item_num) {
            case 1: {
                return ItemInit.acidicTongue;
            }
            case 2: {
                return ItemInit.firefeather;
            }
            case 3: {
                return ItemInit.hypnoticEye;
            }
            case 4: {
                return ItemInit.nightmarePowder;
            }
            case 5: {
                return ItemInit.stickyHide;
            }
            case 6: {
                return ItemInit.mysteriousGloop;
            }
            case 7: {
                return ItemInit.glowBulb;
            }
            case 8: {
                return ItemInit.metalBranch;
            }
            case 9: {
                return ItemInit.shadowHide;
            }
            case 10: {
                return ItemInit.heavyCrystal;
            }
            case 11: {
                return ItemInit.duskerEggs;
            }
            case 12: {
                return ItemInit.explosiveSack;
            }
            case 13: {
                return ItemInit.hardBone;
            }
            case 14: {
                return ItemInit.magicStone;
            }
            case 15: {
                return ItemInit.livingSlime;
            }
            case 16: {
                return ItemInit.reflectiveShard;
            }
            case 17: {
                return ItemInit.rockspine;
            }
            case 18: {
                return ItemInit.razorFangs;
            }
            case 19: {
                return ItemInit.potentPolarcronite;
            }
            case 20: {
                return ItemInit.organicFuse;
            }
        }
        return ItemInit.masterCraftedAlloy;
    }

    public static Block randomBlockItem(Random rand) {
        return BlockInit.ITEM_CHALLENGE_BLOCKS.get(rand.nextInt(BlockInit.ITEM_CHALLENGE_BLOCKS.size()));
    }
}

