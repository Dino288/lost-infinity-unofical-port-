/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Vec3i
 */
package xol.lostinfinity.dimension.data;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Vec3i;

public class TargetNode {
    private BlockPos pos = null;
    private int timing = 0;
    private int duration = 0;
    private int endTime = 0;

    public TargetNode(BlockPos pos, int timing, int duration) {
        this.pos = new BlockPos((Vec3i)pos);
        this.timing = timing;
        this.duration = duration;
        this.updateEndTime();
    }

    private void updateEndTime() {
        this.endTime = this.timing - this.duration;
    }

    public BlockPos getPos() {
        return this.pos;
    }

    public void setPos(BlockPos pos) {
        this.pos = new BlockPos((Vec3i)pos);
    }

    public int getTiming() {
        return this.timing;
    }

    public void setTiming(int timing) {
        this.timing = timing;
    }

    public int getDuration() {
        return this.duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getEndTime() {
        return this.endTime;
    }
}

