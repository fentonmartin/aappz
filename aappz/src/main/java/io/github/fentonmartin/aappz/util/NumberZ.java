package io.github.fentonmartin.aappz.util;

import java.util.Date;

@SuppressWarnings({"unused"})
public class NumberZ {

    /**
     * Get random integer number
     *
     * @return the result
     */
    public static int getRandom() {
        return (int) ((new Date().getTime() / 1000L) % Integer.MAX_VALUE);
    }

    /**
     * Get hexadecimal formatted string
     *
     * @param number is inputted number to convert
     * @return hexadecimal string
     */
    public static String toHex(int number) {
        return Integer.toHexString(number);
    }

    /**
     * Get hexadecimal formatted string
     *
     * @param number is inputted number to convert
     * @return hexadecimal string
     */
    public static String toHex(long number) {
        return Long.toHexString(number);
    }

    /**
     * Get octal formatted string
     *
     * @param number is inputted number to convert
     * @return octal string
     */
    public static String toOctal(int number) {
        return Integer.toOctalString(number);
    }

    /**
     * Get octal formatted string
     *
     * @param number is inputted number to convert
     * @return octal string
     */
    public static String toOctal(long number) {
        return Long.toOctalString(number);
    }

    /**
     * Get binary formatted string
     *
     * @param number is inputted number to convert
     * @return binary string
     */
    public static String toBinary(int number) {
        return Integer.toBinaryString(number);
    }

    /**
     * Get binary formatted string
     *
     * @param number is inputted number to convert
     * @return binary string
     */
    public static String toBinary(long number) {
        return Long.toBinaryString(number);
    }
}
