/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.state.BlockState
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Vec3
 *  net.minecraft.util.math.Vec3i
 *  net.minecraft.world.World
 */
package xol.lostinfinity.dimension.shadowsea;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.core.BlockPos;
import net.minecraft.world.phys.Vec3;
import net.minecraft.core.Vec3i;
import net.minecraft.world.level.Level;
import xol.lostinfinity.init.BlockInit;

public class CoralGenerator {
    private Level world;
    private BlockState topBlock = BlockInit.seastone.func_176223_P();

    public CoralGenerator() {
    }

    public void setWorld(Level world, BlockState state) {
        this.world = world;
        this.topBlock = state;
    }

    public CoralGenerator(Level world) {
        this.world = world;
    }

    public void genRandomCoral(BlockPos pos) {
        if (!this.world.field_72995_K) {
            int randCoral = this.world.field_73012_v.nextInt(8);
            switch (randCoral) {
                case 0: {
                    this.genTreeCoral(pos);
                    break;
                }
                case 1: {
                    this.genTubeCoral(pos, new Integer[0]);
                    break;
                }
                case 2: {
                    this.genFunnelCoral(pos);
                    break;
                }
                case 3: {
                    this.genBranchCoral(pos);
                    break;
                }
                case 4: {
                    this.genPlateCoral(pos, new Integer[0]);
                    break;
                }
                case 5: {
                    this.genPoleCoral(pos, new Integer[0]);
                    break;
                }
                case 6: {
                    this.genBrainCoral(pos);
                }
            }
        }
    }

    public void genVolcanicCoral(BlockPos pos) {
        if (!this.world.field_72995_K) {
            if (this.world.field_73012_v.nextInt(4) == 0) {
                int randCoral = this.world.field_73012_v.nextInt(3);
                switch (randCoral) {
                    case 0: {
                        this.genSproutCoral(pos);
                        break;
                    }
                    case 1: {
                        this.GenFlatTopCoral(pos);
                        break;
                    }
                    case 2: {
                        this.GenBulbCoral(pos);
                    }
                }
            } else {
                int randCoral = this.world.field_73012_v.nextInt(3);
                switch (randCoral) {
                    case 0: {
                        this.genTubeCoral(pos, 6, 7, 8, 9);
                        break;
                    }
                    case 1: {
                        this.genPlateCoral(pos, 6, 7, 8, 9);
                        break;
                    }
                    case 2: {
                        this.genPoleCoral(pos, 6, 7, 8, 9);
                    }
                }
            }
        }
    }

    public void genRandomExtras(BlockPos pos) {
        this.genRadionTower(pos);
    }

    private void genRadionTower(BlockPos pos) {
        int towerHeight = 30;
        int radius = 7;
        int wallHeight = 7;
        int pillarHeight = 7;
        for (int j = 0; j < towerHeight; ++j) {
            for (int i = -2; i <= 2; ++i) {
                for (int k = -2; k <= 2; ++k) {
                    if (Math.abs(i) == 2 && Math.abs(k) == 2) continue;
                    if (Math.abs(i) == 2 || Math.abs(k) == 2) {
                        if (this.world.field_73012_v.nextInt(6) != 0) continue;
                        this.world.func_175656_a(pos.func_177982_a(i, j, k), BlockInit.seastone.func_176223_P());
                        continue;
                    }
                    this.world.func_175656_a(pos.func_177982_a(i, j, k), BlockInit.seastone.func_176223_P());
                }
            }
        }
        for (int i = -radius; i <= radius; ++i) {
            for (int k = -radius; k <= radius; ++k) {
                int j;
                if (i * i + k * k > radius * radius) continue;
                if (i * i + k * k >= (radius - 1) * (radius - 1)) {
                    for (j = 1; j <= wallHeight; ++j) {
                        this.world.func_175656_a(pos.func_177982_a(i, towerHeight + j, k), BlockInit.seastone.func_176223_P());
                    }
                } else if (i * i + k * k >= (radius - 2) * (radius - 2)) {
                    for (j = 1; j <= wallHeight; ++j) {
                        if (this.world.field_73012_v.nextInt(4) == 0) {
                            this.world.func_175656_a(pos.func_177982_a(i, towerHeight + j, k), BlockInit.radionOre.func_176223_P());
                            continue;
                        }
                        this.world.func_175656_a(pos.func_177982_a(i, towerHeight + j, k), BlockInit.seastone.func_176223_P());
                    }
                } else if (i == 0 && k == 0) {
                    for (j = 1; j <= pillarHeight; ++j) {
                        this.world.func_175656_a(pos.func_177982_a(i, towerHeight + j, k), BlockInit.radionPillar.func_176223_P());
                    }
                }
                this.world.func_175656_a(pos.func_177982_a(i, towerHeight, k), BlockInit.seastone.func_176223_P());
            }
        }
    }

    public void genPoleCoral(BlockPos pos, Integer ... ints) {
        int i;
        int secondPick;
        int pick;
        if (ints.length == 0) {
            pick = this.world.field_73012_v.nextInt(16);
            secondPick = pick - 1 + this.world.field_73012_v.nextInt(3);
            if (secondPick < 0) {
                secondPick = 15;
            } else if (secondPick > 15) {
                secondPick = 0;
            }
        } else {
            secondPick = pick = ints[this.world.field_73012_v.nextInt(ints.length)].intValue();
        }
        ArrayList<BlockPos> startingPositions = new ArrayList<BlockPos>();
        BlockState poleState = BlockInit.superRoughCoral.func_176203_a(pick);
        BlockState poleTop = BlockInit.roughCoral.func_176203_a(secondPick);
        int minRadius = 4;
        int maxRadius = 8;
        int minHeight = 3;
        int maxHeight = 15;
        Random rand = new Random();
        int height = rand.nextInt(maxHeight - minHeight + 1) + minHeight;
        int radius = rand.nextInt(maxRadius - minRadius + 1) + minRadius;
        startingPositions.add(pos);
        for (i = 0; i < height; ++i) {
            if (i == height - 1) {
                this.world.func_175656_a(pos.func_177982_a(0, i, 0), poleTop);
                continue;
            }
            this.world.func_175656_a(pos.func_177982_a(0, i, 0), poleState);
        }
        for (i = -radius; i <= radius; ++i) {
            for (int j = -radius; j <= radius; ++j) {
                BlockPos check = pos.func_177982_a(i, 0, j);
                if (!this.isTopBlock(check.func_177977_b())) continue;
                boolean tooClose = false;
                for (BlockPos position : startingPositions) {
                    if (!(check.func_185332_f(position.func_177958_n(), position.func_177956_o(), position.func_177952_p()) < 2.0)) continue;
                    tooClose = true;
                    break;
                }
                if (tooClose || rand.nextInt(4) != 0) continue;
                height = rand.nextInt(maxHeight - minHeight + 1) + minHeight;
                startingPositions.add(check);
                for (int k = 0; k < height; ++k) {
                    if (k == height - 1) {
                        this.world.func_175656_a(check.func_177982_a(0, k, 0), poleTop);
                        continue;
                    }
                    this.world.func_175656_a(check.func_177982_a(0, k, 0), poleState);
                }
            }
        }
    }

