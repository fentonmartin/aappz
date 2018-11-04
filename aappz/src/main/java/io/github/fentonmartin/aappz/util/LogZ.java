package io.github.fentonmartin.aappz.util;

import android.util.Log;

class LogZ {
    void setLog(String log) {
        Log.d("LogZ " + getClass().getSimpleName(), log);
    }
}
