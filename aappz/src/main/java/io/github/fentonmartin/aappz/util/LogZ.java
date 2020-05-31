package io.github.fentonmartin.aappz.util;

import android.util.Log;

public class LogZ {

    public static Logger build(boolean loggingEnabled) {
        return loggingEnabled ? new Blabber() : new Disabled();
    }

    private static class Disabled implements Logger {

        @Override
        public void v(String message, Object... args) {
        }

        @Override
        public void v(Throwable t, String message, Object... args) {
        }

        @Override
        public void d(String message, Object... args) {
        }

        @Override
        public void d(Throwable t, String message, Object... args) {
        }

        @Override
        public void i(String message, Object... args) {
        }

        @Override
        public void i(Throwable t, String message, Object... args) {
        }

        @Override
        public void w(String message, Object... args) {
        }

        @Override
        public void w(Throwable t, String message, Object... args) {
        }

        @Override
        public void e(String message, Object... args) {
        }

        @Override
        public void e(Throwable t, String message, Object... args) {
        }
    }

    private static class Blabber implements Logger {

        private String TAG = "LogZ ";

        private String getTag() {
            return new Exception().getStackTrace()[3].getMethodName();
        }

        private String formatMessage(String message, Object... args) {
            return args.length == 0 ? message : String.format(message, args);
        }

        @Override
        public void v(String message, Object... args) {
            Log.v(TAG + getTag(), formatMessage(message, args));
        }

        @Override
        public void v(Throwable t, String message, Object... args) {
            Log.v(TAG + getTag(), formatMessage(message, args), t);
        }

        @Override
        public void d(String message, Object... args) {
            Log.d(TAG + getTag(), formatMessage(message, args));

        }

        @Override
        public void d(Throwable t, String message, Object... args) {
            Log.d(TAG + getTag(), formatMessage(message, args), t);

        }

        @Override
        public void i(String message, Object... args) {
            Log.i(TAG + getTag(), formatMessage(message, args));

        }

        @Override
        public void i(Throwable t, String message, Object... args) {
            Log.i(TAG + getTag(), formatMessage(message, args), t);

        }

        @Override
        public void w(String message, Object... args) {
            Log.w(TAG + getTag(), formatMessage(message, args));

        }

        @Override
        public void w(Throwable t, String message, Object... args) {
            Log.w(TAG + getTag(), formatMessage(message, args), t);

        }

        @Override
        public void e(String message, Object... args) {
            Log.e(TAG + getTag(), formatMessage(message, args));

        }

        @Override
        public void e(Throwable t, String message, Object... args) {
            Log.e(TAG + getTag(), formatMessage(message, args), t);
        }
    }

    public interface Logger {
        void v(String message, Object... args);

        void v(Throwable t, String message, Object... args);

        void d(String message, Object... args);

        void d(Throwable t, String message, Object... args);

        void i(String message, Object... args);

        void i(Throwable t, String message, Object... args);

        void w(String message, Object... args);

        void w(Throwable t, String message, Object... args);

        void e(String message, Object... args);

        void e(Throwable t, String message, Object... args);
    }
}