    private boolean isTopBlock(BlockPos pos) {
        return this.world.func_180495_p(pos).equals(this.topBlock);
    }

    public void genFunnelCoral(BlockPos pos) {
        if (!this.isTopBlock(pos.func_177977_b())) {
            return;
        }
        int pick = 9 + this.world.field_73012_v.nextInt(4);
        BlockState funnelState = BlockInit.roughCoral.func_176203_a(pick);
        int heightMin = 10;
        int heightMax = 25;
        int height = this.world.field_73012_v.nextInt(heightMax - heightMin + 1) + heightMin;
        int curRadius = 0;
        for (int i = 0; i < height; ++i) {
            if (i > height - 2) {
                curRadius += 3;
            } else if (i % 5 == 4) {
                ++curRadius;
            }
            for (int j = -curRadius; j <= curRadius; ++j) {
                for (int k = -curRadius; k <= curRadius; ++k) {
                    if (j * j + k * k > curRadius * curRadius) continue;
                    if (i == height - 1 && j * j + k * k < curRadius * curRadius - curRadius) {
                        int roll = this.world.field_73012_v.nextInt(2);
                        if (roll == 0) {
                            this.world.func_175656_a(pos.func_177982_a(j, i, k), funnelState);
                            continue;
                        }
                        if (roll != 1) continue;
                        this.world.func_175656_a(pos.func_177982_a(j, i + 1, k), funnelState);
                        this.world.func_175656_a(pos.func_177982_a(j, i, k), funnelState);
                        continue;
                    }
                    this.world.func_175656_a(pos.func_177982_a(j, i, k), funnelState);
                }
            }
        }
    }

    public void genPlateCoral(BlockPos pos, Integer ... ints) {
        if (!this.isTopBlock(pos.func_177977_b())) {
            return;
        }
        this.genPlateCoral(pos, (BlockState)null, (BlockState)null, ints);
    }

    public void genPlateCoral(BlockPos pos, BlockState prevPlate, BlockState prevInner, Integer ... ints) {
        BlockState plateState = prevPlate;
        BlockState innerState = prevInner;
        if (plateState == null || innerState == null) {
            int pick = ints.length == 0 ? this.world.field_73012_v.nextInt(16) : ints[this.world.field_73012_v.nextInt(ints.length)].intValue();
            plateState = BlockInit.smoothCoral.func_176203_a(pick);
            innerState = BlockInit.lightSmoothCoral.func_176203_a(pick);
        }
        int radiusMin = 3;
        int radiusMax = 10;
        int radius = this.world.field_73012_v.nextInt(radiusMax - radiusMin + 1) + radiusMin;
        for (int i = -radius; i <= radius; ++i) {
            for (int j = -radius; j <= radius; ++j) {
                double curRadius = Math.sqrt(i * i + j * j);
                if (!(curRadius <= (double)(radius + 1))) continue;
                int x = pos.func_177958_n() + i;
                int z = pos.func_177952_p() + j;
                int y = (int)((double)pos.func_177956_o() + (double)radius / 5.2 * Math.cos(curRadius * Math.PI / (double)radius + Math.PI));
                if (curRadius <= (double)((float)radius * 0.85f)) {
                    this.world.func_175656_a(new BlockPos(x, y, z), innerState);
                    continue;
                }
                this.world.func_175656_a(new BlockPos(x, y, z), plateState);
            }
        }
        if (this.world.field_73012_v.nextBoolean()) {
            this.genPlateCoral(pos.func_177971_a(new Vec3i(this.world.field_73012_v.nextInt(5) - 2, 2, this.world.field_73012_v.nextInt(5) - 2)), plateState, innerState, new Integer[0]);
        }
    }

    public void genBranchCoral(BlockPos pos) {
        if (!this.isTopBlock(pos.func_177977_b())) {
            return;
        }
        int pick = this.world.field_73012_v.nextInt(16);
        BlockState branchState = BlockInit.roughCoral.func_176203_a(pick);
        this.genBranchCoral(branchState, null, null, null, null, 0, pos);
    }

