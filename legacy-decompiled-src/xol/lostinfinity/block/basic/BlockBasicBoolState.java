/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.block.properties.Property
 *  net.minecraft.block.properties.BooleanProperty
 *  net.minecraft.block.state.StateDefinition
 *  net.minecraft.block.state.BlockState
 */
package xol.lostinfinity.block.basic;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.BlockState;
import xol.lostinfinity.block.basic.BlockBasic;

public class BlockBasicBoolState
extends BlockBasic {
    public static final BooleanProperty ACTIVE = BooleanProperty.func_177716_a((String)"active");

    public BlockBasicBoolState(String name) {
        super(name);
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
}

