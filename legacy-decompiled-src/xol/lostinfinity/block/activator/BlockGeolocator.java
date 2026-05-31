/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.block.SoundType
 *  net.minecraft.block.material.Material
 *  net.minecraft.block.state.BlockState
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.item.ItemEntity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.init.SoundEvents
 *  net.minecraft.item.Item
 *  net.minecraft.item.BlockItem
 *  net.minecraft.item.ItemStack
 *  net.minecraft.nbt.CompoundTag
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
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
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
import xol.lostinfinity.item.misc.ItemGeolocationOrb;

public class BlockGeolocator
extends Block {
    private int blockType = 0;

    public BlockGeolocator(String name, int locatorType) {
        super(Material.field_151573_f);
        this.func_149663_c(name);
        this.setRegistryName(name);
        this.func_149711_c(3.0f);
        this.func_149647_a(TabsInit.TAB_BLOCKS);
        this.func_149672_a(SoundType.field_185851_d);
        this.func_149715_a(1.0f);
        this.blockType = locatorType;
        BlockInit.BLOCKS.add(this);
        ItemInit.ITEMS.add((Item)new BlockItem((Block)this).setRegistryName(this.getRegistryName()));
    }

    public boolean func_180639_a(Level worldIn, BlockPos pos, BlockState state, Player playerIn, InteractionHand hand, Direction facing, float hitX, float hitY, float hitZ) {
        if (!playerIn.func_70093_af()) {
            if (this.blockType != 4) {
                if (playerIn.func_184586_b(hand).func_77973_b() instanceof ItemGeolocationOrb) {
                    ItemStack stack = playerIn.func_184586_b(hand);
                    boolean flag = false;
                    if (stack.func_77942_o()) {
                        if (stack.func_77978_p().func_74762_e("geolocator") == this.blockType) {
                            if (stack.func_77978_p().func_74762_e("geocount") == 1) {
                                playerIn.func_184611_a(hand, new ItemStack(ItemInit.geocoordinatedOrb, 2));
                                if (!worldIn.field_72995_K) {
                                    worldIn.func_184133_a(null, pos, SoundEvents.field_187626_cN, SoundSource.MASTER, 1.0f, 1.0f);
                                }
                            } else {
                                stack.func_77978_p().func_74768_a("geocount", stack.func_77978_p().func_74762_e("geocount") - 1);
                                if (!worldIn.field_72995_K) {
                                    worldIn.func_184133_a(null, pos, SoundInit.SCANNER, SoundSource.MASTER, 1.0f, 1.0f);
                                }
                                boolean run = true;
                                int newType = -1;
                                while (run) {
                                    newType = worldIn.field_73012_v.nextInt(4);
                                    if (newType == this.blockType) continue;
                                    run = false;
                                }
                                stack.func_77978_p().func_74768_a("geolocator", newType);
                            }
                        } else {
                            flag = true;
                        }
                    } else {
                        flag = true;
                    }
                    if (flag) {
                        if (!worldIn.field_72995_K) {
                            playerIn.func_145747_a((Component)new Component((Object)((Object)TextFmt.Gray) + "The orb smashes as you attempt to sync it with the geolocator."));
                            worldIn.func_184133_a(null, pos, SoundEvents.field_187561_bM, SoundSource.MASTER, 1.0f, 1.0f);
                        }
                        playerIn.func_184611_a(hand, ItemStack.field_190927_a);
                    }
                }
            } else if (playerIn.func_184586_b(hand).func_77973_b().equals(ItemInit.deviantGlobe)) {
                playerIn.func_184586_b(hand).func_190918_g(1);
                if (!worldIn.field_72995_K) {
                    worldIn.func_184133_a(null, pos, SoundEvents.field_187620_cL, SoundSource.MASTER, 1.0f, 1.0f);
                    ItemStack geostack = new ItemStack(ItemInit.geolocationOrb);
                    geostack.func_77982_d(new CompoundTag());
                    geostack.func_77978_p().func_74768_a("geocount", 3);
                    geostack.func_77978_p().func_74768_a("geolocator", worldIn.field_73012_v.nextInt(4));
                    ItemEntity geoloc = new ItemEntity(worldIn, playerIn.field_70165_t, playerIn.field_70163_u, playerIn.field_70161_v, geostack);
                    geoloc.field_70159_w = 0.0;
                    geoloc.field_70181_x = 0.0;
                    geoloc.field_70179_y = 0.0;
                    worldIn.func_72838_d((Entity)geoloc);
                }
            }
        }
        return true;
    }
}

