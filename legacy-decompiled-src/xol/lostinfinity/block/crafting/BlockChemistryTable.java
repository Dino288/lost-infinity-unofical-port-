/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.block.Block
 *  net.minecraft.block.IBlockEntityProvider
 *  net.minecraft.block.SoundType
 *  net.minecraft.block.material.Material
 *  net.minecraft.block.state.BlockState
 *  net.minecraft.creativetab.CreativeModeTab
 *  net.minecraft.entity.player.Player
 *  net.minecraft.inventory.IInventory
 *  net.minecraft.inventory.InventoryHelper
 *  net.minecraft.tileentity.BlockEntity
 *  net.minecraft.util.Direction
 *  net.minecraft.util.InteractionHand
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.world.World
 */
package xol.lostinfinity.block.crafting;

import javax.annotation.Nullable;
import net.minecraft.world.level.block.Block;
import net.minecraft.block.IBlockEntityProvider;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.entity.player.Player;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import xol.lostinfinity.block.basic.BlockBasicGui;
import xol.lostinfinity.block.tileentity.BlockEntityChemistryTable;
import xol.lostinfinity.common.lostinfinity;
import xol.lostinfinity.gui.GuiHandler;
import xol.lostinfinity.init.TabsInit;

public class BlockChemistryTable
extends BlockBasicGui
implements IBlockEntityProvider {
    public BlockChemistryTable(String name) {
        this(name, Material.field_151576_e, TabsInit.TAB_BLOCKS);
    }

    public BlockChemistryTable(String name, Material material, CreativeModeTab tab) {
        super(name, material, tab);
        this.func_149647_a(tab).func_149711_c(3.0f).func_149752_b(10.0f);
        this.func_149672_a(SoundType.field_185851_d);
    }

    @Override
    public boolean func_180639_a(Level worldIn, BlockPos pos, BlockState state, Player playerIn, InteractionHand hand, Direction facing, float hitX, float hitY, float hitZ) {
        if (!playerIn.func_70093_af()) {
            playerIn.openGui((Object)lostinfinity.instance, GuiHandler.RegisteredGuis.CHEMISTRY_TABLE.getId(), worldIn, pos.func_177958_n(), pos.func_177956_o(), pos.func_177952_p());
        }
        return true;
    }

    @Nullable
    public BlockEntity func_149915_a(Level worldIn, int meta) {
        return null;
    }

    public BlockEntity createBlockEntity(Level world, BlockState state) {
        return new BlockEntityChemistryTable();
    }

    public boolean hasBlockEntity(BlockState state) {
        return true;
    }

    public void func_180663_b(Level worldIn, BlockPos pos, BlockState state) {
        BlockEntity tileentity;
        if (this.hasBlockEntity(state) && (tileentity = worldIn.func_175625_s(pos)) instanceof BlockEntityChemistryTable) {
            InventoryHelper.func_180175_a((World)worldIn, (BlockPos)pos, (IInventory)((BlockEntityChemistryTable)tileentity));
            worldIn.func_175666_e(pos, (Block)this);
            worldIn.func_175713_t(pos);
        }
    }
}