    public int genBranchCoral(BlockState branchState, CoralNode[][][] map, CoralNode node, Vec3i dir, ArrayList<CoralNode> visited, int count, BlockPos pos) {
        Random rand = new Random();
        ++count;
        if (map == null) {
            CoralNode countNode;
            int k;
            int j;
            int i;
            int minXZ = 5;
            int maxXZ = 7;
            int minY = 8;
            int maxY = 40;
            int xSize = rand.nextInt(maxXZ - minXZ + 1) + minXZ;
            int zSize = rand.nextInt(maxXZ - minXZ + 1) + minXZ;
            int ySize = rand.nextInt(maxY - minY + 1) + minY;
            map = new CoralNode[xSize][ySize][zSize];
            for (int i2 = 0; i2 < xSize; ++i2) {
                for (int j2 = 0; j2 < ySize; ++j2) {
                    for (int k2 = 0; k2 < zSize; ++k2) {
                        map[i2][j2][k2] = new CoralNode(i2, j2, k2);
                    }
                }
            }
            node = CoralGenerator.getNodeAtLocation(map, xSize / 2, 0, zSize / 2);
            visited = new ArrayList();
            dir = new Vec3i(0, 1, 0);
            CoralNode next = CoralGenerator.getNodeAtLocation(map, node.x + dir.func_177958_n(), node.y + dir.func_177956_o(), node.z + dir.func_177952_p());
            node.visited = true;
            next.prev.add(node);
            this.genBranchCoral(branchState, map, next, dir, visited, count, pos);
            int totalCount = 0;
            boolean finished = false;
            for (i = 0; i < xSize; ++i) {
                block4: for (j = 0; j < ySize; ++j) {
                    for (k = 0; k < zSize; ++k) {
                        countNode = CoralGenerator.getNodeAtLocation(map, i, j, k);
                        if (countNode.visited) {
                            ++totalCount;
                        }
                        if (totalCount <= 24) continue;
                        finished = true;
                        continue block4;
                    }
                }
            }
            if (!finished) {
                this.genBranchCoral(branchState, null, null, null, null, 0, pos);
            } else {
                for (i = 0; i < xSize; ++i) {
                    for (j = 0; j < ySize; ++j) {
                        for (k = 0; k < zSize; ++k) {
                            countNode = CoralGenerator.getNodeAtLocation(map, i, j, k);
                            if (!countNode.visited) continue;
                            this.world.func_175656_a(pos.func_177982_a(countNode.x - xSize / 2, countNode.y, countNode.z - zSize / 2), branchState);
                        }
                    }
                }
            }
            return count;
        }
        double xDist = Math.abs(Math.min(map.length - node.x, node.x));
        double yDist = Math.abs(Math.min(map[0].length - node.y, node.y));
        double zDist = Math.abs(Math.min(map[0][0].length - node.z, node.z));
        if (xDist > 0.0 && yDist > 0.0 && zDist > 0.0 && !node.visited) {
            int neighbourCount = 0;
            for (int i = -1; i <= 1; ++i) {
                for (int j = -1; j <= 1; ++j) {
                    for (int k = -1; k <= 1; ++k) {
                        CoralNode check;
                        if (i == 0 && j == 0 && k == 0 || (check = CoralGenerator.getNodeAtLocation(map, node.x + i, node.y + j, node.z + k)) == null || !check.visited || ++neighbourCount <= 2) continue;
                        return count;
                    }
                }
            }
            node.visited = true;
            int roll = rand.nextInt(11);
            if (roll > 3) {
                ArrayList<Vec3i> upDirs = CoralGenerator.upDirs();
                Collections.shuffle(upDirs);
                ArrayList<Vec3i> used = new ArrayList<Vec3i>();
                int num = 2;
                for (int i = 0; i < num; ++i) {
                    int iterations = 0;
                    boolean found = false;
                    while (!found && iterations < 10) {
                        CoralNode newNode;
                        ++iterations;
                        Collections.shuffle(upDirs);
                        Vec3i newDir = upDirs.get(0);
                        if (used.contains(newDir) || (newNode = CoralGenerator.getNodeAtLocation(map, node.x + newDir.func_177958_n(), node.y + newDir.func_177956_o(), node.z + newDir.func_177952_p())) == null || newNode.equals(node) || node.prev.contains(newNode)) continue;
                        for (CoralNode prevNode : node.prev) {
                            if (prevNode == null || prevNode.equals(node) || prevNode.equals(newNode)) continue;
                            newNode.prev.add(node);
                        }
                        found = true;
                        newNode.prev.add(node);
                        count += this.genBranchCoral(branchState, map, newNode, newDir, visited, count, pos);
                        used.add(newDir);
                    }
                }
                return count;
            }
            if (!dir.equals((Object)new Vec3i(0, 1, 0)) && rand.nextInt(3) == 0) {
                dir = new Vec3i(0, 1, 0);
            }
            CoralNode next = CoralGenerator.getNodeAtLocation(map, node.x + dir.func_177958_n(), node.y + dir.func_177956_o(), node.z + dir.func_177952_p());
            if (node.prev.contains(next) || next == null) {
                return count;
            }
            if (node.equals(next)) {
                return count;
            }
            for (CoralNode prevNode : node.prev) {
                if (prevNode == null || prevNode.equals(node) || prevNode.equals(next)) continue;
                next.prev.add(node);
            }
            next.prev.add(node);
            count += this.genBranchCoral(branchState, map, next, dir, visited, count, pos);
        }
        return count;
    }

    private static ArrayList<Vec3i> upDirs() {
        ArrayList<Vec3i> neighbours = new ArrayList<Vec3i>();
        neighbours.add(new Vec3i(0, 1, 0));
        neighbours.add(new Vec3i(1, 0, 0));
        neighbours.add(new Vec3i(-1, 0, 0));
        neighbours.add(new Vec3i(0, 0, 1));
        neighbours.add(new Vec3i(0, 0, -1));
        return neighbours;
    }

    private static ArrayList<Vec3i> getDirs() {
        ArrayList<Vec3i> neighbours = new ArrayList<Vec3i>();
        neighbours.add(new Vec3i(0, 1, 0));
        neighbours.add(new Vec3i(1, 0, 0));
        neighbours.add(new Vec3i(-1, 0, 0));
        neighbours.add(new Vec3i(0, 0, 1));
        neighbours.add(new Vec3i(0, 0, -1));
        neighbours.add(new Vec3i(0, -1, 0));
        return neighbours;
    }

    private static Vec3 randomlyRotate(Vec3 dir, double xRot, double yRot, double zRot) {
        Random rand = new Random();
        double angleX = rand.nextDouble() * xRot * 2.0 - xRot;
        double angleY = rand.nextDouble() * yRot * 2.0 - yRot;
        double angleZ = rand.nextDouble() * zRot * 2.0 - zRot;
        double newX = dir.field_72450_a;
        double newY = dir.field_72448_b * Math.cos(angleX) - dir.field_72449_c * Math.sin(angleX);
        double newZ = dir.field_72448_b * Math.sin(angleX) + dir.field_72449_c * Math.cos(angleX);
        newX = newX * Math.cos(angleY) + newZ * Math.sin(angleY);
        newZ = -newX * Math.sin(angleY) + newZ * Math.cos(angleY);
        newX = newX * Math.cos(angleZ) - newY * Math.sin(angleZ);
        newY = newX * Math.sin(angleZ) + newY * Math.cos(angleZ);
        return new Vec3(newX, newY, newZ);
    }

    private static CoralNode getNodeAtLocation(CoralNode[][][] map, int x, int y, int z) {
        if (map != null && x >= 0 && x < map.length && y >= 0 && y < map[0].length && z >= 0 && z < map[0][0].length) {
            return map[x][y][z];
        }
        return null;
    }

    public boolean isZigZag(Vec3i first, Vec3i second) {
        return Math.abs(first.func_177958_n() - second.func_177958_n()) + Math.abs(first.func_177952_p() - second.func_177952_p()) != 1 || first.func_177958_n() != second.func_177958_n() && second.func_177952_p() != first.func_177952_p();
    }

