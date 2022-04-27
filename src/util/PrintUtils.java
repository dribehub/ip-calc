package util;

import calculator.IpAddress;

public class PrintUtils {

    public enum ANSI {

        NORMAL(0, false),
        RED(31, false),
        GREEN(32, false),
        YELLOW(33, false),
        BLUE(34, false),
        PURPLE(35, false),
        CYAN(36, false),
        NORMAL_BOLD(0, true),
        RED_BOLD(31, true),
        GREEN_BOLD(32, true),
        YELLOW_BOLD(33, true),
        BLUE_BOLD(34, true),
        PURPLE_BOLD(35, true),
        CYAN_BOLD(36, true);

        private final String code;

        ANSI(int code, boolean bold) {
            String boldFormat = "\u001b[%d;1m";
            String normalFormat = "\u001b[%dm";
            String format = bold ? boldFormat : normalFormat;
            this.code = String.format(format, code);
        }
    }

    public static String red(String str) {
        return ANSI.RED.code + str + ANSI.NORMAL.code;
    }

    public static String green(String str) {
        return ANSI.GREEN.code + str + ANSI.NORMAL.code;
    }

    public static String purple(IpAddress addr) {
        return ANSI.PURPLE.code + addr.getHostName() + ANSI.NORMAL.code;
    }

    public static String purple(String addr) {
        return ANSI.PURPLE.code + addr + ANSI.NORMAL.code;
    }

    public static void printHeader(String str) {
        System.out.println(ANSI.GREEN.code + str + ANSI.NORMAL.code);
    }
}
