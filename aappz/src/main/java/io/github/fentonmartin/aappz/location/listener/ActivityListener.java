package io.github.fentonmartin.aappz.location.listener;

import android.content.Context;

import com.google.android.gms.location.DetectedActivity;

import io.github.fentonmartin.aappz.location.util.ActivityParams;
import io.github.fentonmartin.aappz.LogZ;

public interface ActivityListener {

    void init(Context context, LogZ.Logger logger);

    void start(OnActivityUpdatedListener listener, ActivityParams params);

    void stop();

    DetectedActivity getLastActivity();
}
