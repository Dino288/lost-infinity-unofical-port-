/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.block.IBlockEntityProvider
 *  net.minecraft.block.state.BlockState
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.item.ItemEntity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.item.ItemStack
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.tileentity.BlockEntity
 *  net.minecraft.util.Direction
 *  net.minecraft.util.InteractionHand
 *  net.minecraft.util.SoundSource
 *  net.minecraft.util.math.AABB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Vec3i
 *  net.minecraft.world.World
 */
package xol.lostinfinity.block.activator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import net.minecraft.world.level.block.Block;
import net.minecraft.block.IBlockEntityProvider;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.phys.AABB;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Vec3i;
import net.minecraft.world.level.Level;
import xol.lostinfinity.block.activator.BlockChromaTile;
import xol.lostinfinity.block.basic.BlockBasic;
import xol.lostinfinity.block.tileentity.BlockEntityChromaGame;
import xol.lostinfinity.init.BlockInit;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.init.SoundInit;

public class BlockChromaGame
extends BlockBasic
implements IBlockEntityProvider {
    public BlockChromaGame(String name) {
        super(name);
    }

    private boolean validInput(ItemStack stack) {
        return stack.func_77973_b().equals(ItemInit.frostedLog);
    }

    public boolean func_180639_a(Level worldIn, BlockPos pos, BlockState state, Player playerIn, InteractionHand hand, Direction facing, float hitX, float hitY, float hitZ) {
        if (!playerIn.func_70093_af()) {
            if (this.validInput(playerIn.func_184586_b(hand))) {
                double dist;
                double closest = 99999.0;
                double nextClosest = 99999.1;
                double radius = 10.0;
                AABB checkBox = new AABB(pos.func_177963_a(-radius, -radius, -radius), pos.func_177963_a(radius, radius, radius));
                List players = worldIn.func_72872_a(Player.class, checkBox);
                Player first = null;
                Player second = null;
                for (Player player : players) {
                    dist = player.func_174818_b(pos);
                    if (!(player.func_174818_b(pos) < closest)) continue;
                    first = player;
                    closest = dist;
                }
                players.remove(first);
                for (Player player : players) {
                    dist = player.func_174818_b(pos);
                    if (!(player.func_174818_b(pos) < nextClosest)) continue;
                    second = player;
                    nextClosest = dist;
                }
                if (first != null && second != null) {
                    if (!worldIn.field_72995_K) {
                        this.setPlayers(worldIn, pos, first, second);
                        this.reset(pos, worldIn, playerIn, hand, facing, hitX, hitY, hitZ);
                    }
                    playerIn.func_184586_b(hand).func_190918_g(1);
                }
            } else if (!worldIn.field_72995_K) {
                BlockPos ref = pos.func_177982_a(0, 0, 0);
                Vec3i dir = BlockChromaGame.findTileDir(worldIn, ref);
                int xDir = dir.func_177958_n();
                int zDir = dir.func_177952_p();
                int dimension = 6;
                ref = ref.func_177971_a(dir);
                boolean flag = true;
                block2: for (int i = 0; i < dimension; ++i) {
                    for (int j = 0; j < dimension; ++j) {
                        BlockPos tile = ref.func_177982_a(xDir * i, 0, zDir * j);
                        if (worldIn.func_180495_p(tile).equals(BlockInit.chromaTile.func_176203_a(3))) continue;
                        flag = false;
                        continue block2;
                    }
                }
                if (flag) {
                    ItemStack mapstack = new ItemStack(ItemInit.resolveMap);
                    mapstack.func_77982_d(new CompoundTag());
                    mapstack.func_77978_p().func_74768_a("MapEntityType", worldIn.field_73012_v.nextInt(8));
                    mapstack.func_77978_p().func_74768_a("MapEntityNum", 2 + worldIn.field_73012_v.nextInt(4));
                    ItemEntity geoloc = new ItemEntity(worldIn, playerIn.field_70165_t, playerIn.field_70163_u, playerIn.field_70161_v, mapstack);
                    geoloc.field_70159_w = 0.0;
                    geoloc.field_70181_x = 0.0;
                    geoloc.field_70179_y = 0.0;
                    worldIn.func_72838_d((Entity)geoloc);
                    this.reset(pos, worldIn, playerIn, hand, facing, hitX, hitY, hitZ);
                    this.setPlayers(worldIn, pos, null, null);
                    worldIn.func_184133_a(null, pos, SoundInit.MACHINE_CRAFT, SoundSource.MASTER, 1.0f, 1.0f);
                }
            }
        }
        return true;
    }

    private void setPlayers(Level worldIn, BlockPos pos, Player first, Player second) {
        if (worldIn.func_175625_s(pos) != null && worldIn.func_175625_s(pos) instanceof BlockEntityChromaGame) {
            BlockEntityChromaGame tileentity = (BlockEntityChromaGame)worldIn.func_175625_s(pos);
            tileentity.setPlayers(first, second);
        }
    }

    private Player getRandomPlayer(Level worldIn, BlockPos pos) {
        if (worldIn.func_175625_s(pos) != null && worldIn.func_175625_s(pos) instanceof BlockEntityChromaGame) {
            BlockEntityChromaGame tileentity = (BlockEntityChromaGame)worldIn.func_175625_s(pos);
            boolean rand = worldIn.field_73012_v.nextBoolean();
            if (rand) {
                return tileentity.getFirst();
            }
            return tileentity.getSecond();
        }
        return null;
    }

    private void reset(BlockPos pos, Level worldIn, Player playerIn, InteractionHand hand, Direction facing, float hitX, float hitY, float hitZ) {
        BlockPos ref = pos.func_177982_a(0, 0, 0);
        Vec3i dir = BlockChromaGame.findTileDir(worldIn, ref);
        int xDir = dir.func_177958_n();
        int zDir = dir.func_177952_p();
        int iterations = 40;
        int count = 0;
        BlockPos temp = ref = ref.func_177971_a(dir);
        while (worldIn.func_180495_p(temp).func_177230_c().equals(BlockInit.chromaTile)) {
            temp = ref.func_177982_a(xDir * ++count, 0, 0);
        }
        ArrayList<BlockPos> tiles = new ArrayList<BlockPos>();
        for (int i = 0; i < count; ++i) {
            for (int j = 0; j < count; ++j) {
                BlockPos tile = ref.func_177982_a(xDir * i, 0, zDir * j);
                if (!worldIn.func_180495_p(tile).func_177230_c().equals(BlockInit.chromaTile)) continue;
                tiles.add(tile);
                worldIn.func_175656_a(tile, BlockInit.chromaTile.func_176203_a(3));
            }
        }
        Random rand = new Random();
        for (int k = 0; k < iterations; ++k) {
            Player presser;
            int index = rand.nextInt(tiles.size());
            BlockState tileState = worldIn.func_180495_p((BlockPos)tiles.get(index));
            Block tileBlock = tileState.func_177230_c();
            if (!(tileBlock instanceof BlockChromaTile) || (presser = this.getRandomPlayer(worldIn, pos)) == null) continue;
            ((BlockChromaTile)tileBlock).func_180639_a(worldIn, (BlockPos)tiles.get(index), tileState, presser, hand, facing, hitX, hitY, hitZ);
        }
    }

    private static Vec3i findTileDir(Level worldIn, BlockPos pos) {
        ArrayList<Vec3i> dirs = new ArrayList<Vec3i>();
        dirs.add(new Vec3i(1, 0, 1));
        dirs.add(new Vec3i(-1, 0, 1));
        dirs.add(new Vec3i(-1, 0, -1));
        dirs.add(new Vec3i(1, 0, -1));
        for (Vec3i dir : dirs) {
            if (!worldIn.func_180495_p(pos.func_177971_a(dir)).func_177230_c().equals(BlockInit.chromaTile)) continue;
            return dir;
        }
        return null;
    }

    public BlockEntity func_149915_a(Level worldIn, int meta) {
        return null;
    }

    public boolean func_149716_u() {
        return true;
    }

    public BlockEntity createBlockEntity(Level world, BlockState state) {
        return new BlockEntityChromaGame();
    }
}

