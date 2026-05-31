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
 *  net.minecraft.util.SoundSource
 *  net.minecraft.util.SoundEvent
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
import net.minecraft.sounds.SoundSource;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Vec3i;
import net.minecraft.world.level.Level;
import xol.lostinfinity.block.basic.BlockBasic;
import xol.lostinfinity.block.tileentity.BlockEntityMelodicSequencer;
import xol.lostinfinity.init.BlockInit;

public class BlockMelodyButton
extends BlockBasic {
    public static final IntegerProperty AMOUNT = IntegerProperty.func_177719_a((String)"amount", (int)0, (int)4);

    public BlockMelodyButton(String name) {
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
        if (!worldIn.field_72995_K && !playerIn.func_70093_af()) {
            boolean played = false;
            int radius = 7;
            Vec3i offset = new Vec3i(0, 2, 0);
            for (int i = -radius; i <= radius; ++i) {
                for (int k = -radius; k <= radius; ++k) {
                    BlockEntity tileEntity;
                    BlockPos check = new BlockPos((Vec3i)pos.func_177971_a(offset).func_177982_a(i, 0, k));
                    BlockState checkState = worldIn.func_180495_p(check);
                    Block checkBlock = checkState.func_177230_c();
                    if (checkBlock != BlockInit.melodicSequencer || (tileEntity = worldIn.func_175625_s(check)) == null || !(tileEntity instanceof BlockEntityMelodicSequencer)) continue;
                    BlockEntityMelodicSequencer sequencer = (BlockEntityMelodicSequencer)tileEntity;
                    int meta = this.func_176201_c(state);
                    played = sequencer.playNote(meta, pos, playerIn);
                }
            }
            if (!played) {
                int meta = this.func_176201_c(state);
                ArrayList<SoundEvent> notes = BlockEntityMelodicSequencer.getNotes();
                if (notes.size() > meta) {
                    worldIn.func_184133_a(null, pos, notes.get(meta), SoundSource.BLOCKS, 0.8f, 1.0f);
                }
            }
        }
        return true;
    }
}

