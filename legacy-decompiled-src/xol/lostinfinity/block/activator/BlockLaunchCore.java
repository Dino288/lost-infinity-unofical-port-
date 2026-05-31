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
 *  net.minecraft.entity.player.Player
 *  net.minecraft.item.Item
 *  net.minecraft.item.BlockItem
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.Direction
 *  net.minecraft.util.InteractionHand
 *  net.minecraft.util.SoundSource
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
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundSource;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xol.lostinfinity.block.misc.BlockLaunchCoordinator;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.BlockInit;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.init.TabsInit;

public class BlockLaunchCore
extends Block {
    public BlockLaunchCore(String name) {
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
        if (!playerIn.func_70093_af() && !worldIn.field_72995_K) {
            if (this.iteratePads(pos, worldIn, false) != 24) {
                playerIn.func_145747_a((Component)new Component((Object)((Object)TextFmt.Red) + "Launch pad missing!"));
                return true;
            }
            boolean correct = true;
            for (int i = 0; i < 4; ++i) {
                if (!correct) continue;
                int running_total = 0;
                for (int j = 0; j < 5; ++j) {
                    BlockPos check_pos = i < 2 ? pos.func_177982_a(-2 + j, 0, i % 2 == 0 ? 3 : -3) : pos.func_177982_a(i % 2 == 0 ? 3 : -3, 0, -2 + j);
                    Block block_at_pos = worldIn.func_180495_p(check_pos).func_177230_c();
                    if (block_at_pos instanceof BlockLaunchCoordinator) {
                        BlockLaunchCoordinator coordinator = (BlockLaunchCoordinator)block_at_pos;
                        running_total += coordinator.getColor() * coordinator.getShape();
                        continue;
                    }
                    correct = false;
                    playerIn.func_145747_a((Component)new Component((Object)((Object)TextFmt.Red) + "Coordinator missing!"));
                }
                int goal = 22 + 5 * i;
                if (running_total == goal) continue;
                correct = false;
                playerIn.func_145747_a((Component)new Component((Object)((Object)TextFmt.Red) + "Row did not equal goal of:  " + goal + ". Outcome was: " + running_total));
            }
            if (correct) {
                this.iteratePads(pos, worldIn, true);
                worldIn.func_184133_a(null, pos, SoundInit.SUPERMUTATION, SoundSource.MASTER, 1.0f, 1.0f);
            }
        }
        return true;
    }

    public int iteratePads(BlockPos pos, Level worldIn, boolean light) {
        int light_total = 0;
        for (int i = -2; i < 3; ++i) {
            for (int j = -2; j < 3; ++j) {
                if (j == 0 && i == 0) continue;
                BlockPos check_pos = pos.func_177982_a(i, 0, j);
                if (light) {
                    worldIn.func_175656_a(check_pos, BlockInit.launchPad.func_176223_P());
                    continue;
                }
                Block block_check = worldIn.func_180495_p(check_pos).func_177230_c();
                if (!block_check.equals(BlockInit.launchPad) && !block_check.equals(BlockInit.launchPadUnpowered)) continue;
                ++light_total;
            }
        }
        return light_total;
    }

    @SideOnly(value=Side.CLIENT)
    public void func_190948_a(ItemStack stack, @Nullable Level worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add((Object)((Object)TextFmt.Gold) + "Needs launch coordinators with the following values:");
        tooltip.add((Object)((Object)TextFmt.Aqua) + "South: 22");
        tooltip.add((Object)((Object)TextFmt.Light_Purple) + "North: 27");
        tooltip.add((Object)((Object)TextFmt.Aqua) + "East: 32");
        tooltip.add((Object)((Object)TextFmt.Light_Purple) + "West: 37");
    }
}

