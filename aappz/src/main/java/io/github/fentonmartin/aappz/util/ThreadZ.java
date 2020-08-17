package io.github.fentonmartin.aappz.util;

public class ThreadZ {

    public static void request(final ThreadZ.Callback callback) {
        if (PrefZ.getLong("ThreadZ") <= 0)
            PrefZ.setLong("ThreadZ", DateZ.getTimestamp());
        valid(PrefZ.getLong("ThreadZ"), callback);
    }

    public static void valid(long timestamp, final ThreadZ.Callback callback) {
        if (DateZ.getTimeRangeCheck(timestamp, DateZ.MINUTES))
            callback.onValid();
    }

    public static void valid(long timestamp, long limit, final ThreadZ.Callback callback) {
        if (DateZ.getTimeRangeCheck(timestamp, limit))
            callback.onValid();
    }

    public interface Callback {
        void onValid();
    }
}
