package io.github.fentonmartin.aappz.util;

import android.app.Activity;
import android.util.Log;

class LogZ {
    void setLog(String log) {
        Log.d("LogZ ", log);
    }
    void setLog(Activity activity, String log) {
        Log.d("LogZ " + activity.getClass().getSimpleName(), log);
    }
}
