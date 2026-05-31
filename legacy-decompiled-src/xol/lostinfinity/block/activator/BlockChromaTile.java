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
 *  net.minecraft.util.Direction
 *  net.minecraft.util.InteractionHand
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Vec3i
 *  net.minecraft.world.World
 */
package xol.lostinfinity.block.activator;

import java.util.ArrayList;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Vec3i;
import net.minecraft.world.level.Level;
import xol.lostinfinity.block.basic.BlockBasic;
import xol.lostinfinity.block.tileentity.BlockEntityChromaGame;
import xol.lostinfinity.init.BlockInit;

public class BlockChromaTile
extends BlockBasic {
    public static final IntegerProperty AMOUNT = IntegerProperty.func_177719_a((String)"amount", (int)0, (int)3);

    public BlockChromaTile(String name) {
        super(name);
    }

    public boolean func_180639_a(Level worldIn, BlockPos pos, BlockState state, Player playerIn, InteractionHand hand, Direction facing, float hitX, float hitY, float hitZ) {
        if (!worldIn.field_72995_K) {
            worldIn.func_175656_a(pos, this.getNewState(worldIn, pos, state, playerIn));
            ArrayList<Vec3i> neighbours = new ArrayList<Vec3i>();
            neighbours.add(new Vec3i(1, 0, 0));
            neighbours.add(new Vec3i(-1, 0, 0));
            neighbours.add(new Vec3i(0, 0, 1));
            neighbours.add(new Vec3i(0, 0, -1));
            for (Vec3i neighbour : neighbours) {
                BlockState neighbourState = worldIn.func_180495_p(pos.func_177971_a(neighbour));
                Block block = neighbourState.func_177230_c();
                if (!(block instanceof BlockChromaTile)) continue;
                worldIn.func_175656_a(pos.func_177971_a(neighbour), this.getNewState(worldIn, pos, neighbourState, playerIn));
            }
        }
        return true;
    }

    private BlockState getNewState(Level worldIn, BlockPos pos, BlockState state, Player playerIn) {
        int meta = this.func_176201_c(state);
        BlockPos ref = pos.func_177982_a(0, 0, 0);
        int radius = 20;
        for (int i = -radius; i <= radius; ++i) {
            for (int j = -radius; j <= radius; ++j) {
                BlockPos check = ref.func_177982_a(i, 0, j);
                if (!worldIn.func_180495_p(check).func_177230_c().equals(BlockInit.chromaGame) || worldIn.func_175625_s(check) == null || !(worldIn.func_175625_s(check) instanceof BlockEntityChromaGame)) continue;
                BlockEntityChromaGame tileentity = (BlockEntityChromaGame)worldIn.func_175625_s(check);
                if (tileentity.isFirst(playerIn)) {
                    switch (meta) {
                        case 0: {
                            return this.func_176203_a(1);
                        }
                        case 1: {
                            return this.func_176203_a(0);
                        }
                        case 2: {
                            return this.func_176203_a(3);
                        }
                        case 3: {
                            return this.func_176203_a(2);
                        }
                    }
                    continue;
                }
                if (tileentity.isSecond(playerIn)) {
                    switch (meta) {
                        case 0: {
                            return this.func_176203_a(2);
                        }
                        case 1: {
                            return this.func_176203_a(3);
                        }
                        case 2: {
                            return this.func_176203_a(0);
                        }
                        case 3: {
                            return this.func_176203_a(1);
                        }
                    }
                    continue;
                }
                return state;
            }
        }
        return state;
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
}

