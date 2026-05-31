/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.IBlockEntityProvider
 *  net.minecraft.block.state.BlockState
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.item.ItemStack
 *  net.minecraft.tileentity.BlockEntity
 *  net.minecraft.util.Direction
 *  net.minecraft.util.InteractionHand
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Vec3i
 *  net.minecraft.util.text.Component
 *  net.minecraft.util.text.Component
 *  net.minecraft.world.World
 */
package xol.lostinfinity.block.activator;

import net.minecraft.block.IBlockEntityProvider;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Vec3i;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.Level;
import xol.lostinfinity.block.basic.BlockBasic;
import xol.lostinfinity.block.tileentity.BlockEntityAlignmentDialGame;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.dimension.util.DimensionActivator;
import xol.lostinfinity.init.BlockInit;
import xol.lostinfinity.init.DimensionInit;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.item.activate.ItemComplexLostMap;

public class BlockAlignmentDialGame
extends BlockBasic
implements IBlockEntityProvider {
    public BlockAlignmentDialGame(String name) {
        super(name);
    }

    private boolean validMap(ItemStack stack) {
        return stack.func_77973_b() instanceof ItemComplexLostMap && stack.func_77942_o() && stack.func_77978_p().func_74762_e("MapProgress") == 2;
    }

    public boolean func_180639_a(Level worldIn, BlockPos pos, BlockState state, Player playerIn, InteractionHand hand, Direction facing, float hitX, float hitY, float hitZ) {
        ItemStack held = playerIn.func_184586_b(hand);
        if (this.validMap(held)) {
            if (!worldIn.field_72995_K && this.checkWin(pos, worldIn, playerIn)) {
                playerIn.func_184586_b(hand).func_190918_g(1);
                playerIn.func_184611_a(hand, new ItemStack(ItemInit.mazeToken, 1));
                DimensionActivator.transferEntityWithCoords((Entity)playerIn, DimensionInit.celestialVoid, 1465.0, 65.0, 431.0);
                if (worldIn.func_175625_s(pos) != null) {
                    BlockEntityAlignmentDialGame tileentity = (BlockEntityAlignmentDialGame)worldIn.func_175625_s(pos);
                    tileentity.reset();
                }
            }
        } else if (!worldIn.field_72995_K && worldIn.func_175625_s(pos) != null) {
            BlockEntityAlignmentDialGame tileEntity = (BlockEntityAlignmentDialGame)worldIn.func_175625_s(pos);
            tileEntity.reset();
        }
        return true;
    }

    private boolean checkWin(BlockPos pos, Level worldIn, Player playerIn) {
        if (worldIn.func_175625_s(pos) != null) {
            int count;
            BlockEntityAlignmentDialGame tileEntity = (BlockEntityAlignmentDialGame)worldIn.func_175625_s(pos);
            Vec3i dir = null;
            switch (tileEntity.getDir()) {
                case "North": {
                    dir = new Vec3i(0, 0, -1);
                    break;
                }
                case "East": {
                    dir = new Vec3i(1, 0, 0);
                    break;
                }
                case "South": {
                    dir = new Vec3i(0, 0, 1);
                    break;
                }
                case "West": {
                    dir = new Vec3i(-1, 0, 0);
                }
            }
            if (dir != null && (count = tileEntity.getRingCount()) > 0) {
                for (int i = 1; i <= count; ++i) {
                    BlockPos check = pos.func_177982_a(dir.func_177958_n() * count, 0, dir.func_177952_p() * count);
                    if (BlockInit.alignmentTile.func_176201_c(worldIn.func_180495_p(check)) == 1) continue;
                    playerIn.func_145747_a((Component)new Component((Object)((Object)TextFmt.Gold) + String.format("The dials must point %s", tileEntity.getDir())));
                    return false;
                }
                return true;
            }
        }
        return false;
    }

    public BlockEntity func_149915_a(Level worldIn, int meta) {
        return null;
    }

    public boolean func_149716_u() {
        return true;
    }

    public BlockEntity createBlockEntity(Level world, BlockState state) {
        return new BlockEntityAlignmentDialGame();
    }
}

