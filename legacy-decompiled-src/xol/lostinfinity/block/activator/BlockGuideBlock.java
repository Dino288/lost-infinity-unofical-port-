/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.block.SoundType
 *  net.minecraft.block.material.Material
 *  net.minecraft.block.state.BlockState
 *  net.minecraft.entity.player.Player
 *  net.minecraft.item.Item
 *  net.minecraft.item.BlockItem
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.Direction
 *  net.minecraft.util.InteractionHand
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.world.World
 */
package xol.lostinfinity.block.activator;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import xol.lostinfinity.init.BlockInit;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.init.TabsInit;

public class BlockGuideBlock
extends Block {
    public BlockGuideBlock(String name) {
        super(Material.field_151573_f);
        this.func_149663_c(name);
        this.setRegistryName(name);
        this.func_149711_c(3.0f);
        this.func_149647_a(TabsInit.TAB_BLOCKS);
        this.func_149672_a(SoundType.field_185851_d);
        this.func_149715_a(1.0f);
        BlockInit.BLOCKS.add(this);
        ItemInit.ITEMS.add((Item)new BlockItem((Block)this).setRegistryName(this.getRegistryName()));
    }

    public boolean func_180639_a(Level worldIn, BlockPos pos, BlockState state, Player playerIn, InteractionHand hand, Direction facing, float hitX, float hitY, float hitZ) {
        if (!worldIn.field_72995_K && worldIn.func_180495_p(pos.func_177977_b()).func_177230_c() == BlockInit.blockTrackWin) {
            worldIn.func_175698_g(pos);
            ItemStack stack = playerIn.func_184586_b(hand);
            if (stack.func_77973_b() == ItemInit.webbedIdol) {
                playerIn.func_184611_a(hand, new ItemStack(ItemInit.tokenVycellia));
                playerIn.func_70634_a(25.5, 31.5, 31.5);
            } else if (stack.func_77973_b() == ItemInit.pendantOfTheStorm) {
                playerIn.func_184611_a(hand, new ItemStack(ItemInit.tokenOzor));
                playerIn.func_70634_a(25.5, 31.5, 31.5);
            } else if (stack.func_77973_b() == ItemInit.conductiveBar) {
                playerIn.func_184611_a(hand, new ItemStack(ItemInit.tokenThundyron));
                playerIn.func_70634_a(25.5, 31.5, 31.5);
            } else if (stack.func_77973_b() == ItemInit.jarOfBlood) {
                playerIn.func_184611_a(hand, new ItemStack(ItemInit.tokenBarul));
                playerIn.func_70634_a(25.5, 31.5, 31.5);
            } else if (stack.func_77973_b() == ItemInit.frostedLog) {
                playerIn.func_184611_a(hand, new ItemStack(ItemInit.tokenCryonus));
                playerIn.func_70634_a(25.5, 31.5, 31.5);
            }
        }
        return true;
    }
}

