/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.block.IBlockEntityProvider
 *  net.minecraft.block.material.Material
 *  net.minecraft.block.state.BlockState
 *  net.minecraft.client.util.ITooltipFlag
 *  net.minecraft.creativetab.CreativeModeTab
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.item.ItemStack
 *  net.minecraft.tileentity.BlockEntity
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
package xol.lostinfinity.block.misc;

import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.block.IBlockEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundSource;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xol.lostinfinity.block.basic.BlockBasicGui;
import xol.lostinfinity.block.tileentity.BlockEntityNebulousBeacon;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.common.lostinfinity;
import xol.lostinfinity.gui.GuiHandler;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.init.TabsInit;

public class BlockNebulousBeacon
extends BlockBasicGui
implements IBlockEntityProvider {
    private BlockEntityNebulousBeacon tileEntity;

    public BlockNebulousBeacon(String name) {
        super(name, Material.field_151576_e, TabsInit.TAB_BLOCKS);
    }

    public BlockNebulousBeacon(String name, Material material, CreativeModeTab tab) {
        super(name, material, tab);
    }

    public BlockEntity createBlockEntity(Level worldIn, BlockState state) {
        this.tileEntity = new BlockEntityNebulousBeacon();
        return this.tileEntity;
    }

    public boolean hasBlockEntity(BlockState state) {
        return true;
    }

    public BlockEntity func_149915_a(Level worldIn, int meta) {
        return null;
    }

    @Override
    public boolean func_180639_a(Level worldIn, BlockPos pos, BlockState state, Player playerIn, InteractionHand hand, Direction facing, float hitX, float hitY, float hitZ) {
        if (!playerIn.func_70093_af()) {
            playerIn.openGui((Object)lostinfinity.instance, GuiHandler.RegisteredGuis.NEBULOUS_BEACON.getId(), worldIn, pos.func_177958_n(), pos.func_177956_o(), pos.func_177952_p());
        }
        return true;
    }

    @SideOnly(value=Side.CLIENT)
    public void func_190948_a(ItemStack stack, @Nullable Level worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add((Object)((Object)TextFmt.Light_Purple) + "When placed, this beacon will charge up an astral generator.");
        tooltip.add((Object)((Object)TextFmt.Dark_Purple) + "Nebulous Enemies will detect the beacon and attack it.");
        tooltip.add((Object)((Object)TextFmt.Gray) + "Protect the beacon until it is fully charged to receive the generator.");
    }

    public void func_180663_b(Level worldIn, BlockPos pos, BlockState state) {
        BlockEntity brokenBlockEntity;
        if (this.hasBlockEntity(state) && (brokenBlockEntity = worldIn.func_175625_s(pos)) instanceof BlockEntityNebulousBeacon) {
            worldIn.func_175713_t(pos);
        }
    }

    public void func_180633_a(Level worldIn, BlockPos pos, BlockState state, LivingEntity placer, ItemStack stack) {
        if (worldIn.field_72995_K) {
            placer.func_145747_a((Component)new Component((Object)((Object)TextFmt.Light_Purple) + "The beacon has been placed. Prepare your defenses."));
        } else {
            worldIn.func_184148_a(null, (double)pos.func_177958_n(), (double)pos.func_177956_o(), (double)pos.func_177952_p(), SoundInit.IMPENDING_DOOM, SoundSource.PLAYERS, 3.0f, 1.0f);
        }
    }
}

