/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.IBlockEntityProvider
 *  net.minecraft.block.state.BlockState
 *  net.minecraft.entity.player.Player
 *  net.minecraft.item.Item
 *  net.minecraft.tileentity.BlockEntity
 *  net.minecraft.util.Direction
 *  net.minecraft.util.InteractionHand
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.world.World
 */
package xol.lostinfinity.block.activator;

import net.minecraft.block.IBlockEntityProvider;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import xol.lostinfinity.block.basic.BlockBasicBoolState;
import xol.lostinfinity.block.tileentity.BlockEntityPortalNexus;
import xol.lostinfinity.block.tileentity.BlockEntityPortalNode;
import xol.lostinfinity.init.BlockInit;
import xol.lostinfinity.init.ItemInit;

public class BlockPortalNode
extends BlockBasicBoolState
implements IBlockEntityProvider {
    public BlockPortalNode(String name) {
        super(name);
    }

    private boolean validInput(Item item) {
        return item.equals(ItemInit.blightedCapacitor);
    }

    public boolean func_180639_a(Level worldIn, BlockPos pos, BlockState state, Player playerIn, InteractionHand hand, Direction facing, float hitX, float hitY, float hitZ) {
        if (!playerIn.func_70093_af()) {
            if (this.validInput(playerIn.func_184586_b(hand).func_77973_b())) {
                if (!worldIn.field_72995_K) {
                    if (state.equals(BlockInit.portalNode.func_176203_a(0))) {
                        int radius = 15;
                        BlockEntityPortalNode node = (BlockEntityPortalNode)worldIn.func_175625_s(pos);
                        if (node != null) {
                            BlockEntityPortalNexus nexus = null;
                            BlockPos nexusPos = null;
                            block0: for (int i = -radius; i <= radius; ++i) {
                                for (int k = -radius; k <= radius; ++k) {
                                    nexusPos = pos.func_177982_a(i, 0, k);
                                    if (!worldIn.func_180495_p(nexusPos).func_177230_c().equals(BlockInit.portalNexus)) continue;
                                    nexus = (BlockEntityPortalNexus)worldIn.func_175625_s(nexusPos);
                                    break block0;
                                }
                            }
                            if (nexus != null && nexusPos != null) {
                                nexus.addNodePos(pos);
                            }
                        }
                        worldIn.func_175656_a(pos, BlockInit.portalNode.func_176203_a(1));
                    }
                } else {
                    int radius = 15;
                    BlockEntityPortalNode node = (BlockEntityPortalNode)worldIn.func_175625_s(pos);
                    if (node != null) {
                        BlockEntityPortalNexus nexus = null;
                        BlockPos nexusPos = null;
                        block2: for (int i = -radius; i <= radius; ++i) {
                            for (int k = -radius; k <= radius; ++k) {
                                nexusPos = pos.func_177982_a(i, 0, k);
                                if (!worldIn.func_180495_p(nexusPos).func_177230_c().equals(BlockInit.portalNexus)) continue;
                                nexus = (BlockEntityPortalNexus)worldIn.func_175625_s(nexusPos);
                                break block2;
                            }
                        }
                        if (nexus != null && nexusPos != null) {
                            node.setNexusPos(nexusPos);
                        }
                    }
                }
            }
            playerIn.func_184586_b(hand).func_190918_g(1);
        }
        return true;
    }

    public BlockEntity createBlockEntity(Level world, BlockState state) {
        return new BlockEntityPortalNode();
    }

    public boolean hasBlockEntity(BlockState state) {
        return true;
    }

    public BlockEntity func_149915_a(Level worldIn, int meta) {
        return null;
    }
}

