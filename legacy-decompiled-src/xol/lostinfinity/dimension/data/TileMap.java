/*
 * Decompiled with CFR 0.152.
 */
package xol.lostinfinity.dimension.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import xol.lostinfinity.dimension.data.TileNode;

public class TileMap {
    private TileNode[][] map;
    private List<TileNode> remaining_nodes = new ArrayList<TileNode>();
    private Random rand = new Random();
    private int winx;
    private int winz;
    private int numColumns;
    private int numRows;

    public TileMap(int col, int row, int winnerx, int winnerz, int style) {
        this.map = new TileNode[col][row];
        this.numColumns = col;
        this.numRows = row;
        this.winx = winnerx == -1 ? this.rand.nextInt(col) : winnerx;
        this.winz = winnerz == -1 ? this.rand.nextInt(row) : winnerz;
        for (int cnum = 0; cnum < col; ++cnum) {
            for (int rnum = 0; rnum < row; ++rnum) {
                TileNode node;
                boolean is_winner = false;
                if (cnum == this.winx && rnum == this.winz) {
                    is_winner = true;
                }
                this.map[cnum][rnum] = node = new TileNode(is_winner, cnum, this.getYfromXZStyle(cnum, rnum, style), rnum);
                this.remaining_nodes.add(node);
            }
        }
    }

    public TileNode getNodeAtLocation(int col, int row) {
        if (col < 0 || row < 0 || col >= this.numColumns || row >= this.numRows) {
            return null;
        }
        if (this.map[col][row].isDead()) {
            return null;
        }
        return this.map[col][row];
    }

    public int remainingTiles() {
        return this.remaining_nodes.size();
    }

    public TileNode randomLivingNode() {
        return this.remaining_nodes.get(this.rand.nextInt(this.remaining_nodes.size()));
    }

    public List<TileNode> removeTiles(int numRemove) {
        ArrayList<TileNode> removedNodes = new ArrayList<TileNode>();
        for (int i = 0; i < numRemove; ++i) {
            boolean didRemove = false;
            TileNode node = null;
            for (int attempts = 0; !didRemove && attempts < 10; ++attempts) {
                if (attempts >= 10) continue;
                boolean foundNode = false;
                while (!foundNode) {
                    node = this.randomLivingNode();
                    if (node == null || node.isDead() || node.isWinnerNode()) continue;
                    foundNode = true;
                }
                boolean safeKill = true;
                for (TileNode neighbour : node.getNeighbours(this)) {
                    if (neighbour == null) continue;
                    ArrayList<TileNode> checked = new ArrayList<TileNode>();
                    checked.add(node);
                    if (neighbour.nodeHasPath(checked, this)) continue;
                    safeKill = false;
                }
                if (!safeKill) continue;
                node.setDead();
                didRemove = true;
                removedNodes.add(node);
                this.remaining_nodes.remove(node);
            }
        }
        return removedNodes;
    }

    private int getYfromXZStyle(int xline, int zline, int style) {
        int yheight = 28;
        switch (style) {
            case 0: {
                break;
            }
            case 1: {
                if (xline % 2 != 1 && zline % 2 != 1) break;
                ++yheight;
                break;
            }
            case 2: {
                int xdiff = Math.abs(3 - xline);
                int zdiff = Math.abs(3 - zline);
                if (xdiff > zdiff) {
                    yheight = 28 + xdiff;
                    break;
                }
                yheight = 28 + zdiff;
                break;
            }
            case 3: {
                int xdiff = Math.abs(3 - xline);
                int zdiff = Math.abs(3 - zline);
                if (xdiff > zdiff) {
                    yheight = 31 - xdiff;
                    break;
                }
                yheight = 31 - zdiff;
                break;
            }
            case 4: {
                yheight += xline;
            }
        }
        return yheight;
    }
}

