package io.github.fentonmartin.aappz.util;

import android.annotation.SuppressLint;

import java.text.SimpleDateFormat;
import java.util.Date;

import io.github.fentonmartin.aappz.constant.DateConstant;

@SuppressLint("SimpleDateFormat")
@SuppressWarnings({"WeakerAccess", "unused"})
public class DateZ {

    /**
     * Get date time string with 'yyyy-MM-dd HH:mm:ss' format
     */
    public static String getDatetime() {
        return new SimpleDateFormat(DateConstant.DATE_FULL).format(new Date());
    }

    /**
     * Get date time string with pattern format
     *
     * @param pattern the target pattern (See: DateConstant)
     */
    public static String getDatetime(String pattern) {
        return new SimpleDateFormat(pattern).format(new Date());
    }

    /**
     * Get date time string with simple default format
     */
    public static String getDatetimeSimple() {
        return new SimpleDateFormat().format(new Date());
    }

    /**
     * Get timestamp long from current time
     */
    public static long getTimestamp() {
        return new Date().getTime();
    }

    /**
     * Get timestamp string from current timestamp
     */
    public static String getTimestampString() {
        return String.valueOf(getTimestamp());
    }

    /**
     * Get 'yyyy-MM-dd HH:mm:ss' string from inputted time
     *
     * @param timestamp the inputted long timestamp
     */
    public static String getTimestampTime(long timestamp) {
        return new SimpleDateFormat(DateConstant.DATE_FULL).format(new Date(timestamp));
    }

    /**
     * Get 'yyyy-MM-dd HH:mm:ss' string from inputted time
     *
     * @param timestamp the inputted string timestamp
     */
    public static String getTimestampTime(String timestamp) {
        return getTimestampTime(Long.parseLong(timestamp));
    }

    /**
     * Get pattern time string from inputted time
     *
     * @param pattern   the target pattern (See: DateConstant)
     * @param timestamp the inputted long timestamp
     */
    public static String getTimestampTime(String pattern, long timestamp) {
        return new SimpleDateFormat(pattern).format(new Date(timestamp));
    }

    /**
     * Get pattern time string from inputted time
     *
     * @param pattern   the target pattern (See: DateConstant)
     * @param timestamp the inputted string timestamp
     */
    public static String getTimestampTime(String pattern, String timestamp) {
        return getTimestampTime(pattern, Long.parseLong(timestamp));
    }
}