    public void genTubeCoral(BlockPos pos, Integer ... ints) {
        int i;
        if (!this.isTopBlock(pos.func_177977_b())) {
            return;
        }
        int pick = ints.length == 0 ? this.world.field_73012_v.nextInt(16) : ints[this.world.field_73012_v.nextInt(ints.length)].intValue();
        BlockState outerTube = BlockInit.darkRoughCoral.func_176203_a(pick);
        BlockState innerTube = BlockInit.smoothCoral.func_176203_a(pick);
        int heightMax = 24;
        int heightMin = 6;
        int maxRadius = 8;
        int minRadius = 4;
        int radius = this.world.field_73012_v.nextInt(maxRadius - minRadius + 1) + minRadius;
        ArrayList<BlockPos> startingPositions = new ArrayList<BlockPos>();
        startingPositions.add(pos);
        ArrayList<Vec3i> outerRingVecs = new ArrayList<Vec3i>();
        ArrayList<Vec3i> innerRingVecs = new ArrayList<Vec3i>();
        for (int i2 = -2; i2 <= 2; ++i2) {
            for (int j = -2; j <= 2; ++j) {
                int currentRad = i2 * i2 + j * j;
                if ((double)currentRad >= 2.0 && (double)currentRad <= 5.0) {
                    outerRingVecs.add(new Vec3i(i2, 0, j));
                    continue;
                }
                if (currentRad <= 0 || !((double)currentRad < 2.0)) continue;
                innerRingVecs.add(new Vec3i(i2, 0, j));
            }
        }
        int height = this.world.field_73012_v.nextInt(heightMax - heightMin + 1) + heightMin;
        this.world.func_175656_a(pos.func_177982_a(0, -1, 1), outerTube);
        this.world.func_175656_a(pos.func_177982_a(1, -1, 1), outerTube);
        this.world.func_175656_a(pos.func_177982_a(-1, -1, 1), outerTube);
        this.world.func_175656_a(pos.func_177982_a(0, -1, -1), outerTube);
        this.world.func_175656_a(pos.func_177982_a(1, -1, 0), outerTube);
        this.world.func_175656_a(pos.func_177982_a(1, -1, -1), outerTube);
        this.world.func_175656_a(pos.func_177982_a(-1, -1, 0), outerTube);
        this.world.func_175656_a(pos.func_177982_a(-1, -1, -1), outerTube);
        this.world.func_175656_a(pos.func_177982_a(0, -1, 0), outerTube);
        this.world.func_175656_a(pos.func_177982_a(0, -2, 1), outerTube);
        this.world.func_175656_a(pos.func_177982_a(1, -2, 0), outerTube);
        this.world.func_175656_a(pos.func_177982_a(0, -2, -1), outerTube);
        this.world.func_175656_a(pos.func_177982_a(-1, -2, 0), outerTube);
        this.world.func_175656_a(pos.func_177982_a(0, -2, 0), outerTube);
        Vec3i offset = new Vec3i(0, 0, 0);
        Vec3i prevOffset = new Vec3i(0, 0, 0);
        for (i = 0; i < height; ++i) {
            if (i % 5 == 2) {
                while (this.isZigZag(prevOffset, offset)) {
                    offset = new Vec3i(this.world.field_73012_v.nextInt(3) - 1, 0, this.world.field_73012_v.nextInt(3) - 1);
                }
                prevOffset = offset;
            }
            if (i < height - 1) {
                for (Vec3i vec : innerRingVecs) {
                    this.world.func_175656_a(pos.func_177971_a(offset).func_177971_a(vec).func_177982_a(0, i, 0), innerTube);
                }
            }
            for (Vec3i vec : outerRingVecs) {
                this.world.func_175656_a(pos.func_177971_a(offset).func_177971_a(vec).func_177982_a(0, i, 0), outerTube);
            }
        }
        for (i = -radius; i <= radius; ++i) {
            for (int j = -radius; j <= radius; ++j) {
                BlockPos check = pos.func_177982_a(i, 0, j);
                if (!this.isTopBlock(check.func_177977_b())) continue;
                boolean tooClose = false;
                for (BlockPos position : startingPositions) {
                    double dist = check.func_185332_f(position.func_177958_n(), position.func_177956_o(), position.func_177952_p());
                    if (!(dist < 5.0)) continue;
                    tooClose = true;
                    break;
                }
                if (tooClose || this.world.field_73012_v.nextInt(4) != 0) continue;
                startingPositions.add(check);
                for (int k = -2; k <= 2; ++k) {
                    for (int n = -2; n <= 2; ++n) {
                        int currentRad = k * k + n * n;
                        if ((double)currentRad >= 2.0 && (double)currentRad <= 5.0) {
                            outerRingVecs.add(new Vec3i(k, 0, n));
                            continue;
                        }
                        if (currentRad <= 0 || !((double)currentRad < 2.0)) continue;
                        innerRingVecs.add(new Vec3i(k, 0, n));
                    }
                }
                height = this.world.field_73012_v.nextInt(heightMax - heightMin + 1) + heightMin;
                offset = new Vec3i(0, 0, 0);
                this.world.func_175656_a(check.func_177982_a(0, -1, 1), outerTube);
                this.world.func_175656_a(check.func_177982_a(1, -1, 1), outerTube);
                this.world.func_175656_a(check.func_177982_a(-1, -1, 1), outerTube);
                this.world.func_175656_a(check.func_177982_a(0, -1, -1), outerTube);
                this.world.func_175656_a(check.func_177982_a(1, -1, 0), outerTube);
                this.world.func_175656_a(check.func_177982_a(1, -1, -1), outerTube);
                this.world.func_175656_a(check.func_177982_a(-1, -1, 0), outerTube);
                this.world.func_175656_a(check.func_177982_a(-1, -1, -1), outerTube);
                this.world.func_175656_a(check.func_177982_a(0, -1, 0), outerTube);
                this.world.func_175656_a(check.func_177982_a(0, -2, 1), outerTube);
                this.world.func_175656_a(check.func_177982_a(1, -2, 0), outerTube);
                this.world.func_175656_a(check.func_177982_a(0, -2, -1), outerTube);
                this.world.func_175656_a(check.func_177982_a(-1, -2, 0), outerTube);
                this.world.func_175656_a(check.func_177982_a(0, -2, 0), outerTube);
                prevOffset = new Vec3i(0, 0, 0);
                for (int h = 0; h < height; ++h) {
                    if (h % 5 == 2) {
                        while (this.isZigZag(prevOffset, offset) || prevOffset.equals((Object)offset)) {
                            offset = new Vec3i(this.world.field_73012_v.nextInt(3) - 1, 0, this.world.field_73012_v.nextInt(3) - 1);
                        }
                        prevOffset = offset;
                    }
                    if (h < height - 1) {
                        for (Vec3i vec : innerRingVecs) {
                            this.world.func_175656_a(check.func_177971_a(offset).func_177971_a(vec).func_177982_a(0, h, 0), innerTube);
                        }
                    }
                    for (Vec3i vec : outerRingVecs) {
                        this.world.func_175656_a(check.func_177971_a(offset).func_177971_a(vec).func_177982_a(0, h, 0), outerTube);
                    }
                }
            }
        }
    }

