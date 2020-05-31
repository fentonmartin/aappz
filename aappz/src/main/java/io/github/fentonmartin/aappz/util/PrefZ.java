package io.github.fentonmartin.aappz.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;

import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

@SuppressWarnings({"WeakerAccess", "unused"})
public final class PrefZ {

    private static SharedPreferences preferences;
    private static final String LENGTH = "LENGTH";
    private static final String _SUFFIX = "_PrefZ";

    /**
     * Initiate PrefZ class
     *
     * @param context   the application context
     * @param prefsName the preference name
     * @param mode      the preference mode
     */
    private static void init(Context context, String prefsName, int mode) {
        preferences = context.getSharedPreferences(prefsName, mode);
    }

    /**
     * Get static SharedPreferences
     *
     * @return the result
     */
    public static SharedPreferences getPreferences() {
        if (preferences != null)
            return preferences;
        throw new RuntimeException("PrefZ class not correctly instantiated. Please call Builder.setContext().build() in the Application class onCreate.");
    }

    /**
     * Get all Map String SharedPreferences
     *
     * @return the result
     */
    public static Map<String, ?> getAll() {
        return getPreferences().getAll();
    }

    /**
     * Get integer from SharedPreferences
     *
     * @param key      the preference key
     * @param defValue default value
     * @return the result
     */
    public static int getInt(final String key, final int defValue) {
        return getPreferences().getInt(key, defValue);
    }

    /**
     * Get integer from SharedPreferences
     *
     * @param key the preference key
     * @return the result
     */
    public static int getInt(final String key) {
        return getPreferences().getInt(key, 0);
    }

    /**
     * Get boolean from SharedPreferences
     *
     * @param key      the preference key
     * @param defValue default value
     * @return the result
     */
    public static boolean getBoolean(final String key, final boolean defValue) {
        return getPreferences().getBoolean(key, defValue);
    }

    /**
     * Get boolean from SharedPreferences
     *
     * @param key the preference key
     * @return the result
     */
    public static boolean getBoolean(final String key) {
        return getPreferences().getBoolean(key, false);
    }

    /**
     * Get long from SharedPreferences
     *
     * @param key      the preference key
     * @param defValue default value
     * @return the result
     */
    public static long getLong(final String key, final long defValue) {
        return getPreferences().getLong(key, defValue);
    }

    /**
     * Get long from SharedPreferences
     *
     * @param key the preference key
     * @return the result
     */
    public static long getLong(final String key) {
        return getPreferences().getLong(key, 0L);
    }

    /**
     * Get double from SharedPreferences
     *
     * @param key      the preference key
     * @param defValue default value
     * @return the result
     */
    public static double getDouble(final String key, final double defValue) {
        return Double.longBitsToDouble(getPreferences().getLong(key, Double.doubleToLongBits(defValue)));
    }

    /**
     * Get double from SharedPreferences
     *
     * @param key the preference key
     * @return the result
     */
    public static double getDouble(final String key) {
        return Double.longBitsToDouble(getPreferences().getLong(key, Double.doubleToLongBits(0.0d)));
    }

    /**
     * Get float from SharedPreferences
     *
     * @param key      the preference key
     * @param defValue default value
     * @return the result
     */
    public static float getFloat(final String key, final float defValue) {
        return getPreferences().getFloat(key, defValue);
    }

    /**
     * Get float from SharedPreferences
     *
     * @param key the preference key
     * @return the result
     */
    public static float getFloat(final String key) {
        return getPreferences().getFloat(key, 0.0f);
    }

    /**
     * Get string from SharedPreferences
     *
     * @param key      the preference key
     * @param defValue default value
     * @return the result
     */
    public static String getString(final String key, final String defValue) {
        return getPreferences().getString(key, defValue);
    }

    /**
     * Get string from SharedPreferences
     *
     * @param key the preference key
     * @return the result
     */
    public static String getString(final String key) {
        return getPreferences().getString(key, "");
    }

    /**
     * Get string set from SharedPreferences
     *
     * @param key      the preference key
     * @param defValue default value
     * @return the result
     */
    public static Set<String> getStringSet(final String key, final Set<String> defValue) {
        SharedPreferences prefs = getPreferences();
        return prefs.getStringSet(key, defValue);
    }

    /**
     * Get string set ordered from SharedPreferences
     *
     * @param key      the preference key
     * @param defValue default value
     * @return the result
     */
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

    /**
     * Set long value to SharedPreferences
     *
     * @param key   the preference key
     * @param value the value
     */
    public static void setLong(final String key, final long value) {
        final Editor editor = getPreferences().edit();
        editor.putLong(key, value);
        editor.apply();
    }

