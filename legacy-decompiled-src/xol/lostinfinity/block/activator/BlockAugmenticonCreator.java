/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.block.SoundType
 *  net.minecraft.block.material.Material
 *  net.minecraft.block.state.BlockState
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.init.SoundEvents
 *  net.minecraft.item.Item
 *  net.minecraft.item.BlockItem
 *  net.minecraft.item.ItemStack
 *  net.minecraft.nbt.NBTBase
 *  net.minecraft.nbt.NBTTagInt
 *  net.minecraft.nbt.NBTTagList
 *  net.minecraft.util.Direction
 *  net.minecraft.util.InteractionHand
 *  net.minecraft.util.SoundSource
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.text.Component
 *  net.minecraft.util.text.Component
 *  net.minecraft.world.World
 */
package xol.lostinfinity.block.activator;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagInt;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundSource;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.Level;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.BlockInit;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.init.TabsInit;
import xol.lostinfinity.item.misc.ItemAugmentSlide;
import xol.lostinfinity.item.misc.ItemAugmenticonBox;
import xol.lostinfinity.mob.entity.starforge.EntityAugmenticon;

public class BlockAugmenticonCreator
extends Block {
    public BlockAugmenticonCreator(String name) {
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
        if (!playerIn.func_70093_af()) {
            ItemStack stack = playerIn.func_184586_b(hand);
            if (stack.func_190926_b()) {
                if (!worldIn.field_72995_K) {
                    playerIn.func_70634_a(1553.0, 11.0, -584.0);
                    worldIn.func_184133_a(null, pos, SoundInit.ARENA_TELEPORT, SoundSource.MASTER, 1.0f, 1.0f);
                }
            } else if (stack.func_77973_b() instanceof ItemAugmenticonBox) {
                if (!ItemAugmenticonBox.getAugmentList(stack).func_82582_d()) {
                    if (!worldIn.field_72995_K) {
                        NBTTagList list = ItemAugmenticonBox.getAugmentList(stack);
                        playerIn.func_70634_a(1554.0, 12.0, -556.0);
                        EntityAugmenticon augmenticon = new EntityAugmenticon(worldIn);
                        augmenticon.func_70107_b(1576.0, 13.0, -551.0);
                        for (NBTBase tag : list) {
                            NBTTagInt strTag = (NBTTagInt)tag;
                            augmenticon.addAbility(ItemAugmentSlide.SlideType.values()[strTag.func_150287_d()].registryName);
                        }
                        worldIn.func_72838_d((Entity)augmenticon);
                    }
                    playerIn.func_184611_a(hand, ItemStack.field_190927_a);
                    worldIn.func_184133_a(null, pos, SoundEvents.field_187620_cL, SoundSource.MASTER, 1.0f, 1.0f);
                } else if (!worldIn.field_72995_K) {
                    playerIn.func_145747_a((Component)new Component((Object)((Object)TextFmt.Red) + "The augmenticon must have at least one programmed ability."));
                }
            }
        }
        return true;
    }
}

