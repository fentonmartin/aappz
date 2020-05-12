package io.github.fentonmartin.aappz.constant;

@SuppressWarnings("unused")
public class DateConstant {
    /*----------------------------------------------------------------------
        Component	            Type	Examples	        API Levels
    ------------------------------------------------------------------------
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
    ------------------------------------------------------------------------
    More: https://developer.android.com/reference/java/text/SimpleDateFormat */

    public static final String TIME = "HH:mm";
    public static final String TIME_FULL = "HH:mm:ss";
    public static final String TIME_12 = "hh:mm aa";
    public static final String TIME_12_FULL = "hh:mm:ss aa";

    public static final String TIMEZONE = "zzz";
    public static final String TIMEZONE_CODE = "z";
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
