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
 *  net.minecraft.util.SoundSource
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.world.World
 */
package xol.lostinfinity.block.misc;

import java.util.Random;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundSource;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import xol.lostinfinity.block.basic.BlockBasic;
import xol.lostinfinity.init.SoundInit;

public class BlockSynchroniteSignal
extends BlockBasic {
    public static final IntegerProperty AMOUNT = IntegerProperty.func_177719_a((String)"amount", (int)0, (int)3);

    public BlockSynchroniteSignal(String name) {
        super(name);
        this.func_149675_a(true);
    }

    public int func_149738_a(Level worldIn) {
        return 3;
    }

    public boolean func_180639_a(Level worldIn, BlockPos pos, BlockState state, Player playerIn, InteractionHand hand, Direction facing, float hitX, float hitY, float hitZ) {
        if (!worldIn.field_72995_K) {
            int meta = this.func_176201_c(state);
            boolean run = true;
            int newMeta = meta;
            while (run) {
                newMeta = worldIn.field_73012_v.nextInt(4);
                if (newMeta == meta) continue;
                run = false;
            }
            worldIn.func_184133_a(null, pos.func_177977_b(), SoundInit.SYNCHRONITE_SWITCH, SoundSource.BLOCKS, 1.5f, 0.8f + worldIn.field_73012_v.nextFloat() * 0.4f);
            worldIn.func_175656_a(pos, this.func_176203_a(newMeta));
        }
        return true;
    }

    public void func_180650_b(Level world, BlockPos pos, BlockState state, Random rand) {
        if (!world.field_72995_K) {
            int meta = this.func_176201_c(state);
            boolean run = true;
            int newMeta = meta;
            while (run) {
                newMeta = rand.nextInt(4);
                if (newMeta == meta) continue;
                run = false;
            }
            world.func_184133_a(null, pos.func_177977_b(), SoundInit.SYNCHRONITE_SWITCH, SoundSource.BLOCKS, 1.5f, 0.8f + world.field_73012_v.nextFloat() * 0.4f);
            world.func_175656_a(pos, this.func_176203_a(newMeta));
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

    public BlockState getStateWithAmount(int amount) {
        return this.func_176223_P().func_177226_a((Property)AMOUNT, (Comparable)Integer.valueOf(amount));
    }
}

