package io.github.fentonmartin.aappz.util;

public class ThreadZ {

    /**
     * Make a request checker based on 1 minute
     *
     * @param callback set thread callback (functions, etc)
     */
    public static void request(final ThreadZ.Callback callback) {
        if (PrefZ.getLong("ThreadZ") <= 0)
            PrefZ.setLong("ThreadZ", DateZ.getTimestamp());
        valid(PrefZ.getLong("ThreadZ"), callback);
    }

    /**
     * Make a request checker based on limit
     *
     * @param limit    set request limit by long DateZ (hours, monutes, etc)
     * @param callback set thread callback (functions, etc)
     */
    public static void request(long limit, final ThreadZ.Callback callback) {
        if (PrefZ.getLong("ThreadZ") <= 0)
            PrefZ.setLong("ThreadZ", DateZ.getTimestamp());
        valid(PrefZ.getLong("ThreadZ"), limit, callback);
    }

    /**
     * Make a valid checker based on 1 minute
     *
     * @param timestamp set long timestamp for check the validity
     * @param callback  set thread callback (functions, etc)
     */
    public static void valid(long timestamp, final ThreadZ.Callback callback) {
        if (DateZ.getTimeRangeCheck(timestamp, DateZ.MINUTES))
            callback.onValid();
    }

    /**
     * Make a valid checker based on limit
     *
     * @param timestamp set long timestamp for check the validity
     * @param limit     set request limit by long DateZ (hours, monutes, etc)
     * @param callback  set thread callback (functions, etc)
     */
    public static void valid(long timestamp, long limit, final ThreadZ.Callback callback) {
        if (DateZ.getTimeRangeCheck(timestamp, limit))
            callback.onValid();
    }

    public interface Callback {
        void onValid();
    }
}
