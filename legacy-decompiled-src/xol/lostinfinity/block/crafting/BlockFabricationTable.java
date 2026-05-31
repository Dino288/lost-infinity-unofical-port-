/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.block.SoundType
 *  net.minecraft.block.state.BlockState
 *  net.minecraft.creativetab.CreativeModeTab
 *  net.minecraft.entity.player.Player
 *  net.minecraft.util.Direction
 *  net.minecraft.util.InteractionHand
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.text.Component
 *  net.minecraft.util.text.Component
 *  net.minecraft.world.World
 */
package xol.lostinfinity.block.crafting;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.entity.player.Player;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.Level;
import xol.lostinfinity.block.basic.BlockBasicGui;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.common.lostinfinity;
import xol.lostinfinity.gui.GuiHandler;
import xol.lostinfinity.init.BlockInit;
import xol.lostinfinity.init.TabsInit;

public class BlockFabricationTable
extends BlockBasicGui {
    public BlockFabricationTable(String name) {
        this(name, TabsInit.TAB_BLOCKS);
    }

    public BlockFabricationTable(String name, CreativeModeTab tab) {
        super(name, GuiHandler.RegisteredGuis.FABRICATION_STATION.getId());
        this.func_149647_a(tab);
        this.func_149672_a(SoundType.field_185852_e);
        this.func_149715_a(1.0f);
    }

    @Override
    public boolean func_180639_a(Level worldIn, BlockPos pos, BlockState state, Player playerIn, InteractionHand hand, Direction facing, float hitX, float hitY, float hitZ) {
        if (!playerIn.func_70093_af()) {
            BlockPos[] positions;
            int poweredCount = 0;
            Block poweredBlock = BlockInit.fabricationBattery;
            for (BlockPos position : positions = new BlockPos[]{pos.func_177982_a(0, -1, 1), pos.func_177982_a(-1, -1, 0), pos.func_177982_a(1, -1, 0), pos.func_177982_a(0, -1, -1)}) {
                if (!worldIn.func_180495_p(position).func_177230_c().equals(poweredBlock)) continue;
                ++poweredCount;
            }
            if (poweredCount == 4) {
                playerIn.openGui((Object)lostinfinity.instance, GuiHandler.RegisteredGuis.FABRICATION_STATION.getId(), worldIn, pos.func_177958_n(), pos.func_177956_o(), pos.func_177952_p());
            } else if (!worldIn.field_72995_K) {
                playerIn.func_145747_a((Component)new Component((Object)((Object)TextFmt.Red) + "The fabrication table is unpowered."));
            }
        }
        return true;
    }
}

