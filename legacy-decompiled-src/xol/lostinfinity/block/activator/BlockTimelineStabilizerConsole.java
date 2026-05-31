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
 *  net.minecraft.item.ItemStack
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.util.Direction
 *  net.minecraft.util.InteractionHand
 *  net.minecraft.util.SoundSource
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Vec3i
 *  net.minecraft.util.text.Component
 *  net.minecraft.util.text.Component
 *  net.minecraft.world.World
 *  net.minecraft.world.ServerLevel
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
import net.minecraft.world.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundSource;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Vec3i;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.Level;
import net.minecraft.server.level.ServerLevel;
import xol.lostinfinity.block.basic.BlockBasic;
import xol.lostinfinity.dimension.data.MazeMap;
import xol.lostinfinity.dimension.data.MazeNode;
import xol.lostinfinity.init.BlockInit;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.init.SoundInit;

public class BlockTimelineStabilizerConsole
extends BlockBasic {
    public static final IntegerProperty AMOUNT = IntegerProperty.func_177719_a((String)"amount", (int)0, (int)1);

    public BlockTimelineStabilizerConsole(String name) {
        super(name);
    }

    public boolean func_180639_a(Level worldIn, BlockPos pos, BlockState state, Player playerIn, InteractionHand hand, Direction facing, float hitX, float hitY, float hitZ) {
        if (!worldIn.field_72995_K && !playerIn.func_70093_af()) {
            int meta = this.func_176201_c(state);
            ItemStack stack = playerIn.func_184586_b(hand);
            if (stack.func_77973_b().equals(ItemInit.timelineMonitor)) {
                if (!stack.func_77942_o()) {
                    stack.func_77982_d(new CompoundTag());
                }
                CompoundTag compound = stack.func_77978_p();
                switch (meta) {
                    case 0: {
                        if (compound.func_74764_b("1x") && compound.func_74764_b("2x")) {
                            this.generateMaze(stack, worldIn);
                            worldIn.func_184133_a(null, playerIn.func_180425_c(), SoundInit.MANUFACTURE_MACHINE, SoundSource.BLOCKS, 1.5f, 1.0f);
                            break;
                        }
                        compound.func_74768_a("1x", pos.func_177958_n());
                        compound.func_74768_a("1y", pos.func_177956_o());
                        compound.func_74768_a("1z", pos.func_177952_p());
                        playerIn.func_145747_a((Component)new Component("Marked 1st Console"));
                        break;
                    }
                    case 1: {
                        compound.func_74768_a("2x", pos.func_177958_n());
                        compound.func_74768_a("2y", pos.func_177956_o());
                        compound.func_74768_a("2z", pos.func_177952_p());
                        playerIn.func_145747_a((Component)new Component("Marked 2nd Console"));
                    }
                }
            }
        } else if (!worldIn.field_72995_K) {
            int meta = this.func_176201_c(state);
            if (meta < 1) {
                worldIn.func_175656_a(pos, this.func_176203_a(meta + 1));
            } else {
                worldIn.func_175656_a(pos, this.func_176203_a(0));
            }
        }
        return true;
    }

    public static Vec3i getRotatedVec(Vec3i vec, double rad) {
        return new Vec3i((double)(Math.round((double)vec.func_177958_n() * Math.cos(rad)) + Math.round((double)vec.func_177952_p() * Math.sin(rad))), (double)vec.func_177956_o(), (double)(Math.round((double)(-vec.func_177958_n()) * Math.sin(rad)) + Math.round((double)vec.func_177952_p() * Math.cos(rad))));
    }

    private void generateMaze(ItemStack stack, Level worldIn) {
        int width = 29;
        int height = 16;
        MazeMap map1 = new MazeMap(width, height);
        MazeMap map2 = new MazeMap(width, height);
        CompoundTag compound = stack.func_77978_p();
        ArrayList<BlockPos> pillars = new ArrayList<BlockPos>();
        double rad = 0.0;
        Vec3i offset = new Vec3i(0, 3, 0);
        pillars.add(new BlockPos(compound.func_74762_e("1x") + offset.func_177958_n(), compound.func_74762_e("1y") + offset.func_177956_o(), compound.func_74762_e("1z") + offset.func_177952_p()));
        pillars.add(new BlockPos(compound.func_74762_e("2x") + offset.func_177958_n(), compound.func_74762_e("2y") + offset.func_177956_o(), compound.func_74762_e("2z") + offset.func_177952_p()));
        ServerLevel overworld = worldIn.func_73046_m().func_71218_a(0);
        for (int i = 0; i < 2; ++i) {
            for (int h = 0; h < 4; ++h) {
                for (int j = 0; j < width / 4; ++j) {
                    for (int k = 0; k < height; ++k) {
                        BlockPos ref = (BlockPos)pillars.get(i);
                        int xDir = 1;
                        int zDir = 1;
                        if (worldIn.func_180495_p(ref.func_177982_a(-1, 0, 0)).func_177230_c().equals(BlockInit.labyrinthGlassBlue)) {
                            xDir = -1;
                        }
                        if (worldIn.func_180495_p(ref.func_177982_a(0, 0, -1)).func_177230_c().equals(BlockInit.labyrinthGlassBlue)) {
                            zDir = -1;
                        }
                        rad = xDir == 1 ? (zDir == 1 ? 0.0 : 1.5707963267948966) : (zDir == 1 ? 4.71238898038469 : Math.PI);
                        ref = ref.func_177982_a(xDir * 1, -4, zDir * 1);
                        Vec3i front = new Vec3i(0, 0, -1);
                        front = BlockTimelineStabilizerConsole.getRotatedVec(front, rad);
                        Vec3i dir = new Vec3i(1, 0, 0);
                        Vec3i refOffset = new Vec3i(0, 0, 0);
                        switch (h) {
                            case 0: {
                                break;
                            }
                            case 1: {
                                refOffset = new Vec3i(width / 4, 0, 0);
                                dir = new Vec3i(0, 0, 1);
                                break;
                            }
                            case 2: {
                                refOffset = new Vec3i(width / 4, 0, width / 4);
                                dir = new Vec3i(-1, 0, 0);
                                break;
                            }
                            case 3: {
                                refOffset = new Vec3i(0, 0, width / 4);
                                dir = new Vec3i(0, 0, -1);
                            }
                        }
                        refOffset = BlockTimelineStabilizerConsole.getRotatedVec(refOffset, rad);
                        ref = ref.func_177971_a(refOffset);
                        dir = BlockTimelineStabilizerConsole.getRotatedVec(dir, rad);
                        ref = ref.func_177982_a(dir.func_177958_n() * j, k, dir.func_177952_p() * j);
                        MazeNode mazeNode = i == 0 ? map1.getNodeAtLocation(j + h * (width / 4), k) : map2.getNodeAtLocation(j + h * (width / 4), k);
                        worldIn.func_175656_a(ref, BlockInit.trackWall.func_176223_P());
                        if ((mazeNode.getType().equals("path") || mazeNode.getType().equals("trigger")) && mazeNode.isVisited()) {
                            worldIn.func_175698_g(ref);
                        }
                        if (i == 0 && j == 0 && h == 0 && k == 0) {
                            worldIn.func_175656_a(ref, BlockInit.timelineStabilizerCapsule.func_176223_P());
                            continue;
                        }
                        if (h != 0 || j != 0 || k != height - 1) continue;
                        worldIn.func_175656_a(ref, BlockInit.timelineStabilizerGoal.func_176223_P());
                    }
                }
            }
        }
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

