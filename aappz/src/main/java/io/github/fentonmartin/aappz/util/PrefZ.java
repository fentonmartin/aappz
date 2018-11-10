package io.github.fentonmartin.aappz.util;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;

import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public final class PrefZ {

    private static SharedPreferences mPrefZ;
    private static final String _SUFFIX = "_PrefZ";
    private static final String LENGTH = "#LENGTH";

    private static void init(Context context, String prefsName, int mode) {
        mPrefZ = context.getSharedPreferences(prefsName, mode);
    }
    public static SharedPreferences getPreferences() {
        if (mPrefZ != null) {
            return mPrefZ;
        }
        throw new RuntimeException(
                "PrefZ class not correctly instantiated. Please call Builder.setContext().build() in the Application class onCreate.");
    }
    public static Map<String, ?> getAll() {
        return getPreferences().getAll();
    }
    public static int getInt(final String key, final int defValue) {
        return getPreferences().getInt(key, defValue);
    }
    public static int getInt(final String key) {
        return getPreferences().getInt(key, 0);
    }
    public static boolean getBoolean(final String key, final boolean defValue) {
        return getPreferences().getBoolean(key, defValue);
    }
    public static boolean getBoolean(final String key) {
        return getPreferences().getBoolean(key, false);
    }
    public static long getLong(final String key, final long defValue) {
        return getPreferences().getLong(key, defValue);
    }
    public static long getLong(final String key) {
        return getPreferences().getLong(key, 0L);
    }
    public static double getDouble(final String key, final double defValue) {
        return Double.longBitsToDouble(getPreferences().getLong(key, Double.doubleToLongBits(defValue)));
    }
    public static double getDouble(final String key) {
        return Double.longBitsToDouble(getPreferences().getLong(key, Double.doubleToLongBits(0.0d)));
    }
    public static float getFloat(final String key, final float defValue) {
        return getPreferences().getFloat(key, defValue);
    }
    public static float getFloat(final String key) {
        return getPreferences().getFloat(key, 0.0f);
    }
    public static String getString(final String key, final String defValue) {
        return getPreferences().getString(key, defValue);
    }
    public static String getString(final String key) {
        return getPreferences().getString(key, "");
    }
    public static Set<String> getStringSet(final String key, final Set<String> defValue) {
        SharedPreferences prefs = getPreferences();
        return prefs.getStringSet(key, defValue);
    }
    public static Set<String> getStringSetOrdered(String key, final Set<String> defValue) {
        SharedPreferences prefs = getPreferences();
        if (prefs.contains(key + LENGTH)) {
            LinkedHashSet<String> set = new LinkedHashSet<>();
            int stringSetLength = prefs.getInt(key + LENGTH, -1);
            if (stringSetLength >= 0) {
                for (int i = 0; i < stringSetLength; i++) {
                    set.add(prefs.getString(key + "[" + i + "]", null));
                }
            }
            return set;
        }
        return defValue;
    }
    public static void setLong(final String key, final long value) {
        final Editor editor = getPreferences().edit();
        editor.putLong(key, value);
        editor.apply();
    }
    public static void setInt(final String key, final int value) {
        final Editor editor = getPreferences().edit();
        editor.putInt(key, value);
        editor.apply();
    }
    public static void setDouble(final String key, final double value) {
        final Editor editor = getPreferences().edit();
        editor.putLong(key, Double.doubleToRawLongBits(value));
        editor.apply();
    }
    public static void setFloat(final String key, final float value) {
        final Editor editor = getPreferences().edit();
        editor.putFloat(key, value);
        editor.apply();
    }
    public static void setBoolean(final String key, final boolean value) {
        final Editor editor = getPreferences().edit();
        editor.putBoolean(key, value);
        editor.apply();
    }
    public static void setString(final String key, final String value) {
        final Editor editor = getPreferences().edit();
        editor.putString(key, value);
        editor.apply();
    }
    public static void setStringSet(final String key, final Set<String> value) {
        final Editor editor = getPreferences().edit();
        editor.putStringSet(key, value);
        editor.apply();
    }
    public static void setStringSetOrdered(String key, Set<String> value) {
        final Editor editor = getPreferences().edit();
        int stringSetLength = 0;
        if (mPrefZ.contains(key + LENGTH)) {
            stringSetLength = mPrefZ.getInt(key + LENGTH, -1);
        }
        editor.putInt(key + LENGTH, value.size());
        int i = 0;
        for (String aValue : value) {
            editor.putString(key + "[" + i + "]", aValue);
            i++;
        }
        for (; i < stringSetLength; i++) {
            editor.remove(key + "[" + i + "]");
        }
        editor.apply();
    }
    public static void remove(final String key) {
        SharedPreferences prefs = getPreferences();
        final Editor editor = prefs.edit();
        if (prefs.contains(key + LENGTH)) {
            int stringSetLength = prefs.getInt(key + LENGTH, -1);
            if (stringSetLength >= 0) {
                editor.remove(key + LENGTH);
                for (int i = 0; i < stringSetLength; i++) {
                    editor.remove(key + "[" + i + "]");
                }
            }
        }
        editor.remove(key);
        editor.apply();
    }
    public static boolean contains(final String key) {
        return getPreferences().contains(key);
    }
    public static Editor clear() {
        final Editor editor = getPreferences().edit().clear();
        editor.apply();
        return editor;
    }
    public static Editor edit() {
        return getPreferences().edit();
    }
    public final static class Builder {

        private String mKey;
        private Context mContext;
        private int mMode = -1;
        private boolean mUseDefault = false;

        public Builder setPrefsName(final String prefsName) {
            mKey = prefsName;
            return this;
        }
        public Builder setContext(final Context context) {
            mContext = context;
            return this;
        }
        public Builder setMode(final int mode) {
            if (mode == ContextWrapper.MODE_PRIVATE || mode == ContextWrapper.MODE_WORLD_READABLE || mode == ContextWrapper.MODE_WORLD_WRITEABLE || mode == ContextWrapper.MODE_MULTI_PROCESS) {
                mMode = mode;
            } else {
                throw new RuntimeException("The mode in the SharedPreference can only be set too ContextWrapper.MODE_PRIVATE, ContextWrapper.MODE_WORLD_READABLE, ContextWrapper.MODE_WORLD_WRITEABLE or ContextWrapper.MODE_MULTI_PROCESS");
            }

            return this;
        }
        public Builder setUseDefaultSharedPreference(boolean defaultSharedPreference) {
            mUseDefault = defaultSharedPreference;
            return this;
        }
        public void build() {
            if (mContext == null) {
                throw new RuntimeException("Context not set, please set context before building the PrefZ instance.");
            }
            if (TextUtils.isEmpty(mKey)) {
                mKey = mContext.getPackageName();
            }
            if (mUseDefault) {
                mKey += _SUFFIX;
            }
            if (mMode == -1) {
                mMode = ContextWrapper.MODE_PRIVATE;
            }
            PrefZ.init(mContext, mKey, mMode);
        }
    }
}