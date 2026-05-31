/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.block.properties.Property
 *  net.minecraft.block.properties.IntegerProperty
 *  net.minecraft.block.state.StateDefinition
 *  net.minecraft.block.state.BlockState
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.item.ItemEntity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.item.ItemStack
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.util.Direction
 *  net.minecraft.util.InteractionHand
 *  net.minecraft.util.SoundSource
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Vec3i
 *  net.minecraft.world.World
 *  net.minecraft.world.chunk.Chunk
 */
package xol.lostinfinity.block.activator;

import java.util.ArrayList;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundSource;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Vec3i;
import net.minecraft.world.level.Level;
import net.minecraft.world.chunk.Chunk;
import xol.lostinfinity.block.basic.BlockBasic;
import xol.lostinfinity.init.BlockInit;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.init.SoundInit;

public class BlockTimelineStabilizerArrow
extends BlockBasic {
    public static final IntegerProperty AMOUNT = IntegerProperty.func_177719_a((String)"amount", (int)0, (int)3);

    public BlockTimelineStabilizerArrow(String name) {
        super(name);
    }

    public static Vec3i getRotatedVec(Vec3i vec, double rad) {
        return new Vec3i((double)(Math.round((double)vec.func_177958_n() * Math.cos(rad)) + Math.round((double)vec.func_177952_p() * Math.sin(rad))), (double)vec.func_177956_o(), (double)(Math.round((double)(-vec.func_177958_n()) * Math.sin(rad)) + Math.round((double)vec.func_177952_p() * Math.cos(rad))));
    }

    public boolean func_180639_a(Level worldIn, BlockPos pos, BlockState state, Player playerIn, InteractionHand hand, Direction facing, float hitX, float hitY, float hitZ) {
        ItemStack stack = playerIn.func_184586_b(hand);
        if (!worldIn.field_72995_K && playerIn.func_70093_af()) {
            int meta = this.func_176201_c(state);
            if (meta < 3) {
                worldIn.func_175656_a(pos, this.func_176203_a(meta + 1));
            } else {
                worldIn.func_175656_a(pos, this.func_176203_a(0));
            }
        } else if (!worldIn.field_72995_K) {
            int width = 29;
            int height = 16;
            CompoundTag compound = stack.func_77978_p();
            if (!stack.func_77942_o()) {
                return true;
            }
            if (compound.func_74764_b("1x") && compound.func_74764_b("2x")) {
                ArrayList<BlockPos> pillars = new ArrayList<BlockPos>();
                Vec3i offset = new Vec3i(0, 3, 0);
                pillars.add(new BlockPos(compound.func_74762_e("1x") + offset.func_177958_n(), compound.func_74762_e("1y") + offset.func_177956_o(), compound.func_74762_e("1z") + offset.func_177952_p()));
                pillars.add(new BlockPos(compound.func_74762_e("2x") + offset.func_177958_n(), compound.func_74762_e("2y") + offset.func_177956_o(), compound.func_74762_e("2z") + offset.func_177952_p()));
                double rad = 0.0;
                double closestDist = 999999.0;
                BlockPos closest = null;
                for (BlockPos pillar : pillars) {
                    double dist = pillar.func_185332_f(pos.func_177958_n(), pos.func_177956_o(), pos.func_177952_p());
                    if (!(dist < closestDist)) continue;
                    closestDist = dist;
                    closest = pillar;
                }
                if (closest != null) {
                    int radius = 40;
                    for (int i = -radius; i < radius; ++i) {
                        for (int j = -radius; j < radius; ++j) {
                            for (int k = -radius; k < radius; ++k) {
                                boolean onFront;
                                BlockPos check = pos.func_177982_a(i, j, k);
                                if (!worldIn.func_180495_p(check).func_177230_c().equals(BlockInit.timelineStabilizerCapsule)) continue;
                                int pillarNum = pillars.indexOf(closest);
                                BlockPos ref = (BlockPos)pillars.get(pillarNum);
                                int xDir = 1;
                                int zDir = 1;
                                if (worldIn.func_180495_p(ref.func_177982_a(-1, 0, 0)).func_177230_c().equals(BlockInit.labyrinthGlassBlue)) {
                                    xDir = -1;
                                }
                                if (worldIn.func_180495_p(ref.func_177982_a(0, 0, -1)).func_177230_c().equals(BlockInit.labyrinthGlassBlue)) {
                                    zDir = -1;
                                }
                                rad = xDir == 1 ? (zDir == 1 ? 0.0 : 1.5707963267948966) : (zDir == 1 ? 4.71238898038469 : Math.PI);
                                ref = ref.func_177982_a(xDir, 0, zDir);
                                int meta = this.func_176201_c(state);
                                int xDiff = check.func_177958_n() - closest.func_177958_n() - 1 * xDir;
                                int zDiff = check.func_177952_p() - closest.func_177952_p() - 1 * zDir;
                                Vec3i cornerDir = null;
                                boolean byRight = xDiff == 0;
                                boolean byLeft = xDiff == width / 4;
                                boolean byFront = zDiff == 0;
                                boolean byBack = zDiff == width / 4;
                                boolean onRight = xDiff == -1;
                                boolean onLeft = xDiff == width / 4 + 1;
                                boolean onBack = zDiff == width / 4 + 1;
                                boolean bl = onFront = zDiff == -1;
                                if (rad == 0.0) {
                                    byRight = xDiff == 0;
                                    byLeft = xDiff == width / 4;
                                    byFront = zDiff == 0;
                                    byBack = zDiff == width / 4;
                                    onRight = xDiff == -1;
                                    onLeft = xDiff == width / 4 + 1;
                                    onBack = zDiff == width / 4 + 1;
                                    onFront = zDiff == -1;
                                } else if (rad == 1.5707963267948966) {
                                    byRight = zDiff == 0;
                                    byLeft = zDiff == -(width / 4);
                                    byBack = xDiff == width / 4;
                                    byFront = xDiff == 0;
                                    onRight = zDiff == 1;
                                    onLeft = zDiff == -(width / 4) - 1;
                                    onFront = xDiff == -1;
                                    onBack = xDiff == width / 4 + 1;
                                } else if (rad == Math.PI) {
                                    byLeft = xDiff == -width / 4;
                                    byRight = xDiff == 0;
                                    byBack = zDiff == -(width / 4);
                                    byFront = zDiff == 0;
                                    onLeft = xDiff == -width / 4 - 1;
                                    onRight = xDiff == 1;
                                    onFront = zDiff == 1;
                                    onBack = zDiff == -(width / 4) - 1;
                                } else if (rad == 4.71238898038469) {
                                    byLeft = zDiff == width / 4;
                                    byRight = zDiff == 0;
                                    byFront = xDiff == 0;
                                    byBack = xDiff == -(width / 4);
                                    onLeft = zDiff == width / 4 + 1;
                                    onRight = zDiff == -1;
                                    onBack = xDiff == -(width / 4) - 1;
                                    onFront = xDiff == 1;
                                }
                                Vec3i dir = new Vec3i(0, 0, 0);
                                switch (meta) {
                                    case 0: {
                                        if (byFront && !byRight) {
                                            dir = new Vec3i(-1, 0, 0);
                                            break;
                                        }
                                        if (byRight && !byBack) {
                                            dir = new Vec3i(0, 0, 1);
                                            break;
                                        }
                                        if (byBack && !byLeft) {
                                            dir = new Vec3i(1, 0, 0);
                                            break;
                                        }
                                        if (!byLeft || byFront) break;
                                        dir = new Vec3i(0, 0, -1);
                                        break;
                                    }
                                    case 1: {
                                        dir = new Vec3i(0, 1, 0);
                                        break;
                                    }
                                    case 2: {
                                        if (byFront && !byLeft) {
                                            dir = new Vec3i(1, 0, 0);
                                            break;
                                        }
                                        if (byRight && !byFront) {
                                            dir = new Vec3i(0, 0, -1);
                                            break;
                                        }
                                        if (byBack && !byRight) {
                                            dir = new Vec3i(-1, 0, 0);
                                            break;
                                        }
                                        if (!byLeft || byBack) break;
                                        dir = new Vec3i(0, 0, 1);
                                        break;
                                    }
                                    case 3: {
                                        dir = new Vec3i(0, -1, 0);
                                    }
                                }
                                dir = BlockTimelineStabilizerArrow.getRotatedVec(dir, rad);
                                int relativeY = check.func_177973_b((Vec3i)closest).func_177956_o();
                                if (relativeY >= 11) {
                                    return true;
                                }
                                if (cornerDir != null) {
                                    cornerDir = BlockTimelineStabilizerArrow.getRotatedVec(cornerDir, rad);
                                }
                                if (worldIn.func_180495_p(check.func_177971_a(dir)).func_177230_c().equals(BlockInit.timelineStabilizerGoal)) {
                                    if (pillarNum == 0) {
                                        BlockPos next;
                                        BlockPos nextRef = next = (BlockPos)pillars.get(pillarNum + 1);
                                        int nextXDir = 1;
                                        int nextZDir = 1;
                                        if (worldIn.func_180495_p(nextRef.func_177982_a(-1, 0, 0)).func_177230_c().equals(BlockInit.labyrinthGlassBlue)) {
                                            nextXDir = -1;
                                        }
                                        if (worldIn.func_180495_p(nextRef.func_177982_a(0, 0, -1)).func_177230_c().equals(BlockInit.labyrinthGlassBlue)) {
                                            nextZDir = -1;
                                        }
                                        rad = nextXDir == 1 ? (nextZDir == 1 ? 0.0 : 1.5707963267948966) : (nextZDir == 1 ? 4.71238898038469 : Math.PI);
                                        nextRef = nextRef.func_177982_a(nextXDir * 1, -4, nextZDir * 1);
                                        worldIn.func_175698_g(check);
                                        worldIn.func_175656_a(nextRef, BlockInit.timelineStabilizerCapsule.func_176223_P());
                                        worldIn.func_184133_a(null, playerIn.func_180425_c(), SoundInit.MYSTERY_VOICE_TRANSMISSION, SoundSource.BLOCKS, 1.5f, 1.0f);
                                    } else {
                                        worldIn.func_175698_g(check);
                                        this.win(check.func_177971_a(dir), worldIn, playerIn);
                                    }
                                    return true;
                                }
                                if (!worldIn.func_175623_d(check.func_177971_a(dir)) && (cornerDir == null || !worldIn.func_175623_d(check.func_177971_a(cornerDir))) || !worldIn.func_175623_d(check.func_177971_a(dir))) continue;
                                worldIn.func_175656_a(check.func_177971_a(dir), BlockInit.timelineStabilizerCapsule.func_176223_P());
                                worldIn.func_175698_g(check);
                                worldIn.func_184133_a(null, playerIn.func_180425_c(), SoundInit.GEAR_MACHINE_2, SoundSource.BLOCKS, 1.5f, 0.8f + worldIn.field_73012_v.nextFloat() * 0.4f);
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }

    private void win(BlockPos pos, Level worldIn, Player playerIn) {
        ItemEntity reward = new ItemEntity(worldIn, playerIn.field_70165_t, playerIn.field_70163_u, playerIn.field_70161_v, new ItemStack(ItemInit.multiTimelineDataChip));
        reward.field_70159_w = 0.0;
        reward.field_70181_x = 0.0;
        reward.field_70179_y = 0.0;
        worldIn.func_72838_d((Entity)reward);
        worldIn.func_184133_a(null, playerIn.func_180425_c(), SoundInit.MYSTERY_VOICE_TRANSMISSION, SoundSource.BLOCKS, 1.5f, 1.0f);
    }

    private boolean onTrack(BlockPos check, Chunk chunk) {
        ArrayList<Vec3i> positions = new ArrayList<Vec3i>();
        positions.add(new Vec3i(1, 0, 0));
        positions.add(new Vec3i(-1, 0, 0));
        positions.add(new Vec3i(0, 0, 1));
        positions.add(new Vec3i(0, 0, -1));
        for (Vec3i pos : positions) {
            if (!chunk.func_177435_g(check.func_177971_a(pos)).func_177230_c().equals(BlockInit.trackWall)) continue;
            return true;
        }
        return false;
    }

    private void transfer(Level worldIn, BlockPos pos) {
    }

    private boolean onTrack(BlockPos check, Level worldIn) {
        ArrayList<Vec3i> positions = new ArrayList<Vec3i>();
        positions.add(new Vec3i(1, 0, 0));
        positions.add(new Vec3i(-1, 0, 0));
        positions.add(new Vec3i(0, 0, 1));
        positions.add(new Vec3i(0, 0, -1));
        for (Vec3i pos : positions) {
            if (!worldIn.func_180495_p(check.func_177971_a(pos)).func_177230_c().equals(BlockInit.trackWall)) continue;
            return true;
        }
        return false;
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

