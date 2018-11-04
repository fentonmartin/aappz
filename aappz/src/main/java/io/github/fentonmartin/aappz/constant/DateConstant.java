package io.github.fentonmartin.aappz.constant;

public class DateConstant {
    /*----------------------------------------------------------------------
    Letter	Component	        Type	Examples	        API Levels
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

    public static final String DATE_FULL = "yyyy-MM-dd HH:mm:ss";
    public static final String DATE_FULL_REVERSE = "dd-MM-yyyy HH:mm:ss";
    public static final String DATE_DAY = "MMMM d, yyyy";
    public static final String DATE_DAY_REVERSE = "d MMMM yyyy";
    public static final String DATE_DAY_FULL = "EEEE, MMMM d, yyyy";
    public static final String DATE_DAY_FULL_REVERSE = "EEEE, d MMMM yyyy";
}