    private static ArrayList<BlockPos> getNeighbours(BlockPos pos, boolean hasDiag) {
        ArrayList<BlockPos> neighbours = new ArrayList<BlockPos>();
        neighbours.add(pos.func_177974_f());
        neighbours.add(pos.func_177968_d());
        neighbours.add(pos.func_177976_e());
        neighbours.add(pos.func_177978_c());
        if (hasDiag) {
            neighbours.add(pos.func_177974_f().func_177978_c());
            neighbours.add(pos.func_177974_f().func_177968_d());
            neighbours.add(pos.func_177976_e().func_177978_c());
            neighbours.add(pos.func_177976_e().func_177968_d());
        }
        return neighbours;
    }

    public void genTreeCoral(BlockPos pos) {
        if (!this.isTopBlock(pos.func_177977_b())) {
            return;
        }
        int pick = this.world.field_73012_v.nextInt(16);
        BlockState branchState = BlockInit.roughCoral.func_176203_a(pick);
        this.genTreeCoral(branchState, null, null, null, null, pos);
    }

    public void genTreeCoral(BlockState branchState, CoralNode[][][] map, CoralTrunk trunk, Vec3i dir, ArrayList<CoralNode> visited, BlockPos pos) {
        int radius = 3;
        Random rand = new Random();
        if (map == null) {
            int i;
            int minXZ = 20;
            int maxXZ = 30;
            int minY = 25;
            int maxY = 35;
            int xSize = rand.nextInt(maxXZ - minXZ + 1) + minXZ;
            int zSize = rand.nextInt(maxXZ - minXZ + 1) + minXZ;
            int ySize = rand.nextInt(maxY - minY + 1) + minY;
            map = new CoralNode[xSize][ySize][zSize];
            for (int i2 = 0; i2 < xSize; ++i2) {
                for (int j = 0; j < ySize; ++j) {
                    for (int k = 0; k < zSize; ++k) {
                        map[i2][j][k] = new CoralNode(i2, j, k);
                    }
                }
            }
            CoralNode node = CoralGenerator.getNodeAtLocation(map, xSize / 2, 0, zSize / 2);
            node.prev.clear();
            visited = new ArrayList();
            dir = new Vec3i(0, 1, 0);
            CoralTrunk next = new CoralTrunk(map, node, radius, dir);
            next.visit();
            visited.addAll(next.nodes);
            ArrayList<CoralTrunk> queue = new ArrayList<CoralTrunk>();
            queue.add(next);
            int iterations = 0;
            while (!queue.isEmpty() && iterations < 1000) {
                ++iterations;
                CoralTrunk curTrunk = (CoralTrunk)queue.get(0);
                radius = curTrunk.centre.prev.size() > 40 ? 1 : Math.max(1, 2 - curTrunk.centre.prev.size() / 4);
                queue.remove(curTrunk);
                int roll = rand.nextInt(6);
                if (roll < 4 || curTrunk.centre.prev.size() < radius) {
                    CoralNode newCentre;
                    Vec3i newDir = curTrunk.dir;
                    if (!newDir.equals((Object)new Vec3i(0, 1, 0)) && rand.nextInt(3) == 0) {
                        newDir = new Vec3i(0, 1, 0);
                    }
                    if ((newCentre = CoralGenerator.getNodeAtLocation(map, curTrunk.centre.x + newDir.func_177958_n(), curTrunk.centre.y + newDir.func_177956_o(), curTrunk.centre.z + newDir.func_177952_p())) == null || curTrunk.centre.prev.contains(newCentre)) continue;
                    CoralTrunk newTrunk = new CoralTrunk(map, newCentre, radius, newDir);
                    int visitedCount = 0;
                    ArrayList checked = new ArrayList();
                    for (CoralNode trunkNode : newTrunk.nodes) {
                        if (!trunkNode.visited) continue;
                        ++visitedCount;
                    }
                    if ((visitedCount > 2 || radius <= 0) && (radius != 0 || visitedCount > 5)) continue;
                    newCentre.prev.clear();
                    newCentre.prev.addAll(curTrunk.centre.prev);
                    newCentre.prev.add(curTrunk.centre);
                    newTrunk.visit();
                    visited.addAll(newTrunk.nodes);
                    queue.add(newTrunk);
                    continue;
                }
                ArrayList<Vec3i> dirs = CoralGenerator.upDirs();
                dirs.remove(curTrunk.dir);
                Collections.shuffle(dirs);
                int num = 2;
                for (int i3 = 0; i3 < num; ++i3) {
                    Vec3i newDir = dirs.get(i3);
                    int mult = 1;
                    if (radius == 0) {
                        mult = 1;
                    }
                    int z = curTrunk.centre.z + newDir.func_177952_p() * mult;
                    CoralNode newCentre = CoralGenerator.getNodeAtLocation(map, curTrunk.centre.x + newDir.func_177958_n() * mult, curTrunk.centre.y + newDir.func_177956_o() * mult, curTrunk.centre.z + newDir.func_177952_p() * mult);
                    if (newCentre == null || curTrunk.centre.prev.contains(newCentre)) continue;
                    newCentre.prev.clear();
                    newCentre.prev.addAll(curTrunk.centre.prev);
                    newCentre.prev.add(curTrunk.centre);
                    CoralTrunk newTrunk = new CoralTrunk(map, newCentre, radius, newDir);
                    int visitedCount = 0;
                    ArrayList<CoralNode> checked = new ArrayList<CoralNode>();
                    for (CoralNode trunkNode : newTrunk.nodes) {
                        if (trunkNode.visited) {
                            ++visitedCount;
                        }
                        if (radius != 0) continue;
                        for (CoralNode neighbour : CoralGenerator.getCoralNeighbours(map, trunkNode)) {
                            if (neighbour == null || !neighbour.visited || checked.contains(neighbour)) continue;
                            ++visitedCount;
                            checked.add(neighbour);
                        }
                    }
                    if ((visitedCount > 2 || radius <= 0) && (radius != 0 || visitedCount > 5)) continue;
                    newTrunk.visit();
                    visited.addAll(newTrunk.nodes);
                    queue.add(newTrunk);
                }
            }
            int count = 0;
            boolean done = false;
            block8: for (i = 0; i < xSize; ++i) {
                for (int j = 0; j < ySize; ++j) {
                    for (int k = 0; k < zSize; ++k) {
                        CoralNode countNode = CoralGenerator.getNodeAtLocation(map, i, j, k);
                        if (!countNode.visited || ++count <= 20) continue;
                        done = true;
                        break block8;
                    }
                }
            }
            if (!done) {
                this.genTreeCoral(branchState, null, null, null, null, pos);
            } else {
                for (i = 0; i < xSize; ++i) {
                    for (int j = 0; j < ySize; ++j) {
                        for (int k = 0; k < zSize; ++k) {
                            CoralNode countNode = CoralGenerator.getNodeAtLocation(map, i, j, k);
                            if (!countNode.visited) continue;
                            this.world.func_175656_a(pos.func_177982_a(countNode.x - xSize / 2, countNode.y, countNode.z - zSize / 2), branchState);
                        }
                    }
                }
            }
            return;
        }
    }

