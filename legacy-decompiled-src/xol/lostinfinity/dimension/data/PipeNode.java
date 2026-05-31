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
import java.util.Random;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Vec3i;
import xol.lostinfinity.block.activator.BlockPipe;
import xol.lostinfinity.init.BlockInit;

public class PipeNode {
    private BlockPos blockPos;
    private int xpos;
    private int ypos;
    private String type;
    private boolean[] neighbours;
    private int rotation;
    private BlockState state;
    private boolean lit;

    public PipeNode(String type, int rotation, int gridx, int gridy) {
        this.type = type;
        this.rotation = rotation;
        this.state = this.getStateFromTypeRot(type, rotation);
        this.xpos = gridx;
        this.ypos = gridy;
        this.lit = false;
        this.initNeighbours();
    }

    public boolean isLit() {
        return this.lit;
    }

    public void setLit(boolean lit) {
        this.lit = lit;
    }

    public void rotate() {
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
        this.rotateNeighbours();
    }

    public BlockState getState() {
        return this.state;
    }

    public void updateState() {
        this.state = this.getStateFromTypeRot(this.type, this.rotation);
    }

    private BlockState getStateFromTypeRot(String name, int rot) {
        Direction facing;
        switch (rot) {
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
        switch (name) {
            case "cross": {
                if (this.isLit()) {
                    return ((BlockPipe)BlockInit.pipeCrossLit).getStateWithFacing(facing);
                }
                return ((BlockPipe)BlockInit.pipeCross).getStateWithFacing(facing);
            }
            case "elbow": {
                if (this.isLit()) {
                    return ((BlockPipe)BlockInit.pipeElbowLit).getStateWithFacing(facing);
                }
                return ((BlockPipe)BlockInit.pipeElbow).getStateWithFacing(facing);
            }
            case "t": {
                if (this.isLit()) {
                    return ((BlockPipe)BlockInit.pipeTLit).getStateWithFacing(facing);
                }
                return ((BlockPipe)BlockInit.pipeT).getStateWithFacing(facing);
            }
            case "l": {
                if (this.isLit()) {
                    return ((BlockPipe)BlockInit.pipeLLit).getStateWithFacing(facing);
                }
                return ((BlockPipe)BlockInit.pipeL).getStateWithFacing(facing);
            }
        }
        return ((BlockPipe)BlockInit.pipeNone).getStateWithFacing(facing);
    }

    public PipeNode(int gridx, int gridy) {
        Random rand = new Random();
        this.type = "none";
        this.rotation = 0;
        this.xpos = gridx;
        this.ypos = gridy;
        this.lit = false;
        this.initNeighbours();
    }

    public void initNeighbours() {
        String type;
        int rot = this.rotation;
        switch (type = this.type) {
            case "cross": {
                this.neighbours = new boolean[]{true, true, true, true};
                break;
            }
            case "elbow": {
                this.neighbours = new boolean[]{true, true, false, false};
                break;
            }
            case "t": {
                this.neighbours = new boolean[]{true, true, true, false};
                break;
            }
            case "l": {
                this.neighbours = new boolean[]{true, false, true, false};
                break;
            }
            case "none": {
                this.neighbours = new boolean[]{false, false, false, false};
            }
        }
        for (int i = 0; i < rot; ++i) {
            this.rotateNeighbours();
        }
    }

    private void rotateNeighbours() {
        boolean[] neighbours = this.neighbours;
        boolean[] newNeighbours = new boolean[]{false, false, false, false};
        if (neighbours[0]) {
            newNeighbours[1] = true;
        }
        if (neighbours[1]) {
            newNeighbours[2] = true;
        }
        if (neighbours[2]) {
            newNeighbours[3] = true;
        }
        if (neighbours[3]) {
            newNeighbours[0] = true;
        }
        this.setNeighbours(newNeighbours);
    }

    public void setNeighbours(boolean[] neighbours) {
        this.neighbours = neighbours;
    }

    public boolean compare(PipeNode node) {
        int x1 = this.getX();
        int x2 = node.getX();
        int y1 = this.getY();
        int y2 = node.getY();
        return x1 == x2 && y1 == y2;
    }

    public int getX() {
        return this.xpos;
    }

    public int getY() {
        return this.ypos;
    }

    public void setX(int x) {
        this.xpos = x;
    }

    public void setY(int y) {
        this.ypos = y;
    }

    public void setBlockPos(BlockPos pos) {
        this.blockPos = new BlockPos((Vec3i)pos);
    }

    public BlockPos getBlockPos() {
        return this.blockPos;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<PipeNode> getConnectedNeighbours(PipeNode[][] pipeMap) {
        ArrayList<PipeNode> connected = new ArrayList<PipeNode>();
        for (PipeNode neighbour : this.getNeighbours(pipeMap)) {
            if (!neighbour.getNeighbours(pipeMap).contains(this)) continue;
            connected.add(neighbour);
        }
        return connected;
    }

    public void propogateLit(PipeNode[][] pipeMap, ArrayList<PipeNode> visited) {
        visited.add(this);
        this.setLit(true);
        for (PipeNode neighbour : this.getConnectedNeighbours(pipeMap)) {
            if (visited.contains(neighbour)) continue;
            neighbour.propogateLit(pipeMap, visited);
        }
    }

    public PipeNode getNodeAtLocation(PipeNode[][] pipeMap, int x, int y) {
        if (x >= 0 && x < pipeMap.length && y >= 0 && y < pipeMap[x].length) {
            return pipeMap[x][y];
        }
        return null;
    }

    public List<PipeNode> getNeighbours(PipeNode[][] pipeMap) {
        ArrayList<PipeNode> neighbourList = new ArrayList<PipeNode>();
        int x = this.getX();
        int y = this.getY();
        boolean[] neighbours = this.neighbours;
        if (neighbours[0] && this.getNodeAtLocation(pipeMap, x, y + 1) != null) {
            neighbourList.add(pipeMap[x][y + 1]);
        }
        if (neighbours[1] && this.getNodeAtLocation(pipeMap, x + 1, y) != null) {
            neighbourList.add(pipeMap[x + 1][y]);
        }
        if (neighbours[2] && this.getNodeAtLocation(pipeMap, x, y - 1) != null) {
            neighbourList.add(pipeMap[x][y - 1]);
        }
        if (neighbours[3] && this.getNodeAtLocation(pipeMap, x - 1, y) != null) {
            neighbourList.add(pipeMap[x - 1][y]);
        }
        return neighbourList;
    }
}

