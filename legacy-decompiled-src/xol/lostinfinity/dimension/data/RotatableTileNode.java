/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.state.BlockState
 *  net.minecraft.util.Direction
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Vec3i
 */
package xol.lostinfinity.dimension.data;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Vec3i;
import xol.lostinfinity.block.activator.BlockRotatableTile;
import xol.lostinfinity.init.BlockInit;

public class RotatableTileNode {
    private BlockPos blockPos;
    private int xpos;
    private int zpos;
    private int rotation;
    private BlockState state;

    public RotatableTileNode(int rotation, int gridx, int gridz) {
        this.rotation = rotation;
        this.state = this.getStateFromRot();
        this.xpos = gridx;
        this.zpos = gridz;
    }

    public void rotate(RotatableTileNode[][] tileMap, boolean propogate) {
        switch (this.rotation) {
            case 0: {
                this.rotation = 1;
                break;
            }
            case 1: {
                this.rotation = 2;
                break;
            }
            case 2: {
                this.rotation = 3;
                break;
            }
            case 3: {
                this.rotation = 0;
                break;
            }
            default: {
                this.rotation = 0;
            }
        }
        if (propogate) {
            this.rotateNeighbours(tileMap);
        }
    }

    private void rotateNeighbours(RotatableTileNode[][] tileMap) {
        for (RotatableTileNode node : this.getNeighbours(tileMap)) {
            node.rotate(tileMap, false);
        }
    }

    public BlockState getState() {
        return this.state;
    }

    public void updateState() {
        this.state = this.getStateFromRot();
    }

    private BlockState getStateFromRot() {
        Direction facing;
        switch (this.rotation) {
            case 0: {
                facing = Direction.NORTH;
                break;
            }
            case 1: {
                facing = Direction.EAST;
                break;
            }
            case 2: {
                facing = Direction.SOUTH;
                break;
            }
            case 3: {
                facing = Direction.WEST;
                break;
            }
            default: {
                facing = Direction.NORTH;
            }
        }
        return ((BlockRotatableTile)BlockInit.rotatableTile).getStateWithFacing(facing);
    }

    public boolean compare(RotatableTileNode node) {
        int x1 = this.getX();
        int x2 = node.getX();
        int z1 = this.getZ();
        int z2 = node.getZ();
        return x1 == x2 && z1 == z2;
    }

    public int getX() {
        return this.xpos;
    }

    public int getZ() {
        return this.zpos;
    }

    public void setX(int x) {
        this.xpos = x;
    }

    public void setZ(int z) {
        this.zpos = z;
    }

    public void setBlockPos(BlockPos pos) {
        this.blockPos = new BlockPos((Vec3i)pos);
    }

    public BlockPos getBlockPos() {
        return this.blockPos;
    }

    public int getRotation() {
        return this.rotation;
    }

    public RotatableTileNode getNodeAtLocation(RotatableTileNode[][] tileMap, int x, int z) {
        if (x >= 0 && x < tileMap.length && z >= 0 && z < tileMap[x].length) {
            return tileMap[x][z];
        }
        return null;
    }

    public List<RotatableTileNode> getNeighbours(RotatableTileNode[][] tileMap) {
        int z;
        ArrayList<RotatableTileNode> neighbourList = new ArrayList<RotatableTileNode>();
        int x = this.getX();
        if (this.getNodeAtLocation(tileMap, x, (z = this.getZ()) + 1) != null) {
            neighbourList.add(tileMap[x][z + 1]);
        }
        if (this.getNodeAtLocation(tileMap, x + 1, z) != null) {
            neighbourList.add(tileMap[x + 1][z]);
        }
        if (this.getNodeAtLocation(tileMap, x, z - 1) != null) {
            neighbourList.add(tileMap[x][z - 1]);
        }
        if (this.getNodeAtLocation(tileMap, x - 1, z) != null) {
            neighbourList.add(tileMap[x - 1][z]);
        }
        return neighbourList;
    }
}

