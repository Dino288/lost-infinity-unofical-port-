/*
 * Decompiled with CFR 0.152.
 */
package xol.lostinfinity.dimension.data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;
import xol.lostinfinity.dimension.data.LabPathNode;

public class LabPathGenerator {
    private LabPathNode[][] pathMap;

    /*
     * WARNING - void declaration
     */
    public LabPathGenerator(int rows, int columns) {
        Random rand = new Random();
        boolean complete = false;
        while (!complete) {
            int connectedCount = 0;
            this.pathMap = new LabPathNode[columns][rows];
            for (int i = 0; i < columns; ++i) {
                for (int j = 0; j < rows; ++j) {
                    this.pathMap[i][j] = new LabPathNode(i, j);
                }
            }
            ArrayList<ArrayList<LabPathNode>> doors = new ArrayList<ArrayList<LabPathNode>>();
            ArrayList<LabPath> paths = new ArrayList<LabPath>();
            doors.add(this.get2x2(0, 6));
            doors.add(this.get2x2(6, 0));
            doors.add(this.get2x2(12, 6));
            doors.add(this.get2x2(6, 12));
            Collections.shuffle(doors);
            for (ArrayList arrayList : doors) {
                LabPathGenerator.visit(arrayList);
            }
            int numDeadEnds = 0;
            boolean bl = false;
            ArrayList<Integer> needsConnection = new ArrayList<Integer>();
            needsConnection.add(0);
            needsConnection.add(1);
            needsConnection.add(2);
            needsConnection.add(3);
            for (int i = 0; i < 4; ++i) {
                ArrayList<Integer> connectedDoors = new ArrayList<Integer>();
                int startDoor = i;
                boolean isDeadEnd = rand.nextBoolean();
                if (isDeadEnd && numDeadEnds <= 2) {
                    paths.add(new LabPath(connectedDoors, true, startDoor));
                    ++numDeadEnds;
                    continue;
                }
                int numConnected = rand.nextInt(3);
                for (int j = 0; j < numConnected; ++j) {
                    if (needsConnection.isEmpty()) continue;
                    if (needsConnection.size() == 1 && (Integer)needsConnection.get(0) == startDoor) break;
                    int randDoor = (Integer)needsConnection.get(rand.nextInt(needsConnection.size()));
                    while (randDoor == startDoor) {
                        randDoor = (Integer)needsConnection.get(rand.nextInt(needsConnection.size()));
                    }
                    connectedDoors.add(randDoor);
                    ++connectedCount;
                    needsConnection.remove(needsConnection.indexOf(randDoor));
                }
                if (connectedDoors.size() > 1) {
                    paths.add(new LabPath(connectedDoors, true, startDoor));
                    continue;
                }
                if (numDeadEnds > 2) break;
                paths.add(new LabPath(connectedDoors, false, startDoor));
                ++numDeadEnds;
            }
            if (numDeadEnds < 2 && connectedCount < 2) {
                System.out.println("Failed");
            }
            for (LabPath path : paths) {
                ArrayList<Integer> connectedDoors = path.getConnectedDoors();
                ArrayList<LabPathNode> doorNodes = path.getDoorNodes();
                ArrayList<LabPathNode> endNodes = path.getEndNodes();
                ArrayList<LabPathNode> visited = path.getVisited();
                for (int connectedDoor : connectedDoors) {
                    ArrayList door = (ArrayList)doors.get(connectedDoor);
                    if (door == null) continue;
                    doorNodes.addAll(door);
                }
                endNodes.addAll((Collection)doors.get(path.getStartDoor()));
                visited.addAll((Collection)doors.get(path.getStartDoor()));
                LabPathGenerator.visit((ArrayList)doors.get(path.getStartDoor()));
                boolean end = true;
                if (!this.drawPath(path)) {
                    end = false;
                }
                if (!end) continue;
                complete = true;
            }
        }
    }

