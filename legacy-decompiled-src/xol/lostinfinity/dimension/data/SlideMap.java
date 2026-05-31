/*
 * Decompiled with CFR 0.152.
 */
package xol.lostinfinity.dimension.data;

import java.util.List;
import java.util.Random;
import xol.lostinfinity.dimension.data.SlideNode;

public class SlideMap {
    private int col;
    private int row;
    private SlideNode[][] slideNodeGrid;
    private SlideNode empty;

    public SlideMap(int columns, int rows, int numSteps) {
        int y = 0;
        this.col = columns;
        this.row = rows;
        this.slideNodeGrid = new SlideNode[columns][rows];
        int count = 0;
        for (int i = 0; i < columns; ++i) {
            for (int j = 0; j < rows; ++j) {
                SlideNode node;
                this.slideNodeGrid[i][j] = node = new SlideNode(i, y, j, count);
                ++count;
            }
        }
        this.empty = this.getNodeAtLocation(0, 0);
        this.empty.setEmpty(true);
        Random rand = new Random();
        for (int k = 0; k < numSteps; ++k) {
            List<SlideNode> neighbours = this.empty.getNeighbours(this);
            int randTile = rand.nextInt(neighbours.size());
            SlideNode nodeToSwap = neighbours.get(randTile);
            this.empty.setEmpty(false);
            this.empty.setTileNum(nodeToSwap.getTileNum());
            this.empty = nodeToSwap;
            nodeToSwap.setEmpty(true);
            nodeToSwap.setTileNum(0);
        }
    }

    public SlideMap(int columns, int rows, int numSteps, int emptyTileNum) {
        int y = 0;
        this.col = columns;
        this.row = rows;
        this.slideNodeGrid = new SlideNode[columns][rows];
        int count = 0;
        for (int i = 0; i < columns; ++i) {
            for (int j = 0; j < rows; ++j) {
                SlideNode node;
                this.slideNodeGrid[i][j] = node = new SlideNode(i, y, j, count);
                if (count == emptyTileNum) {
                    this.empty = this.getNodeAtLocation(i, j);
                    this.empty.setEmpty(true);
                }
                ++count;
            }
        }
        Random rand = new Random();
        for (int k = 0; k < numSteps; ++k) {
            List<SlideNode> neighbours = this.empty.getNeighbours(this);
            int randTile = rand.nextInt(neighbours.size());
            SlideNode nodeToSwap = neighbours.get(randTile);
            this.empty.setEmpty(false);
            this.empty.setTileNum(nodeToSwap.getTileNum());
            this.empty = nodeToSwap;
            nodeToSwap.setEmpty(true);
            nodeToSwap.setTileNum(0);
        }
    }

    public SlideNode getNodeAtLocation(int col, int row) {
        if (col < 0 || row < 0 || col >= this.col || row >= this.row) {
            return null;
        }
        return this.slideNodeGrid[col][row];
    }
}

