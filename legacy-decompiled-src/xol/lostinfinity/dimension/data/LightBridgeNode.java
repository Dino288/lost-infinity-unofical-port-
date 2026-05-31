/*
 * Decompiled with CFR 0.152.
 */
package xol.lostinfinity.dimension.data;

import java.util.ArrayList;
import java.util.Collections;

public class LightBridgeNode {
    private int x;
    private int y;
    private boolean lit;

    public LightBridgeNode(int x, int y, boolean lit) {
        this.x = x;
        this.y = y;
        this.lit = lit;
    }

    public boolean isLit() {
        return this.lit;
    }

    public void setLit(boolean lit) {
        this.lit = lit;
    }

    public void toggle() {
        this.lit = !this.lit;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public ArrayList<LightBridgeNode> getNeighbours(LightBridgeNode[][] bridgeMap) {
        int y;
        ArrayList<LightBridgeNode> neighbours = new ArrayList<LightBridgeNode>();
        int x = this.getX();
        if (this.getNodeAtLocation(bridgeMap, x, (y = this.getY()) + 1) != null) {
            neighbours.add(this.getNodeAtLocation(bridgeMap, x, y + 1));
        }
        if (this.getNodeAtLocation(bridgeMap, x, y - 1) != null) {
            neighbours.add(this.getNodeAtLocation(bridgeMap, x, y - 1));
        }
        if (this.getNodeAtLocation(bridgeMap, x + 1, y) != null) {
            neighbours.add(this.getNodeAtLocation(bridgeMap, x + 1, y));
        }
        if (this.getNodeAtLocation(bridgeMap, x - 1, y) != null) {
            neighbours.add(this.getNodeAtLocation(bridgeMap, x - 1, y));
        }
        return neighbours;
    }

    public ArrayList<LightBridgeNode> getPathToNode(LightBridgeNode[][] bridgeMap, ArrayList<LightBridgeNode> visited, int y) {
        if (visited == null) {
            visited = new ArrayList();
        }
        visited.add(this);
        if (this.y == y) {
            return visited;
        }
        ArrayList<LightBridgeNode> neighbours = this.getNeighbours(bridgeMap);
        Collections.shuffle(neighbours);
        for (LightBridgeNode neighbour : neighbours) {
            boolean isLone = true;
            for (LightBridgeNode subNeighbour : neighbour.getNeighbours(bridgeMap)) {
                if (subNeighbour.equals(this) || !visited.contains(subNeighbour)) continue;
                isLone = false;
            }
            if (!isLone) continue;
            return neighbour.getPathToNode(bridgeMap, visited, y);
        }
        return null;
    }

    private LightBridgeNode getNodeAtLocation(LightBridgeNode[][] bridgeMap, int x, int y) {
        if (x >= 0 && x < bridgeMap.length && y >= 0 && y < bridgeMap[x].length) {
            return bridgeMap[x][y];
        }
        return null;
    }
}