    private static ArrayList<CoralNode> getCoralNeighbours(CoralNode[][][] map, CoralNode node) {
        ArrayList<CoralNode> neighbours = new ArrayList<CoralNode>();
        ArrayList<Vec3i> dirs = new ArrayList<Vec3i>();
        dirs.add(new Vec3i(0, 0, 1));
        dirs.add(new Vec3i(1, 0, 1));
        dirs.add(new Vec3i(-1, 0, 1));
        dirs.add(new Vec3i(1, 0, 0));
        dirs.add(new Vec3i(-1, 0, 0));
        dirs.add(new Vec3i(1, 1, 0));
        dirs.add(new Vec3i(-1, 1, 0));
        dirs.add(new Vec3i(1, -1, 0));
        dirs.add(new Vec3i(-1, -1, 0));
        dirs.add(new Vec3i(0, 1, 0));
        dirs.add(new Vec3i(0, -1, 0));
        dirs.add(new Vec3i(1, 0, -1));
        dirs.add(new Vec3i(-1, 0, -1));
        dirs.add(new Vec3i(0, 0, -1));
        dirs.add(new Vec3i(0, 1, 1));
        dirs.add(new Vec3i(1, 1, 1));
        dirs.add(new Vec3i(-1, 1, 1));
        dirs.add(new Vec3i(1, 1, -1));
        dirs.add(new Vec3i(-1, 1, -1));
        dirs.add(new Vec3i(0, 1, -1));
        dirs.add(new Vec3i(0, -1, 1));
        dirs.add(new Vec3i(1, -1, 1));
        dirs.add(new Vec3i(-1, -1, 1));
        dirs.add(new Vec3i(1, -1, -1));
        dirs.add(new Vec3i(-1, -1, -1));
        dirs.add(new Vec3i(0, -1, -1));
        for (Vec3i dir : dirs) {
            CoralNode neighbour = CoralGenerator.getNodeAtLocation(map, node.x + dir.func_177958_n(), node.y + dir.func_177956_o(), node.z + dir.func_177952_p());
            neighbours.add(neighbour);
        }
        return neighbours;
    }

    public void genBrainCoral(BlockPos pos) {
        if (!this.isTopBlock(pos.func_177977_b())) {
            return;
        }
        int pick = this.world.field_73012_v.nextInt(16);
        int secondPick = pick - 1 + this.world.field_73012_v.nextInt(3);
        if (secondPick < 0) {
            secondPick = 15;
        } else if (secondPick > 15) {
            secondPick = 0;
        }
        BlockState brain1 = BlockInit.patternedSmoothCoral.func_176203_a(pick);
        BlockState brain2 = BlockInit.patternedSmoothCoral.func_176203_a(secondPick);
        int radiusMax = 8;
        int radiusMin = 4;
        int radius = this.world.field_73012_v.nextInt(radiusMax - radiusMin + 1) + radiusMin;
        for (int i = -radius; i <= radius; ++i) {
            for (int k = -radius; k <= radius; ++k) {
                for (int j = (int)(-Math.round((double)radius / 1.5)); j <= (int)Math.round((double)radius / 1.5); ++j) {
                    int sqDist = i * i + (int)Math.round((double)(j * j) * 2.25) + k * k - radius * radius;
                    if (sqDist > 0) continue;
                    BlockPos place = pos.func_177982_a(i, j, k);
                    if (this.world.field_73012_v.nextBoolean()) {
                        this.world.func_175656_a(place, brain1);
                        continue;
                    }
                    this.world.func_175656_a(place, brain2);
                }
            }
        }
    }

    public void GenFlatTopCoral(BlockPos pos) {
        if (!this.isTopBlock(pos.func_177977_b())) {
            return;
        }
        int pick = 6 + this.world.field_73012_v.nextInt(4);
        BlockState stemState = BlockInit.darkRoughCoral.func_176203_a(pick);
        BlockState topState = BlockInit.roughCoral.func_176203_a(pick);
        int stemRadius = 2;
        int stemHeight = 4;
        int topRadiusMax = 15;
        int topRadiusMin = 8;
        Random rand = new Random();
        for (int i = -stemRadius - 1; i <= stemRadius + 1; ++i) {
            for (int j = 0; j < stemHeight; ++j) {
                for (int k = -stemRadius - 1; k <= stemRadius + 1; ++k) {
                    if (j == 0 || j == stemHeight - 1) {
                        if (i * i + k * k > (stemRadius + 1) * (stemRadius + 1)) continue;
                        this.world.func_175656_a(pos.func_177982_a(i, j, k), stemState);
                        continue;
                    }
                    if (i * i + k * k > stemRadius * stemRadius) continue;
                    this.world.func_175656_a(pos.func_177982_a(i, j, k), stemState);
                }
            }
        }
        int curRadius = rand.nextInt(topRadiusMax - topRadiusMin + 1) + topRadiusMin;
        int yOff = 0;
        for (int i = -topRadiusMax; i <= topRadiusMax; ++i) {
            for (int k = -topRadiusMax; k <= topRadiusMax; ++k) {
                yOff = i * i + k * k > curRadius * curRadius / 3 ? 2 : (i * i + k * k > curRadius * curRadius / 8 ? 1 : 0);
                if (i * i + k * k < curRadius * curRadius - curRadius - 2) {
                    this.world.func_175656_a(pos.func_177982_a(i, stemHeight + yOff, k), stemState);
                    continue;
                }
                if (i * i + k * k > curRadius * curRadius || i * i + k * k < curRadius * curRadius - curRadius - 2 || !rand.nextBoolean()) continue;
                this.world.func_175656_a(pos.func_177982_a(i, stemHeight + yOff, k), topState);
            }
        }
    }

