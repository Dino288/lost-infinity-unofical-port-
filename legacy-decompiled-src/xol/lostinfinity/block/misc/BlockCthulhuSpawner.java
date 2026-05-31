/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.block.IBlockEntityProvider
 *  net.minecraft.block.properties.Property
 *  net.minecraft.block.state.BlockState
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.tileentity.BlockEntity
 *  net.minecraft.util.Direction
 *  net.minecraft.util.InteractionHand
 *  net.minecraft.util.SoundSource
 *  net.minecraft.util.math.AABB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.world.World
 */
package xol.lostinfinity.block.misc;

import javax.annotation.Nullable;
import net.minecraft.block.IBlockEntityProvider;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.phys.AABB;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import xol.lostinfinity.block.basic.BlockBasicRotational;
import xol.lostinfinity.block.tileentity.BlockEntityCthulhuSpawner;
import xol.lostinfinity.common.lostinfinity;
import xol.lostinfinity.gui.GuiHandler;
import xol.lostinfinity.init.BlockInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.mob.entity.cthulhu.EntityCthulhu;

public class BlockCthulhuSpawner
extends BlockBasicRotational
implements IBlockEntityProvider {
    public static final int BLOCK_DISTANCE = 30;

    public BlockCthulhuSpawner(String name) {
        super(name);
    }

    @Nullable
    public BlockEntity func_149915_a(Level worldIn, int meta) {
        return new BlockEntityCthulhuSpawner();
    }

    public static Direction getFacing(Level world, BlockPos pos) {
        BlockState state = world.func_180495_p(pos);
        if (state.func_177230_c() != BlockInit.cthulhuSpawner) {
            return Direction.DOWN;
        }
        return (Direction)state.func_177229_b((Property)field_185512_D);
    }

    public static boolean spawnCthulhu(Level world, BlockPos pos) {
        BlockState state = world.func_180495_p(pos);
        if (state.func_177230_c() != BlockInit.cthulhuSpawner) {
            return false;
        }
        BlockPos center = pos.func_177967_a(Direction.NORTH, 30);
        BlockPos east = center.func_177967_a(Direction.WEST, 30);
        BlockPos south = center.func_177967_a(Direction.NORTH, 30);
        BlockPos west = center.func_177967_a(Direction.EAST, 30);
        if (BlockCthulhuSpawner.getFacing(world, east) != Direction.EAST || BlockCthulhuSpawner.getFacing(world, south) != Direction.SOUTH || BlockCthulhuSpawner.getFacing(world, west) != Direction.WEST) {
            return false;
        }
        BlockEntityCthulhuSpawner eastSpawner = (BlockEntityCthulhuSpawner)world.func_175625_s(east);
        BlockEntityCthulhuSpawner southSpawner = (BlockEntityCthulhuSpawner)world.func_175625_s(south);
        BlockEntityCthulhuSpawner westSpawner = (BlockEntityCthulhuSpawner)world.func_175625_s(west);
        if (BlockCthulhuSpawner.isValid(eastSpawner) && BlockCthulhuSpawner.isValid(southSpawner) && BlockCthulhuSpawner.isValid(westSpawner)) {
            eastSpawner.spawned = true;
            southSpawner.spawned = true;
            westSpawner.spawned = true;
            EntityCthulhu cthulhu = new EntityCthulhu(world);
            cthulhu.func_70107_b((double)center.func_177958_n() + 0.5, center.func_177956_o(), (double)center.func_177952_p() + 0.5);
            world.func_72838_d((Entity)cthulhu);
            world.func_184133_a(null, cthulhu.func_180425_c(), SoundInit.TT_PORTAL, SoundSource.HOSTILE, 1.0f, 1.0f);
            for (Player contender : world.func_72872_a(Player.class, new AABB(cthulhu.func_180425_c()).func_186662_g(70.0))) {
                world.func_184133_a(null, contender.func_180425_c(), SoundInit.TT_PORTAL, SoundSource.HOSTILE, 1.0f, 1.0f);
            }
            return true;
        }
        return false;
    }

    private static boolean isValid(BlockEntityCthulhuSpawner spawner) {
        return spawner != null && spawner.canSpawn();
    }

    public boolean func_180639_a(Level worldIn, BlockPos pos, BlockState state, Player playerIn, InteractionHand hand, Direction facing, float hitX, float hitY, float hitZ) {
        if (!playerIn.func_70093_af()) {
            playerIn.openGui((Object)lostinfinity.instance, GuiHandler.RegisteredGuis.CTHULHU_SPAWNER.getId(), worldIn, pos.func_177958_n(), pos.func_177956_o(), pos.func_177952_p());
        }
        return true;
    }
}

