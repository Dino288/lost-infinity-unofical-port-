/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.block.properties.Property
 *  net.minecraft.block.properties.IntegerProperty
 *  net.minecraft.block.state.StateDefinition
 *  net.minecraft.block.state.BlockState
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.tileentity.BlockEntity
 *  net.minecraft.util.Direction
 *  net.minecraft.util.InteractionHand
 *  net.minecraft.util.SoundSource
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Vec3i
 *  net.minecraft.world.World
 */
package xol.lostinfinity.block.activator;

import java.util.ArrayList;
import java.util.Stack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundSource;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Vec3i;
import net.minecraft.world.level.Level;
import xol.lostinfinity.block.activator.BlockPowerConduit;
import xol.lostinfinity.block.basic.BlockBasicLight;
import xol.lostinfinity.block.tileentity.BlockEntityPowerConduit;
import xol.lostinfinity.init.BlockInit;
import xol.lostinfinity.init.SoundInit;

public class BlockPowerNodule
extends BlockBasicLight {
    public static final IntegerProperty AMOUNT = IntegerProperty.func_177719_a((String)"amount", (int)0, (int)3);

    public BlockPowerNodule(String name) {
        super(name);
    }

    public BlockState func_180642_a(Level worldIn, BlockPos pos, Direction facing, float hitX, float hitY, float hitZ, int meta, LivingEntity placer) {
        return this.func_176223_P().func_177226_a((Property)AMOUNT, (Comparable)Integer.valueOf(0));
    }

    public BlockState func_176203_a(int meta) {
        return this.func_176223_P().func_177226_a((Property)AMOUNT, (Comparable)Integer.valueOf(meta));
    }

    public int func_176201_c(BlockState state) {
        return (Integer)state.func_177229_b((Property)AMOUNT);
    }

    protected StateDefinition func_180661_e() {
        return new StateDefinition((Block)this, new Property[]{AMOUNT});
    }

    public boolean func_180639_a(Level worldIn, BlockPos pos, BlockState state, Player playerIn, InteractionHand hand, Direction facing, float hitX, float hitY, float hitZ) {
        BlockEntity tileEntity;
        BlockPos gameBlock;
        if (!worldIn.field_72995_K && (gameBlock = this.findGameBlock(worldIn, pos)) != null && (tileEntity = worldIn.func_175625_s(gameBlock)) != null && tileEntity instanceof BlockEntityPowerConduit) {
            BlockEntityPowerConduit TE = (BlockEntityPowerConduit)tileEntity;
            ArrayList<BlockPos> tiles = TE.getTiles();
            BlockPos connectorPos = null;
            for (BlockPos tilePos : tiles) {
                if (this.func_176201_c(worldIn.func_180495_p(tilePos)) != 3) continue;
                connectorPos = tilePos;
                break;
            }
            if (connectorPos != null) {
                boolean xDir = pos.func_177958_n() - connectorPos.func_177958_n() > 0;
                boolean zDir = pos.func_177952_p() - connectorPos.func_177952_p() > 0;
                Vec3i upDir = TE.getUpDir();
                Vec3i newDir = null;
                if (xDir) {
                    if (upDir.func_177958_n() > 0) {
                        newDir = new Vec3i(1, 0, 0);
                    } else if (upDir.func_177958_n() < 0) {
                        newDir = new Vec3i(1, 0, 0);
                    }
                } else if (upDir.func_177958_n() > 0) {
                    newDir = new Vec3i(-1, 0, 0);
                } else if (upDir.func_177958_n() < 0) {
                    newDir = new Vec3i(-1, 0, 0);
                }
                if (zDir) {
                    if (upDir.func_177952_p() > 0) {
                        newDir = new Vec3i(0, 0, 1);
                    } else if (upDir.func_177952_p() < 0) {
                        newDir = new Vec3i(0, 0, 1);
                    }
                } else if (upDir.func_177952_p() > 0) {
                    newDir = new Vec3i(0, 0, -1);
                } else if (upDir.func_177952_p() < 0) {
                    newDir = new Vec3i(0, 0, -1);
                }
                BlockPos next = connectorPos.func_177971_a(newDir);
                BlockState nextState = worldIn.func_180495_p(next);
                if (!nextState.func_177230_c().equals(BlockInit.powerNodule)) {
                    return true;
                }
                worldIn.func_184133_a(null, connectorPos, SoundInit.GENERIC_UI_2, SoundSource.BLOCKS, 1.0f, 0.8f * worldIn.field_73012_v.nextFloat() * 0.4f);
                if (BlockInit.powerNodule.func_176201_c(nextState) == 2) {
                    worldIn.func_175656_a(next, BlockInit.powerNodule.func_176203_a(3));
                    worldIn.func_175656_a(connectorPos, BlockInit.powerNodule.func_176203_a(2));
                } else if (BlockInit.powerNodule.func_176201_c(nextState) == 0) {
                    worldIn.func_175656_a(next, BlockInit.powerNodule.func_176203_a(1));
                    worldIn.func_175656_a(connectorPos, BlockInit.powerNodule.func_176203_a(2));
                }
            }
        }
        return true;
    }

    private BlockPos findGameBlock(Level worldIn, BlockPos pos) {
        Vec3i offset = new Vec3i(0, 2, 0);
        ArrayList<BlockPos> visited = new ArrayList<BlockPos>();
        Stack<BlockPos> toVisit = new Stack<BlockPos>();
        visited.add(pos);
        toVisit.addAll(this.getNeighbours(pos));
        while (!toVisit.isEmpty()) {
            BlockPos node = (BlockPos)toVisit.pop();
            if (node == null) continue;
            Block block = worldIn.func_180495_p(node).func_177230_c();
            Block upBlock = worldIn.func_180495_p(node.func_177971_a(offset)).func_177230_c();
            if (block instanceof BlockPowerNodule) {
                visited.add(node);
                ArrayList<BlockPos> neighbours = this.getNeighbours(node);
                for (BlockPos neighbour : neighbours) {
                    if (visited.contains(neighbour)) continue;
                    toVisit.add(neighbour);
                }
                continue;
            }
            if (!(upBlock instanceof BlockPowerConduit)) continue;
            return node.func_177971_a(offset);
        }
        return null;
    }

    ArrayList<BlockPos> getNeighbours(BlockPos pos) {
        ArrayList<BlockPos> neighbours = new ArrayList<BlockPos>();
        neighbours.add(pos.func_177982_a(1, 0, 0));
        neighbours.add(pos.func_177982_a(-1, 0, 0));
        neighbours.add(pos.func_177982_a(1, 0, 1));
        neighbours.add(pos.func_177982_a(1, 0, -1));
        neighbours.add(pos.func_177982_a(-1, 0, 1));
        neighbours.add(pos.func_177982_a(-1, 0, -1));
        neighbours.add(pos.func_177982_a(0, 0, 1));
        neighbours.add(pos.func_177982_a(0, 0, -1));
        return neighbours;
    }
}