    public void GenBulbCoral(BlockPos pos) {
        if (!this.isTopBlock(pos.func_177977_b())) {
            return;
        }
        Random rand = new Random();
        int pick = 6 + this.world.field_73012_v.nextInt(4);
        int radius = 10;
        BlockState stemState = BlockInit.smoothCoral.func_176203_a(pick);
        BlockState bulbState = BlockInit.patternedSmoothCoral.func_176203_a(pick);
        for (int i = -radius; i <= radius; ++i) {
            for (int k = -radius; k <= radius; ++k) {
                if (i * i + k * k > radius * radius || rand.nextInt(25) != 0) continue;
                this.GenBulb(pos.func_177982_a(i, 0, k), this.world, null, stemState, bulbState);
            }
        }
    }

    private void GenBulb(BlockPos pos, Level world, ArrayList<BlockPos> visited, BlockState stemState, BlockState bulbState) {
        if (!this.isTopBlock(pos.func_177977_b())) {
            return;
        }
        if (visited == null) {
            visited = new ArrayList();
        }
        int heightMin = 6;
        int heightMax = 10;
        int stemRadius = 1;
        int bulbRadius = 3;
        Random rand = new Random();
        int height = rand.nextInt(heightMax - heightMin + 1) + heightMin;
        Vec3i offset = new Vec3i(0, 0, 0);
        for (int j = 0; j < height; ++j) {
            int roll = rand.nextInt(6);
            switch (roll) {
                case 0: {
                    offset = new Vec3i(offset.func_177958_n() + 1, 0, offset.func_177952_p());
                    break;
                }
                case 1: {
                    offset = new Vec3i(offset.func_177958_n() - 1, 0, offset.func_177952_p());
                    break;
                }
                case 2: {
                    offset = new Vec3i(offset.func_177958_n(), 0, offset.func_177952_p() + 1);
                    break;
                }
                case 3: {
                    offset = new Vec3i(offset.func_177958_n() + 1, 0, offset.func_177952_p() - 1);
                }
            }
            for (int i = -stemRadius; i <= stemRadius; ++i) {
                for (int k = -stemRadius; k <= stemRadius; ++k) {
                    world.func_175656_a(pos.func_177982_a(i, j, k).func_177971_a(offset), stemState);
                    if (j <= height / 2) continue;
                    visited.add(pos.func_177982_a(i, j, k).func_177971_a(offset));
                }
            }
        }
        for (int i = -bulbRadius; i <= bulbRadius; ++i) {
            for (int j = -bulbRadius + 2; j <= bulbRadius; ++j) {
                for (int k = -bulbRadius; k <= bulbRadius; ++k) {
                    if (i * i + j * j + k * k >= bulbRadius * bulbRadius - 3) continue;
                    world.func_175656_a(pos.func_177971_a(offset).func_177982_a(i, j + height + 1, k), bulbState);
                    visited.add(pos.func_177971_a(offset).func_177982_a(i, j + height + 1, k));
                }
            }
        }
    }

    public void genSproutCoral(BlockPos pos) {
        if (!this.isTopBlock(pos.func_177977_b())) {
            return;
        }
        int pick = 6 + this.world.field_73012_v.nextInt(4);
        BlockState branchState = BlockInit.roughCoral.func_176203_a(pick);
        BlockState plateState = BlockInit.superRoughCoral.func_176203_a(pick);
        this.genSproutCoral(branchState, plateState, null, null, null, null, pos, this.world);
    }

