/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.properties.Property
 *  net.minecraft.block.state.BlockState
 */
package xol.lostinfinity.block.activator;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.BlockState;
import xol.lostinfinity.block.basic.BlockBasicBoolState;

public class BlockRhythmTile
extends BlockBasicBoolState {
    public BlockRhythmTile(String name) {
        super(name);
        this.func_149715_a(1.0f);
    }

    public BlockState getActiveState() {
        return this.func_176223_P().func_177226_a((Property)ACTIVE, (Comparable)Boolean.valueOf(true));
    }

    public BlockState getInactiveState() {
        return this.func_176223_P().func_177226_a((Property)ACTIVE, (Comparable)Boolean.valueOf(false));
    }
}