    /**
     * Set integer value to SharedPreferences
     *
     * @param key   the preference key
     * @param value the value
     */
    public static void setInt(final String key, final int value) {
        final Editor editor = getPreferences().edit();
        editor.putInt(key, value);
        editor.apply();
    }

    /**
     * Set double value to SharedPreferences
     *
     * @param key   the preference key
     * @param value the value
     */
    public static void setDouble(final String key, final double value) {
        final Editor editor = getPreferences().edit();
        editor.putLong(key, Double.doubleToRawLongBits(value));
        editor.apply();
    }

    /**
     * Set float value to SharedPreferences
     *
     * @param key   the preference key
     * @param value the value
     */
    public static void setFloat(final String key, final float value) {
        final Editor editor = getPreferences().edit();
        editor.putFloat(key, value);
        editor.apply();
    }

    /**
     * Set boolean value to SharedPreferences
     *
     * @param key   the preference key
     * @param value the value
     */
    public static void setBoolean(final String key, final boolean value) {
        final Editor editor = getPreferences().edit();
        editor.putBoolean(key, value);
        editor.apply();
    }

    /**
     * Set string value to SharedPreferences
     *
     * @param key   the preference key
     * @param value the value
     */
    public static void setString(final String key, final String value) {
        final Editor editor = getPreferences().edit();
        editor.putString(key, value);
        editor.apply();
    }

    /**
     * Set string set value to SharedPreferences
     *
     * @param key   the preference key
     * @param value the value
     */
    public static void setStringSet(final String key, final Set<String> value) {
        final Editor editor = getPreferences().edit();
        editor.putStringSet(key, value);
        editor.apply();
    }

    /**
     * Set string set ordered value to SharedPreferences
     *
     * @param key   the preference key
     * @param value the value
     */
    public static void setStringSetOrdered(String key, Set<String> value) {
        final Editor editor = getPreferences().edit();
        int stringSetLength = 0;
        if (preferences.contains(key + LENGTH))
            stringSetLength = preferences.getInt(key + LENGTH, -1);
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

    /**
     * Remove current preference key
     *
     * @param key preference key
     */
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

    /**
     * Check current prefs key
     *
     * @param key preference key
     * @return the result
     */
    public static boolean contains(final String key) {
        return getPreferences().contains(key);
    }

    /**
     * Set clear to preference edit
     *
     * @return the result
     */
    public static Editor clear() {
        final Editor editor = getPreferences().edit().clear();
        editor.apply();
        return editor;
    }

    /**
     * return getPreferences().edit for preference edit
     *
     * @return the result
     */
    public static Editor edit() {
        return getPreferences().edit();
    }

    public final static class Builder {

        private String mKey;
        private Context mContext;
        private int mMode = -1;
        private boolean mUseDefault = false;

        /**
         * Set name to SharedPreference
         *
         * @param prefsName passing the preference name
         * @return the result
         */
        public Builder setPrefsName(final String prefsName) {
            mKey = prefsName;
            return this;
        }

        /**
         * Set context to SharedPreference
         *
         * @param context passing the application context
         * @return the result
         */
        public Builder setContext(final Context context) {
            mContext = context;
            return this;
        }

        /**
         * Set SharedPreference mode
         *
         * @param mode MODE_PRIVATE, MODE_WORLD_READABLE, MODE_WORLD_WRITEABLE, or MODE_MULTI_PROCESS
         * @return the result
         */
        @SuppressLint({"WorldReadableFiles", "WorldWriteableFiles"})
        public Builder setMode(final int mode) {
            if (mode == ContextWrapper.MODE_PRIVATE || mode == ContextWrapper.MODE_WORLD_READABLE ||
                    mode == ContextWrapper.MODE_WORLD_WRITEABLE || mode == ContextWrapper.MODE_MULTI_PROCESS)
                mMode = mode;
            else
                throw new RuntimeException("The mode in the SharedPreference can only be set too ContextWrapper.MODE_PRIVATE, ContextWrapper.MODE_WORLD_READABLE, ContextWrapper.MODE_WORLD_WRITEABLE or ContextWrapper.MODE_MULTI_PROCESS");
            return this;
        }

        /**
         * Set use default SharedPreference
         *
         * @param defaultSharedPreference boolean default preference
         * @return the result
         */
        public Builder setUseDefaultSharedPreference(boolean defaultSharedPreference) {
            mUseDefault = defaultSharedPreference;
            return this;
        }

        /**
         * Build the PrefZ class
         */
        public void build() {
            if (mContext == null)
                throw new RuntimeException("Context not set, please set context before building the PrefZ instance.");
            if (TextUtils.isEmpty(mKey))
                mKey = mContext.getPackageName();
            if (mUseDefault)
                mKey += _SUFFIX;
            if (mMode == -1)
                mMode = ContextWrapper.MODE_PRIVATE;
            PrefZ.init(mContext, mKey, mMode);
        }
    }
}