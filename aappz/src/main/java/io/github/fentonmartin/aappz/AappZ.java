package io.github.fentonmartin.aappz;

import android.content.ContextWrapper;
import android.os.Bundle;

import io.github.fentonmartin.aappz.util.ActivityZ;
import io.github.fentonmartin.aappz.util.PrefZ;

public class AappZ extends ActivityZ {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /* PrefZ Initialization */
        new PrefZ.Builder()
                .setContext(this)
                .setMode(ContextWrapper.MODE_PRIVATE)
                .setPrefsName(getPackageName())
                .setUseDefaultSharedPreference(true)
                .build();
    }
}
