/*
 * Decompiled with CFR 0.152.
 */
package xol.lostinfinity.client;

public enum TextFmt {
    Black('0'),
    Dark_Blue('1'),
    Dark_Green('2'),
    Dark_Aqua('3'),
    Dark_Red('4'),
    Dark_Purple('5'),
    Gold('6'),
    Gray('7'),
    Dark_Gray('8'),
    Blue('9'),
    Green('a'),
    Aqua('b'),
    Red('c'),
    Light_Purple('d'),
    Yellow('e'),
    White('f'),
    Obfuscated('k'),
    Bold('l'),
    Strikethrough('m'),
    Underline('n'),
    Italic('o'),
    Reset('r');

    protected final char ch;

    private TextFmt(char ch) {
        this.ch = ch;
    }

    public static String getFormatting(TextFmt ... fmt) {
        StringBuilder builder = new StringBuilder();
        for (TextFmt fmts : fmt) {
            builder.append(fmts.toString());
        }
        return builder.toString();
    }

    public static String format(String str) {
        return str.replace("&", "\u00a7");
    }

    public String toString() {
        return "\u00a7" + this.ch;
    }
}

