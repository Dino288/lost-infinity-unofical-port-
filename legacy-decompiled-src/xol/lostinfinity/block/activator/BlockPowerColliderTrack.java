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
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Vec3i;
import net.minecraft.world.level.Level;
import xol.lostinfinity.block.activator.BlockPowerCollider;
import xol.lostinfinity.block.basic.BlockBasic;
import xol.lostinfinity.block.tileentity.BlockEntityPowerCollider;

public class BlockPowerColliderTrack
extends BlockBasic {
    public static final IntegerProperty AMOUNT = IntegerProperty.func_177719_a((String)"amount", (int)0, (int)2);
    private static final Vec3i offset = new Vec3i(0, 0, 0);

    public BlockPowerColliderTrack(String name) {
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
        BlockPos collider;
        if (!worldIn.field_72995_K && (collider = this.findCollider(worldIn, pos)) != null && (tileEntity = worldIn.func_175625_s(collider)) != null && tileEntity instanceof BlockEntityPowerCollider) {
            BlockEntityPowerCollider TE = (BlockEntityPowerCollider)tileEntity;
            TE.light(pos);
        }
        return true;
    }

    private BlockPos findCollider(Level worldIn, BlockPos pos) {
        BlockPos ref = pos.func_177971_a(offset);
        int radius = 30;
        for (int i = -radius; i < radius; ++i) {
            for (int j = -radius; j < radius; ++j) {
                BlockPos check = ref.func_177982_a(i, 0, j);
                Block block = worldIn.func_180495_p(check).func_177230_c();
                if (!(block instanceof BlockPowerCollider)) continue;
                return check;
            }
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

