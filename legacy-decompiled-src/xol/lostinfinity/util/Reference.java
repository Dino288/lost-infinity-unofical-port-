/*
 * Decompiled with CFR 0.152.
 */
package xol.lostinfinity.util;

public class Reference {
    public static final String MODID = "lostinfinity";
    public static final String NAME = "Lost Infinity Stones";
    public static final String VERSION = "1.15.4";
    public static final String CLIENT = "xol.lostinfinity.common.ClientProxy";
    public static final String COMMON = "xol.lostinfinity.common.CommonProxy";

    public static int getDecimalColorFromRGB(int r, int g, int b) {
        int R = Math.min(r, 255);
        int G = Math.min(g, 255);
        int B = Math.min(b, 255);
        R = R << 16 & 0xFF0000;
        G = G << 8 & 0xFF00;
        return 0xFF000000 | R | G | (B &= 0xFF);
    }
}