    private boolean drawPath(LabPath path) {
        ArrayList<LabPathNode> endNodes = path.getEndNodes();
        ArrayList<LabPathNode> visited = path.getVisited();
        ArrayList<LabPathNode> doorNodes = path.getDoorNodes();
        boolean pathComplete = false;
        int iterations = 0;
        while (!pathComplete && iterations < 20) {
            ++iterations;
            Collections.shuffle(endNodes);
            LabPathNode toAdd = null;
            ArrayList<LabPathNode> check = null;
            for (LabPathNode node : endNodes) {
                block2: for (int i = 0; i < 2; ++i) {
                    for (int j = 0; j < 2; ++j) {
                        check = this.get2x2(i + node.getX(), j + node.getZ());
                        boolean connected = false;
                        boolean canAdd = true;
                        for (LabPathNode subNode : check) {
                            if (subNode != null) {
                                ArrayList<LabPathNode> adjacents = this.getAdjacents(subNode);
                                for (LabPathNode adjacent : adjacents) {
                                    if (adjacent == null || visited.contains(adjacent) || !adjacent.visited() || doorNodes.contains(adjacent)) continue;
                                    canAdd = false;
                                    break;
                                }
                                if (endNodes.contains(subNode)) {
                                    connected = true;
                                    continue;
                                }
                                if (!visited.contains(subNode) || !subNode.visited()) continue;
                                canAdd = false;
                                break;
                            }
                            canAdd = false;
                            break;
                        }
                        if (!connected || !canAdd) continue;
                        toAdd = this.getNodeAtLocation(i + node.getX(), j + node.getZ());
                        break block2;
                    }
                }
                if (toAdd == null) continue;
                break;
            }
            if (toAdd == null || check == null) continue;
            ArrayList<LabPathNode> toRemove = new ArrayList<LabPathNode>();
            for (LabPathNode node : check) {
                if (endNodes.contains(node)) {
                    toRemove.add(node);
                }
                if (!doorNodes.contains(node)) continue;
                pathComplete = true;
            }
            check.removeAll(toRemove);
            LabPathGenerator.visit(check);
            endNodes.clear();
            endNodes.addAll(check);
            visited.addAll(check);
            if (!pathComplete) continue;
            return true;
        }
        return false;
    }

    private ArrayList<LabPathNode> getAdjacents(LabPathNode subNode) {
        ArrayList<LabPathNode> adjacents = new ArrayList<LabPathNode>();
        adjacents.add(this.getNodeAtLocation(subNode.getX() + 1, subNode.getZ()));
        adjacents.add(this.getNodeAtLocation(subNode.getX(), subNode.getZ() + 1));
        adjacents.add(this.getNodeAtLocation(subNode.getX(), subNode.getZ() - 1));
        adjacents.add(this.getNodeAtLocation(subNode.getX() - 1, subNode.getZ()));
        return adjacents;
    }

    public static void visit(ArrayList<LabPathNode> nodes) {
        for (LabPathNode node : nodes) {
            if (node == null) continue;
            node.setVisited();
        }
    }

    public static void main(String[] args) {
        int c = 14;
        int r = 14;
        LabPathGenerator pathMap = new LabPathGenerator(c, r);
        for (int i = 0; i < c; ++i) {
            for (int j = 0; j < r; ++j) {
                LabPathNode node = pathMap.getNodeAtLocation(j, i);
                if (node == null) continue;
                boolean visited = node.visited();
                if (visited) {
                    System.out.print("[]");
                    continue;
                }
                System.out.print("{}");
            }
            System.out.print("\r\n");
        }
    }

    public LabPathNode getNodeAtLocation(int i, int j) {
        if (this.pathMap != null && i >= 0 && j >= 0 && this.pathMap.length > i && this.pathMap[i].length > j) {
            return this.pathMap[i][j];
        }
        return null;
    }

    private ArrayList<LabPathNode> get2x2(int i, int j) {
        ArrayList<LabPathNode> nodes = new ArrayList<LabPathNode>();
        nodes.add(this.getNodeAtLocation(i, j));
        nodes.add(this.getNodeAtLocation(i + 1, j));
        nodes.add(this.getNodeAtLocation(i, j + 1));
        nodes.add(this.getNodeAtLocation(i + 1, j + 1));
        return nodes;
    }

    private class LabPath {
        ArrayList<LabPathNode> endNodes;
        ArrayList<LabPathNode> visited = new ArrayList();
        ArrayList<LabPathNode> doorNodes;
        ArrayList<Integer> connectedDoors;
        int startDoor;
        boolean isDeadEnd;

        public LabPath(ArrayList<Integer> connectedDoors, boolean isDeadEnd, int startDoor) {
            this.endNodes = new ArrayList();
            this.doorNodes = new ArrayList();
            this.startDoor = startDoor;
            this.connectedDoors = connectedDoors;
            this.isDeadEnd = isDeadEnd;
        }

        public int getStartDoor() {
            return this.startDoor;
        }

        public ArrayList<LabPathNode> getDoorNodes() {
            return this.doorNodes;
        }

        public void setDoorNodes(ArrayList<LabPathNode> doorNodes) {
            this.doorNodes = doorNodes;
        }

        public void setEndNodes(ArrayList<LabPathNode> endNodes) {
            this.endNodes = endNodes;
        }

        public ArrayList<LabPathNode> getEndNodes() {
            return this.endNodes;
        }

        public void setVisited(ArrayList<LabPathNode> visited) {
            this.visited = visited;
        }

        public ArrayList<LabPathNode> getVisited() {
            return this.visited;
        }

        public void addVisited(LabPathNode node) {
            if (this.visited != null) {
                this.visited.add(node);
            }
        }

        public boolean isDeadEnd() {
            return this.isDeadEnd;
        }

        public ArrayList<Integer> getConnectedDoors() {
            return this.connectedDoors;
        }
    }
}
