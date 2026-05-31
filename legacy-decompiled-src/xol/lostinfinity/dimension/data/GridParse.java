/*
 * Decompiled with CFR 0.152.
 */
package xol.lostinfinity.dimension.data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import xol.lostinfinity.dimension.data.GridNode;

public class GridParse {
    public static String grid_file = "";
    private GridNode[][] grid;
    private int max_rows = 0;
    private int max_columns = 0;

    public GridParse(String path) {
        grid_file = "assets/lostinfinity/structures/predefined/" + path;
        this.ParseGridFile(grid_file);
    }

    private void ParseGridFile(String grid_file_location) {
        try {
            this.max_rows = this.rowCount();
            this.max_columns = this.columnCount();
            this.grid = new GridNode[this.max_rows][this.max_columns];
            BufferedReader readIn = new BufferedReader(new InputStreamReader(this.getClass().getClassLoader().getResourceAsStream(grid_file_location), "UTF-8"));
            int row = 0;
            String data = null;
            while ((data = readIn.readLine()) != null) {
                String[] values = data.split(",");
                for (int column = 0; column < values.length; ++column) {
                    GridNode node;
                    if (values[column].isEmpty()) continue;
                    String[] dataPair = values[column].split(":");
                    String pieceType = dataPair[0];
                    int rotation = 0;
                    rotation = Integer.parseInt(dataPair[1]);
                    int yOffset = 0;
                    if (dataPair.length > 2) {
                        yOffset = Integer.parseInt(dataPair[2]);
                    }
                    this.grid[row][column] = node = new GridNode(pieceType, rotation, yOffset);
                }
                ++row;
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    private int rowCount() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(this.getClass().getClassLoader().getResourceAsStream(grid_file), "UTF-8"));
            int lines = 0;
            while (reader.readLine() != null) {
                ++lines;
            }
            reader.close();
            return lines;
        }
        catch (IOException e) {
            e.printStackTrace();
            return -1;
        }
    }

    private int columnCount() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(this.getClass().getClassLoader().getResourceAsStream(grid_file), "UTF-8"));
            String line = reader.readLine();
            reader.close();
            int numberOfColumns = line.replaceAll("[^,]", "").length();
            return numberOfColumns + 1;
        }
        catch (IOException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public GridNode getNodeAtLocation(int x, int y, int offset_x, int offset_y) {
        try {
            if (this.grid[this.max_rows - 1 - x + offset_x][y + offset_y] == null) {
                return null;
            }
            return this.grid[this.max_rows - 1 - x + offset_x][y + offset_y];
        }
        catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    public GridNode[][] getGrid() {
        return this.grid;
    }
}

