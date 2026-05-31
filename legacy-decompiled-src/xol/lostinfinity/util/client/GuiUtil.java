/*
 * Decompiled with CFR 0.152.
 */
package xol.lostinfinity.util.client;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GuiUtil {
    public static boolean isInRect(int x, int y, int xSize, int ySize, int mouseX, int mouseY) {
        return mouseX >= x && mouseX <= x + xSize && mouseY >= y && mouseY <= y + ySize;
    }

    public static List<String> getHoverText(String ... text) {
        return new ArrayList<String>(Arrays.asList(text));
    }

    public static int getCurrentBarSize(int barSize, int currentProgress, int maxProgress, int minProgress) {
        return (int)((float)barSize * ((float)(currentProgress - minProgress) / (float)(maxProgress - minProgress)));
    }
}

