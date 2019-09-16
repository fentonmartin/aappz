package io.github.fentonmartin.aappz.util;

import android.os.Handler;

@SuppressWarnings("unused")
public class DelayZ {

    private static Handler handler = new Handler();

    public static void post(long millis, final Callback callback) {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                callback.onDelayed();
            }
        }, millis);
    }

    public static void post(long millis, Runnable runnable) {
        handler.postDelayed(runnable, millis);
    }

    public static void cancel(Runnable runnable) {
        handler.removeCallbacksAndMessages(runnable);
    }

    public static void cancel() {
        handler.removeCallbacksAndMessages(null);
    }

    public interface Callback {
        void onDelayed();
    }
}
