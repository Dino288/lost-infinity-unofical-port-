/*
 * Decompiled with CFR 0.152.
 */
package xol.lostinfinity.dimension.data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import xol.lostinfinity.dimension.data.TetrisNode;

public class TetrisMap {
    private TetrisNode[][] map;
    private Random rand = new Random();
    private int numColumns;
    private int numRows;
    private static int[][][] linePiece = new int[][][]{new int[][]{{0, 1, 2, 3}, {0, 0, 0, 0}}, new int[][]{{0, 0, 0, 0}, {0, 1, 2, 3}}};
    private static int[][][] lPiece = new int[][][]{new int[][]{{0, 1, 2, 2}, {0, 0, 0, 1}}, new int[][]{{0, 0, 0, 1}, {0, 1, 2, 2}}, new int[][]{{0, 0, 0, -1}, {0, 1, 2, 2}}, new int[][]{{-1, 0, 0, 0}, {0, 0, 1, 2}}, new int[][]{{1, 0, 0, 0}, {0, 0, 1, 2}}, new int[][]{{0, 1, 2, 2}, {0, 0, 0, -1}}, new int[][]{{0, 0, 1, 2}, {-1, 0, 0, 0}}, new int[][]{{0, 0, 1, 2}, {1, 0, 0, 0}}};
    private static int[][][] tPiece = new int[][][]{new int[][]{{0, 1, 1, 2}, {0, 0, -1, 0}}, new int[][]{{0, 1, 1, 1}, {0, 1, 0, -1}}, new int[][]{{0, 0, 0, 1}, {1, 0, -1, 0}}, new int[][]{{0, 1, 1, 2}, {0, 0, 1, 0}}};
    private static int[][][] zigPiece = new int[][][]{new int[][]{{0, 0, 1, 1}, {-1, 0, 0, 1}}, new int[][]{{1, 1, 0, 0}, {1, 0, 0, -1}}, new int[][]{{0, 1, 1, 2}, {0, 0, 1, 1}}, new int[][]{{0, 1, 1, 2}, {0, 0, -1, -1}}};
    private static int[][][] squarePiece = new int[][][]{new int[][]{{0, 0, 1, 1}, {0, 1, 0, 1}}};
    private static final Random random = new Random();
    private List<int[][][]> pieceCollection = new ArrayList<int[][][]>();
    private int complexity;
    private List<TetrisNode> activeNodes = new ArrayList<TetrisNode>();
    private static int startx = 0;
    private static int startz = 0;
    private int[] pieceList = null;
    private static int[][] combinationsFactor4 = new int[][]{{1, 1, 2, 0, 0}, {1, 2, 0, 0, 1}, {2, 0, 0, 0, 2}, {2, 2, 0, 0, 0}, {0, 2, 0, 0, 2}, {0, 1, 2, 1, 0}, {1, 2, 0, 1, 0}};

    public TetrisMap(int n, int m) {
        this.pieceCollection.add(linePiece);
        this.pieceCollection.add(lPiece);
        this.pieceCollection.add(tPiece);
        this.pieceCollection.add(zigPiece);
        this.pieceCollection.add(squarePiece);
        this.map = new TetrisNode[n][m];
        this.numColumns = n;
        this.numRows = m;
        for (int cnum = 0; cnum < n; ++cnum) {
            for (int rnum = 0; rnum < m; ++rnum) {
                TetrisNode node;
                this.map[cnum][rnum] = node = new TetrisNode(cnum, rnum);
            }
        }
        if (n % 4 == 0 && m % 4 == 0) {
            this.pieceList = this.generate4FactorPieceList(n, m);
        }
    }

    public int[] getPieceList() {
        return this.pieceList;
    }

    public static void main(String[] args) {
        TetrisMap map = new TetrisMap(4, 8);
    }

    private int[] generate4FactorPieceList(int n, int m) {
        int[] pieceList = new int[5];
        ArrayList<int[]> combinationList = new ArrayList<int[]>();
        for (int i = 0; i < combinationsFactor4.length; ++i) {
            combinationList.add(combinationsFactor4[i]);
        }
        Collections.shuffle(combinationList);
        int picksLeft = n / 4 * (m / 4);
        for (int i = 0; i < combinationList.size(); ++i) {
            int picks = this.rand.nextInt(picksLeft + 1);
            picksLeft -= picks;
            int[] comb = (int[])combinationList.get(i);
            for (int j = 0; j < comb.length; ++j) {
                int n2 = j;
                pieceList[n2] = pieceList[n2] + comb[j] * picks;
            }
            if (picksLeft <= 0) break;
        }
        return pieceList;
    }

    public TetrisNode[][] getGrid() {
        return this.map;
    }

    public int getCol() {
        return this.numColumns;
    }

    public int getRow() {
        return this.numRows;
    }

    public List<TetrisNode> getNodesAtOrientation(int i, int j, int[][] orientation) {
        ArrayList<TetrisNode> nodes = new ArrayList<TetrisNode>();
        for (int k = 0; k < 4; ++k) {
            int x = orientation[0][k];
            int z = orientation[1][k];
            TetrisNode node = this.getNodeAtLocation(i + x, j + z);
            nodes.add(node);
        }
        return nodes;
    }

    public TetrisNode getNodeAtLocation(int col, int row) {
        if (col < 0 || row < 0 || col >= this.numColumns || row >= this.numRows) {
            return null;
        }
        return this.map[col][row];
    }
}

