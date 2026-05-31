/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.block.Block
 *  net.minecraft.block.SoundType
 *  net.minecraft.block.material.Material
 *  net.minecraft.block.state.BlockState
 *  net.minecraft.client.util.ITooltipFlag
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.item.Item
 *  net.minecraft.item.BlockItem
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.Direction
 *  net.minecraft.util.InteractionHand
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.text.Component
 *  net.minecraft.util.text.Component
 *  net.minecraft.world.World
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package xol.lostinfinity.block.activator;

import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xol.lostinfinity.block.misc.BlockLaunchCoordinator;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.dimension.util.DimensionActivator;
import xol.lostinfinity.init.BlockInit;
import xol.lostinfinity.init.DimensionInit;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.init.TabsInit;
import xol.lostinfinity.item.activate.ItemComplexLostMap;

public class BlockDimensionalizer
extends Block {
    public BlockDimensionalizer(String name) {
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
            boolean valid_hold = false;
            ItemStack held = playerIn.func_184586_b(hand);
            if (held.func_77973_b() instanceof ItemComplexLostMap && held.func_77942_o() && held.func_77978_p().func_74762_e("MapProgress") == 2) {
                valid_hold = true;
            }
            if (!worldIn.field_72995_K && valid_hold) {
                int[] goals = new int[]{held.func_77978_p().func_74762_e("MapSouth"), held.func_77978_p().func_74762_e("MapNorth"), held.func_77978_p().func_74762_e("MapEast"), held.func_77978_p().func_74762_e("MapWest")};
                boolean correct = true;
                for (int i = 0; i < 4; ++i) {
                    if (!correct) continue;
                    int running_total = 0;
                    for (int j = 0; j < 7; ++j) {
                        BlockPos check_pos = i < 2 ? pos.func_177982_a(-3 + j, 0, i % 2 == 0 ? 4 : -4) : pos.func_177982_a(i % 2 == 0 ? 4 : -4, 0, -3 + j);
                        Block block_at_pos = worldIn.func_180495_p(check_pos).func_177230_c();
                        if (block_at_pos instanceof BlockLaunchCoordinator) {
                            BlockLaunchCoordinator coordinator = (BlockLaunchCoordinator)block_at_pos;
                            running_total += coordinator.getColor() * coordinator.getShape();
                            continue;
                        }
                        correct = false;
                        playerIn.func_145747_a((Component)new Component((Object)((Object)TextFmt.Red) + "Coordinator missing!"));
                    }
                    int goal = goals[i];
                    if (running_total == goal) continue;
                    correct = false;
                    String[] rownames = new String[]{"South", "North", "East", "West"};
                    playerIn.func_145747_a((Component)new Component((Object)((Object)TextFmt.Red) + rownames[i] + " Row did not equal goal of:  " + goal + ". Outcome was: " + running_total));
                }
                if (correct) {
                    held.func_190918_g(1);
                    playerIn.func_184611_a(hand, new ItemStack(ItemInit.mazeToken, 1));
                    DimensionActivator.transferEntityWithCoords((Entity)playerIn, DimensionInit.celestialVoid, 1465.0, 65.0, 431.0);
                }
            }
        }
        return true;
    }

    @SideOnly(value=Side.CLIENT)
    public void func_190948_a(ItemStack stack, @Nullable Level worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add((Object)((Object)TextFmt.Gold) + "Match launch coordinator values to Advanced Celestial Map.");
    }
}