    public void genSproutCoral(BlockState branchState, BlockState plateState, CoralNode[][][] map, CoralTrunk trunk, Vec3i dir, ArrayList<CoralNode> visited, BlockPos pos, Level world) {
        int radius = 3;
        Random rand = new Random();
        if (map == null) {
            int i;
            int minXZ = 20;
            int maxXZ = 30;
            int minY = 25;
            int maxY = 35;
            int xSize = rand.nextInt(maxXZ - minXZ + 1) + minXZ;
            int zSize = rand.nextInt(maxXZ - minXZ + 1) + minXZ;
            int ySize = rand.nextInt(maxY - minY + 1) + minY;
            map = new CoralNode[xSize][ySize][zSize];
            for (int i2 = 0; i2 < xSize; ++i2) {
                for (int j = 0; j < ySize; ++j) {
                    for (int k = 0; k < zSize; ++k) {
                        map[i2][j][k] = new CoralNode(i2, j, k);
                    }
                }
            }
            CoralNode node = CoralGenerator.getNodeAtLocation(map, xSize / 2, 0, zSize / 2);
            node.prev.clear();
            visited = new ArrayList();
            dir = new Vec3i(0, 1, 0);
            CoralTrunk next = new CoralTrunk(map, node, radius, dir);
            next.visit();
            visited.addAll(next.nodes);
            ArrayList<CoralTrunk> queue = new ArrayList<CoralTrunk>();
            queue.add(next);
            int iterations = 0;
            while (!queue.isEmpty() && iterations < 1000) {
                ++iterations;
                CoralTrunk curTrunk = (CoralTrunk)queue.get(0);
                if (rand.nextInt(4) == 0 && (double)curTrunk.centre.y > (double)ySize / 1.5) {
                    int plateRadius = rand.nextInt(3) + 2;
                    Vec3i offset = new Vec3i(rand.nextInt(3) - 1, 1, rand.nextInt(3) - 1);
                    for (int i3 = -plateRadius; i3 <= plateRadius; ++i3) {
                        for (int k = -plateRadius; k <= plateRadius; ++k) {
                            if (i3 * i3 + k * k > plateRadius * plateRadius) continue;
                            world.func_175656_a(pos.func_177982_a(curTrunk.centre.x + offset.func_177958_n() + i3 - xSize / 2, curTrunk.centre.y, curTrunk.centre.z + offset.func_177952_p() + k - zSize / 2), plateState);
                        }
                    }
                }
                radius = curTrunk.centre.prev.size() > 40 ? 1 : Math.max(1, 2 - curTrunk.centre.prev.size() / 4);
                queue.remove(curTrunk);
                int roll = rand.nextInt(6);
                if (roll < 4 || curTrunk.centre.prev.size() < radius) {
                    CoralNode newCentre;
                    Vec3i newDir = curTrunk.dir;
                    if (!newDir.equals((Object)new Vec3i(0, 1, 0)) && rand.nextInt(3) == 0) {
                        newDir = new Vec3i(0, 1, 0);
                    }
                    if ((newCentre = CoralGenerator.getNodeAtLocation(map, curTrunk.centre.x + newDir.func_177958_n(), curTrunk.centre.y + newDir.func_177956_o(), curTrunk.centre.z + newDir.func_177952_p())) == null || curTrunk.centre.prev.contains(newCentre)) continue;
                    CoralTrunk newTrunk = new CoralTrunk(map, newCentre, radius, newDir);
                    int visitedCount = 0;
                    ArrayList checked = new ArrayList();
                    for (CoralNode trunkNode : newTrunk.nodes) {
                        if (!trunkNode.visited) continue;
                        ++visitedCount;
                    }
                    if ((visitedCount > 2 || radius <= 0) && (radius != 0 || visitedCount > 5)) continue;
                    newCentre.prev.clear();
                    newCentre.prev.addAll(curTrunk.centre.prev);
                    newCentre.prev.add(curTrunk.centre);
                    newTrunk.visit();
                    visited.addAll(newTrunk.nodes);
                    queue.add(newTrunk);
                    continue;
                }
                ArrayList<Vec3i> dirs = CoralGenerator.upDirs();
                dirs.remove(curTrunk.dir);
                Collections.shuffle(dirs);
                int num = 2;
                for (int i4 = 0; i4 < num; ++i4) {
                    Vec3i newDir = dirs.get(i4);
                    int mult = 1;
                    if (radius == 0) {
                        mult = 1;
                    }
                    int z = curTrunk.centre.z + newDir.func_177952_p() * mult;
                    CoralNode newCentre = CoralGenerator.getNodeAtLocation(map, curTrunk.centre.x + newDir.func_177958_n() * mult, curTrunk.centre.y + newDir.func_177956_o() * mult, curTrunk.centre.z + newDir.func_177952_p() * mult);
                    if (newCentre == null || curTrunk.centre.prev.contains(newCentre)) continue;
                    newCentre.prev.clear();
                    newCentre.prev.addAll(curTrunk.centre.prev);
                    newCentre.prev.add(curTrunk.centre);
                    CoralTrunk newTrunk = new CoralTrunk(map, newCentre, radius, newDir);
                    int visitedCount = 0;
                    ArrayList<CoralNode> checked = new ArrayList<CoralNode>();
                    for (CoralNode trunkNode : newTrunk.nodes) {
                        if (trunkNode.visited) {
                            ++visitedCount;
                        }
                        if (radius != 0) continue;
                        for (CoralNode neighbour : CoralGenerator.getCoralNeighbours(map, trunkNode)) {
                            if (neighbour == null || !neighbour.visited || checked.contains(neighbour)) continue;
                            ++visitedCount;
                            checked.add(neighbour);
                        }
                    }
                    if ((visitedCount > 2 || radius <= 0) && (radius != 0 || visitedCount > 5)) continue;
                    newTrunk.visit();
                    visited.addAll(newTrunk.nodes);
                    queue.add(newTrunk);
                }
            }
            int count = 0;
            boolean done = false;
            block10: for (i = 0; i < xSize; ++i) {
                for (int j = 0; j < ySize; ++j) {
                    for (int k = 0; k < zSize; ++k) {
                        CoralNode countNode = CoralGenerator.getNodeAtLocation(map, i, j, k);
                        if (!countNode.visited || ++count <= 85) continue;
                        done = true;
                        break block10;
                    }
                }
            }
            if (!done) {
                this.genSproutCoral(branchState, plateState, null, null, null, null, pos, world);
            } else {
                for (i = 0; i < xSize; ++i) {
                    for (int j = 0; j < ySize; ++j) {
                        for (int k = 0; k < zSize; ++k) {
                            BlockPos check;
                            CoralNode countNode = CoralGenerator.getNodeAtLocation(map, i, j, k);
                            if (!countNode.visited || world.func_180495_p(check = pos.func_177982_a(countNode.x - xSize / 2, countNode.y, countNode.z - zSize / 2)) == plateState) continue;
                            world.func_175656_a(pos.func_177982_a(countNode.x - xSize / 2, countNode.y, countNode.z - zSize / 2), branchState);
                        }
                    }
                }
            }
            return;
        }
    }

    private class CoralTrunk {
        private ArrayList<CoralNode> nodes = new ArrayList();
        private int radius = 0;
        private CoralNode centre = null;
        private Vec3i dir = null;

        private CoralTrunk(CoralNode[][][] map, CoralNode centre, int radius, Vec3i dir) {
            this.centre = centre;
            this.radius = radius;
            this.dir = dir;
            if (radius == 0) {
                CoralNode node = CoralGenerator.getNodeAtLocation(map, centre.x + dir.func_177958_n(), centre.y + dir.func_177956_o(), centre.z + dir.func_177952_p());
                if (node != null) {
                    this.nodes.add(node);
                }
                return;
            }
            if (dir != null) {
                Vec3i upDir = null;
                Vec3i rightDir = null;
                if (dir.func_177958_n() != 0) {
                    upDir = new Vec3i(0, 1, 0);
                    rightDir = new Vec3i(0, 0, 1);
                } else if (dir.func_177956_o() != 0) {
                    upDir = new Vec3i(1, 0, 0);
                    rightDir = new Vec3i(0, 0, 1);
                } else if (dir.func_177952_p() != 0) {
                    upDir = new Vec3i(0, 1, 0);
                    rightDir = new Vec3i(1, 0, 0);
                }
                for (int i = -radius; i <= radius; ++i) {
                    for (int j = -radius; j <= radius; ++j) {
                        CoralNode node;
                        if (i * i + j * j > radius * radius || (node = CoralGenerator.getNodeAtLocation(map, centre.x + upDir.func_177958_n() * i + rightDir.func_177958_n() * j, centre.y + upDir.func_177956_o() * i + rightDir.func_177956_o() * j, centre.z + upDir.func_177952_p() * i + rightDir.func_177952_p() * j)) == null) continue;
                        this.nodes.add(node);
                    }
                }
            }
        }

        private void visit() {
            for (CoralNode node : this.nodes) {
                node.visited = true;
            }
        }
    }

    private class CoralNode {
        private int x = 0;
        private int y = 0;
        private int z = 0;
        private ArrayList<CoralNode> prev = new ArrayList();
        private boolean visited = false;

        private CoralNode(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.prev.clear();
        }
    }
}

