/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.block.Block
 *  net.minecraft.block.state.BlockState
 *  net.minecraft.client.util.ITooltipFlag
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.init.SoundEvents
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.Direction
 *  net.minecraft.util.InteractionHand
 *  net.minecraft.util.SoundSource
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.world.World
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package xol.lostinfinity.block.misc;

import java.util.List;
import java.util.Random;
import javax.annotation.Nullable;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundSource;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xol.lostinfinity.block.basic.BlockBasicRotational;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.BlockInit;
import xol.lostinfinity.init.ItemInit;

public class BlockLaunchCoordinator
extends BlockBasicRotational {
    private int coord_color;
    private int coord_shape;

    public BlockLaunchCoordinator(String name, int color, int shape) {
        super(name);
        this.func_149715_a(1.0f);
        this.coord_color = color;
        this.coord_shape = shape;
    }

    public boolean func_180639_a(Level worldIn, BlockPos pos, BlockState state, Player playerIn, InteractionHand hand, Direction facing, float hitX, float hitY, float hitZ) {
        if (!playerIn.func_70093_af()) {
            ItemStack held = playerIn.func_184586_b(hand);
            boolean flag = false;
            if (held.func_77973_b().equals(ItemInit.configurationCellColor)) {
                flag = true;
                if (!worldIn.field_72995_K) {
                    boolean run = true;
                    while (run) {
                        BlockLaunchCoordinator newBlock = (BlockLaunchCoordinator)BlockLaunchCoordinator.getRandomCoordinator(worldIn);
                        if (newBlock.getShape() != this.getShape() || newBlock.getColor() == this.getColor()) continue;
                        worldIn.func_175656_a(pos, newBlock.func_176203_a(this.func_176201_c(state)));
                        run = false;
                    }
                }
            } else if (held.func_77973_b().equals(ItemInit.configurationCellShape)) {
                flag = true;
                if (!worldIn.field_72995_K) {
                    boolean run = true;
                    while (run) {
                        BlockLaunchCoordinator newBlock = (BlockLaunchCoordinator)BlockLaunchCoordinator.getRandomCoordinator(worldIn);
                        if (newBlock.getColor() != this.getColor() || newBlock.getShape() == this.getShape()) continue;
                        worldIn.func_175656_a(pos, newBlock.func_176203_a(this.func_176201_c(state)));
                        run = false;
                    }
                }
            }
            if (flag) {
                held.func_190918_g(1);
                worldIn.func_184133_a(null, pos, SoundEvents.field_187626_cN, SoundSource.MASTER, 1.0f, 1.0f);
            }
        }
        return true;
    }

    public void func_180633_a(Level worldIn, BlockPos pos, BlockState state, LivingEntity placer, ItemStack stack) {
        if (!worldIn.field_72995_K && placer instanceof Player) {
            worldIn.func_175656_a(pos, BlockLaunchCoordinator.getRandomCoordinator(worldIn).func_176223_P());
        }
    }

    public int getColor() {
        return this.coord_color;
    }

    public int getShape() {
        return this.coord_shape;
    }

    public Item func_180660_a(BlockState state, Random rand, int fortune) {
        return null;
    }

    private static Block getRandomCoordinator(Level worldIn) {
        Block[] coord = new Block[]{BlockInit.launchCoordinatorBlue1, BlockInit.launchCoordinatorBlue3, BlockInit.launchCoordinatorBlue4, BlockInit.launchCoordinatorBlue5, BlockInit.launchCoordinatorPurple1, BlockInit.launchCoordinatorPurple3, BlockInit.launchCoordinatorPurple4, BlockInit.launchCoordinatorPurple5, BlockInit.launchCoordinatorGreen1, BlockInit.launchCoordinatorGreen3, BlockInit.launchCoordinatorGreen4, BlockInit.launchCoordinatorGreen5, BlockInit.launchCoordinatorRed1, BlockInit.launchCoordinatorRed3, BlockInit.launchCoordinatorRed4, BlockInit.launchCoordinatorRed5};
        int block = worldIn.field_73012_v.nextInt(coord.length);
        return coord[block];
    }

    @SideOnly(value=Side.CLIENT)
    public void func_190948_a(ItemStack stack, @Nullable Level worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add((Object)((Object)TextFmt.Gold) + "Becomes a random launch coordinator when placed.");
        tooltip.add((Object)((Object)TextFmt.Red) + "Drops nothing when mined.");
    }
}

