/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.block.SoundType
 *  net.minecraft.block.material.Material
 *  net.minecraft.block.state.BlockFaceShape
 *  net.minecraft.block.state.BlockState
 *  net.minecraft.creativetab.CreativeModeTab
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.init.Blocks
 *  net.minecraft.item.Item
 *  net.minecraft.item.BlockItem
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.Direction
 *  net.minecraft.util.NonNullList
 *  net.minecraft.util.math.AABB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.world.IBlockAccess
 *  net.minecraft.world.World
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package xol.lostinfinity.block.misc;

import java.util.Random;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
import net.minecraft.world.phys.AABB;
import net.minecraft.core.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xol.lostinfinity.init.BlockInit;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.init.TabsInit;
import xol.lostinfinity.util.data.IMaxAttack;

public class BlockAcidicGel
extends Block
implements IMaxAttack {
    protected static final AABB CARPET_AABB = new AABB(0.0, 0.0, 0.0, 1.0, 0.0625, 1.0);

    public BlockAcidicGel(String name, float hardness, Material material) {
        this(name, hardness, material, TabsInit.TAB_BLOCKS);
    }

    public BlockAcidicGel(String name, float hardness, Material material, CreativeModeTab tab) {
        super(material);
        this.func_149663_c(name);
        this.setRegistryName(name);
        this.func_149647_a(tab);
        this.func_149722_s();
        this.func_149672_a(SoundType.field_185859_l);
        this.func_149675_a(true);
        BlockInit.BLOCKS.add(this);
        ItemInit.ITEMS.add((Item)new BlockItem((Block)this).setRegistryName(this.getRegistryName()));
    }

    public AABB func_185496_a(BlockState state, IBlockAccess source, BlockPos pos) {
        return CARPET_AABB;
    }

    public boolean func_149662_c(BlockState state) {
        return false;
    }

    public boolean func_149686_d(BlockState state) {
        return false;
    }

    public boolean func_176196_c(Level worldIn, BlockPos pos) {
        return super.func_176196_c(worldIn, pos) && this.canBlockStay(worldIn, pos);
    }

    public void func_189540_a(BlockState state, Level worldIn, BlockPos pos, Block blockIn, BlockPos fromPos) {
        this.checkForDrop(worldIn, pos, state);
    }

    public void func_180634_a(Level worldIn, BlockPos pos, BlockState state, Entity entityIn) {
        if (!worldIn.field_72995_K && entityIn instanceof Player && entityIn.field_70173_aa % 4 == 2) {
            IMaxAttack.dealPotionDamage((LivingEntity)entityIn, ((LivingEntity)entityIn).func_110138_aP() / 10.0f);
        }
    }

    public void getDrops(NonNullList<ItemStack> drops, IBlockAccess world, BlockPos pos, BlockState state, int fortune) {
        drops.clear();
    }

    public void func_180650_b(Level worldIn, BlockPos pos, BlockState state, Random rand) {
        worldIn.func_175656_a(pos, Blocks.field_150350_a.func_176223_P());
    }

    private boolean checkForDrop(Level worldIn, BlockPos pos, BlockState state) {
        if (!this.canBlockStay(worldIn, pos)) {
            worldIn.func_175698_g(pos);
            return false;
        }
        return true;
    }

    private boolean canBlockStay(Level worldIn, BlockPos pos) {
        return !worldIn.func_175623_d(pos.func_177977_b());
    }

    @SideOnly(value=Side.CLIENT)
    public boolean func_176225_a(BlockState blockState, IBlockAccess blockAccess, BlockPos pos, Direction side) {
        if (side == Direction.UP) {
            return true;
        }
        return blockAccess.func_180495_p(pos.func_177972_a(side)).func_177230_c() == this ? true : super.func_176225_a(blockState, blockAccess, pos, side);
    }

    public BlockFaceShape func_193383_a(IBlockAccess worldIn, BlockState state, BlockPos pos, Direction face) {
        return face == Direction.DOWN ? BlockFaceShape.SOLID : BlockFaceShape.UNDEFINED;
    }
}

