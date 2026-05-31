/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.tileentity.BlockEntity
 *  net.minecraft.util.ITickable
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Vec3i
 */
package xol.lostinfinity.block.tileentity;

import java.util.ArrayList;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.util.ITickable;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Vec3i;
import xol.lostinfinity.init.BlockInit;

public class BlockEntityAlignmentDialGame
extends BlockEntity
implements ITickable {
    private boolean active = false;
    private ArrayList<ArrayList<BlockPos>> rings = null;
    private boolean[] ringStates = null;
    private int dir = 0;
    private int timer = 0;
    private static final int spinTime = 1;
    private int ringCount = 0;

    public void func_73660_a() {
        if (this.active && !this.field_145850_b.field_72995_K) {
            if (this.timer <= 0 && this.ringStates != null) {
                this.timer = 1;
                for (int i = 0; i < this.ringStates.length; ++i) {
                    if (!this.ringStates[i]) continue;
                    this.rotateRing(i);
                }
            } else {
                --this.timer;
            }
        }
    }

    public void toggleRing(BlockPos pos) {
        int i = Math.max(Math.abs(pos.func_177958_n() - this.func_174877_v().func_177958_n()), Math.abs(pos.func_177952_p() - this.func_174877_v().func_177952_p())) - 1;
        if (this.ringStates != null && this.ringStates.length >= i - 1) {
            this.ringStates[i] = !this.ringStates[i];
        }
    }

    private void rotateRing(int i) {
        if (this.rings != null) {
            ArrayList<BlockPos> ring = this.rings.get(i);
            BlockPos lit = null;
            for (BlockPos pos : ring) {
                if (!this.field_145850_b.func_180495_p(pos).equals(BlockInit.alignmentTile.func_176203_a(1))) continue;
                lit = pos;
                break;
            }
            if (lit != null) {
                BlockPos check;
                int dist = i + 1;
                Vec3i dir = null;
                int x = lit.func_177958_n() - this.func_174877_v().func_177958_n();
                int z = lit.func_177952_p() - this.func_174877_v().func_177952_p();
                if (x == dist && z > -dist) {
                    dir = new Vec3i(0, 0, -1);
                } else if (x == -dist && z < dist) {
                    dir = new Vec3i(0, 0, 1);
                } else if (z == dist && x < dist) {
                    dir = new Vec3i(1, 0, 0);
                } else if (z == -dist && x > -dist) {
                    dir = new Vec3i(-1, 0, 0);
                }
                if (dir != null && ring.contains(check = lit.func_177971_a(dir))) {
                    this.field_145850_b.func_175656_a(check, BlockInit.alignmentTile.func_176203_a(1));
                    this.field_145850_b.func_175656_a(lit, BlockInit.alignmentTile.func_176203_a(0));
                }
            }
        }
    }

    public int getRingCount() {
        return this.ringCount;
    }

    public String getDir() {
        switch (this.dir) {
            case 0: {
                return "North";
            }
            case 1: {
                return "East";
            }
            case 2: {
                return "West";
            }
            case 3: {
                return "South";
            }
        }
        return "North";
    }

    public void reset() {
        int ringCount = 0;
        this.rings = new ArrayList();
        boolean foundRings = false;
        while (!foundRings) {
            int dist = ringCount + 1;
            ArrayList<BlockPos> ring = new ArrayList<BlockPos>();
            block1: for (int i = -dist; i <= dist; ++i) {
                for (int j = -dist; j <= dist; ++j) {
                    BlockPos check = this.func_174877_v().func_177982_a(i, 0, j);
                    int ringNum = Math.max(Math.abs(check.func_177958_n() - this.func_174877_v().func_177958_n()), Math.abs(check.func_177952_p() - this.func_174877_v().func_177952_p()));
                    if (i == 0 && j == 0 || ringNum != dist) continue;
                    if (this.field_145850_b.func_180495_p(check).func_177230_c().equals(BlockInit.alignmentTile)) {
                        ring.add(check);
                        this.field_145850_b.func_175656_a(check, BlockInit.alignmentTile.func_176203_a(0));
                        continue;
                    }
                    foundRings = true;
                    break block1;
                }
            }
            if (ring.isEmpty()) continue;
            this.rings.add(ring);
            ++ringCount;
        }
        this.ringCount = ringCount;
        if (this.ringCount <= 0) {
            return;
        }
        this.ringStates = new boolean[ringCount];
        for (ArrayList<BlockPos> ringPositions : this.rings) {
            int rand = this.field_145850_b.field_73012_v.nextInt(ringPositions.size());
            this.field_145850_b.func_175656_a(ringPositions.get(rand), BlockInit.alignmentTile.func_176203_a(1));
        }
        this.active = true;
        this.dir = this.field_145850_b.field_73012_v.nextInt(4);
    }
}

