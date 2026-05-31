/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.state.BlockState
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.item.ItemEntity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.util.InteractionResultHolder
 *  net.minecraft.util.InteractionHand
 *  net.minecraft.util.SoundSource
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.text.Component
 *  net.minecraft.util.text.Component
 *  net.minecraft.world.World
 */
package xol.lostinfinity.item.activate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundSource;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.Level;
import xol.lostinfinity.init.BlockInit;
import xol.lostinfinity.init.DimensionInit;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.init.TabsInit;
import xol.lostinfinity.item.basics.ItemBasic;

public class ItemFossilFinder
extends ItemBasic {
    public ItemFossilFinder(String regName) {
        super(regName, TabsInit.TAB_AUXMATS);
    }

    public InteractionResultHolder<ItemStack> func_77659_a(Level worldIn, Player playerIn, InteractionHand handIn) {
        block38: {
            ItemStack stack = playerIn.func_184586_b(handIn);
            if (!worldIn.field_72995_K && worldIn.field_73011_w.func_186058_p() == DimensionInit.shadowSea) {
                if (!stack.func_77942_o()) {
                    stack.func_77982_d(new CompoundTag());
                }
                int progress = stack.func_77978_p().func_74762_e("progress");
                if (!stack.func_77978_p().func_74764_b("trackLength")) {
                    if (stack.func_77978_p().func_74764_b("avoidX")) {
                        int avoidX = stack.func_77978_p().func_74762_e("avoidX");
                        int avoidZ = stack.func_77978_p().func_74762_e("avoidZ");
                        int xDiff = Math.abs((int)playerIn.field_70165_t - avoidX);
                        int zDiff = Math.abs((int)playerIn.field_70161_v - avoidZ);
                        if (xDiff < 20 || zDiff < 20) {
                            playerIn.func_145747_a((Component)new Component("Too close to last sample, find a new location!"));
                            return super.func_77659_a(worldIn, playerIn, handIn);
                        }
                    }
                    int randX = playerIn.func_180425_c().func_177958_n() + worldIn.field_73012_v.nextInt(15) + 18;
                    int randZ = playerIn.func_180425_c().func_177952_p() + worldIn.field_73012_v.nextInt(15) + 18;
                    int curX = playerIn.func_180425_c().func_177958_n();
                    int curZ = playerIn.func_180425_c().func_177952_p();
                    ArrayList<BlockPos> tracks = new ArrayList<BlockPos>();
                    BlockPos pos = new BlockPos(curX, worldIn.func_189649_b(curX, curZ), curZ);
                    while (!worldIn.func_175623_d(pos)) {
                        pos = pos.func_177984_a();
                    }
                    tracks.add(pos);
                    while (curX != randX || curZ != randZ) {
                        int zDiff = randZ - curZ;
                        int xDiff = randX - curX;
                        if (xDiff == 0) {
                            curZ = (int)((float)curZ + Math.signum(zDiff));
                        } else if (zDiff == 0) {
                            curX = (int)((float)curX + Math.signum(xDiff));
                        } else if (worldIn.field_73012_v.nextBoolean()) {
                            curZ = (int)((float)curZ + Math.signum(zDiff));
                        } else {
                            curX = (int)((float)curX + Math.signum(xDiff));
                        }
                        BlockPos trackPos = new BlockPos(curX, worldIn.func_189649_b(curX, curZ), curZ);
                        while (!worldIn.func_175623_d(trackPos)) {
                            trackPos = trackPos.func_177984_a();
                        }
                        tracks.add(trackPos);
                    }
                    worldIn.func_184133_a(null, playerIn.func_180425_c(), SoundInit.GENERIC_UI_1, SoundSource.PLAYERS, 1.0f, 0.7f + worldIn.field_73012_v.nextFloat() * 0.6f);
                    worldIn.func_175656_a(pos, BlockInit.fossilTrack.func_176223_P());
                    stack.func_77978_p().func_74768_a("trackLength", tracks.size());
                    playerIn.func_145747_a((Component)new Component("Discovered fossil evidence, follow the trail!"));
                    for (int i = 0; i < tracks.size(); ++i) {
                        stack.func_77978_p().func_74768_a("track" + i + "X", ((BlockPos)tracks.get(i)).func_177958_n());
                        stack.func_77978_p().func_74768_a("track" + i + "Y", ((BlockPos)tracks.get(i)).func_177956_o());
                        stack.func_77978_p().func_74768_a("track" + i + "Z", ((BlockPos)tracks.get(i)).func_177952_p());
                    }
                } else if (!stack.func_77978_p().func_74764_b("finalX")) {
                    int trackLength = stack.func_77978_p().func_74762_e("trackLength");
                    ArrayList<BlockPos> tracks = new ArrayList<BlockPos>();
                    for (int i = 0; i < trackLength; ++i) {
                        int x = stack.func_77978_p().func_74762_e("track" + i + "X");
                        int y = stack.func_77978_p().func_74762_e("track" + i + "Y");
                        int z = stack.func_77978_p().func_74762_e("track" + i + "Z");
                        tracks.add(new BlockPos(x, y, z));
                    }
                    ArrayList<BlockPos> nearPlayerPositions = new ArrayList<BlockPos>();
                    for (BlockPos nearPlayerPos : BlockPos.func_177980_a((BlockPos)playerIn.func_180425_c().func_177982_a(-2, 0, -2), (BlockPos)playerIn.func_180425_c().func_177982_a(2, 1, 2))) {
                        nearPlayerPositions.add(nearPlayerPos);
                    }
                    block6: for (BlockPos nearPos : nearPlayerPositions) {
                        for (BlockPos track : tracks) {
                            if (track.func_177958_n() != nearPos.func_177958_n() || track.func_177952_p() != nearPos.func_177952_p()) continue;
                            BlockState state = worldIn.func_180495_p(track);
                            if (state.func_177230_c() == BlockInit.fossilTrack) continue block6;
                            int lastRevealedIndex = 0;
                            for (int i = 0; i < tracks.size(); ++i) {
                                if (worldIn.func_180495_p((BlockPos)tracks.get(i)).func_177230_c() != BlockInit.fossilTrack) continue;
                                lastRevealedIndex = i;
                            }
                            int index = tracks.indexOf(track);
                            int numToReveal = 1;
                            if (index > lastRevealedIndex) {
                                int indDiff = index - lastRevealedIndex;
                                if (indDiff > 0) {
                                    worldIn.func_184133_a(null, playerIn.func_180425_c(), SoundInit.WATER_MUD, SoundSource.PLAYERS, 1.0f, 0.5f + worldIn.field_73012_v.nextFloat());
                                }
                                numToReveal = indDiff / 2 + 1;
                            }
                            int bound = index + numToReveal < tracks.size() ? index + numToReveal : tracks.size();
                            for (int i = 0; i < bound; ++i) {
                                worldIn.func_175656_a((BlockPos)tracks.get(i), BlockInit.fossilTrack.func_176223_P());
                            }
                            if (bound != tracks.size()) break block38;
                            playerIn.func_145747_a((Component)new Component("You have reached the end of the trail, search your surroundings for the fossil"));
                            int radius = 15;
                            ArrayList<BlockPos> positions = new ArrayList<BlockPos>();
                            for (BlockPos position : BlockPos.func_177980_a((BlockPos)playerIn.func_180425_c().func_177982_a(-radius, 0, -radius), (BlockPos)playerIn.func_180425_c().func_177982_a(radius, radius, radius))) {
                                positions.add(position);
                            }
                            Collections.shuffle(positions);
                            for (BlockPos pos : positions) {
                                if (worldIn.func_175623_d(pos) || !worldIn.func_175623_d(pos.func_177984_a())) continue;
                                stack.func_77978_p().func_74768_a("finalX", pos.func_177958_n());
                                stack.func_77978_p().func_74768_a("finalY", pos.func_177956_o());
                                stack.func_77978_p().func_74768_a("finalZ", pos.func_177952_p());
                                break block38;
                            }
                            break block38;
                        }
                    }
                } else if (stack.func_77978_p().func_74764_b("finalX")) {
                    int zDiff;
                    int yDiff;
                    int xDiff = Math.abs(playerIn.func_180425_c().func_177958_n() - stack.func_77978_p().func_74762_e("finalX"));
                    if (xDiff + (yDiff = Math.abs(playerIn.func_180425_c().func_177956_o() - stack.func_77978_p().func_74762_e("finalY"))) + (zDiff = Math.abs(playerIn.func_180425_c().func_177952_p() - stack.func_77978_p().func_74762_e("finalZ"))) < 3) {
                        stack.func_77978_p().func_82580_o("finalX");
                        stack.func_77978_p().func_82580_o("finalY");
                        stack.func_77978_p().func_82580_o("finalZ");
                        int trackLength = stack.func_77978_p().func_74762_e("trackLength");
                        for (int i = 0; i < trackLength; ++i) {
                            int x = stack.func_77978_p().func_74762_e("track" + i + "X");
                            int y = stack.func_77978_p().func_74762_e("track" + i + "Y");
                            int z = stack.func_77978_p().func_74762_e("track" + i + "Z");
                            worldIn.func_175698_g(new BlockPos(x, y, z));
                        }
                        stack.func_77982_d(new CompoundTag());
                        playerIn.func_145747_a((Component)new Component("Fossil found!"));
                        ItemEntity fossil = new ItemEntity(worldIn, playerIn.field_70165_t, playerIn.field_70163_u + 0.4, playerIn.field_70161_v, new ItemStack(this.randomFossil(worldIn.field_73012_v)));
                        fossil.field_70159_w = 0.0;
                        fossil.field_70181_x = 0.0;
                        fossil.field_70179_y = 0.0;
                        worldIn.func_72838_d((Entity)fossil);
                        worldIn.func_184133_a(null, playerIn.func_180425_c(), SoundInit.WATER_REVEAL, SoundSource.PLAYERS, 1.5f, 0.7f + worldIn.field_73012_v.nextFloat() * 0.6f);
                    } else if (xDiff + yDiff + zDiff < 7) {
                        playerIn.func_145747_a((Component)new Component("You are very close to the fossil!"));
                    } else if (xDiff + yDiff + zDiff < 15) {
                        playerIn.func_145747_a((Component)new Component("You are close to the fossil!"));
                    } else if (xDiff + yDiff + zDiff < 45) {
                        playerIn.func_145747_a((Component)new Component("The fossil is in this area, but you aren't that close!"));
                    } else {
                        playerIn.func_145747_a((Component)new Component("You are too far! Look in the area around the end of the track!"));
                    }
                }
            }
        }
        return super.func_77659_a(worldIn, playerIn, handIn);
    }

    private Item randomFossil(Random rand) {
        switch (rand.nextInt(6)) {
            case 0: {
                return ItemInit.fossilEelBotjaw;
            }
            case 1: {
                return ItemInit.fossilRibbedTail;
            }
            case 2: {
                return ItemInit.fossilEelTopjaw;
            }
            case 3: {
                return ItemInit.fossilSmallRibs;
            }
            case 4: {
                return ItemInit.fossilSmallRibs;
            }
            case 5: {
                return ItemInit.fossilRibbedTail;
            }
        }
        return ItemInit.fossilSmallRibs;
    }
}

