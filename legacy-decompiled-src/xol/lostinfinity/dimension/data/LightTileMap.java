/*
 * Decompiled with CFR 0.152.
 */
package xol.lostinfinity.dimension.data;

import java.util.List;
import java.util.Random;
import xol.lostinfinity.dimension.data.LightTileNode;

public class LightTileMap {
    private int col;
    private int row;
    private LightTileNode[][] lightTileGrid;

    public LightTileMap(int columns, int rows, int numSteps) {
        int y = 0;
        this.col = columns;
        this.row = rows;
        this.lightTileGrid = new LightTileNode[columns][rows];
        for (int i = 0; i < columns; ++i) {
            for (int j = 0; j < rows; ++j) {
                LightTileNode node;
                this.lightTileGrid[i][j] = node = new LightTileNode(i, y, j, true);
            }
        }
        Random rand = new Random();
        for (int k = 0; k < numSteps; ++k) {
            int randCol = rand.nextInt(this.col);
            int randRow = rand.nextInt(this.row);
            LightTileNode node = this.getNodeAtLocation(randCol, randRow);
            List<LightTileNode> neighbours = node.getNeighbours(this);
            node.toggle();
            for (LightTileNode n : neighbours) {
                n.toggle();
            }
        }
    }

    public LightTileNode getNodeAtLocation(int col, int row) {
        if (col < 0 || row < 0 || col >= this.col || row >= this.row) {
            return null;
        }
        return this.lightTileGrid[col][row];
    }
}

