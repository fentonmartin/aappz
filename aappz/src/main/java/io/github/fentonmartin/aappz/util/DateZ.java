package io.github.fentonmartin.aappz.util;

import android.annotation.SuppressLint;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@SuppressLint("SimpleDateFormat")
@SuppressWarnings({"WeakerAccess", "unused"})
public class DateZ {

    /* DateTime ----------------------------------------------------------------------------------*/

    /**
     * Get date class from inputted string
     *
     * @param pattern the target pattern (See: DateZ)
     * @param text    the string timestamp
     * @return the result
     */
    public static Date getDateFrom(String pattern, String text) {
        try {
            SimpleDateFormat format = new SimpleDateFormat(pattern);
            return format.parse(text);
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     * Get date time string with 'yyyy-MM-dd HH:mm:ss' format
     *
     * @return the result
     */
    public static String getDateTime() {
        return new SimpleDateFormat(DateZ.DATE_FULL).format(new Date());
    }

    /**
     * Get date time string with Locale.getDefault format
     *
     * @param pattern the target pattern (See: DateZ)
     * @return the result
     */
    public static String getDateTime(String pattern) {
        return new SimpleDateFormat(pattern).format(new Date());
    }

    /**
     * Get date time string with 'EEE, MMM d, yyyy HH:mm' format
     *
     * @return the result
     */
    public static String getDateTimeFull() {
        return new SimpleDateFormat(DateZ.CUSTOM_24).format(new Date());
    }

    /**
     * Get date time string with simple default format
     *
     * @return the result
     */
    public static String getDateTimeSimple() {
        return new SimpleDateFormat().format(new Date());
    }

    /* DateHex -----------------------------------------------------------------------------------*/

    /**
     * Get date time hex from current timestamp
     *
     * @return the result
     */
    public static String getDateHex() {
        return NumberZ.toHex(getTimestamp());
    }

    /**
     * Get date time from hex timestamp
     *
     * @param hex the hex timestamp
     * @return the result
     */
    public static String getDateHexFrom(String hex) {
        return getTimestamp(NumberZ.fromHex(hex));
    }

    /* Timestamp ---------------------------------------------------------------------------------*/

    /**
     * Get timestamp long from current time
     *
     * @return the result
     */
    public static long getTimestamp() {
        return new Date().getTime();
    }

    /**
     * Get timestamp string from current timestamp
     *
     * @return the result
     */
    public static String getTimestampString() {
        return String.valueOf(getTimestamp());
    }

    /**
     * Get 'yyyy-MM-dd HH:mm:ss' string from inputted time
     *
     * @param timestamp the inputted long timestamp
     * @return the result
     */
    public static String getTimestamp(long timestamp) {
        return new SimpleDateFormat(DateZ.DATE_FULL).format(new Date(timestamp));
    }

    /**
     * Get 'yyyy-MM-dd HH:mm:ss' string from inputted time
     *
     * @param timestamp the inputted string timestamp
     * @return the result
     */
    public static String getTimestamp(String timestamp) {
        return getTimestamp(Long.parseLong(timestamp));
    }

    /**
     * Get pattern time string from inputted time
     *
     * @param pattern   the target pattern (See: DateZ)
     * @param timestamp the inputted long timestamp
     * @return the result
     */
    public static String getTimestamp(String pattern, long timestamp) {
        return new SimpleDateFormat(pattern).format(new Date(timestamp));
    }

    /**
     * Get pattern time string from inputted time
     *
     * @param pattern   the target pattern (See: DateZ)
     * @param timestamp the inputted string timestamp
     * @return the result
     */
    public static String getTimestamp(String pattern, String timestamp) {
        return getTimestamp(pattern, Long.parseLong(timestamp));
    }

    /**
     * Get timestamp long from inputted string
     *
     * @param pattern the target pattern (See: DateZ)
     * @param text    the string timestamp
     * @return the result
     */
    public static long getTimestampLongFrom(String pattern, String text) {
        Date parsedDate = getDateFrom(pattern, text);
        if (parsedDate != null)
            return parsedDate.getTime();
        else
            return 0;
    }

    /**
     * Get timestamp string from inputted string
     *
     * @param pattern the target pattern (See: DateZ)
     * @param text    the string timestamp
     * @return the result
     */
    public static String getTimestampStringFrom(String pattern, String text) {
        return String.valueOf(getTimestampLongFrom(pattern, text));
    }

    /* TimeRange ---------------------------------------------------------------------------------*/

    /**
     * Get time range long from inputted time to current time
     *
     * @param timestamp the inputted long timestamp
     * @return the result
     */
    public static long getTimeRange(long timestamp) {
        return getTimestamp() - timestamp;
    }

    /**
     * Get time range long from inputted time to current time
     *
     * @param timestamp the inputted string timestamp
     * @return the result
     */
    public static long getTimeRange(String timestamp) {
        return getTimeRange(Long.parseLong(timestamp));
    }

    /**
     * Get boolean from inputted time to current time
     *
     * @param timestamp the inputted long timestamp
     * @param limit     the inputted long limit (less than limit)
     * @return the result
     */
    public static boolean getTimeRangeCheck(long timestamp, long limit) {
        return (getTimestamp() - timestamp) <= limit;
    }

    /**
     * Get boolean from inputted time to current time
     *
     * @param timestamp the inputted string timestamp
     * @param limit     the inputted long limit (less than limit)
     * @return the result
     */
    public static boolean getTimeRangeCheck(String timestamp, long limit) {
        return getTimeRangeCheck(Long.parseLong(timestamp), limit);
    }

    /**
     * Get time range string from inputted time to current time
     *
     * @param timestamp the inputted long timestamp
     * @return the result
     */
    public static String getTimeRangeString(long timestamp) {
        return String.valueOf(getTimeRange(timestamp));
    }

    /**
     * Get time range string from inputted time to current time
     *
     * @param timestamp the inputted string timestamp
     * @return the result
     */
    public static String getTimeRangeString(String timestamp) {
        return String.valueOf(getTimeRange(timestamp));
    }

    /**
     * Get time range string from inputted time
     *
     * @param time the inputted long time
     * @return the result
     */
    public static String getTimeRangeFrom(long time) {
        return getTimeRangeFrom(time, RANGE_1);
    }

    /**
     * Get time range string from inputted time
     *
     * @param time the inputted string time
     * @return the result
     */
    public static String getTimeRangeFrom(String time) {
        return getTimeRangeFrom(Long.parseLong(time), RANGE_1);
    }

    /**
     * Get time range string from inputted time and type
     *
     * @param time the inputted long time
     * @param type the range type (year, month, day, second)
     * @return the result
     */
    public static String getTimeRangeFrom(long time, String type) {
        String result = "";
        switch (type) {
            case RANGE_1:
                result = getTimeRangeType(time, true, true, true, true, true, true, true);
                break;
            case RANGE_2:
                result = getTimeRangeType(time, true, true, false, true, true, true, true);
                break;
            case RANGE_3:
                result = getTimeRangeType(time, true, true, true, true, true, true, false);
                break;
            case RANGE_4:
                result = getTimeRangeType(time, true, true, false, true, true, true, false);
                break;
            case RANGE_5:
                result = getTimeRangeType(time, false, true, true, true, true, true, true);
                break;
            case RANGE_6:
                result = getTimeRangeType(time, false, true, false, true, true, true, true);
                break;
            case RANGE_7:
                result = getTimeRangeType(time, false, true, true, true, true, true, false);
                break;
            case RANGE_8:
                result = getTimeRangeType(time, false, true, false, true, true, true, false);
                break;
            case RANGE_9:
                result = getTimeRangeType(time, false, false, true, true, true, true, true);
                break;
            case RANGE_10:
                result = getTimeRangeType(time, false, false, true, true, true, true, false);
                break;
            case RANGE_11:
                result = getTimeRangeType(time, false, false, false, true, true, true, true);
                break;
            case RANGE_12:
                result = getTimeRangeType(time, false, false, false, true, true, true, false);
                break;
            case RANGE_13:
                result = getTimeRangeType(time, false, false, false, false, true, true, true);
                break;
            case RANGE_14:
                result = getTimeRangeType(time, false, false, false, false, true, true, false);
                break;
        }
        return result;
    }

    /**
     * Get time range string from inputted time and type
     *
     * @param time the inputted string time
     * @param type the range type (year, month, day, second)
     * @return the result
     */
    public static String getTimeRangeFrom(String time, String type) {
        return getTimeRangeFrom(Long.parseLong(time), type);
    }

    /**
     * Get time range string from inputted timestamp
     *
     * @param timestamp the inputted long timestamp
     * @return the result
     */
    public static String getTimeRangeNowFrom(long timestamp) {
        return getTimeRangeFrom(getTimeRange(timestamp), RANGE_1);
    }

    /**
     * Get time range string from inputted timestamp
     *
     * @param timestamp the inputted string timestamp
     * @return the result
     */
    public static String getTimeRangeNowFrom(String timestamp) {
        return getTimeRangeNowFrom(Long.parseLong(timestamp));
    }

    /**
     * Get time range string from inputted timestamp
     *
     * @param timestamp the inputted long timestamp
     * @param type      the range type (year, month, day, second)
     * @return the result
     */
    public static String getTimeRangeNowFrom(long timestamp, String type) {
        return getTimeRangeFrom(getTimeRange(timestamp), type);
    }

    /**
     * Get time range string from inputted timestamp
     *
     * @param timestamp the inputted string timestamp
     * @param type      the range type (year, month, day, second)
     * @return the result
     */
    public static String getTimeRangeNowFrom(String timestamp, String type) {
        return getTimeRangeNowFrom(Long.parseLong(timestamp), type);
    }

    @SuppressWarnings("SameParameterValue")
    private static String getTimeRangeType(long time, boolean year, boolean month, boolean week, boolean day, boolean hour, boolean minute, boolean second) {
        long years = 0, months = 0, weeks = 0, days = 0, hours = 0, minutes = 0, seconds = 0;

        if (year)
            years = time / YEARS;

        if (month && years > 0)
            months = (time % YEARS) / MONTHS;
        else if (month)
            months = time / MONTHS;

        if (week && months > 0)
            weeks = (time % MONTHS) / WEEKS;
        else if (week && years > 0)
            weeks = (time % YEARS) / WEEKS;
        else if (week)
            weeks = time / WEEKS;

        if (day && weeks > 0)
            days = (time % WEEKS) / DAYS;
        else if (day && months > 0)
            days = (time % MONTHS) / DAYS;
        else if (day && years > 0)
            days = (time % YEARS) / DAYS;
        else if (day)
            days = time / DAYS;

        if (hour && days > 0)
            hours = (time % DAYS) / HOURS;
        else if (hour && weeks > 0)
            hours = (time % WEEKS) / HOURS;
        else if (hour && months > 0)
            hours = (time % MONTHS) / HOURS;
        else if (hour && years > 0)
            hours = (time % YEARS) / HOURS;
        else if (hour)
            hours = time / HOURS;

        if (minute && hours > 0)
            minutes = (time % HOURS) / MINUTES;
        else if (minute && days > 0)
            minutes = (time % DAYS) / MINUTES;
        else if (minute && weeks > 0)
            minutes = (time % WEEKS) / MINUTES;
        else if (minute && months > 0)
            minutes = (time % MONTHS) / MINUTES;
        else if (minute && years > 0)
            minutes = (time % YEARS) / MINUTES;
        else if (minute)
            minutes = time / MINUTES;

        if (second && minutes > 0)
            seconds = (time % MINUTES) / SECONDS;
        else if (second && hours > 0)
            seconds = (time % HOURS) / SECONDS;
        else if (second && days > 0)
            seconds = (time % DAYS) / SECONDS;
        else if (second && weeks > 0)
            seconds = (time % WEEKS) / SECONDS;
        else if (second && months > 0)
            seconds = (time % MONTHS) / SECONDS;
        else if (second && years > 0)
            seconds = (time % YEARS) / SECONDS;
        else if (second)
            seconds = time / SECONDS;

        return getResult(Integer.parseInt(String.valueOf(years)),
                Integer.parseInt(String.valueOf(months)),
                Integer.parseInt(String.valueOf(weeks)),
                Integer.parseInt(String.valueOf(days)),
                Integer.parseInt(String.valueOf(hours)),
                Integer.parseInt(String.valueOf(minutes)),
                Integer.parseInt(String.valueOf(seconds)));
    }

    private static String getResult(int years, int months, int weeks, int days, int hours, int minutes, int seconds) {
        String result = "";
        if (years > 1)
            result = years + " years";
        else if (years > 0)
            result = years + " year";

        if (months > 1)
            if (!result.isEmpty())
                result = result + ", " + months + " months";
            else result = result + months + " months";
        else if (months > 0)
            if (!result.isEmpty())
                result = result + ", " + months + " month";
            else result = result + months + " month";

        if (weeks > 1)
            if (!result.isEmpty())
                result = result + ", " + weeks + " weeks";
            else result = result + weeks + " weeks";
        else if (weeks > 0)
            if (!result.isEmpty())
                result = result + ", " + weeks + " week";
            else result = result + weeks + " week";

        if (days > 1)
            if (!result.isEmpty())
                result = result + ", " + days + " days";
            else result = result + days + " days";
        else if (days > 0)
            if (!result.isEmpty())
                result = result + ", " + days + " day";
            else result = result + days + " day";

        if (hours > 1)
            if (!result.isEmpty())
                result = result + ", " + hours + " hours";
            else result = result + hours + " hours";
        else if (hours > 0)
            if (!result.isEmpty())
                result = result + ", " + hours + " hour";
            else result = result + hours + " hour";

        if (minutes > 1)
            if (!result.isEmpty())
                result = result + ", " + minutes + " minutes";
            else result = result + minutes + " minutes";
        else if (minutes > 0)
            if (!result.isEmpty())
                result = result + ", " + minutes + " minute";
            else result = result + minutes + " minute";

        if (seconds > 1)
            if (!result.isEmpty())
                result = result + ", " + seconds + " seconds";
            else result = result + seconds + " seconds";
        else if (seconds > 0)
            if (!result.isEmpty())
                result = result + ", " + seconds + " second";
            else result = result + seconds + " second";

        return result;
    }

    /* Date Constants ------------------------------------------------------------------------------
    ------------------------------------------------------------------------------------------------
    |   Component	            Type	Examples	        API Levels
    ------------------------------------------------------------------------------------------------
    G	Era designator	        Text	AD	                    1+
    y	Year	                Year	1996; 96	            1+
    Y	Week year	            Year	2009; 09	            24+
    M	Month in year (context)	Month	July; Jul; 07	        1+
    w	Week in year	        Number	27	                    1+
    W	Week in month	        Number	2	                    1+
    D	Day in year	            Number	189	                    1+
    d	Day in month	        Number	10	                    1+
    F	Day of week in month	Number	2	                    1+
    E	Day name in week	    Text	Tuesday; Tue	        1+
    u	Day number of week  	Number	1-7	                    24+
    a	Am/pm marker	        Text	PM	                    1+
    H	Hour in day (0-23)	    Number	0	                    1+
    k	Hour in day (1-24)	    Number	24	                    1+
    K	Hour in am/pm (0-11)	Number	0	                    1+
    h	Hour in am/pm (1-12)	Number	12	                    1+
    m	Minute in hour	        Number	30	                    1+
    s	Second in minute	    Number	55	                    1+
    S	Millisecond	            Number	978	                    1+
    z	General time zone	    Pacific Standard Time; PST; GMT-08:00
    Z	RFC 822 time zone	    -0800
    X	ISO 8601 time zone	    -08; -0800; -08:00
    ------------------------------------------------------------------------------------------------
    More: https://developer.android.com/reference/java/text/SimpleDateFormat -----------------------
    ----------------------------------------------------------------------------------------------*/

    public static final String TIME = "HH:mm";
    public static final String TIME_FULL = "HH:mm:ss";
    public static final String TIME_12 = "hh:mm aa";
    public static final String TIME_12_FULL = "hh:mm:ss aa";

    public static final String TIMEZONE = "zzz";
    public static final String TIMEZONE_TEXT = "zzzz";
    public static final String TIMEZONE_NUMBER = "Z";

    public static final String DATE_FULL = "yyyy-MM-dd HH:mm:ss";
    public static final String DATE_FULL_REVERSE = "dd-MM-yyyy HH:mm:ss";
    public static final String DATE_DETAIL_FULL = "yyyy-MM-dd HH:mm:ss.SSS";
    public static final String DATE_DETAIL_FULL_REVERSE = "dd-MM-yyyy HH:mm:ss.SSS";

    public static final String DATE_DAY = "MMMM d, yyyy";
    public static final String DATE_DAY_REVERSE = "d MMMM yyyy";
    public static final String DATE_DAY_FULL = "EEEE, MMMM d, yyyy";
    public static final String DATE_DAY_FULL_REVERSE = "EEEE, d MMMM yyyy";

    public static final String FORMAT_DAY = "EEEE";
    public static final String FORMAT_D = "d";
    public static final String FORMAT_M = "MMMM";
    public static final String FORMAT_Y = "yyyy";

    public static final String CUSTOM_1 = "yyMMddHHmmss";
    public static final String CUSTOM_2 = "yyMMddHHmmssSSS";
    public static final String CUSTOM_3 = "yyyyMMddHHmmss";
    public static final String CUSTOM_4 = "yyyyMMddHHmmssSSS";
    public static final String CUSTOM_5 = "yy.MM.dd.HH.mm";
    public static final String CUSTOM_6 = "yy.MM.dd.HH.mm.ss";
    public static final String CUSTOM_7 = "yy.MM.dd.HH.mm.ss.SSS";
    public static final String CUSTOM_8 = "yy:MM:dd:HH:mm";
    public static final String CUSTOM_9 = "yy:MM:dd:HH:mm:ss";
    public static final String CUSTOM_10 = "yy:MM:dd:HH:mm:ss:SSS";

    public static final String CUSTOM_11 = "yyMMdd";
    public static final String CUSTOM_12 = "yyMMddHHmm";
    public static final String CUSTOM_13 = "yyyyMMdd";
    public static final String CUSTOM_14 = "yyyyMMddHHmm";
    public static final String CUSTOM_15 = "yyMM";
    public static final String CUSTOM_16 = "EEE, MMM d, yyyy";
    public static final String CUSTOM_17 = "EEEE, MMM d, yyyy";
    public static final String CUSTOM_18 = "MMM d, yyyy";
    public static final String CUSTOM_19 = "d MMM yyyy";
    public static final String CUSTOM_20 = "d MMM \'yy";

    public static final String CUSTOM_21 = "EEEE, MMMM d, yyyy HH:mm:ss";
    public static final String CUSTOM_22 = "EEE, MMM d, yyyy HH:mm:ss";
    public static final String CUSTOM_23 = "EEEE, MMMM d, yyyy HH:mm";
    public static final String CUSTOM_24 = "EEE, MMM d, yyyy HH:mm";
    public static final String CUSTOM_25 = "yyyy MMMM d HH:mm:ss";
    public static final String CUSTOM_26 = "yyyy MMM d HH:mm:ss";
    public static final String CUSTOM_27 = "yyyy MMMM d HH:mm";
    public static final String CUSTOM_28 = "yyyy MMM d HH:mm";
    public static final String CUSTOM_29 = "yy/MM/dd HH:mm:ss";
    public static final String CUSTOM_30 = "yy/MM/dd HH:mm";

    public static final String CUSTOM_31 = "EEEE, d MMMM yyyy HH:mm:ss";
    public static final String CUSTOM_32 = "EEE, d MMMM yyyy HH:mm:ss";
    public static final String CUSTOM_33 = "EEEE, d MMM yyyy HH:mm:ss";
    public static final String CUSTOM_34 = "EEE, d MMM yyyy HH:mm:ss";
    public static final String CUSTOM_35 = "EEEE, d MMMM yyyy HH:mm";
    public static final String CUSTOM_36 = "EEE, d MMMM yyyy HH:mm";
    public static final String CUSTOM_37 = "EEEE, d MMM yyyy HH:mm";
    public static final String CUSTOM_38 = "EEE, d MMM yyyy HH:mm";
    public static final String CUSTOM_39 = "EEEE, dd/MM/yyyy HH:mm";
    public static final String CUSTOM_40 = "EEE, dd/MM/yy HH:mm";

    public static final String CUSTOM_41 = "EEEE, HH:mm:ss";
    public static final String CUSTOM_42 = "EEEE, HH:mm";
    public static final String CUSTOM_43 = "EEE, HH:mm:ss";
    public static final String CUSTOM_44 = "EEE, HH:mm";
    public static final String CUSTOM_45 = "MMMM d, HH:mm";
    public static final String CUSTOM_46 = "MMM d, HH:mm";
    public static final String CUSTOM_47 = "MMMM d, hh:mm aa";
    public static final String CUSTOM_48 = "MMM d, hh:mm aa";
    public static final String CUSTOM_49 = "HH:mm, zzzz";
    public static final String CUSTOM_50 = "hh:mm aa, zzzz";

    public static final String RANGE_1 = "years, months, weeks, days, hours, minutes, seconds";
    public static final String RANGE_2 = "years, months, days, hours, minutes, seconds";
    public static final String RANGE_3 = "years, months, weeks, days, hours, minutes";
    public static final String RANGE_4 = "years, months, days, hours, minutes";
    public static final String RANGE_5 = "months, weeks, days, hours, minutes, seconds";
    public static final String RANGE_6 = "months, days, hours, minutes, seconds";
    public static final String RANGE_7 = "months, weeks, days, hours, minutes";
    public static final String RANGE_8 = "months, days, hours, minutes";
    public static final String RANGE_9 = "weeks, days, hours, minutes, seconds";
    public static final String RANGE_10 = "weeks, days, hours, minutes";
    public static final String RANGE_11 = "days, hours, minutes, seconds";
    public static final String RANGE_12 = "days, hours, minutes";
    public static final String RANGE_13 = "hours, minutes, seconds";
    public static final String RANGE_14 = "hours, minutes";

    public static long SECONDS = 1000;
    public static long MINUTES = 60 * SECONDS;
    public static long HOURS = 60 * MINUTES;
    public static long DAYS = 24 * HOURS;
    public static long WEEKS = 7 * DAYS;
    public static long MONTHS = 30 * DAYS;
    public static long YEARS = 365 * DAYS;
}
