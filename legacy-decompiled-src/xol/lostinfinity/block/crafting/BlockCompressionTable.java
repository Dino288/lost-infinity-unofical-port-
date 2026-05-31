/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.block.SoundType
 *  net.minecraft.block.material.Material
 *  net.minecraft.block.state.BlockState
 *  net.minecraft.client.util.ITooltipFlag
 *  net.minecraft.creativetab.CreativeModeTab
 *  net.minecraft.entity.player.Player
 *  net.minecraft.item.ItemStack
 *  net.minecraft.tileentity.BlockEntity
 *  net.minecraft.util.Direction
 *  net.minecraft.util.InteractionHand
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.world.World
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package xol.lostinfinity.block.crafting;

import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xol.lostinfinity.block.basic.BlockBasicGui;
import xol.lostinfinity.block.tileentity.BlockEntityCompressionTable;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.common.lostinfinity;
import xol.lostinfinity.gui.GuiHandler;
import xol.lostinfinity.init.TabsInit;

public class BlockCompressionTable
extends BlockBasicGui {
    public BlockCompressionTable(String name) {
        this(name, Material.field_151576_e);
    }

    public BlockCompressionTable(String name, Material material) {
        this(name, material, TabsInit.TAB_BLOCKS);
    }

    public BlockCompressionTable(String name, Material material, CreativeModeTab tab) {
        super(name, material, tab);
        this.func_149647_a(tab);
        this.func_149672_a(SoundType.field_185851_d);
        this.func_149715_a(1.0f);
    }

    public BlockEntity createBlockEntity(Level world, BlockState state) {
        return new BlockEntityCompressionTable();
    }

    public boolean hasBlockEntity(BlockState state) {
        return true;
    }

    private BlockEntityCompressionTable getTE(Level world, BlockPos pos) {
        return (BlockEntityCompressionTable)world.func_175625_s(pos);
    }

    @Override
    public boolean func_180639_a(Level worldIn, BlockPos pos, BlockState state, Player playerIn, InteractionHand hand, Direction facing, float hitX, float hitY, float hitZ) {
        if (!playerIn.func_70093_af()) {
            playerIn.openGui((Object)lostinfinity.instance, GuiHandler.RegisteredGuis.COMPRESSION_TABLE.getId(), worldIn, pos.func_177958_n(), pos.func_177956_o(), pos.func_177952_p());
        }
        return true;
    }

    @SideOnly(value=Side.CLIENT)
    public void func_190948_a(ItemStack stack, @Nullable Level worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add((Object)((Object)TextFmt.Italic) + "Unleashes an extremely powerful shockwave when given a Celestial Emerald.");
        tooltip.add((Object)((Object)TextFmt.Italic) + "Per Module Upgrades:");
        tooltip.add((Object)((Object)TextFmt.Red) + "NW: Power Modules | 22% Damage");
        tooltip.add((Object)((Object)TextFmt.Aqua) + "NE: Efficiency Modules | 16% Reduced Consumption");
        tooltip.add((Object)((Object)TextFmt.Light_Purple) + "SE: Depth Modules | 4 Blocks Up/Down");
        tooltip.add((Object)((Object)TextFmt.Yellow) + "SW: Range Modules | 8 Block Radius");
    }
}

