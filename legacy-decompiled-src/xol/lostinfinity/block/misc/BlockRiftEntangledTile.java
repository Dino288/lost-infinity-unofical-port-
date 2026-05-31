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
 *  net.minecraft.init.SoundEvents
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.Direction
 *  net.minecraft.util.InteractionHand
 *  net.minecraft.util.SoundSource
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Vec3i
 *  net.minecraft.util.text.Component
 *  net.minecraft.util.text.Component
 *  net.minecraft.world.DimensionType
 *  net.minecraft.world.World
 *  net.minecraft.world.ServerLevel
 */
package xol.lostinfinity.block.misc;

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
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundSource;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Vec3i;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Component;
import net.minecraft.world.DimensionType;
import net.minecraft.world.level.Level;
import net.minecraft.server.level.ServerLevel;
import xol.lostinfinity.block.basic.BlockBasic;
import xol.lostinfinity.block.basic.ISpecialMurkMeta;
import xol.lostinfinity.init.DimensionInit;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.init.SoundInit;

public class BlockRiftEntangledTile
extends BlockBasic
implements ISpecialMurkMeta {
    public static final IntegerProperty AMOUNT = IntegerProperty.func_177719_a((String)"amount", (int)0, (int)15);

    public BlockRiftEntangledTile(String name) {
        super(name);
    }

    public boolean func_180639_a(Level worldIn, BlockPos pos, BlockState state, Player playerIn, InteractionHand hand, Direction facing, float hitX, float hitY, float hitZ) {
        if (!worldIn.field_72995_K && playerIn.func_184586_b(hand).func_77973_b().equals(ItemInit.powerAnalyzer)) {
            if (worldIn.field_73011_w.func_186058_p() == DimensionInit.infiniteMurk) {
                int radius = 5;
                BlockPos zeroPos = null;
                block0: for (int i = -radius; i <= radius; ++i) {
                    for (int j = -radius; j <= radius; ++j) {
                        BlockPos check = pos.func_177982_a(i, 0, j);
                        BlockState checkState = worldIn.func_180495_p(check);
                        if (!(checkState.func_177230_c() instanceof BlockRiftEntangledTile) || this.func_176201_c(checkState) != 0) continue;
                        zeroPos = check;
                        break block0;
                    }
                }
                if (zeroPos != null) {
                    ArrayList<Vec3i> positions = new ArrayList<Vec3i>();
                    positions.add(new Vec3i(0, 0, 1));
                    positions.add(new Vec3i(0, 0, -1));
                    positions.add(new Vec3i(1, 0, 0));
                    positions.add(new Vec3i(-1, 0, 0));
                    Vec3i dirRight = null;
                    Vec3i dirDown = null;
                    for (Vec3i position : positions) {
                        BlockState checkState = worldIn.func_180495_p(zeroPos.func_177971_a(position));
                        if (!(checkState.func_177230_c() instanceof BlockRiftEntangledTile)) continue;
                        if (this.func_176201_c(checkState) == 1 && dirRight == null) {
                            dirRight = position;
                        }
                        if (this.func_176201_c(checkState) != 4 || dirDown != null) continue;
                        dirDown = position;
                    }
                    boolean complete = true;
                    int meta = 0;
                    ArrayList<BlockPos> tiles = new ArrayList<BlockPos>();
                    block3: for (int i = 0; i < 4; ++i) {
                        for (int j = 0; j < 4; ++j) {
                            BlockPos check = zeroPos.func_177982_a(dirRight.func_177958_n() * j + dirDown.func_177958_n() * i, 0, dirRight.func_177952_p() * j + dirDown.func_177952_p() * i);
                            BlockState checkState = worldIn.func_180495_p(check);
                            if (checkState.func_177230_c() instanceof BlockRiftEntangledTile) {
                                if (this.func_176201_c(checkState) != meta) {
                                    complete = false;
                                    break block3;
                                }
                            } else {
                                complete = false;
                                break block3;
                            }
                            tiles.add(check);
                            ++meta;
                        }
                    }
                    if (complete) {
                        worldIn.func_184133_a(null, pos, SoundInit.MACHINE_CRAFT, SoundSource.BLOCKS, 1.0f, 1.0f);
                        ItemEntity item = new ItemEntity(worldIn, (double)pos.func_177958_n(), (double)(pos.func_177956_o() + 2), (double)pos.func_177952_p(), new ItemStack(ItemInit.alignedDisc));
                        item.field_70159_w = 0.0;
                        item.field_70181_x = 0.0;
                        item.field_70179_y = 0.0;
                        worldIn.func_72838_d((Entity)item);
                        for (BlockPos tilePos : tiles) {
                            worldIn.func_175698_g(tilePos);
                            ServerLevel overworld = worldIn.func_73046_m().func_71218_a(0);
                            overworld.func_175698_g(tilePos);
                        }
                    }
                }
            } else if (worldIn.field_73011_w.func_186058_p() == DimensionType.OVERWORLD) {
                int meta = this.func_176201_c(state);
                meta = meta < 15 ? ++meta : 0;
                playerIn.func_145747_a((Component)new Component(String.format("This block is showing: Tile %d", meta)));
                worldIn.func_175656_a(pos, this.func_176203_a(meta));
                worldIn.func_184133_a(null, pos, SoundEvents.field_187750_dc, SoundSource.BLOCKS, 1.0f, 1.0f);
            }
        }
        return true;
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

    public BlockState getStateWithAmount(int amount) {
        return this.func_176223_P().func_177226_a((Property)AMOUNT, (Comparable)Integer.valueOf(amount));
    }

    @Override
    public int getMurkMeta(BlockState state) {
        int meta = this.func_176201_c(state);
        switch (meta) {
            case 0: {
                return 13;
            }
            case 1: {
                return 6;
            }
            case 2: {
                return 11;
            }
            case 3: {
                return 15;
            }
            case 4: {
                return 5;
            }
            case 5: {
                return 0;
            }
            case 6: {
                return 3;
            }
            case 7: {
                return 12;
            }
            case 8: {
                return 1;
            }
            case 9: {
                return 7;
            }
            case 10: {
                return 14;
            }
            case 11: {
                return 2;
            }
            case 12: {
                return 8;
            }
            case 13: {
                return 4;
            }
            case 14: {
                return 9;
            }
            case 15: {
                return 10;
            }
        }
        return 0;
    }
}

