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
 *  net.minecraft.util.Direction
 *  net.minecraft.util.InteractionHand
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.text.Component
 *  net.minecraft.util.text.Component
 *  net.minecraft.world.World
 */
package xol.lostinfinity.block.activator;

import java.util.Random;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.Level;
import xol.lostinfinity.block.basic.BlockBasic;
import xol.lostinfinity.init.ItemInit;

public class BlockMonomerDeposit
extends BlockBasic {
    public static final IntegerProperty AMOUNT = IntegerProperty.func_177719_a((String)"amount", (int)0, (int)5);

    public BlockMonomerDeposit(String name) {
        super(name);
        this.func_149675_a(true);
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
        ItemStack held = playerIn.func_184586_b(hand);
        if (playerIn.func_70093_af() && !worldIn.field_72995_K) {
            int meta = this.func_176201_c(state);
            if (meta < 5) {
                worldIn.func_175656_a(pos, this.func_176203_a(meta + 1));
            } else {
                worldIn.func_175656_a(pos, this.func_176203_a(0));
            }
        }
        if (held.func_77973_b().equals(ItemInit.monomerCollector) && held.func_77942_o() && !worldIn.field_72995_K) {
            long endTime = held.func_77978_p().func_74763_f("EndTime");
            if (endTime > System.currentTimeMillis()) {
                int amount = worldIn.field_73012_v.nextInt(4) + 2;
                int meta = this.func_176201_c(state);
                if (meta != 0) {
                    switch (meta) {
                        case 1: {
                            playerIn.func_191521_c(new ItemStack(ItemInit.purpleMonomerSample, amount));
                            break;
                        }
                        case 2: {
                            playerIn.func_191521_c(new ItemStack(ItemInit.blueMonomerSample, amount));
                            break;
                        }
                        case 3: {
                            playerIn.func_191521_c(new ItemStack(ItemInit.redMonomerSample, amount));
                            break;
                        }
                        case 4: {
                            playerIn.func_191521_c(new ItemStack(ItemInit.yellowMonomerSample, amount));
                            break;
                        }
                        case 5: {
                            playerIn.func_191521_c(new ItemStack(ItemInit.greenMonomerSample, amount));
                        }
                    }
                    worldIn.func_175656_a(pos, this.func_176203_a(0));
                }
            } else {
                playerIn.func_145747_a((Component)new Component("You have taken too long to collect the monomers, the collector has been diminished"));
            }
        }
        return true;
    }

    public void func_180650_b(Level world, BlockPos pos, BlockState state, Random rand) {
        int meta;
        if (!world.field_72995_K && (meta = this.func_176201_c(state)) == 0) {
            int randMeta = world.field_73012_v.nextInt(5) + 1;
            world.func_175656_a(pos, this.func_176203_a(randMeta));
        }
    }
}

