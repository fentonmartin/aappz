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
    public static String getDateFromHex(String hex) {
        return getTimestampTime(NumberZ.fromHex(hex));
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
    public static String getTimestampTime(long timestamp) {
        return new SimpleDateFormat(DateZ.DATE_FULL).format(new Date(timestamp));
    }

    /**
     * Get 'yyyy-MM-dd HH:mm:ss' string from inputted time
     *
     * @param timestamp the inputted string timestamp
     * @return the result
     */
    public static String getTimestampTime(String timestamp) {
        return getTimestampTime(Long.parseLong(timestamp));
    }

    /**
     * Get pattern time string from inputted time
     *
     * @param pattern   the target pattern (See: DateZ)
     * @param timestamp the inputted long timestamp
     * @return the result
     */
    public static String getTimestampTime(String pattern, long timestamp) {
        return new SimpleDateFormat(pattern).format(new Date(timestamp));
    }

    /**
     * Get pattern time string from inputted time
     *
     * @param pattern   the target pattern (See: DateZ)
     * @param timestamp the inputted string timestamp
     * @return the result
     */
    public static String getTimestampTime(String pattern, String timestamp) {
        return getTimestampTime(pattern, Long.parseLong(timestamp));
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
     * Get time range string from inputted time to current time
     *
     * @param timestamp the inputted long timestamp
     * @return the result
     */
    public static String getTimeRangeString(long timestamp) {
        return String.valueOf(getTimeRange(timestamp));
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
}
