/*
 * Decompiled with CFR 0.152.
 */
package xol.lostinfinity.dimension.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;
import xol.lostinfinity.dimension.data.MazeNode;

public class MazeMap {
    private MazeNode[][] map;
    private List<MazeNode> remaining_nodes = new ArrayList<MazeNode>();
    private Random rand = new Random();
    private static int startx = 0;
    private static int startz = 0;
    private static int wallPercent = 25;
    private static int triggerPercent = 4;
    private int numColumns;
    private int numRows;

    public MazeMap(int col, int row) {
        boolean min = true;
        int max = 100;
        this.map = new MazeNode[col][row];
        this.numColumns = col;
        this.numRows = row;
        for (int cnum = 0; cnum < col; ++cnum) {
            for (int rnum = 0; rnum < row; ++rnum) {
                int y = 0;
                MazeNode node = cnum % 2 == 0 ? (rnum % 2 == 0 ? new MazeNode("path", cnum, y, rnum) : new MazeNode("wall", cnum, y, rnum)) : (rnum % 2 == 0 ? new MazeNode("wall", cnum, y, rnum) : new MazeNode("path", cnum, y, rnum));
                this.map[cnum][rnum] = node;
            }
        }
        this.drawMap();
    }

    private void drawMap() {
        MazeNode startNode = this.getNodeAtLocation(startx, startz);
        int width = this.numColumns;
        int height = this.numRows;
        startNode.setVisited();
        Stack<MazeNode> pathStack = new Stack<MazeNode>();
        pathStack.push(startNode);
        while (!pathStack.empty()) {
            MazeNode cell = (MazeNode)pathStack.pop();
            List<MazeNode> neighbours = cell.getNeighbours(this);
            if (neighbours.isEmpty()) continue;
            int randIdx = (int)(Math.random() * (double)neighbours.size());
            for (int i = 0; i < neighbours.size(); ++i) {
                MazeNode neighbour = neighbours.get(i);
                MazeNode wall = cell.connect(neighbour, this);
                wall.setType("path");
                wall.setVisited();
                neighbour.setType("path");
                neighbour.setVisited();
                if (i == randIdx) continue;
                pathStack.push(neighbour);
            }
            pathStack.push(neighbours.get(randIdx));
        }
        for (int i = 0; i < width; ++i) {
            for (int j = 0; j < height; ++j) {
                int randInt = (int)(Math.random() * 100.0);
                MazeNode node = this.getNodeAtLocation(i, j);
                if (randInt >= 4 || !node.isVisited()) continue;
                node.setType("trigger");
            }
        }
    }

    public MazeNode getNodeAtLocation(int col, int row) {
        if (col < 0 || row < 0 || col >= this.numColumns || row >= this.numRows) {
            return null;
        }
        return this.map[col][row];
    }
}

