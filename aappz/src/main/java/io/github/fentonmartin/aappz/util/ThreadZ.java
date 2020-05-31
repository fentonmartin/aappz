package io.github.fentonmartin.aappz.util;

public class ThreadZ {

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
