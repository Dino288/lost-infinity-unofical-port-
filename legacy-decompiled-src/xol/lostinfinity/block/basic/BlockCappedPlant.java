/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.block.SoundType
 *  net.minecraft.block.material.Material
 *  net.minecraft.block.properties.Property
 *  net.minecraft.block.properties.BooleanProperty
 *  net.minecraft.block.state.StateDefinition
 *  net.minecraft.block.state.BlockState
 *  net.minecraft.entity.player.Player
 *  net.minecraft.item.ItemHoe
 *  net.minecraft.util.Direction
 *  net.minecraft.util.InteractionHand
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.world.World
 */
package xol.lostinfinity.block.basic;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.entity.player.Player;
import net.minecraft.item.ItemHoe;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import xol.lostinfinity.block.basic.BlockBasicPlant;

public class BlockCappedPlant
extends BlockBasicPlant {
    public static final BooleanProperty ACTIVE = BooleanProperty.func_177716_a((String)"active");

    public BlockCappedPlant(String name) {
        super(name, Material.field_151585_k);
        this.func_149672_a(SoundType.field_185850_c);
        this.func_180632_j(this.field_176227_L.func_177621_b().func_177226_a((Property)ACTIVE, (Comparable)Boolean.valueOf(false)));
    }

    public BlockState func_176203_a(int meta) {
        switch (meta) {
            case 0: {
                return this.func_176223_P().func_177226_a((Property)ACTIVE, (Comparable)Boolean.valueOf(false));
            }
            case 1: {
                return this.func_176223_P().func_177226_a((Property)ACTIVE, (Comparable)Boolean.valueOf(true));
            }
        }
        return this.func_176223_P();
    }

    public int func_176201_c(BlockState state) {
        if (state.equals(this.func_176223_P().func_177226_a((Property)ACTIVE, (Comparable)Boolean.valueOf(false)))) {
            return 0;
        }
        if (state.equals(this.func_176223_P().func_177226_a((Property)ACTIVE, (Comparable)Boolean.valueOf(true)))) {
            return 1;
        }
        return 0;
    }

    protected StateDefinition func_180661_e() {
        return new StateDefinition((Block)this, new Property[]{ACTIVE});
    }

    public boolean func_180639_a(Level worldIn, BlockPos pos, BlockState state, Player playerIn, InteractionHand hand, Direction facing, float hitX, float hitY, float hitZ) {
        if (!worldIn.field_72995_K && playerIn.func_184586_b(hand).func_77973_b() instanceof ItemHoe) {
            if (this.func_176201_c(state) == 0) {
                worldIn.func_175656_a(pos, this.func_176203_a(1));
            } else {
                worldIn.func_175656_a(pos, this.func_176203_a(0));
            }
            return true;
        }
        return false;
    }
}

