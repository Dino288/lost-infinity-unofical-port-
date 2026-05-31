/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.math.BlockPos
 */
package xol.lostinfinity.dimension.data;

import net.minecraft.core.BlockPos;

public class BlockData {
    private BlockPos pos = null;
    private int meta = 0;
    private int id = 0;

    public BlockData(BlockPos pos, int meta, int id) {
        this.pos = pos;
        this.meta = meta;
        this.id = id;
    }

    public BlockPos getPos() {
        return this.pos;
    }

    public void setPos(BlockPos pos) {
        this.pos = pos;
    }

    public int getMeta() {
        return this.meta;
    }

    public void setMeta(int meta) {
        this.meta = meta;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

