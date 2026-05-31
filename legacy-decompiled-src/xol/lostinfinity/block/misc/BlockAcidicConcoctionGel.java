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
import xol.lostinfinity.init.PotionInit;
import xol.lostinfinity.init.TabsInit;
import xol.lostinfinity.mob.entity.base.EntityImmaterial;
import xol.lostinfinity.projectile.entity.EntityPoisonousBubble;
import xol.lostinfinity.util.data.IMaxAttack;

public class BlockAcidicConcoctionGel
extends Block
implements IMaxAttack {
    protected static final AABB CARPET_AABB = new AABB(0.0, 0.0, 0.0, 1.0, 0.0625, 1.0);

    public BlockAcidicConcoctionGel(String name, float hardness, Material material) {
        this(name, hardness, material, TabsInit.TAB_BLOCKS);
    }

    public BlockAcidicConcoctionGel(String name, float hardness, Material material, CreativeModeTab tab) {
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
        if (!worldIn.field_72995_K && entityIn instanceof LivingEntity && !(entityIn instanceof EntityImmaterial) && entityIn.field_70173_aa % 4 == 2) {
            if (entityIn instanceof Player && ((Player)entityIn).func_70644_a(PotionInit.ACIDIC)) {
                return;
            }
            IMaxAttack.dealPotionDamage((LivingEntity)entityIn, ((LivingEntity)entityIn).func_110138_aP() / 10.0f);
        }
    }

    public void getDrops(NonNullList<ItemStack> drops, IBlockAccess world, BlockPos pos, BlockState state, int fortune) {
        drops.clear();
    }

    public void func_180650_b(Level worldIn, BlockPos pos, BlockState state, Random rand) {
        if (rand.nextBoolean()) {
            worldIn.func_175656_a(pos, Blocks.field_150350_a.func_176223_P());
        } else {
            BlockAcidicConcoctionGel.releasePoison(worldIn, pos);
        }
    }

    private static void releasePoison(Level worldIn, BlockPos pos) {
        if (!worldIn.field_72995_K) {
            int radius = 2;
            for (BlockPos poisonPos : BlockPos.func_177980_a((BlockPos)pos.func_177982_a(-radius, -radius, -radius), (BlockPos)pos.func_177982_a(radius, radius, radius))) {
                if (!worldIn.func_180495_p(poisonPos).equals(BlockInit.acidicConcoctionGel.func_176223_P()) || worldIn.field_73012_v.nextInt(3) != 0) continue;
                for (int i = 0; i < 2; ++i) {
                    EntityPoisonousBubble bubble = new EntityPoisonousBubble(worldIn);
                    bubble.func_70634_a((double)poisonPos.func_177958_n() + worldIn.field_73012_v.nextDouble() * 0.5 - 0.25, (float)poisonPos.func_177956_o() + 0.2f, (double)poisonPos.func_177952_p() + worldIn.field_73012_v.nextDouble() * 0.5 - 0.25);
                    bubble.func_70186_c(0.0, 1.0, 0.0, 0.2f, 3.0f);
                    worldIn.func_72838_d((Entity)bubble);
                }
            }
        }
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

