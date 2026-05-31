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
 *  net.minecraft.util.math.BlockPos
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
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import xol.lostinfinity.block.activator.BlockAncientSymbolInterpreter;
import xol.lostinfinity.block.basic.BlockBasic;
import xol.lostinfinity.block.tileentity.BlockEntityAncientSymbolInterpreter;

public class BlockAncientSymbol
extends BlockBasic {
    public static final IntegerProperty AMOUNT = IntegerProperty.func_177719_a((String)"amount", (int)0, (int)15);

    public BlockAncientSymbol(String name) {
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
        if (!worldIn.field_72995_K) {
            BlockEntity tileEntity;
            if (this.func_176201_c(state) != 0) {
                return true;
            }
            BlockPos interpreter = this.findInterpreter(worldIn, pos);
            if (interpreter != null && (tileEntity = worldIn.func_175625_s(interpreter)) != null && tileEntity instanceof BlockEntityAncientSymbolInterpreter) {
                BlockEntityAncientSymbolInterpreter TE = (BlockEntityAncientSymbolInterpreter)tileEntity;
                TE.flip(pos);
            }
        }
        return true;
    }

    private BlockPos findInterpreter(Level worldIn, BlockPos pos) {
        ArrayList<BlockPos> visited = new ArrayList<BlockPos>();
        Stack<BlockPos> toVisit = new Stack<BlockPos>();
        visited.add(pos);
        toVisit.addAll(this.getNeighbours(pos));
        while (!toVisit.isEmpty()) {
            BlockPos node = (BlockPos)toVisit.pop();
            if (node == null) continue;
            Block block = worldIn.func_180495_p(node).func_177230_c();
            Block upBlock = worldIn.func_180495_p(node.func_177982_a(0, 3, 0)).func_177230_c();
            if (block instanceof BlockAncientSymbol) {
                visited.add(node);
                ArrayList<BlockPos> neighbours = this.getNeighbours(node);
                for (BlockPos neighbour : neighbours) {
                    if (visited.contains(neighbour)) continue;
                    toVisit.add(neighbour);
                }
                continue;
            }
            if (!(upBlock instanceof BlockAncientSymbolInterpreter)) continue;
            return node.func_177982_a(0, 3, 0);
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

